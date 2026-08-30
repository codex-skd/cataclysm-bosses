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
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Phantom_Halberd_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Halberd_Entity;
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
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Phantom_Halberd_Renderer
extends CmEntityRenderer<Phantom_Halberd_Entity> {
    private static final Identifier PHANTOM_HALBERD = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/maledictus/phantom_halberd.png");
    private static final Identifier PHANTOM_HALBERD_DISCARD = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/maledictus/phantom_halberd_discard.png");
    private final Phantom_Halberd_Model model = new Phantom_Halberd_Model();
    private static final RenderType DECAL = CMRenderTypes.entityCutoutNoCull((Identifier)PHANTOM_HALBERD);
    private static final RenderType RENDER_TYPE = CMRenderTypes.entityCutoutNoCull((Identifier)PHANTOM_HALBERD);

    public Phantom_Halberd_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    protected void render(Phantom_Halberd_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f - entityIn.getYRot()));
        matrixStackIn.translate(0.0, 1.0, 0.0);
        matrixStackIn.scale(-0.8f, -0.8f, 0.8f);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, 0.0f, 0.0f);
        if (entityIn.lifeTicks > 0) {
            float f2 = (float)entityIn.lifeTicks / 70.0f;
            int i = ARGB.color((int)Mth.floor((float)(f2 * 255.0f)), (int)-1);
            VertexConsumer vertexconsumer = bufferIn.getBuffer(RenderTypes.entityTranslucent((Identifier)PHANTOM_HALBERD_DISCARD));
            this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);
            VertexConsumer vertexconsumer1 = bufferIn.getBuffer(DECAL);
            this.model.renderToBuffer(matrixStackIn, vertexconsumer1, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        } else {
            VertexConsumer vertexconsumer3 = bufferIn.getBuffer(RENDER_TYPE);
            this.model.renderToBuffer(matrixStackIn, vertexconsumer3, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        }
        matrixStackIn.popPose();
    }

    protected int getBlockLightLevel(Phantom_Halberd_Entity entityIn, BlockPos pos) {
        return 15;
    }

    public Identifier getTextureLocation(Phantom_Halberd_Entity entity) {
        return PHANTOM_HALBERD;
    }
}

