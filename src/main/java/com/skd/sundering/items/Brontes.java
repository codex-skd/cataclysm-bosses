/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 *  org.jetbrains.annotations.Nullable
 */
package com.skd.sundering.items;

import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.entity.projectile.Brontes_Entity;
import com.skd.sundering.init.ModDataComponents;
import com.skd.sundering.init.ModSounds;
import com.skd.sundering.util.AttributeUtils;
import java.util.List;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class Brontes
extends PickaxeItem {
    public Brontes(Tier toolMaterial, Item.Properties props) {
        super(toolMaterial, props);
    }

    public boolean hurtEnemy(ItemStack heldItemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            target.playSound((SoundEvent)ModSounds.HAMMERTIME.get(), 0.5f, 0.5f);
            target.knockback(1.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        }
        return true;
    }

    public void inventoryTick(ItemStack stack, Level level, Entity holder, int slot, boolean isSelected) {
        if (!level.isClientSide() && stack.get(ModDataComponents.THROWN_HAMMER) != null && this.getThrownEntity(level, stack) == null) {
            stack.remove(ModDataComponents.THROWN_HAMMER);
        }
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
            float f = Brontes.getPowerForTime(i);
            if (!((double)f < 0.5) && !p_43395_.isClientSide() && p_43394_.get(ModDataComponents.THROWN_HAMMER) == null && p_43395_.getWorldBorder().isWithinBounds(player.blockPosition())) {
                Brontes_Entity brontes = new Brontes_Entity(p_43395_, (LivingEntity)player);
                brontes.setBaseDamage(AttributeUtils.OriginDamage(p_43396_, p_43394_));
                brontes.setAreaDamage((float)CMCommonConfig.Brontes.stormareadamage);
                brontes.setStormDamage((float)CMCommonConfig.Brontes.stormdamage);
                brontes.shootFromRotation((Entity)player, player.getXRot(), player.getYRot(), 0.0f, 2.5f, 1.0f);
                if (p_43395_.addFreshEntity((Entity)brontes)) {
                    p_43394_.set(ModDataComponents.THROWN_HAMMER, (Object)brontes.getUUID());
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

    @Nullable
    private Brontes_Entity getThrownEntity(Level level, ItemStack stack) {
        if (level instanceof ServerLevel) {
            Entity e;
            ServerLevel server = (ServerLevel)level;
            UUID id = (UUID)stack.get(ModDataComponents.THROWN_HAMMER);
            if (id != null && (e = server.getEntity(id)) instanceof Brontes_Entity) {
                Brontes_Entity playerCeraunus = (Brontes_Entity)e;
                return playerCeraunus;
            }
        }
        return null;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.get(ModDataComponents.THROWN_HAMMER) == null && world.getWorldBorder().isWithinBounds(player.blockPosition())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume((Object)itemstack);
        }
        return InteractionResultHolder.fail((Object)itemstack);
    }

    public static boolean getThrowing(ItemStack itemStack) {
        return itemStack.get(ModDataComponents.THROWN_HAMMER) == null;
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }

    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStackMaterial) {
        return false;
    }

    public int getEnchantmentValue() {
        return 16;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.brontes.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.brontes.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}

