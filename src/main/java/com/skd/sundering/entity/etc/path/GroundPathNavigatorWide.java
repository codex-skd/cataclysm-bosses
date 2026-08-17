/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.entity.etc.path;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class GroundPathNavigatorWide
extends GroundPathNavigation {
    private float distancemodifier = 0.75f;

    public GroundPathNavigatorWide(Mob entitylivingIn, Level worldIn) {
        super(entitylivingIn, worldIn);
    }

    public GroundPathNavigatorWide(Mob entitylivingIn, Level worldIn, float distancemodifier) {
        super(entitylivingIn, worldIn);
        this.distancemodifier = distancemodifier;
    }

    protected void followThePath() {
        boolean flag;
        Vec3 vector3d = this.getTempMobPos();
        this.maxDistanceToWaypoint = this.mob.getBbWidth() * this.distancemodifier;
        BlockPos vector3i = this.path.getNextNodePos();
        double d0 = Math.abs(this.mob.getX() - ((double)vector3i.getX() + 0.5));
        double d1 = Math.abs(this.mob.getY() - (double)vector3i.getY());
        double d2 = Math.abs(this.mob.getZ() - ((double)vector3i.getZ() + 0.5));
        boolean bl = flag = d0 < (double)this.maxDistanceToWaypoint && d2 < (double)this.maxDistanceToWaypoint && d1 < 1.0;
        if (flag || this.canCutCorner(this.path.getNextNode().type) && this.shouldTargetNextNodeInDirection(vector3d)) {
            this.path.advance();
        }
        this.doStuckDetection(vector3d);
    }

    private boolean shouldTargetNextNodeInDirection(Vec3 currentPosition) {
        Vec3 vector3d3;
        if (this.path.getNextNodeIndex() + 1 >= this.path.getNodeCount()) {
            return false;
        }
        Vec3 vector3d = Vec3.atBottomCenterOf((Vec3i)this.path.getNextNodePos());
        if (!currentPosition.closerThan((Position)vector3d, 2.0)) {
            return false;
        }
        Vec3 vector3d1 = Vec3.atBottomCenterOf((Vec3i)this.path.getNodePos(this.path.getNextNodeIndex() + 1));
        Vec3 vector3d2 = vector3d1.subtract(vector3d);
        return vector3d2.dot(vector3d3 = currentPosition.subtract(vector3d)) > 0.0;
    }
}

