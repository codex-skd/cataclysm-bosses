/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.sundering.util;

import java.util.Arrays;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

public class EntityExcludedDamageSource
extends DamageSource {
    protected final List<EntityType<?>> entities;

    public EntityExcludedDamageSource(Holder<DamageType> type, EntityType<?> ... entities) {
        super(type);
        this.entities = Arrays.stream(entities).toList();
    }

    public Component getLocalizedDeathMessage(LivingEntity living) {
        LivingEntity livingentity = living.getKillCredit();
        String s = "death.attack." + this.type().msgId();
        String s1 = s + ".player";
        if (livingentity != null) {
            for (EntityType<?> entity : this.entities) {
                if (livingentity.getType() != entity) continue;
                return Component.translatable((String)s, (Object[])new Object[]{living.getDisplayName()});
            }
        }
        return livingentity != null ? Component.translatable((String)s1, (Object[])new Object[]{living.getDisplayName(), livingentity.getDisplayName()}) : Component.translatable((String)s, (Object[])new Object[]{living.getDisplayName()});
    }
}

