/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Queues
 *  com.mojang.datafixers.util.Pair
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.Util
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Registry
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.worldgen.Pools
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.JigsawBlock
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder
 *  net.minecraft.world.level.levelgen.structure.pools.DimensionPadding
 *  net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement
 *  net.minecraft.world.level.levelgen.structure.pools.JigsawJunction
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool$Projection
 *  net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.minecraft.world.phys.AABB
 *  org.apache.commons.lang3.mutable.MutableObject
 */
package com.skd.cataclysmbosses.structures.jisaw.assembler;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.mixin.accessor.BoundingBoxAccessor;
import com.skd.cataclysmbosses.mixin.accessor.StructureTemplatePoolAccessor;
import com.skd.cataclysmbosses.structures.jisaw.PieceEntry;
import com.skd.cataclysmbosses.structures.jisaw.assembler.PieceContext;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.skd.cataclysmbosses.structures.jisaw.element.CataclysmJigsawPoolElement;
import com.skd.cataclysmbosses.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.skd.cataclysmbosses.structures.jisaw.element.IMaxCountJigsawPoolElement;
import com.skd.cataclysmbosses.util.BoxOctree;
import com.google.common.collect.Queues;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.JigsawBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.EmptyPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.JigsawJunction;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.mutable.MutableObject;

public class JigsawStructureAssembler {
    private final Settings settings;
    private final List<PieceEntry> pieces = new ArrayList<PieceEntry>();
    public Deque<PieceEntry> unprocessedPieceEntries = Queues.newArrayDeque();
    private final Map<String, Integer> pieceCounts = new HashMap<String, Integer>();
    private final Map<String, Integer> maxPieceCounts = new HashMap<String, Integer>();

    public JigsawStructureAssembler(Settings settings) {
        this.settings = settings;
    }

    public void assembleStructure(PoolElementStructurePiece startPiece, BoxOctree structureBounds) {
        PieceEntry startPieceEntry = new PieceEntry(startPiece, (MutableObject<BoxOctree>)new MutableObject((Object)structureBounds), null, 0, null, null, null);
        this.pieces.add(startPieceEntry);
        this.unprocessedPieceEntries.addLast(startPieceEntry);
        while (!this.unprocessedPieceEntries.isEmpty()) {
            PieceEntry entry = this.unprocessedPieceEntries.removeFirst();
            this.addChildrenForPiece(entry);
        }
        this.applyModifications();
    }

    public void addAllPiecesToStructureBuilder(StructurePiecesBuilder structurePiecesBuilder) {
        this.pieces.forEach(pieceEntry -> structurePiecesBuilder.addPiece((StructurePiece)pieceEntry.getPiece()));
    }

