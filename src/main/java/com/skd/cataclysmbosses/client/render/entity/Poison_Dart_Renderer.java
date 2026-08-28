/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.entity.projectile.Poison_Dart_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Poison_Dart_Renderer
extends CmEntityRenderer<Poison_Dart_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/poison_dart.png");

    public Poison_Dart_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public Identifier getTextureLocation(Poison_Dart_Entity entity) {
        return TEXTURE;
    }

    protected void render(Poison_Dart_Entity p_113839_, float p_113841_, PoseStack p_113842_, CmMultiBufferSource p_113843_, int p_113844_) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    public void vertex(PoseStack.Pose p_324380_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.addVertex(p_324380_, (float)p_254058_, (float)p_254338_, (float)p_254196_).setColor(-1).setUv(p_254003_, p_254165_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_254271_).setNormal(p_324380_, (float)p_253982_, (float)p_254038_, (float)p_254037_);
    }
}

