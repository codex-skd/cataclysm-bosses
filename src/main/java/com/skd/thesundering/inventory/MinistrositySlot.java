/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.Container
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.thesundering.inventory;

import com.skd.thesundering.init.ModTag;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MinistrositySlot
extends Slot {
    public MinistrositySlot(Container p_40223_, int p_40224_, int p_40225_, int p_40226_) {
        super(p_40223_, p_40224_, p_40225_, p_40226_);
    }

    public boolean mayPlace(ItemStack stack) {
        return !stack.is(ModTag.MINISTROSITY_BLACKLIST);
    }
}

