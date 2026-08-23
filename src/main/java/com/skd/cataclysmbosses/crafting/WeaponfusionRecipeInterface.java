package com.skd.cataclysmbosses.crafting;

import com.skd.cataclysmbosses.init.ModRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface WeaponfusionRecipeInterface extends Recipe<WeaponfusionRecipeInput> {
    default RecipeType<WeaponfusionRecipe> getType() {
        return ModRecipeTypes.WEAPON_FUSION.get();
    }

    boolean isBaseIngredient(ItemStack stack);

    boolean isAdditionIngredient(ItemStack stack);
}
