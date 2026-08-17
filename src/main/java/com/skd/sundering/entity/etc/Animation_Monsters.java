/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.Holder
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.monster.Enemy
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.common.CommonHooks
 *  net.neoforged.neoforge.network.PacketDistributor
 */
package com.skd.sundering.entity.etc;

import com.skd.sundering.message.MessageMusic;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.network.PacketDistributor;

public class Animation_Monsters
extends Monster
implements Enemy {
    private static final Identifier MOB_HEALTH_MODIFIER_ID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"animation_health");
    private static final Identifier MOB_DAMAGE_MODIFIER_ID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"animation_damage");
    public int attackTicks;
    @OnlyIn(value=Dist.CLIENT)
    public Vec3[] socketPosArray;

    public Animation_Monsters(EntityType entity, Level world) {
        super(entity, world);
        if (world.isClientSide()) {
            this.socketPosArray = new Vec3[0];
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && this.getBossMusic() != null) {
            if (this.canPlayMusic()) {
                PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)this, (CustomPacketPayload)new MessageMusic(this.getId(), true), (CustomPacketPayload[])new CustomPacketPayload[0]);
            } else {
                PacketDistributor.sendToPlayersTrackingEntityAndSelf((Entity)this, (CustomPacketPayload)new MessageMusic(this.getId(), false), (CustomPacketPayload[])new CustomPacketPayload[0]);
            }
        }
    }

    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
    }

    public boolean canPlayerHearMusic(Player player) {
        return player != null && this.canAttack((LivingEntity)player) && this.distanceTo((Entity)player) < 2500.0f;
    }

    public void setConfigattribute(LivingEntity entity, double hpconfig, double dmgconfig) {
        AttributeInstance attackDamageAttr;
        AttributeInstance maxHealthAttr = entity.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            double difference = maxHealthAttr.getBaseValue() * hpconfig - maxHealthAttr.getBaseValue();
            maxHealthAttr.addTransientModifier(new AttributeModifier(MOB_HEALTH_MODIFIER_ID, difference, AttributeModifier.Operation.ADD_VALUE));
            entity.setHealth(entity.getMaxHealth());
        }
        if ((attackDamageAttr = entity.getAttribute(Attributes.ATTACK_DAMAGE)) != null) {
            double difference = attackDamageAttr.getBaseValue() * dmgconfig - attackDamageAttr.getBaseValue();
            attackDamageAttr.addTransientModifier(new AttributeModifier(MOB_DAMAGE_MODIFIER_ID, difference, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    public double calculateRange(DamageSource damagesource) {
        return damagesource.getEntity() != null ? this.distanceToSqr(damagesource.getEntity()) : -1.0;
    }

    public double getAngleBetweenEntities(Entity first, Entity second) {
        return Math.atan2(second.getZ() - first.getZ(), second.getX() - first.getX()) * 57.29577951308232 + 90.0;
    }

    protected boolean canPlayMusic() {
        return !this.isSilent() && this.getTarget() instanceof Player && this.getTarget() != null && this.getTarget().isAlive();
    }

    protected void tickDeath() {
        this.onDeathUpdate(this.deathtimer());
    }

    public SoundEvent getBossMusic() {
        return null;
    }

    public int deathtimer() {
        return 20;
    }

    protected void onDeathAIUpdate() {
    }

    public void onDeathUpdate(int deathDuration) {
        this.onDeathAIUpdate();
        ++this.deathTime;
        if (this.deathTime >= deathDuration && !this.level().isClientSide() && !this.isRemoved()) {
            this.level().broadcastEntityEvent((Entity)this, (byte)60);
            this.remove(Entity.RemovalReason.KILLED);
        }
    }

    public void die(DamageSource cause) {
        if (CommonHooks.onLivingDeath((LivingEntity)this, (DamageSource)cause)) {
            return;
        }
        if (!this.isRemoved() && !this.dead) {
            Entity entity = cause.getEntity();
            LivingEntity livingentity = this.getKillCredit();
            if (this.deathScore >= 0 && livingentity != null) {
                livingentity.awardKillScore((Entity)this, this.deathScore, cause);
            }
            if (this.isSleeping()) {
                this.stopSleeping();
            }
            this.dead = true;
            this.getCombatTracker().recheckStatus();
            Level level = this.level();
            if (level instanceof ServerLevel) {
                ServerLevel serverlevel = (ServerLevel)level;
                if (entity == null || entity.killedEntity(serverlevel, (LivingEntity)this)) {
                    this.gameEvent((Holder)GameEvent.ENTITY_DIE);
                    this.dropAllDeathLoot(serverlevel, cause);
                    this.createWitherRose(livingentity);
                    this.AfterDefeatBoss(livingentity);
                }
                this.level().broadcastEntityEvent((Entity)this, (byte)3);
            }
            this.setPose(Pose.DYING);
        }
    }

    protected void AfterDefeatBoss(@Nullable LivingEntity p_21269_) {
    }

    public void circleEntity(Entity target, float radius, float speed, boolean direction, int circleFrame, float offset, float moveSpeedMultiplier) {
        int directionInt = direction ? 1 : -1;
        double t = (double)(directionInt * circleFrame) * 0.5 * (double)speed / (double)radius + (double)offset;
        Vec3 movePos = target.position().add((double)radius * Math.cos(t), 0.0, (double)radius * Math.sin(t));
        this.getNavigation().moveTo(movePos.x, movePos.y, movePos.z, (double)(speed * moveSpeedMultiplier));
    }

    protected void repelEntities(float x, float y, float z, float radius) {
        List<LivingEntity> nearbyEntities = this.getEntityLivingBaseNearby(x, y, z, radius);
        for (Entity entity : nearbyEntities) {
            if (!entity.isPickable() || entity.noPhysics) continue;
            double angle = (this.getAngleBetweenEntities((Entity)this, entity) + 90.0) * Math.PI / 180.0;
            entity.setDeltaMovement(-0.1 * Math.cos(angle), entity.getDeltaMovement().y, -0.1 * Math.sin(angle));
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void setSocketPosArray(int index, Vec3 pos) {
        if (this.socketPosArray != null && this.socketPosArray.length > index) {
            this.socketPosArray[index] = pos;
        }
    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    public void push(Entity entityIn) {
        double d1;
        double d0;
        double d2;
        if (!(this.isSleeping() || this.isPassengerOfSameVehicle(entityIn) || entityIn.noPhysics || this.noPhysics || !((d2 = Mth.absMax((double)(d0 = entityIn.getX() - this.getX()), (double)(d1 = entityIn.getZ() - this.getZ()))) >= (double)0.01f))) {
            d2 = Mth.sqrt((float)((float)d2));
            d0 /= d2;
            d1 /= d2;
            double d3 = 1.0 / d2;
            if (d3 > 1.0) {
                d3 = 1.0;
            }
            d0 *= d3;
            d1 *= d3;
            d0 *= (double)0.05f;
            d1 *= (double)0.05f;
            if (!this.isVehicle() && this.canBePushedByEntity(entityIn)) {
                this.push(-d0, 0.0, -d1);
            }
            if (!entityIn.isVehicle()) {
                entityIn.push(d0, 0.0, d1);
            }
        }
    }

    public List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return this.getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return this.level().getEntitiesOfClass(entityClass, this.getBoundingBox().inflate(dX, dY, dZ), e -> e != this && (double)this.distanceTo((Entity)e) <= r + (double)(e.getBbWidth() / 2.0f) && e.getY() <= this.getY() + dY);
    }
}

