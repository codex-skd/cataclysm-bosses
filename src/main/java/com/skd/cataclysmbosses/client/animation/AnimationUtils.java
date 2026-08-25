/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.floats.FloatUnaryOperator
 *  net.minecraft.client.animation.AnimationChannel
 *  net.minecraft.client.animation.AnimationChannel$Interpolations
 *  net.minecraft.client.animation.AnimationChannel$Targets
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.animation.Keyframe
 *  net.minecraft.client.animation.KeyframeAnimations
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Vector3f
 */
package com.skd.cataclysmbosses.client.animation;

import it.unimi.dsi.fastutil.floats.FloatUnaryOperator;
import java.util.ArrayList;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
// import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
// import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class AnimationUtils {
    public static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();

    public static Vec3 calculateViewVector(float xRot, float yRot) {
        float f = xRot * ((float)Math.PI / 180);
        float f1 = -yRot * ((float)Math.PI / 180);
        float f2 = Mth.cos((float)f1);
        float f3 = Mth.sin((float)f1);
        float f4 = Mth.cos((float)f);
        float f5 = Mth.sin((float)f);
        return new Vec3((double)(f3 * f4), (double)(-f5), (double)(f2 * f4));
    }

//         public static void animateAmplitude(HierarchicalModel<?> model, AnimationState anim, AnimationDefinition animDef, float tick, float speed, float amplitude) {
//             anim.updateTime(tick, speed);
//             anim.ifStarted(p_233392_ -> KeyframeAnimations.animate((HierarchicalModel)model, (AnimationDefinition)animDef, (long)p_233392_.getAccumulatedTime(), (float)amplitude, (Vector3f)ANIMATION_VECTOR_CACHE));
//         }
//     
//         public static void animateWalkAmplitude(HierarchicalModel<?> model, AnimationDefinition animDef, float limbSwing, float limbSwingAmount, float speed, float amplitude) {
//             long i = (long)(limbSwing * 50.0f * speed);
//             float f = limbSwingAmount * amplitude;
//             KeyframeAnimations.animate(model, (AnimationDefinition)animDef, (long)i, (float)f, (Vector3f)ANIMATION_VECTOR_CACHE);
//         }

    public static void progressPositionPrev(ModelPart model, float progress, float rotX, float rotY, float rotZ, float divisor) {
        model.x += progress * rotX / divisor;
        model.y += progress * rotY / divisor;
        model.z += progress * rotZ / divisor;
    }

    public static void progressRotationPrev(ModelPart model, float progress, float x, float y, float z, float divisor) {
        model.xRot += progress * x / divisor;
        model.yRot += progress * y / divisor;
        model.zRot += progress * z / divisor;
    }

    public static AnimationChannel molangRotationChannel(float length, float step, FloatUnaryOperator degXFunc, FloatUnaryOperator degYFunc, FloatUnaryOperator degZFunc) {
        ArrayList<Keyframe> frames = new ArrayList<Keyframe>();
        for (float t = 0.0f; t < length - 1.0E-6f; t += step) {
            float degX = degXFunc.apply(t);
            float degY = degYFunc.apply(t);
            float degZ = degZFunc.apply(t);
            frames.add(new Keyframe(t, KeyframeAnimations.degreeVec((float)degX, (float)degY, (float)degZ), AnimationChannel.Interpolations.CATMULLROM));
        }
        frames.add(new Keyframe(length, KeyframeAnimations.degreeVec((float)degXFunc.apply(length), (float)degYFunc.apply(length), (float)degZFunc.apply(length)), AnimationChannel.Interpolations.CATMULLROM));
        return new AnimationChannel(AnimationChannel.Targets.ROTATION, frames.toArray(new Keyframe[0]));
    }

    public static AnimationChannel molangPostionChannel(float length, float step, FloatUnaryOperator degXFunc, FloatUnaryOperator degYFunc, FloatUnaryOperator degZFunc) {
        ArrayList<Keyframe> frames = new ArrayList<Keyframe>();
        for (float t = 0.0f; t < length - 1.0E-6f; t += step) {
            float degX = degXFunc.apply(t);
            float degY = degYFunc.apply(t);
            float degZ = degZFunc.apply(t);
            frames.add(new Keyframe(t, KeyframeAnimations.posVec((float)degX, (float)degY, (float)degZ), AnimationChannel.Interpolations.CATMULLROM));
        }
        frames.add(new Keyframe(length, KeyframeAnimations.posVec((float)degXFunc.apply(length), (float)degYFunc.apply(length), (float)degZFunc.apply(length)), AnimationChannel.Interpolations.CATMULLROM));
        return new AnimationChannel(AnimationChannel.Targets.POSITION, frames.toArray(new Keyframe[0]));
    }
}

