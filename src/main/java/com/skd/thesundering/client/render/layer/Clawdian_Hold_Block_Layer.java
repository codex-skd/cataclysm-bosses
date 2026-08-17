/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.block.BlockRenderDispatcher
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.model.entity.Clawdian_Model;
import com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Clawdian_Hold_Block_Layer
extends RenderLayer<Clawdian_Entity, Clawdian_Model> {
    private final BlockRenderDispatcher blockRenderer;

    public Clawdian_Hold_Block_Layer(RenderLayerParent<Clawdian_Entity, Clawdian_Model> renderer, BlockRenderDispatcher blockRenderer) {
        super(renderer);
        this.blockRenderer = blockRenderer;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Clawdian_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        BlockState blockstate = entity.getHoldBlock();
        if (blockstate != null) {
            int amount = 2;
            for (int i = 0; i < amount; ++i) {
                for (int l = 0; l < amount; ++l) {
                    float xOffset = (float)(i * 2 - 1) * 0.5f;
                    float zOffset = (float)(l * 2 - 1) * 0.5f;
                    matrixStackIn.pushPose();
                    ((Clawdian_Model)this.getParentModel()).translateToHand(matrixStackIn);
                    matrixStackIn.translate((double)(0.5f + xOffset), 1.0 + 0.08 * (double)(i + l), (double)(-0.7f + zOffset));
                    matrixStackIn.scale(-1.0f, -1.0f, 1.0f);
                    this.blockRenderer.renderSingleBlock(blockstate, matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY);
                    matrixStackIn.popPose();
                }
            }
        }
    }
}

