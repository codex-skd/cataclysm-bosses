/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nullable
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.BossEvent$BossBarColor
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntitySelector
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
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.common.NeoForgeMod
 *  net.neoforged.neoforge.entity.PartEntity
 *  net.neoforged.neoforge.event.EventHooks
 *  net.neoforged.neoforge.fluids.FluidType
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.skd.thesundering.client.particle.Options.RoarParticleOptions;
import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.AI.AnimalAIRandomSwimming;
import com.skd.thesundering.entity.AI.EntityAINearestTarget3D;
import com.skd.thesundering.entity.AI.HurtByNearestTargetGoal;
import com.skd.thesundering.entity.AI.MobAIFindWater;
import com.skd.thesundering.entity.AnimationMonster.AI.AnimationGoal;
import com.skd.thesundering.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Mine_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Orb_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Portal_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Dimensional_Rift_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Part;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.skd.thesundering.entity.effect.Cm_Falling_Block_Entity;
import com.skd.thesundering.entity.effect.ScreenShake_Entity;
import com.skd.thesundering.entity.etc.CMBossInfoServer;
import com.skd.thesundering.entity.etc.IHoldEntity;
import com.skd.thesundering.entity.etc.ISemiAquatic;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.entity.etc.path.CMPathNavigateGround;
import com.skd.thesundering.entity.partentity.Cm_Part_Entity;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.message.MessageMusic;
import com.skd.thesundering.util.EntityUtil;
import com.skd.thesundering.world.data.CMWorldData;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
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
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.entity.PartEntity;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.network.PacketDistributor;

