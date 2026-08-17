/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.UUIDUtil
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.ByteBufCodecs
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.Identifier
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.sundering.message;

import com.skd.sundering.ClientProxy;
import java.util.UUID;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public abstract class MessageBossBar
implements CustomPacketPayload {
    protected final UUID bossEvent;
    protected final int rendertype;
    protected final int remainlife;

    public MessageBossBar(UUID bossEvent, int rendertype, int remainlife) {
        this.bossEvent = bossEvent;
        this.rendertype = rendertype;
        this.remainlife = remainlife;
    }

    public UUID getBossEvent() {
        return this.bossEvent;
    }

    public int getRendertype() {
        return this.rendertype;
    }

    public int getRemainlife() {
        return this.remainlife;
    }

    public static class Remove
    extends MessageBossBar {
        public static final CustomPacketPayload.Type<Remove> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"remove_custom_bossbar"));
        public static final StreamCodec<RegistryFriendlyByteBuf, Remove> STREAM_CODEC = StreamCodec.composite((StreamCodec)UUIDUtil.STREAM_CODEC, MessageBossBar::getBossEvent, (StreamCodec)ByteBufCodecs.INT, MessageBossBar::getRendertype, (StreamCodec)ByteBufCodecs.INT, MessageBossBar::getRemainlife, Remove::new);

        public Remove(UUID bossEvent, int rendertype, int remainlife) {
            super(bossEvent, rendertype, remainlife);
        }

        public CustomPacketPayload.Type<Remove> type() {
            return TYPE;
        }

        public static void execute(Remove payload, IPayloadContext context) {
            ClientProxy.bossBarRenderTypes.remove(payload.bossEvent);
        }
    }

    public static class Display
    extends MessageBossBar {
        public static final CustomPacketPayload.Type<Display> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"add_custom_bossbar"));
        public static final StreamCodec<RegistryFriendlyByteBuf, Display> STREAM_CODEC = StreamCodec.composite((StreamCodec)UUIDUtil.STREAM_CODEC, MessageBossBar::getBossEvent, (StreamCodec)ByteBufCodecs.INT, MessageBossBar::getRendertype, (StreamCodec)ByteBufCodecs.INT, MessageBossBar::getRemainlife, Display::new);

        public Display(UUID bossEvent, int rendertype, int remainlife) {
            super(bossEvent, rendertype, remainlife);
        }

        public CustomPacketPayload.Type<Display> type() {
            return TYPE;
        }

        public static void execute(Display payload, IPayloadContext context) {
            ClientProxy.bossBarRenderTypes.put(payload.bossEvent, new ClientProxy.BossBarData(payload.rendertype, payload.remainlife));
        }
    }
}

