/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.BiomeTags
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$MoveFunction
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl$Operation
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.MoveToBlockGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.RangedAttackGoal
 *  net.minecraft.world.entity.ai.goal.ZombieAttackGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation
 *  net.minecraft.world.entity.ai.util.DefaultRandomPos
 *  net.minecraft.world.entity.animal.IronGolem
 *  net.minecraft.world.entity.animal.Turtle
 *  net.minecraft.world.entity.animal.axolotl.Axolotl
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.monster.RangedAttackMob
 *  net.minecraft.world.entity.monster.Zombie
 *  net.minecraft.world.entity.monster.ZombifiedPiglin
 *  net.minecraft.world.entity.npc.AbstractVillager
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.ThrownTrident
 *  net.minecraft.world.entity.vehicle.Boat
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters;

import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Symbiocto_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModTag;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.turtle.Turtle;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.ThrownTrident;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class Drowned_Host_Entity
extends Zombie
implements RangedAttackMob {
    public static final float NAUTILUS_SHELL_CHANCE = 0.03f;
    boolean searchingForLand;
    protected final WaterBoundPathNavigation waterNavigation;
    protected final GroundPathNavigation groundNavigation;

    public Drowned_Host_Entity(EntityType<? extends Drowned_Host_Entity> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new DrownedMoveControl(this);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.waterNavigation = new WaterBoundPathNavigation((Mob)this, level);
        this.groundNavigation = new GroundPathNavigation((Mob)this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.23f).add(Attributes.MAX_HEALTH, 20.0).add(Attributes.ATTACK_DAMAGE, 3.0).add(Attributes.ARMOR, 2.0).add(Attributes.STEP_HEIGHT, 1.0).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(1, (Goal)new DrownedGoToWaterGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(2, (Goal)new DrownedTridentAttackGoal(this, 1.0, 40, 10.0f));
        this.goalSelector.addGoal(2, (Goal)new ZombieAttackGoal((Zombie)this, 1.0, false));
        this.goalSelector.addGoal(5, (Goal)new DrownedGoToBeachGoal(this, 1.0));
        this.goalSelector.addGoal(6, (Goal)new DrownedSwimUpGoal(this, 1.0, this.level().getSeaLevel()));
        this.goalSelector.addGoal(7, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[]{Drowned_Host_Entity.class}).setAlertOthers(new Class[]{ZombifiedPiglin.class}));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, IronGolem.class, true));
        this.targetSelector.addGoal(3, (Goal)new NearestAttackableTargetGoal((Mob)this, Axolotl.class, true, false));
        this.targetSelector.addGoal(5, (Goal)new NearestAttackableTargetGoal((Mob)this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    protected void updateControlFlags() {
        boolean flag = !(this.getControllingPassenger() instanceof Mob) || this.getControllingPassenger() instanceof Symbiocto_Entity;
        boolean flag1 = !(this.getVehicle() instanceof Boat);
        this.goalSelector.setControlFlag(Goal.Flag.MOVE, flag);
        this.goalSelector.setControlFlag(Goal.Flag.JUMP, flag && flag1);
        this.goalSelector.setControlFlag(Goal.Flag.LOOK, flag);
        this.goalSelector.setControlFlag(Goal.Flag.TARGET, flag);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor accessor, DifficultyInstance difficulty, EntitySpawnReason spawnType, @Nullable SpawnGroupData spawnGroupData) {
        spawnGroupData = super.finalizeSpawn(accessor, difficulty, spawnType, spawnGroupData);
        Symbiocto_Entity upper = new Symbiocto_Entity((EntityType)ModEntities.SYMBIOCTO.get(), this.level());
        upper.setPos(this.getX(), this.getY() + 1.3125, this.getZ()); upper.setYRot((float)this.getZ()); upper.setXRot(this.getYRot());
        EventHooks.finalizeMobSpawn((Mob)upper, (ServerLevelAccessor)accessor, (DifficultyInstance)difficulty, (EntitySpawnReason)spawnType, (SpawnGroupData)spawnGroupData);
        upper.setYBodyRot(this.yBodyRot);
        upper.setYHeadRot(this.getYHeadRot());
        upper.setYRot(this.getYRot());
        upper.startRiding((Entity)this);
        return spawnGroupData;
    }

    public static boolean checkDrownedSpawnRules(EntityType<Drowned_Host_Entity> drowned, ServerLevelAccessor serverLevel, EntitySpawnReason mobSpawnType, BlockPos pos, RandomSource random) {
        boolean flag;
        if (!serverLevel.getFluidState(pos.below()).is(FluidTags.WATER) && !EntitySpawnReason.isSpawner((EntitySpawnReason)mobSpawnType)) {
            return false;
        }
        Holder holder = serverLevel.getBiome(pos);
        boolean bl = flag = !(serverLevel.getDifficulty() == Difficulty.PEACEFUL || !EntitySpawnReason.ignoresLightRequirements((EntitySpawnReason)mobSpawnType) && !Drowned_Host_Entity.isDarkEnoughToSpawn((ServerLevelAccessor)serverLevel, (BlockPos)pos, (RandomSource)random) || !EntitySpawnReason.isSpawner((EntitySpawnReason)mobSpawnType) && !serverLevel.getFluidState(pos).is(FluidTags.WATER));
        if (flag && EntitySpawnReason.isSpawner((EntitySpawnReason)mobSpawnType)) {
            return true;
        }
        return holder.is(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS) ? random.nextInt(15) == 0 && flag : random.nextInt(40) == 0 && Drowned_Host_Entity.isDeepEnoughToSpawn((LevelAccessor)serverLevel, pos) && flag;
    }

    public void positionRider(Entity entity, Entity.MoveFunction callback) {
        super.positionRider(entity, callback);
        if (entity instanceof Symbiocto_Entity) {
            Symbiocto_Entity goblin = (Symbiocto_Entity)entity;
            goblin.setYBodyRot(this.yBodyRot);
            goblin.setYHeadRot(this.getYHeadRot());
            goblin.setYRot(this.getYRot());
        }
    }

    private static boolean isDeepEnoughToSpawn(LevelAccessor level, BlockPos pos) {
        return pos.getY() < level.getSeaLevel() - 5;
    }

    protected boolean supportsBreakDoorGoal() {
        return false;
    }

    public boolean isBaby() {
        return false;
    }

    public boolean considersEntityAsAlly(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.considersEntityAsAlly(entityIn)) {
            return true;
        }
        if (entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_SCYLLA)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        }
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return this.isInWater() ? SoundEvents.DROWNED_AMBIENT_WATER : SoundEvents.DROWNED_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return this.isInWater() ? SoundEvents.DROWNED_HURT_WATER : SoundEvents.DROWNED_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isInWater() ? SoundEvents.DROWNED_DEATH_WATER : SoundEvents.DROWNED_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.DROWNED_STEP;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.DROWNED_SWIM;
    }

    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }

    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        if ((double)random.nextFloat() > 0.9) {
            int i = random.nextInt(16);
            if (i < 10) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.TRIDENT));
            } else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.FISHING_ROD));
            }
        }
    }

    protected boolean canReplaceCurrentItem(ItemStack candidate, ItemStack existing, net.minecraft.world.entity.EquipmentSlot slot) {
        if (existing.is(Items.NAUTILUS_SHELL)) {
            return false;
        }
        if (existing.is(Items.TRIDENT)) {
            return candidate.is(Items.TRIDENT) ? candidate.getDamageValue() < existing.getDamageValue() : false;
        }
        return candidate.is(Items.TRIDENT) ? true : super.canReplaceCurrentItem(candidate, existing, slot);
    }

    protected boolean convertsInWater() {
        return false;
    }

    protected boolean isSunSensitive() {
        return !this.isVehicle() || !(this.getPassengers().get(0) instanceof Symbiocto_Entity);
    }

    public boolean checkSpawnObstruction(LevelReader level) {
        return level.isUnobstructed((Entity)this);
    }

    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        }
        LivingEntity livingentity = this.getTarget();
        return livingentity != null && livingentity.isInWater();
    }

    public void travel(Vec3 travelVector) {
        if (this.isLocalInstanceAuthoritative() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01f, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(travelVector);
        }
    }

    public void updateSwimming() {
        if (!this.level().isClientSide()) {
            if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.setSwimming(false);
            }
        }
    }

    public boolean isVisuallySwimming() {
        return this.isSwimming();
    }

    protected boolean closeToNextPos() {
        double d0;
        BlockPos blockpos;
        Path path = this.getNavigation().getPath();
        return path != null && (blockpos = path.getTarget()) != null && (d0 = this.distanceToSqr(blockpos.getX(), blockpos.getY(), blockpos.getZ())) < 4.0;
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ThrownTrident throwntrident = new ThrownTrident(this.level(), (LivingEntity)this, new ItemStack((ItemLike)Items.TRIDENT));
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333) - throwntrident.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        throwntrident.shoot(d0, d1 + d3 * (double)0.2f, d2, 1.6f, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level().addFreshEntity((Entity)throwntrident);
    }

    public void setSearchingForLand(boolean searchingForLand) {
        this.searchingForLand = searchingForLand;
    }

    static class DrownedMoveControl
    extends MoveControl {
        private final Drowned_Host_Entity drowned;

        public DrownedMoveControl(Drowned_Host_Entity drowned) {
            super((Mob)drowned);
            this.drowned = drowned;
        }

        public void tick() {
            LivingEntity livingentity = this.drowned.getTarget();
            if (this.drowned.wantsToSwim() && this.drowned.isInWater()) {
                if (livingentity != null && livingentity.getY() > this.drowned.getY() || this.drowned.searchingForLand) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0, 0.002, 0.0));
                }
                if (this.operation != MoveControl.Operation.MOVE_TO || this.drowned.getNavigation().isDone()) {
                    this.drowned.setSpeed(0.0f);
                    return;
                }
                double d0 = this.wantedX - this.drowned.getX();
                double d1 = this.wantedY - this.drowned.getY();
                double d2 = this.wantedZ - this.drowned.getZ();
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 /= d3;
                float f = (float)(Mth.atan2((double)d2, (double)d0) * 180.0 / 3.1415927410125732) - 90.0f;
                this.drowned.setYRot(this.rotlerp(this.drowned.getYRot(), f, 90.0f));
                this.drowned.yBodyRot = this.drowned.getYRot();
                float f1 = (float)(this.speedModifier * this.drowned.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float f2 = Mth.lerp((float)0.125f, (float)this.drowned.getSpeed(), (float)f1);
                this.drowned.setSpeed(f2);
                this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add((double)f2 * d0 * 0.005, (double)f2 * d1 * 0.1, (double)f2 * d2 * 0.005));
            } else {
                if (!this.drowned.onGround()) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0, -0.008, 0.0));
                }
                super.tick();
            }
        }
    }

    static class DrownedGoToWaterGoal
    extends Goal {
        private final PathfinderMob mob;
        private double wantedX;
        private double wantedY;
        private double wantedZ;
        private final double speedModifier;
        private final Level level;

        public DrownedGoToWaterGoal(PathfinderMob mob, double speedModifier) {
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.level = mob.level();
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (!(this.level.getOverworldClockTime() % 24000 < 12000)) {
                return false;
            }
            if (this.mob.isInWater()) {
                return false;
            }
            Vec3 vec3 = this.getWaterPos();
            if (vec3 == null) {
                return false;
            }
            this.wantedX = vec3.x;
            this.wantedY = vec3.y;
            this.wantedZ = vec3.z;
            return true;
        }

        public boolean canContinueToUse() {
            return !this.mob.getNavigation().isDone();
        }

        public void start() {
            this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        @Nullable
        private Vec3 getWaterPos() {
            RandomSource randomsource = this.mob.getRandom();
            BlockPos blockpos = this.mob.blockPosition();
            for (int i = 0; i < 10; ++i) {
                BlockPos blockpos1 = blockpos.offset(randomsource.nextInt(20) - 10, 2 - randomsource.nextInt(8), randomsource.nextInt(20) - 10);
                if (!this.level.getBlockState(blockpos1).is(Blocks.WATER)) continue;
                return Vec3.atBottomCenterOf((Vec3i)blockpos1);
            }
            return null;
        }
    }

    static class DrownedTridentAttackGoal
    extends RangedAttackGoal {
        private final Drowned_Host_Entity drowned;

        public DrownedTridentAttackGoal(RangedAttackMob rangedAttackMob, double speedModifier, int attackInterval, float attackRadius) {
            super(rangedAttackMob, speedModifier, attackInterval, attackRadius);
            this.drowned = (Drowned_Host_Entity)rangedAttackMob;
        }

        public boolean canUse() {
            return super.canUse() && this.drowned.getMainHandItem().is(Items.TRIDENT);
        }

        public void start() {
            super.start();
            this.drowned.setAggressive(true);
            this.drowned.startUsingItem(InteractionHand.MAIN_HAND);
        }

        public void stop() {
            super.stop();
            this.drowned.stopUsingItem();
            this.drowned.setAggressive(false);
        }
    }

    static class DrownedGoToBeachGoal
    extends MoveToBlockGoal {
        private final Drowned_Host_Entity drowned;

        public DrownedGoToBeachGoal(Drowned_Host_Entity drowned, double speedModifier) {
            super((PathfinderMob)drowned, speedModifier, 8, 2);
            this.drowned = drowned;
        }

        public boolean canUse() {
            return super.canUse() && this.drowned.level().getOverworldClockTime() % 24000 >= 12000 && this.drowned.isInWater() && this.drowned.getY() >= (double)(this.drowned.level().getSeaLevel() - 3);
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            BlockPos blockpos = pos.above();
            return level.isEmptyBlock(blockpos) && level.isEmptyBlock(blockpos.above()) ? level.getBlockState(pos).entityCanStandOn((BlockGetter)level, pos, (Entity)this.drowned) : false;
        }

        public void start() {
            this.drowned.setSearchingForLand(false);
            this.drowned.navigation = (PathNavigation)this.drowned.groundNavigation;
            super.start();
        }

        public void stop() {
            super.stop();
        }
    }

    static class DrownedSwimUpGoal
    extends Goal {
        private final Drowned_Host_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public DrownedSwimUpGoal(Drowned_Host_Entity drowned, double speedModifier, int seaLevel) {
            this.drowned = drowned;
            this.speedModifier = speedModifier;
            this.seaLevel = seaLevel;
        }

        public boolean canUse() {
            return this.drowned.level().getOverworldClockTime() % 24000 >= 12000 && this.drowned.isInWater() && this.drowned.getY() < (double)(this.seaLevel - 2);
        }

        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }

        public void tick() {
            if (this.drowned.getY() < (double)(this.seaLevel - 1) && (this.drowned.getNavigation().isDone() || this.drowned.closeToNextPos())) {
                Vec3 vec3 = DefaultRandomPos.getPosTowards((PathfinderMob)this.drowned, (int)4, (int)8, (Vec3)new Vec3(this.drowned.getX(), (double)(this.seaLevel - 1), this.drowned.getZ()), (double)1.5707963705062866);
                if (vec3 == null) {
                    this.stuck = true;
                    return;
                }
                this.drowned.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
            }
        }

        public void start() {
            this.drowned.setSearchingForLand(true);
            this.stuck = false;
        }

        public void stop() {
            this.drowned.setSearchingForLand(false);
        }
    }
}

