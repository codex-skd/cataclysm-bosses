/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
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
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.ItemAbilities
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.Attachment.ChargeAttachment;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.init.ModDataAttachments;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;

public class Gauntlet_of_Bulwark
extends Cataclysm_Weapon {
    public Gauntlet_of_Bulwark(Item.Properties group) {
        super(group);
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_77661_1_) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public InteractionResult use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
        InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);
        if (otheritem.canPerformAction(ItemAbilities.SHIELD_BLOCK) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem.getItem())) {
            return InteractionResult.FAIL;
        }
        p_77659_2_.startUsingItem(p_77659_3_);
        return InteractionResult.CONSUME;
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        double radius = 4.5;
        Level world = livingEntityIn.level();
        List list = world.getEntities((Entity)livingEntityIn, livingEntityIn.getBoundingBox().inflate(radius));
        int c = this.getUseDuration(stack, livingEntityIn) - count;
        if (c == 20) {
            livingEntityIn.playSound((SoundEvent)ModSounds.FLAME_BURST.get(), 1.0f, 1.0f);
            for (Entity entity : list) {
                if (!(entity instanceof LivingEntity) || entity instanceof Player && ((Player)entity).getAbilities().invulnerable) continue;
                ((LivingEntity)entity).addEffect(new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 40));
                if (!entity.onGround()) continue;
                double d0 = entity.getX() - livingEntityIn.getX();
                double d1 = entity.getZ() - livingEntityIn.getZ();
                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                float f = 1.5f;
                entity.push(d0 / d2 * (double)f, (double)0.1f, d1 / d2 * (double)f);
            }
            if (world.isClientSide()) {
                for (int i = 0; i < 20; ++i) {
                    float velocity = 0.2f;
                    float yaw = (float)i * 0.31415927f;
                    float vy = world.getRandom().nextFloat() * 0.1f - 0.05f;
                    float vx = 0.2f * Mth.cos((float)yaw);
                    float vz = 0.2f * Mth.sin((float)yaw);
                    world.addParticle((ParticleOptions)ParticleTypes.FLAME, livingEntityIn.getX(), livingEntityIn.getY() + 1.0, livingEntityIn.getZ(), (double)vx, (double)vy, (double)vz);
                }
            }
        }
    }

    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (!entityLiving.isShiftKeyDown() && !entityLiving.isFallFlying()) {
            int i = this.getUseDuration(stack, entityLiving) - timeLeft;
            int t = Mth.clamp((int)i, (int)1, (int)5);
            float f7 = entityLiving.getYRot();
            float f = entityLiving.getXRot();
            if (i >= 20) {
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
                charge.setknockbackSpeedIndex((float)t * 0.35f);
                charge.setdamagePerEffectiveCharge(1.2f);
                charge.setdx(f1 * 0.5f);
                charge.setdZ(f3 * 0.5f);
                if (!level.isClientSide()) {
                    ((Player)entityLiving).getCooldowns().addCooldown(this.getDefaultInstance(), CMCommonConfig.GauntletOfBulwark.cooldown);
                }
            }
        }
        return true;
        return false;
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

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.gauntlet_of_bulwark.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.gauntlet_of_bulwark.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}

