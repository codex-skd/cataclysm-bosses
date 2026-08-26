/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Part;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Abyss_Orb_Entity
extends Projectile {
    public double xPower;
    public double yPower;
    public double zPower;
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;
    private static final EntityDataAccessor<Boolean> TRACKING = SynchedEntityData.defineId(Abyss_Orb_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Abyss_Orb_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private int timer;
    private int lifetick;

    public Abyss_Orb_Entity(EntityType<? extends Abyss_Orb_Entity> p_36833_, Level p_36834_) {
        super(p_36833_, p_36834_);
    }

    public Abyss_Orb_Entity(Level worldIn, LivingEntity entity) {
        this((EntityType<? extends Abyss_Orb_Entity>)((EntityType)ModEntities.ABYSS_ORB.get()), worldIn);
        this.setOwner((Entity)entity);
    }

    public Abyss_Orb_Entity(EntityType<? extends Abyss_Orb_Entity> p_36817_, double p_36818_, double p_36819_, double p_36820_, double p_36821_, double p_36822_, double p_36823_, Level p_36824_) {
        this(p_36817_, p_36824_);
        this.setPos(p_36818_, p_36819_, p_36820_, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0) {
            this.xPower = p_36821_ / d0 * 0.1;
            this.yPower = p_36822_ / d0 * 0.1;
            this.zPower = p_36823_ / d0 * 0.1;
        }
    }

    public Abyss_Orb_Entity(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_, float damage, LivingEntity finalTarget) {
        this((EntityType<? extends Abyss_Orb_Entity>)((EntityType)ModEntities.ABYSS_ORB.get()), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner((Entity)p_36827_);
        this.setDamage(damage);
        this.finalTarget = finalTarget;
        this.setRot(p_36827_.getYRot(), p_36827_.getXRot());
    }

    public Abyss_Orb_Entity(Level worldIn, LivingEntity entity, LivingEntity finalTarget) {
        this((EntityType<? extends Abyss_Orb_Entity>)((EntityType)ModEntities.ABYSS_ORB.get()), worldIn);
        this.setOwner((Entity)entity);
        this.finalTarget = finalTarget;
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(TRACKING, false);
        p_326229_.define(DAMAGE, Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, Float.valueOf(damage));
    }

    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }
        return p_36837_ < (d0 *= 64.0) * d0;
    }

    public void addAdditionalSaveData(ValueOutput p_37357_) {
        super.addAdditionalSaveData(p_37357_);
        if (this.finalTarget != null) {
            p_37357_.store("Target", UUIDUtil.CODEC, this.finalTarget.getUUID());
        }
        p_37357_.put("power", (Tag)this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));
        p_37357_.putInt("timer", this.timer);
        p_37357_.putFloat("damage", this.getDamage());
        p_37357_.putBoolean("tracking", this.getTracking());
    }

    public void readAdditionalSaveData(ValueInput p_37353_) {
        ListTag listtag;
        super.readAdditionalSaveData(p_37353_);
        if (p_37353_.read("Target", UUIDUtil.CODEC).isPresent()) {
            this.targetId = p_37353_.read("Target", UUIDUtil.CODEC).orElse(null);
        }
        if (p_37353_.contains("power", 9) && (listtag = p_37353_.getList("power", 6)).size() == 3) {
            this.xPower = listtag.getDouble(0);
            this.yPower = listtag.getDouble(1);
            this.zPower = listtag.getDouble(2);
        }
        this.timer = p_37353_.getIntOr("timer", 0);
        this.setTracking(p_37353_.getBooleanOr("fired", false));
        this.setDamage(p_37353_.getFloatOr("damage", 0.0F));
    }

    public void setTracking(boolean tracking) {
        this.entityData.set(TRACKING, tracking);
    }

    public boolean getTracking() {
        return (Boolean)this.entityData.get(TRACKING);
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (this.level().isClientSide() || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector((Entity)this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact((Projectile)this, (HitResult)hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }
            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement((Entity)this, (float)0.2f);
            float f = this.getInertia();
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    float f1 = 0.25f;
                    this.level().addParticle((ParticleOptions)ParticleTypes.BUBBLE, d0 - vec3.x * 0.25, d1 - vec3.y * 0.25, d2 - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
                }
                f = 0.8f;
            }
            this.level().addParticle((ParticleOptions)ParticleTypes.REVERSE_PORTAL, this.getX() - vec3.x, this.getY() - vec3.y + 0.15, this.getZ() - vec3.z, 0.0, 0.0, 0.0);
            this.level().addParticle((ParticleOptions)new LightningParticleOptions(102, 26, 204), d0 - vec3.x * 0.5 + this.random.nextDouble() * 0.6 - 0.3, d1 - vec3.y * 0.5, d2 - vec3.z * 0.5 + this.random.nextDouble() * 0.6 - 0.3, vec3.x, vec3.y, vec3.z);
            this.setDeltaMovement(vec3.add(this.xPower, this.yPower, this.zPower).scale((double)f));
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
        if (!this.level().isClientSide()) {
            --this.timer;
            ++this.lifetick;
            if (this.timer <= 0 && !this.getTracking()) {
                this.setTracking(true);
            }
            if (this.lifetick >= 400 && this.getTracking()) {
                this.setTracking(false);
            }
            if (this.lifetick >= 500) {
                this.level().explode(entity, this.getX(), this.getY(), this.getZ(), 1.0f, false, Level.ExplosionInteraction.NONE);
                this.discard();
            }
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerLevel)this.level()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
            if (this.getTracking()) {
                if (this.finalTarget == null || !this.finalTarget.isAlive() || this.finalTarget instanceof Player && this.finalTarget.isSpectator()) {
                    this.yPower = -0.05;
                } else {
                    double d = this.distanceToSqr(this.finalTarget);
                    double dx = this.finalTarget.getX() - this.getX();
                    double dy = this.finalTarget.getY() + (double)(this.finalTarget.getBbHeight() * 1.2f) - this.getY();
                    double dz = this.finalTarget.getZ() - this.getZ();
                    double d13 = 2.0;
                    this.xPower += (dx /= d) * d13;
                    this.yPower += (dy /= d) * d13;
                    this.zPower += (dz /= d) * d13;
                    this.xPower = Mth.clamp((double)((float)this.xPower), (double)-0.05, (double)0.05);
                    this.yPower = Mth.clamp((double)((float)this.yPower), (double)-0.05, (double)0.05);
                    this.zPower = Mth.clamp((double)((float)this.zPower), (double)-0.05, (double)0.05);
                }
            }
        }
    }

    public void setUp(int delay) {
        this.setTracking(false);
        this.timer = delay;
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity1 = this.getOwner();
        if (!(this.level().isClientSide() || (result.getEntity() instanceof The_Leviathan_Part || result.getEntity() instanceof The_Leviathan_Entity) && entity1 instanceof The_Leviathan_Entity)) {
            boolean flag;
            Entity entity = result.getEntity();
            if (entity1 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity1;
                flag = entity.hurtOrSimulate(this.damageSources().mobProjectile((Entity)this, livingentity), this.getDamage());
            } else {
                flag = entity.hurtOrSimulate(this.damageSources().magic(), this.getDamage());
            }
            if (flag && entity instanceof LivingEntity) {
                ((LivingEntity)entity).addEffect(new MobEffectInstance(ModEffect.EFFECTABYSSAL_FEAR, 100, 0), this.getEffectSource());
            }
            this.level().explode(entity1, this.getX(), this.getY(), this.getZ(), 1.0f, false, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        Entity entity1 = this.getOwner();
        if (this.getTracking()) {
            if (this.lifetick >= 200 && !this.level().isClientSide()) {
                this.level().explode(entity1, this.getX(), this.getY(), this.getZ(), 1.0f, false, Level.ExplosionInteraction.NONE);
                this.discard();
            }
        } else if (this.lifetick >= 400 && !this.level().isClientSide()) {
            this.level().explode(entity1, this.getX(), this.getY(), this.getZ(), 1.0f, false, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    protected void onHit(HitResult ray) {
        HitResult.Type raytraceresult$type = ray.getType();
        if (raytraceresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)ray);
        } else if (raytraceresult$type == HitResult.Type.BLOCK) {
            this.onHitBlock((BlockHitResult)ray);
        }
    }

    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }

    protected float getInertia() {
        return 0.6f;
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0f;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0f;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(this.getId(), this.getUUID(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), this.getType(), i, new Vec3(this.xPower, this.yPower, this.zPower), 0.0);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
        Vec3 movement = p_150128_.getMovement();
        double d0 = movement.x;
        double d1 = movement.y;
        double d2 = movement.z;
        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        if (d3 != 0.0) {
            this.xPower = d0 / d3 * 0.1;
            this.yPower = d1 / d3 * 0.1;
            this.zPower = d2 / d3 * 0.1;
        }
    }
}

