/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.codec.ByteBufCodecs
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.Container
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.cataclysmbosses.message;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageOpenInventory(int id, int size, int entityId) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageOpenInventory> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"open_inventory"));
    public static final StreamCodec<FriendlyByteBuf, MessageOpenInventory> STREAM_CODEC = StreamCodec.composite((StreamCodec)ByteBufCodecs.INT, MessageOpenInventory::id, (StreamCodec)ByteBufCodecs.INT, MessageOpenInventory::size, (StreamCodec)ByteBufCodecs.INT, MessageOpenInventory::entityId, MessageOpenInventory::new);

    public static void handle(MessageOpenInventory payload, IPayloadContext context) {
        context.enqueueWork(() -> com.skd.cataclysmbosses.Cataclysm_Bosses.PROXY.openMinistrosityInventory(payload));
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

