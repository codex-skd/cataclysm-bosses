#!/usr/bin/env python3
"""Count unique error locations from a compileJava log.
Unique key = file + line + msg text. Prints total+unique and per-file top.
Usage: python count_errors.py <logfile>
"""
import re, sys, collections

def main(logpath):
    lines = open(logpath, encoding="utf-8", errors="replace").read().split("\n")
    startpat = re.compile(r"([^:]+?\.java):(\d+): error: (.*)")
    errors = []
    for line in lines:
        m = startpat.search(line)
        if m:
            errors.append((m.group(1), int(m.group(2)), m.group(3).strip()))
    total = len(errors)
    uniq = set(errors)
    print("TOTAL_ERROR_LINES:", total)
    print("UNIQUE_ERRORS:", len(uniq))
    byfile = collections.Counter(e[0] for e in uniq)
    print("\n=== TOP UNIQUE-BY-FILE ===")
    for f, c in byfile.most_common(60):
        print(f"{c:5d} {f}")

if __name__ == "__main__":
    main(sys.argv[1])
