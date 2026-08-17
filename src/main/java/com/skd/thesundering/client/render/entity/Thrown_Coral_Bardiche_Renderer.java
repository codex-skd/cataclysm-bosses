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
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.entity.Coral_Bardiche_Model;
import com.skd.thesundering.entity.projectile.ThrownCoral_Bardiche_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Thrown_Coral_Bardiche_Renderer
extends EntityRenderer<ThrownCoral_Bardiche_Entity> {
    private static final Identifier VOID_HOWITZER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/coral_bardiche.png");
    private final Coral_Bardiche_Model model = new Coral_Bardiche_Model();

    public Thrown_Coral_Bardiche_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(ThrownCoral_Bardiche_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot()) - 90.0f));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot()) + 90.0f));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect((MultiBufferSource)bufferIn, (RenderType)this.model.renderType(this.getTextureLocation(entityIn)), (boolean)false, (boolean)entityIn.isFoil());
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(ThrownCoral_Bardiche_Entity entity) {
        return VOID_HOWITZER_TEXTURES;
    }
}

