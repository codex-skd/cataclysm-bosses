/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.cataclysmbosses.client.sound;

import com.skd.cataclysmbosses.client.sound.ItemTickableSound;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MeatShredderSound
extends ItemTickableSound {
    public MeatShredderSound(LivingEntity user) {
        super(user, (SoundEvent)ModSounds.SHREDDER_LOOP.get());
    }

    @Override
    public void tickVolume(ItemStack itemStack) {
        this.volume = 0.4f;
        this.pitch = 1.0f;
    }

    @Override
    public boolean isValidItem(ItemStack itemStack) {
        return itemStack.is((Item)ModItems.MEAT_SHREDDER.get());
    }
}

