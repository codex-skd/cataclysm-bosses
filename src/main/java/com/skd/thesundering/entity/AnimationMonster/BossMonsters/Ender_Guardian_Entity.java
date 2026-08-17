/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.BossEvent$BossBarColor
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
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
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.entity.projectile.ShulkerBullet
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.event.EventHooks
 *  net.neoforged.neoforge.event.entity.EntityTeleportEvent$EnderEntity
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.thesundering.entity.AnimationMonster.BossMonsters;

import com.skd.thesundering.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.thesundering.client.particle.Options.RingParticleOptions;
import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.AI.HurtByNearestTargetGoal;
import com.skd.thesundering.entity.AnimationMonster.AI.AnimationGoal;
import com.skd.thesundering.entity.AnimationMonster.AI.AttackAnimationGoal1;
import com.skd.thesundering.entity.AnimationMonster.AI.AttackAnimationGoal2;
import com.skd.thesundering.entity.AnimationMonster.AI.AttackMoveGoal;
import com.skd.thesundering.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.skd.thesundering.entity.effect.ScreenShake_Entity;
import com.skd.thesundering.entity.effect.Void_Vortex_Entity;
import com.skd.thesundering.entity.etc.CMBossInfoServer;
import com.skd.thesundering.entity.etc.SmartBodyHelper2;
import com.skd.thesundering.entity.etc.path.CMPathNavigateGround;
import com.skd.thesundering.entity.projectile.Ender_Guardian_Bullet_Entity;
import com.skd.thesundering.entity.projectile.Void_Rune_Entity;
import com.skd.thesundering.init.ModBlocks;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModItems;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.message.MessageMusic;
import com.skd.thesundering.util.EntityUtil;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class Ender_Guardian_Entity
extends LLibrary_Boss_Monster {
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, false, 1);
    private static final EntityDataAccessor<Boolean> IS_HELMETLESS = SynchedEntityData.defineId(Ender_Guardian_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> USED_MASS_DESTRUCTION = SynchedEntityData.defineId(Ender_Guardian_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<BlockPos>> TELEPORT_POS = SynchedEntityData.defineId(Ender_Guardian_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_BLOCK_POS);
    public static final Animation GUARDIAN_RIGHT_STRONG_ATTACK = Animation.create((int)60);
    public static final Animation GUARDIAN_LEFT_STRONG_ATTACK = Animation.create((int)60);
    public static final Animation GUARDIAN_RIGHT_ATTACK = Animation.create((int)40);
    public static final Animation GUARDIAN_LEFT_ATTACK = Animation.create((int)40);
    public static final Animation GUARDIAN_BURST_ATTACK = Animation.create((int)53);
    public static final Animation GUARDIAN_UPPERCUT_AND_BULLET = Animation.create((int)100);
    public static final Animation GUARDIAN_RAGE_UPPERCUT = Animation.create((int)120);
    public static final Animation GUARDIAN_STOMP = Animation.create((int)48);
    public static final Animation GUARDIAN_RAGE_STOMP = Animation.create((int)83);
    public static final Animation GUARDIAN_MASS_DESTRUCTION = Animation.create((int)75);
    public static final Animation GUARDIAN_FALLEN = Animation.create((int)196);
    public static final Animation GUARDIAN_HUG_ME = Animation.create((int)76);
    public static final Animation GUARDIAN_AIR_STRIKE1 = Animation.create((int)123);
    public static final Animation GUARDIAN_AIR_STRIKE2 = Animation.create((int)39);
    public static final Animation GUARDIAN_RIGHT_SWING = Animation.create((int)42);
    public static final Animation GUARDIAN_LEFT_SWING = Animation.create((int)42);
    public static final Animation GUARDIAN_BLACKHOLE = Animation.create((int)62);
    public static final Animation GUARDIAN_ROCKETPUNCH = Animation.create((int)58);
    public static final int STOMP_COOLDOWN = 400;
    public static final int UPPERCUT_COOLDOWN = 200;
    public static final int TELEPORT_COOLDOWN = 280;
    public static final int TELEPORT_SMASH_COOLDOWN = 600;
    public static final int VORTEX_COOLDOWN = 280;
    private int stomp_cooldown = 0;
    private int teleport_cooldown = 0;
    private int teleport_smash_cooldown = 0;
    private int uppercut_cooldown = 0;
    private int vortexcooldown = 0;

    public Ender_Guardian_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 300;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.EnderGuardian.healthMultiplier, CMCommonConfig.EnderGuardian.attackMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, GUARDIAN_RIGHT_STRONG_ATTACK, GUARDIAN_LEFT_STRONG_ATTACK, GUARDIAN_BURST_ATTACK, GUARDIAN_UPPERCUT_AND_BULLET, GUARDIAN_STOMP, GUARDIAN_RIGHT_ATTACK, GUARDIAN_LEFT_ATTACK, GUARDIAN_MASS_DESTRUCTION, GUARDIAN_RAGE_STOMP, GUARDIAN_RAGE_UPPERCUT, GUARDIAN_FALLEN, GUARDIAN_HUG_ME, GUARDIAN_AIR_STRIKE1, GUARDIAN_AIR_STRIKE2, GUARDIAN_LEFT_SWING, GUARDIAN_RIGHT_SWING, GUARDIAN_BLACKHOLE, GUARDIAN_ROCKETPUNCH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new AttackMoveGoal(this, true, 1.0));
        this.goalSelector.addGoal(1, (Goal)new PunchAttackGoal(this));
        this.goalSelector.addGoal(1, (Goal)new AttackAnimationGoal2<Ender_Guardian_Entity>(this, this, GUARDIAN_MASS_DESTRUCTION, 39, 50){

            public void start() {
                super.start();
                ((Ender_Guardian_Entity)this.entity).setUsedMassDestruction(true);
            }
        });
        this.goalSelector.addGoal(1, new AttackAnimationGoal2<Ender_Guardian_Entity>(this, GUARDIAN_BURST_ATTACK, 27, 47));
        this.goalSelector.addGoal(1, (Goal)new VoidVortexGoal(this, GUARDIAN_BLACKHOLE));
        this.goalSelector.addGoal(1, (Goal)new RocketPunchGoal(this, GUARDIAN_ROCKETPUNCH));
        this.goalSelector.addGoal(1, new SimpleAnimationGoal<Ender_Guardian_Entity>(this, GUARDIAN_AIR_STRIKE2));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ender_Guardian_Entity>(this, GUARDIAN_RIGHT_SWING, 26, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ender_Guardian_Entity>(this, GUARDIAN_LEFT_SWING, 26, true));
        this.goalSelector.addGoal(1, (Goal)new HugmeGoal(this, GUARDIAN_HUG_ME, 30.0f, 20));
        this.goalSelector.addGoal(1, (Goal)new TeleportStrikeGoal(this, GUARDIAN_AIR_STRIKE1));
        this.goalSelector.addGoal(1, (Goal)new StompAttackGoal(this));
        this.goalSelector.addGoal(1, (Goal)new UppercutAndBulletGoal(this, GUARDIAN_UPPERCUT_AND_BULLET));
        this.goalSelector.addGoal(1, (Goal)new RageUppercut(this, GUARDIAN_RAGE_UPPERCUT));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, true));
    }

    public static AttributeSupplier.Builder ender_guardian() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 50.0).add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 16.0).add(Attributes.MAX_HEALTH, 333.0).add(Attributes.ARMOR, 20.0).add(Attributes.STEP_HEIGHT, 1.75).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_HELMETLESS, (Object)false);
        p_326229_.define(TELEPORT_POS, Optional.empty());
        p_326229_.define(USED_MASS_DESTRUCTION, (Object)true);
    }

    private static Animation getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(4)) {
            case 0: {
                return GUARDIAN_RIGHT_STRONG_ATTACK;
            }
            case 1: {
                return GUARDIAN_LEFT_STRONG_ATTACK;
            }
            case 2: {
                return GUARDIAN_RIGHT_ATTACK;
            }
            case 3: {
                return GUARDIAN_LEFT_ATTACK;
            }
        }
        return GUARDIAN_RIGHT_STRONG_ATTACK;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        Optional<BlockPos> restPos = this.getTeleportPos();
        if (restPos.isPresent()) {
            compound.put("TeleportPos", NbtUtils.writeBlockPos((BlockPos)this.getTeleportPos().get()));
        }
        compound.putBoolean("is_Helmetless", this.getIsHelmetless());
        compound.putBoolean("used_mass_destruction", this.getUsedMassDestruction());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        NbtUtils.readBlockPos((CompoundTag)compound, (String)"TeleportPos").ifPresent(this::setTeleportPos);
        this.setIsHelmetless(compound.getBoolean("is_Helmetless"));
        this.setUsedMassDestruction(compound.getBoolean("used_mass_destruction"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setIsHelmetless(boolean isHelmetless) {
        if (isHelmetless) {
            this.getAttribute(Attributes.ARMOR).setBaseValue(15.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.29f);
        } else {
            this.getAttribute(Attributes.ARMOR).setBaseValue(20.0);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.27f);
        }
        this.entityData.set(IS_HELMETLESS, (Object)isHelmetless);
    }

    public boolean getIsHelmetless() {
        return (Boolean)this.entityData.get(IS_HELMETLESS);
    }

    public void setUsedMassDestruction(boolean usedMassDestruction) {
        this.entityData.set(USED_MASS_DESTRUCTION, (Object)usedMassDestruction);
    }

    public boolean getUsedMassDestruction() {
        return (Boolean)this.entityData.get(USED_MASS_DESTRUCTION);
    }

    public void setTeleportPos(BlockPos p_30220_) {
        this.entityData.set(TELEPORT_POS, Optional.of(p_30220_));
    }

    public Optional<BlockPos> getTeleportPos() {
        return (Optional)this.entityData.get(TELEPORT_POS);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        boolean attack;
        if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (!this.getIsHelmetless() && entity instanceof AbstractArrow) {
            return false;
        }
        if (entity instanceof ShulkerBullet || entity instanceof Ender_Guardian_Bullet_Entity) {
            return false;
        }
        if (entity instanceof AbstractGolem) {
            damage = (float)((double)damage * 0.5);
        }
        if ((attack = super.hurt(source, damage)) && this.getIsHelmetless()) {
            this.playSound(SoundEvents.SHULKER_HURT, 1.0f, 0.8f);
        }
        return attack;
    }

    @Override
    public float DamageCap() {
        return (float)CMCommonConfig.EnderGuardian.damageCap;
    }

    @Override
    public float NatureRegen() {
        return (float)CMCommonConfig.EnderGuardian.natureHeal;
    }

    @Override
    public float DpsCap() {
        return (float)CMCommonConfig.EnderGuardian.dpsCap;
    }

    @Override
    public double RangeLimit() {
        return CMCommonConfig.EnderGuardian.rangeCap;
    }

    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || super.isInvulnerableTo(source);
    }

    @Override
    public void tick() {
        Animation animation2;
        super.tick();
        this.repelEntities(1.8f, 4.0f, 1.8f, 1.8f);
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        LivingEntity target = this.getTarget();
        Animation animation = Ender_Guardian_Entity.getRandomAttack(this.random);
        Animation animation3 = animation2 = this.getIsHelmetless() ? GUARDIAN_RAGE_UPPERCUT : GUARDIAN_UPPERCUT_AND_BULLET;
        if (this.isAlive()) {
            if (!this.getIsHelmetless() && this.isHelmetless()) {
                this.setIsHelmetless(true);
                this.BrokenHelmet();
            }
            if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && !this.getUsedMassDestruction() && this.isHelmetless()) {
                this.setAnimation(GUARDIAN_MASS_DESTRUCTION);
            } else if (target != null && target.isAlive()) {
                if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr((Entity)target) >= 256.0 && this.distanceToSqr((Entity)target) <= 1024.0 && target.onGround() && this.getIsHelmetless() && this.getRandom().nextFloat() * 100.0f < 20.0f && this.teleport_smash_cooldown <= 0) {
                    this.teleport_smash_cooldown = 600;
                    this.setAnimation(GUARDIAN_AIR_STRIKE1);
                } else if (this.vortexcooldown <= 0 && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr((Entity)target) <= 1024.0 && (this.distanceToSqr((Entity)target) >= 35.0 && this.getRandom().nextFloat() * 100.0f < 2.0f || this.getRandom().nextFloat() * 100.0f < 60.0f && this.getY() + 3.0 <= target.getY())) {
                    this.vortexcooldown = 280;
                    this.setAnimation(GUARDIAN_BLACKHOLE);
                } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && (double)this.distanceTo((Entity)target) >= 4.3 && (double)this.distanceTo((Entity)target) <= 16.0 && target.onGround() && this.getRandom().nextFloat() * 100.0f < 4.0f && this.teleport_cooldown <= 0) {
                    this.teleport_cooldown = 280;
                    this.setAnimation(GUARDIAN_HUG_ME);
                } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && (double)this.distanceTo((Entity)target) < 4.3 && target.onGround() && this.getRandom().nextFloat() * 100.0f < 0.7f && this.teleport_cooldown <= 0) {
                    this.teleport_cooldown = 280;
                    this.setAnimation(GUARDIAN_HUG_ME);
                } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 2.75f) {
                    if (this.random.nextInt(6) == 0) {
                        this.setAnimation(GUARDIAN_BURST_ATTACK);
                    } else {
                        this.setAnimation(animation);
                    }
                } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) > 2.75f && this.distanceTo((Entity)target) < 4.3f && (target.hasEffect(MobEffects.LEVITATION) || target.hasEffect(ModEffect.EFFECTSTUN))) {
                    this.uppercut_cooldown = 200;
                    this.setAnimation(animation2);
                } else if (this.stomp_cooldown <= 0 && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && target.onGround() && (this.distanceTo((Entity)target) > 6.0f && this.distanceTo((Entity)target) < 13.0f && this.getRandom().nextFloat() * 100.0f < 10.0f || this.distanceTo((Entity)target) > 2.75f && this.distanceTo((Entity)target) < 4.3f && this.getRandom().nextFloat() * 100.0f < 2.0f)) {
                    this.stomp_cooldown = 400;
                    Animation animation32 = this.getIsHelmetless() ? GUARDIAN_RAGE_STOMP : GUARDIAN_STOMP;
                    this.setAnimation(animation32);
                } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) > 2.75f && this.distanceTo((Entity)target) < 4.3f) {
                    if (this.random.nextInt(4) == 0) {
                        this.uppercut_cooldown = 200;
                        this.setAnimation(animation2);
                    } else {
                        this.setAnimation(animation);
                    }
                }
            }
        }
        if (this.stomp_cooldown > 0) {
            --this.stomp_cooldown;
        }
        if (this.teleport_cooldown > 0) {
            --this.teleport_cooldown;
        }
        if (this.teleport_smash_cooldown > 0) {
            --this.teleport_smash_cooldown;
        }
        if (this.uppercut_cooldown > 0) {
            --this.uppercut_cooldown;
        }
        if (this.vortexcooldown > 0) {
            --this.vortexcooldown;
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAnimation() == GUARDIAN_LEFT_STRONG_ATTACK) {
            if (this.getAnimationTick() < 2) {
                this.GravityPullparticle();
            }
            if (this.getAnimationTick() < 29) {
                this.GravityPull();
            }
            if (this.getAnimationTick() == 34) {
                this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.15f, 5.0f, 70.0f, 1.0f, (float)CMCommonConfig.EnderGuardian.GravityPunchHpdamage, 100, 0, 0.0f, false);
                this.Attackparticle(2.2f, 0.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.2f, 0, 10);
            }
        }
        if (this.getAnimation() == GUARDIAN_RIGHT_STRONG_ATTACK) {
            if (this.getAnimationTick() < 2) {
                this.GravityPullparticle();
            }
            if (this.getAnimationTick() < 24) {
                this.GravityPull();
            }
            if (this.getAnimationTick() == 29) {
                this.AreaAttack(5.15f, 5.0f, 70.0f, 1.0f, (float)CMCommonConfig.EnderGuardian.GravityPunchHpdamage, 100, 0, 0.0f, false);
                this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.Attackparticle(2.2f, 0.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.2f, 0, 10);
            }
        }
        if (this.getAnimation() == GUARDIAN_RIGHT_ATTACK && this.getAnimationTick() == 22) {
            this.AreaAttack(5.85f, 5.0f, 80.0f, 1.0f, 0.0f, 80, 0, 0.0f, false);
            this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            this.Attackparticle(2.75f, 0.5f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.1f, 0, 10);
        }
        if (this.getAnimation() == GUARDIAN_LEFT_ATTACK && this.getAnimationTick() == 19) {
            this.AreaAttack(5.85f, 5.0f, 80.0f, 1.0f, 0.0f, 80, 0, 0.0f, false);
            this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            this.Attackparticle(2.75f, -0.5f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.1f, 0, 10);
        }
        if (this.getAnimation() == GUARDIAN_BURST_ATTACK) {
            if (this.getAnimationTick() == 15) {
                this.Burstparticle();
            }
            if (this.getAnimationTick() == 27) {
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(7.5f, 6.0f, 100.0f, 1.0f, (float)CMCommonConfig.EnderGuardian.KnockbackHpdamage, 0, 0, 0.0f, true);
            }
        }
        if ((this.getAnimation() == GUARDIAN_UPPERCUT_AND_BULLET || this.getAnimation() == GUARDIAN_RAGE_UPPERCUT) && this.getAnimationTick() == 27) {
            this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            this.AreaAttack(6.25f, 7.0f, 60.0f, 1.4f, (float)CMCommonConfig.EnderGuardian.UppercutHpdamage, 150, 60, 0.5f, false);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.3f, 0, 10);
        }
        if (this.getAnimation() == GUARDIAN_STOMP && this.getAnimationTick() == 32) {
            this.StompAttack();
            this.Attackparticle(0.4f, 0.8f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 10.0f, 0.1f, 0, 5);
        }
        if (this.getAnimation() == GUARDIAN_RAGE_STOMP && (this.getAnimationTick() == 32 || this.getAnimationTick() == 53 || this.getAnimationTick() == 62)) {
            this.StompAttack();
            this.Attackparticle(0.4f, 0.8f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 10.0f, 0.1f, 0, 5);
        }
        if (this.getAnimation() == GUARDIAN_RAGE_UPPERCUT && this.getAnimationTick() == 84) {
            this.RageAttack();
            this.AreaAttack(5.5f, 5.0f, 120.0f, 1.2f, (float)CMCommonConfig.EnderGuardian.AreaAttackHpdamage, 100, 0, 0.0f, false);
            this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.2f, 0, 10);
        }
        if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION) {
            if (this.getAnimationTick() == 1 && CMCommonConfig.EnderGuardian.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), false), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
            if (this.getAnimationTick() == 39) {
                this.Attackparticle(2.75f, 2.25f);
                this.Attackparticle(2.75f, -2.25f);
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.3f, 0, 10);
                this.MassDestruction(5.0f, 1.1f, 150);
                if (!this.level().isClientSide()) {
                    if (CMCommonConfig.EnderGuardian.ignoreMobGriefing) {
                        this.BlockBreaking(CMCommonConfig.EnderGuardian.BlockBreakingX, CMCommonConfig.EnderGuardian.BlockBreakingY, CMCommonConfig.EnderGuardian.BlockBreakingZ);
                    } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                        this.BlockBreaking(CMCommonConfig.EnderGuardian.BlockBreakingX, CMCommonConfig.EnderGuardian.BlockBreakingY, CMCommonConfig.EnderGuardian.BlockBreakingZ);
                    }
                }
            }
            if (this.getAnimationTick() == 50 && CMCommonConfig.EnderGuardian.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), true), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
        }
        if (this.getAnimation() == GUARDIAN_HUG_ME) {
            if (this.getAnimationTick() == 15) {
                this.Teleportparticle();
            }
            if (this.getAnimationTick() == 38) {
                this.AreaAttack(6.0f, 6.0f, 120.0f, 1.0f, (float)CMCommonConfig.EnderGuardian.TeleportAttackHpdamage, 80, 60, 0.6f, false);
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.2f, 0, 10);
            }
        }
        if (this.getAnimation() == GUARDIAN_AIR_STRIKE1) {
            if (this.getAnimationTick() == 20) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.15f, 0, 20);
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.getAnimationTick() == 40) {
                this.playSound(SoundEvents.SHULKER_TELEPORT, 1.0f, 1.0f);
            }
        }
        if (this.getAnimation() == GUARDIAN_AIR_STRIKE2 && this.getAnimationTick() == 3) {
            this.MassDestruction(3.0f, 1.5f, 200);
            this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            this.Attackparticle(2.5f, 1.25f);
            this.Attackparticle(2.5f, -0.5f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
            switch (this.random.nextInt(3)) {
                case 0: {
                    this.StrikeRune(8, 0.5);
                    break;
                }
                case 1: {
                    this.StrikeRune(10, 0.75);
                    break;
                }
                case 2: {
                    this.StrikeRune(12, 1.0);
                    break;
                }
            }
        }
        if ((this.getAnimation() == GUARDIAN_RIGHT_SWING || this.getAnimation() == GUARDIAN_LEFT_SWING) && this.getAnimationTick() == 24) {
            this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 2.0f, 0.5f);
            this.AreaAttack(4.25f, 4.25f, 80.0f, 1.0f, 0.0f, 40, 40, 0.0f, true);
        }
        if (this.getAnimation() == GUARDIAN_BLACKHOLE && this.getAnimationTick() == 26) {
            this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.3f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            this.Attackparticle(1.0f, 0.2f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 10.0f, 0.1f, 0, 5);
        }
        if (this.getAnimation() == GUARDIAN_ROCKETPUNCH) {
            if (this.getAnimationTick() == 24) {
                this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.getAnimationTick() == 28) {
                this.AreaAttack(7.0f, 7.0f, 120.0f, 1.25f, (float)CMCommonConfig.EnderGuardian.RocketPunchHpdamage, 200, 0, 0.0f, true);
            }
        }
    }

    private void StrikeRune(int rune, double time) {
        for (int i = 0; i < rune; ++i) {
            float throwAngle = (float)i * (float)Math.PI / (float)(rune / 2);
            for (int k = 0; k < 8; ++k) {
                double d2 = 1.15 * (double)(k + 1);
                int d3 = (int)(time * (double)(k + 1));
                this.spawnFangs(this.getX() + (double)Mth.cos((float)throwAngle) * 1.25 * d2, this.getZ() + (double)Mth.sin((float)throwAngle) * 1.25 * d2, this.getY(), this.getY() + 2.0, throwAngle, d3);
            }
        }
    }

    public boolean isHelmetless() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        this.setDeltaMovement(0.0, this.getDeltaMovement().y, 0.0);
        if (this.deathTime == 50) {
            this.playSound((SoundEvent)ModSounds.MONSTROSITYLAND.get(), 1.0f, 1.0f);
        }
        if (this.deathTime == 100) {
            this.playSound(SoundEvents.SHULKER_TELEPORT, 1.0f, 1.0f);
        }
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        ServerLevel serverLevel;
        MinecraftServer server;
        ServerLevel targetLevel;
        Level level;
        if (CMCommonConfig.EnderGuardian.respawner && !this.level().isClientSide() && this.getHomePos() != null && (level = this.level()) instanceof ServerLevel && (targetLevel = (server = (serverLevel = (ServerLevel)level).getServer()).getLevel(this.getHomePos().dimension())) != null) {
            this.Respawner(this.getHomePos().pos().getX(), this.getHomePos().pos().getZ(), this.getHomePos().pos().getY() - 10, this.getHomePos().pos().getY(), targetLevel);
        }
    }

    private void Respawner(int x, int z, int minY, int maxY, ServerLevel serverLevel) {
        BlockPos blockpos = new BlockPos(x, maxY, z);
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
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((float)minY) - 1);
        BlockState block = ((Block)ModBlocks.BOSS_RESPAWNER.get()).defaultBlockState();
        int newY = Mth.floor((double)((double)blockpos.getY() + d0));
        BlockPos pos = new BlockPos(x, flag ? newY : maxY, z);
        serverLevel.setBlock(pos, block, 2);
        BlockEntity blockEntity = serverLevel.getBlockEntity(pos);
        if (blockEntity instanceof Boss_Respawn_Spawner_Block_Entity) {
            Boss_Respawn_Spawner_Block_Entity spawnerblockentity = (Boss_Respawn_Spawner_Block_Entity)blockEntity;
            spawnerblockentity.setEntityId((EntityType)ModEntities.ENDER_GUARDIAN.get());
            spawnerblockentity.setTheItem(((Item)ModItems.VOID_EYE.get()).getDefaultInstance());
        }
    }

    @Override
    @Nullable
    public Animation getDeathAnimation() {
        return GUARDIAN_FALLEN;
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks, float airborne, boolean knockback) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || entityHit instanceof Ender_Guardian_Entity) continue;
                boolean flag = entityHit.hurt(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage, (double)(entityHit.getMaxHealth() * hpdamage))));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (airborne > 0.0f) {
                    entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0.0, (double)airborne, 0.0));
                }
                if (flag && stunticks > 0) {
                    entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, stunticks));
                }
                if (!knockback) continue;
                this.launch((Entity)entityHit);
            }
        }
    }

    private void MassDestruction(float grow, float damage, int ticks) {
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate((double)grow))) {
                if (this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ender_Guardian_Entity || entityHit == this) continue;
                entityHit.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage);
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (ticks > 0) {
                        EntityUtil.disableShield(player, ticks);
                    }
                }
                this.launch((Entity)entityHit);
            }
        }
    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor((double)this.getX());
        int MthY = Mth.floor((double)this.getY());
        int MthZ = Mth.floor((double)this.getZ());
        boolean flag = false;
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = -y; j <= -1; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.level().getBlockState(blockpos);
                    if (block == Blocks.AIR.defaultBlockState() || !block.is(ModTag.ENDER_GUARDIAN_CAN_DESTROY) || !block.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)block)) continue;
                    flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
                }
            }
        }
    }

    private void Burstparticle() {
        if (this.level().isClientSide()) {
            double d0 = this.getX();
            double d1 = this.getY() + 2.0;
            double d2 = this.getZ();
            int size = 5;
            for (int i = -size; i <= size; ++i) {
                for (int j = -size; j <= size; ++j) {
                    for (int k = -size; k <= size; ++k) {
                        double d3 = (double)j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                        double d4 = (double)i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                        double d5 = (double)k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5;
                        double d6 = (double)Mth.sqrt((float)((float)(d3 * d3 + d4 * d4 + d5 * d5))) / 0.5 + this.random.nextGaussian() * 0.05;
                        this.level().addParticle((ParticleOptions)ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);
                        if (i == -size || i == size || j == -size || j == size) continue;
                        k += size * 2 - 1;
                    }
                }
            }
        }
    }

    private void Teleportparticle() {
        if (this.level().isClientSide() && this.getTeleportPos().isPresent()) {
            double d0 = this.getTeleportPos().get().getX();
            double d1 = this.getY();
            double d2 = this.getTeleportPos().get().getZ();
            if (this.level().isClientSide()) {
                for (int i1 = 0; i1 < 40 + this.random.nextInt(12); ++i1) {
                    double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
                    float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                    double extraX = 2.0f * Mth.sin((float)((float)(Math.PI + (double)angle)));
                    double extraY = 0.3f;
                    double extraZ = 2.0f * Mth.cos((float)angle);
                    this.level().addParticle((ParticleOptions)ParticleTypes.END_ROD, d0 + extraX, d1 + extraY, d2 + extraZ, 0.0, DeltaMovementY, 0.0);
                }
            }
        }
    }

    private void launch(Entity entityHit) {
        double d0 = entityHit.getX() - this.getX();
        double d1 = entityHit.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
        entityHit.push(d0 / d2 * 4.0, 0.2, d1 / d2 * 4.0);
    }

    private void GravityPull() {
        List<LivingEntity> entities = this.getEntityLivingBaseNearby(12.0, 12.0, 12.0, 12.0);
        for (LivingEntity inRange : entities) {
            if (inRange instanceof Player && ((Player)inRange).getAbilities().invulnerable || this.isAlliedTo((Entity)inRange)) continue;
            float angle = (float)Math.PI / 180 * this.yBodyRot;
            double extraX = Mth.sin((float)((float)(Math.PI + (double)angle)));
            double extraZ = Mth.cos((float)angle);
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            Vec3 diff = inRange.position().subtract(this.position().add(2.0 * vecX + extraX * 0.25, 0.0, 2.0 * vecZ + extraZ * 0.25));
            diff = diff.normalize().scale(0.085);
            inRange.setDeltaMovement(inRange.getDeltaMovement().subtract(diff));
        }
    }

    private void GravityPullparticle() {
        if (this.level().isClientSide()) {
            for (int i1 = 0; i1 < 80 + this.random.nextInt(12); ++i1) {
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = Mth.cos((float)angle);
                double theta = (double)this.yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                double vecZ = Math.sin(theta);
                this.level().addParticle((ParticleOptions)ParticleTypes.PORTAL, this.getX() + 2.2 * vecX + extraX * 0.75, this.getY() + extraY, this.getZ() + 2.2 * vecZ + extraZ * 0.75, (this.random.nextDouble() - 0.5) * 12.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 12.0);
            }
        }
    }

    private void Attackparticle(float vec, float math) {
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
                double extraX = 1.2 * (double)Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = 1.2 * (double)Mth.cos((float)angle);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
            this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 25, 255, 255, 255, 1.0f, 25.0f, false, 2), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.3f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void StompAttack() {
        this.playSound((SoundEvent)ModSounds.ENDER_GUARDIAN_FIST.get(), 0.3f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        LivingEntity target = this.getTarget();
        if (target != null) {
            int k;
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0;
            float f = (float)Mth.atan2((double)(target.getZ() - this.getZ()), (double)(target.getX() - this.getX()));
            float angle2 = (float)Math.PI / 180 * this.yBodyRot;
            for (k = 0; k < 6; ++k) {
                float f2 = angle2 + (float)k * (float)Math.PI * 2.0f / 6.0f + 1.2566371f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f2) * 2.5, this.getZ() + (double)Mth.sin((float)f2) * 2.5, d0, d1, f2, 3);
            }
            for (k = 0; k < 11; ++k) {
                float f3 = angle2 + (float)k * (float)Math.PI * 2.0f / 11.0f + 0.62831855f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f3) * 3.5, this.getZ() + (double)Mth.sin((float)f3) * 3.5, d0, d1, f3, 10);
            }
            for (k = 0; k < 14; ++k) {
                float f4 = angle2 + (float)k * (float)Math.PI * 2.0f / 14.0f + 0.31415927f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f4) * 4.5, this.getZ() + (double)Mth.sin((float)f4) * 4.5, d0, d1, f4, 15);
            }
            float[] all = new float[]{f - 0.4f, f, f + 0.4f};
            float[] all2 = new float[]{f - 0.1f, f + 0.1f};
            switch (this.random.nextInt(3)) {
                case 0: {
                    for (float angle : all) {
                        for (int l = 0; l < 13; ++l) {
                            double d2 = 1.25 * (double)(l + 1);
                            int j = (int)(0.75f * (float)l);
                            this.spawnFangs(this.getX() + (double)Mth.cos((float)angle) * d2, this.getZ() + (double)Mth.sin((float)angle) * d2, d0, d1, angle, j);
                        }
                    }
                    break;
                }
                case 1: {
                    for (float angle : all2) {
                        for (int l = 0; l < 13; ++l) {
                            double d2 = 1.25 * (double)(l + 1);
                            int j = (int)(0.25f * (float)l);
                            this.spawnFangs(this.getX() + (double)Mth.cos((float)angle) * d2, this.getZ() + (double)Mth.sin((float)angle) * d2, d0, d1, angle, j);
                        }
                    }
                    break;
                }
                case 2: {
                    for (int l = 0; l < 13; ++l) {
                        double d2 = 1.25 * (double)(l + 1);
                        int j = (int)(0.5f * (float)l);
                        this.spawnFangs(this.getX() + (double)Mth.cos((float)f) * d2, this.getZ() + (double)Mth.sin((float)f) * d2, d0, d1, f, j);
                    }
                    break;
                }
            }
        }
    }

    private void RageAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            float[] all;
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0;
            float f = (float)Mth.atan2((double)(target.getZ() - this.getZ()), (double)(target.getX() - this.getX()));
            for (float angle : all = new float[]{f - 0.3f, f - 0.6f, f - 0.9f, f, f + 0.3f, f + 0.6f, f + 0.9f}) {
                for (int l = 0; l < 10; ++l) {
                    double d2 = 1.25 * (double)(l + 1);
                    int j = (int)(0.75f * (float)l);
                    this.spawnFangs(this.getX() + (double)Mth.cos((float)angle) * d2, this.getZ() + (double)Mth.sin((float)angle) * d2, d0, d1, angle, j);
                }
            }
        }
    }

    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
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
            this.level().addFreshEntity((Entity)new Void_Rune_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, (float)CMCommonConfig.EnderGuardian.VoidRuneDamage, (LivingEntity)this));
        }
    }

    private void spawnVortex(double x, double z, double minY, double maxY, float rotation) {
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
            this.level().addFreshEntity((Entity)new Void_Vortex_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, (LivingEntity)this, 300));
        }
    }

    private void BrokenHelmet() {
        if (!this.level().isClientSide()) {
            double xx = Mth.cos((float)(this.getYRot() % 360.0f / 180.0f * (float)Math.PI)) * 0.75f;
            double zz = Mth.sin((float)(this.getYRot() % 360.0f / 180.0f * (float)Math.PI)) * 0.75f;
            this.level().explode((Entity)this, this.getX() + xx, this.getY() + (double)this.getEyeHeight(), this.getZ() + zz, 2.0f, Level.ExplosionInteraction.TRIGGER);
        }
    }

    private void Bulletpattern() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            BlockPos tgt = target.blockPosition();
            double tx = tgt.getX();
            double tz = tgt.getZ();
            double ty = target.getY() + 0.1;
            if (this.getAnimationTick() == 54) {
                if (!(target.onGround() || target.isInWater() || this.level().getBlockState(tgt.below()).blocksMotion())) {
                    ty -= 1.0;
                }
                BlockPos Pos = this.blockPosition();
                double sx = Pos.getX();
                double sz = Pos.getZ();
                Direction dir = Direction.getNearest((double)(tx - sx), (double)0.0, (double)(tz - sz));
                double cx = dir.getStepX();
                double cz = dir.getStepZ();
                double offsetangle = Math.toRadians(6.0);
                for (int i = -4; i <= 4; ++i) {
                    double angle = (double)(i - 2) * offsetangle;
                    double x = cx * Math.cos(angle) + cz * Math.sin(angle);
                    double z = -cx * Math.sin(angle) + cz * Math.cos(angle);
                    Vec3 vec3 = new Vec3(x, this.getY() + 2.0, z);
                    Ender_Guardian_Bullet_Entity bullet = new Ender_Guardian_Bullet_Entity(this.level(), (LivingEntity)this, vec3.normalize());
                    bullet.setOwner((Entity)this);
                    bullet.setPos(this.getX(), this.getY() - 2.0 + this.random.nextDouble() * 4.0, this.getZ());
                    bullet.setUp(30, cx, 0.0, cz, tx - 7.0 * cx + (double)i * cz, ty, tz - 7.0 * cz + (double)i * cx);
                    this.level().addFreshEntity((Entity)bullet);
                }
            }
        }
    }

    private boolean teleport(double p_32544_, double p_32545_, double p_32546_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(p_32544_, p_32545_, p_32546_);
        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState((BlockPos)blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }
        BlockState blockstate = this.level().getBlockState((BlockPos)blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {
            EntityTeleportEvent.EnderEntity event = EventHooks.onEnderTeleport((LivingEntity)this, (double)p_32544_, (double)p_32545_, (double)p_32546_);
            if (event.isCanceled()) {
                return false;
            }
            Vec3 vec3 = this.position();
            boolean flag2 = this.ProperTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                this.level().gameEvent((Holder)GameEvent.TELEPORT, vec3, GameEvent.Context.of((Entity)this));
                if (!this.isSilent()) {
                    this.playSound(SoundEvents.SHULKER_TELEPORT, 1.0f, 1.0f);
                }
            }
            return flag2;
        }
        return false;
    }

    public boolean ProperTeleport(double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing((double)p_20985_, (double)p_20986_, (double)p_20987_);
        Level level = this.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;
            while (!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                    continue;
                }
                d3 -= 1.0;
                blockpos = blockpos1;
            }
            if (flag1) {
                this.teleportTo(p_20985_, d3, p_20987_);
                if (level.noCollision((Entity)this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            this.teleportTo(d0, d1, d2);
            return false;
        }
        if (p_20988_) {
            level.broadcastEntityEvent((Entity)this, (byte)46);
        }
        this.getNavigation().stop();
        return true;
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

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().is(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.ENDERGUARDIANHURT.get();
    }

    protected SoundEvent getAmbientSound() {
        return this.getIsHelmetless() ? SoundEvents.SHULKER_AMBIENT : super.getAmbientSound();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.ENDERGUARDIANDEATH.get();
    }

    @Override
    protected boolean canPlayMusic() {
        if (CMCommonConfig.EnderGuardian.SeparatePhaseMusic) {
            if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION) {
                return this.getAnimationTick() > 50 && super.canPlayMusic();
            }
            return super.canPlayMusic();
        }
        return super.canPlayMusic();
    }

    @Override
    public SoundEvent getBossMusic() {
        if (CMCommonConfig.EnderGuardian.SeparatePhaseMusic) {
            return this.getIsHelmetless() || this.getUsedMassDestruction() ? (SoundEvent)ModSounds.ENDERGUARDIAN_MUSIC_2.get() : (SoundEvent)ModSounds.ENDERGUARDIAN_MUSIC_1.get();
        }
        return (SoundEvent)ModSounds.ENDERGUARDIAN_MUSIC_DISC.get();
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

    class PunchAttackGoal
    extends AnimationGoal<Ender_Guardian_Entity> {
        public PunchAttackGoal(Ender_Guardian_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == GUARDIAN_LEFT_ATTACK || animation == GUARDIAN_RIGHT_ATTACK || animation == GUARDIAN_LEFT_STRONG_ATTACK || animation == GUARDIAN_RIGHT_STRONG_ATTACK;
        }

        public void tick() {
            Ender_Guardian_Entity.this.setDeltaMovement(0.0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0.0);
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_LEFT_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 17 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 27 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                }
                if (Ender_Guardian_Entity.this.getAnimationTick() == 24 && target != null && Ender_Guardian_Entity.this.random.nextInt(2) == 0 && Ender_Guardian_Entity.this.distanceTo((Entity)target) <= 4.0f) {
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ender_Guardian_Entity.this, GUARDIAN_LEFT_SWING);
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RIGHT_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 22 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 32 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                }
                if (Ender_Guardian_Entity.this.getAnimationTick() == 26 && target != null && Ender_Guardian_Entity.this.random.nextInt(2) == 0 && Ender_Guardian_Entity.this.distanceTo((Entity)target) <= 4.0f) {
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ender_Guardian_Entity.this, GUARDIAN_RIGHT_SWING);
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_LEFT_STRONG_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 34 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 44 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RIGHT_STRONG_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 39 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                }
            }
        }
    }

    static class VoidVortexGoal
    extends SimpleAnimationGoal<Ender_Guardian_Entity> {
        public VoidVortexGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = ((Ender_Guardian_Entity)this.entity).getTarget();
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() < 26 && target != null) {
                ((Ender_Guardian_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                ((Ender_Guardian_Entity)this.entity).setYRot(((Ender_Guardian_Entity)this.entity).yRotO);
            }
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() == 26 && target != null) {
                double tx = target.getX();
                double ty = target.getY();
                double tz = target.getZ();
                double minY = Math.min(ty, ((Ender_Guardian_Entity)this.entity).getY());
                double maxY = Math.max(ty, ((Ender_Guardian_Entity)this.entity).getY()) + 1.0;
                float angle = (float)Mth.atan2((double)(tz - ((Ender_Guardian_Entity)this.entity).getZ()), (double)(tx - ((Ender_Guardian_Entity)this.entity).getX()));
                ((Ender_Guardian_Entity)this.entity).spawnVortex(tx, tz, minY, maxY, angle);
            }
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() == 37 && target != null && ((Ender_Guardian_Entity)this.entity).distanceToSqr((Entity)target) >= 25.0) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((Ender_Guardian_Entity)this.entity), GUARDIAN_ROCKETPUNCH);
            }
        }
    }

    static class RocketPunchGoal
    extends SimpleAnimationGoal<Ender_Guardian_Entity> {
        public RocketPunchGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = ((Ender_Guardian_Entity)this.entity).getTarget();
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() < 24 && target != null) {
                ((Ender_Guardian_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                ((Ender_Guardian_Entity)this.entity).setYRot(((Ender_Guardian_Entity)this.entity).yRotO);
            }
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() == 24 && target != null) {
                ((Ender_Guardian_Entity)this.entity).setDeltaMovement((target.getX() - ((Ender_Guardian_Entity)this.entity).getX()) * (double)0.3f, 0.0, (target.getZ() - ((Ender_Guardian_Entity)this.entity).getZ()) * (double)0.3f);
            }
        }
    }

    class HugmeGoal
    extends SimpleAnimationGoal<Ender_Guardian_Entity> {
        private final float sensing;
        private final int teleport;
        public double prevX;
        public double prevZ;
        private int newX;
        private int newZ;

        public HugmeGoal(Ender_Guardian_Entity entity, Animation animation, float sensing, int teleport) {
            super(entity, animation);
            this.sensing = sensing;
            this.teleport = teleport;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            super.start();
            LivingEntity target = ((Ender_Guardian_Entity)this.entity).getTarget();
            if (target != null) {
                this.prevX = target.getX();
                this.prevZ = target.getZ();
            }
        }

        public void tick() {
            LivingEntity target = ((Ender_Guardian_Entity)this.entity).getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 40 && target != null) {
                Ender_Guardian_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
                Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            } else {
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
            }
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() == this.teleport - 6 && target != null) {
                double x = target.getX();
                double z = target.getZ();
                double vx = (x - this.prevX) / (double)this.teleport;
                double vz = (z - this.prevZ) / (double)this.teleport;
                this.newX = Mth.floor((double)(x + vx * (double)this.sensing));
                this.newZ = Mth.floor((double)(z + vz * (double)this.sensing));
                ((Ender_Guardian_Entity)this.entity).setTeleportPos(BlockPos.containing((double)this.newX, (double)target.getY(), (double)this.newZ));
            }
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() == this.teleport && target != null && ((Ender_Guardian_Entity)this.entity).getTeleportPos().isPresent()) {
                ((Ender_Guardian_Entity)this.entity).teleport(((Ender_Guardian_Entity)this.entity).getTeleportPos().get().getX(), target.getY(), ((Ender_Guardian_Entity)this.entity).getTeleportPos().get().getZ());
            }
        }
    }

    static class TeleportStrikeGoal
    extends SimpleAnimationGoal<Ender_Guardian_Entity> {
        public TeleportStrikeGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = ((Ender_Guardian_Entity)this.entity).getTarget();
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() < 40) {
                ((Ender_Guardian_Entity)this.entity).setDeltaMovement(0.0, ((Ender_Guardian_Entity)this.entity).getDeltaMovement().y, 0.0);
            }
            if (target != null) {
                ((Ender_Guardian_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                if (((Ender_Guardian_Entity)this.entity).getAnimationTick() == 40) {
                    float y = ((Ender_Guardian_Entity)this.entity).getIsHelmetless() ? 8.0f : 4.0f;
                    ((Ender_Guardian_Entity)this.entity).teleportTo(target.getX(), target.getY() + (double)y, target.getZ());
                }
            }
            if (((Ender_Guardian_Entity)this.entity).getAnimationTick() > 48 && ((Ender_Guardian_Entity)this.entity).onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)((Ender_Guardian_Entity)this.entity), GUARDIAN_AIR_STRIKE2);
            }
        }
    }

    class StompAttackGoal
    extends AnimationGoal<Ender_Guardian_Entity> {
        public StompAttackGoal(Ender_Guardian_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == GUARDIAN_STOMP || animation == GUARDIAN_RAGE_STOMP;
        }

        public void tick() {
            Ender_Guardian_Entity.this.setDeltaMovement(0.0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0.0);
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_STOMP) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 32 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 42 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RAGE_STOMP) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 32 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 42 && Ender_Guardian_Entity.this.getAnimationTick() < 53 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 58 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ender_Guardian_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                }
            }
        }
    }

    class UppercutAndBulletGoal
    extends SimpleAnimationGoal<Ender_Guardian_Entity> {
        public UppercutAndBulletGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 54 && target != null) {
                Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yBodyRot);
            } else {
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() == 26) {
                float f1 = (float)Math.cos(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90.0f));
                if (target != null) {
                    float r = Ender_Guardian_Entity.this.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)7.0f);
                    Ender_Guardian_Entity.this.push((double)f1 * 0.3 * (double)r, 0.0, (double)f2 * 0.3 * (double)r);
                } else {
                    Ender_Guardian_Entity.this.push((double)f1 * 2.0, 0.0, (double)f2 * 2.0);
                }
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() > 32 || Ender_Guardian_Entity.this.getAnimationTick() < 26) {
                Ender_Guardian_Entity.this.setDeltaMovement(0.0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0.0);
            }
            Ender_Guardian_Entity.this.Bulletpattern();
        }
    }

    class RageUppercut
    extends SimpleAnimationGoal<Ender_Guardian_Entity> {
        public RageUppercut(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 54 && Ender_Guardian_Entity.this.getAnimationTick() < 84 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 104 && target != null) {
                Ender_Guardian_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yBodyRot);
            } else {
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() == 26) {
                float f1 = (float)Math.cos(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90.0f));
                if (target != null) {
                    float r = Ender_Guardian_Entity.this.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)7.0f);
                    Ender_Guardian_Entity.this.push((double)f1 * 0.3 * (double)r, 0.0, (double)f2 * 0.3 * (double)r);
                } else {
                    Ender_Guardian_Entity.this.push((double)f1 * 2.0, 0.0, (double)f2 * 2.0);
                }
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() > 32 || Ender_Guardian_Entity.this.getAnimationTick() < 26) {
                Ender_Guardian_Entity.this.setDeltaMovement(0.0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0.0);
            }
            Ender_Guardian_Entity.this.Bulletpattern();
        }
    }
}

