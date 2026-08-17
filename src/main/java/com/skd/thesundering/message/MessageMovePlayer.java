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
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.thesundering.message;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageMovePlayer(double motionX, double motionY, double motionZ) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageMovePlayer> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"move_player"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageMovePlayer> STREAM_CODEC = CustomPacketPayload.codec(MessageMovePlayer::write, MessageMovePlayer::new);

    public MessageMovePlayer(FriendlyByteBuf buf) {
        this(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(this.motionX());
        buf.writeDouble(this.motionY());
        buf.writeDouble(this.motionZ());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageMovePlayer message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> ctx.player().push(message.motionX(), message.motionY(), message.motionZ()));
    }
}

