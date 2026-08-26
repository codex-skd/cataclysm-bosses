#!/usr/bin/env python3
"""Convert Item.use() InteractionResultHolder<ItemStack> -> InteractionResult.
Line-based, safe (cannot overrun a statement). Only consume/success/pass/fail.
sidedSuccess is left for manual handling (3 files)."""
import re
from pathlib import Path

ROOT = Path("src/main/java/com/skd/cataclysmbosses/items")

def close_paren(line, open_idx):
    depth = 0
    for i in range(open_idx, len(line)):
        if line[i] == '(':
            depth += 1
        elif line[i] == ')':
            depth -= 1
            if depth == 0:
                return i
    return -1

def transform_line(line):
    out, i = [], 0
    while i < len(line):
        m = re.search(r"InteractionResultHolder\.(consume|success|pass|fail)\s*\(", line[i:])
        if not m:
            out.append(line[i:])
            break
        start = i + m.start()
        out.append(line[i:start])
        open_ = i + m.end() - 1
        close = close_paren(line, open_)
        if close < 0:
            out.append(line[start:])
            break
        METHOD = m.group(1).upper()
        out.append(f"InteractionResult.{METHOD}")
        i = close + 1
    return "".join(out)

changed = 0
for path in sorted(ROOT.rglob("*.java")):
    text = path.read_text(encoding="utf-8")
    orig = text
    text = text.replace("import net.minecraft.world.InteractionResultHolder;",
                        "import net.minecraft.world.InteractionResult;")
    text = text.replace("InteractionResultHolder<ItemStack>", "InteractionResult")
    new_lines = [transform_line(ln) for ln in text.split("\n")]
    text = "\n".join(new_lines)
    if text != orig:
        path.write_text(text, encoding="utf-8")
        changed += 1
print("changed files:", changed)
