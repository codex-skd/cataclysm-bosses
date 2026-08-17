/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.level.Level
 */
package com.skd.thesundering.entity.etc.path;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;

public class DirectPathNavigator
extends GroundPathNavigation {
    private Mob mob;
    private float yMobOffset = 0.0f;

    public DirectPathNavigator(Mob mob, Level world) {
        this(mob, world, 0.0f);
    }

    public DirectPathNavigator(Mob mob, Level world, float yMobOffset) {
        super(mob, world);
        this.mob = mob;
        this.yMobOffset = yMobOffset;
    }

    public void tick() {
        ++this.tick;
    }

    public boolean moveTo(double x, double y, double z, double speedIn) {
        this.mob.getMoveControl().setWantedPosition(x, y, z, speedIn);
        return true;
    }

    public boolean moveTo(Entity entityIn, double speedIn) {
        this.mob.getMoveControl().setWantedPosition(entityIn.getX(), entityIn.getY() + (double)this.yMobOffset, entityIn.getZ(), speedIn);
        return true;
    }
}

