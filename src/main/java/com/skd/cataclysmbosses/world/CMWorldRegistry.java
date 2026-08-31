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
package com.skd.cataclysmbosses.world;

import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModTag;
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
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.DeeplingSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING.get(), 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_ANGLER.get(), 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingBruteSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.DeeplingBruteSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_BRUTE.get(), 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingPriestSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.DeeplingPriestSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_PRIEST.get(), 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.DEEPLING_WARLOCK.get(), 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.CoralgolemSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.CoralgolemSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.CORAL_GOLEM.get(), 1, 1));
        }
        if (biome.is(ModTag.AMETHYST_CRAB_SPAWN) && CMCommonConfig.Spawning.AmethystCrabSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.AmethystCrabSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.AMETHYST_CRAB.get(), 1, 1));
        }
        if (biome.is(ModTag.KOBOLETON_SPAWN) && CMCommonConfig.Spawning.KoboletonSpawnWeight > 0) {
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, CMCommonConfig.Spawning.KoboletonSpawnWeight, new MobSpawnSettings.SpawnerData((EntityType)ModEntities.KOBOLETON.get(), 2, 3));
        }
    }

    public static void modifyStructure(Holder<Structure> structure, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (structure.is(ModTag.BERSERKER_SPAWN) && CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight > 0) {
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData((EntityType)ModEntities.IGNITED_BERSERKER.get(), 1, 1), CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight);
        }
    }
}

