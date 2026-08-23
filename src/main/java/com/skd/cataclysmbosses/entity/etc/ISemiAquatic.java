/*
 * Decompiled with CFR 0.152.
 */
package com.skd.cataclysmbosses.entity.etc;

public interface ISemiAquatic {
    public boolean shouldEnterWater();

    public boolean shouldLeaveWater();

    public boolean shouldStopMoving();

    public int getWaterSearchRange();
}

