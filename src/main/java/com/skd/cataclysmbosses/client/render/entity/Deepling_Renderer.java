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

import com.skd.cataclysmbosses.client.model.entity.Deepling_Model;
import com.skd.cataclysmbosses.client.render.layer.AbstractDeepling_Layer;
import com.skd.cataclysmbosses.client.render.layer.LayerDeeplingItem;
import com.skd.cataclysmbosses.entity.Deepling.Deepling_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Deepling_Renderer
extends CmMobRenderer<Deepling_Entity> {
    private static final Identifier SSAPBUG_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_1.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_layer.png");

    public Deepling_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Deepling_Model(), 0.7f);
        this.addLayer(new AbstractDeepling_Layer(this, DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeeplingItem((RenderLayerParent)this, renderManagerIn.getItemInHandRenderer()));
    }

    public Identifier getTextureLocation(Deepling_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    protected void scale(Deepling_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

