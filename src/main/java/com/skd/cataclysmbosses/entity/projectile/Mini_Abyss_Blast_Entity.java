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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.client.tool.ControlledAnimation;
import com.skd.cataclysmbosses.entity.Pet.The_Baby_Leviathan_Entity;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Mini_Abyss_Blast_Entity
extends Entity {
    public static final double RADIUS = 15.0;
    public LivingEntity caster;
    public double endPosX;
    public double endPosY;
    public double endPosZ;
    public double collidePosX;
    public double collidePosY;
    public double collidePosZ;
    public double prevCollidePosX;
    public double prevCollidePosY;
    public double prevCollidePosZ;
    public float renderYaw;
    public float renderPitch;
    public ControlledAnimation appear = new ControlledAnimation(3);
    public boolean on = true;
    public Direction blockSide = null;
    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(Mini_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PITCH = SynchedEntityData.defineId(Mini_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(Mini_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Mini_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> BEAMDIRECTION = SynchedEntityData.defineId(Mini_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    public float prevYaw;
    public float prevPitch;
    @OnlyIn(value=Dist.CLIENT)
    private Vec3[] attractorPos;

    public Mini_Abyss_Blast_Entity(EntityType<? extends Mini_Abyss_Blast_Entity> type, Level world) {
        super(type, world);
        this.noCulling(true);
        if (world.isClientSide()) {
            this.attractorPos = new Vec3[]{new Vec3(0.0, 0.0, 0.0)};
        }
    }

    public Mini_Abyss_Blast_Entity(EntityType<? extends Mini_Abyss_Blast_Entity> type, Level world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration, float direction) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setPos(x, y, z);
        this.calculateEndPos();
        if (!world.isClientSide()) {
            this.setCasterID(caster.getId());
        }
    }

    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    public void tick() {
        super.tick();
        this.prevCollidePosX = this.collidePosX;
        this.prevCollidePosY = this.collidePosY;
        this.prevCollidePosZ = this.collidePosZ;
        this.prevYaw = this.renderYaw;
        this.prevPitch = this.renderPitch;
        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        if (this.tickCount == 1 && this.level().isClientSide()) {
            this.caster = (LivingEntity)this.level().getEntity(this.getCasterID());
        }
        if (!this.level().isClientSide() && this.caster instanceof The_Baby_Leviathan_Entity) {
            this.updateWithHarbinger();
        }
        if (this.caster != null) {
            this.renderYaw = (float)((double)(this.caster.yHeadRot + this.getBeamDirection()) * Math.PI / 180.0);
            this.renderPitch = (float)((double)(-this.caster.getXRot()) * Math.PI / 180.0);
        }
        if (!this.on && this.appear.getTimer() == 0) {
            this.discard();
        }
        if (this.on && this.tickCount > 20) {
            this.appear.increaseTimer();
        } else {
            this.appear.decreaseTimer();
        }
        if (this.caster != null && !this.caster.isAlive()) {
            this.discard();
        }
        if (this.tickCount > 20) {
            this.calculateEndPos();
            List<LivingEntity> hit = this.raytraceEntities((Level)this.level(), (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ)).entities;
            if (this.blockSide != null) {
                this.spawnExplosionParticles(3);
            }
            if (!this.level().isClientSide()) {
                for (LivingEntity target : hit) {
                    if (this.caster == null || this.caster.isAlliedTo((Entity)target) || target == this.caster) continue;
                    target.hurtOrSimulate(CMDamageTypes.causeDeathLaserDamage(this, this.caster), 5.0f);
                }
            }
        }
        if (this.tickCount - 20 > this.getDuration()) {
            this.on = false;
        }
    }

    private void spawnExplosionParticles(int amount) {
        for (int i = 0; i < amount; ++i) {
            float velocity = 1.0f;
            float yaw = (float)((double)(this.random.nextFloat() * 2.0f) * Math.PI);
            float motionY = this.random.nextFloat() * 0.08f;
            float motionX = 1.0f * Mth.cos((float)yaw);
            float motionZ = 1.0f * Mth.sin((float)yaw);
            this.level().addParticle((ParticleOptions)new LightningParticleOptions(102, 26, 204), this.collidePosX, this.collidePosY + 0.1, this.collidePosZ, (double)motionX, (double)motionY, (double)motionZ);
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(YAW, Float.valueOf(0.0f));
        p_326229_.define(PITCH, Float.valueOf(0.0f));
        p_326229_.define(DURATION, 0);
        p_326229_.define(CASTER, -1);
        p_326229_.define(BEAMDIRECTION, Float.valueOf(90.0f));
    }

    public float getYaw() {
        return ((Float)this.entityData.get(YAW)).floatValue();
    }

    public void setYaw(float yaw) {
        this.entityData.set(YAW, Float.valueOf(yaw));
    }

    public float getPitch() {
        return ((Float)this.entityData.get(PITCH)).floatValue();
    }

    public void setPitch(float pitch) {
        this.entityData.set(PITCH, Float.valueOf(pitch));
    }

    public int getDuration() {
        return (Integer)this.entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        this.entityData.set(DURATION, duration);
    }

    public float getBeamDirection() {
        return ((Float)this.entityData.get(BEAMDIRECTION)).floatValue();
    }

    public void setBeamDirection(float beamDirection) {
        this.entityData.set(BEAMDIRECTION, Float.valueOf(beamDirection));
    }

    public int getCasterID() {
        return (Integer)this.entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        this.entityData.set(CASTER, id);
    }

    protected void readAdditionalSaveData(ValueInput compound) {
        this.setYaw(compound.getFloatOr("Yaw", 0.0f));
        this.setPitch(compound.getFloatOr("Pitch", 0.0f));
        this.setDuration(compound.getIntOr("Duration", 0));
        this.setBeamDirection(compound.getFloatOr("BeamDirection", 0.0f));
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        compound.putFloat("Yaw", this.getYaw());
        compound.putFloat("Pitch", this.getPitch());
        compound.putInt("Duration", this.getDuration());
        compound.putFloat("BeamDirection", this.getBeamDirection());
    }

    private void calculateEndPos() {
        if (this.level().isClientSide()) {
            this.endPosX = this.getX() + 15.0 * Math.cos(this.renderYaw) * Math.cos(this.renderPitch);
            this.endPosZ = this.getZ() + 15.0 * Math.sin(this.renderYaw) * Math.cos(this.renderPitch);
            this.endPosY = this.getY() + 15.0 * Math.sin(this.renderPitch);
        } else {
            this.endPosX = this.getX() + 15.0 * Math.cos(this.getYaw()) * Math.cos(this.getPitch());
            this.endPosZ = this.getZ() + 15.0 * Math.sin(this.getYaw()) * Math.cos(this.getPitch());
            this.endPosY = this.getY() + 15.0 * Math.sin(this.getPitch());
        }
    }

    public LaserbeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to) {
        LaserbeamHitResult result = new LaserbeamHitResult();
        result.setBlockHit((HitResult)world.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this)));
        if (result.blockHit != null) {
            Vec3 hitVec = result.blockHit.getLocation();
            this.collidePosX = hitVec.x;
            this.collidePosY = hitVec.y;
            this.collidePosZ = hitVec.z;
            this.blockSide = result.blockHit.getDirection();
        } else {
            this.collidePosX = this.endPosX;
            this.collidePosY = this.endPosY;
            this.collidePosZ = this.endPosZ;
            this.blockSide = null;
        }
        List entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(this.getX(), this.collidePosX), Math.min(this.getY(), this.collidePosY), Math.min(this.getZ(), this.collidePosZ), Math.max(this.getX(), this.collidePosX), Math.max(this.getY(), this.collidePosY), Math.max(this.getZ(), this.collidePosZ)).inflate(2.0, 2.0, 2.0));
        for (LivingEntity entity : entities) {
            if (entity == this.caster) continue;
            float pad = entity.getPickRadius() + 0.15f;
            AABB aabb = entity.getBoundingBox().inflate((double)pad, (double)pad, (double)pad);
            Optional hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
                continue;
            }
            if (!hit.isPresent()) continue;
            result.addEntityHit(entity);
        }
        return result;
    }

    public void push(Entity entityIn) {
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }

    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 10.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }
        return p_36837_ < (d0 *= 64.0) * d0;
    }

    private void updateWithHarbinger() {
        this.setYaw((float)((double)(this.caster.yHeadRot + this.getBeamDirection()) * Math.PI / 180.0));
        this.setPitch((float)((double)(-this.caster.getXRot()) * Math.PI / 180.0));
        float f = -Mth.sin((float)(this.caster.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.caster.getXRot() * ((float)Math.PI / 180)));
        float f2 = Mth.cos((float)(this.caster.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.caster.getXRot() * ((float)Math.PI / 180)));
        this.setPos(this.caster.getX(), this.caster.getY() + 0.125, this.caster.getZ());
    }

    public static class LaserbeamHitResult {
        private BlockHitResult blockHit;
        private final List<LivingEntity> entities = new ArrayList<LivingEntity>();

        public BlockHitResult getBlockHit() {
            return this.blockHit;
        }

        public void setBlockHit(HitResult rayTraceResult) {
            if (rayTraceResult.getType() == HitResult.Type.BLOCK) {
                this.blockHit = (BlockHitResult)rayTraceResult;
            }
        }

        public void addEntityHit(LivingEntity entity) {
            this.entities.add(entity);
        }
    }
}

