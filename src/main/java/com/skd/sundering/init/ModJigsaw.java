/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.sundering.init;

import com.skd.sundering.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModJigsaw {
    public static final DeferredRegister<StructurePoolElementType<?>> STRUCTURE_POOL_ELEMENT = DeferredRegister.create((Registry)BuiltInRegistries.STRUCTURE_POOL_ELEMENT, (String)"cataclysm");
    public static final DeferredHolder<StructurePoolElementType<?>, StructurePoolElementType<CataclysmJigsawSinglePoolElement>> CATACLYSM_ELEMENT = STRUCTURE_POOL_ELEMENT.register("cataclysm_element", () -> () -> CataclysmJigsawSinglePoolElement.CODEC);
}

