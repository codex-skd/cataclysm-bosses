/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  javax.annotation.Nullable
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
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  SpawnReason
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.NeoForgeMod
 *  net.neoforged.neoforge.fluids.FluidType
 */
package com.skd.cataclysmbosses.entity.Deepling;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.CmAttackGoal;
import com.skd.cataclysmbosses.entity.AI.MobAIFindWater;
import com.skd.cataclysmbosses.entity.AI.MobAILeaveWater;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackAnimationGoal1;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.LLibrary_Monster;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.etc.ISemiAquatic;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.GroundPathNavigatorWide;
import com.skd.cataclysmbosses.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.world.data.CMWorldData;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import java.util.EnumSet;
import org.jspecify.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.SpawnReason;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;

public class Coral_Golem_Entity
extends LLibrary_Monster
implements ISemiAquatic {
    private boolean isLandNavigator;
    boolean searchingForLand;
    public static final Animation CORAL_GOLEM_LEAP = Animation.create((int)100);
    public static final Animation CORAL_GOLEM_SMASH = Animation.create((int)23);
    public static final Animation CORAL_GOLEM_LEFT_SMASH = Animation.create((int)36);
    public static final Animation CORAL_GOLEM_RIGHT_SMASH = Animation.create((int)36);
    public static final int LEAP_ATTACK_COOLDOWN = 160;
    private int leap_attack_cooldown = 0;
    private static final EntityDataAccessor<Boolean> GOLEMSWIM = SynchedEntityData.defineId(Coral_Golem_Entity.class, EntityDataSerializers.BOOLEAN);

    public Coral_Golem_Entity(EntityType<?> entity, Level world) {
        super(entity, world);
        this.xpReward = 15;
        this.moveControl = new GolemMoveControl(this, 2.0f);
        this.switchNavigator(false);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, CORAL_GOLEM_SMASH, CORAL_GOLEM_LEFT_SMASH, CORAL_GOLEM_RIGHT_SMASH, CORAL_GOLEM_LEAP};
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new GolemGoToBeachGoal(this, 1.0));
        this.goalSelector.addGoal(6, new GolemSwimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.goalSelector.addGoal(4, new MobAIFindWater(this, 1.0));
        this.goalSelector.addGoal(4, new MobAILeaveWater(this));
        this.goalSelector.addGoal(0, new AttackAnimationGoal1<Coral_Golem_Entity>(this, CORAL_GOLEM_LEFT_SMASH, 16, true));
        this.goalSelector.addGoal(0, new AttackAnimationGoal1<Coral_Golem_Entity>(this, CORAL_GOLEM_RIGHT_SMASH, 16, true));
        this.goalSelector.addGoal(0, new Leap(this, CORAL_GOLEM_LEAP));
        this.goalSelector.addGoal(0, new SimpleAnimationGoal<Coral_Golem_Entity>(this, CORAL_GOLEM_SMASH));
        this.goalSelector.addGoal(2, new CmAttackGoal(this, 1.0));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
    }

    public static AttributeSupplier.Builder coralgolem() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 11.0).add(Attributes.MAX_HEALTH, 110.0).add(Attributes.ARMOR, 5.0).add(Attributes.STEP_HEIGHT, 1.5).add(Attributes.KNOCKBACK_RESISTANCE, 0.8);
    }

    public boolean hurt(DamageSource source, float damage) {
        return super.hurt(source, damage);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(GOLEMSWIM, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, SpawnReason spawnReasonIn) {
        if (ModEntities.rollSpawn(CMCommonConfig.Spawning.CoralgolemSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)worldIn;
            if (super.checkSpawnRules(worldIn, spawnReasonIn)) {
                CMWorldData data = CMWorldData.get((Level)serverLevel, (ResourceKey<Level>)Level.OVERWORLD);
                return data != null && data.isLeviathanDefeatedOnce();
            }
        }
        return false;
    }

    public boolean checkSpawnObstruction(LevelReader p_32829_) {
        return p_32829_.isUnobstructed((Entity)this);
    }

    public static boolean cangolemSpawn(EntityType<? extends Coral_Golem_Entity> guardian, LevelAccessor level, SpawnReason spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (SpawnReason.isSpawner((SpawnReason)spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
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
        boolean flag1;
        super.tick();
        if (this.isInWater() && this.isLandNavigator) {
            this.switchNavigator(false);
        }
        if (!this.isInWater() && !this.isLandNavigator) {
            this.switchNavigator(true);
        }
        if (flag1 = this.canInFluidType(this.getEyeInFluidType())) {
            if (this.level().noCollision(this, this.getBoundingBox()) && !this.getSwim()) {
                this.setSwim(true);
            }
        } else if (this.level().noCollision(this, this.getBoundingBox()) && this.getSwim()) {
            this.setSwim(false);
        }
        if (this.leap_attack_cooldown > 0) {
            --this.leap_attack_cooldown;
        }
        LivingEntity target = this.getTarget();
        if (this.isAlive() && target != null && target.isAlive()) {
            if (!this.getSwim() && this.leap_attack_cooldown <= 0 && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && target.onGround() && this.random.nextInt(25) == 0 && this.distanceTo(target) <= 15.0f) {
                this.leap_attack_cooldown = 160;
                this.setAnimation(CORAL_GOLEM_LEAP);
            } else if (this.distanceTo(target) < 3.75f && !this.isNoAi() && this.getAnimation() == NO_ANIMATION) {
                Animation animation = Coral_Golem_Entity.getRandomAttack(this.random);
                this.setAnimation(animation);
            }
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAnimation() == CORAL_GOLEM_RIGHT_SMASH && this.getAnimationTick() == 16) {
            this.EarthQuake(3.0f, 2);
            this.Makeparticle(2.0f, -0.5f);
        }
        if (this.getAnimation() == CORAL_GOLEM_LEFT_SMASH && this.getAnimationTick() == 16) {
            this.EarthQuake(3.0f, 2);
            this.Makeparticle(2.0f, 0.5f);
        }
        if (this.getAnimation() == CORAL_GOLEM_SMASH && this.getAnimationTick() == 2) {
            this.EarthQuake(4.0f, 4);
            this.Makeparticle(2.25f, 1.25f);
            this.Makeparticle(2.25f, -1.25f);
        }
    }

    private void Makeparticle(float vec, float math) {
        if (this.level().isClientSide()) {
            for (int i1 = 0; i1 < 80 + this.random.nextInt(12); ++i1) {
                double DeltaMovementX = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementZ = this.getRandom().nextGaussian() * 0.07;
                float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
                float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = 0.75f * Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = 0.75f * Mth.cos((float)angle);
                double theta = (double)this.yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                double vecZ = Math.sin(theta);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
        }
    }

    protected void positionRider(Entity p_289537_, Entity.MoveFunction p_289541_) {
        super.positionRider(p_289537_, p_289541_);
        float radius = 0.5f;
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        double extraX = radius * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = radius * Mth.cos((float)angle);
        Vec3 vec3 = this.getPassengerRidingPosition(p_289537_);
        Vec3 vec31 = p_289537_.getVehicleAttachmentPoint(this);
        double px = vec3.x - vec31.x + extraX;
        double pz = vec3.z - vec31.z + extraZ;
        p_289541_.accept(p_289537_, px, this.getY(0.65), pz);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    private void EarthQuake(float grow, int damage) {
        ScreenShake_Entity.ScreenShake(this.level(), this.position(), 10.0f, 0.15f, 0, 20);
        this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate((double)grow))) {
            if (this.isAlliedTo(entity) || entity instanceof Coral_Golem_Entity || entity == this) continue;
            entity.hurt(this.damageSources().mobAttack((LivingEntity)this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float)this.random.nextInt(damage));
            this.launch(entity, true);
        }
    }

    private static Animation getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(2)) {
            case 0: {
                return CORAL_GOLEM_RIGHT_SMASH;
            }
            case 1: {
                return CORAL_GOLEM_LEFT_SMASH;
            }
        }
        return CORAL_GOLEM_RIGHT_SMASH;
    }

    private void launch(LivingEntity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
        float f = huge ? 2.0f : 0.5f;
        e.push(d0 / d2 * (double)f, huge ? 0.5 : (double)0.2f, d1 / d2 * (double)f);
    }

    public boolean isAlliedTo(@Nullable Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn != null && entityIn.getType().is(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0f, 1.0f);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.CORAL_GOLEM_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.CORAL_GOLEM_DEATH.get();
    }

    private boolean canInFluidType(FluidType type) {
        NeoForgeMod.WATER_TYPE.value();
        return type.canSwim(this);
    }

    public boolean isVisuallySwimming() {
        return this.getSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide(this, this.level());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, this.level());
            this.isLandNavigator = false;
        }
    }

    public boolean getSwim() {
        return this.entityData.get(GOLEMSWIM);
    }

    public void setSwim(boolean swim) {
        this.entityData.set(GOLEMSWIM, swim);
    }

    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    @Override
    public boolean shouldEnterWater() {
        return false;
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
        return new SmartBodyHelper2(this);
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

    static class GolemMoveControl
    extends MoveControl {
        private final Coral_Golem_Entity drowned;
        private final float speedMulti;

        public GolemMoveControl(Coral_Golem_Entity p_32433_, float speedMulti) {
            super(p_32433_);
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

    static class GolemGoToBeachGoal
    extends MoveToBlockGoal {
        private final Coral_Golem_Entity drowned;

        public GolemGoToBeachGoal(Coral_Golem_Entity p_32409_, double p_32410_) {
            super(p_32409_, p_32410_, 8, 2);
            this.drowned = p_32409_;
        }

        public boolean canUse() {
            return super.canUse() && this.drowned.level().isRaining() && this.drowned.isInWater() && this.drowned.getY() >= (double)(this.drowned.level().getSeaLevel() - 3);
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        protected boolean isValidTarget(LevelReader p_32413_, BlockPos p_32414_) {
            BlockPos blockpos = p_32414_.above();
            return p_32413_.isEmptyBlock(blockpos) && p_32413_.isEmptyBlock(blockpos.above()) ? p_32413_.getBlockState(p_32414_).entityCanStandOn(p_32413_, p_32414_, this.drowned) : false;
        }

        public void start() {
            this.drowned.setSearchingForLand(false);
            super.start();
        }

        public void stop() {
            super.stop();
        }
    }

    static class GolemSwimUpGoal
    extends Goal {
        private final Coral_Golem_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public GolemSwimUpGoal(Coral_Golem_Entity p_32440_, double p_32441_, int p_32442_) {
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
                Vec3 vec3 = DefaultRandomPos.getPosTowards(this.drowned, 4, 8, new Vec3(this.drowned.getX(), (double)(this.seaLevel - 1), this.drowned.getZ()), (double)1.5707963705062866);
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

    static class Leap
    extends SimpleAnimationGoal<Coral_Golem_Entity> {
        private final Coral_Golem_Entity drowned;

        public Leap(Coral_Golem_Entity entity, Animation animation) {
            super(entity, animation);
            this.drowned = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = this.drowned.getTarget();
            if (target != null) {
                this.drowned.lookAt(target, 30.0f, 30.0f);
                this.drowned.getLookControl().setLookAt(target, 30.0f, 30.0f);
                if (this.drowned.getAnimationTick() == 22) {
                    double d0 = target.getX() - this.drowned.getX();
                    double d1 = target.getY() - this.drowned.getY();
                    double d2 = target.getZ() - this.drowned.getZ();
                    this.drowned.setDeltaMovement(d0 * 0.15, 0.75 + Mth.clamp((double)(d1 * 0.05), (double)0.0, (double)10.0), d2 * 0.15);
                }
            } else if (this.drowned.getAnimationTick() == 22) {
                this.drowned.setDeltaMovement(0.0, 0.75, 0.0);
            }
            if (this.drowned.getAnimationTick() > 22 && this.drowned.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this.drowned, CORAL_GOLEM_SMASH);
            }
        }
    }
}

