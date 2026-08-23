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

public record RoarParticleOptions(int duration, int r, int g, int b, float a, float startsize, float increase, float endsize) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, RoarParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeInt(option.duration);
        buf.writeInt(option.r);
        buf.writeInt(option.g);
        buf.writeInt(option.b);
        buf.writeFloat(option.a);
        buf.writeFloat(option.startsize);
        buf.writeFloat(option.increase);
        buf.writeFloat(option.endsize);
    }, buf -> new RoarParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<RoarParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.INT.fieldOf("duration").forGetter(p -> p.duration), (App)Codec.INT.fieldOf("r").forGetter(p -> p.r), (App)Codec.INT.fieldOf("g").forGetter(p -> p.g), (App)Codec.INT.fieldOf("b").forGetter(p -> p.b), (App)Codec.FLOAT.fieldOf("a").forGetter(p -> Float.valueOf(p.a)), (App)Codec.FLOAT.fieldOf("startsize").forGetter(p -> Float.valueOf(p.startsize)), (App)Codec.FLOAT.fieldOf("increase").forGetter(p -> Float.valueOf(p.increase)), (App)Codec.FLOAT.fieldOf("endsize").forGetter(p -> Float.valueOf(p.endsize))).apply((Applicative)object, RoarParticleOptions::new));

    @NotNull
    public ParticleType<RoarParticleOptions> getType() {
        return (ParticleType)ModParticle.ROAR.get();
    }
}

