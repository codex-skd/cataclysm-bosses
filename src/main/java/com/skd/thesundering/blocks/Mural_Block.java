/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.AttachFace
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.thesundering.blocks;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mural_Block
extends FaceAttachedHorizontalDirectionalBlock
implements SimpleWaterloggedBlock {
    public static final MapCodec<Mural_Block> CODEC = Mural_Block.simpleCodec(Mural_Block::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape CEILING_AABB;
    protected static final VoxelShape FLOOR_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;

    public MapCodec<Mural_Block> codec() {
        return CODEC;
    }

    public Mural_Block(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)FACE, (Comparable)AttachFace.WALL)).setValue((Property)WATERLOGGED, (Comparable)Boolean.FALSE));
    }

    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = (Direction)state.getValue((Property)FACING);
        switch ((AttachFace)state.getValue((Property)FACE)) {
            case FLOOR: {
                return FLOOR_AABB;
            }
            case WALL: {
                return switch (direction) {
                    case Direction.EAST -> EAST_AABB;
                    case Direction.WEST -> WEST_AABB;
                    case Direction.SOUTH -> SOUTH_AABB;
                    case Direction.NORTH, Direction.UP, Direction.DOWN -> NORTH_AABB;
                    default -> throw new MatchException(null, null);
                };
            }
        }
        return CEILING_AABB;
    }

    protected boolean isSignalSource(BlockState state) {
        return true;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        for (Direction direction : context.getNearestLookingDirections()) {
            BlockState blockstate = direction.getAxis() == Direction.Axis.Y ? (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACE, (Comparable)(direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR))).setValue((Property)FACING, (Comparable)context.getHorizontalDirection())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.getType() == Fluids.WATER)) : (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACE, (Comparable)AttachFace.WALL)).setValue((Property)FACING, (Comparable)direction.getOpposite())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
            if (!blockstate.canSurvive((LevelReader)context.getLevel(), context.getClickedPos())) continue;
            return blockstate;
        }
        return null;
    }

    public FluidState getFluidState(BlockState p_51581_) {
        return (Boolean)p_51581_.getValue((Property)WATERLOGGED) != false ? Fluids.WATER.getSource(false) : super.getFluidState(p_51581_);
    }

    public BlockState updateShape(BlockState p_51555_, Direction p_51556_, BlockState p_51557_, LevelAccessor p_51558_, BlockPos p_51559_, BlockPos p_51560_) {
        if (((Boolean)p_51555_.getValue((Property)WATERLOGGED)).booleanValue()) {
            p_51558_.scheduleTick(p_51559_, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)p_51558_));
        }
        return super.updateShape(p_51555_, p_51556_, p_51557_, p_51558_, p_51559_, p_51560_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, FACE, WATERLOGGED});
    }

    static {
        FLOOR_AABB = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)8.0, (double)16.0);
        CEILING_AABB = Block.box((double)0.0, (double)8.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        NORTH_AABB = Block.box((double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0, (double)16.0);
        SOUTH_AABB = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)8.0);
        WEST_AABB = Block.box((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        EAST_AABB = Block.box((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0);
    }
}

