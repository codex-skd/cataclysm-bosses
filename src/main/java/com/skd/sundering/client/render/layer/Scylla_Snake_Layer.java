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

import com.skd.sundering.client.model.entity.Scylla_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.entity.Scylla_Renderer;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
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
public class Scylla_Snake_Layer
extends RenderLayer<Scylla_Entity, Scylla_Model> {
    private static final Identifier LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/scylla_snake.png");

    public Scylla_Snake_Layer(Scylla_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public Identifier getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scylla_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType ghost = CMRenderTypes.getGhost(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(ghost);
        float alpha = 0.35f;
        int i1 = FastColor.ARGB32.color((int)((int)(alpha * 255.0f)), (int)255, (int)255, (int)255);
        ((Scylla_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i1);
    }
}

