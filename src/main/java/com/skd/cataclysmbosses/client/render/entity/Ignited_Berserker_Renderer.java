/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.LivingEntity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Ignited_Berserker_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ignited_Berserker_Renderer
extends CmMobRenderer<Ignited_Berserker_Entity> {
    private static final Identifier BERSERKER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignited_berserker.png");
    private static final Identifier BERSERKER_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignited_berserker_layer.png");

    public Ignited_Berserker_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ignited_Berserker_Model(renderManagerIn.bakeLayer(CMModelLayers.IGNITED_BERSERKER_MODEL)), 0.5f);
        this.addLayer(new Ignited_Berserker_GlowLayer(this));
    }

    public Identifier getTextureLocation(Ignited_Berserker_Entity entity) {
        return BERSERKER_TEXTURES;
    }

    protected void scale(Ignited_Berserker_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.05f, 1.05f, 1.05f);
    }

    static class Ignited_Berserker_GlowLayer
    extends RenderLayer<Ignited_Berserker_Entity, Ignited_Berserker_Model<Ignited_Berserker_Entity>> {
        public Ignited_Berserker_GlowLayer(Ignited_Berserker_Renderer p_i50928_1_) {
            super((RenderLayerParent)p_i50928_1_);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Berserker_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getFlickering(BERSERKER_LAYER_TEXTURES));
            float alpha = 0.5f + (Mth.cos((float)(ageInTicks * 0.2f)) + 1.0f) * 0.2f;
            int i = ARGB.color((int)Mth.floor((float)(alpha * 255.0f)), (int)255, (int)255, (int)255);
            ((Ignited_Berserker_Model)this.getParentModel()).renderToBuffer(matrixStackIn, ivertexbuilder, 240, LivingEntityRenderer.getOverlayCoords((LivingEntity)entitylivingbaseIn, (float)0.0f), i);
        }
    }
}

