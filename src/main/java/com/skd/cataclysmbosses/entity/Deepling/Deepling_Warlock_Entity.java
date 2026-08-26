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
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
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
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.Deepling.AbstractDeepling;
import com.skd.cataclysmbosses.entity.effect.Abyss_Mark_Entity;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
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

public class Deepling_Warlock_Entity
extends AbstractDeepling {
    public static final Animation DEEPLING_MELEE = Animation.create((int)20);
    public static final Animation DEEPLING_MAGIC = Animation.create((int)90);
    boolean searchingForLand;
    private int lightcooldown = 200;
    public static final int LIGHT_COOLDOWN = 400;
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed((float)1.15f, (float)0.6f);

    public Deepling_Warlock_Entity(EntityType<?> entity, Level world) {
        super(entity, world);
        this.switchNavigator(false);
        this.xpReward = 10;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MagicTrackingGoal(this, DEEPLING_MAGIC));
        this.goalSelector.addGoal(2, new DeeplingMagicGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]).setAlertOthers(new Class[0]));
        this.goalSelector.addGoal(3, new AnimationMeleeAttackGoal(this, 1.0, false));
    }

    public static AttributeSupplier.Builder deeplingwarlock() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.MAX_HEALTH, 45.0).add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
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
        if (ModEntities.rollSpawn(CMCommonConfig.Spawning.DeeplingWarlockSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel) {
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

    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Warlock_Entity> guardian, LevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (EntitySpawnReason.isSpawner((EntitySpawnReason)spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE, DEEPLING_MAGIC};
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (this.lightcooldown > 0) {
            --this.lightcooldown;
        }
        if (this.isAlive() && this.getAnimation() == DEEPLING_MELEE && this.getAnimationTick() == 5) {
            this.playSound((SoundEvent)ModSounds.DEEPLING_SWING.get(), 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            if (target != null && this.distanceTo((Entity)target) < 3.0f) {
                float damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                target.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), damage);
            }
        }
    }

    @Override
    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
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

    static class MagicTrackingGoal
    extends SimpleAnimationGoal<Deepling_Warlock_Entity> {
        private final Deepling_Warlock_Entity warlock;

        public MagicTrackingGoal(Deepling_Warlock_Entity entity, Animation animation) {
            super(entity, animation);
            this.warlock = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            LivingEntity target = this.warlock.getTarget();
            if (target != null) {
                this.warlock.getLookControl().setLookAt(target, 30.0f, 30.0f);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = this.warlock.getTarget();
            if (target != null) {
                this.warlock.getLookControl().setLookAt(target, 30.0f, 30.0f);
                if (this.warlock.getAnimationTick() == 18) {
                    double sx = this.warlock.getX();
                    double sy = this.warlock.getY();
                    double sz = this.warlock.getZ();
                    Abyss_Mark_Entity fireball = new Abyss_Mark_Entity(this.warlock.level(), sx, sy, sz, 80, (float)CMCommonConfig.Leviathan.AbyssBlastDamage, (float)CMCommonConfig.Leviathan.AbyssBlastHpDamage, this.warlock.getUUID(), target);
                    this.warlock.level().addFreshEntity((Entity)fireball);
                }
            }
        }
    }

    static class DeeplingMagicGoal
    extends Goal {
        private final Deepling_Warlock_Entity angler;

        public DeeplingMagicGoal(Deepling_Warlock_Entity angler) {
            this.angler = angler;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = this.angler.getTarget();
            return this.angler.lightcooldown <= 0 && this.angler.getAnimation() == IAnimatedEntity.NO_ANIMATION && target != null && this.angler.distanceToSqr(target) >= 25.0 && target.isAlive() && this.angler.getRandom().nextFloat() * 100.0f < 12.0f;
        }

        public void start() {
            super.start();
            this.angler.setAnimation(DEEPLING_MAGIC);
            this.angler.lightcooldown = 400;
            this.angler.navigation.stop();
        }

        public void stop() {
            super.stop();
        }
    }

    static class AnimationMeleeAttackGoal
    extends MeleeAttackGoal {
        protected final Deepling_Warlock_Entity mob;

        public AnimationMeleeAttackGoal(Deepling_Warlock_Entity p_25552_, double p_25553_, boolean p_25554_) {
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

