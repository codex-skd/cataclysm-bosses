/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Matrix4f
 */
package com.skd.thesundering.client.particle;

import com.skd.thesundering.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public abstract class AbstractTrailParticle
extends Particle {
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;
    public float r;
    public float g;
    public float b;
    protected float trailA = 1.0f;

    public AbstractTrailParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd, float r, float g, float b) {
        super(world, x, y, z);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void tick() {
        this.tickTrail();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.xd *= 0.99;
        this.yd *= 0.99;
        this.zd *= 0.99;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.yd -= (double)this.gravity;
        }
    }

    public void tickTrail() {
        Vec3 currentPosition = new Vec3(this.x, this.y, this.z);
        if (this.trailPointer == -1) {
            for (int i = 0; i < this.trailPositions.length; ++i) {
                this.trailPositions[i] = currentPosition;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = currentPosition;
    }

    public void render(VertexConsumer consumer, Camera camera, float partialTick) {
        if (this.trailPointer > -1) {
            MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
            VertexConsumer vertexconsumer = this.getVetrexConsumer(multibuffersource$buffersource);
            Vec3 cameraPos = camera.getPosition();
            float x = (float)Mth.lerp((double)partialTick, (double)this.xo, (double)this.x);
            float y = (float)Mth.lerp((double)partialTick, (double)this.yo, (double)this.y);
            float z = (float)Mth.lerp((double)partialTick, (double)this.zo, (double)this.z);
            PoseStack posestack = new PoseStack();
            posestack.pushPose();
            posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
            int light = this.getLightColor(partialTick);
            float zRot = this.getTrailRot(camera);
            Vec3 topAngleVec = new Vec3(0.0, (double)(this.getTrailHeight() / 2.0f), 0.0).zRot(zRot);
            Vec3 bottomAngleVec = new Vec3(0.0, (double)(-this.getTrailHeight() / 2.0f), 0.0).zRot(zRot);
            Vec3 drawFrom = new Vec3((double)x, (double)y, (double)z);
            PoseStack.Pose lastPose = posestack.last();
            Matrix4f matrix = lastPose.pose();
            for (int samples = 0; samples < this.sampleCount(); ++samples) {
                Vec3 sample = this.getTrailPosition(samples * this.sampleStep(), partialTick);
                float u1 = (float)samples / (float)this.sampleCount();
                float u2 = (float)(samples + 1) / (float)this.sampleCount();
                this.addVertex(vertexconsumer, matrix, drawFrom, bottomAngleVec, u1, 1.0f, light);
                this.addVertex(vertexconsumer, matrix, sample, bottomAngleVec, u2, 1.0f, light);
                this.addVertex(vertexconsumer, matrix, sample, topAngleVec, u2, 0.0f, light);
                this.addVertex(vertexconsumer, matrix, drawFrom, topAngleVec, u1, 0.0f, light);
                drawFrom = sample;
            }
            posestack.popPose();
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, Vec3 offset, float u, float v, int light) {
        consumer.addVertex(matrix, (float)(pos.x + offset.x), (float)(pos.y + offset.y), (float)(pos.z + offset.z)).setColor(this.r, this.g, this.b, this.trailA).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
    }

    protected VertexConsumer getVetrexConsumer(MultiBufferSource.BufferSource multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.getTrailEffect(this.getTrailTexture()));
    }

    public float getTrailRot(Camera camera) {
        return (float)(-Math.PI) / 180 * camera.getXRot();
    }

    public abstract float getTrailHeight();

    public abstract Identifier getTrailTexture();

    public int sampleCount() {
        return 20;
    }

    public int sampleStep() {
        return 1;
    }

    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.removed) {
            partialTick = 1.0f;
        }
        int i = this.trailPointer - pointer & 0x3F;
        int j = this.trailPointer - pointer - 1 & 0x3F;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale((double)partialTick));
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }
}

