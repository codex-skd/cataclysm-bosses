/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.SingleQuadParticle
 *  net.minecraft.core.particles.SimpleParticleType
 */
package com.skd.cataclysmbosses.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class TrapFlameParticle
extends SingleQuadParticle {
    private final SpriteSet sprites;
    private float prevAlpha = 0.0f;

    protected TrapFlameParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed, (TextureAtlasSprite) null);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.quadSize = 0.4f + world.getRandom().nextFloat() * 0.25f;
        this.lifetime = 10 + world.getRandom().nextInt(20);
        this.friction = 0.99f;
    }

    public void tick() {
        this.setSpriteFromAge(this.sprites);
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        float ageProgress = (float)this.age / (float)this.lifetime;
        float f = ageProgress - 0.5f;
        float scale = 1.0f + ageProgress * 0.5f;
        float f1 = 1.0f - f * 2.0f;
        if (ageProgress > 0.5f) {
            this.prevAlpha = this.alpha;
            this.setAlpha(this.prevAlpha + (f1 - this.prevAlpha) * Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false));
        }
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.scale(scale);
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double)this.friction;
            this.yd *= (double)this.friction;
            this.zd *= (double)this.friction;
        }
    }

    public int getLightCoords(float partialTicks) {
        return 240;
    }

    public Particle scale(float p_107683_) {
        this.quadSize = p_107683_;
        return this;
    }

    public static class Factory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            TrapFlameParticle particle = new TrapFlameParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
            return particle;
        }
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

