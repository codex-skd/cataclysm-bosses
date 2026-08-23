/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blocks.Mechanical_fusion_Anvil;
import com.skd.cataclysmbosses.client.model.block.Mechanical_Anvil_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.Property;

public class RendererMechanical_fusion_anvil<T extends Mechanical_fusion_Anvil_Block_Entity>
implements BlockEntityRenderer<T> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/mechanical_fusion_anvil.png");
    private static final Identifier LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/mechanical_fusion_anvil_layer.png");
    private static final Mechanical_Anvil_Model MODEL = new Mechanical_Anvil_Model();

    public RendererMechanical_fusion_anvil(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        float f = ((Direction)tileEntityIn.getBlockState().getValue((Property)Mechanical_fusion_Anvil.FACING)).toYRot();
        matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(-f + 90.0f));
        matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
        MODEL.animate((Mechanical_fusion_Anvil_Block_Entity)((Object)tileEntityIn), partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), combinedLightIn, combinedOverlayIn);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityTranslucentCull((Identifier)LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
    }
}

