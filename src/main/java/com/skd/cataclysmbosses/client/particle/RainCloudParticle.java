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
 *  net.minecraft.core.particles.SimpleParticleType
 */
package com.skd.cataclysmbosses.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class RainCloudParticle
extends SingleQuadParticle {
    private final SpriteSet sprites;

    protected RainCloudParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.alpha = 0.6f;
        this.quadSize *= 8.0f;
        this.gravity = 0.0f;
        this.lifetime = (int)(Math.random() * 2.0) + 60;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TRANSLUCENT;
    }

    public float getQuadSize(float p_107608_) {
        float f = 1.0f - ((float)this.age + p_107608_) / ((float)this.lifetime * 1.5f);
        return this.quadSize * f;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double)this.friction;
            this.yd *= (double)this.friction;
            this.zd *= (double)this.friction;
        }
    }

    public static class Factory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Factory(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
            return new RainCloudParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

