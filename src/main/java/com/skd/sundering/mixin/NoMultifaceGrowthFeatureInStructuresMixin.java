/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.MultifaceGrowthFeature
 *  net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.skd.sundering.mixin;

import com.skd.sundering.init.ModTag;
import com.skd.sundering.util.MixinUtils;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.MultifaceGrowthFeature;
import net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={MultifaceGrowthFeature.class})
public class NoMultifaceGrowthFeatureInStructuresMixin {
    @Inject(method={"Lnet/minecraft/world/level/levelgen/feature/MultifaceGrowthFeature;place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void cataclysm_noOreInStructures(FeaturePlaceContext<MultifaceGrowthConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        WorldGenLevel worldGenLevel = context.level();
        if (!(worldGenLevel instanceof WorldGenRegion)) {
            return;
        }
        WorldGenRegion worldGenRegion = (WorldGenRegion)worldGenLevel;
        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.origin(), ModTag.BLOCKED_MULTIFACE)) {
            cir.setReturnValue((Object)false);
        }
    }
}

