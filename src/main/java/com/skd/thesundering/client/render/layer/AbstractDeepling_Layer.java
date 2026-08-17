/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.Deepling.AbstractDeepling;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;

public class AbstractDeepling_Layer<T extends AbstractDeepling>
extends RenderLayer<T, EntityModel<T>> {
    private final Identifier texture;
    private final RenderType renderType;

    public AbstractDeepling_Layer(RenderLayerParent<T, EntityModel<T>> renderer, Identifier texture) {
        super(renderer);
        this.texture = texture;
        this.renderType = CMRenderTypes.CMEyes(texture);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(this.renderType);
        float strength = 0.5f + Mth.clamp((float)((float)Math.cos(((float)((AbstractDeepling)entitylivingbaseIn).LayerTicks + partialTicks) * 0.1f) - 0.5f), (float)-0.5f, (float)0.5f);
        strength += Mth.lerp((float)partialTicks, (float)((AbstractDeepling)entitylivingbaseIn).oLayerBrightness, (float)((AbstractDeepling)entitylivingbaseIn).LayerBrightness) * 1.0f * (float)Math.PI;
        strength = Mth.clamp((float)strength, (float)0.1f, (float)1.0f) * 255.0f;
        int i = FastColor.ARGB32.color((int)255, (int)((int)strength), (int)((int)strength), (int)((int)strength));
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer2, 0xF00000, OverlayTexture.NO_OVERLAY, i);
    }
}

