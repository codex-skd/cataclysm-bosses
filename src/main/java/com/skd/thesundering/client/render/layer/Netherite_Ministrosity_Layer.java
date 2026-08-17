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
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.model.entity.Netherite_Ministrosity_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.client.render.entity.Netherite_Ministrosity_Renderer;
import com.skd.thesundering.entity.Pet.Netherite_Ministrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;

public class Netherite_Ministrosity_Layer
extends RenderLayer<Netherite_Ministrosity_Entity, Netherite_Ministrosity_Model> {
    private static final Identifier NETHERITE_MONSTRISITY_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/netherite_ministrosity_layer.png");

    public Netherite_Ministrosity_Layer(Netherite_Ministrosity_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Netherite_Ministrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        float strength = 0.5f + Mth.clamp((float)((float)Math.cos(((float)entity.LayerTicks + partialTicks) * 0.1f) - 0.25f), (float)-0.25f, (float)0.5f);
        if (!entity.getIsAwaken()) {
            strength = 0.0f;
        }
        strength += Mth.lerp((float)partialTicks, (float)entity.oLayerBrightness, (float)entity.LayerBrightness) * 1.0f * (float)Math.PI;
        strength = Mth.clamp((float)strength, (float)0.25f, (float)1.0f);
        int i = FastColor.ARGB32.color((int)((int)(255.0f * strength)), (int)((int)(255.0f * strength)), (int)((int)(255.0f * strength)), (int)255);
        ((Netherite_Ministrosity_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, 0xF00000, OverlayTexture.NO_OVERLAY, i);
    }
}

