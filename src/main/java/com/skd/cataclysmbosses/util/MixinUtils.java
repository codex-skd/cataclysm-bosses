/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Registry
 *  net.minecraft.core.SectionPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.tags.TagKey
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.StructureAccess
 *  net.minecraft.world.level.chunk.status.ChunkStatus
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.StructureStart
 */
package com.skd.cataclysmbosses.util;

import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.StructureAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;

public class MixinUtils {
    public static boolean isPositionInTaggedStructure(WorldGenRegion worldGenRegion, BlockPos pos, TagKey<Structure> structureTagKey) {
        Registry structureRegistry = worldGenRegion.registryAccess().lookupOrThrow(Registries.STRUCTURE);
        SectionPos sectionPos = SectionPos.of((BlockPos)pos);
        ChunkAccess chunkAccess = worldGenRegion.getChunk(sectionPos.x(), sectionPos.z(), ChunkStatus.STRUCTURE_REFERENCES);
        if (!chunkAccess.getHighestGeneratedStatus().isOrAfter(ChunkStatus.STRUCTURE_REFERENCES)) {
            return false;
        }
        Map allReferencesInChunk = chunkAccess.getAllReferences();
        for (Map.Entry entry : allReferencesInChunk.entrySet()) {
            Structure structure = (Structure)entry.getKey();
            LongSet references = (LongSet)entry.getValue();
            Optional structureKey = structureRegistry.getResourceKey((Object)structure);
            boolean isTaggedStructure = structureKey.isPresent() && structureRegistry.getOrThrow((ResourceKey)structureKey.get()).is(structureTagKey);
            if (!isTaggedStructure || !MixinUtils.isAnyReferenceValidStartForStructure(worldGenRegion, structure, references, structureStart -> structureStart.getBoundingBox().isInside((Vec3i)pos))) continue;
            return true;
        }
        return false;
    }

    private static boolean isAnyReferenceValidStartForStructure(WorldGenRegion worldGenRegion, Structure structure, LongSet references, Predicate<StructureStart> filter) {
        StructureManager structureManager = worldGenRegion.getLevel().structureManager();
        LongIterator longIterator = references.iterator();
        while (longIterator.hasNext()) {
            ChunkAccess structureStartChunkAccess;
            StructureStart structureStart;
            long reference = (Long)longIterator.next();
            SectionPos structureStartSectionPos = SectionPos.of((ChunkPos)ChunkPos.unpack(reference), (int)worldGenRegion.getMinSectionY());
            if (!worldGenRegion.hasChunk(structureStartSectionPos.x(), structureStartSectionPos.z()) || (structureStart = structureManager.getStartForStructure(structureStartSectionPos, structure, (StructureAccess)(structureStartChunkAccess = worldGenRegion.getChunk(structureStartSectionPos.x(), structureStartSectionPos.z(), ChunkStatus.STRUCTURE_STARTS)))) == null || !structureStart.isValid() || !filter.test(structureStart)) continue;
            return true;
        }
        return false;
    }
}

