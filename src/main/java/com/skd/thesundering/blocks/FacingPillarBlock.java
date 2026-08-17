/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
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
package com.skd.thesundering.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FacingPillarBlock
extends Block {
    public static final BooleanProperty TOP = BooleanProperty.create((String)"top");
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public FacingPillarBlock(BlockBehaviour.Properties p_49046_) {
        super(p_49046_);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue((Property)TOP, (Comparable)Boolean.valueOf(true))).setValue((Property)FACING, (Comparable)Direction.UP));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        BlockState pillar = super.updateShape(state, direction, state1, levelAccessor, blockPos, blockPos1);
        pillar = levelAccessor.getBlockState(blockPos.relative((Direction)state.getValue((Property)FACING))).getBlock() instanceof FacingPillarBlock ? (BlockState)pillar.setValue((Property)TOP, (Comparable)Boolean.valueOf(false)) : (BlockState)pillar.setValue((Property)TOP, (Comparable)Boolean.valueOf(true));
        return pillar;
    }

    public BlockState rotate(BlockState p_49085_, Rotation p_49086_) {
        return (BlockState)p_49085_.setValue((Property)FACING, (Comparable)p_49086_.rotate((Direction)p_49085_.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState p_49082_, Mirror p_49083_) {
        return p_49082_.rotate(p_49083_.getRotation((Direction)p_49082_.getValue((Property)FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49088_) {
        p_49088_.add(new Property[]{TOP, FACING});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level levelaccessor = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState above = levelaccessor.getBlockState(blockpos.relative(context.getNearestLookingDirection().getOpposite()));
        return (BlockState)((BlockState)this.defaultBlockState().setValue((Property)TOP, (Comparable)Boolean.valueOf(!(above.getBlock() instanceof FacingPillarBlock)))).setValue((Property)FACING, (Comparable)context.getNearestLookingDirection().getOpposite());
    }
}