public class The_Leviathan_Entity
extends LLibrary_Boss_Monster
implements ISemiAquatic,
IHoldEntity {
    public static final Animation LEVIATHAN_GRAB = Animation.create((int)160);
    public static final Animation LEVIATHAN_GRAB_BITE = Animation.create((int)13);
    public static final Animation LEVIATHAN_BITE = Animation.create((int)24);
    public static final Animation LEVIATHAN_ABYSS_BLAST = Animation.create((int)184);
    public static final Animation LEVIATHAN_ABYSS_BLAST_FIRE = Animation.create((int)216);
    public static final Animation LEVIATHAN_RUSH = Animation.create((int)157);
    public static final Animation LEVIATHAN_STUN = Animation.create((int)90);
    public static final Animation LEVIATHAN_ABYSS_BLAST_PORTAL = Animation.create((int)142);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_UPPER_R = Animation.create((int)44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_LOWER_R = Animation.create((int)44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_UPPER_L = Animation.create((int)44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_LOWER_L = Animation.create((int)44);
    public static final Animation LEVIATHAN_TENTACLE_HOLD = Animation.create((int)63);
    public static final Animation LEVIATHAN_TENTACLE_HOLD_BLAST = Animation.create((int)189);
    public static final Animation LEVIATHAN_TAIL_WHIPS = Animation.create((int)42);
    public static final Animation LEVIATHAN_BREAK_DIMENSION = Animation.create((int)156);
    public static final Animation LEVIATHAN_PHASE2 = Animation.create((int)200);
    public static final Animation LEVIATHAN_DEATH = Animation.create((int)210);
    public static final Animation LEVIATHAN_MINE = Animation.create((int)68);
    public final The_Leviathan_Part headPart;
    public final The_Leviathan_Part tailPart1;
    public final The_Leviathan_Part tailPart2;
    public final The_Leviathan_Part[] leviathanParts;
    public boolean blocksBylefttentacle = true;
    public boolean blocksByrighttentacle = true;
    public boolean CanGrab = true;
    public boolean CanAbyss_Blast = true;
    public boolean CanRush = true;
    public boolean CanTailWhips = true;
    public boolean CanBite = true;
    public boolean CanAbyss_Blast_Portal = true;
    public boolean CanCrackDimension = true;
    public boolean CanMine = true;
    public float NoSwimProgress = 0.0f;
    public float prevNoSwimProgress = 0.0f;
    public float LeftTentacleProgress = 0.0f;
    public float prevLeftTentacleProgress = 0.0f;
    public float RightTentacleProgress = 0.0f;
    public float prevRightTentacleProgress = 0.0f;
    private boolean isLandNavigator;
    public Vec3 teleportPos = null;
    public Abyss_Portal_Entity portalTarget = null;
    public boolean fullyThrough = true;
    public static final int GRAB_HUNTING_COOLDOWN = 70;
    public static final int RUSH_HUNTING_COOLDOWN = 100;
    public static final int BLAST_HUNTING_COOLDOWN = 140;
    public static final int CRACK_HUNTING_COOLDOWN = 250;
    public static final int BLAST_PORTAL_HUNTING_COOLDOWN = 120;
    public static final int TAIL_WHIPS_HUNTING_COOLDOWN = 100;
    public static final int BITE_COOLDOWN = 100;
    public static final int MELEE_COOLDOWN = 40;
    public static final int MINE_COOLDOWN = 100;
    private AttackMode mode = AttackMode.CIRCLE;
    private int hunting_cooldown = 160;
    private int makePortalCooldown = 0;
    private int bite_cooldown = 0;
    private int melee_cooldown = 0;
    private int waterstillTicks = 0;
    public double endPosX;
    public double endPosY;
    public double endPosZ;
    public double collidePosX;
    public double collidePosY;
    public double collidePosZ;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    public float LayerBrightness;
    private Vec3 prevTailPos = new Vec3(0.0, 0.0, 0.0);
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, false, 5);
    private static final EntityDataAccessor<Integer> BLAST_CHANCE = SynchedEntityData.defineId(The_Leviathan_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MODE_CHANCE = SynchedEntityData.defineId(The_Leviathan_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> MELT_DOWN = SynchedEntityData.defineId(The_Leviathan_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<UUID>> TONGUE_UUID = SynchedEntityData.defineId(The_Leviathan_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> TONGUE_ID = SynchedEntityData.defineId(The_Leviathan_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public The_Leviathan_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.xpReward = 500;
        if (worldIn.isClientSide()) {
            this.socketPosArray = new Vec3[]{new Vec3(0.0, 0.0, 0.0)};
        }
        this.headPart = new The_Leviathan_Part(this, 2.8f, 2.8f);
        this.tailPart1 = new The_Leviathan_Part(this, 1.5f, 2.4f);
        this.tailPart2 = new The_Leviathan_Part(this, 1.3f, 2.4f);
        this.leviathanParts = new The_Leviathan_Part[]{this.headPart, this.tailPart1, this.tailPart2};
        this.switchNavigator(false);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Leviathan.healthMultiplier, CMCommonConfig.Leviathan.attackMultiplier);
    }

    public static AttributeSupplier.Builder leviathan() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 400.0).add(Attributes.FOLLOW_RANGE, 64.0).add(Attributes.ARMOR, 10.0).add(Attributes.ATTACK_DAMAGE, 15.0).add(Attributes.KNOCKBACK_RESISTANCE, 1.0).add(Attributes.MOVEMENT_SPEED, 0.15);
    }

    @Override
    public float DamageCap() {
        return (float)CMCommonConfig.Leviathan.damageCap;
    }

    @Override
    public float NatureRegen() {
        return (float)CMCommonConfig.Leviathan.natureHeal;
    }

    @Override
    public float DpsCap() {
        return (float)CMCommonConfig.Leviathan.dpsCap;
    }

    public int DpsMulti() {
        return CMCommonConfig.Leviathan.dpsLimitTime;
    }

    @Override
    public double RangeLimit() {
        return CMCommonConfig.Leviathan.rangeCap;
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation((Mob)this, worldIn);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(BLAST_CHANCE, (Object)0);
        p_326229_.define(MODE_CHANCE, (Object)0);
        p_326229_.define(MELT_DOWN, (Object)false);
        p_326229_.define(TONGUE_UUID, Optional.empty());
        p_326229_.define(TONGUE_ID, (Object)-1);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new MobAIFindWater((PathfinderMob)this, 2.0));
        this.goalSelector.addGoal(3, (Goal)new LeviathanAttackGoal(this));
        this.goalSelector.addGoal(4, (Goal)new AnimalAIRandomSwimming((PathfinderMob)this, 1.0, 3, 15));
        this.goalSelector.addGoal(4, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(5, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 6.0f));
        this.goalSelector.addGoal(0, (Goal)new LeviathanGrabAttackGoal(this, LEVIATHAN_GRAB));
        this.goalSelector.addGoal(0, (Goal)new LeviathanAbyssDimensionAttackGoal(this, LEVIATHAN_BREAK_DIMENSION));
        this.goalSelector.addGoal(0, (Goal)new LeviathanStunGoal(this, LEVIATHAN_STUN));
        this.goalSelector.addGoal(0, (Goal)new LeviathanGrabBiteAttackGoal(this, LEVIATHAN_GRAB_BITE));
        this.goalSelector.addGoal(0, (Goal)new LeviathanBiteAttackGoal(this, LEVIATHAN_BITE));
        this.goalSelector.addGoal(0, (Goal)new LeviathanPhase2Goal(this, LEVIATHAN_PHASE2));
        this.goalSelector.addGoal(0, (Goal)new LeviathanTailWhipsAttackGoal(this, LEVIATHAN_TAIL_WHIPS));
        this.goalSelector.addGoal(0, (Goal)new LeviathanTentacleAttackGoal(this));
        this.goalSelector.addGoal(0, (Goal)new LeviathanBlastAttackGoal(this, LEVIATHAN_ABYSS_BLAST));
        this.goalSelector.addGoal(0, (Goal)new LeviathanBlastFireAttackGoal(this, LEVIATHAN_ABYSS_BLAST_FIRE));
        this.goalSelector.addGoal(0, (Goal)new LeviathanAbyssBlastPortalAttackGoal(this, LEVIATHAN_ABYSS_BLAST_PORTAL));
        this.goalSelector.addGoal(0, (Goal)new LeviathanRushAttackGoal(this, LEVIATHAN_RUSH));
        this.goalSelector.addGoal(0, (Goal)new LeviathanTentacleHoldAttackGoal(this, LEVIATHAN_TENTACLE_HOLD));
        this.goalSelector.addGoal(0, (Goal)new LeviathanTentacleHoldBlastAttackGoal(this, LEVIATHAN_TENTACLE_HOLD_BLAST));
        this.goalSelector.addGoal(0, (Goal)new LeviathanMineAttackGoal(this, LEVIATHAN_MINE));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<Player>((Mob)this, Player.class, false, true));
        this.targetSelector.addGoal(3, new EntityAINearestTarget3D<LivingEntity>((Mob)this, LivingEntity.class, 160, false, true, ModEntities.buildPredicateFromTag(ModTag.LEVIATHAN_TARGET)));
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl((Mob)this);
            this.navigation = new CMPathNavigateGround((Mob)this, this.level());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new LeviathanMoveController(this, 10.0f, 1.0f, 6.0f);
            this.navigation = new WaterBoundPathNavigation((Mob)this, this.level());
            this.isLandNavigator = false;
        }
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{LEVIATHAN_PHASE2, LEVIATHAN_BITE, LEVIATHAN_BREAK_DIMENSION, LEVIATHAN_GRAB, LEVIATHAN_TAIL_WHIPS, LEVIATHAN_ABYSS_BLAST_PORTAL, LEVIATHAN_GRAB_BITE, LEVIATHAN_ABYSS_BLAST, LEVIATHAN_RUSH, LEVIATHAN_TENTACLE_STRIKE_UPPER_R, LEVIATHAN_TENTACLE_STRIKE_UPPER_L, LEVIATHAN_TENTACLE_STRIKE_LOWER_L, LEVIATHAN_TENTACLE_STRIKE_LOWER_R, LEVIATHAN_STUN, LEVIATHAN_DEATH, LEVIATHAN_TENTACLE_HOLD, LEVIATHAN_TENTACLE_HOLD_BLAST, LEVIATHAN_ABYSS_BLAST_FIRE, LEVIATHAN_MINE};
    }

    public void travel(Vec3 travelVector) {
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

    private static Animation getRandomTantalcleStrike(RandomSource rand) {
        switch (rand.nextInt(4)) {
            case 0: {
                return LEVIATHAN_TENTACLE_STRIKE_LOWER_L;
            }
            case 1: {
                return LEVIATHAN_TENTACLE_STRIKE_LOWER_R;
            }
            case 2: {
                return LEVIATHAN_TENTACLE_STRIKE_UPPER_L;
            }
            case 3: {
                return LEVIATHAN_TENTACLE_STRIKE_UPPER_R;
            }
        }
        return LEVIATHAN_TENTACLE_STRIKE_UPPER_R;
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Abyss_Blast_Entity || entity instanceof Portal_Abyss_Blast_Entity) {
            return false;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }
        double range = this.calculateRange(source);
        boolean flag1 = this.canInFluidType(this.getEyeInFluidType());
        if (!flag1 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && CMCommonConfig.Leviathan.ImmuneOutofWater) {
            if (entity instanceof Player) {
                Player player = (Player)entity;
                player.displayClientMessage((Component)Component.translatable((String)"entity.cataclysm.the_leviathan_immune"), true);
            }
            return false;
        }
        if (this.getAnimation() == LEVIATHAN_PHASE2 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        boolean attack = super.hurt(source, damage);
        if (this.getAnimation() == LEVIATHAN_RUSH && this.getAnimationTick() >= 38 && this.getAnimationTick() <= 54 && attack) {
            AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this, LEVIATHAN_STUN);
        }
        return attack;
    }

    @Override
    public int HealCooldown() {
        return 600;
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    private boolean canInFluidType(FluidType type) {
        NeoForgeMod.WATER_TYPE.value();
        return type.canSwim((Entity)this.self());
    }

    public void onInsideBubbleColumn(boolean p_20322_) {
    }

    public void onAboveBubbleCol(boolean p_20313_) {
    }

    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    public boolean attackEntityFromPart(The_Leviathan_Part leviathan_part, DamageSource source, float amount) {
        return this.hurt(source, amount);
    }

    @Override
    public void tick() {
        Entity weapon;
        super.tick();
        this.setYRot(this.yHeadRot);
        if (this.isInWater() && this.isLandNavigator) {
            this.switchNavigator(false);
        }
        if (!this.isInWater() && !this.isLandNavigator) {
            this.switchNavigator(true);
        }
        if ((weapon = this.getTongue()) instanceof The_Leviathan_Tongue_Entity) {
            The_Leviathan_Tongue_Entity magneticWeapon = (The_Leviathan_Tongue_Entity)weapon;
            this.entityData.set(TONGUE_ID, (Object)magneticWeapon.getId());
            magneticWeapon.setControllerUUID(this.getUUID());
        }
        if (!this.getPassengers().isEmpty() && ((Entity)this.getPassengers().get(0)).isShiftKeyDown() && this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
            ((Entity)this.getPassengers().get(0)).setShiftKeyDown(false);
        }
        LivingEntity target = this.getTarget();
        if (!this.level().isClientSide()) {
            float halfHealth = this.getMaxHealth() / 2.0f;
            if (!this.getMeltDown()) {
                this.bossInfo.setProgress((this.getHealth() - halfHealth) / (this.getMaxHealth() - halfHealth));
            } else {
                this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
                this.bossInfo.setRenderType(6);
            }
        }
        boolean groundAnimate = !this.isInWater();
        this.prevNoSwimProgress = this.NoSwimProgress;
        if (groundAnimate) {
            if (this.NoSwimProgress < 10.0f) {
                this.NoSwimProgress += 1.0f;
            }
        } else if (this.NoSwimProgress > 0.0f) {
            this.NoSwimProgress -= 1.0f;
        }
        this.prevLeftTentacleProgress = this.LeftTentacleProgress;
        this.prevRightTentacleProgress = this.RightTentacleProgress;
        if (this.blocksByrighttentacle) {
            if (this.RightTentacleProgress < 10.0f) {
                this.RightTentacleProgress += 1.0f;
            }
        } else if (this.RightTentacleProgress > 0.0f) {
            this.RightTentacleProgress -= 1.0f;
        }
        if (this.blocksBylefttentacle) {
            if (this.LeftTentacleProgress < 10.0f) {
                this.LeftTentacleProgress += 1.0f;
            }
        } else if (this.LeftTentacleProgress > 0.0f) {
            this.LeftTentacleProgress -= 1.0f;
        }
        if (this.tickCount % 10 == 0) {
            this.blocksByrighttentacle = this.checkBlocksByTentacle(1.0f, -3.0f) || this.checkBlocksByTentacle(2.0f, -3.0f) || this.checkBlocksByTentacle(3.0f, -3.0f) || this.checkBlocksByTentacle(4.0f, -3.0f) || this.checkBlocksByTentacle(5.0f, -3.0f);
            boolean bl = this.blocksBylefttentacle = this.checkBlocksByTentacle(1.0f, 3.0f) || this.checkBlocksByTentacle(2.0f, 3.0f) || this.checkBlocksByTentacle(3.0f, 3.0f) || this.checkBlocksByTentacle(4.0f, 3.0f) || this.checkBlocksByTentacle(5.0f, 3.0f);
        }
        if (this.portalTarget != null && this.portalTarget.getLifespan() < 5) {
            this.portalTarget = null;
        }
        if (this.teleportPos != null) {
            this.setPos(this.teleportPos.x, this.teleportPos.y, this.teleportPos.z);
            this.teleportPos = null;
        }
        if (this.makePortalCooldown > 0) {
            --this.makePortalCooldown;
        }
        if (this.hunting_cooldown > 0) {
            --this.hunting_cooldown;
        }
        if (this.bite_cooldown > 0) {
            --this.bite_cooldown;
        }
        if (this.melee_cooldown > 0) {
            --this.melee_cooldown;
        }
        if (!this.isNoAi()) {
            if (this.getAnimation() == NO_ANIMATION && !this.getMeltDown() && this.isMeltDown() && this.isAlive()) {
                this.setAnimation(LEVIATHAN_PHASE2);
            }
            if (this.getAnimation() == NO_ANIMATION && this.getTarget() != null) {
                this.waterstillTicks = Math.abs(this.xo - this.getX()) < (double)0.01f && Math.abs(this.yo - this.getY()) < (double)0.01f && Math.abs(this.zo - this.getZ()) < (double)0.01f ? ++this.waterstillTicks : 0;
                if (this.waterstillTicks > 40 && this.makePortalCooldown == 0) {
                    this.createStuckPortal();
                }
            }
            if (!this.level().isClientSide()) {
                if (this.destroyBlocksTick > 0) {
                    --this.destroyBlocksTick;
                    if (this.destroyBlocksTick == 0) {
                        if (CMCommonConfig.Leviathan.ignoreMobGriefing) {
                            this.blockbreak(0.5, 0.5, 0.5);
                        } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                            this.blockbreak(0.5, 0.5, 0.5);
                        }
                    }
                }
                if (this.mode == AttackMode.MELEE) {
                    if (CMCommonConfig.Leviathan.ignoreMobGriefing) {
                        this.blockbreak2();
                    } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                        this.blockbreak2();
                    }
                }
            }
            float f17 = this.getYRot() * (float)Math.PI / 180.0f;
            float pitch = this.getXRot() * (float)Math.PI / 180.0f;
            float f3 = Mth.sin((float)f17) * (1.0f - Math.abs(this.getXRot() / 90.0f));
            float f18 = Mth.cos((float)f17) * (1.0f - Math.abs(this.getXRot() / 90.0f));
            this.setPartPosition(this.headPart, f3 * -3.8f, -pitch * 3.0f, -f18 * -3.8f);
            this.setPartPosition(this.tailPart1, f3 * 3.3f, -pitch * -5.0f, -f18 * 3.3f);
            this.setPartPosition(this.tailPart2, f3 * 4.7f, -pitch * -8.0f, -f18 * 4.7f);
            Vec3[] avector3d = new Vec3[this.leviathanParts.length];
            for (int j = 0; j < this.leviathanParts.length; ++j) {
                avector3d[j] = new Vec3(this.leviathanParts[j].getX(), this.leviathanParts[j].getY(), this.leviathanParts[j].getZ());
            }
            for (int l = 0; l < this.leviathanParts.length; ++l) {
                this.leviathanParts[l].xo = avector3d[l].x;
                this.leviathanParts[l].yo = avector3d[l].y;
                this.leviathanParts[l].zo = avector3d[l].z;
                this.leviathanParts[l].xOld = avector3d[l].x;
                this.leviathanParts[l].yOld = avector3d[l].y;
                this.leviathanParts[l].zOld = avector3d[l].z;
            }
        }
    }

    public void aiStep() {
        float l;
        int j;
        Vec3 motion;
        float f3;
        float f2;
        int i;
        super.aiStep();
        float yaw = this.getYRot() * (float)Math.PI / 180.0f;
        float pitch = this.getXRot() * (float)Math.PI / 180.0f;
        float fx = Mth.sin((float)yaw) * (1.0f - Math.abs(this.getXRot() / 90.0f));
        float fz = Mth.cos((float)yaw) * (1.0f - Math.abs(this.getXRot() / 90.0f));
        if (this.getAnimation() == LEVIATHAN_ABYSS_BLAST) {
            if (this.getAnimationTick() < 30 && this.level().isClientSide()) {
                for (i = 0; i < 20; ++i) {
                    float f = -Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.getXRot() * ((float)Math.PI / 180)));
                    f2 = -Mth.sin((float)(this.getXRot() * ((float)Math.PI / 180)));
                    f3 = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.getXRot() * ((float)Math.PI / 180)));
                    this.level().addParticle((ParticleOptions)ParticleTypes.PORTAL, this.getX() + (double)f * 4.0, this.getY() + (double)f2 * 3.5, this.getZ() + (double)f3 * 4.0, (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
                }
            }
            if (this.getAnimationTick() >= 82) {
                this.setXRot(this.xRotO);
            }
            if (this.getAnimationTick() == 84 && this.getMeltDown()) {
                for (i = 0; i < 3; ++i) {
                    motion = new Vec3(0.5, -1.25, 0.5).yRot(-((float)(120 * i)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                for (i = 0; i < 6; ++i) {
                    motion = new Vec3(1.0, 0.0, 1.0).yRot(-((float)(60 * i)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                for (i = 0; i < 3; ++i) {
                    motion = new Vec3(0.5, 1.25, 0.5).yRot(-((float)(120 * i)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
            }
            i = 44;
            j = 0;
            while (i <= 84) {
                l = (float)j * 0.025f;
                if (this.getAnimationTick() == i) {
                    this.LayerBrightness = l;
                }
                ++i;
                ++j;
            }
            i = 144;
            j = 40;
            while (i <= 184) {
                l = (float)j * 0.025f;
                if (this.getAnimationTick() == i) {
                    this.LayerBrightness = l;
                }
                ++i;
                --j;
            }
            if (this.getAnimationTick() == 84) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 90, 10);
            }
        }
        if (this.getAnimation() == LEVIATHAN_ABYSS_BLAST_FIRE) {
            if (this.getAnimationTick() < 30 && this.level().isClientSide()) {
                for (i = 0; i < 20; ++i) {
                    float f = -Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.getXRot() * ((float)Math.PI / 180)));
                    f2 = -Mth.sin((float)(this.getXRot() * ((float)Math.PI / 180)));
                    f3 = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.getXRot() * ((float)Math.PI / 180)));
                    this.level().addParticle((ParticleOptions)ParticleTypes.PORTAL, this.getX() + (double)f * 4.0, this.getY() + (double)f2 * 3.5, this.getZ() + (double)f3 * 4.0, (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
                }
            }
            if (this.getAnimationTick() == 84 || this.getAnimationTick() == 129 || this.getAnimationTick() == 174) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.ABYSS_BLAST_ONLY_SHOOT.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            }
            if (this.getAnimationTick() >= 80 && this.getAnimationTick() <= 118 || this.getAnimationTick() >= 125 && this.getAnimationTick() <= 163 || this.getAnimationTick() >= 170 && this.getAnimationTick() <= 198) {
                this.setXRot(this.xRotO);
            }
            i = 44;
            j = 0;
            while (i <= 84) {
                l = (float)j * 0.025f;
                if (this.getAnimationTick() == i) {
                    this.LayerBrightness = l;
                }
                ++i;
                ++j;
            }
            i = 176;
            j = 40;
            while (i <= 216) {
                l = (float)j * 0.025f;
                if (this.getAnimationTick() == i) {
                    this.LayerBrightness = l;
                }
                ++i;
                --j;
            }
            if (this.getAnimationTick() == 84 || this.getAnimationTick() == 129 || this.getAnimationTick() == 174) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 20, 10);
            }
        }
        if (this.getAnimation() == LEVIATHAN_RUSH) {
            if (this.getAnimationTick() > 54 && this.getAnimationTick() < 137) {
                this.chargeDamage();
                if (!this.level().isClientSide()) {
                    if (CMCommonConfig.Leviathan.ignoreMobGriefing) {
                        this.chargeblockbreaking();
                    } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                        this.chargeblockbreaking();
                    }
                }
            }
            if (this.getAnimationTick() == 54) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.LEVIATHAN_ROAR.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 13.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 60, 10);
                this.roarDarkness(48.0, 48.0, 48.0, 48.0, 20);
            }
            if (this.getAnimationTick() == 57) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 14.0f);
            }
            if (this.getAnimationTick() == 60) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 15.0f);
            }
        }
        if (this.getAnimation() == LEVIATHAN_GRAB_BITE && this.getAnimationTick() == 2) {
            this.biteattack(6.5f, 1.5, 1.5, 1.5, 100);
        }
        if (this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_UPPER_R) {
            this.Tentacleattack(24, 9.0f, 2.0, 2.0, 2.0);
        }
        if (this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_LOWER_R) {
            this.Tentacleattack(28, 9.0f, 2.0, 2.0, 2.0);
        }
        if (this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_UPPER_L) {
            this.Tentacleattack(26, 9.0f, 2.0, 2.0, 2.0);
        }
        if (this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_LOWER_L) {
            this.Tentacleattack(21, 9.0f, 2.0, 2.0, 2.0);
        }
        if (this.getAnimation() == LEVIATHAN_STUN) {
            if (this.getAnimationTick() == 52) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.LEVIATHAN_STUN_ROAR.get(), SoundSource.HOSTILE, 4.0f, 0.8f);
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 8.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 40, 10);
                if (this.getMeltDown()) {
                    for (i = 0; i < 3; ++i) {
                        motion = new Vec3(0.5, -1.25, 0.5).yRot(-((float)(120 * i)) * ((float)Math.PI / 180));
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                    for (i = 0; i < 6; ++i) {
                        motion = new Vec3(1.0, 0.0, 1.0).yRot(-((float)(60 * i)) * ((float)Math.PI / 180));
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                    for (i = 0; i < 3; ++i) {
                        motion = new Vec3(0.5, 1.25, 0.5).yRot(-((float)(120 * i)) * ((float)Math.PI / 180));
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                }
            }
            if (this.getAnimationTick() == 55) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 9.0f);
            }
        }
        if (this.getAnimation() == LEVIATHAN_ABYSS_BLAST_PORTAL) {
            if (this.getAnimationTick() == 56) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.LEVIATHAN_ROAR.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 60, 10);
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 13.0f);
                this.roarDarkness(48.0, 48.0, 48.0, 48.0, 80);
            }
            if (this.getAnimationTick() == 59) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 14.0f);
            }
            if (this.getAnimationTick() == 62) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 15.0f);
            }
            i = 16;
            j = 0;
            while (i <= 56) {
                l = (float)j * 0.025f;
                if (this.getAnimationTick() == i) {
                    this.LayerBrightness = l;
                }
                ++i;
                ++j;
            }
            i = 102;
            j = 40;
            while (i <= 142) {
                l = (float)j * 0.025f;
                if (this.getAnimationTick() == i) {
                    this.LayerBrightness = l;
                }
                ++i;
                --j;
            }
        }
        this.SwingParticles();
        if (this.getAnimation() == LEVIATHAN_TAIL_WHIPS && this.getAnimationTick() == 18) {
            this.TailWhips();
        }
        if (this.getAnimation() == LEVIATHAN_BREAK_DIMENSION) {
            if (this.getAnimationTick() == 24) {
                this.level().playSound((Player)null, (Entity)this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.05f, 10, 10);
            }
            if (this.getAnimationTick() == 62) {
                this.level().playSound((Player)null, (Entity)this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 2.0f, 1.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 10, 10);
                for (Entity entity : this.level().getEntities((Entity)this, this.getBoundingBox().inflate(15.0))) {
                    Dimensional_Rift_Entity rift;
                    if (!(entity instanceof Dimensional_Rift_Entity) || (rift = (Dimensional_Rift_Entity)entity).getStage() >= 4) continue;
                    rift.setStage(rift.getStage() + 1);
                }
            }
            if (this.getAnimationTick() == 94) {
                this.level().playSound((Player)null, (Entity)this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 3.0f, 1.2f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 10, 10);
                for (Entity entity : this.level().getEntities((Entity)this, this.getBoundingBox().inflate(15.0))) {
                    Dimensional_Rift_Entity rift;
                    if (!(entity instanceof Dimensional_Rift_Entity) || (rift = (Dimensional_Rift_Entity)entity).getStage() >= 4) continue;
                    rift.setStage(rift.getStage() + 1);
                }
            }
            if (this.getAnimationTick() == 126) {
                this.level().playSound((Player)null, (Entity)this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 3.0f, 1.3f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.2f, 10, 10);
                for (Entity entity : this.level().getEntities((Entity)this, this.getBoundingBox().inflate(15.0))) {
                    Dimensional_Rift_Entity rift;
                    if (!(entity instanceof Dimensional_Rift_Entity) || (rift = (Dimensional_Rift_Entity)entity).getStage() >= 4) continue;
                    rift.setStage(rift.getStage() + 1);
                }
            }
        }
        if (this.getAnimation() == LEVIATHAN_BITE) {
            if (this.getAnimationTick() == 11) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.LEVIATHAN_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if (this.getAnimationTick() == 13) {
                this.biteattack(6.0f, 1.5, 1.5, 1.5, 100);
            }
        }
        if (this.getAnimation() == LEVIATHAN_PHASE2) {
            if (this.getAnimationTick() == 1 && CMCommonConfig.Leviathan.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), false), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
            if (this.getAnimationTick() == 90) {
                int i2;
                if (!this.getMeltDown()) {
                    this.setMeltDown(true);
                }
                if (CMCommonConfig.Leviathan.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                    PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), true), (CustomPacketPayload[])new CustomPacketPayload[0]);
                }
                for (i2 = 0; i2 < 3; ++i2) {
                    motion = new Vec3(0.5, -1.25, 0.5).yRot(-((float)(120 * i2)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                for (i2 = 0; i2 < 6; ++i2) {
                    motion = new Vec3(1.0, -0.75, 1.0).yRot(-((float)(60 * i2)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                for (i2 = 0; i2 < 6; ++i2) {
                    motion = new Vec3(1.0, 0.0, 1.0).yRot(-((float)(60 * i2)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                for (i2 = 0; i2 < 6; ++i2) {
                    motion = new Vec3(1.0, 0.75, 1.0).yRot(-((float)(60 * i2)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                for (i2 = 0; i2 < 3; ++i2) {
                    motion = new Vec3(0.5, 1.25, 0.5).yRot(-((float)(120 * i2)) * ((float)Math.PI / 180));
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.LEVIATHAN_STUN_ROAR.get(), SoundSource.HOSTILE, 3.0f, 0.8f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.1f, 40, 10);
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 13.0f);
            }
            if (this.getAnimationTick() == 93) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 14.0f);
            }
            if (this.getAnimationTick() == 96) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 1.2f, 15.0f);
            }
            if (this.getAnimationTick() >= 70 && this.getAnimationTick() <= 80) {
                this.Sphereparticle(this.getEyeHeight(), 0.0f, 8.0f);
            }
        }
        if (this.getAnimation() == LEVIATHAN_TENTACLE_HOLD && this.getAnimationTick() == 32) {
            this.TentacleHoldattack(7.0f, 2.5, 2.5, 2.5, 80);
        }
        if (this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
            int i3 = 44;
            int j2 = 0;
            while (i3 <= 84) {
                float l2 = (float)j2 * 0.025f;
                if (this.getAnimationTick() == i3) {
                    this.LayerBrightness = l2;
                }
                ++i3;
                ++j2;
            }
            i3 = 149;
            j2 = 40;
            while (i3 <= 189) {
                float l3 = (float)j2 * 0.025f;
                if (this.getAnimationTick() == i3) {
                    this.LayerBrightness = l3;
                }
                ++i3;
                --j2;
            }
        }
        if (this.getAnimation() == LEVIATHAN_MINE) {
            if (this.getAnimationTick() == 28) {
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 0.9f, 8.0f);
            }
            if (this.getAnimationTick() == 31) {
                this.level().playSound((Player)null, (Entity)this, (SoundEvent)ModSounds.LEVIATHAN_STUN_ROAR.get(), SoundSource.HOSTILE, 3.0f, 0.8f);
                this.RoarParticle(this.getX() + (double)(fx * -4.0f), this.getY() - (double)(pitch * 3.0f), this.getZ() - (double)(fz * -4.0f), 60, 102, 26, 204, 0.9f, 1.0f, 0.9f, 9.0f);
            }
        }
    }

    private void RoarParticle(double x, double y, double z, int duration, int r, int g, int b, float a, float start, float inc, float end) {
        if (this.level().isClientSide()) {
            this.level().addParticle((ParticleOptions)new RoarParticleOptions(duration, r, g, b, a, start, inc, end), x, y, z, 0.0, 0.0, 0.0);
        }
    }

    private void roarDarkness(double x, double y, double z, double radius, int time) {
        List<LivingEntity> entities = this.getEntityLivingBaseNearby(x, y, z, radius);
        if (!this.level().isClientSide()) {
            for (LivingEntity inRange : entities) {
                if (inRange instanceof Player && ((Player)inRange).getAbilities().invulnerable || this.isAlliedTo((Entity)inRange)) continue;
                inRange.addEffect(new MobEffectInstance(MobEffects.DARKNESS, time));
            }
        }
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        boolean prev;
        CMWorldData worldData;
        if (living != null && (worldData = CMWorldData.get(this.level(), (ResourceKey<Level>)Level.OVERWORLD)) != null && !(prev = worldData.isLeviathanDefeatedOnce())) {
            worldData.setLeviathanDefeatedOnce(true);
            Level level = this.level();
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel)level;
                serverLevel.getPlayers(EntitySelector.NO_SPECTATORS).forEach(serverPlayer -> serverPlayer.displayClientMessage((Component)Component.translatable((String)"entity.cataclysm.the_leviathan.defeat_message").withStyle(ChatFormatting.DARK_PURPLE), true));
            }
        }
    }

    private void TailWhips() {
        if (!this.level().isClientSide()) {
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0, 7.0, 7.0))) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof The_Leviathan_Entity || entity == this) continue;
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                boolean flag = entity.hurt(damagesource, (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), (double)(entity.getMaxHealth() * (float)CMCommonConfig.Leviathan.TailSwingHpDamage))));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                    Player player = (Player)entity;
                    EntityUtil.disableShield(player, 120);
                }
                if (!flag) continue;
                this.launch((Entity)entity, true);
                entity.addEffect(new MobEffectInstance(ModEffect.EFFECTBONE_FRACTURE, 200));
            }
        }
    }

    private void Sphereparticle(float height, float vec, float size) {
        if (this.level().isClientSide() && this.tickCount % 2 == 0) {
            double d0 = this.getX();
            double d1 = this.getY() + (double)height;
            double d2 = this.getZ();
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            for (float i = -size; i <= size; i += 1.0f) {
                for (float j = -size; j <= size; j += 1.0f) {
                    for (float k = -size; k <= size; k += 1.0f) {
                        double d3 = (double)j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                        double d4 = (double)i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                        double d5 = (double)k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                        double d6 = (double)Mth.sqrt((float)((float)(d3 * d3 + d4 * d4 + d5 * d5))) / 0.5 + this.random.nextGaussian() * 0.05;
                        this.level().addParticle((ParticleOptions)ParticleTypes.REVERSE_PORTAL, d0 + (double)vec * vecX, d1, d2 + (double)vec * vecZ, d3 / d6, d4 / d6, d5 / d6);
                        if (i == -size || i == size || j == -size || j == size) continue;
                        k += size * 2.0f - 1.0f;
                    }
                }
            }
        }
    }

    public boolean isMeltDown() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }

    public void shootAbyssOrb(double xMotion, double yMotion, double zMotion) {
        if (this.getTarget() != null) {
            Abyss_Orb_Entity fireball = new Abyss_Orb_Entity((LivingEntity)this, xMotion, yMotion, zMotion, this.level(), (float)CMCommonConfig.Leviathan.AbyssOrbdamage, this.getTarget());
            fireball.setPos(fireball.getX(), this.getEyeY(), fireball.getZ());
            fireball.setUp(40);
            if (!this.level().isClientSide()) {
                this.level().addFreshEntity((Entity)fireball);
            }
        } else {
            Abyss_Orb_Entity fireball = new Abyss_Orb_Entity((LivingEntity)this, xMotion, yMotion, zMotion, this.level(), (float)CMCommonConfig.Leviathan.AbyssOrbdamage, null);
            fireball.setPos(fireball.getX(), this.getEyeY(), fireball.getZ());
            fireball.setUp(40);
            if (!this.level().isClientSide()) {
                this.level().addFreshEntity((Entity)fireball);
            }
        }
    }

    private void launch(Entity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
        float f = huge ? 10.0f : 5.0f;
        e.push(d0 / d2 * (double)f, huge ? 1.0 : (double)0.2f, d1 / d2 * (double)f);
    }

    private void Tailswing() {
        Vec3 bladePos = this.socketPosArray[0];
        double length = this.prevTailPos.subtract(bladePos).length();
        int numClouds = (int)Math.floor(2.0 * length);
        for (int i = 0; i < numClouds; ++i) {
            double x = this.prevTailPos.x + (double)i * (bladePos.x - this.prevTailPos.x) / (double)numClouds;
            double y = this.prevTailPos.y + (double)i * (bladePos.y - this.prevTailPos.y) / (double)numClouds;
            double z = this.prevTailPos.z + (double)i * (bladePos.z - this.prevTailPos.z) / (double)numClouds;
            SimpleParticleType type = ParticleTypes.EXPLOSION;
            this.level().addParticle((ParticleOptions)type, x, y, z, 0.0, 0.0, 0.0);
        }
    }

    private void SwingParticles() {
        if (this.level().isClientSide()) {
            Vec3 bladePos = this.socketPosArray[0];
            if (this.getAnimation() == LEVIATHAN_TAIL_WHIPS && this.getAnimationTick() >= 10 && this.getAnimationTick() <= 34) {
                this.Tailswing();
            }
            this.prevTailPos = bladePos;
        }
    }

    private void blockbreak(double x, double y, double z) {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(x, y, z);
        for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.LEVIATHAN_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
            flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
        }
    }

    private void blockbreak2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.2);
        for (BlockPos pos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(pos);
            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), pos, (Entity)this) || blockstate.is(ModTag.LEVIATHAN_IMMUNE)) continue;
            if (this.random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, blockstate, 20);
                flag = this.level().destroyBlock(pos, false, (Entity)this) || flag;
                fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2 + this.random.nextDouble()) / 3.0, 0.2 + this.getRandom().nextGaussian() * 0.15, (-1.2 + this.random.nextDouble()) / 3.0)));
                this.level().addFreshEntity((Entity)fallingBlockEntity);
                continue;
            }
            flag = this.level().destroyBlock(pos, false, (Entity)this) || flag;
            this.setDeltaMovement(this.getDeltaMovement().multiply((double)0.6f, 1.0, (double)0.6f));
        }
        if (flag) {
            this.blockBreakCounter = 10;
        }
    }

    private void chargeblockbreaking() {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(4.5, 0.5, 4.5);
        double yblockbreak = this.isInWater() ? aabb.minY : this.getY();
        for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)yblockbreak), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.LEVIATHAN_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
            flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
        }
    }

    private void chargeDamage() {
        if (this.tickCount % 4 == 0 && !this.level().isClientSide()) {
            for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.0))) {
                if (this.isAlliedTo((Entity)Lentity) || Lentity instanceof The_Leviathan_Entity || Lentity == this) continue;
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                boolean flag = Lentity.hurt(damagesource, (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), (double)(Lentity.getMaxHealth() * (float)CMCommonConfig.Leviathan.RushHpDamage))));
                if (Lentity instanceof Player) {
                    Player player = (Player)Lentity;
                    if (Lentity.isDamageSourceBlocked(damagesource)) {
                        EntityUtil.disableShield(player, 120);
                    }
                }
                if (!flag || !Lentity.onGround()) continue;
                double d0 = Lentity.getX() - this.getX();
                double d1 = Lentity.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                float f = 1.5f;
                Lentity.push(d0 / d2 * (double)f, 0.5, d1 / d2 * (double)f);
            }
        }
    }

    private void biteattack(float radius, double inflateX, double inflateY, double inflateZ, int stuntick) {
        double renderYaw = (double)(this.yHeadRot + 90.0f) * Math.PI / 180.0;
        double renderPitch = (float)((double)(-this.getXRot()) * Math.PI / 180.0);
        this.endPosX = this.getX() + (double)radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        this.endPosZ = this.getZ() + (double)radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        this.endPosY = this.getY() + (double)radius * Math.sin(renderPitch);
        if (!this.level().isClientSide()) {
            List<LivingEntity> hit = this.raytraceEntities((Level)this.level(), (double)inflateX, (double)inflateY, (double)inflateZ, (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ)).entities;
            for (LivingEntity target : hit) {
                if (this.isAlliedTo((Entity)target) || target instanceof The_Leviathan_Entity || target == this) continue;
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                boolean flag = target.hurt(damagesource, (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)) * 1.5 + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5, (double)(target.getMaxHealth() * (float)CMCommonConfig.Leviathan.TentacleHpDamage))));
                if (target instanceof Player) {
                    Player player = (Player)target;
                    if (target.isDamageSourceBlocked(damagesource)) {
                        EntityUtil.disableShield(player, 200);
                    }
                }
                if (!flag || stuntick <= 0) continue;
                target.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, stuntick));
            }
        }
    }

    private void Tentacleattack(int anime, float radius, double inflateX, double inflateY, double inflateZ) {
        double renderYaw = (double)(this.yHeadRot + 90.0f) * Math.PI / 180.0;
        double renderPitch = (float)((double)(-this.getXRot()) * Math.PI / 180.0);
        this.endPosX = this.getX() + (double)radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        this.endPosZ = this.getZ() + (double)radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        this.endPosY = this.getY() + (double)radius * Math.sin(renderPitch);
        if (this.getAnimationTick() == anime) {
            this.playSound((SoundEvent)ModSounds.LEVIATHAN_TENTACLE_STRIKE.get(), 1.0f, 1.0f);
            if (!this.level().isClientSide()) {
                List<LivingEntity> hit = this.raytraceEntities((Level)this.level(), (double)inflateX, (double)inflateY, (double)inflateZ, (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ)).entities;
                for (LivingEntity target : hit) {
                    if (this.isAlliedTo((Entity)target) || target instanceof The_Leviathan_Entity || target == this) continue;
                    DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                    boolean flag = target.hurt(damagesource, (float)((double)((float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), (double)(target.getMaxHealth() * (float)CMCommonConfig.Leviathan.TentacleHpDamage))));
                    if (target instanceof Player) {
                        Player player = (Player)target;
                        if (target.isDamageSourceBlocked(damagesource)) {
                            EntityUtil.disableShield(player, 90);
                        }
                    }
                    if (!flag) continue;
                    double d0 = target.getX() - this.getX();
                    double d1 = target.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    target.push(d0 / d2 * 7.0, 0.2, d1 / d2 * 7.0);
                }
            }
        }
    }

    private void TentacleHoldattack(float radius, double inflateX, double inflateY, double inflateZ, int shieldbreakticks) {
        double renderYaw = (double)(this.yHeadRot + 90.0f) * Math.PI / 180.0;
        double renderPitch = (float)((double)(-this.getXRot()) * Math.PI / 180.0);
        this.endPosX = this.getX() + (double)radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        this.endPosZ = this.getZ() + (double)radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        this.endPosY = this.getY() + (double)radius * Math.sin(renderPitch);
        if (!this.level().isClientSide()) {
            List<LivingEntity> hit = this.raytraceEntities((Level)this.level(), (double)inflateX, (double)inflateY, (double)inflateZ, (Vec3)new Vec3((double)this.getX(), (double)this.getY(), (double)this.getZ()), (Vec3)new Vec3((double)this.endPosX, (double)this.endPosY, (double)this.endPosZ)).entities;
            for (LivingEntity target : hit) {
                if (this.isAlliedTo((Entity)target) || target instanceof The_Leviathan_Entity || target == this) continue;
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                boolean flag = target.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getMaxHealth() * 0.1f);
                if (target instanceof Player) {
                    Player player = (Player)target;
                    if (target.isDamageSourceBlocked(damagesource) && shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag || target.getType().is(ModTag.IGNIS_CANT_POKE) || !target.isAlive()) continue;
                if (target.isShiftKeyDown()) {
                    target.setShiftKeyDown(false);
                }
                target.startRiding((Entity)this, true);
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this, LEVIATHAN_TENTACLE_HOLD_BLAST);
            }
        }
    }

    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        if (this.hasPassenger(passenger)) {
            if (this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST && this.getAnimationTick() == 169) {
                passenger.stopRiding();
            }
            this.setXRot(this.xRotO);
            this.yBodyRot = this.getYRot();
            this.yHeadRot = this.getYRot();
            float f17 = this.getYRot() * (float)Math.PI / 180.0f;
            float pitch = this.getXRot() * (float)Math.PI / 180.0f;
            float f3 = Mth.sin((float)f17) * (1.0f - Math.abs(this.getXRot() / 90.0f));
            float f18 = Mth.cos((float)f17) * (1.0f - Math.abs(this.getXRot() / 90.0f));
            moveFunc.accept(passenger, this.getX() + (double)(f3 * -8.25f), this.getY() + (double)(-pitch * 6.0f), this.getZ() + (double)(-f18 * -8.25f));
        }
    }

    public boolean shouldRiderSit() {
        return false;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance p_31495_) {
        return p_31495_.getEffect() != ModEffect.EFFECTABYSSAL_BURN.get() && super.canBeAffected(p_31495_);
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

    protected int increaseAirSupply(int currentAir) {
        return this.getMaxAirSupply();
    }

    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("BlastChance", this.getBlastChance());
        compound.putBoolean("MeltDown", this.getMeltDown());
        compound.putInt("ModeChance", this.getModeChance());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setBlastChance(compound.getInt("BlastChance"));
        this.setModeChance(compound.getInt("ModeChance"));
        this.setMeltDown(compound.getBoolean("MeltDown"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    public boolean getMeltDown() {
        return (Boolean)this.entityData.get(MELT_DOWN);
    }

    public void setMeltDown(boolean chance) {
        this.entityData.set(MELT_DOWN, (Object)chance);
    }

    public int getBlastChance() {
        return (Integer)this.entityData.get(BLAST_CHANCE);
    }

    public void setBlastChance(int chance) {
        this.entityData.set(BLAST_CHANCE, (Object)chance);
    }

    public int getModeChance() {
        return (Integer)this.entityData.get(MODE_CHANCE);
    }

    public void setModeChance(int chance) {
        this.entityData.set(MODE_CHANCE, (Object)chance);
    }

    @Nullable
    public UUID getTongueUUID() {
        return ((Optional)this.entityData.get(TONGUE_UUID)).orElse(null);
    }

    public void setTongueUUID(@Nullable UUID uniqueId) {
        this.entityData.set(TONGUE_UUID, Optional.ofNullable(uniqueId));
    }

    public Entity getTongue() {
        if (!this.level().isClientSide()) {
            UUID id = this.getTongueUUID();
            return id == null ? null : ((ServerLevel)this.level()).getEntity(id);
        }
        int id = (Integer)this.entityData.get(TONGUE_ID);
        return id == -1 ? null : this.level().getEntity(id);
    }

    public void createStuckPortal() {
        if (this.getTarget() != null) {
            Vec3 to = new Vec3(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ());
            this.createPortal2(this.getX(), this.getY() + 0.1, this.getZ(), to);
        }
    }

    public void createPortal2(double x, double y, double z, Vec3 to) {
        if (!this.level().isClientSide() && this.portalTarget == null) {
            Abyss_Portal_Entity portal = (Abyss_Portal_Entity)((EntityType)ModEntities.ABYSS_PORTAL.get()).create(this.level());
            portal.setPos(x, y, z);
            portal.setLifespan(10000);
            portal.setEntrance(true);
            if (!this.level().isClientSide()) {
                this.level().addFreshEntity((Entity)portal);
            }
            this.portalTarget = portal;
            portal.setDestination(BlockPos.containing((double)to.x, (double)to.y, (double)to.z));
            this.makePortalCooldown = 300;
        }
    }

    public void resetPortalLogic() {
        this.portalTarget = null;
    }

    public void teleportTo(Vec3 vec) {
        this.teleportPos = vec;
        this.fullyThrough = false;
    }

    private boolean checkBlocksByTentacle(float vec, float math) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        BlockPos pos1 = new BlockPos(Mth.floor((double)(this.getX() + (double)vec * vecX + (double)(f * math))), Math.round((float)(this.getY() - 2.0)), Mth.floor((double)(this.getZ() + (double)vec * vecZ + (double)(f1 * math))));
        return this.level().getBlockState(pos1).blocksMotion();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    @Override
    public boolean shouldEnterWater() {
        return true;
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
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

    @Override
    public SoundEvent getBossMusic() {
        if (CMCommonConfig.Leviathan.SeparatePhaseMusic) {
            return this.getMeltDown() ? (SoundEvent)ModSounds.LEVIATHAN_MUSIC_2.get() : (SoundEvent)ModSounds.LEVIATHAN_MUSIC_1.get();
        }
        return (SoundEvent)ModSounds.LEVIATHAN_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        if (CMCommonConfig.Leviathan.SeparatePhaseMusic) {
            if (this.getAnimation() == LEVIATHAN_PHASE2) {
                return this.getAnimationTick() > 90 && super.canPlayMusic();
            }
            return super.canPlayMusic();
        }
        return super.canPlayMusic();
    }

    @Override
    @Nullable
    public Animation getDeathAnimation() {
        return LEVIATHAN_DEATH;
    }

    protected float getSoundVolume() {
        return this.isSilent() ? 0.0f : 2.0f;
    }

    private void setPartPosition(The_Leviathan_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * (double)part.scale, this.getY() + offsetY * (double)part.scale, this.getZ() + offsetZ * (double)part.scale);
    }

    public boolean isMultipartEntity() {
        return true;
    }

    @Nullable
    public PartEntity<?>[] getParts() {
        return this.leviathanParts;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Cm_Part_Entity.assignPartIDs((Entity)this);
    }

    public Vec3 getTonguePosition() {
        float f1 = -Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.getXRot() * ((float)Math.PI / 180)));
        float f2 = -Mth.sin((float)(this.getXRot() * ((float)Math.PI / 180)));
        float f3 = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180))) * Mth.cos((float)(this.getXRot() * ((float)Math.PI / 180)));
        return new Vec3(this.getX() + (double)f1 * 3.0, this.getY() + (double)f2 * 3.5, this.getZ() + (double)f3 * 3.0);
    }

    private static enum AttackMode {
        CIRCLE,
        MELEE,
        RANGE;

    }

    class LeviathanAttackGoal
    extends Goal {
        private final The_Leviathan_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final int huntingTime = 0;
        private float MeleeModeTime = 0.0f;
        private static final int MELEE_MODE_TIME = 160;
        private float circleDistance = 18.0f;
        private boolean clockwise = false;

        public LeviathanAttackGoal(The_Leviathan_Entity mob) {
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

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.MeleeModeTime = 0.0f;
            this.circleDistance = 36 + this.mob.random.nextInt(20);
            this.clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            this.circlingTime = 0;
            this.MeleeModeTime = 0.0f;
            this.circleDistance = 36 + this.mob.random.nextInt(20);
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

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == AttackMode.CIRCLE) {
                    ++this.circlingTime;
                    The_Leviathan_Entity.this.circleEntity((Entity)target, this.circleDistance, 1.0f, this.clockwise, this.circlingTime, 0.0f, 1.0f);
                    if (0 >= this.mob.hunting_cooldown) {
                        int i = Math.max(this.mob.getModeChance(), 2);
                        this.mob.mode = this.mob.random.nextInt(i) == 0 ? AttackMode.RANGE : AttackMode.MELEE;
                    }
                    if (this.mob.getRandom().nextFloat() * 100.0f < 12.0f && this.mob.distanceToSqr((Entity)target) <= 49.0 && this.mob.melee_cooldown <= 0) {
                        Animation animation = The_Leviathan_Entity.getRandomTantalcleStrike(this.mob.random);
                        this.mob.setAnimation(animation);
                    }
                } else if (this.mob.mode == AttackMode.RANGE) {
                    if (this.mob.getRandom().nextFloat() * 100.0f < 3.0f && this.mob.CanAbyss_Blast_Portal) {
                        this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST_PORTAL);
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 2.0f * (float)this.mob.getBlastChance() && this.mob.CanAbyss_Blast) {
                        if (this.mob.random.nextInt(2) == 0) {
                            this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST);
                        } else {
                            this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST_FIRE);
                        }
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 8.0f && this.mob.distanceToSqr((Entity)target) >= 700.0 && this.mob.CanGrab) {
                        this.mob.setAnimation(LEVIATHAN_GRAB);
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 4.0f && this.mob.distanceToSqr((Entity)target) < 900.0 && this.mob.distanceToSqr((Entity)target) >= 49.0 && this.mob.CanRush) {
                        this.mob.setAnimation(LEVIATHAN_RUSH);
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    this.mob.getNavigation().moveTo((Entity)target, 1.0);
                    this.MeleeModeTime += 1.0f;
                    this.mob.getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                    if (this.MeleeModeTime >= 160.0f) {
                        this.mob.mode = AttackMode.RANGE;
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 15.0f && this.mob.distanceToSqr((Entity)target) < 49.0 && this.mob.CanTailWhips) {
                        this.mob.setAnimation(LEVIATHAN_TAIL_WHIPS);
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 8.0f && this.mob.distanceToSqr((Entity)target) < 36.0 && this.mob.CanGrab) {
                        this.mob.setAnimation(LEVIATHAN_TENTACLE_HOLD);
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 20.0f && this.mob.distanceToSqr((Entity)target) <= 30.0 && this.mob.CanBite) {
                        this.mob.setAnimation(LEVIATHAN_BITE);
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 3.0f && this.mob.CanCrackDimension && this.mob.distanceToSqr((Entity)target) < 256.0 && this.mob.distanceToSqr((Entity)target) > 49.0) {
                        this.mob.setAnimation(LEVIATHAN_BREAK_DIMENSION);
                    } else if (this.mob.getRandom().nextFloat() * 100.0f < 5.0f && this.mob.CanMine && this.mob.distanceToSqr((Entity)target) < 256.0 && this.mob.distanceToSqr((Entity)target) > 100.0) {
                        this.mob.setAnimation(LEVIATHAN_MINE);
                    }
                }
            }
        }
    }

    static class LeviathanGrabAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanGrabAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = false;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 70;
            ((The_Leviathan_Entity)this.entity).setBlastChance(((The_Leviathan_Entity)this.entity).getBlastChance() + 1);
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() + 1);
        }

        public void tick() {
            The_Leviathan_Tongue_Entity magneticWeapon;
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            Entity weapon = ((The_Leviathan_Entity)this.entity).getTongue();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 25 && target != null && ((The_Leviathan_Entity)this.entity).getTongue() == null && !((The_Leviathan_Entity)this.entity).level().isClientSide()) {
                The_Leviathan_Tongue_Entity segment = (The_Leviathan_Tongue_Entity)((EntityType)ModEntities.THE_LEVIATHAN_TONGUE.get()).create(((The_Leviathan_Entity)this.entity).level());
                segment.copyPosition((Entity)this.entity);
                segment.setPos(((The_Leviathan_Entity)this.entity).getTonguePosition());
                segment.setControllerUUID(((The_Leviathan_Entity)this.entity).getUUID());
                segment.setMaxDuration(120);
                ((The_Leviathan_Entity)this.entity).setTongueUUID(segment.getUUID());
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)segment);
            }
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() > 25 && ((The_Leviathan_Entity)this.entity).getAnimationTick() <= 145 && target != null && target.isAlive() && ((The_Leviathan_Entity)this.entity).distanceTo((Entity)target) < 8.5f) {
                if (weapon instanceof The_Leviathan_Tongue_Entity && (magneticWeapon = (The_Leviathan_Tongue_Entity)weapon).getComingBack()) {
                    magneticWeapon.remove(Entity.RemovalReason.DISCARDED);
                }
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((The_Leviathan_Entity)this.entity), LEVIATHAN_GRAB_BITE);
            }
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() > 155 && weapon instanceof The_Leviathan_Tongue_Entity) {
                magneticWeapon = (The_Leviathan_Tongue_Entity)weapon;
                magneticWeapon.remove(Entity.RemovalReason.DISCARDED);
            }
        }
    }

    static class LeviathanAbyssDimensionAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanAbyssDimensionAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = false;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 0.0f);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 250;
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() - 1);
        }

        public void tick() {
            Dimensional_Rift_Entity rift;
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 24 && !((The_Leviathan_Entity)this.entity).level().isClientSide()) {
                double theta = (double)((The_Leviathan_Entity)this.entity).yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                double vecZ = Math.sin(theta);
                Dimensional_Rift_Entity portal = new Dimensional_Rift_Entity(((The_Leviathan_Entity)this.entity).level(), ((The_Leviathan_Entity)this.entity).getX() + vecX * 12.0, ((The_Leviathan_Entity)this.entity).getEyeY(), ((The_Leviathan_Entity)this.entity).getZ() + vecZ * 12.0, (LivingEntity)this.entity);
                portal.setStage(1);
                portal.setLifespan(600);
                if (!((The_Leviathan_Entity)this.entity).level().isClientSide()) {
                    ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)portal);
                }
            }
            if ((rift = this.getClosestDimensionalRift()) != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)rift, 30.0f, 90.0f);
            }
        }

        private Dimensional_Rift_Entity getClosestDimensionalRift() {
            List list = ((The_Leviathan_Entity)this.entity).level().getEntitiesOfClass(Dimensional_Rift_Entity.class, ((The_Leviathan_Entity)this.entity).getBoundingBox().inflate(15.0, 15.0, 15.0));
            Dimensional_Rift_Entity closest = null;
            if (!list.isEmpty()) {
                for (Dimensional_Rift_Entity entity : list) {
                    if (closest != null && !(closest.distanceTo(entity) > entity.distanceTo(entity))) continue;
                    closest = entity;
                }
            }
            return closest;
        }
    }

    static class LeviathanStunGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanStunGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            super.start();
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null && ((The_Leviathan_Entity)this.entity).getAnimationTick() > 28) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }
    }

    static class LeviathanGrabBiteAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanGrabBiteAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            ((The_Leviathan_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.LEVIATHAN_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            super.start();
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            ((The_Leviathan_Entity)this.entity).setYRot(((The_Leviathan_Entity)this.entity).yRotO);
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 70;
        }
    }

    static class LeviathanBiteAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanBiteAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanBite = false;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() < 13 && target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 100;
            ((The_Leviathan_Entity)this.entity).setBlastChance(((The_Leviathan_Entity)this.entity).getBlastChance() + 1);
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() - 1);
        }
    }

    static class LeviathanPhase2Goal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanPhase2Goal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            super.start();
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() >= 90 && target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
        }
    }

    static class LeviathanTailWhipsAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanTailWhipsAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = false;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 100;
            ((The_Leviathan_Entity)this.entity).setBlastChance(((The_Leviathan_Entity)this.entity).getBlastChance() + 1);
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
        }

        public void tick() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() - 1);
        }
    }

    static class LeviathanTentacleAttackGoal
    extends AnimationGoal<The_Leviathan_Entity> {
        public LeviathanTentacleAttackGoal(The_Leviathan_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == LEVIATHAN_TENTACLE_STRIKE_UPPER_R || animation == LEVIATHAN_TENTACLE_STRIKE_LOWER_R || animation == LEVIATHAN_TENTACLE_STRIKE_UPPER_L || animation == LEVIATHAN_TENTACLE_STRIKE_LOWER_L;
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            super.start();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
            ((The_Leviathan_Entity)this.entity).melee_cooldown = 40;
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }
    }

    static class LeviathanBlastAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanBlastAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.ABYSS_BLAST.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = false;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 140;
            ((The_Leviathan_Entity)this.entity).setBlastChance(0);
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() + 1);
        }

        public void tick() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null && ((The_Leviathan_Entity)this.entity).getAnimationTick() < 82) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            float dir = 90.0f;
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 64 && !((The_Leviathan_Entity)this.entity).level().isClientSide()) {
                Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity((EntityType<? extends Abyss_Blast_Entity>)((EntityType)ModEntities.ABYSS_BLAST.get()), ((The_Leviathan_Entity)this.entity).level(), (LivingEntity)this.entity, ((The_Leviathan_Entity)this.entity).getX(), ((The_Leviathan_Entity)this.entity).getY(), ((The_Leviathan_Entity)this.entity).getZ(), (float)((double)(((The_Leviathan_Entity)this.entity).yHeadRot + dir) * Math.PI / 180.0), (float)((double)(-((The_Leviathan_Entity)this.entity).getXRot()) * Math.PI / 180.0), 80, dir, (float)CMCommonConfig.Leviathan.AbyssBlastDamage, (float)CMCommonConfig.Leviathan.AbyssBlastHpDamage);
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)DeathBeam);
            }
        }
    }

    static class LeviathanBlastFireAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanBlastFireAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.ABYSS_BLAST_ONLY_CHARGE.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = false;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 140;
            ((The_Leviathan_Entity)this.entity).setBlastChance(0);
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() + 1);
        }

        public void tick() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null && (((The_Leviathan_Entity)this.entity).getAnimationTick() < 80 || ((The_Leviathan_Entity)this.entity).getAnimationTick() > 118 && ((The_Leviathan_Entity)this.entity).getAnimationTick() < 125 || ((The_Leviathan_Entity)this.entity).getAnimationTick() > 163 && ((The_Leviathan_Entity)this.entity).getAnimationTick() < 170)) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            float dir = 90.0f;
            if (!(((The_Leviathan_Entity)this.entity).getAnimationTick() != 64 && ((The_Leviathan_Entity)this.entity).getAnimationTick() != 109 && ((The_Leviathan_Entity)this.entity).getAnimationTick() != 154 || ((The_Leviathan_Entity)this.entity).level().isClientSide())) {
                Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity((EntityType<? extends Abyss_Blast_Entity>)((EntityType)ModEntities.ABYSS_BLAST.get()), ((The_Leviathan_Entity)this.entity).level(), (LivingEntity)this.entity, ((The_Leviathan_Entity)this.entity).getX(), ((The_Leviathan_Entity)this.entity).getY(), ((The_Leviathan_Entity)this.entity).getZ(), (float)((double)(((The_Leviathan_Entity)this.entity).yHeadRot + dir) * Math.PI / 180.0), (float)((double)(-((The_Leviathan_Entity)this.entity).getXRot()) * Math.PI / 180.0), 28, dir, (float)CMCommonConfig.Leviathan.AbyssBlastDamage, (float)CMCommonConfig.Leviathan.AbyssBlastHpDamage);
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)DeathBeam);
            }
        }
    }

    static class LeviathanAbyssBlastPortalAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanAbyssBlastPortalAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = false;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            super.start();
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 120;
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() + 1);
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                double d0 = Math.min(target.getY(), ((The_Leviathan_Entity)this.entity).getY()) - 50.0;
                double d1 = Math.max(target.getY(), ((The_Leviathan_Entity)this.entity).getY()) + 3.0;
                float f = (float)Mth.atan2((double)(target.getZ() - ((The_Leviathan_Entity)this.entity).getZ()), (double)(target.getX() - ((The_Leviathan_Entity)this.entity).getX()));
                if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 56) {
                    for (int l = 0; l < 9; ++l) {
                        int j = (int)(5.0f * (float)l);
                        double randomNearbyX = target.getX() + ((The_Leviathan_Entity)this.entity).random.nextGaussian() * 12.0;
                        double randomNearbyZ = target.getZ() + ((The_Leviathan_Entity)this.entity).random.nextGaussian() * 12.0;
                        this.spawnUnderPortal(randomNearbyX, randomNearbyZ, d0, d1, f, j);
                    }
                }
                if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 56 || ((The_Leviathan_Entity)this.entity).getAnimationTick() == 76 || ((The_Leviathan_Entity)this.entity).getAnimationTick() == 96) {
                    this.spawnUnderPortal(target.getX(), target.getZ(), d0, d1, f, 0);
                }
            }
        }

        private void spawnUnderPortal(double x, double z, double minY, double maxY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
            boolean flag = false;
            double d0 = 0.0;
            do {
                BlockState blockstate1;
                VoxelShape voxelshape;
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = ((The_Leviathan_Entity)this.entity).level().getBlockState(blockpos1);
                if (!blockstate.isFaceSturdy((BlockGetter)((The_Leviathan_Entity)this.entity).level(), blockpos1, Direction.UP)) continue;
                if (!((The_Leviathan_Entity)this.entity).level().isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = ((The_Leviathan_Entity)this.entity).level().getBlockState(blockpos)).getCollisionShape((BlockGetter)((The_Leviathan_Entity)this.entity).level(), blockpos)).isEmpty()) {
                    d0 = voxelshape.max(Direction.Axis.Y);
                }
                flag = true;
                break;
            } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)minY) - 1);
            if (flag) {
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)new Abyss_Blast_Portal_Entity(((The_Leviathan_Entity)this.entity).level(), x, (double)blockpos.getY() + d0, z, rotation, delay, (float)CMCommonConfig.Leviathan.AbyssBlastDamage, (float)CMCommonConfig.Leviathan.AbyssBlastHpDamage, (LivingEntity)this.entity));
            }
        }

        private void spawnUpperPortal(double x, double z, double maxY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
            boolean flag = false;
            double d0 = 0.0;
            do {
                BlockState blockstate1;
                VoxelShape voxelshape;
                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = ((The_Leviathan_Entity)this.entity).level().getBlockState(blockpos1);
                if (!blockstate.isFaceSturdy((BlockGetter)((The_Leviathan_Entity)this.entity).level(), blockpos1, Direction.DOWN)) continue;
                if (!((The_Leviathan_Entity)this.entity).level().isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = ((The_Leviathan_Entity)this.entity).level().getBlockState(blockpos)).getCollisionShape((BlockGetter)((The_Leviathan_Entity)this.entity).level(), blockpos)).isEmpty()) {
                    d0 = voxelshape.max(Direction.Axis.Y);
                }
                flag = true;
                break;
            } while ((blockpos = blockpos.above()).getY() < Math.min(((The_Leviathan_Entity)this.entity).level().getMaxBuildHeight(), ((The_Leviathan_Entity)this.entity).getBlockY() + 100) && !((The_Leviathan_Entity)this.entity).level().getBlockState(blockpos).isSolid());
            if (flag) {
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)new Abyss_Blast_Portal_Entity(((The_Leviathan_Entity)this.entity).level(), x, (double)blockpos.getY() + d0 + 0.5, z, rotation, delay, (float)CMCommonConfig.Leviathan.AbyssBlastDamage, (float)CMCommonConfig.Leviathan.AbyssBlastHpDamage, (LivingEntity)this.entity));
            }
        }
    }

    static class LeviathanRushAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanRushAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            super.start();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = false;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void stop() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 100;
            ((The_Leviathan_Entity)this.entity).setBlastChance(((The_Leviathan_Entity)this.entity).getBlastChance() + 1);
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() + 1);
        }

        public void tick() {
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                if (((The_Leviathan_Entity)this.entity).getAnimationTick() > 53 && ((The_Leviathan_Entity)this.entity).getAnimationTick() < 134) {
                    double d0 = target.getX() - ((The_Leviathan_Entity)this.entity).getX();
                    double d1 = target.getEyeY() - ((The_Leviathan_Entity)this.entity).getEyeY();
                    double d2 = target.getZ() - ((The_Leviathan_Entity)this.entity).getZ();
                    double d3 = Mth.sqrt((float)((float)(d0 * d0 + d2 * d2)));
                    float targetYaw = (float)(Mth.atan2((double)d2, (double)d0) * 180.0 / 3.1415927410125732 - 90.0);
                    float targetPitch = (float)(-(Mth.atan2((double)d1, (double)d3) * 180.0 / 3.1415927410125732));
                    ((The_Leviathan_Entity)this.entity).setXRot(((The_Leviathan_Entity)this.entity).getXRot() + Mth.clamp((float)(targetPitch - ((The_Leviathan_Entity)this.entity).getXRot()), (float)-2.0f, (float)2.0f));
                    if (d0 * d0 + d2 * d2 >= 9.0) {
                        ((The_Leviathan_Entity)this.entity).setYRot(((The_Leviathan_Entity)this.entity).getYRot() + Mth.clamp((float)(targetYaw - ((The_Leviathan_Entity)this.entity).getYRot()), (float)-2.0f, (float)2.0f));
                        ((The_Leviathan_Entity)this.entity).yBodyRot = ((The_Leviathan_Entity)this.entity).getYRot();
                    }
                    if (Math.abs(Mth.wrapDegrees((float)targetYaw) - Mth.wrapDegrees((float)((The_Leviathan_Entity)this.entity).getYRot())) < 4.0f) {
                        double distSq = d0 * d0 + d2 * d2;
                        if (distSq < 9.0) {
                            ((The_Leviathan_Entity)this.entity).setYRot(((The_Leviathan_Entity)this.entity).yRotO);
                            ((The_Leviathan_Entity)this.entity).yBodyRot = ((The_Leviathan_Entity)this.entity).yRotO;
                            ((The_Leviathan_Entity)this.entity).setDeltaMovement(((The_Leviathan_Entity)this.entity).getDeltaMovement().multiply(0.8, 1.0, 0.8));
                        } else {
                            if (((The_Leviathan_Entity)this.entity).isInWater() && target.isInWater()) {
                                Vec3 vector3d = ((The_Leviathan_Entity)this.entity).getDeltaMovement();
                                Vec3 vector3d1 = new Vec3(target.getX() - ((The_Leviathan_Entity)this.entity).getX(), target.getY() - ((The_Leviathan_Entity)this.entity).getY(), target.getZ() - ((The_Leviathan_Entity)this.entity).getZ());
                                if (vector3d1.lengthSqr() > 1.0E-7) {
                                    vector3d1 = vector3d1.normalize().scale(0.5).add(vector3d.scale(0.5));
                                }
                                ((The_Leviathan_Entity)this.entity).setDeltaMovement(vector3d1.x, vector3d1.y, vector3d1.z);
                            }
                            ((The_Leviathan_Entity)this.entity).getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0);
                            ((The_Leviathan_Entity)this.entity).getNavigation().moveTo((Entity)target, 1.0);
                        }
                    }
                }
            }
        }
    }

    static class LeviathanTentacleHoldAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanTentacleHoldAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = false;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 70;
            ((The_Leviathan_Entity)this.entity).setBlastChance(((The_Leviathan_Entity)this.entity).getBlastChance() + 1);
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void tick() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() - 1);
        }
    }

    static class LeviathanTentacleHoldBlastAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanTentacleHoldBlastAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = false;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanMine = true;
            ((The_Leviathan_Entity)this.entity).level().playSound((Player)null, (Entity)this.entity, (SoundEvent)ModSounds.ABYSS_BLAST.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 140;
            ((The_Leviathan_Entity)this.entity).setBlastChance(0);
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void tick() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            float dir = 90.0f;
            if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 64 && !((The_Leviathan_Entity)this.entity).level().isClientSide()) {
                Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity((EntityType<? extends Abyss_Blast_Entity>)((EntityType)ModEntities.ABYSS_BLAST.get()), ((The_Leviathan_Entity)this.entity).level(), (LivingEntity)this.entity, ((The_Leviathan_Entity)this.entity).getX(), ((The_Leviathan_Entity)this.entity).getY(), ((The_Leviathan_Entity)this.entity).getZ(), (float)((double)(((The_Leviathan_Entity)this.entity).yHeadRot + dir) * Math.PI / 180.0), (float)((double)(-((The_Leviathan_Entity)this.entity).getXRot()) * Math.PI / 180.0), 80, dir, (float)CMCommonConfig.Leviathan.AbyssBlastDamage, (float)CMCommonConfig.Leviathan.AbyssBlastHpDamage);
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)DeathBeam);
            }
        }
    }

    static class LeviathanMineAttackGoal
    extends SimpleAnimationGoal<The_Leviathan_Entity> {
        public LeviathanMineAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
        }

        public void start() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast_Portal = true;
            ((The_Leviathan_Entity)this.entity).CanGrab = true;
            ((The_Leviathan_Entity)this.entity).CanRush = true;
            ((The_Leviathan_Entity)this.entity).CanCrackDimension = true;
            ((The_Leviathan_Entity)this.entity).CanAbyss_Blast = true;
            ((The_Leviathan_Entity)this.entity).CanTailWhips = true;
            ((The_Leviathan_Entity)this.entity).CanBite = true;
            ((The_Leviathan_Entity)this.entity).CanMine = false;
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            ((The_Leviathan_Entity)this.entity).hunting_cooldown = 100;
            ((The_Leviathan_Entity)this.entity).setBlastChance(((The_Leviathan_Entity)this.entity).getBlastChance() + 1);
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
            }
        }

        public void tick() {
            ((The_Leviathan_Entity)this.entity).getNavigation().stop();
            LivingEntity target = ((The_Leviathan_Entity)this.entity).getTarget();
            if (target != null) {
                ((The_Leviathan_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 90.0f);
                float f = (float)Mth.atan2((double)(target.getZ() - ((The_Leviathan_Entity)this.entity).getZ()), (double)(target.getX() - ((The_Leviathan_Entity)this.entity).getX()));
                if (((The_Leviathan_Entity)this.entity).getAnimationTick() == 31) {
                    for (int l = 0; l < 35; ++l) {
                        int j = (int)(2.0f * (float)l);
                        double randomNearbyX = target.getX() + ((The_Leviathan_Entity)this.entity).random.nextGaussian() * 12.0;
                        double randomNearbyY = target.getY() + ((The_Leviathan_Entity)this.entity).random.nextGaussian() * 8.0;
                        double randomNearbyZ = target.getZ() + ((The_Leviathan_Entity)this.entity).random.nextGaussian() * 12.0;
                        this.spawnMines(randomNearbyX, randomNearbyY, randomNearbyZ, f, j);
                    }
                }
            }
            ((The_Leviathan_Entity)this.entity).setModeChance(((The_Leviathan_Entity)this.entity).getModeChance() - 1);
        }

        private void spawnMines(double x, double y, double z, float rotation, int delay) {
            Abyss_Mine_Entity mine = new Abyss_Mine_Entity(((The_Leviathan_Entity)this.entity).level(), x, y, z, rotation, delay, (LivingEntity)this.entity);
            if (mine.level().noCollision((Entity)mine)) {
                ((The_Leviathan_Entity)this.entity).level().addFreshEntity((Entity)mine);
            }
        }
    }

    static class LeviathanMoveController
    extends MoveControl {
        private final The_Leviathan_Entity entity;
        private final float speedMulti;
        private final float ySpeedMod;
        private final float yawLimit;
        private int stillTicks = 0;

        public LeviathanMoveController(The_Leviathan_Entity entity, float speedMulti, float ySpeedMod, float yawLimit) {
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

