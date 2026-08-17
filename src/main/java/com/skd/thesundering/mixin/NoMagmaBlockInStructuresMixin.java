/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.UnderwaterMagmaFeature
 *  net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.skd.thesundering.mixin;

import com.skd.thesundering.init.ModTag;
import com.skd.thesundering.util.MixinUtils;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.UnderwaterMagmaFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={UnderwaterMagmaFeature.class})
public class NoMagmaBlockInStructuresMixin {
    @Inject(method={"place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z"}, cancellable=true, at={@At(value="HEAD")})
    private void cataclysm_noMagmablockInStructures(FeaturePlaceContext<DeltaFeatureConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        WorldGenLevel worldGenLevel = context.level();
        if (!(worldGenLevel instanceof WorldGenRegion)) {
            return;
        }
        WorldGenRegion worldGenRegion = (WorldGenRegion)worldGenLevel;
        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.origin(), ModTag.BLOCKED_MAGMA_BLOCK)) {
            cir.setReturnValue((Object)false);
        }
    }
}

