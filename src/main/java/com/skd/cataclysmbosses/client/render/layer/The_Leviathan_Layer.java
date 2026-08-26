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

import com.skd.cataclysmbosses.client.model.entity.The_Leviathan_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.client.render.entity.The_Leviathan_Renderer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
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
public class The_Leviathan_Layer
extends RenderLayer<The_Leviathan_Entity, The_Leviathan_Model> {
    private static final Identifier LEVIATHAN_LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/the_leviathan_layer.png");
    private static final Identifier BURNING_LEVIATHAN_LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/the_burning_leviathan_layer.png");

    public The_Leviathan_Layer(The_Leviathan_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Leviathan_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha = entity.getMeltDown() ? 1.0f : entity.LayerBrightness;
        Identifier resourceLocation = entity.getMeltDown() ? BURNING_LEVIATHAN_LAYER : LEVIATHAN_LAYER;
        RenderType eyes = CMRenderTypes.CMEyes(resourceLocation);
        int i = ARGB.color((int)255, (int)((int)(255.0f * alpha)), (int)((int)(255.0f * alpha)), (int)((int)(255.0f * alpha)));
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        ((The_Leviathan_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i);
    }
}

