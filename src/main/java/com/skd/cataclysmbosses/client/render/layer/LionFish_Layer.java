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
 *  net.minecraft.util.Mth
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.client.model.entity.Lionfish_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.client.render.entity.Lionfish_Renderer;
import com.skd.cataclysmbosses.entity.Deepling.Lionfish_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class LionFish_Layer
extends RenderLayer<Lionfish_Entity, Lionfish_Model> {
    private static final Identifier LION_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/lionfish_layer.png");

    public LionFish_Layer(Lionfish_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Lionfish_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = CMRenderTypes.CMEyes(LION_LAYER_TEXTURES);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        float strength = 0.5f + Mth.clamp((float)((float)Math.cos(((float)entity.LayerTicks + partialTicks) * 0.1f) - 0.5f), (float)-0.5f, (float)0.5f);
        strength += Mth.lerp((float)partialTicks, (float)entity.oLayerBrightness, (float)entity.LayerBrightness) * 1.0f * (float)Math.PI;
        strength = Mth.clamp((float)strength, (float)0.1f, (float)1.0f) * 255.0f;
        int i = ARGB.color((int)255, (int)((int)strength), (int)((int)strength), (int)((int)strength));
        ((Lionfish_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, 0xF00000, OverlayTexture.NO_OVERLAY, i);
    }
}

