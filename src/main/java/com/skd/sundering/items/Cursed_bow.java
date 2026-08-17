/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow$Pickup
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.item.ArrowItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.ProjectileWeaponItem
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.sundering.items;

import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.entity.projectile.Phantom_Arrow_Entity;
import com.skd.sundering.init.ModDataComponents;
import com.skd.sundering.init.ModItems;
import com.skd.sundering.items.Components.ChargeAnimationComponent;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class Cursed_bow
extends ProjectileWeaponItem {
    public Cursed_bow(Item.Properties group) {
        super(group);
    }

    public InteractionResultHolder<ItemStack> use(Level p_40672_, Player p_40673_, InteractionHand p_40674_) {
        ItemStack itemstack;
        boolean flag = !p_40673_.getProjectile(itemstack = p_40673_.getItemInHand(p_40674_)).isEmpty();
        InteractionResultHolder ret = EventHooks.onArrowNock((ItemStack)itemstack, (Level)p_40672_, (Player)p_40673_, (InteractionHand)p_40674_, (boolean)flag);
        if (ret != null) {
            return ret;
        }
        if (!p_40673_.hasInfiniteMaterials() && !flag) {
            return InteractionResultHolder.fail((Object)itemstack);
        }
        p_40673_.startUsingItem(p_40674_);
        return InteractionResultHolder.consume((Object)itemstack);
    }

    public int getUseDuration(ItemStack stack, LivingEntity pEntity) {
        return 72000;
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        LivingEntity living;
        super.inventoryTick(stack, level, entity, i, held);
        boolean using = entity instanceof LivingEntity && (living = (LivingEntity)entity).getUseItem().equals(stack);
        int useTime = Cursed_bow.getUseTime(stack);
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, (Object)ChargeAnimationComponent.EMPTY);
        if (flaskContents.PrevUseTime() != flaskContents.UseTime()) {
            stack.update(ModDataComponents.CHARGE_ANIMATION, (Object)flaskContents, component -> component.tryAddDose(useTime, Cursed_bow.getUseTime(stack)));
        }
        int maxLoadTime = Cursed_bow.getMaxLoadTime();
        if (using && useTime < maxLoadTime) {
            int set = useTime + 1;
            Cursed_bow.setUseTime(stack, set);
        }
        if (!using && (float)useTime > 0.0f) {
            Cursed_bow.setUseTime(stack, Math.max(0, useTime - 5));
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
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, (Object)ChargeAnimationComponent.EMPTY);
        stack.update(ModDataComponents.CHARGE_ANIMATION, (Object)flaskContents, component -> component.tryAddDose(useTime, Cursed_bow.getUseTime(stack)));
    }

    public static float getLerpedUseTime(ItemStack stack, float f) {
        ChargeAnimationComponent flaskContents = (ChargeAnimationComponent)stack.getOrDefault(ModDataComponents.CHARGE_ANIMATION, (Object)ChargeAnimationComponent.EMPTY);
        float prev = flaskContents.PrevUseTime();
        float current = flaskContents.UseTime();
        return prev + f * (current - prev);
    }

    public static float getPullingAmount(ItemStack itemStack, float partialTicks) {
        return Math.min(Cursed_bow.getLerpedUseTime(itemStack, partialTicks) / (float)Cursed_bow.getMaxLoadTime(), 1.0f);
    }

    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BOW;
    }

    public static float getPowerForTime(int i) {
        float f = (float)i / (float)Cursed_bow.getMaxLoadTime();
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
        List possibleList = level.getEntities((Entity)living, living.getBoundingBox().expandTowards(lookVec.x() * range, lookVec.y() * range, lookVec.z() * range).inflate((double)var9, (double)var9, (double)var9));
        double hitDist = 0.0;
        for (Entity possibleEntity : possibleList) {
            double possibleDist;
            if (!possibleEntity.isPickable()) continue;
            float borderSize = possibleEntity.getPickRadius();
            AABB collisionBB = possibleEntity.getBoundingBox().inflate((double)borderSize, (double)borderSize, (double)borderSize);
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

    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player) {
            Player player = (Player)entityLiving;
            ItemStack itemstack = player.getProjectile(stack);
            Entity pointedEntity = this.getPlayerLookTarget(level, entityLiving);
            if (!itemstack.isEmpty()) {
                int i = this.getUseDuration(stack, entityLiving) - timeLeft;
                if ((i = EventHooks.onArrowLoose((ItemStack)stack, (Level)level, (Player)player, (int)i, (!itemstack.isEmpty() ? 1 : 0) != 0)) < 0) {
                    return;
                }
                float f = Cursed_bow.getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    List list = Cursed_bow.draw((ItemStack)stack, (ItemStack)itemstack, (LivingEntity)player);
                    if (level instanceof ServerLevel) {
                        ServerLevel serverlevel = (ServerLevel)level;
                        if (!list.isEmpty()) {
                            this.shoot(serverlevel, (LivingEntity)player, player.getUsedItemHand(), stack, list, f, 1.0f, f == 1.0f, pointedEntity);
                        }
                    }
                    level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0f, 1.0f / (level.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
                    player.awardStat(Stats.ITEM_USED.get((Object)this));
                }
            }
        }
    }

    // FASE0 DIAGNOSTIC STUB: CFR failed to decompile this method ("Unable to fully structure
    // code" -- emitted invalid GOTO/label pseudocode with no local variable declarations at
    // all, lines 210-257 of the original decompile). This is a genuine decompiler limitation,
    // not a NeoForge API issue -- needs full manual reconstruction from bytecode (e.g. via
    // javap -c on the original class, or a different decompiler) in Fase 1, not attempted here
    // since this pass exists only to surface real 26.2.0.45-beta API breakage in the rest of
    // the 839-file codebase. Do not treat this stub as a faithful port of the original logic.
    protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @Nullable Entity target) {
        throw new UnsupportedOperationException("FASE0 stub -- not reconstructed, CFR decompilation failure");
    }

    protected AbstractArrow createArrow(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        ArrowItem arrowitem1;
        Item var8 = ammo.getItem();
        ArrowItem var10000 = var8 instanceof ArrowItem ? (arrowitem1 = (ArrowItem)var8) : (ArrowItem)Items.ARROW;
        ArrowItem arrowitem = var10000;
        AbstractArrow abstractarrow = arrowitem.createArrow(level, ammo, shooter, weapon);
        if (isCrit) {
            abstractarrow.setCritArrow(true);
        }
        return this.customArrow(abstractarrow, ammo, weapon);
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public int getEnchantmentValue() {
        return 16;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.is((Item)ModItems.CURSED_BOW.get()) || !newStack.is((Item)ModItems.CURSED_BOW.get());
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public int getDefaultProjectileRange() {
        return 64;
    }

    protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
        projectile.shootFromRotation((Entity)shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0f, velocity, inaccuracy);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.cursed_bow.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.cursed_bow2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