    private void addChildrenForPiece(PieceEntry pieceEntry) {
        Holder fallbackPoolHolder;
        PoolElementStructurePiece piece = pieceEntry.getPiece();
        MutableObject parentOctree = new MutableObject();
        List pieceJigsawBlocks = piece.getElement().getShuffledJigsawBlocks(this.settings.structureTemplateManager, piece.getPosition(), piece.getRotation(), this.settings.rand);
        boolean generatedAtLeastOneChildPiece = false;
        for (StructureTemplate.StructureBlockInfo jigsawBlockInfo : pieceJigsawBlocks) {
            ResourceKey<StructureTemplatePool> poolKey = JigsawStructureAssembler.readPoolName(jigsawBlockInfo);
            Optional optionalPoolHolder = this.settings.poolRegistry.getHolder(poolKey);
            if (optionalPoolHolder.isEmpty()) {
                Cataclysm.LOGGER.warn("Empty or nonexistent pool: {}", (Object)poolKey.location());
                continue;
            }
            Holder targetPoolHolder = (Holder)optionalPoolHolder.get();
            StructureTemplatePool targetPool = (StructureTemplatePool)targetPoolHolder.value();
            if (targetPool.size() == 0 && !targetPoolHolder.is(Pools.EMPTY)) {
                Cataclysm.LOGGER.warn("Empty or nonexistent pool: {}", (Object)poolKey.location());
                continue;
            }
            fallbackPoolHolder = ((StructureTemplatePool)targetPoolHolder.value()).getFallback();
            StructureTemplatePool fallbackPool = (StructureTemplatePool)fallbackPoolHolder.value();
            if (fallbackPool.size() == 0 && !fallbackPoolHolder.is(Pools.EMPTY)) {
                Cataclysm.LOGGER.warn("Empty or nonexistent fallback pool: {}", (Object)fallbackPoolHolder.unwrapKey().map(key -> key.location().toString()).orElse("<unregistered>"));
                continue;
            }
            PieceContext pieceContext = this.createPieceContextForJigsawBlock(jigsawBlockInfo, pieceEntry, (MutableObject<BoxOctree>)parentOctree);
            Optional<Object> newlyGeneratedPiece = Optional.empty();
            if (pieceEntry.getDepth() != this.settings.maxDepth) {
                pieceContext.candidatePoolElements = new ObjectArrayList(((StructureTemplatePoolAccessor)targetPool).getRawTemplates());
                newlyGeneratedPiece = this.chooseCandidateFromPool(pieceContext);
            }
            if (newlyGeneratedPiece.isEmpty()) {
                pieceContext.candidatePoolElements = new ObjectArrayList(((StructureTemplatePoolAccessor)fallbackPool).getRawTemplates());
                newlyGeneratedPiece = this.chooseCandidateFromPool(pieceContext);
            }
            if (!newlyGeneratedPiece.isPresent()) continue;
            generatedAtLeastOneChildPiece = true;
        }
        if (pieceEntry.getDeadendPool().isPresent() && !generatedAtLeastOneChildPiece && pieceJigsawBlocks.size() > 1) {
            Identifier deadendPoolId = pieceEntry.getDeadendPool().get();
            Optional deadendPool = this.settings.poolRegistry.getOptional(deadendPoolId);
            if (deadendPool.isEmpty()) {
                Cataclysm.LOGGER.error("Unable to find deadend pool {} for element {}", (Object)deadendPoolId, (Object)piece.getElement());
                return;
            }
            PieceEntry parentEntry = pieceEntry.getParentEntry();
            PieceContext newContext = pieceEntry.getSourcePieceContext().copy();
            newContext.candidatePoolElements = new ObjectArrayList(((StructureTemplatePoolAccessor)deadendPool.get()).getRawTemplates());
            AABB pieceAabb = pieceEntry.getPieceAabb();
            if (parentEntry != null && pieceAabb != null) {
                IMaxCountJigsawPoolElement maxCountJigsawPoolElement;
                Object pieceName;
                parentEntry.getPiece().getJunctions().remove(pieceEntry.getParentJunction());
                ((BoxOctree)pieceEntry.getBoxOctree().getValue()).removeBox(pieceAabb);
                this.pieces.remove(pieceEntry);
                fallbackPoolHolder = pieceEntry.getPiece().getElement();
                if (fallbackPoolHolder instanceof CataclysmJigsawPoolElement) {
                    CataclysmJigsawPoolElement yungElement = (CataclysmJigsawPoolElement)fallbackPoolHolder;
                    if (yungElement.maxCount.isPresent() && yungElement.name.isPresent() && this.pieceCounts.containsKey(yungElement.name.get())) {
                        pieceName = yungElement.name.get();
                        this.pieceCounts.put((String)pieceName, this.pieceCounts.get(pieceName) - 1);
                    }
                }
                if ((pieceName = pieceEntry.getPiece().getElement()) instanceof IMaxCountJigsawPoolElement && this.pieceCounts.containsKey((maxCountJigsawPoolElement = (IMaxCountJigsawPoolElement)pieceName).getName())) {
                    pieceName = maxCountJigsawPoolElement.getName();
                    this.pieceCounts.put((String)pieceName, this.pieceCounts.get(pieceName) - 1);
                }
                this.chooseCandidateFromPool(newContext);
            }
        }
    }

