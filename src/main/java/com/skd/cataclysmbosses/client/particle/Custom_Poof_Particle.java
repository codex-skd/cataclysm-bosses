/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.SingleQuadParticle
 *  net.minecraft.util.Mth
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.Options.CustomPoofParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Custom_Poof_Particle
extends SingleQuadParticle {
    private final SpriteSet sprites;
    private float initialR;
    private float initialG;
    private float initialB;

    protected Custom_Poof_Particle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, float r, float g, float b, float gravity) {
        super(level, x, y, z);
        this.gravity = gravity;
        this.friction = 0.9f;
        this.sprites = sprites;
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.rCol = r / 255.0f;
        this.gCol = g / 255.0f;
        this.bCol = b / 255.0f;
        this.initialR = r / 255.0f;
        this.initialG = g / 255.0f;
        this.initialB = b / 255.0f;
        this.quadSize = 0.25f + level.getRandom().nextFloat() * 0.1f;
        this.lifetime = (int)(24.0 / ((double)this.random.nextFloat() * 0.8 + 0.2)) + 2;
        this.setSpriteFromAge(sprites);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TRANSLUCENT;
    }

    public int getLightColor(float p_106821_) {
        return 240;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.yd -= 0.04 * (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.speedUpWhenYMotionIsBlocked && this.y == this.yo) {
                this.xd *= 1.1;
                this.zd *= 1.1;
            }
            this.xd *= (double)this.friction;
            this.yd *= (double)this.friction;
            this.zd *= (double)this.friction;
            if (this.onGround) {
                this.xd *= (double)0.7f;
                this.zd *= (double)0.7f;
            }
            float progress = (float)this.age / (float)this.lifetime;
            this.rCol = Mth.lerp((float)progress, (float)this.initialR, (float)1.0f);
            this.gCol = Mth.lerp((float)progress, (float)this.initialG, (float)1.0f);
            this.bCol = Mth.lerp((float)progress, (float)this.initialB, (float)1.0f);
            this.alpha = Mth.lerp((float)progress, (float)1.0f, (float)0.5f);
        }
        this.setSpriteFromAge(this.sprites);
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Provider
    implements ParticleProvider<CustomPoofParticleOptions> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(CustomPoofParticleOptions type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new Custom_Poof_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites, type.r(), type.g(), type.b(), type.gravity());
        }
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

