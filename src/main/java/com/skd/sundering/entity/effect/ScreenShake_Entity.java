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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.entity.effect;

import com.skd.sundering.init.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class ScreenShake_Entity
extends Entity {
    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(ScreenShake_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> MAGNITUDE = SynchedEntityData.defineId(ScreenShake_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(ScreenShake_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FADE_DURATION = SynchedEntityData.defineId(ScreenShake_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public ScreenShake_Entity(EntityType<?> type, Level world) {
        super(type, world);
    }

    public ScreenShake_Entity(Level world, Vec3 position, float radius, float magnitude, int duration, int fadeDuration) {
        super((EntityType)ModEntities.SCREEN_SHAKE.get(), world);
        this.setRadius(radius);
        this.setMagnitude(magnitude);
        this.setDuration(duration);
        this.setFadeDuration(fadeDuration);
        this.setPos(position.x, position.y, position.z);
    }

    @OnlyIn(value=Dist.CLIENT)
    public float getShakeAmount(Player player, float delta) {
        float ticksDelta = (float)this.tickCount + delta;
        float timeFrac = 1.0f - (ticksDelta - (float)this.getDuration()) / ((float)this.getFadeDuration() + 1.0f);
        float baseAmount = ticksDelta < (float)this.getDuration() ? this.getMagnitude() : timeFrac * timeFrac * this.getMagnitude();
        Vec3 playerPos = player.getEyePosition(delta);
        float distFrac = (float)(1.0 - Mth.clamp((double)(this.position().distanceTo(playerPos) / (double)this.getRadius()), (double)0.0, (double)1.0));
        return baseAmount * distFrac * distFrac;
    }

    public void tick() {
        super.tick();
        if (this.tickCount > this.getDuration() + this.getFadeDuration()) {
            this.discard();
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(RADIUS, (Object)Float.valueOf(10.0f));
        p_326229_.define(MAGNITUDE, (Object)Float.valueOf(1.0f));
        p_326229_.define(DURATION, (Object)0);
        p_326229_.define(FADE_DURATION, (Object)5);
    }

    public float getRadius() {
        return ((Float)this.entityData.get(RADIUS)).floatValue();
    }

    public void setRadius(float radius) {
        this.entityData.set(RADIUS, (Object)Float.valueOf(radius));
    }

    public float getMagnitude() {
        return ((Float)this.entityData.get(MAGNITUDE)).floatValue();
    }

    public void setMagnitude(float magnitude) {
        this.entityData.set(MAGNITUDE, (Object)Float.valueOf(magnitude));
    }

    public int getDuration() {
        return (Integer)this.entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        this.entityData.set(DURATION, (Object)duration);
    }

    public int getFadeDuration() {
        return (Integer)this.entityData.get(FADE_DURATION);
    }

    public void setFadeDuration(int fadeDuration) {
        this.entityData.set(FADE_DURATION, (Object)fadeDuration);
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setRadius(compound.getFloat("radius"));
        this.setMagnitude(compound.getFloat("magnitude"));
        this.setDuration(compound.getInt("duration"));
        this.setFadeDuration(compound.getInt("fade_duration"));
        this.tickCount = compound.getInt("ticks_existed");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("radius", this.getRadius());
        compound.putFloat("magnitude", this.getMagnitude());
        compound.putInt("duration", this.getDuration());
        compound.putInt("fade_duration", this.getFadeDuration());
        compound.putInt("ticks_existed", this.tickCount);
    }

    public static void ScreenShake(Level world, Vec3 position, float radius, float magnitude, int duration, int fadeDuration) {
        if (!world.isClientSide()) {
            ScreenShake_Entity ScreenShake = new ScreenShake_Entity(world, position, radius, magnitude, duration, fadeDuration);
            world.addFreshEntity((Entity)ScreenShake);
        }
    }
}

