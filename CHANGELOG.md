# Changelog — Cataclysm Bosses

> Nota: las entradas `0.0.0-beta.1..3` se publicaron bajo el nombre anterior del proyecto, "The Sundering" (`mod_id` `the_sundering`), en un proyecto de CurseForge que fue cerrado. El mod se renombró a **Cataclysm Bosses** (`mod_id` `cataclysm_bosses`, package `com.skd.cataclysmbosses`) y se creó un proyecto nuevo de CurseForge (`1664413`). El versionado se reinicia en `0.0.0-alpha.1` para marcar que el port ya compila y arranca, pero **aún no está verificado como jugable**.

## [0.0.0-alpha.1] - 2026-08-31

Primera versión del port bajo el nombre **Cataclysm Bosses**. Es una **alpha de desarrollo**: el mod compila, el jar se genera, el servidor dedicado arranca hasta `Done!` y el cliente carga todos los recursos sin crash fatal — pero **nada se ha verificado in-game** (entrar a un mundo, invocar un jefe, craftear, generación de estructuras).

### Estado

- **Todo el código Java del port de L_Ender's Cataclysm 3.32 (MC 1.21.1) compila contra Minecraft 26.2 / NeoForge 26.2.0.57** (baseline histórico: 5.548 errores de compilación → 0).
- Dependencia de accesorios cambiada de Curios a **regalia_slots_api** (port propio; expone un shim `top.theillusivec4.curios.api.*` completo).
- Data pack y assets (~914 + ~1.771 ficheros) copiados del jar original; 210 recetas migradas al formato de ingredientes de 26.2.
- `runServer` → `Done (6.2s)! For help, type help`. `runClient` carga sin FATAL.

### Limitaciones conocidas (NO jugable todavía)

- **Casi todos los renderers de jefe son stubs vacíos → los jefes son invisibles.** Barras de jefe custom, HUD de vida custom, VFX de partículas y layers de entidad (ojos brillantes, arma en mano, jinetes) están stubbeados. Render de accesorios en el jugador desactivado.
- Usar el **Cursed Bow crashea** (`UnsupportedOperationException`, lógica no reconstruida). El yunque de fusión no produce resultado.
- Worldgen / estructuras / item-model-definitions de 26.2 sin verificar — puede que no generen estructuras y falten crafteos/modelos.
- Rarezas custom (color pulsante), vuelo de la Ignitium Elytra e integración JEI: degradados o desactivados.

### Fix (arranque)

- **Mixins**: `ItemMixin` `ItemEntity.hurt` → `hurtServer(ServerLevel, …)`; `FoodDataMixin` `tick(Player)` → `tick(ServerPlayer)`; quitados `NoteBlockInstrumentMixin` (el enum `NoteBlockInstrument.Type` es `private` ahora) y `Client.HumanoidModelMixin` (`poseRightArm/LeftArm` toman `HumanoidRenderState`), más 7 accessors sin usar.
- **Registro**: `ModBlocks` (134) + `ModItems` (282) migrados a `registerBlock/registerItem(name, factory, propsSupplier)` para que NeoForge asigne el `ResourceKey` a las `Properties` antes de construir el bloque/item (`"Block/Item id not set"`).
- **Data components**: `AttributeUtils.mergeAttributes` lee del `DataComponentMap.Builder` (que es un `DataComponentGetter`) en vez de `item.components()`, que lanza `"Components not bound yet"` durante `ModifyDefaultComponentsEvent`.
- **Class-init**: `Ink_Mural_Block` guarda `DeferredBlock` en vez de resolver `.get()` en `<clinit>`; `Cursed_Tombstone_Block` recupera su `createBlockStateDefinition`.
- **Red**: `MessageOpenInventory` referenciaba clases de cliente (`Screen`, `Minecraft`) en código que el servidor también carga → movido a `ClientProxy`.
- **Sonidos**: `ModSounds` — los sonidos `note_block_imitate_*` pasan por el `DeferredRegister` (evita "registry already frozen").

## [0.0.0-beta.3] - 2026-08-15

### Fix

- **Crash al arrancar en la v0.0.0-beta.2**: `IllegalArgumentException: class ... has no @SubscribeEvent methods, but register was called anyway`. La clase principal (placeholder) llamaba a `NeoForge.EVENT_BUS.register(this)` sin tener ningún método `@SubscribeEvent` — esta versión de NeoForge ya no lo tolera como no-op silencioso. Quitada la llamada hasta que exista un listener real.
- Confirmado en juego: carga correctamente junto al resto de mods de la instancia de pruebas.

## [0.0.0-beta.2] - 2026-08-15

### Fix

- **Jar rechazado por Minecraft ("not a valid mod file") en la v0.0.0-beta.1**: `build.gradle` apuntaba a `src/main/templates` (ruta antigua del MDK) en vez de `src/main/resources/templates`, así que `META-INF/neoforge.mods.toml` nunca se generaba de verdad dentro del jar. Corregido.
- `mod_id` normalizado a `the_sundering` (antes `sundering`, inconsistente con el nombre de la carpeta local y el repo).

## [0.0.0-beta.1] - 2026-08-15

### Setup

- **Estructura inicial del repo.** Scaffolding del proyecto (MDK NeoForge 26.2.0.45-beta, ModDevGradle), clase principal placeholder, `neoforge.mods.toml` template, mixins config vacío. Aún sin código portado de L_Ender's Cataclysm — pendiente Fase 1 del port. Dependencias planificadas (NautilusAPI, Curios) aún no cableadas en `build.gradle`.
