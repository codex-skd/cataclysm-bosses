/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class InternalStateGoal
extends Goal {
    protected final Internal_Animation_Monster entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    public InternalStateGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public InternalStateGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public InternalStateGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, EnumSet<Goal.Flag> interruptFlagTypes) {
        this.entity = entity;
        this.setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public boolean canUse() {
        return this.entity.getAttackState() == this.getattackstate;
    }

    public void start() {
        if (this.getattackstate != this.attackstate) {
            this.entity.setAttackState(this.attackstate);
        }
    }

    public boolean isInterruptable() {
        return false;
    }

    public void stop() {
        this.entity.setAttackState(this.attackendstate);
    }

    public boolean canContinueToUse() {
        return this.attackfinaltick > 0 ? this.entity.attackTicks <= this.attackfinaltick && this.entity.getAttackState() == this.attackstate : this.canUse();
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (target != null) {
            boolean flag;
            boolean bl = flag = this.entity.attackTicks < this.attackseetick;
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
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}

