/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.projectile.Laser_Beam_Entity;
import com.skd.cataclysmbosses.init.ModDataComponents;
import com.skd.cataclysmbosses.init.ModSounds;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class Laser_Gatling
extends Item {
    private static final String TAG_CHARGED = "Charged";
    public static final Predicate<ItemStack> REDSTONE = stack -> stack.getItem() == Items.REDSTONE;

    public Laser_Gatling(Item.Properties properties) {
        super(properties);
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return Laser_Gatling.isUsable(pStack) ? Integer.MAX_VALUE : 0;
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return super.isBarVisible(itemStack) && Laser_Gatling.isUsable(itemStack);
    }

    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamageValue() < stack.getMaxDamage() - 1;
    }

    public InteractionResult use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.startUsingItem(handIn);
        if (!Laser_Gatling.isUsable(itemstack)) {
            ItemStack ammo = this.findAmmo(playerIn);
            boolean flag = playerIn.isCreative();
            if (!ammo.isEmpty()) {
                ammo.shrink(1);
                flag = true;
            }
            if (flag) {
                itemstack.setDamageValue(0);
            }
        }
        return InteractionResult.CONSUME;
    }

    public ItemStack findAmmo(Player entity) {
        if (entity.isCreative()) {
            return ItemStack.EMPTY;
        }
        for (int i = 0; i < entity.getInventory().getContainerSize(); ++i) {
            ItemStack itemstack1 = entity.getInventory().getItem(i);
            if (!REDSTONE.test(itemstack1)) continue;
            return itemstack1;
        }
        return ItemStack.EMPTY;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !ItemStack.isSameItem((ItemStack)oldStack, (ItemStack)newStack);
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        if (Laser_Gatling.isUsable(stack)) {
            stack.set(ModDataComponents.LASER_GATLING, (Object)false);
            if (count % 2 == 0) {
                Vec3 vector3d = livingEntityIn.getViewVector(1.0f);
                Vec3 vec3 = vector3d.normalize();
                Laser_Beam_Entity laser = new Laser_Beam_Entity(livingEntityIn, vec3, worldIn, (float)CMCommonConfig.LaserGatling.damage);
                float yRot = (float)(Mth.atan2((double)vec3.z, (double)vec3.x) * 57.29577951308232) + 90.0f;
                float xRot = (float)(-(Mth.atan2((double)vec3.y, (double)Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * 57.29577951308232));
                laser.setYRot(yRot);
                laser.setXRot(xRot);
                laser.setPosRaw(livingEntityIn.getX(), livingEntityIn.getY() + (double)(livingEntityIn.getEyeHeight() * 0.8f), livingEntityIn.getZ());
                RandomSource rand = worldIn.getRandom();
                livingEntityIn.gameEvent((Holder)GameEvent.ITEM_INTERACT_START);
                livingEntityIn.playSound((SoundEvent)ModSounds.HARBINGER_LASER.get(), 0.2f, 1.0f + (rand.nextFloat() - rand.nextFloat()) * 0.2f);
                if (!worldIn.isClientSide()) {
                    worldIn.addFreshEntity((Entity)laser);
                }
                stack.hurtAndBreak(1, livingEntityIn, EquipmentSlot.MAINHAND);
            }
        } else if (livingEntityIn instanceof Player) {
            ItemStack ammo = this.findAmmo((Player)livingEntityIn);
            boolean flag = ((Player)livingEntityIn).isCreative();
            if (!ammo.isEmpty()) {
                ammo.shrink(1);
                flag = true;
            }
            if (flag) {
                ((Player)livingEntityIn).getCooldowns().addCooldown(this.getDefaultInstance(), 20);
                stack.setDamageValue(0);
            }
            livingEntityIn.stopUsingItem();
        }
    }

    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity living, int remainingUseTicks) {
        stack.set(ModDataComponents.LASER_GATLING, (Object)false);
        return true;
        return false;
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        LivingEntity living;
        boolean using;
        super.inventoryTick(stack, level, entity, i, held);
        boolean bl = using = entity instanceof LivingEntity && (living = (LivingEntity)entity).getUseItem().equals(stack);
        if (using) {
            stack.set(ModDataComponents.LASER_GATLING, (Object)true);
        }
        if (!using) {
            stack.set(ModDataComponents.LASER_GATLING, (Object)false);
        }
    }

    public static boolean isCharged(ItemStack p_40933_) {
        return (Boolean)p_40933_.getOrDefault(ModDataComponents.LASER_GATLING, (Object)true);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.laser_gatling.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

