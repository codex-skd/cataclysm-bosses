/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.annotations.VisibleForTesting
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Direction$AxisDirection
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.item.FallingBlockEntity
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ThrownTrident
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Fallable
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.SpeleothemThickness
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.init.ModBlocks;
import com.google.common.annotations.VisibleForTesting;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
// import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SpeleothemThickness;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PointedIcicleBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final EnumProperty<Direction> TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<SpeleothemThickness> THICKNESS = BlockStateProperties.SPELEOTHEM_THICKNESS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final int MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE = 11;
    private static final int DELAY_BEFORE_FALLING = 2;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK = 0.02f;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE = 0.12f;
    private static final int MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON = 11;
    private static final float WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.17578125f;
    private static final float LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.05859375f;
    private static final double MIN_TRIDENT_VELOCITY_TO_BREAK_DRIPSTONE = 0.6;
    private static final float STALACTITE_DAMAGE_PER_FALL_DISTANCE_AND_SIZE = 1.0f;
    private static final int STALACTITE_MAX_DAMAGE = 40;
    private static final int MAX_STALACTITE_HEIGHT_FOR_DAMAGE_CALCULATION = 6;
    private static final float STALAGMITE_FALL_DISTANCE_OFFSET = 2.0f;
    private static final int STALAGMITE_FALL_DAMAGE_MODIFIER = 2;
    private static final float AVERAGE_DAYS_PER_GROWTH = 5.0f;
    private static final float GROWTH_PROBABILITY_PER_RANDOM_TICK = 0.011377778f;
    private static final int MAX_GROWTH_LENGTH = 7;
    private static final int MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING = 10;
    private static final float STALACTITE_DRIP_START_PIXEL = 0.6875f;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.box((double)5.0, (double)0.0, (double)5.0, (double)11.0, (double)16.0, (double)11.0);
    private static final VoxelShape TIP_SHAPE_UP = Block.box((double)5.0, (double)0.0, (double)5.0, (double)11.0, (double)11.0, (double)11.0);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.box((double)5.0, (double)5.0, (double)5.0, (double)11.0, (double)16.0, (double)11.0);
    private static final VoxelShape FRUSTUM_SHAPE = Block.box((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)16.0, (double)12.0);
    private static final VoxelShape MIDDLE_SHAPE = Block.box((double)3.0, (double)0.0, (double)3.0, (double)13.0, (double)16.0, (double)13.0);
    private static final VoxelShape BASE_SHAPE = Block.box((double)2.0, (double)0.0, (double)2.0, (double)14.0, (double)16.0, (double)14.0);
    private static final float MAX_HORIZONTAL_OFFSET = 0.125f;
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box((double)6.0, (double)0.0, (double)6.0, (double)10.0, (double)16.0, (double)10.0);

    public PointedIcicleBlock(BlockBehaviour.Properties p_154025_) {
        super(p_154025_);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)TIP_DIRECTION, (Comparable)Direction.UP)).setValue(THICKNESS, (Comparable)SpeleothemThickness.TIP)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_154157_) {
        p_154157_.add(new Property[]{TIP_DIRECTION, THICKNESS, WATERLOGGED});
    }

    public boolean canSurvive(BlockState p_154137_, LevelReader p_154138_, BlockPos p_154139_) {
        return PointedIcicleBlock.isValidPointedIciclePlacement(p_154138_, p_154139_, (Direction)p_154137_.getValue((Property)TIP_DIRECTION));
    }

    public BlockState updateShape(BlockState p_154147_, Direction p_154148_, BlockState p_154149_, LevelAccessor p_154150_, BlockPos p_154151_, BlockPos p_154152_) {
        if (((Boolean)p_154147_.getValue((Property)WATERLOGGED)).booleanValue()) {
            p_154150_.scheduleTick(p_154151_, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)p_154150_));
        }
        if (p_154148_ != Direction.UP && p_154148_ != Direction.DOWN) {
            return p_154147_;
        }
        Direction direction = (Direction)p_154147_.getValue((Property)TIP_DIRECTION);
        if (direction == Direction.DOWN && p_154150_.getBlockTicks().hasScheduledTick(p_154151_, (Object)this)) {
            return p_154147_;
        }
        if (p_154148_ == direction.getOpposite() && !this.canSurvive(p_154147_, (LevelReader)p_154150_, p_154151_)) {
            if (direction == Direction.DOWN) {
                p_154150_.scheduleTick(p_154151_, (Block)this, 2);
            } else {
                p_154150_.scheduleTick(p_154151_, (Block)this, 1);
            }
            return p_154147_;
        }
        boolean flag = p_154147_.getValue(THICKNESS) == SpeleothemThickness.TIP_MERGE;
        SpeleothemThickness dripstonethickness = PointedIcicleBlock.calculateDripstoneThickness((LevelReader)p_154150_, p_154151_, direction, flag);
        return (BlockState)p_154147_.setValue(THICKNESS, (Comparable)dripstonethickness);
    }

    public void onProjectileHit(Level p_154042_, BlockState p_154043_, BlockHitResult p_154044_, Projectile p_154045_) {
        BlockPos blockpos = p_154044_.getBlockPos();
        if (!p_154042_.isClientSide() && p_154045_.mayInteract(p_154042_, blockpos) && p_154045_ instanceof ThrownTrident && p_154045_.getDeltaMovement().length() > 0.6) {
            p_154042_.destroyBlock(blockpos, true);
        }
    }

    public void fallOn(Level p_154047_, BlockState p_154048_, BlockPos p_154049_, Entity p_154050_, float p_154051_) {
        if (p_154048_.getValue((Property)TIP_DIRECTION) == Direction.UP && p_154048_.getValue(THICKNESS) == SpeleothemThickness.TIP) {
            p_154050_.causeFallDamage(p_154051_ + 2.0f, 2.0f, p_154047_.damageSources().stalagmite());
        } else {
            super.fallOn(p_154047_, p_154048_, p_154049_, p_154050_, p_154051_);
        }
    }

    public void tick(BlockState p_221865_, ServerLevel p_221866_, BlockPos p_221867_, RandomSource p_221868_) {
        if (PointedIcicleBlock.isStalactite(p_221865_) && !this.canSurvive(p_221865_, (LevelReader)p_221866_, p_221867_)) {
            p_221866_.destroyBlock(p_221867_, true);
        } else {
            PointedIcicleBlock.spawnFallingStalactite(p_221865_, p_221866_, p_221867_);
        }
    }

    public void randomTick(BlockState p_221883_, ServerLevel p_221884_, BlockPos p_221885_, RandomSource p_221886_) {
        if (p_221886_.nextFloat() < 0.011377778f && PointedIcicleBlock.isStalactiteStartPos(p_221883_, (LevelReader)p_221884_, p_221885_)) {
            PointedIcicleBlock.growStalactiteOrStalagmiteIfPossible(p_221883_, p_221884_, p_221885_, p_221886_);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_154040_) {
        Direction direction;
        BlockPos blockpos;
        Level levelaccessor = p_154040_.getLevel();
        Direction direction1 = PointedIcicleBlock.calculateTipDirection((LevelReader)levelaccessor, blockpos = p_154040_.getClickedPos(), direction = p_154040_.getNearestLookingVerticalDirection().getOpposite());
        if (direction1 == null) {
            return null;
        }
        boolean flag = !p_154040_.isSecondaryUseActive();
        SpeleothemThickness dripstonethickness = PointedIcicleBlock.calculateDripstoneThickness((LevelReader)levelaccessor, blockpos, direction1, flag);
        return dripstonethickness == null ? null : (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue((Property)TIP_DIRECTION, (Comparable)direction1)).setValue(THICKNESS, (Comparable)dripstonethickness)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER));
    }

    public FluidState getFluidState(BlockState p_154235_) {
        return (Boolean)p_154235_.getValue((Property)WATERLOGGED) != false ? Fluids.WATER.getSource(false) : super.getFluidState(p_154235_);
    }

    public VoxelShape getOcclusionShape(BlockState p_154170_, BlockGetter p_154171_, BlockPos p_154172_) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState p_154117_, BlockGetter p_154118_, BlockPos p_154119_, CollisionContext p_154120_) {
        SpeleothemThickness dripstonethickness = (SpeleothemThickness)p_154117_.getValue(THICKNESS);
        VoxelShape voxelshape = dripstonethickness == SpeleothemThickness.TIP_MERGE ? TIP_MERGE_SHAPE : (dripstonethickness == SpeleothemThickness.TIP ? (p_154117_.getValue((Property)TIP_DIRECTION) == Direction.DOWN ? TIP_SHAPE_DOWN : TIP_SHAPE_UP) : (dripstonethickness == SpeleothemThickness.FRUSTUM ? FRUSTUM_SHAPE : (dripstonethickness == SpeleothemThickness.MIDDLE ? MIDDLE_SHAPE : BASE_SHAPE)));
        Vec3 vec3 = p_154117_.getOffset(p_154118_, p_154119_);
        return voxelshape.move(vec3.x, 0.0, vec3.z);
    }

    public boolean isCollisionShapeFullBlock(BlockState p_181235_, BlockGetter p_181236_, BlockPos p_181237_) {
        return false;
    }

    public float getMaxHorizontalOffset() {
        return 0.125f;
    }

    public void onBrokenAfterFall(Level p_154059_, BlockPos p_154060_, FallingBlockEntity p_154061_) {
        if (!p_154061_.isSilent()) {
            p_154059_.levelEvent(1045, p_154060_, 0);
        }
    }

    public DamageSource getFallDamageSource(Entity p_254432_) {
        return p_254432_.damageSources().fallingStalactite(p_254432_);
    }

    private static void spawnFallingStalactite(BlockState p_154098_, ServerLevel p_154099_, BlockPos p_154100_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_154100_.mutable();
        BlockState blockstate = p_154098_;
        while (PointedIcicleBlock.isStalactite(blockstate)) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall((Level)p_154099_, (BlockPos)blockpos$mutableblockpos, (BlockState)blockstate);
            if (PointedIcicleBlock.isTip(blockstate, true)) {
                int i = Math.max(1 + p_154100_.getY() - blockpos$mutableblockpos.getY(), 6);
                float f = 1.0f * (float)i;
                fallingblockentity.setHurtsEntities(f, 40);
                break;
            }
            blockpos$mutableblockpos.move(Direction.DOWN);
            blockstate = p_154099_.getBlockState((BlockPos)blockpos$mutableblockpos);
        }
    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState p_221888_, ServerLevel p_221889_, BlockPos p_221890_, RandomSource p_221891_) {
        BlockState blockstate2;
        BlockPos blockpos;
        BlockState blockstate = p_221889_.getBlockState(p_221890_.above(1));
        if (PointedIcicleBlock.canGrow(blockstate) && (blockpos = PointedIcicleBlock.findTip(p_221888_, (LevelAccessor)p_221889_, p_221890_, 7, false)) != null && PointedIcicleBlock.canDrip(blockstate2 = p_221889_.getBlockState(blockpos)) && PointedIcicleBlock.canTipGrow(blockstate2, p_221889_, blockpos)) {
            if (p_221891_.nextBoolean()) {
                PointedIcicleBlock.grow(p_221889_, blockpos, Direction.DOWN);
            } else {
                PointedIcicleBlock.growStalagmiteBelow(p_221889_, blockpos);
            }
        }
    }

    private static void growStalagmiteBelow(ServerLevel p_154033_, BlockPos p_154034_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_154034_.mutable();
        for (int i = 0; i < 10; ++i) {
            blockpos$mutableblockpos.move(Direction.DOWN);
            BlockState blockstate = p_154033_.getBlockState((BlockPos)blockpos$mutableblockpos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }
            if (PointedIcicleBlock.isUnmergedTipWithDirection(blockstate, Direction.UP) && PointedIcicleBlock.canTipGrow(blockstate, p_154033_, (BlockPos)blockpos$mutableblockpos)) {
                PointedIcicleBlock.grow(p_154033_, (BlockPos)blockpos$mutableblockpos, Direction.UP);
                return;
            }
            if (PointedIcicleBlock.isValidPointedIciclePlacement((LevelReader)p_154033_, (BlockPos)blockpos$mutableblockpos, Direction.UP) && !p_154033_.isWaterAt(blockpos$mutableblockpos.below())) {
                PointedIcicleBlock.grow(p_154033_, blockpos$mutableblockpos.below(), Direction.UP);
                return;
            }
            if (PointedIcicleBlock.canDripThrough((BlockGetter)p_154033_, (BlockPos)blockpos$mutableblockpos, blockstate)) continue;
            return;
        }
    }

    private static void grow(ServerLevel p_154036_, BlockPos p_154037_, Direction p_154038_) {
        BlockPos blockpos = p_154037_.relative(p_154038_);
        BlockState blockstate = p_154036_.getBlockState(blockpos);
        if (PointedIcicleBlock.isUnmergedTipWithDirection(blockstate, p_154038_.getOpposite())) {
            PointedIcicleBlock.createMergedTips(blockstate, (LevelAccessor)p_154036_, blockpos);
        } else if (blockstate.isAir() || blockstate.is(Blocks.WATER)) {
            PointedIcicleBlock.createDripstone((LevelAccessor)p_154036_, blockpos, p_154038_, SpeleothemThickness.TIP);
        }
    }

    // private static void createDripstone(LevelAccessor p_154088_, BlockPos p_154089_, Direction p_154090_, SpeleothemThickness p_154091_) {
    //         BlockState blockstate = (BlockState)((BlockState)((BlockState)((Block)ModBlocks.POINTED_ICICLE.get()).defaultBlockState().setValue((Property)TIP_DIRECTION, (Comparable)p_154090_)).setValue(THICKNESS, (Comparable)p_154091_)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(p_154088_.getFluidState(p_154089_).getType() == Fluids.WATER));
    //         p_154088_.setBlock(p_154089_, blockstate, 3);
    //     }
    //
    private static void createMergedTips(BlockState p_154231_, LevelAccessor p_154232_, BlockPos p_154233_) {
        BlockPos blockpos;
        BlockPos blockpos1;
        if (p_154231_.getValue((Property)TIP_DIRECTION) == Direction.UP) {
            blockpos1 = p_154233_;
            blockpos = p_154233_.above();
        } else {
            blockpos = p_154233_;
            blockpos1 = p_154233_.below();
        }
        // PointedIcicleBlock.createDripstone(p_154232_, blockpos, Direction.DOWN, SpeleothemThickness.TIP_MERGE);
        // PointedIcicleBlock.createDripstone(p_154232_, blockpos1, Direction.UP, SpeleothemThickness.TIP_MERGE);
    }

    @Nullable
    private static BlockPos findTip(BlockState p_154131_, LevelAccessor p_154132_, BlockPos p_154133_, int p_154134_, boolean p_154135_) {
        if (PointedIcicleBlock.isTip(p_154131_, p_154135_)) {
            return p_154133_;
        }
        Direction direction = (Direction)p_154131_.getValue((Property)TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> bipredicate = (p_202023_, p_202024_) -> p_202024_.is((Block)ModBlocks.POINTED_ICICLE.get()) && p_202024_.getValue((Property)TIP_DIRECTION) == direction;
        return PointedIcicleBlock.findBlockVertical(p_154132_, p_154133_, direction.getAxisDirection(), bipredicate, p_154168_ -> PointedIcicleBlock.isTip(p_154168_, p_154135_), p_154134_).orElse(null);
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader p_154191_, BlockPos p_154192_, Direction p_154193_) {
        Direction direction;
        if (PointedIcicleBlock.isValidPointedIciclePlacement(p_154191_, p_154192_, p_154193_)) {
            direction = p_154193_;
        } else {
            if (!PointedIcicleBlock.isValidPointedIciclePlacement(p_154191_, p_154192_, p_154193_.getOpposite())) {
                return null;
            }
            direction = p_154193_.getOpposite();
        }
        return direction;
    }

    // private static SpeleothemThickness calculateDripstoneThickness(LevelReader p_154093_, BlockPos p_154094_, Direction p_154095_, boolean p_154096_) {
    //         Direction direction = p_154095_.getOpposite();
    //         BlockState blockstate = p_154093_.getBlockState(p_154094_.relative(p_154095_));
    //         if (PointedIcicleBlock.isPointedDripstoneWithDirection(blockstate, direction)) {
    //             return !p_154096_ && blockstate.getValue(THICKNESS) != SpeleothemThickness.TIP_MERGE ? SpeleothemThickness.TIP : SpeleothemThickness.TIP_MERGE;
    //         }
    //         if (!PointedIcicleBlock.isPointedDripstoneWithDirection(blockstate, p_154095_)) {
    //             return SpeleothemThickness.TIP;
    //         }
    //         SpeleothemThickness dripstonethickness = (SpeleothemThickness)blockstate.getValue(THICKNESS);
    //         if (dripstonethickness != SpeleothemThickness.TIP && dripstonethickness != SpeleothemThickness.TIP_MERGE) {
    //             BlockState blockstate1 = p_154093_.getBlockState(p_154094_.relative(direction));
    //             return !PointedIcicleBlock.isPointedDripstoneWithDirection(blockstate1, p_154095_) ? SpeleothemThickness.BASE : SpeleothemThickness.MIDDLE;
    //         }
    //         return SpeleothemThickness.FRUSTUM;
    //     }

    public static boolean canDrip(BlockState p_154239_) {
        return PointedIcicleBlock.isStalactite(p_154239_) && p_154239_.getValue(THICKNESS) == SpeleothemThickness.TIP && (Boolean)p_154239_.getValue((Property)WATERLOGGED) == false;
    }

    private static boolean canTipGrow(BlockState p_154195_, ServerLevel p_154196_, BlockPos p_154197_) {
        Direction direction = (Direction)p_154195_.getValue((Property)TIP_DIRECTION);
        BlockPos blockpos = p_154197_.relative(direction);
        BlockState blockstate = p_154196_.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        }
        return blockstate.isAir() ? true : PointedIcicleBlock.isUnmergedTipWithDirection(blockstate, direction.getOpposite());
    }

    private static Optional<BlockPos> findRootBlock(Level p_154067_, BlockPos p_154068_, BlockState p_154069_, int p_154070_) {
        Direction direction = (Direction)p_154069_.getValue((Property)TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> bipredicate = (p_202015_, p_202016_) -> p_202016_.is((Block)ModBlocks.POINTED_ICICLE.get()) && p_202016_.getValue((Property)TIP_DIRECTION) == direction;
        return PointedIcicleBlock.findBlockVertical((LevelAccessor)p_154067_, p_154068_, direction.getOpposite().getAxisDirection(), bipredicate, p_154245_ -> !p_154245_.is((Block)ModBlocks.POINTED_ICICLE.get()), p_154070_);
    }

    private static boolean isValidPointedIciclePlacement(LevelReader p_154222_, BlockPos p_154223_, Direction p_154224_) {
        BlockPos blockpos = p_154223_.relative(p_154224_.getOpposite());
        BlockState blockstate = p_154222_.getBlockState(blockpos);
        return blockstate.isFaceSturdy((BlockGetter)p_154222_, blockpos, p_154224_) || PointedIcicleBlock.isPointedDripstoneWithDirection(blockstate, p_154224_);
    }

    private static boolean isTip(BlockState p_154154_, boolean p_154155_) {
        if (!p_154154_.is((Block)ModBlocks.POINTED_ICICLE.get())) {
            return false;
        }
        SpeleothemThickness dripstonethickness = (SpeleothemThickness)p_154154_.getValue(THICKNESS);
        return dripstonethickness == SpeleothemThickness.TIP || p_154155_ && dripstonethickness == SpeleothemThickness.TIP_MERGE;
    }

    private static boolean isUnmergedTipWithDirection(BlockState p_154144_, Direction p_154145_) {
        return PointedIcicleBlock.isTip(p_154144_, false) && p_154144_.getValue((Property)TIP_DIRECTION) == p_154145_;
    }

    private static boolean isStalactite(BlockState p_154241_) {
        return PointedIcicleBlock.isPointedDripstoneWithDirection(p_154241_, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState p_154243_) {
        return PointedIcicleBlock.isPointedDripstoneWithDirection(p_154243_, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState p_154204_, LevelReader p_154205_, BlockPos p_154206_) {
        return PointedIcicleBlock.isStalactite(p_154204_) && !p_154205_.getBlockState(p_154206_.above()).is((Block)ModBlocks.POINTED_ICICLE.get());
    }

    public boolean isPathfindable(BlockState p_154112_, BlockGetter p_154113_, BlockPos p_154114_, PathComputationType p_154115_) {
        return false;
    }

    private static boolean isPointedDripstoneWithDirection(BlockState p_154208_, Direction p_154209_) {
        return p_154208_.is((Block)ModBlocks.POINTED_ICICLE.get()) && p_154208_.getValue((Property)TIP_DIRECTION) == p_154209_;
    }

    private static boolean canGrow(BlockState p_154141_) {
        return p_154141_.is(BlockTags.ICE);
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor p_202007_, BlockPos p_202008_, Direction.AxisDirection p_202009_, BiPredicate<BlockPos, BlockState> p_202010_, Predicate<BlockState> p_202011_, int p_202012_) {
        Direction direction = Direction.get((Direction.AxisDirection)p_202009_, (Direction.Axis)Direction.Axis.Y);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = p_202008_.mutable();
        for (int i = 1; i < p_202012_; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = p_202007_.getBlockState((BlockPos)blockpos$mutableblockpos);
            if (p_202011_.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.immutable());
            }
            if (!p_202007_.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) && p_202010_.test((BlockPos)blockpos$mutableblockpos, blockstate)) continue;
            return Optional.empty();
        }
        return Optional.empty();
    }

    private static boolean canDripThrough(BlockGetter p_202018_, BlockPos p_202019_, BlockState p_202020_) {
        if (p_202020_.isAir()) {
            return true;
        }
        if (p_202020_.isSolidRender(p_202018_, p_202019_)) {
            return false;
        }
        if (!p_202020_.getFluidState().isEmpty()) {
            return false;
        }
        VoxelShape voxelshape = p_202020_.getCollisionShape(p_202018_, p_202019_);
        return !Shapes.joinIsNotEmpty((VoxelShape)REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, (VoxelShape)voxelshape, (BooleanOp)BooleanOp.AND);
    }
}