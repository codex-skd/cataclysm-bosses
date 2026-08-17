/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.entity.AI;

import com.skd.sundering.entity.etc.ISemiAquatic;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;

public class SemiAquaticAIRandomSwimming
extends RandomStrollGoal {
    public SemiAquaticAIRandomSwimming(Animal creature, double speed, int chance) {
        super((PathfinderMob)creature, speed, chance, false);
    }

    public boolean canUse() {
        if (this.mob.isVehicle() || ((ISemiAquatic)this.mob).shouldStopMoving() || this.mob.getTarget() != null || !this.mob.isInWater() && !this.mob.isInLava() && this.mob instanceof ISemiAquatic && !((ISemiAquatic)this.mob).shouldEnterWater()) {
            return false;
        }
        if (!this.forceTrigger && this.mob.getRandom().nextInt(this.interval) != 0) {
            return false;
        }
        Vec3 vector3d = this.getPosition();
        if (vector3d == null) {
            return false;
        }
        this.wantedX = vector3d.x;
        this.wantedY = vector3d.y;
        this.wantedZ = vector3d.z;
        this.forceTrigger = false;
        return true;
    }

    @Nullable
    protected Vec3 getPosition() {
        Vec3 vector3d;
        if (this.mob.hasRestriction() && this.mob.distanceToSqr(Vec3.atCenterOf((Vec3i)this.mob.getRestrictCenter())) > (double)(this.mob.getRestrictRadius() * this.mob.getRestrictRadius())) {
            return DefaultRandomPos.getPosTowards((PathfinderMob)this.mob, (int)7, (int)3, (Vec3)Vec3.atBottomCenterOf((Vec3i)this.mob.getRestrictCenter()), (double)1.0);
        }
        if (this.mob.getRandom().nextFloat() < 0.3f && (vector3d = this.findSurfaceTarget(this.mob, 15, 7)) != null) {
            return vector3d;
        }
        vector3d = DefaultRandomPos.getPos((PathfinderMob)this.mob, (int)7, (int)3);
        int i = 0;
        while (vector3d != null && !this.mob.level().getFluidState(BlockPos.containing((Position)vector3d)).is(FluidTags.LAVA) && !this.mob.level().getBlockState(BlockPos.containing((Position)vector3d)).isPathfindable(PathComputationType.WATER) && i++ < 15) {
            vector3d = DefaultRandomPos.getPos((PathfinderMob)this.mob, (int)10, (int)7);
        }
        return vector3d;
    }

    private boolean canJumpTo(BlockPos pos, int dx, int dz, int scale) {
        BlockPos blockpos = pos.offset(dx * scale, 0, dz * scale);
        return this.mob.level().getFluidState(blockpos).is(FluidTags.LAVA) || this.mob.level().getFluidState(blockpos).is(FluidTags.WATER) && !this.mob.level().getBlockState(blockpos).blocksMotion();
    }

    private boolean isAirAbove(BlockPos pos, int dx, int dz, int scale) {
        return this.mob.level().getBlockState(pos.offset(dx * scale, 1, dz * scale)).isAir() && this.mob.level().getBlockState(pos.offset(dx * scale, 2, dz * scale)).isAir();
    }

    protected Vec3 findSurfaceTarget(PathfinderMob creature, int i, int i1) {
        BlockPos upPos = creature.blockPosition();
        while (creature.level().getFluidState(upPos).is(FluidTags.WATER) || creature.level().getFluidState(upPos).is(FluidTags.LAVA)) {
            upPos = upPos.above();
        }
        if (this.isAirAbove(upPos.below(), 0, 0, 0) && this.canJumpTo(upPos.below(), 0, 0, 0)) {
            return new Vec3((double)((float)upPos.getX() + 0.5f), (double)((float)upPos.getY() - 1.0f), (double)((float)upPos.getZ() + 0.5f));
        }
        return null;
    }
}

