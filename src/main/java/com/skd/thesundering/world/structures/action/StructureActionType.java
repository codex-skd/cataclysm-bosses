/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.resources.Identifier
 */
package com.skd.thesundering.world.structures.action;

import com.skd.thesundering.world.structures.action.DelayGenerationAction;
import com.skd.thesundering.world.structures.action.StructureAction;
import com.skd.thesundering.world.structures.action.TransformAction;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.resources.Identifier;

public interface StructureActionType<C extends StructureAction> {
    public static final Map<Identifier, StructureActionType<?>> ACTION_TYPES_BY_NAME = new HashMap();
    public static final Map<StructureActionType<?>, Identifier> NAME_BY_ACTION_TYPES = new HashMap();
    public static final Codec<StructureActionType<?>> ACTION_TYPE_CODEC = Identifier.CODEC.flatXmap(resourceLocation -> Optional.ofNullable(ACTION_TYPES_BY_NAME.get(resourceLocation)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "Unknown structure action type: " + String.valueOf(resourceLocation))), actionType -> Optional.of(NAME_BY_ACTION_TYPES.get(actionType)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "No ID found for structure action type " + String.valueOf(actionType) + ". Is it registered?")));
    public static final Codec<StructureAction> ACTION_CODEC = ACTION_TYPE_CODEC.dispatch("type", StructureAction::type, StructureActionType::codec);
    public static final StructureActionType<TransformAction> TRANSFORM = StructureActionType.register("transform", TransformAction.CODEC);
    public static final StructureActionType<DelayGenerationAction> DELAY_GENERATION = StructureActionType.register("delay_generation", DelayGenerationAction.CODEC);

    public static <C extends StructureAction> StructureActionType<C> register(Identifier resourceLocation, MapCodec<C> codec) {
        StructureActionType<C> actionType = () -> codec;
        ACTION_TYPES_BY_NAME.put(resourceLocation, actionType);
        NAME_BY_ACTION_TYPES.put(actionType, resourceLocation);
        return actionType;
    }

    private static <C extends StructureAction> StructureActionType<C> register(String id, MapCodec<C> codec) {
        return StructureActionType.register(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)id), codec);
    }

    public MapCodec<C> codec();
}

