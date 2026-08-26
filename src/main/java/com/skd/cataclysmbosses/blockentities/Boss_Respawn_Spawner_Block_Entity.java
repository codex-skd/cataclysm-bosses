/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.EntitySpawnReason
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.blocks.Boss_Respawn_Spawner_Block;
import com.skd.cataclysmbosses.entity.etc.IHomeEntity;
import com.skd.cataclysmbosses.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

public class Boss_Respawn_Spawner_Block_Entity
extends BlockEntity {
    public int Animaitonticks;
    public int tickCount;
    public int animation = 0;
    public AnimationState openingAnimationState = new AnimationState();
    protected static final int SHORT_RANGE = 9;
    protected static final int LONG_RANGE = 50;
    private Entity displayEntity;
    private EntityType<?> spawnType = null;
    protected boolean spawnedBoss = false;
    private ItemStack item = ItemStack.EMPTY;

    public Boss_Respawn_Spawner_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.BOSS_RESPAWNER.get(), pos, state);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "opening") {
            return this.openingAnimationState;
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

    public static void tick(Level level, BlockPos pos, BlockState state, Boss_Respawn_Spawner_Block_Entity te) {
        ++te.tickCount;
        if (te.spawnedBoss || !te.anyPlayerInRange(level)) {
            return;
        }
        if (state.getBlock() instanceof Boss_Respawn_Spawner_Block) {
            if (((Boolean)state.getValue((Property)Boss_Respawn_Spawner_Block.LIT)).booleanValue()) {
                ++te.Animaitonticks;
                if (level instanceof ServerLevel) {
                    ServerLevel serverLevel = (ServerLevel)level;
                    if (level.getDifficulty() != Difficulty.PEACEFUL && te.Animaitonticks >= 19 && te.spawnMyBoss(serverLevel, pos)) {
                        level.destroyBlock(pos, false);
                        te.spawnedBoss = true;
                    }
                }
            } else {
                te.Animaitonticks = 0;
            }
        }
    }

    public boolean anyPlayerInRange(Level level) {
        return level.hasNearbyAlivePlayer((double)this.getBlockPos().getX() + 0.5, (double)this.getBlockPos().getY() + 0.5, (double)this.getBlockPos().getZ() + 0.5, (double)this.getRange());
    }

    protected boolean spawnMyBoss(ServerLevel serverLevel, BlockPos pos) {
        Entity entity;
        Vec3 vec3 = Vec3.atLowerCornerWithOffset((Vec3i)pos, (double)0.5, (double)0.0, (double)0.5);
        try {
            entity = this.spawnType.create((Level)serverLevel, EntitySpawnReason.EVENT);
        }
        catch (Exception exception) {
            Cataclysm.LOGGER.warn("Failed to create mob", (Throwable)exception);
            return false;
        }
        if (entity != null) {
            entity.setPos(vec3);
            if (entity instanceof Mob) {
                Mob living = (Mob)entity;
                // living.finalizeSpawn((ServerLevelAccessor)serverLevel, serverLevel.getCurrentDifficultyAt(this.worldPosition), EntitySpawnReason.SPAWNER, null);
                if (living instanceof IHomeEntity) {
                    IHomeEntity homeEntity = (IHomeEntity)living;
                    homeEntity.setHomePos(GlobalPos.of((ResourceKey)serverLevel.dimension(), (BlockPos)BlockPos.containing((Position)vec3)));
                }
            }
            return serverLevel.addFreshEntity(entity);
        }
        return false;
    }

    protected int getRange() {
        return 9;
    }

    public ItemStack getTheItem() {
        return this.item;
    }

    public void setTheItem(ItemStack item) {
        this.item = item;
        this.setChanged();
    }

    public void setEntityId(EntityType<?> type) {
        this.spawnType = type;
        this.setChanged();
    }

    public void onHit(Level level) {
        BlockPos blockpos = this.getBlockPos();
        BlockState state = this.getBlockState();
        if (!((Boolean)state.getValue((Property)Boss_Respawn_Spawner_Block.LIT)).booleanValue()) {
            level.setBlock(blockpos, (BlockState)state.setValue((Property)Boss_Respawn_Spawner_Block.LIT, (Comparable)Boolean.valueOf(true)), 2);
            level.blockEvent(blockpos, this.getBlockState().getBlock(), 1, 0);
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create((BlockEntity)this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("EntityType")) {
            String str = tag.getString("EntityType");
            this.spawnType = (EntityType)BuiltInRegistries.ENTITY_TYPE.get(Identifier.parse((String)str));
        }
        this.item = tag.contains("Item", 10) ? ItemStack.parse((HolderLookup.Provider)registries, (Tag)tag.getCompound("Item")).orElse(ItemStack.EMPTY) : ItemStack.EMPTY;
        this.Animaitonticks = tag.getInt("animationTicks");
    }

    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.getTheItem().isEmpty()) {
            tag.put("Item", this.getTheItem().save(registries));
        }
        tag.putInt("animationTicks", this.Animaitonticks);
        if (this.spawnType != null) {
            tag.putString("EntityType", BuiltInRegistries.ENTITY_TYPE.getKey(this.spawnType).toString());
        }
    }

    public Entity getDisplayEntity(Level level) {
        if (this.displayEntity == null && this.spawnType != null || this.displayEntity != null && this.displayEntity.getType() != this.spawnType) {
            this.displayEntity = this.spawnType.create(level, EntitySpawnReason.EVENT);
        }
        return this.displayEntity;
    }
}

