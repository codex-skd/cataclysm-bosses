/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.item.FallingBlockEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Fallable
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blocks.SandStoneTrapBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class Sandstone_Falling_Trap
extends SandStoneTrapBlock
implements Fallable {
    public Sandstone_Falling_Trap(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        this.activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    private void activate(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!((Boolean)state.getValue((Property)LIT)).booleanValue() && Sandstone_Falling_Trap.shouldTrigger(entity) && Sandstone_Falling_Trap.isFree(world.getBlockState(pos.below())) && pos.getY() >= world.getMinY()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall((Level)world, (BlockPos)pos, (BlockState)state);
            this.falling(fallingblockentity);
        }
    }

    public static boolean isFree(BlockState p_53242_) {
        return p_53242_.isAir() || p_53242_.is(BlockTags.FIRE) || p_53242_.liquid() || p_53242_.canBeReplaced();
    }

    protected void falling(FallingBlockEntity p_53206_) {
    }
}

