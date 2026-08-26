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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.AnimationMonster;

import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.LLibrary_Monster;
import com.skd.cataclysmbosses.entity.projectile.Laser_Beam_Entity;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class The_Watcher_Entity
extends LLibrary_Monster {
    public static final Animation WATCHER_BITE = Animation.create((int)22);
    public static final Animation WATCHER_SHOT = Animation.create((int)55);
    public static final Animation WATCHER_EXTRA_SHOT = Animation.create((int)17);

    public The_Watcher_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 8;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, WATCHER_BITE, WATCHER_EXTRA_SHOT, WATCHER_SHOT};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new WatcherMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(0, (Goal)new ShotPrepare(this, WATCHER_SHOT));
        this.goalSelector.addGoal(0, (Goal)new Shot(this, WATCHER_EXTRA_SHOT));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
    }

    public static AttributeSupplier.Builder the_watcher() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 5.0).add(Attributes.MAX_HEALTH, 25.0).add(Attributes.ARMOR, 5.0).add(Attributes.STEP_HEIGHT, 1.25).add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
    }

    public boolean hurt(DamageSource source, float damage) {
        if (source.is(CMDamageTypes.EMP)) {
            super.hurtOrSimulate(source, 1000.0f);
            return true;
        }
        return super.hurtOrSimulate(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void tick() {
        super.tick();
        this.setYRot(this.yBodyRot);
        LivingEntity target = this.getTarget();
        if (this.getAnimation() == WATCHER_BITE && this.getAnimationTick() == 13 && target != null && this.distanceTo((Entity)target) < 3.0f && this.hasLineOfSight((Entity)target)) {
            float damage = (int)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
            target.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), damage);
        }
        if (this.getAnimation() == WATCHER_EXTRA_SHOT && this.getAnimationTick() == 9) {
            if (!this.isSilent()) {
                this.playSound((SoundEvent)ModSounds.HARBINGER_LASER.get(), 1.0f, 1.0f);
            }
            if (target != null && target.isAlive()) {
                double d0 = this.getX();
                double d1 = this.getY() + (double)(this.getBbHeight() * 1.0f / 2.0f);
                double d2 = this.getZ();
                double d3 = target.getX() - d0;
                double d4 = target.getY() + (double)(target.getBbHeight() * 1.0f / 2.0f) - d1;
                double d5 = target.getZ() - d2;
                Vec3 vec3 = new Vec3(d3, d4, d5);
                Laser_Beam_Entity laserBeam = new Laser_Beam_Entity((LivingEntity)this, vec3.normalize(), this.level(), 7.0f);
                float yRot = (float)(Mth.atan2((double)vec3.z, (double)vec3.x) * 57.29577951308232) + 90.0f;
                float xRot = (float)(-(Mth.atan2((double)vec3.y, (double)Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * 57.29577951308232));
                laserBeam.setYRot(yRot);
                laserBeam.setXRot(xRot);
                laserBeam.setPosRaw(d0, d1, d2);
                this.level().addFreshEntity((Entity)laserBeam);
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
        if (entityIn.getType().is(ModTag.TEAM_THE_HARBINGER)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.WATCHER_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.WATCHER_DEATH.get();
    }

    static class WatcherMoveGoal
    extends Goal {
        private final The_Watcher_Entity watcher;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private int delayCounter;
        protected final double moveSpeed;

        public WatcherMoveGoal(The_Watcher_Entity boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
            this.watcher = boss;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.moveSpeed = moveSpeed;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            LivingEntity target = this.watcher.getTarget();
            return target != null && target.isAlive();
        }

        public void stop() {
            this.watcher.getNavigation().stop();
            LivingEntity livingentity = this.watcher.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.watcher.setTarget(null);
            }
            this.watcher.setAggressive(false);
            this.watcher.getNavigation().stop();
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.watcher.getTarget();
            if (target == null) {
                return false;
            }
            if (!target.isAlive()) {
                return false;
            }
            if (!this.followingTargetEvenIfNotSeen) {
                return !this.watcher.getNavigation().isDone();
            }
            if (!this.watcher.isWithinRestriction(target.blockPosition())) {
                return false;
            }
            return !(target instanceof Player) || !target.isSpectator() && !((Player)target).isCreative();
        }

        public void start() {
            this.watcher.getNavigation().moveTo(this.path, this.moveSpeed);
            this.watcher.setAggressive(true);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.watcher.getTarget();
            if (target != null) {
                this.watcher.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                double distSq = this.watcher.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.watcher.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.watcher.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0)) {
                        if (!this.watcher.isPathFinding() && !this.watcher.getNavigation().moveTo((Entity)target, 1.0)) {
                            this.delayCounter += 5;
                        }
                    } else {
                        this.watcher.getNavigation().moveTo((Entity)target, this.moveSpeed);
                    }
                }
                if (target.isAlive() && this.watcher.getAnimation() == IAnimatedEntity.NO_ANIMATION) {
                    if (this.watcher.distanceTo((Entity)target) < 1.5f) {
                        this.watcher.setAnimation(WATCHER_BITE);
                    } else if (this.watcher.getRandom().nextFloat() * 100.0f < 24.0f && (double)this.watcher.distanceTo((Entity)target) >= 6.0) {
                        this.watcher.setAnimation(WATCHER_SHOT);
                    }
                }
            }
        }
    }

    static class ShotPrepare
    extends SimpleAnimationGoal<The_Watcher_Entity> {
        public ShotPrepare(The_Watcher_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            LivingEntity target = ((The_Watcher_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Watcher_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = ((The_Watcher_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Watcher_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
            super.stop();
        }

        public void tick() {
            LivingEntity target = ((The_Watcher_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Watcher_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                if (((The_Watcher_Entity)this.entity).getAnimationTick() == 45) {
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((The_Watcher_Entity)this.entity), WATCHER_EXTRA_SHOT);
                }
            }
        }
    }

    static class Shot
    extends SimpleAnimationGoal<The_Watcher_Entity> {
        public Shot(The_Watcher_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            LivingEntity target = ((The_Watcher_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Watcher_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = ((The_Watcher_Entity)this.entity).getTarget();
            if (((The_Watcher_Entity)this.entity).getAnimationTick() < 7 && target != null) {
                ((The_Watcher_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            } else {
                ((The_Watcher_Entity)this.entity).setYRot(((The_Watcher_Entity)this.entity).yRotO);
            }
            if (target != null && ((The_Watcher_Entity)this.entity).getAnimationTick() == 11 && ((The_Watcher_Entity)this.entity).getRandom().nextFloat() * 100.0f < 60.0f) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((The_Watcher_Entity)this.entity), WATCHER_EXTRA_SHOT);
            }
        }
    }
}

