/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.equipment.ArmorMaterial$Layer
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModKeybind;
import com.skd.cataclysmbosses.items.Cataclysm_Armor;
import com.skd.cataclysmbosses.items.CuriosItem.AttributeContainer;
import com.skd.cataclysmbosses.items.KeybindUsingArmor;
import com.skd.cataclysmbosses.message.MessageArmorKey;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

public class Cursium_Armor
extends Cataclysm_Armor
implements KeybindUsingArmor {
    public Cursium_Armor(Holder<ArmorMaterial> material, ArmorType slot, Item.Properties properties) {
        super(material, slot, properties, new AttributeContainer[0]);
    }

    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is((Item)ModItems.CURSIUM_INGOT.get());
    }

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @javax.annotation.Nullable EquipmentSlot slotId) {
        Player player;
        if (!(entity instanceof Player)) {
            return;
        }
        player = (Player)entity;
        if (this.type == ArmorType.HELMET && player.getItemBySlot(EquipmentSlot.HEAD) == stack) {
            if (ModKeybind.HELMET_KEY_ABILITY.consumeClick()) {
                PacketDistributor.sendToPlayer((net.minecraft.server.level.ServerPlayer)player, (CustomPacketPayload)new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), player.getId(), 5));
                this.onKeyPacket(player, stack, 5);
            }
        } else if (this.type == ArmorType.BOOTS && player.getItemBySlot(EquipmentSlot.FEET) == stack && ModKeybind.BOOTS_KEY_ABILITY.consumeClick()) {
            PacketDistributor.sendToPlayer((net.minecraft.server.level.ServerPlayer)player, (CustomPacketPayload)new MessageArmorKey(EquipmentSlot.FEET.ordinal(), player.getId(), 7));
            this.onKeyPacket(player, stack, 7);
        }
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, java.util.function.Consumer<Component> builder, TooltipFlag flags) {
        if (this.type == ArmorType.HELMET) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_helmet.desc2", (Object[])new Object[]{ModKeybind.HELMET_KEY_ABILITY.getTranslatedKeyMessage()}).withStyle(ChatFormatting.DARK_GREEN));
        } else if (this.type == ArmorType.CHESTPLATE) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_chestplate.desc2").withStyle(ChatFormatting.DARK_GREEN));
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_chestplate.desc3").withStyle(ChatFormatting.DARK_GREEN));
        } else if (this.type == ArmorType.LEGGINGS) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_leggings.desc2").withStyle(ChatFormatting.DARK_GREEN));
        } else if (this.type == ArmorType.BOOTS) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
            builder.accept((Component)Component.translatable((String)"item.cataclysm.cursium_boots.desc2", (Object[])new Object[]{ModKeybind.BOOTS_KEY_ABILITY.getTranslatedKeyMessage()}).withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int type) {
        if (player == null) {
            return;
        }
        if (type == 5 && !player.getCooldowns().isOnCooldown(new ItemStack(ModItems.CURSIUM_HELMET.get()))) {
            boolean targetFound = false;
            List<Entity> list = player.level().getEntities((Entity)player, player.getBoundingBox().inflate(24.0));
            for (Entity entity : list) {
                if (!(entity instanceof LivingEntity)) continue;
                LivingEntity living = (LivingEntity)entity;
                if (entity == player) continue;
                targetFound = true;
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 160));
            }
            if (targetFound) {
                player.getCooldowns().addCooldown(ModItems.CURSIUM_HELMET.get().getDefaultInstance(), 200);
            }
        }
        if (type == 7 && player.onGround() && !player.getCooldowns().isOnCooldown(new ItemStack(ModItems.CURSIUM_BOOTS.get()))) {
            float speed = -1.8f;
            float dodgeYaw = (float)Math.toRadians(player.getYRot() + 90.0f);
            double velX = (double)speed * Math.cos(dodgeYaw);
            double velZ = (double)speed * Math.sin(dodgeYaw);
            Vec3 currentVel = player.getDeltaMovement();
            player.setDeltaMovement(currentVel.x + velX, 0.4, currentVel.z + velZ);
            player.hurtMarked = true;
            player.getCooldowns().addCooldown(ModItems.CURSIUM_BOOTS.get().getDefaultInstance(), 200);
        }
    }

    public Identifier getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, net.minecraft.client.resources.model.EquipmentClientInfo.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/armor/cursium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png")));
    }
}

