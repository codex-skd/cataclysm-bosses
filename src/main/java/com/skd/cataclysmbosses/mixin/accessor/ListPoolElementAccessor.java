/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.levelgen.structure.pools.ListPoolElement
 *  net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.skd.cataclysmbosses.mixin.accessor;

import java.util.List;
import net.minecraft.world.level.levelgen.structure.pools.ListPoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ListPoolElement.class})
public interface ListPoolElementAccessor {
    @Accessor
    public List<StructurePoolElement> getElements();
}

