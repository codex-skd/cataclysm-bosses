/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.biome.MobSpawnSettings$SpawnerData
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.neoforged.neoforge.common.world.ModifiableBiomeInfo$BiomeInfo$Builder
 *  net.neoforged.neoforge.common.world.ModifiableStructureInfo$StructureInfo$Builder
 */
package com.skd.thesundering.world;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModTag;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.common.world.ModifiableStructureInfo;

public class CMWorldRegistry {
    public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING.get(), CMCommonConfig.Spawning.DeeplingSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_ANGLER.get(), CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingBruteSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_BRUTE.get(), CMCommonConfig.Spawning.DeeplingBruteSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingPriestSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_PRIEST.get(), CMCommonConfig.Spawning.DeeplingPriestSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_WARLOCK.get(), CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.CoralgolemSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.CORAL_GOLEM.get(), CMCommonConfig.Spawning.CoralgolemSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.AMETHYST_CRAB_SPAWN) && CMCommonConfig.Spawning.AmethystCrabSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.AMETHYST_CRAB.get(), CMCommonConfig.Spawning.AmethystCrabSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.KOBOLETON_SPAWN) && CMCommonConfig.Spawning.KoboletonSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.KOBOLETON.get(), CMCommonConfig.Spawning.KoboletonSpawnWeight, 2, 3));
        }
    }

    public static void modifyStructure(Holder<Structure> structure, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (structure.is(ModTag.BERSERKER_SPAWN) && CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight > 0) {
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.IGNITED_BERSERKER.get(), CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight, 1, 1));
        }
    }
}

