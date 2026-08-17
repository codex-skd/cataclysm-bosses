/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.sundering.entity.Pet.AI;

import com.skd.sundering.entity.Pet.AI.PetAnimationGoal;
import com.skd.sundering.entity.Pet.AnimationPet;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;

public class PetSimpleAnimationGoal<T extends AnimationPet>
extends PetAnimationGoal<T> {
    private final Animation animation;

    public PetSimpleAnimationGoal(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    @Override
    protected boolean test(Animation animation) {
        return animation == this.animation;
    }
}

