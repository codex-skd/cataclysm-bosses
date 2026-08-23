/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.DynamicOps
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.NbtOps
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.Level
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.Nullable
 */
package com.skd.cataclysmbosses.entity.etc;

import com.skd.cataclysmbosses.Cataclysm;
import com.mojang.serialization.DynamicOps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

public interface IHomeEntity {
    default public void addAdditionalHomePoint(CompoundTag tag) {
        if (this.getHomePos() != null) {
            GlobalPos.CODEC.encodeStart((DynamicOps)NbtOps.INSTANCE, (Object)this.getHomePos()).resultOrPartial(arg_0 -> ((Logger)Cataclysm.LOGGER).error(arg_0)).ifPresent(tag1 -> tag.put("HomePos", tag1));
        }
    }

    default public void readAdditionalHomePoint(CompoundTag tag) {
        if (tag.contains("Home", 9)) {
            ListTag nbttaglist = tag.getList("Home", 6);
            double hx = nbttaglist.getDouble(0);
            double hy = nbttaglist.getDouble(1);
            double hz = nbttaglist.getDouble(2);
            this.setHomePos(GlobalPos.of((ResourceKey)Level.OVERWORLD, (BlockPos)BlockPos.containing((double)hx, (double)hy, (double)hz)));
        } else if (tag.contains("HomePos")) {
            this.setHomePos(GlobalPos.CODEC.parse((DynamicOps)NbtOps.INSTANCE, (Object)tag.get("HomePos")).resultOrPartial(arg_0 -> ((Logger)Cataclysm.LOGGER).error(arg_0)).orElse(null));
        }
    }

    @Nullable
    public GlobalPos getHomePos();

    public void setHomePos(@Nullable GlobalPos var1);
}

