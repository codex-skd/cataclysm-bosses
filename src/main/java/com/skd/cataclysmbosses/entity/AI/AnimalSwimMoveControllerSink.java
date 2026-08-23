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
package com.skd.cataclysmbosses.entity.AI;

import com.skd.cataclysmbosses.entity.etc.ISemiAquatic;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class AnimalSwimMoveControllerSink
extends MoveControl {
    private final PathfinderMob entity;
    private float speedMulti;
    private float ySpeedMod = 1.0f;
    private float yawLimit = 10.0f;

    public AnimalSwimMoveControllerSink(PathfinderMob entity, float speedMulti, float ySpeedMod) {
        super((Mob)entity);
        this.entity = entity;
        this.speedMulti = speedMulti;
        this.ySpeedMod = ySpeedMod;
    }

    public AnimalSwimMoveControllerSink(PathfinderMob entity, float speedMulti, float ySpeedMod, float yawLimit) {
        super((Mob)entity);
        this.entity = entity;
        this.speedMulti = speedMulti;
        this.ySpeedMod = ySpeedMod;
        this.yawLimit = yawLimit;
    }

    public void tick() {
        if (this.entity instanceof ISemiAquatic && ((ISemiAquatic)this.entity).shouldStopMoving()) {
            this.entity.setSpeed(0.0f);
            return;
        }
        if (this.operation == MoveControl.Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
            double lvt_5_1_;
            double lvt_3_1_;
            double lvt_1_1_ = this.wantedX - this.entity.getX();
            double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + (lvt_3_1_ = this.wantedY - this.entity.getY()) * lvt_3_1_ + (lvt_5_1_ = this.wantedZ - this.entity.getZ()) * lvt_5_1_;
            if (lvt_7_1_ < 2.500000277905201E-7) {
                this.mob.setZza(0.0f);
            } else {
                float lvt_9_1_ = (float)(Mth.atan2((double)lvt_5_1_, (double)lvt_1_1_) * 57.2957763671875) - 90.0f;
                this.entity.setYRot(this.rotlerp(this.entity.getYRot(), lvt_9_1_, this.yawLimit));
                this.entity.yBodyRot = this.entity.getYRot();
                this.entity.yHeadRot = this.entity.getYRot();
                float lvt_10_1_ = (float)(this.speedModifier * (double)this.speedMulti * 3.0 * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                if (this.entity.isInWater()) {
                    if (lvt_3_1_ > 0.0 && this.entity.horizontalCollision) {
                        this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, (double)0.08f, 0.0));
                    } else {
                        this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, (double)this.entity.getSpeed() * lvt_3_1_ * 0.6 * (double)this.ySpeedMod, 0.0));
                    }
                    this.entity.setSpeed(lvt_10_1_ * 0.02f);
                    float lvt_11_1_ = -((float)(Mth.atan2((double)lvt_3_1_, (double)Mth.sqrt((float)((float)(lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_)))) * 57.2957763671875));
                    lvt_11_1_ = Mth.clamp((float)Mth.wrapDegrees((float)lvt_11_1_), (float)-85.0f, (float)85.0f);
                    this.entity.setXRot(this.rotlerp(this.entity.getXRot(), lvt_11_1_, 5.0f));
                    float lvt_12_1_ = Mth.cos((float)(this.entity.getXRot() * ((float)Math.PI / 180)));
                    float lvt_13_1_ = Mth.sin((float)(this.entity.getXRot() * ((float)Math.PI / 180)));
                    this.entity.zza = lvt_12_1_ * lvt_10_1_;
                    this.entity.yya = -lvt_13_1_ * lvt_10_1_;
                } else {
                    this.entity.setSpeed(lvt_10_1_ * 0.1f);
                }
            }
        } else {
            this.entity.setSpeed(0.0f);
            this.entity.setXxa(0.0f);
            this.entity.setYya(0.0f);
            this.entity.setZza(0.0f);
        }
    }
}

