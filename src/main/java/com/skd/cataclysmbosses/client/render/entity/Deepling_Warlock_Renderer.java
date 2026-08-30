/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;

import com.skd.cataclysmbosses.client.model.entity.Deepling_Warlock_Model;
import com.skd.cataclysmbosses.client.render.layer.AbstractDeepling_Layer;
import com.skd.cataclysmbosses.client.render.layer.LayerDeepling_WarlockItem;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Warlock_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Deepling_Warlock_Renderer
extends CmMobRenderer<Deepling_Warlock_Entity> {
    private static final Identifier DEEPLING_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_warlock.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_warlock_layer.png");

    public Deepling_Warlock_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Warlock_Model(), 0.7f);
        this.addLayer(new AbstractDeepling_Layer(this, DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeepling_WarlockItem((RenderLayerParent)this, net.minecraft.client.Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer()));
    }

    @Override
    protected void render(Deepling_Warlock_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Deepling_Warlock_Entity entity) {
        return DEEPLING_TEXTURES;
    }

    protected void scale(Deepling_Warlock_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

