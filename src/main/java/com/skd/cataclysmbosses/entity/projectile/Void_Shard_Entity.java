/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ItemParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ThrowableItemProjectile
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Void_Shard_Entity
extends ThrowableItemProjectile {
    private BlockState lastState;
    private Entity ignoreEntity = null;

    public Void_Shard_Entity(EntityType<? extends Void_Shard_Entity> type, Level world) {
        super(type, world);
    }

    public Void_Shard_Entity(EntityType type, Level worldIn, LivingEntity throwerIn) {
        super(type, throwerIn, worldIn, new net.minecraft.world.item.ItemStack((ItemLike)ModItems.VOID_SHARD.get()));
    }

    public Void_Shard_Entity(Level worldIn, LivingEntity throwerIn, double x, double y, double z, Vec3 movement, @Nullable Entity ignore) {
        super((EntityType)ModEntities.VOID_SHARD.get(), x, y, z, worldIn, new net.minecraft.world.item.ItemStack((ItemLike)ModItems.VOID_SHARD.get()));
        this.setOwner((Entity)throwerIn);
        this.setDeltaMovement(movement);
        this.ignoreEntity = ignore;
    }

    public void addAdditionalSaveData(ValueOutput tag) {
        super.addAdditionalSaveData(tag);
        if (this.lastState != null) {
            tag.store("inBlockState", net.minecraft.nbt.CompoundTag.CODEC, NbtUtils.writeBlockState((BlockState)this.lastState));
        }
    }

    public void readAdditionalSaveData(ValueInput tag) {
        super.readAdditionalSaveData(tag);
        if (tag.read("inBlockState", net.minecraft.nbt.CompoundTag.CODEC).isPresent()) {
            this.lastState = NbtUtils.readBlockState(this.level().holderLookup(net.minecraft.core.registries.Registries.BLOCK), tag.read("inBlockState", net.minecraft.nbt.CompoundTag.CODEC).orElseThrow());
        }
    }

    protected Item getDefaultItem() {
        return (Item)ModItems.VOID_SHARD.get();
    }

    protected void onHitBlock(BlockHitResult hit) {
        this.lastState = this.level().getBlockState(hit.getBlockPos());
        super.onHitBlock(hit);
        Vec3 Vec32 = hit.getLocation().subtract(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(Vec32);
        Vec3 Vec31 = Vec32.normalize().scale(this.getGravity());
        this.setPosRaw(this.getX() - Vec31.x, this.getY() - Vec31.y, this.getZ() - Vec31.z);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        float i = 1.5f;
        if (shooter == null) {
            entity.hurtOrSimulate(this.damageSources().magic(), i);
            entity.invulnerableTime = 0;
        } else if (entity != shooter && !shooter.isAlliedTo(entity)) {
            entity.hurtOrSimulate(this.damageSources().indirectMagic((Entity)this, this.getOwner()), i);
            entity.invulnerableTime = 0;
        }
    }

    public void shootFromRotation(Entity p_234612_1_, float p_234612_2_, float p_234612_3_, float p_234612_4_, float p_234612_5_, float p_234612_6_) {
        float f = (float)(-Math.sin(p_234612_3_ * ((float)Math.PI / 180)) * Math.cos(p_234612_2_ * ((float)Math.PI / 180)));
        float f1 = (float)(-Math.sin((p_234612_2_ + p_234612_4_) * ((float)Math.PI / 180)));
        float f2 = (float)(Math.cos(p_234612_3_ * ((float)Math.PI / 180)) * Math.cos(p_234612_2_ * ((float)Math.PI / 180)));
        this.shoot(f, f1, f2, p_234612_5_, p_234612_6_);
        Vec3 Vec32 = p_234612_1_.getDeltaMovement();
        this.setDeltaMovement(this.getDeltaMovement().add(Vec32.x, p_234612_1_.onGround() ? 0.0 : Vec32.y, Vec32.z));
    }

    protected boolean canHitEntity(Entity entity) {
        if (entity == this.ignoreEntity) {
            return false;
        }
        return super.canHitEntity(entity);
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
                this.level().addParticle((ParticleOptions)new ItemParticleOption(ParticleTypes.ITEM, (Item)ModItems.VOID_SHARD.get()), this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.1, this.random.nextGaussian() * 0.1, this.random.nextGaussian() * 0.1);
            }
        }
    }
}

