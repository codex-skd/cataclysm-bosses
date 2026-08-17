/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.Util
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Registry
 *  net.minecraft.core.RegistryAccess
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.WorldgenRandom
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationStub
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder
 *  net.minecraft.world.level.levelgen.structure.pools.DimensionPadding
 *  net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
 *  net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.minecraft.world.phys.AABB
 */
package com.skd.sundering.structures.jisaw;

import com.skd.sundering.Cataclysm;
import com.skd.sundering.mixin.accessor.StructureTemplatePoolAccessor;
import com.skd.sundering.structures.jisaw.assembler.JigsawStructureAssembler;
import com.skd.sundering.structures.jisaw.context.StructureContext;
import com.skd.sundering.structures.jisaw.element.CataclysmJigsawPoolElement;
import com.skd.sundering.util.BoxOctree;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.AABB;

public class CataclysmJigsawManager {
    public static Optional<Structure.GenerationStub> assembleJigsawStructure(Structure.GenerationContext generationContext, Holder<StructureTemplatePool> startPool, Optional<Identifier> startJigsawNameOptional, int maxDepth, BlockPos locatePos, boolean useExpansionHack, Optional<Heightmap.Types> projectStartToHeightmap, int maxDistanceFromCenter, Optional<Integer> maxY, Optional<Integer> minY, DimensionPadding dimensionPadding, LiquidSettings liquidSettings) {
        RegistryAccess registryAccess = generationContext.registryAccess();
        Registry registry = registryAccess.registryOrThrow(Registries.TEMPLATE_POOL);
        ChunkGenerator chunkGenerator = generationContext.chunkGenerator();
        StructureTemplateManager structureManager = generationContext.structureTemplateManager();
        LevelHeightAccessor levelHeightAccessor = generationContext.heightAccessor();
        WorldgenRandom worldgenRandom = generationContext.random();
        Optional<PoolElementStructurePiece> startPieceOptional = CataclysmJigsawManager.getStartPiece(startPool, startJigsawNameOptional, locatePos, liquidSettings, generationContext);
        if (startPieceOptional.isEmpty()) {
            return Optional.empty();
        }
        PoolElementStructurePiece startPiece = startPieceOptional.get();
        BlockPos startingPosOffset = locatePos.subtract((Vec3i)startPiece.getPosition());
        BoundingBox pieceBoundingBox = startPiece.getBoundingBox();
        int bbCenterX = (pieceBoundingBox.maxX() + pieceBoundingBox.minX()) / 2;
        int bbCenterZ = (pieceBoundingBox.maxZ() + pieceBoundingBox.minZ()) / 2;
        int bbCenterY = projectStartToHeightmap.map(types -> locatePos.getY() + chunkGenerator.getFirstFreeHeight(bbCenterX, bbCenterZ, types, levelHeightAccessor, generationContext.randomState())).orElseGet(() -> startPiece.getPosition().getY());
        int adjustedPieceCenterY = bbCenterY + startingPosOffset.getY();
        int yAdjustment = pieceBoundingBox.minY() + startPiece.getGroundLevelDelta();
        startPiece.move(0, bbCenterY - yAdjustment, 0);
        AABB aABB = new AABB((double)(bbCenterX - maxDistanceFromCenter), (double)(adjustedPieceCenterY - maxDistanceFromCenter), (double)(bbCenterZ - maxDistanceFromCenter), (double)(bbCenterX + maxDistanceFromCenter + 1), (double)(adjustedPieceCenterY + maxDistanceFromCenter + 1), (double)(bbCenterZ + maxDistanceFromCenter + 1));
        BoxOctree maxStructureBounds = new BoxOctree(aABB);
        maxStructureBounds.addBox(AABB.of((BoundingBox)pieceBoundingBox));
        return Optional.of(new Structure.GenerationStub(new BlockPos(bbCenterX, adjustedPieceCenterY, bbCenterZ), structurePiecesBuilder -> {
            if (maxDepth <= 0) {
                return;
            }
            JigsawStructureAssembler assembler = new JigsawStructureAssembler(new JigsawStructureAssembler.Settings().poolRegistry((Registry<StructureTemplatePool>)registry).maxDepth(maxDepth).chunkGenerator(chunkGenerator).structureTemplateManager(structureManager).randomState(generationContext.randomState()).biomeSource(generationContext.biomeSource()).rand((RandomSource)worldgenRandom).maxY(maxY).minY(minY).useExpansionHack(useExpansionHack).levelHeightAccessor(levelHeightAccessor).dimensionPadding(dimensionPadding).liquidSettings(liquidSettings));
            assembler.assembleStructure(startPiece, maxStructureBounds);
            assembler.addAllPiecesToStructureBuilder((StructurePiecesBuilder)structurePiecesBuilder);
        }));
    }

