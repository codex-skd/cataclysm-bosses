/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  SpawnReason
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.Deepling;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.Deepling.AbstractDeepling;
import com.skd.cataclysmbosses.entity.projectile.ThrownCoral_Bardiche_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.SpawnReason;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class Deepling_Brute_Entity
extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_BRUTE_TRIDENT_THROW = Animation.create((int)45);
    public static final Animation DEEPLING_BRUTE_MELEE = Animation.create((int)20);
    private int SpinAttackTicks;
    private static final EntityDataAccessor<Boolean> SPINATTACK = SynchedEntityData.defineId(Deepling_Brute_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed((float)1.3f, (float)0.7f);

    public Deepling_Brute_Entity(EntityType<?> entity, Level world) {
        super(entity, world);
        this.moveControl = new DeeplingMoveControl(this, 2.0f);
        this.switchNavigator(false);
        this.xpReward = 15;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new DeeplingBruteTridentShoot(this, 1.0, 15.0f));
        this.goalSelector.addGoal(5, new DeeplingGoToBeachGoal(this, 1.0));
        this.goalSelector.addGoal(6, new DeeplingSwimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
        this.goalSelector.addGoal(3, new AnimationMeleeAttackGoal(this, 1.1f, false));
    }

    public static AttributeSupplier.Builder deeplingbrute() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.29f).add(Attributes.ATTACK_DAMAGE, 5.0).add(Attributes.MAX_HEALTH, 60.0).add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.ARMOR, 8.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.35);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(SPINATTACK, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Moisture", this.getMoistness());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setMoistness(compound.getInt("Moisture"));
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219154_, DifficultyInstance p_219155_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)ModItems.CORAL_BARDICHE.get()));
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.DEEPLING_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.DEEPLING_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.DEEPLING_DEATH.get();
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound((SoundEvent)ModSounds.DEEPLING_IDLE.get(), 0.15f, 0.6f);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, SpawnReason spawnReasonIn) {
        return ModEntities.rollSpawn(CMCommonConfig.Spawning.DeeplingBruteSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, SpawnReason p_34090_, @Nullable SpawnGroupData p_34091_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        return spawngroupdata;
    }

    public boolean checkSpawnObstruction(LevelReader p_32829_) {
        return p_32829_.isUnobstructed((Entity)this);
    }

    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Brute_Entity> guardian, LevelAccessor level, SpawnReason spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (SpawnReason.isSpawner((SpawnReason)spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_BRUTE_TRIDENT_THROW, DEEPLING_BRUTE_MELEE};
    }

    public boolean getSpinAttack() {
        return this.entityData.get(SPINATTACK);
    }

    public void setSpinAttack(boolean p_211137_1_) {
        this.entityData.set(SPINATTACK, p_211137_1_);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (this.isAlive()) {
            if (this.getAnimation() == DEEPLING_BRUTE_TRIDENT_THROW && target != null && this.getAnimationTick() == 11) {
                if (this.isInWaterOrRain() && !this.isPassenger()) {
                    double f1 = target.getX() - this.getX();
                    double f2 = target.getY() - this.getY();
                    double f3 = target.getZ() - this.getZ();
                    double f4 = Mth.sqrt((float)((float)(f1 * f1 + f2 * f2 + f3 * f3)));
                    float f5 = 2.0f;
                    this.push(f1 *= (double)f5 / f4, f2 *= (double)f5 / f4, f3 *= (double)f5 / f4);
                    this.startAutoSpinAttack(20);
                    if (this.onGround()) {
                        this.move(MoverType.SELF, new Vec3(0.0, 1.1999999284744263, 0.0));
                    }
                    this.playSound((SoundEvent)SoundEvents.TRIDENT_RIPTIDE_3.value(), 1.0f, 1.0f);
                } else {
                    ThrownCoral_Bardiche_Entity throwntrident = new ThrownCoral_Bardiche_Entity(this.level(), this, new ItemStack(ModItems.CORAL_BARDICHE.get()));
                    double p0 = target.getX() - this.getX();
                    double p1 = target.getY(0.3333333333333333) - throwntrident.getY();
                    double p2 = target.getZ() - this.getZ();
                    double p3 = Math.sqrt(p0 * p0 + p2 * p2);
                    throwntrident.shoot(p0, p1 + p3 * (double)0.2f, p2, 1.6f, 14 - this.level().getDifficulty().getId() * 4);
                    this.playSound(SoundEvents.DROWNED_SHOOT, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                    this.level().addFreshEntity((Entity)throwntrident);
                }
            }
            if (this.getAnimation() == DEEPLING_BRUTE_MELEE && this.getAnimationTick() == 5) {
                this.playSound((SoundEvent)ModSounds.DEEPLING_SWING.get(), 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                if (target != null && this.distanceTo(target) < 3.0f) {
                    float damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    target.hurt(this.damageSources().mobAttack((LivingEntity)this), damage);
                }
            }
        }
        AABB aabb = this.getBoundingBox();
        if (this.SpinAttackTicks > 0) {
            --this.SpinAttackTicks;
            this.checkAutoSpinAttack(aabb, this.getBoundingBox());
        }
    }

    public void startAutoSpinAttack(int p_204080_) {
        this.SpinAttackTicks = p_204080_;
        if (!this.level().isClientSide()) {
            this.setSpinAttack(true);
        }
    }

    protected void checkAutoSpinAttack(AABB p_21072_, AABB p_21073_) {
        AABB aabb = p_21072_.minmax(p_21073_);
        List<Entity> list = this.level().getEntities(this, aabb);
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                if (!(entity instanceof LivingEntity)) continue;
                entity.hurt(this.damageSources().mobAttack((LivingEntity)this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                this.SpinAttackTicks = 0;
                this.setDeltaMovement(this.getDeltaMovement().scale(-0.2));
                break;
            }
        } else if (this.horizontalCollision) {
            this.SpinAttackTicks = 0;
        }
        if (!this.level().isClientSide() && this.SpinAttackTicks <= 0) {
            this.setSpinAttack(false);
        }
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    @Override
    public AABB getSwimmingBox() {
        return new AABB(this.getX() - (double)1.3f, this.getY(), this.getZ() - (double)1.3f, this.getX() + (double)1.3f, this.getY() + (double)0.7f, this.getZ() + (double)1.3f);
    }

    @Override
    public AABB getNormalBox() {
        return new AABB(this.getX() - (double)0.7f, this.getY(), this.getZ() - (double)0.7f, this.getX() + (double)0.7f, this.getY() + (double)2.6f, this.getZ() + (double)0.7f);
    }

    @Override
    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
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
    protected AABB getAttackBoundingBox() {
        AABB aabb = super.getAttackBoundingBox();
        return aabb.deflate(0.05, 0.0, 0.05);
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

    static class DeeplingMoveControl
    extends MoveControl {
        private final Deepling_Brute_Entity drowned;
        private final float speedMulti;

        public DeeplingMoveControl(Deepling_Brute_Entity p_32433_, float speedMulti) {
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

    static class DeeplingBruteTridentShoot
    extends Goal {
        private final Deepling_Brute_Entity mob;
        private final double moveSpeedAmp;
        private int attackCooldown;
        private final float maxAttackDistance;
        private int attackTime = -1;
        private int seeTime;
        private boolean strafingClockwise;
        private boolean strafingBackwards;
        private int strafingTime = -1;

        public DeeplingBruteTridentShoot(Deepling_Brute_Entity mob, double moveSpeedAmpIn, float maxAttackDistanceIn) {
            this.mob = mob;
            this.moveSpeedAmp = moveSpeedAmpIn;
            this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.mob.getTarget();
            return livingentity != null && livingentity.isAlive() && this.mob.getMainHandItem().is(ModItems.CORAL_BARDICHE.get()) && this.mob.distanceToSqr(livingentity) >= 36.0;
        }

        public boolean canContinueToUse() {
            return this.canUse() || !this.mob.getNavigation().isDone();
        }

        public void start() {
            super.start();
            this.mob.setAggressive(true);
            this.mob.startUsingItem(InteractionHand.MAIN_HAND);
        }

        public void stop() {
            super.stop();
            this.mob.setAggressive(false);
            this.seeTime = 0;
            this.attackTime = -1;
            this.mob.stopUsingItem();
        }

        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity != null) {
                boolean flag1;
                double d0 = this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                boolean flag = this.mob.hasLineOfSight((Entity)livingentity);
                boolean bl = flag1 = this.seeTime > 0;
                if (flag != flag1) {
                    this.seeTime = 0;
                }
                this.seeTime = flag ? ++this.seeTime : --this.seeTime;
                if (!(d0 > (double)this.maxAttackDistance) && this.seeTime >= 20) {
                    this.mob.getNavigation().stop();
                    ++this.strafingTime;
                } else {
                    this.mob.getNavigation().moveTo(livingentity, this.moveSpeedAmp);
                    this.strafingTime = -1;
                }
                if (this.strafingTime >= 20) {
                    if ((double)this.mob.getRandom().nextFloat() < 0.3) {
                        boolean bl2 = this.strafingClockwise = !this.strafingClockwise;
                    }
                    if ((double)this.mob.getRandom().nextFloat() < 0.3) {
                        this.strafingBackwards = !this.strafingBackwards;
                    }
                    this.strafingTime = 0;
                }
                if (this.strafingTime > -1) {
                    if (d0 > (double)(this.maxAttackDistance * 0.75f)) {
                        this.strafingBackwards = false;
                    } else if (d0 < (double)(this.maxAttackDistance * 0.25f)) {
                        this.strafingBackwards = true;
                    }
                    this.mob.getMoveControl().strafe(this.strafingBackwards ? -0.5f : 0.5f, this.strafingClockwise ? 0.5f : -0.5f);
                    this.mob.lookAt(livingentity, 30.0f, 30.0f);
                } else {
                    this.mob.getLookControl().setLookAt(livingentity, 30.0f, 30.0f);
                }
                if (!flag && this.seeTime < -60) {
                    this.mob.stopUsingItem();
                } else if (flag && this.mob.getAnimation() != DEEPLING_BRUTE_TRIDENT_THROW) {
                    this.mob.setAnimation(DEEPLING_BRUTE_TRIDENT_THROW);
                    this.attackTime = this.attackCooldown;
                }
            }
        }
    }

    static class DeeplingGoToBeachGoal
    extends MoveToBlockGoal {
        private final Deepling_Brute_Entity drowned;

        public DeeplingGoToBeachGoal(Deepling_Brute_Entity p_32409_, double p_32410_) {
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

    static class DeeplingSwimUpGoal
    extends Goal {
        private final Deepling_Brute_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public DeeplingSwimUpGoal(Deepling_Brute_Entity p_32440_, double p_32441_, int p_32442_) {
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

    static class AnimationMeleeAttackGoal
    extends MeleeAttackGoal {
        protected final Deepling_Brute_Entity mob;

        public AnimationMeleeAttackGoal(Deepling_Brute_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_, p_25553_, p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        protected void checkAndPerformAttack(LivingEntity p_25557_) {
            if (this.canPerformAttack(p_25557_) && this.mob.getAnimation() == IAnimatedEntity.NO_ANIMATION) {
                this.mob.setAnimation(DEEPLING_BRUTE_MELEE);
            }
        }
    }
}

