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

public class CustomExplodeParticle
extends SingleQuadParticle {
    private final SpriteSet sprites;

    protected CustomExplodeParticle(ClientLevel world, double x, double y, double z, double xSpeed, SpriteSet sprites) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.quadSize = 2.0f * (1.0f - (float)xSpeed * 0.5f);
        this.lifetime = 7 + this.random.nextInt(4);
        this.sprites = sprites;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TRANSLUCENT;
    }

    public float getQuadSize(float scaleFactor) {
        return super.getQuadSize(scaleFactor);
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public static class LightningFactory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public LightningFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CustomExplodeParticle particle = new CustomExplodeParticle(worldIn, x, y, z, xSpeed, this.spriteSet);
            particle.setSpriteFromAge(this.spriteSet);
            particle.scale(0.5f);
            particle.setLifetime(5);
            return particle;
        }
    }

    public static class IgnisFactory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public IgnisFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CustomExplodeParticle particle = new CustomExplodeParticle(worldIn, x, y, z, xSpeed, this.spriteSet);
            particle.setSpriteFromAge(this.spriteSet);
            particle.scale(1.0f + worldIn.getRandom().nextFloat() * 0.9f);
            return particle;
        }
    }

    public static class FlareFactory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public FlareFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CustomExplodeParticle particle = new CustomExplodeParticle(worldIn, x, y, z, xSpeed, this.spriteSet);
            particle.setSpriteFromAge(this.spriteSet);
            particle.scale(1.0f + worldIn.getRandom().nextFloat() * 0.9f);
            return particle;
        }
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

