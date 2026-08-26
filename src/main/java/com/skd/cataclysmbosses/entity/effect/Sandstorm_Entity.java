/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerEntity
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.client.particle.Options.StormParticleOptions;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Sandstorm_Entity
extends Entity {
    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Sandstorm_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Float> OFFSET = SynchedEntityData.defineId(Sandstorm_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Sandstorm_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    private LivingEntity caster;
    private UUID casterUuid;

    public Sandstorm_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Sandstorm_Entity(Level worldIn, double x, double y, double z, int lifespan, float offset, LivingEntity casterIn) {
        this((EntityType)ModEntities.SANDSTORM.get(), worldIn);
        this.setLifespan(lifespan);
        this.setPos(x, y, z);
        this.setState(1);
        this.setOffset(offset);
        this.setCaster(casterIn);
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entity) {
        return new ClientboundAddEntityPacket((Entity)this, entity);
    }

    public void tick() {
        super.tick();
        this.updateMotion();
        LivingEntity owner = this.getCaster();
        if (owner != null && !owner.isAlive()) {
            this.discard();
        }
        if (this.level().isClientSide()) {
            float ran = 0.04f;
            float r = 0.89f + this.random.nextFloat() * ran;
            float g = 0.85f + this.random.nextFloat() * ran;
            float b = 0.69f + this.random.nextFloat() * ran * 1.5f;
            this.level().addParticle((ParticleOptions)new StormParticleOptions(r, g, b, 2.75f + this.random.nextFloat() * 0.6f, 3.75f + this.random.nextFloat() * 0.6f, this.getId()), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            this.level().addParticle((ParticleOptions)new StormParticleOptions(r, g, b, 2.5f + this.random.nextFloat() * 0.45f, 3.0f + this.random.nextFloat() * 0.45f, this.getId()), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            this.level().addParticle((ParticleOptions)new StormParticleOptions(r, g, b, 2.25f + this.random.nextFloat() * 0.45f, 2.25f + this.random.nextFloat() * 0.45f, this.getId()), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            this.level().addParticle((ParticleOptions)new StormParticleOptions(r, g, b, 1.25f + this.random.nextFloat() * 0.45f, 1.25f + this.random.nextFloat() * 0.45f, this.getId()), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            if (this.getState() == 1 && this.getLifespan() < 295) {
                this.setState(0);
            }
            if (this.getState() == 0 && this.getLifespan() < 10) {
                this.setState(2);
            }
        }
        if (!this.isSilent() && this.level().isClientSide()) {
            Cataclysm.PROXY.playWorldSound((Object)this, (byte)2);
        }
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2, 0.0, 0.2))) {
            this.damage(entity);
        }
        this.setLifespan(this.getLifespan() - 1);
        if (this.getLifespan() <= 0) {
            Cataclysm.PROXY.clearSoundCacheFor(this);
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity && this.tickCount % 3 == 0) {
            boolean flag;
            if (livingentity == null) {
                boolean flag2 = Hitentity.hurtOrSimulate(this.damageSources().magic(), 7.0f);
                if (flag2) {
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                    Hitentity.addEffect(effectinstance);
                }
            } else if (!livingentity.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)livingentity) && (flag = Hitentity.hurtOrSimulate(this.damageSources().indirectMagic((Entity)this, (Entity)livingentity), 7.0f))) {
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                Hitentity.addEffect(effectinstance);
            }
        }
    }

    public int getLifespan() {
        return (Integer)this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }

    public float getOffset() {
        return ((Float)this.entityData.get(OFFSET)).floatValue();
    }

    public void setOffset(float i) {
        this.entityData.set(OFFSET, Float.valueOf(i));
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

    protected void updateMotion() {
        LivingEntity owner = this.getCaster();
        if (owner != null) {
            Vec3 orbit;
            float offset;
            float speed;
            float radius;
            Vec3 center;
            if (owner instanceof Ancient_Remnant_Entity) {
                center = owner.position().add(0.0, 0.0, 0.0);
                radius = 8.0f;
                speed = (float)this.tickCount * 0.04f;
                offset = this.getOffset();
                orbit = new Vec3(center.x + Math.cos(speed + offset) * (double)radius, center.y, center.z + Math.sin(speed + offset) * (double)radius);
                this.setPos(orbit);
            }
            if (owner instanceof Player) {
                center = owner.position().add(0.0, 0.0, 0.0);
                radius = 6.0f;
                speed = (float)this.tickCount * 0.04f;
                offset = this.getOffset();
                orbit = new Vec3(center.x + Math.cos(speed + offset) * (double)radius, center.y, center.z + Math.sin(speed + offset) * (double)radius);
                this.setPos(orbit);
            }
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(LIFESPAN, 300);
        p_326229_.define(OFFSET, Float.valueOf(0.0f));
        p_326229_.define(STATE, 0);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "spawn") {
            return this.SpawnAnimationState;
        }
        if (input == "despawn") {
            return this.DespawnAnimationState;
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
                    this.DespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return (Integer)this.entityData.get(STATE);
    }

    public void setState(int state) {
        this.entityData.set(STATE, state);
    }

    protected void readAdditionalSaveData(ValueInput compound) {
        this.setLifespan(compound.getIntOr("Lifespan", 0));
        if (compound.read("Owner", UUIDUtil.CODEC).isPresent()) {
            this.casterUuid = compound.read("Owner", UUIDUtil.CODEC).orElse(null);
        }
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        compound.putInt("Lifespan", this.getLifespan());
        if (this.casterUuid != null) {
            compound.store("Owner", UUIDUtil.CODEC, this.casterUuid);
        }
    }
}

