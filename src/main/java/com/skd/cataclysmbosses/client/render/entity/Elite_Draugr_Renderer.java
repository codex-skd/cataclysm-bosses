/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.ItemInHandLayer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 */
package com.skd.cataclysmbosses.client.render.entity;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Elite_Draugr_Model;
import com.skd.cataclysmbosses.client.render.layer.LayerGenericGlowing;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;

public class Elite_Draugr_Renderer
extends CmMobRenderer<Elite_Draugr_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/elite_draugr.png");
    private static final Identifier LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/elite_draugr_layer.png");

    public Elite_Draugr_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Elite_Draugr_Model(renderManagerIn.bakeLayer(CMModelLayers.ELITE_DRAUGR_MODEL)), 0.5f);
        this.addLayer(new LayerGenericGlowing(this, LAYER));
        this.addLayer((RenderLayer)new ItemInHandLayer((RenderLayerParent)this, renderManagerIn.getItemInHandRenderer()));
    }

    protected void scale(Elite_Draugr_Entity p_114907_, PoseStack p_114908_, float p_114909_) {
        float f = 1.0f;
        p_114908_.scale(f, f, f);
        super.scale((LivingEntity)p_114907_, p_114908_, p_114909_);
    }

    public Identifier getTextureLocation(Elite_Draugr_Entity entity) {
        return TEXTURE;
    }
}

