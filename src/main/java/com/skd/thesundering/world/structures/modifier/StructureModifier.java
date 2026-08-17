/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 */
package com.skd.thesundering.world.structures.modifier;

import com.skd.thesundering.structures.jisaw.PieceEntry;
import com.skd.thesundering.structures.jisaw.condition.StructureCondition;
import com.skd.thesundering.structures.jisaw.condition.StructureConditionType;
import com.skd.thesundering.structures.jisaw.context.StructureContext;
import com.skd.thesundering.world.structures.action.StructureAction;
import com.skd.thesundering.world.structures.action.StructureActionType;
import com.skd.thesundering.world.structures.targetselector.StructureTargetSelector;
import com.skd.thesundering.world.structures.targetselector.StructureTargetSelectorType;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;

public class StructureModifier {
    public static final Codec<StructureModifier> CODEC = RecordCodecBuilder.create(builder -> builder.group((App)StructureConditionType.CONDITION_CODEC.fieldOf("condition").forGetter(modifier -> modifier.condition), (App)StructureActionType.ACTION_CODEC.listOf().fieldOf("actions").forGetter(modifier -> modifier.actions), (App)StructureTargetSelectorType.TARGET_SELECTOR_CODEC.fieldOf("target_selector").forGetter(modifier -> modifier.targetSelector)).apply((Applicative)builder, StructureModifier::new));
    private final StructureCondition condition;
    private final List<StructureAction> actions;
    private final StructureTargetSelector targetSelector;

    public StructureModifier(StructureCondition condition, List<StructureAction> actions, StructureTargetSelector targetSelector) {
        this.condition = condition;
        this.actions = actions;
        this.targetSelector = targetSelector;
    }

    public boolean apply(StructureContext structureContext) {
        if (!this.condition.passes(structureContext)) {
            return false;
        }
        List<PieceEntry> targets = this.targetSelector.apply(structureContext);
        for (PieceEntry target : targets) {
            this.actions.forEach(action -> action.apply(structureContext, target));
        }
        return true;
    }
}

