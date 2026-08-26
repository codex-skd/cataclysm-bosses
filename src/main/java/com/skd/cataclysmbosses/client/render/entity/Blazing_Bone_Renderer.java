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
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.entity.projectile.Blazing_Bone_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Blazing_Bone_Renderer
extends EntityRenderer<Blazing_Bone_Entity, EntityRenderState> {
    public Blazing_Bone_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public void render(Blazing_Bone_Entity entity, float yaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int light) {
        stack.pushPose();
        float spin = ((float)entity.tickCount + partialTicks) * 30.0f;
        stack.scale(1.25f, 1.25f, 1.25f);
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(yaw + 90.0f));
        stack.mulPose(Axis.ZP.rotationDegrees(spin));
        stack.translate(0.0f, 0.0f, 0.0f);
        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, stack, buffer, entity.level(), entity.getId());
        stack.popPose();
        stack.popPose();
    }

    public Identifier getTextureLocation(Blazing_Bone_Entity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

