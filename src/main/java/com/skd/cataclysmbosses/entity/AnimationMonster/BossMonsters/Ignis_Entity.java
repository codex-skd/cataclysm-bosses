/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.google.common.collect.ImmutableList
 *  javax.annotation.Nullable
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
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
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.BossEvent$BossBarColor
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
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
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Explosion$BlockInteraction
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.event.EventHooks
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters;

import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.client.particle.Options.RoarParticleOptions;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.HurtByNearestTargetGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackAniamtionGoal3;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackAnimationGoal1;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackAnimationGoal2;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackMoveGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.skd.cataclysmbosses.entity.effect.Cm_Falling_Block_Entity;
import com.skd.cataclysmbosses.entity.effect.Flame_Strike_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.etc.CMBossInfoServer;
import com.skd.cataclysmbosses.entity.etc.IHoldEntity;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.projectile.Ignis_Abyss_Fireball_Entity;
import com.skd.cataclysmbosses.entity.projectile.Ignis_Fireball_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntityDataSerializers;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.message.MessageMusic;
import com.skd.cataclysmbosses.util.CustomExplosion.IgnisExplosion;
import com.skd.cataclysmbosses.util.EntityUtil;
import com.skd.cataclysmbosses.world.data.CMWorldData;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.network.PacketDistributor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Ignis_Entity
extends LLibrary_Boss_Monster
implements IHoldEntity {
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.YELLOW, false, 2);
    public static final Animation SWING_ATTACK = Animation.create((int)55);
    public static final Animation SWING_ATTACK_SOUL = Animation.create((int)46);
    public static final Animation SWING_ATTACK_BERSERK = Animation.create((int)37);
    public static final Animation HORIZONTAL_SWING_ATTACK = Animation.create((int)68);
    public static final Animation HORIZONTAL_SWING_ATTACK_SOUL = Animation.create((int)58);
    public static final Animation SHIELD_SMASH_ATTACK = Animation.create((int)70);
    public static final Animation PHASE_2 = Animation.create((int)68);
    public static final Animation POKE_ATTACK = Animation.create((int)65);
    public static final Animation POKE_ATTACK2 = Animation.create((int)56);
    public static final Animation POKE_ATTACK3 = Animation.create((int)50);
    public static final Animation POKED_ATTACK = Animation.create((int)65);
    public static final Animation PHASE_3 = Animation.create((int)120);
    public static final Animation MAGIC_ATTACK = Animation.create((int)69);
    public static final Animation SMASH_IN_AIR = Animation.create((int)105);
    public static final Animation SMASH = Animation.create((int)47);
    public static final Animation BODY_CHECK_ATTACK1 = Animation.create((int)62);
    public static final Animation BODY_CHECK_ATTACK2 = Animation.create((int)62);
    public static final Animation BODY_CHECK_ATTACK3 = Animation.create((int)62);
    public static final Animation BODY_CHECK_ATTACK4 = Animation.create((int)62);
    public static final Animation BODY_CHECK_ATTACK_SOUL1 = Animation.create((int)45);
    public static final Animation BODY_CHECK_ATTACK_SOUL2 = Animation.create((int)45);
    public static final Animation BODY_CHECK_ATTACK_SOUL3 = Animation.create((int)45);
    public static final Animation BODY_CHECK_ATTACK_SOUL4 = Animation.create((int)45);
    public static final Animation IGNIS_DEATH = Animation.create((int)124);
    public static final Animation COUNTER = Animation.create((int)61);
    public static final Animation STRIKE = Animation.create((int)62);
    public static final Animation COMBO1 = Animation.create((int)102);
    public static final Animation COMBO2 = Animation.create((int)131);
    public static final Animation BREAK_THE_SHIELD = Animation.create((int)87);
    public static final Animation SWING_UPPERCUT = Animation.create((int)65);
    public static final Animation SWING_UPPERSLASH = Animation.create((int)54);
    public static final Animation SPIN_ATTACK = Animation.create((int)38);
    public static final Animation EARTH_SHUDDERS_ATTACK = Animation.create((int)138);
    public static final Animation HORIZONTAL_SMALL_SWING_ATTACK = Animation.create((int)44);
    public static final Animation HORIZONTAL_SMALL_SWING_ALT_ATTACK2 = Animation.create((int)38);
    public static final Animation REINFORCED_SMASH_IN_AIR = Animation.create((int)162);
    public static final Animation REINFORCED_SMASH = Animation.create((int)115);
    public static final Animation REINFORCED_SMASH_IN_AIR_SOUL = Animation.create((int)162);
    public static final Animation REINFORCED_SMASH_SOUL = Animation.create((int)115);
    public static final Animation SHIELD_BREAK_COUNTER = Animation.create((int)53);
    public static final Animation SHIELD_BREAK_STRIKE = Animation.create((int)64);
    public static final Animation ULTIMATE_ATTACK = Animation.create((int)114);
    public static final int UNARMED_COOLDOWN = 200;
    public static final int AIR_SMASH_COOLDOWN = 240;
    public static final int BODY_CHECK_COOLDOWN = 200;
    public static final int POKE_COOLDOWN = 240;
    public static final int CONTER_STRIKE_COOLDOWN = 360;
    public static final int EARTH_SHUDDERS_COOLDOWN = 800;
    public static final int SWORD_DANCE_COOLDOWN = 600;
    public static final int HORIZONTAL_SMALL_SWING_COOLDOWN = 100;
    public static final int HORIZONTAL_SWING_COOLDOWN = 160;
    public static final int MAGIC_COOLDOWN = 300;
    public static final int REINFORCED_SMASH_COOLDOWN = 1800;
    public static final int ULTIMATE_COOLDOWN = 1200;
    private static final EntityDataAccessor<Boolean> IS_BLOCKING = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_SHIELD_BREAK = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> SHIELD_DURABILITY = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_SHIELD = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SHOW_SHIELD = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_SWORD = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> BOSS_PHASE = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<Vec3>> TARGET_VEC = SynchedEntityData.defineId(Ignis_Entity.class, (EntityDataSerializer)((EntityDataSerializer)ModEntityDataSerializers.OPTIONAL_VEC_3.get()));
    private Vec3 prevBladePos = new Vec3(0.0, 0.0, 0.0);
    public Vec3 prevTargetPosition;
    public Vec3 clientTargetPosition;
    private int air_smash_cooldown = 0;
    private int body_check_cooldown = 0;
    private int poke_cooldown = 0;
    private int counter_strike_cooldown = 0;
    private int horizontal_small_swing_cooldown = 0;
    private int horizontal_swing_cooldown = 0;
    private int magic_cooldown = 0;
    private int earth_shudders_cooldown = 0;
    private int sword_dance_cooldown = 0;
    private int reinforced_smash_cooldown = 1800;
    private int ultimate_cooldown = 0;
    private boolean Combo = false;
    private int CanSpin = 0;
    private int timeWithoutTarget;
    private int destroyBlocksTick;
    public float blockingProgress;
    public float swordProgress;
    public float prevblockingProgress;
    public float prevswordProgress;

    public Ignis_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setPathfindingMalus(PathType.LAVA, 8.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Ignis.healthMultiplier, CMCommonConfig.Ignis.attackMultiplier);
        if (world.isClientSide()) {
            this.socketPosArray = new Vec3[]{new Vec3(0.0, 0.0, 0.0)};
        }
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, SWING_ATTACK, SWING_ATTACK_SOUL, SWING_ATTACK_BERSERK, SWING_UPPERCUT, SWING_UPPERSLASH, SPIN_ATTACK, HORIZONTAL_SWING_ATTACK, HORIZONTAL_SWING_ATTACK_SOUL, POKE_ATTACK, POKE_ATTACK2, POKE_ATTACK3, POKED_ATTACK, MAGIC_ATTACK, PHASE_3, SHIELD_SMASH_ATTACK, PHASE_2, BODY_CHECK_ATTACK4, BODY_CHECK_ATTACK3, BODY_CHECK_ATTACK2, BODY_CHECK_ATTACK1, BODY_CHECK_ATTACK_SOUL1, BODY_CHECK_ATTACK_SOUL2, BODY_CHECK_ATTACK_SOUL3, BODY_CHECK_ATTACK_SOUL4, SMASH, COUNTER, STRIKE, SMASH_IN_AIR, BREAK_THE_SHIELD, COMBO1, COMBO2, EARTH_SHUDDERS_ATTACK, HORIZONTAL_SMALL_SWING_ATTACK, HORIZONTAL_SMALL_SWING_ALT_ATTACK2, REINFORCED_SMASH_IN_AIR, REINFORCED_SMASH, REINFORCED_SMASH_IN_AIR_SOUL, REINFORCED_SMASH_SOUL, SHIELD_BREAK_COUNTER, SHIELD_BREAK_STRIKE, ULTIMATE_ATTACK, IGNIS_DEATH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new AttackMoveGoal(this, true, 1.0));
        this.goalSelector.addGoal(1, (Goal)new Hornzontal_SwingGoal(this, HORIZONTAL_SWING_ATTACK, 31, 51, 20, 36));
        this.goalSelector.addGoal(1, (Goal)new Hornzontal_SwingGoal(this, HORIZONTAL_SWING_ATTACK_SOUL, 27, 47, 16, 31));
        this.goalSelector.addGoal(1, (Goal)new PokeGoal(this, POKE_ATTACK, 39, 59, 34, 41, 34, 40));
        this.goalSelector.addGoal(1, (Goal)new PokeGoal(this, POKE_ATTACK2, 33, 53, 28, 35, 28, 34));
        this.goalSelector.addGoal(1, (Goal)new PokeGoal(this, POKE_ATTACK3, 29, 49, 24, 31, 24, 30));
        this.goalSelector.addGoal(1, (Goal)new Combo1(this, COMBO1));
        this.goalSelector.addGoal(1, (Goal)new Combo2(this, COMBO2, 34, 12.0f, 27, 0.3f, 0.3f));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, PHASE_3, 34, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, SWING_UPPERSLASH, 23, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, BREAK_THE_SHIELD, 35, false));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, COMBO1, 10, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, MAGIC_ATTACK, 49, true));
        this.goalSelector.addGoal(1, (Goal)new AttackAnimationGoal1<Ignis_Entity>(this, ULTIMATE_ATTACK, 72, true){

            public void start() {
                super.start();
                float f1 = (float)Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
                float f0 = (float)Mth.atan2((double)f1, (double)f2);
                Ignis_Entity.this.spawnFlameStrike(Ignis_Entity.this.getX(), Ignis_Entity.this.getZ(), Ignis_Entity.this.getY(), Ignis_Entity.this.getY(), f0, 30, 68, 0, 5.0f, true);
            }
        });
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, COUNTER, 55, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, SHIELD_BREAK_COUNTER, 60, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, STRIKE, 34, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<Ignis_Entity>(this, SHIELD_BREAK_STRIKE, 34, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal2<Ignis_Entity>(this, PHASE_2, 34, 54));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<Ignis_Entity>(this, SMASH));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<Ignis_Entity>(this, REINFORCED_SMASH_SOUL));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<Ignis_Entity>(this, REINFORCED_SMASH));
        this.goalSelector.addGoal(1, (Goal)new PredictiveChargeAttackAnimationGoal(this, this, SWING_UPPERCUT, 34, 50, 12.0f, 27, 0.3f, 0.3f));
        this.goalSelector.addGoal(1, (Goal)new Shield_Smash(this, SHIELD_SMASH_ATTACK));
        this.goalSelector.addGoal(1, (Goal)new Poked(this, POKED_ATTACK));
        this.goalSelector.addGoal(1, (Goal)new Air_Smash(this, SMASH_IN_AIR));
        this.goalSelector.addGoal(1, (Goal)new Swing_Attack_Goal(this, SWING_ATTACK, 24, 30));
        this.goalSelector.addGoal(1, (Goal)new Swing_Attack_Goal(this, SWING_ATTACK_SOUL, 18, 24));
        this.goalSelector.addGoal(1, (Goal)new Swing_Attack_Goal(this, SWING_ATTACK_BERSERK, 17, 23));
        this.goalSelector.addGoal(1, (Goal)new Hornzontal_Small_SwingGoal(this, 19, 13, 12, 21));
        this.goalSelector.addGoal(1, (Goal)new Body_Check_Attack(this));
        this.goalSelector.addGoal(1, (Goal)new Earth_Shudders(this, EARTH_SHUDDERS_ATTACK));
        this.goalSelector.addGoal(1, (Goal)new Reinforced_Air_Smash(this));
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByNearestTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, true));
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        LivingEntity target = this.getTarget();
        double range = this.calculateRange(source);
        if (!(entity == null || this.isNoAi() || this.blockingProgress != 10.0f && this.swordProgress != 10.0f)) {
            if (target != null && target.isAlive() && this.getAnimation() == NO_ANIMATION && this.getRandom().nextFloat() * 100.0f < 12.0f && this.counter_strike_cooldown <= 0 && range < 225.0) {
                this.counter_strike_cooldown = 360;
                Animation counter = this.getIsShieldBreak() ? SHIELD_BREAK_COUNTER : COUNTER;
                this.setAnimation(counter);
            }
            if (this.getAnimation() == COUNTER && this.getAnimationTick() > 16 && this.getAnimationTick() <= 46) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this, STRIKE);
                this.playSound(SoundEvents.BLAZE_HURT, 0.5f, 0.4f + this.getRandom().nextFloat() * 0.1f);
                if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    return false;
                }
            }
            if (this.getAnimation() == SHIELD_BREAK_COUNTER && this.getAnimationTick() > 8 && this.getAnimationTick() <= 38) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this, SHIELD_BREAK_STRIKE);
                this.playSound(SoundEvents.BLAZE_HURT, 0.5f, 0.4f + this.getRandom().nextFloat() * 0.1f);
                if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    return false;
                }
            }
        }
        if (source.getDirectEntity() instanceof Ignis_Abyss_Fireball_Entity) {
            if (!(source.getEntity() instanceof Ignis_Entity)) {
                if (source.is(DamageTypeTags.IS_PROJECTILE) && this.getShieldDurability() < 3) {
                    this.playSound((SoundEvent)ModSounds.IGNIS_ARMOR_BREAK.get(), 1.0f, 0.8f);
                    if (!this.level().isClientSide()) {
                        this.setShieldDurability(this.getShieldDurability() + 1);
                    }
                }
            } else {
                return false;
            }
        }
        if ((this.getAnimation() == ULTIMATE_ATTACK || this.getBossPhase() == 1 && this.getHealth() <= this.getMaxHealth() * 1.0f / 3.0f || this.getBossPhase() == 0 && this.getHealth() <= this.getMaxHealth() * 2.0f / 3.0f) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            damage = (float)((double)damage * 0.5);
        }
        if (!(this.getAnimation() != PHASE_3 && this.getAnimation() != PHASE_2 && this.getAnimation() != STRIKE || source.is(DamageTypeTags.BYPASSES_INVULNERABILITY))) {
            return false;
        }
        if (source.getDirectEntity() instanceof Ignis_Fireball_Entity) {
            return false;
        }
        if (damage > 0.0f && this.canBlockDamageSource(source)) {
            this.hurtCurrentlyUsedShield(damage);
            if (!source.is(DamageTypeTags.IS_PROJECTILE) && entity instanceof LivingEntity) {
                this.blockUsingShield((LivingEntity)entity);
            }
            this.playSound(SoundEvents.BLAZE_HURT, 0.5f, 0.4f + this.getRandom().nextFloat() * 0.1f);
            return false;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }
        Crackiness irongolem$crackiness = this.getCrackiness();
        boolean attack = super.hurtOrSimulate(source, damage);
        if (attack && this.getCrackiness() != irongolem$crackiness) {
            this.playSound((SoundEvent)ModSounds.IGNIS_ARMOR_BREAK.get(), 1.0f, 0.8f);
        }
        return attack;
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Vec3 vector3d2;
        Entity entity = damageSourceIn.getDirectEntity();
        boolean flag = false;
        if (entity instanceof Ignis_Abyss_Fireball_Entity && !(damageSourceIn.getEntity() instanceof Ignis_Entity)) {
            flag = true;
        }
        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && !flag && this.getIsShield() && (vector3d2 = damageSourceIn.getSourcePosition()) != null) {
            Vec3 vector3d = this.getViewVector(1.0f);
            Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
            vector3d1 = new Vec3(vector3d1.x, 0.0, vector3d1.z);
            return vector3d1.dot(vector3d) < 0.0;
        }
        return false;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_BLOCKING, false);
        p_326229_.define(IS_SHIELD, false);
        p_326229_.define(IS_SHIELD_BREAK, false);
        p_326229_.define(SHIELD_DURABILITY, 0);
        p_326229_.define(IS_SWORD, false);
        p_326229_.define(SHOW_SHIELD, true);
        p_326229_.define(BOSS_PHASE, 0);
        p_326229_.define(TARGET_VEC, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("BossPhase", this.getBossPhase());
        compound.putBoolean("Is_Shield_Break", this.getIsShieldBreak());
        compound.putInt("Shield_Durability", this.getShieldDurability());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.setBossPhase(compound.getIntOr("BossPhase", 0));
        this.setIsShieldBreak(compound.getBooleanOr("Is_Shield_Break", false));
        this.setShieldDurability(compound.getIntOr("Shield_Durability", 0));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setTargetPosition(@Nullable Vec3 vec3) {
        this.entityData.set(TARGET_VEC, Optional.ofNullable(vec3));
    }

    @Nullable
    public Vec3 getTargetPosition() {
        return ((Optional)this.entityData.get(TARGET_VEC)).orElse(null);
    }

    public void setIsBlocking(boolean isBlocking) {
        if (isBlocking && this.getIsSword()) {
            this.setIsSword(false);
        }
        this.entityData.set(IS_BLOCKING, isBlocking);
    }

    public boolean getIsBlocking() {
        return (Boolean)this.entityData.get(IS_BLOCKING);
    }

    public void setIsShield(boolean isShield) {
        this.entityData.set(IS_SHIELD, isShield);
    }

    public boolean getIsShield() {
        return (Boolean)this.entityData.get(IS_SHIELD);
    }

    public void setIsSword(boolean isSword) {
        if (isSword && this.getIsBlocking()) {
            this.setIsBlocking(false);
        }
        this.entityData.set(IS_SWORD, isSword);
    }

    public boolean getIsSword() {
        return (Boolean)this.entityData.get(IS_SWORD);
    }

    public void setIsShieldBreak(boolean isShieldBreak) {
        if (isShieldBreak) {
            if (this.getIsBlocking()) {
                this.setIsBlocking(false);
                this.setIsSword(true);
            }
            this.setShieldDurability(3);
            this.setShowShield(false);
        }
        this.entityData.set(IS_SHIELD_BREAK, isShieldBreak);
    }

    public boolean getIsShieldBreak() {
        return (Boolean)this.entityData.get(IS_SHIELD_BREAK);
    }

    public void setShieldDurability(int ShieldDurability) {
        this.entityData.set(SHIELD_DURABILITY, ShieldDurability);
    }

    public int getShieldDurability() {
        return (Integer)this.entityData.get(SHIELD_DURABILITY);
    }

    public void setShowShield(boolean showShield) {
        this.entityData.set(SHOW_SHIELD, showShield);
    }

    public boolean getShowShield() {
        return (Boolean)this.entityData.get(SHOW_SHIELD);
    }

    public void setBossPhase(int bossPhase) {
        this.entityData.set(BOSS_PHASE, bossPhase);
    }

    public int getBossPhase() {
        return (Integer)this.entityData.get(BOSS_PHASE);
    }

    public Crackiness getCrackiness() {
        return Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public static AttributeSupplier.Builder ignis() {
        return Ignis_Entity.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 50.0).add(Attributes.MOVEMENT_SPEED, (double)0.33f).add(Attributes.ATTACK_DAMAGE, 14.0).add(Attributes.MAX_HEALTH, 450.0).add(Attributes.ARMOR, 10.0).add(Attributes.STEP_HEIGHT, 2.5).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public float DamageCap() {
        return (float)CMCommonConfig.Ignis.damageCap;
    }

    @Override
    public float NatureRegen() {
        return (float)CMCommonConfig.Ignis.natureHeal;
    }

    @Override
    public float DpsCap() {
        return (float)CMCommonConfig.Ignis.dpsCap;
    }

    @Override
    public double RangeLimit() {
        return CMCommonConfig.Ignis.rangeCap;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0f;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    private void floatStrider() {
        if (this.isInLava()) {
            CollisionContext lvt_1_1_ = CollisionContext.of((Entity)this);
            if (lvt_1_1_.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition().below(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.LAVA)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5).add(0.0, (double)this.random.nextFloat() * 0.5, 0.0));
            }
        }
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 1.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.IGNIS_AMBIENT.get();
    }

    private static Animation getRandomPoke(RandomSource rand) {
        switch (rand.nextInt(3)) {
            case 0: {
                return POKE_ATTACK;
            }
            case 1: {
                return POKE_ATTACK2;
            }
            case 2: {
                return POKE_ATTACK3;
            }
        }
        return POKE_ATTACK;
    }

    private static Animation getRandomReinforced(RandomSource rand) {
        switch (rand.nextInt(2)) {
            case 0: {
                return REINFORCED_SMASH_IN_AIR;
            }
            case 1: {
                return REINFORCED_SMASH_IN_AIR_SOUL;
            }
        }
        return REINFORCED_SMASH_IN_AIR;
    }

    public boolean canStandOnFluid(FluidState p_204067_) {
        return p_204067_.is(FluidTags.LAVA);
    }

    @Nullable
    public Vec3 ClientTargetPosition(float partialTicks) {
        if (this.clientTargetPosition != null && this.prevTargetPosition != null) {
            return this.prevTargetPosition.add(this.clientTargetPosition.subtract(this.prevTargetPosition).scale((double)partialTicks));
        }
        return null;
    }

    @Override
    public void tick() {
        Vec3 EndPos;
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        this.prevblockingProgress = this.blockingProgress;
        this.prevswordProgress = this.swordProgress;
        this.prevTargetPosition = this.clientTargetPosition;
        this.clientTargetPosition = EndPos = this.getTargetPosition();
        this.floatStrider();
        if (this.getIsBlocking() && this.blockingProgress < 10.0f) {
            this.blockingProgress += 1.0f;
        }
        if (!this.getIsBlocking() && this.blockingProgress > 0.0f) {
            this.blockingProgress -= 1.0f;
        }
        if (this.getIsSword() && this.swordProgress < 10.0f) {
            this.swordProgress += 1.0f;
        }
        if (!this.getIsSword() && this.swordProgress > 0.0f) {
            this.swordProgress -= 1.0f;
        }
        if (!this.getPassengers().isEmpty() && ((Entity)this.getPassengers().get(0)).isShiftKeyDown() && this.getAnimation() == POKED_ATTACK) {
            ((Entity)this.getPassengers().get(0)).setShiftKeyDown(false);
        }
        LivingEntity target = this.getTarget();
        this.SwingParticles();
        if (this.level().isClientSide()) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level().playLocalSound(this.getX() + 0.5, this.getY() + 0.5, this.getZ() + 0.5, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0f + this.random.nextFloat(), this.random.nextFloat() * 0.7f + 0.3f, false);
            }
            if (this.getBossPhase() > 1) {
                int n = this.getCrackiness() == Crackiness.NONE ? 5 : (this.getCrackiness() == Crackiness.LOW ? 4 : (i = this.getCrackiness() == Crackiness.MEDIUM ? 3 : 2));
                if (this.random.nextInt(i) == 0) {
                    this.level().addParticle((ParticleOptions)ModParticle.SOUL_LAVA.get(), this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
                }
            } else {
                for (i = 0; i < 2; ++i) {
                    this.level().addParticle((ParticleOptions)ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), 0.0, 0.0, 0.0);
                }
            }
        } else {
            if (this.timeWithoutTarget > 0) {
                --this.timeWithoutTarget;
            }
            if (target != null) {
                this.timeWithoutTarget = 200;
                if (this.getIsShieldBreak()) {
                    this.setIsSword(true);
                } else {
                    this.setIsBlocking(true);
                }
            }
            if (this.getAnimation() == NO_ANIMATION && this.timeWithoutTarget <= 0 && (this.getIsBlocking() || this.getIsSword() && target == null)) {
                this.setIsSword(false);
                this.setIsBlocking(false);
            }
            if (this.getBossPhase() > 0) {
                this.bossInfo.setColor(BossEvent.BossBarColor.BLUE);
                this.bossInfo.setRenderType(3);
            }
            if (this.getBossPhase() > 1) {
                this.bossInfo.setDarkenScreen(true);
                if (this.getAnimation() != PHASE_3) {
                    this.setIsShieldBreak(true);
                }
            }
            if (this.getIsBlocking() && this.blockingProgress == 10.0f) {
                if (this.getAnimation() == NO_ANIMATION) {
                    this.setIsShield(true);
                } else if (this.getAnimation() == COUNTER) {
                    this.setIsShield(true);
                } else if (this.getAnimation() == STRIKE) {
                    this.setIsShield(false);
                } else if (this.getAnimation() == POKED_ATTACK) {
                    this.setIsShield(false);
                } else if (this.getAnimation() == BREAK_THE_SHIELD) {
                    this.setIsShield(false);
                } else if (this.getAnimation() == HORIZONTAL_SWING_ATTACK) {
                    this.setIsShield(this.getAnimationTick() > 31);
                } else if (this.getAnimation() == HORIZONTAL_SWING_ATTACK_SOUL) {
                    this.setIsShield(this.getAnimationTick() > 27);
                } else if (this.getAnimation() == BODY_CHECK_ATTACK1 || this.getAnimation() == BODY_CHECK_ATTACK2 || this.getAnimation() == BODY_CHECK_ATTACK3 || this.getAnimation() == BODY_CHECK_ATTACK4) {
                    this.setIsShield(this.getAnimationTick() < 25);
                } else if (this.getAnimation() == BODY_CHECK_ATTACK_SOUL1 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL2 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL3 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL4) {
                    this.setIsShield(this.getAnimationTick() < 21);
                } else if (this.getAnimation() == POKE_ATTACK) {
                    this.setIsShield(this.getAnimationTick() < 39);
                } else if (this.getAnimation() == POKE_ATTACK2) {
                    this.setIsShield(this.getAnimationTick() < 34);
                } else if (this.getAnimation() == POKE_ATTACK3) {
                    this.setIsShield(this.getAnimationTick() < 29);
                } else if (this.getAnimation() == SWING_ATTACK) {
                    this.setIsShield(this.getAnimationTick() < 24);
                } else if (this.getAnimation() == SWING_ATTACK_SOUL) {
                    this.setIsShield(this.getAnimationTick() < 18);
                } else if (this.getAnimation() == SWING_ATTACK_BERSERK) {
                    this.setIsShield(this.getAnimationTick() < 15);
                } else if (this.getAnimation() == SWING_UPPERSLASH) {
                    this.setIsShield(this.getAnimationTick() > 27);
                } else if (this.getAnimation() == MAGIC_ATTACK) {
                    this.setIsShield(this.getAnimationTick() > 34 && this.getAnimationTick() < 46);
                } else if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
                    this.setIsShield(false);
                } else if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
                    this.setIsShield(false);
                } else if (this.getAnimation() == EARTH_SHUDDERS_ATTACK) {
                    this.setIsShield(false);
                } else if (this.getAnimation() == REINFORCED_SMASH_SOUL || this.getAnimation() == REINFORCED_SMASH) {
                    this.setIsShield(this.getAnimationTick() > 6 && this.getAnimationTick() < 19);
                } else if (this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL || this.getAnimation() == REINFORCED_SMASH_IN_AIR) {
                    this.setIsShield(false);
                }
            } else {
                this.setIsShield(false);
            }
        }
        if (this.body_check_cooldown > 0) {
            --this.body_check_cooldown;
        }
        if (this.air_smash_cooldown > 0) {
            --this.air_smash_cooldown;
        }
        if (this.counter_strike_cooldown > 0) {
            --this.counter_strike_cooldown;
        }
        if (this.poke_cooldown > 0) {
            --this.poke_cooldown;
        }
        if (this.earth_shudders_cooldown > 0) {
            --this.earth_shudders_cooldown;
        }
        if (this.horizontal_small_swing_cooldown > 0) {
            --this.horizontal_small_swing_cooldown;
        }
        if (this.horizontal_swing_cooldown > 0) {
            --this.horizontal_swing_cooldown;
        }
        if (this.magic_cooldown > 0) {
            --this.magic_cooldown;
        }
        if (this.reinforced_smash_cooldown > 0) {
            --this.reinforced_smash_cooldown;
        }
        if (this.sword_dance_cooldown > 0) {
            --this.sword_dance_cooldown;
        }
        if (this.ultimate_cooldown > 0) {
            --this.ultimate_cooldown;
        }
        this.repelEntities(1.4f, 4.0f, 1.4f, 1.4f);
        Animation animation = Ignis_Entity.getRandomPoke(this.random);
        if (this.isAlive()) {
            if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getShieldDurability() > 2 && !this.getIsShieldBreak()) {
                this.setAnimation(BREAK_THE_SHIELD);
            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getHealth() <= this.getMaxHealth() * 2.0f / 3.0f && this.getBossPhase() < 1) {
                this.setAnimation(PHASE_2);
            } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getHealth() <= this.getMaxHealth() * 1.0f / 3.0f && this.getBossPhase() < 2) {
                this.setAnimation(PHASE_3);
            } else if (target != null && target.isAlive()) {
                if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr((Entity)target) <= 225.0 && this.ultimate_cooldown <= 0 && this.getBossPhase() > 1) {
                    this.ultimate_cooldown = 1200;
                    this.setAnimation(ULTIMATE_ATTACK);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr((Entity)target) <= 400.0 && this.reinforced_smash_cooldown <= 0) {
                    this.reinforced_smash_cooldown = 1800;
                    Animation ranimation = Ignis_Entity.getRandomReinforced(this.random);
                    this.setAnimation(ranimation);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr((Entity)target) >= 225.0 && this.distanceToSqr((Entity)target) <= 1024.0 && target.onGround() && this.air_smash_cooldown <= 0) {
                    this.air_smash_cooldown = 240;
                    this.setAnimation(SMASH_IN_AIR);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr((Entity)target) >= 81.0 && this.distanceToSqr((Entity)target) <= 625.0 && this.magic_cooldown <= 0 && this.getRandom().nextFloat() * 100.0f < 1.0f || !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.getRandom().nextFloat() * 100.0f < 10.0f && this.getY() + 5.0 <= target.getY() && this.magic_cooldown <= 0) {
                    this.magic_cooldown = 300;
                    this.setAnimation(MAGIC_ATTACK);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 12.0f && this.distanceTo((Entity)target) > 5.0f && this.poke_cooldown <= 0 && this.getRandom().nextFloat() * 100.0f < 4.0f) {
                    this.poke_cooldown = 240;
                    this.setAnimation(animation);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 12.0f && this.getRandom().nextFloat() * 100.0f < 15.0f && this.poke_cooldown <= 0 && target.hasEffect(ModEffect.EFFECTSTUN)) {
                    this.poke_cooldown = 240;
                    this.setAnimation(animation);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 6.5f && this.getRandom().nextFloat() * 100.0f < 4.0f) {
                    Animation animation2 = this.getBossPhase() > 0 ? HORIZONTAL_SWING_ATTACK_SOUL : HORIZONTAL_SWING_ATTACK;
                    this.horizontal_swing_cooldown = 160;
                    this.setAnimation(animation2);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 4.25f && this.getRandom().nextFloat() * 100.0f < 8.0f) {
                    Animation animation3 = this.getBossPhase() > 1 ? SWING_ATTACK_BERSERK : (this.getBossPhase() > 0 ? SWING_ATTACK_SOUL : SWING_ATTACK);
                    this.setAnimation(animation3);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 5.25f && this.getRandom().nextFloat() * 100.0f < 5.0f && this.getIsShieldBreak() && this.sword_dance_cooldown <= 0) {
                    this.sword_dance_cooldown = this.getBossPhase() > 1 ? 600 : (this.getBossPhase() > 0 ? 720 : 840);
                    this.setAnimation(COMBO1);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 3.0f && this.getRandom().nextFloat() * 100.0f < 20.0f && !this.getIsShieldBreak()) {
                    this.setAnimation(SHIELD_SMASH_ATTACK);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 5.0f && this.getRandom().nextFloat() * 100.0f < 0.7f && this.counter_strike_cooldown <= 0 && !target.hasEffect(ModEffect.EFFECTSTUN)) {
                    this.counter_strike_cooldown = 360;
                    Animation counter = this.getIsShieldBreak() ? SHIELD_BREAK_COUNTER : COUNTER;
                    this.setAnimation(counter);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) > 4.5f && this.distanceTo((Entity)target) < 11.0f && this.earth_shudders_cooldown <= 0 && this.getRandom().nextFloat() * 100.0f < 1.0f && this.getY() >= target.getY() - 2.5 && this.getY() <= target.getY() + 2.5) {
                    this.earth_shudders_cooldown = 800;
                    this.setAnimation(EARTH_SHUDDERS_ATTACK);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 5.5f && this.getRandom().nextFloat() * 100.0f < 15.0f && this.horizontal_small_swing_cooldown <= 0) {
                    this.horizontal_small_swing_cooldown = 100;
                    this.setAnimation(HORIZONTAL_SMALL_SWING_ATTACK);
                } else if ((this.blockingProgress == 10.0f || this.swordProgress == 10.0f) && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo((Entity)target) < 3.0f && this.getRandom().nextFloat() * 100.0f < 10.0f && this.body_check_cooldown <= 0) {
                    this.body_check_cooldown = 200;
                    Animation animation5 = this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL1 : BODY_CHECK_ATTACK1;
                    this.setAnimation(animation5);
                }
            }
        }
        this.blockbreak();
        super.tick();
    }

    public void aiStep() {
        float vec;
        int brand;
        super.aiStep();
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        int n = brand = this.getBossPhase() > 0 ? 240 : 200;
        if (this.getAnimation() == SWING_ATTACK) {
            if (this.getAnimationTick() == 21) {
                this.SwingParticle(vecX, 3.2, vecZ, 2.0, -0.4, 4, 1.7f, (float)Math.toRadians(-this.yBodyRot - 85.0f), (float)Math.toRadians(20.0), (float)Math.toRadians(140.0));
            }
            if (this.getAnimationTick() == 24) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 70.0f, 1.0f, 0.05f, 80, 2, brand, 5, false, 0.0f);
            }
        }
        if (this.getAnimation() == HORIZONTAL_SWING_ATTACK) {
            if (this.getAnimationTick() == 28) {
                this.SwingParticle(vecX, (double)(this.getBbHeight() / 2.0f) + 0.6, vecZ, 1.4, 0.0, 6, 1.8f, (float)Math.toRadians(-this.yBodyRot - 15.0f), (float)Math.toRadians(-80.0), 0.0f);
            }
            if (this.getAnimationTick() == 31) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 210.0f, 1.0f, 0.06f, 120, 3, brand, 5, false, 0.0f);
            }
        }
        if (this.getAnimation() == SWING_ATTACK_SOUL) {
            if (this.getAnimationTick() == 15) {
                this.SwingParticle(vecX, 3.2, vecZ, 2.0, -0.4, 4, 1.7f, (float)Math.toRadians(-this.yBodyRot - 85.0f), (float)Math.toRadians(20.0), (float)Math.toRadians(140.0));
            }
            if (this.getAnimationTick() == 18) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 70.0f, 1.0f, 0.05f, 80, 2, brand, 5, false, 0.0f);
            }
        }
        if (this.getAnimation() == SWING_ATTACK_BERSERK) {
            if (this.getAnimationTick() == 14) {
                this.SwingParticle(vecX, 3.2, vecZ, 2.0, -0.4, 4, 1.7f, (float)Math.toRadians(-this.yBodyRot - 85.0f), (float)Math.toRadians(20.0), (float)Math.toRadians(140.0));
            }
            if (this.getAnimationTick() == 17) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 70.0f, 1.0f, 0.05f, 80, 2, brand, 7, false, 0.0f);
            }
        }
        if (this.getAnimation() == HORIZONTAL_SWING_ATTACK_SOUL) {
            if (this.getAnimationTick() == 24) {
                this.SwingParticle(vecX, (double)(this.getBbHeight() / 2.0f) + 0.6, vecZ, 1.4, 0.0, 6, 1.8f, (float)Math.toRadians(-this.yBodyRot - 15.0f), (float)Math.toRadians(-80.0), 0.0f);
            }
            if (this.getAnimationTick() == 27) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 210.0f, 1.0f, 0.06f, 120, 3, brand, 5, false, 0.0f);
            }
        }
        if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
            if (this.getAnimationTick() == 17) {
                this.SwingParticle(vecX, (double)(this.getBbHeight() / 2.0f) + 0.6, vecZ, 1.4, 0.0, 4, 1.4f, (float)Math.toRadians(-this.yBodyRot), (float)Math.toRadians(-75.0), (float)Math.toRadians(65.0));
            }
            if (this.getAnimationTick() == 19) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 120.0f, 0.4f, 0.03f, 0, 2, brand, 3, true, 0.0f);
            }
        }
        if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
            if (this.getAnimationTick() == 11) {
                this.SwingParticle(vecX, (double)(this.getBbHeight() / 2.0f) + 0.8, vecZ, 1.4, 0.0, 4, 1.4f, (float)Math.toRadians(-this.yBodyRot), (float)Math.toRadians(80.0), (float)Math.toRadians(-75.0));
            }
            if (this.getAnimationTick() == 13) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 120.0f, 0.4f, 0.03f, 40, 2, brand, 3, false, 0.0f);
            }
        }
        if (this.getAnimation() == SPIN_ATTACK) {
            if (this.getAnimationTick() == 13) {
                this.SwingParticle(vecX, (double)(this.getBbHeight() / 2.0f) + 0.6, vecZ, 1.1, 0.0, 6, 1.8f, (float)Math.toRadians(-this.yBodyRot), (float)Math.toRadians(-85.0), (float)Math.toRadians(75.0));
            }
            if (this.getAnimationTick() == 14) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 310.0f, 1.0f, 0.06f, 120, 3, brand, 5, false, 0.3f);
            }
        }
        if (this.getAnimation() == BREAK_THE_SHIELD) {
            int b;
            int r = this.getBossPhase() > 0 ? 2 : 255;
            int g = this.getBossPhase() > 0 ? 199 : 215;
            int n2 = b = this.getBossPhase() > 0 ? 203 : 63;
            if (this.getAnimationTick() == 25) {
                this.setShowShield(false);
                this.ShieldExplode(-2.75f, 1.5f, 2.0f);
            }
            if (this.getAnimationTick() == 79) {
                this.setIsShieldBreak(true);
            }
            if (this.getAnimationTick() == 55) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 50);
                List<LivingEntity> entities = this.getEntityLivingBaseNearby(12.0, 12.0, 12.0, 12.0);
                this.playSound((SoundEvent)ModSounds.FLAME_BURST.get(), 1.0f, 0.8f);
                this.Roarparticle(1.5f, 0.0f, 3.1f, 10, r, g, b, 0.4f, 1.0f, 0.8f, 5.0f);
                if (!this.level().isClientSide()) {
                    for (LivingEntity inRange : entities) {
                        if (inRange instanceof Player && ((Player)inRange).getAbilities().invulnerable || this.isAlliedTo((Entity)inRange)) continue;
                        inRange.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 60));
                    }
                }
            }
            if (this.getAnimationTick() == 58) {
                this.Roarparticle(1.5f, 0.0f, 3.1f, 10, r, g, b, 0.4f, 1.0f, 0.8f, 5.0f);
            }
            if (this.getAnimationTick() == 61) {
                this.Roarparticle(1.5f, 0.0f, 3.1f, 10, r, g, b, 0.4f, 1.0f, 0.8f, 5.0f);
            }
        }
        if (this.getAnimation() == PHASE_2) {
            if (this.getAnimationTick() == 1 && CMCommonConfig.Ignis.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), false), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
            if (this.getAnimationTick() == 21 && CMCommonConfig.Ignis.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), true), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
            if (this.getAnimationTick() == 29) {
                this.playSound((SoundEvent)ModSounds.FLAME_BURST.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.getAnimationTick() > 29 && this.getAnimationTick() < 39) {
                this.Sphereparticle(2.0f, 0.0f, 5.0f);
                this.Phase_Transition(14, 0.4f, 0.03f, 5, 240);
            }
            if (this.getAnimationTick() == 34) {
                this.setBossPhase(1);
            }
        }
        if (this.getAnimation() == PHASE_3) {
            if (this.getAnimationTick() == 1 && CMCommonConfig.Ignis.SeparatePhaseMusic && !this.level().isClientSide() && this.getBossMusic() != null) {
                PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), false), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
            if (this.getAnimationTick() == 58) {
                this.setBossPhase(2);
                this.setShowShield(false);
                if (!this.getIsShieldBreak()) {
                    this.ShieldExplode(2.0f, 0.575f, 2.0f);
                }
                this.playSound((SoundEvent)ModSounds.FLAME_BURST.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.playSound((SoundEvent)ModSounds.SWORD_STOMP.get(), 1.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 10);
                this.ShieldSmashparticle(0.5f, 1.0f, -0.15f);
                if (CMCommonConfig.Ignis.ignoreMobGriefing && !this.level().isClientSide() && this.getBossMusic() != null) {
                    PacketDistributor.sendToAllPlayers((CustomPacketPayload)new MessageMusic(this.getId(), true), (CustomPacketPayload[])new CustomPacketPayload[0]);
                }
            }
            if (this.getAnimationTick() > 58 && this.getAnimationTick() < 68) {
                this.Sphereparticle(0.5f, 1.0f, 6.0f);
                this.Phase_Transition(27, 0.6f, 0.05f, 5, 240);
            }
            if (this.getAnimationTick() == 94) {
                this.SwingParticle(vecX, (double)(this.getBbHeight() / 2.0f) + 0.6, vecZ, 1.1, 0.0, 6, 1.4f, (float)Math.toRadians(-this.yBodyRot - 35.0f), (float)Math.toRadians(-85.0), (float)Math.toRadians(75.0));
            }
        }
        if (this.getAnimation() == SHIELD_SMASH_ATTACK) {
            if (this.getAnimationTick() == 34) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.AreaAttack(4.85f, 2.5f, 45.0f, 1.5f, 0.15f, 200, 0, 0, 5, false, 0.0f);
                this.ShieldSmashparticle(1.3f, 2.75f, -0.1f);
                this.ShieldSmashDamage(2.0f, 4, 1.5f, 2.75f, false, 0, 1.0f, 0.02f, 0.1f);
            }
            if (this.getAnimationTick() == 37) {
                this.ShieldSmashDamage(2.0f, 5, 1.5f, 2.75f, false, 0, 1.0f, 0.02f, 0.1f);
            }
            if (this.getAnimationTick() == 40) {
                this.ShieldSmashDamage(2.0f, 6, 1.5f, 2.75f, false, 0, 1.0f, 0.02f, 0.1f);
            }
        }
        if (this.getAnimation() == SMASH) {
            float math;
            float vec2 = this.getIsShieldBreak() ? 1.8f : 1.5f;
            float radius = this.getIsShieldBreak() ? 0.8f : 1.3f;
            float f = math = this.getIsShieldBreak() ? 0.3f : 0.0f;
            if (this.getAnimationTick() == 5) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.AreaAttack(4.85f, 2.5f, 45.0f, 1.5f, 0.15f, 200, 0, 0, 5, false, 0.0f);
                this.ShieldSmashparticle(radius, vec2, math);
                this.ShieldSmashDamage(2.0f, 3, 1.5f, vec2, false, 0, 1.0f, 0.02f, 0.1f);
            }
            if (this.getAnimationTick() == 8) {
                this.ShieldSmashDamage(2.0f, 4, 1.5f, vec2, false, 0, 1.0f, 0.02f, 0.1f);
            }
            if (this.getAnimationTick() == 11) {
                this.ShieldSmashDamage(2.0f, 5, 1.5f, vec2, false, 0, 1.0f, 0.02f, 0.1f);
            }
            if (this.getAnimationTick() == 14) {
                this.ShieldSmashDamage(2.0f, 6, 1.5f, vec2, false, 0, 1.0f, 0.02f, 0.1f);
            }
        }
        float f = vec = this.getIsShieldBreak() ? 1.5f : 3.0f;
        if (this.getAnimation() == REINFORCED_SMASH) {
            if (this.getAnimationTick() == 5) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                if (!this.level().isClientSide()) {
                    DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.25))) {
                        if (this.isAlliedTo((Entity)entity) || entity instanceof Ignis_Entity || entity == this) continue;
                        entity.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5 + (double)(entity.getMaxHealth() * 0.15f)));
                        if (!entity.isDamageSourceBlocked(damagesource) || !(entity instanceof Player)) continue;
                        Player player = (Player)entity;
                        EntityUtil.disableShield(player, 200);
                    }
                }
                this.ShieldSmashparticle(1.3f, vec, 0.0f);
            }
            if (this.getAnimationTick() == 5) {
                this.ShieldSmashDamage(2.0f, 3, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 7) {
                this.ShieldSmashDamage(2.0f, 4, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 9) {
                this.ShieldSmashDamage(2.0f, 5, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 11) {
                this.ShieldSmashDamage(2.0f, 6, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 13) {
                this.ShieldSmashDamage(2.0f, 7, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 15) {
                this.ShieldSmashDamage(2.0f, 8, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 17) {
                this.ShieldSmashDamage(2.0f, 9, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 19) {
                this.ShieldSmashDamage(2.0f, 10, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 46) {
                this.playSound((SoundEvent)ModSounds.SWORD_STOMP.get(), 1.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 20);
                this.ShieldSmashparticle(0.5f, 2.0f, 0.6f);
                this.AreaAttack(4.85f, 2.5f, 45.0f, 1.5f, 0.15f, 200, 0, 0, 5, false, 0.0f);
                switch (this.random.nextInt(3)) {
                    case 0: {
                        this.shootAbyssFireball(new Vec3(2.0, 3.0, 0.0), 54);
                        this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 41);
                        this.shootFireball(new Vec3(0.0, 3.0, 0.0), 28);
                        break;
                    }
                    case 1: {
                        this.shootFireball(new Vec3(2.0, 3.0, 0.0), 28);
                        this.shootAbyssFireball(new Vec3(-2.0, 3.0, 0.0), 54);
                        this.shootFireball(new Vec3(0.0, 3.0, 0.0), 41);
                        break;
                    }
                    case 2: {
                        this.shootFireball(new Vec3(2.0, 3.0, 0.0), 28);
                        this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 41);
                        this.shootAbyssFireball(new Vec3(0.0, 3.0, 0.0), 54);
                        break;
                    }
                }
            }
            if (this.getAnimationTick() > 46 && this.getAnimationTick() < 56) {
                this.Sphereparticle(0.75f, 2.0f, 6.0f);
            }
            if (this.getAnimationTick() == 46) {
                this.ShieldSmashDamage(2.0f, 16, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 47) {
                this.ShieldSmashDamage(2.0f, 15, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 48) {
                this.ShieldSmashDamage(2.0f, 14, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 49) {
                this.ShieldSmashDamage(2.0f, 13, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 50) {
                this.ShieldSmashDamage(2.0f, 12, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 51) {
                this.ShieldSmashDamage(2.0f, 11, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 52) {
                this.ShieldSmashDamage(2.0f, 10, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 53) {
                this.ShieldSmashDamage(2.0f, 9, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 54) {
                this.ShieldSmashDamage(2.0f, 8, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 55) {
                this.ShieldSmashDamage(2.0f, 7, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 56) {
                this.ShieldSmashDamage(2.0f, 6, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 57) {
                this.ShieldSmashDamage(2.0f, 5, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
        }
        if (this.getAnimation() == REINFORCED_SMASH_SOUL) {
            if (this.getAnimationTick() == 5) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                if (!this.level().isClientSide()) {
                    DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.25))) {
                        if (this.isAlliedTo((Entity)entity) || entity instanceof Ignis_Entity || entity == this) continue;
                        boolean flag = entity.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5 + (double)(entity.getMaxHealth() * 0.15f)));
                        if (!entity.isDamageSourceBlocked(damagesource) || !(entity instanceof Player)) continue;
                        Player player = (Player)entity;
                        EntityUtil.disableShield(player, 200);
                    }
                }
                this.ShieldSmashparticle(1.3f, vec, 0.0f);
            }
            if (this.getAnimationTick() == 5) {
                this.ShieldSmashDamage(2.0f, 16, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 7) {
                this.ShieldSmashDamage(2.0f, 15, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 9) {
                this.ShieldSmashDamage(2.0f, 14, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 11) {
                this.ShieldSmashDamage(2.0f, 13, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 13) {
                this.ShieldSmashDamage(2.0f, 12, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 15) {
                this.ShieldSmashDamage(2.0f, 11, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 17) {
                this.ShieldSmashDamage(2.0f, 10, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 19) {
                this.ShieldSmashDamage(2.0f, 9, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 21) {
                this.ShieldSmashDamage(2.0f, 8, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 23) {
                this.ShieldSmashDamage(2.0f, 7, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 25) {
                this.ShieldSmashDamage(2.0f, 6, 2.5f, vec, true, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 46) {
                this.playSound((SoundEvent)ModSounds.SWORD_STOMP.get(), 1.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 20);
                this.ShieldSmashparticle(0.5f, 2.0f, 0.6f);
                this.AreaAttack(4.85f, 2.5f, 45.0f, 1.5f, 0.15f, 200, 0, 0, 5, false, 0.0f);
                switch (this.random.nextInt(3)) {
                    case 0: {
                        this.shootAbyssFireball(new Vec3(2.0, 3.0, 0.0), 54);
                        this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 41);
                        this.shootFireball(new Vec3(0.0, 3.0, 0.0), 28);
                        break;
                    }
                    case 1: {
                        this.shootFireball(new Vec3(2.0, 3.0, 0.0), 28);
                        this.shootAbyssFireball(new Vec3(-2.0, 3.0, 0.0), 54);
                        this.shootFireball(new Vec3(0.0, 3.0, 0.0), 41);
                        break;
                    }
                    case 2: {
                        this.shootFireball(new Vec3(2.0, 3.0, 0.0), 28);
                        this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 41);
                        this.shootAbyssFireball(new Vec3(0.0, 3.0, 0.0), 54);
                        break;
                    }
                }
            }
            if (this.getAnimationTick() > 46 && this.getAnimationTick() < 56) {
                this.Sphereparticle(0.75f, 2.0f, 6.0f);
            }
            if (this.getAnimationTick() == 48) {
                this.ShieldSmashDamage(2.0f, 3, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 49) {
                this.ShieldSmashDamage(2.0f, 4, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 50) {
                this.ShieldSmashDamage(2.0f, 5, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 51) {
                this.ShieldSmashDamage(2.0f, 6, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 52) {
                this.ShieldSmashDamage(2.0f, 7, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 53) {
                this.ShieldSmashDamage(2.0f, 8, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 54) {
                this.ShieldSmashDamage(2.0f, 9, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
            if (this.getAnimationTick() == 55) {
                this.ShieldSmashDamage(2.0f, 10, 2.5f, 2.0f, false, 80, 1.1f, 0.06f, 0.075f);
            }
        }
        if (this.getAnimation() == REINFORCED_SMASH_IN_AIR) {
            if (this.getAnimationTick() == 23) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(4.5f, 8.0f, 100.0f, 1.0f, 0.1f, 120, 3, brand, 5, false, 0.65f);
            }
            if (this.getAnimationTick() == 53) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 70.0f, 1.1f, 0.1f, 120, 2, brand, 5, false, 0.0f);
            }
            if (this.getAnimationTick() > 74 && this.getAnimationTick() < 81) {
                this.PatternParticle(1.5f, 0.0f, 1.0f, false);
            }
            if (this.getAnimationTick() == 21) {
                this.bladeFireball(2.0f, -1.5f, 5.0f, 30);
            }
            if (this.getAnimationTick() == 23) {
                this.bladeFireball(3.0f, 0.0f, 4.0f, 28);
            }
            if (this.getAnimationTick() == 25) {
                this.bladeFireball(2.0f, 1.5f, 3.0f, 26);
            }
        }
        if (this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL) {
            if (this.getAnimationTick() == 23) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(4.5f, 8.0f, 100.0f, 1.0f, 0.1f, 120, 3, brand, 5, false, 0.65f);
            }
            if (this.getAnimationTick() == 53) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 70.0f, 1.1f, 0.1f, 120, 2, brand, 5, false, 0.0f);
            }
            if (this.getAnimationTick() == 21) {
                this.bladeFireball(2.0f, -1.5f, 5.0f, 30);
            }
            if (this.getAnimationTick() == 23) {
                this.bladeFireball(3.0f, 0.0f, 4.0f, 28);
            }
            if (this.getAnimationTick() == 25) {
                this.bladeFireball(2.0f, 1.5f, 3.0f, 26);
            }
            if (this.getAnimationTick() > 74 && this.getAnimationTick() < 81) {
                this.PatternParticle(1.5f, 0.0f, 1.0f, true);
            }
        }
        if (this.getAnimation() == STRIKE) {
            if (this.getAnimationTick() == 31) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 120.0f, 1.25f, 0.1f, 120, 5, brand, 7, false, 0.0f);
            }
            if (this.getAnimationTick() > 31 && this.getAnimationTick() < 35) {
                this.StrikeParticle(0.75f, 5, 0.0f);
            }
            if (this.getAnimationTick() == 36) {
                this.ShieldSmashDamage(0.75f, 4, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 5, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(4.5f);
            }
            if (this.getAnimationTick() == 38) {
                this.ShieldSmashDamage(0.75f, 6, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 7, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(6.5f);
            }
            if (this.getAnimationTick() == 40) {
                this.ShieldSmashDamage(0.75f, 8, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 9, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(8.5f);
            }
            if (this.getAnimationTick() == 42) {
                this.ShieldSmashDamage(0.75f, 10, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 11, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(10.5f);
            }
            if (this.getAnimationTick() == 44) {
                this.ShieldSmashDamage(0.75f, 12, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 13, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(12.5f);
            }
            if (this.getAnimationTick() == 46) {
                this.ShieldSmashDamage(0.75f, 14, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 15, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(14.5f);
            }
            if (this.getAnimationTick() == 48) {
                this.ShieldSmashDamage(0.75f, 16, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 17, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(16.5f);
            }
        }
        if (this.getAnimation() == SHIELD_BREAK_STRIKE) {
            int b;
            int r = this.getBossPhase() > 0 ? 2 : 255;
            int g = this.getBossPhase() > 0 ? 199 : 215;
            int n3 = b = this.getBossPhase() > 0 ? 203 : 63;
            if (this.getAnimationTick() == 15) {
                this.playSound((SoundEvent)ModSounds.FLAME_BURST.get(), 1.0f, 0.8f);
                this.Roarparticle(1.5f, 0.0f, 3.3f, 10, r, g, b, 0.4f, 1.0f, 0.8f, 5.0f);
            }
            if (this.getAnimationTick() == 18) {
                this.Roarparticle(1.5f, 0.0f, 3.3f, 10, r, g, b, 0.4f, 1.0f, 0.8f, 5.0f);
            }
            if (this.getAnimationTick() == 21) {
                this.Roarparticle(1.5f, 0.0f, 3.3f, 10, r, g, b, 0.4f, 1.0f, 0.8f, 5.0f);
            }
            if (this.getAnimationTick() == 17) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.15f, 0, 50);
                List<LivingEntity> entities = this.getEntityLivingBaseNearby(12.0, 12.0, 12.0, 12.0);
                if (!this.level().isClientSide()) {
                    for (LivingEntity inRange : entities) {
                        if (inRange instanceof Player && ((Player)inRange).getAbilities().invulnerable || this.isAlliedTo((Entity)inRange)) continue;
                        inRange.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 60));
                    }
                }
            }
            if (this.getAnimationTick() == 44) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.0f, 6.0f, 310.0f, 1.25f, 0.1f, 120, 5, brand, 7, false, 0.3f);
            }
            if (this.getAnimationTick() == 49) {
                this.ShieldSmashDamage(0.75f, 4, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 5, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(4.5f);
            }
            if (this.getAnimationTick() == 51) {
                this.ShieldSmashDamage(0.75f, 6, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 7, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(6.5f);
            }
            if (this.getAnimationTick() == 53) {
                this.ShieldSmashDamage(0.75f, 8, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 9, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(8.5f);
            }
            if (this.getAnimationTick() == 55) {
                this.ShieldSmashDamage(0.75f, 10, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 11, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(10.5f);
            }
            if (this.getAnimationTick() == 57) {
                this.ShieldSmashDamage(0.75f, 12, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 13, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(12.5f);
            }
            if (this.getAnimationTick() == 59) {
                this.ShieldSmashDamage(0.75f, 14, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 15, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(14.5f);
            }
            if (this.getAnimationTick() == 61) {
                this.ShieldSmashDamage(0.75f, 16, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.75f, 17, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(16.5f);
            }
            if (this.getAnimationTick() > 44 && this.getAnimationTick() < 48) {
                this.StrikeParticle(0.75f, 5, 0.0f);
            }
        }
        if (this.getAnimation() == POKE_ATTACK) {
            if (this.getAnimationTick() == 37) {
                this.playSound((SoundEvent)ModSounds.IGNIS_POKE.get(), 1.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.getAnimationTick() == 39) {
                this.Poke(7.0f, 70.0f, 160);
            }
        }
        if (this.getAnimation() == POKE_ATTACK2) {
            if (this.getAnimationTick() == 32) {
                this.playSound((SoundEvent)ModSounds.IGNIS_POKE.get(), 1.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.getAnimationTick() == 34) {
                this.Poke(7.0f, 65.0f, 160);
            }
        }
        if (this.getAnimation() == POKE_ATTACK3) {
            if (this.getAnimationTick() == 27) {
                this.playSound((SoundEvent)ModSounds.IGNIS_POKE.get(), 1.0f, 0.75f + this.getRandom().nextFloat() * 0.1f);
            }
            if (this.getAnimationTick() == 29) {
                this.Poke(7.0f, 60.0f, 160);
            }
        }
        if ((this.getAnimation() == BODY_CHECK_ATTACK1 || this.getAnimation() == BODY_CHECK_ATTACK2 || this.getAnimation() == BODY_CHECK_ATTACK3 || this.getAnimation() == BODY_CHECK_ATTACK4) && this.getAnimationTick() == 25) {
            this.BodyCheckAttack(3.0f, 6.0f, 120.0f, 0.8f, 0.03f, 80, 80, 0.2f);
        }
        if ((this.getAnimation() == BODY_CHECK_ATTACK_SOUL1 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL2 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL3 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL4) && this.getAnimationTick() == 21) {
            this.BodyCheckAttack(3.0f, 6.0f, 120.0f, 0.9f, 0.03f, 100, 100, 0.2f);
        }
        if (this.getAnimation() == SWING_UPPERCUT && this.getAnimationTick() == 32) {
            this.BodyCheckAttack(4.5f, 8.0f, 120.0f, 1.0f, 0.03f, 60, 70, 0.8);
        }
        if (this.getAnimation() == SWING_UPPERSLASH) {
            if (this.getAnimationTick() == 24) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(4.5f, 8.0f, 100.0f, 1.0f, 0.05f, 120, 3, brand, 5, false, 0.65f);
            }
            if (this.getAnimationTick() == 26) {
                this.ShieldSmashDamage(0.4f, 3, 2.5f, 0.0f, false, 80, 1.0f, 0.03f, 0.1f);
                this.ShieldSmashDamage(0.4f, 4, 2.5f, 0.0f, false, 80, 1.0f, 0.03f, 0.1f);
                this.earthquakesound(3.5f);
            }
            if (this.getAnimationTick() == 28) {
                this.ShieldSmashDamage(0.4f, 5, 2.5f, 0.0f, false, 80, 1.0f, 0.03f, 0.1f);
                this.ShieldSmashDamage(0.4f, 6, 2.5f, 0.0f, false, 80, 1.0f, 0.03f, 0.1f);
                this.earthquakesound(5.5f);
            }
            if (this.getAnimationTick() == 30) {
                this.ShieldSmashDamage(0.4f, 7, 2.5f, 0.0f, false, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(0.4f, 8, 2.5f, 0.0f, false, 80, 1.0f, 0.03f, 0.1f);
                this.earthquakesound(7.5f);
            }
        }
        if (this.getAnimation() == EARTH_SHUDDERS_ATTACK) {
            if (this.getAnimationTick() == 32) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.AreaAttack(4.0f, 6.0f, 80.0f, 1.2f, 0.08f, 120, 5, brand, 5, false, 0.0f);
                this.ShieldSmashparticle(0.75f, 2.3f, -0.65f);
                for (int l = 7; l >= 4; --l) {
                    this.ShieldSmashDamage(2.0f, l, 3.0f, 2.3f, false, 80, 1.0f, 0.05f, 0.05f);
                }
            }
            if (this.getAnimationTick() == 73) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.AreaAttack(4.0f, 6.0f, 80.0f, 1.2f, 0.08f, 120, 5, brand, 5, false, 0.0f);
                this.ShieldSmashparticle(0.75f, 1.85f, -0.6f);
            }
            if (this.getAnimationTick() == 73) {
                this.ShieldSmashDamage(2.0f, 16, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 15, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 76) {
                this.ShieldSmashDamage(2.0f, 14, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 13, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 79) {
                this.ShieldSmashDamage(2.0f, 12, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 11, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 82) {
                this.ShieldSmashDamage(2.0f, 10, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 9, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 85) {
                this.ShieldSmashDamage(2.0f, 8, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 7, 3.0f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 117) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 20.0f, 0.3f, 0, 20);
                this.ShieldSmashparticle(0.75f, 2.3f, -0.65f);
                this.AreaAttack(4.0f, 6.0f, 80.0f, 1.2f, 0.08f, 120, 5, brand, 5, false, 0.0f);
            }
            if (this.getAnimationTick() == 117) {
                this.ShieldSmashDamage(2.0f, 3, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 4, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 120) {
                this.ShieldSmashDamage(2.0f, 5, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 6, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 123) {
                this.ShieldSmashDamage(2.0f, 7, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 8, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 126) {
                this.ShieldSmashDamage(2.0f, 9, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 10, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 129) {
                this.ShieldSmashDamage(2.0f, 11, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 12, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 132) {
                this.ShieldSmashDamage(2.0f, 13, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 14, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
            if (this.getAnimationTick() == 135) {
                this.ShieldSmashDamage(2.0f, 15, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                this.ShieldSmashDamage(2.0f, 16, 3.0f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
            }
        }
        if (this.getAnimation() == MAGIC_ATTACK && this.getAnimationTick() == 5) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.EVOKER_PREPARE_SUMMON, this.getSoundSource(), 5.0f, 1.4f + this.getRandom().nextFloat() * 0.1f, false);
            switch (this.random.nextInt(5)) {
                case 0: {
                    this.shootAbyssFireball(new Vec3(-5.0, 3.0, 0.0), 109);
                    this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 45);
                    this.shootFireball(new Vec3(0.0, 3.0, 0.0), 61);
                    this.shootFireball(new Vec3(2.0, 3.0, 0.0), 77);
                    this.shootFireball(new Vec3(5.0, 3.0, 0.0), 93);
                    break;
                }
                case 1: {
                    this.shootFireball(new Vec3(-5.0, 3.0, 0.0), 45);
                    this.shootAbyssFireball(new Vec3(-2.0, 3.0, 0.0), 109);
                    this.shootFireball(new Vec3(0.0, 3.0, 0.0), 61);
                    this.shootFireball(new Vec3(2.0, 3.0, 0.0), 77);
                    this.shootFireball(new Vec3(5.0, 3.0, 0.0), 93);
                    break;
                }
                case 2: {
                    this.shootFireball(new Vec3(-5.0, 3.0, 0.0), 45);
                    this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 61);
                    this.shootAbyssFireball(new Vec3(0.0, 3.0, 0.0), 109);
                    this.shootFireball(new Vec3(2.0, 3.0, 0.0), 77);
                    this.shootFireball(new Vec3(5.0, 3.0, 0.0), 93);
                    break;
                }
                case 3: {
                    this.shootFireball(new Vec3(-5.0, 3.0, 0.0), 45);
                    this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 61);
                    this.shootFireball(new Vec3(0.0, 3.0, 0.0), 77);
                    this.shootAbyssFireball(new Vec3(2.0, 3.0, 0.0), 109);
                    this.shootFireball(new Vec3(5.0, 3.0, 0.0), 93);
                    break;
                }
                case 4: {
                    this.shootFireball(new Vec3(-5.0, 3.0, 0.0), 45);
                    this.shootFireball(new Vec3(-2.0, 3.0, 0.0), 61);
                    this.shootFireball(new Vec3(0.0, 3.0, 0.0), 77);
                    this.shootFireball(new Vec3(2.0, 3.0, 0.0), 93);
                    this.shootAbyssFireball(new Vec3(5.0, 3.0, 0.0), 109);
                    break;
                }
            }
        }
        if (this.getAnimation() == ULTIMATE_ATTACK) {
            float f1 = (float)Math.cos(Math.toRadians(this.getYRot() + 90.0f));
            float f2 = (float)Math.sin(Math.toRadians(this.getYRot() + 90.0f));
            float f0 = (float)Mth.atan2((double)f1, (double)f2);
            if (this.getAnimationTick() == 74) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.5f + this.getRandom().nextFloat() * 0.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30.0f, 0.3f, 0, 20);
                LivingEntity target = this.getTarget();
                this.AreaAttack(6.0f, 6.0f, 45.0f, 2.0f, 0.25f, 300, 5, brand, 7, false, 0.0f);
                if (target != null) {
                    double d0 = Math.min(target.getY(), this.getY());
                    double d1 = Math.max(target.getY(), this.getY()) + 1.0;
                    for (int l = 0; l < 8; ++l) {
                        double d2 = 4.25 * (double)(l + 2);
                        int j2 = (int)(1.5f * (float)l);
                        this.spawnFlameStrike(this.getX() + (double)f1 * d2, this.getZ() + (double)f2 * d2, d0, d1, f0, 60, j2, j2, 2.0f, false);
                    }
                } else {
                    for (int l = 0; l < 8; ++l) {
                        double d2 = 4.25 * (double)(l + 2);
                        int j2 = (int)(1.5f * (float)l);
                        this.spawnFlameStrike(this.getX() + (double)f1 * d2, this.getZ() + (double)f2 * d2, this.getY(), this.getY(), f0, 60, j2, j2, 2.0f, false);
                    }
                }
                for (int l = 4; l < 38; ++l) {
                    this.UltimateAttack(l, 3.0f, 1.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -1.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 2.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -2.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 3.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -3.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 4.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -4.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 5.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -5.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 6.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -6.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 7.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -7.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 8.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -8.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, 9.5f, 150, 1.5f, 0.15f, 1.0f);
                    this.UltimateAttack(l, 3.0f, -9.5f, 150, 1.5f, 0.15f, 1.0f);
                }
                this.earthquakesound(10.0f);
            }
        }
        if (this.getAnimation() == COMBO1) {
            if (this.getAnimationTick() == 19) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 90.0f, 0.75f, 0.05f, 60, 2, brand, 5, false, 0.0f);
            }
            if (this.getAnimationTick() == 38) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 120.0f, 0.75f, 0.05f, 60, 2, brand, 5, false, 0.0f);
            }
            if (this.getAnimationTick() == 61) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.0f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 70.0f, 0.75f, 0.05f, 60, 2, brand, 5, false, 0.0f);
            }
            if (this.getAnimationTick() == 76) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(6.5f, 6.0f, 310.0f, 0.75f, 0.05f, 60, 3, brand, 5, false, 0.3f);
            }
        }
        if (this.getAnimation() == COMBO2) {
            if (this.getAnimationTick() == 32) {
                this.BodyCheckAttack(4.5f, 8.0f, 120.0f, 1.0f, 0.03f, 60, 40, 0.8);
            }
            if (this.getAnimationTick() == 59) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 120.0f, 0.4f, 0.03f, 0, 2, brand, 3, false, 0.0f);
            }
            if (this.getAnimationTick() == 74) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 1.25f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 120.0f, 0.4f, 0.03f, 50, 2, brand, 3, false, 0.0f);
            }
            if (this.getAnimationTick() == 108) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                this.AreaAttack(5.25f, 6.0f, 225.0f, 1.25f, 0.1f, 150, 5, brand, 7, false, 0.0f);
            }
            if (this.getAnimationTick() > 108 && this.getAnimationTick() < 112) {
                this.StrikeParticle(1.25f, 5, 0.0f);
            }
            if (this.getAnimationTick() == 108) {
                this.ShieldSmashDamage(1.25f, 3, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(1.25f, 4, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(3.5f);
            }
            if (this.getAnimationTick() == 110) {
                this.ShieldSmashDamage(1.25f, 5, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(1.25f, 6, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(3.5f);
            }
            if (this.getAnimationTick() == 112) {
                this.ShieldSmashDamage(1.25f, 7, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(1.25f, 8, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(3.5f);
            }
            if (this.getAnimationTick() == 114) {
                this.ShieldSmashDamage(1.25f, 9, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(1.25f, 10, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(3.5f);
            }
            if (this.getAnimationTick() == 116) {
                this.ShieldSmashDamage(1.25f, 11, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.ShieldSmashDamage(1.25f, 12, 2.5f, 0.0f, true, 240, 1.1f, 0.12f, 0.1f);
                this.earthquakesound(3.5f);
            }
        }
    }

    private void Roarparticle(float vec, float math, float y, int duration, int r, int g, int b, float a, float start, float inc, float end) {
        if (this.level().isClientSide()) {
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            this.level().addParticle((ParticleOptions)new RoarParticleOptions(duration, r, g, b, a, start, inc, end), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)y, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void blockbreak() {
        if (!this.isNoAi() && !this.level().isClientSide() && this.destroyBlocksTick > 0) {
            --this.destroyBlocksTick;
            if (this.destroyBlocksTick == 0 && EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                boolean flag = false;
                AABB aabb = this.getBoundingBox().inflate(0.2);
                for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)this.getY()), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.IGNIS_IMMUNE) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)blockstate)) continue;
                    flag = this.level().destroyBlock(blockpos, true, (Entity)this) || flag;
                }
                if (flag) {
                    this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                }
            }
        }
    }

    @Override
    @Nullable
    public Animation getDeathAnimation() {
        return IGNIS_DEATH;
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int firetime, int brandticks, int heal, boolean combo, float airborne) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || entityHit instanceof Ignis_Entity) continue;
                boolean flag = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(entityHit.getMaxHealth() * hpdamage)));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                entityHit.igniteForSeconds((float)firetime);
                if (brandticks > 0) {
                    MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, brandticks, i, false, true, true);
                    entityHit.addEffect(effectinstance);
                    this.heal((float)heal * (float)CMCommonConfig.Ignis.HealingMultiplier * (float)(i + 1));
                }
                if (combo && !this.Combo) {
                    this.Combo = true;
                    ++this.CanSpin;
                }
                if (!(airborne > 0.0f)) continue;
                entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0.0, (double)airborne, 0.0));
            }
        }
    }

    private void BodyCheckAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int slowticks, double airborne) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ignis_Entity) continue;
                boolean flag = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(entityHit.getMaxHealth() * hpdamage)));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag) continue;
                this.playSound(SoundEvents.ANVIL_LAND, 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f);
                double d0 = entityHit.getX() - this.getX();
                double d1 = entityHit.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                entityHit.push(d0 / d2 * 2.5, airborne, d1 / d2 * 2.5);
                if (slowticks <= 0) continue;
                entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, slowticks));
            }
        }
    }

    private void Poke(float range, float arc, int shieldbreakticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, range, range, range);
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
                if (!(this.distanceTo((Entity)entityHit) <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ignis_Entity) continue;
                boolean flag = entityHit.hurtOrSimulate(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + entityHit.getMaxHealth() * 0.1f);
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                if (!flag || entityHit.getType().builtInRegistryHolder().is(ModTag.IGNIS_CANT_POKE) || !entityHit.isAlive() || !this.getPassengers().isEmpty()) continue;
                if (entityHit.isShiftKeyDown()) {
                    entityHit.setShiftKeyDown(false);
                }
                entityHit.startRiding((Entity)this, true);
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)this, POKED_ATTACK);
            }
        }
    }

    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        if (this.hasPassenger(passenger)) {
            int tick = 5;
            if (this.getAnimation() == POKED_ATTACK) {
                tick = this.getAnimationTick();
                if (this.getAnimationTick() == 46) {
                    passenger.stopRiding();
                }
            }
            this.yHeadRot = this.yBodyRot;
            float radius = 4.0f;
            float angle = (float)Math.PI / 180 * this.yBodyRot;
            double extraX = radius * Mth.sin((float)((float)(Math.PI + (double)angle)));
            double extraZ = radius * Mth.cos((float)angle);
            double extraY = tick < 10 ? 0.0 : (double)(0.2f * (float)Mth.clamp((int)(tick - 10), (int)0, (int)15));
            moveFunc.accept(passenger, this.getX() + extraX, this.getY() + extraY + (double)1.2f, this.getZ() + extraZ);
            if ((tick - 10) % 4 == 0 && passenger instanceof LivingEntity) {
                boolean flag;
                LivingEntity living = (LivingEntity)passenger;
                if (!this.level().isClientSide() && (flag = living.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), 4.0f + living.getMaxHealth() * 0.02f))) {
                    MobEffectInstance effectinstance1 = living.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        living.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 240, i, false, true, true);
                    living.addEffect(effectinstance);
                    this.heal(2.0f * (float)CMCommonConfig.Ignis.HealingMultiplier * (float)(i + 1));
                }
            }
        }
    }

    public boolean shouldRiderSit() {
        return false;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    private void Flameswing() {
        Vec3 bladePos = this.socketPosArray[0];
        int Density = 4;
        float Randomness = 0.5f;
        double length = this.prevBladePos.subtract(bladePos).length();
        int numClouds = (int)Math.floor(2.0 * length);
        for (int i = 0; i < numClouds; ++i) {
            double x = this.prevBladePos.x + (double)i * (bladePos.x - this.prevBladePos.x) / (double)numClouds;
            double y = this.prevBladePos.y + (double)i * (bladePos.y - this.prevBladePos.y) / (double)numClouds;
            double z = this.prevBladePos.z + (double)i * (bladePos.z - this.prevBladePos.z) / (double)numClouds;
            for (int j = 0; j < Density; ++j) {
                float xOffset = Randomness * (2.0f * this.random.nextFloat() - 1.0f);
                float yOffset = Randomness * (2.0f * this.random.nextFloat() - 1.0f);
                float zOffset = Randomness * (2.0f * this.random.nextFloat() - 1.0f);
                SimpleParticleType type = this.getBossPhase() > 0 ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                this.level().addParticle((ParticleOptions)type, x + (double)xOffset, y + (double)yOffset, z + (double)zOffset, 0.0, 0.0, 0.0);
            }
        }
    }

    private void SwingParticles() {
        if (this.level().isClientSide()) {
            Vec3 bladePos = this.socketPosArray[0];
            if (this.getAnimation() == HORIZONTAL_SWING_ATTACK && this.getAnimationTick() > 27 && this.getAnimationTick() < 33) {
                this.Flameswing();
            }
            if (this.getAnimation() == SWING_ATTACK && this.getAnimationTick() > 15 && this.getAnimationTick() < 27) {
                this.Flameswing();
            }
            if (this.getAnimation() == SWING_ATTACK_BERSERK && this.getAnimationTick() > 12 && this.getAnimationTick() < 17) {
                this.Flameswing();
            }
            if (this.getAnimation() == HORIZONTAL_SWING_ATTACK_SOUL && this.getAnimationTick() > 24 && this.getAnimationTick() < 28) {
                this.Flameswing();
            }
            if (this.getAnimation() == SWING_ATTACK_SOUL && this.getAnimationTick() > 16 && this.getAnimationTick() < 19) {
                this.Flameswing();
            }
            if (this.getAnimation() == PHASE_3 && this.getAnimationTick() > 96 && this.getAnimationTick() < 100) {
                this.Flameswing();
            }
            if (this.getAnimation() == STRIKE && this.getAnimationTick() > 28 && this.getAnimationTick() < 33) {
                this.Flameswing();
            }
            if (this.getAnimation() == SWING_UPPERSLASH && this.getAnimationTick() > 23 && this.getAnimationTick() < 28) {
                this.Flameswing();
            }
            if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK && this.getAnimationTick() > 7) {
                this.Flameswing();
            }
            if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2 && this.getAnimationTick() > 3) {
                this.Flameswing();
            }
            if (this.getAnimation() == SPIN_ATTACK && this.getAnimationTick() > 10 && this.getAnimationTick() < 18) {
                this.Flameswing();
            }
            if ((this.getAnimation() == REINFORCED_SMASH_IN_AIR || this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL) && this.getAnimationTick() > 19 && this.getAnimationTick() < 58) {
                this.Flameswing();
            }
            if (this.getAnimation() == SHIELD_BREAK_STRIKE && this.getAnimationTick() > 37 && this.getAnimationTick() < 49) {
                this.Flameswing();
            }
            if (this.getAnimation() == ULTIMATE_ATTACK && this.getAnimationTick() > 71 && this.getAnimationTick() < 74) {
                this.Flameswing();
            }
            if (this.getAnimation() == COMBO1 && (this.getAnimationTick() > 16 && this.getAnimationTick() < 21 || this.getAnimationTick() > 36 && this.getAnimationTick() < 40 || this.getAnimationTick() > 60 && this.getAnimationTick() < 78)) {
                this.Flameswing();
            }
            if (this.getAnimation() == COMBO2 && (this.getAnimationTick() > 59 && this.getAnimationTick() < 62 || this.getAnimationTick() > 74 && this.getAnimationTick() < 77 || this.getAnimationTick() > 107 && this.getAnimationTick() < 114)) {
                this.Flameswing();
            }
            this.prevBladePos = bladePos;
        }
    }

    private void SwingParticle(double x, double y, double z, double vec, double math, int lifetime, float scale, float yaw, float pitch, float roll) {
        if (this.level().isClientSide()) {
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double d0 = this.getX() + x * vec * (double)this.getScale() + (double)f * math * (double)this.getScale();
            double d1 = this.getY() + y * (double)this.getScale();
            double d2 = this.getZ() + z * vec * (double)this.getScale() + (double)f1 * math * (double)this.getScale();
            if (this.getBossPhase() > 0) {
                // empty if block
            }
        }
    }

    private void ShieldSmashparticle(float radius, float vec, float math) {
        if (this.level().isClientSide()) {
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double theta = (double)this.yBodyRot * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + this.random.nextInt(12); ++i1) {
                double motionX = this.getRandom().nextGaussian() * 0.07;
                double motionY = this.getRandom().nextGaussian() * 0.07;
                double motionZ = this.getRandom().nextGaussian() * 0.07;
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = radius * Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = radius * Mth.cos((float)angle);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), motionX, motionY, motionZ);
            }
            this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 25, 255, 255, 255, 1.0f, 25.0f, false, 0), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.3f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void ShieldExplode(float radius, float math, float y) {
        if (!this.level().isClientSide()) {
            float angle = (float)Math.PI / 180 * this.yBodyRot;
            float f = Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180)));
            float f1 = Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180)));
            double extraX = radius * Mth.sin((float)((float)(Math.PI + (double)angle)));
            double extraZ = radius * Mth.cos((float)angle);
            IgnisExplosion explosion = new IgnisExplosion(this.level(), (Entity)this, null, null, this.getX() + extraX + (double)(f * math), this.getY() + (double)y, this.getZ() + extraZ + (double)(f1 * math), 2.0f, true, Explosion.BlockInteraction.KEEP);
            explosion.explode();
            explosion.finalizeExplosion(this.getBossPhase() > 0 ? 2 : 1, 0.5);
        }
    }

    private void ShieldSmashDamage(float spreadarc, int distance, float mxy, float vec, boolean grab, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        if (!this.level().isClientSide()) {
            double bodyRotRad = (double)this.yBodyRot * (Math.PI / 180);
            double cosBodyRot = Math.cos(bodyRotRad);
            double sinBodyRot = Math.sin(bodyRotRad);
            double facingAngle = bodyRotRad + 1.5707963267948966;
            double commonOffsetX = (double)vec * -sinBodyRot;
            double commonOffsetZ = (double)vec * cosBodyRot;
            double baseX = this.getX() + commonOffsetX;
            double baseZ = this.getZ() + commonOffsetZ;
            int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
            double spread = Math.PI * (double)spreadarc;
            int arcLen = Mth.ceil((double)((double)distance * spread));
            double minY = this.getY() - 1.0;
            double maxY = this.getY() + (double)mxy;
            float factor = 1.0f - (float)distance / 12.0f;
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            float baseDamage = (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage);
            for (int i = 0; i < arcLen; ++i) {
                double thetaRatio = arcLen > 1 ? (double)i / (double)(arcLen - 1) : 0.5;
                double theta = (thetaRatio - 0.5) * spread + facingAngle;
                double vx = Math.cos(theta);
                double vz = Math.sin(theta);
                double px = baseX + vx * (double)distance;
                double pz = baseZ + vz * (double)distance;
                int hitX = Mth.floor((double)px);
                int hitZ = Mth.floor((double)pz);
                BlockPos pos = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(pos);
                int maxDepth = 256;
                for (int depthCount = 0; depthCount < maxDepth && block.getRenderShape() != RenderShape.MODEL; ++depthCount) {
                    pos = pos.below();
                    block = this.level().getBlockState(pos);
                }
                if (block.getRenderShape() != RenderShape.MODEL) {
                    block = Blocks.AIR.defaultBlockState();
                }
                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, block, 10);
                fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
                this.level().addFreshEntity((Entity)fallingBlockEntity);
                if (block.is(ModTag.IGNIS_CAN_DESTROY_CRACKED_BLOCK) && (CMCommonConfig.Ignis.ignoreMobGriefing || EventHooks.canEntityGrief((Level)this.level(), (Entity)this))) {
                    this.level().destroyBlock(pos, false, (Entity)this);
                }
                AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
                List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
                for (LivingEntity entity : hit) {
                    if (this.isAlliedTo((Entity)entity) || entity instanceof Ignis_Entity || entity == this) continue;
                    float finalDamage = baseDamage + entity.getMaxHealth() * hpdamage;
                    boolean flag = entity.hurtOrSimulate(damagesource, finalDamage);
                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                        Player player = (Player)entity;
                        if (shieldbreakticks > 0) {
                            EntityUtil.disableShield(player, shieldbreakticks);
                        }
                    }
                    if (!flag) continue;
                    if (grab) {
                        double magnitude = -4.0;
                        double x = vx * (double)(1.0f - factor) * magnitude;
                        double y = entity.onGround() ? 0.15 : 0.0;
                        double z = vz * (double)(1.0f - factor) * magnitude;
                        entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
                        continue;
                    }
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, (double)(airborne * (float)distance) + this.level().random.nextDouble() * 0.15, 0.0));
                }
            }
        }
    }

    private void UltimateAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        if (!this.level().isClientSide()) {
            double bodyRotRad = (double)this.yBodyRot * (Math.PI / 180);
            double sinRot = Math.sin(bodyRotRad);
            double cosRot = Math.cos(bodyRotRad);
            double extraX = (double)distance * -sinRot;
            double extraZ = (double)distance * cosRot;
            double px = this.getX() + extraX + cosRot * (double)math;
            double pz = this.getZ() + extraZ + sinRot * (double)math;
            int hitY = Mth.floor((double)(this.getBoundingBox().minY - 0.5));
            int hitX = Mth.floor((double)px);
            int hitZ = Mth.floor((double)pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = this.level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth && block.getRenderShape() != RenderShape.MODEL; ++depthCount) {
                pos = pos.below();
                block = this.level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(this.level(), (double)hitX + 0.5, (double)hitY + 1.0, (double)hitZ + 0.5, block, 10);
            fallingBlockEntity.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
            this.level().addFreshEntity((Entity)fallingBlockEntity);
            if (block.is(ModTag.IGNIS_CAN_DESTROY_CRACKED_BLOCK) && (CMCommonConfig.Ignis.ignoreMobGriefing || EventHooks.canEntityGrief((Level)this.level(), (Entity)this))) {
                this.level().destroyBlock(pos, false, (Entity)this);
            }
            double minY = this.getY() - 2.0;
            double maxY = this.getY() + (double)mxy;
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
            if (!hit.isEmpty()) {
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                float baseDamage = (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage;
                for (LivingEntity entity : hit) {
                    if (this.isAlliedTo((Entity)entity) || entity instanceof Ignis_Entity || entity == this) continue;
                    float finalDamage = baseDamage + entity.getMaxHealth() * hpdamage;
                    boolean flag = entity.hurtOrSimulate(damagesource, finalDamage);
                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                        Player player = (Player)entity;
                        if (shieldbreakticks > 0) {
                            EntityUtil.disableShield(player, shieldbreakticks);
                        }
                    }
                    if (!flag) continue;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, (double)airborne + this.level().random.nextDouble() * 0.15, 0.0));
                }
            }
        }
    }

    private void earthquakesound(float distance) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        this.level().playLocalSound(this.getX() + (double)distance * vecX, this.getY(), this.getZ() + (double)distance * vecZ, SoundEvents.TOTEM_USE, this.getSoundSource(), 1.5f, 0.8f + this.getRandom().nextFloat() * 0.1f, false);
    }

    private void StrikeParticle(float spreadarc, int distance, float vec) {
        double perpFacing = (double)this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + 1.5707963267948966;
        double spread = Math.PI * (double)spreadarc;
        int arcLen = Mth.ceil((double)((double)distance * spread));
        for (int i = 0; i < arcLen; ++i) {
            double theta = ((double)i / ((double)arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double vy = Mth.sqrt((float)((float)(vx * (double)distance * vx * (double)distance + vz * (double)distance * vz * (double)distance)));
            double px = this.getX() + vx * (double)distance + (double)vec * Math.cos((double)(this.yBodyRot + 90.0f) * Math.PI / 180.0);
            double pz = this.getZ() + vz * (double)distance + (double)vec * Math.sin((double)(this.yBodyRot + 90.0f) * Math.PI / 180.0);
            if (!this.level().isClientSide() || this.tickCount % 2 != 0) continue;
            for (int i1 = 0; i1 < 80 + this.random.nextInt(12); ++i1) {
                double motionX = 0.2 * Mth.lerp((double)1.0, (double)(vx * (double)distance + 3.0), (double)(vx * (double)distance));
                double motionY = 0.2 * Mth.lerp((double)1.5, (double)(vy * 0.1), (double)(vy * 0.1));
                double motionZ = 0.2 * Mth.lerp((double)1.0, (double)(vz * (double)distance + 3.0), (double)(vz * (double)distance));
                double spreads = 10.0 + this.getRandom().nextDouble() * 2.5;
                double velocity = 0.5 + this.getRandom().nextDouble() * 0.15;
                motionX += this.getRandom().nextGaussian() * (double)0.0075f * spreads;
                motionZ += this.getRandom().nextGaussian() * (double)0.0075f * spreads;
                SimpleParticleType type = this.getBossPhase() > 0 ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                this.level().addParticle((ParticleOptions)type, px, this.getY() + (double)1.3f, pz, motionX *= velocity, motionY, motionZ *= velocity);
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
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_IGNIS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        boolean prev;
        CMWorldData worldData;
        if (living != null && (worldData = CMWorldData.get(this.level(), (ResourceKey<Level>)Level.NETHER)) != null && !(prev = worldData.isIgnisDefeatedOnce())) {
            worldData.setIgnisDefeatedOnce(true);
            Level level = this.level();
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel)level;
                serverLevel.getPlayers(EntitySelector.NO_SPECTATORS).forEach(serverPlayer -> serverPlayer.displayClientMessage((Component)Component.translatable((String)"entity.cataclysm.ignis.defeat_message").withStyle(ChatFormatting.GOLD), true));
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
                        SimpleParticleType type = this.getBossPhase() > 0 ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                        this.level().addParticle((ParticleOptions)type, d0 + (double)vec * vecX, d1, d2 + (double)vec * vecZ, d3 / d6, d4 / d6, d5 / d6);
                        if (i == -size || i == size || j == -size || j == size) continue;
                        k += size * 2.0f - 1.0f;
                    }
                }
            }
        }
    }

    private void PatternParticle(float height, float vec, float size, boolean blue) {
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
                        SimpleParticleType type = blue ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                        this.level().addParticle((ParticleOptions)type, d0 + (double)vec * vecX, d1, d2 + (double)vec * vecZ, d3 / d6, d4 / d6, d5 / d6);
                        if (i == -size || i == size || j == -size || j == size) continue;
                        k += size * 2.0f - 1.0f;
                    }
                }
            }
        }
    }

    private void Phase_Transition(int dist, float damage, float hpdamage, int firetime, int brandticks) {
        if (this.getAnimationTick() % 2 == 0) {
            int distance = this.getAnimationTick() / 2 - dist;
            List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(distance, distance, distance, distance);
            if (!this.level().isClientSide()) {
                DamageSource damagesource = this.damageSources().indirectMagic((Entity)this, (Entity)this);
                for (LivingEntity entityHit : entitiesHit) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)entityHit) || entityHit instanceof Ignis_Entity || entityHit == this || !(flag = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage + (double)(entityHit.getMaxHealth() * hpdamage))))) continue;
                    entityHit.igniteForSeconds((float)firetime);
                    if (brandticks <= 0) continue;
                    MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, brandticks, i, false, true, true);
                    entityHit.addEffect(effectinstance);
                }
            }
        }
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    protected boolean isAffectedByFluids() {
        return false;
    }

    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, EntitySpawnReason p_29680_, @Nullable SpawnGroupData p_29681_) {
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.IGNIS_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.IGNIS_DEATH.get();
    }

    @Override
    protected boolean canPlayMusic() {
        if (CMCommonConfig.Ignis.SeparatePhaseMusic) {
            if (this.getAnimation() == PHASE_2) {
                return this.getAnimationTick() >= 21 && super.canPlayMusic();
            }
            if (this.getAnimation() == PHASE_3) {
                return this.getAnimationTick() >= 58 && super.canPlayMusic();
            }
            return super.canPlayMusic();
        }
        return super.canPlayMusic();
    }

    @Override
    public SoundEvent getBossMusic() {
        if (CMCommonConfig.Ignis.SeparatePhaseMusic) {
            if (this.getBossPhase() >= 2 || this.getBossPhase() == 1 && this.getAnimation() == PHASE_3 && this.getAnimationTick() >= 30) {
                return (SoundEvent)ModSounds.IGNIS_MUSIC_3.get();
            }
            if (this.getBossPhase() == 1 || this.getBossPhase() == 0 && this.getAnimation() == PHASE_2 && this.getAnimationTick() >= 21) {
                return (SoundEvent)ModSounds.IGNIS_MUSIC_2.get();
            }
            return (SoundEvent)ModSounds.IGNIS_MUSIC_1.get();
        }
        return (SoundEvent)ModSounds.IGNIS_MUSIC_DISC.get();
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

    private boolean shouldFollowUp(float Range) {
        LivingEntity target = this.getTarget();
        if (target != null && target.isAlive()) {
            Vec3 betweenEntitiesVec;
            Vec3 targetMoveVec = target.getDeltaMovement();
            boolean targetComingCloser = targetMoveVec.dot(betweenEntitiesVec = this.position().subtract(target.position())) > 0.0;
            return this.distanceTo((Entity)target) < Range || this.distanceTo((Entity)target) < 5.0f + Range && targetComingCloser;
        }
        return false;
    }

    private void shootAbyssFireball(Vec3 shotAt, int timer) {
        shotAt = shotAt.yRot(-this.getYRot() * ((float)Math.PI / 180));
        Ignis_Abyss_Fireball_Entity shot = new Ignis_Abyss_Fireball_Entity(this.level(), (LivingEntity)this);
        shot.setPos(this.getX() - (double)(this.getBbWidth() + 1.0f) * 0.15 * (double)Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180))), this.getY() + 1.0, this.getZ() + (double)(this.getBbWidth() + 1.0f) * 0.15 * (double)Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180))));
        double d0 = shotAt.x;
        double d1 = shotAt.y;
        double d2 = shotAt.z;
        float f = Mth.sqrt((float)((float)(d0 * d0 + d2 * d2))) * 0.35f;
        shot.shoot(d0, d1 + (double)f, d2, 0.25f, 3.0f);
        shot.setUp(timer);
        this.level().addFreshEntity((Entity)shot);
    }

    private void shootFireball(Vec3 shotAt, int timer) {
        shotAt = shotAt.yRot(-this.getYRot() * ((float)Math.PI / 180));
        Ignis_Fireball_Entity shot = new Ignis_Fireball_Entity(this.level(), (LivingEntity)this);
        shot.setPos(this.getX() - (double)(this.getBbWidth() + 1.0f) * 0.15 * (double)Mth.sin((float)(this.yBodyRot * ((float)Math.PI / 180))), this.getY() + 1.0, this.getZ() + (double)(this.getBbWidth() + 1.0f) * 0.15 * (double)Mth.cos((float)(this.yBodyRot * ((float)Math.PI / 180))));
        double d0 = shotAt.x;
        double d1 = shotAt.y;
        double d2 = shotAt.z;
        float f = Mth.sqrt((float)((float)(d0 * d0 + d2 * d2))) * 0.35f;
        shot.shoot(d0, d1 + (double)f, d2, 0.25f, 3.0f);
        shot.setUp(timer);
        if (this.getBossPhase() > 0) {
            shot.setSoul(true);
        }
        this.level().addFreshEntity((Entity)shot);
    }

    private void bladeFireball(float radius, float math, float Y, int timer) {
        Ignis_Fireball_Entity shot = new Ignis_Fireball_Entity(this.level(), (LivingEntity)this);
        float angle = (float)Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)));
        float f1 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180)));
        double extraX = radius * Mth.sin((float)((float)(Math.PI + (double)angle)));
        double extraZ = radius * Mth.cos((float)angle);
        shot.setPos(this.getX() + (double)(f * math) + extraX, this.getY() + (double)Y, this.getZ() + (double)(f1 * math) + extraZ);
        shot.setUp(timer);
        if (this.getBossPhase() > 0) {
            shot.setSoul(true);
        }
        this.level().addFreshEntity((Entity)shot);
    }

    private void spawnFlameStrike(double x, double z, double minY, double maxY, float rotation, int duration, int wait, int delay, float radius, boolean soul) {
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
            this.level().addFreshEntity((Entity)new Flame_Strike_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, duration, wait, delay, radius, soul ? 8.0f : 6.0f, 6.0f, soul, (LivingEntity)this));
        }
    }

    class Hornzontal_SwingGoal
    extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int look2;
        private final int charge;
        private final int bodycheck;

        public Hornzontal_SwingGoal(Ignis_Entity entity, Animation animation, int look1, int look2, int charge, int bodycheck) {
            super(entity, animation);
            this.look1 = look1;
            this.look2 = look2;
            this.charge = charge;
            this.bodycheck = bodycheck;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                boolean flag;
                boolean bl = flag = Ignis_Entity.this.getAnimationTick() < this.look1 || Ignis_Entity.this.getAnimationTick() > this.look2;
                if (flag) {
                    ((Ignis_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    ((Ignis_Entity)this.entity).lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    ((Ignis_Entity)this.entity).getLookControl().setLookAt((Entity)target, 0.0f, 30.0f);
                    ((Ignis_Entity)this.entity).setYRot(((Ignis_Entity)this.entity).yRotO);
                }
            } else {
                ((Ignis_Entity)this.entity).setYRot(((Ignis_Entity)this.entity).yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == this.charge) {
                float f1 = (float)Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
                if (target != null) {
                    float r = Ignis_Entity.this.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)10.0f);
                    Ignis_Entity.this.push((double)f1 * 0.3 * (double)r, 0.0, (double)f2 * 0.3 * (double)r);
                }
            }
            if (Ignis_Entity.this.getAnimationTick() == this.bodycheck && Ignis_Entity.this.shouldFollowUp(3.5f) && Ignis_Entity.this.getRandom().nextInt(3) == 0 && Ignis_Entity.this.body_check_cooldown <= 0) {
                Ignis_Entity.this.body_check_cooldown = 200;
                Animation bodycheck = Ignis_Entity.this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL2 : BODY_CHECK_ATTACK2;
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, bodycheck);
            }
        }
    }

    class PokeGoal
    extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int look2;
        private final int charge;
        private final int bodycheck;
        private final int motion1;
        private final int motion2;

        public PokeGoal(Ignis_Entity entity, Animation animation, int look1, int look2, int charge, int bodycheck, int motion1, int motion2) {
            super(entity, animation);
            this.look1 = look1;
            this.look2 = look2;
            this.charge = charge;
            this.bodycheck = bodycheck;
            this.motion1 = motion1;
            this.motion2 = motion2;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            float f1 = (float)Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            float f2 = (float)Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            if (Ignis_Entity.this.getAnimationTick() < this.look1 && target != null || Ignis_Entity.this.getAnimationTick() > this.look2 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yBodyRot);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == this.charge) {
                if (target != null) {
                    float r = Ignis_Entity.this.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)15.0f);
                    Ignis_Entity.this.push((double)f1 * 0.3 * (double)r, 0.0, (double)f2 * 0.3 * (double)r);
                } else {
                    Ignis_Entity.this.push(f1, 0.0, f2);
                }
            }
            if (Ignis_Entity.this.getAnimationTick() == this.bodycheck && Ignis_Entity.this.shouldFollowUp(3.0f) && Ignis_Entity.this.getRandom().nextInt(2) == 0 && Ignis_Entity.this.body_check_cooldown <= 0) {
                Ignis_Entity.this.body_check_cooldown = 200;
                Animation bodycheck = Ignis_Entity.this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL4 : BODY_CHECK_ATTACK4;
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, bodycheck);
            }
            if (Ignis_Entity.this.getAnimationTick() < this.motion1 || Ignis_Entity.this.getAnimationTick() > this.motion2) {
                Ignis_Entity.this.setDeltaMovement(0.0, Ignis_Entity.this.getDeltaMovement().y, 0.0);
            }
        }
    }

    class Combo1
    extends SimpleAnimationGoal<Ignis_Entity> {
        public Combo1(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            float f1 = (float)Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            float f2 = (float)Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 20 && target != null || Ignis_Entity.this.getAnimationTick() < 62 && Ignis_Entity.this.getAnimationTick() > 44 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == 15 || Ignis_Entity.this.getAnimationTick() == 36 || Ignis_Entity.this.getAnimationTick() == 71) {
                if (target != null) {
                    float r = Ignis_Entity.this.distanceTo((Entity)target);
                    r = Mth.clamp((float)r, (float)0.0f, (float)5.0f);
                    Ignis_Entity.this.push((double)f1 * 0.35 * (double)r, 0.0, (double)f2 * 0.35 * (double)r);
                } else {
                    Ignis_Entity.this.push(f1, 0.0, f2);
                }
            }
            if (Ignis_Entity.this.getAnimationTick() == 84 && target != null) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, COMBO2);
            }
        }
    }

    class Combo2
    extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final float sensing;
        private final int charge;
        private final float motionx;
        private final float motionz;
        public double prevX;
        public double prevZ;

        public Combo2(Ignis_Entity entity, Animation animation, int look1, float sensing, int charge, float motionx, float motionz) {
            super(entity, animation);
            this.look1 = look1;
            this.sensing = sensing;
            this.charge = charge;
            this.motionx = motionx;
            this.motionz = motionz;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            super.start();
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                this.prevX = target.getX();
                this.prevZ = target.getZ();
            }
        }

        public void stop() {
            super.stop();
            ((Ignis_Entity)this.entity).setTargetPosition(null);
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < this.look1 && target != null || Ignis_Entity.this.getAnimationTick() < 59 && Ignis_Entity.this.getAnimationTick() > 43 && target != null || Ignis_Entity.this.getAnimationTick() < 74 && Ignis_Entity.this.getAnimationTick() > 61 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yBodyRot);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (((Ignis_Entity)this.entity).getAnimationTick() < this.charge && target != null) {
                double x = target.getX();
                double z = target.getZ();
                double vx = (x - this.prevX) / (double)this.charge;
                double vz = (z - this.prevZ) / (double)this.charge;
                Vec3 vec3 = new Vec3((double)Mth.floor((double)(x + vx * (double)this.sensing)), 0.0, (double)Mth.floor((double)(z + vz * (double)this.sensing)));
                ((Ignis_Entity)this.entity).setTargetPosition(vec3);
            }
            if (((Ignis_Entity)this.entity).getAnimationTick() == this.charge) {
                if (((Ignis_Entity)this.entity).getTargetPosition() != null) {
                    ((Ignis_Entity)this.entity).setDeltaMovement((((Ignis_Entity)this.entity).getTargetPosition().x - ((Ignis_Entity)this.entity).getX()) * (double)this.motionx, 0.0, (((Ignis_Entity)this.entity).getTargetPosition().z - ((Ignis_Entity)this.entity).getZ()) * (double)this.motionz);
                }
                ((Ignis_Entity)this.entity).setTargetPosition(null);
            }
            float f1 = (float)Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            float f2 = (float)Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            if (Ignis_Entity.this.getAnimationTick() == 55 || Ignis_Entity.this.getAnimationTick() == 70) {
                if (target != null) {
                    if (Ignis_Entity.this.distanceTo((Entity)target) > 3.5f) {
                        Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                    }
                } else {
                    Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                }
            }
        }
    }

    class PredictiveChargeAttackAnimationGoal
    extends SimpleAnimationGoal<Ignis_Entity> {
        protected LivingEntity target;
        private final int look1;
        private final int look2;
        private final float sensing;
        private final int charge;
        private final float motionx;
        private final float motionz;
        public double prevX;
        public double prevZ;

        public PredictiveChargeAttackAnimationGoal(Ignis_Entity this$0, Ignis_Entity entity, Animation animation, int look1, int look2, float sensing, int charge, float motionx, float motionz) {
            super(entity, animation);
            this.look1 = look1;
            this.look2 = look2;
            this.sensing = sensing;
            this.charge = charge;
            this.motionx = motionx;
            this.motionz = motionz;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            super.start();
            this.target = ((Ignis_Entity)this.entity).getTarget();
            if (this.target != null) {
                this.prevX = this.target.getX();
                this.prevZ = this.target.getZ();
            }
        }

        public void stop() {
            super.stop();
            ((Ignis_Entity)this.entity).setTargetPosition(null);
        }

        public void tick() {
            if (((Ignis_Entity)this.entity).getAnimationTick() < this.look1 && this.target != null || ((Ignis_Entity)this.entity).getAnimationTick() > this.look2 && this.target != null) {
                ((Ignis_Entity)this.entity).getLookControl().setLookAt((Entity)this.target, 30.0f, 30.0f);
                ((Ignis_Entity)this.entity).setYRot(((Ignis_Entity)this.entity).yBodyRot);
            } else {
                ((Ignis_Entity)this.entity).setYRot(((Ignis_Entity)this.entity).yRotO);
            }
            if (((Ignis_Entity)this.entity).getAnimationTick() < this.charge && this.target != null) {
                double x = this.target.getX();
                double z = this.target.getZ();
                double vx = (x - this.prevX) / (double)this.charge;
                double vz = (z - this.prevZ) / (double)this.charge;
                Vec3 vec3 = new Vec3((double)Mth.floor((double)(x + vx * (double)this.sensing)), 0.0, (double)Mth.floor((double)(z + vz * (double)this.sensing)));
                ((Ignis_Entity)this.entity).setTargetPosition(vec3);
            }
            if (((Ignis_Entity)this.entity).getAnimationTick() == this.charge) {
                if (((Ignis_Entity)this.entity).getTargetPosition() != null) {
                    ((Ignis_Entity)this.entity).setDeltaMovement((((Ignis_Entity)this.entity).getTargetPosition().x - ((Ignis_Entity)this.entity).getX()) * (double)this.motionx, 0.0, (((Ignis_Entity)this.entity).getTargetPosition().z - ((Ignis_Entity)this.entity).getZ()) * (double)this.motionz);
                }
                ((Ignis_Entity)this.entity).setTargetPosition(null);
            }
        }
    }

    class Shield_Smash
    extends SimpleAnimationGoal<Ignis_Entity> {
        public Shield_Smash(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 34 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            Ignis_Entity.this.setDeltaMovement(0.0, Ignis_Entity.this.getDeltaMovement().y, 0.0);
            if (Ignis_Entity.this.getAnimationTick() == 45 && Ignis_Entity.this.shouldFollowUp(4.0f) && Ignis_Entity.this.getRandom().nextInt(3) == 0 && Ignis_Entity.this.body_check_cooldown <= 0) {
                Ignis_Entity.this.body_check_cooldown = 200;
                Animation bodycheck = Ignis_Entity.this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL3 : BODY_CHECK_ATTACK3;
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, bodycheck);
            }
        }
    }

    class Poked
    extends SimpleAnimationGoal<Ignis_Entity> {
        public Poked(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 20.0f, 20.0f);
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            }
            Ignis_Entity.this.setDeltaMovement(0.0, Ignis_Entity.this.getDeltaMovement().y, 0.0);
        }
    }

    class Air_Smash
    extends SimpleAnimationGoal<Ignis_Entity> {
        public Air_Smash(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            }
            if (Ignis_Entity.this.getAnimationTick() == 19) {
                if (target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.15, 1.3, (target.getZ() - Ignis_Entity.this.getZ()) * 0.15);
                } else {
                    Ignis_Entity.this.setDeltaMovement(0.0, 1.4, 0.0);
                }
            }
            if (Ignis_Entity.this.getAnimationTick() > 19 && Ignis_Entity.this.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, SMASH);
            }
        }
    }

    class Swing_Attack_Goal
    extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int follow_through_tick;

        public Swing_Attack_Goal(Ignis_Entity entity, Animation animation, int look1, int follow_through_tick) {
            super(entity, animation);
            this.look1 = look1;
            this.follow_through_tick = follow_through_tick;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < this.look1 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == this.follow_through_tick && Ignis_Entity.this.getRandom().nextInt(2) == 0 && target != null) {
                if (Ignis_Entity.this.distanceTo((Entity)target) <= 6.0f) {
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, SWING_UPPERSLASH);
                } else {
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, SWING_UPPERCUT);
                }
            }
            Ignis_Entity.this.setDeltaMovement(0.0, Ignis_Entity.this.getDeltaMovement().y, 0.0);
        }
    }

    class Hornzontal_Small_SwingGoal
    extends AnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int look2;
        private final int look3;
        private final int follow_through_tick;

        public Hornzontal_Small_SwingGoal(Ignis_Entity entity, int look1, int look2, int look3, int follow_through_tick) {
            super(entity);
            this.look1 = look1;
            this.look2 = look2;
            this.look3 = look3;
            this.follow_through_tick = follow_through_tick;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == HORIZONTAL_SMALL_SWING_ALT_ATTACK2 || animation == HORIZONTAL_SMALL_SWING_ATTACK || animation == SPIN_ATTACK;
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            float f1 = (float)Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            float f2 = (float)Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90.0f));
            if (Ignis_Entity.this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
                if (Ignis_Entity.this.getAnimationTick() < this.look1 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 14) {
                    if (target != null) {
                        if (Ignis_Entity.this.distanceTo((Entity)target) > 3.5f) {
                            Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                        }
                    } else {
                        Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                    }
                }
                if (Ignis_Entity.this.Combo && Ignis_Entity.this.getAnimationTick() == this.follow_through_tick) {
                    Ignis_Entity.this.Combo = false;
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, HORIZONTAL_SMALL_SWING_ALT_ATTACK2);
                }
            }
            if (Ignis_Entity.this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
                if (Ignis_Entity.this.getAnimationTick() < this.look2 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 10) {
                    if (target != null) {
                        if (Ignis_Entity.this.distanceTo((Entity)target) > 3.5f) {
                            Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                        }
                    } else {
                        Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                    }
                }
                if (Ignis_Entity.this.getAnimationTick() == this.follow_through_tick && Ignis_Entity.this.CanSpin >= 2) {
                    Ignis_Entity.this.CanSpin = 0;
                    AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, SPIN_ATTACK);
                }
            }
            if (Ignis_Entity.this.getAnimation() == SPIN_ATTACK) {
                if (Ignis_Entity.this.getAnimationTick() < this.look3 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 10) {
                    Ignis_Entity.this.push((double)f1 * 1.5, 0.0, (double)f2 * 1.5);
                }
            }
        }
    }

    class Body_Check_Attack
    extends AnimationGoal<Ignis_Entity> {
        public Body_Check_Attack(Ignis_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == BODY_CHECK_ATTACK1 || animation == BODY_CHECK_ATTACK2 || animation == BODY_CHECK_ATTACK3 || animation == BODY_CHECK_ATTACK4 || animation == BODY_CHECK_ATTACK_SOUL1 || animation == BODY_CHECK_ATTACK_SOUL2 || animation == BODY_CHECK_ATTACK_SOUL3 || animation == BODY_CHECK_ATTACK_SOUL4;
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL1 || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL2 || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL3 || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL4) {
                if (Ignis_Entity.this.getAnimationTick() < 21 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yBodyRot);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 16 && target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * (double)0.4f, 0.0, (target.getZ() - Ignis_Entity.this.getZ()) * (double)0.4f);
                }
            }
            if (Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK1 || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK2 || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK3 || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK4) {
                if (Ignis_Entity.this.getAnimationTick() < 25 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yBodyRot);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 20 && target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.25, 0.0, (target.getZ() - Ignis_Entity.this.getZ()) * 0.25);
                }
            }
        }
    }

    class Earth_Shudders
    extends SimpleAnimationGoal<Ignis_Entity> {
        public Earth_Shudders(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            Ignis_Entity.this.setDeltaMovement(0.0, Ignis_Entity.this.getDeltaMovement().y, 0.0);
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 31 && target != null || Ignis_Entity.this.getAnimationTick() < 73 && Ignis_Entity.this.getAnimationTick() > 45 && target != null || Ignis_Entity.this.getAnimationTick() < 117 && Ignis_Entity.this.getAnimationTick() > 89 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
        }
    }

    class Reinforced_Air_Smash
    extends AnimationGoal<Ignis_Entity> {
        public Reinforced_Air_Smash(Ignis_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == REINFORCED_SMASH_IN_AIR_SOUL || animation == REINFORCED_SMASH_IN_AIR;
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 25 && target != null || Ignis_Entity.this.getAnimationTick() < 55 && Ignis_Entity.this.getAnimationTick() > 36 && target != null || Ignis_Entity.this.getAnimationTick() < 85 && Ignis_Entity.this.getAnimationTick() > 66 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            } else if (Ignis_Entity.this.getAnimationTick() >= 83 && target != null) {
                Ignis_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == 84) {
                if (target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.15, 1.3, (target.getZ() - Ignis_Entity.this.getZ()) * 0.15);
                } else {
                    Ignis_Entity.this.setDeltaMovement(0.0, 1.8, 0.0);
                }
            }
            if (Ignis_Entity.this.getAnimation() == REINFORCED_SMASH_IN_AIR && Ignis_Entity.this.getAnimationTick() > 84 && Ignis_Entity.this.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, REINFORCED_SMASH);
            }
            if (Ignis_Entity.this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL && Ignis_Entity.this.getAnimationTick() > 84 && Ignis_Entity.this.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage((Entity)Ignis_Entity.this, REINFORCED_SMASH_SOUL);
            }
        }
    }

    public static enum Crackiness {
        NONE(1.0f),
        LOW(0.3f),
        MEDIUM(0.2f),
        HIGH(0.1f);

        private static final List<Crackiness> BY_DAMAGE;
        private final float fraction;

        private Crackiness(float p_28900_) {
            this.fraction = p_28900_;
        }

        public static Crackiness byFraction(float p_28902_) {
            for (Crackiness ignis$crackiness : BY_DAMAGE) {
                if (!(p_28902_ < ignis$crackiness.fraction)) continue;
                return ignis$crackiness;
            }
            return NONE;
        }

        static {
            BY_DAMAGE = (List)Stream.of(Crackiness.values()).sorted(Comparator.comparingDouble(p_28904_ -> p_28904_.fraction)).collect(ImmutableList.toImmutableList());
        }
    }
}

