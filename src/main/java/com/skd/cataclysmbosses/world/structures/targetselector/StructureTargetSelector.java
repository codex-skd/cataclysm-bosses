/*
 * Decompiled with CFR 0.152.
 */
package com.skd.cataclysmbosses.world.structures.targetselector;

import com.skd.cataclysmbosses.structures.jisaw.PieceEntry;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.skd.cataclysmbosses.world.structures.targetselector.StructureTargetSelectorType;
import java.util.List;

public abstract class StructureTargetSelector {
    public abstract StructureTargetSelectorType<?> type();

    public abstract List<PieceEntry> apply(StructureContext var1);
}

