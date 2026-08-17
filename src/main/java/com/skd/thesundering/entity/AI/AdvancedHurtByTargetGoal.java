/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 */
package com.skd.thesundering.entity.AI;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class AdvancedHurtByTargetGoal
extends HurtByTargetGoal {
    private int forcedAggroTime;
    private float intensity;

    public AdvancedHurtByTargetGoal(PathfinderMob mob, Class<?> ... ToIgnoreDamage) {
        super(mob, (Class[])ToIgnoreDamage);
    }

    public void tick() {
        super.tick();
        if (this.timestamp != this.mob.getLastHurtByMobTimestamp()) {
            this.timestamp = this.mob.getLastHurtByMobTimestamp();
            if (this.mob.getLastHurtByMob() != this.targetMob) {
                this.forcedAggroTime -= 20;
            } else {
                this.forcedAggroTime += (int)(20.0f * this.intensity);
                this.intensity *= 0.8f;
            }
        }
    }

    public void start() {
        super.start();
        this.forcedAggroTime = 40 + this.mob.getRandom().nextInt(140);
        this.intensity = 1.0f;
    }

    public boolean canContinueToUse() {
        return --this.forcedAggroTime > 0 && super.canContinueToUse();
    }
}

