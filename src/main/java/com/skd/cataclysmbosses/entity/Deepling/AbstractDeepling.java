/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  net.neoforged.neoforge.common.NeoForgeMod
 *  net.neoforged.neoforge.fluids.FluidType
 *  org.jspecify.annotations.Nullable
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.storage.ValueInput
 *  net.minecraft.world.level.storage.ValueOutput
 *  net.minecraft.world.level.storage.ValueOutput;
 */
package com.skd.cataclysmbosses.entity.Deepling;


import com.skd.cataclysmbosses.entity.AI.MobAIFindWater;
import com.skd.cataclysmbosses.entity.AI.MobAILeaveWater;
// import com.skd.cataclysmbosses.entity.AI.RidingCoralssus; // TODO: not ported
// import com.skd.cataclysmbosses.entity.AI.StopRiding; // TODO: not ported
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
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
import org.jspecify.annotations.Nullable;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.ValueInput;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.entity.AnimationMonster.LLibrary_Monster;
import com.skd.cataclysmbosses.entity.etc.ISemiAquatic;

public abstract class AbstractDeepling
extends LLibrary_Monster
implements ISemiAquatic,
Enemy {
    private int moistureAttackTime = 0;
    public float LayerBrightness;
    public float oLayerBrightness;
    public int LayerTicks;
    private boolean isLandNavigator;
    private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(AbstractDeepling.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DEEPLINGSWIM = SynchedEntityData.defineId(AbstractDeepling.class, EntityDataSerializers.BOOLEAN);

    public AbstractDeepling(EntityType<?> entity, Level world) {
        super(entity, world);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new MobAIFindWater(this, 1.0));
        this.goalSelector.addGoal(4, new MobAILeaveWater(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));
        // this.goalSelector.addGoal(5, new RidingCoralssus(this)); // TODO: RidingCoralssus not ported
        // this.goalSelector.addGoal(3, new StopRiding(this)); // TODO: StopRiding not ported
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
    }

    @Override
    public int getWaterSearchRange() {
        return 16;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(MOISTNESS, 40000);
        p_326229_.define(DEEPLINGSWIM, false);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        }
        if (super.isAlliedTo(entityIn)) {
            return true;
        }
        if (entityIn != null && entityIn.getType().builtInRegistryHolder().is(ModTag.TEAM_THE_LEVIATHAN)) {
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
        } else if (this.isInWaterOrRain()) {
            this.setMoistness(6000);
        } else {
            int dry = this.level().isDay() ? 2 : 1;
            this.setMoistness(this.getMoistness() - dry);
            if (this.getMoistness() <= 0 && this.moistureAttackTime-- <= 0) {
                this.hurtServer(this.level(), this.damageSources().dryOut(), this.random.nextInt(2) == 0 ? 1.0f : 0.0f);
                this.moistureAttackTime = 20;
            }
        }
        boolean flag1 = this.isInWater();
        if (this.level().isClientSide()) {
            if (flag1) {
                if (this.level().noCollision(this, this.getSwimmingBox())) {
                    if (!this.getDeeplingSwim()) {
                        this.setDeeplingSwim(true);
                    }
                    this.refreshDimensions();
                }
            } else if (this.level().noCollision(this, this.getNormalBox())) {
                if (this.getDeeplingSwim()) {
                    this.setDeeplingSwim(false);
                }
                this.refreshDimensions();
            }
        }
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Moistness", this.getMoistness());
        compound.putBoolean("DeeplingSwim", this.getDeeplingSwim());
    }

    public void readAdditionalSaveData(ValueInput compound) {
        this.setMoistness(compound.getIntOr("Moistness", 40000));
        this.setDeeplingSwim(compound.getBooleanOr("DeeplingSwim", false));
        super.readAdditionalSaveData(compound);
    }

    public int getMoistness() {
        return this.entityData.get(MOISTNESS);
    }

    public void setMoistness(int moistness) {
        this.entityData.set(MOISTNESS, moistness);
    }

    public boolean getDeeplingSwim() {
        return this.entityData.get(DEEPLINGSWIM);
    }

    public void setDeeplingSwim(boolean deeplingSwim) {
        this.entityData.set(DEEPLINGSWIM, deeplingSwim);
    }

    public void switchNavigator(boolean isLandNavigator) {
        this.isLandNavigator = isLandNavigator;
    }

    public boolean getIsLandNavigator() {
        return this.isLandNavigator;
    }

    @Override
    public boolean shouldEnterWater() {
        return true;
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }
}