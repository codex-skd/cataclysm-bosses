/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectListIterator
 *  net.minecraft.world.level.levelgen.Beardifier
 *  net.minecraft.world.level.levelgen.Beardifier$Rigid
 *  net.minecraft.world.level.levelgen.structure.pools.JigsawJunction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.skd.cataclysmbosses.mixin.accessor;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.world.level.levelgen.Beardifier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawJunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Beardifier.class})
public interface BeardifierAccessor {
    @Accessor
    public ObjectListIterator<Beardifier.Rigid> getPieceIterator();

    @Accessor
    public ObjectListIterator<JigsawJunction> getJunctionIterator();
}

