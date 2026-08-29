/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.ExtraCodecs
 */
package com.skd.cataclysmbosses.world.structures.terrainadaptation;

import com.skd.cataclysmbosses.world.structures.terrainadaptation.EnhancedTerrainAdaptation;
import com.skd.cataclysmbosses.world.structures.terrainadaptation.EnhancedTerrainAdaptationType;
import com.skd.cataclysmbosses.world.structures.terrainadaptation.TerrainAction;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;

public class CustomAdaptation
extends EnhancedTerrainAdaptation {
    public static final MapCodec<CustomAdaptation> CODEC = RecordCodecBuilder.mapCodec(builder -> builder.group(ExtraCodecs.NON_NEGATIVE_INT.fieldOf("kernel_size").forGetter(EnhancedTerrainAdaptation::getKernelSize), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("kernel_distance").forGetter(EnhancedTerrainAdaptation::getKernelDistance), TerrainAction.CODEC.fieldOf("top").forGetter(EnhancedTerrainAdaptation::topAction), TerrainAction.CODEC.fieldOf("bottom").forGetter(EnhancedTerrainAdaptation::bottomAction), Codec.DOUBLE.optionalFieldOf("bottom_offset", 0.0).forGetter(EnhancedTerrainAdaptation::getBottomOffset), EnhancedTerrainAdaptation.Padding.CODEC.optionalFieldOf("padding", EnhancedTerrainAdaptation.Padding.ZERO).forGetter(EnhancedTerrainAdaptation::getPadding)).apply(builder, CustomAdaptation::new));

    CustomAdaptation(int kernelSize, int kernelDistance, TerrainAction topAction, TerrainAction bottomAction, double bottomOffset, EnhancedTerrainAdaptation.Padding padding) {
        super(kernelSize, kernelDistance, topAction, bottomAction, bottomOffset, padding);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.CUSTOM;
    }
}

