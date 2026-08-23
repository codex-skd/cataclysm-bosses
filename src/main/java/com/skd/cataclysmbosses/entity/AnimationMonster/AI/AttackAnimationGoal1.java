/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.AI;

import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.LLibrary_Monster;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class AttackAnimationGoal1<T extends LLibrary_Monster>
extends SimpleAnimationGoal<T> {
    private final int look1;
    private final boolean see;

    public AttackAnimationGoal1(T entity, Animation animation, int look1, boolean see) {
        super(entity, animation);
        this.look1 = look1;
        this.see = see;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (this.see) {
            if (target != null) {
                boolean flag;
                boolean bl = flag = this.entity.getAnimationTick() < this.look1;
                if (flag) {
                    this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    this.entity.getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                    this.entity.setYRot(this.entity.yRotO);
                }
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
        } else if (target != null) {
            boolean flag;
            boolean bl = flag = this.entity.getAnimationTick() > this.look1;
            if (flag) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                this.entity.getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                this.entity.setYRot(this.entity.yRotO);
            }
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
        this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
    }
}

