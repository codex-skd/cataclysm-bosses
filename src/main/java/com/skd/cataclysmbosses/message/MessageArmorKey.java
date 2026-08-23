/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.cataclysmbosses.message;

import com.skd.cataclysmbosses.items.KeybindUsingArmor;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageArmorKey(int equipmentSlot, int playerId, int typ) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageArmorKey> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"armor_key"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageArmorKey> STREAM_CODEC = CustomPacketPayload.codec(MessageArmorKey::write, MessageArmorKey::new);

    public MessageArmorKey(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.equipmentSlot());
        buf.writeInt(this.playerId());
        buf.writeInt(this.typ());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageArmorKey message, IPayloadContext context) {
        if (context.flow().isServerbound()) {
            context.enqueueWork(() -> {
                EquipmentSlot equipmentSlot1;
                Player player = context.player();
                ItemStack stack = player.getItemBySlot(equipmentSlot1 = EquipmentSlot.values()[Mth.clamp((int)message.equipmentSlot, (int)0, (int)(EquipmentSlot.values().length - 1))]);
                Item patt0$temp = stack.getItem();
                if (patt0$temp instanceof KeybindUsingArmor) {
                    KeybindUsingArmor armor = (KeybindUsingArmor)patt0$temp;
                    armor.onKeyPacket(player, stack, message.typ);
                }
            });
        }
    }
}

