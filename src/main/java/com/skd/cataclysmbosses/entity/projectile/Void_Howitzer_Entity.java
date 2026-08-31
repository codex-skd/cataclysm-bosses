/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ThrowableProjectile
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.projectile.Void_Rune_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Void_Howitzer_Entity
extends ThrowableProjectile {
    public Void_Howitzer_Entity(EntityType<Void_Howitzer_Entity> type, Level world) {
        super(type, world);
    }

    public Void_Howitzer_Entity(EntityType<Void_Howitzer_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower.getX(), thrower.getEyeY() - 0.10000000149011612D, thrower.getZ(), world);
        this.setOwner(thrower);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            Entity entity = p_37626_.getEntity();
            Entity entity2 = this.getOwner();
            if (entity2 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity2;
                DamageSource damagesource = this.damageSources().indirectMagic((Entity)this, (Entity)livingentity);
                boolean flag = entity.hurtOrSimulate(damagesource, 8.0f);
                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                    } else {
                        livingentity.heal(5.0f);
                    }
                }
            } else {
                entity.hurtOrSimulate(this.damageSources().magic(), 5.0f);
            }
        }
    }

    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide()) {
            float f5;
            int k;
            int standingOnY = Mth.floor((double)this.getY()) - 3;
            this.level().explode((Entity)this, this.getX(), this.getY(), this.getZ(), 3.0f, false, Level.ExplosionInteraction.NONE);
            for (k = 0; k < 6; ++k) {
                float f2 = (float)k * (float)Math.PI * 2.0f / 6.0f + 1.2566371f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f2) * 2.5, this.getZ() + (double)Mth.sin((float)f2) * 2.5, standingOnY, this.getY() + 1.0, f2, 0);
            }
            for (k = 0; k < 11; ++k) {
                float f3 = (float)k * (float)Math.PI * 2.0f / 11.0f + 0.62831855f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f3) * 3.5, this.getZ() + (double)Mth.sin((float)f3) * 3.5, standingOnY, this.getY() + 1.0, f3, 2);
            }
            for (k = 0; k < 14; ++k) {
                float f4 = (float)k * (float)Math.PI * 2.0f / 14.0f + 0.31415927f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f4) * 4.5, this.getZ() + (double)Mth.sin((float)f4) * 4.5, standingOnY, this.getY() + 1.0, f4, 4);
            }
            for (k = 0; k < 19; ++k) {
                f5 = (float)k * (float)Math.PI * 2.0f / 19.0f + 0.25132743f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f5) * 5.5, this.getZ() + (double)Mth.sin((float)f5) * 5.5, standingOnY, this.getY() + 1.0, f5, 6);
            }
            for (k = 0; k < 26; ++k) {
                f5 = (float)k * (float)Math.PI * 2.0f / 26.0f + 0.17951958f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f5) * 6.5, this.getZ() + (double)Mth.sin((float)f5) * 6.5, standingOnY, this.getY() + 1.0, f5, 8);
            }
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 40.0f, 0.3f, 0, 20);
            this.discard();
        }
    }

    protected void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (!blockstate.isFaceSturdy((BlockGetter)this.level(), blockpos1, Direction.UP)) continue;
            if (!this.level().isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = this.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)minY) - 1);
        if (flag) {
            LivingEntity entity1 = (LivingEntity)this.getOwner();
            this.level().addFreshEntity((Entity)new Void_Rune_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, 7.0f, entity1));
        }
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            Vec3 vec3 = this.getDeltaMovement();
            this.level().addParticle((ParticleOptions)ParticleTypes.REVERSE_PORTAL, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            this.level().addParticle((ParticleOptions)ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
        }
    }

    protected double getDefaultGravity() {
        return 0.03f;
    }
}

