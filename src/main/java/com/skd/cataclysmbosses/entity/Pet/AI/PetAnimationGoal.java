/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.Pet.AI;

import com.skd.cataclysmbosses.entity.Pet.AnimationPet;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;

public abstract class PetAnimationGoal<T extends AnimationPet>
extends Goal {
    protected final T entity;

    protected PetAnimationGoal(T entity) {
        this(entity, true);
    }

    protected PetAnimationGoal(T entity, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }
    }

    public boolean canUse() {
        return this.test(((IAnimatedEntity)this.entity).getAnimation());
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    protected abstract boolean test(Animation var1);
}

