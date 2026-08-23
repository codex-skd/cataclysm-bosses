/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.Pet.AI;

import com.skd.cataclysmbosses.entity.Pet.InternalAnimationPet;
import java.util.EnumSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

public class InternalPetAttackGoal
extends Goal {
    protected final InternalAnimationPet entity;
    private final int getattackstate;
    private final int attackstate;
    private final int attackendstate;
    private final int attackMaxtick;
    private final int attackseetick;
    private final float attackrange;

    public InternalPetAttackGoal(InternalAnimationPet entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public InternalPetAttackGoal(InternalAnimationPet entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Goal.Flag> interruptFlagTypes) {
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

    public void start() {
        this.entity.setAttackState(this.attackstate);
    }

    public void stop() {
        this.entity.setAttackState(this.attackendstate);
    }

    public boolean canContinueToUse() {
        return this.entity.getAttackState() == this.attackstate && this.entity.attackTicks <= this.attackMaxtick;
    }

    public void tick() {
        LivingEntity target = this.entity.getTarget();
        if (this.entity.attackTicks < this.attackseetick && target != null) {
            this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            this.entity.lookAt((Entity)target, 30.0f, 30.0f);
        } else {
            this.entity.setYRot(this.entity.yRotO);
        }
    }

    public boolean requiresUpdateEveryTick() {
        return false;
    }
}

