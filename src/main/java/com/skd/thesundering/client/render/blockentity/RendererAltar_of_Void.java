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
package com.skd.thesundering.client.render.blockentity;

import com.skd.thesundering.blockentities.AltarOfVoid_Block_Entity;
import com.skd.thesundering.client.model.block.Altar_of_Void_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.Identifier;

public class RendererAltar_of_Void<T extends AltarOfVoid_Block_Entity>
implements BlockEntityRenderer<T> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_void.png");
    private static final Altar_of_Void_Model MODEL = new Altar_of_Void_Model();

    public RendererAltar_of_Void(BlockEntityRendererProvider.Context rendererDispatcherIn) {
    }

    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5f, 1.5f, 0.5f);
        matrixStackIn.scale(1.0f, -1.0f, -1.0f);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
    }
}

