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

public record ParryParticleOptions(float r, float g, float b) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, ParryParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.r);
        buf.writeFloat(option.g);
        buf.writeFloat(option.b);
    }, buf -> new ParryParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<ParryParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("r").forGetter(p -> Float.valueOf(p.r)), (App)Codec.FLOAT.fieldOf("g").forGetter(p -> Float.valueOf(p.g)), (App)Codec.FLOAT.fieldOf("b").forGetter(p -> Float.valueOf(p.b))).apply((Applicative)object, ParryParticleOptions::new));

    @NotNull
    public ParticleType<ParryParticleOptions> getType() {
        return (ParticleType)ModParticle.PARRY.get();
    }
}

