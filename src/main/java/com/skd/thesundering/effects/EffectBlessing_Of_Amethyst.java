/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.thesundering.effects;

import com.skd.thesundering.init.ModEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class EffectBlessing_Of_Amethyst
extends MobEffect {
    public EffectBlessing_Of_Amethyst() {
        super(MobEffectCategory.BENEFICIAL, 16698342);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.hasEffect(ModEffect.EFFECTABYSSAL_BURN)) {
            LivingEntityIn.removeEffect(ModEffect.EFFECTABYSSAL_BURN);
        }
        if (LivingEntityIn.hasEffect(ModEffect.EFFECTABYSSAL_FEAR)) {
            LivingEntityIn.removeEffect(ModEffect.EFFECTABYSSAL_FEAR);
        }
        if (LivingEntityIn.hasEffect(MobEffects.DARKNESS)) {
            LivingEntityIn.removeEffect(MobEffects.DARKNESS);
        }
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }
}

