/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Direction
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.client.particle.Options.StormParticleOptions;
import com.skd.cataclysmbosses.entity.projectile.Elemental_Spear_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Water_Spear_Entity
extends Elemental_Spear_Entity {
    private static final EntityDataAccessor<Integer> BOUNCES = SynchedEntityData.defineId(Water_Spear_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level, double accel) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        this.setOldPosAndRot();
        this.setState(1);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, accel);
    }

    public Water_Spear_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage, double accel) {
        this((EntityType<? extends Water_Spear_Entity>)((EntityType)ModEntities.WATER_SPEAR.get()), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_, accel);
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
    }

    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(BOUNCES, (Object)0);
    }

    public int getTotalBounces() {
        return (Integer)this.entityData.get(BOUNCES);
    }

    public void setTotalBounces(int bounces) {
        this.entityData.set(BOUNCES, (Object)bounces);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            Entity entity = p_37626_.getEntity();
            boolean flag = false;
            Entity entity2 = this.getOwner();
            if (entity2 instanceof LivingEntity) {
                DamageSource damagesource;
                LivingEntity livingentity = (LivingEntity)entity2;
                if (!entity.isAlliedTo((Entity)livingentity) && !livingentity.equals((Object)entity) && !livingentity.isAlliedTo(entity) && (flag = entity.hurt(damagesource = this.damageSources().mobProjectile((Entity)this, livingentity), this.getDamage())) && entity.isAlive()) {
                    EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), 5.0f);
            }
            if (flag && entity instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity)entity;
                MobEffectInstance effectinstance1 = livingentity1.getEffect(ModEffect.EFFECTWETNESS);
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    livingentity1.removeEffectNoUpdate(ModEffect.EFFECTWETNESS);
                } else {
                    --i;
                }
                i = Mth.clamp((int)i, (int)0, (int)4);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTWETNESS, 200, i, false, true, true);
                livingentity1.addEffect(effectinstance);
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.hurtMarked = true;
        BlockHitResult traceResult = result;
        BlockState blockstate = this.level().getBlockState(traceResult.getBlockPos());
        if (!blockstate.getCollisionShape((BlockGetter)this.level(), traceResult.getBlockPos()).isEmpty()) {
            Direction face = traceResult.getDirection();
            blockstate.onProjectileHit(this.level(), blockstate, traceResult, (Projectile)this);
            Vec3 motion = this.getDeltaMovement();
            double motionX = motion.x();
            double motionY = motion.y();
            double motionZ = motion.z();
            if (face == Direction.EAST) {
                motionX = -motionX;
            } else if (face == Direction.SOUTH) {
                motionZ = -motionZ;
            } else if (face == Direction.WEST) {
                motionX = -motionX;
            } else if (face == Direction.NORTH) {
                motionZ = -motionZ;
            } else if (face == Direction.UP) {
                motionY = -motionY;
            } else if (face == Direction.DOWN) {
                motionY = -motionY;
            }
            Vec3 motion2 = new Vec3(motionX, motionY, motionZ);
            this.assignDirectionalMovement(motion2, this.accelerationPower);
            if (this.getTotalBounces() <= 0) {
                if (!this.level().isClientSide()) {
                    this.discard();
                }
            } else {
                this.setTotalBounces(this.getTotalBounces() - 1);
            }
        }
    }

    @Override
    protected void SpawnParticle() {
        double dx = this.getX() + (double)(1.5f * (this.random.nextFloat() - 0.5f));
        double dy = this.getY() + (double)(1.5f * (this.random.nextFloat() - 0.5f));
        double dz = this.getZ() + (double)(1.5f * (this.random.nextFloat() - 0.5f));
        float r = (float)(89 + this.random.nextInt(35)) / 255.0f;
        float g = (float)(180 + this.random.nextInt(35)) / 255.0f;
        float b = (float)(180 + this.random.nextInt(35)) / 255.0f;
        this.level().addParticle((ParticleOptions)new StormParticleOptions(r, g, b, 0.1f, this.getBbHeight() / 2.0f, this.getId()), dx, dy, dz, 0.0, 0.0, 0.0);
    }

    @Override
    protected float getInertia() {
        return 0.95f;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
        compound.putInt("totalBounces", this.getTotalBounces());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }
        this.setTotalBounces(compound.getInt("totalBounces"));
    }
}

