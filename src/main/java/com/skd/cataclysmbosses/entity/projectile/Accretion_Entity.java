/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.EntityTypeTags
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileDeflection
 *  net.minecraft.world.entity.projectile.ThrowableProjectile
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Accretion_Entity
extends ThrowableProjectile {
    private static final EntityDataAccessor<Optional<BlockState>> BLOCK_STATE = SynchedEntityData.defineId(Accretion_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Accretion_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Accretion_Entity(EntityType<Accretion_Entity> type, Level world) {
        super(type, world);
    }

    public Accretion_Entity(EntityType<Accretion_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(BLOCK_STATE, Optional.empty());
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    public void setBlockState(@Nullable BlockState state) {
        this.entityData.set(BLOCK_STATE, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getBlockState() {
        return ((Optional)this.entityData.get(BLOCK_STATE)).orElse(null);
    }

    public boolean shouldRiderSit() {
        return false;
    }

    public boolean isInWater() {
        return false;
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag = false;
            if (entity1 instanceof LivingEntity) {
                if (entity != entity1 && !entity1.isAlliedTo(entity)) {
                    LivingEntity livingentity = (LivingEntity)entity1;
                    DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, livingentity);
                    flag = entity.hurt(damagesource, this.getDamage());
                    if (flag) {
                        BlockState blockstate;
                        if (entity.isAlive()) {
                            EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                        }
                        if ((blockstate = this.getBlockState()) != null) {
                            this.level().levelEvent(2001, new BlockPos((Vec3i)this.blockPosition()), Block.getId((BlockState)this.getBlockState()));
                        }
                        ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.05f, 0, 20);
                        this.discard();
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().inWall(), 5.0f);
            }
            if (flag && entity instanceof LivingEntity) {
                int i = 2;
                ((LivingEntity)entity).addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 20 * i, 1), this.getEffectSource());
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide()) {
            BlockState blockstate = this.getBlockState();
            if (blockstate != null && !this.isVehicle()) {
                this.level().levelEvent(2001, new BlockPos((Vec3i)this.blockPosition()), Block.getId((BlockState)this.getBlockState()));
            }
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.05f, 0, 20);
            this.discard();
        }
    }

    protected void onHit(HitResult result) {
        HitResult.Type hitresult$type = result.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            EntityHitResult entityhitresult = (EntityHitResult)result;
            Entity entity = entityhitresult.getEntity();
            if (entity.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE) && entity instanceof Projectile) {
                Projectile projectile = (Projectile)entity;
                projectile.deflect(ProjectileDeflection.AIM_DEFLECT, this.getOwner(), this.getOwner(), true);
            }
            this.onHitEntity(entityhitresult);
            this.level().gameEvent((Holder)GameEvent.PROJECTILE_LAND, result.getLocation(), GameEvent.Context.of((Entity)this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)result;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent((Holder)GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of((Entity)this, (BlockState)this.level().getBlockState(blockpos)));
        }
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        BlockState blockstate = this.getBlockState();
        if (blockstate != null) {
            compound.put("AccretionBlockState", (Tag)NbtUtils.writeBlockState((BlockState)blockstate));
        }
        compound.putFloat("Damage", this.getDamage());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        BlockState blockstate = null;
        if (compound.contains("AccretionBlockState", 10) && (blockstate = NbtUtils.readBlockState((HolderGetter)this.level().holderLookup(Registries.BLOCK), (CompoundTag)compound.getCompound("AccretionBlockState"))).isAir()) {
            blockstate = null;
        }
        this.setBlockState(blockstate);
        this.setDamage(compound.getFloat("Damage"));
    }

    public void tick() {
        super.tick();
        BlockState block = this.getBlockState();
        if (block != null && block.getRenderShape() != RenderShape.INVISIBLE) {
            Vec3 vec3 = this.getDeltaMovement();
            this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
        }
    }

    protected double getDefaultGravity() {
        return 0.03f;
    }
}

