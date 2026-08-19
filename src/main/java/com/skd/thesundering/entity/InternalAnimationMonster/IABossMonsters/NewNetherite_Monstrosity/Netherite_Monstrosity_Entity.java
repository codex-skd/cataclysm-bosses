/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.BossEvent$BossBarColor
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
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.AbstractGolem
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.npc.AbstractVillager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.entity.PartEntity
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;

import com.skd.thesundering.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.thesundering.client.particle.Options.RingParticleOptions;
import com.skd.thesundering.client.particle.Options.RoarParticleOptions;
import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.AI.HurtByNearestTargetGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.skd.thesundering.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.skd.thesundering.entity.effect.Cm_Falling_Block_Entity;
import com.skd.thesundering.entity.effect.ScreenShake_Entity;
import com.skd.thesundering.entity.etc.CMBossInfoServer;
import com.skd.thesundering.entity.etc.FowardMoveController;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.entity.etc.path.CMPathNavigateGround;
import com.skd.thesundering.entity.partentity.Cm_Part_Entity;
import com.skd.thesundering.entity.projectile.Flame_Jet_Entity;
import com.skd.thesundering.entity.projectile.Flare_Bomb_Entity;
import com.skd.thesundering.entity.projectile.Lava_Bomb_Entity;
import com.skd.thesundering.init.ModBlocks;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModItems;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.util.CMMathUtil;
import com.skd.thesundering.util.EntityUtil;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.entity.PartEntity;
import net.neoforged.neoforge.event.EventHooks;

