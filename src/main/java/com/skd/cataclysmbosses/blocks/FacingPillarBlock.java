/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.cataclysmbosses.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FacingPillarBlock
extends Block {
    public static final BooleanProperty TOP = BooleanProperty.create((String)"top");
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

    public FacingPillarBlock(BlockBehaviour.Properties p_49046_) {
        super(p_49046_);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(TOP, true)).setValue(FACING, Direction.UP));
    }

    protected BlockState updateShape(BlockState state, LevelReader levelAccessor, ScheduledTickAccess ticks, BlockPos blockPos, Direction direction, BlockPos blockPos1, BlockState state1, RandomSource random) {
        BlockState pillar = super.updateShape(state, levelAccessor, ticks, blockPos, direction, blockPos1, state1, random);
        pillar = levelAccessor.getBlockState(blockPos.relative(state.getValue(FACING))).getBlock() instanceof FacingPillarBlock ? (BlockState)pillar.setValue(TOP, false) : (BlockState)pillar.setValue(TOP, true);
        return pillar;
    }

    public BlockState rotate(BlockState p_49085_, Rotation p_49086_) {
        return (BlockState)p_49085_.setValue(FACING, p_49086_.rotate(p_49085_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_49082_, Mirror p_49083_) {
        return p_49082_.rotate(p_49083_.getRotation(p_49082_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49088_) {
        p_49088_.add(new Property[]{TOP, FACING});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState above = levelaccessor.getBlockState(blockpos.relative(context.getNearestLookingDirection().getOpposite()));
        return (BlockState)((BlockState)this.defaultBlockState().setValue(TOP, !(above.getBlock() instanceof FacingPillarBlock))).setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }
}

