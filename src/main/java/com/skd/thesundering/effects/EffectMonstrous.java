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

public class EffectMonstrous
extends MobEffect {
    private static final Identifier MONSTROUS_KNOCKBACK = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"monstrous_knockback");
    private static final Identifier MONSTROUS_ARMOR = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"monstrous_armor");
    private static final Identifier MONSTROUS_ARMOR_TOUGHNESS = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"monstrous_armor_toughness");

    public EffectMonstrous() {
        super(MobEffectCategory.BENEFICIAL, 8803127);
        this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, MONSTROUS_KNOCKBACK, 0.5, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR, MONSTROUS_ARMOR, 3.0, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, MONSTROUS_ARMOR_TOUGHNESS, 2.0, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.getHealth() < LivingEntityIn.getMaxHealth() * 1.0f / 2.0f) {
            LivingEntityIn.heal(1.0f);
        }
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        }
        return true;
    }
}

