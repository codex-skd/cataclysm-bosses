/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.RisingParticle
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.core.particles.SimpleParticleType
 */
package com.skd.cataclysmbosses.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.RisingParticle;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class Phantom_Wing_FlameParticle
extends RisingParticle {
    private SpriteSet sprites;
    protected boolean isGlowing;

    Phantom_Wing_FlameParticle(ClientLevel p_107717_, double p_107718_, double p_107719_, double p_107720_, double p_107721_, double p_107722_, double p_107723_, TextureAtlasSprite sprite) {
        super(p_107717_, p_107718_, p_107719_, p_107720_, p_107721_, p_107722_, p_107723_, sprite);
        this.scale(1.5f);
    }

    public int getLightCoords(float p_234080_) {
        return this.isGlowing ? 240 : super.getLightCoords(p_234080_);
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }

    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
    }

    public static class Provider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet p_107739_) {
            this.sprite = p_107739_;
        }

        public Particle createParticle(SimpleParticleType p_107750_, ClientLevel p_107751_, double p_107752_, double p_107753_, double p_107754_, double p_107755_, double p_107756_, double p_107757_, RandomSource random) {
            Phantom_Wing_FlameParticle Phantom_Wing_FlameParticle2 = new Phantom_Wing_FlameParticle(p_107751_, p_107752_, p_107753_, p_107754_, p_107755_, p_107756_, p_107757_, this.sprite.get(random));
            Phantom_Wing_FlameParticle2.sprites = this.sprite;
            Phantom_Wing_FlameParticle2.setAlpha(1.0f);
            return Phantom_Wing_FlameParticle2;
        }
    }

    public static class EmissiveProvider
    implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public EmissiveProvider(SpriteSet p_234083_) {
            this.sprite = p_234083_;
        }

        public Particle createParticle(SimpleParticleType p_234094_, ClientLevel p_234095_, double p_234096_, double p_234097_, double p_234098_, double p_234099_, double p_234100_, double p_234101_, RandomSource random) {
            Phantom_Wing_FlameParticle Phantom_Wing_FlameParticle2 = new Phantom_Wing_FlameParticle(p_234095_, p_234096_, p_234097_, p_234098_, p_234099_, p_234100_, p_234101_, this.sprite.get(random));
            Phantom_Wing_FlameParticle2.sprites = this.sprite;
            Phantom_Wing_FlameParticle2.setAlpha(1.0f);
            Phantom_Wing_FlameParticle2.isGlowing = true;
            return Phantom_Wing_FlameParticle2;
        }
    }
}

