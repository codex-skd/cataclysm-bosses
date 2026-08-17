/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.thesundering.blocks;

import com.skd.thesundering.blockentities.AltarOfVoid_Block_Entity;
import com.skd.thesundering.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Altar_Of_Void_Block
extends BaseEntityBlock {
    public static final MapCodec<Altar_Of_Void_Block> CODEC = Altar_Of_Void_Block.simpleCodec(Altar_Of_Void_Block::new);
    private static final VoxelShape BASE = Block.box((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)4.0, (double)15.0);
    private static final VoxelShape MID = Block.box((double)2.0, (double)4.0, (double)2.0, (double)14.0, (double)10.0, (double)14.0);
    private static final VoxelShape TOP = Block.box((double)0.0, (double)10.0, (double)0.0, (double)16.0, (double)14.0, (double)16.0);
    private static final VoxelShape AXIS_AABB = Shapes.or((VoxelShape)BASE, (VoxelShape[])new VoxelShape[]{MID, TOP});

    public MapCodec<Altar_Of_Void_Block> codec() {
        return CODEC;
    }

    public Altar_Of_Void_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
    }

    public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
        return AXIS_AABB;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfVoid_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return Altar_Of_Void_Block.createTickerHelper(p_152182_, (BlockEntityType)((BlockEntityType)ModTileentites.ALTAR_OF_VOID.get()), AltarOfVoid_Block_Entity::commonTick);
    }
}

