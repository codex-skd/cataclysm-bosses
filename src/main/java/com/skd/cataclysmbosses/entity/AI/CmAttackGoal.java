/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 */
package com.skd.cataclysmbosses.entity.AI;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CmAttackGoal
extends MeleeAttackGoal {
    private LivingEntity target;
    private int delayCounter;
    protected final double moveSpeed;

    public CmAttackGoal(PathfinderMob creatureEntity, double moveSpeed) {
        super(creatureEntity, moveSpeed, true);
        this.moveSpeed = moveSpeed;
    }

    public boolean canUse() {
        this.target = this.mob.getTarget();
        return this.target != null && this.target.isAlive();
    }

    public void stop() {
        this.mob.getNavigation().stop();
        if (this.mob.getTarget() == null) {
            this.mob.setAggressive(false);
            this.mob.getNavigation().stop();
        }
    }

    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if (target == null) {
            return;
        }
        this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
        double distSq = this.mob.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
        if (--this.delayCounter <= 0) {
            this.delayCounter = 4 + this.mob.getRandom().nextInt(7);
            if (distSq > Math.pow(this.mob.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0)) {
                if (!this.mob.isPathFinding() && !this.mob.getNavigation().moveTo((Entity)target, 1.0)) {
                    this.delayCounter += 5;
                }
            } else {
                this.mob.getNavigation().moveTo((Entity)target, this.moveSpeed);
            }
        }
    }
}

