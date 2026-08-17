/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectCategory
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 */
package com.skd.thesundering.effects;

import com.skd.thesundering.init.ModEffect;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectGhostForm
extends MobEffect {
    private int lastDuration = -1;
    private static final Identifier GHOST_SPEED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ghost_speed");

    public EffectGhostForm() {
        super(MobEffectCategory.BENEFICIAL, 3789490);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, GHOST_SPEED, 0.4, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (this.lastDuration == 1) {
            LivingEntityIn.addEffect(new MobEffectInstance(ModEffect.EFFECTGHOST_SICKNESS, 7200, 0, false, false, true));
        }
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int p_295734_) {
        this.lastDuration = duration;
        return duration > 0;
    }
}

