/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.network.chat.Component
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 */
package com.skd.sundering.items;

import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.entity.effect.Sandstorm_Entity;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class Sandstorm_In_A_Bottle
extends Item {
    public Sandstorm_In_A_Bottle(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            for (int i = 0; i < 2; ++i) {
                double sz;
                double sy;
                float angle = (float)i * (float)Math.PI;
                double sx = player.getX() + (double)(Mth.cos((float)angle) * 6.0f);
                Sandstorm_Entity projectile = new Sandstorm_Entity(level, sx, sy = player.getY(), sz = player.getZ() + (double)(Mth.sin((float)angle) * 6.0f), 200, angle, (LivingEntity)player);
                boolean flag = level.addFreshEntity((Entity)projectile);
                if (!flag) continue;
                player.getCooldowns().addCooldown((Item)this, CMCommonConfig.SandstormInABottle.cooldown);
            }
        }
        return InteractionResultHolder.success((Object)stack);
    }

    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
    }
}

