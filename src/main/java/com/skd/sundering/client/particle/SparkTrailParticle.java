/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Vector4f
 */
package com.skd.sundering.client.particle;

import com.skd.sundering.client.particle.Options.SparkTrailParticleOptions;
import com.skd.sundering.client.render.etc.LightningBoltData;
import com.skd.sundering.client.render.etc.LightningRender;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

public class SparkTrailParticle
extends Particle {
    private double toX;
    private double toY;
    private double toZ;
    private LightningRender lightningRender = new LightningRender();

    public SparkTrailParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int r, int g, int b) {
        super(world, x, y, z);
        this.setSize(1.0f, 1.0f);
        this.gravity = 0.0f;
        this.lifetime = 5 + new Random().nextInt(3);
        this.toX = xSpeed;
        this.toY = ySpeed;
        this.toZ = zSpeed;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3 vec3 = camera.getPosition();
        PoseStack posestack = new PoseStack();
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        float f = (float)(Mth.lerp((double)partialTick, (double)this.xo, (double)this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)partialTick, (double)this.yo, (double)this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)partialTick, (double)this.zo, (double)this.z) - vec3.z());
        float scale = 1.85f;
        posestack.pushPose();
        posestack.translate(f, f1, f2);
        posestack.scale(scale, scale, scale);
        LightningBoltData.BoltRenderInfo lightningBoltData = new LightningBoltData.BoltRenderInfo(0.5f, 0.1f, 0.5f, 0.85f, new Vector4f(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, 1.0f), 0.9f);
        LightningBoltData bolt = new LightningBoltData(lightningBoltData, Vec3.ZERO, new Vec3(this.toX, this.toY, this.toZ), 2).size(0.05f).lifespan(this.lifetime).spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        this.lightningRender.update((Object)this, bolt, partialTick);
        this.lightningRender.render(partialTick, posestack, (MultiBufferSource)multibuffersource$buffersource);
        posestack.popPose();
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<SparkTrailParticleOptions> {
        public Particle createParticle(SparkTrailParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SparkTrailParticle particle = new SparkTrailParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.r(), data.g(), data.b());
            return particle;
        }
    }
}

