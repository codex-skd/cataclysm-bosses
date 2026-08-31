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
package com.skd.cataclysmbosses.client.particle.Options;

import com.skd.cataclysmbosses.init.ModParticle;
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

public record IgnisSwingParticleOptions(int lifetime, float scale, float yaw, float pitch, float roll) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, IgnisSwingParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeInt(option.lifetime);
        buf.writeFloat(option.scale);
        buf.writeFloat(option.yaw);
        buf.writeFloat(option.pitch);
        buf.writeFloat(option.roll);
    }, buf -> new IgnisSwingParticleOptions(buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<IgnisSwingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group(Codec.INT.fieldOf("lifetime").forGetter(p -> p.lifetime), Codec.FLOAT.fieldOf("scale").forGetter(p -> Float.valueOf(p.scale)), Codec.FLOAT.fieldOf("yaw").forGetter(p -> Float.valueOf(p.yaw)), Codec.FLOAT.fieldOf("pitch").forGetter(p -> Float.valueOf(p.pitch)), Codec.FLOAT.fieldOf("roll").forGetter(p -> Float.valueOf(p.roll))).apply(object, IgnisSwingParticleOptions::new));

    @NotNull
    public ParticleType<IgnisSwingParticleOptions> getType() {
        return (ParticleType)ModParticle.IGNIS_SWING.get();
    }
}

