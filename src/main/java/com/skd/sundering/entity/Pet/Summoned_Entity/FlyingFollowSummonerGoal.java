/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.level.pathfinder.WalkNodeEvaluator
 */
package com.skd.sundering.entity.Pet.Summoned_Entity;

import com.skd.sundering.entity.Pet.Summoned_Entity.Abstract_Summoned_Entity;
import com.skd.sundering.entity.etc.IFollower;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

public class FlyingFollowSummonerGoal
extends Goal {
    private final Abstract_Summoned_Entity tameAnimal;
    private LivingEntity owner;
    private final LevelReader world;
    private final double followSpeed;
    private final PathNavigation navigator;
    private int timeToRecalcPath;
    private final float maxDist;
    private final float minDist;
    private float oldWaterCost;
    private final boolean teleportToLeaves;
    private final IFollower follower;

    public FlyingFollowSummonerGoal(Abstract_Summoned_Entity tameAnimal, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
        this.tameAnimal = tameAnimal;
        this.world = tameAnimal.level();
        this.followSpeed = speed;
        this.navigator = tameAnimal.getNavigation();
        this.minDist = minDist;
        this.maxDist = maxDist;
        this.teleportToLeaves = teleportToLeaves;
        this.follower = tameAnimal;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.tameAnimal.getOwner();
        if (livingentity == null) {
            return false;
        }
        if (livingentity.isSpectator()) {
            return false;
        }
        if (this.tameAnimal.distanceToSqr((Entity)livingentity) < (double)(this.minDist * this.minDist) || this.isInCombat()) {
            return false;
        }
        this.owner = livingentity;
        return this.follower.shouldFollow();
    }

    public boolean canContinueToUse() {
        if (this.isInCombat()) {
            return false;
        }
        return this.tameAnimal.distanceToSqr((Entity)this.owner) > (double)(this.maxDist * this.maxDist);
    }

    private boolean isInCombat() {
        LivingEntity owner = this.tameAnimal.getOwner();
        if (owner != null) {
            return this.tameAnimal.distanceTo((Entity)owner) < 30.0f && this.tameAnimal.getTarget() != null && this.tameAnimal.getTarget().isAlive();
        }
        return false;
    }

    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameAnimal.getPathfindingMalus(PathType.WATER);
        this.tameAnimal.setPathfindingMalus(PathType.WATER, 0.0f);
    }

    public void stop() {
        this.owner = null;
        this.navigator.stop();
        this.tameAnimal.setPathfindingMalus(PathType.WATER, this.oldWaterCost);
    }

    public void tick() {
        this.tameAnimal.getLookControl().setLookAt((Entity)this.owner, 10.0f, (float)this.tameAnimal.getMaxHeadXRot());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.tameAnimal.isLeashed() && !this.tameAnimal.isPassenger()) {
                if (this.tameAnimal.distanceToSqr((Entity)this.owner) >= 144.0) {
                    this.tryToTeleportNearEntity();
                }
                this.follower.followEntity(this.tameAnimal, this.owner, this.followSpeed);
            }
        }
    }

    private void tryToTeleportNearEntity() {
        BlockPos blockpos = this.owner.blockPosition();
        for (int i = 0; i < 10; ++i) {
            int j = this.getRandomNumber(-3, 3);
            int k = this.getRandomNumber(-1, 1);
            int l = this.getRandomNumber(-3, 3);
            boolean flag = this.tryToTeleportToLocation(blockpos.getX() + j, blockpos.getY() + k, blockpos.getZ() + l);
            if (!flag) continue;
            return;
        }
    }

    private boolean tryToTeleportToLocation(int x, int y, int z) {
        if (Math.abs((double)x - this.owner.getX()) < 2.0 && Math.abs((double)z - this.owner.getZ()) < 2.0) {
            return false;
        }
        if (!this.isTeleportFriendlyBlock(new BlockPos(x, y, z))) {
            return false;
        }
        this.tameAnimal.moveTo((double)x + 0.5, y, (double)z + 0.5, this.tameAnimal.getYRot(), this.tameAnimal.getXRot());
        this.navigator.stop();
        return true;
    }

    private boolean isTeleportFriendlyBlock(BlockPos pos) {
        if (this.world.getBlockState(pos).isAir()) {
            BlockPos blockpos = pos.subtract((Vec3i)this.tameAnimal.blockPosition());
            return this.world.noCollision((Entity)this.tameAnimal, this.tameAnimal.getBoundingBox().move(blockpos));
        }
        PathType pathnodetype = WalkNodeEvaluator.getPathTypeStatic((Mob)this.tameAnimal, (BlockPos)pos);
        if (pathnodetype != PathType.WALKABLE) {
            return false;
        }
        BlockState blockstate = this.world.getBlockState(pos.below());
        if (!this.teleportToLeaves && blockstate.getBlock() instanceof LeavesBlock) {
            return false;
        }
        BlockPos blockpos = pos.subtract((Vec3i)this.tameAnimal.blockPosition());
        return this.world.noCollision((Entity)this.tameAnimal, this.tameAnimal.getBoundingBox().move(blockpos));
    }

    private int getRandomNumber(int min, int max) {
        return this.tameAnimal.getRandom().nextInt(max - min + 1) + min;
    }
}

