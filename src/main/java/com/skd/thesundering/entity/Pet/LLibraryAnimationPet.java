/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.Animation
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 */
package com.skd.thesundering.entity.Pet;

import com.skd.thesundering.entity.Pet.AnimationPet;
import com.skd.thesundering.entity.etc.IFollower;
import com.skd.nautilusapi.server.animation.Animation;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class LLibraryAnimationPet
extends AnimationPet
implements IAnimatedEntity,
IFollower {
    private int animationTick;
    private Animation currentAnimation;

    public LLibraryAnimationPet(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void onAnimationFinish(Animation animation) {
    }

    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION};
    }

    public int getAnimationTick() {
        return this.animationTick;
    }

    public void setAnimationTick(int tick) {
        this.animationTick = tick;
    }

    public Animation getAnimation() {
        return this.currentAnimation;
    }

    public void setAnimation(Animation animation) {
        if (animation == NO_ANIMATION) {
            this.onAnimationFinish(this.currentAnimation);
        }
        this.currentAnimation = animation;
        this.setAnimationTick(0);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }
}

