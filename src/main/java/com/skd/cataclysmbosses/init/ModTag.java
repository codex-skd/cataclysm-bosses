/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.levelgen.structure.Structure
 */
package com.skd.cataclysmbosses.init;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class ModTag {
    public static final TagKey<Block> NETHERITE_MONSTROSITY_IMMUNE = ModTag.registerBlockTag("netherite_monstrosity_immune");
    public static final TagKey<EntityType<?>> TRAP_BLOCK_NOT_DETECTED = ModTag.registerEntityTag("trap_block_not_detected");
    public static final TagKey<EntityType<?>> SANDSTONE_TRAP_NOT_DETECTED = ModTag.registerEntityTag("sandstone_trap_not_detected");
    public static final TagKey<EntityType<?>> IGNIS_CANT_POKE = ModTag.registerEntityTag("ignis_cant_poke");
    public static final TagKey<EntityType<?>> LAVA_MONSTER = ModTag.registerEntityTag("lava_monster");
    public static final TagKey<EntityType<?>> LEVIATHAN_TARGET = ModTag.registerEntityTag("leviathan_target");
    public static final TagKey<EntityType<?>> BABY_LEVIATHAN_TARGET = ModTag.registerEntityTag("baby_leviathan_target");
    public static final TagKey<EntityType<?>> ANCIENT_REMNANT_TARGET = ModTag.registerEntityTag("ancient_remnant_target");
    public static final TagKey<EntityType<?>> MODERN_REMNANT_TARGET = ModTag.registerEntityTag("modern_remnant_target");
    public static final TagKey<EntityType<?>> TEAM_ANCIENT_REMNANT = ModTag.registerEntityTag("team_ancient_remnant");
    public static final TagKey<EntityType<?>> TEAM_ENDER_GUARDIAN = ModTag.registerEntityTag("team_ender_guardian");
    public static final TagKey<EntityType<?>> TEAM_IGNIS = ModTag.registerEntityTag("team_ignis");
    public static final TagKey<EntityType<?>> TEAM_THE_HARBINGER = ModTag.registerEntityTag("team_the_harbinger");
    public static final TagKey<EntityType<?>> TEAM_THE_LEVIATHAN = ModTag.registerEntityTag("team_the_leviathan");
    public static final TagKey<EntityType<?>> TEAM_MONSTROSITY = ModTag.registerEntityTag("team_monstrosity");
    public static final TagKey<EntityType<?>> TEAM_SCYLLA = ModTag.registerEntityTag("team_scylla");
    public static final TagKey<EntityType<?>> DIMENSIONAL_LIFT_IMMUNE = ModTag.registerEntityTag("dimensional_lift_immune");
    public static final TagKey<EntityType<?>> TEAM_MALEDICTUS = ModTag.registerEntityTag("team_maledictus");
    public static final TagKey<EntityType<?>> ELEMENTAL = ModTag.registerEntityTag("elemental");
    public static final TagKey<DamageType> BYPASSES_HURT_TIME = ModTag.registerDamageTypeTag("bypasses_hurt_time");
    public static final TagKey<DamageType> BLOCK_SELF_REGEN = ModTag.registerDamageTypeTag("block_self_regen");
    public static final TagKey<Block> ENDER_GOLEM_CAN_DESTROY = ModTag.registerBlockTag("ender_golem_can_destroy");
    public static final TagKey<Block> CM_GLASS = ModTag.registerBlockTag("cm_glass");
    public static final TagKey<Block> ENDER_GUARDIAN_CAN_DESTROY = ModTag.registerBlockTag("ender_guardian_can_destroy");
    public static final TagKey<Block> ALTAR_DESTROY_IMMUNE = ModTag.registerBlockTag("altar_destroy_immune");
    public static final TagKey<Block> IGNIS_CAN_DESTROY_CRACKED_BLOCK = ModTag.registerBlockTag("ignis_can_destroy_cracked_block");
    public static final TagKey<Block> IGNIS_IMMUNE = ModTag.registerBlockTag("ignis_immune");
    public static final TagKey<Block> HARBINGER_IMMUNE = ModTag.registerBlockTag("harbinger_immune");
    public static final TagKey<Block> LEVIATHAN_IMMUNE = ModTag.registerBlockTag("leviathan_immune");
    public static final TagKey<Block> REMNANT_IMMUNE = ModTag.registerBlockTag("remnant_immune");
    public static final TagKey<Block> MALEDICTUS_IMMUNE = ModTag.registerBlockTag("maledictus_immune");
    public static final TagKey<Block> SCYLLA_IMMUNE = ModTag.registerBlockTag("scylla_immune");
    public static final TagKey<Block> CLAWDIAN_IMMUNE = ModTag.registerBlockTag("clawdian_immune");
    public static final TagKey<Block> FROSTED_PRISON_CHANDELIER = ModTag.registerBlockTag("frosted_prison_chandelier");
    public static final TagKey<Block> CORALSSUS_BREAK = ModTag.registerBlockTag("coralssus_break");
    public static final TagKey<Block> ENDERMAPTERA_CAN_NOT_SPAWN = ModTag.registerBlockTag("endermaptera_can_not_spawn");
    public static final TagKey<Block> NETHERITE_MONSTROSITY_BREAK = ModTag.registerBlockTag("netherite_monstrosity_break");
    public static final TagKey<Block> SUNKEN_CITY_MATERIAL = ModTag.registerBlockTag("sunken_city_material");
    public static final TagKey<Structure> EYE_OF_MECH_LOCATED = ModTag.registerStructureTag("eye_of_mech_located");
    public static final TagKey<Structure> EYE_OF_RUINED_LOCATED = ModTag.registerStructureTag("eye_of_ruined_located");
    public static final TagKey<Structure> EYE_OF_FLAME_LOCATED = ModTag.registerStructureTag("eye_of_flame_located");
    public static final TagKey<Structure> EYE_OF_CURSE_LOCATED = ModTag.registerStructureTag("eye_of_curse_located");
    public static final TagKey<Structure> EYE_OF_MONSTROUS_LOCATED = ModTag.registerStructureTag("eye_of_monstrous_located");
    public static final TagKey<Structure> EYE_OF_ABYSS_LOCATED = ModTag.registerStructureTag("eye_of_abyss_located");
    public static final TagKey<Structure> EYE_OF_DESERT_LOCATED = ModTag.registerStructureTag("eye_of_desert_located");
    public static final TagKey<Structure> EYE_OF_STORM_LOCATED = ModTag.registerStructureTag("eye_of_storm_located");
    public static final TagKey<Structure> BLOCKED_BASALT = ModTag.registerStructureTag("blocked_basalt");
    public static final TagKey<Structure> BLOCKED_LAKE = ModTag.registerStructureTag("blocked_lake");
    public static final TagKey<Structure> BLOCKED_GEODE = ModTag.registerStructureTag("blocked_geode");
    public static final TagKey<Structure> BLOCKED_ORE = ModTag.registerStructureTag("blocked_ore");
    public static final TagKey<Structure> BLOCKED_MULTIFACE = ModTag.registerStructureTag("blocked_multiface");
    public static final TagKey<Structure> BLOCKED_MAGMA_BLOCK = ModTag.registerStructureTag("blocked_magma_block");
    public static final TagKey<Structure> BERSERKER_SPAWN = ModTag.registerStructureTag("berserker_spawn");
    public static final TagKey<Item> EXPLOSION_IMMUNE_ITEM = ModTag.registerItemTag("explosion_immune_item");
    public static final TagKey<Item> STICKY_ITEM = ModTag.registerItemTag("sticky_item");
    public static final TagKey<Item> MINISTROSITY_BLACKLIST = ModTag.registerItemTag("ministrosity_blacklist");
    public static final TagKey<Item> BONE_ITEM = ModTag.registerItemTag("bone_item");
    public static final TagKey<MobEffect> EFFECTIVE_FOR_BOSSES = ModTag.registerEffectTag("effective_for_bosses");
    public static final TagKey<Biome> REQUIRED_SUNKEN_CITY_SURROUNDING = ModTag.registerBiomeTag("required_sunken_city_surrounding");
    public static final TagKey<Biome> DEEPLINGS_SPAWN = ModTag.registerBiomeTag("deeplings_spawn");
    public static final TagKey<Biome> KOBOLETON_SPAWN = ModTag.registerBiomeTag("koboleton_spawn");
    public static final TagKey<Biome> AMETHYST_CRAB_SPAWN = ModTag.registerBiomeTag("amethyst_crab_spawn");

    private static TagKey<EntityType<?>> registerEntityTag(String name) {
        return TagKey.create((ResourceKey)Registries.ENTITY_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create((ResourceKey)Registries.ITEM, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    private static TagKey<MobEffect> registerEffectTag(String name) {
        return TagKey.create((ResourceKey)Registries.MOB_EFFECT, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    private static TagKey<Structure> registerStructureTag(String name) {
        return TagKey.create((ResourceKey)Registries.STRUCTURE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.create((ResourceKey)Registries.BIOME, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    private static TagKey<DamageType> registerDamageTypeTag(String name) {
        return TagKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name));
    }

    public static <T> boolean isInTag(T value, TagKey<T> tagKey) {
        Registry registry = (Registry)BuiltInRegistries.REGISTRY.get(tagKey.registry().location());
        return registry.getOrCreateTag(tagKey).contains((Holder)registry.getHolderOrThrow((ResourceKey)registry.getResourceKey(value).orElseThrow()));
    }
}

