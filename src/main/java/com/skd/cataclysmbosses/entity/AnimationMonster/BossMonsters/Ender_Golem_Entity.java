/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
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
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.animal.AbstractGolem
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AI.CmAttackGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.projectile.Void_Rune_Entity;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;

public class Ender_Golem_Entity
extends LLibrary_Boss_Monster {
    public static final Animation ANIMATION_ATTACK1 = Animation.create((int)25);
    public static final Animation ANIMATION_ATTACK2 = Animation.create((int)25);
    public static final Animation ANIMATION_EARTHQUAKE = Animation.create((int)35);
    public static final Animation VOID_RUNE_ATTACK = Animation.create((int)83);
    public static final Animation ENDER_GOLEM_DEATH = Animation.create((int)95);
    public static final int VOID_RUNE_ATTACK_COOLDOWN = 250;
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Ender_Golem_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private int void_rune_attack_cooldown = 0;
    private int timeWithoutTarget;
    public float deactivateProgress;
    public float prevdeactivateProgress;

    public Ender_Golem_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 15;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.EnderGolem.healthMultiplier, CMCommonConfig.EnderGolem.attackMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, ANIMATION_ATTACK1, ANIMATION_ATTACK2, ANIMATION_EARTHQUAKE, VOID_RUNE_ATTACK, ENDER_GOLEM_DEATH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new CmAttackGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(1, (Goal)new AttackGoal());
        this.goalSelector.addGoal(0, (Goal)new AwakenGoal());
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, true));
    }

    public static AttributeSupplier.Builder ender_golem() {
        return Ender_Golem_Entity.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 10.0).add(Attributes.MAX_HEALTH, 150.0).add(Attributes.ARMOR, 12.0).add(Attributes.STEP_HEIGHT, 1.5).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public double RangeLimit() {
        return CMCommonConfig.EnderGolem.rangeCap;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    private static Animation getRandomAttack(RandomSource rand) {
        return switch (rand.nextInt(3)) {
            case 0 -> ANIMATION_ATTACK1;
            case 1 -> ANIMATION_ATTACK2;
            default -> ANIMATION_EARTHQUAKE;
        };
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (!(this.getAnimation() != VOID_RUNE_ATTACK && this.getIsAwaken() || !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && source.is(DamageTypes.MAGIC))) {
            damage = (float)((double)damage * 0.5);
        }
        double range = this.calculateRange(source);
        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractGolem) {
            damage = (float)((double)damage * 0.5);
        }
        return super.hurt(source, damage);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_AWAKEN, (Object)false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Awaken", this.getIsAwaken());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setIsAwaken(compound.getBoolean("is_Awaken"));
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, (Object)isAwaken);
    }

    public boolean getIsAwaken() {
        return (Boolean)this.entityData.get(IS_AWAKEN);
    }

    @Override
    public void tick() {
        super.tick();
        this.repelEntities(1.7f, 3.7f, 1.7f, 1.7f);
        LivingEntity target = this.getTarget();
        this.prevdeactivateProgress = this.deactivateProgress;
        if (!this.getIsAwaken() && this.deactivateProgress < 30.0f) {
            this.deactivateProgress += 1.0f;
        }
        if (this.getIsAwaken() && this.deactivateProgress > 0.0f) {
            this.deactivateProgress -= 1.0f;
        }
        if (!this.getIsAwaken() && this.tickCount % 20 == 0) {
            this.heal(2.0f);
        }
        if (this.deactivateProgress == 0.0f && this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (this.void_rune_attack_cooldown <= 0 && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && target.onGround() && (this.random.nextInt(45) == 0 && this.distanceTo((Entity)target) < 4.0f || this.random.nextInt(24) == 0 && this.distanceTo((Entity)target) < 10.0f)) {
                    this.void_rune_attack_cooldown = 250;
                    this.setAnimation(VOID_RUNE_ATTACK);
                } else if (this.distanceTo((Entity)target) < 4.0f && !this.isNoAi() && this.getAnimation() == NO_ANIMATION) {
                    Animation animation = Ender_Golem_Entity.getRandomAttack(this.random);
                    this.setAnimation(animation);
                }
            }
            if (this.getAnimation() == ANIMATION_EARTHQUAKE && this.getAnimationTick() == 19) {
                this.EarthQuake(5.0f, 6);
                this.EarthQuakeParticle();
                if (!this.level().isClientSide()) {
                    if (CMCommonConfig.EnderGolem.ignoreMobGriefing) {
                        this.BlockBreaking(4, 4, 4);
                    } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                        this.BlockBreaking(4, 4, 4);
                    }
                }
            }
            if ((this.getAnimation() == ANIMATION_ATTACK1 || this.getAnimation() == ANIMATION_ATTACK2) && this.getAnimationTick() == 13) {
                this.playSound((SoundEvent)ModSounds.GOLEMATTACK.get(), 1.0f, 1.0f);
                if (target != null && target.isAlive() && this.distanceTo((Entity)target) < 4.75f) {
                    target.hurt(this.damageSources().mobAttack((LivingEntity)this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float)this.random.nextInt(4));
                    target.knockback(1.25, this.getX() - target.getX(), this.getZ() - target.getZ());
                }
            }
            if (this.getAnimation() == VOID_RUNE_ATTACK) {
                if (this.getAnimationTick() == 22) {
                    this.EarthQuake(4.25f, 4);
                    this.EarthQuakeParticle();
                    if (!this.level().isClientSide()) {
                        if (CMCommonConfig.EnderGolem.ignoreMobGriefing) {
                            this.BlockBreaking(4, 4, 4);
                        } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                            this.BlockBreaking(4, 4, 4);
                        }
                    }
                }
                if (this.getAnimationTick() == 28) {
                    this.VoidRuneAttack();
                }
            }
        }
        if (this.void_rune_attack_cooldown > 0) {
            --this.void_rune_attack_cooldown;
        }
        if (!this.level().isClientSide()) {
            ++this.timeWithoutTarget;
            if (target != null) {
                this.timeWithoutTarget = 0;
                if (!this.getIsAwaken()) {
                    this.setIsAwaken(true);
                }
            }
            if (this.timeWithoutTarget > 400 && this.getIsAwaken() && target == null) {
                this.timeWithoutTarget = 0;
                this.setIsAwaken(false);
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
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.level().getBlockState(blockpos);
                    if (block == Blocks.AIR.defaultBlockState() || !block.is(ModTag.ENDER_GOLEM_CAN_DESTROY) || !block.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || !EventHooks.onEntityDestroyBlock((LivingEntity)this, (BlockPos)blockpos, (BlockState)block)) continue;
                    flag = this.level().destroyBlock(blockpos, true, (Entity)this) || flag;
                }
            }
        }
    }

    private void EarthQuakeParticle() {
        if (this.level().isClientSide()) {
            BlockState block = this.level().getBlockState(this.blockPosition().below());
            for (int i1 = 0; i1 < 20 + this.random.nextInt(12); ++i1) {
                double DeltaMovementX = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementY = this.getRandom().nextGaussian() * 0.07;
                double DeltaMovementZ = this.getRandom().nextGaussian() * 0.07;
                float angle = (float)Math.PI / 180 * this.yBodyRot + (float)i1;
                double extraX = 4.0f * Mth.sin((float)((float)(Math.PI + (double)angle)));
                double extraY = 0.3f;
                double extraZ = 4.0f * Mth.cos((float)angle);
                if (block.getRenderShape() == RenderShape.INVISIBLE) continue;
                this.level().addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
        }
    }

    private void EarthQuake(float grow, int damage) {
        this.playSound((SoundEvent)ModSounds.EXPLOSION.get(), 1.5f, 1.0f + this.getRandom().nextFloat() * 0.1f);
        if (!this.level().isClientSide()) {
            DamageSource damagesource = this.damageSources().mobAttack((LivingEntity)this);
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate((double)grow))) {
                if (this.isAlliedTo((Entity)entity) || entity instanceof Ender_Golem_Entity || entity == this) continue;
                entity.hurt(damagesource, (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE) + (float)this.random.nextInt(damage));
                this.launch(entity, true);
            }
        }
    }

    private void VoidRuneAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            int k;
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0;
            float f = (float)Mth.atan2((double)(target.getZ() - this.getZ()), (double)(target.getX() - this.getX()));
            float f2 = Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180))) * 2.0f;
            float f3 = Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180))) * 2.0f;
            for (int l = 0; l < 10; ++l) {
                double d2 = 1.5 * (double)(l + 1);
                int j = (int)(1.25f * (float)l);
                this.spawnFangs(this.getX() + (double)f2 + (double)Mth.cos((float)f) * d2, this.getZ() + (double)f3 + (double)Mth.sin((float)f) * d2, d0, d1, f, j);
                this.spawnFangs(this.getX() - (double)f2 + (double)Mth.cos((float)f) * d2, this.getZ() - (double)f3 + (double)Mth.sin((float)f) * d2, d0, d1, f, j);
            }
            for (k = 0; k < 6; ++k) {
                float f4 = f + (float)k * (float)Math.PI * 2.0f / 6.0f + 0.83775806f;
                this.spawnFangs(this.getX() + (double)Mth.cos((float)f4) * 2.5, this.getZ() + (double)Mth.sin((float)f4) * 2.5, d0, d1, f2, 5);
            }
            for (k = 0; k < 8; ++k) {
                this.spawnFangs(this.getX() + this.random.nextGaussian() * 4.5, this.getZ() + this.random.nextGaussian() * 4.5, d0, d1, f3, 15);
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
            this.level().addFreshEntity((Entity)new Void_Rune_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, (float)CMCommonConfig.EnderGolem.VoidRuneDamage, (LivingEntity)this));
        }
    }

    private void launch(LivingEntity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
        float f = huge ? 2.0f : 0.5f;
        e.push(d0 / d2 * (double)f, huge ? 0.5 : (double)0.2f, d1 / d2 * (double)f);
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
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        this.setDeltaMovement(0.0, this.getDeltaMovement().y, 0.0);
        if (this.deathTime == 40) {
            this.playSound((SoundEvent)ModSounds.MONSTROSITYLAND.get(), 1.0f, 1.0f);
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

    @Override
    @Nullable
    public Animation getDeathAnimation() {
        return ENDER_GOLEM_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0f, 1.0f);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.GOLEMHURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.GOLEMDEATH.get();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    class AttackGoal
    extends Goal {
        public AttackGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.LOOK, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return Ender_Golem_Entity.this.getAnimation() == ANIMATION_EARTHQUAKE || Ender_Golem_Entity.this.getAnimation() == VOID_RUNE_ATTACK;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void stop() {
            super.stop();
        }

        public void tick() {
            Ender_Golem_Entity.this.setDeltaMovement(0.0, Ender_Golem_Entity.this.getDeltaMovement().y, 0.0);
            LivingEntity target = Ender_Golem_Entity.this.getTarget();
            if (Ender_Golem_Entity.this.getAnimation() == ANIMATION_EARTHQUAKE) {
                if (Ender_Golem_Entity.this.getAnimationTick() < 19 && target != null) {
                    Ender_Golem_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ender_Golem_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Golem_Entity.this.setYRot(Ender_Golem_Entity.this.yRotO);
                }
            }
            if (Ender_Golem_Entity.this.getAnimation() == VOID_RUNE_ATTACK) {
                if (Ender_Golem_Entity.this.getAnimationTick() < 22 && target != null) {
                    Ender_Golem_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                    Ender_Golem_Entity.this.lookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ender_Golem_Entity.this.setYRot(Ender_Golem_Entity.this.yRotO);
                }
            }
        }
    }

    class AwakenGoal
    extends Goal {
        public AwakenGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.LOOK, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return Ender_Golem_Entity.this.deactivateProgress > 0.0f;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            Ender_Golem_Entity.this.setDeltaMovement(0.0, Ender_Golem_Entity.this.getDeltaMovement().y, 0.0);
        }
    }
}

