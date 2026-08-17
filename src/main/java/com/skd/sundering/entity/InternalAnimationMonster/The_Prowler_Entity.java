/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.entity.InternalAnimationMonster;

import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.sundering.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.sundering.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.sundering.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.sundering.entity.effect.ScreenShake_Entity;
import com.skd.sundering.entity.etc.SmartBodyHelper2;
import com.skd.sundering.entity.etc.path.CMPathNavigateGround;
import com.skd.sundering.entity.projectile.Death_Laser_Beam_Entity;
import com.skd.sundering.entity.projectile.Wither_Homing_Missile_Entity;
import com.skd.sundering.init.ModEffect;
import com.skd.sundering.init.ModEntities;
import com.skd.sundering.init.ModSounds;
import com.skd.sundering.init.ModTag;
import com.skd.sundering.util.CMDamageTypes;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

public class The_Prowler_Entity
extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState stunAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState laserAnimationState = new AnimationState();
    public AnimationState spinAnimationState = new AnimationState();
    public AnimationState meleeAnimationState = new AnimationState();
    public AnimationState strongAttackAnimationState = new AnimationState();
    public AnimationState pierceAnimationState = new AnimationState();
    public static final int SPIN_COOLDOWN = 80;
    public static final int LASER_COOLDOWN = 200;
    private int spin_cooldown = 0;
    private int laser_cooldown = 100;
    public static final int NATURE_HEAL_COOLDOWN = 60;
    private int timeWithoutTarget;

    public The_Prowler_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 70;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Prowler.healthMultiplier, CMCommonConfig.Prowler.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(0, (Goal)new InternalStateGoal(this, 1, 1, 0, 60, 0));
        this.goalSelector.addGoal(1, (Goal)new Lasershoot(this, 0, 2, 0, 90, 20, 8.0f, 20, 100.0f));
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 4, 0, 50, 22, 4.75f){

            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < 26.0f && The_Prowler_Entity.this.spin_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                The_Prowler_Entity.this.spin_cooldown = 80;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, this, 0, 5, 0, 50, 38, 5.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < 20.0f;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, this, 0, 6, 0, 55, 45, 6.0f){

            @Override
            public boolean canUse() {
                LivingEntity target = this.entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < 20.0f && target != null && (double)this.entity.distanceTo((Entity)target) >= 2.75;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, this, 0, 7, 0, 80, 38, 4.25f){

            @Override
            public boolean canUse() {
                LivingEntity target = this.entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < 24.0f && target != null;
            }
        });
    }

    public static AttributeSupplier.Builder the_prowler() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 14.0).add(Attributes.MAX_HEALTH, 160.0).add(Attributes.ARMOR, 10.0).add(Attributes.STEP_HEIGHT, 1.5).add(Attributes.KNOCKBACK_RESISTANCE, 0.95);
    }

    public boolean hurt(DamageSource source, float damage) {
        double distSqr;
        if (source.is(CMDamageTypes.EMP) && this.getAttackState() != 1) {
            this.setAttackState(1);
        }
        if ((distSqr = this.calculateRange(source)) != -1.0) {
            double distance;
            float multiplier;
            double limit = CMCommonConfig.Prowler.rangeCap;
            double maxLimit = limit * 1.5;
            double limitSqr = limit * limit;
            double maxLimitSqr = maxLimit * maxLimit;
            if (distSqr >= maxLimitSqr) {
                return false;
            }
            if (distSqr > limitSqr && (damage *= (multiplier = (float)((maxLimit - (distance = Math.sqrt(distSqr))) / (maxLimit - limit)))) <= 0.0f) {
                return false;
            }
        }
        return super.hurt(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "stun") {
            return this.stunAnimationState;
        }
        if (input == "laser") {
            return this.laserAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "spin") {
            return this.spinAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "melee") {
            return this.meleeAnimationState;
        }
        if (input == "strong_attack") {
            return this.strongAttackAnimationState;
        }
        if (input == "pierce") {
            return this.pierceAnimationState;
        }
        return new AnimationState();
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
                    this.stunAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.laserAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.spinAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.meleeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.strongAttackAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.pierceAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.laserAnimationState.stop();
        this.stunAnimationState.stop();
        this.spinAnimationState.stop();
        this.meleeAnimationState.stop();
        this.strongAttackAnimationState.stop();
        this.deathAnimationState.stop();
        this.pierceAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    @Override
    public int deathtimer() {
        return 40;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() != 1, this.tickCount);
        } else {
            LivingEntity target;
            if (this.timeWithoutTarget > 0) {
                --this.timeWithoutTarget;
            }
            if ((target = this.getTarget()) != null) {
                this.timeWithoutTarget = 60;
            }
            if (this.timeWithoutTarget <= 0 && !this.isNoAi() && this.tickCount % 20 == 0) {
                this.heal(this.getMaxHealth() / 10.0f);
            }
        }
        if (this.laser_cooldown > 0) {
            --this.laser_cooldown;
        }
        if (this.spin_cooldown > 0) {
            --this.spin_cooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        LivingEntity target = this.getTarget();
        if (this.getAttackState() == 2 && this.attackTicks == 38) {
            this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.DEATH_LASER.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.2f, 0, 10);
        }
        if (this.getAttackState() == 1 && this.level().isClientSide()) {
            for (int i = 0; i < 2; ++i) {
                this.level().addParticle((ParticleOptions)ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
            }
        }
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 23 || this.attackTicks == 32) {
                this.AreaAttack(6.0f, 6.0f, 180.0f, 1.0f);
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            }
            if (this.attackTicks == 23) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            }
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 27) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            }
            if (this.attackTicks == 20 || this.attackTicks == 26 || this.attackTicks == 32 || this.attackTicks == 38 || this.attackTicks == 44) {
                this.AreaAttack(5.4f, 5.5f, 110.0f, 0.5f);
            }
        }
        float f1 = (float)Math.cos(Math.toRadians(this.getYRot() + 90.0f));
        float f2 = (float)Math.sin(Math.toRadians(this.getYRot() + 90.0f));
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 18) {
                this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
            }
            if (this.attackTicks == 17) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            }
            if (this.attackTicks == 25) {
                this.AreaAttack(5.5f, 5.5f, 70.0f, 1.5f);
            }
        }
        if (this.getAttackState() == 7) {
            if (target != null) {
                if (this.attackTicks == 12) {
                    this.Missilelaunch(2.0f, 0.5f, target);
                }
                if (this.attackTicks == 15) {
                    this.Missilelaunch(2.3f, 0.5f, target);
                }
                if (this.attackTicks == 18) {
                    this.Missilelaunch(2.6f, 0.5f, target);
                }
            }
            if (this.attackTicks == 18) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.PROWLER_SAW_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
            }
            if (this.attackTicks == 25 || this.attackTicks == 32 || this.attackTicks == 40) {
                this.AreaAttack(5.5f, 5.5f, 60.0f, 0.5f);
            }
            if (this.attackTicks == 64) {
                this.AreaAttack(5.5f, 5.5f, 140.0f, 1.0f);
            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = CMDamageTypes.causeShredderDamage((LivingEntity)this);
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof The_Prowler_Entity || entityHit == this) continue;
                entityHit.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
            }
        }
    }

    private void Missilelaunch(float y, float math, LivingEntity target) {
        if (!this.isSilent()) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.ROCKET_LAUNCH.get(), SoundSource.HOSTILE, 1.5f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        }
        float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        double d0 = this.getX() + 0.5 * vecX + (double)(f * math);
        double d1 = this.getY() + (double)y;
        double d2 = this.getZ() + 0.5 * vecZ + (double)(f1 * math);
        double d3 = target.getX() - d0;
        double d4 = target.getY() - d1;
        double d5 = target.getZ() - d2;
        Vec3 vec3 = new Vec3(d3, d4, d5);
        Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity((LivingEntity)this, vec3.normalize(), this.level(), (float)CMCommonConfig.Prowler.HomingMissiledamage, target);
        laserBeam.setPosRaw(d0, d1, d2);
        this.level().addFreshEntity((Entity)laserBeam);
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
        return (SoundEvent)ModSounds.PROWLER_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.PROWLER_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.PROWLER_IDLE.get();
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

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    static class Lasershoot
    extends InternalAttackGoal {
        private final The_Prowler_Entity entity;
        private final int attackshot;
        private final float random;

        public Lasershoot(The_Prowler_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.getSensing().hasLineOfSight((Entity)target) && this.entity.laser_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.laser_cooldown = 200;
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == this.attackshot) {
                Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity((EntityType<? extends Death_Laser_Beam_Entity>)((EntityType)ModEntities.DEATH_LASER_BEAM.get()), this.entity.level(), (LivingEntity)this.entity, this.entity.getX(), this.entity.getY() + 1.8, this.entity.getZ(), (float)((double)(this.entity.yHeadRot + 90.0f) * Math.PI / 180.0), (float)((double)(-this.entity.getXRot()) * Math.PI / 180.0), 28, (float)CMCommonConfig.Prowler.DeathLaserdamage, (float)CMCommonConfig.Prowler.DeathLaserHpdamage);
                this.entity.level().addFreshEntity((Entity)DeathBeam);
            }
            if (this.entity.attackTicks >= this.attackshot && target != null) {
                this.entity.getLookControl().setLookAt(target.getX(), target.getY() + (double)(target.getBbHeight() / 2.0f), target.getZ(), 2.0f, 90.0f);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}

