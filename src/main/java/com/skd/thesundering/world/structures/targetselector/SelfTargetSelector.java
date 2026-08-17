/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 */
package com.skd.thesundering.world.structures.targetselector;

import com.skd.thesundering.structures.jisaw.PieceEntry;
import com.skd.thesundering.structures.jisaw.context.StructureContext;
import com.skd.thesundering.world.structures.targetselector.StructureTargetSelector;
import com.skd.thesundering.world.structures.targetselector.StructureTargetSelectorType;
import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.List;

public class SelfTargetSelector
extends StructureTargetSelector {
    private static final SelfTargetSelector INSTANCE = new SelfTargetSelector();
    public static final MapCodec<SelfTargetSelector> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureTargetSelectorType<?> type() {
        return StructureTargetSelectorType.SELF;
    }

    @Override
    public List<PieceEntry> apply(StructureContext ctx) {
        ArrayList<PieceEntry> list = new ArrayList<PieceEntry>();
        if (ctx.pieceEntry() != null) {
            list.add(ctx.pieceEntry());
        }
        return list;
    }
}

