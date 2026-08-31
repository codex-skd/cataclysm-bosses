/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.AltarOfAmethyst_Block_Entity;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Altar_Of_Amethyst_Block
extends BaseEntityBlock
implements SimpleWaterloggedBlock {
    public static final MapCodec<Altar_Of_Amethyst_Block> CODEC = Altar_Of_Amethyst_Block.simpleCodec(Altar_Of_Amethyst_Block::new);
    // public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    // public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape BASE = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)3.0, (double)16.0);
    private static final VoxelShape MID = Block.box((double)2.0, (double)3.0, (double)2.0, (double)14.0, (double)13.0, (double)14.0);
    private static final VoxelShape TOP = Block.box((double)0.0, (double)13.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    private static final VoxelShape AXIS_AABB = Shapes.or((VoxelShape)BASE, (VoxelShape[])new VoxelShape[]{MID, TOP});

    public MapCodec<Altar_Of_Amethyst_Block> codec() {
        return CODEC;
    }

    public Altar_Of_Amethyst_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        // this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)WATERLOGGED, (Comparable)Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new AltarOfAmethyst_Block_Entity(p_153215_, p_153216_);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152123_, BlockState p_152124_, BlockEntityType<T> p_152125_) {
        return p_152125_ == ModTileentites.ALTAR_OF_AMETHYST.get() ? (level, pos, state, entity) -> AltarOfAmethyst_Block_Entity.cookingTick(level, pos, state, (AltarOfAmethyst_Block_Entity)entity) : null;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return AXIS_AABB;
    }

    @Override
    public BlockState rotate(BlockState p_55795_, Rotation p_55796_) {
        // return (BlockState)p_55795_.setValue((Property)FACING, (Comparable)p_55796_.rotate((Direction)p_55795_.getValue((Property)FACING)));
        return super.rotate(p_55795_, p_55796_);
    }

    @Override
    public BlockState mirror(BlockState p_55807_, net.minecraft.world.level.block.Mirror p_55808_) {
        // return p_55807_.rotate(p_55808_.getRotation((Direction)p_55807_.getValue((Property)FACING)));
        return super.mirror(p_55807_, p_55808_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_60568_) {
        // p_60568_.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_48781_) {
        // FluidState fluidstate = p_48781_.getLevel().getFluidState(p_48781_.getClickedPos());
        // return (BlockState)((BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)p_48781_.getHorizontalDirection().getClockWise())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
        return super.getStateForPlacement(p_48781_);
    }

    @Override
    public FluidState getFluidState(BlockState p_57221_) {
        // return p_57221_.getValue((Property)WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_57221_);
        return super.getFluidState(p_57221_);
    }

    @Override
    protected BlockState updateShape(BlockState p_57061_, LevelReader p_57064_, ScheduledTickAccess ticks, BlockPos p_57065_, Direction p_57062_, BlockPos p_57066_, BlockState p_57063_, RandomSource random) {
        // if (p_57061_.getValue((Property)WATERLOGGED)) {
        //     p_57064_.scheduleTick(p_57065_, Fluids.WATER, Fluids.WATER.getTickDelay(p_57064_));
        // }
        return super.updateShape(p_57061_, p_57064_, ticks, p_57065_, p_57062_, p_57066_, p_57063_, random);
    }
}