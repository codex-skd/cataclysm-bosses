/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.CollisionGetter
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.level.pathfinder.PathfindingContext
 *  net.minecraft.world.level.pathfinder.WalkNodeEvaluator
 */
package com.skd.cataclysmbosses.entity.Pet.AI;

import com.skd.cataclysmbosses.entity.Pet.AnimationPet;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfindingContext;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

public class TameableAIFollowOwnerWater
extends Goal {
    private final AnimationPet tameable;
    private final LevelReader world;
    private final double followSpeed;
    private final float maxDist;
    private final float minDist;
    private final boolean teleportToLeaves;
    private LivingEntity owner;
    private int timeToRecalcPath;
    private float oldWaterCost;

    public TameableAIFollowOwnerWater(AnimationPet tamed, double speed, float minDist, float maxDist, boolean leaves) {
        this.tameable = tamed;
        this.world = tamed.level();
        this.followSpeed = speed;
        this.minDist = minDist;
        this.maxDist = maxDist;
        this.teleportToLeaves = leaves;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        LivingEntity lvt_1_1_ = this.tameable.getOwner();
        if (lvt_1_1_ == null) {
            return false;
        }
        if (lvt_1_1_.isSpectator()) {
            return false;
        }
        if (!this.tameable.shouldFollow() || this.isInCombat()) {
            return false;
        }
        if (this.tameable.distanceToSqr((Entity)lvt_1_1_) < (double)(this.minDist * this.minDist)) {
            return false;
        }
        if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        }
        this.owner = lvt_1_1_;
        return true;
    }

    public boolean canContinueToUse() {
        if (this.tameable.getNavigation().isDone() || this.isInCombat()) {
            return false;
        }
        if (!this.tameable.shouldFollow()) {
            return false;
        }
        if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        }
        return this.tameable.distanceToSqr((Entity)this.owner) > (double)(this.maxDist * this.maxDist);
    }

    private boolean isInCombat() {
        LivingEntity owner = this.tameable.getOwner();
        if (owner != null) {
            return this.tameable.distanceTo((Entity)owner) < 30.0f && this.tameable.getTarget() != null && this.tameable.getTarget().isAlive();
        }
        return false;
    }

    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameable.getPathfindingMalus(PathType.WATER);
        this.tameable.setPathfindingMalus(PathType.WATER, 0.0f);
    }

    public void stop() {
        this.owner = null;
        this.tameable.getNavigation().stop();
        this.tameable.setPathfindingMalus(PathType.WATER, this.oldWaterCost);
    }

    public void tick() {
        this.tameable.getLookControl().setLookAt((Entity)this.owner, 10.0f, (float)this.tameable.getMaxHeadXRot());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.tameable.isLeashed() && !this.tameable.isPassenger()) {
                if (this.tameable.distanceToSqr((Entity)this.owner) >= 144.0) {
                    this.tryToTeleportNearEntity();
                } else {
                    this.tameable.getNavigation().moveTo((Entity)this.owner, this.followSpeed);
                }
            }
        }
    }

    private void tryToTeleportNearEntity() {
        BlockPos lvt_1_1_ = this.owner.blockPosition();
        for (int lvt_2_1_ = 0; lvt_2_1_ < 10; ++lvt_2_1_) {
            int lvt_3_1_ = this.getRandomNumber(-3, 3);
            int lvt_4_1_ = this.getRandomNumber(-1, 1);
            int lvt_5_1_ = this.getRandomNumber(-3, 3);
            boolean lvt_6_1_ = this.tryToTeleportToLocation(lvt_1_1_.getX() + lvt_3_1_, lvt_1_1_.getY() + lvt_4_1_, lvt_1_1_.getZ() + lvt_5_1_);
            if (!lvt_6_1_) continue;
            return;
        }
    }

    private boolean tryToTeleportToLocation(int p_226328_1_, int p_226328_2_, int p_226328_3_) {
        if (Math.abs((double)p_226328_1_ - this.owner.getX()) < 2.0 && Math.abs((double)p_226328_3_ - this.owner.getZ()) < 2.0) {
            return false;
        }
        if (!this.isTeleportFriendlyBlock(new BlockPos(p_226328_1_, p_226328_2_, p_226328_3_))) {
            return false;
        }
        this.tameable.moveTo((double)p_226328_1_ + 0.5, p_226328_2_, (double)p_226328_3_ + 0.5, this.tameable.getYRot(), this.tameable.getXRot());
        this.tameable.getNavigation().stop();
        return true;
    }

    private boolean isTeleportFriendlyBlock(BlockPos pos) {
        PathfindingContext pathfindingcontext = new PathfindingContext((CollisionGetter)this.world, (Mob)this.tameable);
        PathType blockPathType = WalkNodeEvaluator.getPathTypeStatic((PathfindingContext)pathfindingcontext, (BlockPos.MutableBlockPos)pos.mutable());
        if (this.world.getFluidState(pos).is(FluidTags.WATER) || !this.world.getFluidState(pos).is(FluidTags.WATER) && this.world.getFluidState(pos.below()).is(FluidTags.WATER)) {
            return true;
        }
        if (blockPathType != PathType.WALKABLE || this.avoidsLand()) {
            return false;
        }
        BlockState lvt_3_1_ = this.world.getBlockState(pos.below());
        if (!this.teleportToLeaves && lvt_3_1_.getBlock() instanceof LeavesBlock) {
            return false;
        }
        BlockPos lvt_4_1_ = pos.subtract((Vec3i)this.tameable.blockPosition());
        return this.world.noCollision((Entity)this.tameable, this.tameable.getBoundingBox().move(lvt_4_1_));
    }

    public boolean avoidsLand() {
        return false;
    }

    private int getRandomNumber(int p_226327_1_, int p_226327_2_) {
        return this.tameable.getRandom().nextInt(p_226327_2_ - p_226327_1_ + 1) + p_226327_1_;
    }
}

