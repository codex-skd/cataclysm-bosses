package com.skd.cataclysmbosses.crafting;

import com.skd.cataclysmbosses.init.ModRecipeSerializers;
import com.skd.cataclysmbosses.init.ModRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class AltarOfAmethystRecipe implements Recipe<SingleRecipeInput> {
    private final Ingredient ingredient;
    private final ItemStack result;
    private final int time;
    private PlacementInfo placementInfo;

    public AltarOfAmethystRecipe(Ingredient ingredients, ItemStack result, int time) {
        this.ingredient = ingredients;
        this.result = result;
        this.time = time;
    }

    public boolean matches(SingleRecipeInput input, Level level) {
        return this.ingredient.test(input.item());
    }

    public ItemStack assemble(SingleRecipeInput input) {
        return this.result.copy();
    }

    public boolean showNotification() {
        return true;
    }

    public String group() {
        return "";
    }

    public PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(this.ingredient);
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

    public int getTime() {
        return this.time;
    }

    public RecipeType<AltarOfAmethystRecipe> getType() {
        return ModRecipeTypes.AMETHYST_BLESS.get();
    }

    public RecipeSerializer<AltarOfAmethystRecipe> getSerializer() {
        return ModRecipeSerializers.AMETHYST_BLESS.get();
    }

    public static class Serializer implements RecipeSerializer<AltarOfAmethystRecipe> {
        private static final MapCodec<AltarOfAmethystRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                Codec.INT.optionalFieldOf("time", 200).forGetter(recipe -> recipe.time)
        ).apply(i, AltarOfAmethystRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, AltarOfAmethystRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public MapCodec<AltarOfAmethystRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, AltarOfAmethystRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static AltarOfAmethystRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buf);
            int time = buf.readVarInt();
            return new AltarOfAmethystRecipe(ingredient, itemstack, time);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buf, AltarOfAmethystRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredient);
            ItemStack.STREAM_CODEC.encode(buf, recipe.result);
            buf.writeVarInt(recipe.time);
        }
    }
}
