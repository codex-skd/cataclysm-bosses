#!/usr/bin/env python3
"""Migrate single-arg EntityType.create(<Level>) -> create(<Level>, EntitySpawnReason.X)
for the NeoForge 26.2.0.57 API delta.
Adds the EntitySpawnReason import if missing.

Reason mapping:
  - structures/*.java : STRUCTURE
  - everything else     : EVENT
"""
import re, sys, os

REASON = "net.minecraft.world.entity.EntitySpawnReason"

# per file
rules = {
    r"blockentities\\AltarOfAbyss_Block_Entity.java": "EVENT",
    r"blockentities\\AltarOfFire_Block_Entity.java": "EVENT",
    r"blockentities\\AltarOfVoid_Block_Entity.java": "EVENT",
    r"blockentities\\Boss_Respawn_Spawner_Block_Entity.java": "EVENT",
    r"blockentities\\Cursed_tombstone_Entity.java": "EVENT",
    r"blocks\\Abyssal_Egg_Block.java": "EVENT",
    r"blocks\\PurpurVoidRuneTrapBlock.java": "EVENT",
    r"entity\\AnimationMonster\\BossMonsters\\The_Leviathan\\Abyss_Portal_Entity.java": "EVENT",
    r"entity\\AnimationMonster\\BossMonsters\\The_Leviathan\\The_Leviathan_Entity.java": "EVENT",
    r"entity\\Deepling\\Deepling_Angler_Entity.java": "EVENT",
    r"entity\\projectile\\Tidal_Tentacle_Entity.java": "EVENT",
    r"items\\Netherite_Effigy.java": "EVENT",
    r"items\\Remnant_Skull.java": "EVENT",
    r"items\\Tidal_Claws.java": "EVENT",
    r"structures\\Burning_Arena_Structure.java": "STRUCTURE",
    r"structures\\Cursed_Pyramid_Structure.java": "STRUCTURE",
    r"structures\\RuinedCitadelStructure.java": "STRUCTURE",
    r"structures\\Sunken_City_Structure.java": "STRUCTURE",
}

def fix(path, reason):
    with open(path, encoding="utf-8", errors="replace") as f:
        src = f.read()
    orig = src
    # ensure import
    if REASON not in src:
        # add after the last net.minecraft import block; simple: insert before first net.neoforged import or after package
        lines = src.split("\n")
        insert = None
        for i, ln in enumerate(lines):
            if ln.startswith("import net.neoforged.") or ln.startswith("import com.skd."):
                insert = i
                break
        if insert is None:
            # find last import line
            idxs = [i for i, ln in enumerate(lines) if ln.startswith("import ")]
            insert = idxs[-1] + 1 if idxs else None
        if insert is None:
            # after package line
            for i, ln in enumerate(lines):
                if ln.startswith("package "):
                    insert = i + 1
                    break
        imp = "import net.minecraft.world.entity.EntitySpawnReason;"
        lines.insert(insert, imp)
        src = "\n".join(lines)

    # Now transform .create(<arg>) single arg where arg is a Level-typed var. We transform patterns:
    #   <...>.create(<expr>)   ->  <...>.create(<expr>, EntitySpawnReason.<reason>)
    # Only when the expr doesn't already contain a comma at top-level and isn't a 2-arg call.
    # We match .create( ... ) capturing balanced.
    # To keep it simple and safe, we match known forms: variable name, this.var(), (Level)expr, cast expr.
    # Pattern: .create( <content> ) where content has no top-level comma or nested parens ambiguity.

    def repl(m):
        span = m.group(0)
        inner = m.group(1)
        # skip if already two-arg
        return span

    # Use a targeted regex for the specific known arg forms:
    # variable | this.foo() | (Level)expr
    pat = re.compile(r"\.create\((\s*\(Level\)[^)]*\)|this\.level\(\)|level\)|world\)|worldIn\)|p_\d+_[A-Za-z]+\)|serverLevel\)|levelIn\))")
    # We'll do explicit replacements instead.
    replacements = [
        (".create(level)", ".create(level, EntitySpawnReason.%s)" % reason),
        (".create(this.level())", ".create(this.level(), EntitySpawnReason.%s)" % reason),
        (".create(world)", ".create(world, EntitySpawnReason.%s)" % reason),
        (".create(worldIn)", ".create(worldIn, EntitySpawnReason.%s)" % reason),
        (".create(p_40622_)", ".create(p_40622_, EntitySpawnReason.%s)" % reason),
        (".create((Level)serverLevel)", ".create((Level)serverLevel, EntitySpawnReason.%s)" % reason),
        (".create((Level)p_277739_)", ".create((Level)p_277739_, EntitySpawnReason.%s)" % reason),
        (".create((Level)worldIn.getLevel())", ".create((Level)worldIn.getLevel(), EntitySpawnReason.%s)" % reason),
    ]
    changed = False
    for old, new in replacements:
        if old in src:
            src = src.replace(old, new)
            changed = True

    if changed and src != orig:
        with open(path, "w", encoding="utf-8", newline="") as f:
            f.write(src)
        return True
    return False

base = "src/main/java/com/skd/cataclysmbosses"
total = 0
for pat, reason in rules.items():
    # build path
    p = os.path.join(base, pat.replace("\\", os.sep))
    if os.path.exists(p):
        if fix(p, reason):
            print("fixed", pat, "->", reason)
            total += 1
        else:
            print("NOP  ", pat)
    else:
        print("MISS ", pat)
print("TOTAL:", total)
