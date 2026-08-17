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
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.RegistryAccess
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.block.Block
 */
package com.skd.thesundering.jei;

import com.skd.thesundering.crafting.WeaponfusionRecipe;
import com.skd.thesundering.init.ModBlocks;
import com.skd.thesundering.jei.LEnderCataclysmJEIPlugin;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class WeaponfusionRecipeCategory
implements IRecipeCategory<WeaponfusionRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/fusion.png");

    public WeaponfusionRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 26, 46, 125, 18);
        this.icon = guiHelper.createDrawableItemStack(new ItemStack((ItemLike)ModBlocks.MECHANICAL_FUSION_ANVIL.get()));
    }

    public RecipeType<WeaponfusionRecipe> getRecipeType() {
        return LEnderCataclysmJEIPlugin.WEAPON_FUSION;
    }

    public Component getTitle() {
        return ((Block)ModBlocks.MECHANICAL_FUSION_ANVIL.get()).getName();
    }

    public IDrawable getBackground() {
        return this.background;
    }

    public IDrawable getIcon() {
        return this.icon;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, WeaponfusionRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.getbaseIngredient());
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 1).addIngredients(recipe.getAdditionIngredient());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 1).addItemStack(recipe.getResultItem((HolderLookup.Provider)RegistryAccess.EMPTY));
    }

    public boolean isHandled(WeaponfusionRecipe recipe) {
        return !recipe.isSpecial();
    }
}

