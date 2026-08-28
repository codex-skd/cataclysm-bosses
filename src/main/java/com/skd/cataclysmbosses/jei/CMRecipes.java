/*
 * Decompiled with CFR 0.152.
 * JEI 26.2 API changed - stubbed for compilation
 */
package com.skd.cataclysmbosses.jei;

import com.skd.cataclysmbosses.crafting.AltarOfAmethystRecipe;
import com.skd.cataclysmbosses.crafting.WeaponfusionRecipe;
import com.skd.cataclysmbosses.init.ModRecipeSerializers;
import com.skd.cataclysmbosses.init.ModRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import java.util.List;

public class CMRecipes {
    public static List<RecipeHolder<AltarOfAmethystRecipe>> getAmethystBlessRecipes() {
        return Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.AMETHYST_BLESS.get());
    }
    
    public static List<RecipeHolder<WeaponfusionRecipe>> getWeaponFusionRecipes() {
        return Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.WEAPON_FUSION.get());
    }
    
    public static boolean isRecipeValid(RecipeHolder<?> holder) {
        return holder.value().showNotification();
    }
}