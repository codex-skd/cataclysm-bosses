/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.animal.Fox
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.entity.EntityTeleportEvent$ChorusFruit
 */
package com.skd.cataclysmbosses.effects;

import com.skd.cataclysmbosses.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;

public class EffectAbyssal_Burn
extends MobEffect {
    public EffectAbyssal_Burn() {
        super(MobEffectCategory.HARMFUL, 6619391);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        boolean flag = LivingEntityIn.hurt(LivingEntityIn.damageSources().source(CMDamageTypes.ABYSSAL_BURN), 1.0f);
        if (flag && LivingEntityIn.getRandom().nextFloat() < 0.75f - LivingEntityIn.getHealth() / LivingEntityIn.getMaxHealth() && !LivingEntityIn.level().isClientSide()) {
            double d0 = LivingEntityIn.getX();
            double d1 = LivingEntityIn.getY();
            double d2 = LivingEntityIn.getZ();
            for (int i = 0; i < 8; ++i) {
                double d3 = LivingEntityIn.getX() + (LivingEntityIn.getRandom().nextDouble() - 0.5) * 8.0;
                double d4 = Mth.clamp((double)(LivingEntityIn.getY() + (double)(LivingEntityIn.getRandom().nextInt(8) - 4)), (double)LivingEntityIn.level().getMinBuildHeight(), (double)(LivingEntityIn.level().getMinBuildHeight() + ((ServerLevel)LivingEntityIn.level()).getLogicalHeight() - 1));
                double d5 = LivingEntityIn.getZ() + (LivingEntityIn.getRandom().nextDouble() - 0.5) * 8.0;
                if (LivingEntityIn.isPassenger()) {
                    LivingEntityIn.stopRiding();
                }
                Vec3 vec3 = LivingEntityIn.position();
                LivingEntityIn.level().gameEvent((Holder)GameEvent.TELEPORT, vec3, GameEvent.Context.of((Entity)LivingEntityIn));
                EntityTeleportEvent.ChorusFruit event = new EntityTeleportEvent.ChorusFruit(LivingEntityIn, d3, d4, d5);
                if (!this.randomTeleportInwater(LivingEntityIn, event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) continue;
                SoundEvent soundevent = LivingEntityIn instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                LivingEntityIn.level().playSound((Player)null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0f, 1.0f);
                LivingEntityIn.playSound(soundevent, 1.0f, 1.0f);
                break;
            }
        }
        return true;
    }

    private boolean randomTeleportInwater(LivingEntity LivingEntityIn, double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = LivingEntityIn.getX();
        double d1 = LivingEntityIn.getY();
        double d2 = LivingEntityIn.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing((double)p_20985_, (double)p_20986_, (double)p_20987_);
        Level level = LivingEntityIn.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;
            while (!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                    continue;
                }
                d3 -= 1.0;
                blockpos = blockpos1;
            }
            if (flag1) {
                LivingEntityIn.teleportTo(p_20985_, d3, p_20987_);
                if (level.noCollision((Entity)LivingEntityIn)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            LivingEntityIn.teleportTo(d0, d1, d2);
            return false;
        }
        if (p_20988_) {
            level.broadcastEntityEvent((Entity)LivingEntityIn, (byte)46);
        }
        if (LivingEntityIn instanceof PathfinderMob) {
            ((PathfinderMob)LivingEntityIn).getNavigation().stop();
        }
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i > 0 ? p_295629_ % i == 0 : true;
    }
}

