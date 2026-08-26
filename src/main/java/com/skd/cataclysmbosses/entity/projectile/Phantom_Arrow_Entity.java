/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow$Pickup
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.client.particle.Options.Cursed_MarkParticleOption;
import com.skd.cataclysmbosses.client.particle.Options.TrackLightningParticleOptions;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Phantom_Arrow_Entity
extends AbstractArrow {
    private static final EntityDataAccessor<Integer> TRANSPARENCY = SynchedEntityData.defineId(Phantom_Arrow_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;
    private boolean stopSeeking;
    private boolean impactParticleSpawn = false;

    public Phantom_Arrow_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Phantom_Arrow_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Phantom_Arrow_Entity(Level worldIn, LivingEntity shooter, LivingEntity finalTarget) {
        this((EntityType)ModEntities.PHANTOM_ARROW.get(), shooter.getX(), shooter.getEyeY() - (double)0.1f, shooter.getZ(), worldIn);
        this.setOwner((Entity)shooter);
        this.finalTarget = finalTarget;
        if (shooter instanceof Player) {
            this.pickup = AbstractArrow.Pickup.ALLOWED;
        }
    }

    public Phantom_Arrow_Entity(Level worldIn, LivingEntity shooter) {
        this((EntityType)ModEntities.PHANTOM_ARROW.get(), shooter.getX(), shooter.getEyeY() - (double)0.1f, shooter.getZ(), worldIn);
        this.setOwner((Entity)shooter);
        if (shooter instanceof Player) {
            this.pickup = AbstractArrow.Pickup.ALLOWED;
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(TRANSPARENCY, 0);
    }

    public int getTransparency() {
        return (Integer)this.entityData.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.entityData.set(TRANSPARENCY, trans);
    }

    public void addAdditionalSaveData(ValueOutput p_37357_) {
        super.addAdditionalSaveData(p_37357_);
        if (this.finalTarget != null) {
            p_37357_.store("Target", UUIDUtil.CODEC, this.finalTarget.getUUID());
        }
    }

    public void readAdditionalSaveData(ValueInput p_37353_) {
        super.readAdditionalSaveData(p_37353_);
        if (p_37353_.read("Target", UUIDUtil.CODEC).isPresent()) {
            this.targetId = p_37353_.read("Target", UUIDUtil.CODEC).orElse(null);
        }
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            Vec3 arcVec;
            float sqrt;
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerLevel)this.level()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
            this.setTransparency(this.life);
            if (!this.inGround && !this.stopSeeking && (this.finalTarget != null && this.finalTarget.isAlive() || this.finalTarget instanceof Player && !this.finalTarget.isSpectator()) && (sqrt = (float)this.getDeltaMovement().length()) > 1.25f && this.tickCount > 2 && this.finalTarget != null && (arcVec = this.finalTarget.position().add(0.0, (double)(0.65f * this.finalTarget.getBbHeight()), 0.0).subtract(this.position())).length() > (double)this.finalTarget.getBbWidth()) {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.625).add(arcVec.normalize().scale((double)0.4775f)));
            }
        } else {
            Vec3 center = this.position().add(this.getDeltaMovement());
            Vec3 vec3 = center.add(new Vec3((double)(this.random.nextFloat() - 0.5f), (double)(this.random.nextFloat() - 0.5f), (double)(this.random.nextFloat() - 0.5f)));
            this.level().addParticle((ParticleOptions)new TrackLightningParticleOptions(26, 107, 89), center.x, center.y, center.z, vec3.x, vec3.y, vec3.z);
            Vec3 vec31 = this.getDeltaMovement();
            double d5 = vec31.x;
            double d6 = vec31.y;
            double d1 = vec31.z;
            for (int i = 0; i < 2; ++i) {
                this.level().addParticle((ParticleOptions)ModParticle.CURSED_FLAME.get(), this.getX() + d5 * (double)i / 4.0, this.getY() + d6 * (double)i / 4.0, this.getZ() + d1 * (double)i / 4.0, 0.0, 0.0, 0.0);
            }
        }
    }

    protected void tickDespawn() {
        ++this.life;
        if (this.life >= 200) {
            this.discard();
        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        Vec3 blockpos = result.getLocation();
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            serverlevel.sendParticles((ParticleOptions)new Cursed_MarkParticleOption(0.5f + this.random.nextFloat() * 0.2f), blockpos.x(), blockpos.y(), blockpos.z(), 1, 0.0, 0.0, 0.0, 0.0);
        }
    }

    protected void onHitEntity(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = (float)this.getBaseDamage();
        Entity entity1 = this.getOwner();
        DamageSource damagesource = CMDamageTypes.causeMaledictioSagittaDamage((Entity)this, (Entity)(entity1 == null ? this : entity1));
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            f = EnchantmentHelper.modifyDamage((ServerLevel)serverlevel, (ItemStack)this.getWeaponItem(), (Entity)entity, (DamageSource)damagesource, (float)f);
        }
        boolean flag = entity.getType() == EntityType.ENDERMAN;
        this.stopSeeking = true;
        if (this.isOnFire() && !flag) {
            entity.igniteForSeconds(5.0f);
        }
        if (entity.hurtOrSimulate(damagesource, f)) {
            if (flag) {
                return;
            }
            Level level2 = this.level();
            if (level2 instanceof ServerLevel) {
                ServerLevel serverlevel1 = (ServerLevel)level2;
                EnchantmentHelper.doPostAttackEffectsWithItemSource((ServerLevel)serverlevel1, (Entity)entity, (DamageSource)damagesource, (ItemStack)this.getWeaponItem());
            }
            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity;
                this.doKnockback(livingentity, damagesource);
                this.doPostHurtEffects(livingentity);
            }
        } else {
            this.setDeltaMovement(this.getDeltaMovement().scale(-0.1));
            this.setYRot(this.getYRot() + 180.0f);
            this.yRotO += 180.0f;
            if (!this.level().isClientSide() && this.getDeltaMovement().lengthSqr() < 1.0E-7 && this.pickup == AbstractArrow.Pickup.ALLOWED) {
                this.spawnAtLocation(this.getPickupItem(), 0.1f);
            }
            this.discard();
        }
        this.playSound(SoundEvents.ARROW_HIT, 1.0f, 1.2f / (this.random.nextFloat() * 0.2f + 0.9f));
    }

    public ItemStack getWeaponItem() {
        return this.getPickupItemStackOrigin();
    }

    protected void doPostHurtEffects(LivingEntity entity) {
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack((ItemLike)Items.ARROW);
    }
}

