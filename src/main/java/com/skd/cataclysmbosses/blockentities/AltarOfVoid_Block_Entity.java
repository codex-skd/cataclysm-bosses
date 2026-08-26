/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class AltarOfVoid_Block_Entity
extends BlockEntity {
    protected static final int SHORT_RANGE = 6;
    protected boolean spawnedBoss = false;

    public AltarOfVoid_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.ALTAR_OF_VOID.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, AltarOfVoid_Block_Entity entity) {
        entity.tick(level, pos, state, entity);
    }

    public boolean anyPlayerInRange(Level level, BlockPos pos) {
        return level.hasNearbyAlivePlayer((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, (double)this.getRange());
    }

    public void tick(Level level, BlockPos pos, BlockState state, AltarOfVoid_Block_Entity te) {
        if (this.spawnedBoss || !this.anyPlayerInRange(level, pos)) {
            return;
        }
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            if (level.getDifficulty() != Difficulty.PEACEFUL && this.spawnMyBoss(serverLevel, pos)) {
                level.destroyBlock(pos, false);
                this.spawnedBoss = true;
            }
        }
    }

    protected boolean spawnMyBoss(ServerLevel serverLevel, BlockPos pos) {
        Vec3 vec3 = Vec3.atLowerCornerWithOffset((Vec3i)pos, (double)0.5, (double)0.0, (double)0.5);
        Ender_Guardian_Entity entity = (Ender_Guardian_Entity)((EntityType)ModEntities.ENDER_GUARDIAN.get()).create((Level)serverLevel, EntitySpawnReason.EVENT);
        if (entity != null) {
            entity.setPos(vec3);
            // entity.finalizeSpawn((ServerLevelAccessor)serverLevel, serverLevel.getCurrentDifficultyAt(this.worldPosition), EntitySpawnReason.SPAWNER, null);
            entity.setUsedMassDestruction(false);
            entity.setHomePos(GlobalPos.of((ResourceKey)serverLevel.dimension(), (BlockPos)pos));
            return serverLevel.addFreshEntity((Entity)entity);
        }
        return false;
    }

    protected int getRange() {
        return 6;
    }
}

