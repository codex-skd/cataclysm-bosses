/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.world.item.crafting.RecipeHolder
 *  net.minecraft.world.item.crafting.RecipeManager
 *  net.minecraft.world.item.crafting.RecipeType
 */
package com.skd.thesundering.jei;

import com.skd.thesundering.crafting.AltarOfAmethystRecipe;
import com.skd.thesundering.crafting.WeaponfusionRecipe;
import com.skd.thesundering.init.ModRecipeTypes;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;

public class CMRecipes {
    private final RecipeManager recipeManager;

    public CMRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null) {
            throw new NullPointerException("minecraft world must not be null.");
        }
        this.recipeManager = level.getRecipeManager();
    }

    public List<WeaponfusionRecipe> getWeaponfusionRecipes() {
        return this.recipeManager.getAllRecipesFor((RecipeType)ModRecipeTypes.WEAPON_FUSION.get()).stream().map(RecipeHolder::value).toList();
    }

    public List<AltarOfAmethystRecipe> getAmethystBlessRecipes() {
        return this.recipeManager.getAllRecipesFor((RecipeType)ModRecipeTypes.AMETHYST_BLESS.get()).stream().map(RecipeHolder::value).toList();
    }
}

