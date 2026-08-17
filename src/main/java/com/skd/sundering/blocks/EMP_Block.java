/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.DustParticleOptions
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
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
 */
package com.skd.sundering.blocks;

import com.skd.sundering.blockentities.EMP_Block_Entity;
import com.skd.sundering.client.particle.Options.LightningParticleOptions;
import com.skd.sundering.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class EMP_Block
extends BaseEntityBlock {
    public static final MapCodec<EMP_Block> CODEC = EMP_Block.simpleCodec(EMP_Block::new);
    public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty OVERLOAD = BooleanProperty.create((String)"overload");

    public MapCodec<EMP_Block> codec() {
        return CODEC;
    }

    public EMP_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)TIP_DIRECTION, (Comparable)Direction.UP)).setValue((Property)POWERED, (Comparable)Boolean.valueOf(false))).setValue((Property)OVERLOAD, (Comparable)Boolean.valueOf(false)));
    }

    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isClientSide()) {
            this.updateState(state, worldIn, pos, blockIn);
        }
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if (!worldIn.isClientSide()) {
            this.updateState(state, (Level)worldIn, pos, state.getBlock());
        }
    }

    public void updateState(BlockState state, Level worldIn, BlockPos pos, Block blockIn) {
        boolean flag = (Boolean)state.getValue((Property)POWERED);
        boolean flag1 = worldIn.hasNeighborSignal(pos);
        if (flag1 != flag) {
            worldIn.setBlock(pos, (BlockState)state.setValue((Property)POWERED, (Comparable)Boolean.valueOf(flag1)), 3);
            worldIn.updateNeighborsAt(pos.below(), (Block)this);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue((Property)TIP_DIRECTION, (Comparable)context.getNearestLookingVerticalDirection().getOpposite())).setValue((Property)POWERED, (Comparable)Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())))).setValue((Property)OVERLOAD, (Comparable)Boolean.valueOf(false));
    }

    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        Direction direction = Direction.getRandom((RandomSource)rand);
        double d0 = 0.5625;
        double d = rand.nextFloat() - 0.5f;
        if (direction != Direction.UP) {
            BlockPos blockpos = pos.relative(direction);
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (!stateIn.canOcclude() || !blockstate.isFaceSturdy((BlockGetter)worldIn, blockpos, direction.getOpposite())) {
                double d3;
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5 + d0 * (double)direction.getStepX() : (double)rand.nextFloat();
                double d2 = d3 = direction$axis == Direction.Axis.Z ? 0.5 + d0 * (double)direction.getStepZ() : (double)rand.nextFloat();
                if (((Boolean)stateIn.getValue((Property)OVERLOAD)).booleanValue()) {
                    for (int i1 = 0; i1 < 20; ++i1) {
                        worldIn.addParticle((ParticleOptions)DustParticleOptions.REDSTONE, (double)pos.getX() + d1, (double)pos.getY() + 0.75, (double)pos.getZ() + d3, 0.0, 0.0, 0.0);
                    }
                } else {
                    worldIn.addParticle((ParticleOptions)new LightningParticleOptions(255, 51, 0), (double)pos.getX() + 0.5, (double)pos.getY() + 0.75, (double)pos.getZ() + 0.5, d * 2.0, d, d * 2.0);
                }
            }
        }
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EMP_Block_Entity(pos, state);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TIP_DIRECTION, POWERED, OVERLOAD});
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return EMP_Block.createTickerHelper(p_152182_, (BlockEntityType)((BlockEntityType)ModTileentites.EMP.get()), EMP_Block_Entity::commonTick);
    }
}

