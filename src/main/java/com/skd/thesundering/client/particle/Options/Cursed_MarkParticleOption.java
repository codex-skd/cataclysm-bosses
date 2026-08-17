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

public record Cursed_MarkParticleOption(float size) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, Cursed_MarkParticleOption> STREAM_CODEC = StreamCodec.of((buf, option) -> buf.writeFloat(option.size), buf -> new Cursed_MarkParticleOption(buf.readFloat()));
    public static MapCodec<Cursed_MarkParticleOption> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("size").forGetter(p -> Float.valueOf(p.size))).apply((Applicative)object, Cursed_MarkParticleOption::new));

    @NotNull
    public ParticleType<Cursed_MarkParticleOption> getType() {
        return (ParticleType)ModParticle.CURSED_MARK.get();
    }
}

