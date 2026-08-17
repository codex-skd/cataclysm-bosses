/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.sundering.init;

import com.skd.sundering.world.structures.Processor.WaterlogWhenReplacingWaterProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModStructureProcessor {
    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR = DeferredRegister.create((ResourceKey)Registries.STRUCTURE_PROCESSOR, (String)"cataclysm");
    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<WaterlogWhenReplacingWaterProcessor>> WATERLOGGING_WHEN_REPLACING_WATER_PROCESSOR = STRUCTURE_PROCESSOR.register("waterlogging_when_replacing_water_processor", () -> () -> WaterlogWhenReplacingWaterProcessor.CODEC);
}

