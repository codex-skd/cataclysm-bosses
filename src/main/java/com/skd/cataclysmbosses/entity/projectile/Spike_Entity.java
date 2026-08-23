/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ItemParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ThrowableItemProjectile
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Spike_Entity
extends ThrowableItemProjectile {
    public Spike_Entity(EntityType<? extends Spike_Entity> type, Level world) {
        super(type, world);
    }

    public Spike_Entity(Level worldIn, LivingEntity throwerIn) {
        super((EntityType)ModEntities.LIONFISH_SPIKE.get(), throwerIn, world);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    protected Item getDefaultItem() {
        return (Item)ModItems.LIONFISH_SPIKE.get();
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        float i = 4.0f;
        if (shooter instanceof LivingEntity) {
            if (entity != shooter && !shooter.isAlliedTo(entity) && entity.hurt(this.damageSources().mobProjectile((Entity)this, (LivingEntity)shooter), i) && entity instanceof LivingEntity) {
                ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0), (Entity)this);
            }
        } else {
            entity.hurt(this.damageSources().mobProjectile((Entity)this, null), i);
        }
    }

    public boolean isInWater() {
        return false;
    }

    public boolean isNoGravity() {
        return false;
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent((Entity)this, (byte)3);
            this.discard();
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle((ParticleOptions)new ItemParticleOption(ParticleTypes.ITEM, new ItemStack((ItemLike)ModItems.LIONFISH_SPIKE.get())), this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.2, this.random.nextGaussian() * 0.2, this.random.nextGaussian() * 0.2);
            }
        }
    }
}

