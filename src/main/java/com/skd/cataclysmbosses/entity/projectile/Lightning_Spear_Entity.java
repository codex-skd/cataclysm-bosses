/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.client.particle.Options.CircleLightningParticleOptions;
import com.skd.cataclysmbosses.entity.effect.Lightning_Area_Effect_Entity;
import com.skd.cataclysmbosses.entity.effect.Lightning_Storm_Entity;
import com.skd.cataclysmbosses.entity.projectile.Elemental_Spear_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Lightning_Spear_Entity
extends Elemental_Spear_Entity {
    private static final EntityDataAccessor<Float> AREA_RADIUS = SynchedEntityData.defineId(Lightning_Spear_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_DAMAGE = SynchedEntityData.defineId(Lightning_Spear_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HP_DAMAGE = SynchedEntityData.defineId(Lightning_Spear_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level, double accel) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        this.setOldPosAndRot();
        this.setState(1);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, accel);
    }

    public Lightning_Spear_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage, double accel) {
        this((EntityType<? extends Lightning_Spear_Entity>)((EntityType)ModEntities.LIGHTNING_SPEAR.get()), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_, accel);
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
    }

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.setPos(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(AREA_RADIUS, Float.valueOf(0.0f));
        p_326229_.define(AREA_DAMAGE, Float.valueOf(0.0f));
        p_326229_.define(HP_DAMAGE, Float.valueOf(0.0f));
    }

    public float getAreaRadius() {
        return ((Float)this.entityData.get(AREA_RADIUS)).floatValue();
    }

    public void setAreaRadius(float radius) {
        this.entityData.set(AREA_RADIUS, Float.valueOf(radius));
    }

    public float getAreaDamage() {
        return ((Float)this.entityData.get(AREA_DAMAGE)).floatValue();
    }

    public void setAreaDamage(float damage) {
        this.entityData.set(AREA_DAMAGE, Float.valueOf(damage));
    }

    public float getHpDamage() {
        return ((Float)this.entityData.get(HP_DAMAGE)).floatValue();
    }

    public void setHpDamage(float damage) {
        this.entityData.set(HP_DAMAGE, Float.valueOf(damage));
    }

    @Override
    protected void SpawnParticle() {
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        int r = 89 + this.random.nextInt(5);
        int g = 180 + this.random.nextInt(5);
        int b = 180 + this.random.nextInt(5);
        this.level().addParticle((ParticleOptions)new CircleLightningParticleOptions(0.1f, r, g, b), this.getX(), this.getY(0.5), this.getZ(), d0, d1, d2);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            Entity entity = p_37626_.getEntity();
            Entity entity2 = this.getOwner();
            if (entity2 instanceof LivingEntity) {
                DamageSource damagesource;
                boolean flag;
                LivingEntity livingentity = (LivingEntity)entity2;
                if (!this.isAlliedTo(entity) && !livingentity.equals((Object)entity) && !livingentity.isAlliedTo(entity) && (flag = entity.hurtOrSimulate(damagesource = CMDamageTypes.causeLightningDamage((Entity)this, (Entity)livingentity), this.getDamage())) && entity.isAlive()) {
                    EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                }
            } else {
                entity.hurtOrSimulate(this.damageSources().magic(), 5.0f);
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        Vec3 blockpos = result.getLocation();
        if (!this.level().isClientSide()) {
            Lightning_Area_Effect_Entity areaeffectcloud = new Lightning_Area_Effect_Entity(this.level(), blockpos.x(), blockpos.y(), blockpos.z());
            areaeffectcloud.setRadius(this.getAreaRadius());
            LivingEntity entity1 = (LivingEntity)this.getOwner();
            areaeffectcloud.setOwner(entity1);
            areaeffectcloud.setRadiusOnUse(-1.0f);
            areaeffectcloud.setDamage(this.getAreaDamage());
            areaeffectcloud.setWaitTime(12);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            this.level().addFreshEntity((Entity)areaeffectcloud);
            this.level().addFreshEntity((Entity)new Lightning_Storm_Entity(this.level(), blockpos.x(), blockpos.y(), blockpos.z(), this.getYRot(), -5, this.getAreaDamage(), this.getHpDamage(), entity1, 2.0f));
            this.discard();
        }
    }

    @Override
    protected float getInertia() {
        return 0.98f;
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
        compound.putFloat("area_damage", this.getAreaDamage());
        compound.putFloat("hp_damage", this.getAreaRadius());
        compound.putFloat("area_radius", this.getAreaRadius());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDoubleOr("acceleration_power", 0.0);
        }
        this.setAreaDamage(compound.getFloatOr("area_damage", 0.0f));
        this.setHpDamage(compound.getFloatOr("hp_damage", 0.0f));
        this.setAreaRadius(compound.getFloatOr("area_radius", 0.0f));
    }
}

