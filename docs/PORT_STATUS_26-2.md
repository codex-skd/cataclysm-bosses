SESSION STATUS — NeoForge 26.2.0.45-beta -> 26.2.0.57 compile port
================================================================

== 2026-08-30 (sesión 5) — 423 -> 288 errores | client/ (model DONE, render en curso) ==

Modelo de delegación: opencode-go/longcat-2.0 (elección del usuario, misma que sesiones 2-4).
Nota: longcat esta sesión tiende a tardar MUCHO (~25-35 min/lote) y a veces necesita el fichero
de errores regenerado; también corrompió 6 líneas con un char  al quitar @Override (Claude lo
reparó). Prompts tight en scratchpad: deleg_client_model{,_1b}.md, deleg_render_entity_{light,heavy}.md.
Refs de NautilusAPI copiadas a tmp_scratch/nautilus_ref/ (OpenCode auto-rechaza external_directory).

Commits nuevos (rama production, SIN pushear):
  d410b94  client/model/ compila (423 -> 351)   [longcat parcial + Claude a mano: clusters
           buildPartCache->createPartLookup, riding field, translateToHand, skull models, elytra]
  4ad909f  client/render/entity LIGHT batch + root proxy (351 -> 288)  [longcat: 27 renderers
           simples CmEntityRenderer; + Claude: FMLLoader.getDist->FMLEnvironment.getDist,
           ClientProxy cameraEntity/Int2ObjectMap]

ESTADO: 288 errores, todos en client/:
  render/entity            140   (SOLO el cluster CmMobRenderer de jefes: Scylla 20, Leviathan 10,
                                  Deepling*/Draugr*/Ignited*... + Scylla_Ceraunus, Void_Scatter_Arrow.
                                  Los 27 renderers simples ya compilan. -> lote HEAVY delegado a longcat.)
  event/                    62   (ClientEvent.java ~58 + ClientSetup ~4; RenderGuiLayerEvent,
                                  RenderLivingEvent, key handling, ViewArea privado... A MANO al final.)
  render/item/CuriosRenderer 44  (Curios render API; prepareModel name-clash x9. Varios quedarán stub.)
  gui                       17   (CustomBossBar blit(Identifier,...) x11; MinistrosityInventoryScreen 4)
  render/etc                16   (CurioHeadRenderer 8, LightningBoltData 7 - ViewArea.sections privado)
  CustomRarity 3 / render(root) 3 / render/item 3

