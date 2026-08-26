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
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Cindaria_Model;
import com.skd.cataclysmbosses.client.render.layer.Cindaria_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Cindaria_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Cindaria_Renderer
extends CmMobRenderer<Cindaria_Entity> {
    private static final Identifier CINDARIA_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/cindaria_armor.png");

    public Cindaria_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Cindaria_Model(renderManagerIn.bakeLayer(CMModelLayers.CINDARIA_MODEL)), 0.5f);
        this.addLayer(new Cindaria_Layer(this));
    }

    public Identifier getTextureLocation(Cindaria_Entity entity) {
        return CINDARIA_TEXTURES;
    }

    protected float getFlipDegrees(Cindaria_Entity entity) {
        return 0.0f;
    }

    protected void scale(Cindaria_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.8f, 0.8f, 0.8f);
    }
}

