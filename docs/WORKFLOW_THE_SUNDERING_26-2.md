# Flujo de trabajo — The Sundering (NeoForge)

> **Versión del workflow**: 1.16.0 (codex-docs)
> Este archivo pertenece al proyecto **The Sundering**. Cambios aquí solo afectan a este proyecto.
> **Trabaja directamente con este archivo**: es el workflow operativo del mod, autocontenido. No leas `codex-docs/WORKFLOW_AGENT.md` ni `WORKFLOW_GENERIC.md` de forma rutinaria.
> On-demand (solo si la tarea lo necesita): `codex-docs/reference/CURSEFORGE.md` (formato HTML al publicar), `codex-docs/reference/GRAPHIFY.md` (backend LLM de Graphify), `codex-docs/reference/REPO_SETUP.md` (setup único de repo).
>
> ⚠️ **CurseForge cerró el proyecto (2026-08-15)** por subir versiones esqueleto sin contenido real — ver `docs/curseforge/project_vars.md` para el detalle. **No subir nada a CurseForge ni recrear el proyecto hasta tener una versión genuinamente estable.**

## Específico del mod

| Dato | Valor |
|---|---|
| Mod ID (`gradle.properties`) | `the_sundering` |
| Clase principal | `Sundering` |
| Display name (Title Case) | `The Sundering` |
| Versiones de Minecraft | `26.2` |
| Rama | `minecraft/26.2/neoforge-26.2.0.45-beta/production` |

### Notas específicas de este mod

