/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.pathfinder.Path
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;

public class InternalMoveGoal
extends Goal {
    private final Internal_Animation_Monster monster;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private int delayCounter;
    protected final double moveSpeed;

    public InternalMoveGoal(Internal_Animation_Monster boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
        this.monster = boss;
        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
        this.moveSpeed = moveSpeed;
        this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity target = this.monster.getTarget();
        return target != null && target.isAlive();
    }

    public void stop() {
        this.monster.getNavigation().stop();
        LivingEntity livingentity = this.monster.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.monster.setTarget(null);
        }
        this.monster.setAggressive(false);
    }

    public boolean canContinueToUse() {
        LivingEntity target = this.monster.getTarget();
        if (target == null) {
            return false;
        }
        if (!target.isAlive()) {
            return false;
        }
        if (!this.followingTargetEvenIfNotSeen) {
            return !this.monster.getNavigation().isDone();
        }
        if (!this.monster.isWithinHome(target.blockPosition())) {
            return false;
        }
        return !(target instanceof Player) || !target.isSpectator() && !((Player)target).isCreative();
    }

    public void start() {
        this.monster.getNavigation().moveTo(this.path, this.moveSpeed);
        this.monster.setAggressive(true);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.monster.getTarget();
        if (target != null) {
            this.monster.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            double distSq = this.monster.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
            if (--this.delayCounter <= 0) {
                this.delayCounter = 4 + this.monster.getRandom().nextInt(7);
                if (distSq > Math.pow(this.monster.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0)) {
                    if (!this.monster.isPathFinding() && !this.monster.getNavigation().moveTo((Entity)target, 1.0)) {
                        this.delayCounter += 5;
                    }
                } else {
                    this.monster.getNavigation().moveTo((Entity)target, this.moveSpeed);
                }
            }
        }
    }
}

