/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.resources.Identifier
 */
package com.skd.sundering.client.render.blockentity;

import com.skd.sundering.blockentities.Abyssal_Egg_Block_Entity;
import com.skd.sundering.client.model.block.Abyssal_Egg_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.Identifier;

public class RendererAbyssal_Egg
implements BlockEntityRenderer<Abyssal_Egg_Block_Entity> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/abyssal_egg.png");
    private static final Identifier LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/abyssal_egg_layer.png");
    private static final Abyssal_Egg_Model MODEL = new Abyssal_Egg_Model();

    public RendererAbyssal_Egg(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public void render(Abyssal_Egg_Block_Entity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        matrixStackIn.scale(1.0f, -1.0f, -1.0f);
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), combinedLightIn, combinedOverlayIn);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getGhost(LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
    }
}

