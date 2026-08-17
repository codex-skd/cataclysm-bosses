/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 */
package com.skd.thesundering.world.structures.terrainadaptation;

import com.skd.thesundering.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.skd.thesundering.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.skd.thesundering.world.structures.terrainadaptation.TerrainAction;
import com.mojang.serialization.MapCodec;

public class SmallCarvedTopNoBeardAdaptation
extends EnhancedTerrainAdaptation {
    private static final SmallCarvedTopNoBeardAdaptation INSTANCE = new SmallCarvedTopNoBeardAdaptation();
    public static final MapCodec<SmallCarvedTopNoBeardAdaptation> CODEC = MapCodec.unit(() -> INSTANCE);

    public SmallCarvedTopNoBeardAdaptation() {
        super(12, 6, TerrainAction.CARVE, TerrainAction.NONE, 0.0, EnhancedTerrainAdaptation.Padding.ZERO);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.SMALL_CARVED_TOP_NO_BEARD;
    }
}

