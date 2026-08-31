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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Wither_Howitzer_Model;
import com.skd.cataclysmbosses.entity.projectile.Wither_Howitzer_Entity;
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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Wither_Howitzer_Renderer
extends CmEntityRenderer<Wither_Howitzer_Entity> {
    private static final Identifier WITHER_HOWITZER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/wither_howitzer.png");
    private final Wither_Howitzer_Model model = new Wither_Howitzer_Model();

    public Wither_Howitzer_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    protected void render(Wither_Howitzer_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0, 0.25, 0.0);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot()) - 180.0f));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot())));
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(RenderTypes.entityTranslucent((Identifier)this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        matrixStackIn.popPose();
    }

    protected int getBlockLightLevel(Wither_Howitzer_Entity entityIn, BlockPos pos) {
        return 15;
    }

    public Identifier getTextureLocation(Wither_Howitzer_Entity entity) {
        return WITHER_HOWITZER_TEXTURES;
    }
}

