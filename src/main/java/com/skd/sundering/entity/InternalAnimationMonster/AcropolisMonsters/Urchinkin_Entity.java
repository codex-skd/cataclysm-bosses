/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.entity.InternalAnimationMonster.AcropolisMonsters;

import com.skd.sundering.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.sundering.entity.projectile.Urchin_Spike_Entity;
import com.skd.sundering.init.ModItems;
import com.skd.sundering.init.ModSounds;
import com.skd.sundering.init.ModTag;
import java.util.EnumSet;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

public class Urchinkin_Entity
extends Monster {
    boolean searchingForLand;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState rollAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(Urchinkin_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private int roll_cooldown = 0;
    public static final int ROLL_COOLDOWN = 80;
    public int attackTicks;
    protected final SemiAquaticPathNavigator waterNavigation;
    protected final GroundPathNavigation groundNavigation;

    public Urchinkin_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 5;
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.waterNavigation = new SemiAquaticPathNavigator((Mob)this, world);
        this.groundNavigation = new GroundPathNavigation((Mob)this, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new Roll(this, 0, 1, 0, 40, 12, 5.0f, 13, 30, 50.0f));
        this.goalSelector.addGoal(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, true));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
    }

    public static AttributeSupplier.Builder urchin() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.37f).add(Attributes.ATTACK_DAMAGE, 3.0).add(Attributes.MAX_HEALTH, 12.0);
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater() && this.wantsToSwim()) {
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
            if (inWaterAI && !(this.moveControl instanceof UrchinkinSwimControl)) {
                this.navigation = this.waterNavigation;
                this.moveControl = new UrchinkinSwimControl(this, 4.0f);
                this.setSwimming(true);
            } else if (!inWaterAI && this.moveControl instanceof UrchinkinSwimControl) {
                this.navigation = this.groundNavigation;
                this.moveControl = new MoveControl((Mob)this);
                this.setSwimming(false);
            }
        }
    }

    public AnimationState getAnimationState(String input) {
        if (input == "roll") {
            return this.rollAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "attack") {
            return this.attackAnimationState;
        }
        return new AnimationState();
    }

    public boolean isMeatBoy() {
        String s = ChatFormatting.stripFormatting((String)this.getName().getString());
        return s != null && s.toLowerCase().contains("meatboy");
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(ATTACK_STATE, (Object)0);
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
                    this.rollAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public int getAttackState() {
        return (Integer)this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.entityData.set(ATTACK_STATE, (Object)input);
        this.level().broadcastEntityEvent((Entity)this, (byte)(-input));
    }

    public void stopAllAnimationStates() {
        this.rollAnimationState.stop();
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent((Entity)this, (byte)4);
        return super.doHurtTarget(p_219472_);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        } else if (id == 4) {
            this.attackAnimationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(id);
        }
    }

    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 2.0f;
    }

    public void tick() {
        super.tick();
        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
        if (this.roll_cooldown > 0) {
            --this.roll_cooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 1) {
            if (this.attackTicks > 13 && this.attackTicks < 30 && !this.level().isClientSide()) {
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)livingentity) || livingentity instanceof Urchinkin_Entity || livingentity == this || !(flag = livingentity.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)))) continue;
                    livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0), (Entity)this);
                }
            }
            if (this.attackTicks == 13 || this.attackTicks == 16 || this.attackTicks == 19 || this.attackTicks == 22 || this.attackTicks == 25 || this.attackTicks == 28) {
                this.SpikeNansa(3);
            }
        }
    }

    public void die(DamageSource cause) {
        super.die(cause);
        this.SpikeNansa(6);
    }

    private void SpikeNansa(int spike) {
        int shardCount = spike + this.random.nextInt(2);
        if (!this.level().isClientSide()) {
            for (int i = 0; i < shardCount; ++i) {
                float f = (float)(i + 1) / (float)shardCount * 360.0f;
                Urchin_Spike_Entity shard = new Urchin_Spike_Entity(this.level(), (LivingEntity)this);
                if (this.isMeatBoy()) {
                    ItemStack itemstack = new ItemStack((ItemLike)ModItems.BLOOD_CLOT.get());
                    shard.setItem(itemstack);
                }
                shard.shoot(this.random.nextFloat() * 0.4f * 2.0f - 0.4f, this.random.nextFloat() * 0.25f + 0.1f, this.random.nextFloat() * 0.4f * 2.0f - 0.4f, 0.35f, 1.0f);
                this.level().addFreshEntity((Entity)shard);
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
        if (entityIn.getType().is(ModTag.TEAM_SCYLLA)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.DRAUGR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.DRAUGR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.DRAUGR_IDLE.get();
    }

    static class Roll
    extends Goal {
        private final Urchinkin_Entity entity;
        private final int attackrollstart;
        private final int attackrollend;
        private final float random;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        public Roll(Urchinkin_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackroll, int attackrollend, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.getattackstate = getAttackState;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.attackrollstart = attackroll;
            this.attackrollend = attackrollend;
            this.random = random;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo((Entity)target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.getSensing().hasLineOfSight((Entity)target) && this.entity.roll_cooldown <= 0;
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {
            this.entity.setAttackState(this.attackendstate);
            this.entity.roll_cooldown = 80;
        }

        public boolean canContinueToUse() {
            return this.entity.getAttackState() == this.attackstate && this.entity.attackTicks <= this.attackMaxtick;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (this.attackrollstart < this.entity.attackTicks && this.attackrollend > this.entity.attackTicks) {
                Vec3 vector3d = this.entity.getDeltaMovement();
                float f = this.entity.getYRot() * ((float)Math.PI / 180);
                Vec3 vector3d1 = new Vec3((double)(-Mth.sin((float)f)), this.entity.getDeltaMovement().y, (double)Mth.cos((float)f)).scale(0.35).add(vector3d.scale(0.35));
                this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class UrchinkinSwimControl
    extends MoveControl {
        private final Urchinkin_Entity drowned;
        private final float speedMulti;

        public UrchinkinSwimControl(Urchinkin_Entity p_32433_, float speedMulti) {
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

