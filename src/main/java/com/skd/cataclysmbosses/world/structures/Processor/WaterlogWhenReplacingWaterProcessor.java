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
package com.skd.cataclysmbosses.world.structures.Processor;

import com.skd.cataclysmbosses.init.ModStructureProcessor;
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

    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos pos, BlockPos pos2, BlockPos pos3, StructureTemplate.StructureBlockInfo infoIn, StructurePlaceSettings settings) {
        if (infoIn.state().hasProperty((Property)BlockStateProperties.WATERLOGGED)) {
            WorldGenRegion worldGenRegion;
            if (levelReader instanceof WorldGenRegion && !(worldGenRegion = (WorldGenRegion)levelReader).getCenter().equals((Object)new ChunkPos(infoIn.pos()))) {
                return infoIn;
            }
            BlockState blockState = levelReader.getChunk(infoIn.pos()).getBlockState(infoIn.pos());
            boolean isWater = blockState.getFluidState().is(FluidTags.WATER);
            if (isWater) {
                ChunkAccess chunk = levelReader.getChunk(infoIn.pos());
                int minY = chunk.getMinBuildHeight();
                int maxY = chunk.getMaxBuildHeight();
                int currentY = infoIn.pos().getY();
                if (currentY >= minY && currentY <= maxY) {
                    ((LevelAccessor)levelReader).scheduleTick(infoIn.pos(), infoIn.state().getBlock(), 0);
                }
            }
            return new StructureTemplate.StructureBlockInfo(infoIn.pos(), (BlockState)infoIn.state().setValue((Property)BlockStateProperties.WATERLOGGED, (Comparable)Boolean.valueOf(isWater)), infoIn.nbt());
        }
        return infoIn;
    }

    protected StructureProcessorType getType() {
        return ModStructureProcessor.WATERLOGGING_WHEN_REPLACING_WATER_PROCESSOR.get();
    }
}

