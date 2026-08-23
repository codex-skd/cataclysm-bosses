/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
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
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.projectile.Void_Rune_Entity;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Void_core
extends Item {
    public Void_core(Item.Properties group) {
        super(group);
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        int standingOnY = Mth.floor((double)player.getY()) - 1;
        double headY = player.getY() + 1.0;
        float yawRadians = (float)Math.toRadians(90.0f + player.getYRot());
        boolean hasSucceeded = false;
        if (player.getXRot() > 70.0f) {
            float mulPosedYaw;
            for (int i = 0; i < 5; ++i) {
                mulPosedYaw = yawRadians + (float)i * (float)Math.PI * 0.4f;
                if (!this.spawnFangs(player.getX() + (double)Mth.cos((float)mulPosedYaw) * 1.5, headY, player.getZ() + (double)Mth.sin((float)mulPosedYaw) * 1.5, standingOnY, mulPosedYaw, 0, world, player)) continue;
                hasSucceeded = true;
            }
            for (int k = 0; k < 8; ++k) {
                mulPosedYaw = yawRadians + (float)k * (float)Math.PI * 2.0f / 8.0f + 1.2566371f;
                if (!this.spawnFangs(player.getX() + (double)Mth.cos((float)mulPosedYaw) * 2.5, headY, player.getZ() + (double)Mth.sin((float)mulPosedYaw) * 2.5, standingOnY, mulPosedYaw, 3, world, player)) continue;
                hasSucceeded = true;
            }
        } else {
            for (int l = 0; l < 10; ++l) {
                double d2 = 1.25 * (double)(l + 1);
                if (!this.spawnFangs(player.getX() + (double)Mth.cos((float)yawRadians) * d2, headY, player.getZ() + (double)Mth.sin((float)yawRadians) * d2, standingOnY, yawRadians, l, world, player)) continue;
                hasSucceeded = true;
            }
        }
        ItemStack stack = player.getItemInHand(hand);
        if (hasSucceeded) {
            player.getCooldowns().addCooldown((Item)this, CMCommonConfig.VoidCore.cooldown);
            return InteractionResultHolder.success((Object)stack);
        }
        return InteractionResultHolder.pass((Object)stack);
    }

    private boolean spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, Player player) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)y, (double)z);
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
        } while ((blockpos = blockpos.below()).getY() >= lowestYCheck);
        if (flag) {
            world.addFreshEntity((Entity)new Void_Rune_Entity(world, x, (double)blockpos.getY() + d0, z, yRot, warmupDelayTicks, (float)CMCommonConfig.VoidCore.runeDamage, (LivingEntity)player));
            return true;
        }
        return false;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.void_core.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

