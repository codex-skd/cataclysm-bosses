/*
 * Decompiled with CFR 0.152.
 *
 * PORT NOTE (26.2): the original injection targeted the removed
 * HumanoidArmorLayer#renderArmorPiece(PoseStack, MultiBufferSource, LivingEntity,
 * EquipmentSlot, int, HumanoidModel, F...) pipeline. Armor rendering now goes through
 * SubmitNodeCollector / EquipmentLayerRenderer + IClientItemExtensions#getHumanoidArmorModel.
 * The custom Cursium ghost-layer rendering must be re-implemented against the new
 * SubmitNodeCollector-based pipeline as part of the client render cluster port.
 */
package com.skd.cataclysmbosses.mixin.Client;

import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = {HumanoidArmorLayer.class})
public abstract class HumanoidArmorLayerMixin {
}
