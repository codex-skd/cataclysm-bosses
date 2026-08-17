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
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.entity.projectile;

import com.skd.thesundering.client.particle.Options.CircleLightningParticleOptions;
import com.skd.thesundering.client.particle.Options.NotSpinTrailParticleOptions;
import com.skd.thesundering.entity.effect.ScreenShake_Entity;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Storm_Serpent_Entity
extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Storm_Serpent_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Storm_Serpent_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(Storm_Serpent_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState Spawn2AnimationState = new AnimationState();

    public Storm_Serpent_Entity(EntityType<? extends Storm_Serpent_Entity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public Storm_Serpent_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, float damage, LivingEntity finalTarget, boolean right) {
        this((EntityType<? extends Storm_Serpent_Entity>)((EntityType)ModEntities.STORM_SERPENT.get()), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.finalTarget = finalTarget;
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setDamage(damage);
        this.setPos(x, y, z);
        this.setRight(right);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(STATE, (Object)0);
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(RIGHT, (Object)false);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "spawn") {
            return this.SpawnAnimationState;
        }
        if (input == "spawn2") {
            return this.Spawn2AnimationState;
        }
        return new AnimationState();
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_) && this.level().isClientSide()) {
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
                    this.Spawn2AnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.SpawnAnimationState.stop();
        this.Spawn2AnimationState.stop();
    }

    public int getState() {
        return (Integer)this.entityData.get(STATE);
    }

    public void setState(int state) {
        this.entityData.set(STATE, (Object)state);
    }

    public boolean getRight() {
        return (Boolean)this.entityData.get(RIGHT);
    }

    public void setRight(boolean right) {
        this.entityData.set(RIGHT, (Object)right);
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        Entity entity;
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.casterUuid)) instanceof LivingEntity) {
            this.caster = (LivingEntity)entity;
        }
        return this.caster;
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        if (compound.hasUUID("Target")) {
            this.targetId = compound.getUUID("Target");
        }
        this.setDamage(compound.getFloat("Damage"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.finalTarget != null) {
            compound.putUUID("Target", this.finalTarget.getUUID());
        }
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        compound.putFloat("Damage", this.getDamage());
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.clientSideAttackStarted) {
                int i;
                ++this.lifeTicks;
                if (this.lifeTicks == 10) {
                    for (i = 0; i < 12; ++i) {
                        float angle = (float)Math.PI / 180 * this.getYRot() + (float)i;
                        float r = 0.5f + this.random.nextFloat() * 0.9f;
                        float velocity = r + this.random.nextFloat() * 4.0f;
                        float x = r * Mth.sin((float)((float)(Math.PI + (double)angle)));
                        float z = r * Mth.cos((float)angle);
                        double d0 = this.getX() + (double)x;
                        double d1 = this.getY() + 0.1;
                        double d2 = this.getZ() + (double)z;
                        double extraX = d0 + (double)(velocity * 0.4f * Mth.sin((float)((float)(Math.PI + (double)angle))));
                        double extraY = d1 + (double)0.3f + (double)(this.random.nextFloat() * 2.0f);
                        double extraZ = d2 + (double)(velocity * 0.4f * Mth.cos((float)angle));
                        this.level().addParticle((ParticleOptions)new NotSpinTrailParticleOptions(0.44313726f, 0.7607843f, 0.9411765f, 0.05f, 0.75f, 0.5f, 0.0, 60 + this.random.nextInt(40)), d0, d1, d2, extraX, extraY, extraZ);
                    }
                }
                if (this.lifeTicks > 12 && this.lifeTicks < 18) {
                    for (i = 0; i < 5; ++i) {
                        this.level().addParticle((ParticleOptions)new CircleLightningParticleOptions(0.1f, 113, 194, 240), this.getX(), this.getY() + 0.1, this.getZ(), this.getX() + (double)((this.random.nextFloat() - 0.5f) * 7.0f), this.getY() + 0.1, this.getZ() + (double)((this.random.nextFloat() - 0.5f) * 7.0f));
                    }
                }
                if (this.lifeTicks == 52) {
                    for (i = 0; i < 12; ++i) {
                        double theta = Math.toRadians(this.getYRot());
                        double vecX = Math.cos(theta) * 8.0;
                        double vecZ = Math.sin(theta) * 8.0;
                        float angle = (float)Math.PI / 180 * this.getYRot() + (float)i;
                        float r = 0.5f + this.random.nextFloat() * 0.9f;
                        float velocity = r + this.random.nextFloat() * 4.0f;
                        float x = (float)(vecX + (double)(r * Mth.sin((float)((float)(Math.PI + (double)angle)))));
                        float z = (float)(vecZ + (double)(r * Mth.cos((float)angle)));
                        double d0 = this.getX() + (double)x;
                        double d1 = this.getY() + 0.1;
                        double d2 = this.getZ() + (double)z;
                        double extraX = d0 + (double)(velocity * 0.6f * Mth.sin((float)((float)(Math.PI + (double)angle))));
                        double extraY = d1 + (double)0.3f + (double)(this.random.nextFloat() * 1.2f);
                        double extraZ = d2 + (double)(velocity * 0.6f * Mth.cos((float)angle));
                        this.level().addParticle((ParticleOptions)new NotSpinTrailParticleOptions(0.44313726f, 0.7607843f, 0.9411765f, 0.05f, 0.75f, 0.5f, 0.0, 80 + this.random.nextInt(40)), d0, d1, d2, extraX, extraY, extraZ);
                    }
                }
                if (this.lifeTicks > 52 && this.lifeTicks < 56) {
                    for (i = 0; i < 5; ++i) {
                        double theta = Math.toRadians(this.getYRot());
                        double vecX = Math.cos(theta) * 8.0;
                        double vecZ = Math.sin(theta) * 8.0;
                        this.level().addParticle((ParticleOptions)new CircleLightningParticleOptions(0.1f, 113, 194, 240), this.getX() + vecX, this.getY() + 0.1, this.getZ() + vecZ, this.getX() + vecX + (double)((this.random.nextFloat() - 0.5f) * 7.0f), this.getY() + 0.1, this.getZ() + vecZ + (double)((this.random.nextFloat() - 0.5f) * 7.0f));
                    }
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10 && this.getState() == 0) {
                this.setState(!this.getRight() ? 1 : 2);
            }
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerLevel)this.level()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
            if (this.finalTarget != null && this.finalTarget.isAlive() && this.warmupDelayTicks > -48) {
                this.lookAt(this.finalTarget, 30.0f, 0.0f);
            }
            if (this.warmupDelayTicks == -52 || this.warmupDelayTicks == -53 || this.warmupDelayTicks == -54 || this.warmupDelayTicks == -55) {
                double theta = Math.toRadians(this.getYRot());
                double vecX = this.getX() + Math.cos(theta) * 8.0;
                double vecZ = this.getZ() + Math.sin(theta) * 8.0;
                AABB selection = new AABB(vecX - 1.5, this.getY() - 2.0, vecZ - 1.5, vecX + 1.5, this.getY() + (double)this.getBbHeight(), vecZ + 1.5);
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, selection)) {
                    this.damage(livingentity);
                }
                Vec3 vec3 = new Vec3(vecX, this.getY(), vecZ);
                ScreenShake_Entity.ScreenShake(this.level(), vec3, 10.0f, 0.07f, 0, 20);
            }
            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent((Entity)this, (byte)4);
                this.sentSpikeEvent = true;
            }
            if (++this.lifeTicks > 70) {
                this.discard();
            }
        }
    }

    protected void lookAt(Entity entity, float maxYRotIncrease, float maxXRotIncrease) {
        double d1;
        double d0 = entity.getX() - this.getX();
        double d2 = entity.getZ() - this.getZ();
        if (entity instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entity;
            d1 = livingentity.getEyeY() - this.getEyeY();
        } else {
            d1 = (entity.getBoundingBox().minY + entity.getBoundingBox().maxY) / 2.0 - this.getEyeY();
        }
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        float f = (float)(Mth.atan2((double)d2, (double)d0) * 180.0 / 3.1415927410125732);
        float f1 = (float)(-(Mth.atan2((double)d1, (double)d3) * 180.0 / 3.1415927410125732));
        this.setXRot(this.rotlerp(this.getXRot(), f1, maxXRotIncrease));
        this.setYRot(this.rotlerp(this.getYRot(), f, maxYRotIncrease));
    }

    private float rotlerp(float angle, float targetAngle, float maxIncrease) {
        float f = Mth.wrapDegrees((float)(targetAngle - angle));
        if (f > maxIncrease) {
            f = maxIncrease;
        }
        if (f < -maxIncrease) {
            f = -maxIncrease;
        }
        return angle + f;
    }

    protected void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            boolean flag;
            if (livingentity == null) {
                Hitentity.hurt(this.damageSources().magic(), this.getDamage());
            } else if (!livingentity.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)livingentity) && (flag = Hitentity.hurt(this.damageSources().indirectMagic((Entity)this, (Entity)livingentity), this.getDamage()))) {
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTWETNESS, 150, 4, false, true, true);
                Hitentity.addEffect(effectinstance);
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.isSilent()) {
                // empty if block
            }
        }
    }

    public float getAnimationProgress(float p_36937_) {
        if (!this.clientSideAttackStarted) {
            return 0.0f;
        }
        int i = this.lifeTicks - 2;
        return i <= 0 ? 1.0f : 1.0f - ((float)i - p_36937_) / 20.0f;
    }
}

