/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Wither_Missile_Model;
import com.skd.cataclysmbosses.entity.projectile.Wither_Missile_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Wither_Missile_Renderer
extends CmEntityRenderer<Wither_Missile_Entity> {
    private static final Identifier WITHER_MISSILE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/harbinger/wither_missile.png");
    public Wither_Missile_Model model = new Wither_Missile_Model();

    public Wither_Missile_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    protected int getBlockLightLevel(Wither_Missile_Entity entity, BlockPos pos) {
        return 15;
    }

    protected void render(Wither_Missile_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RenderTypes.entityCutout(this.getTextureLocation(entityIn)));
        this.model.setupAnim((Entity)entityIn, 0.0f, 0.0f, 0.0f, f, f1);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        matrixStackIn.popPose();
    }

    public Identifier getTextureLocation(Wither_Missile_Entity entity) {
        return WITHER_MISSILE;
    }
}

