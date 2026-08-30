/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.inventory.ContainerLevelAccess
 *  net.minecraft.world.inventory.ItemCombinerMenu
 *  net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition
 *  net.minecraft.world.inventory.MenuType
 *  net.minecraft.world.inventory.Slot
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.crafting.RecipeHolder
 *  net.minecraft.world.item.crafting.RecipeInput
 *  net.minecraft.world.item.crafting.RecipeType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.skd.cataclysmbosses.inventory;

import com.skd.cataclysmbosses.crafting.WeaponfusionRecipe;
import com.skd.cataclysmbosses.crafting.WeaponfusionRecipeInput;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModMenu;
import com.skd.cataclysmbosses.init.ModRecipeTypes;
import java.util.List;
import java.util.OptionalInt;
import javax.annotation.Nullable;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class WeaponfusionMenu
extends ItemCombinerMenu {
    private final Level level;
    @Nullable
    private RecipeHolder<WeaponfusionRecipe> selectedRecipe;
    private final List<RecipeHolder<WeaponfusionRecipe>> recipes;

    public WeaponfusionMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public WeaponfusionMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super((MenuType)ModMenu.WEAPON_FUSION.get(), pContainerId, pPlayerInventory, pAccess, weaponFusionSlots());
        this.level = pPlayerInventory.player.level();
        this.recipes = java.util.List.of(); // TODO 26.2: Level.getRecipeManager() removed - wire level.recipeAccess()
    }

    private static ItemCombinerMenuSlotDefinition weaponFusionSlots() {
        return ItemCombinerMenuSlotDefinition.create().withSlot(0, 27, 47, s -> true).withSlot(1, 76, 47, s -> true).withResultSlot(2, 134, 47).build();
    }

    protected boolean isValidBlock(BlockState pState) {
        return pState.is((Block)ModBlocks.MECHANICAL_FUSION_ANVIL.get());
    }

    protected boolean mayPickup(Player pPlayer, boolean pHasStack) {
        return this.selectedRecipe != null && ((WeaponfusionRecipe)this.selectedRecipe.value()).matches(this.createRecipeInput(), this.level);
    }

    protected void onTake(Player pPlayer, ItemStack pStack) {
        pStack.onCraftedBy(pPlayer, pStack.getCount());
        this.resultSlots.awardUsedRecipes(pPlayer, this.getRelevantItems());
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.shrinkStackInSlot(2);
        this.access.execute((p_40263_, p_40264_) -> p_40263_.levelEvent(1044, p_40264_, 0));
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(0), this.inputSlots.getItem(1), this.inputSlots.getItem(2));
    }

    private WeaponfusionRecipeInput createRecipeInput() {
        return new WeaponfusionRecipeInput(this.inputSlots.getItem(0), this.inputSlots.getItem(1));
    }

    private void shrinkStackInSlot(int pIndex) {
        ItemStack itemstack = this.inputSlots.getItem(pIndex);
        if (!itemstack.isEmpty()) {
            itemstack.shrink(1);
            this.inputSlots.setItem(pIndex, itemstack);
        }
    }

    public void createResult() {
        // TODO 26.2: Level.getRecipeManager() removed. Re-wire via level.recipeAccess() so weapon
        // fusion produces a result again. Until then the fusion anvil GUI opens but yields nothing.
        this.selectedRecipe = null;
        this.resultSlots.setItem(0, ItemStack.EMPTY);
    }

    public int getSlotToQuickMoveTo(ItemStack pStack) {
        return this.findSlotToQuickMoveTo(pStack).orElse(0);
    }

    private static OptionalInt findSlotMatchingIngredient(WeaponfusionRecipe p_266790_, ItemStack p_266818_) {
        if (p_266790_.isBaseIngredient(p_266818_)) {
            return OptionalInt.of(0);
        }
        return p_266790_.isAdditionIngredient(p_266818_) ? OptionalInt.of(1) : OptionalInt.empty();
    }

    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public boolean canMoveIntoInputSlots(ItemStack pStack) {
        return this.findSlotToQuickMoveTo(pStack).isPresent();
    }

    private OptionalInt findSlotToQuickMoveTo(ItemStack pStack) {
        return this.recipes.stream().flatMapToInt(p_300800_ -> WeaponfusionMenu.findSlotMatchingIngredient((WeaponfusionRecipe)p_300800_.value(), pStack).stream()).filter(p_294045_ -> !this.getSlot(p_294045_).hasItem()).findFirst();
    }
}

