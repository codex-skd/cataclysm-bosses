#!/usr/bin/env python3
"""
Bulk API migration fix script for NeoForge 26.2.0.45-beta to 26.2.0.57
Applies confirmed API changes across all Java source files.
"""

import os
import re
import sys
from pathlib import Path

SRC_DIR = Path("src/main/java")


def apply_fixes(content, filepath):
    """Apply all API migration fixes to a file's content. Returns (new_content, changes_list)."""
    changes = []

    # --- Import changes ---

    # Change 14: SkullModelBase import path
    old_import = "import net.minecraft.client.model.SkullModelBase;"
    new_import = "import net.minecraft.client.model.object.skull.SkullModelBase;"
    if old_import in content and new_import not in content:
        content = content.replace(old_import, new_import)
        changes.append("Import: SkullModelBase path updated")

    # Change 19: RenderType import path (net.minecraft.client.renderer -> rendertype)
    new_rt_import = "import net.minecraft.client.renderer.rendertype.RenderType;"
    old_rt_import = "import net.minecraft.client.renderer.RenderType;"
    if old_rt_import in content:
        if new_rt_import not in content:
            content = content.replace(old_rt_import, new_rt_import)
            changes.append("Import: RenderType path updated to rendertype package")
        else:
            # New import already exists, remove the old one to avoid duplicate
            content = content.replace(old_rt_import + "\n", "")

    # Change 23: FastColor -> ARGB import
    new_argb_import = "import net.minecraft.util.ARGB;"
    old_fc_import = "import net.minecraft.util.FastColor;"
    if old_fc_import in content and new_argb_import not in content:
        content = content.replace(old_fc_import, new_argb_import)
        changes.append("Import: FastColor -> ARGB")

    # --- Code changes ---

    # Change 23: FastColor.ARGB32.* -> ARGB.* (code references)
    # Order matters: colorFromFloat before color to avoid partial matches
    for old_pat, new_pat in [
        ("FastColor.ARGB32.colorFromFloat(", "ARGB.colorFromFloat("),
        ("FastColor.ARGB32.color(", "ARGB.color("),
        ("FastColor.ARGB32.COLOR_DEPTH_WRITE", "ARGB.COLOR_DEPTH_WRITE"),
        ("FastColor.ARGB32.COLOR_WRITE", "ARGB.COLOR_WRITE"),
    ]:
        if old_pat in content:
            count = content.count(old_pat)
            content = content.replace(old_pat, new_pat)
            changes.append("Code: %s -> %s (%dx)" % (old_pat, new_pat, count))

    # Change 24: this.moveTo( -> this.setPos(
    if "this.moveTo(" in content:
        count = content.count("this.moveTo(")
        content = content.replace("this.moveTo(", "this.setPos(")
        changes.append("Code: this.moveTo() -> this.setPos() (%dx)" % count)

    # Change 25: this.noCulling = true; -> this.noCulling(true);
    pattern_noculling = re.compile(r"this\.noCulling\s*=\s*true;")
    if pattern_noculling.search(content):
        count = len(pattern_noculling.findall(content))
        content = pattern_noculling.sub("this.noCulling(true);", content)
        changes.append("Code: this.noCulling = true -> this.noCulling(true) (%dx)" % count)

    # Changes 26-27: entity.random -> entity.getRandom()
    for old_pat, new_pat in [
        ("this.entity.random", "this.entity.getRandom()"),
    ]:
        if old_pat in content:
            count = content.count(old_pat)
            content = content.replace(old_pat, new_pat)
            changes.append("Code: %s -> %s (%dx)" % (old_pat, new_pat, count))

    # Also handle X_Entity.this.random patterns (outer class reference in inner class)
    pattern_outer_random = re.compile(r"(\w+(?:_\w+)*)\.this\.random\b")
    matches = pattern_outer_random.findall(content)
    if matches:
        for cls_name in set(matches):
            old = "%s.this.random" % cls_name
            new = "%s.this.getRandom()" % cls_name
            if old in content:
                count = content.count(old)
                content = content.replace(old, new)
                changes.append("Code: %s -> %s (%dx)" % (old, new, count))

    # Changes 28-33: compound.getXxx() -> compound.getXxxOr() with defaults
    # Apply to files with readAdditionalSaveData (Entity and BlockEntity)
    if "readAdditionalSaveData" in content:
        get_or_defaults = [
            ("getFloat", "0.0f"),
            ("getInt", "0"),
            ("getDouble", "0.0"),
            ("getBoolean", "false"),
            ("getLong", "0L"),
            ("getString", '""'),
        ]
        for var_name in ["compound", "tag"]:
            for getter, default_val in get_or_defaults:
                pattern = re.compile(
                    r"%s\.%s\(\"([^\"]+)\"\)" % (re.escape(var_name), re.escape(getter))
                )
                if pattern.search(content):
                    replacement = r'%s.%sOr("\1", %s)' % (var_name, getter, default_val)
                    new_content = pattern.sub(replacement, content)
                    if new_content != content:
                        count = len(pattern.findall(content))
                        content = new_content
                        changes.append(
                            "Code: %s.%s() -> %s.%sOr() (%dx)" % (var_name, getter, var_name, getter, count)
                        )

    # Changes 34-35: Method signature changes (CompoundTag -> ValueInput/ValueOutput)
    pattern_add = re.compile(
        r"(?:public|protected)\s+void\s+addAdditionalSaveData\(CompoundTag\s+(\w+)\)"
    )
    match_add = pattern_add.search(content)
    if match_add:
        param_name = match_add.group(1)
        old_sig = "addAdditionalSaveData(CompoundTag %s)" % param_name
        new_sig = "addAdditionalSaveData(ValueOutput %s)" % param_name
        content = content.replace(old_sig, new_sig, 1)
        changes.append("Signature: addAdditionalSaveData CompoundTag -> ValueOutput")

    pattern_read = re.compile(
        r"(?:public|protected)\s+void\s+readAdditionalSaveData\(CompoundTag\s+(\w+)\)"
    )
    match_read = pattern_read.search(content)
    if match_read:
        param_name = match_read.group(1)
        old_sig = "readAdditionalSaveData(CompoundTag %s)" % param_name
        new_sig = "readAdditionalSaveData(ValueInput %s)" % param_name
        content = content.replace(old_sig, new_sig, 1)
        changes.append("Signature: readAdditionalSaveData CompoundTag -> ValueInput")

    # Change 36: Remove (Object) casts in SynchedEntityData .set() calls
    pattern_obj_set = re.compile(
        r"(entityData|getEntityData\(\))\.set\(([^,]+),\s*\(Object\)"
    )
    if pattern_obj_set.search(content):
        count = len(pattern_obj_set.findall(content))
        content = pattern_obj_set.sub(r"\1.set(\2, ", content)
        changes.append("Code: Removed (Object) casts in entityData.set() (%dx)" % count)

    # Changes 37-42: RenderType.xxx() -> RenderTypes.xxx()
    render_type_methods = [
        "entityTranslucentEmissive",
        "entityTranslucent",
        "entityCutoutNoCull",
        "entityCutout",
        "armorCutoutNoCull",
        "entitySolid",
    ]
    for method in render_type_methods:
        old_call = "RenderType.%s(" % method
        new_call = "RenderTypes.%s(" % method
        if old_call in content:
            count = content.count(old_call)
            content = content.replace(old_call, new_call)
            changes.append("Code: RenderType.%s() -> RenderTypes.%s() (%dx)" % (method, method, count))

    # --- Import additions for newly used classes ---

    # Add RenderTypes import if now used (check for standalone RenderTypes., not CMRenderTypes.)
    if re.search(r'(?<![A-Za-z])RenderTypes\.', content):
        rt_import = "import net.minecraft.client.renderer.rendertype.RenderType;"
        rt_types_import = "import net.minecraft.client.renderer.rendertype.RenderTypes;"
        if rt_types_import not in content:
            if rt_import in content:
                content = content.replace(
                    rt_import,
                    rt_import + "\n" + rt_types_import,
                    1,
                )
                changes.append("Added import: RenderTypes")
            else:
                # Fallback: add after last import line
                last_import = None
                for m in re.finditer(r"^import [^;]+;$", content, re.MULTILINE):
                    last_import = m
                if last_import:
                    pos = last_import.end()
                    content = (
                        content[:pos]
                        + "\n" + rt_types_import
                        + content[pos:]
                    )
                    changes.append("Added import: RenderTypes (fallback)")

    # Add ValueInput import if now used
    if "ValueInput " in content:
        vi_import = "import net.minecraft.nbt.ValueInput;"
        if vi_import not in content:
            last_import = None
            for m in re.finditer(r"^import [^;]+;$", content, re.MULTILINE):
                last_import = m
            if last_import:
                pos = last_import.end()
                content = content[:pos] + "\n" + vi_import + content[pos:]
                changes.append("Added import: ValueInput (verify package path)")

    # Add ValueOutput import if now used
    if "ValueOutput " in content:
        vo_import = "import net.minecraft.nbt.ValueOutput;"
        if vo_import not in content:
            last_import = None
            for m in re.finditer(r"^import [^;]+;$", content, re.MULTILINE):
                last_import = m
            if last_import:
                pos = last_import.end()
                content = content[:pos] + "\n" + vo_import + content[pos:]
                changes.append("Added import: ValueOutput (verify package path)")

    # Add ARGB import if code uses ARGB. but import wasn't from FastColor conversion
    if "ARGB." in content and "import net.minecraft.util.ARGB;" not in content:
        last_import = None
        for m in re.finditer(r"^import [^;]+;$", content, re.MULTILINE):
            last_import = m
        if last_import:
            pos = last_import.end()
            content = content[:pos] + "\nimport net.minecraft.util.ARGB;" + content[pos:]
            changes.append("Added import: ARGB")

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
                print("  [FIX] %s" % ch)

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
        print("  - MultiBufferSource -> SubmitNodeCollector (parameter types only)")
        print("  - HierarchicalModel removed (no replacement)")
        print("  - RenderStateShard removed (check CMRenderTypes.java)")
        print("  - ItemProperties removed (rewrite item property registration)")
        print("  - ArmorItem removed (now Equippable data component)")
        print("  - HumanoidArmorModel new location (verify)")
        print("  - TextureSheetParticle -> SingleQuadParticle")
        print("  - Verify ValueInput/ValueOutput import package paths")
    print()


if __name__ == "__main__":
    main()
