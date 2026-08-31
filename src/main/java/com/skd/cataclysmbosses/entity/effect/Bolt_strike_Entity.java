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
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModSounds;
import java.util.List;
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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Bolt_strike_Entity
extends Entity {
    private int warmupDelayTicks = 34;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Bolt_strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Bolt_strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> R = SynchedEntityData.defineId(Bolt_strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> G = SynchedEntityData.defineId(Bolt_strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> B = SynchedEntityData.defineId(Bolt_strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Bolt_strike_Entity(EntityType<? extends Bolt_strike_Entity> entityType, Level level) {
        super(entityType, level);
    }

    public Bolt_strike_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, float damage, LivingEntity casterIn) {
        this((EntityType<? extends Bolt_strike_Entity>)((EntityType)ModEntities.BOLT_STRIKE.get()), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setPos(x, y, z);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, Float.valueOf(0.0f));
        p_326229_.define(HPDAMAGE, Float.valueOf(0.0f));
        p_326229_.define(R, 0);
        p_326229_.define(G, 0);
        p_326229_.define(B, 0);
    }

    public int getR() {
        return (Integer)this.entityData.get(R);
    }

    public void setR(int r) {
        this.entityData.set(R, r);
    }

    public int getG() {
        return (Integer)this.entityData.get(G);
    }

    public void setG(int g) {
        this.entityData.set(G, g);
    }

    public int getB() {
        return (Integer)this.entityData.get(B);
    }

    public void setB(int b) {
        this.entityData.set(B, b);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.owner = p_190549_1_;
        this.ownerUUID = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        Entity entity;
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.ownerUUID)) instanceof LivingEntity) {
            this.owner = (LivingEntity)entity;
        }
        return this.owner;
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, Float.valueOf(damage));
    }

    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = 64.0 * Bolt_strike_Entity.getViewScale();
        return distance < d0 * d0;
    }

    public Vec3 getAnglePosition(float p_20347_, double height, double Maxradius, double Minradius) {
        double angle = (double)(this.random.nextFloat() * 2.0f) * Math.PI;
        double radius = Minradius + this.random.nextDouble() * (Maxradius - Minradius);
        double randomX = radius * Math.cos(angle);
        double randomZ = radius * Math.sin(angle);
        return this.getPosition(p_20347_).add(randomX, height, randomZ);
    }

    public float getAnimationProgress(float partialTicks) {
        if (!this.clientSideAttackStarted) {
            return 0.0f;
        }
        int i = this.lifeTicks;
        if (i >= 12 && i < 18) {
            return 0.3f;
        }
        if (i >= 18) {
            return Math.max(0.3f - ((float)(i - 18) + partialTicks) / 20.0f, 0.0f);
        }
        return 0.0f;
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
                if (this.lifeTicks < 24 && this.lifeTicks > 12) {
                    this.smolder(6);
                }
                if (this.lifeTicks == 12 && !this.isSilent()) {
                    this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.EMP_ACTIVATED.get(), this.getSoundSource(), 1.0f, this.random.nextFloat() * 0.2f + 0.85f, false);
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -12) {
                this.damageEntityLivingBaseNearby(1.0);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.1f, 0, 30);
            }
            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent((Entity)this, (byte)4);
                this.sentSpikeEvent = true;
            }
            if (++this.lifeTicks > 22) {
                this.discard();
            }
        }
    }

    public void damageEntityLivingBaseNearby(double radius) {
        AABB region = new AABB(this.getX() - radius, this.getY() - 0.5, this.getZ() - radius, this.getX() + radius, (double)(this.level().getMaxY() + 1 + 20), this.getZ() + radius);
        List<LivingEntity> entities = this.level().getEntitiesOfClass(LivingEntity.class, region);
        for (LivingEntity entity : entities) {
            this.damage(entity);
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (livingentity == null) {
                Hitentity.hurtOrSimulate(this.damageSources().magic(), this.getDamage());
            } else if (!livingentity.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)livingentity)) {
                Hitentity.hurtOrSimulate(this.damageSources().indirectMagic((Entity)this, (Entity)livingentity), this.getDamage());
            }
        }
    }

    public void handleEntityEvent(byte p_36935_) {
        super.handleEntityEvent(p_36935_);
        if (p_36935_ == 4) {
            this.clientSideAttackStarted = true;
        }
    }

    private void smolder(int amount) {
        for (int i = 0; i < amount; ++i) {
            float velocity = 1.5f;
            float yaw = (float)((double)(this.random.nextFloat() * 2.0f) * Math.PI);
            float r = this.random.nextFloat() * 0.7f;
            float x = r * Mth.cos((float)yaw);
            float z = r * Mth.sin((float)yaw);
            float motionY = this.random.nextFloat() * 0.8f;
            float motionX = 1.5f * Mth.cos((float)yaw);
            float motionZ = 1.5f * Mth.sin((float)yaw);
            this.level().addParticle((ParticleOptions)new LightningParticleOptions(this.getR(), this.getG(), this.getB()), this.getX() + (double)x, this.getY() + 0.1, this.getZ() + (double)z, (double)motionX, (double)motionY, (double)motionZ);
        }
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        if (this.ownerUUID != null) {
            compound.store("Owner", UUIDUtil.CODEC, this.ownerUUID);
        }
        compound.putFloat("damage", this.getDamage());
        compound.putInt("r", this.getR());
        compound.putInt("g", this.getG());
        compound.putInt("b", this.getB());
    }

    protected void readAdditionalSaveData(ValueInput compound) {
        if (compound.read("Owner", UUIDUtil.CODEC).isPresent()) {
            this.ownerUUID = compound.read("Owner", UUIDUtil.CODEC).orElse(null);
        }
        this.setDamage(compound.getFloatOr("damage", 0.0f));
        this.setR(compound.getIntOr("r", 0));
        this.setG(compound.getIntOr("g", 0));
        this.setB(compound.getIntOr("b", 0));
    }

    @Override
    public boolean hurtServer(net.minecraft.server.level.ServerLevel level, net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }
}

