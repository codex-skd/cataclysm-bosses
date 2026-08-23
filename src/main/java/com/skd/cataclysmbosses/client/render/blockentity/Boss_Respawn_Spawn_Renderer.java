/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 */
package com.skd.cataclysmbosses.client.render.blockentity;

import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.client.model.block.Boss_Respawn_Spawner_Model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Boss_Respawn_Spawn_Renderer
implements BlockEntityRenderer<Boss_Respawn_Spawner_Block_Entity> {
    private final EntityRenderDispatcher entityRenderer;
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/boss_respawner.png");
    private static final Boss_Respawn_Spawner_Model MODEL = new Boss_Respawn_Spawner_Model();
    private final ItemRenderer itemRenderer;

    public Boss_Respawn_Spawn_Renderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        this.entityRenderer = rendererDispatcherIn.getEntityRenderer();
        this.itemRenderer = rendererDispatcherIn.getItemRenderer();
    }

    public void render(Boss_Respawn_Spawner_Block_Entity entity, float delta, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5f, 1.501f, 0.5f);
        poseStack.scale(1.0f, -1.0f, -1.0f);
        MODEL.animate(entity, delta);
        MODEL.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull((Identifier)TEXTURE)), packedLight, overlay);
        poseStack.popPose();
        poseStack.pushPose();
        Entity currentEntity = entity.getDisplayEntity((Level)Minecraft.getInstance().level);
        if (currentEntity != null) {
            float f = 0.53125f;
            float f1 = Math.max(currentEntity.getBbWidth(), currentEntity.getBbHeight());
            if ((double)f1 > 1.0) {
                f /= f1;
            }
            poseStack.translate(0.5f, 0.1f, 0.5f);
            poseStack.scale(f, f, f);
            this.entityRenderer.render(currentEntity, 0.0, 0.0, 0.0, 0.0f, delta, poseStack, buffer, packedLight);
        }
        poseStack.popPose();
        this.renderItem(entity, delta, poseStack, buffer, packedLight);
    }

    public void renderItem(Boss_Respawn_Spawner_Block_Entity tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn) {
        int posLong = (int)tileEntityIn.getBlockPos().asLong();
        ItemStack stack = tileEntityIn.getTheItem();
        if (stack != ItemStack.EMPTY) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5, (double)1.15f, 0.5);
            matrixStackIn.scale(0.5f, 0.5f, 0.5f);
            if (tileEntityIn.getLevel() != null) {
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0f));
                this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, combinedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn, tileEntityIn.getLevel(), posLong);
            }
            matrixStackIn.popPose();
        }
    }
}

