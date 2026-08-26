/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.GlobalPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.NonNullList
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.component.DataComponentMap$Builder
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Clearable
 *  net.minecraft.world.ContainerHelper
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.component.ItemContainerContents
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntity$DataComponentInput
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.gameevent.GameEvent$Context
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.init.ModTileentites;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class AltarOfFire_Block_Entity
extends BlockEntity
implements Clearable {
    public int tickCount;
    private static final int NUM_SLOTS = 1;
    private final NonNullList<ItemStack> items = NonNullList.withSize((int)1, (Object)ItemStack.EMPTY);
    public boolean summoningthis = false;
    public int summoningticks = 0;
    private final RandomSource rnd = RandomSource.create();

    public AltarOfFire_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.ALTAR_OF_FIRE.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, AltarOfFire_Block_Entity entity) {
        entity.tick(level, pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        ++this.tickCount;
        this.summoningthis = false;
        if (!this.getItem(0).isEmpty() && this.getItem(0).getItem() == ModItems.BURNING_ASHES.get()) {
            this.summoningthis = true;
            if (this.summoningticks == 1) {
                ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf((Vec3i)pos), 20.0f, 0.05f, 0, 150);
            }
            if (this.summoningticks > 118 && this.summoningticks < 121) {
                this.Sphereparticle(3.0f, 3.0f);
            }
            if (this.summoningticks > 121) {
                this.BlockBreaking(3, 3, 3);
                this.BasaltBreaking(16, 8, 16);
                Ignis_Entity ignis = (Ignis_Entity)((EntityType)ModEntities.IGNIS.get()).create(level);
                if (level instanceof ServerLevel) {
                    ServerLevel serverLevel = (ServerLevel)level;
                    if (ignis != null) {
                        ignis.setPos((float)pos.getX() + 0.5f, pos.getY() + 3, (float)pos.getZ() + 0.5f);
                        ignis.setHomePos(GlobalPos.of((ResourceKey)serverLevel.dimension(), (BlockPos)pos));
                        boolean flag = level.addFreshEntity((Entity)ignis);
                        if (flag) {
                            this.items.set(0, ItemStack.EMPTY);
                            this.setChanged();
                            level.sendBlockUpdated(pos, state, state, 3);
                        }
                    }
                }
            }
        }
        this.summoningticks = !this.summoningthis ? 0 : ++this.summoningticks;
    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor((float)this.getBlockPos().getX());
        int MthY = Mth.floor((float)this.getBlockPos().getY());
        int MthZ = Mth.floor((float)this.getBlockPos().getZ());
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.level.getBlockState(blockpos);
                    if (block == Blocks.AIR.defaultBlockState() || block.is(ModTag.ALTAR_DESTROY_IMMUNE)) continue;
                    this.level.destroyBlock(blockpos, false);
                }
            }
        }
    }

    private void BasaltBreaking(int x, int y, int z) {
        int MthX = Mth.floor((float)this.getBlockPos().getX());
        int MthY = Mth.floor((float)this.getBlockPos().getY());
        int MthZ = Mth.floor((float)this.getBlockPos().getZ());
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = -1; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState blockstate = this.level.getBlockState(blockpos);
                    Block block = blockstate.getBlock();
                    if (block == Blocks.AIR || block != Blocks.BASALT) continue;
                    this.level.destroyBlock(blockpos, false);
                }
            }
        }
    }

    private void Sphereparticle(float height, float size) {
        double d0 = (float)this.getBlockPos().getX() + 0.5f;
        double d1 = (float)this.getBlockPos().getY() + height;
        double d2 = (float)this.getBlockPos().getZ() + 0.5f;
        for (float i = -size; i <= size; i += 1.0f) {
            for (float j = -size; j <= size; j += 1.0f) {
                for (float k = -size; k <= size; k += 1.0f) {
                    double d3 = (double)j + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5;
                    double d4 = (double)i + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5;
                    double d5 = (double)k + (this.rnd.nextDouble() - this.rnd.nextDouble()) * 0.5;
                    double d6 = (double)Mth.sqrt((float)((float)(d3 * d3 + d4 * d4 + d5 * d5))) / 0.5 + this.rnd.nextGaussian() * 0.05;
                    this.level.addParticle((ParticleOptions)ParticleTypes.FLAME, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);
                    if (i == -size || i == size || j == -size || j == size) continue;
                    k += size * 2.0f - 1.0f;
                }
            }
        }
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack getItem(int index) {
        return (ItemStack)this.items.get(index);
    }

    public void placeItem(@Nullable LivingEntity entity, int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        this.level.gameEvent((Holder)GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of((Entity)entity, (BlockState)this.getBlockState()));
        this.markUpdated();
    }

    public int getMaxStackSize() {
        return 1;
    }

    public void loadAdditional(CompoundTag p_155312_, HolderLookup.Provider p_324612_) {
        super.loadAdditional(p_155312_, p_324612_);
        this.items.clear();
        ContainerHelper.loadAllItems((CompoundTag)p_155312_, this.items, (HolderLookup.Provider)p_324612_);
    }

    protected void saveAdditional(CompoundTag p_187486_, HolderLookup.Provider p_324612_) {
        super.saveAdditional(p_187486_, p_324612_);
        ContainerHelper.saveAllItems((CompoundTag)p_187486_, this.items, (boolean)true, (HolderLookup.Provider)p_324612_);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create((BlockEntity)this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider p_324612_) {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems((CompoundTag)compoundtag, this.items, (boolean)true, (HolderLookup.Provider)p_324612_);
        return compoundtag;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    public void clearContent() {
        this.items.clear();
    }

    public void dowse() {
        if (this.level != null) {
            this.markUpdated();
        }
    }

    protected void collectImplicitComponents(DataComponentMap.Builder p_338620_) {
        super.collectImplicitComponents(p_338620_);
        p_338620_.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    public void removeComponentsFromTag(CompoundTag p_332690_) {
        p_332690_.remove("Items");
    }
}

