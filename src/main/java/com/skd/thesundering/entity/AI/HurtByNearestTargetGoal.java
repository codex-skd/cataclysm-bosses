/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 */
package com.skd.thesundering.entity.AI;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class HurtByNearestTargetGoal
extends HurtByTargetGoal {
    public HurtByNearestTargetGoal(PathfinderMob creatureIn, Class<?> ... excludeReinforcementTypes) {
        super(creatureIn, (Class[])excludeReinforcementTypes);
    }

    public boolean canUse() {
        return super.canUse();
    }

    public boolean canContinueToUse() {
        if (!super.canContinueToUse()) {
            return false;
        }
        LivingEntity revengeTarget = this.mob.getLastHurtByMob();
        if (super.canUse() && revengeTarget != this.targetMob && this.targetMob != null && revengeTarget != null && this.mob.distanceToSqr((Entity)revengeTarget) < this.mob.distanceToSqr((Entity)this.targetMob)) {
            this.mob.setLastHurtMob((Entity)this.targetMob);
            return false;
        }
        return true;
    }
}

