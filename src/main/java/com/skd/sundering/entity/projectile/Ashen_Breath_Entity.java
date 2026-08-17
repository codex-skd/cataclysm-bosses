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
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.PushReaction
 */
package com.skd.sundering.entity.projectile;

import com.skd.sundering.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;

public class Ashen_Breath_Entity
extends Entity {
    private static final int RANGE = 7;
    private static final int ARC = 45;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Ashen_Breath_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Ashen_Breath_Entity(EntityType<? extends Ashen_Breath_Entity> type, Level world) {
        super(type, world);
    }

    public Ashen_Breath_Entity(EntityType<? extends Ashen_Breath_Entity> type, Level world, float damage, LivingEntity caster) {
        super(type, world);
        this.setCaster(caster);
        this.setDamage(damage);
    }

    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    public void tick() {
        super.tick();
        if (this.caster != null && !this.caster.isAlive()) {
            this.discard();
        }
        if (this.caster != null) {
            this.setYRot(this.caster.yHeadRot);
        }
        float yaw = (float)Math.toRadians(-this.getYRot());
        float pitch = (float)Math.toRadians(-this.getXRot());
        float spread = 0.25f;
        float speed = 0.56f;
        float xComp = (float)(Math.sin(yaw) * Math.cos(pitch));
        float yComp = (float)Math.sin(pitch);
        float zComp = (float)(Math.cos(yaw) * Math.cos(pitch));
        double theta = (double)this.getYRot() * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        double vec = 0.9;
        if (this.level().isClientSide()) {
            double zSpeed;
            double ySpeed;
            double xSpeed;
            int i;
            for (i = 0; i < 80; ++i) {
                xSpeed = (double)(speed * xComp) + (double)(spread * 1.0f * (this.random.nextFloat() * 2.0f - 1.0f)) * Math.sqrt(1.0f - xComp * xComp);
                ySpeed = (double)(speed * yComp) + (double)(spread * 1.0f * (this.random.nextFloat() * 2.0f - 1.0f)) * Math.sqrt(1.0f - yComp * yComp);
                zSpeed = (double)(speed * zComp) + (double)(spread * 1.0f * (this.random.nextFloat() * 2.0f - 1.0f)) * Math.sqrt(1.0f - zComp * zComp);
                this.level().addParticle((ParticleOptions)ParticleTypes.SMOKE, this.getX() + vec * vecX, this.getY(), this.getZ() + vec * vecZ, xSpeed, ySpeed, zSpeed);
            }
            for (i = 0; i < 2; ++i) {
                xSpeed = (double)(speed * xComp) + (double)spread * 0.7 * (double)(this.random.nextFloat() * 2.0f - 1.0f) * Math.sqrt(1.0f - xComp * xComp);
                ySpeed = (double)(speed * yComp) + (double)spread * 0.7 * (double)(this.random.nextFloat() * 2.0f - 1.0f) * Math.sqrt(1.0f - yComp * yComp);
                zSpeed = (double)(speed * zComp) + (double)spread * 0.7 * (double)(this.random.nextFloat() * 2.0f - 1.0f) * Math.sqrt(1.0f - zComp * zComp);
                this.level().addParticle((ParticleOptions)ParticleTypes.FLAME, this.getX() + vec * vecX, this.getY(), this.getZ() + vec * vecZ, xSpeed, ySpeed, zSpeed);
            }
        }
        if (this.tickCount > 2 && this.caster != null) {
            this.hitEntities();
        }
        if (this.tickCount > 25) {
            this.discard();
        }
    }

    public void hitEntities() {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(7.0, 7.0, 7.0, 7.0);
        for (LivingEntity entityHit : entitiesHit) {
            boolean flag;
            boolean CloseCheck;
            int distance;
            float entityHitYaw = (float)((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * 57.29577951308232 - 90.0) % 360.0);
            float entityAttackingYaw = this.getYRot() % 360.0f;
            if (entityHitYaw < 0.0f) {
                entityHitYaw += 360.0f;
            }
            if (entityAttackingYaw < 0.0f) {
                entityAttackingYaw += 360.0f;
            }
            float entityRelativeYaw = entityHitYaw - entityAttackingYaw;
            float xzDistance = (float)Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            double hitY = entityHit.getY() + (double)entityHit.getBbHeight() / 2.0;
            float entityHitPitch = (float)(Math.atan2(hitY - this.getY(), xzDistance) * 57.29577951308232 % 360.0);
            float entityAttackingPitch = -this.getXRot() % 360.0f;
            if (entityHitPitch < 0.0f) {
                entityHitPitch += 360.0f;
            }
            if (entityAttackingPitch < 0.0f) {
                entityAttackingPitch += 360.0f;
            }
            float entityRelativePitch = entityHitPitch - entityAttackingPitch;
            float entityHitDistance = (float)Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()) + (hitY - this.getY()) * (hitY - this.getY()));
            boolean inRange = entityHitDistance <= (float)(distance = this.tickCount / 2) + 1.0f;
            boolean yawCheck = entityRelativeYaw <= 22.5f && entityRelativeYaw >= -22.5f || entityRelativeYaw >= 337.5f || entityRelativeYaw <= -337.5f;
            boolean pitchCheck = entityRelativePitch <= 22.5f && entityRelativePitch >= -22.5f || entityRelativePitch >= 337.5f || entityRelativePitch <= -337.5f;
            boolean bl = CloseCheck = this.caster instanceof Ignited_Revenant_Entity && entityHitDistance <= 2.0f;
            if ((!inRange || !yawCheck || !pitchCheck) && !CloseCheck || this.tickCount % 3 != 0 || this.isAlliedTo((Entity)entityHit) || entityHit == this.caster || !(flag = entityHit.hurt(this.damageSources().indirectMagic((Entity)this, (Entity)this.caster), this.getDamage()))) continue;
            MobEffectInstance effectinstance = new MobEffectInstance(MobEffects.BLINDNESS, 60, 0, false, false, true);
            entityHit.addEffect(effectinstance);
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
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
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }

    public boolean isPickable() {
        return false;
    }

    public void push(Entity entityIn) {
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), e -> e != this && (double)this.distanceTo((Entity)e) <= r + (double)(e.getBbWidth() / 2.0f) && e.getY() <= this.getY() + dY);
    }

    public boolean isPushable() {
        return false;
    }
}

