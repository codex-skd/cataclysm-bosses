/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package com.skd.cataclysmbosses.client.particle;

import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class EM_PulseParticle
extends SingleQuadParticle {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/em_pulse.png");
    private float size;
    private float prevSize;
    private float prevAlpha;
    private float alphaDecrease;

    private EM_PulseParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, null);
        this.setSize(1.0f, 0.1f);
        this.alpha = 1.0f;
        this.gravity = 0.0f;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
        this.lifetime = 20;
        this.alphaDecrease = 1.0f / Math.max((float)this.lifetime, 1.0f);
        this.size = 0.1f;
    }

    public void tick() {
        super.tick();
        this.prevSize = this.size;
        this.prevAlpha = this.alpha;
        this.size += 0.3f;
        this.xd *= 0.1;
        this.yd *= 0.8;
        this.zd *= 0.1;
        if (this.alpha > 0.0f) {
            this.alpha = Math.max(this.alpha - this.alphaDecrease, 0.0f);
        }
        this.setSize(1.0f + this.size, 0.1f);
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3 vec3 = camera.getPosition();
        float f = (float)(Mth.lerp((double)partialTick, (double)this.xo, (double)this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)partialTick, (double)this.yo, (double)this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)partialTick, (double)this.zo, (double)this.z) - vec3.z());
        Quaternionf quaternion = Axis.XP.rotationDegrees(90.0f);
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        VertexConsumer portalStatic = multibuffersource$buffersource.getBuffer(CMRenderTypes.getPulse());
        PoseStack posestack = new PoseStack();
        PoseStack.Pose posestack$pose = posestack.last();
        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0f, -1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(1.0f, -1.0f, 0.0f)};
        float f4 = this.prevSize + partialTick * (this.size - this.prevSize);
        float alphaLerp = this.prevAlpha + partialTick * (this.alpha - this.prevAlpha);
        for (int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate((Quaternionfc)quaternion);
            vector3f.mul(f4);
            vector3f.add(f, f1, f2);
        }
        float f7 = 0.0f;
        float f8 = 1.0f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        int j = 240;
        portalStatic.addVertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f8, f6).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0f, -1.0f, 0.0f);
        portalStatic.addVertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f8, f5).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0f, -1.0f, 0.0f);
        portalStatic.addVertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f7, f5).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0f, -1.0f, 0.0f);
        portalStatic.addVertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f7, f6).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0f, -1.0f, 0.0f);
    }

    public ParticleRenderType getGroup() {
        return ParticleRenderType.CUSTOM;
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Factory
    implements ParticleProvider.Sprite<SimpleParticleType> {
        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new EM_PulseParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}

