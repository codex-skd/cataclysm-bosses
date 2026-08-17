/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.DataResult
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.resources.Identifier
 */
package com.skd.thesundering.world.structures.terrainadaptation;

import com.skd.thesundering.world.structures.terrainadaptation.CustomAdaptation;
import com.skd.thesundering.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.skd.thesundering.world.structures.terrainadaptation.LargeCarvedTopNoBeardAdaptation;
import com.skd.thesundering.world.structures.terrainadaptation.NoneAdaptation;
import com.skd.thesundering.world.structures.terrainadaptation.SmallCarvedTopNoBeardAdaptation;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.resources.Identifier;

public interface EnhancedTerrainAdaptationType<C extends EnhancedTerrainAdaptation> {
    public static final Map<Identifier, EnhancedTerrainAdaptationType<?>> ADAPTATION_TYPES_BY_NAME = new HashMap();
    public static final Map<EnhancedTerrainAdaptationType<?>, Identifier> NAME_BY_ADAPTATION_TYPES = new HashMap();
    public static final Codec<EnhancedTerrainAdaptationType<?>> ADAPTATION_TYPE_CODEC = Identifier.CODEC.flatXmap(resourceLocation -> Optional.ofNullable(ADAPTATION_TYPES_BY_NAME.get(resourceLocation)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "Unknown enhanced terrain adaptation type: " + String.valueOf(resourceLocation))), adaptationType -> Optional.of(NAME_BY_ADAPTATION_TYPES.get(adaptationType)).map(DataResult::success).orElseGet(() -> DataResult.error(() -> "No ID found for enhanced terrain adaptation type " + String.valueOf(adaptationType) + ". Is it registered?")));
    public static final Codec<EnhancedTerrainAdaptation> ADAPTATION_CODEC = ADAPTATION_TYPE_CODEC.dispatch("type", EnhancedTerrainAdaptation::type, EnhancedTerrainAdaptationType::codec);
    public static final EnhancedTerrainAdaptationType<NoneAdaptation> NONE = EnhancedTerrainAdaptationType.register("none", NoneAdaptation.CODEC);
    public static final EnhancedTerrainAdaptationType<LargeCarvedTopNoBeardAdaptation> LARGE_CARVED_TOP_NO_BEARD = EnhancedTerrainAdaptationType.register("carved_top_no_beard_large", LargeCarvedTopNoBeardAdaptation.CODEC);
    public static final EnhancedTerrainAdaptationType<SmallCarvedTopNoBeardAdaptation> SMALL_CARVED_TOP_NO_BEARD = EnhancedTerrainAdaptationType.register("carved_top_no_beard_small", SmallCarvedTopNoBeardAdaptation.CODEC);
    public static final EnhancedTerrainAdaptationType<CustomAdaptation> CUSTOM = EnhancedTerrainAdaptationType.register("custom", CustomAdaptation.CODEC);

    public static <C extends EnhancedTerrainAdaptation> EnhancedTerrainAdaptationType<C> register(Identifier resourceLocation, MapCodec<C> codec) {
        EnhancedTerrainAdaptationType<C> adaptationType = () -> codec;
        ADAPTATION_TYPES_BY_NAME.put(resourceLocation, adaptationType);
        NAME_BY_ADAPTATION_TYPES.put(adaptationType, resourceLocation);
        return adaptationType;
    }

    private static <C extends EnhancedTerrainAdaptation> EnhancedTerrainAdaptationType<C> register(String id, MapCodec<C> codec) {
        return EnhancedTerrainAdaptationType.register(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)id), codec);
    }

    public MapCodec<C> codec();
}

