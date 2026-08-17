/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.sundering.entity.AnimationMonster.AI;

import com.skd.sundering.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.sundering.entity.AnimationMonster.LLibrary_Monster;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class PredictiveChargeAttackAnimationGoal<T extends LLibrary_Monster>
extends SimpleAnimationGoal<T> {
    protected LivingEntity target;
    private final int look1;
    private final int look2;
    private final float sensing;
    private final int charge;
    private final float motionx;
    private final float motionz;
    public double prevX;
    public double prevZ;
    private int newX;
    private int newZ;

    public PredictiveChargeAttackAnimationGoal(T entity, Animation animation, int look1, int look2, float sensing, int charge, float motionx, float motionz) {
        super(entity, animation);
        this.look1 = look1;
        this.look2 = look2;
        this.sensing = sensing;
        this.charge = charge;
        this.motionx = motionx;
        this.motionz = motionz;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    public void start() {
        super.start();
        this.target = this.entity.getTarget();
        if (this.target != null) {
            this.prevX = this.target.getX();
            this.prevZ = this.target.getZ();
        }
    }

    public void tick() {
        if (this.target != null) {
            boolean flag;
            boolean bl = flag = this.entity.getAnimationTick() < this.look1 || this.entity.getAnimationTick() > this.look2;
            if (flag) {
                this.entity.getLookControl().setLookAt((Entity)this.target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)this.target, 30.0f, 30.0f);
            } else {
                this.entity.getLookControl().setLookAt((Entity)this.target, 0.0f, 30.0f);
                this.entity.setYRot(this.entity.yRotO);
            }
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
        if (this.entity.getAnimationTick() == this.charge - 1 && this.target != null) {
            double x = this.target.getX();
            double z = this.target.getZ();
            double vx = (x - this.prevX) / (double)this.charge;
            double vz = (z - this.prevZ) / (double)this.charge;
            this.newX = Mth.floor((double)(x + vx * (double)this.sensing));
            this.newZ = Mth.floor((double)(z + vz * (double)this.sensing));
        }
        if (this.entity.getAnimationTick() == this.charge && this.target != null) {
            this.entity.setDeltaMovement(((double)this.newX - this.entity.getX()) * (double)this.motionx, 0.0, ((double)this.newZ - this.entity.getZ()) * (double)this.motionz);
        }
    }
}

