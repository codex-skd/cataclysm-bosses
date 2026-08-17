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
 *  net.minecraft.world.entity.LivingEntity
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.sundering.message;

import com.skd.sundering.init.ModDataAttachments;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageHookFalling(int entityID, boolean falling) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageHookFalling> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"hook_falling_attachment"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageHookFalling> STREAM_CODEC = CustomPacketPayload.codec(MessageHookFalling::write, MessageHookFalling::new);

    public MessageHookFalling(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readBoolean());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID());
        buf.writeBoolean(this.falling());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageHookFalling message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Entity entity = ctx.player().level().getEntity(message.entityID());
            if (entity instanceof LivingEntity) {
                entity.setData(ModDataAttachments.HOOK_FALLING, (Object)message.falling());
            }
        });
    }
}

