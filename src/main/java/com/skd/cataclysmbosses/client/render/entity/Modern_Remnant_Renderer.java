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

import com.skd.cataclysmbosses.client.model.entity.Modern_Remnant_Model;
import com.skd.cataclysmbosses.entity.Pet.Modern_Remnant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Modern_Remnant_Renderer extends CmEntityRenderer<Modern_Remnant_Entity> {
    private static final Identifier MODERN_REMNANT_TEXTURES = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/ancient_remnant/modern_remnant.png");

    public Modern_Remnant_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void render(Modern_Remnant_Entity entity, float f1, PoseStack posestack, CmMultiBufferSource multibuffersource, int i) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public Identifier getTextureLocation(Modern_Remnant_Entity entity) {
        return MODERN_REMNANT_TEXTURES;
    }
}

