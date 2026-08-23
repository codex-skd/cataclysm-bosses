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
package com.skd.cataclysmbosses.effects;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectBone_Fracture
extends MobEffect {
    private static final Identifier BONE_FRACTURE_SPEED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"bone_fracture_speed");
    private static final Identifier BONE_FRACTURE_ATTACK_SPEED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"bone_fracture_attack_speed");

    public EffectBone_Fracture() {
        super(MobEffectCategory.HARMFUL, 0xADABAD);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, BONE_FRACTURE_SPEED, -0.02, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, BONE_FRACTURE_ATTACK_SPEED, -0.15, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }
}

