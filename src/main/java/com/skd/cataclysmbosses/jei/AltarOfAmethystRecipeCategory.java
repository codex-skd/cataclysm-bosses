/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.gui.builder.IRecipeLayoutBuilder
 *  mezz.jei.api.gui.drawable.IDrawable
 *  mezz.jei.api.helpers.IGuiHelper
 *  mezz.jei.api.recipe.IFocusGroup
 *  mezz.jei.api.recipe.RecipeIngredientRole
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  mezz.jei.library.util.RecipeUtil
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 */
package com.skd.cataclysmbosses.jei;

import com.skd.cataclysmbosses.crafting.AltarOfAmethystRecipe;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.jei.AltarOfAmethystDrawable;
import com.skd.cataclysmbosses.jei.LEnderCataclysmJEIPlugin;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class AltarOfAmethystRecipeCategory
implements IRecipeCategory<AltarOfAmethystRecipe> {
    private final IDrawable background = new AltarOfAmethystDrawable();
    private final IDrawable icon;

    public AltarOfAmethystRecipeCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableItemStack(new ItemStack((ItemLike)ModBlocks.ALTAR_OF_AMETHYST.get()));
    }

    public RecipeType<AltarOfAmethystRecipe> getRecipeType() {
        return LEnderCataclysmJEIPlugin.ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE;
    }

    public Component getTitle() {
        return ((Block)ModBlocks.ALTAR_OF_AMETHYST.get()).getName().append((Component)Component.literal((String)" ")).append((Component)Component.translatable((String)"cataclysm.gui.altar_of_amethyst_blessing"));
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, AltarOfAmethystRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 23).addIngredients((Ingredient)recipe.getIngredients().getFirst());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 23).addItemStack(RecipeUtil.getResultItem((Recipe)recipe));
    }

    public boolean isHandled(AltarOfAmethystRecipe recipe) {
        return true;
    }
}

