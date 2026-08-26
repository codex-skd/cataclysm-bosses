/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  net.minecraft.core.component.DataComponents
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
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
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
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.component.ItemAttributeModifiers
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.AttackMoveGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.skd.cataclysmbosses.entity.etc.SmartBodyHelper2;
import com.skd.cataclysmbosses.entity.etc.path.CMPathNavigateGround;
import com.skd.cataclysmbosses.entity.projectile.Ashen_Breath_Entity;
import com.skd.cataclysmbosses.entity.projectile.Blazing_Bone_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.nautilusapi.server.animation.Animation;
import java.util.EnumSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Ignited_Revenant_Entity
extends LLibrary_Boss_Monster {
    public static final Animation ASH_BREATH_ATTACK = Animation.create((int)53);
    public static final Animation BONE_STORM_ATTACK = Animation.create((int)49);
    public static final int BREATH_COOLDOWN = 200;
    public static final int STORM_COOLDOWN = 200;
    private float allowedHeightOffset = 0.5f;
    private int nextHeightOffsetChangeTick;
    private static final EntityDataAccessor<Boolean> ANGER = SynchedEntityData.defineId(Ignited_Revenant_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> SHIELD_DURABILITY = SynchedEntityData.defineId(Ignited_Revenant_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    public float angerProgress;
    public float prevangerProgress;
    private int breath_cooldown = 0;
    private int storm_cooldown = 0;

    public Ignited_Revenant_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 25;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setConfigattribute((LivingEntity)this, CMCommonConfig.IgnitedRevenant.healthMultiplier, CMCommonConfig.IgnitedRevenant.attackMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, ASH_BREATH_ATTACK, BONE_STORM_ATTACK};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, (Goal)new Ignited_Revenant_Goal());
        this.goalSelector.addGoal(0, (Goal)new BoneStormGoal(this, BONE_STORM_ATTACK));
        this.goalSelector.addGoal(0, (Goal)new ShootGoal(this, ASH_BREATH_ATTACK));
        this.goalSelector.addGoal(7, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.targetSelector.addGoal(2, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, true));
    }

    public static AttributeSupplier.Builder ignited_revenant() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 20.0).add(Attributes.MOVEMENT_SPEED, (double)0.28f).add(Attributes.ATTACK_DAMAGE, 6.0).add(Attributes.MAX_HEALTH, 80.0).add(Attributes.ARMOR, 12.0).add(Attributes.STEP_HEIGHT, 1.5).add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation((ServerLevel)this.level(), stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        double itemDamage;
        LivingEntity living;
        ItemStack itemstack;
        Entity entity = source.getDirectEntity();
        if (!this.level().isClientSide() && this.getIsAnger() && entity instanceof LivingEntity && (itemstack = (living = (LivingEntity)entity).getMainHandItem()).getItem() instanceof AxeItem && (double)damage >= (itemDamage = this.getApproximateAttackDamageWithItem(living, itemstack) + 1.0) + itemDamage / 2.0 && this.getShieldDurability() < 4) {
            this.playSound(SoundEvents.WITHER_BREAK_BLOCK, 1.0f, 1.5f);
            this.setShieldDurability(this.getShieldDurability() + 1);
            return false;
        }
        if (damage > 0.0f && this.canBlockDamageSource(source)) {
            this.hurtCurrentlyUsedShield(damage);
            if (!source.is(DamageTypeTags.IS_PROJECTILE) && entity instanceof LivingEntity) {
                this.blockUsingShield((LivingEntity)entity);
            }
            this.playSound(SoundEvents.ANVIL_PLACE, 0.3f, 0.5f);
            return false;
        }
        return super.hurtOrSimulate(source, damage);
    }

    private double getApproximateAttackDamageWithItem(LivingEntity living, ItemStack p_330413_) {
        ItemAttributeModifiers itemattributemodifiers = (ItemAttributeModifiers)p_330413_.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, (Object)ItemAttributeModifiers.EMPTY);
        itemattributemodifiers = p_330413_.getAttributeModifiers();
        return itemattributemodifiers.compute(living.getAttributeBaseValue(Attributes.ATTACK_DAMAGE), EquipmentSlot.MAINHAND);
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Vec3 vector3d2;
        AbstractArrow abstractarrowentity;
        Entity entity = damageSourceIn.getDirectEntity();
        boolean flag = false;
        if (entity instanceof AbstractArrow && (abstractarrowentity = (AbstractArrow)entity).getPierceLevel() > 0) {
            flag = true;
        }
        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && !flag && this.getIsAnger() && this.getShieldDurability() < 4 && (vector3d2 = damageSourceIn.getSourcePosition()) != null) {
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
        p_326229_.define(ANGER, false);
        p_326229_.define(SHIELD_DURABILITY, 0);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
    }

    public void setIsAnger(boolean isAnger) {
        this.entityData.set(ANGER, isAnger);
    }

    public boolean getIsAnger() {
        return (Boolean)this.entityData.get(ANGER);
    }

    public void setShieldDurability(int ShieldDurability) {
        this.entityData.set(SHIELD_DURABILITY, ShieldDurability);
    }

    public int getShieldDurability() {
        return (Integer)this.entityData.get(SHIELD_DURABILITY);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (!this.onGround() && this.getDeltaMovement().y < 0.0) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.6, 1.0));
        }
        this.prevangerProgress = this.angerProgress;
        if (this.getIsAnger() && this.angerProgress < 5.0f) {
            this.angerProgress += 1.0f;
        }
        if (!this.getIsAnger() && this.angerProgress > 0.0f) {
            this.angerProgress -= 1.0f;
        }
        if (this.breath_cooldown > 0) {
            --this.breath_cooldown;
        }
        if (this.storm_cooldown > 0) {
            --this.storm_cooldown;
        }
        if (this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (this.breath_cooldown <= 0 && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.random.nextInt(35) == 0 && this.distanceTo((Entity)target) < 4.5f && this.getShieldDurability() < 4) {
                    this.breath_cooldown = 200;
                    this.setAnimation(ASH_BREATH_ATTACK);
                } else if (this.storm_cooldown <= 0 && this.distanceTo((Entity)target) < 6.0f && !this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.random.nextInt(15) == 0) {
                    this.storm_cooldown = 200;
                    this.setAnimation(BONE_STORM_ATTACK);
                } else if (!this.isNoAi() && this.getAnimation() == NO_ANIMATION && this.random.nextInt(12) == 0 && this.distanceTo((Entity)target) < 4.5f && this.getShieldDurability() > 3) {
                    this.setAnimation(ASH_BREATH_ATTACK);
                }
            }
            if (this.getAnimation() == NO_ANIMATION && this.getIsAnger() && this.getShieldDurability() < 4 && this.tickCount % (6 + this.getShieldDurability() * 2) == 0) {
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.25))) {
                    boolean flag;
                    if (this.isAlliedTo((Entity)entity) || entity instanceof Ignited_Revenant_Entity || entity == this || !(flag = entity.hurtOrSimulate(this.damageSources().mobAttack((LivingEntity)this), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE)))) continue;
                    double d0 = entity.getX() - this.getX();
                    double d1 = entity.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    entity.push(d0 / d2 * 1.5, 0.2, d1 / d2 * 1.5);
                }
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

    protected SoundEvent getAmbientSound() {
        return (SoundEvent)ModSounds.REVENANT_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return (SoundEvent)ModSounds.REVENANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return (SoundEvent)ModSounds.REVENANT_DEATH.get();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
    }

    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2((Mob)this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround((Mob)this, worldIn);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    private void launchbone1() {
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0f, 0.75f);
        for (int i = 0; i < 8; ++i) {
            float yawRadians = (float)Math.toRadians(90.0f + this.getYRot());
            float throwAngle = yawRadians + (float)i * (float)Math.PI / 4.0f;
            double sx = this.getX() + (double)(Mth.cos((float)throwAngle) * 1.0f);
            double sy = this.getY() + (double)this.getBbHeight() * 0.62;
            double sz = this.getZ() + (double)(Mth.sin((float)throwAngle) * 1.0f);
            double vx = Mth.cos((float)throwAngle);
            double vy = 0.0;
            double vz = Mth.sin((float)throwAngle);
            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.level(), (float)CMCommonConfig.IgnitedRevenant.BlazingBoneDamage, (LivingEntity)this);
            projectile.moveTo(sx, sy, sz, (float)i * 45.0f, this.getXRot());
            float speed = 0.5f;
            projectile.shoot(vx, vy, vz, speed, 1.0f);
            this.level().addFreshEntity((Entity)projectile);
        }
    }

    private void launchbone2() {
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0f, 0.75f);
        for (int i = 0; i < 6; ++i) {
            float yawRadians = (float)Math.toRadians(90.0f + this.getYRot());
            float throwAngle = yawRadians + (float)i * (float)Math.PI / 3.0f;
            double sx = this.getX() + (double)(Mth.cos((float)throwAngle) * 1.0f);
            double sy = this.getY() + (double)this.getBbHeight() * 0.62;
            double sz = this.getZ() + (double)(Mth.sin((float)throwAngle) * 1.0f);
            double vx = Mth.cos((float)throwAngle);
            double vy = 0.0;
            double vz = Mth.sin((float)throwAngle);
            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.level(), (float)CMCommonConfig.IgnitedRevenant.BlazingBoneDamage, (LivingEntity)this);
            projectile.moveTo(sx, sy, sz, (float)i * 60.0f, this.getXRot());
            float speed = 0.6f;
            projectile.shoot(vx, vy, vz, speed, 1.0f);
            this.level().addFreshEntity((Entity)projectile);
        }
    }

    private void launchbone3() {
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0f, 0.75f);
        for (int i = 0; i < 10; ++i) {
            float yawRadians = (float)Math.toRadians(90.0f + this.getYRot());
            float throwAngle = yawRadians + (float)i * (float)Math.PI / 5.0f;
            double sx = this.getX() + (double)(Mth.cos((float)throwAngle) * 1.0f);
            double sy = this.getY() + (double)this.getBbHeight() * 0.62;
            double sz = this.getZ() + (double)(Mth.sin((float)throwAngle) * 1.0f);
            double vx = Mth.cos((float)throwAngle);
            double vy = 0.0;
            double vz = Mth.sin((float)throwAngle);
            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.level(), (float)CMCommonConfig.IgnitedRevenant.BlazingBoneDamage, (LivingEntity)this);
            projectile.moveTo(sx, sy, sz, (float)i * 36.0f, this.getXRot());
            float speed = 0.4f;
            projectile.shoot(vx, vy, vz, speed, 1.0f);
            this.level().addFreshEntity((Entity)projectile);
        }
    }

    class Ignited_Revenant_Goal
    extends AttackMoveGoal {
        public Ignited_Revenant_Goal() {
            super(Ignited_Revenant_Entity.this, true, 1.1);
        }

        @Override
        public void start() {
            super.start();
            Ignited_Revenant_Entity.this.setIsAnger(true);
        }

        @Override
        public void stop() {
            super.stop();
            Ignited_Revenant_Entity.this.setIsAnger(false);
        }
    }

    class BoneStormGoal
    extends SimpleAnimationGoal<Ignited_Revenant_Entity> {
        public BoneStormGoal(Ignited_Revenant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = ((Ignited_Revenant_Entity)this.entity).getTarget();
            if (target != null) {
                ((Ignited_Revenant_Entity)this.entity).getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
            }
            if (((Ignited_Revenant_Entity)this.entity).getAnimationTick() == 5) {
                switch (Ignited_Revenant_Entity.this.getRandom().nextInt(3)) {
                    case 0: {
                        Ignited_Revenant_Entity.this.launchbone1();
                        break;
                    }
                    case 1: {
                        Ignited_Revenant_Entity.this.launchbone2();
                        break;
                    }
                    case 2: {
                        Ignited_Revenant_Entity.this.launchbone3();
                        break;
                    }
                }
            }
            if (((Ignited_Revenant_Entity)this.entity).getAnimationTick() == 10) {
                switch (Ignited_Revenant_Entity.this.getRandom().nextInt(3)) {
                    case 0: {
                        Ignited_Revenant_Entity.this.launchbone1();
                        break;
                    }
                    case 1: {
                        Ignited_Revenant_Entity.this.launchbone2();
                        break;
                    }
                    case 2: {
                        Ignited_Revenant_Entity.this.launchbone3();
                        break;
                    }
                }
            }
            if (((Ignited_Revenant_Entity)this.entity).getAnimationTick() == 15) {
                switch (Ignited_Revenant_Entity.this.getRandom().nextInt(3)) {
                    case 0: {
                        Ignited_Revenant_Entity.this.launchbone1();
                        break;
                    }
                    case 1: {
                        Ignited_Revenant_Entity.this.launchbone2();
                        break;
                    }
                    case 2: {
                        Ignited_Revenant_Entity.this.launchbone3();
                        break;
                    }
                }
            }
            if (((Ignited_Revenant_Entity)this.entity).getAnimationTick() == 20) {
                switch (Ignited_Revenant_Entity.this.getRandom().nextInt(3)) {
                    case 0: {
                        Ignited_Revenant_Entity.this.launchbone1();
                        break;
                    }
                    case 1: {
                        Ignited_Revenant_Entity.this.launchbone2();
                        break;
                    }
                    case 2: {
                        Ignited_Revenant_Entity.this.launchbone3();
                        break;
                    }
                }
            }
            --((Ignited_Revenant_Entity)this.entity).nextHeightOffsetChangeTick;
            if (((Ignited_Revenant_Entity)this.entity).nextHeightOffsetChangeTick <= 0) {
                ((Ignited_Revenant_Entity)this.entity).nextHeightOffsetChangeTick = 100;
                ((Ignited_Revenant_Entity)this.entity).allowedHeightOffset = (float)((Ignited_Revenant_Entity)this.entity).random.triangle(0.5, 6.891);
            }
            if (target != null && target.getEyeY() > ((Ignited_Revenant_Entity)this.entity).getEyeY() + (double)((Ignited_Revenant_Entity)this.entity).allowedHeightOffset && ((Ignited_Revenant_Entity)this.entity).canAttack(target)) {
                Vec3 vec3 = ((Ignited_Revenant_Entity)this.entity).getDeltaMovement();
                ((Ignited_Revenant_Entity)this.entity).setDeltaMovement(((Ignited_Revenant_Entity)this.entity).getDeltaMovement().add(0.0, ((double)0.3f - vec3.y) * (double)0.3f, 0.0));
            }
        }
    }

    class ShootGoal
    extends SimpleAnimationGoal<Ignited_Revenant_Entity> {
        public ShootGoal(Ignited_Revenant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            super.start();
            Ignited_Revenant_Entity.this.setIsAnger(true);
        }

        public void stop() {
            super.stop();
            Ignited_Revenant_Entity.this.setIsAnger(false);
        }

        public void tick() {
            LivingEntity target = Ignited_Revenant_Entity.this.getTarget();
            if (target != null) {
                if (Ignited_Revenant_Entity.this.getAnimationTick() < 27) {
                    Ignited_Revenant_Entity.this.getLookControl().setLookAt((Entity)target, 30.0f, 30.0f);
                } else {
                    Ignited_Revenant_Entity.this.getLookControl().setLookAt((Entity)target, 3.0f, 30.0f);
                }
            }
            if (Ignited_Revenant_Entity.this.getAnimationTick() == 21) {
                Ignited_Revenant_Entity.this.playSound((SoundEvent)ModSounds.REVENANT_BREATH.get(), 1.0f, 1.0f);
            }
            Vec3 mouthPos = new Vec3(0.0, 2.3, 0.0);
            mouthPos = mouthPos.yRot((float)Math.toRadians(-Ignited_Revenant_Entity.this.getYRot() - 90.0f));
            mouthPos = mouthPos.add(Ignited_Revenant_Entity.this.position());
            mouthPos = mouthPos.add(new Vec3(0.0, 0.0, 0.0).xRot((float)Math.toRadians(-Ignited_Revenant_Entity.this.getXRot())).yRot((float)Math.toRadians(-Ignited_Revenant_Entity.this.yHeadRot)));
            Ashen_Breath_Entity breath = new Ashen_Breath_Entity((EntityType<? extends Ashen_Breath_Entity>)((EntityType)ModEntities.ASHEN_BREATH.get()), Ignited_Revenant_Entity.this.level(), (float)CMCommonConfig.IgnitedRevenant.AshenbreathDamage, (LivingEntity)Ignited_Revenant_Entity.this);
            if (Ignited_Revenant_Entity.this.getAnimationTick() == 27) {
                breath.absMoveTo(mouthPos.x, mouthPos.y, mouthPos.z, Ignited_Revenant_Entity.this.yHeadRot, Ignited_Revenant_Entity.this.getXRot());
                Ignited_Revenant_Entity.this.level().addFreshEntity((Entity)breath);
            }
        }
    }
}

