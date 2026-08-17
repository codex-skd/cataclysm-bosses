/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.decoration.ArmorStand
 *  net.minecraft.world.entity.player.Player
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
package com.skd.thesundering.blocks;

import com.skd.thesundering.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
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

public class Sandstone_Ignite_Trap
extends BaseEntityBlock {
    public static final MapCodec<Sandstone_Ignite_Trap> CODEC = Sandstone_Ignite_Trap.simpleCodec(Sandstone_Ignite_Trap::new);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public Sandstone_Ignite_Trap(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue((Property)LIT, (Comparable)Boolean.valueOf(false)));
    }

    public MapCodec<Sandstone_Ignite_Trap> codec() {
        return CODEC;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return (Boolean)state.getValue((Property)LIT);
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if (((Boolean)state.getValue((Property)LIT)).booleanValue()) {
            worldIn.setBlock(pos, (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(false)), 3);
        }
    }

    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        Sandstone_Ignite_Trap.activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

    public static boolean shouldTrigger(Entity entity) {
        if (entity instanceof LivingEntity && !entity.getType().is(ModTag.SANDSTONE_TRAP_NOT_DETECTED)) {
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
        if (!((Boolean)state.getValue((Property)LIT)).booleanValue() && Sandstone_Ignite_Trap.shouldTrigger(entity)) {
            world.setBlock(pos, (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(true)), 3);
            world.playLocalSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, (SoundEvent)ModSounds.FLAME_TRAP.get(), SoundSource.BLOCKS, 1.0f + world.random.nextFloat(), world.random.nextFloat() * 0.7f + 0.3f, false);
        }
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SandstoneIgniteTrap_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return Sandstone_Ignite_Trap.createTickerHelper(p_152182_, (BlockEntityType)((BlockEntityType)ModTileentites.SANDSTONE_IGNITE_TRAP.get()), SandstoneIgniteTrap_Block_Entity::commonTick);
    }
}

