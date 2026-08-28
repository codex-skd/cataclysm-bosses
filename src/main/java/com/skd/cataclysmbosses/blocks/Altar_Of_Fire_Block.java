/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.ItemInteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.AltarOfFire_Block_Entity;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.InsideBlockEffectApplier;

public class Altar_Of_Fire_Block
extends BaseEntityBlock {
    public static final MapCodec<Altar_Of_Fire_Block> CODEC = Altar_Of_Fire_Block.simpleCodec(Altar_Of_Fire_Block::new);

    public MapCodec<Altar_Of_Fire_Block> codec() {
        return CODEC;
    }

    public Altar_Of_Fire_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
    }

    // public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
    //     ItemStack heldItem = player.getItemInHand(handIn);
    //     if (worldIn.getBlockEntity(pos) instanceof AltarOfFire_Block_Entity && !player.isShiftKeyDown() && heldItem.getItem() != this.asItem()) {
    //         AltarOfFire_Block_Entity aof = (AltarOfFire_Block_Entity)worldIn.getBlockEntity(pos);
    //         ItemStack copy = heldItem.copy();
    //         copy.setCount(1);
    //         if (aof.getItem(0).isEmpty()) {
    //             aof.placeItem((LivingEntity)player, 0, copy);
    //             if (!player.isCreative()) {
    //                 heldItem.shrink(1);
    //             }
    //         } else {
    //             Altar_Of_Fire_Block.popResource((Level)worldIn, (BlockPos)pos, (ItemStack)aof.getItem(0).copy());
    //             aof.placeItem((LivingEntity)player, 0, ItemStack.EMPTY);
    //         }
    //         return ItemInteractionResult.SUCCESS;
    //     }
    //     return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    // }

    public void animateTick(BlockState p_220918_, Level p_220919_, BlockPos p_220920_, RandomSource p_220921_) {
        if (p_220921_.nextInt(5) == 0) {
            for (int i = 0; i < p_220921_.nextInt(1) + 1; ++i) {
                p_220919_.addParticle((ParticleOptions)ParticleTypes.LAVA, (double)p_220920_.getX() + 0.5, (double)p_220920_.getY() + 1.5, (double)p_220920_.getZ() + 0.5, (double)(p_220921_.nextFloat() / 2.0f), 5.0E-5, (double)(p_220921_.nextFloat() / 2.0f));
            }
        }
    }

    @Override
    protected void entityInside(BlockState p_51269_, Level p_51270_, BlockPos p_51271_, Entity p_51272_, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if (p_51272_ instanceof LivingEntity) {
            p_51272_.hurtOrSimulate(p_51270_.damageSources().campfire(), 3.0f);
        }
        super.entityInside(p_51269_, p_51270_, p_51271_, p_51272_, effectApplier, isPrecise);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfFire_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return p_152182_ == ModTileentites.ALTAR_OF_FIRE.get() ? (level, pos, state, entity) -> ((AltarOfFire_Block_Entity)entity).commonTick(level, pos, state) : null;
    }
}