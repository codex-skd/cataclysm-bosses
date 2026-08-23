/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 */
package com.skd.cataclysmbosses.world.structures.action;

import com.skd.cataclysmbosses.structures.jisaw.PieceEntry;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.skd.cataclysmbosses.world.structures.action.StructureAction;
import com.skd.cataclysmbosses.world.structures.action.StructureActionType;
import com.mojang.serialization.MapCodec;

public class DelayGenerationAction
extends StructureAction {
    private static final DelayGenerationAction INSTANCE = new DelayGenerationAction();
    public static final MapCodec<DelayGenerationAction> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureActionType<?> type() {
        return StructureActionType.DELAY_GENERATION;
    }

    @Override
    public void apply(StructureContext ctx, PieceEntry targetPieceEntry) {
        targetPieceEntry.setDelayGeneration(true);
    }
}

