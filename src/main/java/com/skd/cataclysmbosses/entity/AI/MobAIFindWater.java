/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 */
package com.skd.cataclysmbosses.entity.AI;

import com.skd.cataclysmbosses.entity.etc.ISemiAquatic;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class MobAIFindWater
extends Goal {
    private final PathfinderMob creature;
    private BlockPos targetPos;
    private final double speed;
    private final int executionChance = 10;

    public MobAIFindWater(PathfinderMob creature, double speed) {
        this.creature = creature;
        this.speed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        if (this.creature.onGround() && !this.creature.level().getFluidState(this.creature.blockPosition()).is(FluidTags.WATER) && this.creature instanceof ISemiAquatic && ((ISemiAquatic)this.creature).shouldEnterWater() && this.creature.getRandom().nextInt(10) == 0) {
            this.targetPos = this.generateTarget();
            return this.targetPos != null;
        }
        return false;
    }

    public void start() {
        if (this.targetPos != null) {
            this.creature.getNavigation().moveTo((double)this.targetPos.getX(), (double)this.targetPos.getY(), (double)this.targetPos.getZ(), this.speed);
        }
    }

    public void tick() {
        if (this.targetPos != null) {
            this.creature.getNavigation().moveTo((double)this.targetPos.getX(), (double)this.targetPos.getY(), (double)this.targetPos.getZ(), this.speed);
        }
    }

    public boolean canContinueToUse() {
        if (this.creature instanceof ISemiAquatic && !((ISemiAquatic)this.creature).shouldEnterWater()) {
            this.creature.getNavigation().stop();
            return false;
        }
        return !this.creature.getNavigation().isDone() && this.targetPos != null && !this.creature.level().getFluidState(this.creature.blockPosition()).is(FluidTags.WATER);
    }

    public BlockPos generateTarget() {
        BlockPos blockpos = null;
        RandomSource random = this.creature.getRandom();
        int range = this.creature instanceof ISemiAquatic ? ((ISemiAquatic)this.creature).getWaterSearchRange() : 14;
        for (int i = 0; i < 15; ++i) {
            BlockPos blockPos = this.creature.blockPosition().offset(random.nextInt(range) - range / 2, 3, random.nextInt(range) - range / 2);
            while (this.creature.level().isEmptyBlock(blockPos) && blockPos.getY() > 1) {
                blockPos = blockPos.below();
            }
            if (!this.creature.level().getFluidState(blockPos).is(FluidTags.WATER)) continue;
            blockpos = blockPos;
        }
        return blockpos;
    }
}

