/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.food.FoodData
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package com.skd.thesundering.mixin;

import com.skd.thesundering.init.ModAttribute;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={FoodData.class})
public abstract class FoodDataMixin {
    @WrapOperation(method={"tick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Player;heal(F)V")})
    private void wrapHeal(Player player, float amount, Operation<Void> original) {
        float healAttrValue = (float)player.getAttributeValue(ModAttribute.NATURE_HEAL);
        float healMultiplier = 1.0f + healAttrValue / 100.0f;
        healMultiplier = Math.max(0.0f, healMultiplier);
        original.call(new Object[]{player, Float.valueOf(amount * healMultiplier)});
    }
}

