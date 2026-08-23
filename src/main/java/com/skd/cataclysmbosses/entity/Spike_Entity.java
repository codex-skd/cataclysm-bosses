/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.TryFindWaterGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.Deepling;

import com.skd.cataclysmbosses.entity.AI.AnimalAIRandomSwimming;
import com.skd.cataclysmbosses.entity.AI.EntityAINearestTarget3D;
import com.skd.cataclysmbosses.entity.Deepling.AbstractDeepling;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Angler_Entity;
import com.skd.cataclysmbosses.entity.etc.AquaticMoveController;
import com.skd.cataclysmbosses.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.cataclysmbosses.entity.projectile.Spike_Spike_Entity;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

public class Spike_Entity
extends Monster
implements IAnimatedEntity {
    public static final Animation LIONFISH_BITE = Animation.create((int)19);
    private int animationTick;
    private Animation currentAnimation;
    public float prevOnLandProgress;
    public float onLandProgress;
    public float LayerBrightness;
    public float oLayerBrightness;
    public int LayerTicks;

    public Spike_Entity(EntityType<? extends Monster> monster, Level level) {
        super(monster, level);
        this.xpReward = 5;
        this.moveControl = new AquaticMoveController((PathfinderMob)this, 1.0f, 15.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new SemiAquaticPathNavigator((Mob)this, worldIn);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PUFFER_FISH_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PUFFER_FISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_29628_) {
        return SoundEvents.PUFFER_FISH_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.PUFFER_FISH_FLOP;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, (Goal)new TryFindWaterGoal((PathfinderMob)this));
        this.goalSelector.addGoal(2, (Goal)new AnimationMeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(3, (Goal)new AnimalAIRandomSwimming((PathfinderMob)this, 1.0, 12, 5));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[]{AbstractDeepling.class, Spike_Entity.class}));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<Player>((Mob)this, Player.class, true));
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public static AttributeSupplier.Builder lionfish() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 2.0).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 12.0);
    }

    public boolean hurt(DamageSource p_32820_, float p_32821_) {
        LivingEntity livingentity;
        Entity entity;
        if (this.level().isClientSide()) {
            return false;
        }
        if (!p_32820_.is(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && !p_32820_.is(DamageTypes.THORNS) && (entity = p_32820_.getDirectEntity()) instanceof LivingEntity && (livingentity = (LivingEntity)entity).hurt(this.damageSources().thorns((Entity)this), 1.0f)) {
            livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 0), (Entity)this);
        }
        return super.hurt(p_32820_, p_32821_);
    }

    public void tick() {
        super.tick();
        this.prevOnLandProgress = this.onLandProgress;
        if (!this.isInWater() && this.onLandProgress < 5.0f) {
            this.onLandProgress += 1.0f;
        }
        if (this.isInWater() && this.onLandProgress > 0.0f) {
            this.onLandProgress -= 1.0f;
        }
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0f - 1.0f) * 0.05f), (double)0.4f, (double)((this.random.nextFloat() * 2.0f - 1.0f) * 0.05f)));
            this.setOnGround(false);
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        AnimationHandler.INSTANCE.updateAnimations((Entity)this);
        if (this.level().isClientSide()) {
            ++this.LayerTicks;
            this.LayerBrightness += (0.0f - this.LayerBrightness) * 0.8f;
        }
        if (this.isAlive()) {
            LivingEntity target = this.getTarget();
            if (this.getAnimation() == LIONFISH_BITE && this.getAnimationTick() == 7) {
                this.playSound(SoundEvents.PHANTOM_BITE, 0.4f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
                if (target != null) {
                    float damage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    target.hurt(this.damageSources().mobAttack((LivingEntity)this), damage);
                }
            }
        }
    }

    protected void handleAirSupply(int p_30344_) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(p_30344_ - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(this.damageSources().drown(), 0.01f);
            }
        } else {
            this.setAirSupply(1000);
        }
    }

    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
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

    public void die(DamageSource cause) {
        super.die(cause);
        int shardCount = 6 + this.random.nextInt(2);
        if (!this.level().isClientSide()) {
            for (int i = 0; i < shardCount; ++i) {
                float f = (float)(i + 1) / (float)shardCount * 360.0f;
                Spike_Spike_Entity shard = new Spike_Spike_Entity(this.level(), (LivingEntity)this);
                shard.shoot(this.random.nextFloat() * 0.4f * 2.0f - 0.4f, this.random.nextFloat() * 0.25f + 0.1f, this.random.nextFloat() * 0.4f * 2.0f - 0.4f, 0.35f, 1.0f);
                this.level().addFreshEntity((Entity)shard);
            }
        }
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean checkSpawnObstruction(LevelReader worldIn) {
        return worldIn.isUnobstructed((Entity)this);
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(travelVector);
        }
    }


    private boolean isLeashedToAngler() {
        return this.getLeashHolder() instanceof Deepling_Angler_Entity;
    }

    public int getAnimationTick() {
        return this.animationTick;
    }

    public void setAnimationTick(int i) {
        this.animationTick = i;
    }

    public Animation getAnimation() {
        return this.currentAnimation;
    }

    public void setAnimation(Animation animation) {
        this.currentAnimation = animation;
    }

    public Animation[] getAnimations() {
        return new Animation[]{LIONFISH_BITE, NO_ANIMATION};
    }

    static class AnimationMeleeAttackGoal
    extends MeleeAttackGoal {
        protected final Spike_Entity mob;

        public AnimationMeleeAttackGoal(Spike_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super((PathfinderMob)p_25552_, p_25553_, p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        protected void checkAndPerformAttack(LivingEntity p_25557_) {
            if (this.canPerformAttack(p_25557_) && this.mob.getAnimation() == IAnimatedEntity.NO_ANIMATION) {
                this.mob.setAnimation(LIONFISH_BITE);
            }
        }
    }
}

