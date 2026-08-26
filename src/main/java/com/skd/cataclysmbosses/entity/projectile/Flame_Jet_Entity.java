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
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModParticle;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Flame_Jet_Entity
extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 22;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Flame_Jet_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Flame_Jet_Entity(EntityType<? extends Flame_Jet_Entity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public Flame_Jet_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, float damage, LivingEntity casterIn) {
        this((EntityType<? extends Flame_Jet_Entity>)((EntityType)ModEntities.FLAME_JET.get()), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setPos(x, y, z);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, Float.valueOf(damage));
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

    protected void readAdditionalSaveData(ValueInput compound) {
        this.warmupDelayTicks = compound.getIntOr("Warmup", 0);
        if (compound.read("Owner", UUIDUtil.CODEC).isPresent()) {
            this.casterUuid = compound.read("Owner", UUIDUtil.CODEC).orElse(null);
        }
        this.setDamage(compound.getFloatOr("damage", 0.0f));
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.store("Owner", UUIDUtil.CODEC, this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (this.lifeTicks == 14) {
                    double d0 = this.getX();
                    double d1 = this.getY() + 2.0;
                    double d2 = this.getZ();
                    this.level().addAlwaysVisibleParticle((ParticleOptions)ModParticle.FLAME_JET.get(), d0, d1, d2, 0.0, 0.0, 0.0);
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -8) {
                AABB aabb = this.getBoundingBox().inflate(0.1);
                AABB selection = new AABB(aabb.minX, this.getY() - 0.1, aabb.minZ, aabb.maxX, this.getY() + 3.5, aabb.maxZ);
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, selection)) {
                    this.damage(livingentity);
                }
            }
            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent((Entity)this, (byte)4);
                this.sentSpikeEvent = true;
            }
            if (--this.lifeTicks < 0) {
                this.discard();
            }
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (livingentity == null) {
                Hitentity.hurtOrSimulate(this.damageSources().magic(), this.getDamage());
            } else if (!livingentity.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)livingentity) && Hitentity.hurtOrSimulate(this.damageSources().mobProjectile((Entity)this, livingentity), this.getDamage())) {
                Hitentity.igniteForSeconds(5.0f);
            }
        }
    }

    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.isSilent()) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.BLAZE_SHOOT, this.getSoundSource(), 0.3f, 1.25f, false);
            }
        }
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0f;
    }
}

