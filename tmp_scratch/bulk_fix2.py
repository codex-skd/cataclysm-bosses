#!/usr/bin/env python3
"""
Bulk API migration fix script #2 for NeoForge 26.2.0.57
Handles remaining compilation errors after bulk_fix.py was applied.
"""

import os
import re
import sys
from pathlib import Path

SRC_DIR = Path("src/main/java")


def apply_fixes(content, filepath):
    """Apply all API migration fixes to a file's content. Returns (new_content, changes_list)."""
    changes = []

    # ================================================================
    # FIX 1: Remove (Object) casts in .define() calls
    # Pattern: .define(X, (Object)value) -> .define(X, value)
    # ================================================================
    # Handle various value types after (Object) cast:
    # (Object)false, (Object)true, (Object)0, (Object)-1, (Object)Float.valueOf(x), etc.
    pattern_define_obj = re.compile(
        r'\.define\(([^,]+),\s*\(Object\)\s*'
    )
    if pattern_define_obj.search(content):
        count = len(pattern_define_obj.findall(content))
        content = pattern_define_obj.sub(r'.define(\1, ', content)
        changes.append("Removed (Object) casts in .define() calls (%dx)" % count)

    # ================================================================
    # FIX 2: Remove (Object) casts in .set() calls on entityData/getEntityData
    # Pattern: .set(X, (Object)value) -> .set(X, value)
    # ================================================================
    pattern_entitydata_set_obj = re.compile(
        r'((?:entityData|getEntityData\(\))\.set\([^,]+,\s*)\(Object\)\s*'
    )
    if pattern_entitydata_set_obj.search(content):
        count = len(pattern_entitydata_set_obj.findall(content))
        content = pattern_entitydata_set_obj.sub(r'\1', content)
        changes.append("Removed (Object) casts in entityData.set() calls (%dx)" % count)

    # ================================================================
    # FIX 2b: Remove (Object) casts in ItemStack/DataComponent .set() calls
    # Pattern: .set(DataComponents.X, (Object)value) -> .set(DataComponents.X, value)
    # Also: .set(ModDataComponents.X, (Object)value) -> .set(ModDataComponents.X, value)
    # ================================================================
    pattern_component_set_obj = re.compile(
        r'(\.set\((?:DataComponents|ModDataComponents)\.[^,]+,\s*)\(Object\)\s*'
    )
    if pattern_component_set_obj.search(content):
        count = len(pattern_component_set_obj.findall(content))
        content = pattern_component_set_obj.sub(r'\1', content)
        changes.append("Removed (Object) casts in component .set() calls (%dx)" % count)

    # ================================================================
    # FIX 2c: Remove (Object) casts in List.set() calls (e.g., this.items.set, this.getItems().set)
    # Pattern: this.items.set(index, (Object)value) -> this.items.set(index, value)
    # Pattern: this.getItems().set(index, (Object)value) -> this.getItems().set(index, value)
    # ================================================================
    pattern_list_set_obj = re.compile(
        r'(\.set\([^,]+,\s*)\(Object\)\s*'
    )
    if pattern_list_set_obj.search(content):
        count = len(pattern_list_set_obj.findall(content))
        content = pattern_list_set_obj.sub(r'\1', content)
        changes.append("Removed (Object) casts in .set() calls (%dx)" % count)

    # ================================================================
    # FIX 3: entity.hurt() -> entity.hurtOrSimulate() when used as boolean
    # This is complex: only replace when result is used as boolean
    # Cases:
    #   - boolean x = entity.hurt(...) -> boolean x = entity.hurtOrSimulate(...)
    #   - if (entity.hurt(...)) -> if (entity.hurtOrSimulate(...))
    #   - return entity.hurt(...) -> return entity.hurtOrSimulate(...)  (if method returns boolean)
    #   - flag = entity.hurt(...) -> flag = entity.hurtOrSimulate(...)
    #   - !(flag = entity.hurt(...)) -> !(flag = entity.hurtOrSimulate(...))
    #
    # But leave standalone calls alone (those where return value is ignored)
    # Actually, since hurt() is final+void and hurtOrSimulate() is the boolean one,
    # we should replace ALL calls to .hurt() with .hurtOrSimulate() since the mod
    # code always expects a boolean return from hurt.
    # ================================================================
    # Replace .hurt( with .hurtOrSimulate( globally - all usages expect boolean return
    # But be careful not to replace in method declarations like "public boolean hurt("
    # or in override annotations.
    #
    # Strategy: Replace all calls EXCEPT method declarations
    # ================================================================

    # First, replace .hurt( calls (i.e., invocations on objects)
    # This matches: something.hurt( but NOT "void hurt(" or "boolean hurt(" etc.
    pattern_hurt_call = re.compile(
        r'(\.)hurt\('
    )
    # Check if there are any .hurt( calls that need replacement
    if pattern_hurt_call.search(content):
        # Count occurrences but don't replace method declarations
        count = len(pattern_hurt_call.findall(content))
        content = pattern_hurt_call.sub(r'\1hurtOrSimulate(', content)
        changes.append("Replaced .hurt() -> .hurtOrSimulate() (%dx)" % count)

    # Also handle super.hurt( calls
    pattern_super_hurt = re.compile(
        r'super\.hurt\('
    )
    if pattern_super_hurt.search(content):
        count = len(pattern_super_hurt.findall(content))
        content = pattern_super_hurt.sub('super.hurtOrSimulate(', content)
        changes.append("Replaced super.hurt() -> super.hurtOrSimulate() (%dx)" % count)

    # ================================================================
    # FIX 4: renderToBuffer needs extra int color parameter
    # Pattern: .renderToBuffer(pose, consumer, light, overlay)
    #       -> .renderToBuffer(pose, consumer, light, overlay, -1)
    # ================================================================
    # Match calls with exactly 4 args (the old signature)
    # We need to be careful: some files already have 5 args (the override)
    # We can't use regex for nested parens, so we use the paren-counting approach directly
    if '.renderToBuffer(' in content:
        count = 0
        result = content
        # Find all .renderToBuffer( calls
        idx = 0
        new_content = []
        while True:
            match = result.find('.renderToBuffer(', idx)
            if match == -1:
                new_content.append(result[idx:])
                break
            new_content.append(result[idx:match])
            # Find the opening paren
            paren_start = match + len('.renderToBuffer')
            # Count parens to find matching close
            depth = 1
            i = paren_start + 1
            while i < len(result) and depth > 0:
                if result[i] == '(':
                    depth += 1
                elif result[i] == ')':
                    depth -= 1
                i += 1
            # Now we have the content between parens
            inner = result[paren_start + 1:i - 1]
            # Count top-level commas
            comma_count = 0
            d = 0
            for c in inner:
                if c == '(':
                    d += 1
                elif c == ')':
                    d -= 1
                elif c == ',' and d == 0:
                    comma_count += 1
            if comma_count == 3:
                # 4 args - need to add 5th
                new_content.append('.renderToBuffer(' + inner + ', -1)')
                count += 1
            else:
                # Already has correct number of args or something else
                new_content.append('.renderToBuffer(' + inner + ')')
            idx = i
        content = ''.join(new_content)
        if count > 0:
            changes.append("Added color param to renderToBuffer() (%dx)" % count)

    # ================================================================
    # FIX 5: ModelPart.children is private
    # Pattern: part.children.entrySet() -> need reflection or helper
    # Since children is a Map<String, ModelPart>, we can use getAllParts()
    # or access via a helper. The safest mechanical fix is to use reflection.
    # Actually, looking at the code pattern, it iterates children to build a cache.
    # We can replace: part.children.entrySet() with a helper method call.
    #
    # The pattern is always the same across all model files:
    #   for (Map.Entry entry : part.children.entrySet()) {
    #       String partName = (String)entry.getKey();
    #       ModelPart childPart = (ModelPart)entry.getValue();
    #       this.partCache.putIfAbsent(partName, childPart);
    #   }
    #   if (childPart.children.isEmpty()) continue;
    #
    # Since all these files follow the exact same pattern, we'll add a static
    # helper method and use it.
    # ================================================================
    # For now, replace .children. with method calls via a helper
    # Actually, the safest approach: replace part.children.entrySet() with
    # getting children via ModelPart's getAllParts() and building our own map.
    # But that changes semantics. Let's use a simpler approach:
    # Add a static helper method at the top of each file.

    # Pattern 1: part.children.entrySet() -> need to iterate
    # The children field is private but we can use getChild(String) if we know names
    # OR we can use getAllParts() which returns a flat list of all parts
    #
    # Simplest mechanical fix: replace the pattern with a helper that uses getAllParts()
    # Actually, let me check: getAllParts() returns List<ModelPart>, not a map.
    #
    # Best approach: replace the loop pattern entirely with a recursive helper
    # But that's too complex for a regex. Let's just use the fact that
    # the only usage is building a partCache.

    # Actually the simplest: since all 20+ model files have the EXACT same pattern,
    # we can replace the 5-line loop with a call to a utility method.
    pattern_children_loop = re.compile(
        r'(\s*)for \(Map\.Entry\s+entry\s*:\s*part\.children\.entrySet\(\)\)\s*\{\s*\n'
        r'\s*String partName\s*=\s*\(String\)entry\.getKey\(\);\s*\n'
        r'\s*ModelPart childPart\s*=\s*\(ModelPart\)entry\.getValue\(\);\s*\n'
        r'\s*this\.partCache\.putIfAbsent\(partName,\s*childPart\);\s*\n'
        r'\s*\}',
        re.MULTILINE
    )
    if pattern_children_loop.search(content):
        count = len(pattern_children_loop.findall(content))
        # Replace with a helper that uses getAllParts + getChild
        # Actually, let's replace with reflection-based access
        replacement = (
            r'\1for (Map.Entry<String, ModelPart> entry : getChildrenMap(part).entrySet()) {\n'
            r'\1    String partName = entry.getKey();\n'
            r'\1    ModelPart childPart = entry.getValue();\n'
            r'\1    this.partCache.putIfAbsent(partName, childPart);\n'
            r'\1}'
        )
        content = pattern_children_loop.sub(replacement, content)
        if count > 0:
            changes.append("Replaced children.entrySet() loop with getChildrenMap() helper (%dx)" % count)
            # Add the helper method if not already present
            if 'getChildrenMap' not in content or 'private static Map<String, ModelPart> getChildrenMap' not in content:
                # Find the last closing brace of the class and insert before it
                # Add import for the helper
                helper_method = '''
    @SuppressWarnings("unchecked")
    private static Map<String, ModelPart> getChildrenMap(ModelPart part) {
        try {
            java.lang.reflect.Field f = ModelPart.class.getDeclaredField("children");
            f.setAccessible(true);
            return (Map<String, ModelPart>) f.get(part);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
'''
                # Find the class body end
                last_brace = content.rfind('}')
                if last_brace != -1:
                    content = content[:last_brace] + helper_method + content[last_brace:]
                    changes.append("Added getChildrenMap() reflection helper method")

    # Pattern 2: childPart.children.isEmpty() -> use reflection
    pattern_children_isempty = re.compile(
        r'childPart\.children\.isEmpty\(\)'
    )
    if pattern_children_isempty.search(content):
        count = len(pattern_children_isempty.findall(content))
        content = pattern_children_isempty.sub(
            'getChildrenMap(childPart).isEmpty()', content)
        changes.append("Replaced childPart.children.isEmpty() with getChildrenMap() (%dx)" % count)
        # Make sure helper exists
        if 'private static Map<String, ModelPart> getChildrenMap' not in content:
            helper_method = '''
    @SuppressWarnings("unchecked")
    private static Map<String, ModelPart> getChildrenMap(ModelPart part) {
        try {
            java.lang.reflect.Field f = ModelPart.class.getDeclaredField("children");
            f.setAccessible(true);
            return (Map<String, ModelPart>) f.get(part);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
'''
            last_brace = content.rfind('}')
            if last_brace != -1:
                content = content[:last_brace] + helper_method + content[last_brace:]
                changes.append("Added getChildrenMap() reflection helper method")

    # ================================================================
    # FIX 6: EntityRenderer<T> now requires 2 type params
    # Pattern: extends EntityRenderer<SomeEntity> {
    #       -> extends EntityRenderer<SomeEntity, EntityRenderState> {
    # But actually we need to check what the actual render state types should be
    # For simplicity, use EntityRenderState as the second type param
    # ================================================================
    pattern_entityrenderer_1arg = re.compile(
        r'extends EntityRenderer<(\w+)> \{'
    )
    if pattern_entityrenderer_1arg.search(content):
        count = len(pattern_entityrenderer_1arg.findall(content))
        content = pattern_entityrenderer_1arg.sub(
            r'extends EntityRenderer<\1, EntityRenderState> {', content)
        if count > 0:
            changes.append("Added 2nd type param to EntityRenderer (%dx)" % count)
            # Add EntityRenderState import if needed
            if 'import net.minecraft.client.renderer.entity.state.EntityRenderState;' not in content:
                last_import = None
                for m in re.finditer(r'^import [^;]+;$', content, re.MULTILINE):
                    last_import = m
                if last_import:
                    pos = last_import.end()
                    content = (content[:pos] +
                               "\nimport net.minecraft.client.renderer.entity.state.EntityRenderState;" +
                               content[pos:])
                    changes.append("Added import: EntityRenderState")

    # ================================================================
    # FIX 7: level.random -> level.getRandom() (protected access fix)
    # Level.random is protected, must use getRandom()
    # ================================================================
    # Pattern: level.random -> level.getRandom() (various forms: this.level.random, level.random)
    pattern_level_random = re.compile(
        r'(\w+(?:\.\w+)*)\.random\b'
    )
    # But we need to be careful: this.random in Particle/Entity contexts is fine (it's a field)
    # Only Level's random is protected. So only replace level.random patterns.
    # The key distinction: Level.random is protected but getRandom() is public.
    # Entity.random is protected too but getRandom() works.
    # Actually, for safety, replace ALL .random with .getRandom() when followed by method call
    # but NOT when it's "this.random" in a class that HAS a random field (Particle, Entity)
    #
    # Safer approach: only replace explicit level.random patterns
    for level_pattern in [
        'this.level.random',
        'level.random',
    ]:
        if level_pattern in content:
            # Count occurrences of this specific pattern followed by . (method call)
            count = content.count(level_pattern + '.')
            if count > 0:
                content = content.replace(level_pattern + '.', level_pattern.replace('.random', '.getRandom()') + '.')
                changes.append("Replaced %s -> %s (%dx)" % (
                    level_pattern, level_pattern.replace('.random', '.getRandom()'), count))

    # Also fix: this.random in ContextEvent (GuiComponent subclass)
    # Actually, the ClientEvent extends GuiComponent which has its own random
    # In GuiComponent/HudRenderCallback, this.random should be fine.
    # Skip this.random in entity/particle classes.

    # ================================================================
    # FIX 8: SpawnEggItem constructor changed
    # Old: new SpawnEggItem(EntityType, int, int, Item.Properties)
    # New: new SpawnEggItem(Item.Properties)
    # ================================================================
    pattern_spawnegg = re.compile(
        r'new SpawnEggItem\([^,]+,\s*\d+[^)]*,\s*\d+[^)]*,\s*(new Item\.Properties\([^)]*\))\)'
    )
    if pattern_spawnegg.search(content):
        count = len(pattern_spawnegg.findall(content))
        content = pattern_spawnegg.sub(r'new SpawnEggItem(\1)', content)
        if count > 0:
            changes.append("Fixed SpawnEggItem constructor (%dx)" % count)

    # Also handle hex values in SpawnEggItem constructor
    pattern_spawnegg_hex = re.compile(
        r'new SpawnEggItem\([^,]+,\s*0x[0-9A-Fa-f]+,\s*0x[0-9A-Fa-f]+,\s*(new Item\.Properties\([^)]*\))\)'
    )
    if pattern_spawnegg_hex.search(content):
        count = len(pattern_spawnegg_hex.findall(content))
        content = pattern_spawnegg_hex.sub(r'new SpawnEggItem(\1)', content)
        if count > 0:
            changes.append("Fixed SpawnEggItem constructor (hex args) (%dx)" % count)

    # ================================================================
    # FIX 9: getCooldowns().addCooldown((Item)this, ...) -> addCooldown(this.getDefaultInstance(), ...)
    # getCooldowns().addCooldown((Item)ModItems.X.get(), ...)
    # New API: addCooldown(ItemStack, int)
    # ================================================================
    # Pattern: .addCooldown((Item)expr, ticks)
    pattern_cooldown_add_item = re.compile(
        r'\.addCooldown\(\(Item\)([^,]+),\s*'
    )
    if pattern_cooldown_add_item.search(content):
        count = len(pattern_cooldown_add_item.findall(content))
        # Replace (Item)this with this.getDefaultInstance()
        # and (Item)ModItems.X.get() with ModItems.X.get().getDefaultInstance()
        content = pattern_cooldown_add_item.sub(
            r'.addCooldown(\1.getDefaultInstance(), ', content)
        if count > 0:
            changes.append("Fixed addCooldown (Item) cast -> getDefaultInstance() (%dx)" % count)

    # ================================================================
    # FIX 9b: getCooldowns().isOnCooldown((Item)expr)
    # New API: isOnCooldown(ItemStack)
    # ================================================================
    pattern_cooldown_ison_item = re.compile(
        r'\.isOnCooldown\(\(Item\)([^)]+)\)'
    )
    if pattern_cooldown_ison_item.search(content):
        count = len(pattern_cooldown_ison_item.findall(content))
        content = pattern_cooldown_ison_item.sub(
            r'.isOnCooldown(\1.getDefaultInstance())', content)
        if count > 0:
            changes.append("Fixed isOnCooldown (Item) cast -> getDefaultInstance() (%dx)" % count)

    # ================================================================
    # FIX 10: RegisterRenderers.registerEntityRenderer signature change
    # The method may need EntityRendererProvider not a constructor ref
    # This is a complex fix, skip for now - leave for manual intervention
    # ================================================================

    # ================================================================
    # FIX 11: Import cleanup - remove unused ArmorItem imports where possible
    # ================================================================
    # Check if ArmorItem is actually used beyond imports
    if 'import net.minecraft.world.item.ArmorItem;' in content:
        # Check if ArmorItem is used in the code (not just import)
        content_without_import = content.replace('import net.minecraft.world.item.ArmorItem;', '')
        if re.search(r'\bArmorItem\b', content_without_import):
            pass  # ArmorItem is actually used, keep import
        else:
            content = content.replace('import net.minecraft.world.item.ArmorItem;\n', '')
            changes.append("Removed unused ArmorItem import")

    return content, changes


