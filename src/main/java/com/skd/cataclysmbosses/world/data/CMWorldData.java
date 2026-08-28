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
package com.skd.cataclysmbosses.world.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.storage.SavedDataStorage;
import net.minecraft.resources.Identifier;
import net.minecraft.util.datafix.DataFixTypes;

public class CMWorldData
extends SavedData {
    private static final String IDENTIFIER = "cataclysm_world_data";
    private boolean LeviathanBossDefeatedOnce = false;
    private boolean IgnisBossDefeatedOnce = false;

    private CMWorldData() {
    }

    public static SavedDataType<CMWorldData> type() {
        return new SavedDataType<>(
            Identifier.withDefaultNamespace(IDENTIFIER),
            CMWorldData::new,
            null, // Codec - will use default compound tag
            DataFixTypes.LEVEL_DATA
        );
    }

    public static CMWorldData get(Level world, ResourceKey<Level> dim) {
        if (world instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)world;
            ServerLevel targetLevel = serverLevel.getServer().getLevel(dim);
            if (targetLevel == null) {
                targetLevel = serverLevel.getServer().overworld();
            }
            SavedDataStorage storage = targetLevel.getDataStorage();
            CMWorldData data = storage.computeIfAbsent(CMWorldData.type());
            if (data != null) {
                data.setDirty();
            }
            return data;
        }
        return null;
    }

    // Legacy method for backward compatibility - will be called via SavedDataStorage
    public static CMWorldData load(CompoundTag nbt, HolderLookup.Provider p_323806_) {
        CMWorldData data = new CMWorldData();
        data.LeviathanBossDefeatedOnce = nbt.getBoolean("LeviathanDefeatedOnce");
        data.IgnisBossDefeatedOnce = nbt.getBoolean("IgnisDefeatedOnce");
        return data;
    }

    // Legacy save method
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