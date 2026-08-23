/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.IModPlugin
 *  mezz.jei.api.JeiPlugin
 *  mezz.jei.api.recipe.RecipeType
 *  mezz.jei.api.recipe.category.IRecipeCategory
 *  mezz.jei.api.registration.IRecipeCatalystRegistration
 *  mezz.jei.api.registration.IRecipeCategoryRegistration
 *  mezz.jei.api.registration.IRecipeRegistration
 *  mezz.jei.api.registration.IRecipeTransferRegistration
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 */
package com.skd.cataclysmbosses.jei;

import com.skd.cataclysmbosses.crafting.AltarOfAmethystRecipe;
import com.skd.cataclysmbosses.crafting.WeaponfusionRecipe;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModMenu;
import com.skd.cataclysmbosses.inventory.WeaponfusionMenu;
import com.skd.cataclysmbosses.jei.AltarOfAmethystRecipeCategory;
import com.skd.cataclysmbosses.jei.CMRecipes;
import com.skd.cataclysmbosses.jei.WeaponfusionRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

@JeiPlugin
public class LEnderCataclysmJEIPlugin
implements IModPlugin {
    public static final Identifier MOD = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"jei_plugin");
    public static final RecipeType<WeaponfusionRecipe> WEAPON_FUSION = RecipeType.create((String)"cataclysm", (String)"weapon_infusion", WeaponfusionRecipe.class);
    public static final RecipeType<AltarOfAmethystRecipe> ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE = RecipeType.create((String)"cataclysm", (String)"altar_of_amethyst", AltarOfAmethystRecipe.class);

    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new IRecipeCategory[]{new WeaponfusionRecipeCategory(registry.getJeiHelpers().getGuiHelper())});
        registry.addRecipeCategories(new IRecipeCategory[]{new AltarOfAmethystRecipeCategory(registry.getJeiHelpers().getGuiHelper())});
    }

    public Identifier getPluginUid() {
        return MOD;
    }

    public void registerRecipes(IRecipeRegistration registration) {
        CMRecipes modRecipes = new CMRecipes();
        registration.addRecipes(WEAPON_FUSION, modRecipes.getWeaponfusionRecipes());
        registration.addRecipes(ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE, modRecipes.getAmethystBlessRecipes());
    }

    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(WeaponfusionMenu.class, (MenuType)ModMenu.WEAPON_FUSION.get(), WEAPON_FUSION, 0, 6, 9, 36);
    }

    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack((ItemLike)ModBlocks.MECHANICAL_FUSION_ANVIL.get()), new RecipeType[]{WEAPON_FUSION});
        registration.addRecipeCatalyst(new ItemStack((ItemLike)ModBlocks.ALTAR_OF_AMETHYST.get()), new RecipeType[]{ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE});
    }
}

