/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.pathfinder.Path
 */
package com.skd.sundering.entity.AnimationMonster.AI;

import com.skd.sundering.entity.AnimationMonster.LLibrary_Monster;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;

public class AttackMoveGoal
extends Goal {
    private final LLibrary_Monster Boss_monster;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private int delayCounter;
    protected final double moveSpeed;

    public AttackMoveGoal(LLibrary_Monster boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
        this.Boss_monster = boss;
        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
        this.moveSpeed = moveSpeed;
        this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity target = this.Boss_monster.getTarget();
        return target != null && target.isAlive() && this.Boss_monster.getAnimation() == IAnimatedEntity.NO_ANIMATION;
    }

    public void stop() {
        this.Boss_monster.getNavigation().stop();
        LivingEntity livingentity = this.Boss_monster.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.Boss_monster.setTarget(null);
        }
        this.Boss_monster.setAggressive(false);
    }

    public boolean canContinueToUse() {
        LivingEntity target = this.Boss_monster.getTarget();
        if (target == null) {
            return false;
        }
        if (!target.isAlive()) {
            return false;
        }
        if (!this.followingTargetEvenIfNotSeen) {
            return !this.Boss_monster.getNavigation().isDone();
        }
        if (!this.Boss_monster.isWithinRestriction(target.blockPosition())) {
            return false;
        }
        return !(target instanceof Player) || !target.isSpectator() && !((Player)target).isCreative();
    }

    public void start() {
        this.Boss_monster.getNavigation().moveTo(this.path, this.moveSpeed);
        this.Boss_monster.setAggressive(true);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.Boss_monster.getTarget();
        if (target != null) {
            this.Boss_monster.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            double distSq = this.Boss_monster.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
            if (--this.delayCounter <= 0) {
                this.delayCounter = 4 + this.Boss_monster.getRandom().nextInt(7);
                if (distSq > Math.pow(this.Boss_monster.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0)) {
                    if (!this.Boss_monster.isPathFinding() && !this.Boss_monster.getNavigation().moveTo((Entity)target, 1.0)) {
                        this.delayCounter += 5;
                    }
                } else {
                    this.Boss_monster.getNavigation().moveTo((Entity)target, this.moveSpeed);
                }
            }
        }
    }
}

