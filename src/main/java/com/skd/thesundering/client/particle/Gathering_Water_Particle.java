/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.particle;

import com.skd.thesundering.client.particle.Options.GatheringWaterParticleOptions;
import com.skd.thesundering.client.particle.SpinTrailParticle;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Gathering_Water_Particle
extends SpinTrailParticle {
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/gathering_lightning.png");

    protected Gathering_Water_Particle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed, r, g, b);
        this.orbitAxis = this.random.nextInt(3);
        this.xd = 0.0;
        this.yd = 0.0;
        this.zd = 0.0;
        this.orbitOffset = new Vec3(0.0, 0.0, 0.0);
        this.orbitDistance = 3.0;
        this.orbitSpeed = 12.0f;
        this.alpha = 1.0f;
        this.hasPhysics = false;
        this.lifetime = 20 + this.random.nextInt(10);
    }

    @Override
    public int getLightColor(float partialTicks) {
        return 240;
    }

    @Override
    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        super.render(vertexConsumer, camera, partialTick);
    }

    public float getAlpha() {
        return Mth.clamp((float)(1.0f - (float)this.age / (float)this.lifetime), (float)0.0f, (float)1.0f);
    }

    @Override
    public void tick() {
        this.xd *= 0.9;
        this.yd *= 0.9;
        this.zd *= 0.9;
        super.tick();
        float fadeIn = 0.8f * Mth.clamp((float)((float)this.age / (float)this.lifetime * 32.0f), (float)0.0f, (float)1.0f);
        float fadeOut = Mth.clamp((float)(1.0f - (float)this.age / (float)this.lifetime), (float)0.0f, (float)1.0f);
        this.trailA = fadeIn * fadeOut;
    }

    @Override
    public Vec3 getOrbitPosition(float angle) {
        Vec3 center = new Vec3(this.orbitX, this.orbitY, this.orbitZ);
        float f = this.reverseOrbit ? -1.0f : 1.0f;
        Vec3 add = Vec3.ZERO;
        float rot = angle * 3.0f * this.orbitSpeed * ((float)Math.PI / 180);
        switch (this.orbitAxis) {
            case 0: {
                add = new Vec3(0.0, this.orbitDistance * 0.5, this.orbitDistance * 0.5).xRot(rot * f);
                break;
            }
            case 1: {
                add = new Vec3(this.orbitDistance * 0.5, 0.0, this.orbitDistance * 0.5).yRot(rot * f);
                break;
            }
            case 2: {
                add = new Vec3(this.orbitDistance * 0.5, this.orbitDistance * 0.5, 0.0).zRot(rot * f);
            }
        }
        return center.add(add);
    }

    @Override
    public float getTrailHeight() {
        return 0.4f;
    }

    @Override
    public Identifier getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @Override
    public int sampleCount() {
        return Math.min(10, this.lifetime - this.age);
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<GatheringWaterParticleOptions> {
        public Particle createParticle(GatheringWaterParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Gathering_Water_Particle particle = new Gathering_Water_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.r(), data.g(), data.b());
            return particle;
        }
    }
}

