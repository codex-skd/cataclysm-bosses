/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.NodeEvaluator
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClawdianMoveController
extends MoveControl {
    protected ClawdianOperation operation = ClawdianOperation.WAIT;

    public ClawdianMoveController(Mob mob) {
        super(mob);
    }

    public double getSpeedModifier() {
        return super.getSpeedModifier();
    }

    public void setWantedPosition(double x, double y, double z, double speed) {
        this.wantedX = x;
        this.wantedY = y;
        this.wantedZ = z;
        this.speedModifier = speed;
        if (this.operation != ClawdianOperation.JUMPING) {
            this.operation = ClawdianOperation.MOVE_TO;
        }
    }

    public void strafe(float forward, float strafe) {
        this.operation = ClawdianOperation.STRAFE;
        this.strafeForwards = forward;
        this.strafeRight = strafe;
        this.speedModifier = 1.15;
    }

    public void forward(float forward, float speed) {
        this.operation = ClawdianOperation.FORWARD;
        this.strafeForwards = forward;
        this.speedModifier = speed;
    }

    public void tick() {
        if (this.operation == ClawdianOperation.STRAFE) {
            float dz;
            float baseSpeed = (float)this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED);
            float adjustedSpeed = (float)this.speedModifier * baseSpeed;
            float forward = this.strafeForwards;
            float right = this.strafeRight;
            float mag = Mth.sqrt((float)(forward * forward + right * right));
            if (mag < 1.0f) {
                mag = 1.0f;
            }
            float yawRad = this.mob.getYRot() * ((float)Math.PI / 180);
            float sin = Mth.sin((float)yawRad);
            float cos = Mth.cos((float)yawRad);
            float dx = (forward *= adjustedSpeed / mag) * cos - (right *= adjustedSpeed / mag) * sin;
            if (this.isWalkable(dx, dz = right * cos + forward * sin)) {
                this.mob.setSpeed(adjustedSpeed);
                this.mob.setZza(this.strafeForwards);
                this.mob.setXxa(this.strafeRight);
            } else {
                this.mob.setZza(0.0f);
                this.mob.setXxa(0.0f);
            }
            this.operation = ClawdianOperation.WAIT;
        } else if (this.operation == ClawdianOperation.FORWARD) {
            this.strafeRight = 0.0f;
            this.ForwardMoveControl();
            this.operation = ClawdianOperation.WAIT;
        } else if (this.operation == ClawdianOperation.MOVE_TO) {
            this.operation = ClawdianOperation.WAIT;
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedZ - this.mob.getZ();
            double d2 = this.wantedY - this.mob.getY();
            double d3 = d0 * d0 + d2 * d2 + d1 * d1;
            if (d3 < 2.500000277905201E-7) {
                this.mob.setZza(0.0f);
                return;
            }
            float f9 = (float)(Mth.atan2((double)d1, (double)d0) * 180.0 / 3.1415927410125732) - 90.0f;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f9, 90.0f));
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            BlockPos blockpos = this.mob.blockPosition();
            BlockState blockstate = this.mob.level().getBlockState(blockpos);
            VoxelShape voxelshape = blockstate.getCollisionShape((BlockGetter)this.mob.level(), blockpos);
            if (d2 > (double)this.mob.maxUpStep() && d0 * d0 + d1 * d1 < (double)Math.max(1.0f, this.mob.getBbWidth()) || !voxelshape.isEmpty() && this.mob.getY() < voxelshape.max(Direction.Axis.Y) + (double)blockpos.getY() && !blockstate.is(BlockTags.DOORS) && !blockstate.is(BlockTags.FENCES)) {
                this.mob.getJumpControl().jump();
                this.operation = ClawdianOperation.JUMPING;
            }
        } else if (this.operation == ClawdianOperation.JUMPING) {
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            if (this.mob.onGround()) {
                this.operation = ClawdianOperation.WAIT;
            }
        } else {
            this.mob.setZza(0.0f);
        }
    }

    private void ForwardMoveControl() {
        float worldRelZ;
        float speedAttr = (float)this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED);
        float finalSpeed = (float)this.speedModifier * speedAttr;
        float fForward = this.strafeForwards;
        float fStrafe = this.strafeRight;
        float dist = Mth.sqrt((float)(fForward * fForward + fStrafe * fStrafe));
        if (dist < 1.0f) {
            dist = 1.0f;
        }
        float sin = Mth.sin((float)(this.mob.getYRot() * ((float)Math.PI / 180)));
        float cos = Mth.cos((float)(this.mob.getYRot() * ((float)Math.PI / 180)));
        float worldRelX = (fStrafe /= dist) * cos - (fForward /= dist) * sin;
        if (!this.isWalkableForward(worldRelX, worldRelZ = fForward * cos + fStrafe * sin)) {
            this.strafeForwards = 0.0f;
            this.strafeRight = 0.0f;
            this.mob.setZza(0.0f);
            this.mob.setXxa(0.0f);
            this.mob.setSpeed(0.0f);
            return;
        }
        this.mob.setSpeed(finalSpeed);
        this.mob.setZza(fForward *= finalSpeed);
        this.mob.setXxa(fStrafe *= finalSpeed);
    }

    private boolean isWalkableForward(float worldRelX, float worldRelZ) {
        float lenSq = worldRelX * worldRelX + worldRelZ * worldRelZ;
        if (lenSq < 1.0E-5f) {
            return true;
        }
        float lookAheadDist = this.mob.getBbWidth() / 2.0f + 1.2f;
        float len = Mth.sqrt((float)lenSq);
        float checkX = worldRelX / len * lookAheadDist;
        float checkZ = worldRelZ / len * lookAheadDist;
        BlockPos targetPos = BlockPos.containing((double)(this.mob.getX() + (double)checkX), (double)this.mob.getY(), (double)(this.mob.getZ() + (double)checkZ));
        int maxFallDist = 4;
        for (int i = 0; i <= maxFallDist; ++i) {
            boolean isSolid;
            BlockPos checkPos = targetPos.below(i);
            BlockState state = this.mob.level().getBlockState(checkPos);
            boolean bl = isSolid = !state.isAir() && state.getFluidState().isEmpty() && !state.getCollisionShape((BlockGetter)this.mob.level(), checkPos).isEmpty();
            if (!isSolid) continue;
            if (i == 0) {
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isWalkable(float relativeX, float relativeZ) {
        NodeEvaluator nodeevaluator;
        PathNavigation pathnavigation = this.mob.getNavigation();
        return pathnavigation == null || (nodeevaluator = pathnavigation.getNodeEvaluator()) == null || nodeevaluator.getPathType(this.mob, BlockPos.containing((double)(this.mob.getX() + (double)relativeX), (double)this.mob.getBlockY(), (double)(this.mob.getZ() + (double)relativeZ))) == PathType.WALKABLE;
    }

    protected float rotlerp(float sourceAngle, float targetAngle, float maximumChange) {
        float f1;
        float f = Mth.wrapDegrees((float)(targetAngle - sourceAngle));
        if (f > maximumChange) {
            f = maximumChange;
        }
        if (f < -maximumChange) {
            f = -maximumChange;
        }
        if ((f1 = sourceAngle + f) < 0.0f) {
            f1 += 360.0f;
        } else if (f1 > 360.0f) {
            f1 -= 360.0f;
        }
        return f1;
    }

    protected static enum ClawdianOperation {
        WAIT,
        MOVE_TO,
        FORWARD,
        STRAFE,
        JUMPING;

    }
}

