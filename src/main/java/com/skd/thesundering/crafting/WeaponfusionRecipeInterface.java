/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.level.ItemLike
 */
package com.skd.thesundering.crafting;

import com.skd.thesundering.crafting.WeaponfusionRecipeInput;
import com.skd.thesundering.init.ModBlocks;
import com.skd.thesundering.init.ModRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;

public interface WeaponfusionRecipeInterface
extends Recipe<WeaponfusionRecipeInput> {
    default public RecipeType<?> getType() {
        return (RecipeType)ModRecipeTypes.WEAPON_FUSION.get();
    }

    default public boolean canCraftInDimensions(int p_44528_, int p_44529_) {
        return p_44528_ * p_44529_ >= 2;
    }

    default public ItemStack getToastSymbol() {
        return new ItemStack((ItemLike)ModBlocks.MECHANICAL_FUSION_ANVIL.get());
    }

    public boolean isBaseIngredient(ItemStack var1);

    public boolean isAdditionIngredient(ItemStack var1);
}

