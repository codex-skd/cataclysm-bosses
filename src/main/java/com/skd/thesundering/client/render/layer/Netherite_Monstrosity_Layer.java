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

import com.skd.thesundering.client.model.entity.Netherite_Monstrosity_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.client.render.entity.New_Netherite_Monstrosity_Renderer;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
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

public class Netherite_Monstrosity_Layer
extends RenderLayer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {
    private static final Identifier NETHERITE_MONSTRISITY_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/netherite_monstrosity_layer.png");

    public Netherite_Monstrosity_Layer(New_Netherite_Monstrosity_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 0.5f;
        f = (float)((double)f - Mth.clamp((double)((float)entity.deathTime / (float)entity.deathtimer()), (double)0.0, (double)0.5));
        RenderType eyes = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        int i = FastColor.ARGB32.color((int)((int)(255.0f * f)), (int)((int)(255.0f * f)), (int)((int)(255.0f * f)), (int)((int)(255.0f * f)));
        ((Netherite_Monstrosity_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i);
    }
}

