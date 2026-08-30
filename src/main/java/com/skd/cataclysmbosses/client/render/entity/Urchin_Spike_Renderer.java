/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.entity.projectile.Urchin_Spike_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Urchin_Spike_Renderer
extends CmEntityRenderer<Urchin_Spike_Entity> {
    public Urchin_Spike_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    protected void render(Urchin_Spike_Entity entity, float partialTicks, PoseStack stack, CmMultiBufferSource buffer, int light) {
        stack.pushPose();
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot()) - 90.0f));
        stack.mulPose(Axis.ZP.rotationDegrees(-45.0f));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entity.xRotO, (float)entity.getXRot())));
        stack.translate(0.0f, 0.0f, 0.0f);
        // PORT TODO(26.2): re-wire item render
        // Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, stack, buffer, entity.level(), entity.getId());
        stack.popPose();
        stack.popPose();
    }

    public Identifier getTextureLocation(Urchin_Spike_Entity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

