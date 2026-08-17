/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
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
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 *  org.jetbrains.annotations.Nullable
 */
package com.skd.sundering.items;

import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.entity.effect.Wave_Entity;
import com.skd.sundering.entity.projectile.Player_Ceraunus_Entity;
import com.skd.sundering.init.ModDataComponents;
import com.skd.sundering.init.ModSounds;
import com.skd.sundering.items.Cataclysm_Weapon;
import java.util.List;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class Ceraunus
extends Cataclysm_Weapon {
    public Ceraunus(Item.Properties group) {
        super(group);
    }

    public void inventoryTick(ItemStack stack, Level level, Entity holder, int slot, boolean isSelected) {
        if (!level.isClientSide() && stack.get(ModDataComponents.THROWN_ANCHOR) != null && this.getThrownEntity(level, stack) == null) {
            stack.remove(ModDataComponents.THROWN_ANCHOR);
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
            float f = Ceraunus.getPowerForTime(i);
            if (!((double)f < 0.5) && !p_43395_.isClientSide()) {
                float yawRadians = (float)Math.toRadians(90.0f + player.getYRot());
                double vecX = Math.cos(yawRadians);
                double vecZ = Math.sin(yawRadians);
                double vec = 2.0;
                double spawnX = p_43396_.getX() + vecX * vec;
                double spawnY = p_43396_.getY();
                double spawnZ = p_43396_.getZ() + vecZ * vec;
                int numberOfWaves = 4;
                float angleStep = 25.0f;
                double firstAngleOffset = (double)(numberOfWaves - 1) / 2.0 * (double)angleStep;
                if (p_43396_.isShiftKeyDown()) {
                    player.getCooldowns().addCooldown((Item)this, CMCommonConfig.Ceraunus.cooldown);
                    p_43395_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), (SoundEvent)ModSounds.HEAVY_SMASH.get(), SoundSource.PLAYERS, 0.6f, 1.0f);
                    for (int k = 0; k < numberOfWaves; ++k) {
                        double angle = (double)player.getYRot() - firstAngleOffset + (double)((float)k * angleStep);
                        double rad = Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        Wave_Entity WaveEntity = new Wave_Entity(p_43395_, p_43396_, 60, (float)CMCommonConfig.Ceraunus.waveDamage);
                        WaveEntity.setPos(spawnX, spawnY, spawnZ);
                        WaveEntity.setState(1);
                        WaveEntity.setYRot(-((float)(Mth.atan2((double)dx, (double)dz) * 57.29577951308232)));
                        p_43396_.level().addFreshEntity((Entity)WaveEntity);
                    }
                } else if (p_43394_.get(ModDataComponents.THROWN_ANCHOR) == null && p_43395_.getWorldBorder().isWithinBounds(player.blockPosition())) {
                    Player_Ceraunus_Entity launchedBlock = new Player_Ceraunus_Entity(p_43395_, (LivingEntity)player);
                    launchedBlock.setBaseDamage((float)player.getAttributeValue(Attributes.ATTACK_DAMAGE));
                    launchedBlock.shootFromRotation((Entity)player, player.getXRot(), player.getYRot(), 0.0f, 2.5f, 1.0f);
                    if (p_43395_.addFreshEntity((Entity)launchedBlock)) {
                        p_43394_.set(ModDataComponents.THROWN_ANCHOR, (Object)launchedBlock.getUUID());
                    }
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
    private Player_Ceraunus_Entity getThrownEntity(Level level, ItemStack stack) {
        if (level instanceof ServerLevel) {
            Entity e;
            ServerLevel server = (ServerLevel)level;
            UUID id = (UUID)stack.get(ModDataComponents.THROWN_ANCHOR);
            if (id != null && (e = server.getEntity(id)) instanceof Player_Ceraunus_Entity) {
                Player_Ceraunus_Entity playerCeraunus = (Player_Ceraunus_Entity)e;
                return playerCeraunus;
            }
        }
        return null;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.get(ModDataComponents.THROWN_ANCHOR) == null && world.getWorldBorder().isWithinBounds(player.blockPosition())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume((Object)itemstack);
        }
        return InteractionResultHolder.fail((Object)itemstack);
    }

    public static boolean getThrowing(ItemStack itemStack) {
        return itemStack.get(ModDataComponents.THROWN_ANCHOR) == null;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.ceraunus.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.ceraunus2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }
}

