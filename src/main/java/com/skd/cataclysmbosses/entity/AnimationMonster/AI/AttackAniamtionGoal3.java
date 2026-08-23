/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.AI;

import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.LLibrary_Monster;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.world.entity.ai.goal.Goal;

public class AttackAniamtionGoal3<T extends LLibrary_Monster>
extends SimpleAnimationGoal<T> {
    public AttackAniamtionGoal3(T entity, Animation animation) {
        super(entity, animation);
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    public void tick() {
        this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
    }
}

