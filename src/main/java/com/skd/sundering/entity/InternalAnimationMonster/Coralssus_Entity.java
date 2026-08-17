/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  javax.annotation.Nullable
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
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
 *  net.minecraft.util.ByIdMap
 *  net.minecraft.util.Mth
 *  net.minecraft.util.StringRepresentable
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.VariantHolder
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.NeoForgeMod
 *  net.neoforged.neoforge.event.EventHooks
 *  net.neoforged.neoforge.fluids.FluidType
 */
package com.skd.sundering.entity.InternalAnimationMonster;

import com.skd.sundering.client.particle.Options.RingParticleOptions;
import com.skd.sundering.entity.AI.MobAIFindWater;
import com.skd.sundering.entity.AI.MobAILeaveWater;
import com.skd.sundering.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.sundering.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.sundering.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.sundering.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.sundering.entity.effect.Cm_Falling_Block_Entity;
import com.skd.sundering.entity.effect.ScreenShake_Entity;
import com.skd.sundering.entity.etc.ISemiAquatic;
import com.skd.sundering.entity.etc.SmartBodyHelper2;
import com.skd.sundering.entity.etc.path.GroundPathNavigatorWide;
import com.skd.sundering.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.sundering.init.ModEffect;
import com.skd.sundering.init.ModSounds;
import com.skd.sundering.init.ModTag;
import com.skd.sundering.util.EntityUtil;
import com.mojang.serialization.Codec;
import java.util.EnumSet;
import java.util.function.IntFunction;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;

