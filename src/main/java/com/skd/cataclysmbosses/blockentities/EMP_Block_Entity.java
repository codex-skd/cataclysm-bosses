/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.blocks.EMP_Block;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class EMP_Block_Entity
extends BlockEntity {
    private float chompProgress;
    private float prevChompProgress;
    public int ticksExisted;

    public EMP_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.EMP.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, EMP_Block_Entity entity) {
        entity.tick();
    }

    public void tick() {
        this.prevChompProgress = this.chompProgress;
        boolean powered = false;
        if (this.getBlockState().getBlock() instanceof EMP_Block) {
            powered = (Boolean)this.getBlockState().getValue((Property)EMP_Block.POWERED);
        }
        boolean overload = false;
        if (this.getBlockState().getBlock() instanceof EMP_Block) {
            overload = (Boolean)this.getBlockState().getValue((Property)EMP_Block.OVERLOAD);
        }
        if (powered && this.chompProgress < 15.0f) {
            this.chompProgress += 1.0f;
        }
        if (!powered && this.chompProgress > 0.0f) {
            this.chompProgress -= 1.0f;
        }
        float x = (float)this.getBlockPos().getX() + 0.5f;
        float y = (float)this.getBlockPos().getY() + 0.5f;
        float z = (float)this.getBlockPos().getZ() + 0.5f;
        if (!overload && this.chompProgress == 15.0f) {
            this.level.addParticle((ParticleOptions)ModParticle.EM_PULSE.get(), (double)x, (double)y, (double)z, 0.0, 0.0, 0.0);
            ScreenShake_Entity.ScreenShake(this.level, Vec3.atCenterOf((Vec3i)this.getBlockPos()), 20.0f, 0.01f, 0, 20);
            this.level.playSound((Player)null, this.getBlockPos(), (SoundEvent)ModSounds.EMP_ACTIVATED.get(), SoundSource.BLOCKS, 4.0f, this.level.getRandom().nextFloat() * 0.2f + 1.0f);
            this.level.setBlockAndUpdate(this.getBlockPos(), (BlockState)this.getBlockState().setValue((Property)EMP_Block.OVERLOAD, (Comparable)Boolean.valueOf(true)));
            AABB screamBox = new AABB((double)((float)this.getBlockPos().getX() - 5.0f), (double)((float)this.getBlockPos().getY() - 5.0f), (double)(this.getBlockPos().getZ() - 5), (double)(this.getBlockPos().getX() + 5), (double)((float)this.getBlockPos().getY() + 5.0f), (double)((float)this.getBlockPos().getZ() + 5.0f));
            for (LivingEntity entity : this.level.getEntitiesOfClass(LivingEntity.class, screamBox)) {
                entity.hurtOrSimulate(CMDamageTypes.getDamageSource(this.level, CMDamageTypes.EMP, new EntityType[0]), (float)(3 + entity.getRandom().nextInt(3)));
            }
        }
        ++this.ticksExisted;
    }

    public float getChompProgress(float partialTick) {
        return this.prevChompProgress + (this.chompProgress - this.prevChompProgress) * partialTick;
    }
}

