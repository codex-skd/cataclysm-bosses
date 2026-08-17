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

public record RainFogParticleOptions(float size) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, RainFogParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> buf.writeFloat(option.size), buf -> new RainFogParticleOptions(buf.readFloat()));
    public static MapCodec<RainFogParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("size").forGetter(p -> Float.valueOf(p.size))).apply((Applicative)object, RainFogParticleOptions::new));

    @NotNull
    public ParticleType<RainFogParticleOptions> getType() {
        return (ParticleType)ModParticle.RAIN_FOG.get();
    }
}

