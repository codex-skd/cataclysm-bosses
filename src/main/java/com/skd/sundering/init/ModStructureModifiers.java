/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.resources.ResourceKey
 *  net.neoforged.neoforge.common.world.StructureModifier
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.NeoForgeRegistries$Keys
 */
package com.skd.sundering.init;

import com.skd.sundering.world.CMMobSpawnStructureModifier;
import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.StructureModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModStructureModifiers {
    public static final DeferredRegister<MapCodec<? extends StructureModifier>> STRUCTURE_MODIFIER_SERIALIZERS = DeferredRegister.create((ResourceKey)NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, (String)"cataclysm");
    public static final DeferredHolder<MapCodec<? extends StructureModifier>, MapCodec<CMMobSpawnStructureModifier>> ADD_SPAWNS_STRUCTURE_MODIFIER_TYPE = STRUCTURE_MODIFIER_SERIALIZERS.register("cataclysm_structure_spawns", () -> MapCodec.unit((Object)CMMobSpawnStructureModifier.INSTANCE));
}

