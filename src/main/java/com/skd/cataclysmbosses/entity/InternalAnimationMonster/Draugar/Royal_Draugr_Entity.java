/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
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
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.animal.SnowGolem
 *  net.minecraft.world.entity.monster.Creeper
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.npc.AbstractVillager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.ItemAbilities
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Goals.Royal_DraugrAttackGoal;
import com.skd.cataclysmbosses.entity.etc.IShieldEntity;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Royal_Draugr_Entity
extends Monster
implements IShieldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    private int shieldCooldownTime = 0;

    public Royal_Draugr_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 7;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, (Goal)new Royal_DraugrAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder royal_draugr() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 5.0).add(Attributes.MAX_HEALTH, 30.0).add(Attributes.ARMOR, 5.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
    }

    protected AABB getAttackBoundingBox() {
        AABB aabb = super.getAttackBoundingBox();
        return aabb.deflate(0.05, 0.0, 0.05);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "attack") {
            return this.attackAnimationState;
        }
        if (input == "attack2") {
            return this.attack2AnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        return new AnimationState();
    }

    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (damage > 0.0f && this.canBlockDamageSource(source)) {
            this.hurtCurrentlyUsedShield(damage);
            if (!source.is(DamageTypeTags.IS_PROJECTILE) && entity instanceof LivingEntity) {
                this.blockUsingShield((LivingEntity)entity);
            }
            this.playSound(SoundEvents.SHIELD_BLOCK, 1.0f, 0.8f + this.level().random.nextFloat() * 0.4f);
            return false;
        }
        return super.hurtOrSimulate(source, damage);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    @Override
    public int getShieldCooldownTime() {
        return this.shieldCooldownTime;
    }

    @Override
    public void setShieldCooldownTime(int shieldCooldownTime) {
        this.shieldCooldownTime = shieldCooldownTime;
    }

    @Override
    public boolean isShieldDisabled() {
        return this.shieldCooldownTime > 0;
    }

    @Override
    public void disableShield(boolean guaranteeDisable) {
        this.shieldCooldownTime = 100;
        this.stopUsingItem();
        this.level().broadcastEntityEvent((Entity)this, (byte)30);
        this.playSound(SoundEvents.SHIELD_BREAK, 0.8f, 0.8f + this.level().random.nextFloat() * 0.4f);
    }

    protected void hurtCurrentlyUsedShield(float p_36383_) {
        if (this.useItem.canPerformAction(ItemAbilities.SHIELD_BLOCK) && p_36383_ >= 3.0f) {
            int i = 1 + Mth.floor((float)p_36383_);
            InteractionHand interactionhand = this.getUsedItemHand();
            Level level = this.level();
            if (level instanceof ServerLevel) {
                ServerLevel serverlevel = (ServerLevel)level;
                if (!this.hasInfiniteMaterials()) {
                    this.useItem.hurtAndBreak(i, serverlevel, (LivingEntity)this, item -> {
                        this.onEquippedItemBroken((Item)item, Royal_Draugr_Entity.getSlotForHand((InteractionHand)interactionhand));
                        this.stopUsingItem();
                    });
                }
            }
            if (this.useItem.isEmpty()) {
                this.stopUsingItem();
                if (interactionhand == InteractionHand.MAIN_HAND) {
                    this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                } else {
                    this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }
                this.useItem = ItemStack.EMPTY;
                this.playSound(SoundEvents.SHIELD_BREAK, 0.8f, 0.8f + this.level().random.nextFloat() * 0.4f);
            }
        }
    }

    public boolean isBlocking() {
        return false;
    }

    protected void blockUsingShield(LivingEntity p_36295_) {
        super.blockUsingShield(p_36295_);
        if (p_36295_.getMainHandItem().canDisableShield(this.useItem, (LivingEntity)this, p_36295_)) {
            this.disableShield(true);
        }
    }

    public boolean isDraugrBlocking() {
        if (this.isUsingItem() && !this.useItem.isEmpty()) {
            Item item = this.useItem.getItem();
            return !this.useItem.canPerformAction(ItemAbilities.SHIELD_BLOCK) ? false : item.getUseDuration(this.useItem, (LivingEntity)this) - this.useItemRemaining >= 5;
        }
        return false;
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Vec3 vector3d2;
        AbstractArrow abstractarrow;
        Entity entity = damageSourceIn.getDirectEntity();
        boolean flag = false;
        if (entity instanceof AbstractArrow && (abstractarrow = (AbstractArrow)entity).getPierceLevel() > 0) {
            flag = true;
        }
        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && this.isDraugrBlocking() && !flag && (vector3d2 = damageSourceIn.getSourcePosition()) != null) {
            Vec3 vector3d = this.getViewVector(1.0f);
            Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
            vector3d1 = new Vec3(vector3d1.x, 0.0, vector3d1.z);
            return vector3d1.dot(vector3d) < 0.0;
        }
        return false;
    }

    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
    }

    public HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
    }

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
        if (this.isDraugrBlocking()) {
            this.stopUsingItem();
            this.setShieldCooldownTime(30);
        }
        return super.doHurtTarget(p_219472_);
    }

    protected void dropCustomDeathLoot(ServerLevel p_348503_, DamageSource p_34697_, boolean p_34699_) {
        Creeper creeper;
        super.dropCustomDeathLoot(p_348503_, p_34697_, p_34699_);
        Entity entity = p_34697_.getEntity();
        if (entity instanceof Creeper && (creeper = (Creeper)entity).canDropMobsSkull()) {
            ItemStack itemstack = new ItemStack((ItemLike)ModItems.DRAUGR_HEAD.get());
            creeper.increaseDroppedSkulls();
            this.spawnAtLocation(itemstack);
        }
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, EntitySpawnReason p_34090_, @Nullable SpawnGroupData p_34091_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        this.populateDefaultEquipmentEnchantments(p_34088_, randomsource, p_34089_);
        this.setItemSlot(EquipmentSlot.OFFHAND, this.createSpawnShiled());
        return spawngroupdata;
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
    }

    private ItemStack createSpawnWeapon() {
        return this.random.nextBoolean() ? new ItemStack((ItemLike)ModItems.BLACK_STEEL_AXE.get()) : new ItemStack((ItemLike)ModItems.BLACK_STEEL_SWORD.get());
    }

    private ItemStack createSpawnShiled() {
        return new ItemStack((ItemLike)ModItems.BLACK_STEEL_TARGE.get());
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
        if (this.shieldCooldownTime > 0) {
            --this.shieldCooldownTime;
        }
    }

    public void aiStep() {
        super.aiStep();
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_MALEDICTUS)) {
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
}

