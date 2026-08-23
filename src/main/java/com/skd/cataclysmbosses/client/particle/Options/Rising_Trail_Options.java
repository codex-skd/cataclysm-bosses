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

public record Rising_Trail_Options(float r, float g, float b, float width, float indewidth) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, Rising_Trail_Options> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeFloat(option.r);
        buf.writeFloat(option.g);
        buf.writeFloat(option.b);
        buf.writeFloat(option.width);
        buf.writeFloat(option.indewidth);
    }, buf -> new Rising_Trail_Options(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<Rising_Trail_Options> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.FLOAT.fieldOf("r").forGetter(p -> Float.valueOf(p.r)), (App)Codec.FLOAT.fieldOf("g").forGetter(p -> Float.valueOf(p.g)), (App)Codec.FLOAT.fieldOf("b").forGetter(p -> Float.valueOf(p.b)), (App)Codec.FLOAT.fieldOf("width").forGetter(p -> Float.valueOf(p.width)), (App)Codec.FLOAT.fieldOf("indewidth").forGetter(p -> Float.valueOf(p.indewidth))).apply((Applicative)object, Rising_Trail_Options::new));

    @NotNull
    public ParticleType<Rising_Trail_Options> getType() {
        return (ParticleType)ModParticle.RISING_TRAIL.get();
    }
}

