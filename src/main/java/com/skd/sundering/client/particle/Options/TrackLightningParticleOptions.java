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
package com.skd.sundering.client.particle.Options;

import com.skd.sundering.init.ModParticle;
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

public record TrackLightningParticleOptions(int r, int g, int b) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, TrackLightningParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeInt(option.r);
        buf.writeInt(option.g);
        buf.writeInt(option.b);
    }, buf -> new TrackLightningParticleOptions(buf.readInt(), buf.readInt(), buf.readInt()));
    public static MapCodec<TrackLightningParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.INT.fieldOf("r").forGetter(p -> p.r), (App)Codec.INT.fieldOf("g").forGetter(p -> p.g), (App)Codec.INT.fieldOf("b").forGetter(p -> p.b)).apply((Applicative)object, TrackLightningParticleOptions::new));

    @NotNull
    public ParticleType<TrackLightningParticleOptions> getType() {
        return (ParticleType)ModParticle.TRACK_LIGHTNING.get();
    }
}

