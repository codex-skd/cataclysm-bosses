SESSION STATUS — NeoForge 26.2.0.45-beta -> 26.2.0.57 compile port
================================================================
Date: 2026-08-26
Compile baseline: ./gradlew compileJava  (Xmaxerrs 20000)
Error count: start 5548  ->  now 5010   (538 errors fixed this session)

Resumes: local branch minecraft/26.2/neoforge-26.2.0.57/production
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
Dominant blockers (root-cause classes must be fixed first; many child errors are cascades):
- Rendering rewrite: MultiBufferSource -> SubmitNodeCollector (SubmitNodeCollector /
  submitModel / submitModelPart / submitCustomGeometry). ~180+ errors, ~134 files. This is
  the single biggest blocker (renderers, layers, models, CMItemstackRenderer, ItemRenderer).
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
- Item data-driven rewrite: ArmorItem / Tier / SwordItem.createAttributes removed.
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