def main():
    dry_run = "--dry-run" in sys.argv

    if not SRC_DIR.exists():
        print("ERROR: Source directory not found: %s" % SRC_DIR)
        print("Run this script from the project root.")
        sys.exit(1)

    java_files = sorted(SRC_DIR.rglob("*.java"))
    print("Found %d Java files to process" % len(java_files))
    if dry_run:
        print("DRY RUN - no files will be modified\n")

    total_files_changed = 0
    total_changes = 0
    all_changed_files = []

    for filepath in java_files:
        with open(filepath, "r", encoding="utf-8") as f:
            content = f.read()

        new_content, file_changes = apply_fixes(content, filepath)

        if file_changes:
            rel_path = filepath.relative_to(SRC_DIR.parent.parent)
            print("")
            print("=" * 70)
            print("Modified: %s" % rel_path)
            for ch in file_changes:
                print("  [FIX] %s" % ch.encode('ascii', 'replace').decode())

            if not dry_run:
                with open(filepath, "w", encoding="utf-8") as f:
                    f.write(new_content)

            total_files_changed += 1
            total_changes += len(file_changes)
            all_changed_files.append((rel_path, file_changes))

    # --- Summary ---
    print("")
    print("=" * 70)
    print("SUMMARY")
    print("=" * 70)
    print("  Files scanned:     %d" % len(java_files))
    print("  Files modified:    %d" % total_files_changed)
    print("  Total changes:     %d" % total_changes)
    print()
    if dry_run:
        print("  (DRY RUN - no files were modified)")
    else:
        print("  REMAINING MANUAL FIXES NEEDED:")
        print("  - ArmorItem removed (now Equippable data component)")
        print("  - RegisterRenderers.registerEntityRenderer signature")
        print("  - RenderStateShard removed (CMRenderTypes.java)")
        print("  - Level->ServerLevel casts where needed")
        print("  - create(Level) for particles")
        print("  - spawnAtLocation signature changes")
        print("  - Optional<Double> -> double conversions")
        print("  - @Override on methods that changed signatures")
        print("  - String->ResourceKey conversions")
    print()


if __name__ == "__main__":
    main()
