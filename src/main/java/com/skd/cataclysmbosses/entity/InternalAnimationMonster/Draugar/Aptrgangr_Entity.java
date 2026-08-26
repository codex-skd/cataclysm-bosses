/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.BodyRotationControl
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.animal.SnowGolem
 *  net.minecraft.world.entity.item.FallingBlockEntity
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.monster.Creeper
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.npc.AbstractVillager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.vehicle.DismountHelper
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.CollisionGetter
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Fallable
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar;

import com.skd.cataclysmbosses.blocks.PointedIcicleBlock;
import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.EntityAINearestTarget3D;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.etc.IHoldEntity;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.projectile.Axe_Blade_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.message.MessageEntityCameraSwitch;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import com.skd.cataclysmbosses.util.EntityUtil;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Aptrgangr_Entity
extends Internal_Animation_Monster
implements IHoldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingrightAnimationState = new AnimationState();
    public AnimationState smashAnimationState = new AnimationState();
    public AnimationState chargestartAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState chargehitAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int earthquake_cooldown = 0;
    public static final int EARTHQUAKE_COOLDOWN = 80;
    private boolean chubu = false;
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;
    protected final int NATURE_HEAL_COOLDOWN = 80;
    private int self_regen;

    public Aptrgangr_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 60;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.Aptrgangr.healthMultiplier, CMCommonConfig.Aptrgangr.attackMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0, 80));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<Player>((Mob)this, Player.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, AbstractVillager.class, false));
        this.goalSelector.addGoal(4, (Goal)new InternalMoveGoal(this, false, 1.0));
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 1, 0, 40, 15, 4.5f){

            @Override
            public boolean canUse() {
                return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0f < 22.0f;
            }
        });
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 2, 0, 40, 10, 6.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0f < 16.0f && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.earthquake_cooldown = 80;
            }
        });
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 2, 0, 40, 10, 12.0f){

            @Override
            public boolean canUse() {
                LivingEntity target = this.entity.getTarget();
                return super.canUse() && target != null && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0f < 22.0f && this.entity.distanceTo((Entity)target) > 6.0f && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.earthquake_cooldown = 80;
            }
        });
        this.goalSelector.addGoal(3, (Goal)new InternalAttackGoal(this, 0, 3, 4, 24, 24, 15.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0f < 8.0f && Aptrgangr_Entity.this.charge_cooldown <= 0;
            }
        });
        this.goalSelector.addGoal(2, (Goal)new InternalStateGoal(this, 4, 4, 5, 40, 0){

            @Override
            public void tick() {
                if (this.entity.onGround()) {
                    Vec3 vector3d = this.entity.getDeltaMovement();
                    float f = this.entity.getYRot() * ((float)Math.PI / 180);
                    Vec3 vector3d1 = new Vec3((double)(-Mth.sin((float)f)), this.entity.getDeltaMovement().y, (double)Mth.cos((float)f)).scale(1.0).add(vector3d.scale(0.5));
                    this.entity.setDeltaMovement(vector3d1.x, this.entity.getDeltaMovement().y, vector3d1.z);
                }
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && !Aptrgangr_Entity.this.chubu;
            }

            @Override
            public void stop() {
                if (Aptrgangr_Entity.this.chubu) {
                    this.entity.setAttackState(6);
                    Aptrgangr_Entity.this.chubu = false;
                } else {
                    super.stop();
                }
            }
        });
        this.goalSelector.addGoal(1, (Goal)new InternalStateGoal(this, 5, 5, 0, 23, 0){

            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.charge_cooldown = 160;
            }
        });
        this.goalSelector.addGoal(0, (Goal)new InternalStateGoal(this, 6, 6, 0, 18, 0){

            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.charge_cooldown = 160;
            }
        });
    }

    public static AttributeSupplier.Builder aptrgangr() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 30.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 18.0).add(Attributes.MAX_HEALTH, 160.0).add(Attributes.ARMOR, 10.0).add(Attributes.STEP_HEIGHT, 1.25).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    public boolean hurt(DamageSource source, float damage) {
        if (!this.getPassengers().isEmpty() && this.getAttackState() == 4 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (source.is(ModTag.BLOCK_SELF_REGEN)) {
            this.self_regen = 80;
        }
        return super.hurtOrSimulate(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "swing_right") {
            return this.swingrightAnimationState;
        }
        if (input == "smash") {
            return this.smashAnimationState;
        }
        if (input == "idle") {
            return this.idleAnimationState;
        }
        if (input == "charge_start") {
            return this.chargestartAnimationState;
        }
        if (input == "charge") {
            return this.chargeAnimationState;
        }
        if (input == "charge_end") {
            return this.chargeendAnimationState;
        }
        if (input == "charge_hit") {
            return this.chargehitAnimationState;
        }
        if (input == "death") {
            return this.deathAnimationState;
        }
        return new AnimationState();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
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
                    this.swingrightAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 2: {
                    this.stopAllAnimationStates();
                    this.smashAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 3: {
                    this.stopAllAnimationStates();
                    this.chargestartAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 4: {
                    this.stopAllAnimationStates();
                    this.chargeAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 5: {
                    this.stopAllAnimationStates();
                    this.chargeendAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 6: {
                    this.stopAllAnimationStates();
                    this.chargehitAnimationState.startIfStopped(this.tickCount);
                    break;
                }
                case 7: {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingrightAnimationState.stop();
        this.smashAnimationState.stop();
        this.chargestartAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargeendAnimationState.stop();
        this.chargehitAnimationState.stop();
        this.deathAnimationState.stop();
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(7);
    }

    protected void dropCustomDeathLoot(ServerLevel p_348503_, DamageSource p_34697_, boolean p_34699_) {
        Creeper creeper;
        super.dropCustomDeathLoot(p_348503_, p_34697_, p_34699_);
        Entity entity = p_34697_.getEntity();
        if (entity instanceof Creeper && (creeper = (Creeper)entity).canDropMobsSkull()) {
            ItemStack itemstack = new ItemStack((ItemLike)ModItems.APTRGANGR_HEAD.get());
            creeper.increaseDroppedSkulls();
            this.spawnAtLocation(itemstack);
        }
    }

    @Override
    public int deathtimer() {
        return 60;
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
    }

    public float NatureRegen() {
        return (float)CMCommonConfig.Aptrgangr.natureHeal;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        } else {
            LivingEntity target = this.getTarget();
            if (!this.isNoAi() && this.self_regen <= 0 && !this.isNoAi() && this.NatureRegen() > 0.0f && target == null && this.tickCount % 20 == 0) {
                this.heal(this.NatureRegen());
            }
        }
        if (this.self_regen > 0) {
            --this.self_regen;
        }
        if (this.earthquake_cooldown > 0) {
            --this.earthquake_cooldown;
        }
        if (this.charge_cooldown > 0) {
            --this.charge_cooldown;
        }
        if (!this.getPassengers().isEmpty() && ((Entity)this.getPassengers().get(0)).isShiftKeyDown() && this.getAttackState() == 4) {
            ((Entity)this.getPassengers().get(0)).setShiftKeyDown(false);
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 1 && this.attackTicks == 15) {
            this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.7f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.06f, 0, 20);
            this.AreaAttack(5.75f, 5.75f, 120.0f, 1.0f, 120, true);
        }
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 11) {
                this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.7f);
            }
            if (this.attackTicks == 15) {
                this.AreaAttack(6.5f, 6.5f, 60.0f, 1.0f, 120, false);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.15f, 0, 20);
                this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0f, 0.8f);
                this.Makeparticle(0.6f, 5.0f, 0.0f);
                double theta = (double)this.yBodyRot * (Math.PI / 180);
                double vecX = Math.cos(theta += 1.5707963267948966);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 5;
                float angleStep = 30.0f;
                for (int i = 0; i < numberOfSkulls; ++i) {
                    float angle = this.yBodyRot + ((float)i - (float)numberOfSkulls / 2.0f) * angleStep;
                    float rad = (float)Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    Axe_Blade_Entity witherskull = new Axe_Blade_Entity((LivingEntity)this, dx, 0.0, dz, this.level(), (float)CMCommonConfig.Aptrgangr.AxeBladeDamage, angle);
                    double spawnX = this.getX() + vecX * 5.0;
                    double spawnY = this.getY(0.15);
                    double spawnZ = this.getZ() + vecZ * 5.0;
                    witherskull.setPos(spawnX, spawnY, spawnZ);
                    this.level().addFreshEntity((Entity)witherskull);
                }
            }
        }
        if (this.getAttackState() == 4) {
            this.ChargeGrab(0.0, 0.0, 0.5, 0.1f, 0, true);
            if (this.horizontalCollision) {
                this.chubu = true;
                if (!this.level().isClientSide()) {
                    this.Icicle_Crash();
                }
            }
            if (this.level().isClientSide()) {
                double x = this.getX();
                double y = this.getY() + (double)(this.getBbHeight() / 2.0f);
                double z = this.getZ();
                float yaw = (float)Math.toRadians(-this.getYRot());
                float yaw2 = (float)Math.toRadians(-this.getYRot() + 180.0f);
                float pitch = (float)Math.toRadians(-this.getXRot());
                this.level().addParticle((ParticleOptions)new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50.0f, false, 2), x, y, z, 0.0, 0.0, 0.0);
                this.level().addParticle((ParticleOptions)new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50.0f, false, 2), x, y, z, 0.0, 0.0, 0.0);
            }
        }
        if (this.getAttackState() == 5 && this.attackTicks == 4) {
            this.playSound((SoundEvent)ModSounds.STRONGSWING.get(), 1.0f, 0.7f);
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.06f, 0, 20);
            this.UpperAreaAttack(6.5f, 6.5f, 60.0f, 1.0f, 120, true);
        }
        if (this.getAttackState() == 6 && this.attackTicks == 1) {
            ScreenShake_Entity.ScreenShake(this.level(), this.position(), 15.0f, 0.1f, 0, 20);
            this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0f, 0.9f);
        }
    }

    private void Makeparticle(float size, float vec, float math) {
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
                double extraX = size * Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = size * Mth.cos((float)angle);
                int hitX = Mth.floor((double)(this.getX() + (double)vec * vecX + extraX));
                int hitY = Mth.floor((double)this.getY());
                int hitZ = Mth.floor((double)(this.getZ() + (double)vec * vecZ + extraZ));
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + (double)vec * vecX + extraX + (double)(f * math), this.getY() + extraY, this.getZ() + (double)vec * vecZ + extraZ + (double)(f1 * math), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
            this.level().addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 30, 255, 255, 255, 1.0f, 20.0f, false, 2), this.getX() + (double)vec * vecX + (double)(f * math), this.getY() + (double)0.2f, this.getZ() + (double)vec * vecZ + (double)(f1 * math), 0.0, 0.0, 0.0);
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean knockback) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Aptrgangr_Entity || entityHit == this) continue;
                boolean hurt = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                double d0 = entityHit.getX() - this.getX();
                double d1 = entityHit.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                if (!hurt || !knockback) continue;
                entityHit.push(d0 / d2 * 2.75, 0.15, d1 / d2 * 2.75);
            }
        }
    }

    private void UpperAreaAttack(float range, float height, float arc, float damage, int shieldbreakticks, boolean knockback) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide()) {
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
                if (!(entityHitDistance <= range && entityRelativeAngle <= arc / 2.0f && entityRelativeAngle >= -arc / 2.0f || entityRelativeAngle >= 360.0f - arc / 2.0f) && !(entityRelativeAngle <= -360.0f + arc / 2.0f) || this.isAlliedTo((Entity)entityHit) || entityHit instanceof Aptrgangr_Entity || entityHit == this) continue;
                DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
                boolean hurt = entityHit.hurtOrSimulate(damagesource, (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double)damage));
                if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player) {
                    Player player = (Player)entityHit;
                    if (shieldbreakticks > 0) {
                        EntityUtil.disableShield(player, shieldbreakticks);
                    }
                }
                double d0 = entityHit.getX() - this.getX();
                double d1 = entityHit.getZ() - this.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                if (!hurt || !knockback) continue;
                entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0.0, (double)0.8f, 0.0));
            }
        }
    }

    private void ChargeGrab(double inflateXZ, double inflateY, double range, float damage, int shieldbreakticks, boolean maledictio) {
        double yaw = Math.toRadians(this.getYRot() + 90.0f);
        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        AABB attackRange = this.getBoundingBox().inflate(inflateXZ, inflateY, inflateXZ).expandTowards(xExpand, 0.0, zExpand);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (this.isAlliedTo((Entity)entity) || entity == this || !this.getPassengers().isEmpty()) continue;
            DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage((LivingEntity)this) : this.damageSources().mobAttack((LivingEntity)this);
            boolean flag = entity.hurtOrSimulate(damagesource, damage);
            if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player) {
                Player player = (Player)entity;
                if (shieldbreakticks > 0) {
                    EntityUtil.disableShield(player, shieldbreakticks);
                }
            }
            if (!flag || entity.getType().builtInRegistryHolder().is(ModTag.IGNIS_CANT_POKE) || !entity.isAlive()) continue;
            if (entity.isShiftKeyDown()) {
                entity.setShiftKeyDown(false);
            }
            if (this.level().isClientSide()) continue;
            entity.startRiding((Entity)this, true);
            PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)entity, (CustomPacketPayload)new MessageEntityCameraSwitch.ThridPerson(entity.getId()), (CustomPacketPayload[])new CustomPacketPayload[0]);
        }
    }

    private void Icicle_Crash() {
        if (this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            BlockPos ceil = this.blockPosition().offset(0, 5, 0);
            while (!(this.level().getBlockState(ceil).isSolid() && this.level().getBlockState(ceil).getBlock() != ModBlocks.POINTED_ICICLE.get() || ceil.getY() >= this.level().getMaxBuildHeight())) {
                ceil = ceil.above();
            }
            int i = 8;
            int j = 8;
            int k = 8;
            for (BlockPos blockpos1 : BlockPos.betweenClosed((BlockPos)ceil.offset(-8, -8, -8), (BlockPos)ceil.offset(8, 8, 8))) {
                if (!(this.level().getBlockState(blockpos1).getBlock() instanceof Fallable)) continue;
                if (this.isHangingIcicle(blockpos1)) {
                    while (this.isHangingIcicle(blockpos1.above()) && blockpos1.getY() < this.level().getMaxBuildHeight()) {
                        blockpos1 = blockpos1.above();
                    }
                    if (!this.isHangingIcicle(blockpos1)) continue;
                    Vec3 vec3 = Vec3.atBottomCenterOf((Vec3i)blockpos1);
                    FallingBlockEntity.fall((Level)this.level(), (BlockPos)BlockPos.containing((double)vec3.x, (double)vec3.y, (double)vec3.z), (BlockState)this.level().getBlockState(blockpos1));
                    continue;
                }
                this.level().scheduleTick(blockpos1, this.level().getBlockState(blockpos1).getBlock(), 2);
            }
        }
    }

    private boolean isHangingIcicle(BlockPos pos) {
        return this.level().getBlockState(pos).getBlock() instanceof PointedIcicleBlock && this.level().getBlockState(pos).getValue((Property)PointedIcicleBlock.TIP_DIRECTION) == Direction.DOWN;
    }

    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    public boolean canRiderInteract() {
        return true;
    }

    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        double theta = (double)this.yBodyRot * (Math.PI / 180);
        double vecX = Math.cos(theta += 1.5707963267948966);
        double vecZ = Math.sin(theta);
        Vec3 vec3 = this.getPassengerRidingPosition(passenger);
        Vec3 vec31 = passenger.getVehicleAttachmentPoint((Entity)this);
        double px = vec3.x - vec31.x + (double)0.7f * vecX;
        double pz = vec3.z - vec31.z + (double)0.7f * vecZ;
        double y = this.getY() + 0.6;
        if (this.hasPassenger(passenger)) {
            if (this.getAttackState() == 6) {
                if (this.attackTicks == 1) {
                    DamageSource damagesource;
                    LivingEntity living;
                    boolean flag;
                    if (passenger instanceof LivingEntity && (flag = (living = (LivingEntity)passenger).hurtOrSimulate(damagesource = CMDamageTypes.causeMaledictioDamage((LivingEntity)this), (float)(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5)))) {
                        this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0f, 0.9f);
                    }
                    if (!this.level().isClientSide()) {
                        PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)passenger, (CustomPacketPayload)new MessageEntityCameraSwitch.FirstPerson(passenger.getId()), (CustomPacketPayload[])new CustomPacketPayload[0]);
                        passenger.stopRiding();
                    }
                }
            } else if (this.getAttackState() == 5) {
                if (this.attackTicks == 1 && !this.level().isClientSide()) {
                    PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)passenger, (CustomPacketPayload)new MessageEntityCameraSwitch.FirstPerson(passenger.getId()), (CustomPacketPayload[])new CustomPacketPayload[0]);
                    passenger.stopRiding();
                }
            } else if (this.getAttackState() != 4 && !this.level().isClientSide()) {
                PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)passenger, (CustomPacketPayload)new MessageEntityCameraSwitch.FirstPerson(passenger.getId()), (CustomPacketPayload[])new CustomPacketPayload[0]);
                passenger.stopRiding();
            }
            moveFunc.accept(passenger, px, y, pz);
        }
    }

    public Vec3 getDismountLocationForPassenger(LivingEntity p_29487_) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.getDismountLocationForPassenger(p_29487_);
        }
        int[][] aint = DismountHelper.offsetsForDirection((Direction)direction);
        BlockPos blockpos = this.blockPosition();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        for (Pose pose : p_29487_.getDismountPoses()) {
            AABB aabb = p_29487_.getLocalBoundsForPose(pose);
            for (int[] aint1 : aint) {
                blockpos$mutableblockpos.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                double d0 = this.level().getBlockFloorHeight((BlockPos)blockpos$mutableblockpos);
                if (!DismountHelper.isBlockFloorValid((double)d0)) continue;
                Vec3 vec3 = Vec3.upFromBottomCenterOf((Vec3i)blockpos$mutableblockpos, (double)d0);
                if (!DismountHelper.canDismountTo((CollisionGetter)this.level(), (LivingEntity)p_29487_, (AABB)aabb.move(vec3))) continue;
                p_29487_.setPose(pose);
                return vec3;
            }
        }
        return super.getDismountLocationForPassenger(p_29487_);
    }

    public boolean shouldRiderSit() {
        return false;
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
        return (SoundEvent)ModSounds.APTRGANGR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.APTRGANGR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.APTRGANGR_IDLE.get();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }
}

