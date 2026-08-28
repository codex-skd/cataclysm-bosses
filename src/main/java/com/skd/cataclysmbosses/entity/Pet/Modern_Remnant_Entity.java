/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.Holder
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ItemUtils
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.component.CustomData
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.Pet;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.Pet.AI.TameableAIFollowOwner;
import com.skd.cataclysmbosses.entity.Pet.LLibraryAnimationPet;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Modern_Remnant_Entity
extends LLibraryAnimationPet
implements Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Modern_Remnant_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public float sitProgress;
    public float prevSitProgress;
    private AttackMode mode = AttackMode.CIRCLE;
    public static final Animation MODERN_REMNANT_BITE = Animation.create((int)11);

    public Modern_Remnant_Entity(EntityType type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.ModernRemnant.healthMultiplier, CMCommonConfig.ModernRemnant.attackMultiplier);
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.REMNANT_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.REMNANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.MODERN_REMNANT_DEATH.get();
    }

    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 2.0f;
    }

    public static AttributeSupplier.Builder modernremnant() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.5).add(Attributes.ARMOR, 5.0).add(Attributes.FOLLOW_RANGE, 32.0).add(Attributes.ATTACK_DAMAGE, 6.0).add(Attributes.STEP_HEIGHT, 1.0).add(Attributes.MOVEMENT_SPEED, (double)0.4f);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, (Goal)new SitWhenOrderedToGoal((TamableAnimal)this));
        this.goalSelector.addGoal(3, (Goal)new ModernRemnantAIMelee(this));
        this.goalSelector.addGoal(6, (Goal)new TameableAIFollowOwner(this, 1.3, 6.0f, 2.0f, true));
        this.goalSelector.addGoal(6, (Goal)new TemptGoal((PathfinderMob)this, 1.0, (Predicate)Ingredient.of((ItemLike[])new ItemLike[]{Items.SNIFFER_EGG}), false));
        this.goalSelector.addGoal(7, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 60));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(8, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.targetSelector.addGoal(1, (Goal)new OwnerHurtByTargetGoal((TamableAnimal)this));
        this.targetSelector.addGoal(2, (Goal)new OwnerHurtTargetGoal((TamableAnimal)this));
        this.targetSelector.addGoal(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(5, (Goal)new NonTameRandomTargetGoal((TamableAnimal)this, LivingEntity.class, false, ModEntities.buildPredicateFromTag(ModTag.MODERN_REMNANT_TARGET)));
    }

    public void travel(Vec3 vec3d) {
        if (this.isSitting()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            vec3d = Vec3.ZERO;
        }
        super.travel(vec3d);
    }

    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(FROM_BUCKET, false);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.fromBucket());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBooleanOr("FromBucket", false));
    }

    @Override
    public boolean isFood(ItemStack p_27600_) {
        return p_27600_.is(ModTag.BONE_ITEM);
    }

    public boolean fromBucket() {
        return (Boolean)this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean sit) {
        this.entityData.set(FROM_BUCKET, sit);
    }

    public void saveToBucketTag(@Nonnull ItemStack bucket) {
        Bucketable.saveDefaultDataToBucketTag((Mob)this, (ItemStack)bucket);
        CustomData.update((DataComponentType)DataComponents.BUCKET_ENTITY_DATA, (ItemStack)bucket, this::addAdditionalSaveData);
    }

    public void loadFromBucketTag(CompoundTag p_148832_) {
        this.readAdditionalSaveData(p_148832_);
        Bucketable.loadDefaultDataFromBucketTag((Mob)this, (CompoundTag)p_148832_);
    }

    @Nonnull
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack((ItemLike)ModItems.MODERN_REMNANT_BUCKET.get());
        return stack;
    }

    public SoundEvent getPickupSound() {
        return (SoundEvent)ModSounds.MODERN_REMNANT_FILL_BUCKET.get();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        Optional<InteractionResult> result;
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        InteractionResult type = super.mobInteract(player, hand);
        if (!this.isTame() && item == Items.SNIFFER_EGG) {
            this.usePlayerItem(player, hand, itemstack);
            this.gameEvent((Holder)GameEvent.EAT);
            if (!EventHooks.onAnimalTame((Animal)this, (Player)player)) {
                this.tame(player);
                this.level().broadcastEntityEvent((Entity)this, (byte)7);
            } else {
                this.level().broadcastEntityEvent((Entity)this, (byte)6);
            }
            return InteractionResult.SUCCESS;
        }
        if (this.isTame() && this.isFood(itemstack)) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.usePlayerItem(player, hand, itemstack);
                this.gameEvent((Holder)GameEvent.EAT);
                this.heal(5.0f);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }
        if (this.isTame() && (result = Modern_Remnant_Entity.emptybucketMobPickup(player, hand, this)).isPresent()) {
            return result.get();
        }
        InteractionResult interactionresult = itemstack.interactLivingEntity(player, (LivingEntity)this, hand);
        if (interactionresult != InteractionResult.SUCCESS && type != InteractionResult.SUCCESS && this.isTame() && this.isOwnedBy((LivingEntity)player) && !player.isShiftKeyDown()) {
            boolean sit;
            this.setCommand(this.getCommand() + 1);
            if (this.getCommand() == 3) {
                this.setCommand(0);
            }
            player.displayClientMessage((Component)Component.translatable((String)("entity.cataclysm.all.command_" + this.getCommand()), (Object[])new Object[]{this.getName()}), true);
            boolean bl = sit = this.getCommand() == 2;
            if (sit) {
                this.setOrderedToSit(true);
                return InteractionResult.SUCCESS;
            }
            this.setOrderedToSit(false);
            return InteractionResult.SUCCESS;
        }
        return type;
    }

    private static <T extends LivingEntity> Optional<InteractionResult> emptybucketMobPickup(Player p_148829_, InteractionHand p_148830_, T p_148831_) {
        ItemStack itemstack = p_148829_.getItemInHand(p_148830_);
        if (itemstack.getItem() == Items.BUCKET && p_148831_.isAlive()) {
            p_148831_.playSound(((Bucketable)p_148831_).getPickupSound(), 1.0f, 1.0f);
            ItemStack itemstack1 = ((Bucketable)p_148831_).getBucketItemStack();
            ((Bucketable)p_148831_).saveToBucketTag(itemstack1);
            ItemStack itemstack2 = ItemUtils.createFilledResult((ItemStack)itemstack, (Player)p_148829_, (ItemStack)itemstack1, (boolean)false);
            p_148829_.setItemInHand(p_148830_, itemstack2);
            Level level = p_148831_.level();
            if (!level.isClientSide()) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)p_148829_, itemstack1);
            }
            p_148831_.discard();
            return Optional.of(InteractionResult.sidedSuccess((boolean)level.isClientSide()));
        }
        return Optional.empty();
    }

    public void aiStep() {
        super.aiStep();
        if (this.isSitting() && this.getNavigation().isDone()) {
            this.getNavigation().stop();
        }
        this.prevSitProgress = this.sitProgress;
        if (this.isSitting() && this.sitProgress < 10.0f) {
            this.sitProgress += 1.0f;
        }
        if (!this.isSitting() && this.sitProgress > 0.0f) {
            this.sitProgress -= 1.0f;
        }
        if (this.getAnimation() == MODERN_REMNANT_BITE && this.getAnimationTick() == 3) {
            this.playSound((SoundEvent)ModSounds.MODERN_REMNANT_BITE.get(), 0.5f, 2.0f);
        }
        AnimationHandler.INSTANCE.updateAnimations((Entity)this);
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    public boolean considersEntityAsAlly(Entity entityIn) {
        if (this.isTame()) {
            LivingEntity livingentity = this.getOwner();
            if (entityIn == livingentity) {
                return true;
            }
            if (entityIn instanceof TamableAnimal) {
                return ((TamableAnimal)entityIn).isOwnedBy(livingentity);
            }
            if (livingentity != null) {
                return livingentity.isAlliedTo(entityIn);
            }
        }
        return super.considersEntityAsAlly(entityIn);
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, MODERN_REMNANT_BITE};
    }

    private static enum AttackMode {
        CIRCLE,
        MELEE;

    }

    class ModernRemnantAIMelee
    extends Goal {
        private final Modern_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private int maxcirclingTime = 0;
        private float circleDistance = 13.0f;
        private boolean clockwise = false;
        private float MeleeModeTime = 0.0f;
        private static final int MELEE_MODE_TIME = 120;

        public ModernRemnantAIMelee(Modern_Remnant_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && this.target.isAlive();
        }

        public boolean canContinueToUse() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.maxcirclingTime = 120 + this.mob.random.nextInt(40);
            this.circleDistance = 8 + this.mob.random.nextInt(4);
            this.clockwise = this.mob.random.nextBoolean();
            this.MeleeModeTime = 0.0f;
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.maxcirclingTime = 120 + this.mob.random.nextInt(40);
            this.circleDistance = 8 + this.mob.random.nextInt(4);
            this.clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(this.target)) {
                this.mob.setTarget(null);
            }
            this.MeleeModeTime = 0.0f;
            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == AttackMode.CIRCLE) {
                    ++this.circlingTime;
                    Modern_Remnant_Entity.this.circleEntity(target, this.circleDistance, 1.0f, this.clockwise, this.circlingTime, 0.0f, 1.0f);
                    if (this.circlingTime >= this.maxcirclingTime) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                    if (target.distanceTo((Entity)this.mob) < 5.0f) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    this.MeleeModeTime += 1.0f;
                    this.mob.getNavigation().moveTo((Entity)target, 1.0);
                    this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    if (this.MeleeModeTime >= 120.0f) {
                        this.start();
                    } else if (this.mob.distanceToSqr((Entity)target) <= 4.0 && this.mob.getAnimation() == IAnimatedEntity.NO_ANIMATION) {
                        this.mob.setAnimation(MODERN_REMNANT_BITE);
                    }
                }
                if (this.mob.getAnimation() == MODERN_REMNANT_BITE && this.mob.getAnimationTick() == 5 && this.mob.distanceTo((Entity)target) < this.mob.getBbWidth() * 2.5f * this.mob.getBbWidth() * 2.5f + target.getBbWidth()) {
                    float damage = (float)this.mob.getAttributeValue(Attributes.ATTACK_DAMAGE);
                    target.hurtOrSimulate(Modern_Remnant_Entity.this.damageSources().mobAttack((LivingEntity)this.mob), damage);
                }
            }
        }
    }
}

