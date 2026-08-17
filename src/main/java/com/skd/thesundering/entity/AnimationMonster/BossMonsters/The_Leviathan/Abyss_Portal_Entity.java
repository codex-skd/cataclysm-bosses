/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NbtUtils
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.skd.thesundering.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.skd.thesundering.init.ModEntities;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class Abyss_Portal_Entity
extends Entity {
    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Abyss_Portal_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Boolean> ENTRANCE = SynchedEntityData.defineId(Abyss_Portal_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<BlockPos>> DESTINATION = SynchedEntityData.defineId(Abyss_Portal_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_BLOCK_POS);
    private static final EntityDataAccessor<Optional<UUID>> SISTER_UUID = SynchedEntityData.defineId(Abyss_Portal_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    private boolean isDummy = false;
    private boolean hasClearedObstructions;

    public Abyss_Portal_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public void tick() {
        super.tick();
        if (this.tickCount == 1 && this.getLifespan() == 0) {
            this.setLifespan(2000);
        }
        if (!this.madeOpenNoise) {
            this.gameEvent((Holder)GameEvent.ENTITY_PLACE);
            this.playSound(SoundEvents.END_PORTAL_SPAWN, 1.0f, 1.0f + this.random.nextFloat() * 0.2f);
            this.madeOpenNoise = true;
        }
        if (this.random.nextFloat() < 0.5f && this.level().isClientSide() && Math.min(this.tickCount, this.getLifespan()) >= 20) {
            double particleX = this.getBoundingBox().minX + (double)this.random.nextFloat() * (this.getBoundingBox().maxX - this.getBoundingBox().minX);
            double particleY = this.getBoundingBox().minY + (double)this.random.nextFloat() * (this.getBoundingBox().maxY - this.getBoundingBox().minY);
            double particleZ = this.getBoundingBox().minZ + (double)this.random.nextFloat() * (this.getBoundingBox().maxZ - this.getBoundingBox().minZ);
            this.level().addParticle((ParticleOptions)ParticleTypes.PORTAL, particleX, particleY, particleZ, 0.1 * this.random.nextGaussian(), 0.1 * this.random.nextGaussian(), 0.1 * this.random.nextGaussian());
        }
        ArrayList entities = new ArrayList();
        entities.addAll(this.level().getEntities((Entity)this, this.getBoundingBox().deflate((double)0.2f)));
        entities.addAll(this.level().getEntitiesOfClass(The_Leviathan_Entity.class, this.getBoundingBox().inflate(3.0)));
        if (!this.level().isClientSide() && this.getDestination() != null && this.getLifespan() > 20 && this.tickCount > 20 && this.getEntrance()) {
            for (Entity e : entities) {
                if (e.isOnPortalCooldown() || e.isShiftKeyDown() || e instanceof Abyss_Portal_Entity) continue;
                if (e instanceof The_Leviathan_Entity) {
                    ((The_Leviathan_Entity)e).teleportTo(Vec3.atCenterOf((Vec3i)this.getDestination()));
                    e.setPortalCooldown();
                    ((The_Leviathan_Entity)e).resetPortalLogic();
                    continue;
                }
                e.teleportTo((double)((float)this.getDestination().getX() + 0.5f), (double)((float)this.getDestination().getY() + 0.5f), (double)((float)this.getDestination().getZ() + 0.5f));
                e.setPortalCooldown();
            }
        }
        this.setLifespan(this.getLifespan() - 1);
        if (this.getLifespan() <= 20 && !this.madeCloseNoise) {
            this.gameEvent((Holder)GameEvent.ENTITY_PLACE);
            this.madeCloseNoise = true;
        }
        if (this.getLifespan() <= 0) {
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return (Integer)this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, (Object)i);
    }

    public boolean getEntrance() {
        return (Boolean)this.entityData.get(ENTRANCE);
    }

    public void setEntrance(boolean entrance) {
        this.entityData.set(ENTRANCE, (Object)entrance);
    }

    public void setDestination(@Nullable BlockPos destination) {
        this.entityData.set(DESTINATION, Optional.ofNullable(destination));
        if (this.getSisterId() == null) {
            this.createAndSetSister(this.level(), null);
        }
    }

    @Nullable
    public BlockPos getDestination() {
        return ((Optional)this.getEntityData().get(DESTINATION)).orElse(null);
    }

    public void createAndSetSister(Level world, Direction dir) {
        Abyss_Portal_Entity portal = (Abyss_Portal_Entity)((EntityType)ModEntities.ABYSS_PORTAL.get()).create(world);
        BlockPos safeDestination = this.getDestination();
        portal.teleportTo((float)safeDestination.getX() + 0.5f, (float)safeDestination.getY() + 0.5f, (float)safeDestination.getZ() + 0.5f);
        portal.link(this);
        portal.setEntrance(false);
        world.addFreshEntity((Entity)portal);
    }

    public void setDestination(BlockPos destination, Direction dir) {
        this.entityData.set(DESTINATION, Optional.ofNullable(destination));
        if (this.getSisterId() == null) {
            this.createAndSetSister(this.level(), dir);
        }
    }

    public void link(Abyss_Portal_Entity portal) {
        this.setSisterId(portal.getUUID());
        portal.setSisterId(this.getUUID());
        portal.setLifespan(this.getLifespan());
        this.setDestination(portal.blockPosition());
        portal.setDestination(this.blockPosition());
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(LIFESPAN, (Object)300);
        p_326229_.define(SISTER_UUID, Optional.empty());
        p_326229_.define(DESTINATION, Optional.empty());
        p_326229_.define(ENTRANCE, (Object)true);
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        NbtUtils.readBlockPos((CompoundTag)compound, (String)"Destination").ifPresent(this::setDestination);
        if (compound.hasUUID("SisterUUID")) {
            this.setSisterId(compound.getUUID("SisterUUID"));
        }
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Lifespan", this.getLifespan());
        if (this.getDestination() != null) {
            compound.put("Destination", NbtUtils.writeBlockPos((BlockPos)this.getDestination()));
        }
        if (this.getSisterId() != null) {
            compound.putUUID("SisterUUID", this.getSisterId());
        }
    }

    public Entity getSister() {
        UUID id = this.getSisterId();
        if (id != null && !this.level().isClientSide()) {
            return ((ServerLevel)this.level()).getEntity(id);
        }
        return null;
    }

    public boolean shouldRenderAtSqrDistance(double distance) {
        return distance < 1024.0;
    }

    @Nullable
    public UUID getSisterId() {
        return ((Optional)this.entityData.get(SISTER_UUID)).orElse(null);
    }

    public void setSisterId(@Nullable UUID uniqueId) {
        this.entityData.set(SISTER_UUID, Optional.ofNullable(uniqueId));
    }
}

