/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.crafting.AltarOfAmethystRecipe;
import com.skd.cataclysmbosses.crafting.WeaponfusionRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create((ResourceKey)Registries.RECIPE_TYPE, (String)"cataclysm");
    public static final DeferredHolder<RecipeType<?>, RecipeType<WeaponfusionRecipe>> WEAPON_FUSION = RECIPE_TYPES.register("weapon_fusion", () -> ModRecipeTypes.registerRecipeType("weapon_fusion"));
    public static final DeferredHolder<RecipeType<?>, RecipeType<AltarOfAmethystRecipe>> AMETHYST_BLESS = RECIPE_TYPES.register("amethyst_bless", () -> ModRecipeTypes.registerRecipeType("amethyst_bless"));

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<T>(){

            public String toString() {
                return "cataclysm:" + identifier;
            }
        };
    }
}

