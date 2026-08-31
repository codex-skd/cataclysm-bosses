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
 *  net.minecraft.util.Mth
 *  net.minecraft.world.effect.MobEffectInstance
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
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.init.ModEffect;
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
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

public class Ignitium_Armor
extends Cataclysm_Armor
implements KeybindUsingArmor {
    public Ignitium_Armor(Holder<ArmorMaterial> material, ArmorType slot, Item.Properties properties) {
        super(material, slot, properties, new AttributeContainer[0]);
    }

    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is((Item)ModItems.IGNITIUM_INGOT.get());
    }

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @javax.annotation.Nullable EquipmentSlot slot) {
        Player player;
        if (!(entity instanceof Player)) {
            return;
        }
        player = (Player)entity;
        if (this.type == ArmorType.HELMET && player.getItemBySlot(EquipmentSlot.HEAD) == stack && ModKeybind.HELMET_KEY_ABILITY.consumeClick()) {
            PacketDistributor.sendToPlayer((net.minecraft.server.level.ServerPlayer)player, (CustomPacketPayload)new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), player.getId(), 5));
            this.onKeyPacket(player, stack, 5);
        }
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, java.util.function.Consumer<Component> builder, TooltipFlag flags) {
        if (this.type == ArmorType.HELMET) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.ignitium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
            builder.accept((Component)Component.translatable((String)"item.cataclysm.ignitium_helmet.desc2", (Object[])new Object[]{ModKeybind.HELMET_KEY_ABILITY.getTranslatedKeyMessage()}).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == ArmorType.CHESTPLATE) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.ignitium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == ArmorType.LEGGINGS) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.ignitium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == ArmorType.BOOTS) {
            builder.accept((Component)Component.translatable((String)"item.cataclysm.ignitium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int Type2) {
        if (player == null) {
            return;
        }
        if (Type2 == 5 && !player.getCooldowns().isOnCooldown(new ItemStack(ModItems.IGNITIUM_HELMET.get()))) {
            boolean flag = false;
            List<Entity> list = player.level().getEntities((Entity)player, player.getBoundingBox().inflate(16.0));
            for (Entity entity : list) {
                if (entity instanceof LivingEntity) {
                    LivingEntity living = (LivingEntity)entity;
                    MobEffectInstance effectinstance1 = living.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        living.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)2);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 160, i, true, true, true);
                    flag = living.addEffect(effectinstance);
                }
                if (!flag) continue;
                player.getCooldowns().addCooldown(ModItems.IGNITIUM_HELMET.get().getDefaultInstance(), 300);
            }
        }
    }

    public Identifier getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, net.minecraft.client.resources.model.EquipmentClientInfo.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/armor/ignitium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png")));
    }
}

