/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.pathfinder.Node
 *  net.minecraft.world.level.pathfinder.Path
 *  net.neoforged.neoforge.common.ItemAbilities
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Goals;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import java.util.EnumSet;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.neoforged.neoforge.common.ItemAbilities;

public class Royal_DraugrAttackGoal
extends Goal {
    protected final Royal_Draugr_Entity mob;
    private final double speedModifier;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private double pathedTargetX;
    private double pathedTargetY;
    private double pathedTargetZ;
    private int ticksUntilNextPathRecalculation;
    private int ticksUntilNextAttack;
    private final int attackInterval = 20;
    private long lastCanUseCheck;
    private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 20L;
    private int failedPathFindingPenalty = 0;
    private boolean canPenalize = false;

    public Royal_DraugrAttackGoal(Royal_Draugr_Entity p_25552_, double p_25553_, boolean p_25554_) {
        this.mob = p_25552_;
        this.speedModifier = p_25553_;
        this.followingTargetEvenIfNotSeen = p_25554_;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        long i = this.mob.level().getGameTime();
        if (i - this.lastCanUseCheck < 20L) {
            return false;
        }
        this.lastCanUseCheck = i;
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity == null) {
            return false;
        }
        if (!livingentity.isAlive()) {
            return false;
        }
        if (this.canPenalize) {
            if (--this.ticksUntilNextPathRecalculation <= 0) {
                this.path = this.mob.getNavigation().createPath((Entity)livingentity, 0);
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                return this.path != null;
            }
            return true;
        }
        this.path = this.mob.getNavigation().createPath((Entity)livingentity, 0);
        if (this.path != null) {
            return true;
        }
        return this.getAttackReachSqr(livingentity) >= this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
    }

    public boolean canContinueToUse() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity == null) {
            return false;
        }
        if (!livingentity.isAlive()) {
            return false;
        }
        if (!this.followingTargetEvenIfNotSeen) {
            return !this.mob.getNavigation().isDone();
        }
        if (!this.mob.isWithinHome(livingentity.blockPosition())) {
            return false;
        }
        return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
    }

    public void start() {
        this.mob.getNavigation().moveTo(this.path, this.speedModifier);
        this.mob.setAggressive(true);
        this.ticksUntilNextPathRecalculation = 0;
        this.ticksUntilNextAttack = 0;
    }

    public void stop() {
        LivingEntity livingentity = this.mob.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.mob.setTarget(null);
        }
        this.mob.setAggressive(false);
        this.mob.getNavigation().stop();
        if (this.mob.isDraugrBlocking()) {
            this.mob.stopUsingItem();
            this.mob.setShieldCooldownTime(60);
        }
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity != null) {
            this.mob.getLookControl().setLookAt((Entity)livingentity, 30.0f, 30.0f);
            double d0 = this.mob.distanceToSqr((Entity)livingentity);
            this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
            if (!this.isShieldDisabled(this.mob) && this.mob.getOffhandItem().getUseAnimation() == net.minecraft.world.item.ItemUseAnimation.BLOCK && this.mob.getRandom().nextInt(6) == 0) {
                this.mob.startUsingItem(InteractionHand.OFF_HAND);
            }
            if ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().hasLineOfSight((Entity)livingentity)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0 && this.pathedTargetY == 0.0 && this.pathedTargetZ == 0.0 || livingentity.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0 || this.mob.getRandom().nextFloat() < 0.05f)) {
                this.pathedTargetX = livingentity.getX();
                this.pathedTargetY = livingentity.getY();
                this.pathedTargetZ = livingentity.getZ();
                this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                if (this.canPenalize) {
                    Node finalPathPoint;
                    this.ticksUntilNextPathRecalculation += this.failedPathFindingPenalty;
                    this.failedPathFindingPenalty = this.mob.getNavigation().getPath() != null ? ((finalPathPoint = this.mob.getNavigation().getPath().getEndNode()) != null && livingentity.distanceToSqr((double)finalPathPoint.x, (double)finalPathPoint.y, (double)finalPathPoint.z) < 1.0 ? 0 : (this.failedPathFindingPenalty += 10)) : (this.failedPathFindingPenalty += 10);
                }
                if (d0 > 1024.0) {
                    this.ticksUntilNextPathRecalculation += 10;
                } else if (d0 > 256.0) {
                    this.ticksUntilNextPathRecalculation += 5;
                }
                if (!this.mob.getNavigation().moveTo((Entity)livingentity, this.speedModifier)) {
                    this.ticksUntilNextPathRecalculation += 15;
                }
                this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
            }
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            this.checkAndPerformAttack(livingentity, d0);
        }
    }

    public boolean isShieldDisabled(Royal_Draugr_Entity shieldUser) {
        return shieldUser.isShieldDisabled();
    }

    protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
        double d0 = this.getAttackReachSqr(p_25557_);
        if (p_25558_ <= d0 && this.ticksUntilNextAttack <= 0) {
            this.resetAttackCooldown();
            if (this.mob.isDraugrBlocking()) {
                this.mob.stopUsingItem();
                this.mob.setShieldCooldownTime(30);
            }
            this.mob.swing(InteractionHand.MAIN_HAND);
            if (this.mob.level() instanceof net.minecraft.server.level.ServerLevel _sl) this.mob.doHurtTarget(_sl, (Entity)p_25557_);
        }
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(20);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }

    protected int getAttackInterval() {
        return this.adjustedTickDelay(20);
    }

    protected double getAttackReachSqr(LivingEntity p_25556_) {
        float f = this.mob.getBbWidth();
        return f * 2.25f * f * 2.25f + p_25556_.getBbWidth();
    }
}

