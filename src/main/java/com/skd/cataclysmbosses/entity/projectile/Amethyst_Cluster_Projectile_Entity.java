/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ThrowableProjectile
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.init.ModParticle;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Amethyst_Cluster_Projectile_Entity
extends ThrowableProjectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Amethyst_Cluster_Projectile_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Amethyst_Cluster_Projectile_Entity(EntityType<Amethyst_Cluster_Projectile_Entity> type, Level world) {
        super(type, world);
    }

    public Amethyst_Cluster_Projectile_Entity(EntityType<Amethyst_Cluster_Projectile_Entity> type, Level world, LivingEntity thrower, float damage) {
        super(type, thrower, world);
        this.setDamage(damage);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        if (shooter instanceof LivingEntity) {
            if (entity != shooter && !shooter.isAlliedTo(entity)) {
                entity.hurtOrSimulate(this.damageSources().mobProjectile((Entity)this, (LivingEntity)shooter), this.getDamage());
            }
        } else {
            entity.hurtOrSimulate(this.damageSources().magic(), this.getDamage());
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent((Entity)this, (byte)3);
            this.playSound(SoundEvents.GLASS_BREAK, 1.1f, 0.8f);
            this.discard();
        }
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

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("damage", this.getDamage());
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setDamage(compound.getFloatOr("damage", 0.0f));
    }

    protected double getDefaultGravity() {
        return 0.03f;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 10; ++i) {
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, Blocks.AMETHYST_CLUSTER.defaultBlockState()), this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.2, this.random.nextGaussian() * 0.2, this.random.nextGaussian() * 0.2);
            }
            this.level().addParticle((ParticleOptions)ModParticle.AMETHYST_CRASH.get(), this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }
}

