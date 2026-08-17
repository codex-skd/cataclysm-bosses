/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.NonNullList
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.item.crafting.Recipe
 *  net.minecraft.world.item.crafting.RecipeSerializer
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.item.crafting.SingleRecipeInput
 *  net.minecraft.world.level.Level
 */
package com.skd.sundering.crafting;

import com.skd.sundering.init.ModRecipeSerializers;
import com.skd.sundering.init.ModRecipeTypes;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class AltarOfAmethystRecipe
implements Recipe<SingleRecipeInput> {
    private final Ingredient ingredient;
    private ItemStack result;
    private int time;

    public AltarOfAmethystRecipe(Ingredient ingredients, ItemStack result, int time) {
        this.ingredient = ingredients;
        this.result = result;
        this.time = time;
    }

    public boolean matches(SingleRecipeInput p_344849_, Level p_345973_) {
        return this.ingredient.test(p_344849_.item());
    }

    public ItemStack assemble(SingleRecipeInput p_344838_, HolderLookup.Provider p_336115_) {
        return this.result.copy();
    }

    public boolean canCraftInDimensions(int p_43743_, int p_43744_) {
        return true;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList nonnulllist = NonNullList.create();
        nonnulllist.add((Object)this.ingredient);
        return nonnulllist;
    }

    public ItemStack getResultItem(HolderLookup.Provider p_336110_) {
        return this.result;
    }

    public int getTime() {
        return this.time;
    }

    public RecipeType<?> getType() {
        return (RecipeType)ModRecipeTypes.AMETHYST_BLESS.get();
    }

    public RecipeSerializer<?> getSerializer() {
        return (RecipeSerializer)ModRecipeSerializers.AMETHYST_BLESS.get();
    }

    public static class Serializer
    implements RecipeSerializer<AltarOfAmethystRecipe> {
        private static final MapCodec<AltarOfAmethystRecipe> CODEC = RecordCodecBuilder.mapCodec(p_340782_ -> p_340782_.group((App)Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_300833_ -> p_300833_.ingredient), (App)ItemStack.CODEC.fieldOf("result").forGetter(p_300827_ -> p_300827_.result), (App)Codec.INT.fieldOf("time").orElse((Object)200).forGetter(p_300834_ -> p_300834_.time)).apply((Applicative)p_340782_, AltarOfAmethystRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, AltarOfAmethystRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public MapCodec<AltarOfAmethystRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, AltarOfAmethystRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static AltarOfAmethystRecipe fromNetwork(RegistryFriendlyByteBuf p_320375_) {
            Ingredient ingredient1 = (Ingredient)Ingredient.CONTENTS_STREAM_CODEC.decode((Object)p_320375_);
            ItemStack itemstack = (ItemStack)ItemStack.STREAM_CODEC.decode((Object)p_320375_);
            int i = p_320375_.readVarInt();
            return new AltarOfAmethystRecipe(ingredient1, itemstack, i);
        }

        private static void toNetwork(RegistryFriendlyByteBuf p_320743_, AltarOfAmethystRecipe p_319840_) {
            Ingredient.CONTENTS_STREAM_CODEC.encode((Object)p_320743_, (Object)p_319840_.ingredient);
            ItemStack.STREAM_CODEC.encode((Object)p_320743_, (Object)p_319840_.result);
            p_320743_.writeVarInt(p_319840_.time);
        }
    }
}

