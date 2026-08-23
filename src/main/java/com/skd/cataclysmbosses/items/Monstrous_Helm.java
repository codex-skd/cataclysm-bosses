/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.equipment.ArmorMaterial$Layer
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModItems;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class Monstrous_Helm
extends ArmorItem {
    public Monstrous_Helm(Holder<ArmorMaterial> material, ArmorItem.Type slot, Item.Properties properties) {
        super(material, slot, properties);
    }

    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(Items.NETHERITE_INGOT);
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        Player player;
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player && (player = (Player)entity).getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.MONSTROUS_HELM.get()) {
            boolean berserk = player.getMaxHealth() * 1.0f / 2.0f >= player.getHealth();
            double radius = 4.0;
            List list = level.getEntities((Entity)player, player.getBoundingBox().inflate(radius));
            if (berserk && !player.getCooldowns().isOnCooldown((Item)this)) {
                for (Entity entitys : list) {
                    if (!(entitys instanceof LivingEntity)) continue;
                    entitys.hurt(level.damageSources().mobAttack((LivingEntity)player), (float)player.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.0f / 2.0f);
                    double d0 = entitys.getX() - player.getX();
                    double d1 = entitys.getZ() - player.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
                    entitys.push(d0 / d2 * 1.5, 0.15, d1 / d2 * 1.5);
                }
                player.getCooldowns().addCooldown((Item)this, 350);
                player.addEffect(new MobEffectInstance(ModEffect.EFFECTMONSTROUS, 200, 0, false, true));
            }
        }
    }

    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/armor/monstrous_helm.png");
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.monstrous_helm.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.monstrous_helm2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

