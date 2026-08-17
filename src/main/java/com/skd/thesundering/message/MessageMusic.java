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
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.thesundering.message;

import com.skd.thesundering.client.sound.BossMusicPlayer;
import com.skd.thesundering.entity.etc.Animation_Monsters;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageMusic(int entityID, boolean play) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageMusic> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"music"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageMusic> STREAM_CODEC = CustomPacketPayload.codec(MessageMusic::write, MessageMusic::new);

    public MessageMusic(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readBoolean());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID());
        buf.writeBoolean(this.play());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(final MessageMusic message, final IPayloadContext ctx) {
        if (ctx.flow().isClientbound()) {
            ctx.enqueueWork(new Runnable(){

                @Override
                public void run() {
                    Entity entity = ctx.player().level().getEntity(message.entityID);
                    if (entity instanceof Animation_Monsters) {
                        Animation_Monsters am = (Animation_Monsters)entity;
                        if (message.play) {
                            BossMusicPlayer.playBossMusic(am);
                        } else {
                            BossMusicPlayer.stopBossMusic(am);
                        }
                    }
                }
            });
        }
    }
}

