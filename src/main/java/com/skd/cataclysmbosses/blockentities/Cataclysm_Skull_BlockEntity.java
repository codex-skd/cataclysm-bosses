/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.SkullBlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Cataclysm_Skull_BlockEntity
extends SkullBlockEntity {
    public Cataclysm_Skull_BlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public BlockEntityType<?> getType() {
        return (BlockEntityType)ModTileentites.CATACLYSM_SKULL.get();
    }
}

