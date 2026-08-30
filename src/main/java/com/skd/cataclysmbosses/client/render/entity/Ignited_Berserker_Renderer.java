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
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
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

    @Override
    protected void render(Ignited_Berserker_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Ignited_Berserker_Entity entity) {
        return BERSERKER_TEXTURES;
    }

    protected void scale(Ignited_Berserker_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.05f, 1.05f, 1.05f);
    }

    // PORT NOTE (26.2): stubbed for compile — original RenderLayer used old
    // MultiBufferSource/Entity API. Proper port needs RenderLayer<LivingEntityRenderState, EntityModel>
    // with SubmitNodeCollector. Tracked separately.
    static class Ignited_Berserker_GlowLayer {
        public Ignited_Berserker_GlowLayer(Object... args) {}
        public void render(PoseStack poseStack, Object buffer, int packedLight, Object entity, float a, float b, float c, float d, float e, float f) {}
    }
}

