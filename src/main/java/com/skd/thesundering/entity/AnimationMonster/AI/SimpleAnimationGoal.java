/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.thesundering.entity.AnimationMonster.AI;

import com.skd.thesundering.entity.AnimationMonster.AI.AnimationGoal;
import com.skd.thesundering.entity.AnimationMonster.LLibrary_Monster;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;

public class SimpleAnimationGoal<T extends LLibrary_Monster>
extends AnimationGoal<T> {
    private final Animation animation;

    public SimpleAnimationGoal(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    @Override
    protected boolean test(Animation animation) {
        return animation == this.animation;
    }
}

