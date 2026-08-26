/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.item.Brontes_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Brontes_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Brontes_Renderer
extends CmEntityRenderer<Brontes_Entity> {
    private final Brontes_Model model = new Brontes_Model();
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/brontes.png");
    private static final Identifier TEXTURE_LAYER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/brontes_layer.png");

    public Brontes_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    protected void render(Brontes_Entity entity, float partialTicks, PoseStack poseStack, CmMultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entity.yRotO, (float)entity.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(((float)entity.tickCount + partialTicks) * 40.0f));
        VertexConsumer vertexconsumer = buffer.getBuffer(RenderTypes.entityCutout(TEXTURE));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
        VertexConsumer vertexconsumer2 = buffer.getBuffer(CMRenderTypes.CMEyes(TEXTURE_LAYER));
        this.model.renderToBuffer(poseStack, vertexconsumer2, packedLight, OverlayTexture.NO_OVERLAY, -1);
        poseStack.popPose();
    }

    public Identifier getTextureLocation(Brontes_Entity entity) {
        return TEXTURE;
    }
}

