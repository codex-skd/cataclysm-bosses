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
package com.skd.sundering.blockentities;

import com.skd.sundering.blocks.Altar_Of_Amethyst_Block;
import com.skd.sundering.crafting.AltarOfAmethystRecipe;
import com.skd.sundering.init.ModRecipeTypes;
import com.skd.sundering.init.ModTileentites;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class AltarOfAmethyst_Block_Entity
extends BlockEntity {
    private final ItemStackHandler inventory = this.createHandler();
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
            ItemStack resultStack = ((AltarOfAmethystRecipe)recipe.get().value()).assemble(new SingleRecipeInput(cookingStack), (HolderLookup.Provider)level.registryAccess());
            Containers.dropItemStack((Level)level, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (ItemStack)resultStack.copy());
            this.cookingTime = 0;
            this.inventory.extractItem(0, 1, false);
        }
    }

    public boolean isCooking() {
        return this.hasStoredStack();
    }

    private Optional<RecipeHolder<AltarOfAmethystRecipe>> getMatchingRecipe(ItemStack stack) {
        if (this.level == null) {
            return Optional.empty();
        }
        return this.quickCheck.getRecipeFor((RecipeInput)new SingleRecipeInput(stack), this.level);
    }

    public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.loadAdditional(compound, registries);
        this.inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
        this.cookingTime = compound.getInt("CookTime");
        this.cookingTimeTotal = compound.getInt("CookTimeTotal");
    }

    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        compound.put("Inventory", (Tag)this.inventory.serializeNBT(registries));
        compound.putInt("CookTime", this.cookingTime);
        compound.putInt("CookTimeTotal", this.cookingTimeTotal);
    }

    public ItemStack addItemToCook(ItemStack addedStack, Player player) {
        ItemStack remainderStack;
        Optional<RecipeHolder<AltarOfAmethystRecipe>> recipe = this.getMatchingRecipe(addedStack);
        if (recipe.isPresent() && this.getStoredStack().isEmpty() && !ItemStack.matches((ItemStack)(remainderStack = this.inventory.insertItem(0, addedStack.copy(), false)), (ItemStack)addedStack)) {
            this.cookingTimeTotal = Altar_Of_Amethyst_Block.getCookingTime(((AltarOfAmethystRecipe)recipe.get().value()).getTime());
            this.cookingTime = 0;
            return remainderStack;
        }
        return addedStack;
    }

    public ItemStack removeItem() {
        return this.inventory.extractItem(0, this.getStoredStack().getMaxStackSize(), false);
    }

    public IItemHandler getInventory() {
        return this.inventory;
    }

    public ItemStack getStoredStack() {
        return this.inventory.getStackInSlot(0);
    }

    public boolean hasStoredStack() {
        return !this.getStoredStack().isEmpty();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(){

            protected void onContentsChanged(int slot) {
                AltarOfAmethyst_Block_Entity.this.inventoryChanged();
            }
        };
    }

    public void setRemoved() {
        super.setRemoved();
    }

    @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create((BlockEntity)this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    protected void inventoryChanged() {
        super.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
        }
    }
}

