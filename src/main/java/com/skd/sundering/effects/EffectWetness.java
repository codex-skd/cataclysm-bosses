/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 */
package com.skd.sundering.effects;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectWetness
extends MobEffect {
    private static final Identifier WETNESS_SPEED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"wetness_speed");

    public EffectWetness() {
        super(MobEffectCategory.HARMFUL, 5928654);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, WETNESS_SPEED, -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.isSensitiveToWater()) {
            LivingEntityIn.hurt(LivingEntityIn.damageSources().magic(), 1.0f);
        }
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int p_295391_, int p_294280_) {
        return true;
    }
}

