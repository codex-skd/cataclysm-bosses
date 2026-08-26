/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.BlockParticleOption
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.damagesource.DamageSource
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
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.projectile.Flame_Jet_Entity;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.util.AttributeUtils;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Infernal_forge
extends Item {
    public Infernal_forge(Item.Properties props) {
        super(props);
    }

    public void hurtEnemy(ItemStack heldItemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            target.playSound((SoundEvent)ModSounds.HAMMERTIME.get(), 0.5f, 0.5f);
            target.knockback(1.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        }
        return;
    }

    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        if (player != null && player.getMainHandItem() == stack) {
            this.EarthQuake(context, player);
            player.getCooldowns().addCooldown(this.getDefaultInstance(), CMCommonConfig.InfernalForge.cooldown);
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }

    private void EarthQuake(UseOnContext context, Player player) {
        block3: {
            double radius;
            boolean berserk;
            Level world;
            block2: {
                world = context.getLevel();
                berserk = player.getHealth() <= player.getMaxHealth() * 0.5f;
                radius = 4.0;
                world.playSound(player, player.blockPosition(), (SoundEvent)ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
                if (!world.isClientSide()) break block2;
                BlockState block = world.getBlockState(context.getClickedPos());
                int numParticles = 80;
                for (int i = 0; i < numParticles; ++i) {
                    double angle = (double)i / (double)numParticles * (Math.PI * 2);
                    double d0 = player.getX() + radius * Math.sin(angle);
                    double d1 = player.getY() + 0.15;
                    double d2 = player.getZ() + radius * Math.cos(angle);
                    double d3 = world.getRandom().nextGaussian() * 0.1;
                    double d4 = world.getRandom().nextGaussian() * 0.1;
                    double d5 = world.getRandom().nextGaussian() * 0.1;
                    world.addParticle((ParticleOptions)new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                    if (!berserk) continue;
                    world.addParticle((ParticleOptions)ParticleTypes.FLAME, d0, d1, d2, d3, d4, d5);
                }
                break block3;
            }
            if (!(world instanceof ServerLevel)) break block3;
            ServerLevel serverLevel = (ServerLevel)world;
            ScreenShake_Entity.ScreenShake((Level)serverLevel, player.position(), 30.0f, 0.1f, 0, 30);
            DamageSource shredderDamage = serverLevel.damageSources().playerAttack(player);
            float basedmg = AttributeUtils.OriginDamage((LivingEntity)player, context.getItemInHand());
            List list = serverLevel.getEntities((Entity)player, player.getBoundingBox().inflate(radius));
            for (Entity entity : list) {
                float enchanteddmg;
                LivingEntity living;
                if (!(entity instanceof LivingEntity) || !(living = (LivingEntity)entity).hurt(shredderDamage, enchanteddmg = EnchantmentHelper.modifyDamage((ServerLevel)serverLevel, (ItemStack)context.getItemInHand(), (Entity)living, (DamageSource)shredderDamage, (float)basedmg))) continue;
                living.setDeltaMovement(living.getDeltaMovement().multiply(0.5, 1.0, 0.5).add(0.0, 0.6, 0.0));
                if (!berserk) continue;
                living.igniteForSeconds(5.0f);
            }
        }
    }

    private void spawnJet(Level level, LivingEntity player, double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1;
            BlockState blockstate;
            if (!(blockstate = level.getBlockState(blockpos1 = blockpos.below())).isFaceSturdy((BlockGetter)level, blockpos1, Direction.UP)) continue;
            if (!level.isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = level.getBlockState(blockpos)).getCollisionShape((BlockGetter)level, blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)minY) - 1);
        if (flag) {
            level.addFreshEntity((Entity)new Flame_Jet_Entity(level, x, (double)blockpos.getY() + d0, z, rotation, delay, 7.0f, player));
        }
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
        super.appendHoverText(stack, context, tooltip, flags);
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.infernal_forge.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.infernal_forge.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}

