# Changelog — The Sundering

## [0.0.0-beta.2] - 2026-08-15

### Fix

- **Jar rechazado por Minecraft ("not a valid mod file") en la v0.0.0-beta.1**: `build.gradle` apuntaba a `src/main/templates` (ruta antigua del MDK) en vez de `src/main/resources/templates`, así que `META-INF/neoforge.mods.toml` nunca se generaba de verdad dentro del jar. Corregido.
- `mod_id` normalizado a `the_sundering` (antes `sundering`, inconsistente con el nombre de la carpeta local y el repo).

## [0.0.0-beta.1] - 2026-08-15

### Setup

- **Estructura inicial del repo.** Scaffolding del proyecto (MDK NeoForge 26.2.0.45-beta, ModDevGradle), clase principal placeholder, `neoforge.mods.toml` template, mixins config vacío. Aún sin código portado de L_Ender's Cataclysm — pendiente Fase 1 del port. Dependencias planificadas (NautilusAPI, Curios) aún no cableadas en `build.gradle`.
