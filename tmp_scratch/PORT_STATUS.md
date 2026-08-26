SESSION STATUS — NeoForge 26.2.0.45-beta -> 26.2.0.57 compile port
================================================================
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
