/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.resources.sounds.TickableSoundInstance
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

import com.skd.sundering.client.sound.MeatShredderSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageMeatShredder(int entityID, boolean play) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageMeatShredder> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"meatshredder_sound"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageMeatShredder> STREAM_CODEC = CustomPacketPayload.codec(MessageMeatShredder::write, MessageMeatShredder::new);

    public MessageMeatShredder(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readBoolean());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID());
        buf.writeBoolean(this.play());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(final MessageMeatShredder message, final IPayloadContext ctx) {
        if (ctx.flow().isClientbound()) {
            ctx.enqueueWork(new Runnable(){

                @Override
                public void run() {
                    Entity entity = ctx.player().level().getEntity(message.entityID());
                    if (entity instanceof LivingEntity) {
                        LivingEntity living = (LivingEntity)entity;
                        Minecraft.getInstance().getSoundManager().queueTickingSound((TickableSoundInstance)new MeatShredderSound(living));
                    }
                }
            });
        }
    }
}

