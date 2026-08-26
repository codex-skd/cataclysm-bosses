/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
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
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class The_Annihilator
extends Cataclysm_Weapon {
    public The_Annihilator(Item.Properties group) {
        super(group);
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
            if (i >= 40) {
                this.yall(p_43395_, p_43396_);
                if (!p_43395_.isClientSide()) {
                    player.getCooldowns().addCooldown(this.getDefaultInstance(), 100);
                }
            }
        }
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
        if (i == 40) {
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
        if (world.isClientSide()) {
            world.addParticle((ParticleOptions)new RingParticleOptions(0.0f, 1.5707964f, 30, 86, 236, 204, 1.0f, 85.0f, false, 0), caster.getX(), caster.getY() + (double)0.03f, caster.getZ(), 0.0, 0.0, 0.0);
        }
    }

    private void masseffectParticle(Level world, LivingEntity caster, float radius) {
        if (world.isClientSide()) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float)(Math.random() * 2.0 * Math.PI);
                double distance = Math.sqrt(Math.random()) * (double)radius;
                double extraX = caster.getX() + distance * (double)Mth.cos((float)angle);
                double extraY = caster.getY() + (double)0.3f;
                double extraZ = caster.getZ() + distance * (double)Mth.sin((float)angle);
                world.addParticle((ParticleOptions)ModParticle.PHANTOM_WING_FLAME.get(), extraX, extraY, extraZ, 0.0, world.random.nextGaussian() * 0.04, 0.0);
            }
        }
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack otherHand;
        ItemStack itemstack = player.getItemInHand(hand);
        ItemStack itemStack = otherHand = hand == InteractionHand.MAIN_HAND ? player.getItemInHand(InteractionHand.OFF_HAND) : player.getItemInHand(InteractionHand.MAIN_HAND);
        if (otherHand.is((Item)ModItems.THE_ANNIHILATOR.get())) {
            player.startUsingItem(hand);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.FAIL;
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
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.annihilator.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.annihilator2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

