/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
 *  net.minecraft.world.Containers
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.RecipeHolder
 *  net.minecraft.world.item.crafting.RecipeInput
 *  net.minecraft.world.item.crafting.RecipeManager
 *  net.minecraft.world.item.crafting.RecipeManager$CachedCheck
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.item.crafting.SingleRecipeInput
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.neoforge.items.IItemHandler
 *  net.neoforged.neoforge.items.ItemStackHandler
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.blocks.Altar_Of_Amethyst_Block;
import com.skd.cataclysmbosses.crafting.AltarOfAmethystRecipe;
import com.skd.cataclysmbosses.init.ModRecipeTypes;
import com.skd.cataclysmbosses.init.ModTileentites;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.items.IItemHandler;

public class AltarOfAmethyst_Block_Entity
extends BlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private int cookingTime;
    private int cookingTimeTotal;
    private final RecipeManager.CachedCheck<SingleRecipeInput, AltarOfAmethystRecipe> quickCheck = RecipeManager.createCheck((RecipeType)((RecipeType)ModRecipeTypes.AMETHYST_BLESS.get()));

    public AltarOfAmethyst_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.ALTAR_OF_AMETHYST.get(), pos, state);
    }

    public static void cookingTick(Level level, BlockPos pos, BlockState state, AltarOfAmethyst_Block_Entity skillet) {
        ItemStack cookingStack = skillet.getStoredStack();
        if (cookingStack.isEmpty()) {
            skillet.cookingTime = 0;
        } else {
            skillet.cookAndOutputItems(cookingStack, level, pos);
        }
    }

    private void cookAndOutputItems(ItemStack cookingStack, Level level, BlockPos pos) {
        Optional<RecipeHolder<AltarOfAmethystRecipe>> recipe;
        ++this.cookingTime;
        if (this.cookingTime >= this.cookingTimeTotal && (recipe = this.getMatchingRecipe(cookingStack)).isPresent()) {
            ItemStack resultStack = ((AltarOfAmethystRecipe)recipe.get().value()).assemble(new SingleRecipeInput(cookingStack));
            Containers.dropItemStack((Level)level, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (ItemStack)resultStack.copy());
            this.cookingTime = 0;
            this.items.set(0, ItemStack.EMPTY);
        }
    }

    public boolean isCooking() {
        return this.hasStoredStack();
    }

    private Optional<RecipeHolder<AltarOfAmethystRecipe>> getMatchingRecipe(ItemStack stack) {
        if (this.level == null || !(this.level instanceof ServerLevel)) {
            return Optional.empty();
        }
        return this.quickCheck.getRecipeFor(new SingleRecipeInput(stack), (ServerLevel) this.level);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.items.clear();
        ContainerHelper.loadAllItems(input, this.items);
        this.cookingTime = input.getIntOr("CookTime", 0);
        this.cookingTimeTotal = input.getIntOr("CookTimeTotal", 0);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, this.items, true);
        output.putInt("CookTime", this.cookingTime);
        output.putInt("CookTimeTotal", this.cookingTimeTotal);
    }

    public ItemStack addItemToCook(ItemStack addedStack, Player player) {
        ItemStack remainderStack;
        Optional<RecipeHolder<AltarOfAmethystRecipe>> recipe = this.getMatchingRecipe(addedStack);
        if (recipe.isPresent() && this.getStoredStack().isEmpty() && !ItemStack.matches((ItemStack)(remainderStack = this.insertItem(0, addedStack.copy(), false)), (ItemStack)addedStack)) {
            this.cookingTimeTotal = 200; // Default cooking time
            this.cookingTime = 0;
            return remainderStack;
        }
        return addedStack;
    }

    private ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        ItemStack existing = this.items.get(slot);
        if (existing.isEmpty()) {
            if (!simulate) {
                this.items.set(slot, stack);
            }
            return ItemStack.EMPTY;
        }
        if (!ItemStack.matches(existing, stack)) {
            return stack;
        }
        int maxSize = Math.min(stack.getMaxStackSize(), existing.getMaxStackSize());
        int space = maxSize - existing.getCount();
        if (space <= 0) {
            return stack;
        }
        int toAdd = Math.min(space, stack.getCount());
        if (!simulate) {
            existing.grow(toAdd);
        }
        stack.shrink(toAdd);
        return stack;
    }

    public ItemStack removeItem() {
        ItemStack stack = this.items.get(0);
        this.items.set(0, ItemStack.EMPTY);
        return stack;
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public ItemStack getStoredStack() {
        return this.items.get(0);
    }

    public boolean hasStoredStack() {
        return !this.getStoredStack().isEmpty();
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.items));
    }

    @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create((BlockEntity)this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag compoundtag = new CompoundTag();
        // Legacy serialization for compatibility
        return compoundtag;
    }

    protected void inventoryChanged() {
        super.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
        }
    }
}