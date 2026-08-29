/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.Util
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

import com.skd.cataclysmbosses.client.particle.Options.RainFogParticleOptions;
import com.mojang.math.Axis;
import java.util.function.Consumer;
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

public class Rain_Fog_Particle
extends SingleQuadParticle {
    private final SpriteSet sprites;
    private static final Vector3f ROTATION_VECTOR = new Vector3f(0.5f, 0.5f, 0.5f).normalize();
    private static final Vector3f TRANSFORM_VECTOR = new Vector3f(-1.0f, -1.0f, 0.0f);
    private static final float DEGREES_90 = 1.5707964f;

    protected Rain_Fog_Particle(ClientLevel level, double xCoord, double yCoord, double zCoord, double xd, double yd, double zd, float size, SpriteSet spriteSet) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd, (TextureAtlasSprite) null);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.alpha = 0.6f;
        this.quadSize = size;
        this.gravity = 0.0f;
        this.lifetime = (int)(Math.random() * 2.0) + 60;
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

    private float noise(float offset) {
        return 10.0f * Mth.sin((float)(offset * 0.01f));
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<RainFogParticleOptions> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(RainFogParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            Rain_Fog_Particle particle = new Rain_Fog_Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.size(), this.spriteSet);
            return particle;
        }
    }

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }
}

