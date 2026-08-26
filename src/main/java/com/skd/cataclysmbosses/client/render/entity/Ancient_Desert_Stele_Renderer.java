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
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Ancient_Desert_Stele_Model;
import com.skd.cataclysmbosses.entity.projectile.Ancient_Desert_Stele_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Ancient_Desert_Stele_Renderer
extends EntityRenderer<Ancient_Desert_Stele_Entity, EntityRenderState> {
    private static final Identifier ANCIENT_DESERT_STELE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ancient_desert_stele.png");
    private final Ancient_Desert_Stele_Model model = new Ancient_Desert_Stele_Model();

    public Ancient_Desert_Stele_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Ancient_Desert_Stele_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f - entityIn.getYRot()));
        matrixStackIn.translate(0.0, 1.5, 0.0);
        matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RenderTypes.entityTranslucent((Identifier)this.getTextureLocation(entityIn)));
        int maxWarmUp = 10;
        float progress = Mth.clamp((float)(1.0f - (float)entityIn.getWarmUp() / (float)maxWarmUp), (float)0.0f, (float)1.0f);
        int r = Mth.lerpInt((float)progress, (int)195, (int)255);
        int g = Mth.lerpInt((float)progress, (int)90, (int)255);
        int b = Mth.lerpInt((float)progress, (int)0, (int)255);
        float alpha = progress;
        int i = ARGB.color((int)((int)(255.0f * alpha)), (int)r, (int)g, (int)b);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(Ancient_Desert_Stele_Entity entity) {
        return ANCIENT_DESERT_STELE;
    }
}

