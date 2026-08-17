/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.monster.Enemy
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.neoforged.neoforge.common.NeoForgeMod
 *  net.neoforged.neoforge.fluids.FluidType
 */
package com.skd.thesundering.entity.Deepling;

import com.skd.thesundering.entity.AI.MobAIFindWater;
import com.skd.thesundering.entity.AI.MobAILeaveWater;
import com.skd.thesundering.entity.AnimationMonster.LLibrary_Monster;
import com.skd.thesundering.entity.InternalAnimationMonster.Coralssus_Entity;
import com.skd.thesundering.entity.etc.ISemiAquatic;
import com.skd.thesundering.entity.etc.path.GroundPathNavigatorWide;
import com.skd.thesundering.entity.etc.path.SemiAquaticPathNavigator;
import com.skd.thesundering.init.ModTag;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;

public class AbstractDeepling
extends LLibrary_Monster
implements ISemiAquatic,
Enemy {
    private int moistureAttackTime = 0;
    public float LayerBrightness;
    public float oLayerBrightness;
    public int LayerTicks;
    private boolean isLandNavigator;
    private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(AbstractDeepling.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DEEPLINGSWIM = SynchedEntityData.defineId(AbstractDeepling.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);

    public AbstractDeepling(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, (Goal)new MobAIFindWater((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(4, (Goal)new MobAILeaveWater((PathfinderMob)this));
        this.goalSelector.addGoal(7, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(5, (Goal)new RidingCoralssus(this));
        this.goalSelector.addGoal(3, (Goal)new StopRiding(this));
        this.goalSelector.addGoal(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(6, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(MOISTNESS, (Object)40000);
        p_326229_.define(DEEPLINGSWIM, (Object)false);
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
    public void tick() {
        super.tick();
        if (this.isInWater() && this.isLandNavigator) {
            this.switchNavigator(false);
        }
        if (!this.isInWater() && !this.isLandNavigator) {
            this.switchNavigator(true);
        }
        if (this.isNoAi()) {
            this.setAirSupply(this.getMaxAirSupply());
        } else if (this.isInWaterRainOrBubble()) {
            this.setMoistness(6000);
        } else {
            int dry = this.level().isDay() ? 2 : 1;
            this.setMoistness(this.getMoistness() - dry);
            if (this.getMoistness() <= 0 && this.moistureAttackTime-- <= 0) {
                this.hurt(this.damageSources().dryOut(), this.random.nextInt(2) == 0 ? 1.0f : 0.0f);
                this.moistureAttackTime = 20;
            }
        }
        boolean flag1 = this.canInFluidType(this.getEyeInFluidType());
        if (this.level().isClientSide()) {
            if (flag1) {
                if (this.level().noCollision((Entity)this, this.getSwimmingBox())) {
                    if (!this.getDeeplingSwim()) {
                        this.setDeeplingSwim(true);
                    }
                    this.refreshDimensions();
                }
            } else if (this.level().noCollision((Entity)this, this.getNormalBox())) {
                if (this.getDeeplingSwim()) {
                    this.setDeeplingSwim(false);
                }
                this.refreshDimensions();
            }
        }
        if (this.level().isClientSide()) {
            this.oLayerBrightness = this.LayerBrightness;
            ++this.LayerTicks;
            this.LayerBrightness += (0.0f - this.LayerBrightness) * 0.8f;
        }
    }

    private boolean canInFluidType(FluidType type) {
        NeoForgeMod.WATER_TYPE.value();
        return type.canSwim((Entity)this.self());
    }

    public boolean isVisuallySwimming() {
        return this.getDeeplingSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide((Mob)this, this.level());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator((Mob)this, this.level());
            this.isLandNavigator = false;
        }
    }

    public boolean hurt(DamageSource source, float damage) {
        if (source.is(DamageTypes.HOT_FLOOR)) {
            return false;
        }
        return super.hurt(source, damage);
    }

    public void onInsideBubbleColumn(boolean p_20322_) {
    }

    public void onAboveBubbleCol(boolean p_20313_) {
    }

    public AABB getSwimmingBox() {
        return new AABB(this.getX() - (double)1.15f, this.getY(), this.getZ() - (double)1.15f, this.getX() + (double)1.15f, this.getY() + (double)0.6f, this.getZ() + (double)1.15f);
    }

    public AABB getNormalBox() {
        return new AABB(this.getX() - (double)0.6f, this.getY(), this.getZ() - (double)0.6f, this.getX() + (double)0.6f, this.getY() + (double)2.3f, this.getZ() + (double)0.6f);
    }

    public EntityDimensions getSwimmingSize() {
        return this.getType().getDimensions().scale(this.getScale());
    }

    public EntityDimensions getDefaultDimensions(Pose poseIn) {
        return this.getDeeplingSwim() ? this.getSwimmingSize() : this.getType().getDimensions().scale(this.getScale());
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Moisture", this.getMoistness());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setMoistness(compound.getInt("Moisture"));
    }

    public int getMoistness() {
        return (Integer)this.entityData.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.entityData.set(MOISTNESS, (Object)p_211137_1_);
    }

    public boolean getDeeplingSwim() {
        return (Boolean)this.entityData.get(DEEPLINGSWIM);
    }

    public void setDeeplingSwim(boolean swim) {
        this.entityData.set(DEEPLINGSWIM, (Object)swim);
    }

    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    @Override
    public boolean shouldEnterWater() {
        return this.getMoistness() < 300;
    }

    @Override
    public boolean shouldLeaveWater() {
        return this.getTarget() != null && !this.getTarget().isInWater();
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    protected AABB getAttackBoundingBox() {
        AABB aabb = super.getAttackBoundingBox();
        return aabb.deflate(0.05, 0.0, 0.05);
    }

    static class RidingCoralssus
    extends Goal {
        private final AbstractDeepling drowned;

        public RidingCoralssus(AbstractDeepling p_32440_) {
            this.drowned = p_32440_;
        }

        public boolean canUse() {
            Coralssus_Entity sus = this.getClosestCoralssus_Entity();
            return !this.drowned.isPassenger() && sus != null && this.drowned.getMoistness() > 300 && sus.isAlive() && !sus.isVehicle();
        }

        public void start() {
            Coralssus_Entity sus = this.getClosestCoralssus_Entity();
            if (sus != null) {
                this.drowned.getNavigation().moveTo((Entity)sus, 1.0);
            }
        }

        public void tick() {
            Coralssus_Entity sus = this.getClosestCoralssus_Entity();
            if (sus != null) {
                this.drowned.getNavigation().moveTo((Entity)sus, 1.0);
                if (this.drowned.distanceTo((Entity)sus) < 4.0f) {
                    this.drowned.startRiding((Entity)sus, true);
                }
            }
        }

        public void stop() {
            this.drowned.getNavigation().stop();
        }

        private Coralssus_Entity getClosestCoralssus_Entity() {
            List list = this.drowned.level().getEntitiesOfClass(Coralssus_Entity.class, this.drowned.getBoundingBox().inflate(15.0, 15.0, 15.0));
            Coralssus_Entity closest = null;
            if (!list.isEmpty()) {
                for (Coralssus_Entity entity : list) {
                    if (closest != null && !(closest.distanceTo((Entity)entity) > entity.distanceTo((Entity)entity))) continue;
                    closest = entity;
                }
            }
            return closest;
        }
    }

    static class StopRiding
    extends Goal {
        private final AbstractDeepling drowned;

        public StopRiding(AbstractDeepling p_32440_) {
            this.drowned = p_32440_;
        }

        public boolean canUse() {
            return this.drowned.getMoistness() < 300 && this.drowned.isPassenger();
        }

        public void start() {
            this.drowned.stopRiding();
        }
    }
}

