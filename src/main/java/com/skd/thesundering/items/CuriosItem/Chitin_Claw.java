/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  top.theillusivec4.curios.api.SlotContext
 *  top.theillusivec4.curios.api.type.capability.ICurio$SoundInfo
 */
package com.skd.thesundering.items.CuriosItem;

import com.skd.thesundering.items.CuriosItem.CuriosItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class Chitin_Claw
extends CuriosItem {
    public Chitin_Claw(Item.Properties group) {
        super(group);
    }

    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo((SoundEvent)SoundEvents.ARMOR_EQUIP_NETHERITE.value(), 1.0f, 1.0f);
    }
}

