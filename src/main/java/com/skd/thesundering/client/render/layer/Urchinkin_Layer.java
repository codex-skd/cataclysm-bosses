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

import com.skd.thesundering.client.model.entity.Urchinkin_Model;
import com.skd.thesundering.client.render.entity.Urchinkin_Renderer;
import com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters.Urchinkin_Entity;
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
public class Urchinkin_Layer
extends RenderLayer<Urchinkin_Entity, Urchinkin_Model> {
    private static final Identifier URCHIN_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/urchinkin_layer.png");
    private static final Identifier MEAT_BOY_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/meat_boy_layer.png");

    public Urchinkin_Layer(Urchinkin_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Urchinkin_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = RenderType.eyes((Identifier)this.Texture(entity));
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        ((Urchinkin_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY);
    }

    public Identifier Texture(Urchinkin_Entity entity) {
        if (entity.isMeatBoy()) {
            return MEAT_BOY_LAYER_TEXTURES;
        }
        return URCHIN_LAYER_TEXTURES;
    }
}

