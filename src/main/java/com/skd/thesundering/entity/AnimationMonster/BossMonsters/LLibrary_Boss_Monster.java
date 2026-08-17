/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
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
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.portal.DimensionTransition
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.entity.AnimationMonster.BossMonsters;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.AnimationMonster.LLibrary_Monster;
import com.skd.thesundering.entity.etc.IHomeEntity;
import com.skd.thesundering.init.ModTag;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;

public class LLibrary_Boss_Monster
extends LLibrary_Monster
implements IAnimatedEntity,
Enemy,
IHomeEntity {
    private int homeTicks;
    protected final int HOME_COOLDOWN = CMCommonConfig.ETC.ReturnHome * 20;
    private float damageBucket = 0.0f;
    private int self_regen;
    private static final EntityDataAccessor<Optional<GlobalPos>> HOME_POS = SynchedEntityData.defineId(LLibrary_Boss_Monster.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_GLOBAL_POS);

    public LLibrary_Boss_Monster(EntityType entity, Level world) {
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

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(HOME_POS, Optional.empty());
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.addAdditionalHomePoint(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        this.readAdditionalHomePoint(compound);
        super.readAdditionalSaveData(compound);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        this.homeTicks = this.HOME_COOLDOWN;
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
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
    protected void onDeathAIUpdate() {
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect().getDelegate().is(ModTag.EFFECTIVE_FOR_BOSSES) && super.canBeAffected(p_34192_);
    }

    public boolean canUsePortal(boolean allowPassengers) {
        return false;
    }

    public boolean removeWhenFarAway(double p_21542_) {
        return false;
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }
}

