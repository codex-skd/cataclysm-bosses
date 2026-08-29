/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.datafixers.util.Either
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.Decoder
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.levelgen.LegacyRandomSource
 *  net.minecraft.world.level.levelgen.WorldgenRandom
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.minecraft.world.phys.AABB
 */
package com.skd.cataclysmbosses.world.structures.action;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.structures.jisaw.PieceEntry;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.skd.cataclysmbosses.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.skd.cataclysmbosses.util.BoxOctree;
import com.skd.cataclysmbosses.world.structures.action.StructureAction;
import com.skd.cataclysmbosses.world.structures.action.StructureActionType;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.AABB;

public class TransformAction
extends StructureAction {
    private static final Codec<Either<Identifier, StructureTemplate>> TEMPLATE_CODEC = Codec.of(TransformAction::encodeTemplate, Identifier.CODEC.map(Either::left));
    public static final MapCodec<TransformAction> CODEC = RecordCodecBuilder.mapCodec(builder -> builder.group(TEMPLATE_CODEC.listOf().fieldOf("output").forGetter(action -> action.output), Codec.INT.optionalFieldOf("x_offset", 0).forGetter(action -> action.xOffset), Codec.INT.optionalFieldOf("y_offset", 0).forGetter(action -> action.yOffset), Codec.INT.optionalFieldOf("z_offset", 0).forGetter(action -> action.zOffset)).apply(builder, TransformAction::new));
    private final List<Either<Identifier, StructureTemplate>> output;
    private final int xOffset;
    private final int yOffset;
    private final int zOffset;

    private static <T> DataResult<T> encodeTemplate(Either<Identifier, StructureTemplate> either, DynamicOps<T> ops, T data) {
        return either.left().isEmpty() ? DataResult.error(() -> "cataclysm - Cannot serialize a runtime pool element") : Identifier.CODEC.encode(either.left().get(), ops, data);
    }

    public TransformAction(List<Either<Identifier, StructureTemplate>> output, int xOffset, int yOffset, int zOffset) {
        this.output = output;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
    }

    @Override
    public StructureActionType<?> type() {
        return StructureActionType.TRANSFORM;
    }

    @Override
    public void apply(StructureContext ctx, PieceEntry targetPieceEntry) {
        StructureTemplateManager templateManager = ctx.structureTemplateManager();
        if (templateManager == null) {
            Cataclysm.LOGGER.error("Missing required field 'structureTemplateManager' for transform action!");
            return;
        }
        CataclysmJigsawSinglePoolElement old = (CataclysmJigsawSinglePoolElement)targetPieceEntry.getPiece().getElement();
        WorldgenRandom rand = new WorldgenRandom((RandomSource)new LegacyRandomSource(0L));
        rand.setFeatureSeed((long)targetPieceEntry.getPiece().getPosition().getX(), targetPieceEntry.getPiece().getPosition().getY(), targetPieceEntry.getPiece().getPosition().getX());
        Either<Identifier, StructureTemplate> newTemplate = this.output.get(rand.nextInt(this.output.size()));
        CataclysmJigsawSinglePoolElement newElement = new CataclysmJigsawSinglePoolElement(newTemplate, old.processors, old.getProjection(), old.overrideLiquidSettings, old.name, old.maxCount, old.minRequiredDepth, old.maxPossibleDepth, old.isPriority, old.ignoreBounds, old.condition, old.enhancedTerrainAdaptation, old.deadendPool, old.modifiers);
        BlockPos offset = new BlockPos(this.xOffset, this.yOffset, this.zOffset);
        offset = offset.rotate(targetPieceEntry.getPiece().getRotation());
        BlockPos newPos = targetPieceEntry.getPiece().getPosition().offset((Vec3i)offset);
        BoundingBox newBoundingBox = newElement.getBoundingBox(templateManager, newPos, targetPieceEntry.getPiece().getRotation());
        AABB newAabb = AABB.of((BoundingBox)newBoundingBox);
        ((BoxOctree)targetPieceEntry.getBoxOctree().getValue()).removeBox(targetPieceEntry.getPieceAabb());
        ((BoxOctree)targetPieceEntry.getBoxOctree().getValue()).addBox(newAabb);
        PoolElementStructurePiece newPiece = new PoolElementStructurePiece(templateManager, (StructurePoolElement)newElement, newPos, targetPieceEntry.getPiece().getGroundLevelDelta(), targetPieceEntry.getPiece().getRotation(), newBoundingBox, old.overrideLiquidSettings.orElse(LiquidSettings.APPLY_WATERLOGGING));
        targetPieceEntry.setPiece(newPiece);
    }
}

