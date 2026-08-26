/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.skd.cataclysmbosses.init.ModTag;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class The_Leviathan_Tongue_Entity
extends Entity {
    private static final EntityDataAccessor<Optional<UUID>> CONTROLLER_UUID = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> CONTROLLER_ID = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TARGET_ID = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MAX_DURATION = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> COMING_BACK = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private int destroyBlocksTick;

    public The_Leviathan_Tongue_Entity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(CONTROLLER_UUID, Optional.empty());
        p_326229_.define(CONTROLLER_ID, -1);
        p_326229_.define(TARGET_ID, -1);
        p_326229_.define(DURATION, 0);
        p_326229_.define(MAX_DURATION, 0);
        p_326229_.define(COMING_BACK, false);
    }

    public void tick() {
        super.tick();
        Entity controller = this.getController();
        Entity target = this.getTarget();
        if (!this.getPassengers().isEmpty() && ((Entity)this.getPassengers().get(0)).isShiftKeyDown()) {
            ((Entity)this.getPassengers().get(0)).setShiftKeyDown(false);
        }
        if (this.getDuration() <= this.getMaxDuration()) {
            this.setDuration(this.getDuration() + 1);
        }
        if (!this.level().isClientSide()) {
            if (CMCommonConfig.Leviathan.ignoreMobGriefing) {
                this.blockbreak(0.25, 0.25, 0.25);
            } else if (EventHooks.canEntityGrief((Level)this.level(), (Entity)this)) {
                this.blockbreak(0.25, 0.25, 0.25);
            }
        }
        if (controller instanceof The_Leviathan_Entity) {
            The_Leviathan_Entity levi = (The_Leviathan_Entity)controller;
            this.entityData.set(CONTROLLER_ID, levi.getId());
            levi.setTongueUUID(this.getUUID());
            if (!this.level().isClientSide()) {
                LivingEntity e = levi.getTarget();
                this.entityData.set(TARGET_ID, (e != null && e.isAlive() ? e.getId() : -1));
            }
            boolean attacking = !this.getComingBack() && target != null && target.isAlive();
            Vec3 vec3 = attacking ? target.getEyePosition() : levi.getTonguePosition();
            float speed = attacking ? 0.095f : 0.15f;
            Vec3 want = vec3.subtract(this.position());
            if (target != null && !this.getComingBack() && want.length() < (double)(target.getBbWidth() + 1.0f)) {
                this.hurtEntity((LivingEntity)levi, target);
                this.setComingBack(true);
            }
            this.directMovementTowards(vec3, speed);
            if (this.getDuration() >= this.getMaxDuration() / 2 && !this.getComingBack()) {
                this.setComingBack(true);
            }
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale((double)0.9f));
    }

    private void hurtEntity(LivingEntity holder, Entity target) {
        if (target.hurtOrSimulate(this.damageSources().mobAttack(holder), 6.0f) && !this.level().isClientSide()) {
            target.startRiding((Entity)this);
        }
    }

    private void blockbreak(double x, double y, double z) {
        if (!this.level().isClientSide()) {
            if (this.destroyBlocksTick > 0) {
                --this.destroyBlocksTick;
                return;
            }
            boolean flag = false;
            AABB aabb = this.getBoundingBox().inflate(x, y, z);
            for (BlockPos blockpos : BlockPos.betweenClosed((int)Mth.floor((double)aabb.minX), (int)Mth.floor((double)aabb.minY), (int)Mth.floor((double)aabb.minZ), (int)Mth.floor((double)aabb.maxX), (int)Mth.floor((double)aabb.maxY), (int)Mth.floor((double)aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (blockstate.isAir() || !blockstate.canEntityDestroy((BlockGetter)this.level(), blockpos, (Entity)this) || blockstate.is(ModTag.LEVIATHAN_IMMUNE)) continue;
                flag = this.level().destroyBlock(blockpos, false, (Entity)this) || flag;
            }
            if (flag) {
                this.destroyBlocksTick = 15;
            }
        }
    }

    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return this.random.nextInt(3) + 1 == 3;
        }
        return true;
    }

    private void directMovementTowards(Vec3 moveTo, float speed) {
        Vec3 want = moveTo.subtract(this.position());
        if (want.length() > 1.0) {
            want = want.normalize();
        }
        float targetXRot = (float)(-(Mth.atan2((double)want.y, (double)want.horizontalDistance()) * 57.2957763671875));
        float targetYRot = (float)(-Mth.atan2((double)want.x, (double)want.z) * 57.2957763671875);
        this.setXRot(Mth.approachDegrees((float)this.getXRot(), (float)targetXRot, (float)5.0f));
        this.setYRot(Mth.approachDegrees((float)this.getYRot(), (float)targetYRot, (float)5.0f));
        this.setDeltaMovement(this.getDeltaMovement().add(want.scale((double)speed)));
    }

    public boolean shouldRiderSit() {
        return false;
    }

    protected void readAdditionalSaveData(ValueInput tag) {
        if (tag.read("ControllerUUID", UUIDUtil.CODEC).isPresent()) {
            this.setControllerUUID(tag.read("ControllerUUID", UUIDUtil.CODEC).orElse(null));
        }
        this.setDuration(tag.getIntOr("Duration", 0));
        this.setDuration(tag.getIntOr("Max_Duration", 0));
    }

    protected void addAdditionalSaveData(ValueOutput tag) {
        if (this.getControllerUUID() != null) {
            tag.store("ControllerUUID", UUIDUtil.CODEC, this.getControllerUUID());
        }
        tag.putInt("Duration", this.getDuration());
        tag.putInt("Max_Duration", this.getMaxDuration());
    }

    @Nullable
    public UUID getControllerUUID() {
        return ((Optional)this.entityData.get(CONTROLLER_UUID)).orElse(null);
    }

    public void setControllerUUID(@Nullable UUID uniqueId) {
        this.entityData.set(CONTROLLER_UUID, Optional.ofNullable(uniqueId));
    }

    public int getDuration() {
        return (Integer)this.entityData.get(DURATION);
    }

    public void setDuration(int i) {
        this.entityData.set(DURATION, i);
    }

    public int getMaxDuration() {
        return (Integer)this.entityData.get(MAX_DURATION);
    }

    public void setMaxDuration(int i) {
        this.entityData.set(MAX_DURATION, i);
    }

    public boolean getComingBack() {
        return (Boolean)this.entityData.get(COMING_BACK);
    }

    public void setComingBack(boolean i) {
        this.entityData.set(COMING_BACK, i);
    }

    public Entity getController() {
        if (!this.level().isClientSide()) {
            UUID id = this.getControllerUUID();
            return id == null ? null : ((ServerLevel)this.level()).getEntity(id);
        }
        int id = (Integer)this.entityData.get(CONTROLLER_ID);
        return id == -1 ? null : this.level().getEntity(id);
    }

    public Entity getTarget() {
        int id = (Integer)this.entityData.get(TARGET_ID);
        return id == -1 ? null : this.level().getEntity(id);
    }
}

