/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.CameraType
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.ByteBufCodecs
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.cataclysmbosses.message;

import com.skd.cataclysmbosses.config.CMClientConfig;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public abstract class MessageEntityCameraSwitch
implements CustomPacketPayload {
    protected final int entityId;

    public MessageEntityCameraSwitch(int entityId) {
        this.entityId = entityId;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public static class ThridPerson
    extends MessageEntityCameraSwitch {
        public static final CustomPacketPayload.Type<ThridPerson> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"third_person_camera"));
        public static final StreamCodec<RegistryFriendlyByteBuf, ThridPerson> STREAM_CODEC = StreamCodec.composite((StreamCodec)ByteBufCodecs.INT, MessageEntityCameraSwitch::getEntityId, ThridPerson::new);

        public ThridPerson(int entityId) {
            super(entityId);
        }

        public CustomPacketPayload.Type<ThridPerson> type() {
            return TYPE;
        }

        public static void execute(ThridPerson payload, IPayloadContext context) {
            context.enqueueWork(() -> {
                Entity entity = context.player().level().getEntity(payload.entityId);
                if (entity instanceof Player) {
                    Player player = (Player)entity;
                    if (CMClientConfig.thirdPerson && player == Minecraft.getInstance().player && Minecraft.getInstance().getCameraEntity() == Minecraft.getInstance().player) {
                        Minecraft.getInstance().setCameraEntity(entity);
                        Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
                    }
                }
            });
        }
    }

    public static class FirstPerson
    extends MessageEntityCameraSwitch {
        public static final CustomPacketPayload.Type<FirstPerson> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"first_person_camera"));
        public static final StreamCodec<RegistryFriendlyByteBuf, FirstPerson> STREAM_CODEC = StreamCodec.composite((StreamCodec)ByteBufCodecs.INT, MessageEntityCameraSwitch::getEntityId, FirstPerson::new);

        public FirstPerson(int entityId) {
            super(entityId);
        }

        public CustomPacketPayload.Type<FirstPerson> type() {
            return TYPE;
        }

        public static void execute(FirstPerson payload, IPayloadContext context) {
            context.enqueueWork(() -> {
                Entity entity = context.player().level().getEntity(payload.entityId);
                if (entity instanceof Player) {
                    Player player = (Player)entity;
                    if (CMClientConfig.firstPerson && player == Minecraft.getInstance().player && Minecraft.getInstance().getCameraEntity() == Minecraft.getInstance().player) {
                        Minecraft.getInstance().setCameraEntity(entity);
                        Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
                    }
                }
            });
        }
    }
}

