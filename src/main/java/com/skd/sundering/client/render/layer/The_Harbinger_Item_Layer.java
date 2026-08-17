/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.The_Harbinger_Model;
import com.skd.sundering.client.render.RenderUtils;
import com.skd.sundering.client.render.entity.The_Harbinger_Renderer;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Harbinger_Item_Layer
extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    private AdvancedModelBox AdvancedModelBox;
    private ItemStack itemstack;
    private ItemDisplayContext transformType;

    public The_Harbinger_Item_Layer(The_Harbinger_Renderer renderIn, AdvancedModelBox AdvancedModelBox2, ItemStack itemstack, ItemDisplayContext transformType) {
        super((RenderLayerParent)renderIn);
        this.itemstack = itemstack;
        this.AdvancedModelBox = AdvancedModelBox2;
        this.transformType = transformType;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getIsAct()) {
            matrixStackIn.pushPose();
            RenderUtils.matrixStackFromCitadelModel(matrixStackIn, this.getAdvancedModelBox());
            matrixStackIn.translate(-0.0125f, 0.0f, 0.0f);
            Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().renderItem((LivingEntity)entity, this.getItemstack(), this.transformType, false, matrixStackIn, bufferIn, packedLightIn);
            matrixStackIn.popPose();
        }
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

