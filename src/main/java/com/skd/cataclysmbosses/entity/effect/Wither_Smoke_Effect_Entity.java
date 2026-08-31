/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.PushReaction
 */
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.init.ModEntities;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Wither_Smoke_Effect_Entity
extends Entity {
    private static final EntityDataAccessor<Float> DATA_RADIUS = SynchedEntityData.defineId(Wither_Smoke_Effect_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> DATA_WAITING = SynchedEntityData.defineId(Wither_Smoke_Effect_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final float MAX_RADIUS = 32.0f;
    private int duration = 600;
    private int waitTime = 20;
    private int durationOnUse;
    private float radiusOnUse;
    private float radiusPerTick;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Wither_Smoke_Effect_Entity(EntityType<? extends Wither_Smoke_Effect_Entity> p_19704_, Level p_19705_) {
        super(p_19704_, p_19705_);
        this.noPhysics = true;
        this.setRadius(3.0f);
    }

    public Wither_Smoke_Effect_Entity(Level p_19707_, double p_19708_, double p_19709_, double p_19710_) {
        this((EntityType<? extends Wither_Smoke_Effect_Entity>)((EntityType)ModEntities.WITHER_SMOKE_EFFECT.get()), p_19707_);
        this.setPos(p_19708_, p_19709_, p_19710_);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DATA_RADIUS, Float.valueOf(0.5f));
        p_326229_.define(DATA_WAITING, false);
    }

    public void setRadius(float p_19713_) {
        if (!this.level().isClientSide()) {
            this.getEntityData().set(DATA_RADIUS, Float.valueOf(Mth.clamp((float)p_19713_, (float)0.0f, (float)32.0f)));
        }
    }

    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }

    public float getRadius() {
        return ((Float)this.getEntityData().get(DATA_RADIUS)).floatValue();
    }

    protected void setWaiting(boolean p_19731_) {
        this.getEntityData().set(DATA_WAITING, p_19731_);
    }

    public boolean isWaiting() {
        return (Boolean)this.getEntityData().get(DATA_WAITING);
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int p_19735_) {
        this.duration = p_19735_;
    }

    public void tick() {
        block11: {
            boolean flag1;
            float f;
            boolean flag;
            block10: {
                float f1;
                super.tick();
                flag = this.isWaiting();
                f = this.getRadius();
                if (!this.level().isClientSide()) break block10;
                if (flag && this.random.nextBoolean()) {
                    return;
                }
                int i;
                if (flag) {
                    i = 2;
                    f1 = 0.2f;
                } else {
                    i = Mth.ceil((float)((float)Math.PI * f * f));
                    f1 = f;
                }
                for (int j = 0; j < 10 + this.random.nextInt(2); ++j) {
                    float f2 = this.random.nextFloat() * ((float)Math.PI * 2);
                    float f3 = Mth.sqrt((float)this.random.nextFloat()) * f1;
                    double d0 = this.getX() + (double)(Mth.cos((float)f2) * f3);
                    double d2 = this.getY();
                    double d4 = this.getZ() + (double)(Mth.sin((float)f2) * f3);
                    this.level().addAlwaysVisibleParticle((ParticleOptions)ParticleTypes.SMOKE, d0, d2, d4, 0.0, this.random.nextGaussian() * 0.07, 0.0);
                }
                break block11;
            }
            if (this.tickCount >= this.waitTime + this.duration) {
                this.discard();
                return;
            }
            boolean bl = flag1 = this.tickCount < this.waitTime;
            if (flag != flag1) {
                this.setWaiting(flag1);
            }
            if (flag1) {
                return;
            }
            if (this.radiusPerTick != 0.0f) {
                if ((f += this.radiusPerTick) < 0.5f) {
                    this.discard();
                    return;
                }
                this.setRadius(f);
            }
            if (this.tickCount % 5 != 0) break block11;
            for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                this.damage(livingentity);
            }
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity caster = this.getOwner();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != caster && this.tickCount % 5 == 0) {
            boolean flag;
            if (caster == null) {
                boolean flag2 = Hitentity.hurtOrSimulate(this.damageSources().wither(), 3.0f);
                if (flag2) {
                    MobEffectInstance effectinstance = new MobEffectInstance(MobEffects.WITHER, 160, 0, false, false, true);
                    Hitentity.addEffect(effectinstance);
                }
            } else if (!caster.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)caster) && (flag = Hitentity.hurtOrSimulate(this.damageSources().indirectMagic((Entity)this, (Entity)caster), 3.0f))) {
                MobEffectInstance effectinstance = new MobEffectInstance(MobEffects.WITHER, 160, 0, false, false, true);
                Hitentity.addEffect(effectinstance);
            }
        }
    }

    public float getRadiusOnUse() {
        return this.radiusOnUse;
    }

    public void setRadiusOnUse(float p_19733_) {
        this.radiusOnUse = p_19733_;
    }

    public float getRadiusPerTick() {
        return this.radiusPerTick;
    }

    public void setRadiusPerTick(float p_19739_) {
        this.radiusPerTick = p_19739_;
    }

    public int getDurationOnUse() {
        return this.durationOnUse;
    }

    public void setDurationOnUse(int p_146786_) {
        this.durationOnUse = p_146786_;
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public void setWaitTime(int p_19741_) {
        this.waitTime = p_19741_;
    }

    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        this.ownerUUID = p_19719_ == null ? null : p_19719_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        Entity entity;
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.ownerUUID)) instanceof LivingEntity) {
            this.owner = (LivingEntity)entity;
        }
        return this.owner;
    }

    protected void readAdditionalSaveData(ValueInput p_19727_) {
        this.tickCount = p_19727_.getIntOr("Age", 0);
        this.duration = p_19727_.getIntOr("Duration", 0);
        this.waitTime = p_19727_.getIntOr("WaitTime", 0);
        this.durationOnUse = p_19727_.getIntOr("DurationOnUse", 0);
        this.radiusOnUse = p_19727_.getFloatOr("RadiusOnUse", 0.0F);
        this.radiusPerTick = p_19727_.getFloatOr("RadiusPerTick", 0.0F);
        this.setRadius(p_19727_.getFloatOr("Radius", 0.0F));
        if (p_19727_.read("Owner", UUIDUtil.CODEC).isPresent()) {
            this.ownerUUID = p_19727_.read("Owner", UUIDUtil.CODEC).orElse(null);
        }
    }

    protected void addAdditionalSaveData(ValueOutput p_19737_) {
        p_19737_.putInt("Age", this.tickCount);
        p_19737_.putInt("Duration", this.duration);
        p_19737_.putInt("WaitTime", this.waitTime);
        p_19737_.putInt("DurationOnUse", this.durationOnUse);
        p_19737_.putFloat("RadiusOnUse", this.radiusOnUse);
        p_19737_.putFloat("RadiusPerTick", this.radiusPerTick);
        p_19737_.putFloat("Radius", this.getRadius());
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_19729_) {
        if (DATA_RADIUS.equals(p_19729_)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(p_19729_);
    }

    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    public EntityDimensions getDimensions(Pose p_19721_) {
        return EntityDimensions.scalable((float)(this.getRadius() * 2.0f), (float)0.5f);
    }

    @Override
    public boolean hurtServer(net.minecraft.server.level.ServerLevel level, net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }
}

