/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.SpawnReason
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.blocks.Cursed_Tombstone_Block;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class Cursed_tombstone_Entity
extends BlockEntity {
    public int tickCount;
    public int summonCooldownProgress = 0;
    private final RandomSource rnd = RandomSource.create();

    public Cursed_tombstone_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.CURSED_TOMBSTONE.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState blockState, Cursed_tombstone_Entity entity) {
        if (blockState.getBlock() instanceof Cursed_Tombstone_Block) {
            if (!((Boolean)blockState.getValue((Property)Cursed_Tombstone_Block.POWERED)).booleanValue()) {
                if (entity.summonCooldownProgress < CMCommonConfig.Blocks.CursedTombstoneCooldown * 1200) {
                    ++entity.summonCooldownProgress;
                } else {
                    level.setBlock(pos, (BlockState)blockState.setValue((Property)Cursed_Tombstone_Block.POWERED, (Comparable)Boolean.valueOf(true)), 2);
                    level.gameEvent((Holder)GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(null, (BlockState)blockState));
                }
            } else if (((Boolean)blockState.getValue((Property)Cursed_Tombstone_Block.LIT)).booleanValue()) {
                ++entity.tickCount;
                if (entity.tickCount == 1) {
                    ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf((Vec3i)pos), 20.0f, 0.05f, 0, 80);
                }
                if (entity.tickCount > 60 && entity.tickCount < 63) {
                    double d0 = (float)pos.getX() + 0.5f;
                    double d1 = pos.getY() + 2;
                    double d2 = (float)pos.getZ() + 0.5f;
                    float size = 3.0f;
                    for (float i = -size; i <= size; i += 1.0f) {
                        for (float j = -size; j <= size; j += 1.0f) {
                            for (float k = -size; k <= size; k += 1.0f) {
                                double d3 = (double)j + (entity.rnd.nextDouble() - entity.rnd.nextDouble()) * 0.5;
                                double d4 = (double)i + (entity.rnd.nextDouble() - entity.rnd.nextDouble()) * 0.5;
                                double d5 = (double)k + (entity.rnd.nextDouble() - entity.rnd.nextDouble()) * 0.5;
                                double d6 = (double)Mth.sqrt((float)((float)(d3 * d3 + d4 * d4 + d5 * d5))) / 0.5 + entity.rnd.nextGaussian() * 0.05;
                                level.addParticle((ParticleOptions)ModParticle.PHANTOM_WING_FLAME.get(), d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);
                                if (i == -size || i == size || j == -size || j == size) continue;
                                k += size * 2.0f - 1.0f;
                            }
                        }
                    }
                }
                if (entity.tickCount > 63) {
                    Maledictus_Entity maledictus = (Maledictus_Entity)((EntityType)ModEntities.MALEDICTUS.get()).create(level);
                    if (level instanceof ServerLevel) {
                        ServerLevel serverLevel = (ServerLevel)level;
                        if (maledictus != null) {
                            ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf((Vec3i)pos), 20.0f, 0.1f, 0, 40);
                            maledictus.setPos((double)pos.getX() + 0.5, pos.getY() + 2, (double)pos.getZ() + 0.5);
                            maledictus.setTombstoneDirection((Direction)blockState.getValue((Property)Cursed_Tombstone_Block.FACING));
                            maledictus.setHomePos(GlobalPos.of((ResourceKey)serverLevel.dimension(), (BlockPos)pos));
                            // maledictus.finalizeSpawn((ServerLevelAccessor)serverLevel, serverLevel.getCurrentDifficultyAt(pos), SpawnReason.SPAWNER, null);
                            int MthX = Mth.floor((float)pos.getX());
                            int MthY = Mth.floor((float)pos.getY());
                            int MthZ = Mth.floor((float)pos.getZ());
                            for (int k2 = -1; k2 <= 1; ++k2) {
                                for (int l2 = -1; l2 <= 1; ++l2) {
                                    for (int j = 0; j <= 5; ++j) {
                                        int i3 = MthX + k2;
                                        int k = MthY + j;
                                        int l = MthZ + l2;
                                        BlockPos blockpos = new BlockPos(i3, k, l);
                                        BlockState block = level.getBlockState(blockpos);
                                        if (block == Blocks.AIR.defaultBlockState() || block.is(ModTag.ALTAR_DESTROY_IMMUNE)) continue;
                                        level.destroyBlock(blockpos, false);
                                    }
                                }
                            }
                            if (level.addFreshEntity((Entity)maledictus)) {
                                level.destroyBlock(pos, false);
                            }
                        }
                    }
                }
            } else {
                entity.tickCount = 0;
            }
        }
    }

    public void loadAdditional(CompoundTag p_155312_, HolderLookup.Provider p_324612_) {
        super.loadAdditional(p_155312_, p_324612_);
        if (p_155312_.contains("summonCooldownProgress", 11)) {
            this.summonCooldownProgress = p_155312_.getInt("summonCooldownProgress");
        }
    }

    protected void saveAdditional(CompoundTag p_187518_, HolderLookup.Provider p_324418_) {
        super.saveAdditional(p_187518_, p_324418_);
        p_187518_.putInt("summonCooldownProgress", this.summonCooldownProgress);
    }
}

