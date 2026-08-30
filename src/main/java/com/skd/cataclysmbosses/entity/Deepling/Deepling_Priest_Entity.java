/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.FluidTags
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
 *  EntitySpawnReason
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.Deepling;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.Deepling.AbstractDeepling;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.world.data.CMWorldData;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Deepling_Priest_Entity
extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_MELEE = Animation.create((int)20);
    public static final Animation DEEPLING_BLIND = Animation.create((int)57);
    private int lightcooldown = 200;
    public static final int LIGHT_COOLDOWN = 200;
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed((float)1.15f, (float)0.6f);

    public Deepling_Priest_Entity(EntityType<?> entity, Level world) {
        super(entity, world);
        this.switchNavigator(false);
        this.xpReward = 10;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new DeeplingLightGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
        this.goalSelector.addGoal(3, new AnimationMeleeAttackGoal(this, 1.0, false));
    }

    public static AttributeSupplier.Builder deeplingpriest() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.MAX_HEALTH, 45.0).add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219154_, DifficultyInstance p_219155_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)ModItems.ATHAME.get()));
        this.setDropChance(EquipmentSlot.MAINHAND, 0.0f);
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

    public boolean checkSpawnRules(LevelAccessor worldIn, EntitySpawnReason spawnReasonIn) {
        if (ModEntities.rollSpawn(CMCommonConfig.Spawning.DeeplingPriestSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)worldIn;
            CMWorldData data = CMWorldData.get((Level)serverLevel, (ResourceKey<Level>)Level.OVERWORLD);
            return data != null && data.isLeviathanDefeatedOnce();
        }
        return false;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, EntitySpawnReason p_34090_, @Nullable SpawnGroupData p_34091_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        return spawngroupdata;
    }

    public boolean checkSpawnObstruction(LevelReader p_32829_) {
        return p_32829_.isUnobstructed((Entity)this);
    }

    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Priest_Entity> guardian, LevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (EntitySpawnReason.isSpawner((EntitySpawnReason)spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE, DEEPLING_BLIND};
    }

    private boolean isEntityLookingAt(LivingEntity looker, LivingEntity seen, double degree) {
        Vec3 Vector3d = looker.getViewVector(1.0f).normalize();
        Vec3 Vector3d1 = new Vec3(seen.getX() - looker.getX(), seen.getBoundingBox().minY + (double)seen.getEyeHeight() - (looker.getY() + (double)looker.getEyeHeight()), seen.getZ() - looker.getZ());
        double d0 = Vector3d1.length();
        double d1 = Vector3d.dot(Vector3d1 = Vector3d1.normalize());
        return d1 > 1.0 - (degree *= 1.0 + (double)looker.distanceTo(seen) * 0.1) / d0 && looker.hasLineOfSight(seen);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (this.lightcooldown > 0) {
            --this.lightcooldown;
        }
        if (this.isAlive()) {
            if (this.getAnimation() == DEEPLING_MELEE && this.getAnimationTick() == 5) {
                this.playSound((SoundEvent)ModSounds.DEEPLING_SWING.get(), 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                if (target != null && this.distanceTo(target) < 3.0f) {
                    float damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    target.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), damage);
                }
            }
            if (this.getAnimation() == DEEPLING_BLIND) {
                if (this.getAnimationTick() == 18) {
                    this.playSound((SoundEvent)ModSounds.DEEPLING_LIGHT.get(), 0.2f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                }
                if (this.getAnimationTick() > 18 && this.getAnimationTick() < 47) {
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0))) {
                        boolean flag;
                        if (this.isAlliedTo(entity) || entity == this || !this.isEntityLookingAt(entity, (LivingEntity)this, 0.6) || !(flag = entity.hurtOrSimulate(this.damageSources().indirectMagic(this, this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.7f))) continue;
                        entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80));
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

    static class DeeplingLightGoal
    extends Goal {
        private final Deepling_Priest_Entity angler;

        public DeeplingLightGoal(Deepling_Priest_Entity angler) {
            this.angler = angler;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = this.angler.getTarget();
            return this.angler.lightcooldown <= 0 && this.angler.getAnimation() == IAnimatedEntity.NO_ANIMATION && target != null && this.angler.distanceToSqr(target) <= 64.0 && target.isAlive() && this.angler.getRandom().nextFloat() * 100.0f < 12.0f;
        }

        public void start() {
            super.start();
            this.angler.setAnimation(DEEPLING_BLIND);
            this.angler.lightcooldown = 200;
            this.angler.navigation.stop();
        }

        public void stop() {
            super.stop();
        }
    }

    static class AnimationMeleeAttackGoal
    extends MeleeAttackGoal {
        protected final Deepling_Priest_Entity mob;

        public AnimationMeleeAttackGoal(Deepling_Priest_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_, p_25553_, p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        protected void checkAndPerformAttack(LivingEntity p_25557_) {
            if (this.canPerformAttack(p_25557_) && this.mob.getAnimation() == IAnimatedEntity.NO_ANIMATION) {
                this.mob.setAnimation(DEEPLING_MELEE);
            }
        }
    }
}

