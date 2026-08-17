/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.network.handling.IPayloadContext
 */
package com.skd.sundering.message;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class MessageParticle
implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<MessageParticle> TYPE = new CustomPacketPayload.Type(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"particle_queue"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageParticle> STREAM_CODEC = CustomPacketPayload.codec(MessageParticle::write, MessageParticle::new);
    private final List<QueuedParticle> queuedParticles = new ArrayList<QueuedParticle>();

    public MessageParticle() {
    }

    public MessageParticle(RegistryFriendlyByteBuf buf) {
        ParticleType type;
        int size = buf.readInt();
        for (int i = 0; i < size && (type = (ParticleType)BuiltInRegistries.PARTICLE_TYPE.byId(buf.readInt())) != null; ++i) {
            this.queuedParticles.add(new QueuedParticle((ParticleOptions)ParticleTypes.STREAM_CODEC.decode((Object)buf), buf.readBoolean(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readDouble()));
        }
    }

    public void write(RegistryFriendlyByteBuf buf) {
        buf.writeInt(this.queuedParticles.size());
        for (QueuedParticle queuedParticle : this.queuedParticles) {
            int d = BuiltInRegistries.PARTICLE_TYPE.getId((Object)queuedParticle.particleOptions.getType());
            buf.writeInt(d);
            ParticleTypes.STREAM_CODEC.encode((Object)buf, (Object)queuedParticle.particleOptions);
            buf.writeBoolean(queuedParticle.b);
            buf.writeDouble(queuedParticle.x);
            buf.writeDouble(queuedParticle.y);
            buf.writeDouble(queuedParticle.z);
            buf.writeDouble(queuedParticle.x2);
            buf.writeDouble(queuedParticle.y2);
            buf.writeDouble(queuedParticle.z2);
        }
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void queueParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
        this.queuedParticles.add(new QueuedParticle(particleOptions, b, x, y, z, x2, y2, z2));
    }

    public void queueParticle(ParticleOptions particleOptions, boolean b, Vec3 xyz, Vec3 xyz2) {
        this.queuedParticles.add(new QueuedParticle(particleOptions, b, xyz.x, xyz.y, xyz.z, xyz2.x, xyz2.y, xyz2.z));
    }

    public static void handle(MessageParticle message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            for (QueuedParticle queuedParticle : message.queuedParticles) {
                ctx.player().level().addParticle(queuedParticle.particleOptions, queuedParticle.b, queuedParticle.x, queuedParticle.y, queuedParticle.z, queuedParticle.x2, queuedParticle.y2, queuedParticle.z2);
            }
        });
    }

    private record QueuedParticle(ParticleOptions particleOptions, boolean b, double x, double y, double z, double x2, double y2, double z2) {
    }
}

