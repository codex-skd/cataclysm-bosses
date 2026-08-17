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
package com.skd.sundering.message;

import com.skd.sundering.Attachment.ChargeAttachment;
import com.skd.sundering.init.ModDataAttachments;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageCharge(int entityID, boolean falling, int timer, int chargetime, float knockback, float damageper, float x, float z) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageCharge> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"charge_attachment"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageCharge> STREAM_CODEC = CustomPacketPayload.codec(MessageCharge::write, MessageCharge::new);

    public MessageCharge(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readBoolean(), buf.readInt(), buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID());
        buf.writeBoolean(this.falling());
        buf.writeInt(this.timer());
        buf.writeInt(this.chargetime());
        buf.writeFloat(this.knockback());
        buf.writeFloat(this.damageper());
        buf.writeFloat(this.x());
        buf.writeFloat(this.z());
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageCharge message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Level level = ctx.player().level();
            Entity entity = level.getEntity(message.entityID());
            if (entity instanceof Player) {
                Player player = (Player)entity;
                ChargeAttachment attachment = (ChargeAttachment)player.getData(ModDataAttachments.CHARGE_ATTACHMENT);
                attachment.setCharge(message.falling());
                attachment.setTimer(message.timer());
                attachment.seteffectiveChargeTime(message.chargetime());
                attachment.setknockbackSpeedIndex(message.knockback());
                attachment.setdamagePerEffectiveCharge(message.damageper());
                attachment.setdx(message.x());
                attachment.setdZ(message.z());
            }
        });
    }
}

