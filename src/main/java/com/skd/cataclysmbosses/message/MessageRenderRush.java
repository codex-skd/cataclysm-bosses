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
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.cataclysmbosses.message;

import com.skd.cataclysmbosses.Attachment.RenderRushAttachment;
import com.skd.cataclysmbosses.init.ModDataAttachments;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageRenderRush(int entityID, boolean falling, int timer, float damage) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageRenderRush> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"render_attachment"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageRenderRush> STREAM_CODEC = CustomPacketPayload.codec(MessageRenderRush::write, MessageRenderRush::new);

    public MessageRenderRush(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readBoolean(), buf.readInt(), buf.readFloat());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID());
        buf.writeBoolean(this.falling());
        buf.writeInt(this.timer());
        buf.writeFloat(this.damage());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageRenderRush message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Level level = ctx.player().level();
            Entity entity = level.getEntity(message.entityID());
            if (entity instanceof Player) {
                Player player = (Player)entity;
                RenderRushAttachment attachment = (RenderRushAttachment)player.getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT);
                attachment.setRush(message.falling());
                attachment.setTimer(message.timer());
                attachment.setdamage(message.damage());
            }
        });
    }
}

