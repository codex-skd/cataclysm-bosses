/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.LegSolverQuadruped
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.NodeEvaluator
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters;

import com.skd.thesundering.client.particle.Options.NotSpinTrailParticleOptions;
import com.skd.thesundering.client.particle.Options.RingParticleOptions;
import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.AI.HurtByNearestTargetGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters.ClawdianMoveController;
import com.skd.thesundering.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.thesundering.entity.effect.Cm_Falling_Block_Entity;
import com.skd.thesundering.entity.effect.ScreenShake_Entity;
import com.skd.thesundering.entity.effect.Wave_Entity;
import com.skd.thesundering.entity.etc.FowardMoveController;
import com.skd.thesundering.entity.etc.IHoldEntity;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.entity.etc.path.CMPathNavigateGround;
import com.skd.thesundering.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.thesundering.entity.projectile.Accretion_Entity;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.message.MessageEntityCameraSwitch;
import com.skd.thesundering.util.EntityUtil;
import com.skd.nautilusapi.server.animation.LegSolverQuadruped;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.network.PacketDistributor;

public class Clawdian_Entity
extends Internal_Animation_Monster
implements IHoldEntity {
    boolean searchingForLand;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState verticalswingAnimationState = new AnimationState();
    public AnimationState horizontalswingAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState chargeReadyAnimationState = new AnimationState();
    public AnimationState chargeLoopAnimationState = new AnimationState();
    public AnimationState chargeEndAnimationState = new AnimationState();
    public AnimationState waveStompAnimationState = new AnimationState();
    public AnimationState ClawPunchAnimationState = new AnimationState();
    public AnimationState GrabAndThrowAnimationState = new AnimationState();
    public AnimationState BackstepAnimationState = new AnimationState();
    public LegSolverQuadruped legSolver = new LegSolverQuadruped(-0.1f, 0.45f, 1.4f, 1.4f, 1.0f);
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 200;
    private int wave_cooldown = 0;
    public static final int WAVE_COOLDOWN = 250;
    private int accretion_cooldown = 0;
    public static final int ACCRETION_COOLDOWN = 120;
    private int backstep_cooldown = 0;
    public static final int BACKSTEP_COOLDOWN = 200;
    protected final int NATURE_HEAL_COOLDOWN = 80;
    private int self_regen;
    private static final EntityDataAccessor<Optional<BlockState>> HOLD_STATE = SynchedEntityData.defineId(Clawdian_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    private static final EntityDataAccessor<Integer> BACKSTEP_METER = SynchedEntityData.defineId(Clawdian_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    protected final SemiAquaticPathNavigator waterNavigation;
    protected final CMPathNavigateGround groundNavigation;

    public Clawdian_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 100;
        this.moveControl = new ClawdianMoveController((Mob)this);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.waterNavigation = new SemiAquaticPathNavigator((Mob)this, world);
        this.groundNavigation = new CMPathNavigateGround((Mob)this, world);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Clawdian.healthMultiplier, CMCommonConfig.Clawdian.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(3, (Goal)new InternalMoveGoal(this, true, 1.0));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 8, 0, 47, 19, 3.3f){

            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0f < 35.0f;
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 4, 5, 30, 30, 18.0f){

            @Override
            public boolean canUse() {
                BlockPos currentPos = this.entity.blockPosition();
                float yaw = this.entity.getYRot() * ((float)Math.PI / 180);
                float dx = -Mth.sin((float)yaw) * 2.0f;
                float dz = Mth.cos((float)yaw) * 2.0f;
                BlockPos targetPos = currentPos.offset((int)dx, 0, (int)dz);
                return super.canUse() && !Clawdian_Entity.this.isDangerousFallZone((PathfinderMob)this.entity, targetPos) && Clawdian_Entity.this.getRandom().nextFloat() * 100.0f < 17.0f && Clawdian_Entity.this.charge_cooldown <= 0 && this.entity.onGround() && !this.entity.isSwimming();
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalStateGoal(this, this, 5, 5, 6, 45, 45){

            @Override
            public void tick() {
                LivingEntity target = this.entity.getTarget();
                if (target != null) {
                    boolean flag;
                    boolean bl = flag = this.entity.attackTicks < this.attackseetick;
                    if (flag) {
                        this.entity.getLookControl().setLookAt((Entity)target, 2.0f, 30.0f);
                        this.entity.lookAt((Entity)target, 2.0f, 30.0f);
                    } else {
                        this.entity.getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                        this.entity.setYRot(this.entity.yRotO);
                    }
                } else {
                    this.entity.setYRot(this.entity.yRotO);
                }
                MoveControl moveControl = this.entity.getMoveControl();
                if (moveControl instanceof ClawdianMoveController) {
                    ClawdianMoveController onyxMoveController = (ClawdianMoveController)moveControl;
                    onyxMoveController.forward(1.0f, 2.0f);
                }
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 6, 6, 0, 10, 0){

            @Override
            public void stop() {
                super.stop();
                Clawdian_Entity.this.charge_cooldown = 200;
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 2, 0, 75, 48, 5.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0f < 27.0f;
            }

            @Override
            public void tick() {
                LivingEntity target = this.entity.getTarget();
                if (target != null) {
                    boolean flag;
                    boolean bl = flag = this.entity.attackTicks < this.attackseetick;
                    if (flag) {
                        this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                        this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                    } else {
                        this.entity.getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                        this.entity.setYRot(this.entity.yRotO);
                    }
                } else {
                    this.entity.setYRot(this.entity.yRotO);
                }
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 1, 0, 46, 19, 5.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0f < 30.0f;
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 7, 0, 53, 25, 10.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0f < 20.0f && Clawdian_Entity.this.wave_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Clawdian_Entity.this.wave_cooldown = 250;
            }
        });
        this.goalSelector.addGoal(2, (Goal)new Clawdian_Accretion(this, 0, 9, 0, 70, 30, 4.0f, 8.5f, 46.0f, 14.0f));
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 10, 0, 34, 33, 6.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0f < (float)(7 * Clawdian_Entity.this.getBackstep()) && Clawdian_Entity.this.backstep_cooldown <= 0;
            }

            @Override
            public void tick() {
                LivingEntity target = this.entity.getTarget();
                if (target != null) {
                    boolean flag;
                    boolean bl = flag = this.entity.attackTicks < this.attackseetick;
                    if (flag) {
                        this.entity.getLookControl().setLookAt((Entity)target, 2.0f, 30.0f);
                        this.entity.lookAt((Entity)target, 2.0f, 30.0f);
                    } else {
                        this.entity.getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                        this.entity.setYRot(this.entity.yRotO);
                    }
                } else {
                    this.entity.setYRot(this.entity.yRotO);
                }
                if (this.entity.attackTicks < 24) {
                    this.entity.getMoveControl().strafe(-2.0f, 0.0f);
                }
            }

            @Override
            public void stop() {
                super.stop();
                Clawdian_Entity.this.backstep_cooldown = 200;
                Clawdian_Entity.this.setBackstep(0);
            }
        });
    }

    public static AttributeSupplier.Builder clawdian() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 16.0).add(Attributes.MAX_HEALTH, 225.0).add(Attributes.ARMOR, 12.0).add(Attributes.ARMOR_TOUGHNESS, 3.0).add(Attributes.STEP_HEIGHT, 2.5).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected void blockedByShield(LivingEntity entity) {
        if (this.getAttackState() == 8) {
            double d0 = entity.getX() - this.getX();
            double d1 = entity.getZ() - this.getZ();
            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
            entity.push(d0 / d2 * 9.0, 0.2, d1 / d2 * 9.0);
            entity.hurtMarked = true;
        }
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01f, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(travelVector);
        }
    }

    private boolean isDangerousFallZone(PathfinderMob mob, BlockPos pos) {
        PathNavigation navigation = mob.getNavigation();
        NodeEvaluator evaluator = navigation.getNodeEvaluator();
        if (evaluator == null) {
            return false;
        }
        PathType pathTypeAtTarget = evaluator.getPathType((Mob)mob, (BlockPos)pos.mutable());
        if (pathTypeAtTarget == PathType.DAMAGE_CAUTIOUS || pathTypeAtTarget == PathType.DAMAGE_FIRE || pathTypeAtTarget == PathType.DAMAGE_OTHER || pathTypeAtTarget == PathType.DANGER_FIRE || pathTypeAtTarget == PathType.DANGER_OTHER) {
            return true;
        }
        BlockPos.MutableBlockPos checkPos = pos.mutable().move(Direction.DOWN);
        PathType pathTypeBelow = evaluator.getPathType((Mob)mob, (BlockPos)pos.mutable());
        if (pathTypeBelow == PathType.WALKABLE || pathTypeBelow == PathType.WALKABLE_DOOR) {
            return false;
        }
        int safeDrop = 3;
        for (int i = 0; i < safeDrop; ++i) {
            if (i > 0) {
                checkPos.move(Direction.DOWN);
            }
            if (mob.level().getBlockState((BlockPos)checkPos).isAir()) continue;
            return false;
        }
        return true;
    }

    public void updateSwimming() {
        if (!this.level().isClientSide()) {
            boolean inWaterAI;
            boolean bl = inWaterAI = this.isEffectiveAi() && this.isInWater() && this.wantsToSwim();
            if (inWaterAI && !(this.moveControl instanceof ClawdianSwimControl)) {
                this.navigation = this.waterNavigation;
                this.moveControl = new ClawdianSwimControl(this, 4.0f);
                this.setSwimming(true);
            } else if (!inWaterAI && this.moveControl instanceof ClawdianSwimControl) {
                this.navigation = this.groundNavigation;
                this.moveControl = new ClawdianMoveController((Mob)this);
                this.setSwimming(false);
            }
        }
    }

    public boolean hurt(DamageSource source, float damage) {
        boolean flag;
        Entity rider;
        Entity entity = source.getDirectEntity();
        if (this.canBlockDamageSource(source)) {
            this.playSound((SoundEvent)ModSounds.PARRY.get(), 0.2f, 1.4f);
            return false;
        }
        if (!this.getPassengers().isEmpty() && (rider = (Entity)this.getPassengers().get(0)).equals((Object)entity)) {
            return false;
        }
        if (source.is(ModTag.BLOCK_SELF_REGEN)) {
            this.self_regen = 80;
        }
        if ((flag = super.hurt(source, damage)) && this.getBackstep() < 10) {
            this.setBackstep(this.getBackstep() + 1);
        }
        return flag;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.CLAWDIAN_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.CLAWDIAN_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.CLAWDIAN_IDLE.get();
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Vec3 vector3d2;
        boolean flag = false;
        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && !flag && this.getAttackState() == 5 && (vector3d2 = damageSourceIn.getSourcePosition()) != null) {
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
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "vertical_swing") {
            return this.verticalswingAnimationState;
        }
        if (input == "horizontal_swing") {
            return this.horizontalswingAnimationState;
        }
        if (input == "charge_ready") {
            return this.chargeReadyAnimationState;
        }
        if (input == "charge_loop") {
            return this.chargeLoopAnimationState;
        }
        if (input == "charge_end") {
            return this.chargeEndAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "wave_stomp") {
            return this.waveStompAnimationState;
        }
        if (input == "claw_punch") {
            return this.ClawPunchAnimationState;
        }
        if (input == "grab_and_throw") {
            return this.GrabAndThrowAnimationState;
        }
        if (input == "backstep") {
            return this.BackstepAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(HOLD_STATE, Optional.empty());
        p_326229_.define(BACKSTEP_METER, (Object)0);
    }

    public void setHoldBlock(@Nullable BlockState state) {
        this.entityData.set(HOLD_STATE, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getHoldBlock() {
        return ((Optional)this.entityData.get(HOLD_STATE)).orElse(null);
    }

    public int getBackstep() {
        return (Integer)this.entityData.get(BACKSTEP_METER);
    }

    public void setBackstep(int hurt) {
        this.entityData.set(BACKSTEP_METER, (Object)hurt);
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
                    this.verticalswingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.horizontalswingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.chargeReadyAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.chargeLoopAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.chargeEndAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.waveStompAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 8: {
                    this.stopAllAnimationStates();
                    this.ClawPunchAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 9: {
                    this.stopAllAnimationStates();
                    this.GrabAndThrowAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 10: {
                    this.stopAllAnimationStates();
                    this.BackstepAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.verticalswingAnimationState.stop();
        this.horizontalswingAnimationState.stop();
        this.deathAnimationState.stop();
        this.chargeReadyAnimationState.stop();
        this.chargeLoopAnimationState.stop();
        this.chargeEndAnimationState.stop();
        this.waveStompAnimationState.stop();
        this.ClawPunchAnimationState.stop();
        this.GrabAndThrowAnimationState.stop();
        this.BackstepAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    @Override
    public int deathtimer() {
        return 45;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        BlockState blockstate = this.getHoldBlock();
        if (blockstate != null) {
            compound.put("holdBlockState", (Tag)NbtUtils.writeBlockState((BlockState)blockstate));
        }
        compound.putInt("backstep", this.getBackstep());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        BlockState blockstate = null;
        if (compound.contains("holdBlockState", 10) && (blockstate = NbtUtils.readBlockState((HolderGetter)this.level().holderLookup(Registries.BLOCK), (CompoundTag)compound.getCompound("holdBlockState"))).isAir()) {
            blockstate = null;
        }
        this.setHoldBlock(blockstate);
        this.setBackstep(compound.getInt("backstep"));
    }

    public float NatureRegen() {
        return (float)CMCommonConfig.Clawdian.natureHeal;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        } else {
            LivingEntity target = this.getTarget();
            if (!this.isNoAi() && this.self_regen <= 0 && !this.isNoAi() && this.NatureRegen() > 0.0f && target == null && this.tickCount % 20 == 0) {
                this.heal(this.NatureRegen());
            }
        }
        if (this.self_regen > 0) {
            --this.self_regen;
        }
        if (this.charge_cooldown > 0) {
            --this.charge_cooldown;
        }
        if (this.wave_cooldown > 0) {
            --this.wave_cooldown;
        }
        if (this.accretion_cooldown > 0) {
            --this.accretion_cooldown;
        }
        if (this.backstep_cooldown > 0) {
            --this.backstep_cooldown;
        }
        this.legSolver.update((LivingEntity)this, this.yBodyRot, this.getScale());
        float dis = this.getBbWidth() * 0.75f;
        if (this.getAttackState() != 5) {
            this.repelEntities(dis, this.getBbHeight(), dis, dis);
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 1) {
            if (this.attackTicks == 22) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.2f, 0, 20);
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 2.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 2.0f, 0.95f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(8.5f, 8.5f, 50.0f, 1.0f, 140, false, 2.25);
                this.Makeparticle(2.0f, 7.3f, 0.35f);
            }
            if (this.attackTicks == 22) {
                this.BlockSmashDamage(2.0f, 1, 2.5f, 7.3f, 160, 1.0f, 0.15f);
            }
            if (this.attackTicks == 25) {
                this.BlockSmashDamage(2.0f, 2, 2.5f, 7.3f, 160, 1.0f, 0.15f);
            }
        }
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 22) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 2.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(7.5f, 7.5f, 200.0f, 0.9f, 100, true, 2.25);
            }
            if (this.attackTicks == 50) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.2f, 0, 20);
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 2.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 2.0f, 0.95f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(8.5f, 8.5f, 50.0f, 1.15f, 160, false, 2.25);
                this.Makeparticle(2.0f, 7.3f, 0.35f);
            }
            if (this.attackTicks == 50) {
                this.BlockSmashDamage(2.0f, 1, 2.5f, 7.3f, 160, 1.0f, 0.15f);
            }
            if (this.attackTicks == 53) {
                this.BlockSmashDamage(2.0f, 2, 2.5f, 7.3f, 160, 1.0f, 0.15f);
            }
        }
        if (this.getAttackState() == 5 && !this.level().isClientSide()) {
            if (CMCommonConfig.Clawdian.ignoreMobGriefing) {
                this.ChargeBlockBreaking();
            } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                this.ChargeBlockBreaking();
            }
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            if (this.tickCount % 2 == 0) {
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2))) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)Lentity) || Lentity instanceof Clawdian_Entity || Lentity == this || !(flag = Lentity.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.6f)) || !Lentity.onGround()) continue;
                    double d0 = Lentity.getX() - this.getX();
                    double d1 = Lentity.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    float f = 1.5f;
                    Lentity.push(d0 / d2 * (double)f, (double)0.4f, d1 / d2 * (double)f);
                }
            }
        }
        if (this.getAttackState() == 7) {
            double vecZ;
            if (this.attackTicks == 27) {
                this.AreaAttack(3.5f, 3.5f, 120.0f, 1.35f, 200, false, 2.25);
                this.Makeparticle(2.0f, 0.9f, 0.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.25f, 0, 20);
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 2.0f, 0.95f + this.getRandom().nextFloat() * 0.1f);
                double theta = (double)this.yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                vecZ = Math.sin(theta);
                double vec = 2.0;
                if (!this.level().isClientSide()) {
                    int numberOfWaves = 6;
                    angleStep = 35.0f;
                    double firstAngleOffset = (double)(numberOfWaves - 1) / 2.0 * (double)angleStep;
                    for (i = 0; i < numberOfWaves; ++i) {
                        angle = (double)this.yBodyRot - firstAngleOffset + (double)((float)i * angleStep);
                        rad = Math.toRadians(angle);
                        dx = -Math.sin(rad);
                        dz = Math.cos(rad);
                        spawnX = this.getX() + vecX * vec;
                        spawnY = this.getY();
                        spawnZ = this.getZ() + vecZ * vec;
                        Wave_Entity WaveEntity = new Wave_Entity(this.level(), (LivingEntity)this, 80, 9.0f);
                        WaveEntity.setPos(spawnX, spawnY, spawnZ);
                        WaveEntity.setState(1);
                        WaveEntity.setYRot(-((float)(Mth.atan2((double)dx, (double)dz) * 57.29577951308232)));
                        this.level().addFreshEntity((Entity)WaveEntity);
                    }
                } else {
                    int numberOfWaves = 14;
                    angleStep = 15.0f;
                    double firstAngleOffset = (double)(numberOfWaves - 1) / 2.0 * (double)angleStep;
                    for (i = 0; i < numberOfWaves; ++i) {
                        angle = (double)this.yBodyRot - firstAngleOffset + (double)((float)i * angleStep);
                        rad = Math.toRadians(angle);
                        dx = -Math.sin(rad);
                        dz = Math.cos(rad);
                        spawnX = this.getX() + vecX * vec;
                        spawnY = this.getY();
                        spawnZ = this.getZ() + vecZ * vec;
                        double extraX = spawnX + dx * (1.0 + this.random.nextDouble() / 2.0);
                        double extraY = spawnY + 0.9 + this.random.nextDouble() * 0.5;
                        double extraZ = spawnZ + dz * (1.0 + this.random.nextDouble() / 2.0);
                        this.level().addParticle((ParticleOptions)new NotSpinTrailParticleOptions(0.44313726f, 0.7607843f, 0.9411765f, 0.05f, 0.5f + this.random.nextFloat() * 0.3f, 0.4f + this.random.nextFloat() * 0.2f, 0.0, 120), spawnX, spawnY, spawnZ, extraX, extraY, extraZ);
                    }
                }
            }
            if (this.attackTicks == 26) {
                this.BlockSmashDamage(0.6f, 1, 2.5f, 2.0f, 160, 1.0f, 0.15f);
                this.BlockSmashDamage(0.6f, 2, 2.5f, 2.0f, 160, 1.0f, 0.15f);
            }
            if (this.attackTicks == 28) {
                this.BlockSmashDamage(0.6f, 3, 2.5f, 2.0f, 160, 1.0f, 0.15f);
                this.BlockSmashDamage(0.6f, 4, 2.5f, 2.0f, 160, 1.0f, 0.15f);
            }
            if (this.attackTicks == 31 && !this.level().isClientSide()) {
                double theta = (double)this.yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                vecZ = Math.sin(theta);
                int numberOfSkulls = 5;
                float angleStep = 35.0f;
                double firstAngleOffset = (double)(numberOfSkulls - 1) / 2.0 * (double)angleStep;
                for (int i = 0; i < numberOfSkulls; ++i) {
                    double angle = (double)this.yBodyRot - firstAngleOffset + (double)((float)i * angleStep);
                    double rad = Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    double spawnX = this.getX() + vecX * 2.0;
                    double spawnY = this.getY();
                    double spawnZ = this.getZ() + vecZ * 2.0;
                    Wave_Entity WaveEntity = new Wave_Entity(this.level(), (LivingEntity)this, 80, 9.0f);
                    WaveEntity.setPos(spawnX, spawnY, spawnZ);
                    WaveEntity.setState(1);
                    WaveEntity.setYRot(-((float)(Mth.atan2((double)dx, (double)dz) * 57.29577951308232)));
                    this.level().addFreshEntity((Entity)WaveEntity);
                }
            }
        }
        if (this.getAttackState() == 8) {
            if (this.attackTicks == 18) {
                this.playSound((SoundEvent)ModSounds.CRAB_BITE.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.attackTicks == 21) {
                this.AreaAttack(4.5f, 4.5f, 140.0f, 1.0f, 200, true, 2.25);
            }
        }
        if (this.getAttackState() == 9) {
            if (this.attackTicks == 16) {
                this.playSound(SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.Makeparticle(0.6f, 2.5f, -0.5f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.25f, 0, 20);
                this.HoldAttack(4.5f, 4.5f, 60.0f, 1.0f, 120);
            }
            if (!this.getPassengers().isEmpty() && ((Entity)this.getPassengers().get(0)).isShiftKeyDown()) {
                ((Entity)this.getPassengers().get(0)).setShiftKeyDown(false);
            }
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
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.DUST_PILLAR, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
            this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 30, 255, 255, 255, 1.0f, 20.0f, false, 2), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.2f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void BlockSmashDamage(float spreadarc, int distance, float mxy, float vec, int shieldbreakticks, float damage, float airborne) {
        double bodyRotRad = (double)this.yBodyRot * (Math.PI / 180);
        double cosBodyRot = Math.cos(bodyRotRad);
        double sinBodyRot = Math.sin(bodyRotRad);
        double facingAngle = bodyRotRad + 1.5707963267948966;
        double commonOffsetX = (double)vec * -sinBodyRot;
        double commonOffsetZ = (double)vec * cosBodyRot;
        double baseX = this.getX() + commonOffsetX;
        double baseZ = this.getZ() + commonOffsetZ;
        int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
        double minY = this.getY() - 1.0;
        double maxY = this.getY() + (double)mxy;
        double spread = Math.PI * (double)spreadarc;
        int arcLen = Mth.ceil((double)((double)distance * spread));
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (int i = 0; i < arcLen; ++i) {
                double thetaRatio = arcLen > 1 ? (double)i / (double)(arcLen - 1) : 0.5;
                double theta = (thetaRatio - 0.5) * spread + facingAngle;
                double vx = Math.cos(theta);
                double vz = Math.sin(theta);
                double px = baseX + vx * (double)distance;
                double pz = baseZ + vz * (double)distance;
                int hitX = Mth.floor((double)px);
                int hitZ = Mth.floor((double)pz);
                BlockPos pos = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(pos);
                int maxDepth = 256;
                for (int depthCount = 0; depthCount < maxDepth && block.getRenderShape() != RenderShape.MODEL; ++depthCount) {
                    pos = pos.below();
                    block = this.level().getBlockState(pos);
                }
                if (block.getRenderShape() != RenderShape.MODEL) {
                    block = Blocks.AIR.defaultBlockState();
                }
                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, block, 10);
                fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
                this.level().addFreshEntity((Entity)fallingBlockEntity);
                AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
                List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
                for (LivingEntity entity : hit) {
                    if (this.isAlliedTo((Entity)entity) || entity instanceof Clawdian_Entity || entity == this) continue;
                    boolean flag = entity.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                        Player player = (Player)entity;
                        if (shieldbreakticks > 0) {
                            EntityUtil.disableShield(player, shieldbreakticks);
                        }
                    }
                    if (!flag) continue;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, (double)airborne + this.level().random.nextDouble() * 0.15, 0.0));
                }
            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean knockback, double xz) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Clawdian_Entity || entityHit == this) continue;
                boolean hurt = entityHit.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                double d0 = entityHit.getX() - this.getX();
                double d1 = entityHit.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                if (!hurt || !knockback) continue;
                entityHit.push(d0 / d2 * xz, 0.15, d1 / d2 * xz);
            }
        }
    }

    private void HoldAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || entityHit instanceof Clawdian_Entity || entityHit == this) continue;
                if (!entityHit.getType().is(ModTag.IGNIS_CANT_POKE) && entityHit.isAlive() && this.getPassengers().isEmpty()) {
                    if (entityHit.isShiftKeyDown()) {
                        entityHit.setShiftKeyDown(false);
                    }
                    if (!entityHit.hurt(damagesource, 1.0f)) continue;
                    entityHit.startRiding((Entity)this, true);
                    PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)entityHit, (CustomPacketPayload)new MessageEntityCameraSwitch.ThridPerson(entityHit.getId()), (CustomPacketPayload[])new CustomPacketPayload[0]);
                    continue;
                }
                if (this.isAlliedTo((Entity)entityHit)) continue;
                entityHit.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
            }
        }
    }

    private void ChargeBlockBreaking() {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5, 0.2, 0.5);
        for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.CLAWDIAN_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
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

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_SCYLLA)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    public boolean canRiderInteract() {
        return true;
    }

    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        Vec3 vec3 = this.getPassengerRidingPosition(passenger);
        Vec3 vec31 = passenger.getVehicleAttachmentPoint((Entity)this);
        double px = vec3.x - vec31.x + 2.5 * vecX;
        double pz = vec3.z - vec31.z + 2.5 * vecZ;
        double PosY = this.getY() + (double)this.getBbHeight() * 0.8;
        if (this.hasPassenger(passenger)) {
            moveFunc.accept(passenger, px, PosY, pz);
        }
    }

    public boolean shouldRiderSit() {
        return false;
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

    protected boolean isAffectedByFluids() {
        return true;
    }

    public boolean isPushedByFluid() {
        return false;
    }

    static class Clawdian_Accretion
    extends InternalAttackGoal {
        private final Clawdian_Entity entity;
        private final float meleerandom;
        private final float rangerandom;
        private final int getattackstate;
        private final int attackseetick;
        private final float Meleeattackrange;
        private final float attackrange;

        public Clawdian_Accretion(Clawdian_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float Meleeattackrange, float attackrange, float meleerandom, float rangerandom) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.meleerandom = meleerandom;
            this.rangerandom = rangerandom;
            this.getattackstate = getAttackState;
            this.attackseetick = attackseetick;
            this.Meleeattackrange = Meleeattackrange;
            this.attackrange = attackrange;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.accretion_cooldown <= 0 && this.entity.getAttackState() == this.getattackstate && this.entity.onGround() && !this.entity.isSwimming() && (this.entity.distanceTo((Entity)target) < this.Meleeattackrange && this.entity.getRandom().nextFloat() * 100.0f < this.meleerandom || this.entity.distanceTo((Entity)target) > this.attackrange && this.entity.getRandom().nextFloat() * 100.0f < this.rangerandom);
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.accretion_cooldown = 120;
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                boolean flag;
                boolean bl = flag = this.entity.attackTicks > this.attackseetick;
                if (flag) {
                    this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    this.entity.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    this.entity.getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                    this.entity.setYRot(this.entity.yRotO);
                }
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            double theta = (double)this.entity.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            if (this.entity.attackTicks == 29) {
                double vec = 2.0;
                int hitX = Mth.floor((double)(this.entity.getX() + vec * vecX));
                int hitY = Mth.floor((double)this.entity.getY());
                int hitZ = Mth.floor((double)(this.entity.getZ() + vec * vecZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.entity.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.MODEL) {
                    this.entity.setHoldBlock(block.getBlock().defaultBlockState());
                } else {
                    this.entity.setHoldBlock(Blocks.STONE.defaultBlockState());
                }
            }
            this.entity.getNavigation().stop();
            if (this.entity.attackTicks == 45) {
                int count = 4;
                if (target != null) {
                    double vec = 2.5;
                    double offsetangle = Math.toRadians(4 + this.entity.random.nextInt(5));
                    for (int i = 0; i <= count - 1; ++i) {
                        Accretion_Entity acc = new Accretion_Entity((EntityType<Accretion_Entity>)((EntityType)ModEntities.ACCRETION.get()), this.entity.level(), (LivingEntity)this.entity);
                        double angle = ((double)i - (double)(count - 1) / 2.0) * offsetangle;
                        double d1 = target.getX() - this.entity.getX();
                        double d3 = target.getZ() - this.entity.getZ();
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);
                        double d2 = target.getY(0.2) - acc.getY() + ((double)this.entity.random.nextFloat() - 0.5) * (double)i;
                        double PosX = this.entity.getX() + vecX * vec;
                        double PosY = this.entity.getY() + (double)this.entity.getBbHeight() * 0.8;
                        double PosZ = this.entity.getZ() + vecZ * vec;
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(x, d2 + distance * (double)0.2f, z, 1.4f, 4.0f);
                        acc.setDamage(15.0f);
                        acc.setBlockState(this.entity.getHoldBlock());
                        acc.level().addFreshEntity((Entity)acc);
                    }
                } else {
                    double tempvec = 12.0;
                    double vec = 2.5;
                    double d1 = this.entity.getX() + vecX * tempvec - this.entity.getX();
                    double d3 = this.entity.getZ() + vecZ * tempvec - this.entity.getZ();
                    double offsetangle = Math.toRadians(4 + this.entity.random.nextInt(5));
                    for (int i = 0; i <= count - 1; ++i) {
                        Accretion_Entity acc = new Accretion_Entity((EntityType<Accretion_Entity>)((EntityType)ModEntities.ACCRETION.get()), this.entity.level(), (LivingEntity)this.entity);
                        double angle = ((double)i - (double)(count - 1) / 2.0) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);
                        double d2 = this.entity.getY(0.2) - acc.getY() + ((double)this.entity.random.nextFloat() - 0.5) * (double)i;
                        double PosX = this.entity.getX() + vecX * vec;
                        double PosY = this.entity.getY() + (double)this.entity.getBbHeight() * 0.8;
                        double PosZ = this.entity.getZ() + vecZ * vec;
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(x, d2 + distance * (double)0.2f, z, 1.4f, 4.0f);
                        acc.setDamage(15.0f);
                        acc.setBlockState(this.entity.getHoldBlock());
                        acc.level().addFreshEntity((Entity)acc);
                    }
                }
                if (!this.entity.getPassengers().isEmpty()) {
                    Entity rider = (Entity)this.entity.getPassengers().get(0);
                    double vec = 2.5;
                    if (rider.equals((Object)target) || target == null) {
                        double tempvec = 12.0;
                        double d1 = this.entity.getX() + vecX * tempvec - this.entity.getX();
                        double d2 = this.entity.getY(0.2) - rider.getY();
                        double d3 = this.entity.getZ() + vecZ * tempvec - this.entity.getZ();
                        double distance = Mth.sqrt((float)((float)(d1 * d1 + d3 * d3)));
                        double PosX = this.entity.getX() + vecX * vec;
                        double PosY = this.entity.getY() + (double)this.entity.getBbHeight() * 0.8;
                        double PosZ = this.entity.getZ() + vecZ * vec;
                        Accretion_Entity acc = new Accretion_Entity((EntityType<Accretion_Entity>)((EntityType)ModEntities.ACCRETION.get()), this.entity.level(), (LivingEntity)this.entity);
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(d1, d2 + distance * (double)0.2f, d3, 1.4f, 4.0f);
                        acc.setDamage(15.0f);
                        acc.setBlockState(this.entity.getHoldBlock());
                        rider.startRiding((Entity)acc, true);
                        acc.level().addFreshEntity((Entity)acc);
                    } else {
                        double d1 = target.getX() - this.entity.getX();
                        double d3 = target.getZ() - this.entity.getZ();
                        double d2 = target.getY(0.2) - rider.getY();
                        double distance = Mth.sqrt((float)((float)(d1 * d1 + d3 * d3)));
                        double PosX = this.entity.getX() + vecX * vec;
                        double PosY = this.entity.getY() + (double)this.entity.getBbHeight() * 0.8;
                        double PosZ = this.entity.getZ() + vecZ * vec;
                        Accretion_Entity acc = new Accretion_Entity((EntityType<Accretion_Entity>)((EntityType)ModEntities.ACCRETION.get()), this.entity.level(), (LivingEntity)this.entity);
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(d1, d2 + distance * (double)0.2f, d3, 1.4f, 4.0f);
                        acc.setDamage(15.0f);
                        acc.setBlockState(this.entity.getHoldBlock());
                        rider.startRiding((Entity)acc, true);
                        acc.level().addFreshEntity((Entity)acc);
                    }
                }
            }
            if (this.entity.attackTicks == 46) {
                this.entity.setHoldBlock(null);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ClawdianSwimControl
    extends FowardMoveController {
        private final Clawdian_Entity drowned;
        private final float speedMulti;

        public ClawdianSwimControl(Clawdian_Entity p_32433_, float speedMulti) {
            super((Mob)p_32433_);
            this.drowned = p_32433_;
            this.speedMulti = speedMulti;
        }

        @Override
        public void tick() {
            LivingEntity livingentity = this.drowned.getTarget();
            if (this.drowned.wantsToSwim() && this.drowned.isInWater()) {
                if (livingentity != null && livingentity.getY() > this.drowned.getY() || this.drowned.searchingForLand) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0, 0.002, 0.0));
                }
                if (this.operation != FowardMoveController.FowardOperation.MOVE_TO || this.drowned.getNavigation().isDone()) {
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
}

