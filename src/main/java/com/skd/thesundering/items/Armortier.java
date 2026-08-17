/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Util
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.equipment.ArmorMaterial$Layer
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.thesundering.items;

import com.skd.thesundering.init.ModItems;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Armortier {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create((ResourceKey)Registries.ARMOR_MATERIAL, (String)"cataclysm");
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> IGNITIUM = ARMOR_MATERIALS.register("ignitium", () -> new ArmorMaterial((Map)Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 6);
        map.put(ArmorItem.Type.LEGGINGS, 9);
        map.put(ArmorItem.Type.CHESTPLATE, 11);
        map.put(ArmorItem.Type.HELMET, 6);
        map.put(ArmorItem.Type.BODY, 15);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.IGNITIUM_INGOT.get()}), List.of(new ArmorMaterial.Layer(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ignitium"))), 4.0f, 0.15f));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CURSIUM = ARMOR_MATERIALS.register("cursium", () -> new ArmorMaterial((Map)Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 5);
        map.put(ArmorItem.Type.LEGGINGS, 8);
        map.put(ArmorItem.Type.CHESTPLATE, 10);
        map.put(ArmorItem.Type.HELMET, 5);
        map.put(ArmorItem.Type.BODY, 13);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.CURSIUM_INGOT.get()}), List.of(new ArmorMaterial.Layer(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursium"))), 4.0f, 0.05f));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CRAB = ARMOR_MATERIALS.register("crab", () -> new ArmorMaterial((Map)Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
        map.put(ArmorItem.Type.BODY, 13);
    }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.AMETHYST_CRAB_SHELL.get()}), List.of(new ArmorMaterial.Layer(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"crab"))), 2.0f, 0.1f));
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BONE_REPTILE = ARMOR_MATERIALS.register("bone_reptile", () -> new ArmorMaterial((Map)Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 11);
        map.put(ArmorItem.Type.HELMET, 6);
        map.put(ArmorItem.Type.BODY, 13);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.ANCIENT_METAL_INGOT.get()}), List.of(new ArmorMaterial.Layer(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"bone_reptile"))), 2.5f, 0.25f));
}

