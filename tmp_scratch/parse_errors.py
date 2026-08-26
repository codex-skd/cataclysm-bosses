#!/usr/bin/env python3
"""Parse a compileJava output log and produce structured error stats.
Usage: python parse_errors.py <logfile> [--top N]
Produces per-file counts and per-symbol clusters to triage a port.
"""
import sys, re, collections

def main(logpath, top=80):
    lines = open(logpath, encoding="utf-8", errors="replace").read().split("\n")
    # error start: <path>/X.java:LINE: error: MSG
    startpat = re.compile(r"([^:]+?\.java):(\d+): error: (.*)")
    sympat = re.compile(r"\s*symbol:\s+(.*)")
    locpat = re.compile(r"\s*location:\s+(.*)")

    errors = []  # dicts
    i = 0
    n = len(lines)
    while i < n:
        line = lines[i]
        m = startpat.search(line)
        if m:
            f, ln, msg = m.group(1), int(m.group(2)), m.group(3).strip()
            symbol, location = "", ""
            # scan following lines for symbol/location
            j = i + 1
            while j < n and (not startpat.search(lines[j])):
                if not symbol:
                    sm = sympat.search(lines[j])
                    if sm:
                        symbol = sm.group(1).strip()
                if not location:
                    lm = locpat.search(lines[j])
                    if lm:
                        location = lm.group(1).strip()
                # stop after we pass a line not related (blank / caret only)
                if lines[j].strip() == "":
                    j += 1
                    break
                j += 1
            errors.append({"file": f, "line": ln, "msg": msg, "symbol": symbol, "loc": location})
            i = j
        else:
            i += 1

    print("TOTAL_ERROR_LINES:", len(errors))
    print("UNIQUE_FILES:", len(set(e["file"] for e in errors)))
    print("UNIQUE_MSGS:", len(set(e["msg"] for e in errors)))

    # per-file counts
    byfile = collections.Counter(e["file"] for e in errors)
    print("\n=== TOP FILES ===")
    for f, c in byfile.most_common(50):
        print(f"{c:5d} {f}")

    # symbol clusters
    sigcount = collections.Counter()
    for e in errors:
        key = (e["msg"], e["symbol"], e["loc"])
        sigcount[key] += 1
    print(f"\n=== TOP UNIQUE (msg/symbol/loc) ===")
    for (msg, sym, loc), c in sigcount.most_common(120):
        if sym:
            print(f"{c:5d} [{msg}] symbol={sym} loc={loc}")
        else:
            print(f"{c:5d} [{msg}]")

if __name__ == "__main__":
    log = sys.argv[1]
    top = int(sys.argv[2]) if len(sys.argv) > 2 else 80
    main(log, top)
