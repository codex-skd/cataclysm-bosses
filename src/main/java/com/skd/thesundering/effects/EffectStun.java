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
package com.skd.thesundering.effects;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectStun
extends MobEffect {
    private static final Identifier STUN_SPEED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"stun_speed");

    public EffectStun() {
        super(MobEffectCategory.HARMFUL, 16747520);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, STUN_SPEED, -0.5, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }
}

