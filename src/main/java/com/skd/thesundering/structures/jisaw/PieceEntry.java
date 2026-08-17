/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece
 *  net.minecraft.world.level.levelgen.structure.pools.JigsawJunction
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  net.minecraft.world.phys.AABB
 *  org.apache.commons.lang3.mutable.MutableObject
 */
package com.skd.thesundering.structures.jisaw;

import com.skd.thesundering.structures.jisaw.assembler.PieceContext;
import com.skd.thesundering.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.skd.thesundering.util.BoxOctree;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.pools.JigsawJunction;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.mutable.MutableObject;

public class PieceEntry {
    private PoolElementStructurePiece piece;
    private final MutableObject<BoxOctree> boxOctree;
    private final AABB pieceAabb;
    private final int depth;
    private final List<PieceEntry> childEntries = new ArrayList<PieceEntry>();
    private final PieceEntry parentEntry;
    private final PieceContext sourcePieceContext;
    private final JigsawJunction parentJunction;
    private boolean delayGeneration = false;

    public PieceEntry(PoolElementStructurePiece piece, MutableObject<BoxOctree> boxOctree, AABB pieceAabb, int depth, PieceEntry parentEntry, PieceContext sourcePieceContext, JigsawJunction parentJunction) {
        this.piece = piece;
        this.boxOctree = boxOctree;
        this.pieceAabb = pieceAabb;
        this.depth = depth;
        this.parentEntry = parentEntry;
        this.sourcePieceContext = sourcePieceContext;
        this.parentJunction = parentJunction;
    }

    public void addChildEntry(PieceEntry childEntry) {
        this.childEntries.add(childEntry);
    }

    public boolean hasChildren() {
        return this.childEntries.size() > 0;
    }

    public PoolElementStructurePiece getPiece() {
        return this.piece;
    }

    public void setPiece(PoolElementStructurePiece newPiece) {
        this.piece = newPiece;
    }

    public MutableObject<BoxOctree> getBoxOctree() {
        return this.boxOctree;
    }

    public int getDepth() {
        return this.depth;
    }

    public PieceEntry getParentEntry() {
        return this.parentEntry;
    }

    public PieceContext getSourcePieceContext() {
        return this.sourcePieceContext;
    }

    public AABB getPieceAabb() {
        return this.pieceAabb;
    }

    public JigsawJunction getParentJunction() {
        return this.parentJunction;
    }

    public Optional<Identifier> getDeadendPool() {
        StructurePoolElement structurePoolElement = this.piece.getElement();
        if (structurePoolElement instanceof CataclysmJigsawSinglePoolElement) {
            CataclysmJigsawSinglePoolElement yungSingleElement = (CataclysmJigsawSinglePoolElement)structurePoolElement;
            return yungSingleElement.getDeadendPool();
        }
        return Optional.empty();
    }

    public void setDelayGeneration(boolean delayGeneration) {
        this.delayGeneration = delayGeneration;
    }

    public boolean isDelayGeneration() {
        return this.delayGeneration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PieceEntry that = (PieceEntry)obj;
        return Objects.equals(this.piece, that.piece) && Objects.equals(this.boxOctree, that.boxOctree) && this.depth == that.depth;
    }

    public int hashCode() {
        return Objects.hash(this.piece, this.boxOctree, this.depth);
    }

    public String toString() {
        return "PieceEntry[piece=" + String.valueOf(this.piece) + ", boxOctree=" + String.valueOf(this.boxOctree) + ", depth=" + this.depth + "]";
    }
}

