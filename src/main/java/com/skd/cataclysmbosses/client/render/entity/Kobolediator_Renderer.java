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
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Kobolediator_Model;
import com.skd.cataclysmbosses.client.render.layer.Kobolediator_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Kobolediator_Renderer
extends CmMobRenderer<Kobolediator_Entity> {
    private static final Identifier KOBOLEDIATOR_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/koboleton/kobolediator.png");

    public Kobolediator_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Kobolediator_Model(renderManagerIn.bakeLayer(CMModelLayers.KOBOLEDIATOR_MODEL)), 1.25f);
        this.addLayer(new Kobolediator_Layer(this));
    }

    @Override
    protected void render(Kobolediator_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Kobolediator_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    protected float getFlipDegrees(Kobolediator_Entity entity) {
        return 0.0f;
    }

    protected void scale(Kobolediator_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
    }
}

