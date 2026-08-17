/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.util.LandRandomPos
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.entity.AI;

import com.skd.sundering.entity.etc.ISemiAquatic;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;

public class MobAILeaveWater
extends Goal {
    private final PathfinderMob creature;
    private BlockPos targetPos;
    private final int executionChance = 30;

    public MobAILeaveWater(PathfinderMob creature) {
        this.creature = creature;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        if (this.creature.level().getFluidState(this.creature.blockPosition()).is(FluidTags.WATER) && (this.creature.getTarget() != null || this.creature.getRandom().nextInt(30) == 0) && this.creature instanceof ISemiAquatic && ((ISemiAquatic)this.creature).shouldLeaveWater()) {
            this.targetPos = this.generateTarget();
            return this.targetPos != null;
        }
        return false;
    }

    public void start() {
        if (this.targetPos != null) {
            this.creature.getNavigation().moveTo((double)this.targetPos.getX(), (double)this.targetPos.getY(), (double)this.targetPos.getZ(), 1.0);
        }
    }

    public void tick() {
        if (this.targetPos != null) {
            this.creature.getNavigation().moveTo((double)this.targetPos.getX(), (double)this.targetPos.getY(), (double)this.targetPos.getZ(), 1.0);
        }
        if (this.creature.horizontalCollision && this.creature.isInWater()) {
            float f1 = this.creature.getYRot() * (float)Math.PI / 180.0f;
            this.creature.setDeltaMovement(this.creature.getDeltaMovement().add((double)(-Mth.sin((float)f1) * 0.2f), 0.1, (double)(Mth.cos((float)f1) * 0.2f)));
        }
    }

    public boolean canContinueToUse() {
        if (this.creature instanceof ISemiAquatic && !((ISemiAquatic)this.creature).shouldLeaveWater()) {
            this.creature.getNavigation().stop();
            return false;
        }
        return !this.creature.getNavigation().isDone() && this.targetPos != null && !this.creature.level().getFluidState(this.targetPos).is(FluidTags.WATER);
    }

    public BlockPos generateTarget() {
        Vec3 vector3d = LandRandomPos.getPos((PathfinderMob)this.creature, (int)23, (int)7);
        for (int tries = 0; vector3d != null && tries < 8; ++tries) {
            boolean waterDetected = false;
            for (BlockPos blockpos1 : BlockPos.betweenClosed((int)Mth.floor((double)(vector3d.x - 2.0)), (int)Mth.floor((double)(vector3d.y - 1.0)), (int)Mth.floor((double)(vector3d.z - 2.0)), (int)Mth.floor((double)(vector3d.x + 2.0)), (int)Mth.floor((double)vector3d.y), (int)Mth.floor((double)(vector3d.z + 2.0)))) {
                if (!this.creature.level().getFluidState(blockpos1).is(FluidTags.WATER)) continue;
                waterDetected = true;
                break;
            }
            if (!waterDetected) {
                return BlockPos.containing((Position)vector3d);
            }
            vector3d = LandRandomPos.getPos((PathfinderMob)this.creature, (int)23, (int)7);
        }
        return null;
    }
}