    private PieceContext createPieceContextForJigsawBlock(StructureTemplate.StructureBlockInfo jigsawBlockInfo, PieceEntry pieceEntry, MutableObject<BoxOctree> parentOctree) {
        BoundingBox pieceBoundingBox = pieceEntry.getPiece().getBoundingBox();
        MutableObject<BoxOctree> pieceOctree = pieceEntry.getBoxOctree();
        Direction direction = JigsawBlock.getFrontFacing((BlockState)jigsawBlockInfo.state());
        BlockPos jigsawBlockTargetPos = jigsawBlockInfo.pos().relative(direction);
        boolean isTargetInsideCurrentPiece = pieceBoundingBox.isInside((Vec3i)jigsawBlockTargetPos);
        if (isTargetInsideCurrentPiece) {
            pieceOctree = parentOctree;
            if (parentOctree.getValue() == null) {
                parentOctree.setValue((Object)new BoxOctree(AABB.of((BoundingBox)pieceBoundingBox)));
            }
        }
        return new PieceContext(null, jigsawBlockInfo, jigsawBlockTargetPos, pieceBoundingBox.minY(), jigsawBlockInfo.pos(), pieceOctree, pieceEntry, pieceEntry.getDepth());
    }

    private Optional<StructurePoolElement> chooseCandidateFromPool(PieceContext context) {
        ObjectArrayList<Pair<StructurePoolElement, Integer>> candidatePoolElements = context.candidatePoolElements;
        PoolElementStructurePiece piece = context.pieceEntry.getPiece();
        boolean isPieceRigid = piece.getElement().getProjection() == StructureTemplatePool.Projection.RIGID;
        int jigsawBlockRelativeY = context.jigsawBlockPos.getY() - context.pieceMinY;
        int surfaceHeight = -1;
        Util.shuffle(candidatePoolElements, (RandomSource)this.settings.rand);
        int totalWeightSum = candidatePoolElements.stream().mapToInt(Pair::getSecond).reduce(0, Integer::sum);
        while (candidatePoolElements.size() > 0 && totalWeightSum > 0) {
            CataclysmJigsawPoolElement yungElement;
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
                int chosenWeight = this.settings.rand.nextInt(totalWeightSum) + 1;
                candidatePiecePair = candidatePoolElements.iterator();
                while (candidatePiecePair.hasNext()) {
                    Pair candidate = (Pair)candidatePiecePair.next();
                    if ((chosenWeight -= ((Integer)candidate.getSecond()).intValue()) > 0) continue;
                    chosenPoolElementPair = candidate;
                    break;
                }
            }
            StructurePoolElement chosenPoolElement = (StructurePoolElement)chosenPoolElementPair.getFirst();
            int chosenPieceWeight = (Integer)chosenPoolElementPair.getSecond();
            if (chosenPoolElement == EmptyPoolElement.INSTANCE) {
                return Optional.empty();
            }
            if (chosenPoolElement instanceof CataclysmJigsawPoolElement) {
                yungElement = (CataclysmJigsawPoolElement)chosenPoolElement;
                if (yungElement.maxCount.isPresent()) {
                    int pieceMaxCount = yungElement.maxCount.get();
                    if (yungElement.name.isEmpty()) {
                        Cataclysm.LOGGER.error("Found Cataclysm Jigsaw piece with max_count={} missing \"name\" property.", (Object)pieceMaxCount);
                        Cataclysm.LOGGER.error("Max count pieces must be named in order to work properly!");
                        Cataclysm.LOGGER.error("Ignoring max_count for this piece...");
                    } else {
                        String pieceName = yungElement.name.get();
                        if (this.maxPieceCounts.containsKey(pieceName) && this.maxPieceCounts.get(pieceName) != pieceMaxCount) {
                            Cataclysm.LOGGER.error("Cataclysm Jigsaw Piece with name {} and max_count {} does not match stored max_count of {}!", (Object)pieceName, (Object)pieceMaxCount, (Object)this.maxPieceCounts.get(pieceName));
                            Cataclysm.LOGGER.error("This can happen when multiple pieces across pools use the same name, but have different max_count values.");
                            Cataclysm.LOGGER.error("Please change these max_count values to match. Using max_count={} for now...", (Object)pieceMaxCount);
                        }
                        this.maxPieceCounts.put(pieceName, pieceMaxCount);
                        if (this.pieceCounts.getOrDefault(pieceName, 0) >= pieceMaxCount) {
                            totalWeightSum -= chosenPieceWeight;
                            candidatePoolElements.remove((Object)chosenPoolElementPair);
                            continue;
                        }
                    }
                }
            }
            if (chosenPoolElement instanceof IMaxCountJigsawPoolElement) {
                String pieceName = ((IMaxCountJigsawPoolElement)chosenPoolElement).getName();
                int maxCount = ((IMaxCountJigsawPoolElement)chosenPoolElement).getMaxCount();
                if (this.maxPieceCounts.containsKey(pieceName) && this.maxPieceCounts.get(pieceName) != maxCount) {
                    Cataclysm.LOGGER.error("Max Count Jigsaw Piece with name {} and max_count {} does not match stored max_count of {}!", (Object)pieceName, (Object)maxCount, (Object)this.maxPieceCounts.get(pieceName));
                    Cataclysm.LOGGER.error("This can happen when multiple pieces across pools use the same name, but have different max_count values.");
                    Cataclysm.LOGGER.error("Please change these max_count values to match. Using max_count={} for now...", (Object)maxCount);
                }
                this.maxPieceCounts.put(pieceName, maxCount);
                if (this.pieceCounts.getOrDefault(pieceName, 0) >= maxCount) {
                    totalWeightSum -= ((Integer)chosenPoolElementPair.getSecond()).intValue();
                    candidatePoolElements.remove((Object)chosenPoolElementPair);
                    continue;
                }
            }
            if (chosenPoolElement instanceof CataclysmJigsawPoolElement && !(yungElement = (CataclysmJigsawPoolElement)chosenPoolElement).isAtValidDepth(context.depth)) {
                totalWeightSum -= chosenPieceWeight;
                candidatePoolElements.remove((Object)chosenPoolElementPair);
                continue;
            }
            for (Rotation rotation : Rotation.getShuffled((RandomSource)this.settings.rand)) {
                List candidateJigsawBlocks = chosenPoolElement.getShuffledJigsawBlocks(this.settings.structureTemplateManager, BlockPos.ZERO, rotation, this.settings.rand);
                BoundingBox tempCandidateBoundingBox = chosenPoolElement.getBoundingBox(this.settings.structureTemplateManager, BlockPos.ZERO, rotation);
                int candidateHeightAdjustments = 0;
                if (this.settings.useExpansionHack && tempCandidateBoundingBox.getYSpan() <= 16) {
                    candidateHeightAdjustments = candidateJigsawBlocks.stream().mapToInt(pieceCandidateJigsawBlock -> {
                        if (!tempCandidateBoundingBox.isInside((Vec3i)pieceCandidateJigsawBlock.pos().relative(JigsawBlock.getFrontFacing((BlockState)pieceCandidateJigsawBlock.state())))) {
                            return 0;
                        }
                        ResourceKey<StructureTemplatePool> candidateTargetPoolKey = JigsawStructureAssembler.readPoolName(pieceCandidateJigsawBlock);
                        Optional candidateTargetPool = this.settings.poolRegistry.getHolder(candidateTargetPoolKey);
                        Optional<Holder> candidateFallbackPool = candidateTargetPool.map(poolHolder -> ((StructureTemplatePool)poolHolder.value()).getFallback());
                        int candidateMaxSize = candidateTargetPool.map(poolHolder -> ((StructureTemplatePool)poolHolder.value()).getMaxSize(this.settings.structureTemplateManager)).orElse(0);
                        int candidateFallbackMaxSize = candidateFallbackPool.map(poolHolder -> ((StructureTemplatePool)poolHolder.value()).getMaxSize(this.settings.structureTemplateManager)).orElse(0);
                        return Math.max(candidateMaxSize, candidateFallbackMaxSize);
                    }).max().orElse(0);
                }
                for (StructureTemplate.StructureBlockInfo candidateJigsawBlock : candidateJigsawBlocks) {
                    StructureContext ctx;
                    CataclysmJigsawPoolElement yungElement3;
                    int candidateJigsawBlockY;
                    int adjustedCandidatePieceMinY;
                    if (!JigsawBlock.canAttach((StructureTemplate.StructureBlockInfo)context.jigsawBlock, (StructureTemplate.StructureBlockInfo)candidateJigsawBlock)) continue;
                    BlockPos candidateJigsawBlockPos = candidateJigsawBlock.pos();
                    BlockPos candidateJigsawBlockRelativePos = context.jigsawBlockTargetPos.subtract((Vec3i)candidateJigsawBlockPos);
                    BoundingBox rotatedCandidateBoundingBox = chosenPoolElement.getBoundingBox(this.settings.structureTemplateManager, candidateJigsawBlockRelativePos, rotation);
                    StructureTemplatePool.Projection candidateProjection = chosenPoolElement.getProjection();
                    boolean isCandidateRigid = candidateProjection == StructureTemplatePool.Projection.RIGID;
                    int candidateJigsawBlockRelativeY = candidateJigsawBlockPos.getY();
                    int candidateJigsawYOffsetNeeded = jigsawBlockRelativeY - candidateJigsawBlockRelativeY + JigsawBlock.getFrontFacing((BlockState)context.jigsawBlock.state()).getStepY();
                    if (isPieceRigid && isCandidateRigid) {
                        adjustedCandidatePieceMinY = context.pieceMinY + candidateJigsawYOffsetNeeded;
                    } else {
                        if (surfaceHeight == -1) {
                            surfaceHeight = this.settings.chunkGenerator.getFirstFreeHeight(context.jigsawBlockPos.getX(), context.jigsawBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, this.settings.levelHeightAccessor, this.settings.randomState);
                        }
                        adjustedCandidatePieceMinY = surfaceHeight - candidateJigsawBlockRelativeY;
                    }
                    int candidatePieceYOffsetNeeded = adjustedCandidatePieceMinY - rotatedCandidateBoundingBox.minY();
                    BoundingBox adjustedCandidateBoundingBox = rotatedCandidateBoundingBox.moved(0, candidatePieceYOffsetNeeded, 0);
                    BlockPos adjustedCandidateJigsawBlockRelativePos = candidateJigsawBlockRelativePos.offset(0, candidatePieceYOffsetNeeded, 0);
                    if (candidateHeightAdjustments > 0) {
                        int k2 = Math.max(candidateHeightAdjustments + 1, adjustedCandidateBoundingBox.maxY() - adjustedCandidateBoundingBox.minY());
                        ((BoundingBoxAccessor)adjustedCandidateBoundingBox).setMaxY(adjustedCandidateBoundingBox.minY() + k2);
                    }
                    if (!this.settings.isInBounds(adjustedCandidateBoundingBox.maxY()) || !this.settings.isInBounds(adjustedCandidateBoundingBox.minY())) continue;
                    AABB aabb = AABB.of((BoundingBox)adjustedCandidateBoundingBox);
                    AABB aabbDeflated = aabb.deflate(0.25);
                    boolean pieceIgnoresBounds = false;
                    if (chosenPoolElement instanceof CataclysmJigsawPoolElement) {
                        CataclysmJigsawPoolElement yungElement4 = (CataclysmJigsawPoolElement)chosenPoolElement;
                        pieceIgnoresBounds = yungElement4.ignoresBounds();
                    }
                    if (!pieceIgnoresBounds) {
                        boolean pieceIntersectsExistingPieces = ((BoxOctree)context.boxOctree.getValue()).intersectsAnyBox(aabbDeflated);
                        boolean pieceIsContainedWithinStructureBoundaries = ((BoxOctree)context.boxOctree.getValue()).boundaryContains(aabbDeflated);
                        if (pieceIntersectsExistingPieces || !pieceIsContainedWithinStructureBoundaries) continue;
                    }
                    int newPieceGroundLevelDelta = piece.getGroundLevelDelta();
                    int groundLevelDelta = isCandidateRigid ? newPieceGroundLevelDelta - candidateJigsawYOffsetNeeded : chosenPoolElement.getGroundLevelDelta();
                    if (isPieceRigid) {
                        candidateJigsawBlockY = context.pieceMinY + jigsawBlockRelativeY;
                    } else if (isCandidateRigid) {
                        candidateJigsawBlockY = adjustedCandidatePieceMinY + candidateJigsawBlockRelativeY;
                    } else {
                        if (surfaceHeight == -1) {
                            surfaceHeight = this.settings.chunkGenerator.getFirstFreeHeight(context.jigsawBlockPos.getX(), context.jigsawBlockPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, this.settings.levelHeightAccessor, this.settings.randomState);
                        }
                        candidateJigsawBlockY = surfaceHeight + candidateJigsawYOffsetNeeded / 2;
                    }
                    PoolElementStructurePiece newPiece = new PoolElementStructurePiece(this.settings.structureTemplateManager, chosenPoolElement, adjustedCandidateJigsawBlockRelativePos, groundLevelDelta, rotation, adjustedCandidateBoundingBox, this.settings.liquidSettings);
                    JigsawJunction newJunctionOnParent = new JigsawJunction(context.jigsawBlockTargetPos.getX(), candidateJigsawBlockY - jigsawBlockRelativeY + newPieceGroundLevelDelta, context.jigsawBlockTargetPos.getZ(), candidateJigsawYOffsetNeeded, candidateProjection);
                    PieceEntry newPieceEntry = new PieceEntry(newPiece, context.boxOctree, aabb, context.depth + 1, context.pieceEntry, context.copy(), newJunctionOnParent);
                    if (chosenPoolElement instanceof CataclysmJigsawPoolElement && !(yungElement3 = (CataclysmJigsawPoolElement)chosenPoolElement).passesConditions(ctx = new StructureContext.Builder().structureTemplateManager(this.settings.structureTemplateManager).pieces(this.pieces).pieceEntry(newPieceEntry).pos(adjustedCandidateJigsawBlockRelativePos).rotation(rotation).pieceMinY(adjustedCandidateBoundingBox.minY()).pieceMaxY(adjustedCandidateBoundingBox.maxY()).depth(context.depth + 1).random(this.settings.rand).randomState(this.settings.randomState).biomeSource(this.settings.biomeSource).build())) continue;
                    piece.addJunction(newJunctionOnParent);
                    newPiece.addJunction(new JigsawJunction(context.jigsawBlockPos.getX(), candidateJigsawBlockY - candidateJigsawBlockRelativeY + groundLevelDelta, context.jigsawBlockPos.getZ(), -candidateJigsawYOffsetNeeded, piece.getElement().getProjection()));
                    ((BoxOctree)context.boxOctree.getValue()).addBox(aabb);
                    this.pieces.add(newPieceEntry);
                    context.pieceEntry.addChildEntry(newPieceEntry);
                    if (context.depth + 1 <= this.settings.maxDepth) {
                        this.unprocessedPieceEntries.addLast(newPieceEntry);
                    }
                    if (chosenPoolElement instanceof CataclysmJigsawPoolElement) {
                        yungElement3 = (CataclysmJigsawPoolElement)chosenPoolElement;
                        if (yungElement3.maxCount.isPresent()) {
                            if (yungElement3.name.isEmpty()) {
                                return Optional.of(chosenPoolElement);
                            }
                            String pieceName = yungElement3.name.get();
                            this.pieceCounts.put(pieceName, this.pieceCounts.getOrDefault(pieceName, 0) + 1);
                        }
                    }
                    if (chosenPoolElement instanceof IMaxCountJigsawPoolElement) {
                        String pieceName = ((IMaxCountJigsawPoolElement)chosenPoolElement).getName();
                        this.pieceCounts.put(pieceName, this.pieceCounts.getOrDefault(pieceName, 0) + 1);
                    }
                    return Optional.of(chosenPoolElement);
                }
            }
            totalWeightSum -= chosenPieceWeight;
            candidatePoolElements.remove((Object)chosenPoolElementPair);
        }
        return Optional.empty();
    }

    private void applyModifications() {
        for (PieceEntry pieceEntry : this.pieces) {
            CataclysmJigsawSinglePoolElement yungElement;
            StructurePoolElement structurePoolElement = pieceEntry.getPiece().getElement();
            if (!(structurePoolElement instanceof CataclysmJigsawSinglePoolElement) || !(yungElement = (CataclysmJigsawSinglePoolElement)structurePoolElement).hasModifiers()) continue;
            PoolElementStructurePiece piece = pieceEntry.getPiece();
            StructureContext structureContext = new StructureContext.Builder().pos(piece.getPosition()).rotation(piece.getRotation()).depth(pieceEntry.getDepth()).structureTemplateManager(this.settings.structureTemplateManager).pieceEntry(pieceEntry).pieces(this.pieces).pieceMaxY(piece.getBoundingBox().maxY()).pieceMinY(piece.getBoundingBox().minY()).random(this.settings.rand).randomState(this.settings.randomState).biomeSource(this.settings.biomeSource).build();
            yungElement.modifiers.forEach(modifier -> modifier.apply(structureContext));
        }
        List<PieceEntry> delayedEntries = this.pieces.stream().filter(PieceEntry::isDelayGeneration).toList();
        this.pieces.removeAll(delayedEntries);
        this.pieces.addAll(delayedEntries);
    }

    private static ResourceKey<StructureTemplatePool> readPoolName(StructureTemplate.StructureBlockInfo jigsawBlockInfo) {
        return ResourceKey.create((ResourceKey)Registries.TEMPLATE_POOL, (Identifier)Identifier.parse((String)jigsawBlockInfo.nbt().getString("pool")));
    }

    public static class Settings {
        private Registry<StructureTemplatePool> poolRegistry;
        private int maxDepth;
        private ChunkGenerator chunkGenerator;
        private StructureTemplateManager structureTemplateManager;
        private LevelHeightAccessor levelHeightAccessor;
        private RandomSource rand;
        private boolean useExpansionHack;
        public RandomState randomState;
        private Optional<Integer> maxY;
        private Optional<Integer> minY;
        private DimensionPadding dimensionPadding;
        private LiquidSettings liquidSettings;
        private BiomeSource biomeSource;

        public Settings poolRegistry(Registry<StructureTemplatePool> poolRegistry) {
            this.poolRegistry = poolRegistry;
            return this;
        }

        public Settings maxDepth(int maxDepth) {
            this.maxDepth = maxDepth;
            return this;
        }

        public Settings chunkGenerator(ChunkGenerator chunkGenerator) {
            this.chunkGenerator = chunkGenerator;
            return this;
        }

        public Settings structureTemplateManager(StructureTemplateManager structureTemplateManager) {
            this.structureTemplateManager = structureTemplateManager;
            return this;
        }

        public Settings randomState(RandomState randomState) {
            this.randomState = randomState;
            return this;
        }

        public Settings rand(RandomSource rand) {
            this.rand = rand;
            return this;
        }

        public Settings useExpansionHack(boolean useExpansionHack) {
            this.useExpansionHack = useExpansionHack;
            return this;
        }

        public Settings levelHeightAccessor(LevelHeightAccessor levelHeightAccessor) {
            this.levelHeightAccessor = levelHeightAccessor;
            return this;
        }

        public Settings maxY(Optional<Integer> maxY) {
            this.maxY = maxY;
            return this;
        }

        public Settings minY(Optional<Integer> minY) {
            this.minY = minY;
            return this;
        }

        public Settings dimensionPadding(DimensionPadding dimensionPadding) {
            this.dimensionPadding = dimensionPadding;
            return this;
        }

        public Settings liquidSettings(LiquidSettings liquidSettings) {
            this.liquidSettings = liquidSettings;
            return this;
        }

        public Settings biomeSource(BiomeSource biomeSource) {
            this.biomeSource = biomeSource;
            return this;
        }

        public boolean isInBounds(int y) {
            if (this.maxY.isPresent() && y > this.maxY.get()) {
                return false;
            }
            if (this.minY.isPresent() && y < this.minY.get()) {
                return false;
            }
            if (y < this.levelHeightAccessor.getMinBuildHeight() + this.dimensionPadding.bottom()) {
                return false;
            }
            return y <= this.levelHeightAccessor.getMaxBuildHeight() - this.dimensionPadding.top();
        }
    }
}

