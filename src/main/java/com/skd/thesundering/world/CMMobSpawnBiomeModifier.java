/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.Holder
 *  net.minecraft.world.level.biome.Biome
 *  net.neoforged.neoforge.common.world.BiomeModifier
 *  net.neoforged.neoforge.common.world.BiomeModifier$Phase
 *  net.neoforged.neoforge.common.world.ModifiableBiomeInfo$BiomeInfo$Builder
 */
package com.skd.thesundering.world;

import com.skd.thesundering.init.ModBiomeModifiers;
import com.skd.thesundering.world.CMWorldRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

public class CMMobSpawnBiomeModifier
implements BiomeModifier {
    public static final CMMobSpawnBiomeModifier INSTANCE = new CMMobSpawnBiomeModifier();

    public void modify(Holder<Biome> biome, BiomeModifier.Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == BiomeModifier.Phase.ADD) {
            CMWorldRegistry.addBiomeSpawns(biome, builder);
        }
    }

    public MapCodec<? extends BiomeModifier> codec() {
        return (MapCodec)ModBiomeModifiers.CM_MOB_SPAWN_BIOME_MODIFIER_TYPE.get();
    }
}

