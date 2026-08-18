/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.AbstractHurtingProjectile
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.thesundering.entity.projectile;

import com.skd.thesundering.init.ModEntities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class Ender_Guardian_Bullet_Entity
extends AbstractHurtingProjectile {
    private double dirX;
    private double dirY;
    private double dirZ;
    private double startX;
    private double startY;
    private double startZ;
    private int timer;
    private boolean fired;

    public Ender_Guardian_Bullet_Entity(EntityType<? extends Ender_Guardian_Bullet_Entity> type, Level world) {
        super(type, world);
    }

    public Ender_Guardian_Bullet_Entity(Level worldIn, LivingEntity shooter, Vec3 accel) {
        super((EntityType)ModEntities.ENDER_GUARDIAN_BULLET.get(), shooter, accel, worldIn);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            if (this.fired) {
                Entity entity = result.getEntity();
                Entity Shooter = this.getOwner();
                LivingEntity livingentity = Shooter instanceof LivingEntity ? (LivingEntity)Shooter : null;
                DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, livingentity);
                boolean flag = entity.hurt(damagesource, 6.0f);
                if (flag) {
                    EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                    if (entity instanceof LivingEntity) {
                        ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
                    }
                }
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (this.fired) {
            ((ServerLevel)this.level()).sendParticles((ParticleOptions)ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 2, 0.2, 0.2, 0.2, 0.0);
            this.playSound(SoundEvents.SHULKER_BULLET_HIT, 1.0f, 1.0f);
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (this.fired) {
            this.discard();
        }
    }

    public void setUp(int delay, double dirX, double dirY, double dirZ, double startX, double startY, double startZ) {
        this.fired = false;
        this.timer = delay;
        this.dirX = dirX;
        this.dirY = dirY;
        this.dirZ = dirZ;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
    }

    public void setUpTowards(int delay, double startX, double startY, double startZ, double endX, double endY, double endZ, double speed) {
        Vec3 vec = new Vec3(endX - startX, endY - startY, endZ - startZ).normalize().scale(speed);
        this.setUp(delay, vec.x, vec.y, vec.z, startX, startY, startZ);
    }

    public void tick() {
        if (!this.level().isClientSide()) {
            --this.timer;
            if (this.timer <= 0) {
                if (this.fired) {
                    this.discard();
                } else {
                    this.fired = true;
                    this.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                    this.timer = 30;
                }
            }
            Vec3 DeltaMovement = this.getDeltaMovement();
            double d0 = this.getX();
            double d1 = this.getY();
            double d2 = this.getZ();
            if (this.fired) {
                if (DeltaMovement.lengthSqr() <= 16.0) {
                    this.setDeltaMovement(DeltaMovement.add(this.dirX * 0.1, this.dirY * 0.1, this.dirZ * 0.1));
                }
            } else {
                this.setDeltaMovement(new Vec3(this.startX - d0, this.startY - d1, this.startZ - d2).scale(1.0 / (double)this.timer));
            }
        }
        Entity shooter = this.getOwner();
        if (this.level().isClientSide() || (shooter == null || !shooter.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            HitResult HitResult2 = ProjectileUtil.getHitResultOnMoveVector((Entity)this, x$0 -> this.canHitEntity((Entity)x$0));
            if (HitResult2.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact((Projectile)this, (HitResult)HitResult2)) {
                this.onHit(HitResult2);
            }
            this.checkInsideBlocks();
            Vec3 Vec32 = this.getDeltaMovement();
            double d0 = this.getX() + Vec32.x;
            double d1 = this.getY() + Vec32.y;
            double d2 = this.getZ() + Vec32.z;
            ProjectileUtil.rotateTowardsMovement((Entity)this, (float)0.2f);
            this.level().addParticle((ParticleOptions)ParticleTypes.END_ROD, this.getX() - Vec32.x, this.getY() - Vec32.y + 0.15, this.getZ() - Vec32.z, 0.0, 0.0, 0.0);
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("DX", this.dirX);
        compound.putDouble("DY", this.dirY);
        compound.putDouble("DZ", this.dirZ);
        compound.putDouble("SX", this.startX);
        compound.putDouble("SY", this.startY);
        compound.putDouble("SZ", this.startZ);
        compound.putInt("Timer", this.timer);
        compound.putBoolean("Fired", this.fired);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.dirX = compound.getDouble("DX");
        this.dirY = compound.getDouble("DY");
        this.dirZ = compound.getDouble("DZ");
        this.startX = compound.getDouble("SX");
        this.startY = compound.getDouble("SY");
        this.startZ = compound.getDouble("SZ");
        this.timer = compound.getInt("Timer");
        this.fired = compound.getBoolean("Fired");
    }

    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    public boolean canBeCollidedWith() {
        return false;
    }
}

