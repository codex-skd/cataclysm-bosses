/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationChannel
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationChannel$Interpolations
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationChannel$Targets
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition$Builder
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedKeyframe
 *  com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations
 */
package com.skd.thesundering.client.animation;

import com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationChannel;
import com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedAnimationDefinition;
import com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedKeyframe;
import com.skd.nautilusapi.client.model.AdvancedAnimations.AdvancedKeyframeAnimations;

public class Axe_blade_Animation {
    public static final AdvancedAnimationDefinition IDLE = AdvancedAnimationDefinition.Builder.withLength((float)0.5f).looping().addAnimation("blade", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.POSITION, new AdvancedKeyframe[]{new AdvancedKeyframe(0.0f, AdvancedKeyframeAnimations.posVec((float)0.2762f, (float)0.0f, (float)0.0f), AdvancedAnimationChannel.Interpolations.LINEAR)})).addAnimation("blade", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE, new AdvancedKeyframe[]{new AdvancedKeyframe(0.0f, AdvancedKeyframeAnimations.scaleVec((double)1.0, (double)1.0, (double)1.0102f), AdvancedAnimationChannel.Interpolations.LINEAR)})).addAnimation("vfx", new AdvancedAnimationChannel(AdvancedAnimationChannel.Targets.SCALE, new AdvancedKeyframe[]{new AdvancedKeyframe(0.0f, AdvancedKeyframeAnimations.scaleVec((double)1.0, (double)1.0, (double)1.2628f), AdvancedAnimationChannel.Interpolations.LINEAR)})).build();
}

