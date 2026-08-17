/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.thesundering.entity.AnimationMonster.AI;

import com.skd.thesundering.entity.AnimationMonster.LLibrary_Monster;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;

public abstract class AnimationGoal<T extends LLibrary_Monster>
extends Goal {
    protected final T entity;

    protected AnimationGoal(T entity) {
        this(entity, true);
    }

    protected AnimationGoal(T entity, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }
    }

    public boolean canUse() {
        return this.test(((LLibrary_Monster)((Object)this.entity)).getAnimation());
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    protected abstract boolean test(Animation var1);
}

