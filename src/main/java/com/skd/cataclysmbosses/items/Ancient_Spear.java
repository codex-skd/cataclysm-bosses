/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.projectile.Sandstorm_Projectile;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import com.skd.cataclysmbosses.items.ILeftClick;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class Ancient_Spear
extends Cataclysm_Weapon
implements ILeftClick {
    public Ancient_Spear(Item.Properties group) {
        super(group);
    }

    private boolean isCharged(Player player, ItemStack stack) {
        return player.getAttackStrengthScale(0.5f) > 0.9f;
    }

    public void hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity player) {
        Player player1;
        if (player instanceof Player && this.isCharged(player1 = (Player)player, stack)) {
            this.launchTornado(stack, player);
        }
        return;
    }

    public void postHurtEnemy(ItemStack p_345950_, LivingEntity p_345617_, LivingEntity p_345537_) {
        p_345950_.hurtAndBreak(1, p_345537_, EquipmentSlot.MAINHAND);
    }

    public boolean isValidRepairItem(ItemStack pickaxe, ItemStack stack) {
        return stack.is((Item)ModItems.ANCIENT_METAL_INGOT.get());
    }

    @Override
    public boolean onLeftClick(ItemStack stack, LivingEntity playerIn) {
        if (stack.is((Item)ModItems.ANCIENT_SPEAR.get()) && (!(playerIn instanceof Player) || this.isCharged((Player)playerIn, stack))) {
            return this.launchTornado(stack, playerIn);
        }
        return false;
    }

    public boolean launchTornado(ItemStack stack, LivingEntity playerIn) {
        Level worldIn = playerIn.level();
        if (!worldIn.isClientSide()) {
            stack.hurtAndBreak(1, playerIn, EquipmentSlot.MAINHAND);
            float d7 = playerIn.getYRot();
            float d = playerIn.getXRot();
            float d1 = -Mth.sin((float)(d7 * ((float)Math.PI / 180))) * Mth.cos((float)(d * ((float)Math.PI / 180)));
            float d2 = -Mth.sin((float)(d * ((float)Math.PI / 180)));
            float d3 = Mth.cos((float)(d7 * ((float)Math.PI / 180))) * Mth.cos((float)(d * ((float)Math.PI / 180)));
            double theta = (double)d7 * (Math.PI / 180);
            double vecX = Math.cos(theta += 1.5707963267948966);
            double vecZ = Math.sin(theta);
            double x = playerIn.getX() + vecX;
            double Z = playerIn.getZ() + vecZ;
            Sandstorm_Projectile largefireball = new Sandstorm_Projectile(playerIn, d1, d2, d3, playerIn.level(), (float)CMCommonConfig.AncientSpear.sandstormdamage);
            largefireball.setState(1);
            largefireball.setPos(x, playerIn.getEyeY() - 0.5, Z);
            worldIn.addFreshEntity((Entity)largefireball);
            return true;
        }
        return false;
    }

    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public int getEnchantmentValue() {
        return 16;
    }

    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public float getDestroySpeed(ItemStack p_43288_, BlockState p_43289_) {
        if (p_43289_.is(Blocks.COBWEB)) {
            return 15.0f;
        }
        return p_43289_.is(BlockTags.SWORD_EFFICIENT) ? 1.5f : 1.0f;
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        super.appendHoverText(stack, context, tooltips, flags);
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.ancient_spear.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

