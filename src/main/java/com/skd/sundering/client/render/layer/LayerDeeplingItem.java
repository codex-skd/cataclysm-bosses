/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.ItemInHandRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.Deepling_Model;
import com.skd.sundering.entity.Deepling.Deepling_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class LayerDeeplingItem
extends RenderLayer<Deepling_Entity, Deepling_Model> {
    private final ItemInHandRenderer itemInHandRenderer;

    public LayerDeeplingItem(RenderLayerParent p_234846_, ItemInHandRenderer p_234847_) {
        super(p_234846_);
        this.itemInHandRenderer = p_234847_;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Deepling_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entitylivingbaseIn.getItemBySlot(EquipmentSlot.MAINHAND);
        matrixStackIn.pushPose();
        boolean left = entitylivingbaseIn.isLeftHanded();
        matrixStackIn.pushPose();
        this.translateToHand(matrixStackIn, left);
        matrixStackIn.translate(0.0f, 1.4225f, -0.1f);
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90.0f));
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0f));
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
        ItemInHandRenderer renderer = Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer();
        renderer.renderItem((LivingEntity)entitylivingbaseIn, itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.popPose();
        matrixStackIn.popPose();
    }

    protected void translateToHand(PoseStack matrixStack, boolean left) {
        ((Deepling_Model)this.getParentModel()).root.translateAndRotate(matrixStack);
        ((Deepling_Model)this.getParentModel()).body.translateAndRotate(matrixStack);
        if (left) {
            ((Deepling_Model)this.getParentModel()).left_arm.translateAndRotate(matrixStack);
        } else {
            ((Deepling_Model)this.getParentModel()).right_arm.translateAndRotate(matrixStack);
        }
    }
}

