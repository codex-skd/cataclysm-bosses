/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.advancements.CriteriaTriggers
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.Container
 *  net.minecraft.world.ContainerListener
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.SimpleContainer
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.HasCustomInventoryScreen
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
 *  net.neoforged.bus.api.Event
 *  net.neoforged.neoforge.common.NeoForge
 *  net.neoforged.neoforge.event.EventHooks
 *  net.neoforged.neoforge.event.entity.player.PlayerContainerEvent$Open
 */
package com.skd.thesundering.entity.Pet;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.Pet.AI.InternalPetStateGoal;
import com.skd.thesundering.entity.Pet.AI.TameableAIFollowOwner;
import com.skd.thesundering.entity.Pet.InternalAnimationPet;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.init.ModItems;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.inventory.MinistrostiyMenu;
import com.skd.thesundering.message.MessageOpenInventory;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
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
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
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
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;

public class Netherite_Ministrosity_Entity
extends InternalAnimationPet
implements Bucketable,
ContainerListener,
HasCustomInventoryScreen {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Netherite_Ministrosity_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Netherite_Ministrosity_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public SimpleContainer miniInventory;
    public float LayerBrightness;
    public float oLayerBrightness;
    public int LayerTicks;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState operationAnimationState = new AnimationState();
    public AnimationState chestopenAnimationState = new AnimationState();
    public AnimationState chestloopAnimationState = new AnimationState();
    public AnimationState chestcloseAnimationState = new AnimationState();
    public AnimationState sitstartAnimationState = new AnimationState();
    public AnimationState sitendAnimationState = new AnimationState();

    public Netherite_Ministrosity_Entity(EntityType type, Level world) {
        super(type, world);
        this.createInventory();
        this.xpReward = 0;
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.NetheriteMinistrosity.healthMultiplier, CMCommonConfig.NetheriteMinistrosity.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, (Goal)new SitWhenOrderedToGoal((TamableAnimal)this));
        this.goalSelector.addGoal(6, (Goal)new TameableAIFollowOwner(this, 1.3, 6.0f, 2.0f, true));
        this.goalSelector.addGoal(6, (Goal)new TemptGoal((PathfinderMob)this, 1.0, (Predicate)Ingredient.of((ItemLike[])new ItemLike[]{Items.SNIFFER_EGG}), false));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(8, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.goalSelector.addGoal(7, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 60));
        this.goalSelector.addGoal(0, (Goal)new MinistrosityDoNothingGoal());
        this.goalSelector.addGoal(0, (Goal)new InternalPetStateGoal(this, 2, 2, 0, 40, 0){

            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Ministrosity_Entity.this.getIsAwaken();
            }
        });
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.MINISTROSITY_HURT.get();
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public boolean isOpen() {
        return this.getAttackState() == 3 || this.getAttackState() == 4;
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, (Object)isAwaken);
    }

    public boolean getIsAwaken() {
        return (Boolean)this.entityData.get(IS_AWAKEN);
    }

    protected int getInventorySize() {
        return 17;
    }

    protected void createInventory() {
        SimpleContainer simplecontainer = this.miniInventory;
        this.miniInventory = new SimpleContainer(this.getInventorySize());
        if (simplecontainer != null) {
            simplecontainer.removeListener((ContainerListener)this);
            int i = Math.min(simplecontainer.getContainerSize(), this.miniInventory.getContainerSize());
            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (itemstack.isEmpty()) continue;
                this.miniInventory.setItem(j, itemstack.copy());
            }
        }
        this.miniInventory.addListener((ContainerListener)this);
    }

    public void openCustomInventoryScreen(Player playerEntity) {
        if (playerEntity instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer)playerEntity;
            if (this.isAlive()) {
                if (serverplayer.containerMenu != serverplayer.inventoryMenu) {
                    serverplayer.closeContainer();
                }
                this.setAttackState(3);
                serverplayer.nextContainerCounter();
                serverplayer.connection.send((CustomPacketPayload)new MessageOpenInventory(serverplayer.containerCounter, this.miniInventory.getContainerSize(), this.getId()));
                serverplayer.containerMenu = new MinistrostiyMenu(serverplayer.containerCounter, serverplayer.getInventory(), (Container)this.miniInventory, this);
                serverplayer.initMenu(serverplayer.containerMenu);
                NeoForge.EVENT_BUS.post((Event)new PlayerContainerEvent.Open((Player)serverplayer, serverplayer.containerMenu));
            }
        }
    }

    public int getInventoryColumns() {
        return 5;
    }

    public void containerChanged(Container p_30548_) {
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "operation") {
            return this.operationAnimationState;
        }
        if (input == "chest_open") {
            return this.chestopenAnimationState;
        }
        if (input == "chest_loop") {
            return this.chestloopAnimationState;
        }
        if (input == "chest_close") {
            return this.chestcloseAnimationState;
        }
        if (input == "sit_start") {
            return this.sitstartAnimationState;
        }
        if (input == "sit_end") {
            return this.sitendAnimationState;
        }
        return new AnimationState();
    }

    public static AttributeSupplier.Builder ministrosity() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 120.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.5).add(Attributes.ARMOR, 5.0).add(Attributes.FOLLOW_RANGE, 32.0).add(Attributes.MOVEMENT_SPEED, (double)0.4f);
    }

    protected int decreaseAirSupply(int air) {
        return air;
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

    protected void dropEquipment() {
        super.dropEquipment();
        if (this.miniInventory != null) {
            for (int i = 0; i < this.miniInventory.getContainerSize(); ++i) {
                ItemStack itemstack = this.miniInventory.getItem(i);
                if (itemstack.isEmpty()) continue;
                this.spawnAtLocation(itemstack, 0.0f);
            }
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(FROM_BUCKET, (Object)false);
        p_326229_.define(IS_AWAKEN, (Object)false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.fromBucket());
        compound.putBoolean("is_Awaken", this.getIsAwaken());
        ListTag listtag = new ListTag();
        for (int i = 1; i < this.miniInventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.miniInventory.getItem(i);
            if (itemstack.isEmpty()) continue;
            CompoundTag compoundtag = new CompoundTag();
            compoundtag.putByte("Slot", (byte)(i - 1));
            listtag.add((Object)itemstack.save((HolderLookup.Provider)this.registryAccess(), (Tag)compoundtag));
        }
        compound.put("Items", (Tag)listtag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
        this.setIsAwaken(compound.getBoolean("is_Awaken"));
        this.createInventory();
        ListTag listtag = compound.getList("Items", 10);
        for (int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 0xFF;
            if (j >= this.miniInventory.getContainerSize() - 1) continue;
            this.miniInventory.setItem(j + 1, ItemStack.parse((HolderLookup.Provider)this.registryAccess(), (Tag)compoundtag).orElse(ItemStack.EMPTY));
        }
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
                    this.operationAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.chestopenAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.chestloopAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.chestcloseAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        if (COMMAND.equals(p_21104_)) {
            switch (this.getCommand()) {
                case 0: {
                    this.sitAnimationStates();
                    this.sitendAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 1: {
                    this.sitAnimationStates();
                    break;
                }
                case 2: {
                    this.sitAnimationStates();
                    this.sitstartAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.operationAnimationState.stop();
        this.chestopenAnimationState.stop();
        this.chestloopAnimationState.stop();
        this.chestcloseAnimationState.stop();
    }

    public void sitAnimationStates() {
        this.sitstartAnimationState.stop();
        this.sitendAnimationState.stop();
    }

    public boolean fromBucket() {
        return (Boolean)this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean sit) {
        this.entityData.set(FROM_BUCKET, (Object)sit);
    }

    public void saveToBucketTag(@Nonnull ItemStack bucket) {
        CustomData.update((DataComponentType)DataComponents.BUCKET_ENTITY_DATA, (ItemStack)bucket, this::addAdditionalSaveData);
        Bucketable.saveDefaultDataToBucketTag((Mob)this, (ItemStack)bucket);
    }

    public void loadFromBucketTag(CompoundTag p_148832_) {
        this.readAdditionalSaveData(p_148832_);
        Bucketable.loadDefaultDataFromBucketTag((Mob)this, (CompoundTag)p_148832_);
    }

    @Nonnull
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack((ItemLike)ModItems.NETHERITE_MINISTROSITY_BUCKET.get());
        return stack;
    }

    public SoundEvent getPickupSound() {
        return (SoundEvent)ModSounds.MINISTROSITY_FILL_BUCKET.get();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean owner = this.isTame() && this.isOwnedBy((LivingEntity)player);
        InteractionResult type = super.mobInteract(player, hand);
        if (owner) {
            Optional<InteractionResult> result = Netherite_Ministrosity_Entity.emptybucketMobPickup(player, hand, this);
            if (result.isPresent()) {
                return result.get();
            }
            if (!player.isShiftKeyDown()) {
                this.openCustomInventoryScreen(player);
                this.setCommand(2);
                this.setOrderedToSit(true);
                return InteractionResult.sidedSuccess((boolean)this.level().isClientSide());
            }
        }
        if (!this.isTame() && stack.is((Item)ModItems.LAVA_POWER_CELL.get())) {
            this.usePlayerItem(player, hand, stack);
            this.gameEvent((Holder)GameEvent.EAT);
            if (!EventHooks.onAnimalTame((Animal)this, (Player)player)) {
                this.tame(player);
                this.setIsAwaken(true);
                this.setAttackState(2);
                this.level().broadcastEntityEvent((Entity)this, (byte)7);
            } else {
                this.level().broadcastEntityEvent((Entity)this, (byte)6);
            }
            return InteractionResult.SUCCESS;
        }
        if (this.isTame() && stack.is(Items.COAL) && this.getHealth() < this.getMaxHealth()) {
            this.heal(5.0f);
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
            this.gameEvent((Holder)GameEvent.EAT, (Entity)this);
            return InteractionResult.SUCCESS;
        }
        InteractionResult interactionresult = stack.interactLivingEntity(player, (LivingEntity)this, hand);
        if (interactionresult != InteractionResult.SUCCESS && type != InteractionResult.SUCCESS && this.isTame() && this.isOwnedBy((LivingEntity)player) && player.isShiftKeyDown()) {
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
        if ((this.isSitting() || this.isOpen()) && this.getNavigation().isDone()) {
            this.getNavigation().stop();
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, this.tickCount);
        }
        if (this.getAttackState() == 3) {
            if (this.attackTicks == 1) {
                this.playSound(SoundEvents.SHULKER_AMBIENT, 1.0f, 2.0f);
            }
            if (this.attackTicks >= 9) {
                this.setAttackState(4);
            }
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 1) {
                this.playSound(SoundEvents.SHULKER_AMBIENT, 1.0f, 2.0f);
            }
            if (this.attackTicks >= 10) {
                this.setAttackState(0);
            }
        }
        if (this.level().isClientSide()) {
            ++this.LayerTicks;
            this.LayerBrightness += (0.0f - this.LayerBrightness) * 0.8f;
        }
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

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    public boolean hasInventoryChanged(Container p_149512_) {
        return this.miniInventory != p_149512_;
    }

    class MinistrosityDoNothingGoal
    extends Goal {
        public MinistrosityDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return !Netherite_Ministrosity_Entity.this.getIsAwaken();
        }

        public void tick() {
            Netherite_Ministrosity_Entity.this.setDeltaMovement(0.0, Netherite_Ministrosity_Entity.this.getDeltaMovement().y, 0.0);
        }

        public boolean isInterruptable() {
            return false;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}

