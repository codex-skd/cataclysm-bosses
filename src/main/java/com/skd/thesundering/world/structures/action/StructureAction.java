/*
 * Decompiled with CFR 0.152.
 */
package com.skd.thesundering.world.structures.action;

import com.skd.thesundering.structures.jisaw.PieceEntry;
import com.skd.thesundering.structures.jisaw.context.StructureContext;
import com.skd.thesundering.world.structures.action.StructureActionType;

public abstract class StructureAction {
    public abstract StructureActionType<?> type();

    public abstract void apply(StructureContext var1, PieceEntry var2);
}

