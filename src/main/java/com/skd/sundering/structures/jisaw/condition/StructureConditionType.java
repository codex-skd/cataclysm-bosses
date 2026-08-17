/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.resources.Identifier
 */
package com.skd.sundering.structures.jisaw.condition;

import com.skd.sundering.structures.jisaw.condition.AlwaysTrueCondition;
import com.skd.sundering.structures.jisaw.condition.StructureCondition;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.resources.Identifier;

public interface StructureConditionType<C extends StructureCondition> {
    public static final Map<Identifier, StructureConditionType<?>> CONDITION_TYPES_BY_NAME = new HashMap();
    public static final Map<StructureConditionType<?>, Identifier> NAME_BY_CONDITION_TYPES = new HashMap();
    public static final Codec<StructureConditionType<?>> CONDITION_TYPE_CODEC = Identifier.CODEC.flatXmap(resourceLocation -> Optional.ofNullable(CONDITION_TYPES_BY_NAME.get(resourceLocation)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "Unknown condition type: " + String.valueOf(resourceLocation))), conditionType -> Optional.of(NAME_BY_CONDITION_TYPES.get(conditionType)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "No ID found for condition type " + String.valueOf(conditionType) + ". Is it registered?")));
    public static final Codec<StructureCondition> CONDITION_CODEC = CONDITION_TYPE_CODEC.dispatch("type", StructureCondition::type, StructureConditionType::codec);
    public static final StructureConditionType<AlwaysTrueCondition> ALWAYS_TRUE = StructureConditionType.register("always_true", AlwaysTrueCondition.CODEC);

    public static <C extends StructureCondition> StructureConditionType<C> register(Identifier resourceLocation, MapCodec<C> codec) {
        StructureConditionType<C> conditionType = () -> codec;
        CONDITION_TYPES_BY_NAME.put(resourceLocation, conditionType);
        NAME_BY_CONDITION_TYPES.put(conditionType, resourceLocation);
        return conditionType;
    }

    private static <C extends StructureCondition> StructureConditionType<C> register(String id, MapCodec<C> codec) {
        return StructureConditionType.register(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)id), codec);
    }

    public MapCodec<C> codec();
}

