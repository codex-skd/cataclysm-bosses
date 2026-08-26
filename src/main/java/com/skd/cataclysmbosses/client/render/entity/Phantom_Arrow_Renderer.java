/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Arrow_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Phantom_Arrow_Renderer
extends EntityRenderer<Phantom_Arrow_Entity, EntityRenderState> {
    private static final Identifier TEXTURE_RED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/maledictus/phantom_arrow.png");
    private static final RenderType RENDER_TYPE_RED = CMRenderTypes.getGhost(TEXTURE_RED);

    public Phantom_Arrow_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    public void render(Phantom_Arrow_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot()) - 90.0f));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot())));
        float f1 = 0.15625f;
        float f2 = 0.3125f;
        float f9 = (float)entityIn.shakeTime - partialTicks;
        if (f9 > 0.0f) {
            float f10 = -Mth.sin((float)(f9 * 3.0f)) * f9;
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f10));
        }
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0f));
        matrixStackIn.scale(0.075f, 0.075f, 0.075f);
        matrixStackIn.translate(-4.0f, 0.0f, 0.0f);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RENDER_TYPE_RED);
        PoseStack.Pose posestack$pose = matrixStackIn.last();
        float hide = (float)entityIn.getTransparency() / 200.0f;
        float alpha = 1.0f - hide;
        int light = (int)(255.0f * Mth.clamp((float)alpha, (float)0.0f, (float)1.0f));
        this.vertex(posestack$pose, vertexconsumer, -7, -2, -2, light, 0.0f, 0.15625f, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, 2, light, 0.15625f, 0.15625f, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, 2, light, 0.15625f, 0.3125f, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, -2, light, 0.0f, 0.3125f, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, -2, light, 0.0f, 0.15625f, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, 2, light, 0.15625f, 0.15625f, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, 2, light, 0.15625f, 0.3125f, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, -2, light, 0.0f, 0.3125f, 1, 0, 0, packedLightIn);
        for (int j = 0; j < 4; ++j) {
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f));
            this.vertex(posestack$pose, vertexconsumer, -8, -2, 0, light, 0.0f, 0.0f, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, 8, -2, 0, light, 0.65f, 0.0f, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, 8, 2, 0, light, 0.65f, 0.15625f, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, -8, 2, 0, light, 0.0f, 0.15625f, 0, 1, 0, packedLightIn);
        }
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public void vertex(PoseStack.Pose p_324380_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_, int light, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.addVertex(p_324380_, (float)p_254058_, (float)p_254338_, (float)p_254196_).setColor(255, 255, 255, light).setUv(p_254003_, p_254165_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_254271_).setNormal(p_324380_, (float)p_253982_, (float)p_254038_, (float)p_254037_);
    }

    public Identifier getTextureLocation(Phantom_Arrow_Entity entity) {
        return TEXTURE_RED;
    }
}

