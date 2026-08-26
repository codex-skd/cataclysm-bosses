/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.geom.EntityModelSet
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Drowned_Host_Model;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Drowned_Host_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Drowned_Host_Outer_Layer {
    private static final Identifier DROWNED_OUTER_LAYER_LOCATION = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/sea/drowned_host_outer_layer.png");
    private final Drowned_Host_Model model;

    public Drowned_Host_Outer_Layer(Object renderer, EntityModelSet modelSet) {
        this.model = new Drowned_Host_Model(modelSet.bakeLayer(CMModelLayers.DROWNED_HOST_OUTER_LAYER));
    }
}

