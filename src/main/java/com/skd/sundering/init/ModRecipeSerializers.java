/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.crafting.RecipeSerializer
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.sundering.init;

import com.skd.sundering.crafting.AltarOfAmethystRecipe;
import com.skd.sundering.crafting.WeaponfusionRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create((ResourceKey)Registries.RECIPE_SERIALIZER, (String)"cataclysm");
    public static final DeferredHolder<RecipeSerializer<?>, WeaponfusionRecipe.Serializer> WEAPON_FUSION = RECIPE_SERIALIZERS.register("weapon_fusion", WeaponfusionRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, AltarOfAmethystRecipe.Serializer> AMETHYST_BLESS = RECIPE_SERIALIZERS.register("amethyst_bless", AltarOfAmethystRecipe.Serializer::new);
}

