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
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Orb_Entity;
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
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Abyss_Orb_Renderer
extends CmEntityRenderer<Abyss_Orb_Entity> {
    private static final Identifier TEXTURE_LOCATION = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/abyss_orb.png");
    private static final RenderType RENDER_TYPE = RenderTypes.entityCutoutNoCull((Identifier)TEXTURE_LOCATION);

    public Abyss_Orb_Renderer(EntityRendererProvider.Context p_173962_) {
        super(p_173962_);
    }

    protected int getBlockLightLevel(Abyss_Orb_Entity p_114087_, BlockPos p_114088_) {
        return 15;
    }

    protected void render(Abyss_Orb_Entity p_114080_, float p_114082_, PoseStack p_114083_, CmMultiBufferSource p_114084_, int p_114085_) {
        p_114083_.pushPose();
        p_114083_.scale(1.0f, 1.0f, 1.0f);
        p_114083_.mulPose(this.entityRenderDispatcher.cameraOrientation());
        p_114083_.mulPose(Axis.YP.rotationDegrees(180.0f));
        PoseStack.Pose posestack$pose = p_114083_.last();
        VertexConsumer vertexconsumer = p_114084_.getBuffer(RENDER_TYPE);
        Abyss_Orb_Renderer.vertex(vertexconsumer, posestack$pose, p_114085_, 0.0f, 0, 0, 1);
        Abyss_Orb_Renderer.vertex(vertexconsumer, posestack$pose, p_114085_, 1.0f, 0, 1, 1);
        Abyss_Orb_Renderer.vertex(vertexconsumer, posestack$pose, p_114085_, 1.0f, 1, 1, 0);
        Abyss_Orb_Renderer.vertex(vertexconsumer, posestack$pose, p_114085_, 0.0f, 1, 0, 0);
        p_114083_.popPose();
    }

    private static void vertex(VertexConsumer p_114090_, PoseStack.Pose normals, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.addVertex(normals, p_114094_ - 0.5f, (float)p_114095_ - 0.25f, 0.0f).setColor(255, 255, 255, 255).setUv((float)p_114096_, (float)p_114097_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_114093_).setNormal(normals, 0.0f, 1.0f, 0.0f);
    }

    public Identifier getTextureLocation(Abyss_Orb_Entity p_114078_) {
        return TEXTURE_LOCATION;
    }
}

