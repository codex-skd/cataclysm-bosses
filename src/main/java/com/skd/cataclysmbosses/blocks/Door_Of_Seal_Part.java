/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.StringRepresentable
 */
package com.skd.cataclysmbosses.blocks;

import net.minecraft.util.StringRepresentable;

public enum Door_Of_Seal_Part implements StringRepresentable {
    CENTER("center"),
    SIDE_LEFT("side_left"),
    SIDE_RIGHT("side_right"),
    END_LEFT("end_left"),
    END_RIGHT("end_right");

    private final String name;

    Door_Of_Seal_Part(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}