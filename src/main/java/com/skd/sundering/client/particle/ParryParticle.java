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
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.particle.SpriteSet
 *  net.minecraft.client.particle.SingleQuadParticle
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4f
 */
package com.skd.sundering.client.particle;

import com.skd.sundering.client.particle.Options.ParryParticleOptions;
import com.skd.sundering.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

public class ParryParticle
extends SingleQuadParticle {
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/gathering_lightning.png");
    protected float trailA = 1.0f;

    protected ParryParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.95f;
        this.friction = 0.999f;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        this.alpha = 0.6f;
        this.xd += xSpeed;
        this.yd += ySpeed;
        this.zd += zSpeed;
        this.yd = this.random.nextFloat() * 0.4f + 0.05f;
        this.quadSize *= 0.5f;
        this.lifetime = 9 + level.random.nextInt(3);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getLightColor(float p_107086_) {
        int i = super.getLightColor(p_107086_);
        int j = 240;
        int k = i >> 16 & 0xFF;
        return 0xF0 | k << 16;
    }

    public float getQuadSize(float p_107089_) {
        float f = ((float)this.age + p_107089_) / (float)this.lifetime;
        return this.quadSize * (1.0f - f * f);
    }

    public void tick() {
        super.tick();
        if (!this.removed) {
            float f = (float)this.age / (float)this.lifetime;
            this.xd *= (double)(1.0f - f * f);
            this.yd *= (double)(1.0f - f * f);
            this.zd *= (double)(1.0f - f * f);
            this.tickTrail();
        }
        if (this.onGround) {
            this.remove();
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
        super.render(consumer, camera, partialTick);
        if (this.trailPointer > -1) {
            MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
            VertexConsumer vertexConsumer = this.getVetrexConsumer(bufferSource);
            Vec3 cameraPos = camera.getPosition();
            float renderX = (float)Mth.lerp((double)partialTick, (double)this.xo, (double)this.x);
            float renderY = (float)Mth.lerp((double)partialTick, (double)this.yo, (double)this.y);
            float renderZ = (float)Mth.lerp((double)partialTick, (double)this.zo, (double)this.z);
            PoseStack poseStack = new PoseStack();
            poseStack.pushPose();
            poseStack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
            int light = this.getLightColor(partialTick);
            float trailWidth = 0.08f;
            PoseStack.Pose lastPose = poseStack.last();
            Matrix4f matrix = lastPose.pose();
            Vec3 drawFrom = new Vec3((double)renderX, (double)renderY, (double)renderZ);
            int subSteps = 5;
            int totalSamples = this.sampleCount();
            float totalLength = totalSamples * subSteps;
            for (int i = 0; i < totalSamples - 1; ++i) {
                Vec3 p0 = this.getTrailPosition(Math.max(0, i - 1) * this.sampleStep(), partialTick);
                Vec3 p1 = this.getTrailPosition(i * this.sampleStep(), partialTick);
                Vec3 p2 = this.getTrailPosition((i + 1) * this.sampleStep(), partialTick);
                Vec3 p3 = this.getTrailPosition(Math.min(totalSamples - 1, i + 2) * this.sampleStep(), partialTick);
                for (int step = 1; step <= subSteps; ++step) {
                    float t = (float)step / (float)subSteps;
                    Vec3 sample = this.catmullRom(t, p0, p1, p2, p3);
                    float currentStepIndex = i * subSteps + step;
                    float u1 = (currentStepIndex - 1.0f) / totalLength;
                    float u2 = currentStepIndex / totalLength;
                    Vec3 forward = sample.subtract(drawFrom);
                    if (forward.lengthSqr() == 0.0) continue;
                    Vec3 toCamera = cameraPos.subtract(drawFrom);
                    Vec3 side = forward.cross(toCamera).normalize();
                    Vec3 offset = side.scale((double)(trailWidth / 2.0f));
                    this.addVertex(vertexConsumer, matrix, drawFrom.add(offset), this.rCol, this.gCol, this.bCol, u1, 0.0f, light);
                    this.addVertex(vertexConsumer, matrix, drawFrom.add(offset.scale(-1.0)), this.rCol, this.gCol, this.bCol, u1, 1.0f, light);
                    this.addVertex(vertexConsumer, matrix, sample.add(offset.scale(-1.0)), this.rCol, this.gCol, this.bCol, u2, 1.0f, light);
                    this.addVertex(vertexConsumer, matrix, sample.add(offset), this.rCol, this.gCol, this.bCol, u2, 0.0f, light);
                    drawFrom = sample;
                }
            }
            poseStack.popPose();
        }
    }

    private Vec3 catmullRom(float t, Vec3 p0, Vec3 p1, Vec3 p2, Vec3 p3) {
        double t2 = t * t;
        double t3 = t2 * (double)t;
        double x = 0.5 * (2.0 * p1.x + (-p0.x + p2.x) * (double)t + (2.0 * p0.x - 5.0 * p1.x + 4.0 * p2.x - p2.x) * t2 + (-p0.x + 3.0 * p1.x - 3.0 * p2.x + p3.x) * t3);
        double y = 0.5 * (2.0 * p1.y + (-p0.y + p2.y) * (double)t + (2.0 * p0.y - 5.0 * p1.y + 4.0 * p2.y - p2.y) * t2 + (-p0.y + 3.0 * p1.y - 3.0 * p2.y + p3.y) * t3);
        double z = 0.5 * (2.0 * p1.z + (-p0.z + p2.z) * (double)t + (2.0 * p0.z - 5.0 * p1.z + 4.0 * p2.z - p2.z) * t2 + (-p0.z + 3.0 * p1.z - 3.0 * p2.z + p3.z) * t3);
        return new Vec3(x, y, z);
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, float r, float g, float b, float u, float v, int light) {
        consumer.addVertex(matrix, (float)pos.x, (float)pos.y, (float)pos.z).setColor(r, g, b, 1.0f).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
    }

    protected VertexConsumer getVetrexConsumer(MultiBufferSource.BufferSource multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.getLightTrailEffect(this.getTrailTexture()));
    }

    public float getTrailRot(Camera camera) {
        return (float)(-Math.PI) / 180 * camera.getXRot();
    }

    public float getTrailHeight() {
        return 0.4f;
    }

    public Identifier getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    public int sampleCount() {
        return Math.min(6, (this.lifetime - this.age) / 2);
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

    @OnlyIn(value=Dist.CLIENT)
    public static class ParryFactory
    implements ParticleProvider<ParryParticleOptions> {
        private final SpriteSet spriteSet;

        public ParryFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(ParryParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParryParticle particle = new ParryParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.r(), typeIn.g(), typeIn.b());
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}

