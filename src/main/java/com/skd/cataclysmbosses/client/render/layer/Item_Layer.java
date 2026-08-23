/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.client.render.RenderUtils;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class Item_Layer<T extends LivingEntity, M extends EntityModel<T>>
extends RenderLayer<T, M> {
    private AdvancedModelBox AdvancedModelBox;
    private ItemStack itemstack;
    private ItemDisplayContext transformType;

    public Item_Layer(RenderLayerParent<T, M> renderer, AdvancedModelBox AdvancedModelBox2, ItemStack itemstack, ItemDisplayContext transformType) {
        super(renderer);
        this.itemstack = itemstack;
        this.AdvancedModelBox = AdvancedModelBox2;
        this.transformType = transformType;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!this.AdvancedModelBox.showModel) {
            return;
        }
        matrixStackIn.pushPose();
        RenderUtils.matrixStackFromCitadelModel(matrixStackIn, this.getAdvancedModelBox());
        Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().renderItem(entitylivingbaseIn, this.getItemstack(), this.transformType, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.popPose();
    }

    public ItemStack getItemstack() {
        return this.itemstack;
    }

    public void setItemstack(ItemStack itemstack) {
        this.itemstack = itemstack;
    }

    public AdvancedModelBox getAdvancedModelBox() {
        return this.AdvancedModelBox;
    }

    public void setAdvancedModelBox(AdvancedModelBox AdvancedModelBox2) {
        this.AdvancedModelBox = AdvancedModelBox2;
    }
}

