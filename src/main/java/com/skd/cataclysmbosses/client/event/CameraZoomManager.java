/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 */
package com.skd.cataclysmbosses.client.event;

import net.minecraft.util.Mth;

public class CameraZoomManager {
    private static boolean active = false;
    private static int tickCounter = 0;
    private static int totalDuration = 0;
    private static float maxDistance = 0.0f;
    private static float startWeight = 1.0f;
    private static float midWeight = 0.0f;
    private static float endWeight = 1.0f;

    public static void startZoom(int duration, float distance, float n, float u, float m) {
        active = true;
        tickCounter = 0;
        totalDuration = duration;
        maxDistance = distance;
        startWeight = n;
        midWeight = u;
        endWeight = m;
    }

    public static void tick() {
        if (!active) {
            return;
        }
        if (++tickCounter >= totalDuration) {
            active = false;
            tickCounter = 0;
        }
    }

    public static float getZoomOffset(float partialTick) {
        if (!active) {
            return 0.0f;
        }
        float progress = ((float)tickCounter + partialTick) / (float)totalDuration;
        progress = Mth.clamp((float)progress, (float)0.0f, (float)1.0f);
        float curve = CameraZoomManager.calculateCustomCurve(progress, startWeight, midWeight, endWeight);
        return maxDistance * curve;
    }

    private static float calculateCustomCurve(float progress, float N, float U, float M) {
        float total = N + U + M;
        float start = progress * (total / N);
        float end = (1.0f - progress) * (total / M);
        float tri = Math.min(start, end);
        float trapezoid = Math.min(1.0f, tri);
        trapezoid = Math.max(0.0f, trapezoid);
        return Mth.sin((float)(trapezoid * (float)Math.PI / 2.0f));
    }

    public static boolean isActive() {
        return active;
    }
}

