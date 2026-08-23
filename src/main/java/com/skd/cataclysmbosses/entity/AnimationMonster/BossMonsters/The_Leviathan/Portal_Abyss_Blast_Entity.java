/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.client.tool.ControlledAnimation;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class Portal_Abyss_Blast_Entity
extends Entity {
    public static final double RADIUS = 50.0;
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
    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PITCH = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> BEAMDIRECTION = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Portal_Abyss_Blast_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    public float prevYaw;
    public float prevPitch;

    public Portal_Abyss_Blast_Entity(EntityType<? extends Portal_Abyss_Blast_Entity> type, Level world) {
        super(type, world);
        this.noCulling = true;
    }

    public Portal_Abyss_Blast_Entity(EntityType<? extends Portal_Abyss_Blast_Entity> type, Level world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration, float direction, float damage, float Hpdamage) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setPos(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.calculateEndPos();
        if (!world.isClientSide()) {
            this.setCasterID(caster.getId());
        }
    }

    public Portal_Abyss_Blast_Entity(EntityType<? extends Portal_Abyss_Blast_Entity> type, Level world, double x, double y, double z, float yaw, float pitch, int duration, float direction, float damage, float Hpdamage) {
        this(type, world);
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setPos(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.calculateEndPos();
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
        this.renderYaw = this.getYaw();
        this.renderPitch = this.getPitch();
        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        if (this.tickCount == 1 && this.level().isClientSide()) {
            this.caster = (LivingEntity)this.level().getEntity(this.getCasterID());
        }
        if (!this.on && this.appear.getTimer() == 0) {
            this.discard();
        }
        if (this.on && this.tickCount > 20) {
            this.appear.increaseTimer();
        } else {
            this.appear.decreaseTimer();
        }
        if (this.tickCount == 20) {
            this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.PORTAL_ABYSS_BLAST.get(), SoundSource.HOSTILE, 0.5f, 1.0f);
        }
        if (this.caster != null && !this.caster.isAlive()) {
            this.discard();
        }
        if (this.tickCount > 20) {
            this.calculateEndPos();
            List<LivingEntity> hit = this.raytraceEntities((Level)this.level(), (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ)).entities;
            if (this.blockSide != null) {
                this.spawnExplosionParticles(3);
                if (!this.level().isClientSide()) {
                    for (BlockPos pos : BlockPos.betweenClosed((int)Mth.floor((double)(this.collidePosX - 0.5)), (int)Mth.floor((double)(this.collidePosY - 0.5)), (int)Mth.floor((double)(this.collidePosZ - 0.5)), (int)Mth.floor((double)(this.collidePosX + 0.5)), (int)Mth.floor((double)(this.collidePosY + 0.5)), (int)Mth.floor((double)(this.collidePosZ + 0.5)))) {
                        BlockState block = this.level().getBlockState(pos);
                        if (block.isAir() || block.is(ModTag.LEVIATHAN_IMMUNE) || !EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) continue;
                        this.level().destroyBlock(pos, false);
                    }
                }
            }
            if (!this.level().isClientSide()) {
                for (LivingEntity target : hit) {
                    boolean flag;
                    if (this.caster == null || this.caster.isAlliedTo((Entity)target) || target == this.caster || !(flag = target.hurt(CMDamageTypes.causeDeathLaserDamage(this, this.caster), (float)((double)this.getDamage() + Math.min((double)this.getDamage(), (double)(target.getMaxHealth() * this.getHpDamage()) * 0.01))))) continue;
                    MobEffectInstance effectinstance1 = target.getEffect(ModEffect.EFFECTABYSSAL_BURN);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        target.removeEffectNoUpdate(ModEffect.EFFECTABYSSAL_BURN);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)3);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTABYSSAL_BURN, 160, i, false, true, true);
                    target.addEffect(effectinstance);
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
        p_326229_.define(YAW, (Object)Float.valueOf(0.0f));
        p_326229_.define(PITCH, (Object)Float.valueOf(0.0f));
        p_326229_.define(DURATION, (Object)0);
        p_326229_.define(CASTER, (Object)-1);
        p_326229_.define(BEAMDIRECTION, (Object)Float.valueOf(90.0f));
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(HPDAMAGE, (Object)Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    public float getHpDamage() {
        return ((Float)this.entityData.get(HPDAMAGE)).floatValue();
    }

    public void setHpDamage(float damage) {
        this.entityData.set(HPDAMAGE, (Object)Float.valueOf(damage));
    }

    public float getYaw() {
        return ((Float)this.entityData.get(YAW)).floatValue();
    }

    public void setYaw(float yaw) {
        this.entityData.set(YAW, (Object)Float.valueOf(yaw));
    }

    public float getPitch() {
        return ((Float)this.entityData.get(PITCH)).floatValue();
    }

    public void setPitch(float pitch) {
        this.entityData.set(PITCH, (Object)Float.valueOf(pitch));
    }

    public int getDuration() {
        return (Integer)this.entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        this.entityData.set(DURATION, (Object)duration);
    }

    public float getBeamDirection() {
        return ((Float)this.entityData.get(BEAMDIRECTION)).floatValue();
    }

    public void setBeamDirection(float beamDirection) {
        this.entityData.set(BEAMDIRECTION, (Object)Float.valueOf(beamDirection));
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setYaw(compound.getFloat("Yaw"));
        this.setPitch(compound.getFloat("Pitch"));
        this.setDuration(compound.getInt("Duration"));
        this.setBeamDirection(compound.getFloat("BeamDirection"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("Yaw", this.getYaw());
        compound.putFloat("Pitch", this.getPitch());
        compound.putInt("Duration", this.getDuration());
        compound.putFloat("BeamDirection", this.getBeamDirection());
    }

    public int getCasterID() {
        return (Integer)this.entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        this.entityData.set(CASTER, (Object)id);
    }

    private void calculateEndPos() {
        if (this.level().isClientSide()) {
            this.endPosX = this.getX() + 50.0 * Math.cos(this.renderYaw) * Math.cos(this.renderPitch);
            this.endPosZ = this.getZ() + 50.0 * Math.sin(this.renderYaw) * Math.cos(this.renderPitch);
            this.endPosY = this.getY() + 50.0 * Math.sin(this.renderPitch);
        } else {
            this.endPosX = this.getX() + 50.0 * Math.cos(this.getYaw()) * Math.cos(this.getPitch());
            this.endPosZ = this.getZ() + 50.0 * Math.sin(this.getYaw()) * Math.cos(this.getPitch());
            this.endPosY = this.getY() + 50.0 * Math.sin(this.getPitch());
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
        List entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(this.getX(), this.collidePosX), Math.min(this.getY(), this.collidePosY), Math.min(this.getZ(), this.collidePosZ), Math.max(this.getX(), this.collidePosX), Math.max(this.getY(), this.collidePosY), Math.max(this.getZ(), this.collidePosZ)).inflate(1.0, 1.0, 1.0));
        for (LivingEntity entity : entities) {
            if (entity == this.caster) continue;
            float pad = entity.getPickRadius() + 1.3f;
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

    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 10.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }
        return p_36837_ < (d0 *= 64.0) * d0;
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

