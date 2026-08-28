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
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class Mechanical_fusion_Anvil_Block_Entity
extends BlockEntity {
    public int tickCount;

    public Mechanical_fusion_Anvil_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.MECHANICAL_FUSION_ANVIL.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, Mechanical_fusion_Anvil_Block_Entity entity) {
        entity.tick();
    }

    public void tick() {
        ++this.tickCount;
    }
}

