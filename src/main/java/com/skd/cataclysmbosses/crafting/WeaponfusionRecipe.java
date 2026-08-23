package com.skd.cataclysmbosses.crafting;

import com.skd.cataclysmbosses.init.ModRecipeSerializers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class WeaponfusionRecipe implements WeaponfusionRecipeInterface {
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;
    private PlacementInfo placementInfo;

    public WeaponfusionRecipe(Ingredient base, Ingredient addition, ItemStack result) {
        this.base = base;
        this.addition = addition;
        this.result = result;
    }

    public boolean matches(WeaponfusionRecipeInput input, Level level) {
        return this.base.test(input.base()) && this.addition.test(input.addition());
    }

    public ItemStack assemble(WeaponfusionRecipeInput input) {
        ItemStack itemstack = input.base().transmuteCopy((ItemLike)this.result.getItem(), this.result.getCount());
        itemstack.applyComponents(this.result.getComponentsPatch());
        return itemstack;
    }

    public boolean showNotification() {
        return true;
    }

    public String group() {
        return "";
    }

    public PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(java.util.List.of(this.base, this.addition));
        }
        return this.placementInfo;
    }

    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    // Kept as a plain method (no longer part of the Recipe interface in 26.2) -- the JEI
    // integration (batch 19, not yet ported) still calls this exact signature.
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.result;
    }

    @Override
    public boolean isBaseIngredient(ItemStack stack) {
        return this.base.test(stack);
    }

    public Ingredient getbaseIngredient() {
        return this.base;
    }

    public Ingredient getAdditionIngredient() {
        return this.addition;
    }

    @Override
    public boolean isAdditionIngredient(ItemStack stack) {
        return this.addition.test(stack);
    }

    public RecipeSerializer<WeaponfusionRecipe> getSerializer() {
        return ModRecipeSerializers.WEAPON_FUSION.get();
    }

    public boolean isIncomplete() {
        return Stream.of(this.base, this.addition).anyMatch(Ingredient::hasNoItems);
    }

    public static class Serializer implements RecipeSerializer<WeaponfusionRecipe> {
        private static final MapCodec<WeaponfusionRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Ingredient.CODEC.fieldOf("base").forGetter(recipe -> recipe.base),
                Ingredient.CODEC.fieldOf("addition").forGetter(recipe -> recipe.addition),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
        ).apply(i, WeaponfusionRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, WeaponfusionRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public MapCodec<WeaponfusionRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, WeaponfusionRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static WeaponfusionRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            Ingredient ingredient1 = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            Ingredient ingredient2 = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buf);
            return new WeaponfusionRecipe(ingredient1, ingredient2, itemstack);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buf, WeaponfusionRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.base);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.addition);
            ItemStack.STREAM_CODEC.encode(buf, recipe.result);
        }
    }
}
