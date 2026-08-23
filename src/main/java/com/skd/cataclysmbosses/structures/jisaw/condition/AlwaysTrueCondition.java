/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 */
package com.skd.cataclysmbosses.structures.jisaw.condition;

import com.skd.cataclysmbosses.structures.jisaw.condition.StructureCondition;
import com.skd.cataclysmbosses.structures.jisaw.condition.StructureConditionType;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.mojang.serialization.MapCodec;

public class AlwaysTrueCondition
extends StructureCondition {
    private static final AlwaysTrueCondition INSTANCE = new AlwaysTrueCondition();
    public static final MapCodec<AlwaysTrueCondition> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    public StructureConditionType<?> type() {
        return StructureConditionType.ALWAYS_TRUE;
    }

    @Override
    public boolean passes(StructureContext ctx) {
        return true;
    }
}

