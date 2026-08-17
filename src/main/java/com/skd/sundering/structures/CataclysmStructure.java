/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.biome.Biome
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationStub
 *  net.minecraft.world.level.levelgen.structure.Structure$StructureSettings
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder
 */
package com.skd.sundering.structures;

import java.util.Optional;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

public abstract class CataclysmStructure
extends Structure {
    private Set<Holder<Biome>> allowedBiomes;
    private boolean doCheckHeight;
    private boolean doAvoidWater;
    private boolean doAvoidStructures;

    public CataclysmStructure(Structure.StructureSettings settings, Set<Holder<Biome>> allowedBiomes, boolean doCheckHeight, boolean doAvoidWater, boolean doAvoidStructures) {
        super(settings);
        this.allowedBiomes = allowedBiomes;
        this.doCheckHeight = doCheckHeight;
        this.doAvoidWater = doAvoidWater;
        this.doAvoidStructures = doAvoidStructures;
    }

    public CataclysmStructure(Structure.StructureSettings settings, Set<Holder<Biome>> allowedBiomes) {
        this(settings, allowedBiomes, true, true, true);
    }

    public CataclysmStructure(Structure.StructureSettings settings) {
        super(settings);
    }

    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {
        if (this.checkLocation(context)) {
            return CataclysmStructure.onTopOfChunkCenter((Structure.GenerationContext)context, (Heightmap.Types)Heightmap.Types.WORLD_SURFACE_WG, builder -> this.generatePieces((StructurePiecesBuilder)builder, context));
        }
        return Optional.empty();
    }

    public void generatePieces(StructurePiecesBuilder builder, Structure.GenerationContext context) {
    }

    public boolean checkLocation(Structure.GenerationContext context) {
        return this.checkLocation(context, this.allowedBiomes, this.doCheckHeight, this.doAvoidWater, this.doAvoidStructures);
    }

    protected boolean checkLocation(Structure.GenerationContext context, Set<Holder<Biome>> allowedBiomes, boolean checkHeight, boolean avoidWater, boolean avoidStructures) {
        ChunkPos chunkPos = context.chunkPos();
        BlockPos centerOfChunk = new BlockPos((chunkPos.x << 4) + 7, 0, (chunkPos.z << 4) + 7);
        if (avoidWater) {
            ChunkGenerator chunkGenerator = context.chunkGenerator();
            LevelHeightAccessor heightLimitView = context.heightAccessor();
            int centerHeight = chunkGenerator.getBaseHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightLimitView, context.randomState());
            NoiseColumn columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ(), heightLimitView, context.randomState());
            BlockState topBlock = columnOfBlocks.getBlock(centerHeight);
            if (!topBlock.getFluidState().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }
}

