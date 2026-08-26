/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
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
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.Level$ExplosionInteraction
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.effect;

import com.skd.cataclysmbosses.client.particle.Options.Rising_Trail_Options;
import com.skd.cataclysmbosses.init.ModEntities;
import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Void_Vortex_Entity
extends Entity {
    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Void_Vortex_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Void_Vortex_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    @Nullable
    private LivingEntity owner;

    public Void_Vortex_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Void_Vortex_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, LivingEntity casterIn, int span) {
        this((EntityType)ModEntities.VOID_VORTEX.get(), worldIn);
        this.setLifespan(span);
        this.setOwner(casterIn);
        this.setYRot(p_i47276_8_ * 57.295776f);
        this.setPos(x, y, z);
        if (!worldIn.isClientSide()) {
            this.setCasterID(casterIn.getId());
        }
    }

    public void tick() {
        super.tick();
        if (this.tickCount == 1) {
            if (this.getLifespan() == 0) {
                this.setLifespan(60);
            }
            if (this.level().isClientSide()) {
                this.owner = (LivingEntity)this.level().getEntity(this.getCasterID());
            }
        }
        if (!this.madeOpenNoise) {
            this.gameEvent((Holder)GameEvent.ENTITY_PLACE);
            this.playSound(SoundEvents.END_PORTAL_SPAWN, 1.0f, 1.0f + this.random.nextFloat() * 0.2f);
            this.madeOpenNoise = true;
        }
        if (Math.min(this.tickCount, this.getLifespan()) >= 16) {
            if (this.level().isClientSide()) {
                float r = 0.4f;
                float g = 0.1f;
                float b = 0.8f;
                this.level().addParticle((ParticleOptions)new Rising_Trail_Options(r, g, b, 2.5f + this.random.nextFloat() * 0.25f, 0.08f), this.getX(), this.getY() + 5.0, this.getZ(), 0.0, -0.3, 0.0);
            }
            AABB screamBox = new AABB(this.getX() - 3.0, this.getY(), this.getZ() - 3.0, this.getX() + 3.0, this.getY() + 15.0, this.getZ() + 3.0);
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, screamBox)) {
                if (this.isAlliedTo((Entity)entity) || this.owner != null && (this.owner.equals((Object)entity) || this.owner.isAlliedTo((Entity)entity))) continue;
                if (entity instanceof Player) {
                    Player player = (Player)entity;
                    if (player.getAbilities().invulnerable) continue;
                }
                Vec3 diff = entity.position().subtract(this.position().add(0.0, 0.0, 0.0));
                diff = diff.normalize().scale(0.075);
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, -2.0, 0.0).subtract(diff));
            }
        }
        this.setLifespan(this.getLifespan() - 1);
        if (this.getLifespan() <= 16 && !this.madeCloseNoise) {
            this.gameEvent((Holder)GameEvent.ENTITY_PLACE);
            this.madeCloseNoise = true;
        }
        if (this.getLifespan() <= 0) {
            this.level().explode((Entity)this.owner, this.getX(), this.getY(), this.getZ(), 2.0f, false, Level.ExplosionInteraction.NONE);
            this.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return (Integer)this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }

    public int getCasterID() {
        return (Integer)this.entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        this.entityData.set(CASTER, id);
    }

    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        this.setCasterID(p_19719_ == null ? 0 : p_19719_.getId());
    }

    @Nullable
    public LivingEntity getOwner() {
        Entity entity;
        if (this.owner == null && this.getCasterID() != 0 && this.level() instanceof ServerLevel && (entity = ((ServerLevel)this.level()).getEntity(this.getCasterID())) instanceof LivingEntity) {
            this.owner = (LivingEntity)entity;
        }
        return this.owner;
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(LIFESPAN, 300);
        p_326229_.define(CASTER, -1);
    }

    protected void readAdditionalSaveData(ValueInput compound) {
        this.setLifespan(compound.getIntOr("Lifespan", 0));
        this.setCasterID(compound.getIntOr("CasterId", 0));
    }

    protected void addAdditionalSaveData(ValueOutput compound) {
        compound.putInt("Lifespan", this.getLifespan());
        compound.putInt("CasterId", this.getCasterID());
    }
}

