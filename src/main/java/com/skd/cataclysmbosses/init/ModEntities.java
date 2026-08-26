/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicates
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntityType$Builder
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.SpawnPlacementTypes
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
 *  net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent
 *  net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent$Operation
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Amethyst_Crab_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Mine_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Orb_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Portal_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Dimensional_Rift_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.Endermaptera_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.Koboleton_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.The_Watcher_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Coral_Golem_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Angler_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Brute_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Priest_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Warlock_Entity;
import com.skd.cataclysmbosses.entity.Deepling.Lionfish_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Cindaria_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Drowned_Host_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Hippocamtus_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Symbiocto_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Urchinkin_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Coralssus_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Draugr_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Ceraunus_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Wadjet_Entity;
import com.skd.cataclysmbosses.entity.Pet.Modern_Remnant_Entity;
import com.skd.cataclysmbosses.entity.Pet.Netherite_Ministrosity_Entity;
import com.skd.cataclysmbosses.entity.Pet.The_Baby_Leviathan_Entity;
import com.skd.cataclysmbosses.entity.effect.Abyss_Mark_Entity;
import com.skd.cataclysmbosses.entity.effect.Bolt_strike_Entity;
import com.skd.cataclysmbosses.entity.effect.Cm_Falling_Block_Entity;
import com.skd.cataclysmbosses.entity.effect.Flame_Strike_Entity;
import com.skd.cataclysmbosses.entity.effect.Lightning_Area_Effect_Entity;
import com.skd.cataclysmbosses.entity.effect.Lightning_Storm_Entity;
import com.skd.cataclysmbosses.entity.effect.Sandstorm_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.effect.SkyColor_Entity;
import com.skd.cataclysmbosses.entity.effect.Void_Vortex_Entity;
import com.skd.cataclysmbosses.entity.effect.Wall_Watcher_Entity;
import com.skd.cataclysmbosses.entity.effect.Wave_Entity;
import com.skd.cataclysmbosses.entity.effect.Wither_Smoke_Effect_Entity;
import com.skd.cataclysmbosses.entity.projectile.Accretion_Entity;
import com.skd.cataclysmbosses.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.skd.cataclysmbosses.entity.projectile.Ancient_Desert_Stele_Entity;
import com.skd.cataclysmbosses.entity.projectile.Ashen_Breath_Entity;
import com.skd.cataclysmbosses.entity.projectile.Axe_Blade_Entity;
import com.skd.cataclysmbosses.entity.projectile.Blazing_Bone_Entity;
import com.skd.cataclysmbosses.entity.projectile.Brontes_Entity;
import com.skd.cataclysmbosses.entity.projectile.Cursed_Sandstorm_Entity;
import com.skd.cataclysmbosses.entity.projectile.Death_Laser_Beam_Entity;
import com.skd.cataclysmbosses.entity.projectile.EarthQuake_Entity;
import com.skd.cataclysmbosses.entity.projectile.Ender_Guardian_Bullet_Entity;
import com.skd.cataclysmbosses.entity.projectile.Eye_Of_Dungeon_Entity;
import com.skd.cataclysmbosses.entity.projectile.Flame_Jet_Entity;
import com.skd.cataclysmbosses.entity.projectile.Flare_Bomb_Entity;
import com.skd.cataclysmbosses.entity.projectile.Ignis_Abyss_Fireball_Entity;
import com.skd.cataclysmbosses.entity.projectile.Ignis_Fireball_Entity;
import com.skd.cataclysmbosses.entity.projectile.Laser_Beam_Entity;
import com.skd.cataclysmbosses.entity.projectile.Lava_Bomb_Entity;
import com.skd.cataclysmbosses.entity.projectile.Lightning_Spear_Entity;
import com.skd.cataclysmbosses.entity.projectile.Lionfish_Spike_Entity;
import com.skd.cataclysmbosses.entity.projectile.Mini_Abyss_Blast_Entity;
import com.skd.cataclysmbosses.entity.projectile.Octo_Ink_Entity;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Arrow_Entity;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Halberd_Entity;
import com.skd.cataclysmbosses.entity.projectile.Player_Ceraunus_Entity;
import com.skd.cataclysmbosses.entity.projectile.Poison_Dart_Entity;
import com.skd.cataclysmbosses.entity.projectile.Sandstorm_Projectile;
import com.skd.cataclysmbosses.entity.projectile.Spark_Entity;
import com.skd.cataclysmbosses.entity.projectile.Storm_Serpent_Entity;
import com.skd.cataclysmbosses.entity.projectile.ThrownCoral_Bardiche_Entity;
import com.skd.cataclysmbosses.entity.projectile.ThrownCoral_Spear_Entity;
import com.skd.cataclysmbosses.entity.projectile.Tidal_Hook_Entity;
import com.skd.cataclysmbosses.entity.projectile.Tidal_Tentacle_Entity;
import com.skd.cataclysmbosses.entity.projectile.Urchin_Spike_Entity;
import com.skd.cataclysmbosses.entity.projectile.Void_Howitzer_Entity;
import com.skd.cataclysmbosses.entity.projectile.Void_Rune_Entity;
import com.skd.cataclysmbosses.entity.projectile.Void_Scatter_Arrow_Entity;
import com.skd.cataclysmbosses.entity.projectile.Void_Shard_Entity;
import com.skd.cataclysmbosses.entity.projectile.Water_Spear_Entity;
import com.skd.cataclysmbosses.entity.projectile.Wither_Homing_Missile_Entity;
import com.skd.cataclysmbosses.entity.projectile.Wither_Howitzer_Entity;
import com.skd.cataclysmbosses.entity.projectile.Wither_Missile_Entity;
import com.google.common.base.Predicates;
import java.util.function.Predicate;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid="the_sundering", bus=EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create((Registry)BuiltInRegistries.ENTITY_TYPE, (String)"cataclysm");
    public static final DeferredHolder<EntityType<?>, EntityType<Ender_Golem_Entity>> ENDER_GOLEM = ENTITY_TYPE.register("ender_golem", () -> EntityType.Builder.of(Ender_Golem_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.5f, 3.5f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ender_golem"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ender_Guardian_Entity>> ENDER_GUARDIAN = ENTITY_TYPE.register("ender_guardian", () -> EntityType.Builder.of(Ender_Guardian_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.5f, 3.8f).fireImmune().clientTrackingRange(10).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ender_guardian"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Netherite_Monstrosity_Entity>> NETHERITE_MONSTROSITY = ENTITY_TYPE.register("netherite_monstrosity", () -> EntityType.Builder.of(Netherite_Monstrosity_Entity::new, (MobCategory)MobCategory.MONSTER).sized(3.0f, 5.75f).fireImmune().clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "netherite_monstrosity"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Netherite_Ministrosity_Entity>> NETHERITE_MINISTROSITY = ENTITY_TYPE.register("netherite_ministrosity", () -> EntityType.Builder.of(Netherite_Ministrosity_Entity::new, (MobCategory)MobCategory.CREATURE).sized(0.5f, 0.9f).clientTrackingRange(10).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "netherite_ministrosity"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Lava_Bomb_Entity>> LAVA_BOMB = ENTITY_TYPE.register("lava_bomb", () -> EntityType.Builder.of(Lava_Bomb_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).fireImmune().setShouldReceiveVelocityUpdates(true).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "lava_bomb"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Flare_Bomb_Entity>> FLARE_BOMB = ENTITY_TYPE.register("flare_bomb", () -> EntityType.Builder.of(Flare_Bomb_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).fireImmune().setShouldReceiveVelocityUpdates(true).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "flare_bomb"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Flame_Jet_Entity>> FLAME_JET = ENTITY_TYPE.register("flame_jet", () -> EntityType.Builder.of(Flame_Jet_Entity::new, (MobCategory)MobCategory.MISC).sized(0.6f, 2.5f).clientTrackingRange(6).updateInterval(2).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "flame_jet"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Lightning_Storm_Entity>> LIGHTNING_STORM = ENTITY_TYPE.register("lightning_storm", () -> EntityType.Builder.of(Lightning_Storm_Entity::new, (MobCategory)MobCategory.MISC).sized(0.9f, 3.5f).clientTrackingRange(6).updateInterval(2).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "lightning_storm"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ignis_Entity>> IGNIS = ENTITY_TYPE.register("ignis", () -> EntityType.Builder.of(Ignis_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.25f, 3.5f).fireImmune().clientTrackingRange(10).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ignis"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ender_Guardian_Bullet_Entity>> ENDER_GUARDIAN_BULLET = ENTITY_TYPE.register("ender_guardian_bullet", () -> EntityType.Builder.of(Ender_Guardian_Bullet_Entity::new, (MobCategory)MobCategory.MISC).sized(0.3125f, 0.3125f).setUpdateInterval(1).setTrackingRange(64).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ender_guardian_bullet"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Void_Rune_Entity>> VOID_RUNE = ENTITY_TYPE.register("void_rune", () -> EntityType.Builder.of(Void_Rune_Entity::new, (MobCategory)MobCategory.MISC).sized(0.6f, 1.95f).clientTrackingRange(6).updateInterval(2).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "void_rune"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Abyss_Mine_Entity>> ABYSS_MINE = ENTITY_TYPE.register("abyss_mine", () -> EntityType.Builder.of(Abyss_Mine_Entity::new, (MobCategory)MobCategory.MISC).sized(1.0f, 1.0f).clientTrackingRange(6).updateInterval(2).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "abyss_mine"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Endermaptera_Entity>> ENDERMAPTERA = ENTITY_TYPE.register("endermaptera", () -> EntityType.Builder.of(Endermaptera_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.2f, 0.8f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "endermaptera"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Deepling_Entity>> DEEPLING = ENTITY_TYPE.register("deepling", () -> EntityType.Builder.of(Deepling_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 2.3f).clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "deepling"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Deepling_Brute_Entity>> DEEPLING_BRUTE = ENTITY_TYPE.register("deepling_brute", () -> EntityType.Builder.of(Deepling_Brute_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.7f, 2.6f).clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "deepling_brute"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Deepling_Angler_Entity>> DEEPLING_ANGLER = ENTITY_TYPE.register("deepling_angler", () -> EntityType.Builder.of(Deepling_Angler_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.65f, 2.45f).clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "deepling_angler"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Deepling_Priest_Entity>> DEEPLING_PRIEST = ENTITY_TYPE.register("deepling_priest", () -> EntityType.Builder.of(Deepling_Priest_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 2.3f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "deepling_priest"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Deepling_Warlock_Entity>> DEEPLING_WARLOCK = ENTITY_TYPE.register("deepling_warlock", () -> EntityType.Builder.of(Deepling_Warlock_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 2.3f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "deepling_warlock"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Abyss_Mark_Entity>> ABYSS_MARK = ENTITY_TYPE.register("abyss_mark", () -> EntityType.Builder.of(Abyss_Mark_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).fireImmune().setUpdateInterval(1).setTrackingRange(20).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "abyss_mark"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Lionfish_Entity>> LIONFISH = ENTITY_TYPE.register("lionfish", () -> EntityType.Builder.of(Lionfish_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 0.55f).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "lionfish"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Coral_Golem_Entity>> CORAL_GOLEM = ENTITY_TYPE.register("coral_golem", () -> EntityType.Builder.of(Coral_Golem_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.5f, 2.7f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "coral_golem"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Coralssus_Entity>> CORALSSUS = ENTITY_TYPE.register("coralssus", () -> EntityType.Builder.of(Coralssus_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.75f, 2.85f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "coralssus"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ignited_Revenant_Entity>> IGNITED_REVENANT = ENTITY_TYPE.register("ignited_revenant", () -> EntityType.Builder.of(Ignited_Revenant_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.6f, 2.8f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ignited_revenant"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ignited_Berserker_Entity>> IGNITED_BERSERKER = ENTITY_TYPE.register("ignited_berserker", () -> EntityType.Builder.of(Ignited_Berserker_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.0f, 2.4f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ignited_berserker"))));
    public static final DeferredHolder<EntityType<?>, EntityType<The_Harbinger_Entity>> THE_HARBINGER = ENTITY_TYPE.register("the_harbinger", () -> EntityType.Builder.of(The_Harbinger_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.6f, 3.75f).fireImmune().immuneTo(new Block[]{Blocks.WITHER_ROSE}).clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "the_harbinger"))));
    public static final DeferredHolder<EntityType<?>, EntityType<The_Watcher_Entity>> THE_WATCHER = ENTITY_TYPE.register("the_watcher", () -> EntityType.Builder.of(The_Watcher_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.85f, 0.85f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "the_watcher"))));
    public static final DeferredHolder<EntityType<?>, EntityType<The_Prowler_Entity>> THE_PROWLER = ENTITY_TYPE.register("the_prowler", () -> EntityType.Builder.of(The_Prowler_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.5f, 2.75f).fireImmune().clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "the_prowler"))));
    public static final DeferredHolder<EntityType<?>, EntityType<The_Leviathan_Entity>> THE_LEVIATHAN = ENTITY_TYPE.register("the_leviathan", () -> EntityType.Builder.of(The_Leviathan_Entity::new, (MobCategory)MobCategory.MONSTER).sized(4.5f, 3.0f).fireImmune().eyeHeight(1.35f).clientTrackingRange(10).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "the_leviathan"))));
    public static final DeferredHolder<EntityType<?>, EntityType<The_Baby_Leviathan_Entity>> THE_BABY_LEVIATHAN = ENTITY_TYPE.register("the_baby_leviathan", () -> EntityType.Builder.of(The_Baby_Leviathan_Entity::new, (MobCategory)MobCategory.CREATURE).sized(0.75f, 0.42f).clientTrackingRange(10).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "the_baby_leviathan"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Void_Scatter_Arrow_Entity>> VOID_SCATTER_ARROW = ENTITY_TYPE.register("void_scatter_arrow", () -> EntityType.Builder.of(Void_Scatter_Arrow_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "void_scatter_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Poison_Dart_Entity>> POISON_DART = ENTITY_TYPE.register("poison_dart", () -> EntityType.Builder.of(Poison_Dart_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "void_scatter_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Phantom_Arrow_Entity>> PHANTOM_ARROW = ENTITY_TYPE.register("phantom_arrow", () -> EntityType.Builder.of(Phantom_Arrow_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "phantom_arrow"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Phantom_Halberd_Entity>> PHANTOM_HALBERD = ENTITY_TYPE.register("phantom_halberd", () -> EntityType.Builder.of(Phantom_Halberd_Entity::new, (MobCategory)MobCategory.MISC).sized(0.6f, 1.95f).clientTrackingRange(6).updateInterval(2).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "phantom_halberd"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Void_Shard_Entity>> VOID_SHARD = ENTITY_TYPE.register("void_shard", () -> EntityType.Builder.of(Void_Shard_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "void_shard"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Blazing_Bone_Entity>> BLAZING_BONE = ENTITY_TYPE.register("blazing_bone", () -> EntityType.Builder.of(Blazing_Bone_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "blazing_bone"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Lionfish_Spike_Entity>> LIONFISH_SPIKE = ENTITY_TYPE.register("lionfish_spike", () -> EntityType.Builder.of(Lionfish_Spike_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "lionfish_spike"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Urchin_Spike_Entity>> URCHIN_SPIKE = ENTITY_TYPE.register("urchin_spike", () -> EntityType.Builder.of(Urchin_Spike_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "urchin_spike"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Spark_Entity>> SPARK = ENTITY_TYPE.register("spark", () -> EntityType.Builder.of(Spark_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).updateInterval(20).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "spark"))));
    public static final DeferredHolder<EntityType<?>, EntityType<ScreenShake_Entity>> SCREEN_SHAKE = ENTITY_TYPE.register("screen_shake", () -> EntityType.Builder.of(ScreenShake_Entity::new, (MobCategory)MobCategory.MISC).sized(0.0f, 0.0f).setUpdateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "screen_shake"))));
    public static final DeferredHolder<EntityType<?>, EntityType<SkyColor_Entity>> SKY_COLOR = ENTITY_TYPE.register("sky_color", () -> EntityType.Builder.of(SkyColor_Entity::new, (MobCategory)MobCategory.MISC).sized(0.0f, 0.0f).setUpdateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "sky_color"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Cm_Falling_Block_Entity>> CM_FALLING_BLOCK = ENTITY_TYPE.register("cm_falling_block", () -> EntityType.Builder.of(Cm_Falling_Block_Entity::new, (MobCategory)MobCategory.MISC).sized(0.98f, 0.98f).clientTrackingRange(10).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "cm_falling_block"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ignis_Fireball_Entity>> IGNIS_FIREBALL = ENTITY_TYPE.register("ignis_fireball", () -> EntityType.Builder.of(Ignis_Fireball_Entity::new, (MobCategory)MobCategory.MISC).sized(0.6f, 0.6f).setUpdateInterval(1).setTrackingRange(20).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ignis_fireball"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ignis_Abyss_Fireball_Entity>> IGNIS_ABYSS_FIREBALL = ENTITY_TYPE.register("ignis_abyss_fireball", () -> EntityType.Builder.of(Ignis_Abyss_Fireball_Entity::new, (MobCategory)MobCategory.MISC).sized(0.6f, 0.6f).setUpdateInterval(1).setTrackingRange(20).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ignis_abyss_fireball"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wither_Smoke_Effect_Entity>> WITHER_SMOKE_EFFECT = ENTITY_TYPE.register("wither_smoke_effect", () -> EntityType.Builder.of(Wither_Smoke_Effect_Entity::new, (MobCategory)MobCategory.MISC).sized(6.0f, 0.5f).fireImmune().clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wither_smoke_effect"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Lightning_Area_Effect_Entity>> LIGHTNING_AREA_EFFECT = ENTITY_TYPE.register("lightning_area_effect", () -> EntityType.Builder.of(Lightning_Area_Effect_Entity::new, (MobCategory)MobCategory.MISC).sized(6.0f, 0.5f).fireImmune().clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "lightning_area_effect"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Flame_Strike_Entity>> FLAME_STRIKE = ENTITY_TYPE.register("flame_strike", () -> EntityType.Builder.of(Flame_Strike_Entity::new, (MobCategory)MobCategory.MISC).sized(6.0f, 0.5f).fireImmune().clientTrackingRange(10).updateInterval(2).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "flame_strike"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Bolt_strike_Entity>> BOLT_STRIKE = ENTITY_TYPE.register("bolt_strike", () -> EntityType.Builder.of(Bolt_strike_Entity::new, (MobCategory)MobCategory.MISC).sized(0.0f, 0.0f).clientTrackingRange(16).updateInterval(2).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "bolt_strike"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wave_Entity>> WAVE = ENTITY_TYPE.register("wave", () -> EntityType.Builder.of(Wave_Entity::new, (MobCategory)MobCategory.MISC).sized(1.7f, 2.0f).fireImmune().clientTrackingRange(6).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wave"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Storm_Serpent_Entity>> STORM_SERPENT = ENTITY_TYPE.register("storm_serpent", () -> EntityType.Builder.of(Storm_Serpent_Entity::new, (MobCategory)MobCategory.MISC).sized(2.0f, 9.0f).clientTrackingRange(6).updateInterval(2).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "storm_serpent"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ashen_Breath_Entity>> ASHEN_BREATH = ENTITY_TYPE.register("ashen_breath", () -> EntityType.Builder.of(Ashen_Breath_Entity::new, (MobCategory)MobCategory.MISC).sized(0.0f, 0.0f).fireImmune().clientTrackingRange(4).setUpdateInterval(3).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ashen_breath"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wall_Watcher_Entity>> WALL_WATCHER = ENTITY_TYPE.register("wall_watcher", () -> EntityType.Builder.of(Wall_Watcher_Entity::new, (MobCategory)MobCategory.MISC).sized(0.0f, 0.0f).noSummon().fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wall_watcher"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Death_Laser_Beam_Entity>> DEATH_LASER_BEAM = ENTITY_TYPE.register("death_laser_beam", () -> EntityType.Builder.of(Death_Laser_Beam_Entity::new, (MobCategory)MobCategory.MISC).sized(0.1f, 0.1f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "death_laser_beam"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Abyss_Blast_Entity>> ABYSS_BLAST = ENTITY_TYPE.register("abyss_blast", () -> EntityType.Builder.of(Abyss_Blast_Entity::new, (MobCategory)MobCategory.MISC).sized(0.1f, 0.1f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "abyss_blast"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Mini_Abyss_Blast_Entity>> MINI_ABYSS_BLAST = ENTITY_TYPE.register("mini_abyss_blast", () -> EntityType.Builder.of(Mini_Abyss_Blast_Entity::new, (MobCategory)MobCategory.MISC).sized(0.1f, 0.1f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "mini_abyss_blast"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Portal_Abyss_Blast_Entity>> PORTAL_ABYSS_BLAST = ENTITY_TYPE.register("portal_abyss_blast", () -> EntityType.Builder.of(Portal_Abyss_Blast_Entity::new, (MobCategory)MobCategory.MISC).sized(0.1f, 0.1f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "portal_abyss_blast"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Laser_Beam_Entity>> LASER_BEAM = ENTITY_TYPE.register("laser_beam", () -> EntityType.Builder.of(Laser_Beam_Entity::new, (MobCategory)MobCategory.MISC).sized(0.3125f, 0.3125f).fireImmune().clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "laser_beam"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wither_Missile_Entity>> WITHER_MISSILE = ENTITY_TYPE.register("wither_missile", () -> EntityType.Builder.of(Wither_Missile_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wither_missile"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wither_Homing_Missile_Entity>> WITHER_HOMING_MISSILE = ENTITY_TYPE.register("wither_homing_missile", () -> EntityType.Builder.of(Wither_Homing_Missile_Entity::new, (MobCategory)MobCategory.MISC).sized(0.25f, 0.25f).setUpdateInterval(1).setTrackingRange(20).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wither_homing_missile"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wither_Howitzer_Entity>> WITHER_HOWITZER = ENTITY_TYPE.register("wither_howitzer", () -> EntityType.Builder.of(Wither_Howitzer_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).fireImmune().setShouldReceiveVelocityUpdates(true).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wither_howitzer"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Accretion_Entity>> ACCRETION = ENTITY_TYPE.register("accretion", () -> EntityType.Builder.of(Accretion_Entity::new, (MobCategory)MobCategory.MISC).sized(0.98f, 0.98f).updateInterval(20).passengerAttachments(new float[]{0.49f}).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "accretion"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Abyss_Orb_Entity>> ABYSS_ORB = ENTITY_TYPE.register("abyss_orb", () -> EntityType.Builder.of(Abyss_Orb_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).fireImmune().setUpdateInterval(1).setTrackingRange(20).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "abyss_orb"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Void_Howitzer_Entity>> VOID_HOWITZER = ENTITY_TYPE.register("void_howitzer", () -> EntityType.Builder.of(Void_Howitzer_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).fireImmune().setShouldReceiveVelocityUpdates(true).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "void_howitzer"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Eye_Of_Dungeon_Entity>> EYE_OF_DUNGEON = ENTITY_TYPE.register("eye_of_dungeon", () -> EntityType.Builder.of(Eye_Of_Dungeon_Entity::new, (MobCategory)MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "eye_of_dungeon"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Void_Vortex_Entity>> VOID_VORTEX = ENTITY_TYPE.register("void_vortex", () -> EntityType.Builder.of(Void_Vortex_Entity::new, (MobCategory)MobCategory.MISC).sized(2.5f, 0.5f).fireImmune().clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "void_vortex"))));
    public static final DeferredHolder<EntityType<?>, EntityType<The_Leviathan_Tongue_Entity>> THE_LEVIATHAN_TONGUE = ENTITY_TYPE.register("the_leviathan_tongue", () -> EntityType.Builder.of(The_Leviathan_Tongue_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "the_leviathan_tongue"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Tidal_Tentacle_Entity>> TIDAL_TENTACLE = ENTITY_TYPE.register("tidal_tentacle", () -> EntityType.Builder.of(Tidal_Tentacle_Entity::new, (MobCategory)MobCategory.MISC).sized(0.1f, 0.1f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "tidal_tentacle"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Tidal_Hook_Entity>> TIDAL_HOOK = ENTITY_TYPE.register("tidal_hook", () -> EntityType.Builder.of(Tidal_Hook_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "tidal_hook"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Scylla_Ceraunus_Entity>> SCYLLA_CERAUNUS = ENTITY_TYPE.register("scylla_ceraunus", () -> EntityType.Builder.of(Scylla_Ceraunus_Entity::new, (MobCategory)MobCategory.MISC).sized(1.5f, 1.5f).clientTrackingRange(4).passengerAttachments(new float[]{0.5f}).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "scylla_ceraunus"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Player_Ceraunus_Entity>> PLAYER_CERAUNUS = ENTITY_TYPE.register("player_ceraunus", () -> EntityType.Builder.of(Player_Ceraunus_Entity::new, (MobCategory)MobCategory.MISC).sized(1.5f, 1.5f).clientTrackingRange(4).passengerAttachments(new float[]{0.5f}).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "player_ceraunus"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Brontes_Entity>> BRONTES = ENTITY_TYPE.register("brontes", () -> EntityType.Builder.of(Brontes_Entity::new, (MobCategory)MobCategory.MISC).sized(1.5f, 1.5f).clientTrackingRange(4).passengerAttachments(new float[]{0.5f}).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "brontes"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Abyss_Portal_Entity>> ABYSS_PORTAL = ENTITY_TYPE.register("abyss_portal", () -> EntityType.Builder.of(Abyss_Portal_Entity::new, (MobCategory)MobCategory.MISC).fireImmune().sized(3.0f, 0.15f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "abyss_portal"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Abyss_Blast_Portal_Entity>> ABYSS_BLAST_PORTAL = ENTITY_TYPE.register("abyss_blast_portal", () -> EntityType.Builder.of(Abyss_Blast_Portal_Entity::new, (MobCategory)MobCategory.MISC).sized(4.0f, 0.5f).fireImmune().clientTrackingRange(4).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "abyss_blast_portal"))));
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownCoral_Spear_Entity>> CORAL_SPEAR = ENTITY_TYPE.register("coral_spear", () -> EntityType.Builder.of(ThrownCoral_Spear_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "coral_spear"))));
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownCoral_Bardiche_Entity>> CORAL_BARDICHE = ENTITY_TYPE.register("coral_bardiche", () -> EntityType.Builder.of(ThrownCoral_Bardiche_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "coral_bardiche"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Dimensional_Rift_Entity>> DIMENSIONAL_RIFT = ENTITY_TYPE.register("dimensional_rift", () -> EntityType.Builder.of(Dimensional_Rift_Entity::new, (MobCategory)MobCategory.MISC).sized(2.0f, 2.0f).fireImmune().clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "dimensional_rift"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Amethyst_Crab_Entity>> AMETHYST_CRAB = ENTITY_TYPE.register("amethyst_crab", () -> EntityType.Builder.of(Amethyst_Crab_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.5f, 2.6f).spawnDimensionsScale(1.0f).clientTrackingRange(10).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "amethyst_crab"))));
    public static final DeferredHolder<EntityType<?>, EntityType<EarthQuake_Entity>> EARTHQUAKE = ENTITY_TYPE.register("earthquake", () -> EntityType.Builder.of(EarthQuake_Entity::new, (MobCategory)MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(20).setUpdateInterval(1).sized(0.5f, 0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "earthquake"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Amethyst_Cluster_Projectile_Entity>> AMETHYST_CLUSTER_PROJECTILE = ENTITY_TYPE.register("amethyst_cluster_projectile", () -> EntityType.Builder.of(Amethyst_Cluster_Projectile_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.0f).fireImmune().setShouldReceiveVelocityUpdates(true).setUpdateInterval(1).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "amethyst_cluster_projectile"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ancient_Remnant_Entity>> ANCIENT_REMNANT = ENTITY_TYPE.register("ancient_remnant", () -> EntityType.Builder.of(Ancient_Remnant_Entity::new, (MobCategory)MobCategory.MONSTER).sized(4.35f, 5.0f).fireImmune().clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ancient_remnant"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Modern_Remnant_Entity>> MODERN_REMNANT = ENTITY_TYPE.register("modern_remnant", () -> EntityType.Builder.of(Modern_Remnant_Entity::new, (MobCategory)MobCategory.CREATURE).sized(0.75f, 0.42f).clientTrackingRange(10).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "modern_remnant"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Koboleton_Entity>> KOBOLETON = ENTITY_TYPE.register("koboleton", () -> EntityType.Builder.of(Koboleton_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.85f, 1.6f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "koboleton"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Kobolediator_Entity>> KOBOLEDIATOR = ENTITY_TYPE.register("kobolediator", () -> EntityType.Builder.of(Kobolediator_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.4f, 4.4f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "kobolediator"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Wadjet_Entity>> WADJET = ENTITY_TYPE.register("wadjet", () -> EntityType.Builder.of(Wadjet_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.85f, 3.4f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "wadjet"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Sandstorm_Entity>> SANDSTORM = ENTITY_TYPE.register("sandstorm", () -> EntityType.Builder.of(Sandstorm_Entity::new, (MobCategory)MobCategory.MISC).sized(2.5f, 4.5f).fireImmune().clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "sandstorm"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Sandstorm_Projectile>> SANDSTORM_PROJECTILE = ENTITY_TYPE.register("sandstorm_projectile", () -> EntityType.Builder.of(Sandstorm_Projectile::new, (MobCategory)MobCategory.MISC).sized(0.5f, 1.0f).clientTrackingRange(4).setUpdateInterval(2).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "sandstorm_projectile"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Cursed_Sandstorm_Entity>> CURSED_SANDSTORM = ENTITY_TYPE.register("cursed_sandstorm", () -> EntityType.Builder.of(Cursed_Sandstorm_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 1.0f).setShouldReceiveVelocityUpdates(true).setUpdateInterval(2).setTrackingRange(20).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "cursed_sandstorm"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Ancient_Desert_Stele_Entity>> ANCIENT_DESERT_STELE = ENTITY_TYPE.register("ancient_desert_stele", () -> EntityType.Builder.of(Ancient_Desert_Stele_Entity::new, (MobCategory)MobCategory.MISC).sized(0.8f, 1.375f).clientTrackingRange(6).updateInterval(2).setShouldReceiveVelocityUpdates(true).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "ancient_desert_stele"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Maledictus_Entity>> MALEDICTUS = ENTITY_TYPE.register("maledictus", () -> EntityType.Builder.of(Maledictus_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.5f, 3.0f).fireImmune().clientTrackingRange(10).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "maledictus"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Draugr_Entity>> DRAUGR = ENTITY_TYPE.register("draugr", () -> EntityType.Builder.of(Draugr_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "draugr"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Royal_Draugr_Entity>> ROYAL_DRAUGR = ENTITY_TYPE.register("royal_draugr", () -> EntityType.Builder.of(Royal_Draugr_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.975f, 2.05f).clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "royal_draugr"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Elite_Draugr_Entity>> ELITE_DRAUGR = ENTITY_TYPE.register("elite_draugr", () -> EntityType.Builder.of(Elite_Draugr_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.8f, 2.6f).clientTrackingRange(6).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "elite_draugr"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Aptrgangr_Entity>> APTRGANGR = ENTITY_TYPE.register("aptrgangr", () -> EntityType.Builder.of(Aptrgangr_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.4f, 4.0f).clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "aptrgangr"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Axe_Blade_Entity>> AXE_BLADE = ENTITY_TYPE.register("axe_blade", () -> EntityType.Builder.of(Axe_Blade_Entity::new, (MobCategory)MobCategory.MISC).sized(1.2f, 2.5f).clientTrackingRange(4).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "axe_blade"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Hippocamtus_Entity>> HIPPOCAMTUS = ENTITY_TYPE.register("hippocamtus", () -> EntityType.Builder.of(Hippocamtus_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.95f, 3.0f).clientTrackingRange(8).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "hippocamtus"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Cindaria_Entity>> CINDARIA = ENTITY_TYPE.register("cindaria", () -> EntityType.Builder.of(Cindaria_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 2.3f).clientTrackingRange(8).eyeHeight(1.7f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "cindaria"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Clawdian_Entity>> CLAWDIAN = ENTITY_TYPE.register("clawdian", () -> EntityType.Builder.of(Clawdian_Entity::new, (MobCategory)MobCategory.MONSTER).sized(2.5f, 4.5f).clientTrackingRange(10).eyeHeight(4.4f).fireImmune().build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "clawdian"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Scylla_Entity>> SCYLLA = ENTITY_TYPE.register("scylla", () -> EntityType.Builder.of(Scylla_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.4f, 3.0f).fireImmune().clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "scylla"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Urchinkin_Entity>> URCHINKIN = ENTITY_TYPE.register("urchinkin", () -> EntityType.Builder.of(Urchinkin_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.7f, 0.7f).clientTrackingRange(4).eyeHeight(0.35f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "urchinkin"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Drowned_Host_Entity>> DROWNED_HOST = ENTITY_TYPE.register("drowned_host", () -> EntityType.Builder.of(Drowned_Host_Entity::new, (MobCategory)MobCategory.MONSTER).sized(0.6f, 1.95f).eyeHeight(1.74f).passengerAttachments(new float[]{2.0125f}).ridingOffset(-0.7f).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "drowned_host"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Symbiocto_Entity>> SYMBIOCTO = ENTITY_TYPE.register("symbiocto", () -> EntityType.Builder.of(Symbiocto_Entity::new, (MobCategory)MobCategory.MONSTER).sized(1.1f, 0.95f).eyeHeight(0.5f).passengerAttachments(new float[]{2.0125f}).ridingOffset(-0.4f).clientTrackingRange(4).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "symbiocto"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Octo_Ink_Entity>> OCTO_INK = ENTITY_TYPE.register("octo_ink", () -> EntityType.Builder.of(Octo_Ink_Entity::new, (MobCategory)MobCategory.MISC).sized(0.25f, 0.25f).clientTrackingRange(4).updateInterval(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "octo_ink"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Water_Spear_Entity>> WATER_SPEAR = ENTITY_TYPE.register("water_spear", () -> EntityType.Builder.of(Water_Spear_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "water_spear"))));
    public static final DeferredHolder<EntityType<?>, EntityType<Lightning_Spear_Entity>> LIGHTNING_SPEAR = ENTITY_TYPE.register("lightning_spear", () -> EntityType.Builder.of(Lightning_Spear_Entity::new, (MobCategory)MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(10).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath("cataclysm", "lightning_spear"))));

    public static Predicate<LivingEntity> buildPredicateFromTag(TagKey<EntityType<?>> entityTag) {
        if (entityTag == null) {
            return Predicates.alwaysFalse();
        }
        return e -> e.isAlive() && e.getType().builtInRegistryHolder().is(entityTag);
    }

    public static boolean rollSpawn(int rolls, RandomSource random, EntitySpawnReason reason) {
        if (EntitySpawnReason.isSpawner((EntitySpawnReason)reason)) {
            return true;
        }
        return rolls <= 0 || random.nextInt(rolls) == 0;
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register((EntityType)ENDERMAPTERA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Endermaptera_Entity::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)KOBOLETON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Koboleton_Entity::checkKoboletonSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)DEEPLING_ANGLER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deepling_Angler_Entity::candeeplingSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)DEEPLING.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deepling_Entity::candeeplingSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)DEEPLING_BRUTE.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deepling_Brute_Entity::candeeplingSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)DEEPLING_WARLOCK.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deepling_Warlock_Entity::candeeplingSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)DEEPLING_PRIEST.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deepling_Priest_Entity::candeeplingSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)CORAL_GOLEM.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Coral_Golem_Entity::cangolemSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)AMETHYST_CRAB.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Amethyst_Crab_Entity::canCrabSpawnSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register((EntityType)IGNITED_BERSERKER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void initializeAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)ENDER_GOLEM.get(), Ender_Golem_Entity.ender_golem().build());
        event.put((EntityType)NETHERITE_MINISTROSITY.get(), Netherite_Ministrosity_Entity.ministrosity().build());
        event.put((EntityType)NETHERITE_MONSTROSITY.get(), Netherite_Monstrosity_Entity.netherite_monstrosity().build());
        event.put((EntityType)IGNIS.get(), Ignis_Entity.ignis().build());
        event.put((EntityType)ENDER_GUARDIAN.get(), Ender_Guardian_Entity.ender_guardian().build());
        event.put((EntityType)ENDERMAPTERA.get(), Endermaptera_Entity.endermaptera().build());
        event.put((EntityType)IGNITED_REVENANT.get(), Ignited_Revenant_Entity.ignited_revenant().build());
        event.put((EntityType)IGNITED_BERSERKER.get(), Ignited_Berserker_Entity.ignited_berserker().build());
        event.put((EntityType)THE_HARBINGER.get(), The_Harbinger_Entity.harbinger().build());
        event.put((EntityType)THE_LEVIATHAN.get(), The_Leviathan_Entity.leviathan().build());
        event.put((EntityType)THE_BABY_LEVIATHAN.get(), The_Baby_Leviathan_Entity.babyleviathan().build());
        event.put((EntityType)DEEPLING.get(), Deepling_Entity.deepling().build());
        event.put((EntityType)DEEPLING_BRUTE.get(), Deepling_Brute_Entity.deeplingbrute().build());
        event.put((EntityType)DEEPLING_ANGLER.get(), Deepling_Angler_Entity.deepling().build());
        event.put((EntityType)DEEPLING_PRIEST.get(), Deepling_Priest_Entity.deeplingpriest().build());
        event.put((EntityType)DEEPLING_WARLOCK.get(), Deepling_Warlock_Entity.deeplingwarlock().build());
        event.put((EntityType)CORAL_GOLEM.get(), Coral_Golem_Entity.coralgolem().build());
        event.put((EntityType)CORALSSUS.get(), Coralssus_Entity.coralssus().build());
        event.put((EntityType)LIONFISH.get(), Lionfish_Entity.lionfish().build());
        event.put((EntityType)AMETHYST_CRAB.get(), Amethyst_Crab_Entity.amethyst_crab().build());
        event.put((EntityType)MODERN_REMNANT.get(), Modern_Remnant_Entity.modernremnant().build());
        event.put((EntityType)KOBOLETON.get(), Koboleton_Entity.koboleton().build());
        event.put((EntityType)THE_WATCHER.get(), The_Watcher_Entity.the_watcher().build());
        event.put((EntityType)THE_PROWLER.get(), The_Prowler_Entity.the_prowler().build());
        event.put((EntityType)KOBOLEDIATOR.get(), Kobolediator_Entity.kobolediator().build());
        event.put((EntityType)APTRGANGR.get(), Aptrgangr_Entity.aptrgangr().build());
        event.put((EntityType)WADJET.get(), Wadjet_Entity.wadjet().build());
        event.put((EntityType)MALEDICTUS.get(), Maledictus_Entity.maledictus().build());
        event.put((EntityType)ANCIENT_REMNANT.get(), Ancient_Remnant_Entity.maledictus().build());
        event.put((EntityType)DRAUGR.get(), Draugr_Entity.draugr().build());
        event.put((EntityType)ROYAL_DRAUGR.get(), Royal_Draugr_Entity.royal_draugr().build());
        event.put((EntityType)ELITE_DRAUGR.get(), Elite_Draugr_Entity.elite_draugr().build());
        event.put((EntityType)HIPPOCAMTUS.get(), Hippocamtus_Entity.Hippocamtus_Entity().build());
        event.put((EntityType)URCHINKIN.get(), Urchinkin_Entity.urchin().build());
        event.put((EntityType)CINDARIA.get(), Cindaria_Entity.cindaria().build());
        event.put((EntityType)SCYLLA.get(), Scylla_Entity.scylla().build());
        event.put((EntityType)CLAWDIAN.get(), Clawdian_Entity.clawdian().build());
        event.put((EntityType)DROWNED_HOST.get(), Drowned_Host_Entity.createAttributes().build());
        event.put((EntityType)SYMBIOCTO.get(), Symbiocto_Entity.octo().build());
    }
}

