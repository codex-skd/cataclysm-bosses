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
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.init.ModEntities;
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

public class SkyColor_Entity
extends Entity {
    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(SkyColor_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(SkyColor_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FADE_DURATION = SynchedEntityData.defineId(SkyColor_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> R = SynchedEntityData.defineId(SkyColor_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> G = SynchedEntityData.defineId(SkyColor_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> B = SynchedEntityData.defineId(SkyColor_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);

    public SkyColor_Entity(EntityType<?> type, Level world) {
        super(type, world);
    }

    public SkyColor_Entity(Level world, Vec3 position, float radius, int r, int g, int b, int duration, int fadeDuration) {
        super((EntityType)ModEntities.SKY_COLOR.get(), world);
        this.setRadius(radius);
        this.setR(r);
        this.setG(g);
        this.setB(b);
        this.setDuration(duration);
        this.setFadeDuration(fadeDuration);
        this.setPos(position.x, position.y, position.z);
    }

    @OnlyIn(value=Dist.CLIENT)
    public float getColorIntensity(Player player, float partialTicks) {
        float ticksDelta = (float)this.tickCount + partialTicks;
        float timeFrac = 1.0f - Mth.clamp((float)((ticksDelta - (float)this.getDuration()) / ((float)this.getFadeDuration() + 1.0f)), (float)0.0f, (float)1.0f);
        float baseIntensity = ticksDelta < (float)this.getDuration() ? 1.0f : timeFrac * timeFrac;
        Vec3 playerPos = player.getEyePosition(partialTicks);
        float effectRadius = this.getRadius();
        if (effectRadius <= 0.0f) {
            return 0.0f;
        }
        float distFrac = (float)(1.0 - Mth.clamp((double)(this.position().distanceTo(playerPos) / (double)effectRadius), (double)0.0, (double)1.0));
        return baseIntensity * distFrac * distFrac;
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && this.tickCount > this.getDuration() + this.getFadeDuration()) {
            this.discard();
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(RADIUS, (Object)Float.valueOf(10.0f));
        builder.define(R, (Object)0);
        builder.define(G, (Object)0);
        builder.define(B, (Object)0);
        builder.define(DURATION, (Object)0);
        builder.define(FADE_DURATION, (Object)5);
    }

    public float getRadius() {
        return ((Float)this.entityData.get(RADIUS)).floatValue();
    }

    public void setRadius(float radius) {
        this.entityData.set(RADIUS, (Object)Float.valueOf(radius));
    }

    public int getR() {
        return (Integer)this.entityData.get(R);
    }

    public void setR(int r) {
        this.entityData.set(R, (Object)r);
    }

    public int getG() {
        return (Integer)this.entityData.get(G);
    }

    public void setG(int g) {
        this.entityData.set(G, (Object)g);
    }

    public int getB() {
        return (Integer)this.entityData.get(B);
    }

    public void setB(int b) {
        this.entityData.set(B, (Object)b);
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
        this.setR(compound.getInt("R"));
        this.setG(compound.getInt("G"));
        this.setB(compound.getInt("B"));
        this.setDuration(compound.getInt("duration"));
        this.setFadeDuration(compound.getInt("fade_duration"));
        this.tickCount = compound.getInt("ticks_existed");
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("radius", this.getRadius());
        compound.putInt("R", this.getR());
        compound.putInt("G", this.getG());
        compound.putInt("B", this.getB());
        compound.putInt("duration", this.getDuration());
        compound.putInt("fade_duration", this.getFadeDuration());
        compound.putInt("ticks_existed", this.tickCount);
    }

    public static void color(Level world, Vec3 position, float radius, int r, int g, int b, int duration, int fadeDuration) {
        if (!world.isClientSide()) {
            SkyColor_Entity skyColorEntity = new SkyColor_Entity(world, position, radius, r, g, b, duration, fadeDuration);
            world.addFreshEntity((Entity)skyColorEntity);
        }
    }
}

