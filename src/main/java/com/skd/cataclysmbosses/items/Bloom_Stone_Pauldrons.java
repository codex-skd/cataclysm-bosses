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
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
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

import com.skd.cataclysmbosses.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
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

public class Bloom_Stone_Pauldrons
extends Cataclysm_Armor
implements KeybindUsingArmor {
    public Bloom_Stone_Pauldrons(Holder<ArmorMaterial> material, ArmorType slot, Item.Properties properties, AttributeContainer ... attributes) {
        super(material, slot, properties, attributes);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, java.util.function.Consumer<Component> builder, TooltipFlag flags) {
        builder.accept((Component)Component.translatable((String)"item.cataclysm.bloom_stone_pauldrons.desc", (Object[])new Object[]{ModKeybind.CHESTPLATE_KEY_ABILITY.getTranslatedKeyMessage()}).withStyle(ChatFormatting.DARK_GREEN));
    }

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @javax.annotation.Nullable EquipmentSlot slot) {
        Player player;
        if (!(entity instanceof Player)) {
            return;
        }
        player = (Player)entity;
        if (this.type == ArmorType.CHESTPLATE && player.getItemBySlot(EquipmentSlot.CHEST) == stack && ModKeybind.CHESTPLATE_KEY_ABILITY.consumeClick()) {
            PacketDistributor.sendToPlayer((net.minecraft.server.level.ServerPlayer)player, (CustomPacketPayload)new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), player.getId(), 6));
            this.onKeyPacket(player, stack, 6);
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int Type2) {
        if (player == null) {
            return;
        }
        if (Type2 == 6 && !player.getCooldowns().isOnCooldown(new ItemStack(ModItems.BLOOM_STONE_PAULDRONS.get()))) {
            for (int i = 0; i < 8; ++i) {
                float throwAngle = (float)i * (float)Math.PI / 4.0f;
                double sx = player.getX() + (double)(Mth.cos((float)throwAngle) * 1.0f);
                double sy = player.getY() + (double)player.getBbHeight() * 0.5;
                double sz = player.getZ() + (double)(Mth.sin((float)throwAngle) * 1.0f);
                double vx = Mth.cos((float)throwAngle);
                double vy = 0.0f + player.getRandom().nextFloat() * 0.3f;
                double vz = Mth.sin((float)throwAngle);
                double v3 = Mth.sqrt((float)((float)(vx * vx + vz * vz)));
                Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity((EntityType<Amethyst_Cluster_Projectile_Entity>)((EntityType)ModEntities.AMETHYST_CLUSTER_PROJECTILE.get()), player.level(), (LivingEntity)player, 11.0f);
                projectile.setPos(sx, sy, sz);
            projectile.setYRot((float)i * 11.25f);
            projectile.setXRot(player.getXRot());
                float speed = 0.8f;
                projectile.shoot(vx, vy + v3 * (double)0.2f, vz, speed, 1.0f);
                player.level().addFreshEntity((Entity)projectile);
            }
            player.getCooldowns().addCooldown(ModItems.BLOOM_STONE_PAULDRONS.get().getDefaultInstance(), 240);
        }
    }

    public Identifier getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, net.minecraft.client.resources.model.EquipmentClientInfo.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/armor/bloom_stone_pauldrons.png");
    }
}

