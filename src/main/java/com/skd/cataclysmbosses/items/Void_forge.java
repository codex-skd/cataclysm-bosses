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
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.context.UseOnContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.projectile.Void_Rune_Entity;
import com.skd.cataclysmbosses.init.ModSounds;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Void_forge
extends Item {
    public Void_forge(Item.Properties props) {
        super(props);
    }

    public void hurtEnemy(ItemStack heldItemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            target.playSound((SoundEvent)ModSounds.HAMMERTIME.get(), 0.5f, 0.5f);
            target.push(attacker.getX() - target.getX(), 0.0, attacker.getZ() - target.getZ());
        }
        return;
    }

    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        int standingOnY = Mth.floor((double)player.getY()) - 3;
        Level world = context.getLevel();
        if (player.getMainHandItem() == stack) {
            Vec3 looking = player.getLookAngle();
            double headY = player.getY() + 1.0;
            Vec3[] all = new Vec3[]{looking, looking.yRot(0.3f), looking.yRot(-0.3f), looking.yRot(0.6f), looking.yRot(-0.6f), looking.yRot(0.9f), looking.yRot(-0.9f)};
            world.playSound(null, player.getX(), player.getY(), player.getZ(), (SoundEvent)ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5f, 1.0f / (player.getRandom().nextFloat() * 0.4f + 0.8f));
            ScreenShake_Entity.ScreenShake(world, player.position(), 30.0f, 0.1f, 0, 30);
            for (Vec3 vector3d : all) {
                float f = (float)Mth.atan2((double)vector3d.z, (double)vector3d.x);
                player.getCooldowns().addCooldown(this.getDefaultInstance(), CMCommonConfig.VoidForge.cooldown);
                for (int i = 0; i < 5; ++i) {
                    double d2 = 1.75 * (double)(i + 1);
                    int j = 1 * i;
                    this.spawnFangs(player.getX() + (double)Mth.cos((float)f) * d2, headY, player.getZ() + (double)Mth.sin((float)f) * d2, standingOnY, f, j, world, player);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
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
            world.addFreshEntity((Entity)new Void_Rune_Entity(world, x, (double)blockpos.getY() + d0, z, yRot, warmupDelayTicks, (float)CMCommonConfig.VoidForge.runeDamage, (LivingEntity)player));
            return true;
        }
        return false;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, java.util.function.Consumer<Component> builder, TooltipFlag flags) {
        builder.accept((Component)Component.translatable((String)"item.cataclysm.void_forge.desc").withStyle(ChatFormatting.DARK_GREEN));
        builder.accept((Component)Component.translatable((String)"item.cataclysm.void_forge.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}