public class Coralssus_Entity
extends Internal_Animation_Monster
implements VariantHolder<Variant>,
ISemiAquatic {
    private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(Coralssus_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Coralssus_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(Coralssus_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CORALSSUS_SWIM = SynchedEntityData.defineId(Coralssus_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState angryAnimationState = new AnimationState();
    public AnimationState nantaAnimationState = new AnimationState();
    public AnimationState rightfistAnimationState = new AnimationState();
    public AnimationState leftfistAnimationState = new AnimationState();
    public AnimationState jumpingprepareAnimationState = new AnimationState();
    public AnimationState jumpingAnimationState = new AnimationState();
    public AnimationState jumpingendAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int nanta_cooldown = 0;
    public static final int NANTA_COOLDOWN = 160;
    private int moistureAttackTime = 0;
    private int jump_cooldown = 0;
    public static final int JUMP_COOLDOWN = 160;
    private boolean isLandNavigator;
    boolean searchingForLand;

    public Coralssus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.moveControl = new CoralssusMoveControl(this, 2.5f);
        this.switchNavigator(false);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, (Goal)new CoralssusswimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.goalSelector.addGoal(4, (Goal)new MobAIFindWater((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(4, (Goal)new MobAILeaveWater((PathfinderMob)this));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(2, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 1, 2, 40, 17, 6.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Coralssus_Entity.this.getRandom().nextFloat() * 100.0f < 16.0f && Coralssus_Entity.this.nanta_cooldown <= 0 && !Coralssus_Entity.this.getSwim();
            }

            @Override
            public void start() {
                super.start();
                Coralssus_Entity.this.playSound((SoundEvent)ModSounds.CORALSSUS_ROAR.get(), 1.0f, 1.0f + Coralssus_Entity.this.getRandom().nextFloat() * 0.1f);
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 2, 2, 0, 60, 60){

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.nanta_cooldown = 160;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 3, 0, 30, 8, 4.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && Coralssus_Entity.this.getIsRight();
            }

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.setRight(!Coralssus_Entity.this.getIsRight());
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 4, 0, 30, 8, 4.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && !Coralssus_Entity.this.getIsRight();
            }

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.setRight(!Coralssus_Entity.this.getIsRight());
            }
        });
        this.goalSelector.addGoal(1, (Goal)new Coralssus_JumpPrepareAttackGoal(this, 0, 5, 6, 20, 10, 6.5f, 10.0f, 16.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && !Coralssus_Entity.this.getSwim();
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 6, 6, 7, 100, 100));
        this.goalSelector.addGoal(0, (Goal)new InternalStateGoal(this, 7, 7, 0, 20, 0){

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.jump_cooldown = 160;
            }
        });
    }

    public static AttributeSupplier.Builder coralssus() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 10.0).add(Attributes.MAX_HEALTH, 160.0).add(Attributes.ARMOR, 5.0).add(Attributes.STEP_HEIGHT, 1.25).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "nanta") {
            return this.nantaAnimationState;
        }
        if (input == "angry") {
            return this.angryAnimationState;
        }
        if (input == "right_fist") {
            return this.rightfistAnimationState;
        }
        if (input == "left_fist") {
            return this.leftfistAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "jumping_prepare") {
            return this.jumpingprepareAnimationState;
        }
        if (input == "jumping") {
            return this.jumpingAnimationState;
        }
        if (input == "jumping_end") {
            return this.jumpingendAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(MOISTNESS, (Object)40000);
        p_326229_.define(VARIANT, (Object)Variant.FIRE.id);
        p_326229_.define(RIGHT, (Object)false);
        p_326229_.define(CORALSSUS_SWIM, (Object)false);
    }

    public boolean isSponge() {
        String s = ChatFormatting.stripFormatting((String)this.getName().getString());
        return s != null && s.toLowerCase().contains("squarepants") && this.getVariant() == Variant.HORN;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_) {
        this.setVariant(Variant.byId(this.random.nextInt(3)));
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
                    this.angryAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.nantaAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.rightfistAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.leftfistAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.jumpingprepareAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.jumpingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.jumpingendAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 8: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.angryAnimationState.stop();
        this.nantaAnimationState.stop();
        this.rightfistAnimationState.stop();
        this.leftfistAnimationState.stop();
        this.jumpingprepareAnimationState.stop();
        this.jumpingAnimationState.stop();
        this.jumpingendAnimationState.stop();
        this.deathAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(8);
    }

    @Override
    public int deathtimer() {
        return 30;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant().id);
        compound.putInt("Moisture", this.getMoistness());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(Variant.byId(compound.getInt("Variant")));
        this.setMoistness(compound.getInt("Moisture"));
    }

    public int getMoistness() {
        return (Integer)this.entityData.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.entityData.set(MOISTNESS, (Object)p_211137_1_);
    }

    public Variant getVariant() {
        return Variant.byId((Integer)this.entityData.get(VARIANT));
    }

    public void setVariant(Variant p_262578_) {
        this.entityData.set(VARIANT, (Object)p_262578_.id);
    }

    public void setRight(boolean right) {
        this.entityData.set(RIGHT, (Object)right);
    }

    public boolean getIsRight() {
        return (Boolean)this.entityData.get(RIGHT);
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    public boolean hurt(DamageSource source, float damage) {
        if (source.is(DamageTypes.HOT_FLOOR)) {
            return false;
        }
        return super.hurt(source, damage);
    }

    public void onInsideBubbleColumn(boolean p_20322_) {
    }

    public void onAboveBubbleCol(boolean p_20313_) {
    }

    public void travel(Vec3 p_32394_) {
        if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01f, p_32394_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(p_32394_);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isInWater() && this.isLandNavigator) {
            this.switchNavigator(false);
        }
        if (!this.isInWater() && !this.isLandNavigator) {
            this.switchNavigator(true);
        }
        if (this.isNoAi()) {
            this.setAirSupply(this.getMaxAirSupply());
        } else if (this.isInWaterRainOrBubble()) {
            this.setMoistness(6000);
        } else {
            int dry = this.level().isDay() ? 2 : 1;
            this.setMoistness(this.getMoistness() - dry);
            if (this.getMoistness() <= 0 && this.moistureAttackTime-- <= 0) {
                this.hurt(this.damageSources().dryOut(), this.random.nextInt(2) == 0 ? 1.0f : 0.0f);
                this.moistureAttackTime = 20;
            }
        }
        boolean flag1 = this.canInFluidType(this.getEyeInFluidType());
        if (flag1) {
            if (this.level().noCollision((Entity)this, this.getBoundingBox()) && !this.getSwim()) {
                this.setSwim(true);
            }
        } else if (this.level().noCollision((Entity)this, this.getBoundingBox()) && this.getSwim()) {
            this.setSwim(false);
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }
        if (this.nanta_cooldown > 0) {
            --this.nanta_cooldown;
        }
        if (this.jump_cooldown > 0) {
            --this.jump_cooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        float f1 = (float)Math.cos(Math.toRadians(this.getYRot() + 90.0f));
        float f2 = (float)Math.sin(Math.toRadians(this.getYRot() + 90.0f));
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 6 || this.attackTicks == 16 || this.attackTicks == 26 || this.attackTicks == 36 || this.attackTicks == 46) {
                this.push((double)f1 * 0.5, 0.0, (double)f2 * 0.5);
            }
            if (this.attackTicks == 5 || this.attackTicks == 30) {
                this.EarthQuake(3.5f, 2, 60);
                this.Makeparticle(0.5f, 3.15f, 0.2f);
            }
            if (this.attackTicks == 17) {
                this.EarthQuake(3.5f, 2, 60);
                this.Makeparticle(0.5f, 3.15f, -0.2f);
            }
            if (this.attackTicks == 42) {
                this.EarthQuake(3.5f, 2, 60);
                this.Makeparticle(0.5f, 3.15f, -0.2f);
                this.BlockBreaking();
            }
        }
        if (this.getAttackState() == 3 && this.attackTicks == 12) {
            this.EarthQuake(3.5f, 2, 0);
            this.Makeparticle(0.5f, 2.8f, 0.2f);
        }
        if (this.getAttackState() == 4 && this.attackTicks == 12) {
            this.EarthQuake(3.5f, 2, 0);
            this.Makeparticle(0.5f, 2.8f, -0.2f);
        }
        if (this.getAttackState() == 6 && (this.onGround() || !this.getInBlockState().getFluidState().isEmpty())) {
            this.setAttackState(7);
        }
        if (this.getAttackState() == 7 && this.attackTicks == 3) {
            this.EarthQuake(4.5f, 5, 120);
            this.Makeparticle(0.5f, 3.1f, -0.4f);
            this.Makeparticle(0.5f, 3.1f, 0.4f);
        }
    }

    private void EarthQuake(float grow, int damage, int shieldbreakticks) {
        ScreenShake_Entity.ScreenShake(this.level(), this.position(), 10.0f, 0.15f, 0, 20);
        this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate((double)grow))) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof Coralssus_Entity || entity == this) continue;
                this.launch(entity, true);
                entity.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float)this.random.nextInt(damage));
                if (!entity.isDamageSourceBlocked(damagesource) || !(entity instanceof Player)) continue;
                Player player = (Player)entity;
                if (shieldbreakticks <= 0) continue;
                EntityUtil.disableShield(player, shieldbreakticks);
            }
        }
    }

    private void BlockBreaking() {
        boolean flag = false;
        if (!this.level().isClientSide() && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
            AABB aabb = this.getBoundingBox().inflate(1.5, 1.5, 1.5);
            for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || !blockstate.is(ModTag.CORALSSUS_BREAK) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
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
    }

    private void launch(LivingEntity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
        float f = huge ? 2.0f : 0.5f;
        e.push(d0 / d2 * (double)f, huge ? 0.5 : (double)0.2f, d1 / d2 * (double)f);
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

    protected void positionRider(Entity p_289537_, Entity.MoveFunction p_289541_) {
        super.positionRider(p_289537_, p_289541_);
        float f = 0.5f;
        Vec3 vec3 = this.getPassengerRidingPosition(p_289537_);
        Vec3 vec31 = p_289537_.getVehicleAttachmentPoint((Entity)this);
        Vec3 vec32 = new Vec3(0.0, 0.0, (double)f).yRot(-this.yBodyRot * ((float)Math.PI / 180));
        p_289541_.accept(p_289537_, vec3.x - vec31.x + vec32.x, this.getY(0.75), vec3.z - vec31.z + vec32.z);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.CORALSSUS_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.CORALSSUS_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.CORALSSUS_AMBIENT.get();
    }

    private boolean canInFluidType(FluidType type) {
        NeoForgeMod.WATER_TYPE.value();
        return type.canSwim((Entity)this.self());
    }

    public boolean isVisuallySwimming() {
        return this.getSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide((Mob)this, this.level());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator((Mob)this, this.level());
            this.isLandNavigator = false;
        }
    }

    public boolean getSwim() {
        return (Boolean)this.entityData.get(CORALSSUS_SWIM);
    }

    public void setSwim(boolean swim) {
        this.entityData.set(CORALSSUS_SWIM, (Object)swim);
    }

    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    @Override
    public boolean shouldEnterWater() {
        return this.getMoistness() < 300;
    }

    @Override
    public boolean shouldLeaveWater() {
        return this.getTarget() != null && !this.getTarget().isInWater();
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
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

    protected boolean closeToNextPos() {
        double d0;
        BlockPos blockpos;
        Path path = this.getNavigation().getPath();
        return path != null && (blockpos = path.getTarget()) != null && (d0 = this.distanceToSqr(blockpos.getX(), blockpos.getY(), blockpos.getZ())) < 4.0;
    }

    public void setSearchingForLand(boolean p_32399_) {
        this.searchingForLand = p_32399_;
    }

    static class CoralssusMoveControl
    extends MoveControl {
        private final Coralssus_Entity drowned;
        private final float speedMulti;

        public CoralssusMoveControl(Coralssus_Entity p_32433_, float speedMulti) {
            super((Mob)p_32433_);
            this.drowned = p_32433_;
            this.speedMulti = speedMulti;
        }

        public void tick() {
            LivingEntity livingentity = this.drowned.getTarget();
            if (this.drowned.wantsToSwim() && this.drowned.isInWater()) {
                if (livingentity != null && livingentity.getY() > this.drowned.getY() || this.drowned.searchingForLand) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0, 0.002, 0.0));
                }
                if (this.operation != MoveControl.Operation.MOVE_TO || this.drowned.getNavigation().isDone()) {
                    this.drowned.setSpeed(0.0f);
                    return;
                }
                double d0 = this.wantedX - this.drowned.getX();
                double d1 = this.wantedY - this.drowned.getY();
                double d2 = this.wantedZ - this.drowned.getZ();
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 /= d3;
                float f = (float)(Mth.atan2((double)d2, (double)d0) * 57.2957763671875) - 90.0f;
                this.drowned.setYRot(this.rotlerp(this.drowned.getYRot(), f, 90.0f));
                this.drowned.yBodyRot = this.drowned.getYRot();
                float f1 = (float)(this.speedModifier * (double)this.speedMulti * this.drowned.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float f2 = Mth.lerp((float)0.125f, (float)this.drowned.getSpeed(), (float)f1);
                this.drowned.setSpeed(f2);
                this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add((double)f2 * d0 * 0.005, (double)f2 * d1 * 0.1, (double)f2 * d2 * 0.005));
            } else {
                if (!this.drowned.onGround()) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0, -0.008, 0.0));
                }
                super.tick();
            }
        }
    }

    static class CoralssusswimUpGoal
    extends Goal {
        private final Coralssus_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public CoralssusswimUpGoal(Coralssus_Entity p_32440_, double p_32441_, int p_32442_) {
            this.drowned = p_32440_;
            this.speedModifier = p_32441_;
            this.seaLevel = p_32442_;
        }

        public boolean canUse() {
            return (this.drowned.level().isRaining() || this.drowned.isInWater()) && this.drowned.getY() < (double)(this.seaLevel - 2);
        }

        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }

        public void tick() {
            if (this.drowned.getY() < (double)(this.seaLevel - 1) && (this.drowned.getNavigation().isDone() || this.drowned.closeToNextPos())) {
                Vec3 vec3 = DefaultRandomPos.getPosTowards((PathfinderMob)this.drowned, (int)4, (int)8, (Vec3)new Vec3(this.drowned.getX(), (double)(this.seaLevel - 1), this.drowned.getZ()), (double)1.5707963705062866);
                if (vec3 == null) {
                    this.stuck = true;
                    return;
                }
                this.drowned.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
            }
        }

        public void start() {
            this.drowned.setSearchingForLand(true);
            this.stuck = false;
        }

        public void stop() {
            this.drowned.setSearchingForLand(false);
        }
    }

    public static enum Variant implements StringRepresentable
    {
        FIRE(0, "fire"),
        HORN(1, "horn"),
        TUBE(2, "tube");

        private static final IntFunction<Variant> BY_ID;
        public static final Codec<Variant> CODEC;
        final int id;
        private final String name;

        private Variant(int p_262657_, String p_262679_) {
            this.id = p_262657_;
            this.name = p_262679_;
        }

        public String getSerializedName() {
            return this.name;
        }

        public int id() {
            return this.id;
        }

        public static Variant byId(int p_262665_) {
            return BY_ID.apply(p_262665_);
        }

        static {
            BY_ID = ByIdMap.sparse(Variant::id, (Object[])Variant.values(), (Object)((Object)FIRE));
            CODEC = StringRepresentable.fromEnum(Variant::values);
        }
    }

    class Coralssus_JumpPrepareAttackGoal
    extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;

        public Coralssus_JumpPrepareAttackGoal(Coralssus_Entity entity, int attackstate, int attackendstate, int animationendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, float random) {
            super(entity, attackstate, attackendstate, animationendstate, attackMaxtick, attackseetick, attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo((Entity)target) > this.attackminrange && this.entity.getRandom().nextFloat() * 100.0f < this.random && Coralssus_Entity.this.jump_cooldown <= 0;
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks == 13) {
                if (target != null) {
                    this.entity.getLookControl().setLookAt((Entity)target, 60.0f, 30.0f);
                    Vec3 vec3 = new Vec3(target.getX() - this.entity.getX(), target.getY() - this.entity.getY(), target.getZ() - this.entity.getZ()).normalize();
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(vec3.x * 0.8, 1.0, vec3.z * 0.8));
                } else {
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, 1.0, 0.0));
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}

