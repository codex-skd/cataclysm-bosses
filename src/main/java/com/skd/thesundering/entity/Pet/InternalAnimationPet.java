/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 */
package com.skd.thesundering.entity.Pet;

import com.skd.thesundering.entity.Pet.AnimationPet;
import com.skd.thesundering.entity.etc.IFollower;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class InternalAnimationPet
extends AnimationPet
implements IFollower {
    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(InternalAnimationPet.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public int attackTicks;

    public InternalAnimationPet(EntityType entity, Level world) {
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

    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        } else {
            super.handleEntityEvent(id);
        }
    }

    public void tick() {
        super.tick();
        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }
    }
}

