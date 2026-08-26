/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.blocks.Door_of_Seal_Block;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class Door_Of_Seal_BlockEntity
extends BlockEntity {
    public int Animaitonticks;
    public int tickCount;
    public int animation = 0;
    public Direction facing;
    public AnimationState openingAnimationState = new AnimationState();
    public AnimationState openAnimationState = new AnimationState();

    public Door_Of_Seal_BlockEntity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.DOOR_OF_SEAL.get(), pos, state);
        this.facing = (Direction)state.getValue((Property)BlockStateProperties.HORIZONTAL_FACING);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "opening") {
            return this.openingAnimationState;
        }
        if (input == "open") {
            return this.openAnimationState;
        }
        return new AnimationState();
    }

    public boolean triggerEvent(int p_58837_, int p_58838_) {
        if (p_58837_ == 1) {
            this.openingAnimationState.start(this.tickCount);
            return true;
        }
        return super.triggerEvent(p_58837_, p_58838_);
    }

    public static void tick(Level level, BlockPos pos, BlockState blockState, Door_Of_Seal_BlockEntity entity) {
        ++entity.tickCount;
        if (blockState.getBlock() instanceof Door_of_Seal_Block && ((Boolean)blockState.getValue((Property)Door_of_Seal_Block.LIT)).booleanValue()) {
            ++entity.Animaitonticks;
            if (!((Boolean)blockState.getValue((Property)Door_of_Seal_Block.OPEN)).booleanValue()) {
                if (entity.Animaitonticks == 1) {
                    ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf((Vec3i)pos), 20.0f, 0.05f, 0, 120);
                }
                if (entity.Animaitonticks == 28) {
                    level.playSound((Player)null, pos, (SoundEvent)ModSounds.DOOR_OF_SEAL_OPEN.get(), SoundSource.BLOCKS, 4.0f, level.getRandom().nextFloat() * 0.2f + 1.0f);
                    float x = (float)pos.getX() + 0.5f;
                    float y = pos.getY();
                    float z = (float)pos.getZ() + 0.5f;
                    if (!level.isClientSide()) {
                        level.explode(null, (double)x, (double)(y + 1.0f), (double)z, 2.0f, Level.ExplosionInteraction.TRIGGER);
                    }
                }
                if (entity.Animaitonticks >= 145 && !level.isClientSide()) {
                    level.setBlock(pos, (BlockState)blockState.setValue((Property)Door_of_Seal_Block.OPEN, (Comparable)Boolean.valueOf(true)), 2);
                    level.gameEvent((Holder)GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(null, (BlockState)blockState));
                    for (int i = 0; i <= 7; ++i) {
                        BlockPos[] toBreakPoses;
                        BlockPos abovePos = pos.above(i);
                        BlockPos blockpos1 = abovePos.relative(((Direction)blockState.getValue((Property)Door_of_Seal_Block.FACING)).getClockWise());
                        BlockPos blockpos2 = abovePos;
                        BlockPos blockpos3 = abovePos.relative(((Direction)blockState.getValue((Property)Door_of_Seal_Block.FACING)).getCounterClockWise());
                        BlockPos blockpos4 = abovePos.relative(((Direction)blockState.getValue((Property)Door_of_Seal_Block.FACING)).getClockWise(), 2);
                        BlockPos blockpos5 = abovePos.relative(((Direction)blockState.getValue((Property)Door_of_Seal_Block.FACING)).getCounterClockWise(), 2);
                        for (BlockPos toBreakPos : toBreakPoses = new BlockPos[]{blockpos1, blockpos2, blockpos3, blockpos4, blockpos5}) {
                            BlockState blockstate = level.getBlockState(toBreakPos);
                            if (!blockstate.is((Block)ModBlocks.DOOR_OF_SEAL.get())) continue;
                            level.setBlock(toBreakPos, (BlockState)blockstate.setValue((Property)Door_of_Seal_Block.OPEN, (Comparable)Boolean.valueOf(true)), 2);
                            level.gameEvent((Holder)GameEvent.BLOCK_CHANGE, toBreakPos, GameEvent.Context.of(null, (BlockState)blockstate));
                        }
                    }
                }
            } else {
                entity.Animaitonticks = 0;
                if (level.isClientSide()) {
                    entity.openingAnimationState.stop();
                    entity.openAnimationState.startIfStopped(entity.tickCount);
                }
            }
        }
    }

    public void onHit(Level level) {
        BlockPos blockpos = this.getBlockPos();
        BlockState state = this.getBlockState();
        if (!((Boolean)state.getValue((Property)Door_of_Seal_Block.LIT)).booleanValue()) {
            level.setBlock(blockpos, (BlockState)state.setValue((Property)Door_of_Seal_Block.LIT, (Comparable)Boolean.valueOf(true)), 2);
            this.level.blockEvent(blockpos, this.getBlockState().getBlock(), 1, 0);
        }
    }

    protected void loadAdditional(CompoundTag p_155745_, HolderLookup.Provider p_323876_) {
        super.loadAdditional(p_155745_, p_323876_);
        this.Animaitonticks = p_155745_.getInt("animationTicks");
    }

    protected void saveAdditional(CompoundTag p_187518_, HolderLookup.Provider p_324418_) {
        super.saveAdditional(p_187518_, p_324418_);
        p_187518_.putInt("animationTicks", this.Animaitonticks);
    }
}

