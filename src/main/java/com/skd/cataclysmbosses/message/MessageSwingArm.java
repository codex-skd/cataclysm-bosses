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
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.cataclysmbosses.message;

import com.skd.cataclysmbosses.items.ILeftClick;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageSwingArm(InteractionHand hand) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageSwingArm> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"swing_arm"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageSwingArm> STREAM_CODEC = CustomPacketPayload.codec(MessageSwingArm::write, MessageSwingArm::new);

    public MessageSwingArm(FriendlyByteBuf buf) {
        this(buf.readBoolean() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.hand() == InteractionHand.MAIN_HAND);
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageSwingArm message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            ItemStack leftItem = player.getItemInHand(message.hand);
            if (leftItem.getItem() instanceof ILeftClick) {
                ((ILeftClick)leftItem.getItem()).onLeftClick(leftItem, (LivingEntity)player);
            }
        });
    }
}

