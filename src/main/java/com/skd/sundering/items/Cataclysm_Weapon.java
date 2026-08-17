/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.EquipmentSlotGroup
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.component.ItemAttributeModifiers
 *  net.minecraft.world.item.component.ItemAttributeModifiers$Builder
 */
package com.skd.sundering.items;

import com.skd.sundering.items.CuriosItem.AttributeContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class Cataclysm_Weapon
extends Item {
    public Cataclysm_Weapon(Item.Properties group) {
        super(group);
    }

    public static ItemAttributeModifiers createAttributes(int attackDamage, float attackSpeed) {
        return Cataclysm_Weapon.createAttributes(attackDamage, attackSpeed, new AttributeContainer[0]);
    }

    public static ItemAttributeModifiers createAttributes(float p_331976_, float p_332104_, AttributeContainer ... attributes) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        builder.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)p_331976_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        builder.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        for (AttributeContainer holder : attributes) {
            AttributeModifier modifier = holder.createModifier(EquipmentSlot.MAINHAND.getName());
            if (modifier.amount() == 0.0) continue;
            builder.add(holder.attribute(), modifier, EquipmentSlotGroup.MAINHAND);
        }
        return builder.build();
    }
}

