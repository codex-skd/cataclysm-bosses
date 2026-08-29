/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModParticle;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Ancient_Desert_Stele_Entity
extends Projectile {
    private boolean sentSpikeEvent;
    private int lifeTicks = 70;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final EntityDataAccessor<Boolean> ACTIVATE = SynchedEntityData.defineId(Ancient_Desert_Stele_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Ancient_Desert_Stele_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> WARMUP = SynchedEntityData.defineId(Ancient_Desert_Stele_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public Ancient_Desert_Stele_Entity(EntityType<? extends Ancient_Desert_Stele_Entity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }

    public Ancient_Desert_Stele_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, float damage, LivingEntity casterIn) {
        this((EntityType<? extends Ancient_Desert_Stele_Entity>)((EntityType)ModEntities.ANCIENT_DESERT_STELE.get()), worldIn);
        this.setWarmUp(p_i47276_9_);
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setPos(x, y, z);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(ACTIVATE, false);
        p_326229_.define(DAMAGE, Float.valueOf(0.0f));
        p_326229_.define(WARMUP, 0);
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, Float.valueOf(damage));
    }

    public int getWarmUp() {
        return (Integer)this.entityData.get(WARMUP);
    }

    public void setWarmUp(int damage) {
        this.entityData.set(WARMUP, damage);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        Entity entity;
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.casterUuid)) instanceof LivingEntity) {
            this.caster = (LivingEntity)entity;
        }
        return this.caster;
    }

    protected void readAdditionalSaveData(ValueInput compound) {
        this.setWarmUp(compound.getIntOr("Warmup", 0));
        if (compound.read("Owner", UUIDUtil.CODEC).isPresent()) {
            this.casterUuid = compound.read("Owner", UUIDUtil.CODEC).orElse(null);
        }
        this.setDamage(compound.getFloatOr("damage", 0.0f));
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        compound.putInt("Warmup", this.getWarmUp());
        if (this.casterUuid != null) {
            compound.store("Owner", UUIDUtil.CODEC, this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }

    public void tick() {
        super.tick();
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector((Entity)this, x$0 -> this.canHitEntity((Entity)x$0));
        if (hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact((Projectile)this, (HitResult)hitresult)) {
            this.onHit(hitresult);
        }
        this.applyEffectsFromBlocks();
        if (this.level().isClientSide()) {
            --this.lifeTicks;
        } else {
            if (this.getWarmUp() > 0) {
                this.setWarmUp(this.getWarmUp() - 1);
            } else {
                if (!this.isActivate()) {
                    this.setActivate(true);
                }
                if (--this.lifeTicks < 0) {
                    this.discard();
                }
            }
            if (this.getWarmUp() < 10 && !this.sentSpikeEvent) {
                this.level().broadcastEntityEvent((Entity)this, (byte)4);
                this.sentSpikeEvent = true;
            }
        }
        Vec3 vec3 = this.getDeltaMovement();
        double d2 = this.getX() + vec3.x;
        double d0 = this.getY() + vec3.y;
        double d1 = this.getZ() + vec3.z;
        if (this.isActivate()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
            Vec3 vec31 = this.getDeltaMovement();
            this.setDeltaMovement(vec31.x, vec31.y - 0.03, vec31.z);
        }
        this.setPos(d2, d0, d1);
    }

    protected void onHit(HitResult ray) {
        super.onHit(ray);
        BlockState state = Blocks.SANDSTONE.defaultBlockState();
        SoundType soundtype = state.getSoundType((LevelReader)this.level(), this.blockPosition(), null);
        this.playSound(soundtype.getBreakSound(), (soundtype.getVolume() + 1.0f) / 2.0f, soundtype.getPitch() * 0.8f);
        if (!this.level().isClientSide()) {
            ((ServerLevel)this.level()).sendParticles((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, state), this.getX(), this.getY() + (double)this.getBbHeight() / 2.0, this.getZ(), 64, (double)this.getBbWidth() / 2.0, (double)this.getBbHeight() / 2.0, (double)this.getBbWidth() / 2.0, 1.0);
            this.discard();
        }
    }

    protected void onHitEntity(EntityHitResult p_213868_1_) {
        LivingEntity shooter = this.getCaster();
        Entity entity = p_213868_1_.getEntity();
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            boolean flag = false;
            if (shooter != null) {
                DamageSource damagesource;
                LivingEntity owner = shooter;
                if (owner != entity && !owner.isAlliedTo(entity) && (flag = entity.hurtOrSimulate(damagesource = this.damageSources().mobProjectile((Entity)this, owner), this.getDamage()))) {
                    EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                }
            } else {
                flag = entity.hurtOrSimulate(this.damageSources().magic(), this.getDamage());
            }
            if (flag && entity instanceof LivingEntity) {
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                ((LivingEntity)entity).addEffect(effectinstance);
            }
        }
    }

    protected void onHitBlock(BlockHitResult p_230299_1_) {
    }

    @OnlyIn(value=Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.level().addParticle((ParticleOptions)ModParticle.DESERT_GLYPH.get(), this.getX(), this.getY() + 2.0, this.getZ(), 0.5, 0.0, 0.0);
        }
    }

    public boolean isActivate() {
        return (Boolean)this.entityData.get(ACTIVATE);
    }

    public void setActivate(boolean Activate) {
        this.entityData.set(ACTIVATE, Activate);
    }
}

