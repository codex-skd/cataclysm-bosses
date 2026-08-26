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

import com.skd.cataclysmbosses.client.model.entity.Coral_Golem_Model;
import com.skd.cataclysmbosses.entity.Deepling.Coral_Golem_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Coral_Golem_Renderer
extends CmMobRenderer<Coral_Golem_Entity> {
    private static final Identifier CORALSSUS_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/deepling/coral_golem.png");

    public Coral_Golem_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, (EntityModel)new Coral_Golem_Model(), 1.5f);
    }

    public Identifier getTextureLocation(Coral_Golem_Entity entity) {
        return CORALSSUS_TEXTURES;
    }

    protected void scale(Coral_Golem_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.75f, 1.75f, 1.75f);
    }
}

