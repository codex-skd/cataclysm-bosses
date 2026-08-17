/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.resources.Identifier
 */
package com.skd.thesundering.world.structures.targetselector;

import com.skd.thesundering.world.structures.targetselector.SelfTargetSelector;
import com.skd.thesundering.world.structures.targetselector.StructureTargetSelector;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.resources.Identifier;

public interface StructureTargetSelectorType<C extends StructureTargetSelector> {
    public static final Map<Identifier, StructureTargetSelectorType<?>> TARGET_SELECTOR_TYPES_BY_NAME = new HashMap();
    public static final Map<StructureTargetSelectorType<?>, Identifier> NAME_BY_TARGET_SELECTOR_TYPES = new HashMap();
    public static final Codec<StructureTargetSelectorType<?>> TARGET_SELECTOR_TYPE_CODEC = Identifier.CODEC.flatXmap(resourceLocation -> Optional.ofNullable(TARGET_SELECTOR_TYPES_BY_NAME.get(resourceLocation)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "Unknown target selector type: " + String.valueOf(resourceLocation))), targetSelectorType -> Optional.of(NAME_BY_TARGET_SELECTOR_TYPES.get(targetSelectorType)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "No ID found for target selector type " + String.valueOf(targetSelectorType) + ". Is it registered?")));
    public static final Codec<StructureTargetSelector> TARGET_SELECTOR_CODEC = TARGET_SELECTOR_TYPE_CODEC.dispatch("type", StructureTargetSelector::type, StructureTargetSelectorType::codec);
    public static final StructureTargetSelectorType<SelfTargetSelector> SELF = StructureTargetSelectorType.register("self", SelfTargetSelector.CODEC);

    public static <C extends StructureTargetSelector> StructureTargetSelectorType<C> register(Identifier resourceLocation, MapCodec<C> codec) {
        StructureTargetSelectorType<C> targetSelectorType = () -> codec;
        TARGET_SELECTOR_TYPES_BY_NAME.put(resourceLocation, targetSelectorType);
        NAME_BY_TARGET_SELECTOR_TYPES.put(targetSelectorType, resourceLocation);
        return targetSelectorType;
    }

    private static <C extends StructureTargetSelector> StructureTargetSelectorType<C> register(String id, MapCodec<C> codec) {
        return StructureTargetSelectorType.register(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)id), codec);
    }

    public MapCodec<C> codec();
}

