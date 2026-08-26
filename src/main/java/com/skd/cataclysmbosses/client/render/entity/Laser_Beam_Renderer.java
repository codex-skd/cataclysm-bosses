/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Laser_Beam_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Laser_Beam_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class Laser_Beam_Renderer
extends CmEntityRenderer<Laser_Beam_Entity> {
    private static final Identifier TEXTURE_RED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/laser_beam.png");
    private static final RenderType RENDER_TYPE_RED = CMRenderTypes.CMEyes(TEXTURE_RED);
    public Laser_Beam_Model model;

    public Laser_Beam_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
        this.model = new Laser_Beam_Model(mgr.bakeLayer(CMModelLayers.LASER_BEAM_MODEL));
    }

    protected void render(Laser_Beam_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entity.xRotO, (float)entity.getXRot());
        this.model.setupAnim(f, f1);
        VertexConsumer vertexconsumer = buffer.getBuffer(RENDER_TYPE_RED);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
        poseStack.popPose();
    }

    public Identifier getTextureLocation(Laser_Beam_Entity entity) {
        return TEXTURE_RED;
    }
}

