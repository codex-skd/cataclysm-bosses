/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.cataclysmbosses.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerLevel;

public class EffectGhost_Sickness
extends MobEffect {
    public EffectGhost_Sickness() {
        super(MobEffectCategory.HARMFUL, 9722673);
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return tickCount % k == 0;
        }
        return true;
    }
}

