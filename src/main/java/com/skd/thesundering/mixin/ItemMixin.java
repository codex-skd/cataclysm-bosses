/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.item.ItemStack
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.skd.thesundering.mixin;

import com.skd.thesundering.init.ModTag;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ItemEntity.class})
public abstract class ItemMixin {
    @Shadow
    public abstract ItemStack getItem();

    @Inject(method={"hurt"}, remap=true, at={@At(value="HEAD")}, cancellable=true)
    public void Cmhurt(DamageSource damageSource, float p_32014_, CallbackInfoReturnable<Boolean> cir) {
        if (!this.getItem().isEmpty() && damageSource.is(DamageTypeTags.IS_EXPLOSION) && this.getItem().is(ModTag.EXPLOSION_IMMUNE_ITEM)) {
            cir.setReturnValue((Object)false);
        }
    }
}

