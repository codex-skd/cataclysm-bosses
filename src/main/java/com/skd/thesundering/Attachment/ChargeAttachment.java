/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.phys.AABB
 */
package com.skd.thesundering.Attachment;

import com.skd.thesundering.entity.effect.Wall_Watcher_Entity;
import java.util.List;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;

public class ChargeAttachment {
    private boolean charge;
    public int Timer;
    public int effectiveChargeTime;
    public float dx;
    public float dz;
    public float damagePerEffectiveCharge;
    public float knockbackSpeedIndex;

    public void tick(LivingEntity entity) {
        if (this.isCharge() && !entity.level().isClientSide()) {
            int temp = this.getTimer();
            this.setTimer(temp - 1);
            if (temp > 0) {
                AABB collideBox = entity.getBoundingBox().inflate(0.75, 0.75, 0.75);
                List checks = entity.level().getEntitiesOfClass(LivingEntity.class, collideBox);
                checks.remove(entity);
                if (!checks.isEmpty()) {
                    Wall_Watcher_Entity watchEntity = new Wall_Watcher_Entity(entity.level(), entity.blockPosition(), temp, this.effectiveChargeTime, this.knockbackSpeedIndex, this.damagePerEffectiveCharge, this.dx, this.dz, entity);
                    List<LivingEntity> impact = entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(3.5, 0.75, 3.5));
                    impact.remove(entity);
                    for (LivingEntity target : impact) {
                        if (target.isAlliedTo((Entity)entity)) continue;
                        // Entity.hurt(...) returns void in 26.2.0.45-beta (was boolean) -- no
                        // longer tells us whether the hit actually connected, so the sound now
                        // plays unconditionally instead of being gated on a success flag.
                        target.hurt(entity.damageSources().mobProjectile((Entity)entity, entity), this.damagePerEffectiveCharge * (float)this.effectiveChargeTime);
                        watchEntity.watch(target);
                        target.playSound(SoundEvents.ANVIL_LAND, 1.5f, 0.8f);
                    }
                    entity.level().addFreshEntity((Entity)watchEntity);
                    entity.setDeltaMovement(0.0, 0.0, 0.0);
                    entity.hurtMarked = true;
                    this.setCharge(false);
                }
            }
            if (entity.horizontalCollision || temp == 0) {
                this.setCharge(false);
            }
        }
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public boolean isCharge() {
        return this.charge;
    }

    public void setdamagePerEffectiveCharge(float damage) {
        this.damagePerEffectiveCharge = damage;
    }

    public float getdamagePerEffectiveCharge() {
        return this.damagePerEffectiveCharge;
    }

    public void setknockbackSpeedIndex(float knockback) {
        this.knockbackSpeedIndex = knockback;
    }

    public float getknockbackSpeedIndex() {
        return this.knockbackSpeedIndex;
    }

    public void seteffectiveChargeTime(int chargetime) {
        this.effectiveChargeTime = chargetime;
    }

    public int geteffectiveChargeTime() {
        return this.effectiveChargeTime;
    }

    public void setdx(float dx) {
        this.dx = dx;
    }

    public float getdx() {
        return this.dx;
    }

    public void setdZ(float dz) {
        this.dz = dz;
    }

    public float getdZ() {
        return this.dz;
    }

    public void setTimer(int timer) {
        this.Timer = timer;
    }

    public int getTimer() {
        return this.Timer;
    }
}