TODOs 26.2 NUEVOS de esta sesión (stubs que compilan, revisar antes de jugar):
  - client/render/blockentity/Cataclysm_Skull_Block_Renderer: submit() entero stub (ya lo estaba).
    Los 3 *HeadModel perdieron su translate/scale custom (Model#renderToBuffer es final ahora);
    valores originales anotados como PORT TODO en cada HeadModel para re-aplicar aquí.
  - client/render/entity LIGHT: Eye_Of_Dungeon / Blazing_Bone / Urchin_Spike -> render de item
    (ItemModelResolver/ItemRenderer) dejado como PORT TODO de 1 línea.
  - Boss_Respawn_Spawner_Block_Entity: re-añadido `public final AnimationState openingAnimationState`
    (se perdió en la descompilación); verificar que la animación de apertura del spawner va.
  - Ignitium_Elytra_chestplate_Model: reescrito contra HumanoidRenderState.elytraRot* (como el
    ElytraModel vanilla); se perdió la matemática vieja de fall-fly/crouch (ahora es upstream).

PLAN restante (orden):
  1. render/entity HEAVY (140) - longcat en curso (deleg_render_entity_heavy.md). Scylla/Leviathan
     quizá necesiten repaso a mano. El cuerpo de render() de muchos jefes YA era un stub // TODO.
  2. render/item/CuriosRenderer (44) + render/etc (16) - Curios; varios quedarán stub.
  3. gui (17) - CustomBossBar blit/GuiGraphics.
  4. event/ClientEvent.java (62) - AL FINAL, A MANO, con la tabla de mc262_client_api_migration.
  5. `./gradlew build`, repasar TODOs, runClient.

--- histórico sesión 4 ---

== 2026-08-30 (sesión 4) — 560 -> 423 errores | SOLO QUEDA client/ ==

Commits nuevos (rama production, SIN pushear):
  4e07d5a  mixin/ compila (560 -> 542)          [a mano: cir.setReturnValue, (X)(Object)this, Model ctor]
  f8ad070  init/ + inventory/ effects/ message/ crafting/ jei/ event/ compilan (560 -> 490)
           [parcial longcat-2.0 + a mano; ver TODOs stub abajo]
  d040f82  client/model/ ImmutableList genéricos (490 -> 423)   [regex a mano en 90 ficheros]

**TODO PAQUETE COMPILA MENOS client/.** 423 errores, todos en client/:
  render/entity            194   (renderers de mob/boss; Scylla_Renderer 20, The_Leviathan 10,
                                  Deepling_Brute 7... ~40 ficheros. Puentes Cm* ya existen.)
  event/ClientEvent.java    61   (varios sub-problemas: RenderGuiLayerEvent, RenderLivingEvent,
                                  key handling, LevelRenderer.viewArea privado, Camera.getNearPlane...
                                  ver memoria mc262_client_api_migration)
  model/entity              51   (residual tras el fix de ImmutableList; setupAnim nueva firma,
                                  HeadedModel/LivingEntityRenderState genéricos)
  render/item/CuriosRenderer 44  (Curios API de render cambió: prepareModel name-clash x9,
                                  ICurioRenderer. Curios sigue medio-stubbeado en varios sitios)
  gui                       17   (CustomBossBar 11 - blit(Identifier,...) firma, GuiGraphics;
                                  MinistrosityInventoryScreen 4)
  render/etc                16   (CurioHeadRenderer 8, LightningBoltData 7 - ViewArea.sections privado)
  model/armor               10   (Ignitium_Elytra_chestplate_Model: HumanoidModel<T> genéricos +
                                  AbstractClientPlayer.elytraRotX/Y/Z eliminados - reescritura de elytra)
  render(root)/render/item/CustomRarity  ~9

ENTORNO: la herramienta Bash de la sesión 4 se rompió (sin PATH: git/grep/coreutils no
resuelven). Se trabajó todo por PowerShell + python3 + scratchpad/extract.py + client_scope.py.
Compilar así:  & .\gradlew.bat compileJava "-Dorg.gradle.jvmargs=-Xmx10G" --console=plain 2>&1 |
               Out-File compile.txt -Encoding utf8 -Width 1000    (el -Width 1000 es CLAVE: sin él
               PowerShell trunca las rutas de los errores y extract.py no las parsea).

TODOs 26.2 nuevos (stubs que compilan, revisar antes de publicar):
  - jei/CMRecipes: devuelve listas vacías (Level.getRecipeManager() eliminado; API de recetas
    cliente cambió). La integración JEI no funcionará hasta re-cablear level.recipeAccess().
  - inventory/WeaponfusionMenu.createResult: stubbeado -> el yunque de fusión abre GUI pero no
    produce resultado. Re-cablear recipeAccess().
  - event/ServerEventHandler: lookup de Curios stubbeado (efecto Blazing Grips no se aplicará).
  - init/ModItems: 3 comidas (lionfish, amethyst_crab_meat, blessed_amethyst_crab_meat) perdieron
    sus efectos al comer (FoodProperties.Builder.effect eliminado -> mover a DataComponents.CONSUMABLE).
  - init/ModEntities: Lionfish usa atributos de monstruo por defecto (perdió su createAttributes).

PLAN client/ (sugerido):
  1. render/entity (194) - delegar por lotes (~15 ficheros/lote) con prompt tight + patrones de
     render acumulados. Los peores (Scylla 20, The_Leviathan 10) quizá a mano.
  2. model/entity (51) + model/armor (10) - setupAnim/genéricos; el elytra a mano o stub.
  3. render/item/CuriosRenderer (44) + render/etc (16) - Curios render; puede que varios queden stub.
  4. gui (17) - CustomBossBar blit/GuiGraphics.
  5. ClientEvent.java (61) - AL FINAL, a mano, con la tabla de mc262_client_api_migration delante.
  6. `./gradlew build`, repasar TODOs, runClient.

== 2026-08-30 (sesión 3, FINAL) — 1.015 -> 560 errores ==

Objetivo: primera versión limpia (compila) para subir a CurseForge.

Commits nuevos en `minecraft/26.2/neoforge-26.2.0.57/production` (SIN pushear):
  00fdf42  entity/AnimationMonster/ compila (1015 -> 896)   [longcat-2.0 + 8 fixes a mano]
  dae8f97  entity/InternalAnimationMonster/ + Deepling/ compila (896 -> 690)  [longcat-2.0 + 10 fixes]
  44ca83f  entity/ TODO el árbol compila (690 -> 665)  [Ministrosity + CMBossInfoServer + Spike a mano]
  7ec446f  items/ compila (662 -> 560)  [longcat-2.0 + ~30 stragglers a mano]

**entity/ ENTERO e items/ ENTERO compilan (0 errores).**

PAQUETES A 0 ERRORES: blocks/, client/particle/ (+Options/), CMRenderTypes.java,
  structures/ (incl. jisaw/), world/, util/, **TODO entity/**, **TODO items/**.

REPARTO DE LOS 560 RESTANTES:
  client/  486   -- EL ÚNICO BLOQUE GRANDE. renderers de entidad/boss, modelos
                    (client/model/entity/*: ImmutableList.of((Object)root) genéricos ~mecánico),
                    client/render/entity/* (renderers: puentes Cm* ya existen), ClientEvent.java ~61.
  init/    32    (11 ficheros: ModDataComponents/ModRecipeSerializers register() con MapCodec,
                    KeyMapping ctor nuevo (KeyMapping(String,Type,int,String) -> otra firma),
                    Codec<UUID>->Codec<Object> raw, ArmorMaterial->Holder<ArmorMaterial> en ModItems)
  mixin/   18    (LivingEntityMixin 4x "Object->Boolean" en @Redirect/@ModifyVariable,
                    Client/HumanoidModelMixin 3x Model<S> ctor, 8x mixins de estructura "Object->Boolean")
  misc ~24: inventory 8 (WeaponfusionMenu/ItemCombinerMenu ctor), effects 5 (EffectAbyssal_Burn
            cannot find symbol), message 5 (MessageParticle RegistryFriendlyByteBuf/addParticle),
            crafting 2, jei 2 (CMRecipes recipe-manager API), event 1

ORDEN SUGERIDO PARA CONTINUAR:
  1. init/ (32) + mixin/ (18) + misc (~24) — ~74 errores, mecánico variado. Una delegación
     a longcat-2.0 con el prompt tight + patrones acumulados; luego stragglers a mano.
     (init/ toca ModItems otra vez para ArmorMaterial->Holder si el commit de items/ lo dejó a medias.)
  2. client/ (486) — el bloque final. Trocear:
     a) client/model/entity/ (~ImmutableList.of genéricos + Model<S> ctor) — muy mecánico, delegar entero.
     b) client/render/entity/ (renderers) — CmEntityRenderer/CmMobRenderer/CmHierarchicalModel ya
        existen de sesiones previas; migrar los que aún usan MultiBufferSource/RenderType viejo.
     c) client/render/ (BER, item renderers, etc) + client/gui/.
     d) ClientEvent.java (61) — al final, probablemente varios sub-problemas (RenderGuiLayerEvent,
        RenderLivingEvent, key handling, etc — ver memoria [[mc262_client_api_migration]]).
  3. Cuando compile: `./gradlew build`, revisar los TODOs 26.2 (abajo), runClient, y recién entonces
     pensar en CurseForge (el proyecto está CERRADO por L_Ender — ver docs/curseforge/, NO subir
     hasta tener algo genuinamente jugable).

TODOs 26.2 acumulados (stubs que compilan pero necesitan repaso antes de jugar de verdad):
  - Koboleton_Entity.java:207 — Curios getCuriosHelper() eliminado, stub Optional.empty()
  - Netherite_Ministrosity_Entity — GUI de inventario del pet stubbeada (MinistrostiyMenu sin
    MenuType registrado; el path manual de ServerPlayer es privado ahora). El pet funciona,
    su inventario persiste, pero no se abre la pantalla. Reimplementar con player.openMenu(MenuProvider).
  - Endermaptera getDefaultLootTable() override quitado -> getLootTable().orElse(null) (verificar drops)
  - Draugar: canDropMobsSkull()/increaseDroppedSkulls() quitados (verificar que dropean cráneos)
  - varios "isDamageSourceBlocked -> isBlocking" pierden el check de ángulo de escudo (aceptable)

ORDEN SUGERIDO PARA CONTINUAR:
  1. Terminar items/ (delegación lanzada; revisar, compilar, commitear).
  2. init/ (32) — registros; mecánico, mirar patrones de vault-drawers/otros mods ya portados.
  3. mixin/ (18) + misc pequeño (inventory/effects/message/crafting/jei/event ~20).
  4. client/ (486) — el más grande. Empezar por client/model/entity/ (ImmutableList.of genéricos,
     ~mecánico) y client/render/entity/ (renderers: los puentes Cm* ya existen de sesiones previas).
     Dejar ClientEvent.java para el final (61 err, probablemente varios sub-problemas).

== 2026-08-30 — HANDOFF (sesión 2, FINAL): 1.397 -> ~1.015 errores ==

Commits nuevos en `minecraft/26.2/neoforge-26.2.0.57/production` (SIN pushear):
  23b8531  structures/ + world/ compila (1397 -> 1231)   [longcat-2.0 + ~19 fixes a mano]
  7821b99  entity/projectile/ base classes + top files (1231 -> 1164)  [longcat-2.0]
  2456d52  entity/projectile/ COMPLETO, 0 errores (1164 -> 1076)  [longcat-2.0 batch 2 + ~20 fixes a mano]
  c4da1dd  entity/effect/ + AI/ compilan; Pet/ casi (1076 -> 1015)  [longcat-2.0 + fixes a mano]

PAQUETES QUE YA COMPILAN (0 errores): blocks/, client/particle/ (+Options/),
  client/render/CMRenderTypes.java, structures/ (incl. jisaw/), world/, util/,
  entity/projectile/, entity/effect/, entity/AI/.

UN FICHERO PENDIENTE AISLADO: entity/Pet/Netherite_Ministrosity_Entity.java (21 errores).
  Pet con HasCustomInventoryScreen que abre menú a mano tocando privados de ServerPlayer
  (nextContainerCounter/containerCounter/initMenu) + interfaz world.inventory.ContainerListener
  cambiada (dataChanged) + bodies ValueInput/Output. El reemplazo público 26.2 del hack de
  abrir menú es player.openMenu(MenuProvider). Merece pase dedicado solo-ese-fichero.

REPARTO DE LOS ~1.011 RESTANTES (recuento fresco: scratchpad/an4.py <logfile>):
  client/  486   (renderers de entidad/boss, modelos, ClientEvent.java ~61) -- EL MÁS GRANDE
  entity/  350   (SIN projectile/effect/AI/ ya hechos):
     InternalAnimationMonster/AcropolisMonsters/ 68  (Clawdian_Entity.java 57 - fichero gigante)
     AnimationMonster/BossMonsters/ 60  (Ignis 24, Harbinger 12, Ender_Guardian 11) + The_Leviathan/ 48
     InternalAnimationMonster/Draugar/ 27  |  IABossMonsters/Scylla/ 27  |  Deepling/ 20
     InternalAnimationMonster/ (root, mobs sueltos: Endermaptera, The_Prowler, Coralssus,
       Kobolediator, Wadjet...) 21  |  Ancient_Remnant/ 14  |  Maledictus/ 11  |  NewNetherite_Monstrosity/ 11
     + Pet/Netherite_Ministrosity (21, ver arriba)
  items/   105  (data-driven rewrite - ver histórico "items data-driven rewrite" más abajo)
  init/    32   |  mixin/ 18  |  effects/ 5  inventory/ 5  message/ 5  crafting/ 2  jei/ 2

PATRONES 26.2 CONFIRMADOS ESTA SESIÓN (para el prompt de delegación):
  - setPos(x,y,z,yaw,pitch) -> setPos(x,y,z)+setYRot((float)yaw)+setXRot((float)pitch)
  - CompoundTag getX -> getXOr(k,def) ; getCompound -> getCompoundOrEmpty ; read/store(CODEC)
  - Entity.kill() -> discard() (proyectiles) ó kill(ServerLevel)
  - hurtServer(ServerLevel,DamageSource,float) es el override abstracto nuevo (marca/effect entities: return false)
  - EntityDataSerializers.OPTIONAL_UUID ELIMINADO -> slot STRING + uuid.toString()/UUID.fromString
    (afecta a Tidal_Tentacle ya hecho, Abyss_Mark, Abyss_Portal, The_Leviathan, etc.)
  - Entity.setNoCulling(boolean) ELIMINADO (noCulling solo en Display) -> borrar la llamada
  - EntityTypeTags.SENSITIVE_TO_ENDER ELIMINADO -> entity.getType() == EntityTypes.ENDERMAN
  - ThrowableProjectile perdió el ctor (type,thrower,level) -> super(type, thrower.getX(),
    thrower.getEyeY()-0.1, thrower.getZ(), level) + this.setOwner(thrower)
  - ThrowableItemProjectile movido a ...projectile.throwableitemprojectile.* y +param ItemStack
  - ItemParticleOption(ParticleType, Item)  (NO ItemStack)
  - ChunkPos.x/.z campos -> .x()/.z() ; MobSpawnSettings.SpawnerData sin weight (weight en addSpawn)
  - getShuffledJigsawBlocks -> List<StructureTemplate.JigsawBlockInfo> (.info()/.pool()/.name())
  - RecordCodecBuilder.mapCodec con >~10 campos: hace falta el witness <T> explícito
  - HurtByTargetGoal.timestamp privado -> getTimestamp()/setTimestamp() ; TargetingConditions.Selector
    en vez de Predicate<LivingEntity> ; PathfinderMob restriction API renombrada (verificar en mc_src)

PROCESO DE DELEGACIÓN (lo que funciona):
  - Modelo: `opencode-go/longcat-2.0`. Fiable para port Java. Nvidia deepseek-v4-pro = demasiado lento.
  - Prompt TIGHT: prohibir "leer todos los ficheros primero"; una-a-una; dar los patrones inline;
    NO dejar que investigue cada API (solo si un error concreto lo pide). Plantillas:
    scratchpad/deleg_projectile_v2.md , deleg_entity_misc.md , deleg_structures.md
  - longcat hace ~8-15 ficheros por invocación y a veces sale limpio (exit 0) a mitad -> NO es cuelgue,
    simplemente relanzar con el fichero de errores regenerado. Repetir hasta 0.
  - Extraer errores del paquete:
      grep -A2 -F 'cataclysmbosses\<pkg>\' scratchpad/compile_XX.txt | grep -vE '^\s+location:|^--$' > tmp_scratch/<pkg>_errors.txt
  - Claude compila y verifica DESPUÉS (OpenCode no puede). Cerrar opencode al acabar:
      powershell "Get-Process opencode | ? {$_.ProcessName -ceq 'opencode'} | Stop-Process -Force" ; ./gradlew --stop

ORDEN SUGERIDO PARA MAÑANA:
  1. Terminar entity/effect/+Pet/+AI/ (delegación ya lanzada; revisar resultado, compilar, commitear).
  2. entity/ resto por subpaquete: AnimationMonster/BossMonsters/ (+The_Leviathan/), luego
     InternalAnimationMonster/{AcropolisMonsters(Clawdian),Draugar,IABossMonsters/Scylla,...}, Deepling/.
     Clawdian_Entity.java (57) probablemente merece pase a mano o delegación solo-ese-fichero.
  3. items/ (~105) - data-driven, mirar PORT_STATUS histórico "items data-driven rewrite".
  4. client/ (~486) - lo más grande; renderers dependían de entity/. Puentes Cm* ya existen.
  5. init/ (~32), mixin/ (~18), y el resto pequeño.

== 2026-08-29 (tarde) — HANDOFF: dónde retomar mañana ==

ESTADO: `./gradlew compileJava` FALLA con **1.397 errores** (empezamos la sesión en 1.767).
Progreso de la sesión, todo commiteado en `minecraft/26.2/neoforge-26.2.0.57/production` (SIN pushear):
  8482b2a  chore(repo): limpieza de basura versionada + rename the_sundering -> cataclysm_bosses
  b27c897  blocks/ compila (1767 -> 1708)          [OpenCode Go / longcat-2.0]
  698cfbe  particle/Options/ compila (1708 -> 1579)[Nvidia deepseek-v4-pro — lento, se descartó a media]
  a42756b  client/particle/ compila (1579 -> 1397) [OpenCode Go / longcat-2.0]

PAQUETES QUE YA COMPILAN (0 errores): blocks/, client/particle/, client/particle/Options/,
  client/render/CMRenderTypes.java (ya estaba hecho de antes; el "209 errores" del histórico era obsoleto).

REPARTO ACTUAL DE LOS 1.397 (aprox, sacar recuento fresco con:
  cd scratchpad && python3 an3.py <logfile>  — o el snippet de abajo):
  client/  ~640   (renderers de entidad/boss, modelos, ClientEvent.java ~61)
  entity/  ~560   (cascada de API de entidad; ver histórico "Entity API cascade roots")
  structures/ ~120 (Jigsaw: SpawnerData record, ChunkPos(BlockPos), getMinBuildHeight)
  items/   ~100
  world/   ~40    (DataFixTypes.LEVEL_DATA, getBooleanOr, SpawnerData)
  resto (init, mixin, jei, crafting, effects, inventory, message) ~35

PRÓXIMO CLUSTER SUGERIDO (por orden de rentabilidad / aislamiento):
  1. structures/ + world/  (~160, mecánico: SpawnerData(EntityType,int,int)->record nuevo,
     new ChunkPos(BlockPos)-> ChunkPos(pos) o SectionPos, getMinBuildHeight->getMinY,
     DataFixTypes.LEVEL_DATA renombrado, nbt.getBoolean->getBooleanOr). Bien acotado, no cascada.
  2. entity/ base classes primero (Animation_Monster, Internal_Animation_Monster ya tocadas;
     revisar hurtServer/ValueInput-Output/EntityReference) — al compilar las bases caen
     cientos de errores hijos. Es el bloque de mayor efecto pero el más delicado.
  3. client/ renderers (~640) — el más grande; depende en parte de que entity/ compile.
     Ya hay puentes CmEntityRenderer/CmMobRenderer/CmHierarchicalModel de sesiones previas.

CÓMO SE ESTÁ TRABAJANDO (repetir el patrón):
  - Delegar cada paquete a OpenCode con `opencode run -m opencode-go/longcat-2.0 -- "$(cat prompt.md)"`.
    longcat-2.0 (OpenCode Go) es el modelo elegido: rápido y limpio en blocks/ y particle/.
    Nvidia deepseek-v4-pro responde al test pero es DEMASIADO lento para trabajo real (~45min/24
    ficheros y se cuelga) — no usar salvo que Go agote cuota.
  - El prompt SIEMPRE incluye: restricciones (no tocar versiones/deps, no borrar/renombrar,
    no git add/commit/push, no ./gradlew), scope al paquete, y apuntar a las fuentes reales
    en tmp_scratch/mc_src y tmp_scratch/neo_src (RESTAURADAS en el repo, gitignored).
  - Se le pasa el fichero de errores del paquete: extraer con
      grep -A3 -F 'cataclysmbosses\<pkg>\' scratchpad/compile_pN.txt | grep -vE '^\s+location:|^--$' > tmp_scratch/<pkg>_errors.txt
  - Claude compila y verifica DESPUÉS (OpenCode no puede: sandbox bloquea gradle).
  - Cerrar SIEMPRE el proceso opencode al acabar (Stop-Process nombre 'opencode') y `./gradlew --stop`.
  - Los prompts de delegación de hoy: scratchpad/deleg_blocks.md, deleg_particles_v2.md (plantillas).

OJO / PENDIENTES:
  - Rename the_sundering->cataclysm_bosses hecho en código y mixins.json pero SIN verificar en
    runtime (imposible hasta compilar). Revisar carga de mixins y regen de refmap cuando compile.
  - `src/main/java/com/skd/cataclysmbosses/blocks/Property/CustomNoteBlockInstrument.java`:
    fichero en subcarpeta con nombre raro (package ...blocks.Property). Compila; no tocado.
    Plantear moverlo a un paquete normal en un pase de limpieza posterior.
  - `Cataclysm.java` es un shim de compatibilidad legacy (la clase @Mod real es Cataclysm_Bosses.java).
  - Line endings: el repo no tiene .gitattributes; git avisa LF->CRLF en cada commit. Inofensivo
    pero conviene añadir un .gitattributes con `* text=auto eol=lf` en algún momento.

== 2026-08-29 (mañana) — Limpieza de repo + estado de compilación ==
- `./gradlew compileJava`: FALLA con 1.767 errores (baseline del port 5.548). Nunca ha compilado limpio, nunca se ha ejecutado.
- Distribución: client 796 / entity 566 / structures 122 / items 105 / blocks 60 / world 43 / resto 75.
  Ficheros peores: ClientEvent.java (61), Clawdian_Entity.java (57), Ignis_Entity.java (24), Scylla_Entity.java (23),
  Cursed_Pyramid_Structure.java (23), JigsawStructureAssembler.java (23).
- Limpieza aplicada: sacados del repo ~187 MB de basura versionada (127 build_log*.txt, ~55 hs_err_pid*.log,
  compile_*/build_errors_*, net/ shadow sources, top/*.class, tmp_scratch/{mc_src,neo_src,old_*}, scripts fix_*.py/.sh).
  Movido todo a `../_port_archive_20260829/` (fuera del repo, reversible). `.gitignore` ampliado para que no vuelvan.
  Este fichero (antes tmp_scratch/PORT_STATUS.md) movido a docs/.
- Renombrado the_sundering -> cataclysm_bosses (parcial, ver abajo): arreglados MODID en Cataclysm.java,
  3x @EventBusSubscriber(modid=...), the_sundering.mixins.json/refmap.json -> cataclysm_bosses.*,
  package del mixins.json (com.skd.thesundering.mixin -> com.skd.cataclysmbosses.mixin),
  assets/the_sundering/ -> assets/cataclysm_bosses/, mods.toml template, README/CHANGELOG/ROADMAP/WORKFLOW.
  PENDIENTE de verificar en build (imposible hasta que compile). Revisar que no quede ninguna carga de mixins
  por nombre viejo y que el refmap se regenere.

== Histórico (2026-08-26) ==
Date: 2026-08-26
Compile baseline: ./gradlew compileJava  (Xmaxerrs 20000)
Error count: start 5548 -> 5010 -> 3782 (items) -> 3524 -> 3381 (CMItemstackRenderer) -> 3207 -> 3162 (MobRenderer) -> 3257 -> 2997 -> now 2488
# Models hierarchical batch fixed (23 files via CmHierarchicalModel, Drowned_Host vanilla, 44 layers stubbed)
# Note: 3257 is after partial model WIP (23 HierarchicalModel files stubbed, Drowned_Host vanilla model fixed); count temporarily up due to new bridge stubs (expected to drop after follow-up fixes)
Item/data-driven cluster DONE (~258). Custom item renderer DONE (~143). Simple EntityRenderers batch DONE (~174, 56 files). MobRenderer bosses batch DONE (~45, 34 files):
see "CLUSTER FIXED (CMItemstackRenderer / custom item rendering)" below.

Resumes: local branch minecraft/26.2/neoforge-26.2.0.57/production

== CLUSTER FIXED (items data-driven rewrite) ==
- Tooltier.java: Tier+SimpleTier -> record ToolMaterial(tag,dur,speed,dmgBonus,ench,
  repairTagKey). Repair tags are cataclysm:repairs_*_tools TagKeys (no JSON yet).
- Armortier.java: new ArmorMaterial(durabilityMultiplier, defenseMap<ArmorType,int>,
  ench, equipSound, toughness, kbRes, repairTagKey, assetId ResourceKey<EquipmentAsset>
  under EquipmentAssets.ROOT_ID w/ ns cataclysm). Durabilities 45/45/35/30.
- Cataclysm_Armor extends Item now; keeps material/type fields + getDefaultAttributeModifiers;
  createAttributes/createArmorAttributes take ArmorType. Subclasses only changed ctor sigs.
- Monstrous_Helm / Ignitium_Elytra_ChestPlate extend Item directly. Elytra glider is now
  DataComponents.GLIDER=Unit.INSTANCE; use() -> Equippable.swapWithEquipmentSlot(stack,player).
  canElytraFly/elytraFlightTick removed (vanilla handles via GLIDER component).
- Athame/Khopesh extend Item (SwordItem gone); Brontes/Void_forge/Infernal_forge extend Item
  (PickaxeItem gone). Tools via properties.sword/pickaxe/shovel/axe/hoe(ToolMaterial,...);
  ShovelItem/AxeItem/HoeItem classes still exist with (ToolMaterial,dmg,speed,props) ctors.
- ModItems: armor registrations use properties.humanoidArmor(Armortier.X.value(), ArmorType.Y)
  (sets durability/enchantable/equippable/repairable) + explicit .attributes(createAttributes...).
  Spawn eggs: new SpawnEggItem(props.spawnEgg(ModEntities.X.get())) — REQUIRED for runtime.
  NOTE: octohost_spawn_egg spawns DROWNED_HOST (verified vs original jar bytecode);
  there was never an OCTOHOST entity.
- Unbreakable component class REMOVED in 26.2: DataComponents.UNBREAKABLE is Unit ->
  components.set(..., Unit.INSTANCE). modifyComponents Initializer receives
  DataComponentMap.Builder -> AttributeUtils.mergeAttributes retyped to DataComponentMap.Builder.
- CLIENT side of this cluster: CustomArmorRenderProperties.getHumanoidArmorModel new sig
  (ItemStack, EquipmentClientInfo.LayerType, Model)->Model; renderCustomArmor takes Item and
  checks Cataclysm_Armor.getMaterial()==Armortier.CURSIUM.
  HumanoidArmorLayerMixin NEUTRALIZED (old renderArmorPiece pipeline gone; must be re-implemented
  against SubmitNodeCollector/EquipmentLayerRenderer in the client render cluster).

== CLUSTER FIXED (CMItemstackRenderer / custom item rendering) ==
- BlockEntityWithoutLevelRenderer + ItemRenderer REMOVED in 26.2. Items render via
  ItemModel/SpecialModelRenderer + SubmitNodeCollector; wiring is data-driven from
  assets/<ns>/items/<item>.json (NOT yet written — assets phase).
- CMItemstackRenderer rewritten as SpecialModelRenderer<ItemStack> (+ record Unbaked with
  MAP_CODEC). Registered as "cataclysm:cm_item" in ClientSetup via
  RegisterSpecialModelRendererEvent (NOT RegisterItemModelsEvent — that one is for ItemModel codecs).
  Runtime JSON needed per item:
    assets/cataclysm/items/<name>.json -> {"model":{"type":"minecraft:special","base":"minecraft:item/...","renderer":{"type":"cataclysm:cm_item"}}}
  All ~40 branches preserved: geometry now submitted via collector.order(n).submitCustomGeometry(
  pose, renderType, lambda) where the lambda receives PoseStack.Pose -> wrap into new PoseStack()
  + mulPose(pose.pose()) to call BasicEntityModel.renderToBuffer. Foil = extra pass with
  RenderTypes.entityGlint() (old ItemRenderer.getArmorFoilBuffer behavior).
- Skull items: Cataclysm_Skull_Block_Renderer ported to BlockEntityRenderer<T,SkullBlockRenderState>
  (extractRenderState uses vanilla TRANSFORMATIONS; submit delegates to vanilla static
  SkullBlockRenderer.submitSkull). New helper renderItemSkull(...) for the CMItemstackRenderer path.
  EntityRenderersEvent.CreateSkullModels new sig: registerSkullModel(Type, ModelLayerLocation,
  Function<ModelPart,SkullModelBase>, @Nullable Identifier).
- ItemProperties.register REMOVED in 26.2 (data-driven item model properties): the 11
  registrations (blocking/throwing/using/chunk predicates) deleted from doClientStuff.
  Data-driven equivalents (range_dispatch/dispatch in item model JSONs) pending assets phase.
  Cursed_bow.getPullingAmount / Wrath_of_the_desert.getPullingAmount still read stack state
  directly, unaffected at compile level.
- CMItemRenderProperties.java DELETED (getCustomRenderer hook no longer exists).
- Lionfish_Renderer created as Entity-based placeholder (Lionfish_Entity class itself is
  MISSING from the port — referenced by ModEntities + Deepling_Angler_Entity; must be ported).
  LionFish_Layer/Spike_Renderer remain old-API (entity renderer cluster).
- net.minecraft.Util -> net.minecraft.util.Util.

== CLUSTER FIXED (simple EntityRenderers batch — 56 files) ==
- Compat bridge for the 26.2 EntityRenderer/RenderState split so legacy immediate-mode
  bodies keep working on top of SubmitNodeCollector:
  client/render/compat/CmEntityRenderState (Entity + partialTick),
  CmRecordingVertexConsumer (7-method VertexConsumer recorder → replayInto),
  CmMultiBufferSource (getBuffer(RenderType) + getFoilBuffer(rt,foil) — foil schedules
  a second pending draw sharing the same op list under entityGlint()),
  CmEntityRenderer<T extends Entity> (extends EntityRenderer<T,CmEntityRenderState>,
  extract captures entity/partialTick, submit() runs legacy render() then flushes
  pending draws as ordered submitCustomGeometry + super.submit for nametag/leash).
- Batch-converted 56 EntityRenderer-based renderers (projectiles, portals, marks, etc.):
  extends CmEntityRenderer<XXX>, signature render(XXX,float,PoseStack,CmMultiBufferSource,int),
  ResourceLocation->Identifier, this.model.renderType(...) -> RenderTypes.entityCutout(...)
  + RenderTypes import fix. Removed super.render nametag calls (handled by bridge).
  Example: Thrown_Coral_Spear/Bardiche, Brontes, Abyss blast variants, etc.
- Remaining in render/entity: ~13 files with missing entity/model bases (e.g. Lionfish_Entity
  itself missing — referenced but never ported; blocks ModEntities compilation).

== CLUSTER FIXED (MobRenderer bosses batch — 34 files) ==
- Compat bridge CmMobRenderer<T extends Mob> extends CmEntityRenderer<T> with stubs for
  the old LivingEntityRenderer/MobRenderer helpers called from Scylla etc.:
  model field via compat ctor (Object model), addLayer raw, getAttackAnim/getBob/
  setupRotations/scale/isBodyVisible/getWhiteOverlayProgress/getRenderType/getFlipDegrees/
  isShaking/shouldShowName/getOverlayCoords/isEntityUpSideDown etc. All return safe defaults.
- Batch-converted 34 MobRenderer/LivingEntityRenderer bosses:
  extends CmMobRenderer<XXX>, render(XXX,float,PoseStack,CmMultiBufferSource,int),
  ResourceLocation->Identifier, this.model.renderType(...) -> RenderTypes.entityCutout(...),
  layer loops commented as TODO (need new RenderLayer<S,M>.submit API).
  Scylla_Renderer: 38->23 (-15); similar for others. Two syntax fixes for
  AbstractZombieRenderer 3-param generics (Drowned_Host, Ignited_Berserker).

== CLUSTER FIXED (entity base classes — 4 bases) ==
- LLibrary_Boss_Monster: hurtServer(ServerLevel, DamageSource, float), isInvulnerableTo(ServerLevel),
  addAdditionalHomePoint/readAdditionalHomePoint with ValueOutput/ValueInput,
  ReturnToHome simplified (no DimensionTransition), moveTo instead of setPos
- IABoss_monster: same fixes, DynamicOps/NbtOps imports added
- AbstractDeepling: ISemiAquatic methods (shouldEnterWater, shouldLeaveWater, shouldStopMoving,
  getWaterSearchRange), shouldEnterWater added, made abstract, MobTag import added,
  RidingCoralssus/StopRiding commented out
- Internal_Animation_Monster: hurtServer stub
- Drowned_Host_Model migrated to vanilla ZombieModel<ZombieRenderState>
- ISemiAquatic/IHomeEntity interfaces updated for 26.2 API
- LLibrary_Boss_Monster: SynchedEntityData.Builder import fixed, DimensionTransition removed,
  ReturnToHome simplified, moveTo instead of setPos
- IABoss_monster: DynamicOps/NbtOps imports added, DimensionTransition removed

== REMAINING CLUSTERS (deep/architectural rewrites — NOT done, need real porting) ==

- Compat bridge CmMobRenderer<T extends Mob> extends CmEntityRenderer<T> with stubs for
  the old LivingEntityRenderer/MobRenderer helpers called from Scylla etc.:
  model field via compat ctor (Object model), addLayer raw, getAttackAnim/getBob/
  setupRotations/scale/isBodyVisible/getWhiteOverlayProgress/getRenderType/getFlipDegrees/
  isShaking/shouldShowName/getOverlayCoords/isEntityUpsideDown etc. All return safe defaults.
- Batch-converted 34 MobRenderer/LivingEntityRenderer bosses:
  extends CmMobRenderer<XXX>, render(XXX,float,PoseStack,CmMultiBufferSource,int),
  ResourceLocation->Identifier, this.model.renderType(...) -> RenderTypes.entityCutout(...),
  layer loops commented as TODO (need new RenderLayer<S,M>.submit API).
  Scylla_Renderer: 38 -> 23 errors (-15); similar for others. Two syntax fixes for
  AbstractZombieRenderer 3-param generics (Drowned_Host, Ignited_Berserker).

== PREVIOUS SESSION CLUSTERS (mechanical) ==
Local checkpoint commits (NOT pushed, local-only):
  944e3bf ValueInput/Output namespace, addCooldown ItemStack, value-io bodies
  (next)    EntityType.is->builtInRegistryHolder, build(ResourceKey)
  (next)    level random access, getMaxY, startRiding 3-arg, spawnAtLocation ServerLevel

== CLUSTERS FIXED THIS SESSION (mechanical, behavior-preserving) ==
1. ValueInput/ValueOutput wrong namespace imports (108 files):
   net.minecraft.nbt.ValueInput/ValueOutput  ->  net.minecraft.world.level.storage.
   (resolved the entire "class ValueInput/ValueOutput from nbt" error cluster)
2. addCooldown(Item,int) -> addCooldown(ItemStack,int):
   addCooldown((Item)this, x) -> addCooldown(this.getDefaultInstance(), x)  (21 sites)
3. ValueInput/ValueOutput save/load BODIES (32 files, method-scoped, only on the
   ValueInput/ValueOutput parameter):
   hasUUID->read("x",UUIDUtil.CODEC).isPresent() ; getUUID->...orElse(null)
   putUUID->store("x",UUIDUtil.CODEC,v) ; getFloat->getFloatOr(...,0.0F)
   getBoolean->getBooleanOr(...,false) ; getDouble->getDoubleOr(...,0.0D)
   getInt/getString/getLong/getShort-> get*Or(...,default)  [only when NOT followed by '.']
   Helper script: tmp_scratch/migrate_valueio.py
4. EntityType.is(TagKey) removed -> builtInRegistryHolder().is(tag)  (51 sites, getType().is pattern)
5. EntityType.Builder.build(String) removed -> build(ResourceKey.create(
   Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ns,name)))  (ModEntities, ~47 sites;
   namespace is 'cataclysm' — matches DeferredRegister.create(..., "cataclysm"))
6. Level.protected random -> Level.getRandom()  (random has protected access; ~16 files)
   this.level().random / world.random / worldIn.random / p_xxx_.random
7. Level.getMaxBuildHeight() removed -> getMaxY() + 1   (9 sites; exclusive-top semantics)
8. Entity.startRiding(e, bool) -> startRiding(e, bool, true)   (5 sites; new 3-arg form)
9. Entity.spawnAtLocation(stack,[float]) removed -> spawnAtLocation((ServerLevel)this.level(),
   stack[, float])   (13 sites) + removed invalid @Override on the ItemStack helper overrides
   (also dropped many "method does not override" errors for those helpers)

== REMAINING CLUSTERS (deep/architectural rewrites — NOT done, need real porting) ==
Items cluster is DONE. Dominant blockers now (root-cause classes must be fixed first;
many child errors are cascades):
- Rendering rewrite: MultiBufferSource -> SubmitNodeCollector (submitModel / submitCustomGeometry).
  CMItemstackRenderer DONE; simple EntityRenderers batch DONE (56 files via CmEntityRenderer bridge);
  remaining ~400+ errors in MobRenderer bosses (now via CmMobRenderer, Scylla 38->2), 44 RenderLayer stubs, 23 HierarchicalModel stubs (Maledictus 38->0, Scylla 32->0), plus 13 files
  with missing entity/model bases (e.g. Lionfish_Entity).
- RenderType/CompositeState/RenderStateShard removal (CMRenderTypes.java, 209 errors):
  RenderStateShard/RenderType.CompositeState gone. New custom render types are built with
  RenderType.create(name, RenderSetup) + RenderSetup.builder(RenderPipeline) +
  com.mojang.blaze3d.pipeline RenderPipelines. RenderType constructor is now private
  (cannot subclass). Consumers reference CMRenderTypes.NO_CULL / OVERLAY / LIGHTMAP /
  NEW_ENTITY / TRANSLUCENT_TRANSPARENCY / eyes(...) etc.
- Animation/model rewrite: HierarchicalModel removed (models now extend
  Model<S>/EntityModel<T extends EntityRenderState>). animate(AnimationState,...) and
  animateWalk(...) removed from the model base; animation is applied via
  setupAnim(EntityRenderState) (KeyframeAnimations.animate removed).
  ~178 animate + 16 animateWalk + ~46 HierarchicalModel errors. Also ModelPart.children
  private, HumanoidRenderState missing.
  ArmorMaterial now net.minecraft.world.item.equipment.ArmorMaterial; items use
  properties.humanoidArmor(material,type) + DataComponents.EQUIPPABLE + ItemAttributeModifiers.
  ~164 errors in ModItems + item classes (Armortier, Cursium_Armor, Ignitium_Armor...).
- Particle system: TextureSheetParticle->SingleQuadParticle (render* -> extract*,
  rCol/gCol/bCol fields, ParticleRenderType begin(Tesselator,TextureManager) removed,
  PARTICLE_SHEET_TRANSLUCENT / CUSTOM constants moved). Also ParticleProvider.Factory must
  implement Sprite<SimpleParticleType>.
- Block state property changes: Door_of_Seal_Block FACING/LIT/OPEN, Statue_Block FACING,
  FacingPillarBlock FACING, EMP_Block OVERLOAD/POWERED, CustomNoteBlockInstrument Type private.
- Entity API cascade roots: after base entity classes (Animation_Monster,
  Internal_Animation_Monster, LLibrary_Monster, IABoss_monster, AbstractDeepling, ...)
  compile, many of these vanish:
  level() 46, getX/getY/getZ ~78, getDeltaMovement 16, getRandom 16, damageSources 18,
  isDamageSourceBlocked(Entity.getLastHurtByMob? now shield check) 35, isInWater 13,
  getTarget 13, moveTo->setPos 16, isControlledByLocalInstance, setItemSlot,
  playSound(SoundEvent,float,float)->emitSound, create(Level)->create on ServerLevel 27,
  checkInsideBlocks 12, isInvulnerableTo, getLightColor, getAttributeValue(Holder).
- Recipe API: AltarOfAmethyst assemble/getRecipeFor(RecipeInput), Weaponfusion recipes,
  CraftingMenu / SingleRecipeInput / RecipeInput changes.
- JEI: package mezz.jei.api.recipe missing (mod is in a "jei/" source set — ensure the
  jei dependency / api jar version matches; 7 errors in jei/LEnderCataclysmJEIPlugin...).
- MISC: SpawnerData record constructor, RegistryDataSerializers OPTIONAL_UUID,
  EntityDataSerializers, DataComponentMap.Builder vs DataComponentPatch.Builder,
  ItemAbilities.SHIELD_BLOCK -> ItemAbilities.SHIELD_BLOCK? (moved),
  Minecraft.renderBuffers() removed, Camera.getPosition removed, client renderer registration
  (registerEntityRenderer needs EntityRendererProvider with new Context for render states),
  ClientSetup ItemProperties -> data-driven item model properties.

== KEY PATTERNS / NOTES FOR NEXT SESSION ==
- Extracted real 26.2.0.57 sources live in tmp_scratch/mc_src/ and tmp_scratch/neo_src/
  (these are the ground truth — cross-check any rename against them before applying).
- The mod's internal registry namespace is "cataclysm" (not cataclysm_bosses) — matches the
  known-good 26.2.0.45-beta baseline; do NOT "fix" it to cataclysm_bosses.
- getMaxY() = getMinY()+getHeight()-1; getMaxBuildHeight() old semantics = getMaxY()+1.
- spawnAtLocation / getCooldowns().addCooldown now require ServerLevel / ItemStack resp.
- Do not lower -Xmaxerrs; a passing build reports 0 errors.
- Next most impactful work: port CMRenderTypes.java (single file, 209 errors) to the new
  RenderSetup/RenderPipeline system, then the EntityRenderState-based model/renderer rewrite
  (MultiBufferSource->SubmitNodeCollector), then the data-driven item (ModItems) rewrite.
