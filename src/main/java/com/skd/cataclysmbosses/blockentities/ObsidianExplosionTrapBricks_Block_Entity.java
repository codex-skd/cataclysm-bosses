/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.blocks.ObsidianExplosionTrapBricks;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ObsidianExplosionTrapBricks_Block_Entity
extends BlockEntity {
    public int tickCount;

    public ObsidianExplosionTrapBricks_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, ObsidianExplosionTrapBricks_Block_Entity entity) {
        entity.tick();
    }

    public void tick() {
        boolean LIT = false;
        if (this.getBlockState().getBlock() instanceof ObsidianExplosionTrapBricks) {
            LIT = (Boolean)this.getBlockState().getValue((Property)ObsidianExplosionTrapBricks.LIT);
        }
        if (LIT) {
            ++this.tickCount;
            float x = (float)this.getBlockPos().getX() + 0.5f;
            float y = this.getBlockPos().getY();
            float z = (float)this.getBlockPos().getZ() + 0.5f;
            float f = 5.0f;
            if (this.tickCount < 80) {
                for (LivingEntity inRange : this.level.getEntitiesOfClass(LivingEntity.class, new AABB((double)x - (double)f, (double)y - (double)f, (double)z - (double)f, (double)x + (double)f, (double)y + (double)f, (double)z + (double)f))) {
                    if (inRange instanceof Player && ((Player)inRange).getAbilities().invulnerable || inRange.getType().is(ModTag.TRAP_BLOCK_NOT_DETECTED)) continue;
                    Vec3 diff = inRange.position().subtract(Vec3.atCenterOf((Vec3i)this.getBlockPos().offset(0, 0, 0)));
                    diff = diff.normalize().scale(0.06);
                    inRange.setDeltaMovement(inRange.getDeltaMovement().subtract(diff));
                }
                if (this.level.isClientSide()) {
                    for (int i = 0; i < 3; ++i) {
                        int j = this.level.getRandom().nextInt(2) * 2 - 1;
                        int k = this.level.getRandom().nextInt(2) * 2 - 1;
                        double d0 = (double)this.worldPosition.getX() + 0.5 + 0.25 * (double)j;
                        double d1 = (float)this.worldPosition.getY() + this.level.getRandom().nextFloat();
                        double d2 = (double)this.worldPosition.getZ() + 0.5 + 0.25 * (double)k;
                        double d3 = this.level.getRandom().nextFloat() * (float)j;
                        double d4 = ((double)this.level.getRandom().nextFloat() - 0.5) * 0.125;
                        double d5 = this.level.getRandom().nextFloat() * (float)k;
                        this.level.addParticle((ParticleOptions)ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
                    }
                }
            }
            if (this.tickCount == 80 && !this.level.isClientSide()) {
                this.level.explode(null, (double)x, (double)(y + 1.0f), (double)z, 3.0f, Level.ExplosionInteraction.NONE);
            }
        } else {
            this.tickCount = 0;
        }
    }
}

