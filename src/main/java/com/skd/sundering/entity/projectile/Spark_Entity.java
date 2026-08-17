/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.tags.EntityTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileDeflection
 *  net.minecraft.world.entity.projectile.ThrowableProjectile
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.sundering.entity.projectile;

import com.skd.sundering.client.particle.Options.CircleLightningParticleOptions;
import com.skd.sundering.entity.effect.Lightning_Area_Effect_Entity;
import com.skd.sundering.entity.effect.Lightning_Storm_Entity;
import com.skd.sundering.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Spark_Entity
extends ThrowableProjectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Spark_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_DAMAGE = SynchedEntityData.defineId(Spark_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_RADIUS = SynchedEntityData.defineId(Spark_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HP_DAMAGE = SynchedEntityData.defineId(Spark_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Spark_Entity(EntityType<? extends Spark_Entity> type, Level world) {
        super(type, world);
    }

    public Spark_Entity(Level worldIn, LivingEntity throwerIn) {
        super((EntityType)ModEntities.SPARK.get(), throwerIn, worldIn);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("Damage", this.getDamage());
        tag.putFloat("AreaDamage", this.getAreaDamage());
        tag.putFloat("HpDamage", this.getHpDamage());
        tag.putFloat("Area_Radius", this.getAreaRadius());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("Damage"));
        this.setHpDamage(tag.getFloat("HpDamage"));
        this.setAreaDamage(tag.getFloat("HpDamage"));
        this.setAreaRadius(tag.getFloat("Area_Radius"));
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(AREA_RADIUS, (Object)Float.valueOf(0.0f));
        p_326229_.define(HP_DAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(AREA_DAMAGE, (Object)Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    public float getAreaDamage() {
        return ((Float)this.entityData.get(AREA_DAMAGE)).floatValue();
    }

    public void setAreaDamage(float damage) {
        this.entityData.set(AREA_DAMAGE, (Object)Float.valueOf(damage));
    }

    public float getHpDamage() {
        return ((Float)this.entityData.get(HP_DAMAGE)).floatValue();
    }

    public void setHpDamage(float damage) {
        this.entityData.set(HP_DAMAGE, (Object)Float.valueOf(damage));
    }

    public float getAreaRadius() {
        return ((Float)this.entityData.get(AREA_RADIUS)).floatValue();
    }

    public void setAreaRadius(float radius) {
        this.entityData.set(AREA_RADIUS, (Object)Float.valueOf(radius));
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            Vec3 center = this.position().add(this.getDeltaMovement());
            this.level().addParticle((ParticleOptions)new CircleLightningParticleOptions(0.1f, 143, 241, 215), center.x, center.y, center.z, this.xo, this.yo, this.zo);
        }
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide()) {
            int standingOnY = Mth.floor((double)this.getY()) - 3;
            this.spawnArea(this.getX(), this.getZ(), standingOnY, this.getY() + 1.0);
            LivingEntity entity1 = (LivingEntity)this.getOwner();
            this.level().addFreshEntity((Entity)new Lightning_Storm_Entity(this.level(), this.getX(), this.getY(), this.getZ(), this.getYRot(), -9, this.getDamage(), this.getHpDamage(), entity1, 2.0f));
            this.discard();
        }
    }

    protected void spawnArea(double x, double z, double minY, double maxY) {
        BlockPos below;
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean foundGround = false;
        double spawnY = minY;
        do {
            VoxelShape shape;
            below = blockpos.below();
            BlockState groundState = this.level().getBlockState(below);
            if (!groundState.isFaceSturdy((BlockGetter)this.level(), below, Direction.UP)) continue;
            spawnY = !this.level().isEmptyBlock(blockpos) ? (!(shape = this.level().getBlockState(blockpos).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty() ? (double)blockpos.getY() + shape.max(Direction.Axis.Y) : (double)blockpos.getY()) : (double)blockpos.getY();
            foundGround = true;
            break;
        } while ((blockpos = below).getY() >= Mth.floor((double)minY) - 1);
        if (!foundGround) {
            spawnY = minY;
        }
        Lightning_Area_Effect_Entity areaeffectcloud = new Lightning_Area_Effect_Entity(this.level(), x, spawnY, z);
        areaeffectcloud.setRadius(this.getAreaRadius());
        LivingEntity entity1 = (LivingEntity)this.getOwner();
        areaeffectcloud.setOwner(entity1);
        areaeffectcloud.setRadiusOnUse(-1.0f);
        areaeffectcloud.setDamage(this.getAreaDamage());
        areaeffectcloud.setWaitTime(5);
        areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
        areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() * 2.0f / (float)areaeffectcloud.getDuration());
        this.level().addFreshEntity((Entity)areaeffectcloud);
    }

    protected double getDefaultGravity() {
        return 0.07;
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
}

