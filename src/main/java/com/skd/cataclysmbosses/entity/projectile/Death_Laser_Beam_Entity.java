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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseFireBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.PushReaction
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.blocks.EMP_Block;
import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.client.tool.ControlledAnimation;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Death_Laser_Beam_Entity
extends Entity {
    public static final double RADIUS = 30.0;
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
    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PITCH = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HEAD = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FIRE = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    public float prevYaw;
    public float prevPitch;
    @OnlyIn(value=Dist.CLIENT)
    private Vec3[] attractorPos;

    public Death_Laser_Beam_Entity(EntityType<? extends Death_Laser_Beam_Entity> type, Level world) {
        super(type, world);
        if (world.isClientSide()) {
            this.attractorPos = new Vec3[]{new Vec3(0.0, 0.0, 0.0)};
        }
    }

    public Death_Laser_Beam_Entity(EntityType<? extends Death_Laser_Beam_Entity> type, Level world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration, float damage, float Hpdamage) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setPos(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.calculateEndPos();
        if (!world.isClientSide()) {
            this.setCasterID(caster.getId());
        }
    }

    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        return false;
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
        if (!this.level().isClientSide()) {
            if (this.caster instanceof The_Harbinger_Entity) {
                this.updateWithHarbinger();
            }
            if (this.caster instanceof The_Prowler_Entity) {
                this.updateWithProwler();
            }
        }
        if (this.caster != null) {
            this.renderYaw = (float)(((double)this.caster.yHeadRot + 90.0) * Math.PI / 180.0);
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
            List<LivingEntity> hit = (List<LivingEntity>)this.raytraceEntities((Level)this.level(), (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ), (boolean)false, (boolean)true, (boolean)true).entities;
            if (this.blockSide != null) {
                this.spawnExplosionParticles(5);
                if (!this.level().isClientSide()) {
                    BlockState block;
                    for (BlockPos pos : BlockPos.betweenClosed((int)Mth.floor((double)(this.collidePosX - 0.5)), (int)Mth.floor((double)(this.collidePosY - 0.5)), (int)Mth.floor((double)(this.collidePosZ - 0.5)), (int)Mth.floor((double)(this.collidePosX + 0.5)), (int)Mth.floor((double)(this.collidePosY + 0.5)), (int)Mth.floor((double)(this.collidePosZ + 0.5)))) {
                        block = this.level().getBlockState(pos);
                        if (block.isAir() || !block.is(ModTag.CM_GLASS) || !(this.level() instanceof ServerLevel) || !EventHooks.canEntityGrief((ServerLevel)this.level(), (Entity)this)) continue;
                        this.level().destroyBlock(pos, true);
                    }
                    for (BlockPos pos : BlockPos.betweenClosed((int)Mth.floor((double)(this.collidePosX - 2.5)), (int)Mth.floor((double)(this.collidePosY - 2.5)), (int)Mth.floor((double)(this.collidePosZ - 2.5)), (int)Mth.floor((double)(this.collidePosX + 2.5)), (int)Mth.floor((double)(this.collidePosY + 2.5)), (int)Mth.floor((double)(this.collidePosZ + 2.5)))) {
                        block = this.level().getBlockState(pos);
                        if (!block.is((Block)ModBlocks.EMP.get()) || ((Boolean)block.getValue((Property)EMP_Block.POWERED)).booleanValue() || !((Boolean)block.getValue((Property)EMP_Block.OVERLOAD)).booleanValue()) continue;
                        this.level().setBlockAndUpdate(pos, (BlockState)block.setValue((Property)EMP_Block.OVERLOAD, (Comparable)Boolean.valueOf(false)));
                    }
                    if (this.getFire()) {
                        BlockPos blockpos1 = BlockPos.containing((double)this.collidePosX, (double)this.collidePosY, (double)this.collidePosZ);
                        if (CMCommonConfig.Harbinger.ignoreMobGriefing) {
                            if (this.level().isEmptyBlock(blockpos1)) {
                                this.level().setBlockAndUpdate(blockpos1, BaseFireBlock.getState((BlockGetter)this.level(), (BlockPos)blockpos1));
                            }
                        } else if (this.level() instanceof ServerLevel && EventHooks.canEntityGrief((ServerLevel)this.level(), (Entity)this) && this.level().isEmptyBlock(blockpos1)) {
                            this.level().setBlockAndUpdate(blockpos1, BaseFireBlock.getState((BlockGetter)this.level(), (BlockPos)blockpos1));
                        }
                    }
                }
            }
            if (!this.level().isClientSide()) {
                for (LivingEntity target : hit) {
                    if (this.caster == null || this.caster.isAlliedTo((Entity)target) || target == this.caster) continue;
                    boolean flag = target.hurtOrSimulate(CMDamageTypes.causeDeathLaserDamage(this, this.caster), (float)((double)this.getDamage() + Math.min((double)this.getDamage(), (double)(target.getMaxHealth() * this.getHpDamage()) * 0.01)));
                    if (!this.getFire() || !flag) continue;
                    target.igniteForSeconds(5.0f);
                }
            }
        }
        if (this.tickCount - 20 > this.getDuration()) {
            this.on = false;
        }
    }

    private void spawnExplosionParticles(int amount) {
        for (int i = 0; i < amount; ++i) {
            float velocity = 1.5f;
            float yaw = (float)((double)(this.random.nextFloat() * 2.0f) * Math.PI);
            float motionY = this.random.nextFloat() * 0.8f;
            float motionX = 1.5f * Mth.cos((float)yaw);
            float motionZ = 1.5f * Mth.sin((float)yaw);
            this.level().addParticle((ParticleOptions)new LightningParticleOptions(255, 26, 0), this.collidePosX, this.collidePosY + 0.1, this.collidePosZ, (double)motionX, (double)motionY, (double)motionZ);
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(YAW, Float.valueOf(0.0f));
        p_326229_.define(PITCH, Float.valueOf(0.0f));
        p_326229_.define(DURATION, 0);
        p_326229_.define(CASTER, -1);
        p_326229_.define(HEAD, 0);
        p_326229_.define(FIRE, false);
        p_326229_.define(DAMAGE, Float.valueOf(0.0f));
        p_326229_.define(HPDAMAGE, Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, Float.valueOf(damage));
    }

    public float getHpDamage() {
        return ((Float)this.entityData.get(HPDAMAGE)).floatValue();
    }

    public void setHpDamage(float damage) {
        this.entityData.set(HPDAMAGE, Float.valueOf(damage));
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

    public int getHead() {
        return (Integer)this.entityData.get(HEAD);
    }

    public void setHead(int head) {
        this.entityData.set(HEAD, head);
    }

    public int getCasterID() {
        return (Integer)this.entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        this.entityData.set(CASTER, id);
    }

    public boolean getFire() {
        return (Boolean)this.entityData.get(FIRE);
    }

    public void setFire(boolean fire) {
        this.entityData.set(FIRE, fire);
    }

    protected void readAdditionalSaveData(ValueInput nbt) {
    }

    protected void addAdditionalSaveData(ValueOutput nbt) {
    }

    private void calculateEndPos() {
        if (this.level().isClientSide()) {
            this.endPosX = this.getX() + 30.0 * Math.cos(this.renderYaw) * Math.cos(this.renderPitch);
            this.endPosZ = this.getZ() + 30.0 * Math.sin(this.renderYaw) * Math.cos(this.renderPitch);
            this.endPosY = this.getY() + 30.0 * Math.sin(this.renderPitch);
        } else {
            this.endPosX = this.getX() + 30.0 * Math.cos(this.getYaw()) * Math.cos(this.getPitch());
            this.endPosZ = this.getZ() + 30.0 * Math.sin(this.getYaw()) * Math.cos(this.getPitch());
            this.endPosY = this.getY() + 30.0 * Math.sin(this.getPitch());
        }
    }

    public LaserbeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock) {
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
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(this.getX(), this.collidePosX), Math.min(this.getY(), this.collidePosY), Math.min(this.getZ(), this.collidePosZ), Math.max(this.getX(), this.collidePosX), Math.max(this.getY(), this.collidePosY), Math.max(this.getZ(), this.collidePosZ)).inflate(1.0, 1.0, 1.0));
        for (LivingEntity entity : entities) {
            if (entity == this.caster) continue;
            float pad = entity.getPickRadius() + 0.5f;
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

    public boolean shouldRenderAtSqrDistance(double distance) {
        return distance < 1024.0;
    }

    private void updateWithHarbinger() {
        this.setYaw((float)((double)(this.caster.yHeadRot + 90.0f) * Math.PI / 180.0));
        this.setPitch((float)((double)(-this.caster.getXRot()) * Math.PI / 180.0));
        this.setPos(this.caster.getX(), this.caster.getY() + 2.7, this.caster.getZ());
    }

    private void updateWithProwler() {
        this.setYaw((float)((double)(this.caster.yHeadRot + 90.0f) * Math.PI / 180.0));
        this.setPitch((float)((double)(-this.caster.getXRot()) * Math.PI / 180.0));
        this.setPos(this.caster.getX(), this.caster.getY() + 1.8, this.caster.getZ());
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

