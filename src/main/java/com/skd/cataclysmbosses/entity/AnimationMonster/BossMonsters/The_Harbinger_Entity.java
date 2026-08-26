/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.google.common.collect.ImmutableList
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.BossEvent$BossBarColor
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.PowerableMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.FlyingMoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RangedAttackGoal
 *  net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.targeting.TargetingConditions
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.monster.RangedAttackMob
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters;

import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.client.particle.Options.LightningParticleOptions;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.HurtByNearestTargetGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackAniamtionGoal3;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.skd.cataclysmbosses.entity.effect.Cm_Falling_Block_Entity;
import com.skd.cataclysmbosses.entity.etc.CMBossInfoServer;
import com.skd.cataclysmbosses.entity.projectile.Death_Laser_Beam_Entity;
import com.skd.cataclysmbosses.entity.projectile.Laser_Beam_Entity;
import com.skd.cataclysmbosses.entity.projectile.Wither_Homing_Missile_Entity;
import com.skd.cataclysmbosses.entity.projectile.Wither_Howitzer_Entity;
import com.skd.cataclysmbosses.entity.projectile.Wither_Missile_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.google.common.collect.ImmutableList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class The_Harbinger_Entity
extends LLibrary_Boss_Monster
implements RangedAttackMob,
PowerableMob {
    public static final Animation DEATHLASER_ANIMATION = Animation.create((int)124);
    public static final Animation CHARGE_ANIMATION = Animation.create((int)45);
    public static final Animation DEATH_ANIMATION = Animation.create((int)144);
    public static final Animation LAUNCH_ANIAMATION = Animation.create((int)59);
    public static final Animation MISSILE_FIRE_ANIAMATION = Animation.create((int)118);
    public static final Animation MISSILE_FIRE_FAST_ANIAMATION = Animation.create((int)96);
    public static final Animation STUN_ANIAMATION = Animation.create((int)105);
    public static final int SKILL_COOLDOWN = 240;
    private static final EntityDataAccessor<Integer> FIRST_HEAD_TARGET = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SECOND_HEAD_TARGET = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> THIRD_HEAD_TARGET = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> OVERLOAD = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final List<EntityDataAccessor<Integer>> HEAD_TARGETS = ImmutableList.of(FIRST_HEAD_TARGET, SECOND_HEAD_TARGET, THIRD_HEAD_TARGET);
    private static final EntityDataAccessor<Boolean> LASER_MODE = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> ISCHARGE = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_ACT = SynchedEntityData.defineId(The_Harbinger_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public static final int MODE_CHANGE_COOLDOWN = 300;
    private final float[] xRotHeads = new float[2];
    private final float[] yRotHeads = new float[2];
    private final float[] xRotOHeads = new float[2];
    private final float[] yRotOHeads = new float[2];
    private final int[] nextHeadUpdate = new int[2];
    private final int[] idleHeadUpdates = new int[2];
    public float Laser_Mode_Progress;
    public float prev_Laser_Mode_Progress;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    private final CMBossInfoServer bossEvent = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.RED, true, 4);
    private int mode_change_cooldown = 0;
    private int skill_cooldown = 160;
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = p_31504_ -> p_31504_.attackable() && !p_31504_.getType().builtInRegistryHolder().is(ModTag.TEAM_THE_HARBINGER);
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(20.0).selector(LIVING_ENTITY_SELECTOR);

    public The_Harbinger_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 300;
        this.moveControl = new FlyingMoveControl((Mob)this, 10, false);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Harbinger.healthMultiplier, CMCommonConfig.Harbinger.attackMultiplier);
    }

    protected PathNavigation createNavigation(Level p_186262_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation((Mob)this, p_186262_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEATHLASER_ANIMATION, CHARGE_ANIMATION, DEATH_ANIMATION, LAUNCH_ANIAMATION, MISSILE_FIRE_ANIAMATION, STUN_ANIAMATION, MISSILE_FIRE_FAST_ANIAMATION};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, (Goal)new AwakenGoal());
        this.goalSelector.addGoal(1, (Goal)new DeathLaserGoal(this, DEATHLASER_ANIMATION));
        this.goalSelector.addGoal(1, (Goal)new ChargeGoal(this, CHARGE_ANIMATION));
        this.goalSelector.addGoal(1, (Goal)new LaunchGoal(this, LAUNCH_ANIAMATION));
        this.goalSelector.addGoal(1, (Goal)new MissileLaunchGoal(this, MISSILE_FIRE_ANIAMATION));
        this.goalSelector.addGoal(1, (Goal)new MissileLaunchGoal2(this, MISSILE_FIRE_FAST_ANIAMATION));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<The_Harbinger_Entity>(this, STUN_ANIAMATION));
        this.goalSelector.addGoal(2, (Goal)new RangedAttackGoal((RangedAttackMob)this, 1.0, 40, 20.0f));
        this.goalSelector.addGoal(5, (Goal)new WaterAvoidingRandomFlyingGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(7, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
    }

    public static AttributeSupplier.Builder harbinger() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 390.0).add(Attributes.MOVEMENT_SPEED, (double)0.6f).add(Attributes.ATTACK_DAMAGE, 9.0).add(Attributes.FLYING_SPEED, (double)0.6f).add(Attributes.FOLLOW_RANGE, 40.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.5).add(Attributes.ARMOR, 12.0);
    }

    @Override
    public float DamageCap() {
        return (float)CMCommonConfig.Harbinger.damageCap;
    }

    @Override
    public float NatureRegen() {
        return (float)CMCommonConfig.Harbinger.natureHeal;
    }

    @Override
    public float DpsCap() {
        return (float)CMCommonConfig.Harbinger.dpsCap;
    }

    @Override
    public double RangeLimit() {
        return CMCommonConfig.Harbinger.rangeCap;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation((ServerLevel)this.level(), stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(LASER_MODE, false);
        p_326229_.define(ISCHARGE, false);
        p_326229_.define(IS_ACT, true);
        p_326229_.define(FIRST_HEAD_TARGET, 0);
        p_326229_.define(SECOND_HEAD_TARGET, 0);
        p_326229_.define(THIRD_HEAD_TARGET, 0);
        p_326229_.define(OVERLOAD, 0);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Is_Act", this.getIsAct());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setIsAct(compound.getBooleanOr("Is_Act", false));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity;
        Entity entity1 = source.getEntity();
        if (entity1 instanceof The_Harbinger_Entity) {
            return false;
        }
        int i = 0;
        while (i < this.idleHeadUpdates.length) {
            int n = i++;
            this.idleHeadUpdates[n] = this.idleHeadUpdates[n] + 3;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }
        if (this.getAnimation() != STUN_ANIAMATION && this.getAnimation() != DEATHLASER_ANIMATION && source.is(CMDamageTypes.EMP)) {
            AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this, STUN_ANIAMATION);
        }
        if (this.isPowered() && (entity = source.getDirectEntity()) instanceof AbstractArrow) {
            return false;
        }
        if (this.deactivateProgress > 0.0f && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        return super.hurtOrSimulate(source, damage);
    }

    public boolean canBeSeenAsEnemy() {
        return this.getIsAct() && super.canBeSeenAsEnemy();
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_THE_HARBINGER)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    public void aiStep() {
        Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.6, 1.0);
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        this.prev_Laser_Mode_Progress = this.Laser_Mode_Progress;
        if (this.getIsLaserMode() && this.Laser_Mode_Progress < 30.0f) {
            this.Laser_Mode_Progress += 1.0f;
        }
        if (!this.getIsLaserMode() && this.Laser_Mode_Progress > 0.0f) {
            this.Laser_Mode_Progress -= 1.0f;
        }
        this.prevdeactivateProgress = this.deactivateProgress;
        if (!this.getIsAct() && this.deactivateProgress < 40.0f) {
            this.deactivateProgress = 40.0f;
        }
        if (this.getIsAct() && this.deactivateProgress > 0.0f) {
            this.deactivateProgress -= 1.0f;
        }
        if (this.getIsAct() && this.skill_cooldown > 0) {
            --this.skill_cooldown;
        }
        Entity entity = this.level().getEntity(this.getAlternativeTarget(0));
        if (!this.level().isClientSide() && this.getAlternativeTarget(0) > 0 && this.isAlive() && !this.getIsCharge() && this.getAnimation() != STUN_ANIAMATION && entity != null) {
            double l0;
            double d0 = vec3.y;
            double d = l0 = this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION || this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == LAUNCH_ANIAMATION ? 1.0 : 2.25;
            if (this.getY() < entity.getY() + l0) {
                d0 = Math.max(0.0, d0);
                d0 += 0.3 - d0 * (double)0.6f;
            }
            vec3 = new Vec3(vec3.x, d0, vec3.z);
            Vec3 vec31 = new Vec3(entity.getX() - this.getX(), 0.0, entity.getZ() - this.getZ());
            if (vec31.horizontalDistanceSqr() > 25.0 && (this.getAnimation() != DEATHLASER_ANIMATION || this.getAnimationTick() <= 13) && this.getAnimation() != MISSILE_FIRE_ANIAMATION && this.getAnimation() != MISSILE_FIRE_FAST_ANIAMATION) {
                Vec3 vec32 = vec31.normalize();
                vec3 = vec3.add(vec32.x * 0.3 - vec3.x * 0.6, 0.0, vec32.z * 0.3 - vec3.z * 0.6);
            }
        }
        LivingEntity target = this.getTarget();
        if (this.getIsAct() && this.isAlive() && this.deactivateProgress == 0.0f && target != null && target.isAlive() && this.skill_cooldown <= 0 && (this.Laser_Mode_Progress == 30.0f || this.Laser_Mode_Progress == 0.0f)) {
            if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() >= 3 && this.getRandom().nextFloat() * 100.0f < 3.0f) {
                this.skill_cooldown = 240;
                this.setAnimation(DEATHLASER_ANIMATION);
            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.distanceToSqr((Entity)target) < 64.0 && (this.getRandom().nextFloat() * 100.0f < 4.0f && this.hasLineOfSight((Entity)target) || this.getRandom().nextFloat() * 100.0f < 20.0f && !this.hasLineOfSight((Entity)target))) {
                this.skill_cooldown = 240;
                this.setAnimation(CHARGE_ANIMATION);
            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0f < 3.0f && this.Laser_Mode_Progress == 0.0f) {
                this.skill_cooldown = 240;
                this.setAnimation(LAUNCH_ANIAMATION);
            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0f < 1.5f) {
                this.skill_cooldown = 240;
                Animation missile = this.isPowered() ? MISSILE_FIRE_FAST_ANIAMATION : MISSILE_FIRE_ANIAMATION;
                this.setAnimation(missile);
            }
        }
        this.setDeltaMovement(vec3);
        if (vec3.horizontalDistanceSqr() > 0.05) {
            this.setYRot((float)Mth.atan2((double)vec3.z, (double)vec3.x) * 57.295776f - 90.0f);
        }
        super.aiStep();
        for (int i = 0; i < 2; ++i) {
            this.yRotOHeads[i] = this.yRotHeads[i];
            this.xRotOHeads[i] = this.xRotHeads[i];
        }
        if (this.getAnimation() != CHARGE_ANIMATION && this.getIsCharge()) {
            this.setIsCharge(false);
        }
        if (this.getAnimation() == STUN_ANIAMATION && this.getAnimationTick() == 15) {
            this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.HARBINGER_STUN.get(), SoundSource.HOSTILE, 4.0f, thislevel().getRandom().nextFloat() * 0.2f + 1.0f);
        }
        if (this.getAnimation() == DEATHLASER_ANIMATION && this.getAnimationTick() == 33) {
            this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.DEATH_LASER.get(), SoundSource.HOSTILE, 4.0f, 0.75f);
        }
        if (this.getAnimation() == CHARGE_ANIMATION && this.getAnimationTick() == 24) {
            this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.HARBINGER_CHARGE.get(), SoundSource.HOSTILE, 4.0f, 0.65f);
        }
        if ((this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION) && this.getAnimationTick() == 24) {
            this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.HARBINGER_PREPARE.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
        }
        for (int j = 0; j < 2; ++j) {
            int k = this.getAlternativeTarget(j + 1);
            Entity entity1 = null;
            if (k > 0) {
                entity1 = this.level().getEntity(k);
            }
            if (entity1 != null) {
                double d9 = this.getHeadX(j + 1);
                double d1 = this.getHeadY(j + 1);
                double d3 = this.getHeadZ(j + 1);
                double d4 = entity1.getX() - d9;
                double d5 = entity1.getEyeY() - d1;
                double d6 = entity1.getZ() - d3;
                double d7 = Math.sqrt(d4 * d4 + d6 * d6);
                float f = (float)(Mth.atan2((double)d6, (double)d4) * 57.2957763671875) - 90.0f;
                float f1 = (float)(-(Mth.atan2((double)d5, (double)d7) * 57.2957763671875));
                this.xRotHeads[j] = this.m_31442_(this.xRotHeads[j], f1, 40.0f);
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], f, 10.0f);
                continue;
            }
            this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], this.yBodyRot, 10.0f);
        }
        if (this.level().isClientSide() && this.getIsAct()) {
            double d0 = (double)(this.random.nextFloat() - 0.5f) + this.getDeltaMovement().x;
            double d1 = (double)(this.random.nextFloat() - 0.5f) + this.getDeltaMovement().y;
            double d2 = (double)(this.random.nextFloat() - 0.5f) + this.getDeltaMovement().z;
            double dist = 1.0f + this.random.nextFloat() * 0.2f;
            double d3 = d0 * dist;
            double d4 = d1 * dist;
            double d5 = d2 * dist;
            this.level().addParticle((ParticleOptions)new LightningParticleOptions(255, 51, 0), this.getX() + d0, this.getY() + 2.0, this.getZ() + d2, d3, d4, d5);
            if (entity != null && this.getAnimation() != MISSILE_FIRE_ANIAMATION) {
                float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
                float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
                double theta = (double)this.yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                double vecZ = Math.sin(theta);
                double vec = -1.75;
                double math = 1.35;
                for (int i1 = 0; i1 < 5; ++i1) {
                    float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                    double extraX = 0.2f * Mth.sin((float)((float)(Math.PI + (double)angle)));
                    double extraY = 2.75;
                    double extraZ = 0.2f * Mth.cos((float)angle);
                    this.level().addParticle((ParticleOptions)ParticleTypes.SMOKE, this.getX() + vec * vecX + extraX + (double)f * math, this.getY() + extraY, this.getZ() + vec * vecZ + extraZ + (double)f1 * math, 0.0, -0.07, 0.0);
                    this.level().addParticle((ParticleOptions)ParticleTypes.SMOKE, this.getX() + vec * vecX + extraX + (double)f * -math, this.getY() + extraY, this.getZ() + vec * vecZ + extraZ + (double)f1 * -math, 0.0, -0.07, 0.0);
                }
            }
            if (this.getAnimation() == STUN_ANIAMATION) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle((ParticleOptions)ParticleTypes.LARGE_SMOKE, this.getRandomX(1.5), this.getRandomY(), this.getRandomZ(1.5), 0.0, 0.0, 0.0);
                }
            }
        }
    }

    private void blockbreak() {
        if (this.getIsCharge()) {
            if (!this.level().isClientSide() && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                boolean flag = false;
                AABB aabb = this.getBoundingBox().inflate(1.5, 0.2, 1.5);
                for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)aabb.minY), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.HARBINGER_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
                    if (this.random.nextInt(3) == 0 && !blockstate.hasBlockEntity()) {
                        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)blockpos.getX() + 0.5, (double)blockpos.getY() + 0.5, (double)blockpos.getZ() + 0.5, blockstate, 20);
                        flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                        fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, 0.2 + this.getRandom().nextGaussian() * 0.15, (-1.2 + this.random.nextDouble()) / 3.0)));
                        this.level().addFreshEntity((Entity)fallingBlockEntity);
                        continue;
                    }
                    flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                }
                if (flag) {
                    this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                }
            }
            if (this.tickCount % 4 == 0) {
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.5))) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)Lentity) || Lentity instanceof The_Harbinger_Entity || Lentity == this || !(flag = Lentity.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float)this.random.nextInt(5)) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), (double)(Lentity.getMaxHealth() * (float)CMCommonConfig.Harbinger.ChargeHpDamage))))) || !Lentity.onGround()) continue;
                    double d0 = Lentity.getX() - this.getX();
                    double d1 = Lentity.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    float f = 1.5f;
                    Lentity.push(d0 / d2 * (double)f, 0.5, d1 / d2 * (double)f);
                }
            }
        }
    }

    private void destoryblock2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        boolean flag = false;
        if (this.getAnimation() == NO_ANIMATION && !this.getIsCharge() && !this.level().isClientSide() && this.blockBreakCounter == 0 && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
            AABB aabb = this.getBoundingBox().inflate(0.2);
            for (BlockPos pos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)aabb.minY), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(pos);
                if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), pos, (Entity)this) || blockstate.is(ModTag.HARBINGER_IMMUNE)) continue;
                if (this.random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, blockstate, 20);
                    flag = this.level().destroyBlock(pos, false, (Entity)this) || flag;
                    fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, 0.2 + this.getRandom().nextGaussian() * 0.15, (-1.2 + this.random.nextDouble()) / 3.0)));
                    this.level().addFreshEntity((Entity)fallingBlockEntity);
                    continue;
                }
                flag = this.level().destroyBlock(pos, false, (Entity)this) || flag;
                this.setDeltaMovement(this.getDeltaMovement().multiply((double)0.6f, 1.0, (double)0.6f));
            }
        }
        if (flag) {
            this.blockBreakCounter = 20;
            this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
        }
    }

    private void destroyBlock() {
        if (this.getAnimation() != STUN_ANIAMATION && !this.level().isClientSide() && this.destroyBlocksTick > 0) {
            --this.destroyBlocksTick;
            if (this.destroyBlocksTick == 0 && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                int j1 = Mth.floor((double)this.getY());
                int i2 = Mth.floor((double)this.getX());
                int j2 = Mth.floor((double)this.getZ());
                boolean flag = false;
                for (int j = -1; j <= 1; ++j) {
                    for (int k2 = -1; k2 <= 1; ++k2) {
                        for (int k = 0; k <= 3; ++k) {
                            int l2 = i2 + j;
                            int l = j1 + k;
                            int i1 = j2 + k2;
                            BlockPos blockpos = new BlockPos(l2, l, i1);
                            BlockState blockstate = this.level().getBlockState(blockpos);
                            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.HARBINGER_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
                            if (this.random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)blockpos.getX() + 0.5, (double)blockpos.getY() + 0.5, (double)blockpos.getZ() + 0.5, blockstate, 20);
                                flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                                fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, 0.2 + this.getRandom().nextGaussian() * 0.15, (-1.2 + this.random.nextDouble()) / 3.0)));
                                this.level().addFreshEntity((Entity)fallingBlockEntity);
                                continue;
                            }
                            flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                        }
                    }
                }
                if (flag) {
                    this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                }
            }
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (item == Items.NETHER_STAR && !this.getIsAct()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            this.setIsAct(true);
            this.setHomePos(GlobalPos.of((ResourceKey)this.level().dimension(), (BlockPos)this.blockPosition()));
            this.heal(this.getMaxHealth());
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    protected void customServerAiStep() {
        if (this.getIsAct()) {
            if (this.deactivateProgress > 0.0f) {
                float k1 = this.deactivateProgress - 1.0f;
                if (k1 <= 0.0f && !this.isSilent()) {
                    this.level().globalLevelEvent(1023, this.blockPosition(), 0);
                }
            } else {
                super.customServerAiStep();
                for (int i = 1; i < 3; ++i) {
                    if (this.tickCount < this.nextHeadUpdate[i - 1]) continue;
                    this.nextHeadUpdate[i - 1] = this.tickCount + 10 + this.random.nextInt(10);
                    int l1 = this.getAlternativeTarget(i);
                    if (l1 > 0) {
                        LivingEntity livingentity = (LivingEntity)this.level().getEntity(l1);
                        if (livingentity != null && this.canAttack(livingentity) && !(this.distanceToSqr((Entity)livingentity) > 1600.0) && this.hasLineOfSight((Entity)livingentity) && (this.Laser_Mode_Progress == 30.0f || this.Laser_Mode_Progress == 0.0f) && this.getAnimation() == NO_ANIMATION) {
                            this.performRangedAttack(i + 1, livingentity);
                            int f = this.getIsLaserMode() ? 15 + this.random.nextInt(5) : 30 + this.random.nextInt(20);
                            this.nextHeadUpdate[i - 1] = this.tickCount + f;
                            this.idleHeadUpdates[i - 1] = 0;
                            continue;
                        }
                        this.setAlternativeTarget(i, 0);
                        continue;
                    }
                    List list = this.level().getNearbyEntities(LivingEntity.class, TARGETING_CONDITIONS, (LivingEntity)this, this.getBoundingBox().inflate(20.0, 8.0, 20.0));
                    if (list.isEmpty()) continue;
                    LivingEntity livingentity1 = (LivingEntity)list.get(this.random.nextInt(list.size()));
                    this.setAlternativeTarget(i, livingentity1.getId());
                }
                this.blockbreak();
                this.destroyBlock();
                if (this.getTarget() != null) {
                    this.destoryblock2();
                }
                if (this.mode_change_cooldown < 300) {
                    ++this.mode_change_cooldown;
                } else if (this.getAnimation() == NO_ANIMATION) {
                    this.setIsLaserMode(!this.getIsLaserMode());
                    this.playSound((SoundEvent)ModSounds.HARBINGER_MODE_CHANGE.get(), 3.0f, 1.0f);
                    this.mode_change_cooldown = this.random.nextInt(50);
                }
                if (this.getTarget() != null) {
                    this.setAlternativeTarget(0, this.getTarget().getId());
                } else {
                    this.setAlternativeTarget(0, 0);
                }
                if (this.tickCount % 20 == 0) {
                    this.heal((float)CMCommonConfig.Harbinger.AutoHeal);
                }
            }
        } else if (this.tickCount % 20 == 0) {
            this.heal(50.0f * (float)CMCommonConfig.Harbinger.healthMultiplier);
        }
    }

    protected SoundEvent getAmbientSound() {
        return this.getIsAct() ? (SoundEvent)ModSounds.HARBINGER_IDLE.get() : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.HARBINGER_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.HARBINGER_HURT.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return (SoundEvent)ModSounds.HARBINGER_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && this.getIsAct();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        this.move(MoverType.SELF, new Vec3(0.0, (double)0.15f, 0.0));
        this.setYRot(this.yRotO);
        this.yBodyRot = this.getYRot();
        this.yHeadRot = this.getYRot();
        if (this.deathTime == 123 && !this.level().isClientSide()) {
            this.level().explode((Entity)this, this.getX(), this.getEyeY(), this.getZ(), 7.0f, false, Level.ExplosionInteraction.MOB);
        }
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        ServerLevel serverLevel;
        MinecraftServer server;
        ServerLevel targetLevel;
        Level level;
        if (CMCommonConfig.Harbinger.respawner && !this.level().isClientSide() && this.getHomePos() != null && (level = this.level()) instanceof ServerLevel && (targetLevel = (server = (serverLevel = (ServerLevel)level).getServer()).getLevel(this.getHomePos().dimension())) != null) {
            BlockPos targetPos = this.getHomePos().pos();
            BlockState blockState = ((Block)ModBlocks.BOSS_RESPAWNER.get()).defaultBlockState();
            targetLevel.setBlock(targetPos, blockState, 2);
            BlockEntity blockEntity = targetLevel.getBlockEntity(targetPos);
            if (blockEntity instanceof Boss_Respawn_Spawner_Block_Entity) {
                Boss_Respawn_Spawner_Block_Entity spawnerBlockEntity = (Boss_Respawn_Spawner_Block_Entity)blockEntity;
                spawnerBlockEntity.setEntityId((EntityType)ModEntities.THE_HARBINGER.get());
                spawnerBlockEntity.setTheItem(((Item)ModItems.MECH_EYE.get()).getDefaultInstance());
            }
        }
    }

    private double getHeadX(int head) {
        if (head <= 0) {
            return this.getX();
        }
        float f = (this.yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180);
        float f1 = Mth.cos((float)f);
        double f2 = this.getIsLaserMode() ? 1.65 : 1.5;
        return this.getX() + (double)f1 * f2;
    }

    private double getHeadY(int head) {
        return head <= 0 ? this.getY() + 3.0 : this.getY() + 2.6;
    }

    private double getHeadZ(int head) {
        if (head <= 0) {
            return this.getZ();
        }
        float f = (this.yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180);
        float f1 = Mth.sin((float)f);
        double f2 = this.getIsLaserMode() ? 1.65 : 1.5;
        return this.getZ() + (double)f1 * f2;
    }

    private float m_31442_(float p_31443_, float p_31444_, float p_31445_) {
        float f = Mth.wrapDegrees((float)(p_31444_ - p_31443_));
        if (f > p_31445_) {
            f = p_31445_;
        }
        if (f < -p_31445_) {
            f = -p_31445_;
        }
        return p_31443_ + f;
    }

    private void performRangedAttack(int head, LivingEntity target) {
        this.performRangedAttack(head, target.getX(), target.getY() + (double)target.getEyeHeight() * 0.5, target.getZ());
    }

    private void performRangedAttack(int head, double targetX, double targetY, double targetZ) {
        double d0 = this.getHeadX(head);
        double d1 = this.getHeadY(head);
        double d2 = this.getHeadZ(head);
        double d3 = targetX - d0;
        double d4 = targetY - d1;
        double d5 = targetZ - d2;
        Vec3 vec3 = new Vec3(d3, d4, d5);
        if (this.getIsLaserMode()) {
            if (!this.isSilent()) {
                this.playSound((SoundEvent)ModSounds.HARBINGER_LASER.get(), 1.0f, 1.0f);
            }
            Laser_Beam_Entity laser = new Laser_Beam_Entity((LivingEntity)this, vec3.normalize(), this.level(), (float)CMCommonConfig.Harbinger.Laserdamage);
            float yRot = (float)(Mth.atan2((double)vec3.z, (double)vec3.x) * 57.29577951308232) + 90.0f;
            float xRot = (float)(-(Mth.atan2((double)vec3.y, (double)Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * 57.29577951308232));
            laser.setYRot(yRot);
            laser.setXRot(xRot);
            laser.setPosRaw(d0, d1, d2);
            this.level().addFreshEntity((Entity)laser);
        } else {
            if (!this.isSilent()) {
                this.playSound((SoundEvent)ModSounds.ROCKET_LAUNCH.get(), 1.0f, 0.8f);
            }
            Wither_Missile_Entity witherskull = new Wither_Missile_Entity((LivingEntity)this, vec3.normalize(), this.level(), (float)CMCommonConfig.Harbinger.WitherMissiledamage);
            witherskull.setPosRaw(d0, d1, d2);
            this.level().addFreshEntity((Entity)witherskull);
        }
    }

    public void performRangedAttack(LivingEntity p_31468_, float p_31469_) {
        this.performRangedAttack(0, p_31468_);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    public float getHeadYRot(int head) {
        return this.yRotHeads[head];
    }

    public float getHeadXRot(int head) {
        return this.xRotHeads[head];
    }

    public int getAlternativeTarget(int head) {
        return (Integer)this.entityData.get(HEAD_TARGETS.get(head));
    }

    public void setAlternativeTarget(int targetOffset, int newId) {
        this.entityData.set(HEAD_TARGETS.get(targetOffset), newId);
    }

    public void setIsLaserMode(boolean isLaserMode) {
        this.entityData.set(LASER_MODE, isLaserMode);
    }

    public boolean getIsLaserMode() {
        return (Boolean)this.entityData.get(LASER_MODE);
    }

    public void setIsAct(boolean isAct) {
        this.entityData.set(IS_ACT, isAct);
        this.bossEvent.setVisible(isAct);
    }

    public boolean getIsAct() {
        return (Boolean)this.entityData.get(IS_ACT);
    }

    public void setIsCharge(boolean isCharge) {
        this.entityData.set(ISCHARGE, isCharge);
    }

    public boolean getIsCharge() {
        return (Boolean)this.entityData.get(ISCHARGE);
    }

    public void setOverload(int Overload) {
        this.entityData.set(OVERLOAD, Overload);
    }

    public int getOverload() {
        return (Integer)this.entityData.get(OVERLOAD);
    }

    public boolean isPowered() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public boolean canChangeDimensions() {
        return false;
    }

    @Override
    @Nullable
    public Animation getDeathAnimation() {
        return DEATH_ANIMATION;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance p_31495_) {
        return p_31495_.getEffect() != MobEffects.MOVEMENT_SLOWDOWN && p_31495_.getEffect() != MobEffects.POISON && p_31495_.getEffect() != MobEffects.WITHER && p_31495_.getEffect() != MobEffects.WEAKNESS && p_31495_.getEffect() != MobEffects.LEVITATION && super.canBeAffected(p_31495_);
    }

    public BossEvent.BossBarColor bossBarColor() {
        return BossEvent.BossBarColor.PURPLE;
    }

    class AwakenGoal
    extends Goal {
        public AwakenGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return The_Harbinger_Entity.this.deactivateProgress > 0.0f;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            The_Harbinger_Entity.this.setDeltaMovement(0.0, The_Harbinger_Entity.this.getDeltaMovement().y, 0.0);
        }
    }

    static class DeathLaserGoal
    extends SimpleAnimationGoal<The_Harbinger_Entity> {
        public DeathLaserGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            super.start();
            ((The_Harbinger_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.HARBINGER_DEATHLASER_PREPARE.get(), SoundSource.HOSTILE, 8.0f, 1.2f);
            ((The_Harbinger_Entity)this.entity).setOverload(0);
        }

        public void tick() {
            LivingEntity target = ((The_Harbinger_Entity)this.entity).getTarget();
            ((The_Harbinger_Entity)this.entity).setDeltaMovement(0.0, ((The_Harbinger_Entity)this.entity).getDeltaMovement().y, 0.0);
            if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 18 && !((The_Harbinger_Entity)this.entity).level().isClientSide()) {
                Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity((EntityType<? extends Death_Laser_Beam_Entity>)((EntityType)ModEntities.DEATH_LASER_BEAM.get()), ((The_Harbinger_Entity)this.entity).level(), (LivingEntity)this.entity, ((The_Harbinger_Entity)this.entity).getX(), ((The_Harbinger_Entity)this.entity).getY() + 2.9, ((The_Harbinger_Entity)this.entity).getZ(), (float)((double)(((The_Harbinger_Entity)this.entity).yHeadRot + 90.0f) * Math.PI / 180.0), (float)((double)(-((The_Harbinger_Entity)this.entity).getXRot()) * Math.PI / 180.0), 60, (float)CMCommonConfig.Harbinger.DeathLaserdamage, (float)CMCommonConfig.Harbinger.DeathLaserHpdamage);
                if (((The_Harbinger_Entity)this.entity).isPowered()) {
                    DeathBeam.setFire(true);
                }
                ((The_Harbinger_Entity)this.entity).level().addFreshEntity((Entity)DeathBeam);
            }
            if (((The_Harbinger_Entity)this.entity).getAnimationTick() >= 35 && target != null) {
                ((The_Harbinger_Entity)this.entity).getLookControl().setLookAt(target.getX(), target.getY() + (double)(target.getBbHeight() / 2.0f), target.getZ(), 6.0f, 90.0f);
                ((The_Harbinger_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
            }
        }
    }

    static class ChargeGoal
    extends SimpleAnimationGoal<The_Harbinger_Entity> {
        public ChargeGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            super.start();
            ((The_Harbinger_Entity)this.entity).setOverload(((The_Harbinger_Entity)this.entity).getOverload() + 1);
            ((The_Harbinger_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.HARBINGER_CHARGE_PREPARE.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
        }

        public void tick() {
            LivingEntity target = ((The_Harbinger_Entity)this.entity).getTarget();
            if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 24) {
                ((The_Harbinger_Entity)this.entity).setIsCharge(true);
            }
            if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 36) {
                ((The_Harbinger_Entity)this.entity).setIsCharge(false);
            }
            if (target != null) {
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() < 24) {
                    ((The_Harbinger_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                    ((The_Harbinger_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                }
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 24) {
                    Vec3 rot = target.position().subtract(0.0, 2.0, 0.0).add(((The_Harbinger_Entity)this.entity).position().multiply(-1.0, -1.0, -1.0)).normalize();
                    ((The_Harbinger_Entity)this.entity).setDeltaMovement(rot.multiply(4.0, 5.0, 4.0));
                }
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 45) {
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((The_Harbinger_Entity)this.entity), CHARGE_ANIMATION);
                }
            }
        }

        public void stop() {
            super.stop();
            LivingEntity target = ((The_Harbinger_Entity)this.entity).getTarget();
            if (((The_Harbinger_Entity)this.entity).getOverload() < 3 && ((The_Harbinger_Entity)this.entity).isPowered() && target != null && ((The_Harbinger_Entity)this.entity).random.nextInt(2) == 0) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((The_Harbinger_Entity)this.entity), CHARGE_ANIMATION);
            }
        }
    }

    static class LaunchGoal
    extends SimpleAnimationGoal<The_Harbinger_Entity> {
        public LaunchGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            super.start();
            ((The_Harbinger_Entity)this.entity).setOverload(((The_Harbinger_Entity)this.entity).getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = ((The_Harbinger_Entity)this.entity).getTarget();
            if (target != null) {
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 13) {
                    this.launch(2, target);
                }
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 19) {
                    this.launch(1, target);
                }
            }
        }

        private void launch(int head, LivingEntity p_31459_) {
            this.launch(head, p_31459_.getX(), p_31459_.getY() + (double)p_31459_.getEyeHeight() * 0.5, p_31459_.getZ());
        }

        private void launch(int head, double p_31450_, double p_31451_, double p_31452_) {
            if (!((The_Harbinger_Entity)this.entity).isSilent()) {
                ((The_Harbinger_Entity)this.entity).playSound((SoundEvent)ModSounds.ROCKET_LAUNCH.get(), 1.0f, 1.0f);
            }
            double d0 = ((The_Harbinger_Entity)this.entity).getHeadX(head);
            double d1 = ((The_Harbinger_Entity)this.entity).getHeadY(head);
            double d2 = ((The_Harbinger_Entity)this.entity).getHeadZ(head);
            double d3 = p_31450_ - d0;
            double d4 = p_31451_ - d1;
            double d5 = p_31452_ - d2;
            double d6 = Mth.sqrt((float)((float)(d3 * d3 + d5 * d5)));
            int b = ((The_Harbinger_Entity)this.entity).isPowered() ? 7 : 5;
            for (int i = 0; i < b; ++i) {
                Wither_Howitzer_Entity lava = new Wither_Howitzer_Entity((EntityType<Wither_Howitzer_Entity>)((EntityType)ModEntities.WITHER_HOWITZER.get()), ((The_Harbinger_Entity)this.entity).level(), (LivingEntity)this.entity);
                lava.setPosRaw(d0, d1, d2);
                lava.setRadius(3.0f);
                lava.shoot(d3, d4 + d6 * 6.0, d5, 0.6f, 60.0f);
                ((The_Harbinger_Entity)this.entity).level().addFreshEntity((Entity)lava);
            }
        }
    }

    static class MissileLaunchGoal
    extends SimpleAnimationGoal<The_Harbinger_Entity> {
        public MissileLaunchGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            super.start();
            ((The_Harbinger_Entity)this.entity).setOverload(((The_Harbinger_Entity)this.entity).getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = ((The_Harbinger_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Harbinger_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                ((The_Harbinger_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 80 || ((The_Harbinger_Entity)this.entity).getAnimationTick() == 84 || ((The_Harbinger_Entity)this.entity).getAnimationTick() == 88) {
                    this.mlaunch(2, target);
                }
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 98 || ((The_Harbinger_Entity)this.entity).getAnimationTick() == 102 || ((The_Harbinger_Entity)this.entity).getAnimationTick() == 106) {
                    this.mlaunch(1, target);
                }
            }
        }

        private void mlaunch(int head, LivingEntity target) {
            if (!((The_Harbinger_Entity)this.entity).isSilent()) {
                ((The_Harbinger_Entity)this.entity).playSound((SoundEvent)ModSounds.ROCKET_LAUNCH.get(), 1.0f, 1.0f);
            }
            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);
            double d3 = target.getX() - d0;
            double d4 = target.getY() - d1;
            double d5 = target.getZ() - d2;
            Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
            Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity((LivingEntity)this.entity, vec3, ((The_Harbinger_Entity)this.entity).level(), (float)CMCommonConfig.Harbinger.WitherMissiledamage, target);
            laserBeam.setPosRaw(d0, d1, d2);
            ((The_Harbinger_Entity)this.entity).level().addFreshEntity((Entity)laserBeam);
        }

        private double getLauncherX(int head) {
            if (head <= 0) {
                return ((The_Harbinger_Entity)this.entity).getX();
            }
            double theta = (double)((The_Harbinger_Entity)this.entity).yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            float f = (((The_Harbinger_Entity)this.entity).yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180);
            float f1 = Mth.cos((float)f);
            return ((The_Harbinger_Entity)this.entity).getX() + (double)f1 * 1.25 + vecX * 1.35;
        }

        private double getLauncherY(int head) {
            return head <= 0 ? ((The_Harbinger_Entity)this.entity).getY() + 3.0 : ((The_Harbinger_Entity)this.entity).getY() + 3.8;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return ((The_Harbinger_Entity)this.entity).getZ();
            }
            double theta = (double)((The_Harbinger_Entity)this.entity).yBodyRot * (Math.PI / 180);
            double vecZ = Math.sin(theta += 1.5707963267948966);
            float f = (((The_Harbinger_Entity)this.entity).yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180);
            float f1 = Mth.sin((float)f);
            return ((The_Harbinger_Entity)this.entity).getZ() + (double)f1 * 1.25 + vecZ * 1.35;
        }
    }

    static class MissileLaunchGoal2
    extends SimpleAnimationGoal<The_Harbinger_Entity> {
        public MissileLaunchGoal2(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            super.start();
            ((The_Harbinger_Entity)this.entity).setOverload(((The_Harbinger_Entity)this.entity).getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = ((The_Harbinger_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Harbinger_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                ((The_Harbinger_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                if (((The_Harbinger_Entity)this.entity).getAnimationTick() == 71 || ((The_Harbinger_Entity)this.entity).getAnimationTick() == 75 || ((The_Harbinger_Entity)this.entity).getAnimationTick() == 79) {
                    this.mlaunch(2, target);
                    this.mlaunch(1, target);
                }
            }
        }

        private void mlaunch(int head, LivingEntity target) {
            if (!((The_Harbinger_Entity)this.entity).isSilent()) {
                ((The_Harbinger_Entity)this.entity).playSound((SoundEvent)ModSounds.ROCKET_LAUNCH.get(), 1.0f, 1.0f);
            }
            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);
            double d3 = target.getX() - d0;
            double d4 = target.getY() - d1;
            double d5 = target.getZ() - d2;
            Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
            Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity((LivingEntity)this.entity, vec3, ((The_Harbinger_Entity)this.entity).level(), (float)CMCommonConfig.Harbinger.WitherMissiledamage, target);
            laserBeam.setPosRaw(d0, d1, d2);
            ((The_Harbinger_Entity)this.entity).level().addFreshEntity((Entity)laserBeam);
        }

        private double getLauncherX(int head) {
            if (head <= 0) {
                return ((The_Harbinger_Entity)this.entity).getX();
            }
            double theta = (double)((The_Harbinger_Entity)this.entity).yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            float f = (((The_Harbinger_Entity)this.entity).yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180);
            float f1 = Mth.cos((float)f);
            return ((The_Harbinger_Entity)this.entity).getX() + (double)f1 * 1.25 + vecX * 1.35;
        }

        private double getLauncherY(int head) {
            return head <= 0 ? ((The_Harbinger_Entity)this.entity).getY() + 3.0 : ((The_Harbinger_Entity)this.entity).getY() + 3.8;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return ((The_Harbinger_Entity)this.entity).getZ();
            }
            double theta = (double)((The_Harbinger_Entity)this.entity).yBodyRot * (Math.PI / 180);
            double vecZ = Math.sin(theta += 1.5707963267948966);
            float f = (((The_Harbinger_Entity)this.entity).yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180);
            float f1 = Mth.sin((float)f);
            return ((The_Harbinger_Entity)this.entity).getZ() + (double)f1 * 1.25 + vecZ * 1.35;
        }
    }
}

