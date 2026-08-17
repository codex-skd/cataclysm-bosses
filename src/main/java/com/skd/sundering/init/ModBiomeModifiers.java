/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.resources.ResourceKey
 *  net.neoforged.neoforge.common.world.BiomeModifier
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 */
package com.skd.sundering.init;

import com.skd.sundering.world.CMMobSpawnBiomeModifier;
import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create((ResourceKey)NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, (String)"cataclysm");
    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<CMMobSpawnBiomeModifier>> CM_MOB_SPAWN_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("cataclysm_mob_spawns", () -> MapCodec.unit((Object)CMMobSpawnBiomeModifier.INSTANCE));
}

