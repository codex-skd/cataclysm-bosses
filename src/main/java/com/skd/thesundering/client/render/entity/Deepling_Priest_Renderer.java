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
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.entity.Deepling_Priest_Model;
import com.skd.thesundering.client.render.layer.AbstractDeepling_Layer;
import com.skd.thesundering.client.render.layer.LayerDeepling_PriestItem;
import com.skd.thesundering.client.render.layer.LayerDeepling_Priest_Light;
import com.skd.thesundering.entity.Deepling.Deepling_Priest_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Deepling_Priest_Renderer
extends MobRenderer<Deepling_Priest_Entity, Deepling_Priest_Model> {
    private static final Identifier DEEPLING_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_priest.png");
    private static final Identifier DEEPLING_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/deepling_priest_layer.png");

    public Deepling_Priest_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Deepling_Priest_Model(), 0.7f);
        this.addLayer(new AbstractDeepling_Layer(this, DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeepling_PriestItem((RenderLayerParent)this, renderManagerIn.getItemInHandRenderer()));
        this.addLayer(new LayerDeepling_Priest_Light((RenderLayerParent)this));
    }

    public Identifier getTextureLocation(Deepling_Priest_Entity entity) {
        return DEEPLING_TEXTURES;
    }

    protected void scale(Deepling_Priest_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

