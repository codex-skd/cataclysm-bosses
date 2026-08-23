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

public record LightningParticleOptions(int r, int g, int b) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, LightningParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeInt(option.r);
        buf.writeInt(option.g);
        buf.writeInt(option.b);
    }, buf -> new LightningParticleOptions(buf.readInt(), buf.readInt(), buf.readInt()));
    public static MapCodec<LightningParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.INT.fieldOf("r").forGetter(p -> p.r), (App)Codec.INT.fieldOf("g").forGetter(p -> p.g), (App)Codec.INT.fieldOf("b").forGetter(p -> p.b)).apply((Applicative)object, LightningParticleOptions::new));

    @NotNull
    public ParticleType<LightningParticleOptions> getType() {
        return (ParticleType)ModParticle.LIGHTNING.get();
    }
}

