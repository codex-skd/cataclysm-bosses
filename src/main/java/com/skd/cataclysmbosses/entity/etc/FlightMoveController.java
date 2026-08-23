/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.etc;

import com.skd.cataclysmbosses.entity.etc.MovementControllerCustomCollisions;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FlightMoveController
extends MovementControllerCustomCollisions {
    private final Mob parentEntity;
    private final float speedGeneral;
    private final boolean shouldLookAtTarget;
    private final boolean needsYSupport;

    public FlightMoveController(Mob bird, float speedGeneral, boolean shouldLookAtTarget, boolean needsYSupport) {
        super(bird);
        this.parentEntity = bird;
        this.shouldLookAtTarget = shouldLookAtTarget;
        this.speedGeneral = speedGeneral;
        this.needsYSupport = needsYSupport;
    }

    public FlightMoveController(Mob bird, float speedGeneral, boolean shouldLookAtTarget) {
        this(bird, speedGeneral, shouldLookAtTarget, false);
    }

    public FlightMoveController(Mob bird, float speedGeneral) {
        this(bird, speedGeneral, true);
    }

    @Override
    public void tick() {
        if (this.operation == MoveControl.Operation.MOVE_TO) {
            Vec3 vector3d = new Vec3(this.wantedX - this.parentEntity.getX(), this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
            double d0 = vector3d.length();
            if (d0 < this.parentEntity.getBoundingBox().getSize()) {
                this.operation = MoveControl.Operation.WAIT;
                this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().scale(0.5));
            } else {
                this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(this.speedModifier * (double)this.speedGeneral * 0.05 / d0)));
                if (this.needsYSupport) {
                    double d1 = this.wantedY - this.parentEntity.getY();
                    this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(0.0, (double)this.parentEntity.getSpeed() * (double)this.speedGeneral * Mth.clamp((double)d1, (double)-1.0, (double)1.0) * (double)0.6f, 0.0));
                }
                if (this.parentEntity.getTarget() == null || !this.shouldLookAtTarget) {
                    Vec3 vector3d1 = this.parentEntity.getDeltaMovement();
                    this.parentEntity.setYRot(-((float)Mth.atan2((double)vector3d1.x, (double)vector3d1.z)) * 57.295776f);
                    this.parentEntity.yBodyRot = this.parentEntity.getYRot();
                } else {
                    double d2 = this.parentEntity.getTarget().getX() - this.parentEntity.getX();
                    double d1 = this.parentEntity.getTarget().getZ() - this.parentEntity.getZ();
                    this.parentEntity.setYRot(-((float)Mth.atan2((double)d2, (double)d1)) * 57.295776f);
                    this.parentEntity.yBodyRot = this.parentEntity.getYRot();
                }
            }
        } else if (this.operation == MoveControl.Operation.STRAFE) {
            this.operation = MoveControl.Operation.WAIT;
        }
    }

    private boolean canReach(Vec3 p_220673_1_, int p_220673_2_) {
        AABB axisalignedbb = this.parentEntity.getBoundingBox();
        for (int i = 1; i < p_220673_2_; ++i) {
            axisalignedbb = axisalignedbb.move(p_220673_1_);
            if (this.parentEntity.level().noCollision((Entity)this.parentEntity, axisalignedbb)) continue;
            return false;
        }
        return true;
    }
}

