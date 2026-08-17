/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.component.DataComponentPatch$Builder
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.component.ItemAttributeModifiers
 *  net.minecraft.world.item.component.ItemAttributeModifiers$Builder
 *  net.minecraft.world.item.component.ItemAttributeModifiers$Entry
 */
package com.skd.thesundering.util;

import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class AttributeUtils {
    public static void mergeAttributes(DataComponentPatch.Builder builder, Item item, ItemAttributeModifiers newModifiers) {
        ItemAttributeModifiers existingModifiers = (ItemAttributeModifiers)item.components().getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, (Object)ItemAttributeModifiers.EMPTY);
        ItemAttributeModifiers.Builder combinedBuilder = ItemAttributeModifiers.builder();
        for (ItemAttributeModifiers.Entry existingEntry : existingModifiers.modifiers()) {
            boolean shouldReplace = false;
            for (ItemAttributeModifiers.Entry newEntry : newModifiers.modifiers()) {
                if (!existingEntry.attribute().equals((Object)newEntry.attribute()) || !existingEntry.slot().equals((Object)newEntry.slot())) continue;
                shouldReplace = true;
                break;
            }
            if (shouldReplace) continue;
            combinedBuilder.add(existingEntry.attribute(), existingEntry.modifier(), existingEntry.slot());
        }
        for (ItemAttributeModifiers.Entry newEntry : newModifiers.modifiers()) {
            combinedBuilder.add(newEntry.attribute(), newEntry.modifier(), newEntry.slot());
        }
        builder.set(DataComponents.ATTRIBUTE_MODIFIERS, (Object)combinedBuilder.build());
    }

    public static float OriginDamage(LivingEntity living, ItemStack itemStack) {
        double totalDamage = living.getAttributeValue(Attributes.ATTACK_DAMAGE);
        if (living.getMainHandItem() == itemStack) {
            return (float)totalDamage;
        }
        ItemStack mainHandStack = living.getMainHandItem();
        if (!mainHandStack.isEmpty()) {
            ItemAttributeModifiers modifiers = (ItemAttributeModifiers)mainHandStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, (Object)ItemAttributeModifiers.EMPTY);
            for (ItemAttributeModifiers.Entry entry : modifiers.modifiers()) {
                if (!entry.attribute().is(Attributes.ATTACK_DAMAGE) || !entry.slot().test(EquipmentSlot.MAINHAND) || entry.modifier().operation() != AttributeModifier.Operation.ADD_VALUE) continue;
                totalDamage -= entry.modifier().amount();
            }
        }
        ItemAttributeModifiers shredderModifiers = (ItemAttributeModifiers)itemStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, (Object)ItemAttributeModifiers.EMPTY);
        for (ItemAttributeModifiers.Entry entry : shredderModifiers.modifiers()) {
            if (!entry.attribute().is(Attributes.ATTACK_DAMAGE) || !entry.slot().test(EquipmentSlot.MAINHAND) || entry.modifier().operation() != AttributeModifier.Operation.ADD_VALUE) continue;
            totalDamage += entry.modifier().amount();
        }
        return (float)totalDamage;
    }
}

