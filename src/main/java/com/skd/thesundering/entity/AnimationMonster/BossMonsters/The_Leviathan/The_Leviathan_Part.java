/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.level.gameevent.GameEvent
 */
package com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.skd.thesundering.entity.partentity.Cm_Part_Entity;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.gameevent.GameEvent;

public class The_Leviathan_Part
extends Cm_Part_Entity<The_Leviathan_Entity> {
    private final EntityDimensions size;
    public float scale = 1.0f;

    public The_Leviathan_Part(The_Leviathan_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.scalable((float)sizeX, (float)sizeY);
        this.refreshDimensions();
    }

    public The_Leviathan_Part(The_Leviathan_Entity entityCachalotWhale, float sizeX, float sizeY, EntityDimensions size) {
        super(entityCachalotWhale);
        this.size = size;
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
        return ((The_Leviathan_Entity)this.getParent()).isAlive();
    }

    @Override
    protected void setSize(EntityDimensions size) {
        super.setSize(size);
    }

    public boolean hurt(DamageSource source, float amount) {
        boolean flag;
        boolean bl = flag = this.getParent() != null && ((The_Leviathan_Entity)this.getParent()).attackEntityFromPart(this, source, amount);
        if (flag) {
            this.gameEvent((Holder)GameEvent.ENTITY_DAMAGE);
        }
        return flag;
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
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

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    @Override
    public EntityDimensions getDimensions(Pose poseIn) {
        return this.size;
    }
}

