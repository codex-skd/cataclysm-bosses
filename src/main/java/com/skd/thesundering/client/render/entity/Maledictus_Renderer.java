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
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.entity.Maledictus_Model;
import com.skd.thesundering.client.render.layer.MaledictusRiderLayer;
import com.skd.thesundering.client.render.layer.Maledictus_Cicle_Layer;
import com.skd.thesundering.client.render.layer.Maledictus_Layer;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Maledictus_Renderer
extends MobRenderer<Maledictus_Entity, Maledictus_Model> {
    private static final Identifier MALEDICTUS_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/maledictus/maledictus_armor.png");

    public Maledictus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Maledictus_Model(renderManagerIn.bakeLayer(CMModelLayers.MALEDICTUS_MODEL)), 0.75f);
        this.addLayer(new Maledictus_Layer(this));
        this.addLayer(new Maledictus_Cicle_Layer(this, renderManagerIn));
        this.addLayer(new MaledictusRiderLayer(this));
    }

    public Identifier getTextureLocation(Maledictus_Entity entity) {
        return MALEDICTUS_TEXTURES;
    }

    protected float getFlipDegrees(Maledictus_Entity entity) {
        return 0.0f;
    }

    protected void scale(Maledictus_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

