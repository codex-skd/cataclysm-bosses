/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.network.protocol.game.ClientboundAddEntityPacket
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.entity.projectile.ProjectileUtil
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.sundering.entity.projectile;

import com.skd.sundering.init.ModEntities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class Octo_Ink_Entity
extends Projectile {
    public Octo_Ink_Entity(EntityType<? extends Octo_Ink_Entity> entityType, Level level) {
        super(entityType, level);
    }

    public Octo_Ink_Entity(Level level, LivingEntity spitter) {
        this((EntityType<? extends Octo_Ink_Entity>)((EntityType)ModEntities.OCTO_INK.get()), level);
        this.setOwner((Entity)spitter);
        this.setPos(spitter.getX(), spitter.getEyeY() - (double)0.1f, spitter.getZ());
    }

    protected double getDefaultGravity() {
        return 0.06;
    }

    public void tick() {
        super.tick();
        Vec3 vec3 = this.getDeltaMovement();
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector((Entity)this, x$0 -> this.canHitEntity((Entity)x$0));
        if (hitresult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact((Projectile)this, (HitResult)hitresult)) {
            this.hitTargetOrDeflectSelf(hitresult);
        }
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();
        float f = 0.99f;
        if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        } else if (this.isInWaterOrBubble()) {
            this.discard();
        } else {
            this.setDeltaMovement(vec3.scale((double)0.99f));
            this.applyGravity();
            this.setPos(d0, d1, d2);
        }
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            Level level;
            DamageSource damagesource;
            LivingEntity livingentity = (LivingEntity)entity;
            Entity entity2 = result.getEntity();
            if (entity2.hurt(damagesource = this.damageSources().spit((Entity)this, livingentity), 4.0f) && (level = this.level()) instanceof ServerLevel) {
                ServerLevel serverlevel = (ServerLevel)level;
                EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity2, (DamageSource)damagesource);
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide()) {
            this.discard();
        }
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        double d0 = packet.getXa();
        double d1 = packet.getYa();
        double d2 = packet.getZa();
        for (int i = 0; i < 7; ++i) {
            double d3 = 0.4 + 0.1 * (double)i;
            this.level().addParticle((ParticleOptions)ParticleTypes.SQUID_INK, this.getX(), this.getY(), this.getZ(), d0 * d3, d1, d2 * d3);
        }
        this.setDeltaMovement(d0, d1, d2);
    }
}

