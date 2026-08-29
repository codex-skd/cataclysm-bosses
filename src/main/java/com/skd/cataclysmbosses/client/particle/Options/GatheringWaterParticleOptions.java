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

public record GatheringWaterParticleOptions(float r, float g, float b) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, GatheringWaterParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.r);
        buf.writeFloat(option.g);
        buf.writeFloat(option.b);
    }, buf -> new GatheringWaterParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<GatheringWaterParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group(Codec.FLOAT.fieldOf("r").forGetter(p -> Float.valueOf(p.r)), Codec.FLOAT.fieldOf("g").forGetter(p -> Float.valueOf(p.g)), Codec.FLOAT.fieldOf("b").forGetter(p -> Float.valueOf(p.b))).apply(object, GatheringWaterParticleOptions::new));

    @NotNull
    public ParticleType<GatheringWaterParticleOptions> getType() {
        return (ParticleType)ModParticle.GATHERING_WATER.get();
    }
}

