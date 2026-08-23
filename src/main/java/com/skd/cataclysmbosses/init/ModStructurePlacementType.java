/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.levelgen.structure.placement.StructurePlacement
 *  net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.world.structures.placements.CataclysmRandomSpread;
import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModStructurePlacementType {
    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPES = DeferredRegister.create((ResourceKey)Registries.STRUCTURE_PLACEMENT, (String)"cataclysm");
    public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<CataclysmRandomSpread>> ADVANCED_RANDOM_SPREAD = ModStructurePlacementType.registerPlacer("cataclysm_random_spread", () -> () -> CataclysmRandomSpread.CODEC);

    private static <P extends StructurePlacement> DeferredHolder<StructurePlacementType<?>, StructurePlacementType<P>> registerPlacer(String name, Supplier<StructurePlacementType<P>> factory) {
        return STRUCTURE_PLACEMENT_TYPES.register(name, factory);
    }
}

