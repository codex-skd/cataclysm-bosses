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
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.particle;

import com.skd.thesundering.client.particle.Options.RoarParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class RoarParticle
extends SingleQuadParticle {
    public int r;
    public int g;
    public int b;
    public float endsize;
    public float startsize;
    public float increase;
    private final SpriteSet sprites;

    public RoarParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ, int duration, int r, int g, int b, float opacity, float startsize, float increase, float endsize, SpriteSet sprites) {
        super(world, x, y, z);
        this.sprites = sprites;
        this.setSize(1.0f, 1.0f);
        this.setSpriteFromAge(this.sprites);
        this.quadSize = startsize;
        this.startsize = startsize;
        this.increase = increase;
        this.endsize = endsize;
        this.lifetime = duration;
        this.rCol = (float)r / 255.0f;
        this.gCol = (float)g / 255.0f;
        this.bCol = (float)b / 255.0f;
        this.alpha = opacity;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
    }

    public int getLightColor(float delta) {
        return 0xF0 | super.getLightColor(delta) & 0xFF0000;
    }

    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
            this.quadSize += this.increase;
            if (this.increase > 0.0f) {
                this.quadSize = Math.min(this.quadSize, this.endsize);
            } else if (this.increase < 0.0f) {
                this.quadSize = Math.max(this.quadSize, this.endsize);
            }
            this.alpha = Math.max(0.0f, 1.0f - (float)this.age / (float)this.lifetime);
        }
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class RoarFactory
    implements ParticleProvider<RoarParticleOptions> {
        private final SpriteSet spriteSet;

        public RoarFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(RoarParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            RoarParticle particle = new RoarParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.duration(), typeIn.r(), typeIn.g(), typeIn.b(), typeIn.a(), typeIn.startsize(), typeIn.increase(), typeIn.endsize(), this.spriteSet);
            return particle;
        }
    }
}

