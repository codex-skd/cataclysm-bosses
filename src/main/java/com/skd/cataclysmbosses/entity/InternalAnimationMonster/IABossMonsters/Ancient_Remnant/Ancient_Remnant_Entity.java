/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.LegSolver
 *  com.skd.nautilusapi.server.animation.LegSolver$Leg
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
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
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.BossEvent$BossBarColor
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant;

import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.client.particle.Options.RoarParticleOptions;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.HurtByNearestTargetGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.skd.cataclysmbosses.entity.effect.Cm_Falling_Block_Entity;
import com.skd.cataclysmbosses.entity.effect.Sandstorm_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.etc.CMBossInfoServer;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.projectile.Ancient_Desert_Stele_Entity;
import com.skd.cataclysmbosses.entity.projectile.EarthQuake_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.EntityUtil;
import com.skd.nautilusapi.server.animation.LegSolver;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Ancient_Remnant_Entity
extends IABoss_monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sandstormroarAnimationState = new AnimationState();
    public AnimationState phaseroarAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakenAnimationState = new AnimationState();
    public AnimationState threetailhitAnimationState = new AnimationState();
    public AnimationState rightstompAnimationState = new AnimationState();
    public AnimationState leftstompAnimationState = new AnimationState();
    public AnimationState rightDoubleStompAnimationState = new AnimationState();
    public AnimationState leftDoubleStompAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState rightbiteAnimationState = new AnimationState();
    public AnimationState chargeprepareAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargestunAnimationState = new AnimationState();
    public AnimationState groundtailAnimationState = new AnimationState();
    public AnimationState tailswingAnimationState = new AnimationState();
    public AnimationState monolithAnimationState = new AnimationState();
    private static final EntityDataAccessor<Integer> RAGE = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> NECKLACE = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> POWER = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRASH = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public final LegSolver legSolver = new LegSolver(new LegSolver.Leg[]{new LegSolver.Leg(0.0f, 0.75f, 4.0f, false), new LegSolver.Leg(0.0f, -0.75f, 4.0f, false)});
    private AttackMode mode = AttackMode.CIRCLE;
    private int hunting_cooldown = 160;
    private int roar_cooldown = 0;
    private int monoltih_cooldown = 0;
    private int earthquake_cooldown = 0;
    private int stomp_cooldown = 0;
    private boolean hit = false;
    public static final int ROAR_COOLDOWN = 500;
    public static final int MONOLITH2_COOLDOWN = 200;
    public static final int EARTHQUAKE_COOLDOWN = 160;
    public static final int STOMP_COOLDOWN = 110;
    private final CMBossInfoServer bossEvent = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.WHITE, false, 7);
    private final CMBossInfoServer bossEvent2 = new CMBossInfoServer((Component)Component.translatable((String)"entity.cataclysm.rage_meter"), BossEvent.BossBarColor.WHITE, false, 8);
    public int frame;

    public Ancient_Remnant_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.AncientRemnant.healthMultiplier, CMCommonConfig.AncientRemnant.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, LivingEntity.class, 120, true, true, ModEntities.buildPredicateFromTag(ModTag.ANCIENT_REMNANT_TARGET)));
        this.targetSelector.addGoal(2, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(5, (Goal)new RemnantAttackModeGoal(this));
        this.goalSelector.addGoal(3, (Goal)new RemnantAttackGoal(this, 0, 4, 0, 70, 29, 6.0f, 10.0f));
        this.goalSelector.addGoal(0, (Goal)new RemnantDoNothingGoal());
        this.goalSelector.addGoal(0, (Goal)new RemnantAwakenGoal(this, 2, 2, 0, 80, 0));
        this.goalSelector.addGoal(0, (Goal)new RemnantPhaseChangeGoal(this, 0, 7, 0, 60, 13));
        this.goalSelector.addGoal(3, (Goal)new RemnantStompGoal(this, 0, 8, 9, 13, 14, 0, 50, 66, 26, 20.0, 36.0f));
        this.goalSelector.addGoal(3, (Goal)new RemnantAttackGoal(this, this, 0, 6, 0, 60, 11, 32.0f, 18.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.roar_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                this.entity.roar_cooldown = 500;
            }
        });
        this.goalSelector.addGoal(3, (Goal)new RemnantMonolithAttackGoal(this, 0, 17, 0, 70, 20, 10.0f, 12.0f));
        this.goalSelector.addGoal(3, (Goal)new RemnantChargeGoal(this, 0, 10, 11, 70, 66, 32.0f, 60.0f));
        this.goalSelector.addGoal(2, (Goal)new InternalStateGoal(this, 11, 11, 12, 60, 0){

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && !Ancient_Remnant_Entity.this.getCrash();
            }

            @Override
            public void stop() {
                super.stop();
                Ancient_Remnant_Entity.this.setCrash(false);
            }

            @Override
            public void tick() {
                if (this.entity.onGround()) {
                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * ((float)Math.PI / 180);
                    Vec3 vector3d1 = new Vec3((double)(-Mth.sin((float)f)), this.entity.getDeltaMovement().y, (double)Mth.cos((float)f)).scale(1.0).add(vector3d.scale(0.5));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 12, 12, 0, 120, 0));
        this.goalSelector.addGoal(3, (Goal)new RemnantAttackGoal(this, this, 0, 15, 0, 110, 85, 12.0f, 10.0f){

            @Override
            public boolean canUse() {
                LivingEntity target = this.entity.getTarget();
                return super.canUse() && target != null && target.onGround() && this.entity.earthquake_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                this.entity.earthquake_cooldown = 160;
            }
        });
        this.goalSelector.addGoal(3, (Goal)new RemnantAttackGoal(this, this, 0, 16, 0, 58, 13, 7.5f, 10.0f){

            @Override
            public boolean canUse() {
                LivingEntity target = this.entity.getTarget();
                return super.canUse() && target != null && target.getY() < this.entity.getY() + 1.0;
            }
        });
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    public static AttributeSupplier.Builder maledictus() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 70.0).add(Attributes.MOVEMENT_SPEED, (double)0.33f).add(Attributes.ATTACK_DAMAGE, 25.0).add(Attributes.MAX_HEALTH, 450.0).add(Attributes.ARMOR, 12.0).add(Attributes.ARMOR_TOUGHNESS, 4.0).add(Attributes.STEP_HEIGHT, 1.5).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, EntitySpawnReason p_29680_, @Nullable SpawnGroupData p_29681_) {
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAttackState() == 7 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (this.getAttackState() != 12 && entity instanceof AbstractArrow) {
            return false;
        }
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        return super.hurtOrSimulate(source, damage);
    }

    @Override
    public float DamageCap() {
        return (float)CMCommonConfig.AncientRemnant.damageCap;
    }

    @Override
    public float NatureRegen() {
        return (float)CMCommonConfig.AncientRemnant.natureHeal;
    }

    @Override
    public float DpsCap() {
        return (float)CMCommonConfig.AncientRemnant.dpsCap;
    }

    @Override
    public double RangeLimit() {
        return (float)CMCommonConfig.AncientRemnant.rangeCap;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(RAGE, 0);
        p_326229_.define(NECKLACE, true);
        p_326229_.define(POWER, false);
        p_326229_.define(CRASH, false);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2 || !this.getNecklace();
    }

    public void setNecklace(boolean necklace) {
        this.entityData.set(NECKLACE, necklace);
        this.bossEvent.setVisible(necklace);
        this.bossEvent2.setVisible(necklace);
    }

    public boolean getNecklace() {
        return (Boolean)this.entityData.get(NECKLACE);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("has_necklace", this.getNecklace());
        compound.putInt("Rage", this.getRage());
        compound.putBoolean("Power", this.getIsPower());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setNecklace(compound.getBooleanOr("has_necklace", false));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
        this.setRage(compound.getIntOr("Rage", 0));
        this.setIsPower(compound.getBooleanOr("Power", false));
    }

    public void setRage(int isAnger) {
        this.entityData.set(RAGE, isAnger);
    }

    public int getRage() {
        return (Integer)this.entityData.get(RAGE);
    }

    public void setCrash(boolean isPower) {
        this.entityData.set(CRASH, isPower);
    }

    public boolean getCrash() {
        return (Boolean)this.entityData.get(CRASH);
    }

    public void setIsPower(boolean isPower) {
        this.entityData.set(POWER, isPower);
    }

    public boolean getIsPower() {
        return (Boolean)this.entityData.get(POWER);
    }

    public boolean canStandOnFluid(FluidState p_204067_) {
        return p_204067_.is(FluidTags.WATER);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    private void floatRemnant() {
        if (this.isInWater()) {
            CollisionContext collisioncontext = CollisionContext.of((Entity)this);
            if (collisioncontext.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.WATER)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5).add(0.0, 0.05, 0.0));
            }
        }
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "awaken") {
            return this.awakenAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "three_tail_hit") {
            return this.threetailhitAnimationState;
        }
        if (input == "right_bite") {
            return this.rightbiteAnimationState;
        }
        if (input == "sandstorm_roar") {
            return this.sandstormroarAnimationState;
        }
        if (input == "charge") {
            return this.chargeAnimationState;
        }
        if (input == "charge_prepare") {
            return this.chargeprepareAnimationState;
        }
        if (input == "phase_roar") {
            return this.phaseroarAnimationState;
        }
        if (input == "right_stomp") {
            return this.rightstompAnimationState;
        }
        if (input == "left_stomp") {
            return this.leftstompAnimationState;
        }
        if (input == "charge_stun") {
            return this.chargestunAnimationState;
        }
        if (input == "right_double_stomp") {
            return this.rightDoubleStompAnimationState;
        }
        if (input == "left_double_stomp") {
            return this.leftDoubleStompAnimationState;
        }
        if (input == "ground_tail") {
            return this.groundtailAnimationState;
        }
        if (input == "tail_swing") {
            return this.tailswingAnimationState;
        }
        if (input == "monolith") {
            return this.monolithAnimationState;
        }
        return new AnimationState();
    }

    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                case 0: {
                    this.stopAllAnimationStates();
                    break;
                }
                case 1: {
                    this.stopAllAnimationStates();
                    this.sleepAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.awakenAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.rightbiteAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.threetailhitAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.sandstormroarAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.phaseroarAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 8: {
                    this.stopAllAnimationStates();
                    this.rightstompAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 9: {
                    this.stopAllAnimationStates();
                    this.leftstompAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 10: {
                    this.stopAllAnimationStates();
                    this.chargeprepareAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 11: {
                    this.stopAllAnimationStates();
                    this.chargeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 12: {
                    this.stopAllAnimationStates();
                    this.chargestunAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 13: {
                    this.stopAllAnimationStates();
                    this.rightDoubleStompAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 14: {
                    this.stopAllAnimationStates();
                    this.leftDoubleStompAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 15: {
                    this.stopAllAnimationStates();
                    this.groundtailAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 16: {
                    this.stopAllAnimationStates();
                    this.tailswingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 17: {
                    this.stopAllAnimationStates();
                    this.monolithAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.deathAnimationState.stop();
        this.sleepAnimationState.stop();
        this.awakenAnimationState.stop();
        this.rightbiteAnimationState.stop();
        this.threetailhitAnimationState.stop();
        this.sandstormroarAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargestunAnimationState.stop();
        this.phaseroarAnimationState.stop();
        this.rightstompAnimationState.stop();
        this.leftstompAnimationState.stop();
        this.chargeprepareAnimationState.stop();
        this.rightDoubleStompAnimationState.stop();
        this.leftDoubleStompAnimationState.stop();
        this.groundtailAnimationState.stop();
        this.monolithAnimationState.stop();
        this.tailswingAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    @Override
    public int deathtimer() {
        return 70;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() != 3, this.tickCount);
        } else {
            this.bossEvent.setLife(this.getLife());
        }
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        this.bossEvent2.setProgress((float)this.getRage() / 5.0f);
        this.legSolver.update((LivingEntity)this, this.yBodyRot, this.getScale());
        if (this.hunting_cooldown > 0) {
            --this.hunting_cooldown;
        }
        if (this.roar_cooldown > 0) {
            --this.roar_cooldown;
        }
        if (this.monoltih_cooldown > 0) {
            --this.monoltih_cooldown;
        }
        if (this.earthquake_cooldown > 0) {
            --this.earthquake_cooldown;
        }
        if (this.stomp_cooldown > 0) {
            --this.stomp_cooldown;
        }
        if (!this.level().isClientSide() && this.getAttackState() == 0) {
            if (CMCommonConfig.AncientRemnant.ignoreMobGriefing) {
                this.ChargeBlockBreaking(0.5);
            } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                this.ChargeBlockBreaking(0.5);
            }
        }
        if (this.getIsPower() && this.tickCount % 20 == 0) {
            this.heal(1.0f);
        }
        this.floatRemnant();
        ++this.frame;
        float moveX = (float)(this.getX() - this.xo);
        float moveZ = (float)(this.getZ() - this.zo);
        float speed = Mth.sqrt((float)(moveX * moveX + moveZ * moveZ));
        if (!this.isSilent() && this.frame % 8 == 1 && (double)speed > 0.05 && this.getAttackState() == 11 && this.onGround()) {
            this.playSound((SoundEvent)ModSounds.REMNANT_CHARGE_STEP.get(), 1.0f, 1.0f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
        }
    }

    public boolean isPower() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }

    private void Charge() {
        if (!this.level().isClientSide()) {
            if (CMCommonConfig.AncientRemnant.ignoreMobGriefing) {
                this.ChargeBlockBreaking(1.5);
            } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                this.ChargeBlockBreaking(1.5);
            }
            if (this.tickCount % 4 == 0) {
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)Lentity) || Lentity instanceof Ancient_Remnant_Entity || Lentity == this || !(flag = Lentity.hurtOrSimulate(damagesource, (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2.0f) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2.0, (double)(Lentity.getMaxHealth() * (float)CMCommonConfig.AncientRemnant.ChargeHpDamage))))) || !Lentity.onGround()) continue;
                    double d0 = Lentity.getX() - this.getX();
                    double d1 = Lentity.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    float f = 1.5f;
                    Lentity.push(d0 / d2 * (double)f, 0.5, d1 / d2 * (double)f);
                }
            }
        }
    }

    private void ChargeBlockBreaking(double inflate) {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(inflate, 0.2, inflate);
        for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.REMNANT_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
            if (this.random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)blockpos.getX() + 0.5, (double)blockpos.getY() + 0.5, (double)blockpos.getZ() + 0.5, blockstate, 20);
                flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, 0.2 + this.getRandom().nextGaussian() * 0.15, (-1.2 + this.random.nextDouble()) / 3.0)));
                this.level().addFreshEntity((Entity)fallingBlockEntity);
                continue;
            }
            flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 8) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if (this.attackTicks == 31) {
                this.AreaAttack(7.0f, 7.0f, 70.0f, 1.35f, (float)CMCommonConfig.AncientRemnant.HpDamage, 160, 0);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 14) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 60);
                this.Roarparticle(4.0f, 1.0f, 8.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 17) {
                this.Roarparticle(4.0f, 2.5f, 7.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 20) {
                this.Roarparticle(4.0f, 2.5f, 7.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 23) {
                this.Roarparticle(4.0f, 2.5f, 7.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 26) {
                this.Roarparticle(4.0f, 1.25f, 8.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 29) {
                this.Roarparticle(4.0f, 0.0f, 9.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 55) {
                for (int i = 0; i < 3; ++i) {
                    float angle = (float)i * (float)Math.PI / 1.5f;
                    double sx = this.getX() + (double)(Mth.cos((float)angle) * 8.0f);
                    double sy = this.getY();
                    double sz = this.getZ() + (double)(Mth.sin((float)angle) * 8.0f);
                    if (this.level().isClientSide()) continue;
                    Sandstorm_Entity projectile = new Sandstorm_Entity(this.level(), sx, sy, sz, 300, angle, (LivingEntity)this);
                    this.level().addFreshEntity((Entity)projectile);
                }
            }
        }
        if (this.getAttackState() == 7) {
            if (this.attackTicks == 14) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 80);
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                this.setIsPower(true);
                this.Roarparticle(5.5f, 0.0f, 4.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 17) {
                this.Roarparticle(5.5f, 0.4f, 4.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 20) {
                this.Roarparticle(5.5f, 0.8f, 4.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 23) {
                this.Roarparticle(5.5f, 1.2f, 4.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 26) {
                this.Roarparticle(5.5f, 1.6f, 4.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 29) {
                this.Roarparticle(5.5f, 1.6f, 4.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 32) {
                this.Roarparticle(5.5f, 1.4f, 4.3f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 35) {
                this.Roarparticle(5.5f, 1.2f, 3.8f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 38) {
                this.Roarparticle(5.5f, 1.0f, 3.3f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
            if (this.attackTicks == 41) {
                this.Roarparticle(5.5f, 0.0f, 3.1f, 10, 255, 255, 255, 0.2f, 1.0f, 0.8f, 5.0f);
            }
        }
        if (this.getAttackState() == 8) {
            if (this.attackTicks == 28) {
                this.StompParticle(0.9f, 1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.StompDamage(0.4f, 2, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(2.5f, 1.4f);
            }
            if (this.attackTicks == 30) {
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 4, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(3.5f, 1.4f);
            }
            if (this.attackTicks == 32) {
                this.StompDamage(0.4f, 5, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 6, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(5.5f, 1.4f);
            }
            if (this.attackTicks == 34) {
                this.StompDamage(0.4f, 7, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 8, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(7.5f, 1.4f);
            }
            if (this.attackTicks == 36) {
                this.StompDamage(0.4f, 9, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(9.5f, 1.4f);
            }
            if (this.attackTicks == 38) {
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 11, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(10.5f, 1.4f);
            }
            if (this.attackTicks == 40) {
                this.StompDamage(0.4f, 12, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 13, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(12.5f, 1.4f);
            }
            if (this.attackTicks == 42) {
                this.StompDamage(0.4f, 14, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 15, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(14.5f, 1.4f);
            }
            if (this.attackTicks == 44) {
                this.StompDamage(0.4f, 16, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 17, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(16.5f, 1.4f);
            }
            if (this.attackTicks == 46) {
                this.StompDamage(0.4f, 18, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 19, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(18.5f, 1.4f);
            }
        }
        if (this.getAttackState() == 9) {
            if (this.attackTicks == 28) {
                this.StompParticle(0.9f, -1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.StompDamage(0.4f, 2, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(2.5f, -1.4f);
            }
            if (this.attackTicks == 30) {
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 4, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(3.5f, -1.4f);
            }
            if (this.attackTicks == 32) {
                this.StompDamage(0.4f, 5, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 6, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(5.5f, -1.4f);
            }
            if (this.attackTicks == 34) {
                this.StompDamage(0.4f, 7, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 8, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(7.5f, -1.4f);
            }
            if (this.attackTicks == 36) {
                this.StompDamage(0.4f, 9, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(9.5f, -1.4f);
            }
            if (this.attackTicks == 38) {
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 11, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(10.5f, -1.4f);
            }
            if (this.attackTicks == 40) {
                this.StompDamage(0.4f, 12, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 13, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(12.5f, -1.4f);
            }
            if (this.attackTicks == 42) {
                this.StompDamage(0.4f, 14, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 15, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(14.5f, -1.4f);
            }
            if (this.attackTicks == 44) {
                this.StompDamage(0.4f, 16, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 17, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(16.5f, -1.4f);
            }
            if (this.attackTicks == 46) {
                this.StompDamage(0.4f, 18, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 19, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(18.5f, -1.4f);
            }
        }
        if (this.getAttackState() == 10) {
            if (this.attackTicks == 1) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_CHARGE_PREPARE.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }
            if (this.attackTicks == 14) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.StompParticle(-0.1f, -0.75f);
            }
            if (this.attackTicks == 43) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.StompParticle(-0.1f, 0.75f);
            }
            if (this.attackTicks == 66) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_CHARGE_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                this.Roarparticle(6.0f, 0.0f, 4.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 69) {
                this.Roarparticle(6.0f, 0.0f, 4.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
        }
        if (this.getAttackState() == 11) {
            this.Charge();
            if (!this.level().isClientSide() && this.horizontalCollision) {
                this.setCrash(true);
            }
            if (this.attackTicks >= 1 && this.attackTicks <= 58 && (this.attackTicks - 1) % 3 == 0) {
                this.Roarparticle(6.0f, 0.0f, 3.3f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
        }
        if (this.getAttackState() == 12) {
            if (this.attackTicks == 1) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.25f, 0, 60);
            }
            if (this.attackTicks == 1 || this.attackTicks == 3 || this.attackTicks == 5) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_CHARGE_STEP.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }
        }
        if (this.getAttackState() == 13) {
            if (this.attackTicks == 28) {
                this.StompParticle(0.9f, 1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.StompDamage(0.4f, 2, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(2.5f, 1.4f);
            }
            if (this.attackTicks == 30) {
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 4, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(3.5f, 1.4f);
            }
            if (this.attackTicks == 32) {
                this.StompDamage(0.4f, 5, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 6, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(5.5f, 1.4f);
            }
            if (this.attackTicks == 34) {
                this.StompDamage(0.4f, 7, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 8, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(7.5f, 1.4f);
            }
            if (this.attackTicks == 36) {
                this.StompDamage(0.4f, 9, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(9.5f, 1.4f);
            }
            if (this.attackTicks == 38) {
                this.StompDamage(0.4f, 11, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 12, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(11.5f, 1.4f);
            }
            if (this.attackTicks == 40) {
                this.StompDamage(0.4f, 13, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 14, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(13.5f, 1.4f);
            }
            if (this.attackTicks == 42) {
                this.StompDamage(0.4f, 15, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 16, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(15.5f, 1.4f);
            }
            if (this.attackTicks == 44) {
                this.StompDamage(0.4f, 17, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 18, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(17.5f, 1.4f);
            }
            if (this.attackTicks == 46) {
                this.StompDamage(0.4f, 19, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 20, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(19.5f, 1.4f);
            }
            if (this.attackTicks == 50) {
                this.StompParticle(0.9f, 1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 50) {
                this.StompDamage(0.4f, 2, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(2.5f, 1.4f);
            }
            if (this.attackTicks == 52) {
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 4, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(3.5f, 1.4f);
            }
            if (this.attackTicks == 54) {
                this.StompDamage(0.4f, 5, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 6, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(5.5f, 1.4f);
            }
            if (this.attackTicks == 56) {
                this.StompDamage(0.4f, 7, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 8, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(7.5f, 1.4f);
            }
            if (this.attackTicks == 58) {
                this.StompDamage(0.4f, 9, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(9.5f, 1.4f);
            }
            if (this.attackTicks == 60) {
                this.StompDamage(0.4f, 11, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 12, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(11.5f, 1.4f);
            }
            if (this.attackTicks == 62) {
                this.StompDamage(0.4f, 13, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 14, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(13.5f, 1.4f);
            }
            if (this.attackTicks == 64) {
                this.StompDamage(0.4f, 15, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 16, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(15.5f, 1.4f);
            }
            if (this.attackTicks == 66) {
                this.StompDamage(0.4f, 17, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 18, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(17.5f, 1.4f);
            }
            if (this.attackTicks == 68) {
                this.StompDamage(0.4f, 19, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 20, 6, 0.9f, 0.0f, 1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(19.5f, 1.4f);
            }
        }
        if (this.getAttackState() == 14) {
            if (this.attackTicks == 28) {
                this.StompParticle(0.9f, -1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.StompParticle(0.9f, 1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.StompDamage(0.4f, 2, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(2.5f, -1.4f);
            }
            if (this.attackTicks == 30) {
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 4, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(3.5f, -1.4f);
            }
            if (this.attackTicks == 32) {
                this.StompDamage(0.4f, 5, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 6, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(5.5f, -1.4f);
            }
            if (this.attackTicks == 34) {
                this.StompDamage(0.4f, 7, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 8, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(7.5f, -1.4f);
            }
            if (this.attackTicks == 36) {
                this.StompDamage(0.4f, 9, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(9.5f, -1.4f);
            }
            if (this.attackTicks == 38) {
                this.StompDamage(0.4f, 11, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 12, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(11.5f, -1.4f);
            }
            if (this.attackTicks == 40) {
                this.StompDamage(0.4f, 13, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 14, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(13.5f, -1.4f);
            }
            if (this.attackTicks == 42) {
                this.StompDamage(0.4f, 15, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 16, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(15.5f, -1.4f);
            }
            if (this.attackTicks == 44) {
                this.StompDamage(0.4f, 17, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 18, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(17.5f, -1.4f);
            }
            if (this.attackTicks == 46) {
                this.StompDamage(0.4f, 19, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 20, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(19.5f, -1.4f);
            }
            if (this.attackTicks == 50) {
                this.StompParticle(0.9f, -1.4f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks == 50) {
                this.StompDamage(0.4f, 2, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(2.5f, -1.4f);
            }
            if (this.attackTicks == 52) {
                this.StompDamage(0.4f, 3, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 4, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(3.5f, -1.4f);
            }
            if (this.attackTicks == 54) {
                this.StompDamage(0.4f, 5, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 6, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(5.5f, -1.4f);
            }
            if (this.attackTicks == 56) {
                this.StompDamage(0.4f, 7, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 8, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(7.5f, -1.4f);
            }
            if (this.attackTicks == 58) {
                this.StompDamage(0.4f, 9, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 10, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(9.5f, -1.4f);
            }
            if (this.attackTicks == 60) {
                this.StompDamage(0.4f, 11, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 12, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(11.5f, -1.4f);
            }
            if (this.attackTicks == 62) {
                this.StompDamage(0.4f, 13, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 14, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(13.5f, -1.4f);
            }
            if (this.attackTicks == 64) {
                this.StompDamage(0.4f, 15, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 16, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(15.5f, -1.4f);
            }
            if (this.attackTicks == 66) {
                this.StompDamage(0.4f, 17, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 18, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(17.5f, -1.4f);
            }
            if (this.attackTicks == 68) {
                this.StompDamage(0.4f, 19, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.StompDamage(0.4f, 20, 6, 0.9f, 0.0f, -1.4f, 80, 0.9f, (float)CMCommonConfig.AncientRemnant.StompHpDamage, 0.1f);
                this.Stompsound(19.5f, -1.4f);
            }
        }
        if (this.getAttackState() == 15) {
            if (this.attackTicks == 1) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_TAIL_SLAM_1.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if (this.attackTicks == 26) {
                this.AreaAttack(10.0f, 10.0f, 70.0f, 1.0f, (float)CMCommonConfig.AncientRemnant.HpDamage, 160, 0);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.EarthQuakeSummon(5.5f, 22 + this.random.nextInt(8), 0.8f);
                this.StompParticle(5.5f, 0.8f);
            }
            if (this.attackTicks == 55) {
                this.AreaAttack(10.0f, 10.0f, 70.0f, 1.0f, (float)CMCommonConfig.AncientRemnant.HpDamage, 160, 0);
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_TAIL_SLAM_2.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.EarthQuakeSummon(5.25f, 22 + this.random.nextInt(8), 1.5f);
                this.StompParticle(5.25f, 1.5f);
            }
            if (this.attackTicks == 85) {
                this.AreaAttack(10.0f, 10.0f, 70.0f, 1.0f, (float)CMCommonConfig.AncientRemnant.HpDamage, 160, 0);
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_TAIL_SLAM_3.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 0, 10);
                this.EarthQuakeSummon(5.5f, 22 + this.random.nextInt(8), 0.8f);
                this.StompParticle(5.5f, 0.8f);
            }
        }
        if (this.getAttackState() == 16) {
            if (this.attackTicks == 12) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_TAIL_SWING.get(), SoundSource.HOSTILE, 2.0f, 1.0f);
            }
            if (this.attackTicks == 25) {
                this.TailAreaAttack(8.0f, 8.0f, 1.05f, 120.0f, 1.0f, (float)CMCommonConfig.AncientRemnant.HpDamage, 200, 100);
            }
        }
        if (this.getAttackState() == 17) {
            if (this.attackTicks == 16) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 80);
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.1f);
            }
            if (this.attackTicks == 18) {
                this.Roarparticle(4.0f, -1.0f, 8.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 21) {
                this.Roarparticle(4.0f, -1.4f, 7.5f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 24) {
                this.Roarparticle(4.0f, -1.4f, 8.0f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
            if (this.attackTicks == 27) {
                this.Roarparticle(4.0f, -1.0f, 7.5f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 3.5f);
            }
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (item == ModItems.NECKLACE_OF_THE_DESERT.get() && !this.getNecklace()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            this.setHomePos(GlobalPos.of((ResourceKey)this.level().dimension(), (BlockPos)this.blockPosition()));
            this.setNecklace(true);
            this.setAttackState(2);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (LivingEntity entityHit : entitiesHit) {
                float entityHitAngle = (float)((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * 57.29577951308232 - 90.0) % 360.0);
                float entityAttackingAngle = this.yBodyRot % 360.0f;
                if (entityHitAngle < 0.0f) {
                    entityHitAngle += 360.0f;
                }
                if (entityAttackingAngle < 0.0f) {
                    entityAttackingAngle += 360.0f;
                }
                float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
                float entityHitDistance = (float)Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ancient_Remnant_Entity || entityHit == this) continue;
                boolean flag = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage, (double)(entityHit.getMaxHealth() * hpdamage))));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                this.hit = true;
                if (stunticks <= 0) continue;
                entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, stunticks));
            }
        }
    }

    private void TailAreaAttack(float range, float height, float height2, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
        List<LivingEntity> entitiesHit = this.getTailEntityLivingBaseNearby(range, height, height2, range, range);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (LivingEntity entityHit : entitiesHit) {
                float entityHitAngle = (float)((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * 57.29577951308232 - 90.0) % 360.0);
                float entityAttackingAngle = this.yBodyRot % 360.0f;
                if (entityHitAngle < 0.0f) {
                    entityHitAngle += 360.0f;
                }
                if (entityAttackingAngle < 0.0f) {
                    entityAttackingAngle += 360.0f;
                }
                float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
                float entityHitDistance = (float)Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ancient_Remnant_Entity || entityHit == this) continue;
                boolean flag = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage, (double)(entityHit.getMaxHealth() * hpdamage))));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                this.hit = true;
                if (stunticks > 0) {
                    entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, stunticks));
                }
                double d0 = entityHit.getX() - this.getX();
                double d1 = entityHit.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                entityHit.push(d0 / d2 * 4.0, 0.2, d1 / d2 * 4.0);
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        if (!this.level().isClientSide()) {
            double bodyRotRad = (double)this.yBodyRot * (Math.PI / 180);
            double cosBodyRot = Math.cos(bodyRotRad);
            double sinBodyRot = Math.sin(bodyRotRad);
            double facingAngle = bodyRotRad + 1.5707963267948966;
            double commonOffsetX = (double)vec * -sinBodyRot + cosBodyRot * (double)math;
            double commonOffsetZ = (double)vec * cosBodyRot + sinBodyRot * (double)math;
            double baseX = this.getX() + commonOffsetX;
            double baseZ = this.getZ() + commonOffsetZ;
            int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
            double spread = Math.PI * (double)spreadarc;
            int arcLen = Mth.ceil((double)((double)distance * spread));
            float factor = 1.0f - (float)distance / 12.0f;
            for (int i = 0; i < arcLen; ++i) {
                double thetaRatio = arcLen > 1 ? (double)i / (double)(arcLen - 1) : 0.5;
                double theta = (thetaRatio - 0.5) * spread + facingAngle;
                double vx = Math.cos(theta);
                double vz = Math.sin(theta);
                double px = baseX + vx * (double)distance;
                double pz = baseZ + vz * (double)distance;
                int hitX = Mth.floor((double)px);
                int hitZ = Mth.floor((double)pz);
                BlockPos pos = new BlockPos(hitX, hitY + height, hitZ);
                BlockState block = this.level().getBlockState(pos);
                int maxDepth = 30;
                for (int depthCount = 0; depthCount < maxDepth && block.getRenderShape() != RenderShape.MODEL; ++depthCount) {
                    pos = pos.below();
                    block = this.level().getBlockState(pos);
                }
                if (block.getRenderShape() != RenderShape.MODEL) {
                    block = Blocks.AIR.defaultBlockState();
                }
                this.spawnBlocks(hitX, hitY + height, hitZ, (int)(this.getY() - (double)height), block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage, hpdamage);
            }
        }
    }

    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck, BlockState blockState, double px, double pz, float mxy, double vx, double vz, float factor, int shieldbreakticks, float damage, float hpdamage) {
        BlockPos blockpos = new BlockPos(hitX, hitY, hitZ);
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (!blockstate.isFaceSturdy((BlockGetter)this.level(), blockpos1, Direction.UP)) continue;
            if (this.level().isEmptyBlock(blockpos) || (voxelshape = (blockstate1 = this.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty()) break;
            d0 = voxelshape.max(Direction.Axis.Y);
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((float)lowestYCheck) - 1);
        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)hitX + 0.5, (double)blockpos.getY() + d0 + 0.5, (double)hitZ + 0.5, blockState, 10);
        fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.04, 0.0);
        this.level().addFreshEntity((Entity)fallingBlockEntity);
        AABB selection = new AABB(px - 0.5, (double)blockpos.getY() + d0 - 1.0, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + (double)mxy, pz + 0.5);
        List hitbox = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        if (!hitbox.isEmpty()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            float baseDamage = (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage);
            for (LivingEntity entity : hitbox) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof Ancient_Remnant_Entity || entity == this) continue;
                float finalDamage = baseDamage + entity.getMaxHealth() * hpdamage;
                boolean flag = entity.hurtOrSimulate(damagesource, finalDamage);
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                    Player player = (Player)entity;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                this.hit = true;
                double magnitude = -4.0;
                double x = vx * (double)(1.0f - factor) * magnitude;
                double y = entity.onGround() ? 0.15 : 0.0;
                double z = vz * (double)(1.0f - factor) * magnitude;
                entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
            }
        }
    }

    private void Roarparticle(float vec, float math, float y, int duration, int r, int g, int b, float a, float start, float inc, float end) {
        if (this.level().isClientSide()) {
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            this.level().addParticle((ParticleOptions)new RoarParticleOptions(duration, r, g, b, a, start, inc, end), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)y, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void Stompsound(float distance, float math) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
        this.level().playLocalSound(this.getX() + (double)distance * vecX + (double)(f * math), this.getY(), this.getZ() + (double)distance * vecZ + (double)(f1 * math), (SoundEvent)ModSounds.REMNANT_SHOCKWAVE.get(), this.getSoundSource(), 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f, false);
    }

    public List<LivingEntity> getTailEntityLivingBaseNearby(double distanceX, double distanceMinY, double distanceMaxY, double distanceZ, double radius) {
        return this.getTailEntitiesNearby(LivingEntity.class, distanceX, distanceMinY, distanceMaxY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getTailEntitiesNearby(Class<T> entityClass, double dX, double dY, double pY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, new AABB(this.getX() - dX, this.getY() - dY, this.getZ() - dZ, this.getX() + dX, this.getY() + pY, this.getZ() + dZ), e -> e != this && (double)this.distanceTo((Entity)e) <= r + (double)(e.getBbWidth() / 2.0f) && e.getY() <= this.getY() + dY);
    }

    private void StompParticle(float vec, float math) {
        if (this.level().isClientSide()) {
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + this.random.nextInt(12); ++i1) {
                double DeltaMovementX = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementZ = this.getRandom().nextGaussian() * 0.07;
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = 0.5 * (double)Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.1f;
                double extraZ = 0.5 * (double)Mth.cos((float)angle);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
            this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 20, 255, 255, 255, 1.0f, 25.0f, false, 2), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.2f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void EarthQuakeSummon(float vec, int quake, float math) {
        float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        float angle = 360.0f / (float)quake;
        for (int i = 0; i < quake; ++i) {
            EarthQuake_Entity peq = new EarthQuake_Entity(this.level(), (LivingEntity)this);
            peq.setDamage((float)CMCommonConfig.AncientRemnant.EarthQuakeDamage);
            peq.shootFromRotation((Entity)this, 0.0f, angle * (float)i, 0.0f, 0.45f, 0.0f);
            peq.setPos(this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + 0.3, this.getZ() + (double)vec * vecZ + (double)(f1 * math));
            this.level().addFreshEntity((Entity)peq);
        }
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_ANCIENT_REMNANT)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return !this.isSleep() ? (SoundEvent)ModSounds.REMNANT_IDLE.get() : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.REMNANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.REMNANT_DEATH.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return (SoundEvent)ModSounds.REMNANT_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !this.isSleep();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        ServerLevel serverLevel;
        MinecraftServer server;
        ServerLevel targetLevel;
        Level level;
        if (CMCommonConfig.AncientRemnant.respawner && !this.level().isClientSide() && this.getHomePos() != null && (level = this.level()) instanceof ServerLevel && (targetLevel = (server = (serverLevel = (ServerLevel)level).getServer()).getLevel(this.getHomePos().dimension())) != null) {
            BlockPos targetPos = this.getHomePos().pos();
            BlockState blockState = ((Block)ModBlocks.BOSS_RESPAWNER.get()).defaultBlockState();
            targetLevel.setBlock(targetPos, blockState, 2);
            BlockEntity blockEntity = targetLevel.getBlockEntity(targetPos);
            if (blockEntity instanceof Boss_Respawn_Spawner_Block_Entity) {
                Boss_Respawn_Spawner_Block_Entity spawnerBlockEntity = (Boss_Respawn_Spawner_Block_Entity)blockEntity;
                spawnerBlockEntity.setEntityId((EntityType)ModEntities.ANCIENT_REMNANT.get());
                spawnerBlockEntity.setTheItem(((Item)ModItems.DESERT_EYE.get()).getDefaultInstance());
            }
        }
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
        this.bossEvent2.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
        this.bossEvent2.removePlayer(player);
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    private static enum AttackMode {
        CIRCLE,
        MELEE;

    }

    class RemnantAttackModeGoal
    extends Goal {
        private final Ancient_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final float huntingTime = 0.0f;
        private float circleDistance = 9.0f;
        private boolean clockwise = false;

        public RemnantAttackModeGoal(Ancient_Remnant_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && this.target.isAlive() && this.mob.getAttackState() == 0;
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return false;
            }
            if (!target.isAlive()) {
                return false;
            }
            if (!this.mob.isWithinRestriction(target.blockPosition())) {
                return false;
            }
            return !(target instanceof Player) || !target.isSpectator() && !((Player)target).isCreative();
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.circleDistance = 18 + this.mob.random.nextInt(10);
            this.clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.circleDistance = 18 + this.mob.random.nextInt(10);
            this.clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(this.target)) {
                this.mob.setTarget(null);
            }
            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == AttackMode.CIRCLE) {
                    ++this.circlingTime;
                    Ancient_Remnant_Entity.this.circleEntity((Entity)target, this.circleDistance, 1.0f, this.clockwise, this.circlingTime, 0.0f, 1.0f);
                    if (0.0f >= (float)this.mob.hunting_cooldown) {
                        this.mob.mode = AttackMode.MELEE;
                    } else if ((double)this.mob.distanceTo((Entity)target) < 4.0) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    this.mob.getNavigation().moveTo((Entity)target, 1.0);
                    this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                }
            }
        }
    }

    static class RemnantAttackGoal
    extends InternalAttackGoal {
        protected final Ancient_Remnant_Entity entity;
        private final float random;

        public RemnantAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.random = random;
        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.mode == AttackMode.MELEE;
        }

        @Override
        public void start() {
            super.start();
            this.entity.hit = false;
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
        }

        @Override
        public void stop() {
            super.stop();
            if (!this.entity.hit && this.entity.getRage() < 5) {
                this.entity.setRage(this.entity.getRage() + 1);
                this.entity.hit = false;
            }
        }
    }

    class RemnantDoNothingGoal
    extends Goal {
        public RemnantDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return !Ancient_Remnant_Entity.this.getNecklace();
        }

        public void tick() {
            Ancient_Remnant_Entity.this.setDeltaMovement(0.0, Ancient_Remnant_Entity.this.getDeltaMovement().y, 0.0);
        }

        public boolean isInterruptable() {
            return false;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class RemnantAwakenGoal
    extends InternalStateGoal {
        protected final Ancient_Remnant_Entity entity;

        public RemnantAwakenGoal(Ancient_Remnant_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            return this.entity.getNecklace() && super.canUse();
        }
    }

    static class RemnantPhaseChangeGoal
    extends InternalAttackGoal {
        protected final Ancient_Remnant_Entity entity;

        public RemnantPhaseChangeGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, 0.0f);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            return !this.entity.getIsPower() && this.entity.getAttackState() == this.getattackstate && this.entity.isPower();
        }
    }

    static class RemnantStompGoal
    extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate1;
        private final int attackstate2;
        private final int attackstate3;
        private final int attackstate4;
        private final int attackendstate;
        private final int attackMaxtick1;
        private final int attackMaxtick2;
        private final int attackseetick;
        private final double attackrange;
        private final float random;

        public RemnantStompGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate1, int attackstate2, int attackstate3, int attackstate4, int attackendstate, int attackMaxtick1, int attackMaxtick2, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate1 = attackstate1;
            this.attackstate2 = attackstate2;
            this.attackstate3 = attackstate3;
            this.attackstate4 = attackstate4;
            this.attackendstate = attackendstate;
            this.attackMaxtick1 = attackMaxtick1;
            this.attackMaxtick2 = attackMaxtick2;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;
        }

        public boolean isInterruptable() {
            return false;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && this.entity.stomp_cooldown <= 0 && target.isAlive() && (double)this.entity.distanceTo((Entity)target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.mode == AttackMode.MELEE && target.getY() <= this.entity.getY() + 4.5 && (double)this.entity.distanceTo((Entity)target) > 5.5;
        }

        public void start() {
            if (this.entity.getIsPower()) {
                if (this.entity.getRandom().nextBoolean()) {
                    this.entity.setAttackState(this.attackstate3);
                } else {
                    this.entity.setAttackState(this.attackstate4);
                }
            } else if (this.entity.getRandom().nextBoolean()) {
                this.entity.setAttackState(this.attackstate1);
            } else {
                this.entity.setAttackState(this.attackstate2);
            }
            this.entity.hit = false;
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
        }

        public void stop() {
            this.entity.setAttackState(this.attackendstate);
            this.entity.stomp_cooldown = 110;
            if (!this.entity.hit && this.entity.getRage() < 5) {
                this.entity.setRage(this.entity.getRage() + 1);
                this.entity.hit = false;
            }
        }

        public boolean canContinueToUse() {
            if (this.entity.getAttackState() == this.attackstate1 || this.entity.getAttackState() == this.attackstate2) {
                return this.entity.attackTicks <= this.attackMaxtick1;
            }
            if (this.entity.getAttackState() == this.attackstate3 || this.entity.getAttackState() == this.attackstate4) {
                return this.entity.attackTicks <= this.attackMaxtick2;
            }
            return false;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
        }
    }

    static class RemnantMonolithAttackGoal
    extends InternalAttackGoal {
        protected final Ancient_Remnant_Entity entity;
        private final float random;

        public RemnantMonolithAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.random = random;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && (this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0f < this.random && target.getY() >= this.entity.getY() + 8.0 || this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0f < this.random && (double)this.entity.distanceTo((Entity)target) > 12.0 || this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.distanceTo((Entity)target) < this.attackrange) && this.entity.getAttackState() == this.getattackstate && this.entity.mode == AttackMode.MELEE;
        }

        @Override
        public void start() {
            super.start();
            this.entity.hit = false;
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.monoltih_cooldown = 200;
        }

        @Override
        public void tick() {
            super.tick();
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks == this.attackseetick && target != null) {
                double d1 = target.getY();
                float f = (float)Mth.atan2((double)(target.getZ() - this.entity.getZ()), (double)(target.getX() - this.entity.getX()));
                this.StrikeWindmillMonolith(8, 16, 2.0, 0.75, 0.6, d1, 1);
                for (int l = 0; l < 16; ++l) {
                    double d2 = 1.25 * (double)(l + 1);
                    int j = (int)(5.0f + 1.5f * (float)l);
                    this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos((float)f) * d2, this.entity.getZ() + (double)Mth.sin((float)f) * d2, d1, f, j);
                }
            }
        }

        private void StrikeWindmillMonolith(int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, double spawnY, int delay) {
            float angleIncrement = (float)(Math.PI * 2 / (double)numberOfBranches);
            for (int branch = 0; branch < numberOfBranches; ++branch) {
                float baseAngle = angleIncrement * (float)branch;
                for (int i = 0; i < particlesPerBranch; ++i) {
                    double currentRadius = initialRadius + (double)i * radiusIncrement;
                    float currentAngle = (float)((double)baseAngle + (double)((float)i * angleIncrement) / initialRadius + (double)((float)((double)i * curveFactor)));
                    double xOffset = currentRadius * Math.cos(currentAngle);
                    double zOffset = currentRadius * Math.sin(currentAngle);
                    double spawnX = this.entity.getX() + xOffset;
                    double spawnZ = this.entity.getZ() + zOffset;
                    int d3 = delay * (i + 1);
                    this.spawnSpikeLine(spawnX, spawnZ, spawnY, currentAngle, d3);
                }
            }
        }

        private void spawnSpikeLine(double posX, double posZ, double posY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing((double)posX, (double)posY, (double)posZ);
            double d0 = 0.0;
            do {
                BlockState blockstate1;
                VoxelShape voxelshape;
                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = this.entity.level().getBlockState(blockpos1);
                if (!blockstate.isFaceSturdy((BlockGetter)this.entity.level(), blockpos1, Direction.DOWN)) continue;
                if (this.entity.level().isEmptyBlock(blockpos) || (voxelshape = (blockstate1 = this.entity.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.entity.level(), blockpos)).isEmpty()) break;
                d0 = voxelshape.max(Direction.Axis.Y);
                break;
            } while ((blockpos = blockpos.above()).getY() < Math.min(this.entity.level().getMaxBuildHeight(), this.entity.getBlockY() + 20));
            this.entity.level().addFreshEntity((Entity)new Ancient_Desert_Stele_Entity(this.entity.level(), posX, (double)blockpos.getY() + d0 - 3.0, posZ, rotation, delay, (float)CMCommonConfig.AncientRemnant.AncientDesertSteledamage, (LivingEntity)this.entity));
        }
    }

    static class RemnantChargeGoal
    extends InternalAttackGoal {
        protected final Ancient_Remnant_Entity entity;
        private final float random;

        public RemnantChargeGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.random = random;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && this.entity.getRage() >= 5 && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.mode == AttackMode.MELEE;
        }

        @Override
        public void start() {
            super.start();
            this.entity.setRage(0);
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
        }

        @Override
        public void tick() {
            super.tick();
            this.entity.getNavigation().stop();
        }

        @Override
        public void stop() {
            super.stop();
            if (!this.entity.hit && this.entity.getRage() < 5) {
                this.entity.setRage(this.entity.getRage() + 1);
            }
        }
    }
}

