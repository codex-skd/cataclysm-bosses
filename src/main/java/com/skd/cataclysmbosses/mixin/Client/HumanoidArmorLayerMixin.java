/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.Model
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.equipment.ArmorMaterial$Layer
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.neoforge.client.ClientHooks
 *  net.neoforged.neoforge.client.extensions.common.IClientItemExtensions
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.skd.cataclysmbosses.mixin.Client;

import com.skd.cataclysmbosses.client.render.item.CustomArmorRenderProperties;
import com.skd.cataclysmbosses.items.LayerArmorPostRender;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HumanoidArmorLayer.class})
public abstract class HumanoidArmorLayerMixin
extends RenderLayer {
    private ItemStack lastArmorItemStackRendered = ItemStack.EMPTY;

    @Shadow
    protected abstract void setPartVisibility(HumanoidModel var1, EquipmentSlot var2);

    public HumanoidArmorLayerMixin(RenderLayerParent renderLayerParent) {
        super(renderLayerParent);
    }

    @Inject(method={"renderArmorPiece(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;ILnet/minecraft/client/model/HumanoidModel;FFFFFF)V"}, at={@At(value="HEAD")}, remap=true, cancellable=true)
    private void CMrenderArmorPiece(PoseStack poseStack, MultiBufferSource bufferSource, LivingEntity livingEntity, EquipmentSlot slot, int packedLight, HumanoidModel p_model, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        ItemStack itemstack = livingEntity.getItemBySlot(slot);
        if (itemstack.getItem() instanceof LayerArmorPostRender) {
            ArmorItem armoritem;
            ci.cancel();
            this.lastArmorItemStackRendered = livingEntity.getItemBySlot(slot);
            Item item = itemstack.getItem();
            Item item2 = itemstack.getItem();
            if (item2 instanceof ArmorItem && (armoritem = (ArmorItem)item2).getEquipmentSlot() == slot) {
                boolean flag = slot == EquipmentSlot.LEGS;
                Model armorModel = ClientHooks.getArmorModel((LivingEntity)livingEntity, (ItemStack)itemstack, (EquipmentSlot)slot, (HumanoidModel)p_model);
                EntityModel entityModel = this.getParentModel();
                if (entityModel instanceof HumanoidModel) {
                    HumanoidModel parentHumanoid = (HumanoidModel)entityModel;
                    if (armorModel instanceof HumanoidModel) {
                        HumanoidModel armorHumanoid = (HumanoidModel)armorModel;
                        parentHumanoid.copyPropertiesTo((HumanoidModel)armorModel);
                    }
                }
                this.setPartVisibility((HumanoidModel)armorModel, slot);
                ArmorMaterial armormaterial = (ArmorMaterial)armoritem.getMaterial().value();
                IClientItemExtensions extensions = IClientItemExtensions.of((ItemStack)itemstack);
                extensions.setupModelAnimations(livingEntity, itemstack, slot, armorModel, limbSwing, limbSwingAmount, partialTick, ageInTicks, netHeadYaw, headPitch);
                int fallbackColor = extensions.getDefaultDyeColor(itemstack);
                for (int layerIdx = 0; layerIdx < armormaterial.layers().size(); ++layerIdx) {
                    ArmorMaterial.Layer armormaterial$layer = (ArmorMaterial.Layer)armormaterial.layers().get(layerIdx);
                    int j = extensions.getArmorLayerTintColor(itemstack, livingEntity, armormaterial$layer, layerIdx, fallbackColor);
                    if (j == 0) continue;
                    Identifier texture = ClientHooks.getArmorTexture((Entity)livingEntity, (ItemStack)itemstack, (ArmorMaterial.Layer)armormaterial$layer, (boolean)flag, (EquipmentSlot)slot);
                    CustomArmorRenderProperties.renderCustomArmor(poseStack, bufferSource, packedLight, this.lastArmorItemStackRendered, armoritem, armorModel, flag, texture);
                }
            }
        }
    }
}

