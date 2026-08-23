/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.effect.Flame_Strike_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class The_Immolator
extends Cataclysm_Weapon {
    public The_Immolator(Item.Properties properties) {
        super(properties);
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_77661_1_) {
        return ItemUseAnimation.SPEAR;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public boolean releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player) {
            Player player = (Player)p_43396_;
            int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
            boolean hasSucceeded = false;
            double headY = player.getY() + 1.0;
            int standingOnY = Mth.floor((double)player.getY()) - 2;
            if (i >= 45) {
                float f1 = (float)Math.cos(Math.toRadians(p_43396_.getYRot() + 90.0f));
                float f2 = (float)Math.sin(Math.toRadians(p_43396_.getYRot() + 90.0f));
                float f0 = (float)Mth.atan2((double)f1, (double)f2);
                if (this.spawnFlameStrike(player.getX(), player.getZ(), standingOnY, headY, f0, 45, 0, 0, p_43395_, 2.5f, (LivingEntity)player)) {
                    hasSucceeded = true;
                }
                if (hasSucceeded) {
                    if (!p_43395_.isClientSide()) {
                        player.getCooldowns().addCooldown((Item)this, CMCommonConfig.Immolator.cooldown);
                    }
                    ScreenShake_Entity.ScreenShake(p_43395_, player.position(), 30.0f, 0.15f, 0, 30);
                    p_43395_.playSound(null, player.getX(), player.getY(), player.getZ(), (SoundEvent)ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5f, 1.0f / (player.getRandom().nextFloat() * 0.4f + 0.8f));
                }
            }
        }
        return true;
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        int i = this.getUseDuration(stack, livingEntityIn) - count;
        if (i == 10) {
            this.masseffectParticle(worldIn, livingEntityIn, 2.0f);
        }
        if (i == 20) {
            this.masseffectParticle(worldIn, livingEntityIn, 3.5f);
        }
        if (i == 30) {
            this.masseffectParticle(worldIn, livingEntityIn, 5.0f);
        }
        if (i == 45) {
            livingEntityIn.playSound((SoundEvent)ModSounds.MALEDICTUS_SHORT_ROAR.get(), 1.0f, 1.0f);
        }
    }

    private void yall(Level world, LivingEntity caster) {
        double radius = 6.0;
        ScreenShake_Entity.ScreenShake(world, caster.position(), 30.0f, 0.1f, 0, 30);
        world.playSound(null, caster.getX(), caster.getY(), caster.getZ(), (SoundEvent)ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5f, 1.0f / (caster.getRandom().nextFloat() * 0.4f + 0.8f));
        List list = world.getEntities((Entity)caster, caster.getBoundingBox().inflate(radius, radius, radius));
        for (Entity entity : list) {
            if (!(entity instanceof LivingEntity)) continue;
            entity.hurt(world.damageSources().mobAttack(caster), (float)caster.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2.0f);
        }
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

    private void masseffectParticle(Level world, LivingEntity caster, float radius) {
        if (world.isClientSide()) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float)(Math.random() * 2.0 * Math.PI);
                double distance = Math.sqrt(Math.random()) * (double)radius;
                double extraX = caster.getX() + distance * (double)Mth.cos((float)angle);
                double extraY = caster.getY() + (double)0.3f;
                double extraZ = caster.getZ() + distance * (double)Mth.sin((float)angle);
                world.addParticle((ParticleOptions)ParticleTypes.FLAME, extraX, extraY, extraZ, 0.0, world.random.nextGaussian() * 0.04, 0.0);
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack otherHand;
        ItemStack itemstack = player.getItemInHand(hand);
        ItemStack itemStack = otherHand = hand == InteractionHand.MAIN_HAND ? player.getItemInHand(InteractionHand.OFF_HAND) : player.getItemInHand(InteractionHand.MAIN_HAND);
        if (otherHand.is((Item)ModItems.THE_IMMOLATOR.get())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume((Object)itemstack);
        }
        return InteractionResultHolder.fail((Object)itemstack);
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

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.annihilator.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.immolator.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.immolator2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

