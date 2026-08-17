/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.util.RandomSource
 *  org.joml.Matrix4f
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.model.entity.Deepling_Priest_Model;
import com.skd.thesundering.entity.Deepling.Deepling_Priest_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import org.joml.Matrix4f;

public class LayerDeepling_Priest_Light
extends RenderLayer<Deepling_Priest_Entity, Deepling_Priest_Model> {
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0) / 2.0);

    public LayerDeepling_Priest_Light(RenderLayerParent p_234846_) {
        super(p_234846_);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Deepling_Priest_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        if (entity.getAnimation() == Deepling_Priest_Entity.DEEPLING_BLIND && entity.getAnimationTick() > 18 && entity.getAnimationTick() < 47) {
            float f5 = ((float)entity.getAnimationTick() + partialTicks) / 144.0f;
            float f7 = Math.min(f5 > 0.8f ? (f5 - 0.8f) / 0.2f : 0.0f, 1.0f);
            RandomSource randomsource = RandomSource.create((long)432L);
            VertexConsumer vertexconsumer2 = bufferIn.getBuffer(RenderType.lightning());
            matrixStackIn.pushPose();
            this.translateToLight(matrixStackIn);
            int i = 0;
            while ((float)i < 4.0f) {
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0f));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0f + f5 * 90.0f));
                float f3 = 2.75f;
                float f4 = 2.75f;
                Matrix4f matrix4f = matrixStackIn.last().pose();
                int j = (int)(255.0f * (1.0f - f7));
                LayerDeepling_Priest_Light.vertex01(vertexconsumer2, matrix4f, j);
                LayerDeepling_Priest_Light.vertex2(vertexconsumer2, matrix4f, f3, f4);
                LayerDeepling_Priest_Light.vertex3(vertexconsumer2, matrix4f, f3, f4);
                LayerDeepling_Priest_Light.vertex01(vertexconsumer2, matrix4f, j);
                LayerDeepling_Priest_Light.vertex3(vertexconsumer2, matrix4f, f3, f4);
                LayerDeepling_Priest_Light.vertex4(vertexconsumer2, matrix4f, f3, f4);
                LayerDeepling_Priest_Light.vertex01(vertexconsumer2, matrix4f, j);
                LayerDeepling_Priest_Light.vertex4(vertexconsumer2, matrix4f, f3, f4);
                LayerDeepling_Priest_Light.vertex2(vertexconsumer2, matrix4f, f3, f4);
                ++i;
            }
            matrixStackIn.popPose();
        }
        matrixStackIn.popPose();
    }

    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.addVertex(p_114221_, 0.0f, 0.0f, 0.0f).setColor(51, 255, 255, p_114222_);
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.addVertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5f * p_114218_).setColor(51, 255, 255, 0);
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.addVertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5f * p_114227_).setColor(51, 255, 255, 0);
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.addVertex(p_114230_, 0.0f, p_114231_, 1.0f * p_114232_).setColor(51, 255, 255, 0);
    }

    private void translateToLight(PoseStack matrixStack) {
        ((Deepling_Priest_Model)this.getParentModel()).root.translateAndRotate(matrixStack);
        ((Deepling_Priest_Model)this.getParentModel()).body.translateAndRotate(matrixStack);
        ((Deepling_Priest_Model)this.getParentModel()).head.translateAndRotate(matrixStack);
        ((Deepling_Priest_Model)this.getParentModel()).head2.translateAndRotate(matrixStack);
        ((Deepling_Priest_Model)this.getParentModel()).fin.translateAndRotate(matrixStack);
        ((Deepling_Priest_Model)this.getParentModel()).light.translateAndRotate(matrixStack);
    }
}

