/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class InternalAttackGoal
extends Goal {
    protected final Internal_Animation_Monster entity;
    protected final int getattackstate;
    protected final int attackstate;
    protected final int attackendstate;
    protected final int attackMaxtick;
    protected final int attackseetick;
    protected final float attackrange;

    public InternalAttackGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public InternalAttackGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Goal.Flag> interruptFlagTypes) {
        this.entity = entity;
        this.setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public boolean canUse() {
        LivingEntity target = this.entity.getTarget();
        return target != null && target.isAlive() && this.entity.distanceTo((Entity)target) < this.attackrange && this.entity.getAttackState() == this.getattackstate;
    }

    public boolean isInterruptable() {
        return false;
    }

    public void start() {
        this.entity.setAttackState(this.attackstate);
        this.entity.getNavigation().stop();
    }

    public void stop() {
        this.EndState();
        LivingEntity target = this.entity.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
            this.entity.setTarget(null);
        }
        this.entity.getNavigation().stop();
        if (this.entity.getTarget() == null) {
            this.entity.setAggressive(false);
        }
    }

    protected void EndState() {
        this.entity.setAttackState(this.attackendstate);
    }

    public boolean canContinueToUse() {
        return this.entity.getAttackState() == this.attackstate && this.entity.attackTicks <= this.attackMaxtick;
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
        this.entity.getNavigation().stop();
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
}

