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
package com.skd.sundering.client.render.entity;

import com.skd.sundering.entity.projectile.Lionfish_Spike_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Lionfish_Spike_Renderer
extends EntityRenderer<Lionfish_Spike_Entity> {
    public Lionfish_Spike_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public void render(Lionfish_Spike_Entity entity, float yaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int light) {
        stack.pushPose();
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot()) - 90.0f));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entity.xRotO, (float)entity.getXRot())));
        stack.translate(0.0f, 0.0f, 0.0f);
        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, stack, buffer, entity.level(), entity.getId());
        stack.popPose();
        stack.popPose();
    }

    public Identifier getTextureLocation(Lionfish_Spike_Entity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

