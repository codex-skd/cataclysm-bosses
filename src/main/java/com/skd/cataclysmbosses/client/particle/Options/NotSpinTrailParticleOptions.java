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

public record NotSpinTrailParticleOptions(float r, float g, float b, float gravity, float reduction, float acceleration, double direction, int life) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, NotSpinTrailParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.r);
        buf.writeFloat(option.g);
        buf.writeFloat(option.b);
        buf.writeFloat(option.gravity);
        buf.writeFloat(option.reduction);
        buf.writeFloat(option.acceleration);
        buf.writeDouble(option.direction);
        buf.writeInt(option.life);
    }, buf -> new NotSpinTrailParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readInt()));
    public static MapCodec<NotSpinTrailParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("r").forGetter(p -> Float.valueOf(p.r)), (App)Codec.FLOAT.fieldOf("g").forGetter(p -> Float.valueOf(p.g)), (App)Codec.FLOAT.fieldOf("b").forGetter(p -> Float.valueOf(p.b)), (App)Codec.FLOAT.fieldOf("gravity").forGetter(p -> Float.valueOf(p.gravity)), (App)Codec.FLOAT.fieldOf("reduction").forGetter(p -> Float.valueOf(p.reduction)), (App)Codec.FLOAT.fieldOf("acceleration").forGetter(p -> Float.valueOf(p.acceleration)), (App)Codec.DOUBLE.fieldOf("direction").forGetter(p -> p.direction), (App)Codec.INT.fieldOf("life").forGetter(p -> p.life)).apply((Applicative)object, NotSpinTrailParticleOptions::new));

    @NotNull
    public ParticleType<NotSpinTrailParticleOptions> getType() {
        return (ParticleType)ModParticle.NOT_SPIN_PARTICLE.get();
    }
}

