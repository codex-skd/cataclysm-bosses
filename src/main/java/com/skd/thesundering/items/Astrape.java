/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
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
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 */
package com.skd.thesundering.items;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.projectile.Lightning_Spear_Entity;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.items.Cataclysm_Weapon;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class Astrape
extends Cataclysm_Weapon {
    public Astrape(Item.Properties group) {
        super(group);
    }

    public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
        return !p_43412_.isCreative();
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_43417_) {
        return ItemUseAnimation.SPEAR;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player) {
            Player player = (Player)p_43396_;
            int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
            float f = Astrape.getPowerForTime(i);
            if (!((double)f < 0.5)) {
                p_43395_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), (SoundEvent)ModSounds.EMP_ACTIVATED.get(), SoundSource.PLAYERS, 1.0f, 0.8f);
                if (!p_43395_.isClientSide()) {
                    Vec3 lookDirection = player.getLookAngle();
                    Vec3 vec3 = new Vec3(lookDirection.x, lookDirection.y, lookDirection.z).normalize();
                    float yRot = (float)(Mth.atan2((double)vec3.z, (double)vec3.x) * 57.29577951308232) + 90.0f;
                    float xRot = (float)(-(Mth.atan2((double)vec3.y, (double)Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * 57.29577951308232));
                    Lightning_Spear_Entity lightning = new Lightning_Spear_Entity((LivingEntity)player, vec3.normalize(), p_43395_, (float)CMCommonConfig.Astrape.damage, 2.5);
                    lightning.setYRot(yRot);
                    lightning.setXRot(xRot);
                    lightning.setPos(lightning.getX(), player.getY(0.75), lightning.getZ());
                    lightning.setAreaDamage((float)CMCommonConfig.Astrape.areaDamage);
                    lightning.setAreaRadius(1.0f);
                    boolean flag = p_43395_.addFreshEntity((Entity)lightning);
                    if (flag) {
                        player.getCooldowns().addCooldown((Item)this, CMCommonConfig.Astrape.cooldown);
                    }
                }
            }
        }
    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0f;
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume((Object)itemstack);
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.astrape.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

