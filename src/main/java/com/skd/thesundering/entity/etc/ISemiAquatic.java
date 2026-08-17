/*
 * Decompiled with CFR 0.152.
 */
package com.skd.thesundering.entity.etc;

public interface ISemiAquatic {
    public boolean shouldEnterWater();

    public boolean shouldLeaveWater();

    public boolean shouldStopMoving();

    public int getWaterSearchRange();
}

