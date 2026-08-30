/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
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
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.projectile.Cursed_Sandstorm_Entity;
import com.skd.cataclysmbosses.init.ModDataComponents;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.items.Components.ChargeAnimationComponent;
import java.util.List;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Wrath_of_the_desert
extends Item {
    public Wrath_of_the_desert(Item.Properties group) {
        super(group);
    }

    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @javax.annotation.Nullable EquipmentSlot slot) {
        LivingEntity living;
        boolean using = entity instanceof LivingEntity && (living = (LivingEntity)entity).getUseItem().equals(stack);
        int useTime = Wrath_of_the_desert.getUseTime(stack);
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, ChargeAnimationComponent.EMPTY);
        if (flaskContents.PrevUseTime() != flaskContents.UseTime()) {
            stack.update(ModDataComponents.CHARGE_ANIMATION.get(), flaskContents, component -> component.tryAddDose(useTime, Wrath_of_the_desert.getUseTime(stack)));
        }
        int maxLoadTime = Wrath_of_the_desert.getMaxLoadTime();
        if (using && useTime < maxLoadTime) {
            int set = useTime + 1;
            Wrath_of_the_desert.setUseTime(stack, set);
        }
        if (!using && (float)useTime > 0.0f) {
            Wrath_of_the_desert.setUseTime(stack, Math.max(0, useTime - 5));
        }
    }

    private static int getMaxLoadTime() {
        return 20;
    }

    public static int getUseTime(ItemStack stack) {
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, (Object)ChargeAnimationComponent.EMPTY);
        return flaskContents.UseTime();
    }

    public static void setUseTime(ItemStack stack, int useTime) {
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, ChargeAnimationComponent.EMPTY);
        stack.update(ModDataComponents.CHARGE_ANIMATION.get(), flaskContents, component -> component.tryAddDose(useTime, Wrath_of_the_desert.getUseTime(stack)));
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, (Object)ChargeAnimationComponent.EMPTY);
        float prev = flaskContents.PrevUseTime();
        float current = flaskContents.UseTime();
        return prev + f * (current - prev);
    }

    public static float getPullingAmount(ItemStack itemStack, float partialTicks) {
        return Math.min(Wrath_of_the_desert.getLerpedUseTime(itemStack, partialTicks) / (float)Wrath_of_the_desert.getMaxLoadTime(), 1.0f);
    }

    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }

    public static float getPowerForTime(int i) {
        float f = (float)i / (float)Wrath_of_the_desert.getMaxLoadTime();
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    private Entity getPlayerLookTarget(Level level, LivingEntity living) {
        Entity pointedEntity = null;
        double range = 40.0;
        Vec3 srcVec = living.getEyePosition();
        Vec3 lookVec = living.getViewVector(1.0f);
        Vec3 destVec = srcVec.add(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range);
        float var9 = 2.0f;
        List<Entity> possibleList = level.getEntities((Entity)living, living.getBoundingBox().expandTowards(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range).inflate((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (Entity possibleEntity : possibleList) {
            double possibleDist;
            AABB collisionBB = possibleEntity.getBoundingBox().inflate(1.0, 1.0, 1.0);
            Optional interceptPos = collisionBB.clip(srcVec, destVec);
            if (collisionBB.contains(srcVec)) {
                if (!(0.0 < hitDist) && hitDist != 0.0) continue;
                pointedEntity = possibleEntity;
                hitDist = 0.0;
                continue;
            }
            if (!interceptPos.isPresent() || !((possibleDist = srcVec.distanceTo((Vec3)interceptPos.get())) < hitDist) && hitDist != 0.0) continue;
            pointedEntity = possibleEntity;
            hitDist = possibleDist;
        }
        return pointedEntity;
    }

    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity living, int timeleft) {
        if (living instanceof Player) {
            Player player = (Player)living;
            Entity pointedEntity = this.getPlayerLookTarget(level, living);
            int i = this.getUseDuration(stack, living) - timeleft;
            float f = Wrath_of_the_desert.getPowerForTime(i);
            if (!((double)f < 0.1) && !level.isClientSide()) {
                float baseYaw = player.getYRot();
                float pitch = player.getXRot();
                for (int j = -1; j <= 1; ++j) {
                    Cursed_Sandstorm_Entity largefireball;
                    LivingEntity target;
                    float yaw = baseYaw + (float)(j * 15);
                    float directionX = -Mth.sin((float)(yaw * ((float)Math.PI / 180))) * Mth.cos((float)(pitch * ((float)Math.PI / 180)));
                    float directionY = -Mth.sin((float)(pitch * ((float)Math.PI / 180)));
                    float directionZ = Mth.cos((float)(yaw * ((float)Math.PI / 180))) * Mth.cos((float)(pitch * ((float)Math.PI / 180)));
                    double theta = (double)yaw * (Math.PI / 180);
                    double vecX = Math.cos(theta += 1.5707963267948966);
                    double vecZ = Math.sin(theta);
                    double x = player.getX() + vecX;
                    double Z = player.getZ() + vecZ;
                    if (pointedEntity instanceof LivingEntity && !(target = (LivingEntity)pointedEntity).isAlliedTo((Entity)living)) {
                        largefireball = new Cursed_Sandstorm_Entity((LivingEntity)player, directionX, directionY, directionZ, player.level(), (float)CMCommonConfig.WrathOfTheDesert.damage * f, target);
                        largefireball.setPos(x, player.getEyeY() - 0.5, Z);
                        largefireball.setUp(15);
                        level.addFreshEntity((Entity)largefireball);
                        continue;
                    }
                    largefireball = new Cursed_Sandstorm_Entity((LivingEntity)player, directionX, directionY, directionZ, player.level(), (float)CMCommonConfig.WrathOfTheDesert.damage * f, null);
                    largefireball.setPos(x, player.getEyeY() - 0.5, Z);
                    largefireball.setUp(15);
                    level.addFreshEntity((Entity)largefireball);
                }
                level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0f, 1.0f / (level.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return false;
    }

    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public int getEnchantmentValue() {
        return 16;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.is((Item)ModItems.WRATH_OF_THE_DESERT.get()) || !newStack.is((Item)ModItems.WRATH_OF_THE_DESERT.get());
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.wrath_of_the_desert.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

