/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.ByteBufCodecs
 *  net.minecraft.network.codec.StreamCodec
 */
package com.skd.cataclysmbosses.items.Components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ChargeAnimationComponent(int UseTime, int PrevUseTime) {
    public static final ChargeAnimationComponent EMPTY = new ChargeAnimationComponent(0, 0);
    public static final Codec<ChargeAnimationComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.optionalFieldOf("UseTime", 0).forGetter(ChargeAnimationComponent::UseTime), Codec.INT.optionalFieldOf("PrevUseTime", 0).forGetter(ChargeAnimationComponent::PrevUseTime)).apply(instance, ChargeAnimationComponent::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, ChargeAnimationComponent> STREAM_CODEC = StreamCodec.composite((StreamCodec)ByteBufCodecs.INT, ChargeAnimationComponent::UseTime, (StreamCodec)ByteBufCodecs.INT, ChargeAnimationComponent::PrevUseTime, ChargeAnimationComponent::new);

    public ChargeAnimationComponent tryAddDose(int use, int prevUseTime) {
        return new ChargeAnimationComponent(use, prevUseTime);
    }
}

