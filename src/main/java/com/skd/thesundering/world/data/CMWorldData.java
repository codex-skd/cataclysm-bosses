/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.minecraft.world.level.saveddata.SavedData$Factory
 *  net.minecraft.world.level.storage.DimensionDataStorage
 */
package com.skd.thesundering.world.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

public class CMWorldData
extends SavedData {
    private static final String IDENTIFIER = "cataclysm_world_data";
    private boolean LeviathanBossDefeatedOnce = false;
    private boolean IgnisBossDefeatedOnce = false;

    private CMWorldData() {
    }

    public static SavedData.Factory<CMWorldData> factory() {
        return new SavedData.Factory(CMWorldData::new, CMWorldData::load);
    }

    public static CMWorldData get(Level world, ResourceKey<Level> dim) {
        if (world instanceof ServerLevel) {
            DimensionDataStorage storage;
            CMWorldData data;
            ServerLevel serverLevel = (ServerLevel)world;
            ServerLevel targetLevel = serverLevel.getServer().getLevel(dim);
            if (targetLevel == null) {
                targetLevel = serverLevel.getServer().overworld();
            }
            if ((data = (CMWorldData)(storage = targetLevel.getDataStorage()).computeIfAbsent(CMWorldData.factory(), IDENTIFIER)) != null) {
                data.setDirty();
            }
            return data;
        }
        return null;
    }

    public static CMWorldData load(CompoundTag nbt, HolderLookup.Provider p_323806_) {
        CMWorldData data = new CMWorldData();
        data.LeviathanBossDefeatedOnce = nbt.getBoolean("LeviathanDefeatedOnce");
        data.IgnisBossDefeatedOnce = nbt.getBoolean("IgnisDefeatedOnce");
        return data;
    }

    public CompoundTag save(CompoundTag compound, HolderLookup.Provider p_323890_) {
        compound.putBoolean("LeviathanDefeatedOnce", this.LeviathanBossDefeatedOnce);
        compound.putBoolean("IgnisDefeatedOnce", this.IgnisBossDefeatedOnce);
        return compound;
    }

    public boolean isLeviathanDefeatedOnce() {
        return this.LeviathanBossDefeatedOnce;
    }

    public void setLeviathanDefeatedOnce(boolean defeatedOnce) {
        this.LeviathanBossDefeatedOnce = defeatedOnce;
    }

    public boolean isIgnisDefeatedOnce() {
        return this.IgnisBossDefeatedOnce;
    }

    public void setIgnisDefeatedOnce(boolean defeatedOnce) {
        this.IgnisBossDefeatedOnce = defeatedOnce;
    }
}

