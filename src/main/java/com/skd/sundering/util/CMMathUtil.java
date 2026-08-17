/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.DoubleTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Quaternionf
 */
package com.skd.sundering.util;

import io.netty.buffer.ByteBuf;
import java.util.Optional;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;

public class CMMathUtil {
    public static float approachSmooth(float current, float previous, float desired, float desiredSpeed, float deltaSpeed) {
        float prevSpeed = current - previous;
        desiredSpeed = Mth.abs((float)desiredSpeed);
        desiredSpeed = current < desired ? desiredSpeed : -desiredSpeed;
        float speed = Mth.approach((float)prevSpeed, (float)desiredSpeed, (float)deltaSpeed);
        float speedApproachReduction = (float)(1.0 - Math.pow(Mth.clamp((float)(-Mth.abs((float)(current - desired)) / Mth.abs((float)(2.0f * desiredSpeed / deltaSpeed)) + 1.0f), (float)0.0f, (float)1.0f), 4.0));
        return current < desired ? Mth.clamp((float)(current + speed), (float)current, (float)desired) : Mth.clamp((float)(current + (speed *= speedApproachReduction)), (float)desired, (float)current);
    }

    public static float approachDegreesSmooth(float current, float previous, float desired, float desiredSpeed, float deltaSpeed) {
        float desiredDifference = Mth.degreesDifference((float)current, (float)desired);
        float previousDifference = Mth.degreesDifference((float)current, (float)previous);
        return CMMathUtil.approachSmooth(current, current + previousDifference, current + desiredDifference, desiredSpeed, deltaSpeed);
    }

    public static Quaternionf quatFromRotationXYZ(float x, float y, float z, boolean degrees) {
        if (degrees) {
            x *= (float)Math.PI / 180;
            y *= (float)Math.PI / 180;
            z *= (float)Math.PI / 180;
        }
        return new Quaternionf().rotationXYZ(x, y, z);
    }

    public static Vec3 getOffsetPos(Entity entity, double offsetX, double offsetY, double offsetZ, float rotationX, float rotationY) {
        Vec3 Vec32 = new Vec3(offsetZ, offsetY, offsetX).zRot(rotationX * ((float)Math.PI / 180)).yRot(-rotationY * ((float)Math.PI / 180) - 1.5707964f);
        return entity.position().add(Vec32.x, Vec32.y, Vec32.z);
    }

    public static Vec3 getOffsetMotion(Entity entity, double offsetX, double offsetY, double offsetZ, float rotationX, float rotationY) {
        Vec3 Vec32 = new Vec3(offsetZ, offsetY, offsetX).zRot(rotationX * ((float)Math.PI / 180)).yRot(-rotationY * ((float)Math.PI / 180) - 1.5707964f);
        return Vec32;
    }

    public static float smin(float a, float b, float k) {
        float h = Math.max(k - Math.abs(a - b), 0.0f) / k;
        return Math.min(a, b) - h * h * k * 0.25f;
    }

    public static float getAngle(Vec2 a, Vec2 b) {
        return CMMathUtil.getAngle(a.x, a.y, b.x, b.y);
    }

    public static float getAngle(double ax, double ay, double bx, double by) {
        return (float)Math.atan2(by - ay, bx - ax) + (float)Math.PI;
    }

    public static float cullAnimationTick(int tick, float amplitude, float partialTick, int startOffset, int endAt) {
        float i = Mth.clamp((float)((float)tick + partialTick - (float)startOffset), (float)0.0f, (float)endAt);
        float f = (float)Math.sin((double)(i / (float)endAt) * Math.PI) * amplitude;
        return CMMathUtil.smin(f, 1.0f, 0.1f);
    }

    public static Optional<Vec3> readVec3(CompoundTag tag, String key) {
        ListTag listTag = tag.getList(key, 6);
        if (listTag.size() == 3) {
            double x = listTag.getDouble(0);
            double y = listTag.getDouble(1);
            double z = listTag.getDouble(2);
            return Optional.of(new Vec3(x, y, z));
        }
        return Optional.empty();
    }

    public static ListTag writeVec3(Vec3 pos) {
        ListTag listTag = new ListTag();
        listTag.add((Object)DoubleTag.valueOf((double)pos.x));
        listTag.add((Object)DoubleTag.valueOf((double)pos.y));
        listTag.add((Object)DoubleTag.valueOf((double)pos.z));
        return listTag;
    }

    public static Vec3 readVec3(ByteBuf buf) {
        return new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }

    public static void writeVec3(ByteBuf buf, Vec3 vec3) {
        buf.writeDouble(vec3.x());
        buf.writeDouble(vec3.y());
        buf.writeDouble(vec3.z());
    }
}

