/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 */
package com.skd.sundering.items;

import com.skd.sundering.Attachment.ChargeAttachment;
import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.init.ModDataAttachments;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class Bulwark_of_the_flame
extends Item {
    public Bulwark_of_the_flame(Item.Properties group) {
        super(group);
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_77661_1_) {
        return ItemUseAnimation.BLOCK;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving.isShiftKeyDown() && !entityLiving.isFallFlying()) {
            int i = this.getUseDuration(stack, entityLiving) - timeLeft;
            int t = Mth.clamp((int)i, (int)1, (int)4);
            float f7 = entityLiving.getYRot();
            float f = entityLiving.getXRot();
            float f1 = -Mth.sin((float)(f7 * ((float)Math.PI / 180))) * Mth.cos((float)(f * ((float)Math.PI / 180)));
            float f2 = -Mth.sin((float)(f * ((float)Math.PI / 180)));
            float f3 = Mth.cos((float)(f7 * ((float)Math.PI / 180))) * Mth.cos((float)(f * ((float)Math.PI / 180)));
            float f4 = Mth.sqrt((float)(f1 * f1 + f2 * f2 + f3 * f3));
            float f5 = 3.0f * ((float)t / 6.0f);
            entityLiving.push((double)(f1 *= f5 / f4), 0.0, (double)(f3 *= f5 / f4));
            if (entityLiving.onGround()) {
                float f6 = 1.1999999f;
                entityLiving.move(MoverType.SELF, new Vec3(0.0, (double)f6 / 2.0, 0.0));
            }
            ChargeAttachment charge = (ChargeAttachment)entityLiving.getData(ModDataAttachments.CHARGE_ATTACHMENT);
            charge.setCharge(true);
            charge.setTimer(t * 2);
            charge.seteffectiveChargeTime(t * 2);
            charge.setknockbackSpeedIndex(t * 2);
            charge.setdamagePerEffectiveCharge(0.6f);
            charge.setdx(f1 * 0.1f);
            charge.setdZ(f3 * 0.1f);
            if (!level.isClientSide()) {
                ((Player)entityLiving).getCooldowns().addCooldown((Item)this, CMCommonConfig.BulwarkOfTheFlame.cooldown);
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack lvt_4_1_ = p_77659_2_.getItemInHand(p_77659_3_);
        p_77659_2_.startUsingItem(p_77659_3_);
        return InteractionResultHolder.consume((Object)lvt_4_1_);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.bulwark_of_the_flame.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.bulwark_of_the_flame2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

