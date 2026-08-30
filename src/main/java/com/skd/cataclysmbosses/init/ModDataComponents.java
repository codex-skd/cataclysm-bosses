/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.core.UUIDUtil
 *  net.minecraft.core.component.DataComponentType
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.RegistryFriendlyByteBuf
 *  net.minecraft.network.codec.ByteBufCodecs
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.resources.ResourceKey
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.items.Components.ChargeAnimationComponent;
import com.mojang.serialization.Codec;
import java.util.UUID;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create((ResourceKey)Registries.DATA_COMPONENT_TYPE, (String)"cataclysm");
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LASER_GATLING = COMPONENTS.register("laser_gatling", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ChargeAnimationComponent>> CHARGE_ANIMATION = COMPONENTS.register("charge_animation", () -> DataComponentType.<ChargeAnimationComponent>builder().persistent(ChargeAnimationComponent.CODEC).networkSynchronized(ChargeAnimationComponent.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> THROWN_ANCHOR = COMPONENTS.register("thrown_anchor", () -> DataComponentType.<UUID>builder().persistent(UUIDUtil.CODEC).networkSynchronized(UUIDUtil.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> THROWN_HAMMER = COMPONENTS.register("thrown_hammer", () -> DataComponentType.<UUID>builder().persistent(UUIDUtil.CODEC).networkSynchronized(UUIDUtil.STREAM_CODEC).build());

    @NotNull
    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, Codec<T> codec) {
        return ModDataComponents.register2(name, codec, null);
    }

    @NotNull
    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register2(String name, Codec<T> codec, @Nullable StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
        if (streamCodec == null) {
            return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).build());
        }
        return COMPONENTS.register(name, () -> DataComponentType.<T>builder().persistent(codec).networkSynchronized(streamCodec).build());
    }
}

