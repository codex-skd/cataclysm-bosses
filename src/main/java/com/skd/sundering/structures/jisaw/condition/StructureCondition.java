/*
 * Decompiled with CFR 0.152.
 */
package com.skd.sundering.structures.jisaw.condition;

import com.skd.sundering.structures.jisaw.condition.AlwaysTrueCondition;
import com.skd.sundering.structures.jisaw.condition.StructureConditionType;
import com.skd.sundering.structures.jisaw.context.StructureContext;

public abstract class StructureCondition {
    public static final StructureCondition ALWAYS_TRUE = new AlwaysTrueCondition();

    public abstract StructureConditionType<?> type();

    public abstract boolean passes(StructureContext var1);
}

