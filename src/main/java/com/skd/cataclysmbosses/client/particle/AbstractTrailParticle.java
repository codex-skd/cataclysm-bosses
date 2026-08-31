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
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.state.level.QuadParticleRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public abstract class AbstractTrailParticle
extends SingleQuadParticle {
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;
    public float r;
    public float g;
    public float b;
    protected float trailA = 1.0f;

    public AbstractTrailParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd, float r, float g, float b) {
        super(world, x, y, z, xd, yd, zd, (TextureAtlasSprite) null);
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

    @Override
    public void extract(QuadParticleRenderState state, Camera camera, float partialTick) {
        // TODO: Implement trail rendering with new API
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, Vec3 offset, float u, float v, int light) {
        consumer.addVertex(matrix, (float)(pos.x + offset.x), (float)(pos.y + offset.y), (float)(pos.z + offset.z)).setColor(this.r, this.g, this.b, this.trailA).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
    }

    public float getTrailRot(Camera camera) {
        return (float)(-Math.PI) / 180 * camera.xRot();
    }

    public abstract float getTrailHeight();

    @Override
    public SingleQuadParticle.Layer getLayer() {
        return SingleQuadParticle.Layer.TRANSLUCENT;
    }

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

    @Override
    public ParticleRenderType getGroup() {
        return ParticleRenderType.SINGLE_QUADS;
    }
}