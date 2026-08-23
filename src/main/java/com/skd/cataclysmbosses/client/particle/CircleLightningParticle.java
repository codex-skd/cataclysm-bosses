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
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.particle.Options.CircleLightningParticleOptions;
import com.skd.cataclysmbosses.client.render.etc.LightningBoltData;
import com.skd.cataclysmbosses.client.render.etc.LightningRender;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

public class CircleLightningParticle
extends Particle {
    private LightningRender lightningRender = new LightningRender();

    public CircleLightningParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd, float size, int r, int g, int b) {
        super(world, x, y, z);
        this.setSize(6.0f, 6.0f);
        this.x = x;
        this.y = y;
        this.z = z;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        Vec3 lightningTo = new Vec3(xd - x, yd - y, zd - z);
        this.lifetime = 10;
        LightningBoltData.BoltRenderInfo boltData = new LightningBoltData.BoltRenderInfo(0.5f, 0.1f, 0.5f, 0.85f, new Vector4f(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, 0.8f), 0.1f);
        LightningBoltData bolt = new LightningBoltData(boltData, Vec3.ZERO, lightningTo, 5).size(size).lifespan(this.lifetime).spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        this.lightningRender.update((Object)this, bolt, 1.0f);
    }

    public AABB getRenderBoundingBox(float partialTicks) {
        return this.getBoundingBox().inflate(0.0);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
        }
    }

    public void render(VertexConsumer consumer, Camera camera, float partialTick) {
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        Vec3 cameraPos = camera.getPosition();
        float x = (float)Mth.lerp((double)partialTick, (double)this.xo, (double)this.x);
        float y = (float)Mth.lerp((double)partialTick, (double)this.yo, (double)this.y);
        float z = (float)Mth.lerp((double)partialTick, (double)this.zo, (double)this.z);
        PoseStack posestack = new PoseStack();
        posestack.pushPose();
        posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        posestack.translate(x, y, z);
        this.lightningRender.render(partialTick, posestack, (MultiBufferSource)multibuffersource$buffersource);
        posestack.popPose();
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<CircleLightningParticleOptions> {
        public Particle createParticle(CircleLightningParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CircleLightningParticle particle = new CircleLightningParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.size(), data.r(), data.g(), data.b());
            return particle;
        }
    }
}

