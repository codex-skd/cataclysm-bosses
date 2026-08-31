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
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.Options.LightningZapParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Lightning_Zap_Particle
extends SingleQuadParticle {
    private final SpriteSet sprites;
    private int getR;
    private int getG;
    private int getB;

    protected Lightning_Zap_Particle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, int r, int g, int b, float gravity) {
        super(level, x, y, z, (TextureAtlasSprite) null);
        this.gravity = gravity;
        this.friction = 0.1f;
        this.sprites = sprites;
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.rCol = (float)r / 255.0f;
        this.gCol = (float)g / 255.0f;
        this.bCol = (float)b / 255.0f;
        this.getR = r;
        this.getG = g;
        this.getB = b;
        this.quadSize = 0.25f + level.getRandom().nextFloat() * 0.15f;
        this.lifetime = 6;
        this.setSpriteFromAge(sprites);
    }

    public int getLightCoords(float p_106821_) {
        return 240;
    }

    public void tick() {
        super.tick();
        if (this.age == 3) {
            this.rCol = 1.0f;
            this.gCol = 1.0f;
            this.bCol = 1.0f;
        } else {
            this.rCol = (float)this.getR / 255.0f;
            this.gCol = (float)this.getG / 255.0f;
            this.bCol = (float)this.getB / 255.0f;
        }
        this.setSpriteFromAge(this.sprites);
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Provider
    implements ParticleProvider<LightningZapParticleOptions> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(LightningZapParticleOptions type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new Lightning_Zap_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites, type.r(), type.g(), type.b(), type.gravity());
        }
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