- **Fork de**: [L_Ender's Cataclysm](https://www.curseforge.com/minecraft/mc-mods/lendercataclysm) por L_Ender (MCL_Ender). Referencia original: `L_Ender's Cataclysm 1.21.1-3.32.jar` (mod id `cataclysm`, package `com.github.L_Ender.cataclysm`, versión 3.32 para MC 1.21.1/NeoForge). Sin código fuente público disponible — el port parte de una descompilación (CFR) del jar compilado.
- **mod_id / package / clase — nombre completo en todo, sin abreviar** (decisión explícita del usuario, 2026-08-18): `mod_id=the_sundering`, package Java `com.skd.thesundering`, clase principal `TheSundering` — **a diferencia de** `nautilus_api`/`com.skd.nautilusapi` y `utility_core`/`com.skd.utilitycore`, que sí abrevian el package respecto al mod_id. No aplicar aquí ese patrón de abreviar — es intencional que este mod use el nombre completo en todas las referencias. **Bug real encontrado y corregido el 2026-08-15**: `build.gradle` tenía `from "src/main/templates"` (ruta por defecto del MDK) en la tarea `generateModMetadata` en vez de `from "src/main/resources/templates"` (donde realmente vive la plantilla en este repo) — la tarea nunca generaba el `META-INF/neoforge.mods.toml` real, el jar solo llevaba la plantilla sin procesar bajo `templates/META-INF/`, y Minecraft lo rechazaba con "not a valid mod file". Revisar este mismo detalle si se crea otro mod nuevo copiando esta plantilla.
- **Minecraft / NeoForge**: `26.2` / `26.2.0.45-beta` (versión pineada explícitamente por el usuario — **no actualizar sin pedirlo explícitamente**, ni siquiera a otra beta de la misma rama 26.2)
- **Permiso del autor original — obligatorio, no asumir, CONFIDENCIAL**: L_Ender/MCL_Ender concedió permiso explícito para portar y redistribuir públicamente este derivado (confirmado por el usuario el 2026-08-15, mismo permiso que cubre NautilusAPI/LionfishAPI). **Este acuerdo es confidencial por instrucción expresa del usuario: no mencionar su existencia en ningún texto público** (README.md, project_description.md, versions/*.md, credits de neoforge.mods.toml, o cualquier otro archivo que se publique en CurseForge o en el mirror de GitHub). Esta nota interna (docs/) nunca se publica — REPO_SETUP.md excluye `docs/` del mirror a GitHub — así que es el único lugar donde debe constar el hecho del permiso.
- **Licencia — CC BY-NC-ND 4.0, la más restrictiva del conglomerado**: L_Ender's Cataclysm declara su código bajo **CC BY-NC-ND 4.0** (No-Derivadas) — la cláusula ND en teoría prohíbe distribuir obras derivadas por completo; el permiso confidencial del autor es lo único que hace viable este port público. Los assets originales (texturas, sonidos, modelos, NBTs) son "unlicensed, all rights reserved" — sin licencia de reutilización propia, dependen también del mismo permiso. **No relicenciar** sin confirmar antes con el usuario.
- **Atribución obligatoria (sin mencionar el permiso)**: mantener "port of L_Ender's Cataclysm by L_Ender (MCL_Ender)" — sin ninguna referencia a permiso/autorización — en `README.md`, `docs/curseforge/project_description.md`, `docs/curseforge/versions/*.md` y `credits` de `neoforge.mods.toml` durante todo el desarrollo.
- **Sin residuos del original**: el mod original usa el package `com.github.L_Ender.cataclysm` y namespace de recursos `cataclysm:` — todo el código, assets y datos portados deben quedar bajo `com.skd.thesundering` / `the_sundering:`.
- **Dependencias**:
  - **NautilusAPI** (`nautilus_api`, este mismo conglomerado, ya portada y compilando — `nautilus_api/neoforge/26.2/`) — dependencia obligatoria, sustituye a LionfishAPI. Aún no cableada en `build.gradle` (comentada, pendiente de que exista un jar publicado).
  - **Curios API** — **ya tiene build oficial para NeoForge 26.2** (`curios-neoforge-16.0.0+26.2.jar` confirmado en Fase 0), **no requiere port**. Aún no cableada en `build.gradle`.
- **Icono pendiente**: `assets/the_sundering/icon.png` aún no existe — diseñar uno propio antes de la primera subida a CurseForge, no reutilizar assets de Cataclysm sin verificar que el permiso cubre su redistribución.
- **Fase 0 completada para LionfishAPI/NautilusAPI Y para Cataclysm, incluyendo los 3 bloqueos reales ya resueltos** — ver `temp/cataclysm_port_fase0/FASE0_REPORT.md` (LionfishAPI) y `temp/cataclysm_port_fase0/FASE0_REPORT_CATACLYSM.md` (Cataclysm, 2026-08-15) fuera de este repo, en la raíz del workspace de mods. **Fase 1 planificada y con el Paso 0 ya ejecutado** en `temp/cataclysm_port_fase0/FASE1_PLAN_CATACLYSM.md` — leer ese plan antes de empezar cualquier trabajo de Fase 1, no re-planificar desde cero. **Paso 0 (pasada mecánica global) completado 2026-08-17/18: 10.559 → 6.461 errores (-39%)**. **Código ya copiado a este repo** (2026-08-18, decisión explícita del usuario) — `src/main/java/com/skd/sundering/` son los 839 archivos reales con el Paso 0 aplicado, `Sundering.java` ya es la clase principal real portada (antes `Cataclysm.java`), NautilusAPI cableado como dependencia real en `build.gradle`/`mods.toml`. **NO compila todavía** (quedan 6.461 errores, es el estado esperado — no es una regresión). Sin assets/recursos portados todavía (solo código Java). Los 19 bloques (foundation → registries → infraestructura de render → entidades por facción → mixins/AT) siguen sin empezar — ver plan para el orden. El diagnóstico real de Cataclysm dio **10.559 errores de compilación** sobre 839 clases (con NautilusAPI ya en el classpath para no mezclar ruido). La mayoría son fallout mecánico de patrones ya confirmados (ResourceLocation→Identifier ~1900 hits, Level.isClientSide 418 hits, RenderType reubicado, animate()/AnimationState ya resuelto en NautilusAPI).
  - **`MultiBufferSource` (376 hits) — RESUELTO**: reemplazado por un patrón extract/submit vía `SubmitNodeCollector` (`submitModel`, `submitModelPart`, `submitCustomGeometry`). `VertexConsumer` sigue existiendo igual — código con vértices a mano pasa a `submitNodeCollector.submitCustomGeometry(poseStack, renderType, (pose, consumer) -> { ...mismo código... })`.
  - **`HierarchicalModel` — RESUELTO**: no se renombró, se eliminó del todo — `EntityModel<S>` la absorbió directamente (confirmado en `HumanoidModel` vanilla real). Mismo enfoque que ya usa `BasicEntityModel` en NautilusAPI (standalone, desacoplada de `EntityModel`).
  - **`TextureSheetParticle` — RESUELTO, renombrada a `SingleQuadParticle`**: mismos campos/métodos exactos (`quadSize`, `rCol`/`gCol`/`bCol`, `alpha`, `setSpriteFromAge`), solo cambia `render(...)` → `extract(QuadParticleRenderState, Camera, float)`.
  - Pendientes menores (bajo impacto, resolver sobre la marcha): helpers UUID de `CompoundTag` (ahora vía `Codec`: `tag.store("k", UUIDUtil.CODEC, uuid)` / `tag.read("k", UUIDUtil.CODEC)`), `ArmorMaterial`→`item.equipment`, `AbstractArrow`→`entity.projectile.arrow`, `UseAnim`→`ItemUseAnimation`, `FastColor`/`RenderStateShard`/`DripstoneThickness`/`DirectionProperty`/`InteractionResultHolder` sin investigar aún.
  - **No intentar Fase 1 a mano archivo por archivo** (839 clases, no 35 como NautilusAPI) — ya no hay bloqueos de "no sabemos qué hacer", solo queda delegar el grueso mecánico a OpenCode en bloques por paquete, verificando compilación en cada bloque.
- **Cataclysm trae además, sin equivalente ya resuelto en NautilusAPI**: 22 mixins/accessors (incluyendo mixins de generación de estructuras), un AT de 25 entradas propio (sin verificar todavía contra 26.2.0.45-beta), un hack de extensión de enum vía ASM para rarezas custom, una dimensión propia con worldgen completo (structure sets, template pools, 188 NBTs), y un sistema de animación en 4 capas (AnimationMonster, InternalAnimationMonster, Deepling, Pet) que asumirá la base de `BasicEntityModel`/`AdvancedEntityModel` ya rediseñada en NautilusAPI (desacoplada de `EntityModel` vanilla) — cualquier renderer de jefe portado tendrá que asumir esa misma decisión de diseño, no vanilla `LivingEntityRenderer<T,S,M>`.

## Convenciones de nomenclatura

| Convención | Uso | Ejemplo |
|---|---|---|
| **snake_case** | `mod_id`, assets/ | `the_sundering` |
| **PascalCase** | Clases Java principales | `Sundering` |
| **camelCase** | Variables, métodos, config keys | `sunderingConfig` |
| **Title Case** | Display name (README, CHANGELOG, docs, CurseForge) | `The Sundering` |

## Organización y ramas

- Un repo GitLab por mod, una rama `minecraft/<mc>/neoforge-<neo>/production` por versión. Este clon local trabaja en la rama `production` de esta versión.
- Carpetas: `<mod_id>/<framework>/<mc-version>/` — este clon vive en `sundering/neoforge/26.2/`.
- `*/main` y CI/CD: setup único al crear el repo (`codex-docs/reference/REPO_SETUP.md`) — ramas `production`/`main` ya creadas (2026-08-15); **falta la configuración del operador en GitLab** (default branch, protección de `main`, mirror a GitHub) — pendiente, hacerlo antes del primer push de CI real.

## Estructura del proyecto

`build.gradle` · `gradle.properties` (mod_id, mod_version, mod_group_id, mod_framework) · `settings.gradle` · `src/main/java/<package>/` · `src/main/resources/assets/<mod_id>/` · `META-INF/neoforge.mods.toml` · `libs/` (versionado — aquí irá el jar de NautilusAPI/Curios como dependencia local si hace falta) · `lib_ext/` y `temp/` (no versionados) · `docs/` (WORKFLOW + curseforge/) · `CHANGELOG.md` · `README.md` · `graphify-out/` (versionado, aún no generado).

## Versionado

- Beta `0.0.0-beta.X` · Release `X.Y.Z` (SemVer: MAJOR breaking / MINOR feature / PATCH fix)
- `mod_version` y `mod_framework` en `gradle.properties`. JAR: `<mod_id>-<mc>-<framework>-<loader>-<version>.jar`

## Commits (Conventional Commits)

`<tipo>[<ámbito>]: <descripción>` · tipos `feat fix refactor docs chore style perf test` · el mensaje incluye la versión (`v<version>`).

## Tags

Cada subida a CurseForge crea tag: beta `<mc>-neoforge-beta.X` · release `<mc>-neoforge-X.Y.Z`.

## Flujo por tarea

**0. Alcance** — si el mod tiene varias versiones, preguntar con la herramienta `question`: **"Todas"** o una versión. No asumir.

**1. Desarrollo**

```bash
git checkout minecraft/26.2/neoforge-26.2.0.45-beta/production
./gradlew.bat build
git add -A
git commit -m "feat: <descripción>

v<version>"
git push
```

**2. CurseForge** — solo si el usuario confirma:
- Proyecto en CurseForge: pendiente de creación manual por el usuario (sin API pública para crear proyectos nuevos) — una vez creado, rellenar `docs/curseforge/project_vars.md` con `project_id` y `api_token` (reutilizar el token de cuenta ya usado en otros mods de este conglomerado).
- Bump `mod_version` en gradle.properties → `./gradlew.bat clean build`
- Release notes `docs/curseforge/versions/<version>.md` (HTML) + actualizar `CHANGELOG.md`
- Commit `chore: bump version to <version>` → tag `<mc>-neoforge-<version>` → push
- Subir JAR: `powershell -File ../../codex-docs/scripts/curseforge-upload.ps1` (desde este repo)
- Formato HTML de descripciones/changelog: `codex-docs/reference/CURSEFORGE.md`

**3. Release estable** — bump `X.Y.Z` + tag.

**4. Graphify** — tras cada push a remoto. Versión 0.9.12: **`build` no existe**, usar `extract` (1ª vez) o `update . --force` (tras cambios):

```bash
GRAPHIFY="C:\Users\llagu\AppData\Local\Packages\PythonSoftwareFoundation.Python.3.13_qbz5n2kfra8p0\LocalCache\local-packages\Python313\Scripts\graphify.exe"
"$GRAPHIFY" update . --force
git add graphify-out/ && git commit -m "chore: update knowledge graph" && git push
```

Leer siempre `GRAPH_REPORT.md`, nunca `graph.json`/`graph.html` (pesan >1MB). Sin copias fechadas de `graphify-out/`. Backend LLM: `codex-docs/reference/GRAPHIFY.md`.

## Buenas prácticas

- Un commit por cambio lógico · commit+push tras cada cambio funcional y de docs
- `clean build` antes del JAR final · versionar antes de CurseForge · CHANGELOG al día
- Graphify actualizado tras cada release · nomenclatura consistente · sin basura en repo (`nul`, `*_errors.txt`, `TEMPLATE_LICENSE.txt`) · `.gitignore` excluye `temp/` y `lib_ext/`
- README en inglés siempre actualizado · sin residuos de mod original (paquetes, clases, toml, lang, assets) · atribución de fork explícita, **sin mencionar el permiso** (README, project_description, credits)
- **No relicenciar**: `mod_license`/`LICENSE` deben seguir siendo CC BY-NC-ND 4.0 mientras el mod derive de Cataclysm, salvo indicación expresa del usuario tras confirmar con el autor original
- **Permiso del autor es la base legal de todo el proyecto Y es confidencial**: si en algún momento se pierde constancia de ese permiso o de su confidencialidad (p. ej. nueva sesión sin este contexto), no asumir nada — confirmar con el usuario. No es derivable del código ni de los archivos públicos del repo.
- **Dado el tamaño de Cataclysm (1310 clases), evaluar delegación a OpenCode por bloques** en vez de fixes archivo por archivo — ver nota en "Notas específicas de este mod" arriba.

## Idioma

| Ámbito | Idioma |
|---|---|
| código, logs, commits | en-US |
| README.md | en-US |
| docs internas (docs/, CHANGELOG, este archivo) | es-ES |
| CurseForge | en-US |
