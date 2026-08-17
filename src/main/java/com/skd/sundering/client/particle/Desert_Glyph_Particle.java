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
package com.skd.sundering.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class Desert_Glyph_Particle
extends SingleQuadParticle {
    private final SpriteSet sprites;

    protected Desert_Glyph_Particle(ClientLevel world, double x, double y, double z, double xSpeed, SpriteSet sprites) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.quadSize = 2.0f * (1.0f - (float)xSpeed * 0.5f);
        this.lifetime = 6;
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
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public float getQuadSize(float scaleFactor) {
        return super.getQuadSize(scaleFactor);
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public static class GlyphFactory
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public GlyphFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Desert_Glyph_Particle particle = new Desert_Glyph_Particle(worldIn, x, y, z, xSpeed, this.spriteSet);
            particle.setSpriteFromAge(this.spriteSet);
            particle.scale(1.0f);
            return particle;
        }
    }
}

