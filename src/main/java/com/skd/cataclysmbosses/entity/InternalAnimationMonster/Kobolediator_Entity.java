/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
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
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster;

import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.HurtByNearestTargetGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.cataclysmbosses.entity.effect.Cm_Falling_Block_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.projectile.Poison_Dart_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.EntityUtil;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Kobolediator_Entity
extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sword1AnimationState = new AnimationState();
    public AnimationState sword2AnimationState = new AnimationState();
    public AnimationState chargeprepareAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState blockAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int earthquake_cooldown = 0;
    public static final int EARTHQUAKE_COOLDOWN = 80;
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;
    private static final EntityDataAccessor<Boolean> AWAKEN = SynchedEntityData.defineId(Kobolediator_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);

    public Kobolediator_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 80;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Kobolediator.healthMultiplier, CMCommonConfig.Kobolediator.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(3, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 3, 0, 50, 15, 12.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Kobolediator_Entity.this.getRandom().nextFloat() * 100.0f < 16.0f && Kobolediator_Entity.this.earthquake_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.earthquake_cooldown = 80;
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 4, 0, 100, 64, 8.0f));
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 5, 6, 40, 30, 15.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Kobolediator_Entity.this.getRandom().nextFloat() * 100.0f < 9.0f && Kobolediator_Entity.this.charge_cooldown <= 0;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, this, 6, 6, 7, 30, 0){

            @Override
            public void tick() {
                if (this.entity.onGround()) {
                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * ((float)Math.PI / 180);
                    Vec3 vector3d1 = new Vec3((double)(-Mth.sin((float)f)), this.entity.getDeltaMovement().y, (double)Mth.cos((float)f)).scale(0.7).add(vector3d.scale(0.5));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 6, 7, 0, 40, 40, 5.0f){

            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.charge_cooldown = 160;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 7, 7, 0, 40, 40){

            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.charge_cooldown = 160;
            }
        });
        this.goalSelector.addGoal(0, (Goal)new KobolediatorDoNothingGoal());
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 2, 2, 0, 70, 0));
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal((Internal_Animation_Monster)this, 9, 9, 0, 18, 0, false));
    }

    public static AttributeSupplier.Builder kobolediator() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 14.0).add(Attributes.MAX_HEALTH, 180.0).add(Attributes.ARMOR, 10.0).add(Attributes.STEP_HEIGHT, 1.25).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Poison_Dart_Entity) {
            return false;
        }
        if (this.canBlockDamageSource(source)) {
            if (entity instanceof AbstractArrow) {
                float f = 170.0f + this.random.nextFloat() * 80.0f;
                entity.setDeltaMovement(entity.getDeltaMovement().scale(1.5));
                entity.setYRot(entity.getYRot() + f);
                entity.hurtMarked = true;
            }
            if (this.getAttackState() == 0) {
                this.setAttackState(9);
                this.playSound(SoundEvents.ANVIL_LAND, 1.0f, 2.0f);
            }
            return false;
        }
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        return super.hurtOrSimulate(source, damage);
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Vec3 vector3d2;
        boolean flag = false;
        if (!(this.isNoAi() || !damageSourceIn.is(DamageTypeTags.IS_PROJECTILE) || flag || this.getAttackState() != 0 && this.getAttackState() != 9 || (vector3d2 = damageSourceIn.getSourcePosition()) == null)) {
            Vec3 vector3d = this.getViewVector(1.0f);
            Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
            vector3d1 = new Vec3(vector3d1.x, 0.0, vector3d1.z);
            return vector3d1.dot(vector3d) < 0.0;
        }
        return false;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "awake") {
            return this.awakeAnimationState;
        }
        if (input == "sword1") {
            return this.sword1AnimationState;
        }
        if (input == "sword2") {
            return this.sword2AnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "charge_prepare") {
            return this.chargeprepareAnimationState;
        }
        if (input == "charge") {
            return this.chargeAnimationState;
        }
        if (input == "charge_end") {
            return this.chargeendAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "block") {
            return this.blockAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(AWAKEN, false);
    }

    public void setAwaken(boolean necklace) {
        if (necklace) {
            this.heal(this.getMaxHealth());
        }
        this.entityData.set(AWAKEN, necklace);
    }

    public boolean getAwaken() {
        return (Boolean)this.entityData.get(AWAKEN);
    }

    public boolean isSleep() {
        return !this.getAwaken() || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, EntitySpawnReason p_29680_, @Nullable SpawnGroupData p_29681_) {
        this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
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
                    this.awakeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.sword1AnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.sword2AnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.chargeprepareAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.chargeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.chargeendAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 8: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 9: {
                    this.stopAllAnimationStates();
                    this.blockAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.sword1AnimationState.stop();
        this.sword2AnimationState.stop();
        this.chargeprepareAnimationState.stop();
        this.chargeAnimationState.stop();
        this.blockAnimationState.stop();
        this.chargeendAnimationState.stop();
        this.deathAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(8);
    }

    @Override
    public int deathtimer() {
        return 60;
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Awaken", this.getAwaken());
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setAwaken(compound.getBooleanOr("Awaken", false));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0 && this.getAwaken(), this.tickCount);
        }
        if (this.earthquake_cooldown > 0) {
            --this.earthquake_cooldown;
        }
        if (this.charge_cooldown > 0) {
            --this.charge_cooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 2 && this.attackTicks == 12) {
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.06f, 0, 20);
        }
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 20) {
                this.AreaAttack(10.0f, 6.0f, 60.0f, 1.0f, 120);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.1f, 0, 20);
                this.Makeparticle(0.5f, 9.0f, 1.2f);
            }
            if (this.attackTicks == 19) {
                this.StompDamage(0.25f, 2, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.StompDamage(0.25f, 3, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.Stompsound(2.5f, -0.2f);
            }
            if (this.attackTicks == 21) {
                this.StompDamage(0.25f, 4, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.StompDamage(0.25f, 5, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.Stompsound(4.5f, -0.2f);
            }
            if (this.attackTicks == 23) {
                this.StompDamage(0.25f, 5, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.StompDamage(0.25f, 6, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.Stompsound(5.5f, -0.2f);
            }
            if (this.attackTicks == 25) {
                this.StompDamage(0.25f, 7, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.StompDamage(0.25f, 8, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.Stompsound(7.5f, -0.2f);
            }
            if (this.attackTicks == 27) {
                this.StompDamage(0.25f, 9, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.StompDamage(0.25f, 10, 5, 1.05f, 2.0f, -0.2f, 0, 1.0f);
                this.Stompsound(9.5f, -0.2f);
            }
        }
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 18) {
                this.AreaAttack(9.0f, 6.0f, 270.0f, 1.0f, 0);
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.05f, 0, 10);
            }
            if (this.attackTicks == 36) {
                this.AreaAttack(9.0f, 6.0f, 270.0f, 1.0f, 0);
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.05f, 0, 10);
            }
            if (this.attackTicks == 65) {
                this.AreaAttack(10.0f, 6.0f, 45.0f, 1.25f, 120);
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.1f, 0, 20);
                this.Makeparticle(0.5f, 9.0f, 1.8f);
            }
        }
        if (this.getAttackState() == 6 && !this.level().isClientSide()) {
            if (CMCommonConfig.Kobolediator.ignoreMobGriefing) {
                this.ChargeBlockBreaking();
            } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                this.ChargeBlockBreaking();
            }
            if (this.tickCount % 4 == 0) {
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.5))) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)Lentity) || Lentity instanceof Kobolediator_Entity || Lentity == this || !(flag = Lentity.hurtOrSimulate(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.4f)) || !Lentity.onGround()) continue;
                    double d0 = Lentity.getX() - this.getX();
                    double d1 = Lentity.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    float f = 1.5f;
                    Lentity.push(d0 / d2 * (double)f, 0.5, d1 / d2 * (double)f);
                }
            }
        }
        if (this.getAttackState() == 7 && this.attackTicks == 5) {
            this.AreaAttack(9.0f, 6.0f, 200.0f, 1.25f, 120);
            this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.05f, 0, 10);
        }
    }

    private void Makeparticle(float size, float vec, float math) {
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
                double extraX = size * Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = size * Mth.cos((float)angle);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
            this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 30, 255, 255, 255, 1.0f, 20.0f, false, 2), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.2f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void ChargeBlockBreaking() {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5, 0.2, 0.5);
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

    private void Stompsound(float distance, float math) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
        this.level().playSound((Player)null, this.getX() + (double)distance * vecX + (double)(f * math), this.getY(), this.getZ() + (double)distance * vecZ + (double)(f1 * math), (SoundEvent)ModSounds.REMNANT_STOMP.get(), this.getSoundSource(), 0.6f, 1.0f);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
        if (!this.level().isClientSide()) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Kobolediator_Entity || entityHit == this) continue;
                entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (!entityHit.isDamageSourceBlocked(damagesource) || !(entityHit instanceof Player)) continue;
                Player player = (Player)entityHit;
                if (shieldbreakticks <= 0) continue;
                EntityUtil.disableShield(player, shieldbreakticks);
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec, float math, int shieldbreakticks, float damage) {
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
            if (this.level().isClientSide()) continue;
            this.spawnBlocks(hitX, hitY + height, hitZ, (int)(this.getY() - (double)height), block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage);
        }
    }

    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck, BlockState blockState, double px, double pz, float mxy, double vx, double vz, float factor, int shieldbreakticks, float damage) {
        DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
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
        List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        if (!hit.isEmpty()) {
            for (LivingEntity entity : hit) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof Kobolediator_Entity || entity == this) continue;
                boolean flag = entity.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                    Player player = (Player)entity;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                double magnitude = -4.0;
                double x = vx * (1.0 - (double)factor) * magnitude;
                double y = entity.onGround() ? 0.15 : 0.0;
                double z = vz * (1.0 - (double)factor) * magnitude;
                entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
            }
        }
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_ANCIENT_REMNANT)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.KOBOLEDIATOR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.KOBOLEDIATOR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return this.isSleep() ? super.getAmbientSound() : (SoundEvent)ModSounds.KOBOLEDIATOR_AMBIENT.get();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    class KobolediatorDoNothingGoal
    extends Goal {
        public KobolediatorDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = Kobolediator_Entity.this.getTarget();
            return !(Kobolediator_Entity.this.getAwaken() || target != null && target.isAlive() && Kobolediator_Entity.this.distanceToSqr((Entity)target) < 255.0 && Kobolediator_Entity.this.getSensing().hasLineOfSight((Entity)target));
        }

        public void tick() {
            Kobolediator_Entity.this.setDeltaMovement(0.0, Kobolediator_Entity.this.getDeltaMovement().y, 0.0);
        }

        public void stop() {
            Kobolediator_Entity.this.setAwaken(true);
            Kobolediator_Entity.this.setAttackState(2);
        }

        public boolean isInterruptable() {
            return false;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}

