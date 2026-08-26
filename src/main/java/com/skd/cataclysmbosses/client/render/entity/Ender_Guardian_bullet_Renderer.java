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
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Ender_Guardian_Bullet_Model;
import com.skd.cataclysmbosses.entity.projectile.Ender_Guardian_Bullet_Entity;
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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Ender_Guardian_bullet_Renderer
extends CmEntityRenderer<Ender_Guardian_Bullet_Entity> {
    private static final Identifier ENDER_GUARDIAN_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/shulkerbullet.png");
    private static final RenderType ENDER_GUARDIAN_RENDER_TYPE = RenderTypes.entityTranslucent((Identifier)ENDER_GUARDIAN_TEXTURE);
    public Ender_Guardian_Bullet_Model model = new Ender_Guardian_Bullet_Model();

    public Ender_Guardian_bullet_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    protected int getBlockLightLevel(Ender_Guardian_Bullet_Entity entity, BlockPos pos) {
        return 15;
    }

    protected void render(Ender_Guardian_Bullet_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        float f = this.rotLerp(entityIn.yRotO, entityIn.getYRot(), partialTicks);
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        float f2 = (float)entityIn.tickCount + partialTicks;
        matrixStackIn.translate(0.0, (double)0.15f, 0.0);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.sin((float)(f2 * 0.1f)) * 180.0f));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.cos((float)(f2 * 0.1f)) * 180.0f));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.sin((float)(f2 * 0.15f)) * 360.0f));
        matrixStackIn.scale(-0.5f, -0.5f, 0.5f);
        this.model.setupAnim((Entity)entityIn, 0.0f, 0.0f, 0.0f, f, f1);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(RenderTypes.entityCutout(ENDER_GUARDIAN_TEXTURE));
        this.model.renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        matrixStackIn.scale(1.5f, 1.5f, 1.5f);
        VertexConsumer VertexConsumer1 = bufferIn.getBuffer(ENDER_GUARDIAN_RENDER_TYPE);
        this.model.renderToBuffer(matrixStackIn, VertexConsumer1, packedLightIn, OverlayTexture.NO_OVERLAY, 0x26FFFFFF);
        matrixStackIn.popPose();
    }

    public Identifier getTextureLocation(Ender_Guardian_Bullet_Entity entity) {
        return ENDER_GUARDIAN_TEXTURE;
    }

    private float rotLerp(float prevRotation, float rotation, float partialTicks) {
        float f;
        for (f = rotation - prevRotation; f < -180.0f; f += 360.0f) {
        }
        while (f >= 180.0f) {
            f -= 360.0f;
        }
        return prevRotation + partialTicks * f;
    }
}

