/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  javax.annotation.Nullable
 *  net.minecraft.client.Camera
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.SingleQuadParticle
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package com.skd.thesundering.client.particle;

import com.skd.thesundering.util.CMMathUtil;
import com.mojang.blaze3d.vertex.VertexConsumer;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

public class Abstract_Ignis_Swing_Particle
extends SingleQuadParticle {
    private final SpriteSet sprites;
    public float yaw;
    public float pitch;
    public float Swingroll;
    private final Vector3f[] localVertices;

    public Abstract_Ignis_Swing_Particle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double xd, double yd, double zd, int lifetime, float scale, float yaw, float pitch, float roll) {
        super(pLevel, pX, pY, pZ, 0.0, 0.0, 0.0);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.lifetime = lifetime;
        this.gravity = 0.0f;
        this.sprites = spriteSet;
        this.quadSize = scale * 3.25f;
        this.yaw = yaw;
        this.pitch = pitch;
        this.Swingroll = roll;
        this.friction = 1.0f;
        this.localVertices = this.calculateVertices();
        this.setSpriteFromAge(this.sprites);
    }

    private Vec3 vec3Copy(Vector3f vector3f) {
        return new Vec3((double)vector3f.x, (double)vector3f.y, (double)vector3f.z);
    }

    public void tick() {
        if (this.age == 0) {
            // empty if block
        }
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }
    }

    private void createFlameTrail() {
        int particleCount = 12;
        for (int i = 1; i < particleCount - 1; ++i) {
            float t = (float)i / (float)particleCount;
            float u = 1.0f - t;
            Vec3 localPos = this.vec3Copy(this.localVertices[1]).scale((double)(u * u * u)).add(this.vec3Copy(this.localVertices[0]).scale((double)(3.0f * u * u * t)).add(this.vec3Copy(this.localVertices[3]).scale((double)(3.0f * u * t * t)).add(this.vec3Copy(this.localVertices[2]).scale((double)(t * t * t))))).scale((double)(this.quadSize * 0.9f)).add((2.0 * Math.random() - 1.0) * 0.3, (2.0 * Math.random() - 1.0) * 0.3, (2.0 * Math.random() - 1.0) * 0.3);
            ParticleOptions particleoptions = this.TrailParticle();
            if (particleoptions == null) continue;
            this.level.addParticle(particleoptions, this.x + localPos.x, this.y + localPos.y, this.z + localPos.z, this.random.nextGaussian() * 0.03, this.random.nextGaussian() * 0.03, this.random.nextGaussian() * 0.03);
        }
    }

    @Nullable
    public ParticleOptions TrailParticle() {
        return ParticleTypes.FLAME;
    }

    private Vector3f[] calculateVertices() {
        Quaternionf quaternionf = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        Quaternionf quatY = CMMathUtil.quatFromRotationXYZ(0.0f, this.yaw, 0.0f, false);
        Quaternionf quatX = CMMathUtil.quatFromRotationXYZ(this.pitch, 0.0f, 0.0f, false);
        Quaternionf quatZ = CMMathUtil.quatFromRotationXYZ(0.0f, 0.0f, this.Swingroll, false);
        quaternionf.mul((Quaternionfc)quatY);
        quaternionf.mul((Quaternionfc)quatX);
        quaternionf.mul((Quaternionfc)quatZ);
        Vector3f[] vertices = new Vector3f[]{new Vector3f(-1.0f, -1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(1.0f, -1.0f, 0.0f)};
        for (int i = 0; i < 4; ++i) {
            Vector3f vector3f = vertices[i];
            quaternionf.transform(vector3f);
        }
        return vertices;
    }

    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        Vec3 Vector3d = camera.getPosition();
        float f = (float)(Mth.lerp((double)partialTicks, (double)this.xo, (double)this.x) - Vector3d.x());
        float f1 = (float)(Mth.lerp((double)partialTicks, (double)this.yo, (double)this.y) - Vector3d.y());
        float f2 = (float)(Mth.lerp((double)partialTicks, (double)this.zo, (double)this.z) - Vector3d.z());
        Vector3f[] avector3f = new Vector3f[4];
        float f4 = this.getQuadSize(partialTicks);
        for (int i = 0; i < 4; ++i) {
            Vector3f localVertex = this.localVertices[i];
            avector3f[i] = new Vector3f(localVertex.x(), localVertex.y(), localVertex.z());
            avector3f[i].mul(f4);
            avector3f[i].add(f, f1, f2);
        }
        float f7 = this.getU0();
        float f8 = this.getU1();
        float f5 = this.getV0();
        float f6 = this.getV1();
        int j = this.getLightColor(partialTicks);
        buffer.addVertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).setUv(f8, f6).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).setUv(f8, f5).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).setUv(f7, f5).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).setUv(f7, f6).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).setUv(f7, f6).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).setUv(f7, f5).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).setUv(f8, f5).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
        buffer.addVertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).setUv(f8, f6).setColor(this.rCol, this.gCol, this.bCol, this.alpha).setLight(j);
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    protected int getLightColor(float pPartialTick) {
        return 0xF000F0;
    }
}

