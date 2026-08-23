/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.CreativeModeTab$Output
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.block.Block
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.util.CustomTabBehavior;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockItemInventoryOnly
extends BlockItem
implements CustomTabBehavior {
    public BlockItemInventoryOnly(Block p_40565_, Item.Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public void fillItemCategory(CreativeModeTab.Output contents) {
    }
}

