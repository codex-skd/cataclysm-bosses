/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.players.OldUsersConverter
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Abyss_Mark_Entity
extends Entity {
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;
    private static final EntityDataAccessor<String> CREATOR_ID = SynchedEntityData.defineId(Abyss_Mark_Entity.class, (EntityDataSerializer)EntityDataSerializers.STRING);
    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Abyss_Mark_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Abyss_Mark_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Abyss_Mark_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);

    public Abyss_Mark_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Abyss_Mark_Entity(Level worldIn, double x, double y, double z, int lifespan, float damage, float hpdamage, UUID casterIn, LivingEntity finalTarget) {
        this((EntityType)ModEntities.ABYSS_MARK.get(), worldIn);
        this.setCreatorEntityUUID(casterIn);
        this.setLifespan(lifespan);
        this.setDamage(damage);
        this.setHpDamage(hpdamage);
        this.finalTarget = finalTarget;
        this.setPos(x, y, z);
    }

    public void tick() {
        super.tick();
        this.updateMotion();
        Entity owner = this.getCreatorEntity();
        if (owner != null && !owner.isAlive()) {
            this.discard();
        }
        this.setLifespan(this.getLifespan() - 1);
        if (!this.level().isClientSide() && this.finalTarget == null && this.targetId != null) {
            this.finalTarget = ((ServerLevel)this.level()).getEntity(this.targetId);
            if (this.finalTarget == null) {
                this.targetId = null;
            }
        }
        if (this.getLifespan() <= 0) {
            if (owner != null) {
                this.level().addFreshEntity((Entity)new Abyss_Blast_Portal_Entity(this.level(), this.getX(), this.getY(), this.getZ(), this.getYRot(), 0, this.getDamage(), this.getHpDamage(), (LivingEntity)owner));
            }
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return (Integer)this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }

    public UUID getCreatorEntityUUID() {
        String s = this.entityData.get(CREATOR_ID);
        return s.isEmpty() ? null : java.util.UUID.fromString(s);
    }

    public void setCreatorEntityUUID(UUID id) {
        this.entityData.set(CREATOR_ID, id == null ? "" : id.toString());
    }

    public Entity getCreatorEntity() {
        UUID uuid = this.getCreatorEntityUUID();
        if (uuid != null && !this.level().isClientSide()) {
            return ((ServerLevel)this.level()).getEntity(uuid);
        }
        return null;
    }

    private void updateMotion() {
        Vec3 vec3 = this.getDeltaMovement();
        double h0 = this.getX() + vec3.x;
        double h1 = this.getY() + vec3.y;
        double h2 = this.getZ() + vec3.z;
        if (this.finalTarget != null && this.finalTarget.isAlive() || this.finalTarget instanceof Player && !this.finalTarget.isSpectator()) {
            double dx = this.finalTarget.getX() - this.getX();
            double dz = this.finalTarget.getZ() - this.getZ();
            double p0 = Math.min(this.finalTarget.getY(), this.getY() - 50.0);
            double p1 = Math.max(this.finalTarget.getY(), this.getY());
            BlockPos blockpos = BlockPos.containing((double)this.finalTarget.getX(), (double)p1, (double)this.finalTarget.getZ());
            double d0 = 0.0;
            do {
                BlockState blockstate1;
                VoxelShape voxelshape;
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = this.level().getBlockState(blockpos1);
                if (!blockstate.isFaceSturdy((BlockGetter)this.level(), blockpos1, Direction.UP)) continue;
                if (this.level().isEmptyBlock(blockpos) || (voxelshape = (blockstate1 = this.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty()) break;
                d0 = voxelshape.max(Direction.Axis.Y);
                break;
            } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)p0) - 1);
            this.setPos(h0, (double)blockpos.getY() + d0, h2);
            this.setDeltaMovement(vec3.add(dx, 0.0, dz).scale(0.05));
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(CREATOR_ID, "");
        p_326229_.define(LIFESPAN, 300);
        p_326229_.define(DAMAGE, Float.valueOf(0.0f));
        p_326229_.define(HPDAMAGE, Float.valueOf(0.0f));
    }

    public float getDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, Float.valueOf(damage));
    }

    public float getHpDamage() {
        return ((Float)this.entityData.get(HPDAMAGE)).floatValue();
    }

    public void setHpDamage(float damage) {
        this.entityData.set(HPDAMAGE, Float.valueOf(damage));
    }

    protected void readAdditionalSaveData(ValueInput compound) {
        UUID uuid;
        this.setLifespan(compound.getIntOr("Lifespan", 0));
        if (compound.read("Owner", UUIDUtil.CODEC).isPresent()) {
            uuid = compound.read("Owner", UUIDUtil.CODEC).orElse(null);
        } else {
            String s = compound.getStringOr("Owner", "");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary((MinecraftServer)this.level().getServer(), (String)s);
        }
        if (compound.read("Target", UUIDUtil.CODEC).isPresent()) {
            this.targetId = compound.read("Target", UUIDUtil.CODEC).orElse(null);
        }
        if (uuid != null) {
            try {
                this.setCreatorEntityUUID(uuid);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        this.setDamage(compound.getFloatOr("damage", 0.0f));
        this.setHpDamage(compound.getFloatOr("Hpdamage", 0.0f));
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        compound.putInt("Lifespan", this.getLifespan());
        if (this.getCreatorEntityUUID() != null) {
            compound.store("Owner", UUIDUtil.CODEC, this.getCreatorEntityUUID());
        }
        if (this.finalTarget != null) {
            compound.store("Target", UUIDUtil.CODEC, this.finalTarget.getUUID());
        }
        compound.putFloat("damage", this.getDamage());
        compound.putFloat("Hpdamage", this.getHpDamage());
    }

    @Override
    public boolean hurtServer(net.minecraft.server.level.ServerLevel level, net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }
}

