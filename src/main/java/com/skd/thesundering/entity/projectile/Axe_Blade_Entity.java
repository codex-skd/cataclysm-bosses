/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.entity.projectile;

import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModParticle;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Axe_Blade_Entity
extends Entity {
    public double xPower;
    public double yPower;
    public double zPower;
    private LivingEntity caster;
    private UUID casterUuid;
    private boolean leftOwner;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Axe_Blade_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> TRANSPARENCY = SynchedEntityData.defineId(Axe_Blade_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public int lifetick = 0;
    public AnimationState idleAnimationState = new AnimationState();

    public Axe_Blade_Entity(EntityType<? extends Axe_Blade_Entity> type, Level level) {
        super(type, level);
    }

    public Axe_Blade_Entity(EntityType<? extends Axe_Blade_Entity> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, Level level, float Yrot) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0) {
            this.xPower = p_36821_ / d0 * 0.1;
            this.yPower = p_36822_ / d0 * 0.1;
            this.zPower = p_36823_ / d0 * 0.1;
        }
    }

    public Axe_Blade_Entity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_, float damage, float Yrot) {
        this((EntityType<? extends Axe_Blade_Entity>)((EntityType)ModEntities.AXE_BLADE.get()), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_, Yrot);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setYRot(Yrot);
    }

    public Axe_Blade_Entity(EntityType<? extends Axe_Blade_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0) {
            this.xPower = p_36821_ / d0 * 0.1;
            this.yPower = p_36822_ / d0 * 0.1;
            this.zPower = p_36823_ / d0 * 0.1;
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, (Object)Float.valueOf(0.0f));
        p_326229_.define(TRANSPARENCY, (Object)0);
    }

    public void setOwner(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        Entity entity;
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.casterUuid)) instanceof LivingEntity) {
            this.caster = (LivingEntity)entity;
        }
        return this.caster;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        return new AnimationState();
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, (Object)Float.valueOf(damage));
    }

    public int getTransparency() {
        return (Integer)this.entityData.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.entityData.set(TRANSPARENCY, (Object)trans);
    }

    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }
        return p_36837_ < (d0 *= 64.0) * d0;
    }

    public void tick() {
        HitResult raytraceresult;
        super.tick();
        if (!this.leftOwner) {
            this.leftOwner = this.checkLeftOwner();
        }
        if (!this.level().isClientSide()) {
            ++this.lifetick;
            this.setTransparency(this.lifetick);
            if (this.lifetick >= 80) {
                this.discard();
            }
        } else {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
        if ((raytraceresult = ProjectileUtil.getHitResultOnMoveVector((Entity)this, this::canHitEntity)).getType() != HitResult.Type.MISS) {
            this.onHit(raytraceresult);
        }
        this.checkInsideBlocks();
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        float f = this.getInertia();
        this.level().addParticle((ParticleOptions)ModParticle.PHANTOM_WING_FLAME.get(), this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
        this.setDeltaMovement(vec3.add(this.xPower, this.yPower, this.zPower).scale((double)f));
        this.setPos(d0, d1, d2);
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        if (!this.level().isClientSide()) {
            Entity entity = p_37626_.getEntity();
            LivingEntity entity1 = this.getOwner();
            if (entity1 instanceof LivingEntity) {
                LivingEntity livingentity = entity1;
                entity.hurt(this.damageSources().mobProjectile((Entity)this, livingentity), this.getDamage());
                if (entity1 instanceof LivingEntity) {
                    // empty if block
                }
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
    }

    protected void onHit(HitResult p_37260_) {
        HitResult.Type hitresult$type = p_37260_.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)p_37260_);
            this.level().gameEvent((Holder)GameEvent.PROJECTILE_LAND, p_37260_.getLocation(), GameEvent.Context.of((Entity)this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)p_37260_;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent((Holder)GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of((Entity)this, (BlockState)this.level().getBlockState(blockpos)));
        }
    }

    protected boolean canHitEntity(Entity p_36842_) {
        return this.canHit(p_36842_) && !p_36842_.noPhysics;
    }

    protected boolean canHit(Entity p_37250_) {
        if (!p_37250_.canBeHitByProjectile()) {
            return false;
        }
        LivingEntity entity = this.getOwner();
        return entity == null || this.leftOwner || !entity.isPassengerOfSameVehicle(p_37250_);
    }

    protected float getInertia() {
        return 0.85f;
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        ListTag listtag;
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        if (compound.contains("power", 9) && (listtag = compound.getList("power", 6)).size() == 3) {
            this.xPower = listtag.getDouble(0);
            this.yPower = listtag.getDouble(1);
            this.zPower = listtag.getDouble(2);
        }
        this.leftOwner = compound.getBoolean("LeftOwner");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        if (this.leftOwner) {
            compound.putBoolean("LeftOwner", true);
        }
        compound.put("power", (Tag)this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));
    }

    private boolean checkLeftOwner() {
        LivingEntity entity = this.getOwner();
        if (entity != null) {
            for (Entity entity1 : this.level().getEntities((Entity)this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0), p_234613_0_ -> !p_234613_0_.isSpectator() && p_234613_0_.isPickable())) {
                if (entity1.getRootVehicle() != entity.getRootVehicle()) continue;
                return false;
            }
        }
        return true;
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0f;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0f;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        LivingEntity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(this.getId(), this.getUUID(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), this.getType(), i, new Vec3(this.xPower, this.yPower, this.zPower), 0.0);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
        Vec3 vec3 = p_150128_.getMovement();
        double d0 = vec3.x();
        double d1 = vec3.y();
        double d2 = vec3.z();
        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        if (d3 != 0.0) {
            this.xPower = d0 / d3 * 0.1;
            this.yPower = d1 / d3 * 0.1;
            this.zPower = d2 / d3 * 0.1;
        }
    }
}

