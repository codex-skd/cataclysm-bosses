package com.skd.cataclysmbosses.items;

import com.google.common.collect.Maps;
import com.skd.cataclysmbosses.init.ModItems;
import java.util.Map;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Armortier {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, "cataclysm");

    private static Map<ArmorType, Integer> defense(int boots, int leggings, int chestplate, int helmet, int body) {
        return Maps.newEnumMap(Map.of(
            ArmorType.BOOTS, boots,
            ArmorType.LEGGINGS, leggings,
            ArmorType.CHESTPLATE, chestplate,
            ArmorType.HELMET, helmet,
            ArmorType.BODY, body));
    }

    private static TagKey<net.minecraft.world.item.Item> repairs(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("cataclysm", name));
    }

    private static ResourceKey<EquipmentAsset> asset(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath("cataclysm", name));
    }

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> IGNITIUM = ARMOR_MATERIALS.register("ignitium", () -> new ArmorMaterial(
        45, defense(6, 9, 11, 6, 15), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.15F,
        repairs("repairs_ignitium_armor"), asset("ignitium")));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CURSIUM = ARMOR_MATERIALS.register("cursium", () -> new ArmorMaterial(
        45, defense(5, 8, 10, 5, 13), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.05F,
        repairs("repairs_cursium_armor"), asset("cursium")));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CRAB = ARMOR_MATERIALS.register("crab", () -> new ArmorMaterial(
        30, defense(4, 7, 9, 4, 13), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.1F,
        repairs("repairs_crab_armor"), asset("crab")));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BONE_REPTILE = ARMOR_MATERIALS.register("bone_reptile", () -> new ArmorMaterial(
        35, defense(4, 7, 11, 6, 13), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.25F,
        repairs("repairs_bone_reptile_armor"), asset("bone_reptile")));
}
