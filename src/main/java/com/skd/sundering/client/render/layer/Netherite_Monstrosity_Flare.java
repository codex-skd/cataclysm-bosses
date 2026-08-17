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
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.Netherite_Monstrosity_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.entity.New_Netherite_Monstrosity_Renderer;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;

public class Netherite_Monstrosity_Flare
extends RenderLayer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {
    private static final Identifier NETHERITE_MONSTRISITY_OUTER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/monstrosity/netherite_monstrosity_flare_outer.png");

    public Netherite_Monstrosity_Flare(New_Netherite_Monstrosity_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes2 = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_OUTER);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes2);
        int i = FastColor.ARGB32.color((int)255, (int)255, (int)255, (int)102);
        ((Netherite_Monstrosity_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i);
    }
}

