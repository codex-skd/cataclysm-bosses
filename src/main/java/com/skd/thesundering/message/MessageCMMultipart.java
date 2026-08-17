/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.network.syncher.SynchedEntityData$DataValue
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.neoforge.entity.PartEntity
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.thesundering.message;

import com.skd.thesundering.entity.partentity.Cm_Part_Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.entity.PartEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageCMMultipart(int entityId, @Nullable Entity entity, @Nullable Map<Integer, PartDataHolder> data) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<MessageCMMultipart> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"update_multipart_entity"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageCMMultipart> STREAM_CODEC = CustomPacketPayload.codec(MessageCMMultipart::write, MessageCMMultipart::new);

    public MessageCMMultipart(RegistryFriendlyByteBuf buf) {
        this(buf.readInt(), null, new HashMap<Integer, PartDataHolder>());
        int id;
        while ((id = buf.readInt()) > 0) {
            this.data.put(id, PartDataHolder.decode(buf));
        }
    }

    public MessageCMMultipart(Entity entity) {
        this(-1, entity, Arrays.stream(entity.getParts()).filter(part -> part instanceof Cm_Part_Entity).map(part -> (Cm_Part_Entity)((Object)part)).collect(Collectors.toMap(Entity::getId, Cm_Part_Entity::writeData)));
    }

    public void write(RegistryFriendlyByteBuf buf) {
        if (this.entity == null) {
            throw new IllegalStateException("Null Entity while encoding UpdateTFMultipartPacket");
        }
        if (this.data == null) {
            throw new IllegalStateException("Null Data while encoding UpdateTFMultipartPacket");
        }
        buf.writeInt(this.entity.getId());
        this.data.forEach((id, data) -> {
            buf.writeInt(id.intValue());
            data.encode(buf);
        });
        buf.writeInt(-1);
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MessageCMMultipart message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            int eId = message.entity != null && message.entityId <= 0 ? message.entity.getId() : message.entityId;
            Entity ent = ctx.player().level().getEntity(eId);
            if (ent != null && ent.isMultipartEntity()) {
                PartEntity[] parts = ent.getParts();
                if (parts == null) {
                    return;
                }
                for (PartEntity part : parts) {
                    PartDataHolder data;
                    if (!(part instanceof Cm_Part_Entity)) continue;
                    Cm_Part_Entity tfPart = (Cm_Part_Entity)part;
                    if (message.data == null && message.entity != null) {
                        Arrays.stream(message.entity.getParts()).filter(p -> p instanceof Cm_Part_Entity && p.getId() == part.getId()).map(p -> (Cm_Part_Entity)((Object)((Object)p))).findFirst().ifPresent(p -> tfPart.readData(p.writeData()));
                        continue;
                    }
                    if (message.data == null || (data = message.data.get(tfPart.getId())) == null) continue;
                    tfPart.readData(data);
                }
            }
        });
    }

    public record PartDataHolder(double x, double y, double z, float yRot, float xRot, float width, float height, boolean fixed, @Nullable List<SynchedEntityData.DataValue<?>> data) {
        public void encode(RegistryFriendlyByteBuf buffer) {
            buffer.writeDouble(this.x());
            buffer.writeDouble(this.y());
            buffer.writeDouble(this.z());
            buffer.writeFloat(this.yRot());
            buffer.writeFloat(this.xRot());
            buffer.writeFloat(this.width());
            buffer.writeFloat(this.height());
            buffer.writeBoolean(this.fixed());
            if (this.data() != null) {
                for (SynchedEntityData.DataValue<?> datavalue : this.data()) {
                    datavalue.write(buffer);
                }
            }
            buffer.writeByte(255);
        }

        static PartDataHolder decode(RegistryFriendlyByteBuf buffer) {
            return new PartDataHolder(buffer.readDouble(), buffer.readDouble(), buffer.readDouble(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readBoolean(), PartDataHolder.unpack(buffer));
        }

        private static List<SynchedEntityData.DataValue<?>> unpack(RegistryFriendlyByteBuf buf) {
            short i;
            ArrayList list = new ArrayList();
            while ((i = buf.readUnsignedByte()) != 255) {
                list.add(SynchedEntityData.DataValue.read((RegistryFriendlyByteBuf)buf, (int)i));
            }
            return list;
        }
    }
}

