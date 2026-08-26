/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.cataclysmbosses.blocks;

import com.skd.cataclysmbosses.blocks.TrapBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class EndStoneTeleportTrapBricks
extends TrapBlock {
    public EndStoneTeleportTrapBricks(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        EndStoneTeleportTrapBricks.activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    private static void activate(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!((Boolean)state.getValue((Property)LIT)).booleanValue() && EndStoneTeleportTrapBricks.shouldTrigger(entity)) {
            double d0 = entity.getX() + (entitylevel().getRandom().nextDouble() - 0.5) * 16.0;
            double d1 = entity.getY();
            double d2 = entity.getZ() + (entitylevel().getRandom().nextDouble() - 0.5) * 16.0;
            ((LivingEntity)entity).randomTeleport(d0, d1, d2, false);
            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 25));
            world.setBlock(pos, (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(true)), 3);
            world.playSound(null, pos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }
}

