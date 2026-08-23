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
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
 */
package com.skd.cataclysmbosses.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;

public class SoulLavaParticle
extends SingleQuadParticle {
    SoulLavaParticle(ClientLevel p_107074_, double p_107075_, double p_107076_, double p_107077_) {
        super(p_107074_, p_107075_, p_107076_, p_107077_, 0.0, 0.0, 0.0);
        this.gravity = 0.75f;
        this.friction = 0.999f;
        this.xd *= (double)0.8f;
        this.yd *= (double)0.8f;
        this.zd *= (double)0.8f;
        this.yd = this.random.nextFloat() * 0.4f + 0.05f;
        this.quadSize *= this.random.nextFloat() * 2.0f + 0.2f;
        this.lifetime = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float p_107086_) {
        int i = super.getLightColor(p_107086_);
        int j = 240;
        int k = i >> 16 & 0xFF;
        return 0xF0 | k << 16;
    }

    public float getQuadSize(float p_107089_) {
        float f = ((float)this.age + p_107089_) / (float)this.lifetime;
        return this.quadSize * (1.0f - f * f);
    }

    public void tick() {
        super.tick();
        if (!this.removed) {
            float f = (float)this.age / (float)this.lifetime;
            if (this.random.nextFloat() > f) {
                this.level.addParticle((ParticleOptions)ParticleTypes.SMOKE, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }
        }
    }

    public static class Factory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Factory(SpriteSet p_107092_) {
            this.sprite = p_107092_;
        }

        public Particle createParticle(SimpleParticleType p_107103_, ClientLevel p_107104_, double p_107105_, double p_107106_, double p_107107_, double p_107108_, double p_107109_, double p_107110_) {
            SoulLavaParticle lavaparticle = new SoulLavaParticle(p_107104_, p_107105_, p_107106_, p_107107_);
            lavaparticle.pickSprite(this.sprite);
            return lavaparticle;
        }
    }
}

