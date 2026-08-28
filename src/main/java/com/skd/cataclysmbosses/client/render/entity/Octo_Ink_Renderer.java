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

import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import com.skd.cataclysmbosses.entity.projectile.Octo_Ink_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Octo_Ink_Renderer
extends CmEntityRenderer<Octo_Ink_Entity> {

    public Octo_Ink_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected void render(Octo_Ink_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        // TODO: Implement octo ink rendering
    }

    @Override
    public Identifier getTextureLocation(Octo_Ink_Entity entity) {
        return Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/octo_ink.png");
    }
}
