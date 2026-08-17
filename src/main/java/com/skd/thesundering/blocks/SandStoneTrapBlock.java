/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.decoration.ArmorStand
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.blocks;

import com.skd.thesundering.init.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class SandStoneTrapBlock
extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public SandStoneTrapBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue((Property)LIT, (Comparable)Boolean.valueOf(false)));
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
        super.stepOn(worldIn, pos, state, entityIn);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
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
}

