/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ThrowableProjectile
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.effect.Wither_Smoke_Effect_Entity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Wither_Howitzer_Entity
extends ThrowableProjectile {
    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(Wither_Howitzer_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Wither_Howitzer_Entity(EntityType<Wither_Howitzer_Entity> type, Level world) {
        super(type, world);
    }

    public Wither_Howitzer_Entity(EntityType<Wither_Howitzer_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower.getX(), thrower.getEyeY() - 0.10000000149011612D, thrower.getZ(), world);
        this.setOwner(thrower);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(RADIUS, Float.valueOf(0.5f));
    }

    public void setRadius(float p_19713_) {
        if (!this.level().isClientSide()) {
            this.getEntityData().set(RADIUS, Float.valueOf(Mth.clamp((float)p_19713_, (float)0.0f, (float)32.0f)));
        }
    }

    public float getRadius() {
        return ((Float)this.getEntityData().get(RADIUS)).floatValue();
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            boolean flag;
            ServerLevel serverlevel = (ServerLevel)level;
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            if (entity1 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity1;
                DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, livingentity);
                flag = entity.hurtOrSimulate(damagesource, 11.0f);
                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                    } else if (entity1 instanceof The_Harbinger_Entity) {
                        livingentity.heal((float)CMCommonConfig.Harbinger.LifeSteal);
                    } else {
                        livingentity.heal(5.0f);
                    }
                }
            } else {
                flag = entity.hurtOrSimulate(this.damageSources().magic(), 5.0f);
            }
            if (flag && entity instanceof LivingEntity) {
                int i = 10;
                if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    i = 20;
                } else if (this.level().getDifficulty() == Difficulty.HARD) {
                    i = 30;
                }
                ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * i, 1), this.getEffectSource());
            }
        }
    }

    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide()) {
            this.level().explode((Entity)this, this.getX(), this.getY(), this.getZ(), 2.0f, false, Level.ExplosionInteraction.NONE);
            Wither_Smoke_Effect_Entity areaeffectcloud = new Wither_Smoke_Effect_Entity(this.level(), this.getX(), this.getY(), this.getZ());
            areaeffectcloud.setRadius(this.getRadius());
            LivingEntity entity1 = (LivingEntity)this.getOwner();
            areaeffectcloud.setOwner(entity1);
            areaeffectcloud.setRadiusOnUse(-0.5f);
            areaeffectcloud.setWaitTime(5);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            this.level().addFreshEntity((Entity)areaeffectcloud);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 40.0f, 0.05f, 0, 20);
            this.discard();
        }
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("radius", this.getRadius());
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setRadius(compound.getFloatOr("radius", 0.0f));
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            Vec3 vec3 = this.getDeltaMovement();
            this.level().addParticle((ParticleOptions)ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            this.level().addParticle((ParticleOptions)ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
        }
    }

    protected double getDefaultGravity() {
        return 0.03f;
    }
}

