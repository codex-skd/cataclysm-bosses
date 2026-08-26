/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.block.BlockRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.block.RenderShape
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.entity.projectile.Accretion_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Accretion_Renderer
extends EntityRenderer<Accretion_Entity, EntityRenderState> {
    private final BlockRenderDispatcher blockRenderer;
    private final EntityRenderDispatcher entityRenderer;
    private final RandomSource rnd = RandomSource.create();

    public Accretion_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        this.blockRenderer = renderManagerIn.getBlockRenderDispatcher();
        this.entityRenderer = renderManagerIn.getEntityRenderDispatcher();
    }

    public void render(Accretion_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        BlockState blockstate = entityIn.getBlockState();
        if (blockstate != null && blockstate.getRenderShape() == RenderShape.MODEL) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.0, 0.5, 0.0);
            float f2 = (float)entityIn.tickCount + partialTicks;
            float random = this.rnd.nextFloat() * 0.03f;
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(random * f2 * 60.0f));
            matrixStackIn.mulPose(Axis.ZN.rotationDegrees(f2 * 36.0f));
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.yRotO, (float)entityIn.getYRot()) - 90.0f));
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp((float)partialTicks, (float)entityIn.xRotO, (float)entityIn.getXRot()) + 90.0f));
            matrixStackIn.translate(-0.5, -0.5, -0.5);
            float scale = 0.0f;
            if (entityIn.isVehicle()) {
                for (Entity passenger : entityIn.getPassengers()) {
                    if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) continue;
                    this.renderEntityInClaw(partialTicks, matrixStackIn, bufferIn, packedLightIn, passenger, this.entityRenderer);
                }
            } else {
                scale = 1.0f;
            }
            matrixStackIn.scale(scale, scale, scale);
            this.blockRenderer.renderSingleBlock(blockstate, matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.popPose();
            super.render((Entity)entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        }
    }

    public void renderEntityInClaw(float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, Entity entity, EntityRenderDispatcher entityRenderer) {
        Cataclysm.PROXY.releaseRenderingEntity(entity.getUUID());
        poseStack.pushPose();
        poseStack.translate(0.5f, -0.5f, 0.5f);
        poseStack.scale(1.0f, 1.0f, 1.0f);
        entityRenderer.render(entity, 0.0, 0.0, 0.0, 0.0f, partialTick, poseStack, buffer, packedLight);
        poseStack.popPose();
        Cataclysm.PROXY.blockRenderingEntity(entity.getUUID());
    }

    public Identifier getTextureLocation(Accretion_Entity p_114632_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

