/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4f
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.entity.Ignis_Fireball_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.projectile.Ignis_Abyss_Fireball_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

@OnlyIn(value=Dist.CLIENT)
public class Ignis_Abyss_Fireball_Renderer
extends EntityRenderer<Ignis_Abyss_Fireball_Entity> {
    private static final Identifier IGNIS_FIRE_BALL = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis_fireball_abyss.png");
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/storm.png");
    public Ignis_Fireball_Model model;
    private final RandomSource random = RandomSource.create();

    public Ignis_Abyss_Fireball_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new Ignis_Fireball_Model();
    }

    protected int getBlockLightLevel(Ignis_Abyss_Fireball_Entity entity, BlockPos pos) {
        return 15;
    }

    public void render(Ignis_Abyss_Fireball_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        float f = this.rotLerp(entityIn.yRotO, entityIn.getYRot(), partialTicks);
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        float f2 = (float)entityIn.tickCount + partialTicks;
        matrixStackIn.translate(0.0, (double)0.3f, 0.0);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.sin((float)(f2 * 0.1f)) * 180.0f));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.cos((float)(f2 * 0.1f)) * 180.0f));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.sin((float)(f2 * 0.15f)) * 360.0f));
        this.model.setupAnim((Entity)entityIn, 0.0f, 0.0f, 0.0f, f, f1);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        if (entityIn.hasTrail()) {
            double x = Mth.lerp((double)partialTicks, (double)entityIn.xOld, (double)entityIn.getX());
            double y = Mth.lerp((double)partialTicks, (double)entityIn.yOld, (double)entityIn.getY());
            double z = Mth.lerp((double)partialTicks, (double)entityIn.zOld, (double)entityIn.getZ());
            float ran = 0.04f;
            float r = 0.8901961f + this.random.nextFloat() * ran;
            float g = 0.25882354f + this.random.nextFloat() * ran;
            float b = 0.9607843f + this.random.nextFloat() * ran;
            matrixStackIn.pushPose();
            matrixStackIn.translate(-x, -y, -z);
            this.renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0f, packedLightIn);
            matrixStackIn.popPose();
        }
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(Ignis_Abyss_Fireball_Entity entity) {
        return IGNIS_FIRE_BALL;
    }

    private void renderTrail(Ignis_Abyss_Fireball_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        int sampleSize = 10;
        float trailWidth = 0.2f;
        PoseStack.Pose lastPose = poseStack.last();
        Matrix4f matrix = lastPose.pose();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getLightTrailEffect(TRAIL_TEXTURE));
        Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);
        Vec3 cameraPos = this.entityRenderDispatcher.camera.getPosition();
        for (int i = 0; i < sampleSize; ++i) {
            Vec3 sample = entityIn.getTrailPosition(i + 1, partialTicks);
            float u1 = (float)i / (float)sampleSize;
            float u2 = u1 + 1.0f / (float)sampleSize;
            Vec3 forward = sample.subtract(drawFrom);
            if (forward.lengthSqr() == 0.0) continue;
            Vec3 toCamera = cameraPos.subtract(drawFrom);
            Vec3 side = forward.cross(toCamera).normalize();
            Vec3 offset = side.scale((double)(trailWidth / 2.0f));
            this.addVertex(vertexconsumer, matrix, drawFrom.add(offset), trailR, trailG, trailB, u1, 0.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, drawFrom.add(offset.scale(-1.0)), trailR, trailG, trailB, u1, 1.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, sample.add(offset.scale(-1.0)), trailR, trailG, trailB, u2, 1.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, sample.add(offset), trailR, trailG, trailB, u2, 0.0f, packedLightIn);
            drawFrom = sample;
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, float r, float g, float b, float u, float v, int light) {
        consumer.addVertex(matrix, (float)pos.x, (float)pos.y, (float)pos.z).setColor(r, g, b, 1.0f).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
    }

    private float rotLerp(float prevRotation, float rotation, float partialTicks) {
        float f;
        for (f = rotation - prevRotation; f < -180.0f; f += 360.0f) {
        }
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        return prevRotation + partialTicks * f;
    }
}

