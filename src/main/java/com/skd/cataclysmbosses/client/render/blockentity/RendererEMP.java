/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blocks.EMP_Block;
import com.skd.cataclysmbosses.client.model.block.EMP_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.Property;

public class RendererEMP<T extends EMP_Block_Entity>
implements BlockEntityRenderer<T> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/emp.png");
    private static final EMP_Model MODEL_EMP = new EMP_Model();

    public RendererEMP(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        Direction dir = (Direction)tileEntityIn.getBlockState().getValue((Property)EMP_Block.TIP_DIRECTION);
        if (dir == Direction.UP) {
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        } else {
            matrixStackIn.translate(0.5f, -0.5f, 0.5f);
        }
        matrixStackIn.mulPose(dir.getOpposite().getRotation());
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0f, 0.15f, 0.0f);
        matrixStackIn.scale(0.9f, 0.9f, 0.9f);
        MODEL_EMP.animate((EMP_Block_Entity)((Object)tileEntityIn), partialTicks);
        MODEL_EMP.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
        matrixStackIn.popPose();
    }
}

