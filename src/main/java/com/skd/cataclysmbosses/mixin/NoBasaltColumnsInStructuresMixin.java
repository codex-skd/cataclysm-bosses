/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.skd.cataclysmbosses.mixin;

import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.util.MixinUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BasaltColumnsFeature.class})
public class NoBasaltColumnsInStructuresMixin {
    @Inject(method={"canPlaceAt(Lnet/minecraft/world/level/LevelAccessor;ILnet/minecraft/core/BlockPos$MutableBlockPos;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private static void cataclysm_noBasaltColumnsInStructures(LevelAccessor levelAccessor, int seaLevel, BlockPos.MutableBlockPos mutableBlockPos, CallbackInfoReturnable<Boolean> cir) {
        if (!(levelAccessor instanceof WorldGenRegion)) {
            return;
        }
        WorldGenRegion worldGenRegion = (WorldGenRegion)levelAccessor;
        if (MixinUtils.isPositionInTaggedStructure(worldGenRegion, (BlockPos)mutableBlockPos, ModTag.BLOCKED_BASALT)) {
            cir.setReturnValue((Object)false);
        }
    }
}

