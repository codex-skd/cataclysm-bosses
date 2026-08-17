/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.entity.effect;

import com.skd.sundering.client.particle.Options.CustomPoofParticleOptions;
import com.skd.sundering.init.ModEffect;
import com.skd.sundering.init.ModEntities;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Wave_Entity
extends Entity {
    private static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Wave_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MAX_TICKS = SynchedEntityData.defineId(Wave_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> Y_ROT = SynchedEntityData.defineId(Wave_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Wave_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Wave_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;
    private boolean sentEvent;
    private boolean clientSideAttackEnded;
    private int lSteps;
    private double lx;
    private double ly;
    private double lz;
    private double lyr;
    private double lxr;
    private double lxd;
    private double lyd;
    private double lzd;

    public Wave_Entity(EntityType entityType, Level level) {
        super(entityType, level);
    }

    public Wave_Entity(Level level, LivingEntity shooter, int life, float damage) {
        this((EntityType)ModEntities.WAVE.get(), level);
        this.setOwner(shooter);
        this.setMaxTicks(life);
        this.setDamage(damage);
        this.setLifespan(0);
    }

    public float maxUpStep() {
        return 2.0f;
    }

    public void setOwner(@Nullable LivingEntity living) {
        this.owner = living;
        this.ownerUUID = living == null ? null : living.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        Entity entity;
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.ownerUUID)) instanceof LivingEntity) {
            this.owner = (LivingEntity)entity;
        }
        return this.owner;
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(LIFESPAN, (Object)0);
        p_326229_.define(MAX_TICKS, (Object)0);
        p_326229_.define(Y_ROT, (Object)Float.valueOf(0.0f));
        p_326229_.define(STATE, (Object)0);
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
    }

    public AnimationState getAnimationState(String input) {
        if (input == "spawn") {
            return this.SpawnAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "despawn") {
            return this.DespawnAnimationState;
        }
        return new AnimationState();
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            switch (this.getState()) {
                case 0: {
                    this.stopAllAnimationStates();
                    break;
                }
                case 1: {
                    this.stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.idleAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.DespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.idleAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return (Integer)this.entityData.get(STATE);
    }

    public void setState(int state) {
        this.entityData.set(STATE, (Object)state);
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.hasUUID("Owner")) {
            this.ownerUUID = tag.getUUID("Owner");
        }
        if (tag.contains("Lifespan")) {
            this.setLifespan(tag.getInt("Lifespan"));
        }
        if (tag.contains("Maxticks")) {
            this.setMaxTicks(tag.getInt("Maxticks"));
        }
    }

    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (this.ownerUUID != null) {
            compoundTag.putUUID("Owner", this.ownerUUID);
        }
        compoundTag.putInt("Lifespan", this.getLifespan());
        compoundTag.putInt("Maxticks", this.getMaxTicks());
    }

    public float getYRot() {
        return ((Float)this.entityData.get(Y_ROT)).floatValue();
    }

    public void setYRot(float f) {
        this.entityData.set(Y_ROT, (Object)Float.valueOf(f));
    }

    public int getLifespan() {
        return (Integer)this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int time) {
        this.entityData.set(LIFESPAN, (Object)time);
    }

    public int getMaxTicks() {
        return (Integer)this.entityData.get(MAX_TICKS);
    }

    public void setMaxTicks(int time) {
        this.entityData.set(MAX_TICKS, (Object)time);
    }

    private void spawnParticleAt(float yOffset, float zOffset, float xOffset, ParticleOptions particleType) {
        Vec3 vec3 = new Vec3((double)xOffset, (double)yOffset, (double)zOffset).yRot((float)Math.toRadians(-this.getYRot()));
        this.level().addParticle(particleType, this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z, this.getDeltaMovement().x, (double)0.1f, this.getDeltaMovement().z);
    }

    public void tick() {
        super.tick();
        if (!this.isNoGravity() && !this.isInWaterOrBubble()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, (double)-0.04f, 0.0));
        }
        if (this.getState() == 1 && this.getLifespan() >= 5) {
            this.setState(2);
        }
        if (this.getState() == 2) {
            if (this.getLifespan() >= this.getMaxTicks() - 30 && !this.sentEvent) {
                this.level().broadcastEntityEvent((Entity)this, (byte)4);
                this.sentEvent = true;
            }
            if (this.getLifespan() >= this.getMaxTicks() - 10) {
                this.setState(3);
            }
        }
        this.setLifespan(this.getLifespan() + 1);
        if (this.getLifespan() >= this.getMaxTicks()) {
            this.remove(Entity.RemovalReason.DISCARDED);
        }
        float f = Math.max(1.0f - (float)this.getLifespan() / (1.0f * (float)this.getMaxTicks()), 0.0f);
        Vec3 directionVec = new Vec3(0.0, 0.0, (double)(f * f * 0.1f)).yRot((float)Math.toRadians(-this.getYRot()));
        if (this.level().isClientSide()) {
            if (this.lSteps > 0) {
                double d5 = this.getX() + (this.lx - this.getX()) / (double)this.lSteps;
                double d6 = this.getY() + (this.ly - this.getY()) / (double)this.lSteps;
                double d7 = this.getZ() + (this.lz - this.getZ()) / (double)this.lSteps;
                this.setYRot(Mth.wrapDegrees((float)((float)this.lyr)));
                this.setXRot(this.getXRot() + (float)(this.lxr - (double)this.getXRot()) / (float)this.lSteps);
                --this.lSteps;
                this.setPos(d5, d6, d7);
            } else {
                this.reapplyPosition();
            }
            if (!this.clientSideAttackEnded) {
                for (int particleCount = 0; particleCount < 2; ++particleCount) {
                    for (int i = 0; i < 2; ++i) {
                        float xOffset = (float)(i - 1) / 2.0f + 0.25f + (this.random.nextFloat() - 0.5f) * 0.2f;
                        int rand = this.random.nextInt(20);
                        this.spawnParticleAt(0.1f + this.random.nextFloat() * 0.2f, 0.7f, xOffset * 3.5f, new CustomPoofParticleOptions(76 + rand, 147 + rand, 173 + rand, 0.1f));
                    }
                }
            }
        } else {
            this.reapplyPosition();
            this.setRot(this.getYRot(), this.getXRot());
            this.attackEntities(1.5, Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180))), -Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180))));
        }
        Vec3 vec3 = this.getDeltaMovement().scale((double)0.9f).add(directionVec);
        this.move(MoverType.SELF, vec3);
        this.setDeltaMovement(vec3.multiply((double)0.99f, (double)0.98f, (double)0.99f));
    }

    protected void attackEntities(double strength, double x, double z) {
        AABB bashBox = this.getBoundingBox().inflate((double)0.01f);
        DamageSource source = this.damageSources().mobProjectile((Entity)this, this.owner);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, bashBox)) {
            if (this.owner != null && (this.owner.equals((Object)entity) || this.owner.isAlliedTo((Entity)entity) || entity.isAlliedTo((Entity)this.owner))) continue;
            boolean flag = entity.hurt(source, this.getDamage());
            if (flag) {
                entity.extinguishFire();
                MobEffectInstance effectinstance1 = entity.getEffect(ModEffect.EFFECTWETNESS);
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    entity.removeEffectNoUpdate(ModEffect.EFFECTWETNESS);
                } else {
                    --i;
                }
                i = Mth.clamp((int)i, (int)0, (int)4);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTWETNESS, 200, i, false, true, true);
                entity.addEffect(effectinstance);
            }
            entity.hasImpulse = true;
            Vec3 vec3 = entity.getDeltaMovement();
            while (x * x + z * z < (double)1.0E-5f) {
                x = (Math.random() - Math.random()) * 0.01;
                z = (Math.random() - Math.random()) * 0.01;
            }
            double playerSize = 1.08;
            double entitySize = entity.getBbWidth() * entity.getBbHeight();
            double scale = playerSize / Math.max(0.1, entitySize);
            double knockbackScale = Math.min(scale, 1.5);
            double adjustedStrength = strength * knockbackScale;
            Vec3 knockback = new Vec3(x, 0.0, z).normalize().scale(adjustedStrength);
            entity.setDeltaMovement(vec3.x / 2.0 - knockback.x, entity.onGround() ? Math.min(0.5, vec3.y / 2.0 + strength) : vec3.y, vec3.z / 2.0 - knockback.z);
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackEnded = true;
        }
    }

    public void lerpTo(double x, double y, double z, float yr, float xr, int steps) {
        this.lx = x;
        this.ly = y;
        this.lz = z;
        this.lyr = yr;
        this.lxr = xr;
        this.lSteps = steps;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }

    public void lerpMotion(double lerpX, double lerpY, double lerpZ) {
        this.lxd = lerpX;
        this.lyd = lerpY;
        this.lzd = lerpZ;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }
}

