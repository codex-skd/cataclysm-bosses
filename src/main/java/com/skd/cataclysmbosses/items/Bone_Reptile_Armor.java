/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.equipment.ArmorMaterial$Layer
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.items.Cataclysm_Armor;
import com.skd.cataclysmbosses.items.CuriosItem.AttributeContainer;
import javax.annotation.Nonnull;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Bone_Reptile_Armor
extends Cataclysm_Armor {
    public Bone_Reptile_Armor(Holder<ArmorMaterial> material, ArmorItem.Type slot, Item.Properties properties) {
        super(material, slot, properties, new AttributeContainer[0]);
    }

    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/armor/bone_reptile_armor.png");
    }
}

