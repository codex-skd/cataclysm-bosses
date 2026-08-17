/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleType
 *  net.minecraft.network.codec.StreamCodec
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.thesundering.client.particle.Options;

import com.skd.thesundering.init.ModParticle;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

public record RingParticleOptions(float yaw, float pitch, int duration, int r, int g, int b, float a, float scale, boolean facesCamera, int behavior) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, RingParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.yaw);
        buf.writeFloat(option.pitch);
        buf.writeInt(option.duration);
        buf.writeInt(option.r);
        buf.writeInt(option.g);
        buf.writeInt(option.b);
        buf.writeFloat(option.a);
        buf.writeFloat(option.scale);
        buf.writeBoolean(option.facesCamera);
        buf.writeInt(option.behavior);
    }, buf -> new RingParticleOptions(buf.readFloat(), buf.readFloat(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readBoolean(), buf.readInt()));
    public static MapCodec<RingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("yaw").forGetter(p -> Float.valueOf(p.yaw)), (App)Codec.FLOAT.fieldOf("pitch").forGetter(p -> Float.valueOf(p.pitch)), (App)Codec.INT.fieldOf("duration").forGetter(p -> p.duration), (App)Codec.INT.fieldOf("r").forGetter(p -> p.r), (App)Codec.INT.fieldOf("g").forGetter(p -> p.g), (App)Codec.INT.fieldOf("b").forGetter(p -> p.b), (App)Codec.FLOAT.fieldOf("a").forGetter(p -> Float.valueOf(p.a)), (App)Codec.FLOAT.fieldOf("scale").forGetter(p -> Float.valueOf(p.scale)), (App)Codec.BOOL.fieldOf("facescamera").forGetter(p -> p.facesCamera), (App)Codec.INT.fieldOf("behavior").forGetter(p -> p.behavior)).apply((Applicative)object, RingParticleOptions::new));

    @NotNull
    public ParticleType<RingParticleOptions> getType() {
        return (ParticleType)ModParticle.RING.get();
    }
}

