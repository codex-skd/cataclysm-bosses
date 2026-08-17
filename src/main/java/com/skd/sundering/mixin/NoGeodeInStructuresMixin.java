/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.GeodeFeature
 *  net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration
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
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GeodeFeature.class})
public class NoGeodeInStructuresMixin {
    @Inject(method={"place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void cataclysm_noGeodeInStructures(FeaturePlaceContext<GeodeConfiguration> context, CallbackInfoReturnable<Boolean> cir) {
        WorldGenLevel worldGenLevel = context.level();
        if (!(worldGenLevel instanceof WorldGenRegion)) {
            return;
        }
        WorldGenRegion worldGenRegion = (WorldGenRegion)worldGenLevel;
        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, context.origin(), ModTag.BLOCKED_GEODE)) {
            cir.setReturnValue((Object)false);
        }
    }
}

