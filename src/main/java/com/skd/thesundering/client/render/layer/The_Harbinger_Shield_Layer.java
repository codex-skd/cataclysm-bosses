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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.model.entity.The_Harbinger_Model;
import com.skd.thesundering.client.render.entity.The_Harbinger_Renderer;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Harbinger_Shield_Layer
extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    private static final Identifier HARBINGER_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/the_harbinger_shield_layer.png");

    public The_Harbinger_Shield_Layer(The_Harbinger_Renderer rendererTheHarbinger) {
        super((RenderLayerParent)rendererTheHarbinger);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity harbinger, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = (float)harbinger.tickCount + partialTicks;
        if (harbinger.isPowered()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.02f, 1.02f, 1.02f);
            EntityModel entitymodel = this.getParentModel();
            entitymodel.prepareMobModel((Entity)harbinger, limbSwing, limbSwingAmount, partialTicks);
            ((The_Harbinger_Model)this.getParentModel()).copyPropertiesTo(entitymodel);
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.energySwirl((Identifier)this.getTextureLocation(), (float)this.xOffset(f), (float)(f * 0.01f)));
            entitymodel.setupAnim((Entity)harbinger, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            entitymodel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, -8355712);
            matrixStackIn.popPose();
        }
    }

    protected float xOffset(float p_117702_) {
        return Mth.cos((float)(p_117702_ * 0.02f)) * 2.0f;
    }

    protected Identifier getTextureLocation() {
        return HARBINGER_LAYER_TEXTURES;
    }
}

