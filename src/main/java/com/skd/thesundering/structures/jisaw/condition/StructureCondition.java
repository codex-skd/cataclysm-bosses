/*
 * Decompiled with CFR 0.152.
 */
package com.skd.thesundering.structures.jisaw.condition;

import com.skd.thesundering.structures.jisaw.condition.AlwaysTrueCondition;
import com.skd.thesundering.structures.jisaw.condition.StructureConditionType;
import com.skd.thesundering.structures.jisaw.context.StructureContext;

public abstract class StructureCondition {
    public static final StructureCondition ALWAYS_TRUE = new AlwaysTrueCondition();

    public abstract StructureConditionType<?> type();

    public abstract boolean passes(StructureContext var1);
}

