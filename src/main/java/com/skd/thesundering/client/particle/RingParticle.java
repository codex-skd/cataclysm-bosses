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
package com.skd.thesundering.client.particle;

import com.skd.thesundering.client.particle.Options.RingParticleOptions;
import com.skd.thesundering.util.CMMathUtil;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.util.Mth;
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
        super(world, x, y, z);
        this.sprites = sprites;
        this.setSize(1.0f, 1.0f);
        this.setSpriteFromAge(this.sprites);
        this.size = size * 0.1f;
        this.lifetime = duration;
        this.alpha = 1.0f;
        this.r = r;
        this.g = g;
        this.b = b;
        this.opacity = opacity;
        this.yaw = yaw;
        this.pitch = pitch;
        this.facesCamera = facesCamera;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
        this.behavior = behavior;
    }

    public int getLightColor(float delta) {
        return 0xF0 | super.getLightColor(delta) & 0xFF0000;
    }

    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }
    }

    public void render(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
        float var = ((float)this.age + partialTicks) / (float)this.lifetime;
        this.quadSize = this.behavior == 0 ? this.size * var : (this.behavior == 1 ? this.size * (1.0f - var) : (this.behavior == 2 ? (float)((double)this.size * ((double)(1.0f - var) - Math.pow(2000.0, -var))) : this.size));
        this.alpha = this.opacity * 0.95f * (1.0f - ((float)this.age + partialTicks) / (float)this.lifetime) + 0.05f;
        this.rCol = this.r;
        this.gCol = this.g;
        this.bCol = this.b;
        Vec3 Vector3d = renderInfo.getPosition();
        float f = (float)(Mth.lerp((double)partialTicks, (double)this.xo, (double)this.x) - Vector3d.x());
        float f1 = (float)(Mth.lerp((double)partialTicks, (double)this.yo, (double)this.y) - Vector3d.y());
        float f2 = (float)(Mth.lerp((double)partialTicks, (double)this.zo, (double)this.z) - Vector3d.z());
        Quaternionf quaternionf = new Quaternionf(0.0f, 0.0f, 0.0f, 1.0f);
        if (this.facesCamera) {
            if (this.roll == 0.0f) {
                quaternionf = renderInfo.rotation();
            } else {
                quaternionf = new Quaternionf((Quaternionfc)renderInfo.rotation());
                float f3 = Mth.lerp((float)partialTicks, (float)this.oRoll, (float)this.roll);
                quaternionf.mul((Quaternionfc)Axis.ZP.rotation(f3));
            }
        } else {
            Quaternionf quatX = CMMathUtil.quatFromRotationXYZ(this.pitch, 0.0f, 0.0f, false);
            Quaternionf quatY = CMMathUtil.quatFromRotationXYZ(0.0f, this.yaw, 0.0f, false);
            quaternionf.mul((Quaternionfc)quatY);
            quaternionf.mul((Quaternionfc)quatX);
        }
        Vector3f vector3f1 = new Vector3f(-1.0f, -1.0f, 0.0f);
        quaternionf.transform(vector3f1);
        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0f, -1.0f, 0.0f), new Vector3f(-1.0f, 1.0f, 0.0f), new Vector3f(1.0f, 1.0f, 0.0f), new Vector3f(1.0f, -1.0f, 0.0f)};
        float f4 = this.getQuadSize(partialTicks);
        for (int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            quaternionf.transform(vector3f);
            vector3f.mul(f4);
            vector3f.add(f, f1, f2);
        }
        float f7 = this.getU0();
        float f8 = this.getU1();
        float f5 = this.getV0();
        float f6 = this.getV1();
        int j = this.getLightColor(partialTicks);
        buffer.addVertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).setUv(f8, f6).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).setUv(f8, f5).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).setUv(f7, f5).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).setUv(f7, f6).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).setUv(f7, f6).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).setUv(f7, f5).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).setUv(f8, f5).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
        buffer.addVertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).setUv(f8, f6).setColor(this.rCol / 255.0f, this.gCol / 255.0f, this.bCol / 255.0f, this.alpha).setLight(j);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class RingFactory
    implements ParticleProvider<RingParticleOptions> {
        private final SpriteSet spriteSet;

        public RingFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(RingParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
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
}

