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
 *  net.minecraft.util.FastColor$ARGB32
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.client.model.entity.The_Harbinger_Model;
import com.skd.cataclysmbosses.client.render.entity.The_Harbinger_Renderer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Harbinger_Layer
extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    private static final Identifier HARBINGER_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/the_harbinger_layer.png");

    public The_Harbinger_Layer(The_Harbinger_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int f = (int)(255.0f - entity.deactivateProgress * 255.0f / 40.0f);
        RenderType eyes = RenderType.eyes((Identifier)HARBINGER_LAYER_TEXTURES);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        int i = ARGB.color((int)255, (int)f, (int)f, (int)f);
        ((The_Harbinger_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i);
    }
}

