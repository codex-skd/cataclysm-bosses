/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ShieldItem
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.init.ModItems;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class Black_Steel_Targe
extends ShieldItem {
    public Black_Steel_Targe(Item.Properties properties) {
        super(properties);
    }

    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is((Item)ModItems.BLACK_STEEL_INGOT.get()) || !repair.is(ItemTags.PLANKS) && super.isValidRepairItem(toRepair, repair);
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
    }
}

