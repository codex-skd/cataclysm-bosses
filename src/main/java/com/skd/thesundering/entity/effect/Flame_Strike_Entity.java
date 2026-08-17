/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
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
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.Mth
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Explosion$BlockInteraction
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.PushReaction
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.entity.effect;

import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModParticle;
import com.skd.thesundering.util.CMDamageTypes;
import com.skd.thesundering.util.CustomExplosion.IgnisExplosion;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Flame_Strike_Entity
extends Entity {
    private static final EntityDataAccessor<Float> DATA_RADIUS = SynchedEntityData.defineId(Flame_Strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> DATA_WAITING = SynchedEntityData.defineId(Flame_Strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_SEE = SynchedEntityData.defineId(Flame_Strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SOUL = SynchedEntityData.defineId(Flame_Strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Flame_Strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Flame_Strike_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final float MAX_RADIUS = 32.0f;
    private int duration = 600;
    private int waitTime;
    private int warmupDelayTicks;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Flame_Strike_Entity(EntityType<? extends Flame_Strike_Entity> p_19704_, Level p_19705_) {
        super(p_19704_, p_19705_);
        this.noPhysics = true;
        this.setRadius(3.0f);
    }

    public Flame_Strike_Entity(Level level, double x, double y, double z, float p_i47276_8_, int duration, int wait, int delay, float radius, float damage, float Hpdamage, boolean soul, LivingEntity casterIn) {
        this((EntityType<? extends Flame_Strike_Entity>)((EntityType)ModEntities.FLAME_STRIKE.get()), level);
        this.setOwner(casterIn);
        this.setDuration(duration);
        this.waitTime = wait;
        this.warmupDelayTicks = delay;
        this.setRadius(radius);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.setSoul(soul);
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setPos(x, y, z);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DATA_RADIUS, (Object)Float.valueOf(0.5f));
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(HPDAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(DATA_WAITING, (Object)true);
        p_326229_.define(DATA_SEE, (Object)false);
        p_326229_.define(SOUL, (Object)false);
    }

    public void setRadius(float p_19713_) {
        if (!this.level().isClientSide()) {
            this.getEntityData().set(DATA_RADIUS, (Object)Float.valueOf(Mth.clamp((float)p_19713_, (float)0.0f, (float)32.0f)));
        }
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    public float getHpDamage() {
        return ((Float)this.entityData.get(HPDAMAGE)).floatValue();
    }

    public void setHpDamage(float damage) {
        this.entityData.set(HPDAMAGE, (Object)Float.valueOf(damage));
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
        this.getEntityData().set(DATA_WAITING, (Object)p_19731_);
    }

    public boolean isWaiting() {
        return (Boolean)this.getEntityData().get(DATA_WAITING);
    }

    protected void setSee(boolean p_19731_) {
        this.getEntityData().set(DATA_SEE, (Object)p_19731_);
    }

    public boolean isSee() {
        return (Boolean)this.getEntityData().get(DATA_SEE);
    }

    public void setSoul(boolean Soul) {
        this.getEntityData().set(SOUL, (Object)Soul);
    }

    public boolean isSoul() {
        return (Boolean)this.getEntityData().get(SOUL);
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int p_19735_) {
        this.duration = p_19735_;
    }

    public void tick() {
        super.tick();
        boolean flag = this.isWaiting();
        float f = this.getRadius();
        if (this.level().isClientSide()) {
            if (flag && this.random.nextBoolean()) {
                return;
            }
            SimpleParticleType particleoptions = this.isSoul() ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
            float f1 = flag ? 0.2f : f;
            double spread = Math.PI * 2;
            int arcLen = Mth.ceil((double)((double)this.getRadius() * spread));
            if (!flag) {
                if (this.tickCount % 2 == 0) {
                    for (int j = 0; j < arcLen; ++j) {
                        float f2 = this.random.nextFloat() * ((float)Math.PI * 2);
                        double d0 = this.getX() + (double)(Mth.cos((float)f2) * f1) * 0.9;
                        double d2 = this.getY();
                        double d4 = this.getZ() + (double)(Mth.sin((float)f2) * f1) * 0.9;
                        this.level().addParticle((ParticleOptions)particleoptions, d0, d2, d4, this.random.nextGaussian() * 0.07, 0.125 * (double)this.getRadius() + 0.4, this.random.nextGaussian() * 0.07);
                    }
                }
                if (this.random.nextInt(24) == 0) {
                    this.level().playLocalSound(this.getX() + 0.5, this.getY() + 0.5, this.getZ() + 0.5, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0f + this.random.nextFloat(), this.random.nextFloat() * 0.7f + 0.3f, false);
                }
            }
        } else {
            boolean flag1;
            if (this.tickCount >= this.waitTime + this.duration + this.warmupDelayTicks) {
                if (this.getRadius() > 0.0f) {
                    this.setRadius(this.getRadius() - 0.1f);
                } else {
                    if (!this.isSoul()) {
                        int explosionradius = this.owner instanceof Player ? 1 : 2;
                        IgnisExplosion explosion = new IgnisExplosion(this.level(), (Entity)this.owner, null, null, this.getX(), this.getY(), this.getZ(), explosionradius, false, Explosion.BlockInteraction.KEEP);
                        explosion.explode();
                        explosion.finalizeExplosion(0, 0.0);
                    }
                    this.level().broadcastEntityEvent((Entity)this, (byte)4);
                    this.discard();
                }
            }
            if (this.tickCount >= this.warmupDelayTicks) {
                this.setSee(true);
            }
            boolean bl = flag1 = this.tickCount < this.waitTime + this.warmupDelayTicks;
            if (flag != flag1) {
                this.setWaiting(flag1);
            }
            if (flag1) {
                return;
            }
        }
        if (!flag && this.tickCount % 5 == 0) {
            for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                this.damage(livingentity);
            }
        }
    }

    protected void damage(LivingEntity Hitentity) {
        LivingEntity caster = this.getOwner();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != caster && this.tickCount % 2 == 0) {
            boolean flag;
            if (caster == null) {
                boolean flag2 = Hitentity.hurt(this.damageSources().magic(), this.getDamage() + Hitentity.getMaxHealth() * 0.01f * this.getHpDamage());
                if (flag2) {
                    MobEffectInstance effectinstance1 = Hitentity.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        Hitentity.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                    Hitentity.addEffect(effectinstance);
                }
            } else if (!caster.isAlliedTo((Entity)Hitentity) && !Hitentity.isAlliedTo((Entity)caster) && (flag = Hitentity.hurt(CMDamageTypes.causeFlameStrikeDamage(this, (Entity)caster), this.getDamage() + Hitentity.getMaxHealth() * 0.01f * this.getHpDamage()))) {
                MobEffectInstance effectinstance1 = Hitentity.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    Hitentity.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                } else {
                    --i;
                }
                i = Mth.clamp((int)i, (int)0, (int)4);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                Hitentity.addEffect(effectinstance);
            }
        }
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

    protected void readAdditionalSaveData(CompoundTag p_19727_) {
        this.tickCount = p_19727_.getInt("Age");
        this.duration = p_19727_.getInt("Duration");
        this.waitTime = p_19727_.getInt("WaitTime");
        this.warmupDelayTicks = p_19727_.getInt("Delay");
        this.setRadius(p_19727_.getFloat("Radius"));
        if (p_19727_.hasUUID("Owner")) {
            this.ownerUUID = p_19727_.getUUID("Owner");
        }
        this.setSoul(p_19727_.getBoolean("is_soul"));
        this.setDamage(p_19727_.getFloat("damage"));
        this.setHpDamage(p_19727_.getFloat("Hpdamage"));
    }

    protected void addAdditionalSaveData(CompoundTag p_19737_) {
        p_19737_.putInt("Age", this.tickCount);
        p_19737_.putInt("Duration", this.duration);
        p_19737_.putInt("WaitTime", this.waitTime);
        p_19737_.putInt("Delay", this.warmupDelayTicks);
        p_19737_.putFloat("Radius", this.getRadius());
        if (this.ownerUUID != null) {
            p_19737_.putUUID("Owner", this.ownerUUID);
        }
        p_19737_.putBoolean("is_soul", this.isSoul());
        p_19737_.putFloat("damage", this.getDamage());
        p_19737_.putFloat("Hpdamage", this.getHpDamage());
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_19729_) {
        if (DATA_RADIUS.equals(p_19729_)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(p_19729_);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.level().addParticle((ParticleOptions)ModParticle.FLARE_EXPLODE.get(), this.getX(), this.getY() + (double)0.05f, this.getZ(), 0.1, 0.0, 0.0);
            for (int i = 0; i < 5; ++i) {
                double particleX = this.getX() + (double)((this.random.nextFloat() - 0.5f) * 4.0f);
                double particleY = this.getY() + (double)this.random.nextFloat();
                double particleZ = this.getZ() + (double)((this.random.nextFloat() - 0.5f) * 4.0f);
                this.level().addParticle((ParticleOptions)ModParticle.IGNIS_EXPLODE.get(), particleX, particleY, particleZ, 1.4, 0.0, 0.0);
            }
        }
    }

    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entity) {
        return new ClientboundAddEntityPacket((Entity)this, entity);
    }

    public EntityDimensions getDimensions(Pose p_19721_) {
        return EntityDimensions.scalable((float)(this.getRadius() * 1.8f), (float)(this.getRadius() * 3.0f));
    }
}

