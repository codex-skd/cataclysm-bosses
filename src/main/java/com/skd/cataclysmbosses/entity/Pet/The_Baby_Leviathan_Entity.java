/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
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
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.ItemTags
 *  net.minecraft.util.Mth
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
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal
 *  net.minecraft.world.entity.ai.goal.TemptGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal
 *  net.minecraft.world.entity.animal.Animal
 *  net.minecraft.world.entity.animal.Bucketable
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.component.CustomData
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.Pet;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.EntityAINearestTarget3D;
import com.skd.cataclysmbosses.entity.AI.MobAIFindWater;
import com.skd.cataclysmbosses.entity.AI.MobAILeaveWater;
import com.skd.cataclysmbosses.entity.AI.SemiAquaticAIRandomSwimming;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Entity;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import com.skd.cataclysmbosses.entity.Pet.AI.PetSimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.Pet.AI.TameableAIFollowOwnerWater;
import com.skd.cataclysmbosses.entity.Pet.LLibraryAnimationPet;
import com.skd.cataclysmbosses.entity.etc.ISemiAquatic;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.GroundPathNavigatorWide;
import com.skd.cataclysmbosses.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.cataclysmbosses.entity.projectile.Mini_Abyss_Blast_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class The_Baby_Leviathan_Entity
extends LLibraryAnimationPet
implements ISemiAquatic,
Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(The_Baby_Leviathan_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public static final Animation BABY_LEVIATHAN_BITE = Animation.create((int)14);
    public static final Animation BABY_LEVIATHAN_ABYSS_BLAST = Animation.create((int)157);
    public float sitProgress;
    public float prevSitProgress;
    public float SwimProgress;
    public float prevSwimProgress;
    private int fishFeedings;
    private boolean isLandNavigator;
    private AttackMode mode = AttackMode.CIRCLE;
    private int blast_cooldown = 0;
    public static final int BLAST_HUNTING_COOLDOWN = 100;
    public double endPosX;
    public double endPosY;
    public double endPosZ;
    public double collidePosX;
    public double collidePosY;
    public double collidePosZ;

    public The_Baby_Leviathan_Entity(EntityType type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.switchNavigator(false);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.BabyLeviathan.healthMultiplier, CMCommonConfig.BabyLeviathan.attackMultiplier);
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.LEVIATHAN_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.LEVIATHAN_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.LEVIATHAN_DEFEAT.get();
    }

    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 2.0f;
    }

    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Mini_Abyss_Blast_Entity || entity instanceof Abyss_Blast_Entity || entity instanceof Portal_Abyss_Blast_Entity) {
            return false;
        }
        return super.hurtOrSimulate(source, amount);
    }

    public static AttributeSupplier.Builder babyleviathan() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 120.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.5).add(Attributes.ARMOR, 5.0).add(Attributes.FOLLOW_RANGE, 32.0).add(Attributes.STEP_HEIGHT, 1.0).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.MOVEMENT_SPEED, (double)0.2f);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, (Goal)new SitWhenOrderedToGoal((TamableAnimal)this));
        this.goalSelector.addGoal(2, (Goal)new TameableAIFollowOwnerWater(this, 1.3, 4.0f, 2.0f, true));
        this.goalSelector.addGoal(3, (Goal)new BabyLeviathanAttackGoal(this));
        this.goalSelector.addGoal(0, (Goal)new BabyLeviathanBiteAttackGoal(this, BABY_LEVIATHAN_BITE));
        this.goalSelector.addGoal(0, (Goal)new BabyLeviathanBlastAttackGoal(this, BABY_LEVIATHAN_ABYSS_BLAST));
        this.goalSelector.addGoal(4, (Goal)new MobAIFindWater((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(4, (Goal)new MobAILeaveWater((PathfinderMob)this));
        this.goalSelector.addGoal(6, (Goal)new TemptGoal((PathfinderMob)this, 1.0, (Predicate)Ingredient.of((ItemLike[])new ItemLike[]{Items.TROPICAL_FISH}), false));
        this.goalSelector.addGoal(7, (Goal)new SemiAquaticAIRandomSwimming((Animal)this, 1.0, 30));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(8, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.targetSelector.addGoal(1, (Goal)new OwnerHurtByTargetGoal((TamableAnimal)this));
        this.targetSelector.addGoal(2, (Goal)new OwnerHurtTargetGoal((TamableAnimal)this));
        this.targetSelector.addGoal(3, (Goal)new EntityAINearestTarget3D((Mob)this, LivingEntity.class, 120, false, true, ModEntities.buildPredicateFromTag(ModTag.BABY_LEVIATHAN_TARGET)){

            public boolean canUse() {
                return The_Baby_Leviathan_Entity.this.getCommand() != 2 && !The_Baby_Leviathan_Entity.this.isSitting() && super.canUse() && !The_Baby_Leviathan_Entity.this.isTame();
            }
        });
        this.targetSelector.addGoal(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl((Mob)this);
            this.navigation = new GroundPathNavigatorWide((Mob)this, this.level());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new BabyLeviathanMoveController(this, 3.0f, 1.0f, 10.0f);
            this.navigation = new SemiAquaticPathNavigator((Mob)this, this.level());
            this.isLandNavigator = false;
        }
    }

    public void travel(Vec3 travelVector) {
        if (this.isSitting()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            travelVector = Vec3.ZERO;
            super.travel(travelVector);
            return;
        }
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null && this.getAnimation() == NO_ANIMATION) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(travelVector);
        }
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
        return p_27600_.is(ItemTags.FISHES);
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
        ItemStack stack = new ItemStack((ItemLike)ModItems.THE_BABY_LEVIATHAN_BUCKET.get());
        return stack;
    }

    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        Optional result;
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        InteractionResult type = super.mobInteract(player, hand);
        if (!this.isTame() && item == Items.TROPICAL_FISH) {
            this.usePlayerItem(player, hand, itemstack);
            this.gameEvent((Holder)GameEvent.EAT);
            ++this.fishFeedings;
            if ((this.fishFeedings > 10 && this.getRandom().nextInt(6) == 0 || this.fishFeedings > 30) && !EventHooks.onAnimalTame((Animal)this, (Player)player)) {
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
        if (this.isTame() && (result = Bucketable.bucketMobPickup((Player)player, (InteractionHand)hand, (LivingEntity)this)).isPresent()) {
            return (InteractionResult)result.get();
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

    public void aiStep() {
        super.aiStep();
        if (this.isSitting() && this.getNavigation().isDone()) {
            this.getNavigation().stop();
        }
        boolean swim = this.isInWater();
        this.prevSwimProgress = this.SwimProgress;
        this.prevSitProgress = this.sitProgress;
        if (this.SwimProgress < 5.0f && swim) {
            this.SwimProgress += 1.0f;
        }
        if (this.SwimProgress > 0.0f && !swim) {
            this.SwimProgress -= 1.0f;
        }
        if (this.isSitting() && this.sitProgress < 5.0f) {
            this.sitProgress += 1.0f;
        }
        if (!this.isSitting() && this.sitProgress > 0.0f) {
            this.sitProgress -= 1.0f;
        }
        if (this.isInWater() && this.isLandNavigator) {
            this.switchNavigator(false);
        }
        if (!this.isInWater() && !this.isLandNavigator) {
            this.switchNavigator(true);
        }
        if (this.blast_cooldown > 0) {
            --this.blast_cooldown;
        }
        AnimationHandler.INSTANCE.updateAnimations((Entity)this);
        if (this.getAnimation() == BABY_LEVIATHAN_BITE) {
            if (this.getAnimationTick() == 7) {
                this.playSound((SoundEvent)ModSounds.LEVIATHAN_BITE.get(), 0.5f, 2.0f);
            }
            if (this.getAnimationTick() == 9) {
                this.biteattack(1.5f, 0.5, 0.5, 0.5);
            }
        }
    }

    private void biteattack(float radius, double inflateX, double inflateY, double inflateZ) {
        double renderYaw = (double)(this.yHeadRot + 90.0f) * Math.PI / 180.0;
        double renderPitch = (float)((double)(-this.getXRot()) * Math.PI / 180.0);
        this.endPosX = this.getX() + (double)radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        this.endPosZ = this.getZ() + (double)radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        this.endPosY = this.getY() + (double)radius * Math.sin(renderPitch);
        if (!this.level().isClientSide()) {
            List<LivingEntity> hit = this.raytraceEntities((Level)this.level(), (double)inflateX, (double)inflateY, (double)inflateZ, (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ)).entities;
            for (LivingEntity target : hit) {
                if (this.isAlliedTo((Entity)target) || target instanceof The_Baby_Leviathan_Entity || target == this) continue;
                target.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE));
            }
        }
    }

    private BiteHitResult raytraceEntities(Level world, double inflateX, double inflateY, double inflateZ, Vec3 from, Vec3 to) {
        BiteHitResult result = new BiteHitResult();
        this.collidePosX = this.endPosX;
        this.collidePosY = this.endPosY;
        this.collidePosZ = this.endPosZ;
        List entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(this.getX(), this.collidePosX), Math.min(this.getY(), this.collidePosY), Math.min(this.getZ(), this.collidePosZ), Math.max(this.getX(), this.collidePosX), Math.max(this.getY(), this.collidePosY), Math.max(this.getZ(), this.collidePosZ)).inflate(inflateX, inflateY, inflateZ));
        for (LivingEntity entity : entities) {
            float pad = 2.5f;
            AABB aabb = entity.getBoundingBox().inflate((double)pad, (double)pad, (double)pad);
            Optional hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
                continue;
            }
            if (!hit.isPresent()) continue;
            result.addEntityHit(entity);
        }
        return result;
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    public boolean isAlliedTo(Entity entityIn) {
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
        return super.isAlliedTo(entityIn);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldEnterWater() {
        return !this.isSitting();
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return this.isSitting();
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, BABY_LEVIATHAN_ABYSS_BLAST, BABY_LEVIATHAN_BITE};
    }

    private static enum AttackMode {
        CIRCLE,
        MELEE,
        RANGE;

    }

    class BabyLeviathanAttackGoal
    extends Goal {
        private final The_Baby_Leviathan_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private float circleDistance = 4.0f;
        private boolean clockwise = false;
        private float MeleeModeTime = 0.0f;
        private static final int MELEE_MODE_TIME = 100;

        public BabyLeviathanAttackGoal(The_Baby_Leviathan_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && this.target.isAlive() && this.mob.getAnimation() == IAnimatedEntity.NO_ANIMATION;
        }

        public boolean canContinueToUse() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.MeleeModeTime = 0.0f;
            this.circleDistance = 8 + this.mob.random.nextInt(2);
            this.clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.MeleeModeTime = 0.0f;
            this.circleDistance = 8 + this.mob.random.nextInt(2);
            this.clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(this.target)) {
                this.mob.setTarget(null);
            }
            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == AttackMode.CIRCLE) {
                    ++this.circlingTime;
                    The_Baby_Leviathan_Entity.this.circleEntity(target, this.circleDistance, 1.0f, this.clockwise, this.circlingTime, 0.0f, 1.0f);
                    this.mob.mode = 0 >= this.mob.blast_cooldown ? AttackMode.RANGE : AttackMode.MELEE;
                } else if (this.mob.mode == AttackMode.RANGE) {
                    if (this.mob.getRandom().nextFloat() * 100.0f < 3.0f) {
                        this.mob.setAnimation(BABY_LEVIATHAN_ABYSS_BLAST);
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    this.MeleeModeTime += 1.0f;
                    this.mob.getNavigation().moveTo((Entity)target, 1.0);
                    this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                    if (this.MeleeModeTime >= 100.0f) {
                        this.mob.mode = AttackMode.RANGE;
                    } else if (this.mob.distanceToSqr((Entity)target) <= 4.0) {
                        this.mob.setAnimation(BABY_LEVIATHAN_BITE);
                    }
                }
            }
        }
    }

    static class BabyLeviathanBiteAttackGoal
    extends PetSimpleAnimationGoal<The_Baby_Leviathan_Entity> {
        public BabyLeviathanBiteAttackGoal(The_Baby_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Baby_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Baby_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Baby_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = ((The_Baby_Leviathan_Entity)this.entity).getTarget();
            if (((The_Baby_Leviathan_Entity)this.entity).getAnimationTick() < 9 && target != null) {
                ((The_Baby_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void stop() {
            super.stop();
            LivingEntity target = ((The_Baby_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Baby_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
        }
    }

    static class BabyLeviathanBlastAttackGoal
    extends PetSimpleAnimationGoal<The_Baby_Leviathan_Entity> {
        public BabyLeviathanBlastAttackGoal(The_Baby_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Baby_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Baby_Leviathan_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.ABYSS_BLAST.get(), SoundSource.NEUTRAL, 1.0f, 2.0f);
            LivingEntity target = ((The_Baby_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Baby_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                ((The_Baby_Leviathan_Entity)this.entity).lookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Baby_Leviathan_Entity)this.entity).blast_cooldown = 100;
        }

        public void tick() {
            ((The_Baby_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Baby_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Baby_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                ((The_Baby_Leviathan_Entity)this.entity).lookAt((Entity)target, 30.0f, 90.0f);
            }
            float dir = 90.0f;
            if (((The_Baby_Leviathan_Entity)this.entity).getAnimationTick() == 37 && !((The_Baby_Leviathan_Entity)this.entity).level().isClientSide()) {
                Mini_Abyss_Blast_Entity DeathBeam = new Mini_Abyss_Blast_Entity((EntityType<? extends Mini_Abyss_Blast_Entity>)((EntityType)ModEntities.MINI_ABYSS_BLAST.get()), ((The_Baby_Leviathan_Entity)this.entity).level(), (LivingEntity)this.entity, ((The_Baby_Leviathan_Entity)this.entity).getX(), ((The_Baby_Leviathan_Entity)this.entity).getY(), ((The_Baby_Leviathan_Entity)this.entity).getZ(), (float)((double)(((The_Baby_Leviathan_Entity)this.entity).yHeadRot + dir) * Math.PI / 180.0), (float)((double)(-((The_Baby_Leviathan_Entity)this.entity).getXRot()) * Math.PI / 180.0), 80, dir);
                ((The_Baby_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)DeathBeam);
            }
        }
    }

    static class BabyLeviathanMoveController
    extends MoveControl {
        private final The_Baby_Leviathan_Entity entity;
        private final float speedMulti;
        private final float ySpeedMod;
        private final float yawLimit;
        private int stillTicks = 0;

        public BabyLeviathanMoveController(The_Baby_Leviathan_Entity entity, float speedMulti, float ySpeedMod, float yawLimit) {
            super((Mob)entity);
            this.entity = entity;
            this.speedMulti = speedMulti;
            this.ySpeedMod = ySpeedMod;
            this.yawLimit = yawLimit;
        }

        public void tick() {
            if (this.entity.isInWater() && this.entity.getAnimation() == IAnimatedEntity.NO_ANIMATION) {
                this.stillTicks = Math.abs(this.entity.xo - this.entity.getX()) < (double)0.01f && Math.abs(this.entity.yo - this.entity.getY()) < (double)0.01f && Math.abs(this.entity.zo - this.entity.getZ()) < (double)0.01f ? ++this.stillTicks : 0;
                if (this.stillTicks > 40) {
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, -0.005, 0.0));
                }
            }
            if (this.entity.shouldStopMoving()) {
                this.entity.setSpeed(0.0f);
                return;
            }
            if (this.operation == MoveControl.Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
                double lvt_5_1_;
                double lvt_3_1_;
                double lvt_1_1_ = this.wantedX - this.entity.getX();
                double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + (lvt_3_1_ = this.wantedY - this.entity.getY()) * lvt_3_1_ + (lvt_5_1_ = this.wantedZ - this.entity.getZ()) * lvt_5_1_;
                if (lvt_7_1_ < 2.500000277905201E-7) {
                    this.mob.setZza(0.0f);
                } else {
                    float lvt_9_1_ = (float)(Mth.atan2((double)lvt_5_1_, (double)lvt_1_1_) * 57.2957763671875) - 90.0f;
                    this.entity.setYRot(this.rotlerp(this.entity.getYRot(), lvt_9_1_, this.yawLimit));
                    this.entity.yBodyRot = this.entity.getYRot();
                    this.entity.yHeadRot = this.entity.getYRot();
                    float lvt_10_1_ = (float)(this.speedModifier * (double)this.speedMulti * 3.0 * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    if (this.entity.isInWater()) {
                        if (lvt_3_1_ > 0.0 && this.entity.horizontalCollision) {
                            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, (double)0.08f, 0.0));
                        } else {
                            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0, (double)this.entity.getSpeed() * lvt_3_1_ * 0.6 * (double)this.ySpeedMod, 0.0));
                        }
                        this.entity.setSpeed(lvt_10_1_ * 0.02f);
                        float lvt_11_1_ = -((float)(Mth.atan2((double)lvt_3_1_, (double)Mth.sqrt((float)((float)(lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_)))) * 57.2957763671875));
                        lvt_11_1_ = Mth.clamp((float)Mth.wrapDegrees((float)lvt_11_1_), (float)-85.0f, (float)85.0f);
                        this.entity.setXRot(this.rotlerp(this.entity.getXRot(), lvt_11_1_, 5.0f));
                        float lvt_12_1_ = Mth.cos((float)(this.entity.getXRot() * ((float)Math.PI / 180)));
                        float lvt_13_1_ = Mth.sin((float)(this.entity.getXRot() * ((float)Math.PI / 180)));
                        this.entity.zza = lvt_12_1_ * lvt_10_1_;
                        this.entity.yya = -lvt_13_1_ * lvt_10_1_;
                    } else {
                        this.entity.setSpeed(lvt_10_1_ * 0.1f);
                    }
                }
            } else {
                this.entity.setSpeed(0.0f);
                this.entity.setXxa(0.0f);
                this.entity.setYya(0.0f);
                this.entity.setZza(0.0f);
            }
        }
    }

    public static class BiteHitResult {
        private final List<LivingEntity> entities = new ArrayList<LivingEntity>();

        public void addEntityHit(LivingEntity entity) {
            this.entities.add(entity);
        }
    }
}

