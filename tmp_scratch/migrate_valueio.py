#!/usr/bin/env python3
"""Migrate ValueInput/ValueOutput entity & block-entity save/load bodies.

Scopes transforms to the ValueInput (read) / ValueOutput (write) method
parameter only, so CompoundTag/Tag usages elsewhere are left untouched.
"""
import re
from pathlib import Path

ROOT = Path("src/main/java")
UUID_IMPORT = "import net.minecraft.core.UUIDUtil;"

# receiver regex for method call on a given var
def recut(var, name):
    return re.compile(r"\b" + var + r"\.?" + re.escape(name) + r"\s*\(")

def transform_read(m, var, arg):
    # handle <var>.getUUID("X") / hasUUID("X")
    r = m.group(0)
    r = r.replace(f"{var}.hasUUID(", f"{var}.read(".replace("readx", "read"))
    return r

def apply_read(body, var):
    # hasUUID("X") -> read("X", UUIDUtil.CODEC).isPresent()
    body = re.sub(
        r"\b" + var + r"\.hasUUID\(\s*\"([^\"]+)\"\s*\)",
        lambda m_: f"{var}.read(\"{m_.group(1)}\", UUIDUtil.CODEC).isPresent()",
        body,
    )
    # getUUID("X") -> read("X", UUIDUtil.CODEC).orElse(null)
    body = re.sub(
        r"\b" + var + r"\.getUUID\(\s*\"([^\"]+)\"\s*\)",
        lambda m_: f"{var}.read(\"{m_.group(1)}\", UUIDUtil.CODEC).orElse(null)",
        body,
    )
    # getFloat("X") -> getFloatOr("X", 0.0F)
    body = re.sub(
        r"\b" + var + r"\.getFloat\(\s*\"([^\"]+)\"\s*\)",
        lambda m_: f"{var}.getFloatOr(\"{m_.group(1)}\", 0.0F)",
        body,
    )
    # getBoolean("X") -> getBooleanOr("X", false)
    body = re.sub(
        r"\b" + var + r"\.getBoolean\(\s*\"([^\"]+)\"\s*\)",
        lambda m_: f"{var}.getBooleanOr(\"{m_.group(1)}\", false)",
        body,
    )
    # getDouble("X") -> getDoubleOr("X", 0.0D)
    body = re.sub(
        r"\b" + var + r"\.getDouble\(\s*\"([^\"]+)\"\s*\)",
        lambda m_: f"{var}.getDoubleOr(\"{m_.group(1)}\", 0.0D)",
        body,
    )
    # getInt("X") used directly -> getIntOr("X", 0)  (only when not followed by .)
    body = re.sub(
        r"\b" + var + r"\.getInt\(\s*\"([^\"]+)\"\s*\)(?!\.)",
        lambda m_: f"{var}.getIntOr(\"{m_.group(1)}\", 0)",
        body,
    )
    # getString("X") used directly -> getStringOr("X", "")
    body = re.sub(
        r"\b" + var + r"\.getString\(\s*\"([^\"]+)\"\s*\)(?!\.)",
        lambda m_: f"{var}.getStringOr(\"{m_.group(1)}\", \"\")",
        body,
    )
    # getLong("X") used directly -> getLongOr("X", 0L)
    body = re.sub(
        r"\b" + var + r"\.getLong\(\s*\"([^\"]+)\"\s*\)(?!\.)",
        lambda m_: f"{var}.getLongOr(\"{m_.group(1)}\", 0L)",
        body,
    )
    # getShort("X") -> getShortOr("X", 0)
    body = re.sub(
        r"\b" + var + r"\.getShort\(\s*\"([^\"]+)\"\s*\)(?!\.)",
        lambda m_: f"{var}.getShortOr(\"{m_.group(1)}\", 0)",
        body,
    )
    return body

def apply_write(body, var):
    # putUUID("X", v) -> store("X", UUIDUtil.CODEC, v)
    body = re.sub(
        r"\b" + var + r"\.putUUID\(\s*\"([^\"]+)\"\s*,\s*([^)]+)\)",
        lambda m_: f"{var}.store(\"{m_.group(1)}\", UUIDUtil.CODEC, {m_.group(2).strip()})",
        body,
    )
    return body

def brace_block(lines, start_idx):
    # lines[start_idx] contains '{'
    depth = 0
    i = start_idx
    while i < len(lines):
        depth += lines[i].count("{") - lines[i].count("}")
        if depth <= 0:
            return i
        i += 1
    return i

def process_file(path: Path):
    text = path.read_text(encoding="utf-8")
    orig = text
    lines = text.split("\n")
    out = list(lines)
    readv = re.compile(r"\b(?:void)\s+(?:readAdditionalSaveData|loadAdditional)\s*\(\s*[^)]*ValueInput\s+(\w+)")
    writev = re.compile(r"\b(?:void)\s+(?:addAdditionalSaveData|saveAdditional)\s*\(\s*[^)]*ValueOutput\s+(\w+)")
    need_uuid_import = False
    i = 0
    n = len(lines)
    # process line-by-line; when we find a matching method decl we locate body
    while i < n:
        m = readv.search(lines[i])
        if m:
            var = m.group(1)
            # find the '{' after decl
            j = i
            while j < n and "{" not in lines[j]:
                j += 1
            if j < n:
                end = brace_block(lines, j)
                block = "\n".join(lines[j:end + 1])
                newblock = apply_read(block, var)
                if "UUIDUtil" in newblock:
                    need_uuid_import = True
                out[j:end + 1] = newblock.split("\n")
                i = end + 1
                continue
        mw = writev.search(lines[i])
        if mw:
            var = mw.group(1)
            j = i
            while j < n and "{" not in lines[j]:
                j += 1
            if j < n:
                end = brace_block(lines, j)
                block = "\n".join(lines[j:end + 1])
                newblock = apply_write(block, var)
                if "UUIDUtil" in newblock:
                    need_uuid_import = True
                out[j:end + 1] = newblock.split("\n")
                i = end + 1
                continue
        i += 1
    newtext = "\n".join(out)
    if need_uuid_import and "import net.minecraft.core.UUIDUtil;" not in newtext:
        # insert after last import of same group
        imp = re.compile(r"^import (net\.minecraft\.core\.[^;]+);$", re.M)
        last = None
        for mm in imp.finditer(newtext):
            last = mm
        if last:
            # insert after the chunk of net.minecraft.core imports
            pos = newtext.index(last.group(0))
            newtext = newtext[:pos] + "import net.minecraft.core.UUIDUtil;\n" + newtext[pos:]
        else:
            newtext = newtext.replace("\npublic", "\n" + UUID_IMPORT + "\npublic", 1)
    if newtext != orig:
        path.write_text(newtext, encoding="utf-8")
        return True
    return False

changed = 0
for p in sorted(ROOT.rglob("*.java")):
    if process_file(p):
        changed += 1
print("changed", changed)
