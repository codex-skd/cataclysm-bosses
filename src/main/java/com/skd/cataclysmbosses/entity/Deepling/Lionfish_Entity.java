package com.skd.cataclysmbosses.entity.Deepling;

import net.minecraft.core.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jspecify.annotations.Nullable;

/*
 * PORT NOTE (26.2): placeholder — original Lionfish_Entity class was missing from the
 * decompiled port (referenced by ModEntities but never ported). Minimal stub that
 * extends AbstractDeepling so ModEntities and Deepling_Angler_Entity compile; proper
 * AI/goal port is tracked separately.
 */
public class Lionfish_Entity extends AbstractDeepling {
    public Lionfish_Entity(EntityType<? extends Lionfish_Entity> type, Level level) {
        super(type, level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason reason, @Nullable SpawnGroupData spawnData) {
        return super.finalizeSpawn(level, difficulty, reason, spawnData);
    }

    @Override
    public boolean checkSpawnObstruction(Level level) {
        return super.checkSpawnObstruction(level);
    }

    @Override
    public BlockPos getBlockPosBelowThatAffectsMyMovement() {
        return super.getBlockPosBelowThatAffectsMyMovement();
    }

    public static net.minecraft.world.entity.EntityType.Builder<Lionfish_Entity> lionfish() {
        return net.minecraft.world.entity.EntityType.Builder.<Lionfish_Entity>of(Lionfish_Entity::new, net.minecraft.world.entity.MobCategory.MONSTER)
            .sized(0.6f, 0.55f)
            .clientTrackingRange(4);
    }
}