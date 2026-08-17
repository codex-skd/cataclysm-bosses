/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 */
package com.skd.thesundering.entity.etc;

import com.skd.thesundering.entity.etc.ISemiAquatic;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class AquaticMoveController
extends MoveControl {
    private final PathfinderMob entity;
    private final float speedMulti;
    private float yawLimit = 3.0f;

    public AquaticMoveController(PathfinderMob entity, float speedMulti) {
        super((Mob)entity);
        this.entity = entity;
        this.speedMulti = speedMulti;
    }

    public AquaticMoveController(PathfinderMob entity, float speedMulti, float yawLimit) {
        super((Mob)entity);
        this.entity = entity;
        this.yawLimit = yawLimit;
        this.speedMulti = speedMulti;
    }

    public void tick() {
        if (this.entity.isInWater()) {
            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, 0.005, 0.0));
        }
        if (this.entity instanceof ISemiAquatic && ((ISemiAquatic)this.entity).shouldStopMoving()) {
            this.entity.setSpeed(0.0f);
            return;
        }
        if (this.operation == MoveControl.Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
            double d0 = this.wantedX - this.entity.getX();
            double d1 = this.wantedY - this.entity.getY();
            double d2 = this.wantedZ - this.entity.getZ();
            double d3 = Mth.sqrt((float)((float)(d0 * d0 + d1 * d1 + d2 * d2)));
            double d4 = Mth.sqrt((float)((float)(d0 * d0 + d2 * d2)));
            d1 /= d3;
            float f = (float)(Mth.atan2((double)d2, (double)d0) * 57.2957763671875) - 90.0f;
            this.entity.setYRot(this.rotlerp(this.entity.getYRot(), f, this.yawLimit));
            this.entity.yBodyRot = this.entity.getYRot();
            float f1 = (float)(this.speedModifier * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED) * (double)this.speedMulti);
            this.entity.setSpeed(f1 * 0.4f);
            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, (double)this.entity.getSpeed() * d1 * 0.6, 0.0));
        } else {
            this.entity.setSpeed(0.0f);
        }
    }
}

