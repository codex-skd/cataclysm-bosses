/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.util.StringRepresentable
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.sundering.world.structures.terrainadaptation;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum TerrainAction implements StringRepresentable
{
    CARVE("carve", -1),
    BURY("bury", 1),
    NONE("none", 0);

    public static final Codec<TerrainAction> CODEC;
    private final String name;
    private final int densityModifier;

    private TerrainAction(String name, int densityModifier) {
        this.name = name;
        this.densityModifier = densityModifier;
    }

    public int getDensityModifier() {
        return this.densityModifier;
    }

    @NotNull
    public String getSerializedName() {
        return this.name;
    }

    static {
        CODEC = StringRepresentable.fromValues(TerrainAction::values);
    }
}

