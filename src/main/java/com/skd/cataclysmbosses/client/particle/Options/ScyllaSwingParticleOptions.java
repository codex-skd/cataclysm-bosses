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

public record ScyllaSwingParticleOptions(float scale, float yaw, float pitch) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, ScyllaSwingParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.scale);
        buf.writeFloat(option.yaw);
        buf.writeFloat(option.pitch);
    }, buf -> new ScyllaSwingParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<ScyllaSwingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("scale").forGetter(p -> Float.valueOf(p.scale)), (App)Codec.FLOAT.fieldOf("yaw").forGetter(p -> Float.valueOf(p.yaw)), (App)Codec.FLOAT.fieldOf("pitch").forGetter(p -> Float.valueOf(p.pitch))).apply((Applicative)object, ScyllaSwingParticleOptions::new));

    @NotNull
    public ParticleType<ScyllaSwingParticleOptions> getType() {
        return (ParticleType)ModParticle.SCYLLA_SWING.get();
    }
}

