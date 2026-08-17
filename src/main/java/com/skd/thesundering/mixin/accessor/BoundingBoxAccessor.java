/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.skd.thesundering.mixin.accessor;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={BoundingBox.class})
public interface BoundingBoxAccessor {
    @Accessor(value="minX")
    public void setMinX(int var1);

    @Accessor(value="minY")
    public void setMinY(int var1);

    @Accessor(value="minZ")
    public void setMinZ(int var1);

    @Accessor(value="maxX")
    public void setMaxX(int var1);

    @Accessor(value="maxY")
    public void setMaxY(int var1);

    @Accessor(value="maxZ")
    public void setMaxZ(int var1);
}

