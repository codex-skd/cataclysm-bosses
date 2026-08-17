/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.entity.Hippocamtus_Model;
import com.skd.sundering.client.render.layer.Hippocamtus_Layer;
import com.skd.sundering.entity.InternalAnimationMonster.AcropolisMonsters.Hippocamtus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Hippocamtus_Renderer
extends MobRenderer<Hippocamtus_Entity, Hippocamtus_Model> {
    private static final Identifier KOBOLEDIATOR_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/hippocamtus.png");

    public Hippocamtus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Hippocamtus_Model(renderManagerIn.bakeLayer(CMModelLayers.HIPPOCAMTUS_MODEL)), 0.75f);
        this.addLayer(new Hippocamtus_Layer(this));
    }

    public Identifier getTextureLocation(Hippocamtus_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    protected float getFlipDegrees(Hippocamtus_Entity entity) {
        return 0.0f;
    }

    protected void scale(Hippocamtus_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

