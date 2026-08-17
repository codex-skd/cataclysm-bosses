/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.level.pathfinder.NodeEvaluator
 *  net.minecraft.world.level.pathfinder.PathType
 */
package com.skd.sundering.entity.etc;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathType;

public class CMEntityMoveHelper
extends MoveControl {
    private float maxRotate = 90.0f;

    public CMEntityMoveHelper(Mob entitylivingIn, float maxRotate) {
        super(entitylivingIn);
        this.maxRotate = maxRotate;
    }

    public void tick() {
        if (this.operation == MoveControl.Operation.STRAFE) {
            NodeEvaluator nodeprocessor;
            float f = (float)this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue();
            float f1 = (float)this.speedModifier * f;
            float f2 = this.strafeForwards;
            float f3 = this.strafeRight;
            float f4 = Mth.sqrt((float)(f2 * f2 + f3 * f3));
            if (f4 < 1.0f) {
                f4 = 1.0f;
            }
            f4 = f1 / f4;
            float f5 = Mth.sin((float)(this.mob.getYRot() * ((float)Math.PI / 180)));
            float f6 = Mth.cos((float)(this.mob.getYRot() * ((float)Math.PI / 180)));
            float f7 = (f2 *= f4) * f6 - (f3 *= f4) * f5;
            float f8 = f3 * f6 + f2 * f5;
            PathNavigation pathnavigate = this.mob.getNavigation();
            if (pathnavigate != null && (nodeprocessor = pathnavigate.getNodeEvaluator()) != null && nodeprocessor.getPathType(this.mob, BlockPos.containing((double)Mth.floor((double)(this.mob.getX() + (double)f7)), (double)Mth.floor((double)this.mob.getY()), (double)Mth.floor((double)(this.mob.getZ() + (double)f8)))) != PathType.WALKABLE) {
                this.strafeForwards = 1.0f;
                this.strafeRight = 0.0f;
                f1 = f;
            }
            this.mob.setSpeed(f1);
            this.mob.setZza(this.strafeForwards);
            this.mob.setXxa(this.strafeRight);
            this.operation = MoveControl.Operation.WAIT;
        } else if (this.operation == MoveControl.Operation.MOVE_TO) {
            this.operation = MoveControl.Operation.WAIT;
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedZ - this.mob.getZ();
            double d2 = this.wantedY - this.mob.getY();
            double d3 = d0 * d0 + d2 * d2 + d1 * d1;
            if (d3 < 2.500000277905201E-7) {
                this.mob.setZza(0.0f);
                return;
            }
            float f9 = (float)(Mth.atan2((double)d1, (double)d0) * 57.29577951308232) - 90.0f;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f9, this.maxRotate));
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
            if (d2 > (double)this.mob.maxUpStep() && d0 * d0 + d1 * d1 < (double)Math.max(1.0f, this.mob.getBbWidth())) {
                this.mob.getJumpControl().jump();
                this.operation = MoveControl.Operation.JUMPING;
            }
        } else if (this.operation == MoveControl.Operation.JUMPING) {
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
            if (this.mob.onGround()) {
                this.operation = MoveControl.Operation.WAIT;
            }
        } else {
            this.mob.setZza(0.0f);
        }
    }
}

