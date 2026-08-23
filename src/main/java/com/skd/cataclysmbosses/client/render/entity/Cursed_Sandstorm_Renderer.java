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
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Cursed_Sandstorm_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.projectile.Cursed_Sandstorm_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Cursed_Sandstorm_Renderer
extends EntityRenderer<Cursed_Sandstorm_Entity> {
    private static final Identifier SANDSTORM = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/cursed_sandstorm.png");
    public Cursed_Sandstorm_Model model = new Cursed_Sandstorm_Model();

    public Cursed_Sandstorm_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public void render(Cursed_Sandstorm_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-0.5f, -0.5f, 0.5f);
        matrixStackIn.translate(0.0f, -1.5f, 0.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, f, f1);
        int i = FastColor.ARGB32.color((int)255, (int)255, (int)255, (int)253);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public Identifier getTextureLocation(Cursed_Sandstorm_Entity entity) {
        return SANDSTORM;
    }
}

