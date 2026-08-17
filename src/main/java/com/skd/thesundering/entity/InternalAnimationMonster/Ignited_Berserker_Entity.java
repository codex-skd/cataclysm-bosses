/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 */
package com.skd.thesundering.entity.InternalAnimationMonster;

import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.entity.etc.path.CMPathNavigateGround;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.util.CMDamageTypes;
import com.skd.thesundering.util.EntityUtil;
import com.skd.thesundering.world.data.CMWorldData;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;

public class Ignited_Berserker_Entity
extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState xslashAnimationState = new AnimationState();
    public AnimationState mixerstartAnimationState = new AnimationState();
    public AnimationState mixeridleAnimationState = new AnimationState();
    public AnimationState mixerfinishAnimationState = new AnimationState();
    public AnimationState sworddanceleftAnimationState = new AnimationState();
    public AnimationState sworddancerightAnimationState = new AnimationState();
    private int sword_dance_cooldown = 0;
    public static final int SWORD_DANCE_COOLDOWN = 40;
    private int spin_cooldown = 0;
    public static final int SPIN_COOLDOWN = 80;

    public Ignited_Berserker_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 20;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.goalSelector.addGoal(2, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 1, 0, 50, 15, 3.6f){

            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0f < 12.0f;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 5, 0, 50, 50, 4.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0f < 16.0f && Ignited_Berserker_Entity.this.sword_dance_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.sword_dance_cooldown = 40;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 6, 0, 55, 55, 4.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0f < 16.0f && Ignited_Berserker_Entity.this.sword_dance_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.sword_dance_cooldown = 40;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalAttackGoal(this, 0, 2, 3, 30, 25, 8.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0f < 12.0f && Ignited_Berserker_Entity.this.spin_cooldown <= 0;
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal((Internal_Animation_Monster)this, 3, 3, 4, 90, 0, false));
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 4, 4, 0, 40, 0){

            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.spin_cooldown = 80;
            }
        });
    }

    public static AttributeSupplier.Builder ignited_berserker() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.32f).add(Attributes.ATTACK_DAMAGE, 7.5).add(Attributes.MAX_HEALTH, 65.0).add(Attributes.ARMOR, 8.0).add(Attributes.STEP_HEIGHT, 1.25).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "x_slash") {
            return this.xslashAnimationState;
        }
        if (input == "mixer_start") {
            return this.mixerstartAnimationState;
        }
        if (input == "mixer_idle") {
            return this.mixeridleAnimationState;
        }
        if (input == "mixer_finish") {
            return this.mixerfinishAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "sword_dance_left") {
            return this.sworddanceleftAnimationState;
        }
        if (input == "sword_dance_right") {
            return this.sworddancerightAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
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
                    this.xslashAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.mixerstartAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.mixeridleAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.mixerfinishAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.sworddanceleftAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.sworddancerightAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.xslashAnimationState.stop();
        this.mixerstartAnimationState.stop();
        this.mixeridleAnimationState.stop();
        this.mixerfinishAnimationState.stop();
        this.sworddanceleftAnimationState.stop();
        this.sworddancerightAnimationState.stop();
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(0);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        if (ModEntities.rollSpawn(1, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)worldIn;
            CMWorldData data = CMWorldData.get((Level)serverLevel, (ResourceKey<Level>)Level.NETHER);
            return data != null && data.isIgnisDefeatedOnce();
        }
        return false;
    }

    @Override
    public int deathtimer() {
        return 20;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.onGround() && this.getDeltaMovement().y < 0.0) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.6, 1.0));
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }
        if (this.sword_dance_cooldown > 0) {
            --this.sword_dance_cooldown;
        }
        if (this.spin_cooldown > 0) {
            --this.spin_cooldown;
        }
        float dis = this.getBbWidth() * 0.75f;
        this.repelEntities(dis, this.getBbHeight(), dis, dis);
    }

    public void aiStep() {
        super.aiStep();
        float dis = this.getBbWidth();
        float f1 = (float)Math.cos(Math.toRadians(this.getYRot() + 90.0f));
        float f2 = (float)Math.sin(Math.toRadians(this.getYRot() + 90.0f));
        if (this.getAttackState() == 1) {
            if (this.attackTicks == 17) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 4.35f, dis * 4.35f, 45.0f, 1.25f, 60);
            }
            if (this.attackTicks == 35) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 3.6f, dis * 3.6f, 200.0f, 1.25f, 0);
            }
        }
        if (this.getAttackState() == 3 && this.tickCount % 4 == 0 && !this.level().isClientSide()) {
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.0))) {
                boolean flag;
                if (this.isAlliedTo((Entity)entity) || entity instanceof Ignited_Berserker_Entity || entity == this || !(flag = entity.hurt(this.damageSources().mobAttack((LivingEntity)this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)))) continue;
                double d0 = entity.getX() - this.getX();
                double d1 = entity.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                entity.push(d0 / d2 * 0.5, 0.1, d1 / d2 * 0.5);
            }
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 11 || this.attackTicks == 18 || this.attackTicks == 23 || this.attackTicks == 28) {
                this.push((double)f1 * 0.45, 0.0, (double)f2 * 0.45);
            }
            if (this.attackTicks == 13) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 4.5f, dis * 4.5f, 50.0f, 1.0f, 0);
            }
            if (this.attackTicks == 20) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 3.5f, dis * 3.5f, 60.0f, 1.0f, 0);
            }
            if (this.attackTicks == 25) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 4.5f, dis * 4.5f, 60.0f, 1.0f, 0);
            }
            if (this.attackTicks == 30) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 3.25f, dis * 3.25f, 60.0f, 1.0f, 0);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 15 || this.attackTicks == 123 || this.attackTicks == 26 || this.attackTicks == 33) {
                this.push((double)f1 * 0.45, 0.0, (double)f2 * 0.45);
            }
            if (this.attackTicks == 17) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 4.5f, dis * 4.5f, 40.0f, 1.0f, 0);
            }
            if (this.attackTicks == 25) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 3.25f, dis * 3.25f, 55.0f, 1.0f, 0);
            }
            if (this.attackTicks == 28) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 5.0f, dis * 5.0f, 60.0f, 1.0f, 0);
            }
            if (this.attackTicks == 35) {
                this.playSound((SoundEvent)ModSounds.SWING.get(), 1.0f, 1.2f);
                this.AreaAttack(dis * 3.5f, dis * 3.5f, 40.0f, 1.0f, 0);
            }
        }
    }

    private void AreaSwordAttack(float range, float height, float degree, float arc, float damage) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            boolean flag;
            float entityHitAngle = (float)((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * 57.29577951308232 - (double)degree) % 360.0);
            float entityAttackingAngle = this.yBodyRot % 360.0f;
            if (entityHitAngle < 0.0f) {
                entityHitAngle += 360.0f;
            }
            if (entityAttackingAngle < 0.0f) {
                entityAttackingAngle += 360.0f;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float)Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit == this || !(flag = entityHit.hurt(CMDamageTypes.causeSwordDanceDamage((LivingEntity)this), (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage)))) continue;
            MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND);
            int i = 1;
            if (effectinstance1 != null) {
                i += effectinstance1.getAmplifier();
                entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
            } else {
                --i;
            }
            i = Mth.clamp((int)i, (int)0, (int)1);
            MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 120, i, false, true, true);
            entityHit.addEffect(effectinstance);
            this.heal(3 * (i + 1));
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ignited_Berserker_Entity || entityHit == this) continue;
                boolean flag = entityHit.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                } else {
                    --i;
                }
                i = Mth.clamp((int)i, (int)0, (int)1);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, i, false, true, true);
                entityHit.addEffect(effectinstance);
                this.heal(2.0f * (float)(i + 1));
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
        if (entityIn.getType().is(ModTag.TEAM_IGNIS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.REVENANT_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.REVENANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.REVENANT_DEATH.get();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }
}

