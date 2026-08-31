/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Position
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.stats.Stats
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.EquipmentSlotGroup
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow$Pickup
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.ProjectileItem
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.item.component.ItemAttributeModifiers
 *  net.minecraft.world.item.component.Tool
 *  net.minecraft.world.item.enchantment.EnchantmentEffectComponents
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.common.ItemAbilities
 *  net.neoforged.neoforge.common.ItemAbility
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.entity.projectile.ThrownCoral_Bardiche_Entity;
import com.skd.cataclysmbosses.items.RangeTool;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class Coral_Bardiche
extends Item
implements ProjectileItem,
RangeTool {
    public Coral_Bardiche(Item.Properties p_43381_) {
        super(p_43381_);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)-3.2f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, 1.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0f, 2, true);
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

    public boolean releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player) {
            float f;
            Player player = (Player)p_43396_;
            int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
            if (!(i < 10 || (f = EnchantmentHelper.getTridentSpinAttackStrength((ItemStack)p_43394_, (LivingEntity)player)) > 0.0f && !player.isInWaterOrRain() || Coral_Bardiche.isTooDamagedToUse(p_43394_))) {
                Holder<SoundEvent> holder = EnchantmentHelper.pickHighestLevel((ItemStack)p_43394_, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
                if (!p_43395_.isClientSide()) {
                    p_43394_.hurtAndBreak(1, (LivingEntity)player, EquipmentSlot.MAINHAND);
                    if (f == 0.0f) {
                        ThrownCoral_Bardiche_Entity throwntrident = new ThrownCoral_Bardiche_Entity(p_43395_, (LivingEntity)player, p_43394_);
                        throwntrident.shootFromRotation((Entity)player, player.getXRot(), player.getYRot(), 0.0f, 2.5f, 1.0f);
                        if (player.hasInfiniteMaterials()) {
                            throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        p_43395_.addFreshEntity((Entity)throwntrident);
                        p_43395_.playSound(null, (Entity)throwntrident, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0f, 1.0f);
                        if (!player.hasInfiniteMaterials()) {
                            player.getInventory().removeItem(p_43394_);
                        }
                    }
                }
                player.awardStat(Stats.ITEM_USED.get(this));
                if (f > 0.0f) {
                    float f7 = player.getYRot();
                    float f1 = player.getXRot();
                    float f2 = -Mth.sin((float)(f7 * ((float)Math.PI / 180))) * Mth.cos((float)(f1 * ((float)Math.PI / 180)));
                    float f3 = -Mth.sin((float)(f1 * ((float)Math.PI / 180)));
                    float f4 = Mth.cos((float)(f7 * ((float)Math.PI / 180))) * Mth.cos((float)(f1 * ((float)Math.PI / 180)));
                    float f5 = Mth.sqrt((float)(f2 * f2 + f3 * f3 + f4 * f4));
                    player.push((double)(f2 *= f / f5), (double)(f3 *= f / f5), (double)(f4 *= f / f5));
                    player.startAutoSpinAttack(20, 8.0f, p_43394_);
                    if (player.onGround()) {
                        float f6 = 1.1999999f;
                        player.move(MoverType.SELF, new Vec3(0.0, 1.1999999284744263, 0.0));
                    }
                    p_43395_.playSound(null, (Entity)player, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0f, 1.0f);
                }
            }
        }
        return false;
    }

    public InteractionResult use(Level p_43405_, Player p_43406_, InteractionHand p_43407_) {
        ItemStack itemstack = p_43406_.getItemInHand(p_43407_);
        InteractionHand otherhand = p_43407_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otheritem = p_43406_.getItemInHand(otherhand);
        if (otheritem.has(net.minecraft.core.component.DataComponents.BLOCKS_ATTACKS) && !p_43406_.getCooldowns().isOnCooldown(otheritem)) {
            return InteractionResult.FAIL;
        }
        if (Coral_Bardiche.isTooDamagedToUse(itemstack)) {
            return InteractionResult.FAIL;
        }
        if (EnchantmentHelper.getTridentSpinAttackStrength((ItemStack)itemstack, (LivingEntity)p_43406_) > 0.0f && !p_43406_.isInWaterOrRain()) {
            return InteractionResult.FAIL;
        }
        p_43406_.startUsingItem(p_43407_);
        return InteractionResult.CONSUME;
    }

    private static boolean isTooDamagedToUse(ItemStack p_353073_) {
        return p_353073_.getDamageValue() >= p_353073_.getMaxDamage() - 1;
    }

    public void hurtEnemy(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
    }

    public void postHurtEnemy(ItemStack p_345950_, LivingEntity p_345617_, LivingEntity p_345537_) {
        p_345950_.hurtAndBreak(1, p_345537_, EquipmentSlot.MAINHAND);
    }

    public int getEnchantmentValue() {
        return 1;
    }

    public Projectile asProjectile(Level p_338505_, Position p_338277_, ItemStack p_338353_, Direction p_338220_) {
        ThrownCoral_Bardiche_Entity throwntrident = new ThrownCoral_Bardiche_Entity(p_338505_, p_338277_.x(), p_338277_.y(), p_338277_.z(), p_338353_.copyWithCount(1));
        throwntrident.pickup = AbstractArrow.Pickup.ALLOWED;
        return throwntrident;
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }
}

