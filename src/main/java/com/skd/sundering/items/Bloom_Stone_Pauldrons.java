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
package com.skd.sundering.items;

import com.skd.sundering.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.skd.sundering.init.ModEntities;
import com.skd.sundering.init.ModItems;
import com.skd.sundering.init.ModKeybind;
import com.skd.sundering.items.Cataclysm_Armor;
import com.skd.sundering.items.CuriosItem.AttributeContainer;
import com.skd.sundering.items.KeybindUsingArmor;
import com.skd.sundering.message.MessageArmorKey;
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
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

public class Bloom_Stone_Pauldrons
extends Cataclysm_Armor
implements KeybindUsingArmor {
    public Bloom_Stone_Pauldrons(Holder<ArmorMaterial> material, ArmorItem.Type slot, Item.Properties properties, AttributeContainer ... attributes) {
        super(material, slot, properties, attributes);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.bloom_stone_pauldrons.desc", (Object[])new Object[]{ModKeybind.CHESTPLATE_KEY_ABILITY.getTranslatedKeyMessage()}).withStyle(ChatFormatting.DARK_GREEN));
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        Player player;
        block5: {
            block4: {
                super.inventoryTick(stack, level, entity, i, held);
                if (!(entity instanceof Player)) break block4;
                player = (Player)entity;
                if (level.isClientSide()) break block5;
            }
            return;
        }
        if (this.type == ArmorItem.Type.CHESTPLATE && player.getItemBySlot(EquipmentSlot.CHEST) == stack && ModKeybind.CHESTPLATE_KEY_ABILITY.consumeClick()) {
            PacketDistributor.sendToServer((CustomPacketPayload)new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), player.getId(), 6), (CustomPacketPayload[])new CustomPacketPayload[0]);
            this.onKeyPacket(player, stack, 6);
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int Type2) {
        if (player == null) {
            return;
        }
        if (Type2 == 6 && !player.getCooldowns().isOnCooldown((Item)ModItems.BLOOM_STONE_PAULDRONS.get())) {
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
                projectile.moveTo(sx, sy, sz, (float)i * 11.25f, player.getXRot());
                float speed = 0.8f;
                projectile.shoot(vx, vy + v3 * (double)0.2f, vz, speed, 1.0f);
                player.level().addFreshEntity((Entity)projectile);
            }
            player.getCooldowns().addCooldown((Item)ModItems.BLOOM_STONE_PAULDRONS.get(), 240);
        }
    }

    public Identifier getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/armor/bloom_stone_pauldrons.png");
    }
}

