/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.model.entity.Aptrgangr_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.client.render.entity.Aptrgangr_Renderer;
import com.skd.thesundering.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Aptrgangr_Layer
extends RenderLayer<Aptrgangr_Entity, Aptrgangr_Model> {
    private static final Identifier LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/aptrgangr_layer.png");

    public Aptrgangr_Layer(Aptrgangr_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public Identifier getLayerTextureLocation() {
        return LAYER;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = CMRenderTypes.CMEyes(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        ((Aptrgangr_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
    }
}

