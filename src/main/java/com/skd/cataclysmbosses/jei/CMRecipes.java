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
        return java.util.List.of(); // TODO 26.2: client recipe access API changed (Level.getRecipeManager removed)
    }
    
    public static List<RecipeHolder<WeaponfusionRecipe>> getWeaponFusionRecipes() {
        return java.util.List.of(); // TODO 26.2: client recipe access API changed (Level.getRecipeManager removed)
    }
    
    public static boolean isRecipeValid(RecipeHolder<?> holder) {
        return holder.value().showNotification();
    }
}