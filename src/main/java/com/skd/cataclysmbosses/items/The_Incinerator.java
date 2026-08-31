/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.tags.BlockTags
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
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.effect.Flame_Strike_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;

public class The_Incinerator
extends Cataclysm_Weapon {
    public The_Incinerator(Item.Properties group) {
        super(group);
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_77661_1_) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public boolean releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player) {
            Player player = (Player)p_43396_;
            int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
            double headY = player.getY() + 1.0;
            int standingOnY = Mth.floor((double)player.getY()) - 2;
            float yawRadians = (float)Math.toRadians(90.0f + player.getYRot());
            boolean hasSucceeded = false;
            if (i >= 60) {
                for (int l = 0; l < 10; ++l) {
                    double d2 = 2.25 * (double)(l + 1);
                    int j2 = (int)(1.5f * (float)l);
                    if (!this.spawnFlameStrike(player.getX() + (double)Mth.cos((float)yawRadians) * d2, player.getZ() + (double)Mth.sin((float)yawRadians) * d2, standingOnY, headY, yawRadians, 40, j2, j2, p_43395_, 1.0f, (LivingEntity)player)) continue;
                    hasSucceeded = true;
                }
                if (hasSucceeded) {
                    if (!p_43395_.isClientSide()) {
                        player.getCooldowns().addCooldown(this.getDefaultInstance(), CMCommonConfig.Incinerator.cooldown);
                    }
                    ScreenShake_Entity.ScreenShake(p_43395_, player.position(), 30.0f, 0.15f, 0, 30);
                    player.playSound((SoundEvent)ModSounds.SWORD_STOMP.get(), 1.0f, 1.0f);
                }
            }
        }
        return true;
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        int i = this.getUseDuration(stack, livingEntityIn) - count;
        if (i == 60) {
            livingEntityIn.playSound((SoundEvent)ModSounds.FLAME_BURST.get(), 1.0f, 1.0f);
        }
    }

    public InteractionResult use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
        InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);
        if (otheritem.has(net.minecraft.core.component.DataComponents.BLOCKS_ATTACKS) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem)) {
            return InteractionResult.FAIL;
        }
        p_77659_2_.startUsingItem(p_77659_3_);
        return InteractionResult.CONSUME;
    }

    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
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

    public boolean isCorrectToolForDrops(BlockState p_43298_) {
        return p_43298_.is(Blocks.COBWEB);
    }

    private boolean spawnFlameStrike(double x, double z, double minY, double maxY, float rotation, int duration, int wait, int delay, Level world, float radius, LivingEntity player) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1;
            BlockState blockstate;
            if (!(blockstate = world.getBlockState(blockpos1 = blockpos.below())).isFaceSturdy((BlockGetter)world, blockpos1, Direction.UP)) continue;
            if (!world.isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = world.getBlockState(blockpos)).getCollisionShape((BlockGetter)world, blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((double)(blockpos = blockpos.below()).getY() >= minY);
        if (flag) {
            world.addFreshEntity((Entity)new Flame_Strike_Entity(world, x, (double)blockpos.getY() + d0, z, rotation, duration, wait, delay, radius, 6.0f, 2.0f, false, player));
            return true;
        }
        return false;
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return false; // TODO 26.2: shield blocking is the DataComponents.BLOCKS_ATTACKS component on Item.Properties now, not this override
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, java.util.function.Consumer<Component> builder, TooltipFlag flags) {
        builder.accept((Component)Component.translatable((String)"item.cataclysm.incinerator.desc").withStyle(ChatFormatting.DARK_GREEN));
        builder.accept((Component)Component.translatable((String)"item.cataclysm.incinerator2.desc").withStyle(ChatFormatting.DARK_GREEN));
        builder.accept((Component)Component.translatable((String)"item.cataclysm.incinerator3.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

