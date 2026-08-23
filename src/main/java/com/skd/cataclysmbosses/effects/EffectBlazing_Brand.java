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

public class EffectBlazing_Brand
extends MobEffect {
    private static final Identifier ARMOR_DOWN_ID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"blazing_brand_armor");
    private static final Identifier ARMOR_TOUGHNESS_DOWN_ID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"blazing_brand_armor_toughness");

    public EffectBlazing_Brand() {
        super(MobEffectCategory.HARMFUL, 14423100);
        this.addAttributeModifier(Attributes.ARMOR, ARMOR_DOWN_ID, -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ARMOR_TOUGHNESS_DOWN_ID, -0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }
}

