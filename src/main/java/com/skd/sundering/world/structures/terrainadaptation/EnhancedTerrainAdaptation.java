/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.Util
 *  net.minecraft.util.Mth
 */
package com.skd.sundering.world.structures.terrainadaptation;

import com.skd.sundering.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.skd.sundering.world.structures.terrainadaptation.NoneAdaptation;
import com.skd.sundering.world.structures.terrainadaptation.TerrainAction;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.util.Mth;

public abstract class EnhancedTerrainAdaptation {
    public static final EnhancedTerrainAdaptation NONE = new NoneAdaptation();
    private final TerrainAction topAction;
    private final TerrainAction bottomAction;
    private final int kernelSize;
    private final int kernelDistance;
    private final double bottomOffset;
    private final Padding padding;
    private final float[] kernel;

    public abstract EnhancedTerrainAdaptationType<?> type();

    EnhancedTerrainAdaptation(int kernelSize, int kernelDistance, TerrainAction topAction, TerrainAction bottomAction, double bottomOffset, Padding padding) {
        this.kernelSize = kernelSize;
        this.kernelDistance = kernelDistance;
        this.topAction = topAction;
        this.bottomAction = bottomAction;
        this.bottomOffset = bottomOffset;
        this.padding = padding;
        int kernelRadius = this.getKernelRadius();
        this.kernel = (float[])Util.make((Object)new float[kernelSize * kernelSize * kernelSize], kernel -> {
            for (int x = 0; x < kernelSize; ++x) {
                for (int y = 0; y < kernelSize; ++y) {
                    for (int z = 0; z < kernelSize; ++z) {
                        int i = this.index(x, y, z);
                        double kernelX = x - kernelRadius;
                        double kernelY = (double)(y - kernelRadius) + 0.5;
                        double kernelZ = z - kernelRadius;
                        kernel[i] = this.computeKernelValue(kernelX, kernelY, kernelZ);
                    }
                }
            }
        });
    }

    private float computeKernelValue(double xDistance, double yDistance, double zDistance) {
        double squaredDistance = Mth.lengthSquared((double)xDistance, (double)yDistance, (double)zDistance);
        return (float)Math.pow(Math.E, -squaredDistance / (double)this.kernelDistance);
    }

    public TerrainAction topAction() {
        return this.topAction;
    }

    public TerrainAction bottomAction() {
        return this.bottomAction;
    }

    public double getBottomOffset() {
        return this.bottomOffset;
    }

    public Padding getPadding() {
        return this.padding;
    }

    public int getKernelSize() {
        return this.kernelSize;
    }

    public int getKernelRadius() {
        return this.kernelSize / 2;
    }

    public int getKernelDistance() {
        return this.kernelDistance;
    }

    public float[] getKernel() {
        return this.kernel;
    }

    public double computeDensityFactor(int xDistance, int yDistance, int zDistance, int yDistanceToPieceBottom) {
        int kernelRadius = this.getKernelRadius();
        int kernelX = xDistance + kernelRadius;
        int kernelY = yDistance + kernelRadius;
        int kernelZ = zDistance + kernelRadius;
        if (this.isInKernelRange(kernelX) && this.isInKernelRange(kernelY) && this.isInKernelRange(kernelZ)) {
            int i = this.index(kernelX, kernelY, kernelZ);
            float kernelValue = this.getKernel()[i];
            double actualYDistanceToPieceBottom = (double)yDistanceToPieceBottom + 0.5;
            double squaredDistance = Mth.lengthSquared((double)xDistance, (double)actualYDistanceToPieceBottom, (double)zDistance);
            double multiplier = Math.abs(actualYDistanceToPieceBottom * Mth.invSqrt((double)(squaredDistance / 2.0)) / 2.0);
            boolean isAboveBeardBase = actualYDistanceToPieceBottom > 0.0;
            int densityModifier = isAboveBeardBase ? this.topAction.getDensityModifier() : this.bottomAction.getDensityModifier();
            return multiplier * (double)kernelValue * (double)densityModifier;
        }
        return 0.0;
    }

    private boolean isInKernelRange(int i) {
        return i >= 0 && i < this.kernelSize;
    }

    private int index(int x, int y, int z) {
        return z * this.kernelSize * this.kernelSize + x * this.kernelSize + y;
    }

    public record Padding(int x, int top, int bottom, int z) {
        public static final Padding ZERO = new Padding(0, 0, 0, 0);
        public static final Codec<Padding> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.INT.optionalFieldOf("x", (Object)0).forGetter(padding -> padding.x), (App)Codec.INT.optionalFieldOf("top", (Object)0).forGetter(padding -> padding.top), (App)Codec.INT.optionalFieldOf("bottom", (Object)0).forGetter(padding -> padding.bottom), (App)Codec.INT.optionalFieldOf("z", (Object)0).forGetter(padding -> padding.z)).apply((Applicative)instance, Padding::new));
    }
}

