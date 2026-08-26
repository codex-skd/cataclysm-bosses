#!/usr/bin/env python3
"""Safe, verified mechanical API renames for NeoForge 26.2.0.45-beta -> 26.2.0.57.
Only applies renames verified against the authoritative MC source (tmp_scratch/mc_src)."""
import os, re, sys
from pathlib import Path

SRC = Path("src/main/java")
files = list(SRC.rglob("*.java"))
changed = 0

# (old_import, new_import)
IMPORT_FIXES = [
    ("import net.minecraft.Util;", "import net.minecraft.util.Util;"),
    ("import net.minecraft.client.model.SkullModelBase;", "import net.minecraft.client.model.object.skull.SkullModelBase;"),
    ("import net.minecraft.client.model.PlayerModel;", "import net.minecraft.client.model.player.PlayerModel;"),
    ("import net.minecraft.world.entity.animal.IronGolem;", "import net.minecraft.world.entity.animal.golem.IronGolem;"),
    ("import net.minecraft.world.entity.SpawnReason;", "import net.minecraft.world.entity.EntitySpawnReason;"),
    ("import net.minecraft.world.entity.MobSpawnType;", "import net.minecraft.world.entity.EntitySpawnReason;"),
]

# word-boundary renames: (pattern, replacement)
WORD_RENAMES = [
    (re.compile(r"\bDripstoneThickness\b"), "SpeleothemThickness"),
    (re.compile(r"\bBlockStateProperties\.DRIPSTONE_THICKNESS\b"), "BlockStateProperties.SPELEOTHEM_THICKNESS"),
    (re.compile(r"\bMobSpawnType\.SPAWN_EGG\b"), "EntitySpawnReason.SPAWN_ITEM_USE"),
    (re.compile(r"\bMobSpawnType\b"), "EntitySpawnReason"),
    (re.compile(r"\bSpawnReason\b"), "EntitySpawnReason"),
]

for path in files:
    try:
        text = path.read_text(encoding="utf-8")
    except UnicodeDecodeError:
        continue
    orig = text
    for old_imp, new_imp in IMPORT_FIXES:
        if old_imp in text:
            text = text.replace(old_imp, new_imp)
    for pat, rep in WORD_RENAMES:
        text = pat.sub(rep, text)
    if text != orig:
        path.write_text(text, encoding="utf-8")
        changed += 1

print("changed files:", changed)
