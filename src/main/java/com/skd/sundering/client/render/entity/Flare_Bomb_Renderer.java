/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Matrix4f
 *  org.joml.Quaternionf
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.entity.Flare_Bomb_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.entity.projectile.Flare_Bomb_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class Flare_Bomb_Renderer
extends EntityRenderer<Flare_Bomb_Entity> {
    private static final Identifier OUTER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/flare_bomb_outer.png");
    private static final Identifier INNER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/flare_bomb_inner.png");
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/amogus.png");
    private final Flare_Bomb_Model model;
    private final RandomSource random = RandomSource.create();

    public Flare_Bomb_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        this.model = new Flare_Bomb_Model(renderManagerIn.bakeLayer(CMModelLayers.FLARE_BOMB_MODEL));
    }

    public void render(Flare_Bomb_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(new Quaternionf().setAngleAxis(entityYaw * ((float)Math.PI / 180), 0.0f, -1.0f, 0.0f));
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(CMRenderTypes.CMEyes(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, 0.0f, 0.0f);
        this.model.renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
        VertexConsumer VertexConsumer22 = bufferIn.getBuffer(CMRenderTypes.CMEyes(OUTER_TEXTURES));
        int i = FastColor.ARGB32.color((int)102, (int)255, (int)255, (int)255);
        this.model.renderToBuffer(matrixStackIn, VertexConsumer22, packedLightIn, OverlayTexture.NO_OVERLAY, i);
        matrixStackIn.popPose();
        if (entityIn.hasTrail()) {
            double x = Mth.lerp((double)partialTicks, (double)entityIn.xOld, (double)entityIn.getX());
            double y = Mth.lerp((double)partialTicks, (double)entityIn.yOld, (double)entityIn.getY());
            double z = Mth.lerp((double)partialTicks, (double)entityIn.zOld, (double)entityIn.getZ());
            float ran = 0.04f;
            float r = 0.7647059f + this.random.nextFloat() * ran * 1.5f;
            float g = 0.37254903f + this.random.nextFloat() * ran;
            float b = 0.011764706f + this.random.nextFloat() * ran;
            matrixStackIn.pushPose();
            matrixStackIn.translate(-x, -y, -z);
            this.renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0f, packedLightIn);
            matrixStackIn.popPose();
        }
    }

    protected int getBlockLightLevel(Flare_Bomb_Entity entityIn, BlockPos pos) {
        return 15;
    }

    private void renderTrail(Flare_Bomb_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        int sampleSize = 10;
        float trailHeight = 0.5f;
        float trailZRot = 0.0f;
        Vec3 topAngleVec = new Vec3(0.0, (double)trailHeight, 0.0).zRot(trailZRot);
        Vec3 bottomAngleVec = new Vec3(0.0, (double)(-trailHeight), 0.0).zRot(trailZRot);
        Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);
        PoseStack.Pose lastPose = poseStack.last();
        Matrix4f matrix = lastPose.pose();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getLightTrailEffect(TRAIL_TEXTURE));
        for (int samples = 0; samples < sampleSize; ++samples) {
            Vec3 sample = entityIn.getTrailPosition(samples + 2, partialTicks);
            float u1 = (float)samples / (float)sampleSize;
            float u2 = u1 + 1.0f / (float)sampleSize;
            this.addVertex(vertexconsumer, matrix, drawFrom, bottomAngleVec, trailR, trailG, trailB, u1, 1.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, sample, bottomAngleVec, trailR, trailG, trailB, u2, 1.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, sample, topAngleVec, trailR, trailG, trailB, u2, 0.0f, packedLightIn);
            this.addVertex(vertexconsumer, matrix, drawFrom, topAngleVec, trailR, trailG, trailB, u1, 0.0f, packedLightIn);
            drawFrom = sample;
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, Vec3 offset, float r, float g, float b, float u, float v, int light) {
        consumer.addVertex(matrix, (float)(pos.x + offset.x), (float)(pos.y + offset.y), (float)(pos.z + offset.z)).setColor(r, g, b, 1.0f).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
    }

    public Identifier getTextureLocation(Flare_Bomb_Entity entity) {
        return INNER_TEXTURES;
    }
}

