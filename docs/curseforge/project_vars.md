# CurseForge — Variables del proyecto

> El proyecto anterior (`the_sundering` / `project_id=1652963`) fue **cerrado por CurseForge**
> (2026-08-15) por subir versiones esqueleto sin contenido real. Se creó un **proyecto nuevo**
> tras renombrar el mod a **Cataclysm Bosses** — ver `project_id` abajo. El versionado se
> reinició en `0.0.0-alpha.1` para marcar que el port compila y arranca pero **aún no está
> verificado como jugable**; las release notes lo dejan claro.

## Proyecto

| Variable | Valor |
|----------|-------|
| `curseforge_project_id` | `1664413` |
| ~~antiguo~~ | ~~`1652963` (proyecto cerrado, `the_sundering`)~~ |
| `mod_id` | `cataclysm_bosses` |
| `display_name` | `Cataclysm Bosses` |

## Tokens

| API | Token | Uso |
|-----|-------|-----|
| Upload | `ee776b0a-ee95-4850-b554-06be02a8657f` | Subir archivos JAR |
| Core (GET) | `$2a$10$yGwryAfmRkS9ZJsJUDf5YOKZpOIsmHB8Fji2D8JVCKBSZEKYlwmaO` | Consultar datos del mod |

Autenticación Upload: cabecera `X-Api-Token`
Autenticación Core: cabecera `x-api-key`

> Token de cuenta (mismo para todos los mods de este conglomerado). No hace falta generar uno nuevo.

## Variables para script (lectura automática)

```
project_id = 1664413
api_token = ee776b0a-ee95-4850-b554-06be02a8657f
release_type = alpha
game_versions = 9638, 9639, 16498, 10150
relations =                   # NautilusAPI / regalia_slots_api aun sin proyecto CF referenciable -- sin relations
```

> `game_versions = 9638, 9639, 16498, 10150` → `Client, Server, 26.2, NeoForge`. Incluye los IDs de
> `Client` **y** `Server`, así que CurseForge publica el fichero como **Client & Server**
> automáticamente (sin paso manual en la web).

## Rama

```
minecraft/26.2/neoforge-26.2.0.57/production
```

## Tag

Formato: `<mc-version>-<framework>-<version>`
Ejemplo: `26.2-neoforge-0.0.0-alpha.1`

## Nota

La **primera subida al proyecto nuevo se hace manual** (proyecto recién creado, sin archivos
previos que verificar por API). A partir de la segunda subida se puede usar
`codex-docs/scripts/curseforge-upload.ps1`.

---

## Alta del proyecto en CurseForge (formulario manual — referencia)

| Campo | Valor |
|---|---|
| **Name** | Cataclysm Bosses |
| **Summary** | A boss-monster mod — a port of L_Ender's Cataclysm. |
| **Project Type** | Mod |
| **Game** | Minecraft |
| **Categories** | Mobs, Bosses (o la más cercana disponible) |
| **Mod Loader** | NeoForge |
| **License** | CC BY-NC-ND 4.0 |
| **Client/Server side** | Both |
| **Description** | Contenido de `docs/curseforge/project_description.md` (HTML) |
| **Logo** | `assets/cataclysm_bosses/icon.png` |
| **Relaciones / dependencias** | NautilusAPI (requerida), regalia_slots_api (requerida) |

**IMPORTANTE — sin mencionar el permiso del autor en ningún campo** (ver nota de confidencialidad en `docs/WORKFLOW_CATACLYSM_BOSSES_26-2.md`).
