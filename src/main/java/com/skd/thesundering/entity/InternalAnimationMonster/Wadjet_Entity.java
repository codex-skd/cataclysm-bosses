/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.DynamicChain
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
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
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.entity.InternalAnimationMonster;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.entity.etc.path.CMPathNavigateGround;
import com.skd.thesundering.entity.projectile.Ancient_Desert_Stele_Entity;
import com.skd.thesundering.entity.projectile.Poison_Dart_Entity;
import com.skd.thesundering.entity.projectile.Sandstorm_Projectile;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.util.EntityUtil;
import com.skd.nautilusapi.client.model.tools.DynamicChain;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
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
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Wadjet_Entity
extends Internal_Animation_Monster {
    @OnlyIn(value=Dist.CLIENT)
    public DynamicChain dc;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState stabnswingAnimationState = new AnimationState();
    public AnimationState doublswingAnimationState = new AnimationState();
    public AnimationState spearchargeAnimationState = new AnimationState();
    public AnimationState magicAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState blockAnimationState = new AnimationState();
    private static final EntityDataAccessor<Boolean> AWAKEN = SynchedEntityData.defineId(Wadjet_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> STAB = SynchedEntityData.defineId(Wadjet_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private float prevAttackProgress;
    private float AttackProgress;
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;
    private int magic_cooldown = 0;
    public static final int MAGIC_COOLDOWN = 160;

    public Wadjet_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 60;
        if (world.isClientSide()) {
            this.dc = new DynamicChain((Entity)this);
        }
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Wadjet.healthMultiplier, CMCommonConfig.Wadjet.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(2, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 2, 2, 0, 70, 0));
        this.goalSelector.addGoal(0, (Goal)new WadjetDoNothingGoal());
        this.goalSelector.addGoal(1, (Goal)new ChargeAttackGoal(this, 0, 3, 0, 45, 15, 20, 5.5f, 16));
        this.goalSelector.addGoal(1, (Goal)new MagicAttackGoal(this, 0, 4, 0, 35, 15, 3.5f, 12.0f));
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 5, 0, 60, 60, 5.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Wadjet_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Wadjet_Entity.this.setStab(Wadjet_Entity.this.random.nextBoolean());
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 6, 0, 55, 55, 5.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && !Wadjet_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Wadjet_Entity.this.setStab(Wadjet_Entity.this.random.nextBoolean());
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, this, 1, 1, 0, 0, 0){

            @Override
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });
        this.goalSelector.addGoal(0, (Goal)new InternalAttackGoal(this, 1, 2, 0, 70, 0, 18.0f));
        this.goalSelector.addGoal(0, (Goal)new InternalStateGoal((Internal_Animation_Monster)this, 8, 8, 0, 20, 0, false));
    }

    public static AttributeSupplier.Builder wadjet() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 11.0).add(Attributes.MAX_HEALTH, 150.0).add(Attributes.ARMOR, 5.0).add(Attributes.STEP_HEIGHT, 1.25).add(Attributes.KNOCKBACK_RESISTANCE, 0.7);
    }

    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Poison_Dart_Entity) {
            return false;
        }
        if (!this.isAwaken() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (this.canBlockDamageSource(source)) {
            if (entity instanceof AbstractArrow) {
                float f = 170.0f + this.random.nextFloat() * 80.0f;
                entity.setDeltaMovement(entity.getDeltaMovement().scale(1.0));
                entity.setYRot(entity.getYRot() + f);
                entity.hurtMarked = true;
            }
            if (this.getAttackState() == 0) {
                this.playSound(SoundEvents.ANVIL_LAND, 1.0f, 2.0f);
                this.setAttackState(8);
            }
            return false;
        }
        return super.hurt(source, damage);
    }

    public void handleDamageEvent(DamageSource damageSource) {
        this.invulnerableTime = 20;
        this.hurtTime = this.hurtDuration = 10;
        SoundEvent soundevent = this.getHurtSound(damageSource);
        if (soundevent != null) {
            this.playSound(soundevent, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
        }
        this.hurt(this.damageSources().generic(), 0.0f);
        this.lastDamageSource = damageSource;
        this.lastDamageStamp = this.level().getGameTime();
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Vec3 vector3d2;
        boolean flag = false;
        if (!(this.isNoAi() || !damageSourceIn.is(DamageTypeTags.IS_PROJECTILE) || flag || this.getAttackState() != 0 && this.getAttackState() != 8 || (vector3d2 = damageSourceIn.getSourcePosition()) == null)) {
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
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "awake") {
            return this.awakeAnimationState;
        }
        if (input == "charge") {
            return this.spearchargeAnimationState;
        }
        if (input == "magic") {
            return this.magicAnimationState;
        }
        if (input == "stabnswing") {
            return this.stabnswingAnimationState;
        }
        if (input == "doubleswing") {
            return this.doublswingAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "block") {
            return this.blockAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(STAB, (Object)false);
        p_326229_.define(AWAKEN, (Object)false);
    }

    public boolean isAwaken() {
        return this.getAwaken() || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public void setStab(boolean stab) {
        this.entityData.set(STAB, (Object)stab);
    }

    public boolean getStab() {
        return (Boolean)this.entityData.get(STAB);
    }

    public void setAwaken(boolean necklace) {
        if (necklace) {
            this.heal(this.getMaxHealth());
        }
        this.entityData.set(AWAKEN, (Object)necklace);
    }

    public boolean getAwaken() {
        return (Boolean)this.entityData.get(AWAKEN);
    }

    public boolean canBeSeenAsEnemy() {
        return this.isAwaken() && super.canBeSeenAsEnemy();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_) {
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
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
                    this.sleepAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.awakeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.spearchargeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.magicAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.stabnswingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.doublswingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 8: {
                    this.stopAllAnimationStates();
                    this.blockAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.blockAnimationState.stop();
        this.spearchargeAnimationState.stop();
        this.magicAnimationState.stop();
        this.stabnswingAnimationState.stop();
        this.doublswingAnimationState.stop();
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

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Awaken", this.getAwaken());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setAwaken(compound.getBoolean("Awaken"));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0 && this.getAwaken(), this.tickCount);
        }
        this.prevAttackProgress = this.AttackProgress;
        if (this.isAggressive() && this.AttackProgress < 10.0f) {
            this.AttackProgress += 1.0f;
        }
        if (!this.isAggressive() && this.AttackProgress > 0.0f) {
            this.AttackProgress -= 1.0f;
        }
        if (this.charge_cooldown > 0) {
            --this.charge_cooldown;
        }
        if (this.magic_cooldown > 0) {
            --this.magic_cooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 18) {
                this.playSound((SoundEvent)ModSounds.IGNIS_POKE.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.attackTicks == 20) {
                this.AreaAttack(9.0f, 6.0f, 45.0f, 1.0f, 90, false);
            }
        }
        if (this.getAttackState() == 4 && this.attackTicks == 15) {
            this.playSound(SoundEvents.EVOKER_PREPARE_ATTACK, 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 14) {
                this.playSound((SoundEvent)ModSounds.IGNIS_POKE.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(8.0f, 6.0f, 45.0f, 1.0f, 90, false);
            }
            if (this.attackTicks == 37) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.0f, 4.0f, 220.0f, 1.0f, 70, true);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 14) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.0f, 4.0f, 220.0f, 1.0f, 60, true);
            }
            if (this.attackTicks == 28) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.0f, 4.0f, 220.0f, 1.0f, 60, true);
            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean knockback) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Wadjet_Entity || entityHit == this) continue;
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
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
                entityHit.push(d0 / d2 * 2.25, 0.15, d1 / d2 * 2.25);
            }
        }
    }

    public float getAttackProgress(float partialTicks) {
        return this.prevAttackProgress + (this.AttackProgress - this.prevAttackProgress) * partialTicks;
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_ANCIENT_REMNANT)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.WADJET_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.WADJET_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return !this.isAwaken() ? super.getAmbientSound() : (SoundEvent)ModSounds.WADJET_AMBIENT.get();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    class WadjetDoNothingGoal
    extends Goal {
        public WadjetDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = Wadjet_Entity.this.getTarget();
            return !(Wadjet_Entity.this.getAwaken() || target != null && target.isAlive() && Wadjet_Entity.this.distanceToSqr((Entity)target) < 50.0 && Wadjet_Entity.this.getSensing().hasLineOfSight((Entity)target));
        }

        public void tick() {
            Wadjet_Entity.this.setDeltaMovement(0.0, Wadjet_Entity.this.getDeltaMovement().y, 0.0);
        }

        public void stop() {
            Wadjet_Entity.this.setAwaken(true);
            Wadjet_Entity.this.setAttackState(2);
        }

        public boolean isInterruptable() {
            return false;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ChargeAttackGoal
    extends InternalAttackGoal {
        protected final Wadjet_Entity entity;
        private final int attackshottick;
        private final float attackminrange;

        public ChargeAttackGoal(Wadjet_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackshottick, float attackminrange, int attackrange) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.attackshottick = attackshottick;
            this.attackminrange = attackminrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && this.entity.distanceTo((Entity)target) > this.attackminrange && super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < 16.0f && this.entity.charge_cooldown <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.charge_cooldown = 160;
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == this.attackseetick) {
                float f1 = (float)Math.cos(Math.toRadians(this.entity.yBodyRot + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(this.entity.yBodyRot + 90.0f));
                if (target != null) {
                    float r = this.entity.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)4.0f);
                    this.entity.push((double)f1 * 0.3 * (double)r, 0.0, (double)f2 * 0.3 * (double)r);
                } else {
                    this.entity.push((double)f1 * 2.0, 0.0, (double)f2 * 2.0);
                }
            }
            if (this.entity.attackTicks == this.attackshottick && target != null) {
                double d1 = 5.0;
                Vec3 vec3 = this.entity.getViewVector(1.0f);
                double d2 = target.getX() - (this.entity.getX() + vec3.x * d1);
                double d3 = target.getY(0.5) - this.entity.getY(0.15);
                double d4 = target.getZ() - (this.entity.getZ() + vec3.z * d1);
                Sandstorm_Projectile largefireball = new Sandstorm_Projectile((LivingEntity)this.entity, d2, d3, d4, this.entity.level(), 6.0f);
                largefireball.setState(1);
                largefireball.setPos(this.entity.getX() + vec3.x * d1, this.entity.getY(0.15), largefireball.getZ() + vec3.z * d1);
                this.entity.level().addFreshEntity((Entity)largefireball);
            }
        }
    }

    static class MagicAttackGoal
    extends InternalAttackGoal {
        protected final Wadjet_Entity entity;
        private final float attackminrange;

        public MagicAttackGoal(Wadjet_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange) {
            super(entity, getattackstate, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.attackminrange = attackminrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && this.entity.distanceTo((Entity)target) > this.attackminrange && super.canUse() && this.entity.getRandom().nextFloat() * 100.0f < 24.0f && this.entity.magic_cooldown <= 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.magic_cooldown = 160;
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (target != null) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                if (this.entity.attackTicks == this.attackseetick) {
                    int k;
                    double d1 = target.getY();
                    float f = (float)Mth.atan2((double)(target.getZ() - this.entity.getZ()), (double)(target.getX() - this.entity.getX()));
                    for (k = 0; k < 8; ++k) {
                        float f2 = f + (float)k * (float)Math.PI * 2.0f / 8.0f + 1.2566371f;
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos((float)f2) * 4.5, this.entity.getZ() + (double)Mth.sin((float)f2) * 4.5, d1, f2, 3);
                    }
                    for (k = 0; k < 13; ++k) {
                        float f3 = f + (float)k * (float)Math.PI * 2.0f / 13.0f + 0.62831855f;
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos((float)f3) * 6.5, this.entity.getZ() + (double)Mth.sin((float)f3) * 6.5, d1, f3, 10);
                    }
                    for (k = 0; k < 16; ++k) {
                        float f4 = f + (float)k * (float)Math.PI * 2.0f / 16.0f + 0.31415927f;
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos((float)f4) * 8.5, this.entity.getZ() + (double)Mth.sin((float)f4) * 8.5, d1, f4, 15);
                    }
                    for (k = 0; k < 19; ++k) {
                        float f5 = f + (float)k * (float)Math.PI * 2.0f / 19.0f + 0.15707964f;
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos((float)f5) * 10.5, this.entity.getZ() + (double)Mth.sin((float)f5) * 10.5, d1, f5, 20);
                    }
                    for (k = 0; k < 24; ++k) {
                        float f6 = f + (float)k * (float)Math.PI * 2.0f / 24.0f + 0.07853982f;
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos((float)f6) * 12.5, this.entity.getZ() + (double)Mth.sin((float)f6) * 12.5, d1, f6, 30);
                    }
                }
            }
        }

        private void spawnSpikeLine(double posX, double posZ, double posY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing((double)posX, (double)posY, (double)posZ);
            double d0 = 0.0;
            do {
                BlockState blockstate1;
                VoxelShape voxelshape;
                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = this.entity.level().getBlockState(blockpos1);
                if (!blockstate.isFaceSturdy((BlockGetter)this.entity.level(), blockpos1, Direction.DOWN)) continue;
                if (this.entity.level().isEmptyBlock(blockpos) || (voxelshape = (blockstate1 = this.entity.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.entity.level(), blockpos)).isEmpty()) break;
                d0 = voxelshape.max(Direction.Axis.Y);
                break;
            } while ((blockpos = blockpos.above()).getY() < Math.min(this.entity.level().getMaxBuildHeight(), this.entity.getBlockY() + 12));
            this.entity.level().addFreshEntity((Entity)new Ancient_Desert_Stele_Entity(this.entity.level(), posX, (double)blockpos.getY() + d0 - 3.0, posZ, rotation, delay, (float)CMCommonConfig.Wadjet.AncientDesertSteledamage, (LivingEntity)this.entity));
        }
    }
}

