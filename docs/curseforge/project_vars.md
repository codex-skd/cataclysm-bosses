# CurseForge — Variables del proyecto

> ⚠️ **PROYECTO CERRADO POR CURSEFORGE (2026-08-15)**: subimos versiones esqueleto sin
> contenido real y CurseForge cerró el proyecto. `project_id=1652963` **ya no es válido** —
> no usar `curseforge-upload.ps1` ni ningún dato de este archivo hasta que el usuario indique
> lo contrario. **No recrear el proyecto ni subir nada a CurseForge hasta tener una versión
> genuinamente estable** (con contenido real portado de Cataclysm, no solo scaffolding).
> Dado que The Sundering depende de NautilusAPI (también cerrado, ver su propio
> `project_vars.md`), esto probablemente no ocurra hasta bastante avanzada la Fase 1. Cuando
> llegue ese momento, crear un proyecto nuevo desde cero siguiendo el formulario manual
> documentado más abajo — los datos de Name/Summary/Description/License siguen siendo
> válidos como referencia.

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | ~~`1652963`~~ **INVÁLIDO — proyecto cerrado, ver aviso arriba** |
| `mod_id` | `the_sundering` |
| `display_name` | `The Sundering` |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

> Token de cuenta (mismo para todos los mods, reutilizado desde `vellumli/docs/curseforge/project_vars.md`). No hace falta generar uno nuevo.

## Variables para script (lectura automática)

```
project_id = 1652963
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
release_type = beta
game_versions = 9638, 9639, 16498, 10150
relations =                   # dependencias (NautilusAPI, Curios) no cableadas aun -- sin relations hasta que existan como jars/proyectos referenciables
```

## Rama

```
minecraft/26.2/neoforge-26.2.0.45-beta/production
```

## Tag

Formato: `<mc-version>-<framework>-<version>`
Ejemplo: `26.2-neoforge-0.0.0-beta.1`

## Nota

La **primera subida a CurseForge se hace manual** (proyecto recién creado, sin archivos previos que verificar por API). A partir de la segunda subida se puede usar el script `codex-docs/scripts/curseforge-upload.ps1`.

---

## Alta del proyecto en CurseForge (formulario manual)

Datos a usar al crear el proyecto en https://www.curseforge.com/ (Minecraft → Create Project):

| Campo | Valor |
|---|---|
| **Name** | The Sundering |
| **Summary** (short, ~1 línea) | A boss-monster mod — a port of L_Ender's Cataclysm. |
| **Project Type** | Mod |
| **Game** | Minecraft |
| **Categories** | Mobs, Bosses (o la más cercana disponible) |
| **Mod Loader** | NeoForge |
| **License** | CC BY-NC-ND 4.0 (seleccionar "Attribution-NonCommercial-NoDerivatives" si aparece como opción, o pegar el texto/enlace de `LICENSE`) |
| **Client/Server side** | Both |
| **Repository URL** | `https://github.com/stalking-dragons/the-sundering` (mirror público — confirmar tras configurar el mirror en GitLab) |
| **Issue tracker** | `https://gitlab.com/stalking-dragons/minecraft/the-sundering/-/issues` |
| **Description** | Contenido de `docs/curseforge/project_description.md` (HTML) |
| **Logo** | `assets/the_sundering/icon.png` (listo) |
| **Relaciones / dependencias** | NautilusAPI (requerida), Curios API (requerida) |

**IMPORTANTE — sin mencionar el permiso del autor en ningún campo** (ver nota de confidencialidad en `docs/WORKFLOW_SUNDERING_26-2.md`).

Tras crear el proyecto, pegar aquí `project_id`.
