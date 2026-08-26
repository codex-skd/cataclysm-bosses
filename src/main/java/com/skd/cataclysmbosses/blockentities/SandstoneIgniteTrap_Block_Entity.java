/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.AABB
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.blocks.Sandstone_Ignite_Trap;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.init.ModTileentites;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;

public class SandstoneIgniteTrap_Block_Entity
extends BlockEntity {
    public int tickCount;
    private final RandomSource random = RandomSource.create();

    public SandstoneIgniteTrap_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.SANDSTONE_IGNITE_TRAP.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, SandstoneIgniteTrap_Block_Entity entity) {
        entity.tick(level, pos);
    }

    public void tick(Level level, BlockPos pos) {
        boolean LIT = false;
        if (this.getBlockState().getBlock() instanceof Sandstone_Ignite_Trap) {
            LIT = (Boolean)this.getBlockState().getValue((Property)Sandstone_Ignite_Trap.LIT);
        }
        if (LIT) {
            ++this.tickCount;
            double x = pos.getX();
            double y = pos.above().getY();
            double z = pos.getZ();
            if (level.isClientSide()) {
                level.addParticle((ParticleOptions)ModParticle.TRAP_FLAME.get(), x + 0.5, y, z + 0.5, 0.0, 0.5, 0.0);
            } else if (this.tickCount % 5 == 0) {
                List entitiesInRange = level.getEntitiesOfClass(LivingEntity.class, new AABB(pos.offset(-1, 0, -1).getCenter(), pos.offset(1, 6, 1).getCenter()));
                for (LivingEntity entity : entitiesInRange) {
                    if (entity.getType().is(ModTag.TEAM_ANCIENT_REMNANT) || entity.fireImmune()) continue;
                    entity.hurtOrSimulate(entity.level().damageSources().inFire(), 5.0f);
                    entity.igniteForSeconds(5.0f);
                }
            }
        } else {
            this.tickCount = 0;
        }
    }
}

