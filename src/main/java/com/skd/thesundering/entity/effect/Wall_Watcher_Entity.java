/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 */
package com.skd.thesundering.entity.effect;

import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModSounds;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class Wall_Watcher_Entity
extends Entity {
    static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Wall_Watcher_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    int effectiveChargeTime;
    double knockbackSpeedIndex;
    float damagePerEffectiveCharge;
    double dx;
    double dz;
    LivingEntity source;
    List<YUnchangedLivingEntity> watchedEntities;

    public Wall_Watcher_Entity(EntityType<? extends Wall_Watcher_Entity> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    public Wall_Watcher_Entity(Level level, BlockPos pos, int timer, int effectiveChargeTime, double knockbackSpeedIndex, float damagePerEffectiveCharge, double dx, double dz, LivingEntity source) {
        super((EntityType)ModEntities.WALL_WATCHER.get(), level);
        this.setPos(pos.getX(), pos.getY(), pos.getZ());
        this.entityData.set(TIMER, (Object)timer);
        this.effectiveChargeTime = effectiveChargeTime;
        this.knockbackSpeedIndex = knockbackSpeedIndex;
        this.damagePerEffectiveCharge = damagePerEffectiveCharge;
        this.dx = dx;
        this.dz = dz;
        this.source = source;
        this.watchedEntities = new ArrayList<YUnchangedLivingEntity>();
    }

    public void watch(LivingEntity livingEntity) {
        if (livingEntity != null) {
            this.watchedEntities.add(new YUnchangedLivingEntity(livingEntity));
        }
    }

    public void removeFromWatchList(YUnchangedLivingEntity yUnchangedLivingEntity) {
        if (yUnchangedLivingEntity != null) {
            this.watchedEntities.remove(yUnchangedLivingEntity);
        }
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            int temp = (Integer)this.entityData.get(TIMER);
            if (this.watchedEntities != null && this.source != null) {
                if (!this.watchedEntities.isEmpty()) {
                    ArrayList<YUnchangedLivingEntity> entitiesRemoveFromWatchList = new ArrayList<YUnchangedLivingEntity>();
                    for (YUnchangedLivingEntity entity : this.watchedEntities) {
                        if (entity.livingEntity.horizontalCollision) {
                            if (!entity.livingEntity.isAlliedTo((Entity)this.source)) {
                                entity.livingEntity.invulnerableTime = 0;
                                float realDamageApplied = this.damagePerEffectiveCharge * (float)this.effectiveChargeTime + 1.0f;
                                boolean flag = entity.livingEntity.hurt(this.damageSources().mobProjectile((Entity)this, this.source), realDamageApplied);
                                if (flag) {
                                    entity.livingEntity.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 0.3f, 1.0f);
                                    entity.livingEntity.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 50));
                                }
                            }
                            entitiesRemoveFromWatchList.add(entity);
                            continue;
                        }
                        entity.setMotion(this.dx * this.knockbackSpeedIndex, this.dz * this.knockbackSpeedIndex);
                    }
                    for (YUnchangedLivingEntity remove : entitiesRemoveFromWatchList) {
                        this.removeFromWatchList(remove);
                    }
                    if (temp - 1 == 0) {
                        this.watchedEntities.clear();
                        this.remove(Entity.RemovalReason.DISCARDED);
                    } else {
                        this.entityData.set(TIMER, (Object)(temp - 1));
                    }
                } else if (temp - 1 == 0) {
                    this.remove(Entity.RemovalReason.DISCARDED);
                } else {
                    this.entityData.set(TIMER, (Object)(temp - 1));
                }
            } else {
                this.remove(Entity.RemovalReason.DISCARDED);
            }
        }
    }

    public boolean isNoGravity() {
        return true;
    }

    protected void readAdditionalSaveData(CompoundTag p_20052_) {
        this.source = null;
    }

    protected void addAdditionalSaveData(CompoundTag p_20139_) {
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(TIMER, (Object)0);
    }

    static class YUnchangedLivingEntity {
        LivingEntity livingEntity;
        double Y;

        public YUnchangedLivingEntity(LivingEntity livingEntity) {
            this.livingEntity = livingEntity;
            this.Y = livingEntity.getY();
        }

        void setMotion(double X, double Z) {
            this.livingEntity.setDeltaMovement(X, 0.0, Z);
            this.livingEntity.setPos(this.livingEntity.getX(), this.Y, this.livingEntity.getZ());
            this.livingEntity.hurtMarked = true;
        }
    }
}

