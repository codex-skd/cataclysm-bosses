/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.DynamicOps
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtOps
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.monster.Enemy
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.portal.DimensionTransition
 *  net.minecraft.world.phys.Vec3
 *  org.apache.logging.log4j.Logger
 */
package com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters;

import com.skd.thesundering.Cataclysm;
import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.thesundering.entity.etc.IHomeEntity;
import com.skd.thesundering.init.ModTag;
import com.mojang.serialization.DynamicOps;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.Logger;

public class IABoss_monster
extends Internal_Animation_Monster
implements Enemy,
IHomeEntity {
    private int homeTicks;
    protected final int HOME_COOLDOWN = CMCommonConfig.ETC.ReturnHome * 20;
    private float damageBucket = 0.0f;
    private int self_regen;
    private static final EntityDataAccessor<Optional<GlobalPos>> HOME_POS = SynchedEntityData.defineId(IABoss_monster.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_GLOBAL_POS);
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(IABoss_monster.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public IABoss_monster(EntityType entity, Level world) {
        super(entity, world);
    }

    @Override
    public void setHomePos(@Nullable GlobalPos vec3) {
        this.entityData.set(HOME_POS, Optional.ofNullable(vec3));
    }

    @Override
    @Nullable
    public GlobalPos getHomePos() {
        return ((Optional)this.entityData.get(HOME_POS)).orElse(null);
    }

    public void setLife(int life) {
        this.entityData.set(LIFE, (Object)life);
    }

    public int getLife() {
        return (Integer)this.entityData.get(LIFE);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(HOME_POS, Optional.empty());
        builder.define(LIFE, (Object)0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("LifeRemain", this.getLife());
        if (this.getHomePos() != null) {
            GlobalPos.CODEC.encodeStart((DynamicOps)NbtOps.INSTANCE, (Object)this.getHomePos()).resultOrPartial(arg_0 -> ((Logger)Cataclysm.LOGGER).error(arg_0)).ifPresent(tag1 -> compound.put("HomePos", tag1));
        }
        this.addAdditionalHomePoint(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        this.setLife(compound.getInt("LifeRemain"));
        this.readAdditionalHomePoint(compound);
        super.readAdditionalSaveData(compound);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        this.homeTicks = this.HOME_COOLDOWN;
        if (spawnType == MobSpawnType.SPAWNER) {
            // empty if block
        }
        return spawnGroupData;
    }

    protected void PlayerCounter(Level level) {
        double range = 64.0;
        int playerCount = level.getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(range), player -> !player.isSpectator() && !player.isCreative() && player.isAlive() && player.distanceToSqr((Entity)this) < range * range).size();
        this.setLife(playerCount);
    }

    public void awardKillScore(Entity killed, int scoreValue, DamageSource source) {
        if (killed instanceof ServerPlayer) {
            if (this.getLife() > 0) {
                this.setLife(this.getLife() - 1);
            } else {
                this.Retry();
            }
        }
        super.awardKillScore(killed, scoreValue, source);
    }

    protected void Retry() {
    }

    public boolean hurt(DamageSource source, float amount) {
        boolean flag;
        if (this.isInvulnerableTo(source)) {
            return false;
        }
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        }
        amount = Math.min(this.DamageCap(), amount);
        double distSqr = this.calculateRange(source);
        if (distSqr != -1.0) {
            double distance;
            float multiplier;
            double limit = this.RangeLimit();
            double maxLimit = limit * 1.5;
            double limitSqr = limit * limit;
            double maxLimitSqr = maxLimit * maxLimit;
            if (distSqr >= maxLimitSqr) {
                return false;
            }
            if (distSqr > limitSqr && (amount *= (multiplier = (float)((maxLimit - (distance = Math.sqrt(distSqr))) / (maxLimit - limit)))) <= 0.0f) {
                return false;
            }
        }
        float BUCKET = this.damageBucket;
        if (!source.is(ModTag.BYPASSES_HURT_TIME)) {
            float projectedBucket = this.damageBucket + amount;
            float limit = this.DamageCap();
            if (projectedBucket > limit) {
                float roomLeft = limit - this.damageBucket;
                if (roomLeft > 0.0f) {
                    amount = roomLeft;
                    this.damageBucket = limit;
                } else {
                    amount = 0.1f;
                }
            } else {
                this.damageBucket += amount;
            }
        }
        if (flag = super.hurt(source, amount)) {
            if (source.is(ModTag.BLOCK_SELF_REGEN)) {
                this.self_regen = this.HealCooldown();
            }
        } else {
            this.damageBucket = BUCKET;
        }
        return flag;
    }

    public float DamageCap() {
        return Float.MAX_VALUE;
    }

    public float DpsCap() {
        return Float.MAX_VALUE;
    }

    public float NatureRegen() {
        return 0.0f;
    }

    public double RangeLimit() {
        return Double.MAX_VALUE;
    }

    public int HealCooldown() {
        return 200;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.self_regen > 0) {
            --this.self_regen;
        }
        if (!this.level().isClientSide()) {
            LivingEntity target = this.getTarget();
            if (!this.isNoAi()) {
                if (this.self_regen <= 0 && !this.isNoAi() && this.NatureRegen() > 0.0f && target == null && this.tickCount % 20 == 0) {
                    this.heal(this.NatureRegen());
                }
                if (this.HOME_COOLDOWN > 0) {
                    if (this.homeTicks > 0) {
                        --this.homeTicks;
                    }
                    if (target != null) {
                        this.homeTicks = this.HOME_COOLDOWN;
                    }
                    if (this.homeTicks <= 0) {
                        this.ReturnToHome();
                    }
                }
                if (this.damageBucket > 0.0f) {
                    this.damageBucket -= this.DpsCap() / 20.0f;
                    if (this.damageBucket < 0.0f) {
                        this.damageBucket = 0.0f;
                    }
                }
            }
        }
    }

    private boolean isRestrictionPointValid(ResourceKey<Level> currentMobLevel) {
        return this.getHomePos() != null && this.getHomePos().dimension().equals(currentMobLevel);
    }

    protected void ReturnToHome() {
        Level level;
        if (this.getHomePos() != null && (level = this.level()) instanceof ServerLevel) {
            ServerLevel targetLevel;
            ServerLevel serverLevel = (ServerLevel)level;
            ResourceKey targetDim = this.getHomePos().dimension();
            BlockPos homeBlockPos = this.getHomePos().pos();
            Vec3 homeVec = new Vec3((double)homeBlockPos.getX() + 0.5, (double)homeBlockPos.getY(), (double)homeBlockPos.getZ() + 0.5);
            if (!targetDim.equals(this.level().dimension()) && (targetLevel = serverLevel.getServer().getLevel(targetDim)) != null) {
                this.changeDimension(new DimensionTransition(targetLevel, homeVec, Vec3.ZERO, this.getYRot(), this.getXRot(), DimensionTransition.DO_NOTHING));
                this.homeTicks = this.HOME_COOLDOWN;
                return;
            }
            if (!homeBlockPos.closerToCenterThan((Position)this.position(), 16.0)) {
                this.moveTo(homeVec.x, homeVec.y, homeVec.z, this.getYRot(), this.getXRot());
                this.homeTicks = this.HOME_COOLDOWN;
            }
        }
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    public boolean canUsePortal(boolean allowPassengers) {
        return false;
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect().getDelegate().is(ModTag.EFFECTIVE_FOR_BOSSES) && super.canBeAffected(p_34192_);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }
}

