/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderGetter
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientGamePacketListener
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerEntity
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Cm_Falling_Block_Entity
extends Entity {
    public int duration = 20;
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(Cm_Falling_Block_Entity.class, (EntityDataSerializer)EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(Cm_Falling_Block_Entity.class, (EntityDataSerializer)EntityDataSerializers.BLOCK_STATE);

    public Cm_Falling_Block_Entity(EntityType<Cm_Falling_Block_Entity> type, Level level) {
        super(type, level);
    }

    public Cm_Falling_Block_Entity(Level p_31953_, double p_31954_, double p_31955_, double p_31956_, BlockState p_31957_, int duration) {
        this((EntityType<Cm_Falling_Block_Entity>)((EntityType)ModEntities.CM_FALLING_BLOCK.get()), p_31953_);
        this.setBlockState(p_31957_);
        this.setPos(p_31954_, p_31955_ + (double)((1.0f - this.getBbHeight()) / 2.0f), p_31956_);
        this.setDeltaMovement(Vec3.ZERO);
        this.duration = duration;
        this.xo = p_31954_;
        this.yo = p_31955_;
        this.zo = p_31956_;
        this.setStartPos(this.blockPosition());
    }

    public void setStartPos(BlockPos p_31960_) {
        this.entityData.set(DATA_START_POS, p_31960_);
    }

    public BlockPos getStartPos() {
        return (BlockPos)this.entityData.get(DATA_START_POS);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DATA_START_POS, BlockPos.ZERO);
        p_326229_.define(BLOCK_STATE, Blocks.AIR.defaultBlockState());
    }

    public BlockState getBlockState() {
        return (BlockState)this.entityData.get(BLOCK_STATE);
    }

    public void setBlockState(BlockState p_270267_) {
        this.entityData.set(BLOCK_STATE, p_270267_);
    }

    public void tick() {
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
        if (this.onGround() && this.tickCount > this.duration) {
            this.discard();
        }
        if (this.tickCount > 300) {
            this.discard();
        }
    }

    protected void addAdditionalSaveData(ValueOutput p_31973_) {
        p_31973_.store("block_state", net.minecraft.world.level.block.state.BlockState.CODEC, this.getBlockState());
        p_31973_.putInt("Time", this.duration);
    }

    protected void readAdditionalSaveData(ValueInput p_31964_) {
        this.setBlockState(p_31964_.read("block_state", net.minecraft.world.level.block.state.BlockState.CODEC).orElse(Blocks.AIR.defaultBlockState()));
        this.duration = p_31964_.getIntOr("Time", 0);
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity p_352287_) {
        return new ClientboundAddEntityPacket((Entity)this, p_352287_, Block.getId((BlockState)this.getBlockState()));
    }

    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    public boolean hurtServer(net.minecraft.server.level.ServerLevel level, net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }
}

