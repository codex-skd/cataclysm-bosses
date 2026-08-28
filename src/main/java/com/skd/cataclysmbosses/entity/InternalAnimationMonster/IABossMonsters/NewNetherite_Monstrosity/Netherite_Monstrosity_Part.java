/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.Pose
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;
import net.minecraft.server.level.ServerLevel;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.skd.cataclysmbosses.entity.partentity.Cm_Part_Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Netherite_Monstrosity_Part
extends Cm_Part_Entity<Netherite_Monstrosity_Entity> {
    public final Netherite_Monstrosity_Entity parentMob;
    private final EntityDimensions size;
    public float scale = 1.0f;

    public Netherite_Monstrosity_Part(Netherite_Monstrosity_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.scalable((float)sizeX, (float)sizeY);
        this.parentMob = parent;
        this.refreshDimensions();
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isPickable() {
        return ((Netherite_Monstrosity_Entity)this.getParent()).isAlive();
    }

    @Override
    protected void setSize(EntityDimensions size) {
        super.setSize(size);
    }

    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        return this.isInvulnerableTo(source) ? false : this.parentMob.hurtParts(this, source, amount);
    }

    protected void readAdditionalSaveData(ValueInput compound) {
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
    }

    public boolean is(Entity entity) {
        return this == entity || this.getParent() == entity;
    }

    protected void setRot(float yaw, float pitch) {
        this.setYRot(yaw % 360.0f);
        this.setXRot(pitch % 360.0f);
    }

    protected boolean canRide(Entity entityIn) {
        return false;
    }

    public boolean canUsePortal(boolean p_352936_) {
        return false;
    }

    @Override
    public EntityDimensions getDimensions(Pose poseIn) {
        return this.size;
    }
}

