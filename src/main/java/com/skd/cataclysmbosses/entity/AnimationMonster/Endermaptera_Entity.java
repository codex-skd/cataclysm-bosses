/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.AnimationHandler
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WallClimberNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.level.storage.loot.LootTable
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.AnimationMonster;

import com.skd.cataclysmbosses.entity.etc.FlightMoveController;
import com.skd.cataclysmbosses.entity.etc.path.DirectPathNavigator;
import com.skd.cataclysmbosses.entity.projectile.Void_Shard_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.AnimationHandler;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Endermaptera_Entity
extends Monster
implements IAnimatedEntity {
    @Nullable
    private ResourceKey<LootTable> HAS_JAWS_LOOT = ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"entities/endermaptera_has_jaws"));
    private int animationTick;
    private Animation currentAnimation;
    public static final Animation JAW_ATTACK = Animation.create((int)13);
    public static final Animation HEADBUTT_ATTACK = Animation.create((int)13);
    public float attachChangeProgress = 0.0f;
    public float prevAttachChangeProgress = 0.0f;
    private static final EntityDataAccessor<Direction> ATTACHED_FACE = SynchedEntityData.defineId(Endermaptera_Entity.class, (EntityDataSerializer)EntityDataSerializers.DIRECTION);
    private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Endermaptera_Entity.class, (EntityDataSerializer)EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> HAS_JAWS = SynchedEntityData.defineId(Endermaptera_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final Direction[] HORIZONTALS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private Direction prevAttachDir = Direction.DOWN;
    private boolean isUpsideDownNavigator;

    public Endermaptera_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.xpReward = 6;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, false));
        this.goalSelector.addGoal(5, (Goal)new WaterAvoidingRandomStrollGoal((PathfinderMob)this, 0.8));
        this.goalSelector.addGoal(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
    }

    private void switchNavigator(boolean rightsideUp) {
        if (rightsideUp) {
            this.moveControl = new MoveControl((Mob)this);
            this.navigation = new WallClimberNavigation((Mob)this, this.level());
            this.isUpsideDownNavigator = false;
        } else {
            this.moveControl = new FlightMoveController((Mob)this, 0.6f, false);
            this.navigation = new DirectPathNavigator((Mob)this, this.level());
            this.isUpsideDownNavigator = true;
        }
    }

    public static AttributeSupplier.Builder endermaptera() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.27f).add(Attributes.ATTACK_DAMAGE, 4.0).add(Attributes.MAX_HEALTH, 16.0).add(Attributes.ARMOR, 6.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(CLIMBING, 0);
        p_326229_.define(ATTACHED_FACE, Direction.DOWN);
        p_326229_.define(HAS_JAWS, true);
    }

    public Direction getAttachmentFacing() {
        return (Direction)this.entityData.get(ATTACHED_FACE);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WallClimberNavigation((Mob)this, worldIn);
    }

    @Nullable
    protected ResourceKey<LootTable> getDefaultLootTable() {
        return this.getHasJaws() ? this.HAS_JAWS_LOOT : super.getDefaultLootTable();
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Has_Jaws", this.getHasJaws());
    }

    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(ATTACHED_FACE, Direction.from3DDataValue((int)compound.getByte("AttachFace")));
        this.setHasJaw(compound.getBooleanOr("Has_Jaws", false));
    }

    public void setHasJaw(boolean HasJaws) {
        this.entityData.set(HAS_JAWS, HasJaws);
    }

    public boolean getHasJaws() {
        return (Boolean)this.entityData.get(HAS_JAWS);
    }

    public boolean causeFallDamage(float p_149683_, float p_149684_, DamageSource p_149685_) {
        return false;
    }

    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.ENDERMAPTERA_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.ENDERMAPTERA_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.ENDERMAPTERA_DEATH.get();
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound((SoundEvent)ModSounds.ENDERMAPTERA_STEP.get(), 0.15f, 0.6f);
    }

    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, JAW_ATTACK, HEADBUTT_ATTACK};
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    public boolean doHurtTarget(Entity entityIn) {
        if (this.getHasJaws()) {
            this.setAnimation(JAW_ATTACK);
        } else {
            this.setAnimation(HEADBUTT_ATTACK);
        }
        return true;
    }

    public void tick() {
        block22: {
            block21: {
                LivingEntity target;
                super.tick();
                this.prevAttachChangeProgress = this.attachChangeProgress;
                AnimationHandler.INSTANCE.updateAnimations((Entity)this);
                if (this.attachChangeProgress > 0.0f) {
                    this.attachChangeProgress -= 0.25f;
                }
                Vec3 Vec32 = this.getDeltaMovement();
                if (!this.level().isClientSide()) {
                    this.setBesideClimbableBlock(this.horizontalCollision || this.verticalCollision && !this.onGround());
                    if (this.onGround() || this.isInWaterOrBubble() || this.isInLava()) {
                        this.entityData.set(ATTACHED_FACE, Direction.DOWN);
                    } else if (this.verticalCollision) {
                        this.entityData.set(ATTACHED_FACE, Direction.UP);
                    } else {
                        Direction closestDirection = Direction.DOWN;
                        double closestDistance = 100.0;
                        for (Direction dir : HORIZONTALS) {
                            BlockPos antPos = new BlockPos(Mth.floor((double)this.getX()), Mth.floor((double)this.getY()), Mth.floor((double)this.getZ()));
                            BlockPos offsetPos = antPos.relative(dir);
                            Vec3 offset = Vec3.atCenterOf((Vec3i)offsetPos);
                            if (!(closestDistance > this.position().distanceTo(offset)) || !this.level().loadedAndEntityCanStandOnFace(offsetPos, (Entity)this, dir.getOpposite())) continue;
                            closestDistance = this.position().distanceTo(offset);
                            closestDirection = dir;
                        }
                        this.entityData.set(ATTACHED_FACE, closestDirection);
                    }
                }
                boolean flag = false;
                if (this.getAttachmentFacing() != Direction.DOWN) {
                    if (this.getAttachmentFacing() == Direction.UP) {
                        this.setDeltaMovement(this.getDeltaMovement().add(0.0, 1.0, 0.0));
                    } else {
                        if (!this.horizontalCollision && this.getAttachmentFacing() != Direction.UP) {
                            Vec3 vec = Vec3.atLowerCornerOf((Vec3i)this.getAttachmentFacing().getNormal());
                            this.setDeltaMovement(this.getDeltaMovement().add(vec.normalize().multiply((double)0.1f, (double)0.1f, (double)0.1f)));
                        }
                        if (!this.onGround() && Vec32.y < 0.0) {
                            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.5, 1.0));
                            flag = true;
                        }
                    }
                }
                if (this.getAttachmentFacing() == Direction.UP) {
                    this.setNoGravity(true);
                    this.setDeltaMovement(Vec32.multiply(0.7, 1.0, 0.7));
                } else {
                    this.setNoGravity(false);
                }
                if (!flag && this.onClimbable()) {
                    this.setDeltaMovement(Vec32.multiply(1.0, 0.4, 1.0));
                }
                if (this.prevAttachDir != this.getAttachmentFacing()) {
                    this.attachChangeProgress = 1.0f;
                }
                this.prevAttachDir = this.getAttachmentFacing();
                if (this.level().isClientSide()) break block21;
                if (this.getAttachmentFacing() == Direction.UP && !this.isUpsideDownNavigator) {
                    this.switchNavigator(false);
                }
                if (this.getAttachmentFacing() != Direction.UP && this.isUpsideDownNavigator) {
                    this.switchNavigator(true);
                }
                if ((target = this.getTarget()) == null || !(this.distanceTo((Entity)target) < target.getBbWidth() + this.getBbWidth()) || !this.hasLineOfSight((Entity)target)) break block22;
                float damage = (int)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                if (this.getAnimation() == JAW_ATTACK && this.getAnimationTick() == 11) {
                    target.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), damage);
                    if (this.random.nextInt(6) == 0) {
                        this.BrokenJaws();
                    }
                }
                if (this.getAnimation() != HEADBUTT_ATTACK || this.getAnimationTick() != 6) break block22;
                target.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), damage * 0.75f);
                break block22;
            }
            for (int i = 0; i < 2; ++i) {
                this.level().addParticle((ParticleOptions)ParticleTypes.PORTAL, this.getRandomX(0.5), this.getRandomY(), this.getRandomZ(0.5), (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
            }
        }
    }

    private void BrokenJaws() {
        this.playSound(SoundEvents.ITEM_BREAK, 0.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        this.setHasJaw(false);
        int shardCount = 8 + this.random.nextInt(4);
        if (!this.level().isClientSide()) {
            for (int i = 0; i < shardCount; ++i) {
                float f = (float)(i + 1) / (float)shardCount * 360.0f;
                Void_Shard_Entity shard = new Void_Shard_Entity((EntityType)ModEntities.VOID_SHARD.get(), this.level(), (LivingEntity)this);
                shard.shootFromRotation((Entity)this, this.getXRot() - (float)this.random.nextInt(40), f, 0.0f, 0.15f + this.random.nextFloat() * 0.2f, 1.0f);
                this.level().addFreshEntity((Entity)shard);
            }
        }
    }

    protected void onInsideBlock(BlockState state) {
    }

    public boolean onClimbable() {
        return this.isBesideClimbableBlock();
    }

    public boolean isBesideClimbableBlock() {
        return ((Byte)this.entityData.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = (Byte)this.entityData.get(CLIMBING);
        b0 = climbing ? (byte)(b0 | 1) : (byte)(b0 & 0xFFFFFFFE);
        this.entityData.set(CLIMBING, b0);
    }

    public static boolean canSpawn(EntityType<Endermaptera_Entity> entity, ServerLevelAccessor worldIn, EntitySpawnReason reason, BlockPos pos, RandomSource randomIn) {
        return !worldIn.getBlockState(pos.below()).is(ModTag.ENDERMAPTERA_CAN_NOT_SPAWN) && Endermaptera_Entity.checkMonsterSpawnRules(entity, (ServerLevelAccessor)worldIn, (EntitySpawnReason)reason, (BlockPos)pos, (RandomSource)randomIn);
    }

    public int getAnimationTick() {
        return this.animationTick;
    }

    public void setAnimationTick(int tick) {
        this.animationTick = tick;
    }

    public Animation getAnimation() {
        return this.currentAnimation;
    }

    public void setAnimation(Animation animation) {
        this.currentAnimation = animation;
    }
}

