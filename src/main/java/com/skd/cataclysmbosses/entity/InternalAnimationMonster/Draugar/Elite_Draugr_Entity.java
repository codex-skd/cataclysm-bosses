/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.animal.SnowGolem
 *  net.minecraft.world.entity.monster.Creeper
 *  net.minecraft.world.entity.monster.CrossbowAttackMob
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.npc.AbstractVillager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.item.CrossbowItem
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.component.ChargedProjectiles
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.AABB
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Goals.Elite_DraugrAttackGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Elite_Draugr_Entity
extends Internal_Animation_Monster
implements CrossbowAttackMob {
    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(Elite_Draugr_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState ReloadAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState Shoot1AnimationState = new AnimationState();
    public AnimationState Shoot2AnimationState = new AnimationState();

    public Elite_Draugr_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 5;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, (Goal)new CrossBowReloadGoal(this, 0, 1, 1, 30, 15, 12.0f));
        this.goalSelector.addGoal(0, (Goal)new ReloadedGoal(this, 1, 0, 20, 20.0f));
        this.goalSelector.addGoal(0, (Goal)new CrossBowShootGoal(this, 0, 4, 0, 23, 15, 12.0f));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(4, (Goal)new Elite_DraugrAttackGoal(this, 1.0, 12.0f, true));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder elite_draugr() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 5.0).add(Attributes.MAX_HEALTH, 32.0).add(Attributes.ARMOR, 3.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "attack") {
            return this.attackAnimationState;
        }
        if (input == "attack2") {
            return this.attack2AnimationState;
        }
        if (input == "re_load") {
            return this.ReloadAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "swing") {
            return this.swingAnimationState;
        }
        if (input == "shoot") {
            return this.Shoot1AnimationState;
        }
        if (input == "shoot2") {
            return this.Shoot2AnimationState;
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
                    this.ReloadAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.Shoot1AnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.swingAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.Shoot2AnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_CHARGING_CROSSBOW, false);
    }

    protected AABB getAttackBoundingBox() {
        AABB aabb = super.getAttackBoundingBox();
        return aabb.deflate(0.05, 0.0, 0.05);
    }

    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
        this.ReloadAnimationState.stop();
        this.swingAnimationState.stop();
        this.Shoot1AnimationState.stop();
        this.Shoot2AnimationState.stop();
    }

    public HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
    }

    @Override
    public void handleEntityEvent(byte p_219360_) {
        if (p_219360_ == 4) {
            if (this.random.nextBoolean()) {
                this.attackAnimationState.start(this.tickCount);
            } else {
                this.attack2AnimationState.start(this.tickCount);
            }
        } else {
            super.handleEntityEvent(p_219360_);
        }
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent((Entity)this, (byte)4);
        return super.doHurtTarget(p_219472_);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, EntitySpawnReason p_34090_, @Nullable SpawnGroupData p_34091_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        return spawngroupdata;
    }

    private ItemStack createSpawnWeapon() {
        return new ItemStack((ItemLike)Items.CROSSBOW);
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
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
    }

    public void aiStep() {
        super.aiStep();
    }

    protected void dropCustomDeathLoot(ServerLevel p_348503_, DamageSource p_34697_, boolean p_34699_) {
        Creeper creeper;
        super.dropCustomDeathLoot(p_348503_, p_34697_, p_34699_);
        Entity entity = p_34697_.getEntity();
        if (entity instanceof Creeper && (creeper = (Creeper)entity).canDropMobsSkull()) {
            ItemStack itemstack = new ItemStack((ItemLike)ModItems.DRAUGR_HEAD.get());
            creeper.increaseDroppedSkulls();
            this.spawnAtLocation((ServerLevel)this.level(), itemstack, 0.0f);
        }
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_MALEDICTUS)) {
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

    public boolean isChargingCrossbow() {
        return (Boolean)this.entityData.get(IS_CHARGING_CROSSBOW);
    }

    public void setChargingCrossbow(boolean p_33302_) {
        this.entityData.set(IS_CHARGING_CROSSBOW, p_33302_);
    }

    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }

    public void performRangedAttack(LivingEntity p_33317_, float p_33318_) {
        this.performCrossbowAttack((LivingEntity)this, 1.6f);
    }

    static class CrossBowReloadGoal
    extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private CrossbowState crossbowState = CrossbowState.UNCHARGED;

        public CrossBowReloadGoal(Elite_Draugr_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && this.entity.getRandom().nextFloat() * 100.0f < 22.0f && target.isAlive() && this.entity.distanceTo((Entity)target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && this.isHoldingCrossbow() && !this.entity.isChargingCrossbow();
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {
            this.entity.setAttackState(this.attackendstate);
        }

        public boolean canContinueToUse() {
            return this.entity.getAttackState() == this.attackstate && this.entity.attackTicks <= this.attackMaxtick;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }

        public void tick() {
            ItemStack itemstack;
            int i;
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (this.entity.attackTicks == 5) {
                this.entity.startUsingItem(ProjectileUtil.getWeaponHoldingHand((LivingEntity)this.entity, item -> item instanceof CrossbowItem));
            }
            if ((i = this.entity.getTicksUsingItem()) >= CrossbowItem.getChargeDuration((ItemStack)(itemstack = this.entity.getUseItem()), (LivingEntity)this.entity)) {
                this.entity.releaseUsingItem();
                this.entity.setChargingCrossbow(true);
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ReloadedGoal
    extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackendstate;
        private final int attackseetick;
        private final float attackrange;

        public ReloadedGoal(Elite_Draugr_Entity entity, int getattackstate, int attackendstate, int attackseetick, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackendstate = attackendstate;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo((Entity)target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && this.isHoldingCrossbow() && this.entity.isChargingCrossbow();
        }

        public void start() {
            LivingEntity livingentity = this.entity.getTarget();
            boolean flag = true;
            if (livingentity != null) {
                float f = livingentity.getBbWidth();
                float dis = f * 2.5f * f * 2.5f + livingentity.getBbWidth();
                double d0 = this.entity.distanceToSqr((Entity)livingentity);
                if (d0 <= (double)dis) {
                    flag = false;
                }
            }
            if (flag) {
                this.entity.setAttackState(2);
            } else {
                this.entity.setAttackState(3);
            }
        }

        public void stop() {
            this.entity.setAttackState(this.attackendstate);
        }

        public boolean canContinueToUse() {
            return (this.entity.getAttackState() == 2 || this.entity.getAttackState() == 3) && this.entity.attackTicks <= 30;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (this.entity.getAttackState() == 2 && target != null && this.entity.attackTicks == 10) {
                this.entity.performRangedAttack(target, 1.0f);
                this.entity.setChargingCrossbow(false);
            }
            if (this.entity.getAttackState() == 3 && target != null && this.entity.attackTicks == 11) {
                DamageSource damagesource = this.entity.damageSources().mobAttack((LivingEntity)this.entity);
                target.hurtOrSimulate(damagesource, (float)this.entity.getAttributeValue(Attributes.ATTACK_DAMAGE));
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        protected double getAttackReachSqr(LivingEntity p_25556_) {
            float f = p_25556_.getBbWidth();
            return f * 2.5f * f * 2.5f + p_25556_.getBbWidth();
        }
    }

    static class CrossBowShootGoal
    extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        public CrossBowShootGoal(Elite_Draugr_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && this.entity.getRandom().nextFloat() * 100.0f < 22.0f && target.isAlive() && this.entity.distanceTo((Entity)target) < this.attackrange && this.entity.getAttackState() == this.getattackstate && this.isHoldingCrossbow() && this.entity.isChargingCrossbow();
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {
            this.entity.setAttackState(this.attackendstate);
        }

        public boolean canContinueToUse() {
            return this.entity.getAttackState() == this.attackstate && this.entity.attackTicks <= this.attackMaxtick;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                this.entity.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }
            if (target != null && this.entity.attackTicks == 11) {
                this.entity.performRangedAttack(target, 1.0f);
                ItemStack itemstack1 = this.entity.getItemInHand(ProjectileUtil.getWeaponHoldingHand((LivingEntity)this.entity, item -> item instanceof CrossbowItem));
                if (this.isHoldingCrossbow()) {
                    this.entity.getUseItem().set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY);
                }
                this.entity.setChargingCrossbow(false);
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    private static enum CrossbowState {
        UNCHARGED,
        CHARGING,
        CHARGED,
        READY_TO_ATTACK;

    }
}

