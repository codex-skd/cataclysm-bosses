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

public record AfterImageParticleOptions(int entityid, int r, int g, int b, boolean ghost, int lifeticks) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, AfterImageParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeInt(option.entityid);
        buf.writeInt(option.r);
        buf.writeInt(option.g);
        buf.writeInt(option.b);
        buf.writeBoolean(option.ghost);
        buf.writeInt(option.lifeticks);
    }, buf -> new AfterImageParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readBoolean(), buf.readInt()));
    public static MapCodec<AfterImageParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group(Codec.INT.fieldOf("entityid").forGetter(p -> p.entityid), Codec.INT.fieldOf("r").forGetter(p -> p.r), Codec.INT.fieldOf("g").forGetter(p -> p.g), Codec.INT.fieldOf("b").forGetter(p -> p.b), Codec.BOOL.fieldOf("ghost").forGetter(p -> p.ghost), Codec.INT.fieldOf("lifeticks").forGetter(p -> p.lifeticks)).apply(object, AfterImageParticleOptions::new));

    @NotNull
    public ParticleType<AfterImageParticleOptions> getType() {
        return (ParticleType)ModParticle.AFTER_IMAGE.get();
    }
}