public class Netherite_Monstrosity_Entity
extends IABoss_monster {
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.RED, false, 0);
    public int frame;
    public float LayerBrightness;
    public float oLayerBrightness;
    public int LayerTicks;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState smashsAnimationState = new AnimationState();
    public AnimationState phaseAnimationState = new AnimationState();
    public AnimationState fireAnimationState = new AnimationState();
    public AnimationState drainAnimationState = new AnimationState();
    public AnimationState shouldercheckAnimationState = new AnimationState();
    public AnimationState overpowerAnimationState = new AnimationState();
    public AnimationState flareshotAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public final Netherite_Monstrosity_Part headPart;
    public final Netherite_Monstrosity_Part[] monstrosityParts;
    private static final EntityDataAccessor<Boolean> IS_BERSERK = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> MAGAZINE = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private int blockBreakCounter;
    private int shoot_cooldown = 0;
    public static final int SHOOT_COOLDOWN = 240;
    private boolean onLava = false;
    private int check_cooldown = 0;
    public static final int CHECK_COOLDOWN = 80;
    private int overpower_cooldown = 0;
    public static final int OVERPOWER_COOLDOWN = 160;
    private int flare_shoot_cooldown = 0;
    public static final int FLARE_SHOOT_COOLDOWN = 120;

    public Netherite_Monstrosity_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.moveControl = new FowardMoveController((Mob)this);
        this.headPart = new Netherite_Monstrosity_Part(this, 1.6f, 2.5f);
        this.monstrosityParts = new Netherite_Monstrosity_Part[]{this.headPart};
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.NetheriteMonstrosity.healthMultiplier, CMCommonConfig.NetheriteMonstrosity.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, AbstractVillager.class, true));
        this.goalSelector.addGoal(5, (Goal)new InternalMoveGoal(this, this, false, 1.0){

            @Override
            public boolean canUse() {
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 3, 0, 58, 12, 6.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Monstrosity_Entity.this.getRandom().nextFloat() * 100.0f < 32.0f;
            }
        });
        this.goalSelector.addGoal(0, (Goal)new NMDoNothingGoal());
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 2, 2, 0, 40, 0){

            @Override
            public void start() {
                super.start();
                Netherite_Monstrosity_Entity.this.setHomePos(GlobalPos.of((ResourceKey)Netherite_Monstrosity_Entity.this.level().dimension(), (BlockPos)Netherite_Monstrosity_Entity.this.blockPosition()));
                Netherite_Monstrosity_Entity.this.setIsAwaken(true);
            }

            @Override
            public void tick() {
                this.entity.setDeltaMovement(0.0, this.entity.getDeltaMovement().y, 0.0);
            }
        });
        this.goalSelector.addGoal(0, (Goal)new MonstrosityPhaseChangeGoal(this, 0, 4, 0, 54));
        this.goalSelector.addGoal(3, (Goal)new Magmashoot(this, 0, 6, 0, 44, 20, 40.0f, 19, 16.0f));
        this.goalSelector.addGoal(3, (Goal)new Flareshoot(this, 0, 10, 0, 60, 35, 26.0f, 35, 18.0f));
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 7, 0, 60, 25, 1.0f){

            @Override
            public boolean canUse() {
                LivingEntity target = this.entity.getTarget();
                return target != null && target.isAlive() && this.entity.getAttackState() == 0 && this.entity.isInLava() && Netherite_Monstrosity_Entity.this.getMagazine() >= CMCommonConfig.NetheriteMonstrosity.Lavabombmagazine;
            }
        });
        this.goalSelector.addGoal(3, (Goal)new ShoulderCheck(this, 0, 8, 0, 70, 19, 16.0f, 19, 49, 12.0f));
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 9, 0, 75, 7, 10.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Monstrosity_Entity.this.getRandom().nextFloat() * 100.0f < 40.0f && Netherite_Monstrosity_Entity.this.overpower_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Netherite_Monstrosity_Entity.this.overpower_cooldown = 160;
            }
        });
    }

    public static AttributeSupplier.Builder netherite_monstrosity() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 50.0).add(Attributes.MOVEMENT_SPEED, 0.25).add(Attributes.ATTACK_DAMAGE, 25.0).add(Attributes.MAX_HEALTH, 600.0).add(Attributes.ARMOR, 12.0).add(Attributes.ARMOR_TOUGHNESS, 5.0).add(Attributes.STEP_HEIGHT, 4.5).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public boolean attackEntityFromPart(Netherite_Monstrosity_Part netherite_monstrosity_part, DamageSource source, float amount) {
        return this.hurt(source, amount);
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        boolean attack;
        if (this.getAttackState() == 4 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractGolem) {
            damage *= 0.5f;
        }
        if ((attack = super.hurt(source, damage)) && !this.getIsAwaken() && this.isAlive()) {
            this.setIsAwaken(true);
        }
        return attack;
    }

    public boolean hurtParts(Netherite_Monstrosity_Part part, DamageSource source, float damage) {
        if (part == this.headPart) {
            damage = Math.min(Float.MAX_VALUE, damage * 1.5f);
        }
        boolean attack = super.hurt(source, damage);
        return attack;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    public float DamageCap() {
        return (float)CMCommonConfig.NetheriteMonstrosity.damageCap;
    }

    @Override
    public float NatureRegen() {
        return (float)CMCommonConfig.NetheriteMonstrosity.natureHeal;
    }

    @Override
    public float DpsCap() {
        return (float)CMCommonConfig.NetheriteMonstrosity.dpsCap;
    }

    @Override
    public double RangeLimit() {
        return CMCommonConfig.NetheriteMonstrosity.rangeCap;
    }

    public boolean canBeCollidedWith() {
        return this.isAlive() && CMCommonConfig.NetheriteMonstrosity.BodyCollided && this.getAttackState() != 8;
    }

    public boolean isPushable() {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "sleep") {
            return this.sleepAnimationState;
        }
        if (input == "awake") {
            return this.awakeAnimationState;
        }
        if (input == "smash") {
            return this.smashsAnimationState;
        }
        if (input == "phase_two") {
            return this.phaseAnimationState;
        }
        if (input == "fire") {
            return this.fireAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        if (input == "drain") {
            return this.drainAnimationState;
        }
        if (input == "shoulder_check") {
            return this.shouldercheckAnimationState;
        }
        if (input == "overpower") {
            return this.overpowerAnimationState;
        }
        if (input == "flare_shot") {
            return this.flareshotAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_BERSERK, (Object)false);
        p_326229_.define(IS_AWAKEN, (Object)false);
        p_326229_.define(MAGAZINE, (Object)0);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public boolean canStandOnFluid(FluidState p_230285_1_) {
        return p_230285_1_.is(FluidTags.LAVA);
    }

    public void setIsBerserk(boolean isBerserk) {
        this.entityData.set(IS_BERSERK, (Object)isBerserk);
    }

    public boolean getIsBerserk() {
        return (Boolean)this.entityData.get(IS_BERSERK);
    }

    public void setOnLava(boolean lava) {
        this.onLava = lava;
    }

    public boolean getOnLava() {
        return this.onLava;
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, (Object)isAwaken);
        this.bossInfo.setVisible(isAwaken);
        if (isAwaken) {
            this.PlayerCounter(this.level());
        }
    }

    public boolean getIsAwaken() {
        return (Boolean)this.entityData.get(IS_AWAKEN);
    }

    public void setMagazine(int isAwaken) {
        this.entityData.set(MAGAZINE, (Object)isAwaken);
    }

    public int getMagazine() {
        return (Integer)this.entityData.get(MAGAZINE);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
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
                    this.smashsAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.phaseAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.fireAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.drainAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 8: {
                    this.stopAllAnimationStates();
                    this.shouldercheckAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 9: {
                    this.stopAllAnimationStates();
                    this.overpowerAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 10: {
                    this.stopAllAnimationStates();
                    this.flareshotAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.smashsAnimationState.stop();
        this.phaseAnimationState.stop();
        this.deathAnimationState.stop();
        this.fireAnimationState.stop();
        this.drainAnimationState.stop();
        this.overpowerAnimationState.stop();
        this.shouldercheckAnimationState.stop();
        this.flareshotAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(5);
    }

    @Override
    public int deathtimer() {
        return 60;
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        ServerLevel serverLevel;
        MinecraftServer server;
        ServerLevel targetLevel;
        Level level;
        if (CMCommonConfig.NetheriteMonstrosity.respawner && !this.level().isClientSide() && this.getHomePos() != null && (level = this.level()) instanceof ServerLevel && (targetLevel = (server = (serverLevel = (ServerLevel)level).getServer()).getLevel(this.getHomePos().dimension())) != null) {
            BlockPos targetPos = this.getHomePos().pos();
            BlockState blockState = ((Block)ModBlocks.BOSS_RESPAWNER.get()).defaultBlockState();
            targetLevel.setBlock(targetPos, blockState, 2);
            BlockEntity blockEntity = targetLevel.getBlockEntity(targetPos);
            if (blockEntity instanceof Boss_Respawn_Spawner_Block_Entity) {
                Boss_Respawn_Spawner_Block_Entity spawnerBlockEntity = (Boss_Respawn_Spawner_Block_Entity)blockEntity;
                spawnerBlockEntity.setEntityId((EntityType)ModEntities.NETHERITE_MONSTROSITY.get());
                spawnerBlockEntity.setTheItem(((Item)ModItems.MONSTROUS_EYE.get()).getDefaultInstance());
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Berserk", this.getIsBerserk());
        compound.putBoolean("is_Awaken", this.getIsAwaken());
        compound.putInt("Magazine", this.getMagazine());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setIsBerserk(compound.getBoolean("is_Berserk"));
        this.setIsAwaken(compound.getBoolean("is_Awaken"));
        this.setMagazine(compound.getInt("Magazine"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    private void floatStrider() {
        CollisionContext lvt_1_1_;
        if (this.isInLava() && (lvt_1_1_ = CollisionContext.of((Entity)this)).isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition().below(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.LAVA)) {
            this.setOnGround(true);
        }
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_MONSTROSITY)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        this.floatStrider();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0 && this.getIsAwaken(), this.tickCount);
        } else {
            this.bossInfo.setLife(this.getLife());
        }
        ++this.frame;
        float moveX = (float)(this.getX() - this.xo);
        float moveZ = (float)(this.getZ() - this.zo);
        float speed = Mth.sqrt((float)(moveX * moveX + moveZ * moveZ));
        if (!this.isSilent() && this.frame % 25 == 1 && (double)speed > 0.05 && this.getIsAwaken() && this.getAttackState() != 8) {
            this.playSound((SoundEvent)ModSounds.MONSTROSITYSTEP.get(), 1.0f, 1.0f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.08f, 0, 5);
        }
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        if (this.getAttackState() == 0) {
            this.BlockBreaking();
        }
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
        }
        if (this.shoot_cooldown > 0) {
            --this.shoot_cooldown;
        }
        if (this.overpower_cooldown > 0) {
            --this.overpower_cooldown;
        }
        if (this.check_cooldown > 0) {
            --this.check_cooldown;
        }
        if (this.flare_shoot_cooldown > 0) {
            --this.flare_shoot_cooldown;
        }
        this.setHeadPart();
        if (this.level().isClientSide()) {
            ++this.LayerTicks;
            this.LayerBrightness += (0.0f - this.LayerBrightness) * 0.8f;
        }
    }

    private void setHeadPart() {
        if (!this.isNoAi()) {
            float f17 = this.yBodyRot * ((float)Math.PI / 180);
            float pitch = this.getXRot() * ((float)Math.PI / 180);
            float f3 = Mth.sin((float)f17) * (1.0f - Math.abs(this.getXRot() / 90.0f));
            float f18 = Mth.cos((float)f17) * (1.0f - Math.abs(this.getXRot() / 90.0f));
            Vec3[] avector3d = new Vec3[this.monstrosityParts.length];
            for (int j = 0; j < this.monstrosityParts.length; ++j) {
                avector3d[j] = new Vec3(this.monstrosityParts[j].getX(), this.monstrosityParts[j].getY(), this.monstrosityParts[j].getZ());
            }
            float headY = 0.0f;
            float headxz = 0.0f;
            if (this.getAttackState() == 3) {
                int end = 40;
                float f = 0.0f;
                f = this.attackTicks > end ? CMMathUtil.cullAnimationTick(this.attackTicks, 1.2f, 1.0f, 13, end) : CMMathUtil.cullAnimationTick(this.attackTicks, 2.0f, 1.0f, 13, end);
                headxz = -1.6f * f;
                headY = -2.2f * f;
            }
            if (this.getAttackState() == 6) {
                float f = CMMathUtil.cullAnimationTick(this.attackTicks, 0.5f, 1.0f, 0, 40);
                headxz = 4.0f * f;
                headY = 1.2f * f;
            }
            if (this.getAttackState() == 8) {
                float f = CMMathUtil.cullAnimationTick(this.attackTicks, 2.0f, 1.0f, 0, 30);
                headxz = -4.0f * f;
            }
            this.setPartPosition(this.headPart, f3 * -1.65f + f3 * headxz, pitch + 2.4f + headY, -f18 * -1.65f - f18 * headxz);
            for (int l = 0; l < this.monstrosityParts.length; ++l) {
                this.monstrosityParts[l].xo = avector3d[l].x;
                this.monstrosityParts[l].yo = avector3d[l].y;
                this.monstrosityParts[l].zo = avector3d[l].z;
                this.monstrosityParts[l].xOld = avector3d[l].x;
                this.monstrosityParts[l].yOld = avector3d[l].y;
                this.monstrosityParts[l].zOld = avector3d[l].z;
            }
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType spawnType, @Nullable SpawnGroupData p_29681_) {
        if (spawnType == MobSpawnType.COMMAND || spawnType == MobSpawnType.SPAWN_EGG || MobSpawnType.isSpawner((MobSpawnType)spawnType) || spawnType == MobSpawnType.DISPENSER) {
            this.setIsAwaken(true);
        }
        return super.finalizeSpawn(p_29678_, p_29679_, spawnType, p_29681_);
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 2 && this.attackTicks == 2) {
            this.playSound((SoundEvent)ModSounds.MONSTROSITYAWAKEN.get(), 10.0f, 1.0f);
        }
        if (this.getAttackState() == 3 && this.attackTicks == 19) {
            this.EarthQuake(6.25);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
            this.Makeparticle(4.75f, 2.5f);
            this.Makeparticle(4.75f, -2.5f);
        }
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 10) {
                this.playSound((SoundEvent)ModSounds.MONSTROSITYGROWL.get(), 3.0f, 1.0f);
            }
            if (this.attackTicks == 16) {
                this.Roarparticle(3.5f, 2.7f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 8.0f);
            }
            if (this.attackTicks == 17) {
                this.berserkBlockBreaking(8, 8, 8);
                this.EarthQuake(6.25);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.Makeparticle(4.4f, 2.0f);
                this.Makeparticle(4.4f, -2.0f);
            }
            if (this.attackTicks == 18) {
                this.Roarparticle(3.5f, 2.7f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 9.0f);
            }
            if (this.attackTicks == 20) {
                this.Roarparticle(3.5f, 2.7f, 10, 255, 255, 255, 0.4f, 1.0f, 0.8f, 9.0f);
            }
        }
        if (this.getAttackState() == 5 && this.attackTicks == 26) {
            this.playSound((SoundEvent)ModSounds.MONSTROSITYLAND.get(), 1.0f, 1.0f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
        }
        if (this.getAttackState() == 6 && this.attackTicks == 19) {
            this.playSound((SoundEvent)ModSounds.MONSTROSITYSHOOT.get(), 3.0f, 0.75f);
        }
        if (this.getAttackState() == 7) {
            if (this.attackTicks == 24) {
                this.setMagazine(0);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.doAbsorptionEffects(4, 1, 4);
                this.playSound(SoundEvents.BUCKET_FILL_LAVA, 6.0f, 0.5f);
                this.heal(15.0f * (float)CMCommonConfig.NetheriteMonstrosity.healthMultiplier);
            }
            if (this.attackTicks == 26) {
                this.doAbsorptionEffects(8, 2, 8);
                this.heal(15.0f * (float)CMCommonConfig.NetheriteMonstrosity.healthMultiplier);
            }
            if (this.attackTicks == 28) {
                this.doAbsorptionEffects(16, 4, 16);
                this.heal(15.0f * (float)CMCommonConfig.NetheriteMonstrosity.healthMultiplier);
            }
        }
        if (this.getAttackState() == 8) {
            if (this.attackTicks == 22 || this.attackTicks == 27 || this.attackTicks == 32 || this.attackTicks == 37 || this.attackTicks == 42 || this.attackTicks == 47) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.15f, 0, 6);
                this.playSound((SoundEvent)ModSounds.MONSTROSITYSTEP.get(), 1.0f, 1.0f);
            }
            if (this.attackTicks > 19 && this.attackTicks < 49 && !this.level().isClientSide()) {
                if (CMCommonConfig.NetheriteMonstrosity.ignoreMobGriefing) {
                    this.ChargeBlockBreaking();
                } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                    this.ChargeBlockBreaking();
                }
                double yaw = Math.toRadians(this.getYRot() + 90.0f);
                double xExpand = 2.0 * Math.cos(yaw);
                double zExpand = 2.0 * Math.sin(yaw);
                AABB attackRange = this.getBoundingBox().inflate(0.75, 0.75, 0.75).expandTowards(xExpand, 0.0, zExpand);
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)Lentity) || Lentity instanceof Netherite_Monstrosity_Entity || Lentity == this || !(flag = Lentity.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.4f))) continue;
                    double theta = (double)this.yBodyRot * (Math.PI / 180);
                    double vec = -2.5;
                    double vecX = Math.cos(theta += 1.5707963267948966);
                    double vecZ = Math.sin(theta);
                    double d0 = Lentity.getX() - (this.getX() + vec * vecX);
                    double d1 = Lentity.getZ() - (this.getZ() + vec * vecZ);
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.05);
                    double vel = 4.0;
                    Lentity.push(d0 / d2 * vel, 0.3, d1 / d2 * vel);
                    Lentity.addEffect(new MobEffectInstance(ModEffect.EFFECTBONE_FRACTURE, 100));
                }
            }
        }
        if (this.getAttackState() == 9) {
            if (this.attackTicks == 9) {
                this.OverPowerKnockBack(7.0);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.Makeparticle(-0.3f, 3.4f);
                this.Makeparticle(-0.3f, -3.4f);
                if (!this.level().isClientSide()) {
                    this.CircleFlameJet(-0.3f, 3.4f, this.getIsBerserk() ? 14 : 7, this.getIsBerserk() ? 8 : 4, 3.0);
                    this.CircleFlameJet(-0.3f, -3.4f, this.getIsBerserk() ? 14 : 7, this.getIsBerserk() ? 8 : 4, 3.0);
                }
                this.playSound((SoundEvent)ModSounds.REMNANT_STOMP.get(), 1.0f, 0.7f);
            }
            if (this.attackTicks == 26) {
                this.playSound((SoundEvent)ModSounds.MONSTROSITYGROWL.get(), 3.0f, 1.0f);
            }
            if (this.attackTicks == 32) {
                this.Roarparticle(2.0f, 4.5f, 10, 255, 255, 255, 0.4f, 1.0f, 0.6f, 4.5f);
            }
            if (this.attackTicks == 34) {
                this.Roarparticle(2.0f, 4.5f, 10, 255, 255, 255, 0.4f, 1.0f, 0.6f, 5.0f);
            }
            if (this.attackTicks == 36) {
                this.Roarparticle(2.0f, 4.5f, 10, 255, 255, 255, 0.4f, 1.0f, 0.6f, 5.5f);
            }
            if (this.attackTicks == 31) {
                this.StompDamage(0.6f, 4, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.StompDamage(0.6f, 5, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.Stompsound(4.5f, 0.0f);
            }
            if (this.attackTicks == 33) {
                this.StompDamage(0.6f, 6, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.StompDamage(0.6f, 7, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.Stompsound(6.5f, 0.0f);
            }
            if (this.attackTicks == 35) {
                this.StompDamage(0.6f, 8, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.StompDamage(0.6f, 9, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.Stompsound(8.5f, 0.0f);
            }
            if (this.attackTicks == 37) {
                this.StompDamage(0.6f, 10, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.StompDamage(0.6f, 11, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.Stompsound(10.5f, 0.0f);
            }
            if (this.attackTicks == 39) {
                this.StompDamage(0.6f, 12, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.StompDamage(0.6f, 13, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.Stompsound(12.5f, 0.0f);
            }
            if (this.attackTicks == 41) {
                this.StompDamage(0.6f, 14, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.StompDamage(0.6f, 15, 5, 1.05f, -2.0f, 0.0f, 0, 0.7f);
                this.Stompsound(14.5f, 0.0f);
            }
        }
        if (this.getAttackState() == 10 && this.attackTicks == 35) {
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.08f, 0, 10);
            this.playSound((SoundEvent)ModSounds.MONSTROSITYSHOOT.get(), 3.0f, 0.75f);
        }
    }

    private void CircleFlameJet(float vec, float math, int vertexrune, int rune, double time) {
        float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        for (int i = 0; i < vertexrune; ++i) {
            float throwAngle = (float)i * (float)Math.PI / (float)(vertexrune / 2);
            for (int k = 0; k < rune; ++k) {
                double d2 = 1.1 * (double)(k + 1);
                int d3 = (int)(time * (double)(k + 1));
                this.spawnJet(this.getX() + (double)vec * vecX + (double)(f * math) + (double)Mth.cos((float)throwAngle) * 1.25 * d2, this.getZ() + (double)vec * vecZ + (double)(f1 * math) + (double)Mth.sin((float)throwAngle) * 1.25 * d2, this.getY() - 2.0, this.getY() + 2.0, throwAngle, d3);
            }
        }
    }

    private void spawnJet(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (!blockstate.isFaceSturdy((BlockGetter)this.level(), blockpos1, Direction.UP)) continue;
            if (!this.level().isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = this.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)minY) - 1);
        if (flag) {
            this.level().addFreshEntity((Entity)new Flame_Jet_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, (float)CMCommonConfig.NetheriteMonstrosity.FlameJetDamage, (LivingEntity)this));
        }
    }

    private void Stompsound(float distance, float math) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
        this.level().playSound((Player)null, this.getX() + (double)distance * vecX + (double)(f * math), this.getY(), this.getZ() + (double)distance * vecZ + (double)(f1 * math), (SoundEvent)ModSounds.REMNANT_STOMP.get(), this.getSoundSource(), 0.6f, 1.0f);
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec, float math, int shieldbreakticks, float damage) {
        double bodyRotRad = (double)this.yBodyRot * (Math.PI / 180);
        double cosBodyRot = Math.cos(bodyRotRad);
        double sinBodyRot = Math.sin(bodyRotRad);
        double facingAngle = bodyRotRad + 1.5707963267948966;
        int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
        double spread = Math.PI * (double)spreadarc;
        int arcLen = Mth.ceil((double)((double)distance * spread));
        double commonOffsetX = (double)vec * -sinBodyRot + cosBodyRot * (double)math;
        double commonOffsetZ = (double)vec * cosBodyRot + sinBodyRot * (double)math;
        double baseX = this.getX() + commonOffsetX;
        double baseZ = this.getZ() + commonOffsetZ;
        float factor = 1.0f - (float)distance / 12.0f;
        for (int i = 0; i < arcLen; ++i) {
            double thetaRatio = arcLen > 1 ? (double)i / (double)(arcLen - 1) : 0.5;
            double theta = (thetaRatio - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = baseX + vx * (double)distance;
            double pz = baseZ + vz * (double)distance;
            int hitX = Mth.floor((double)px);
            int hitZ = Mth.floor((double)pz);
            BlockPos pos = new BlockPos(hitX, hitY + height, hitZ);
            BlockState block = this.level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth && block.getRenderShape() != RenderShape.MODEL; ++depthCount) {
                pos = pos.below();
                block = this.level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            this.spawnBlocks(hitX, hitY + height, hitZ, (int)(this.getY() - (double)height), block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage);
        }
    }

    private boolean notLavaCliff(double distance) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        double px = this.getX() + vecX * distance;
        double pz = this.getZ() + vecZ * distance;
        double checkHeight = -2.5;
        Vec3 forwardPosition = new Vec3(px, this.getY() + checkHeight, pz);
        BlockState blockStateBelow = this.level().getBlockState(BlockPos.containing((Position)forwardPosition));
        return !blockStateBelow.isAir();
    }

    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck, BlockState blockState, double px, double pz, float mxy, double vx, double vz, float factor, int shieldbreakticks, float damage) {
        DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
        BlockPos blockpos = new BlockPos(hitX, hitY, hitZ);
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (!blockstate.isFaceSturdy((BlockGetter)this.level(), blockpos1, Direction.UP)) continue;
            if (this.level().isEmptyBlock(blockpos) || (voxelshape = (blockstate1 = this.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty()) break;
            d0 = voxelshape.max(Direction.Axis.Y);
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((float)lowestYCheck) - 1);
        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)hitX + 0.5, (double)blockpos.getY() + d0 + 0.5, (double)hitZ + 0.5, blockState, 10);
        fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.04, 0.0);
        this.level().addFreshEntity((Entity)fallingBlockEntity);
        AABB selection = new AABB(px - 0.5, (double)blockpos.getY() + d0 - 1.0, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + (double)mxy, pz + 0.5);
        List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        if (!hit.isEmpty()) {
            for (LivingEntity entity : hit) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof Kobolediator_Entity || entity == this) continue;
                boolean flag = entity.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                    Player player = (Player)entity;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                double magnitude = 10.0;
                double x = vx * Math.max((double)factor, 0.2) * magnitude;
                double y = 0.0;
                if (entity.onGround()) {
                    y += 0.15;
                }
                double z = vz * Math.max((double)factor, 0.2) * magnitude;
                entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
            }
        }
    }

    private void doAbsorptionEffects(int x, int y, int z) {
        int MthX = Mth.floor((double)this.getX());
        int MthY = Mth.floor((double)this.getY());
        int MthZ = Mth.floor((double)this.getZ());
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    this.doAbsorptionEffect(blockpos);
                }
            }
        }
    }

    private void doAbsorptionEffect(BlockPos pos) {
        BlockState state = this.level().getBlockState(pos);
        if (!this.level().isClientSide() && state.is(Blocks.LAVA)) {
            this.level().setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }
    }

    private void EarthQuake(double area) {
        this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(area))) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof Netherite_Monstrosity_Entity || entity == this) continue;
                boolean flag = entity.hurt(damagesource, (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), (double)(entity.getMaxHealth() * (float)CMCommonConfig.NetheriteMonstrosity.SmashHpdamage))));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                    Player player = (Player)entity;
                    EntityUtil.disableShield(player, 120);
                }
                if (!flag) continue;
                this.launch((Entity)entity, 2.0, 0.6);
                if (!this.getIsBerserk()) continue;
                entity.igniteForSeconds(6.0f);
            }
        }
    }

    private void OverPowerKnockBack(double area) {
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(area))) {
            if (this.isAlliedTo((Entity)entity) || entity instanceof Netherite_Monstrosity_Entity || entity == this) continue;
            this.launch((Entity)entity, 3.0, 0.35);
        }
    }

    private void Makeparticle(float vec, float math) {
        if (this.level().isClientSide()) {
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + this.random.nextInt(12); ++i1) {
                double DeltaMovementX = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementZ = this.getRandom().nextGaussian() * 0.07;
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = 2.0f * Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = 2.0f * Mth.cos((float)angle);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (this.getIsBerserk()) {
                    this.level().addParticle((ParticleOptions)ParticleTypes.FLAME, this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    continue;
                }
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
            if (this.getIsBerserk()) {
                this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 35, 204, 78, 5, 1.0f, 30.0f, false, 0), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.2f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
            } else {
                this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 35, 255, 255, 255, 1.0f, 30.0f, false, 0), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.2f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
            }
        }
    }

    private void Roarparticle(float vec, float y, int duration, int r, int g, int b, float a, float start, float inc, float end) {
        if (this.level().isClientSide()) {
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            this.level().addParticle((ParticleOptions)new RoarParticleOptions(duration, r, g, b, a, start, inc, end), this.getX() + (double)vec * vecX, this.getY() + (double)y, this.getZ() + (double)vec * vecZ, 0.0, 0.0, 0.0);
        }
    }

    private void launch(Entity e, double XZpower, double Ypower) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
        e.push(d0 / d2 * XZpower, Ypower, d1 / d2 * XZpower);
    }

    private void ChargeBlockBreaking() {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5, 0.2, 0.5);
        for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
            if (this.random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)blockpos.getX() + 0.5, (double)blockpos.getY() + 0.5, (double)blockpos.getZ() + 0.5, blockstate, 20);
                flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, 0.2 + this.getRandom().nextGaussian() * 0.15, (-1.2 + this.random.nextDouble()) / 3.0)));
                this.level().addFreshEntity((Entity)fallingBlockEntity);
                continue;
            }
            flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
        }
    }

    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor((double)this.getX());
        int MthY = Mth.floor((double)this.getY());
        int MthZ = Mth.floor((double)this.getZ());
        if (!this.level().isClientSide() && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
            for (int k2 = -x; k2 <= x; ++k2) {
                for (int l2 = -z; l2 <= z; ++l2) {
                    for (int j = 0; j <= y; ++j) {
                        int i3 = MthX + k2;
                        int k = MthY + j;
                        int l = MthZ + l2;
                        BlockPos blockpos = new BlockPos(i3, k, l);
                        BlockState block = this.level().getBlockState(blockpos);
                        BlockEntity tileEntity = this.level().getBlockEntity(blockpos);
                        if (block.isAir() || block.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) continue;
                        if (tileEntity == null && this.random.nextInt(4) + 1 == 4) {
                            this.level().removeBlock(blockpos, true);
                            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)i3 + 0.5, (double)k + 0.5, (double)l + 0.5, block, 5);
                            this.level().setBlock(blockpos, block.getFluidState().createLegacyBlock(), 3);
                            fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, (-1.1 + this.random.nextDouble()) / 3.0, (-1.2 + this.random.nextDouble()) / 3.0)));
                            this.level().addFreshEntity((Entity)fallingBlockEntity);
                            continue;
                        }
                        this.level().destroyBlock(new BlockPos(i3, k, l), this.shouldDropItem(tileEntity));
                    }
                }
            }
        }
    }

    private void BlockBreaking() {
        if (!this.isNoAi() && !this.level().isClientSide() && this.blockBreakCounter == 0 && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
            AABB box = this.getBoundingBox();
            BlockPos min = new BlockPos(Mth.floor((double)box.minX), Mth.floor((double)box.minY), Mth.floor((double)box.minZ));
            BlockPos max = new BlockPos(Mth.floor((double)box.maxX), Mth.floor((double)box.maxY), Mth.floor((double)box.maxZ));
            for (BlockPos pos : BlockPos.betweenClosed((BlockPos)min, (BlockPos)max)) {
                BlockState blockState = this.level().getBlockState(pos);
                if (blockState.isAir() || blockState.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) continue;
                BlockEntity tileEntity = this.level().getBlockEntity(pos);
                if (!this.level().destroyBlock(pos, this.shouldDropItem(tileEntity))) continue;
                this.blockBreakCounter = 10;
            }
        }
    }

    private Vec3 rotateOffsetVec(Vec3 offset, float xRot, float yRot) {
        return offset.xRot(-xRot * ((float)Math.PI / 180)).yRot(-yRot * ((float)Math.PI / 180));
    }

    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return this.random.nextInt(3) + 1 == 3;
        }
        return true;
    }

    public boolean isBerserk() {
        return this.getHealth() <= this.getMaxHealth() * 0.4f;
    }

    protected boolean isAffectedByFluids() {
        return false;
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 3.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    private void setPartPosition(Netherite_Monstrosity_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * (double)part.scale, this.getY() + offsetY * (double)part.scale, this.getZ() + offsetZ * (double)part.scale);
    }

    public boolean isMultipartEntity() {
        return true;
    }

    @Nullable
    public PartEntity<?>[] getParts() {
        return this.monstrosityParts;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Cm_Part_Entity.assignPartIDs((Entity)this);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.MONSTROSITYHURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.MONSTROSITYDEATH.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return (SoundEvent)ModSounds.MONSTROSITY_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && this.getIsAwaken();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    class NMDoNothingGoal
    extends Goal {
        public NMDoNothingGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = Netherite_Monstrosity_Entity.this.getTarget();
            return !(Netherite_Monstrosity_Entity.this.getIsAwaken() || target != null && target.isAlive() && Netherite_Monstrosity_Entity.this.distanceToSqr((Entity)target) < 255.0 && Netherite_Monstrosity_Entity.this.getSensing().hasLineOfSight((Entity)target));
        }

        public void tick() {
            Netherite_Monstrosity_Entity.this.setDeltaMovement(0.0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0.0);
        }

        public void stop() {
            Netherite_Monstrosity_Entity.this.setIsAwaken(true);
            Netherite_Monstrosity_Entity.this.setAttackState(2);
        }

        public boolean isInterruptable() {
            return false;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MonstrosityPhaseChangeGoal
    extends Goal {
        protected final Netherite_Monstrosity_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public MonstrosityPhaseChangeGoal(Netherite_Monstrosity_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
        }

        public boolean canUse() {
            return !this.entity.getIsBerserk() && this.entity.getAttackState() == this.getattackstate && this.entity.isBerserk();
        }

        public void start() {
            this.entity.setIsBerserk(true);
            if (this.getattackstate != this.attackstate) {
                this.entity.setAttackState(this.attackstate);
            }
        }

        public void stop() {
            this.entity.setAttackState(this.attackendstate);
        }

        public boolean canContinueToUse() {
            return this.attackMaxtick > 0 ? this.entity.attackTicks <= this.attackMaxtick : this.canUse();
        }
    }

    static class Magmashoot
    extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final float random;

        public Magmashoot(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo((Entity)target) >= 14.0f && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.getSensing().hasLineOfSight((Entity)target) && this.entity.getMagazine() < CMCommonConfig.NetheriteMonstrosity.Lavabombmagazine && this.entity.shoot_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.shoot_cooldown = 240;
            this.entity.setMagazine(this.entity.getMagazine() + 1);
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            super.tick();
            int lavabombcount = CMCommonConfig.NetheriteMonstrosity.Lavabombamount;
            if (target != null && this.entity.attackTicks == this.attackshot) {
                for (int i = 0; i < lavabombcount; ++i) {
                    Lava_Bomb_Entity lava = new Lava_Bomb_Entity((EntityType<Lava_Bomb_Entity>)((EntityType)ModEntities.LAVA_BOMB.get()), this.entity.level(), (LivingEntity)this.entity);
                    double d0 = target.getX() - this.entity.headPart.getX();
                    double d1 = target.getBoundingBox().minY + (double)(target.getBbHeight() / 3.0f) - lava.getY();
                    double d2 = target.getZ() - this.entity.headPart.getZ();
                    double d3 = Mth.sqrt((float)((float)(d0 * d0 + d2 * d2)));
                    lava.setMaxLavaTime(CMCommonConfig.NetheriteMonstrosity.LavabombDuration + this.entity.getRandom().nextInt(CMCommonConfig.NetheriteMonstrosity.LavabombRandomDuration));
                    lava.shoot(d0, d1 + d3 * (double)0.2f, d2, 1.0f, 24 - this.entity.level().getDifficulty().getId() * 4);
                    this.entity.level().addFreshEntity((Entity)lava);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Flareshoot
    extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final float random;

        public Flareshoot(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo((Entity)target) >= 10.0f && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.getSensing().hasLineOfSight((Entity)target) && this.entity.flare_shoot_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.flare_shoot_cooldown = 120;
        }

        @Override
        public void tick() {
            LivingEntity target = this.entity.getTarget();
            super.tick();
            int lavabombcount = 5;
            if (target != null && this.entity.attackTicks == this.attackshot) {
                for (int i = 0; i < lavabombcount; ++i) {
                    float f = Mth.cos((float)(this.entity.yBodyRot * ((float)Math.PI / 180)));
                    float f1 = Mth.sin((float)(this.entity.yBodyRot * ((float)Math.PI / 180)));
                    double theta = (double)this.entity.yBodyRot * (Math.PI / 180);
                    double vecX = Math.cos(theta += 1.5707963267948966);
                    double vecZ = Math.sin(theta);
                    double vec = 2.2;
                    double math = 3.4;
                    Flare_Bomb_Entity lava = new Flare_Bomb_Entity((EntityType<Flare_Bomb_Entity>)((EntityType)ModEntities.FLARE_BOMB.get()), this.entity.level(), (LivingEntity)this.entity);
                    lava.setPosRaw(this.entity.getX() + vec * vecX + (double)f * math, this.entity.getY(0.65), this.entity.getZ() + vec * vecZ + (double)f1 * math);
                    double d0 = target.getX() - lava.getX();
                    double d1 = target.getBoundingBox().minY + (double)(target.getBbHeight() / 3.0f) - lava.getY();
                    double d2 = target.getZ() - lava.getZ();
                    double d3 = Mth.sqrt((float)((float)(d0 * d0 + d2 * d2)));
                    lava.shoot(d0, d1 + d3 * (double)0.2f, d2, 1.0f, 1 + i * 8);
                    this.entity.level().addFreshEntity((Entity)lava);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ShoulderCheck
    extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final int attackendshot;
        private final float random;

        public ShoulderCheck(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, int attackendshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.attackendshot = attackendshot;
            this.random = random;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo((Entity)target) >= 5.75f && this.entity.getRandom().nextFloat() * 100.0f < this.random && this.entity.getSensing().hasLineOfSight((Entity)target) && this.entity.check_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.check_cooldown = 80;
        }

        @Override
        public void tick() {
            MoveControl moveControl;
            super.tick();
            if (this.entity.attackTicks > this.attackshot && this.entity.attackTicks < this.attackendshot && (moveControl = this.entity.getMoveControl()) instanceof FowardMoveController) {
                FowardMoveController onyxMoveController = (FowardMoveController)moveControl;
                onyxMoveController.forward(1.0f, 2.0f);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}

