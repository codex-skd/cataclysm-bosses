/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate$StructureBlockInfo
 *  org.apache.commons.lang3.mutable.MutableObject
 */
package com.skd.cataclysmbosses.structures.jisaw.assembler;

import com.skd.cataclysmbosses.structures.jisaw.PieceEntry;
import com.skd.cataclysmbosses.util.BoxOctree;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.apache.commons.lang3.mutable.MutableObject;

public class PieceContext {
    public ObjectArrayList<Pair<StructurePoolElement, Integer>> candidatePoolElements;
    public StructureTemplate.JigsawBlockInfo jigsawBlock;
    public BlockPos jigsawBlockTargetPos;
    public int pieceMinY;
    public BlockPos jigsawBlockPos;
    public MutableObject<BoxOctree> boxOctree;
    public PieceEntry pieceEntry;
    public int depth;

    public PieceContext(ObjectArrayList<Pair<StructurePoolElement, Integer>> candidatePoolElements, StructureTemplate.JigsawBlockInfo jigsawBlock, BlockPos jigsawBlockTargetPos, int pieceMinY, BlockPos jigsawBlockPos, MutableObject<BoxOctree> boxOctree, PieceEntry pieceEntry, int depth) {
        this.candidatePoolElements = candidatePoolElements;
        this.jigsawBlock = jigsawBlock;
        this.jigsawBlockTargetPos = jigsawBlockTargetPos;
        this.pieceMinY = pieceMinY;
        this.jigsawBlockPos = jigsawBlockPos;
        this.boxOctree = boxOctree;
        this.pieceEntry = pieceEntry;
        this.depth = depth;
    }

    public PieceContext copy() {
        return new PieceContext(this.candidatePoolElements, this.jigsawBlock, this.jigsawBlockTargetPos, this.pieceMinY, this.jigsawBlockPos, this.boxOctree, this.pieceEntry, this.depth);
    }
}

