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
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.Hippocamtus_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.entity.Hippocamtus_Renderer;
import com.skd.sundering.entity.InternalAnimationMonster.AcropolisMonsters.Hippocamtus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Hippocamtus_Layer
extends RenderLayer<Hippocamtus_Entity, Hippocamtus_Model> {
    private static final Identifier PROWLER_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/hippocamtus_layer.png");

    public Hippocamtus_Layer(Hippocamtus_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    protected Identifier getTextureLocation(Hippocamtus_Entity entity) {
        return PROWLER_LAYER_TEXTURES;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Hippocamtus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getAttackState() == 4) {
            int f = entity.attackTicks < 7 ? entity.attackTicks * 255 / 12 : (entity.attackTicks <= 17 ? 255 : Math.max(0, 255 - (entity.attackTicks - 17) * 255 / 21));
            int i = FastColor.ARGB32.color((int)255, (int)f, (int)f, (int)f);
            RenderType eyes = CMRenderTypes.CMEyes(this.getTextureLocation(entity));
            VertexConsumer vertexConsumer = bufferIn.getBuffer(eyes);
            ((Hippocamtus_Model)this.getParentModel()).renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);
        }
    }
}

