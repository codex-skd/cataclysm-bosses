# CurseForge — Variables del proyecto

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | *(pendiente — el usuario lo pasa tras crear el proyecto)* |
| `mod_id` | `sundering` |
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
project_id =                  # pendiente
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
release_type = beta
game_versions = 9638, 9639, 16498, 10150
relations = nautilus-api:requiredDependency, curios:requiredDependency
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
| **Logo** | `assets/sundering/icon.png` (pendiente de generar) |
| **Relaciones / dependencias** | NautilusAPI (requerida), Curios API (requerida) |

**IMPORTANTE — sin mencionar el permiso del autor en ningún campo** (ver nota de confidencialidad en `docs/WORKFLOW_SUNDERING_26-2.md`).

Tras crear el proyecto, pegar aquí `project_id`.
