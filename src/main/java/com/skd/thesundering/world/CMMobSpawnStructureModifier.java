/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.Holder
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.neoforged.neoforge.common.world.ModifiableStructureInfo$StructureInfo$Builder
 *  net.neoforged.neoforge.common.world.StructureModifier
 *  net.neoforged.neoforge.common.world.StructureModifier$Phase
 */
package com.skd.thesundering.world;

import com.skd.thesundering.init.ModStructureModifiers;
import com.skd.thesundering.world.CMWorldRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.common.world.ModifiableStructureInfo;
import net.neoforged.neoforge.common.world.StructureModifier;

public class CMMobSpawnStructureModifier
implements StructureModifier {
    public static final CMMobSpawnStructureModifier INSTANCE = new CMMobSpawnStructureModifier();

    public void modify(Holder<Structure> structure, StructureModifier.Phase phase, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (phase == StructureModifier.Phase.ADD) {
            CMWorldRegistry.modifyStructure(structure, builder);
        }
    }

    public MapCodec<? extends StructureModifier> codec() {
        return (MapCodec)ModStructureModifiers.ADD_SPAWNS_STRUCTURE_MODIFIER_TYPE.get();
    }
}

