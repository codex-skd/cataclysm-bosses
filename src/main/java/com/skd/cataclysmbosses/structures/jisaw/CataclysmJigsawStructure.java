/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.util.valueproviders.ConstantInt
 *  net.minecraft.util.valueproviders.IntProvider
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.WorldGenerationContext
 *  net.minecraft.world.level.levelgen.WorldgenRandom
 *  net.minecraft.world.level.levelgen.heightproviders.HeightProvider
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationStub
 *  net.minecraft.world.level.levelgen.structure.Structure$StructureSettings
 *  net.minecraft.world.level.levelgen.structure.StructureType
 *  net.minecraft.world.level.levelgen.structure.TerrainAdjustment
 *  net.minecraft.world.level.levelgen.structure.pools.DimensionPadding
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
 *  net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.cataclysmbosses.structures.jisaw;

import com.skd.cataclysmbosses.init.ModStructures;
import com.skd.cataclysmbosses.structures.jisaw.CataclysmJigsawManager;
import com.skd.cataclysmbosses.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.skd.cataclysmbosses.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import org.jetbrains.annotations.NotNull;

public class CataclysmJigsawStructure
extends Structure {
    public static final int MAX_TOTAL_STRUCTURE_RADIUS = 192;
    public static final MapCodec<CataclysmJigsawStructure> CODEC = RecordCodecBuilder.<CataclysmJigsawStructure>mapCodec(builder -> builder.group(CataclysmJigsawStructure.settingsCodec(builder), StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool), Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName), Codec.intRange(0, 128).fieldOf("size").forGetter(structure -> structure.maxDepth), HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight), IntProviders.codec(0, 15).optionalFieldOf("x_offset_in_chunk", ConstantInt.of(0)).forGetter(structure -> structure.xOffsetInChunk), IntProviders.codec(0, 15).optionalFieldOf("z_offset_in_chunk", ConstantInt.of(0)).forGetter(structure -> structure.zOffsetInChunk), Codec.BOOL.optionalFieldOf("use_expansion_hack", false).forGetter(structure -> structure.useExpansionHack), Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap), Codec.intRange(1, 192).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter), Codec.INT.optionalFieldOf("max_y").forGetter(structure -> structure.maxY), Codec.INT.optionalFieldOf("min_y").forGetter(structure -> structure.minY), EnhancedTerrainAdaptationType.ADAPTATION_CODEC.optionalFieldOf("enhanced_terrain_adaptation", EnhancedTerrainAdaptation.NONE).forGetter(structure -> structure.enhancedTerrainAdaptation), DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DimensionPadding.ZERO).forGetter(structure -> structure.dimensionPadding), LiquidSettings.CODEC.optionalFieldOf("liquid_settings", LiquidSettings.APPLY_WATERLOGGING).forGetter(structure -> structure.liquidSettings)).apply(builder, CataclysmJigsawStructure::new)).validate(CataclysmJigsawStructure::validateRange);
    public final Holder<StructureTemplatePool> startPool;
    private final Optional<Identifier> startJigsawName;
    public final int maxDepth;
    public final HeightProvider startHeight;
    public final IntProvider xOffsetInChunk;
    public final IntProvider zOffsetInChunk;
    public final boolean useExpansionHack;
    public final Optional<Heightmap.Types> projectStartToHeightmap;
    public final int maxDistanceFromCenter;
    public final Optional<Integer> maxY;
    public final Optional<Integer> minY;
    public final EnhancedTerrainAdaptation enhancedTerrainAdaptation;
    private final DimensionPadding dimensionPadding;
    private final LiquidSettings liquidSettings;

    public CataclysmJigsawStructure(Structure.StructureSettings structureSettings, Holder<StructureTemplatePool> startPool, Optional<Identifier> startJigsawName, int maxDepth, HeightProvider startHeight, IntProvider xOffsetInChunk, IntProvider zOffsetInChunk, boolean useExpansionHack, Optional<Heightmap.Types> projectStartToHeightmap, int maxBlockDistanceFromCenter, Optional<Integer> maxY, Optional<Integer> minY, EnhancedTerrainAdaptation enhancedTerrainAdaptation, DimensionPadding dimensionPadding, LiquidSettings liquidSettings) {
        super(structureSettings);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.maxDepth = maxDepth;
        this.startHeight = startHeight;
        this.xOffsetInChunk = xOffsetInChunk;
        this.zOffsetInChunk = zOffsetInChunk;
        this.useExpansionHack = useExpansionHack;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxBlockDistanceFromCenter;
        this.maxY = maxY;
        this.minY = minY;
        this.enhancedTerrainAdaptation = enhancedTerrainAdaptation;
        this.dimensionPadding = dimensionPadding;
        this.liquidSettings = liquidSettings;
    }

    private static DataResult<CataclysmJigsawStructure> validateRange(CataclysmJigsawStructure structure) {
        int vanillaEdgeBuffer;
        if (structure.terrainAdaptation() != TerrainAdjustment.NONE && structure.enhancedTerrainAdaptation != EnhancedTerrainAdaptation.NONE) {
            return DataResult.error(() -> "Cataclysm Structure cannot use both vanilla terrain_adaptation and enhanced_terrain_adaptation");
        }
        switch (structure.terrainAdaptation()) {
            default: {
                throw new MatchException(null, null);
            }
            case NONE: {
                vanillaEdgeBuffer = 0;
                break;
            }
            case BURY:
            case BEARD_THIN:
            case BEARD_BOX:
            case ENCAPSULATE: {
                vanillaEdgeBuffer = 12;
            }
        }
        if (structure.maxDistanceFromCenter + vanillaEdgeBuffer > 192) {
            return DataResult.error(() -> "Cataclysm Structure's max_distance_from_center must not exceed 116 when using vanilla terrain_adaptation");
        }
        int enhancedEdgeBuffer = structure.enhancedTerrainAdaptation.getKernelRadius();
        if (structure.maxDistanceFromCenter + enhancedEdgeBuffer > 192) {
            return DataResult.error(() -> "Cataclysm Structure's max_distance_from_center + kernel radius (equal to half the enhanced_terrain_adaptation's kernel size) must not exceed 128");
        }
        return DataResult.success(structure);
    }

    @NotNull
    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        WorldgenRandom randomSource = context.random();
        int xOffset = this.xOffsetInChunk.sample((RandomSource)randomSource);
        int zOffset = this.zOffsetInChunk.sample((RandomSource)randomSource);
        int startY = this.startHeight.sample((RandomSource)context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
        BlockPos startPos = new BlockPos(chunkPos.getBlockX(xOffset), startY, chunkPos.getBlockZ(zOffset));
        return CataclysmJigsawManager.assembleJigsawStructure(context, this.startPool, this.startJigsawName, this.maxDepth, startPos, this.useExpansionHack, this.projectStartToHeightmap, this.maxDistanceFromCenter, this.maxY, this.minY, this.dimensionPadding, this.liquidSettings);
    }

    @NotNull
    public BoundingBox adjustBoundingBox(@NotNull BoundingBox boundingBox) {
        return super.adjustBoundingBox(boundingBox).inflatedBy(this.enhancedTerrainAdaptation.getKernelRadius());
    }

    @NotNull
    public StructureType<?> type() {
        return (StructureType)ModStructures.CATACLYSM_JIGSAW.get();
    }
}

