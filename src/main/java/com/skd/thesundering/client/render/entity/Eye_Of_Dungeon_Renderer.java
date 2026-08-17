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
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4f
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.projectile.Eye_Of_Dungeon_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

@OnlyIn(value=Dist.CLIENT)
public class Eye_Of_Dungeon_Renderer
extends EntityRenderer<Eye_Of_Dungeon_Entity> {
    private final ItemRenderer itemRenderer;
    private static final Identifier TRAIL_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/gathering_lightning.png");

    public Eye_Of_Dungeon_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        this.itemRenderer = renderManagerIn.getItemRenderer();
    }

    public void render(Eye_Of_Dungeon_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (entityIn.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr((Entity)entityIn) < 12.25)) {
            matrixStackIn.pushPose();
            matrixStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
            this.itemRenderer.renderStatic(entityIn.getItem(), ItemDisplayContext.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn, entityIn.level(), entityIn.getId());
            matrixStackIn.popPose();
            if (entityIn.hasTrail()) {
                double x = Mth.lerp((double)partialTicks, (double)entityIn.xOld, (double)entityIn.getX());
                double y = Mth.lerp((double)partialTicks, (double)entityIn.yOld, (double)entityIn.getY());
                double z = Mth.lerp((double)partialTicks, (double)entityIn.zOld, (double)entityIn.getZ());
                float r = (float)entityIn.getR() / 255.0f;
                float g = (float)entityIn.getG() / 255.0f;
                float b = (float)entityIn.getB() / 255.0f;
                matrixStackIn.pushPose();
                matrixStackIn.translate(-x, -y, -z);
                this.renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0f, packedLightIn);
                matrixStackIn.popPose();
            }
            super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        }
    }

    private void renderTrail(Eye_Of_Dungeon_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        int sampleSize = 10;
        float trailHeight = 0.1f;
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

    protected int getBlockLightLevel(Eye_Of_Dungeon_Entity entity, BlockPos pos) {
        return 15;
    }

    public Identifier getTextureLocation(Eye_Of_Dungeon_Entity p_114632_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

