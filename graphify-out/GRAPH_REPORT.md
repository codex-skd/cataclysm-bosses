# Graph Report - .  (2026-08-15)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 15 nodes · 15 edges · 7 communities (4 shown, 3 thin omitted)
- Extraction: 100% EXTRACTED · 0% INFERRED · 0% AMBIGUOUS
- Token cost: 182 input · 64 output

## Graph Freshness
- Built from commit: `cf733278`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- Gradle Scripts
- Mod Development
- Event Handling
- Mod Logo
- Mod Icon

## God Nodes (most connected - your core abstractions)
1. `Sundering` - 4 edges
2. `Logo for The Sundering mod` - 0 edges
3. `Icon for The Sundering mod` - 0 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (7 total, 3 thin omitted)

### Community 0 - "Gradle Scripts"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 1 - "Mod Development"
Cohesion: 0.83
Nodes (3): Logger, Mod, Sundering

## Knowledge Gaps
- **2 isolated node(s):** `Logo for The Sundering mod`, `Icon for The Sundering mod`
  These have ≤1 connection - possible missing edges or undocumented components.
- **3 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Sundering` connect `Mod Development` to `Event Handling`?**
  _High betweenness centrality (0.031) - this node is a cross-community bridge._
- **What connects `Logo for The Sundering mod`, `Icon for The Sundering mod` to the rest of the system?**
  _2 weakly-connected nodes found - possible documentation gaps or missing edges._