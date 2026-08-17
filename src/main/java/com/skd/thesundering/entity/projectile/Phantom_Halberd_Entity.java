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
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.entity.projectile;

import com.skd.thesundering.client.particle.Options.Cursed_MarkParticleOption;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModParticle;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.util.CMDamageTypes;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Phantom_Halberd_Entity
extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Phantom_Halberd_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Phantom_Halberd_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    public AnimationState OneAnimationState = new AnimationState();
    public AnimationState TwospawnAnimationState = new AnimationState();
    public AnimationState ThreespawnAnimationState = new AnimationState();
    public AnimationState FourspawnAnimationState = new AnimationState();

    public Phantom_Halberd_Entity(EntityType<? extends Phantom_Halberd_Entity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public Phantom_Halberd_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn, float damage) {
        this((EntityType<? extends Phantom_Halberd_Entity>)((EntityType)ModEntities.PHANTOM_HALBERD.get()), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setDamage(damage);
        this.setPos(x, y, z);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(STATE, (Object)0);
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
    }

    public AnimationState getAnimationState(String input) {
        if (input == "one") {
            return this.OneAnimationState;
        }
        if (input == "two") {
            return this.TwospawnAnimationState;
        }
        if (input == "three") {
            return this.ThreespawnAnimationState;
        }
        if (input == "four") {
            return this.FourspawnAnimationState;
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
                    this.OneAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.TwospawnAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.ThreespawnAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.FourspawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.OneAnimationState.stop();
        this.TwospawnAnimationState.stop();
        this.ThreespawnAnimationState.stop();
        this.FourspawnAnimationState.stop();
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
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            if (this.clientSideAttackStarted) {
                double d2;
                double d1;
                double d0;
                ++this.lifeTicks;
                if (this.lifeTicks == 55) {
                    d0 = (double)(2.0f * this.random.nextFloat() - 1.0f) * 0.4;
                    d1 = (double)(2.0f * this.random.nextFloat() - 1.0f) * 0.4;
                    d2 = this.getX() + d0;
                    double d3 = this.getY() + (double)this.random.nextFloat() * 2.0;
                    double d4 = this.getZ() + d1;
                    this.level().addParticle((ParticleOptions)ModParticle.PHANTOM_EMITTER.get(), d2, d3, d4, 0.0, 0.25 * this.random.nextDouble(), 0.0);
                }
                if (this.lifeTicks == 4) {
                    d0 = this.getX();
                    d1 = this.getY() + 0.1;
                    d2 = this.getZ();
                    this.level().addParticle((ParticleOptions)new Cursed_MarkParticleOption(0.7f + this.random.nextFloat() * 0.3f), d0, d1, d2, 0.0, 0.0, 0.0);
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10 && this.getState() == 0) {
                this.setState(1 + this.random.nextInt(4));
            }
            if (this.warmupDelayTicks < -12 && this.warmupDelayTicks > -34) {
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                    this.damage(livingentity);
                }
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

    protected void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity && this.tickCount % 5 == 0) {
            if (livingentity == null) {
                Hitentity.hurt(this.damageSources().magic(), this.getDamage());
            } else if (!livingentity.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)livingentity)) {
                Hitentity.hurt(CMDamageTypes.causeMaledictioMagicaeDamage(this, (Entity)livingentity), this.getDamage());
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.isSilent()) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.PHANTOM_SPEAR.get(), this.getSoundSource(), 0.3f, this.random.nextFloat() * 0.2f + 0.85f, false);
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

