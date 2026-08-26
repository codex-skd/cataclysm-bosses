/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
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

import com.skd.cataclysmbosses.client.model.entity.Sandstorm_Model;
import com.skd.cataclysmbosses.entity.effect.Sandstorm_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Sandstorm_Renderer
extends CmEntityRenderer<Sandstorm_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ancient_remnant/sandstorm.png");
    private final Sandstorm_Model model = new Sandstorm_Model();

    public Sandstorm_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    protected void render(Sandstorm_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0, 3.0, 0.0);
        matrixStackIn.scale(-2.0f, -2.0f, 2.0f);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot()) - 90.0f));
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderTypes.entityTranslucent((Identifier)TEXTURE));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, 0.0f, 0.0f);
        this.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        matrixStackIn.popPose();
    }

    public Identifier getTextureLocation(Sandstorm_Entity entity) {
        return TEXTURE;
    }
}