    private static Optional<PoolElementStructurePiece> getStartPiece(Holder<StructureTemplatePool> startPoolHolder, Optional<Identifier> startJigsawNameOptional, BlockPos locatePos, LiquidSettings liquidSettings, Structure.GenerationContext generationContext) {
        int chosenPieceWeight;
        StructureTemplateManager structureTemplateManager = generationContext.structureTemplateManager();
        WorldgenRandom rand = generationContext.random();
        StructureTemplatePool startPool = (StructureTemplatePool)startPoolHolder.value();
        ObjectArrayList candidatePoolElements = new ObjectArrayList(((StructureTemplatePoolAccessor)startPool).getRawTemplates());
        Util.shuffle((List)candidatePoolElements, (RandomSource)rand);
        Rotation rotation = Rotation.getRandom((RandomSource)rand);
        for (int totalWeightSum = candidatePoolElements.stream().mapToInt(Pair::getSecond).reduce(0, Integer::sum); candidatePoolElements.size() > 0 && totalWeightSum > 0; totalWeightSum -= chosenPieceWeight) {
            StructureContext ctx;
            CataclysmJigsawPoolElement yungElement;
            BlockPos anchorPos;
            Pair chosenPoolElementPair = null;
            for (Pair candidatePiecePair : candidatePoolElements) {
                CataclysmJigsawPoolElement yungElement2;
                StructurePoolElement candidatePiece = (StructurePoolElement)candidatePiecePair.getFirst();
                if (!(candidatePiece instanceof CataclysmJigsawPoolElement) || !(yungElement2 = (CataclysmJigsawPoolElement)candidatePiece).isPriorityPiece()) continue;
                chosenPoolElementPair = candidatePiecePair;
                break;
            }
            if (chosenPoolElementPair == null) {
                Pair candidatePiecePair;
                int chosenWeight = rand.nextInt(totalWeightSum) + 1;
                candidatePiecePair = candidatePoolElements.iterator();
                while (candidatePiecePair.hasNext()) {
                    Pair candidate = (Pair)candidatePiecePair.next();
                    if ((chosenWeight -= ((Integer)candidate.getSecond()).intValue()) > 0) continue;
                    chosenPoolElementPair = candidate;
                    break;
                }
            }
            StructurePoolElement chosenPoolElement = (StructurePoolElement)chosenPoolElementPair.getFirst();
            chosenPieceWeight = (Integer)chosenPoolElementPair.getSecond();
            if (chosenPoolElement == EmptyPoolElement.INSTANCE) {
                return Optional.empty();
            }
            if (startJigsawNameOptional.isPresent()) {
                Identifier name = startJigsawNameOptional.get();
                Optional<BlockPos> optional = CataclysmJigsawManager.getPosOfJigsawBlockWithName(chosenPoolElement, name, locatePos, rotation, structureTemplateManager, (RandomSource)rand);
                if (optional.isEmpty()) {
                    Cataclysm.LOGGER.error("No starting jigsaw with Name {} found in start pool {}", (Object)name, (Object)startPoolHolder.unwrapKey().map(pool -> pool.location().toString()).orElse("<unregistered>"));
                    return Optional.empty();
                }
                anchorPos = optional.get();
            } else {
                anchorPos = locatePos;
            }
            BlockPos startingPosOffset = anchorPos.subtract((Vec3i)locatePos);
            BlockPos adjustedStartPos = locatePos.subtract((Vec3i)startingPosOffset);
            if (chosenPoolElement instanceof CataclysmJigsawPoolElement && !(yungElement = (CataclysmJigsawPoolElement)chosenPoolElement).passesConditions(ctx = new StructureContext.Builder().structureTemplateManager(structureTemplateManager).pos(adjustedStartPos).rotation(rotation).depth(0).random((RandomSource)rand).randomState(generationContext.randomState()).biomeSource(generationContext.biomeSource()).build())) {
                candidatePoolElements.remove((Object)chosenPoolElementPair);
                continue;
            }
            return Optional.of(new PoolElementStructurePiece(structureTemplateManager, chosenPoolElement, adjustedStartPos, chosenPoolElement.getGroundLevelDelta(), rotation, chosenPoolElement.getBoundingBox(structureTemplateManager, adjustedStartPos, rotation), liquidSettings));
        }
        return Optional.empty();
    }

    private static Optional<BlockPos> getPosOfJigsawBlockWithName(StructurePoolElement structurePoolElement, Identifier name, BlockPos startPos, Rotation rotation, StructureTemplateManager structureTemplateManager, RandomSource rand) {
        try {
            List shuffledJigsawBlocks = structurePoolElement.getShuffledJigsawBlocks(structureTemplateManager, startPos, rotation, rand);
            for (StructureTemplate.StructureBlockInfo jigsawBlockInfo : shuffledJigsawBlocks) {
                Identifier jigsawBlockName = Identifier.tryParse((String)jigsawBlockInfo.nbt().getString("name"));
                if (!name.equals((Object)jigsawBlockName)) continue;
                return Optional.of(jigsawBlockInfo.pos());
            }
        }
        catch (ConcurrentModificationException e) {
            Cataclysm.LOGGER.error("Encountered unexpected ConcurrentModException while trying to get jigsaw block with name {} from structure pool element {}", (Object)name, (Object)structurePoolElement);
            Cataclysm.LOGGER.error("Ignoring - the structure will still generate, but /locate will not point to the structure's anchor block.");
            return Optional.empty();
        }
        return Optional.empty();
    }
}

