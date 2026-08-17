/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.skd.thesundering.blockentities;

import com.skd.thesundering.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class Abyssal_Egg_Block_Entity
extends BlockEntity {
    public int tickCount;

    public Abyssal_Egg_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.ABYSSAL_EGG.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, Abyssal_Egg_Block_Entity entity) {
        entity.tick();
    }

    public void tick() {
        ++this.tickCount;
    }
}

