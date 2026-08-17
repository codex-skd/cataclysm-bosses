/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow$Pickup
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.blocks;

import com.skd.thesundering.entity.projectile.Poison_Dart_Entity;
import com.skd.thesundering.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

public class Sandstone_Poison_Dart_Trap
extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public Sandstone_Poison_Dart_Trap(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)LIT, (Comparable)Boolean.valueOf(false)));
    }

    public static Vec3 getDispensePosition(BlockPos coords, Direction dir) {
        double d0 = (double)coords.getX() + 0.5 + 0.7 * (double)dir.getStepX();
        double d1 = (double)coords.getY() + 0.15 + 0.7 * (double)dir.getStepY();
        double d2 = (double)coords.getZ() + 0.5 + 0.7 * (double)dir.getStepZ();
        return new Vec3(d0, d1, d2);
    }

    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        this.tickGustmaker(state, worldIn, pos, false);
    }

    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource rand) {
        this.tickGustmaker(state, (Level)worldIn, pos, true);
    }

    public void tickGustmaker(BlockState state, Level worldIn, BlockPos pos, boolean tickOff) {
        boolean flag = worldIn.hasNeighborSignal(pos) || worldIn.hasNeighborSignal(pos.below()) || worldIn.hasNeighborSignal(pos.above());
        boolean flag1 = (Boolean)state.getValue((Property)LIT);
        if (flag && !flag1) {
            if (worldIn.isLoaded(pos)) {
                Vec3 dispensePosition = Sandstone_Poison_Dart_Trap.getDispensePosition(pos, (Direction)state.getValue((Property)FACING));
                Direction direction = (Direction)state.getValue((Property)FACING);
                Poison_Dart_Entity dart = new Poison_Dart_Entity((EntityType)ModEntities.POISON_DART.get(), dispensePosition.x, (float)dispensePosition.y + 0.25f, (float)dispensePosition.z, worldIn);
                dart.pickup = AbstractArrow.Pickup.DISALLOWED;
                dart.shoot(direction.getStepX(), (float)direction.getStepY() + 0.1f, direction.getStepZ(), 2.5f, 1.0f);
                worldIn.addFreshEntity((Entity)dart);
            }
            worldIn.setBlock(pos, (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(true)), 2);
            worldIn.scheduleTick(pos, (Block)this, 20);
        } else if (flag1 && tickOff) {
            worldIn.scheduleTick(pos, (Block)this, 20);
            worldIn.setBlock(pos, (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(false)), 2);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return (BlockState)this.defaultBlockState().setValue((Property)FACING, (Comparable)p_48689_.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, LIT});
    }
}

