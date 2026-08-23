/*
 * Decompiled with CFR 0.152.
 */
package com.skd.cataclysmbosses.world.structures.action;

import com.skd.cataclysmbosses.structures.jisaw.PieceEntry;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.skd.cataclysmbosses.world.structures.action.StructureActionType;

public abstract class StructureAction {
    public abstract StructureActionType<?> type();

    public abstract void apply(StructureContext var1, PieceEntry var2);
}

