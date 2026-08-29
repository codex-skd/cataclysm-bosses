/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.SingleQuadParticle
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.util.CMMathUtil;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class RingParticle
extends SingleQuadParticle {
    public int r;
    public int g;
    public int b;
    public float opacity;
    public boolean facesCamera;
    public float yaw;
    public float pitch;
    public float size;
    private final SpriteSet sprites;
    public int behavior;

    public RingParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ, float yaw, float pitch, int duration, int r, int g, int b, float opacity, float size, boolean facesCamera, int behavior, SpriteSet sprites) {
        super(world, x, y, z, (TextureAtlasSprite) null);
        this.sprites = sprites;
        this.setSize(1.0f, 1.0f);
        this.setSpriteFromAge(this.sprites);
        this.size = size * 0.1f;
        this.lifetime = duration;
        this.alpha = 1.0f;
        this.r = r;
        this.g = g;
        this.b = b;
        this.rCol = r / 255.0f;
        this.gCol = g / 255.0f;
        this.bCol = b / 255.0f;
        this.opacity = opacity;
        this.yaw = yaw;
        this.pitch = pitch;
        this.facesCamera = facesCamera;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
        this.behavior = behavior;
    }

    public int getLightCoords(float delta) {
        return 0xF0 | super.getLightCoords(delta) & 0xFF0000;
    }

    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class RingFactory
    implements ParticleProvider<RingParticleOptions> {
        private final SpriteSet spriteSet;

        public RingFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(RingParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            RingParticle particle = new RingParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.yaw(), typeIn.pitch(), typeIn.duration(), typeIn.r(), typeIn.g(), typeIn.b(), typeIn.a(), typeIn.scale(), typeIn.facesCamera(), typeIn.behavior(), this.spriteSet);
            return particle;
        }
    }

    public static enum EnumRingBehavior {
        SHRINK,
        GROW,
        CONSTANT,
        GROW_THEN_SHRINK;

    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

