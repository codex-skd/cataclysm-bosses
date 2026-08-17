/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.entity;

import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.client.model.entity.Storm_Serpent_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.entity.projectile.Storm_Serpent_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Storm_Serpent_Renderer
extends EntityRenderer<Storm_Serpent_Entity> {
    private static final Identifier SNAKE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/storm_serpent.png");
    private final Storm_Serpent_Model model;

    public Storm_Serpent_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        this.model = new Storm_Serpent_Model(renderManagerIn.bakeLayer(CMModelLayers.STORM_SERPENT_MODEL));
    }

    public void render(Storm_Serpent_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(-90.0f));
        matrixStackIn.translate(0.0, 1.0, 0.0);
        matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
        float f = Mth.rotLerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot());
        float f1 = Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot());
        this.model.setupAnim(entityIn, 0.0f, 0.0f, (float)entityIn.tickCount + partialTicks, f, f1);
        float alpha = 0.8f;
        int i1 = FastColor.ARGB32.color((int)((int)(alpha * 255.0f)), (int)255, (int)255, (int)255);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i1);
        matrixStackIn.popPose();
        super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    protected int getBlockLightLevel(Storm_Serpent_Entity entityIn, BlockPos pos) {
        return 15;
    }

    public Identifier getTextureLocation(Storm_Serpent_Entity entity) {
        return SNAKE;
    }
}

