/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.model.LlamaSpitModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.entity.projectile.Octo_Ink_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Octo_Ink_Renderer extends EntityRenderer<Octo_Ink_Entity> {
    private static final Identifier OCTO_INK_TEXTURE = new ResourceLocation("cataclysm_bosses", "textures/entity/sea/octo_ink.png");
    private final com.skd.cataclysmbosses.client.model.entity.Octo_Ink_Model model;

    public Octo_Ink_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new com.skd.cataclysmbosses.client.model.entity.Octo_Ink_Model(context);
    }

    @Override
    public void render(Octo_Ink_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.15f, 0.0f);
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));
        this.model.setupAnim(entity, partialTicks, 0.0f, -0.1f, 0.0f, 0.0f);
        buffer.getBuffer(this.model.renderType(OCTO_INK_TEXTURE)).ifPresent(vertexconsumer -> {
            this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        });
        poseStack.popPose();
    }

    @Override
    public Identifier getTextureLocation(Octo_Ink_Entity entity) {
        return OCTO_INK_TEXTURE;
    }
}

