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
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.entity.Sandstorm_Projectile_Model;
import com.skd.sundering.entity.projectile.Sandstorm_Projectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Sandstorm_Projectile_Renderer
extends EntityRenderer<Sandstorm_Projectile> {
    private static final Identifier SANDSTORM = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/koboleton/sandstorm.png");
    public Sandstorm_Projectile_Model model = new Sandstorm_Projectile_Model();

    public Sandstorm_Projectile_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public void render(Sandstorm_Projectile entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-0.5f, -0.5f, 0.5f);
        matrixStackIn.translate(0.0f, -1.5f, 0.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, f, f1);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(Sandstorm_Projectile entity) {
        return SANDSTORM;
    }
}

