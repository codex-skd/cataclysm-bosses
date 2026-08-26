/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.ItemAbilities
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.client.particle.Options.ParryParticleOptions;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import com.skd.cataclysmbosses.util.AttributeUtils;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;

public class Meat_Shredder
extends Cataclysm_Weapon {
    public Meat_Shredder(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
        InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);
        if (otheritem.canPerformAction(ItemAbilities.SHIELD_BLOCK) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem.getItem())) {
            return InteractionResult.FAIL;
        }
        p_77659_2_.startUsingItem(p_77659_3_);
        p_77659_1_.playSound(null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), (SoundEvent)ModSounds.SHREDDER_START.get(), SoundSource.PLAYERS, 1.5f, 1.0f / (p_77659_2_.getRandom().nextFloat() * 0.4f + 0.8f));
        return InteractionResult.CONSUME;
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

    public void onUseTick(Level level, LivingEntity living, ItemStack stack, int count) {
        Cataclysm.PROXY.playWorldSound(living, (byte)1);
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            double range = 2.5;
            Vec3 srcVec = living.getEyePosition();
            Vec3 lookVec = living.getViewVector(1.0f);
            Vec3 lookOffset = lookVec.scale(range);
            Vec3 destVec = srcVec.add(lookOffset);
            double padding = 1.0;
            AABB searchArea = living.getBoundingBox().expandTowards(lookOffset).inflate(padding);
            List possibleList = level.getEntities((Entity)living, searchArea);
            DamageSource shredderDamage = CMDamageTypes.causeShredderDamage(living);
            float basedmg = AttributeUtils.OriginDamage(living, stack);
            for (Entity entity : possibleList) {
                float enchanteddmg;
                float finaldmg;
                if (!(entity instanceof LivingEntity)) continue;
                LivingEntity target = (LivingEntity)entity;
                double borderSize = 0.5;
                AABB collisionBB = target.getBoundingBox().inflate(borderSize);
                boolean isHit = collisionBB.contains(srcVec) || collisionBB.clip(srcVec, destVec).isPresent();
                if (!isHit || !target.hurt(shredderDamage, finaldmg = (enchanteddmg = EnchantmentHelper.modifyDamage((ServerLevel)serverLevel, (ItemStack)stack, (Entity)target, (DamageSource)shredderDamage, (float)basedmg)) / 8.5f)) continue;
                serverLevel.sendParticles((ParticleOptions)new ParryParticleOptions(1.0f, 0.41568628f, 0.0f), target.getX(), target.getY(0.5), target.getZ(), 2, target.getDeltaMovement().x, target.getDeltaMovement().y, target.getDeltaMovement().z, (double)(level.getRandom().nextFloat() - 0.5f));
            }
        }
    }

    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity living, int remainingUseTicks) {
        world.playSound(null, living.getX(), living.getY(), living.getZ(), (SoundEvent)ModSounds.SHREDDER_END.get(), SoundSource.PLAYERS, 1.5f, 1.0f / (living.getRandom().nextFloat() * 0.4f + 0.8f));
        Cataclysm.PROXY.clearSoundCacheFor((Entity)living);
        return true;
    }

    public float getDestroySpeed(ItemStack p_41004_, BlockState p_41005_) {
        float speed = 15.0f;
        return p_41005_.is(BlockTags.MINEABLE_WITH_AXE) ? speed : 1.0f;
    }

    public int getUseDuration(ItemStack p_43419_, LivingEntity p_345001_) {
        return 72000;
    }

    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.meat_shredder.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

