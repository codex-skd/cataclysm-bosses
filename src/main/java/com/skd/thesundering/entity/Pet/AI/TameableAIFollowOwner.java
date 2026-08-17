/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.goal.FollowOwnerGoal
 */
package com.skd.thesundering.entity.Pet.AI;

import com.skd.thesundering.entity.etc.IFollower;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;

public class TameableAIFollowOwner
extends FollowOwnerGoal {
    private final IFollower follower;
    private final TamableAnimal tameable;

    public TameableAIFollowOwner(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
        super(tameable, speed, minDist, maxDist);
        this.follower = (IFollower)tameable;
        this.tameable = tameable;
    }

    public boolean canUse() {
        return super.canUse() && this.follower.shouldFollow() && !this.isInCombat();
    }

    public boolean canContinueToUse() {
        return super.canContinueToUse() && this.follower.shouldFollow() && !this.isInCombat();
    }

    private boolean isInCombat() {
        LivingEntity owner = this.tameable.getOwner();
        if (owner != null) {
            return this.tameable.distanceTo((Entity)owner) < 30.0f && this.tameable.getTarget() != null && this.tameable.getTarget().isAlive();
        }
        return false;
    }
}

