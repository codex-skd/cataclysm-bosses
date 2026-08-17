/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.datafixers.util.Either
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.Decoder
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  javax.annotation.ParametersAreNonnullByDefault
 *  net.minecraft.MethodsReturnNonnullByDefault
 *  net.minecraft.Util
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.properties.StructureMode
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool$Projection
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.JigsawReplacementProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 */
package com.skd.thesundering.structures.jisaw.element;

import com.skd.thesundering.init.ModJigsaw;
import com.skd.thesundering.structures.jisaw.condition.StructureCondition;
import com.skd.thesundering.structures.jisaw.element.CataclysmJigsawPoolElement;
import com.skd.thesundering.world.structures.modifier.StructureModifier;
import com.skd.thesundering.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.google.common.collect.Lists;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.JigsawReplacementProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CataclysmJigsawSinglePoolElement
extends CataclysmJigsawPoolElement {
    private static final Codec<Either<Identifier, StructureTemplate>> TEMPLATE_CODEC = Codec.of(CataclysmJigsawSinglePoolElement::encodeTemplate, (Decoder)Identifier.CODEC.map(Either::left));
    public static final MapCodec<CataclysmJigsawSinglePoolElement> CODEC = RecordCodecBuilder.mapCodec(builder -> builder.group(CataclysmJigsawSinglePoolElement.templateCodec(), CataclysmJigsawSinglePoolElement.processorsCodec(), (App)CataclysmJigsawSinglePoolElement.projectionCodec(), CataclysmJigsawSinglePoolElement.overrideLiquidSettingsCodec(), CataclysmJigsawSinglePoolElement.nameCodec(), CataclysmJigsawSinglePoolElement.maxCountCodec(), CataclysmJigsawSinglePoolElement.minRequiredDepthCodec(), CataclysmJigsawSinglePoolElement.maxPossibleDepthCodec(), CataclysmJigsawSinglePoolElement.isPriorityCodec(), CataclysmJigsawSinglePoolElement.ignoreBoundsCodec(), CataclysmJigsawSinglePoolElement.conditionCodec(), CataclysmJigsawSinglePoolElement.enhancedTerrainAdaptationCodec(), (App)Identifier.CODEC.optionalFieldOf("deadend_pool").forGetter(element -> element.deadendPool), (App)StructureModifier.CODEC.listOf().optionalFieldOf("modifiers", new ArrayList()).forGetter(element -> element.modifiers)).apply((Applicative)builder, CataclysmJigsawSinglePoolElement::new));
    public final Either<Identifier, StructureTemplate> template;
    public final Holder<StructureProcessorList> processors;
    public final Optional<LiquidSettings> overrideLiquidSettings;
    public final Optional<Identifier> deadendPool;
    public final List<StructureModifier> modifiers;

    public CataclysmJigsawSinglePoolElement(Either<Identifier, StructureTemplate> template, Holder<StructureProcessorList> processors, StructureTemplatePool.Projection projection, Optional<LiquidSettings> overrideLiquidSettings, Optional<String> name, Optional<Integer> maxCount, Optional<Integer> minRequiredDepth, Optional<Integer> maxPossibleDepth, boolean isPriority, boolean ignoreBounds, StructureCondition condition, Optional<EnhancedTerrainAdaptation> enhancedTerrainAdaptation, Optional<Identifier> deadendPool, List<StructureModifier> modifiers) {
        super(projection, name, maxCount, minRequiredDepth, maxPossibleDepth, isPriority, ignoreBounds, condition, enhancedTerrainAdaptation);
        this.template = template;
        this.processors = processors;
        this.overrideLiquidSettings = overrideLiquidSettings;
        this.deadendPool = deadendPool;
        this.modifiers = modifiers;
    }

    public Vec3i getSize(StructureTemplateManager structureTemplateManager, Rotation rotation) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        return structureTemplate.getSize(rotation);
    }

    public List<StructureTemplate.StructureBlockInfo> getShuffledJigsawBlocks(StructureTemplateManager structureTemplateManager, BlockPos blockPos, Rotation rotation, RandomSource randomSource) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        ObjectArrayList jigsawBlocks = structureTemplate.filterBlocks(blockPos, new StructurePlaceSettings().setRotation(rotation), Blocks.JIGSAW, true);
        Util.shuffle((List)jigsawBlocks, (RandomSource)randomSource);
        return jigsawBlocks;
    }

    public BoundingBox getBoundingBox(StructureTemplateManager structureTemplateManager, BlockPos blockPos, Rotation rotation) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        return structureTemplate.getBoundingBox(new StructurePlaceSettings().setRotation(rotation), blockPos);
    }

    public boolean place(StructureTemplateManager structureTemplateManager, WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, BlockPos pos, BlockPos pivotPos, Rotation rotation, BoundingBox boundingBox, RandomSource randomSource, LiquidSettings liquidSettings, boolean replaceJigsaws) {
        StructurePlaceSettings structurePlaceSettings;
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        if (!structureTemplate.placeInWorld((ServerLevelAccessor)worldGenLevel, pos, pivotPos, structurePlaceSettings = this.getSettings(rotation, boundingBox, liquidSettings, replaceJigsaws), randomSource, 18)) {
            return false;
        }
        for (StructureTemplate.StructureBlockInfo structureBlockInfo : StructureTemplate.processBlockInfos((ServerLevelAccessor)worldGenLevel, (BlockPos)pos, (BlockPos)pivotPos, (StructurePlaceSettings)structurePlaceSettings, this.getDataMarkers(structureTemplateManager, pos, rotation, false))) {
            this.handleDataMarker((LevelAccessor)worldGenLevel, structureBlockInfo, pos, rotation, randomSource, boundingBox);
        }
        return true;
    }

    public Optional<Identifier> getDeadendPool() {
        return this.deadendPool;
    }

    public boolean hasModifiers() {
        return !this.modifiers.isEmpty();
    }

    public StructureTemplate getTemplate(StructureTemplateManager structureTemplateManager) {
        return (StructureTemplate)this.template.map(arg_0 -> ((StructureTemplateManager)structureTemplateManager).getOrCreate(arg_0), Function.identity());
    }

    public StructurePoolElementType<?> getType() {
        return (StructurePoolElementType)ModJigsaw.CATACLYSM_ELEMENT.get();
    }

    public String toString() {
        return String.format("YungJigsawSingle[%s][%s][%s][%s]", this.name.orElse("<unnamed>"), this.template, this.maxCount.isPresent() ? this.maxCount.get() : "no max count", this.isPriority);
    }

    private StructurePlaceSettings getSettings(Rotation rotation, BoundingBox boundingBox, LiquidSettings liquidSettings, boolean replaceJigsaws) {
        StructurePlaceSettings structurePlaceSettings = new StructurePlaceSettings();
        structurePlaceSettings.setBoundingBox(boundingBox);
        structurePlaceSettings.setRotation(rotation);
        structurePlaceSettings.setKnownShape(true);
        structurePlaceSettings.setIgnoreEntities(false);
        structurePlaceSettings.addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_BLOCK);
        structurePlaceSettings.setFinalizeEntities(true);
        structurePlaceSettings.setLiquidSettings(this.overrideLiquidSettings.orElse(liquidSettings));
        if (!replaceJigsaws) {
            structurePlaceSettings.addProcessor((StructureProcessor)JigsawReplacementProcessor.INSTANCE);
        }
        ((StructureProcessorList)this.processors.value()).list().forEach(arg_0 -> ((StructurePlaceSettings)structurePlaceSettings).addProcessor(arg_0));
        this.getProjection().getProcessors().forEach(arg_0 -> ((StructurePlaceSettings)structurePlaceSettings).addProcessor(arg_0));
        return structurePlaceSettings;
    }

    private List<StructureTemplate.StructureBlockInfo> getDataMarkers(StructureTemplateManager structureTemplateManager, BlockPos blockPos, Rotation rotation, boolean isPositionLocal) {
        StructureTemplate structureTemplate = this.getTemplate(structureTemplateManager);
        ObjectArrayList structureBlocks = structureTemplate.filterBlocks(blockPos, new StructurePlaceSettings().setRotation(rotation), Blocks.STRUCTURE_BLOCK, isPositionLocal);
        ArrayList dataBlocks = Lists.newArrayList();
        for (StructureTemplate.StructureBlockInfo block : structureBlocks) {
            StructureMode structureMode = StructureMode.valueOf((String)block.nbt().getString("mode"));
            if (structureMode != StructureMode.DATA) continue;
            dataBlocks.add(block);
        }
        return dataBlocks;
    }

    public static <E extends CataclysmJigsawSinglePoolElement> RecordCodecBuilder<E, Holder<StructureProcessorList>> processorsCodec() {
        return StructureProcessorType.LIST_CODEC.fieldOf("processors").forGetter(element -> element.processors);
    }

    public static <E extends CataclysmJigsawSinglePoolElement> RecordCodecBuilder<E, Either<Identifier, StructureTemplate>> templateCodec() {
        return TEMPLATE_CODEC.fieldOf("location").forGetter(element -> element.template);
    }

    public static <E extends CataclysmJigsawSinglePoolElement> RecordCodecBuilder<E, Optional<LiquidSettings>> overrideLiquidSettingsCodec() {
        return LiquidSettings.CODEC.optionalFieldOf("override_liquid_settings").forGetter(element -> element.overrideLiquidSettings);
    }

    private static <T> DataResult<T> encodeTemplate(Either<Identifier, StructureTemplate> either, DynamicOps<T> ops, T template) {
        Optional optional = either.left();
        return !optional.isPresent() ? DataResult.error(() -> "Can not serialize a runtime pool element") : Identifier.CODEC.encode((Object)((Identifier)optional.get()), ops, template);
    }
}

