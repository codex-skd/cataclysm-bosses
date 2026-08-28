/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
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
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters;
import net.minecraft.server.level.ServerLevel;

import com.skd.cataclysmbosses.client.particle.Options.ParryParticleOptions;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import com.skd.cataclysmbosses.util.EntityUtil;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Hippocamtus_Entity
extends Internal_Animation_Monster {
    boolean searchingForLand;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swing1AnimationState = new AnimationState();
    public AnimationState swing2AnimationState = new AnimationState();
    public AnimationState stabAnimationState = new AnimationState();
    public AnimationState guardAnimationState = new AnimationState();
    public AnimationState guardcounterAnimationState = new AnimationState();
    public AnimationState parryingAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public static final EntityDataAccessor<Boolean> STAB = SynchedEntityData.defineId(Hippocamtus_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private int block_stage = 0;
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 100;
    private int guard_cooldown = 0;
    public static final int GUARD_COOLDOWN = 160;
    protected final SemiAquaticPathNavigator waterNavigation;
    protected final CMPathNavigateGround groundNavigation;

    public Hippocamtus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.waterNavigation = new SemiAquaticPathNavigator((Mob)this, world);
        this.groundNavigation = new CMPathNavigateGround((Mob)this, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(3, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(2, (Goal)new ChargeAttackGoal(this, 0, 3, 0, 41, 13, 4.5f, 16.0f, 16.0f));
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 4, 0, 50, 50, 4.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Hippocamtus_Entity.this.getRandom().nextFloat() * 100.0f < 48.0f && Hippocamtus_Entity.this.guard_cooldown <= 0;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && Hippocamtus_Entity.this.block_stage == 0;
            }

            @Override
            public void stop() {
                Hippocamtus_Entity.this.guard_cooldown = 160;
                if (Hippocamtus_Entity.this.block_stage == 1) {
                    this.entity.setAttackState(5);
                } else if (Hippocamtus_Entity.this.block_stage == 2) {
                    this.entity.setAttackState(6);
                } else {
                    super.stop();
                }
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 1, 0, 45, 8, 4.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Hippocamtus_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.setStab(Hippocamtus_Entity.this.getRandom().nextBoolean());
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalAttackGoal(this, 0, 2, 0, 39, 8, 4.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && !Hippocamtus_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.setStab(Hippocamtus_Entity.this.getRandom().nextBoolean());
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 5, 5, 0, 64, 64){

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.block_stage = 0;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 6, 6, 0, 51, 51){

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.block_stage = 0;
            }
        });
    }

    public static AttributeSupplier.Builder Hippocamtus_Entity() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 10.0).add(Attributes.MAX_HEALTH, 85.0).add(Attributes.ARMOR, 15.0).add(Attributes.STEP_HEIGHT, 1.75).add(Attributes.KNOCKBACK_RESISTANCE, 0.7);
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    public void travel(Vec3 travelVector) {
        if (this.isLocalInstanceAuthoritative() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01f, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(travelVector);
        }
    }

    public void updateSwimming() {
        if (!this.level().isClientSide()) {
            boolean inWaterAI;
            boolean bl = inWaterAI = this.isEffectiveAi() && this.isInWater() && this.wantsToSwim();
            if (inWaterAI && !(this.moveControl instanceof HippocamtusSwimControl)) {
                this.navigation = this.waterNavigation;
                this.moveControl = new HippocamtusSwimControl(this, 4.0f);
                this.setSwimming(true);
            } else if (!inWaterAI && this.moveControl instanceof HippocamtusSwimControl) {
                this.navigation = this.groundNavigation;
                this.moveControl = new MoveControl((Mob)this);
                this.setSwimming(false);
            }
        }
    }

    public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        Vec3 vector3d2;
        Entity entity = source.getDirectEntity();
        if (!source.is(DamageTypeTags.BYPASSES_SHIELD) && !this.isNoAi() && this.getAttackState() == 4 && (vector3d2 = source.getSourcePosition()) != null) {
            Vec3 vector3d = this.getViewVector(1.0f);
            Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
            vector3d1 = new Vec3(vector3d1.x, 0.0, vector3d1.z);
            if (vector3d1.dot(vector3d) < 0.0) {
                if (this.attackTicks >= 7 && this.attackTicks <= 17) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity living = (LivingEntity)entity;
                        this.block_stage = 1;
                        if (!this.level().isClientSide()) {
                            living.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 50));
                        }
                        this.playSound((SoundEvent)ModSounds.PARRY.get(), 0.8f, 1.0f);
                    }
                    return false;
                }
                if (this.attackTicks > 17 && this.attackTicks <= 43) {
                    if (entity instanceof LivingEntity) {
                        LivingEntity living = (LivingEntity)entity;
                        this.block_stage = 2;
                        living.knockback(0.5, this.getX() - living.getX(), this.getZ() - living.getZ());
                    }
                    return false;
                }
                return super.hurtOrSimulate(source, damage);
            }
        }
        return super.hurtOrSimulate(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "swing1") {
            return this.swing1AnimationState;
        }
        if (input == "swing2") {
            return this.swing2AnimationState;
        }
        if (input == "stab") {
            return this.stabAnimationState;
        }
        if (input == "guard") {
            return this.guardAnimationState;
        }
        if (input == "guardcounter") {
            return this.guardcounterAnimationState;
        }
        if (input == "parry") {
            return this.parryingAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(STAB, false);
    }

    public void setStab(boolean stab) {
        this.entityData.set(STAB, stab);
    }

    public boolean getStab() {
        return (Boolean)this.entityData.get(STAB);
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
                    this.swing1AnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.swing2AnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.stabAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.guardAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.parryingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.guardcounterAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swing1AnimationState.stop();
        this.swing2AnimationState.stop();
        this.stabAnimationState.stop();
        this.guardAnimationState.stop();
        this.guardcounterAnimationState.stop();
        this.parryingAnimationState.stop();
        this.deathAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(7);
    }

    @Override
    public int deathtimer() {
        return 60;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.HIPPOCAMTUS_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.HIPPOCAMTUS_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.HIPPOCAMTUS_IDLE.get();
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
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() != 7, this.tickCount);
        }
        if (this.charge_cooldown > 0) {
            --this.charge_cooldown;
        }
        if (this.guard_cooldown > 0) {
            --this.guard_cooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 16) {
                this.playSound((SoundEvent)ModSounds.IGNIS_POKE.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.attackTicks == 18) {
                this.AreaAttack(8.5f, 6.0f, 45.0f, 1.0f, 90, false, false);
            }
        }
        if (this.getAttackState() == 1 && this.attackTicks == 11) {
            this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
            this.AreaAttack(5.0f, 5.0f, 200.0f, 1.0f, 70, false, false);
        }
        if (this.getAttackState() == 2 && this.attackTicks == 11) {
            this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
            this.AreaAttack(5.0f, 5.0f, 200.0f, 1.0f, 60, false, false);
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 1) {
                this.parryParticle(1.5f, 0.9f, -0.1f);
            }
            if (this.attackTicks == 35 || this.attackTicks == 42 || this.attackTicks == 48) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(7.0f, 6.0f, 45.0f, 0.9f, 90, false, true);
            }
        }
        if (this.getAttackState() == 6 && (this.attackTicks == 10 || this.attackTicks == 17 || this.attackTicks == 24)) {
            this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
            this.AreaAttack(7.0f, 6.0f, 45.0f, 0.9f, 90, false, true);
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean knockback, boolean penetrate) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = penetrate ? CMDamageTypes.causePenetrateDamage((LivingEntity)this) : this.damageSources().mobAttack((LivingEntity)this);
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Hippocamtus_Entity || entityHit == this) continue;
                boolean hurt = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
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
                entityHit.push(d0 / d2 * 2.25, 0.15, d1 / d2 * 2.25);
            }
        }
    }

    private void parryParticle(float height, float vec, float math) {
        if (this.level().isClientSide()) {
            double d0 = this.getX();
            double d1 = this.getY() + (double)height;
            double d2 = this.getZ();
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            double theta2 = theta + 1.5707963267948966;
            double X = Math.cos(theta2);
            double Z = Math.sin(theta2);
            for (int i = 0; i < 12; ++i) {
                float throwAngle = (float)i * (float)Math.PI / 6.0f;
                double y = 2.0 * Math.sin(throwAngle);
                double xz = 2.0 * Math.cos(throwAngle);
                double d3 = xz * vecX + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                double d4 = y + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                double d5 = xz * vecZ + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                double speed = 0.35;
                this.level().addParticle((ParticleOptions)new ParryParticleOptions(1.0f, 0.41568628f, 0.0f), d0 + (double)vec * X + (double)(f * math), d1, d2 + (double)vec * Z + (double)(f1 * math), d3 * speed, d4 * speed, d5 * speed);
            }
        }
    }

    public boolean considersEntityAsAlly(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.considersEntityAsAlly(entityIn)) {
            return true;
        }
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_SCYLLA)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    static class ChargeAttackGoal
    extends InternalAttackGoal {
        protected final Hippocamtus_Entity entity;
        private final float attackminrange;
        private final float random;

        public ChargeAttackGoal(Hippocamtus_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, float random) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.attackminrange = attackminrange;
            this.random = random;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo((Entity)target) > this.attackminrange && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.charge_cooldown <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.charge_cooldown = 100;
        }

        @Override
        public void tick() {
            super.tick();
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks == this.attackseetick) {
                float f1 = (float)Math.cos(Math.toRadians(this.entity.yBodyRot + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(this.entity.yBodyRot + 90.0f));
                if (target != null) {
                    float r = this.entity.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)5.0f);
                    this.entity.push((double)f1 * 0.4 * (double)r, 0.0, (double)f2 * 0.4 * (double)r);
                } else {
                    this.entity.push((double)f1 * 2.0, 0.0, (double)f2 * 2.0);
                }
            }
        }
    }

    static class HippocamtusSwimControl
    extends MoveControl {
        private final Hippocamtus_Entity drowned;
        private final float speedMulti;

        public HippocamtusSwimControl(Hippocamtus_Entity p_32433_, float speedMulti) {
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
}

