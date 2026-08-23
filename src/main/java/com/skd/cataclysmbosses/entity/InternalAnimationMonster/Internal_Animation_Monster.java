/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.monster.Enemy
 *  net.minecraft.world.level.Level
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster;

import com.skd.cataclysmbosses.entity.etc.Animation_Monsters;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;

public class Internal_Animation_Monster
extends Animation_Monsters
implements Enemy {
    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(Internal_Animation_Monster.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public int attackTicks;

    public Internal_Animation_Monster(EntityType entity, Level world) {
        super(entity, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(ATTACK_STATE, (Object)0);
    }

    public int getAttackState() {
        return (Integer)this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.entityData.set(ATTACK_STATE, (Object)input);
        this.level().broadcastEntityEvent((Entity)this, (byte)(-input));
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }
    }

    @Override
    protected void tickDeath() {
        this.onDeathUpdate(this.deathtimer());
    }

    @Override
    public int deathtimer() {
        return 20;
    }

    @Override
    public void push(Entity entityIn) {
        double d1;
        double d0;
        double d2;
        if (!(this.isSleeping() || this.isPassengerOfSameVehicle(entityIn) || entityIn.noPhysics || this.noPhysics || !((d2 = Mth.absMax((double)(d0 = entityIn.getX() - this.getX()), (double)(d1 = entityIn.getZ() - this.getZ()))) >= (double)0.01f))) {
            d2 = Mth.sqrt((float)((float)d2));
            d0 /= d2;
            d1 /= d2;
            double d3 = 1.0 / d2;
            if (d3 > 1.0) {
                d3 = 1.0;
            }
            d0 *= d3;
            d1 *= d3;
            d0 *= (double)0.05f;
            d1 *= (double)0.05f;
            if (!this.isVehicle() && this.canBePushedByEntity(entityIn)) {
                this.push(-d0, 0.0, -d1);
            }
            if (!entityIn.isVehicle()) {
                entityIn.push(d0, 0.0, d1);
            }
        }
    }
}

