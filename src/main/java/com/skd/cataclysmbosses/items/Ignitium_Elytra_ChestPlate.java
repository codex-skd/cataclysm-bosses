/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.equipment.ArmorMaterial$Layer
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.init.ModItems;
import javax.annotation.Nonnull;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Ignitium_Elytra_ChestPlate
extends Item {
    public Ignitium_Elytra_ChestPlate(Item.Properties props, Holder<ArmorMaterial> material) {
        super(props);
    }

    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is((Item)ModItems.IGNITIUM_INGOT.get());
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Equippable equippable = itemstack.get(DataComponents.EQUIPPABLE);
        if (equippable != null) {
            return equippable.swapWithEquipmentSlot(itemstack, player);
        }
        return InteractionResult.PASS;
    }

    public Identifier getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, net.minecraft.client.resources.model.EquipmentClientInfo.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/armor/ignitium_elytra_chestplate.png");
    }
}

