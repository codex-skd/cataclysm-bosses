/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.animation.AnimationChannel
 *  net.minecraft.client.animation.AnimationChannel$Interpolations
 *  net.minecraft.client.animation.AnimationChannel$Targets
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.animation.AnimationDefinition$Builder
 *  net.minecraft.client.animation.Keyframe
 *  net.minecraft.client.animation.KeyframeAnimations
 */
package com.skd.sundering.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class Elemental_Spear_Animation {
    public static final AnimationDefinition SPAWN = AnimationDefinition.Builder.withLength((float)0.25f).addAnimation("rot", new AnimationChannel(AnimationChannel.Targets.SCALE, new Keyframe[]{new Keyframe(0.0f, KeyframeAnimations.scaleVec((double)0.0, (double)0.0, (double)0.0), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.125f, KeyframeAnimations.scaleVec((double)0.5, (double)0.5, (double)1.8f), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.1667f, KeyframeAnimations.scaleVec((double)1.0, (double)1.0, (double)1.0), AnimationChannel.Interpolations.CATMULLROM), new Keyframe(0.25f, KeyframeAnimations.scaleVec((double)1.0, (double)1.0, (double)1.0), AnimationChannel.Interpolations.CATMULLROM)})).build();
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength((float)0.5f).looping().addAnimation("rot", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe[]{new Keyframe(0.0f, KeyframeAnimations.degreeVec((float)0.0f, (float)0.0f, (float)0.0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec((float)0.0f, (float)0.0f, (float)-360.0f), AnimationChannel.Interpolations.LINEAR)})).build();
}

