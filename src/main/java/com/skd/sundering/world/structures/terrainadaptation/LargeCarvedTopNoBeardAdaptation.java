/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 */
package com.skd.sundering.world.structures.terrainadaptation;

import com.skd.sundering.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.skd.sundering.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.skd.sundering.world.structures.terrainadaptation.TerrainAction;
import com.mojang.serialization.MapCodec;

public class LargeCarvedTopNoBeardAdaptation
extends EnhancedTerrainAdaptation {
    private static final LargeCarvedTopNoBeardAdaptation INSTANCE = new LargeCarvedTopNoBeardAdaptation();
    public static final MapCodec<LargeCarvedTopNoBeardAdaptation> CODEC = MapCodec.unit(() -> INSTANCE);

    public LargeCarvedTopNoBeardAdaptation() {
        super(24, 16, TerrainAction.CARVE, TerrainAction.NONE, 0.0, EnhancedTerrainAdaptation.Padding.ZERO);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.LARGE_CARVED_TOP_NO_BEARD;
    }
}

