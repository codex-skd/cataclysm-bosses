/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  javax.annotation.ParametersAreNonnullByDefault
 *  net.minecraft.MethodsReturnNonnullByDefault
 *  net.minecraft.util.ExtraCodecs
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool$Projection
 */
package com.skd.cataclysmbosses.structures.jisaw.element;

import com.skd.cataclysmbosses.structures.jisaw.condition.StructureCondition;
import com.skd.cataclysmbosses.structures.jisaw.condition.StructureConditionType;
import com.skd.cataclysmbosses.structures.jisaw.context.StructureContext;
import com.skd.cataclysmbosses.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.skd.cataclysmbosses.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

@ParametersAreNonnullByDefault
public abstract class CataclysmJigsawPoolElement
extends StructurePoolElement {
    public final Optional<String> name;
    public final Optional<Integer> maxCount;
    @Deprecated
    public final Optional<Integer> minRequiredDepth;
    @Deprecated
    public final Optional<Integer> maxPossibleDepth;
    public final boolean isPriority;
    public final boolean ignoreBounds;
    public final StructureCondition condition;
    public final Optional<EnhancedTerrainAdaptation> enhancedTerrainAdaptation;

    public CataclysmJigsawPoolElement(StructureTemplatePool.Projection projection, Optional<String> name, Optional<Integer> maxCount, Optional<Integer> minRequiredDepth, Optional<Integer> maxPossibleDepth, boolean isPriority, boolean ignoreBounds, StructureCondition condition, Optional<EnhancedTerrainAdaptation> enhancedTerrainAdaptation) {
        super(projection);
        this.name = name;
        this.maxCount = maxCount;
        this.minRequiredDepth = minRequiredDepth;
        this.maxPossibleDepth = maxPossibleDepth;
        this.isPriority = isPriority;
        this.ignoreBounds = ignoreBounds;
        this.condition = condition;
        this.enhancedTerrainAdaptation = enhancedTerrainAdaptation;
    }

    public Optional<String> getName() {
        return this.name;
    }

    public Optional<Integer> getMaxCount() {
        return this.maxCount;
    }

    @Deprecated
    public Optional<Integer> getMinRequiredDepth() {
        return this.minRequiredDepth;
    }

    @Deprecated
    public Optional<Integer> getMaxPossibleDepth() {
        return this.maxPossibleDepth;
    }

    public boolean isPriorityPiece() {
        return this.isPriority;
    }

    public boolean ignoresBounds() {
        return this.ignoreBounds;
    }

    public StructureCondition getCondition() {
        return this.condition;
    }

    public Optional<EnhancedTerrainAdaptation> getEnhancedTerrainAdaptation() {
        return this.enhancedTerrainAdaptation;
    }

    public boolean isAtValidDepth(int depth) {
        boolean isAtMinRequiredDepth = this.minRequiredDepth.isEmpty() || this.minRequiredDepth.get() <= depth;
        boolean isAtMaxAllowableDepth = this.maxPossibleDepth.isEmpty() || this.maxPossibleDepth.get() >= depth;
        return isAtMinRequiredDepth && isAtMaxAllowableDepth;
    }

    public boolean passesConditions(StructureContext ctx) {
        return this.condition.passes(ctx);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Optional<String>> nameCodec() {
        return Codec.STRING.optionalFieldOf("name").forGetter(CataclysmJigsawPoolElement::getName);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Optional<Integer>> maxCountCodec() {
        return ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("max_count").forGetter(CataclysmJigsawPoolElement::getMaxCount);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Optional<Integer>> minRequiredDepthCodec() {
        return ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("min_required_depth").forGetter(CataclysmJigsawPoolElement::getMinRequiredDepth);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Optional<Integer>> maxPossibleDepthCodec() {
        return ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("max_possible_depth").forGetter(CataclysmJigsawPoolElement::getMaxPossibleDepth);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Boolean> isPriorityCodec() {
        return Codec.BOOL.optionalFieldOf("is_priority", false).forGetter(CataclysmJigsawPoolElement::isPriorityPiece);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Boolean> ignoreBoundsCodec() {
        return Codec.BOOL.optionalFieldOf("ignore_bounds", false).forGetter(CataclysmJigsawPoolElement::ignoresBounds);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, StructureCondition> conditionCodec() {
        return StructureConditionType.CONDITION_CODEC.optionalFieldOf("condition", StructureCondition.ALWAYS_TRUE).forGetter(CataclysmJigsawPoolElement::getCondition);
    }

    public static <E extends CataclysmJigsawPoolElement> RecordCodecBuilder<E, Optional<EnhancedTerrainAdaptation>> enhancedTerrainAdaptationCodec() {
        return EnhancedTerrainAdaptationType.ADAPTATION_CODEC.optionalFieldOf("enhanced_terrain_adaptation").forGetter(CataclysmJigsawPoolElement::getEnhancedTerrainAdaptation);
    }
}

