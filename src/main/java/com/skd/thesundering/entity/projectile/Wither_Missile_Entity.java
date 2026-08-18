/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.thesundering.entity.projectile;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.skd.thesundering.init.ModEntities;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class Wither_Missile_Entity
extends Projectile {
    public double accelerationPower = 0.1;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Wither_Missile_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Wither_Missile_Entity(EntityType<? extends Wither_Missile_Entity> type, Level level) {
        super(type, level);
    }

    public Wither_Missile_Entity(EntityType<? extends Wither_Missile_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);
    }

    public Wither_Missile_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage) {
        this((EntityType<? extends Wither_Missile_Entity>)((EntityType)ModEntities.WITHER_MISSILE.get()), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_);
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
        this.setRot(p_36827_.getYRot(), p_36827_.getXRot());
    }

    public Wither_Missile_Entity(EntityType<? extends Wither_Missile_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);
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

    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }
        return p_36837_ < (d0 *= 64.0) * d0;
    }

    protected ClipContext.Block getClipType() {
        return ClipContext.Block.COLLIDER;
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (this.level().isClientSide() || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector((Entity)this, this::canHitEntity, (ClipContext.Block)this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact((Projectile)this, (HitResult)hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }
            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement((Entity)this, (float)0.2f);
            float f = this.getInertia();
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    float f1 = 0.25f;
                    this.level().addParticle((ParticleOptions)ParticleTypes.BUBBLE, d0 - vec3.x * 0.25, d1 - vec3.y * 0.25, d2 - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
                }
                f = 0.8f;
            } else {
                this.level().addParticle((ParticleOptions)ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y + 0.35, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            }
            this.level().addParticle((ParticleOptions)ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y + 0.35, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            this.setDeltaMovement(vec3.add(vec3.normalize().scale(this.accelerationPower)).scale((double)f));
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            boolean flag;
            ServerLevel serverlevel = (ServerLevel)level;
            Entity entity = p_37626_.getEntity();
            Entity entity2 = this.getOwner();
            if (entity2 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity2;
                DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, livingentity);
                flag = entity.hurt(damagesource, this.getDamage());
                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                    } else {
                        livingentity.heal(5.0f);
                        if (livingentity instanceof The_Harbinger_Entity) {
                            livingentity.heal((float)CMCommonConfig.Harbinger.LifeSteal);
                        } else {
                            livingentity.heal(5.0f);
                        }
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), 5.0f);
            }
            if (flag && entity instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity)entity;
                int i = 0;
                if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    i = 10;
                } else if (this.level().getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }
                if (i > 0) {
                    livingentity1.addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * i, 1), this.getEffectSource());
                }
            }
        }
    }

    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide()) {
            this.level().explode((Entity)this, this.getX(), this.getY(), this.getZ(), 1.0f, false, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }

    protected float getInertia() {
        return 1.0f;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0f;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0f;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Vec3 vec3 = new Vec3(packet.getXa(), packet.getYa(), packet.getZa());
        this.setDeltaMovement(vec3);
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
    }

    private void assignDirectionalMovement(Vec3 movement, double accelerationPower) {
        this.setDeltaMovement(movement.normalize().scale(accelerationPower));
    }

    protected void onDeflection(@Nullable Entity entity, boolean deflectedByPlayer) {
        this.accelerationPower = deflectedByPlayer ? 0.1 : (this.accelerationPower *= 0.5);
    }
}

