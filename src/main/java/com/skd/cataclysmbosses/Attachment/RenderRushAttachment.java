/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.Attachment;

import com.skd.cataclysmbosses.client.particle.Options.RingParticleOptions;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Halberd_Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RenderRushAttachment {
    private boolean charge;
    public int Timer;
    public float damage;

    public void tick(LivingEntity entity) {
        if (this.isRush()) {
            int standingOnY = Mth.floor((double)entity.getY()) - 3;
            double headY = entity.getY() + 2.0;
            float yawRadians = (float)Math.toRadians(90.0f + entity.getYRot());
            int temp = this.getTimer();
            this.setTimer(temp - 1);
            if (temp > 0) {
                double yaw = Math.toRadians(entity.getYRot() + 90.0f);
                double xExpand = 3.0 * Math.cos(yaw);
                double zExpand = 3.0 * Math.sin(yaw);
                AABB attackRange = entity.getBoundingBox().expandTowards(xExpand, 0.0, zExpand);
                for (LivingEntity target : entity.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
                    if (target.isAlliedTo((Entity)entity) || target == entity) continue;
                    target.hurt(entity.damageSources().mobAttack(entity), this.getdamage());
                }
                if (temp % 2 == 0) {
                    this.spawnFangs(entity.getX(), headY, entity.getZ(), standingOnY, yawRadians, 1, entity.level(), entity);
                    double x = entity.getX();
                    double y = entity.getY() + (double)(entity.getBbHeight() / 2.0f);
                    double z = entity.getZ();
                    float yaw2 = (float)Math.toRadians(-entity.getYRot());
                    float yaw3 = (float)Math.toRadians(-entity.getYRot() + 180.0f);
                    entity.level().addParticle((ParticleOptions)new RingParticleOptions(yaw2, 0.0f, 20, 86, 236, 204, 1.0f, 30.0f, false, 2), x, y, z, 0.0, 0.0, 0.0);
                    entity.level().addParticle((ParticleOptions)new RingParticleOptions(yaw3, 0.0f, 20, 86, 236, 204, 1.0f, 30.0f, false, 2), x, y, z, 0.0, 0.0, 0.0);
                }
            }
            if (temp == 0) {
                this.setRush(false);
            }
        }
    }

    private void spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, LivingEntity player) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)y, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1;
            BlockState blockstate;
            if (!(blockstate = world.getBlockState(blockpos1 = blockpos.below())).isFaceSturdy((BlockGetter)world, blockpos1, Direction.UP)) continue;
            if (!world.isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = world.getBlockState(blockpos)).getCollisionShape((BlockGetter)world, blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.below()).getY() >= lowestYCheck);
        if (flag) {
            world.addFreshEntity((Entity)new Phantom_Halberd_Entity(world, x, (double)blockpos.getY() + d0, z, yRot, warmupDelayTicks, player, (float)CMCommonConfig.SoulRender.phantomHalberdDamage));
        }
    }

    public void setRush(boolean charge) {
        this.charge = charge;
    }

    public boolean isRush() {
        return this.charge;
    }

    public void setdamage(float damage) {
        this.damage = damage;
    }

    public float getdamage() {
        return this.damage;
    }

    public void setTimer(int timer) {
        this.Timer = timer;
    }

    public int getTimer() {
        return this.Timer;
    }
}

