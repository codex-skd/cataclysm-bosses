/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SkullBlock
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.SkullBlockEntity
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModTileentites;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class Cataclysm_Skull_Block
extends SkullBlock {
    public Cataclysm_Skull_Block(SkullBlock.Type p_56318_, BlockBehaviour.Properties p_56319_) {
        super(p_56318_, p_56319_);
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
                return Cataclysm_Skull_Block.createTickerHelper(p_151994_, (BlockEntityType)((BlockEntityType)ModTileentites.CATACLYSM_SKULL.get()), SkullBlockEntity::animation);
            }
        }
        return null;
    }

    public static enum Types implements SkullBlock.Type
    {
        KOBOLEDIATOR("kobolediator"),
        APTRGANGR("aptrgangr"),
        DRAUGR("draugr");

        private final String name;

        private Types(String pName) {
            this.name = pName;
            TYPES.put(pName, this);
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}

