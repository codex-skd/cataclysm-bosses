/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
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
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
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
package com.skd.thesundering.entity.Deepling;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.Deepling.AbstractDeepling;
import com.skd.thesundering.entity.Deepling.Lionfish_Entity;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModSounds;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

public class Deepling_Angler_Entity
extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_MELEE = Animation.create((int)20);
    public static final Animation DEEPLING_HUG = Animation.create((int)20);
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed((float)1.225f, (float)0.65f);
    private int hugcooldown = 100;
    public static final int HUG_COOLDOWN = 100;

    public Deepling_Angler_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.moveControl = new DeeplingMoveControl(this, 2.0f);
        this.switchNavigator(false);
        this.xpReward = 8;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, (Goal)new DeeplingGoToBeachGoal(this, 1.0));
        this.goalSelector.addGoal(6, (Goal)new DeeplingSwimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]).setAlertOthers(new Class[0]));
        this.goalSelector.addGoal(3, (Goal)new AnimationMeleeAttackGoal(this, 1.0, false));
    }

    public static AttributeSupplier.Builder deepling() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.MAX_HEALTH, 30.0).add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation((Mob)this, worldIn);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219154_, DifficultyInstance p_219155_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.FISHING_ROD));
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

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return ModEntities.rollSpawn(CMCommonConfig.Spawning.DeeplingAnglerSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, MobSpawnType p_34090_, @Nullable SpawnGroupData p_34091_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        Lionfish_Entity drowned = (Lionfish_Entity)((EntityType)ModEntities.LIONFISH.get()).create(this.level());
        drowned.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        drowned.copyPosition((Entity)this);
        drowned.setLeashedTo((Entity)this, true);
        p_34088_.addFreshEntity((Entity)drowned);
        return spawngroupdata;
    }

    public boolean checkSpawnObstruction(LevelReader p_32829_) {
        return p_32829_.isUnobstructed((Entity)this);
    }

    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Angler_Entity> guardian, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (MobSpawnType.isSpawner((MobSpawnType)spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE, DEEPLING_HUG};
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (this.hugcooldown > 0) {
            --this.hugcooldown;
        }
        if (this.isAlive()) {
            float damage;
            if (this.getAnimation() == DEEPLING_MELEE && this.getAnimationTick() == 5) {
                this.playSound((SoundEvent)ModSounds.DEEPLING_SWING.get(), 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                if (target != null && this.distanceTo((Entity)target) < 3.0f) {
                    damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    target.hurt(this.damageSources().mobAttack((LivingEntity)this), damage);
                }
            }
            if (this.getAnimation() == DEEPLING_HUG && this.getAnimationTick() == 9) {
                this.playSound((SoundEvent)ModSounds.DEEPLING_SWING.get(), 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                if (target != null && this.distanceTo((Entity)target) < 3.0f) {
                    damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    boolean flag = target.hurt(this.damageSources().mobAttack((LivingEntity)this), damage);
                    if (flag) {
                        target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 1), (Entity)this);
                    }
                }
            }
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
    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
    }

    @Override
    public AABB getSwimmingBox() {
        return new AABB(this.getX() - (double)1.225f, this.getY(), this.getZ() - (double)1.225f, this.getX() + (double)1.225f, this.getY() + (double)0.65f, this.getZ() + (double)1.225f);
    }

    @Override
    public AABB getNormalBox() {
        return new AABB(this.getX() - (double)0.65f, this.getY(), this.getZ() - (double)0.65f, this.getX() + (double)0.65f, this.getY() + (double)2.45f, this.getZ() + (double)0.65f);
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
        private final Deepling_Angler_Entity drowned;
        private final float speedMulti;

        public DeeplingMoveControl(Deepling_Angler_Entity p_32433_, float speedMulti) {
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

    static class DeeplingGoToBeachGoal
    extends MoveToBlockGoal {
        private final Deepling_Angler_Entity drowned;

        public DeeplingGoToBeachGoal(Deepling_Angler_Entity p_32409_, double p_32410_) {
            super((PathfinderMob)p_32409_, p_32410_, 8, 2);
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
            return p_32413_.isEmptyBlock(blockpos) && p_32413_.isEmptyBlock(blockpos.above()) ? p_32413_.getBlockState(p_32414_).entityCanStandOn((BlockGetter)p_32413_, p_32414_, (Entity)this.drowned) : false;
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
        private final Deepling_Angler_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public DeeplingSwimUpGoal(Deepling_Angler_Entity p_32440_, double p_32441_, int p_32442_) {
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

    static class AnimationMeleeAttackGoal
    extends MeleeAttackGoal {
        protected final Deepling_Angler_Entity mob;

        public AnimationMeleeAttackGoal(Deepling_Angler_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super((PathfinderMob)p_25552_, p_25553_, p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        protected void checkAndPerformAttack(LivingEntity p_25557_) {
            if (this.canPerformAttack(p_25557_)) {
                if (this.mob.hugcooldown <= 0) {
                    this.mob.setAnimation(DEEPLING_HUG);
                    this.mob.hugcooldown = 100;
                } else {
                    this.mob.setAnimation(DEEPLING_MELEE);
                }
            }
        }
    }
}

