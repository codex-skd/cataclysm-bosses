/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.entity.projectile;

import com.skd.cataclysmbosses.entity.util.TidalTentacleUtil;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModSounds;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Tidal_Tentacle_Entity
extends Entity {
    private static final EntityDataAccessor<Optional<UUID>> CREATOR_ID = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> FROM_ID = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TARGET_COUNT = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CURRENT_TARGET_ID = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> PROGRESS = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> RETRACTING = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_CLAW = SynchedEntityData.defineId(Tidal_Tentacle_Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    private List<Entity> previouslyTouched = new ArrayList<Entity>();
    private boolean hasChained = false;
    public float prevProgress = 0.0f;
    public static final float MAX_EXTEND_TIME = 5.0f;

    public Tidal_Tentacle_Entity(EntityType<?> type, Level level) {
        super(type, level);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(CREATOR_ID, Optional.empty());
        p_326229_.define(FROM_ID, -1);
        p_326229_.define(TARGET_COUNT, 0);
        p_326229_.define(CURRENT_TARGET_ID, -1);
        p_326229_.define(PROGRESS, Float.valueOf(0.0f));
        p_326229_.define(DAMAGE, Float.valueOf(3.0f));
        p_326229_.define(RETRACTING, false);
        p_326229_.define(HAS_CLAW, true);
    }

    public void tick() {
        float progress;
        this.prevProgress = progress = this.getProgress();
        super.tick();
        Entity creator = this.getCreatorEntity();
        Entity current = this.getToEntity();
        if (this.tickCount == 1 && !this.level().isClientSide()) {
            this.playSound((SoundEvent)ModSounds.TIDAL_TENTACLE.get(), 1.0f, 0.8f + this.random.nextFloat() * 0.4f);
        }
        if (!this.isRetracting() && progress < 5.0f) {
            this.setProgress(progress + 1.0f);
        }
        if (this.isRetracting() && progress > 0.0f) {
            this.setProgress(progress - 1.0f);
        }
        if (this.isRetracting() && progress == 0.0f) {
            Entity from = this.getFromEntity();
            if (from instanceof Tidal_Tentacle_Entity) {
                Tidal_Tentacle_Entity tendonSegment = (Tidal_Tentacle_Entity)from;
                tendonSegment.setRetracting(true);
                this.updateLastTendon(tendonSegment);
            } else {
                this.updateLastTendon(null);
            }
            this.remove(Entity.RemovalReason.DISCARDED);
        }
        if (creator instanceof LivingEntity && current != null) {
            Entity entity;
            Vec3 target = new Vec3(current.getX(), current.getY((double)0.4f), current.getZ());
            Vec3 lerp = target.subtract(this.position());
            this.setDeltaMovement(lerp.scale(0.5));
            if (!this.level().isClientSide() && progress >= 5.0f && this.tickCount % 2 == 0 && (entity = this.getCreatorEntity()) instanceof LivingEntity) {
                DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, (LivingEntity)entity);
                if (current != creator && current.hurtOrSimulate(damagesource, this.getBaseDamage())) {
                    MobEffectInstance effectinstance1 = ((LivingEntity)current).getEffect(ModEffect.EFFECTABYSSAL_CURSE);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        ((LivingEntity)current).removeEffectNoUpdate(ModEffect.EFFECTABYSSAL_CURSE);
                    } else {
                        --i;
                    }
                    i = Mth.clamp((int)i, (int)0, (int)4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTABYSSAL_CURSE, 60, i, false, true, true);
                    ((LivingEntity)current).addEffect(effectinstance);
                }
            }
        }
        Vec3 vector3d = this.getDeltaMovement();
        if (!this.level().isClientSide() && !this.hasChained) {
            if (this.getTargetsHit() > 5) {
                this.setRetracting(true);
            } else if (creator instanceof LivingEntity && this.getProgress() >= 5.0f) {
                Entity closestValid = null;
                for (Entity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(12.0))) {
                    if (entity.equals((Object)creator) || this.previouslyTouched.contains(entity) || !this.isValidTarget((LivingEntity)creator, entity) || !this.hasLineOfSight(entity) || closestValid != null && !(this.distanceTo(entity) < this.distanceTo(closestValid))) continue;
                    closestValid = entity;
                }
                if (closestValid != null) {
                    this.createChain(closestValid);
                    this.hasChained = true;
                } else {
                    this.setRetracting(true);
                }
            }
        }
        double d0 = this.getX() + vector3d.x;
        double d1 = this.getY() + vector3d.y;
        double d2 = this.getZ() + vector3d.z;
        this.setDeltaMovement(vector3d.scale((double)0.99f));
        this.setPos(d0, d1, d2);
    }

    private boolean isValidTarget(LivingEntity creator, Entity entity) {
        if (!creator.isAlliedTo(entity) && !entity.isAlliedTo((Entity)creator) && entity instanceof Mob) {
            return true;
        }
        return creator.getLastHurtMob() != null && creator.getLastHurtMob().getUUID().equals(entity.getUUID()) || creator.getLastHurtByMob() != null && creator.getLastHurtByMob().getUUID().equals(entity.getUUID());
    }

    private boolean hasLineOfSight(Entity entity) {
        if (entity.level() != this.level()) {
            return false;
        }
        Vec3 vec3 = new Vec3(this.getX(), this.getEyeY(), this.getZ());
        Vec3 vec31 = new Vec3(entity.getX(), entity.getEyeY(), entity.getZ());
        if (vec31.distanceTo(vec3) > 128.0) {
            return false;
        }
        return this.level().clip(new ClipContext(vec3, vec31, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this)).getType() == HitResult.Type.MISS;
    }

    private void updateLastTendon(Tidal_Tentacle_Entity lastTendon) {
        Entity creator = this.getCreatorEntity();
        if (creator == null) {
            creator = this.level().getPlayerByUUID(this.getCreatorEntityUUID());
        }
        if (creator instanceof LivingEntity) {
            TidalTentacleUtil.setLastTentacle((LivingEntity)creator, lastTendon);
        }
    }

    private void createChain(Entity closestValid) {
        this.entityData.set(HAS_CLAW, false);
        Tidal_Tentacle_Entity child = (Tidal_Tentacle_Entity)((EntityType)ModEntities.TIDAL_TENTACLE.get()).create(this.level());
        child.previouslyTouched = new ArrayList<Entity>(this.previouslyTouched);
        child.previouslyTouched.add(closestValid);
        child.setCreatorEntityUUID(this.getCreatorEntityUUID());
        child.setFromEntityID(this.getId());
        child.setToEntityID(closestValid.getId());
        child.setPos(closestValid.getX(), closestValid.getY((double)0.4f), closestValid.getZ());
        child.setTargetsHit(this.getTargetsHit() + 1);
        this.updateLastTendon(child);
        this.level().addFreshEntity((Entity)child);
    }

    private float getBaseDamage() {
        return ((Float)this.entityData.get(DAMAGE)).floatValue();
    }

    public UUID getCreatorEntityUUID() {
        return ((Optional)this.entityData.get(CREATOR_ID)).orElse(null);
    }

    public void setCreatorEntityUUID(UUID id) {
        this.entityData.set(CREATOR_ID, Optional.ofNullable(id));
    }

    public Entity getCreatorEntity() {
        UUID uuid = this.getCreatorEntityUUID();
        if (uuid != null && !this.level().isClientSide()) {
            return ((ServerLevel)this.level()).getEntity(uuid);
        }
        return null;
    }

    public int getFromEntityID() {
        return (Integer)this.entityData.get(FROM_ID);
    }

    public void setFromEntityID(int id) {
        this.entityData.set(FROM_ID, id);
    }

    public Entity getFromEntity() {
        return this.getFromEntityID() == -1 ? null : this.level().getEntity(this.getFromEntityID());
    }

    public int getToEntityID() {
        return (Integer)this.entityData.get(CURRENT_TARGET_ID);
    }

    public void setToEntityID(int id) {
        this.entityData.set(CURRENT_TARGET_ID, id);
    }

    public Entity getToEntity() {
        return this.getToEntityID() == -1 ? null : this.level().getEntity(this.getToEntityID());
    }

    public int getTargetsHit() {
        return (Integer)this.entityData.get(TARGET_COUNT);
    }

    public void setTargetsHit(int i) {
        this.entityData.set(TARGET_COUNT, i);
    }

    public float getProgress() {
        return ((Float)this.entityData.get(PROGRESS)).floatValue();
    }

    public void setProgress(float progress) {
        this.entityData.set(PROGRESS, Float.valueOf(progress));
    }

    public boolean isRetracting() {
        return (Boolean)this.entityData.get(RETRACTING);
    }

    public void setRetracting(boolean retract) {
        this.entityData.set(RETRACTING, retract);
    }

    public boolean hasClaw() {
        return (Boolean)this.entityData.get(HAS_CLAW);
    }

    protected void readAdditionalSaveData(ValueInput p_20052_) {
    }

    protected void addAdditionalSaveData(ValueOutput p_20139_) {
    }

    public boolean isCreator(Entity mob) {
        return this.getCreatorEntityUUID() != null && mob.getUUID().equals(this.getCreatorEntityUUID());
    }
}

