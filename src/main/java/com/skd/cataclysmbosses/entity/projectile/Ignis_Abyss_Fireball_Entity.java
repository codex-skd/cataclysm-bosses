/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.nbt.CompoundTag
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
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Explosion$BlockInteraction
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
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.skd.cataclysmbosses.entity.effect.Cm_Falling_Block_Entity;
import com.skd.cataclysmbosses.entity.projectile.CMAbstractHurtingProjectile;
import com.skd.cataclysmbosses.entity.projectile.Ignis_Fireball_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.util.CustomExplosion.IgnisExplosion;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Ignis_Abyss_Fireball_Entity
extends CMAbstractHurtingProjectile {
    private static final EntityDataAccessor<Integer> BOUNCES = SynchedEntityData.defineId(Ignis_Abyss_Fireball_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FIRED = SynchedEntityData.defineId(Ignis_Abyss_Fireball_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private int timer;
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;

    public Ignis_Abyss_Fireball_Entity(EntityType<? extends Ignis_Abyss_Fireball_Entity> type, Level level) {
        super(type, level);
    }

    public Ignis_Abyss_Fireball_Entity(Level level, LivingEntity entity, double x, double y, double z) {
        super((EntityType<? extends CMAbstractHurtingProjectile>)((EntityType)ModEntities.IGNIS_ABYSS_FIREBALL.get()), entity, x, y, z, level);
    }

    public Ignis_Abyss_Fireball_Entity(Level worldIn, LivingEntity entity) {
        this((EntityType<? extends Ignis_Abyss_Fireball_Entity>)((EntityType)ModEntities.IGNIS_ABYSS_FIREBALL.get()), worldIn);
        this.setOwner((Entity)entity);
    }

    public boolean isOnFire() {
        return false;
    }

    @Override
    public void tick() {
        Entity entity;
        super.tick();
        if (!this.level().isClientSide()) {
            --this.timer;
            if (this.timer <= 0 && !this.getFired()) {
                this.setFired(true);
            }
        }
        if (this.timer < -160) {
            this.discard();
        }
        if ((this.timer == 0 || this.timer == -40) && this.getTotalBounces() == 0 && (entity = this.getOwner()) instanceof Mob && ((Mob)entity).getTarget() != null) {
            LivingEntity target = ((Mob)entity).getTarget();
            if (target == null) {
                this.discard();
            }
            float speed = 0.2f;
            double dx = target.getX() - this.getX();
            double dy = target.getY() + (double)(target.getBbHeight() * 0.5f) - this.getY();
            double dz = target.getZ() - this.getZ();
            double d = Math.sqrt(dx * dx + dy * dy + dz * dz);
            this.xPower = (dx /= d) * (double)speed;
            this.yPower = (dy /= d) * (double)speed;
            this.zPower = (dz /= d) * (double)speed;
        }
        Vec3 trailAt = this.position().add(0.0, (double)(this.getBbHeight() / 2.0f), 0.0);
        if (this.trailPointer == -1) {
            Vec3 backAt = trailAt;
            for (int i = 0; i < this.trailPositions.length; ++i) {
                this.trailPositions[i] = backAt;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = trailAt;
    }

    public void setUp(int delay) {
        this.setFired(false);
        this.timer = delay;
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Entity entity = p_37626_.getEntity();
        Entity shooter = this.getOwner();
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            if (!(!this.getFired() || entity instanceof Ignis_Fireball_Entity || entity instanceof Ignis_Abyss_Fireball_Entity || entity instanceof Cm_Falling_Block_Entity || entity instanceof Ignis_Entity && shooter instanceof Ignis_Entity)) {
                boolean flag;
                if (shooter instanceof LivingEntity) {
                    LivingEntity owner = (LivingEntity)shooter;
                    DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, owner);
                    flag = entity instanceof LivingEntity ? entity.hurtOrSimulate(this.damageSources().mobProjectile((Entity)this, owner), 10.0f + ((LivingEntity)entity).getMaxHealth() * 0.2f) : entity.hurtOrSimulate(this.damageSources().mobProjectile((Entity)this, owner), 10.0f);
                    if (flag) {
                        if (entity.isAlive()) {
                            EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                        }
                        if (owner instanceof Ignis_Entity) {
                            owner.heal(5.0f * (float)CMCommonConfig.Ignis.HealingMultiplier);
                        } else {
                            owner.heal(5.0f);
                        }
                    }
                } else {
                    flag = entity.hurtOrSimulate(this.damageSources().magic(), 5.0f);
                }
                IgnisExplosion explosion = new IgnisExplosion(this.level(), (Entity)this, null, null, this.getX(), this.getY(), this.getZ(), 2.0f, true, Explosion.BlockInteraction.KEEP);
                explosion.explode();
                explosion.finalizeExplosion(3, 0.5);
                this.discard();
                if (flag && entity instanceof LivingEntity) {
                    MobEffectInstance effectinstance1 = ((LivingEntity)entity).getEffect(ModEffect.EFFECTBLAZING_BRAND);
                    int i = 2;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        ((LivingEntity)entity).removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                    ((LivingEntity)entity).addEffect(effectinstance);
                }
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        BlockHitResult traceResult = result;
        BlockState blockstate = this.level().getBlockState(traceResult.getBlockPos());
        if (!blockstate.getCollisionShape((BlockGetter)this.level(), traceResult.getBlockPos()).isEmpty() && this.getFired()) {
            Direction face = traceResult.getDirection();
            blockstate.onProjectileHit(this.level(), blockstate, traceResult, (Projectile)this);
            Vec3 motion = this.getDeltaMovement();
            double motionX = motion.x();
            double motionY = motion.y();
            double motionZ = motion.z();
            if (face == Direction.EAST) {
                motionX = -motionX;
            } else if (face == Direction.SOUTH) {
                motionZ = -motionZ;
            } else if (face == Direction.WEST) {
                motionX = -motionX;
            } else if (face == Direction.NORTH) {
                motionZ = -motionZ;
            } else if (face == Direction.UP) {
                motionY = -motionY;
            } else if (face == Direction.DOWN) {
                motionY = -motionY;
            }
            this.setDeltaMovement(motionX, motionY, motionZ);
            this.xPower = motionX * 0.05;
            this.yPower = motionY * 0.05;
            this.zPower = motionZ * 0.05;
            if (this.tickCount > 500 || this.getTotalBounces() > 5) {
                if (!this.level().isClientSide()) {
                    IgnisExplosion explosion = new IgnisExplosion(this.level(), (Entity)this, null, null, this.getX(), this.getY(), this.getZ(), 2.0f, true, Explosion.BlockInteraction.KEEP);
                    explosion.explode();
                    explosion.finalizeExplosion(3, 0.5);
                    this.discard();
                }
            } else {
                this.setTotalBounces(this.getTotalBounces() + 1);
            }
        }
    }

    protected void onHit(HitResult ray) {
        HitResult.Type hitresult$type = ray.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)ray);
            this.level().gameEvent((Holder)GameEvent.PROJECTILE_LAND, ray.getLocation(), GameEvent.Context.of((Entity)this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)ray;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent((Holder)GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of((Entity)this, (BlockState)this.level().getBlockState(blockpos)));
        }
    }

    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.isRemoved()) {
            partialTick = 1.0f;
        }
        int i = this.trailPointer - pointer & 0x3F;
        int j = this.trailPointer - pointer - 1 & 0x3F;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale((double)partialTick));
    }

    public boolean hasTrail() {
        return this.trailPointer != -1;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(BOUNCES, 0);
        p_326229_.define(FIRED, false);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("totalBounces", this.getTotalBounces());
        compound.putInt("timer", this.timer);
        compound.putBoolean("fired", this.getFired());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setTotalBounces(compound.getIntOr("totalBounces", 0));
        this.timer = compound.getIntOr("timer", 0);
        this.setFired(compound.getBooleanOr("fired", false));
    }

    public int getTotalBounces() {
        return (Integer)this.entityData.get(BOUNCES);
    }

    public void setTotalBounces(int bounces) {
        this.entityData.set(BOUNCES, bounces);
    }

    public void setFired(boolean fired) {
        this.entityData.set(FIRED, fired);
    }

    public boolean getFired() {
        return (Boolean)this.entityData.get(FIRED);
    }

    public boolean isPickable() {
        return true;
    }

    public float getPickRadius() {
        return 1.0f;
    }

    @Override
    public void onHitEntity(EntityHitResult p_36839_) {
        super.onHitEntity(p_36839_);
        this.markHurt();
        Entity entity = p_36839_.getEntity();
        if (entity != null && this.getFired()) {
            if (!this.level().isClientSide()) {
                Vec3 vec3 = entity.getLookAngle();
                this.setDeltaMovement(vec3);
                this.xPower = vec3.x * 0.1;
                this.yPower = vec3.y * 0.1;
                this.zPower = vec3.z * 0.1;
                this.setOwner(entity);
            }
        }
    }
}

