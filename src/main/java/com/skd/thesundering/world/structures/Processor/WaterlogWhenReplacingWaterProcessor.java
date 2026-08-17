/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 */
package com.skd.thesundering.world.structures.Processor;

import com.skd.thesundering.init.ModStructureProcessor;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class WaterlogWhenReplacingWaterProcessor
extends StructureProcessor {
    public static final MapCodec<WaterlogWhenReplacingWaterProcessor> CODEC = MapCodec.unit(WaterlogWhenReplacingWaterProcessor::new);

    private WaterlogWhenReplacingWaterProcessor() {
    }

    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos pos, BlockPos pos2, StructureTemplate.StructureBlockInfo infoIn1, StructureTemplate.StructureBlockInfo infoIn2, StructurePlaceSettings settings) {
        if (infoIn2.state().hasProperty((Property)BlockStateProperties.WATERLOGGED)) {
            WorldGenRegion worldGenRegion;
            if (levelReader instanceof WorldGenRegion && !(worldGenRegion = (WorldGenRegion)levelReader).getCenter().equals((Object)new ChunkPos(infoIn2.pos()))) {
                return infoIn2;
            }
            BlockState blockState = levelReader.getChunk(infoIn2.pos()).getBlockState(infoIn2.pos());
            boolean isWater = blockState.getFluidState().is(FluidTags.WATER);
            if (isWater) {
                ChunkAccess chunk = levelReader.getChunk(infoIn2.pos());
                int minY = chunk.getMinBuildHeight();
                int maxY = chunk.getMaxBuildHeight();
                int currentY = infoIn2.pos().getY();
                if (currentY >= minY && currentY <= maxY) {
                    ((LevelAccessor)levelReader).scheduleTick(infoIn2.pos(), infoIn2.state().getBlock(), 0);
                }
            }
            return new StructureTemplate.StructureBlockInfo(infoIn2.pos(), (BlockState)infoIn2.state().setValue((Property)BlockStateProperties.WATERLOGGED, (Comparable)Boolean.valueOf(isWater)), infoIn2.nbt());
        }
        return infoIn2;
    }

    protected StructureProcessorType<?> getType() {
        return (StructureProcessorType)ModStructureProcessor.WATERLOGGING_WHEN_REPLACING_WATER_PROCESSOR.get();
    }
}

