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

public record IgnisSoulSwingParticleOptions(int lifetime, float scale, float yaw, float pitch, float roll) implements ParticleOptions
{
    public static StreamCodec<? super ByteBuf, IgnisSoulSwingParticleOptions> STREAM_CODEC = StreamCodec.of((buf, option) -> {
        buf.writeInt(option.lifetime);
        buf.writeFloat(option.scale);
        buf.writeFloat(option.yaw);
        buf.writeFloat(option.pitch);
        buf.writeFloat(option.roll);
    }, buf -> new IgnisSoulSwingParticleOptions(buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat()));
    public static MapCodec<IgnisSoulSwingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object -> object.group((App)Codec.INT.fieldOf("lifetime").forGetter(p -> p.lifetime), (App)Codec.FLOAT.fieldOf("scale").forGetter(p -> Float.valueOf(p.scale)), (App)Codec.FLOAT.fieldOf("yaw").forGetter(p -> Float.valueOf(p.yaw)), (App)Codec.FLOAT.fieldOf("pitch").forGetter(p -> Float.valueOf(p.pitch)), (App)Codec.FLOAT.fieldOf("roll").forGetter(p -> Float.valueOf(p.roll))).apply((Applicative)object, IgnisSoulSwingParticleOptions::new));

    @NotNull
    public ParticleType<IgnisSoulSwingParticleOptions> getType() {
        return (ParticleType)ModParticle.IGNIS_SOUL_SWING.get();
    }
}

