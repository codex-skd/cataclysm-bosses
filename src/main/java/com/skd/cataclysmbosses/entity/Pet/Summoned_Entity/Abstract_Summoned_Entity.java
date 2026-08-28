/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.players.OldUsersConverter
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.OwnableEntity
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.LeavesBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.level.pathfinder.WalkNodeEvaluator
 *  net.minecraft.world.scores.PlayerTeam
 */
package com.skd.cataclysmbosses.entity.Pet.Summoned_Entity;

import com.skd.cataclysmbosses.entity.etc.IFollower;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Abstract_Summoned_Entity
extends PathfinderMob
implements OwnableEntity,
IFollower {
    private boolean hasLimitedLife;
    private int limitedLifeTicks;
    protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Abstract_Summoned_Entity.class, (EntityDataSerializer)EntityDataSerializers.BYTE);
    protected static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(Abstract_Summoned_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);

    public Abstract_Summoned_Entity(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, 0);
        builder.define(DATA_OWNERUUID_ID, Optional.empty());
    }

    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        if (this.getOwnerUUID() != null) {
            compound.store("Owner", UUIDUtil.CODEC, this.getOwnerUUID());
        }
        if (this.hasLimitedLife) {
            compound.putInt("LifeTicks", this.limitedLifeTicks);
        }
    }

    public void readAdditionalSaveData(ValueInput compound) {
        UUID uuid;
        super.readAdditionalSaveData(compound);
        if (compound.read("Owner", UUIDUtil.CODEC).isPresent()) {
            uuid = compound.read("Owner", UUIDUtil.CODEC).orElse(null);
        } else {
            String s = compound.getStringOr("Owner", "");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary((MinecraftServer)this.getServer(), (String)s);
        }
        if (uuid != null) {
            try {
                this.setOwnerUUID(uuid);
                this.setTame(true, false);
            }
            catch (Throwable throwable) {
                this.setTame(false, true);
            }
        }
        if (compound.contains("LifeTicks")) {
            this.setLimitedLife(compound.getIntOr("LifeTicks", 0));
        }
    }

    public void setLimitedLife(int limitedLifeTicks) {
        this.hasLimitedLife = true;
        this.limitedLifeTicks = limitedLifeTicks;
    }

    public boolean canBeLeashed() {
        return true;
    }

    protected void spawnTamingParticles(boolean tamed) {
        SimpleParticleType particleoptions = ParticleTypes.HEART;
        if (!tamed) {
            particleoptions = ParticleTypes.SMOKE;
        }
        for (int i = 0; i < 7; ++i) {
            double d0 = this.random.nextGaussian() * 0.02;
            double d1 = this.random.nextGaussian() * 0.02;
            double d2 = this.random.nextGaussian() * 0.02;
            this.level().addParticle((ParticleOptions)particleoptions, this.getRandomX(1.0), this.getRandomY() + 0.5, this.getRandomZ(1.0), d0, d1, d2);
        }
    }

    public void handleEntityEvent(byte id) {
        if (id == 7) {
            this.spawnTamingParticles(true);
        } else if (id == 6) {
            this.spawnTamingParticles(false);
        } else {
            super.handleEntityEvent(id);
        }
    }

    public boolean isTame() {
        return ((Byte)this.entityData.get(DATA_FLAGS_ID) & 4) != 0;
    }

    public void setTame(boolean tame, boolean applyTamingSideEffects) {
        byte b0 = (Byte)this.entityData.get(DATA_FLAGS_ID);
        if (tame) {
            this.entityData.set(DATA_FLAGS_ID, ((byte)(b0 | 4)));
        } else {
            this.entityData.set(DATA_FLAGS_ID, ((byte)(b0 & 0xFFFFFFFB)));
        }
        if (applyTamingSideEffects) {
            this.applyTamingSideEffects();
        }
    }

    protected void applyTamingSideEffects() {
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && this.hasLimitedLife && --this.limitedLifeTicks <= 0) {
            this.discard();
        }
    }

    @Nullable
    public UUID getOwnerUUID() {
        return ((Optional)this.entityData.get(DATA_OWNERUUID_ID)).orElse(null);
    }

    public void setOwnerUUID(@Nullable UUID uuid) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(uuid));
    }

    public void tame(Player player) {
        this.setTame(true, true);
        this.setOwnerUUID(player.getUUID());
    }

    public boolean canAttack(LivingEntity target) {
        return this.isOwnedBy(target) ? false : super.canAttack(target);
    }

    public boolean isOwnedBy(LivingEntity entity) {
        return entity == this.getOwner();
    }

    public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
        return true;
    }

    public PlayerTeam getTeam() {
        LivingEntity livingentity;
        if (this.isTame() && (livingentity = this.getOwner()) != null) {
            return livingentity.getTeam();
        }
        return super.getTeam();
    }

    public boolean considersEntityAsAlly(Entity entity) {
        if (this.isTame()) {
            LivingEntity livingentity = this.getOwner();
            if (entity == livingentity) {
                return true;
            }
            if (livingentity != null) {
                return livingentity.isAlliedTo(entity);
            }
        }
        return super.considersEntityAsAlly(entity);
    }

    public void tryToTeleportToOwner() {
        LivingEntity livingentity = this.getOwner();
        if (livingentity != null) {
            this.teleportToAroundBlockPos(livingentity.blockPosition());
        }
    }

    public boolean shouldTryTeleportToOwner() {
        LivingEntity livingentity = this.getOwner();
        return livingentity != null && this.distanceToSqr((Entity)this.getOwner()) >= 144.0;
    }

    private void teleportToAroundBlockPos(BlockPos pos) {
        for (int i = 0; i < 10; ++i) {
            int j = this.random.nextIntBetweenInclusive(-3, 3);
            int k = this.random.nextIntBetweenInclusive(-3, 3);
            if (Math.abs(j) < 2 && Math.abs(k) < 2) continue;
            int l = this.random.nextIntBetweenInclusive(-1, 1);
            if (!this.maybeTeleportTo(pos.getX() + j, pos.getY() + l, pos.getZ() + k)) continue;
            return;
        }
    }

    private boolean maybeTeleportTo(int x, int y, int z) {
        if (!this.canTeleportTo(new BlockPos(x, y, z))) {
            return false;
        }
        this.setPos((double)x + 0.5, y, (double)z + 0.5, this.getYRot(), this.getXRot());
        this.navigation.stop();
        return true;
    }

    private boolean canTeleportTo(BlockPos pos) {
        PathType pathtype = WalkNodeEvaluator.getPathTypeStatic((Mob)this, (BlockPos)pos);
        if (pathtype != PathType.WALKABLE) {
            return false;
        }
        BlockState blockstate = this.level().getBlockState(pos.below());
        if (!this.canFlyToOwner() && blockstate.getBlock() instanceof LeavesBlock) {
            return false;
        }
        BlockPos blockpos = pos.subtract((Vec3i)this.blockPosition());
        return this.level().noCollision((Entity)this, this.getBoundingBox().move(blockpos));
    }

    protected boolean canFlyToOwner() {
        return false;
    }

    @Override
    public boolean shouldFollow() {
        return true;
    }
}

