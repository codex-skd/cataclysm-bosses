/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 */
package com.skd.thesundering.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EffectCurse_Of_Desert
extends MobEffect {
    public EffectCurse_Of_Desert() {
        super(MobEffectCategory.HARMFUL, 16773835);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }
}

