/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.decoration.ArmorStand
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseEntityBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityTicker
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class ObsidianExplosionTrapBricks
extends BaseEntityBlock {
    public static final MapCodec<ObsidianExplosionTrapBricks> CODEC = ObsidianExplosionTrapBricks.simpleCodec(ObsidianExplosionTrapBricks::new);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public MapCodec<ObsidianExplosionTrapBricks> codec() {
        return CODEC;
    }

    public ObsidianExplosionTrapBricks(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(LIT, false));
    }

    public boolean isRandomlyTicking(BlockState state) {
        return (Boolean)state.getValue((Property)LIT);
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if (((Boolean)state.getValue((Property)LIT)).booleanValue()) {
            worldIn.setBlock(pos, (BlockState)state.setValue(LIT, false), 3);
        }
    }

    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        ObsidianExplosionTrapBricks.activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        if (((Boolean)stateIn.getValue((Property)LIT)).booleanValue()) {
            ObsidianExplosionTrapBricks.spawnParticles(worldIn, pos);
        }
    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

    private static void spawnParticles(Level world, BlockPos worldIn) {
        double d0 = 0.5625;
        RandomSource random = world.getRandom();
        for (Direction direction : Direction.values()) {
            BlockPos blockpos = worldIn.relative(direction);
            if (world.getBlockState(blockpos).isSolidRender()) continue;
            Direction.Axis direction$axis = direction.getAxis();
            double d1 = direction$axis == Direction.Axis.X ? 0.5 + d0 * (double)direction.getStepX() : (double)random.nextFloat();
            double d2 = direction$axis == Direction.Axis.Y ? 0.5 + d0 * (double)direction.getStepY() : (double)random.nextFloat();
            double d3 = direction$axis == Direction.Axis.Z ? 0.5 + d0 * (double)direction.getStepZ() : (double)random.nextFloat();
            world.addParticle((ParticleOptions)ParticleTypes.REVERSE_PORTAL, (double)worldIn.getX() + d1, (double)worldIn.getY() + d2, (double)worldIn.getZ() + d3, 0.0, 0.0, 0.0);
        }
    }

    public static boolean shouldTrigger(Entity entity) {
        if (entity instanceof LivingEntity && !entity.getType().builtInRegistryHolder().is(ModTag.TRAP_BLOCK_NOT_DETECTED)) {
            if (entity instanceof Player) {
                return !((Player)entity).isCreative() && !entity.isSpectator();
            }
            return !(entity instanceof ArmorStand);
        }
        return false;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT});
    }

    private static void activate(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!((Boolean)state.getValue((Property)LIT)).booleanValue() && ObsidianExplosionTrapBricks.shouldTrigger(entity)) {
            world.setBlock(pos, (BlockState)state.setValue(LIT, true), 3);
        }
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ObsidianExplosionTrapBricks_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return ObsidianExplosionTrapBricks.createTickerHelper(p_152182_, (BlockEntityType)((BlockEntityType)ModTileentites.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get()), ObsidianExplosionTrapBricks_Block_Entity::commonTick);
    }
}

