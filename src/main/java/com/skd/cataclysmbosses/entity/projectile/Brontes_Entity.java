/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow$Pickup
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.entity.IEntityWithComplexSpawn
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.client.particle.Options.TrackLightningParticleOptions;
import com.skd.cataclysmbosses.entity.effect.Lightning_Storm_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.projectile.Spark_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Brontes_Entity
extends AbstractArrow
implements IEntityWithComplexSpawn {
    private static final EntityDataAccessor<Boolean> RETURN = SynchedEntityData.defineId(Brontes_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> Y_ROT_OLD = SynchedEntityData.defineId(Brontes_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> X_ROT_OLD = SynchedEntityData.defineId(Brontes_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_DAMAGE = SynchedEntityData.defineId(Brontes_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> STORM_DAMAGE = SynchedEntityData.defineId(Brontes_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private double baseDamage = 0.0;

    public Brontes_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Brontes_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Brontes_Entity(Level worldIn, LivingEntity shooter) {
        this((EntityType)ModEntities.BRONTES.get(), shooter.getX(), shooter.getEyeY() - (double)0.1f, shooter.getZ(), worldIn);
        this.setOwner((Entity)shooter);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(RETURN, false);
        p_326229_.define(Y_ROT_OLD, Float.valueOf(0.0f));
        p_326229_.define(X_ROT_OLD, Float.valueOf(0.0f));
        p_326229_.define(AREA_DAMAGE, Float.valueOf(0.0f));
        p_326229_.define(STORM_DAMAGE, Float.valueOf(0.0f));
    }

    public boolean getReturn() {
        return (Boolean)this.entityData.get(RETURN);
    }

    public void setReturn(boolean weapon) {
        this.entityData.set(RETURN, weapon);
    }

    public float getYrotOld() {
        return ((Float)this.entityData.get(Y_ROT_OLD)).floatValue();
    }

    public void setYrotOld(float rot) {
        this.entityData.set(Y_ROT_OLD, Float.valueOf(rot));
    }

    public float getXrotOld() {
        return ((Float)this.entityData.get(X_ROT_OLD)).floatValue();
    }

    public void setXrotOld(float rot) {
        this.entityData.set(X_ROT_OLD, Float.valueOf(rot));
    }

    public float getAreaDamage() {
        return ((Float)this.entityData.get(AREA_DAMAGE)).floatValue();
    }

    public void setAreaDamage(float rot) {
        this.entityData.set(AREA_DAMAGE, Float.valueOf(rot));
    }

    public float getStormDamage() {
        return ((Float)this.entityData.get(STORM_DAMAGE)).floatValue();
    }

    public void setStormDamage(float rot) {
        this.entityData.set(STORM_DAMAGE, Float.valueOf(rot));
    }

    public void readAdditionalSaveData(ValueInput tag) {
        super.readAdditionalSaveData(tag);
        this.setReturn(tag.getBooleanOr("Return", false));
        this.setStormDamage(tag.getFloatOr("StormDamage", 0.0f));
        this.setAreaDamage(tag.getFloatOr("AreaDamage", 0.0f));
    }

    public void addAdditionalSaveData(ValueOutput tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Return", this.getReturn());
        tag.putFloat("StormDamage", this.getStormDamage());
        tag.putFloat("AreaDamage", this.getAreaDamage());
    }

    public void tick() {
        Vec3 vec3;
        super.tick();
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            LivingEntity owner = (LivingEntity)entity;
            if (this.getReturn()) {
                if (!this.isAcceptibleReturnOwner()) {
                    this.discard();
                } else {
                    this.setNoPhysics(true);
                    vec3 = owner.getEyePosition().subtract(this.position());
                    this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015 * 3.0, this.getZ());
                    this.setYRot(this.getYrotOld());
                    if (this.level().isClientSide()) {
                        this.yOld = this.getY();
                    } else if (this.distanceTo((Entity)owner) < 3.0f) {
                        this.discard();
                    }
                    double d0 = 0.2;
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3.normalize().scale(d0)));
                }
            }
        } else {
            this.discard();
        }
        Vec3 center = this.position().add(this.getDeltaMovement());
        vec3 = center.add(new Vec3((double)(this.random.nextFloat() - 0.5f), (double)(this.random.nextFloat() - 0.5f), (double)(this.random.nextFloat() - 0.5f)));
        if (this.level().isClientSide()) {
            this.level().addParticle((ParticleOptions)new TrackLightningParticleOptions(143, 241, 215), center.x, center.y, center.z, vec3.x, vec3.y, vec3.z);
        }
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        return entity == null || !entity.isAlive() ? false : !(entity instanceof ServerPlayer) || !entity.isSpectator();
    }

    protected void onHitEntity(EntityHitResult p_37573_) {
        Entity entity1;
        DamageSource damagesource;
        Entity entity = p_37573_.getEntity();
        if (entity.hurtOrSimulate(damagesource = CMDamageTypes.causePlayerCeraunusDamage((Entity)this, (Entity)((entity1 = this.getOwner()) == null ? this : entity1)), (float)this.baseDamage)) {
            if (entity.getType() == net.minecraft.world.entity.EntityTypes.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity;
                this.doKnockback(livingentity, damagesource);
                this.doPostHurtEffects(livingentity);
                this.playSound(this.getHitGroundSoundEvent(), 1.0f, 1.2f / (this.random.nextFloat() * 0.2f + 0.9f));
            }
        }
    }

    protected void onHitBlock(BlockHitResult p_37573_) {
        super.onHitBlock(p_37573_);
    }

    public ItemStack getWeaponItem() {
        return this.getPickupItemStackOrigin();
    }

    protected boolean tryPickup(Player player) {
        return false;
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack((ItemLike)ModItems.CERAUNUS.get());
    }

    public boolean shouldRiderSit() {
        return false;
    }

    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }

    protected float getWaterInertia() {
        return 0.95f;
    }

    protected void doKnockback(LivingEntity entity, DamageSource damageSource) {
        double d0 = 1.5;
        double d1 = Math.max(0.0, 1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE) * 1.0 / 3.0);
        Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(d0 * 0.6 * d1);
        if (vec3.lengthSqr() > 0.0) {
            entity.push(vec3.x, 0.1, vec3.z);
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        Vec3 hitPos = result.getLocation();
        if (!this.level().isClientSide()) {
            this.setXrotOld(this.getXRot());
            this.setYrotOld(this.getYRot());
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 25.0f, 0.03f, 0, 20);
            float speed = 1.0f;
            int quakeCount = 8;
            float angle = 45.0f;
            for (int i = 0; i < 8; ++i) {
                double angleRad = Math.toRadians((float)i * angle);
                double xDir = Math.cos(angleRad);
                double zDir = Math.sin(angleRad);
                Spark_Entity peq = new Spark_Entity(this.level(), (LivingEntity)this.getOwner());
                peq.setPos(hitPos.x, hitPos.y + 0.1, hitPos.z);
                peq.setAreaDamage(this.getAreaDamage());
                peq.setDamage(this.getStormDamage());
                peq.setAreaRadius(1.0f);
                peq.shoot(xDir, 0.125, zDir, speed, 5.0f);
                this.level().addFreshEntity((Entity)peq);
            }
            this.level().addFreshEntity((Entity)new Lightning_Storm_Entity(this.level(), this.getX(), this.getY(), this.getZ(), this.getYRot(), -9, this.getStormDamage(), 0.0f, (LivingEntity)this.getOwner(), 3.0f));
            this.setReturn(true);
        } else if (this.level().isClientSide()) {
            this.level().addParticle((ParticleOptions)ModParticle.LIGHTNING_EXPLODE.get(), hitPos.x, this.getY(), hitPos.z, 0.0, 0.0, 0.0);
        }
    }

    public boolean canUsePortal(boolean allowPassengers) {
        return false;
    }

    @Override
    public void setBaseDamage(double damage) {
        this.baseDamage = damage;
    }

    protected double getDefaultGravity() {
        return 0.1;
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return (SoundEvent)ModSounds.HEAVY_SMASH.get();
    }

    public void writeSpawnData(RegistryFriendlyByteBuf buffer) {
        buffer.writeInt(this.getOwner() != null ? this.getOwner().getId() : -1);
    }

    public void readSpawnData(RegistryFriendlyByteBuf buf) {
        Entity e = this.level().getEntity(buf.readInt());
        if (e instanceof LivingEntity) {
            this.setOwner(e);
        }
    }
}

