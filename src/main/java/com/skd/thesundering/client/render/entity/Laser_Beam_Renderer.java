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
package com.skd.thesundering.client.render.entity;

import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.entity.Laser_Beam_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.entity.projectile.Laser_Beam_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Laser_Beam_Renderer
extends EntityRenderer<Laser_Beam_Entity> {
    private static final Identifier TEXTURE_RED = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/laser_beam.png");
    private static final RenderType RENDER_TYPE_RED = CMRenderTypes.CMEyes(TEXTURE_RED);
    public Laser_Beam_Model model;

    public Laser_Beam_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
        this.model = new Laser_Beam_Model(mgr.bakeLayer(CMModelLayers.LASER_BEAM_MODEL));
    }

    public void render(Laser_Beam_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entity.xRotO, (float)entity.getXRot());
        this.model.setupAnim(f, f1);
        VertexConsumer vertexconsumer = buffer.getBuffer(RENDER_TYPE_RED);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render((Entity)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    public Identifier getTextureLocation(Laser_Beam_Entity entity) {
        return TEXTURE_RED;
    }
}

