/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  net.minecraft.world.level.block.WallSkullBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.SkullBlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.skd.thesundering.blocks;

import com.skd.thesundering.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.thesundering.init.ModBlocks;
import com.skd.thesundering.init.ModTileentites;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class Cataclysm_Wall_Skull_Block
extends WallSkullBlock {
    public Cataclysm_Wall_Skull_Block(SkullBlock.Type type, BlockBehaviour.Properties props) {
        super(type, props);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Cataclysm_Skull_BlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_151992_, BlockState p_151993_, BlockEntityType<T> p_151994_) {
        if (p_151992_.isClientSide()) {
            boolean flag;
            boolean bl = flag = p_151993_.is((Block)ModBlocks.APTRGANGR_HEAD.get()) || p_151993_.is((Block)ModBlocks.APTRGANGR_WALL_HEAD.get()) || p_151993_.is((Block)ModBlocks.KOBOLEDIATOR_SKULL.get()) || p_151993_.is((Block)ModBlocks.KOBOLEDIATOR_WALL_SKULL.get());
            if (flag) {
                return Cataclysm_Wall_Skull_Block.createTickerHelper(p_151994_, (BlockEntityType)((BlockEntityType)ModTileentites.CATACLYSM_SKULL.get()), SkullBlockEntity::animation);
            }
        }
        return null;
    }
}

