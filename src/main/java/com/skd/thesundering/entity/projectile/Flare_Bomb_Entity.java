/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.projectile.ThrowableProjectile
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.HitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 */
package com.skd.thesundering.entity.projectile;

import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.skd.thesundering.entity.projectile.Flame_Jet_Entity;
import com.skd.thesundering.init.ModParticle;
import com.skd.thesundering.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Flare_Bomb_Entity
extends ThrowableProjectile {
    public double prevDeltaMovementX;
    public double prevDeltaMovementY;
    public double prevDeltaMovementZ;
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, Level world) {
        super(type, world);
    }

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        Level level = this.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverlevel = (ServerLevel)level;
            if (!(result.getEntity() instanceof Flare_Bomb_Entity || shooter instanceof Netherite_Monstrosity_Entity && (result.getEntity() instanceof Netherite_Monstrosity_Part || result.getEntity() instanceof Netherite_Monstrosity_Entity))) {
                Entity entity = result.getEntity();
                Entity entity2 = this.getOwner();
                if (entity2 instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity)entity2;
                    DamageSource damagesource = this.damageSources().mobProjectile((Entity)this, livingentity);
                    boolean flag = entity.hurt(damagesource, 7.0f);
                    if (flag && entity.isAlive()) {
                        entity.igniteForSeconds(5.0f);
                        EnchantmentHelper.doPostAttackEffects((ServerLevel)serverlevel, (Entity)entity, (DamageSource)damagesource);
                    }
                } else {
                    entity.hurt(this.damageSources().magic(), 7.0f);
                }
            }
        }
    }

    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide()) {
            this.playSound(SoundEvents.GENERIC_BURN, 1.5f, 0.75f);
            this.level().broadcastEntityEvent((Entity)this, (byte)4);
            if (this.random.nextBoolean()) {
                this.XStrikeRune(10, 2.0);
            } else {
                this.PlusStrikeRune(10, 2.0);
            }
            this.discard();
        }
    }

    protected void PlusStrikeRune(int rune, double time) {
        for (int i = 0; i < 4; ++i) {
            float yawRadians = (float)Math.toRadians(90.0f + this.getYRot());
            float throwAngle = yawRadians + (float)i * (float)Math.PI / 2.0f;
            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8 * (double)(k + 1);
                int d3 = (int)(time * (double)(k + 1));
                this.spawnJet(this.getX() + (double)Mth.cos((float)throwAngle) * 1.25 * d2, this.getZ() + (double)Mth.sin((float)throwAngle) * 1.25 * d2, this.getY() - 2.0, this.getY() + 2.0, throwAngle, d3);
            }
        }
    }

    protected void XStrikeRune(int rune, double time) {
        for (int i = 0; i < 4; ++i) {
            float yawRadians = (float)Math.toRadians(45.0f + this.getYRot());
            float throwAngle = yawRadians + (float)i * (float)Math.PI / 2.0f;
            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8 * (double)(k + 1);
                int d3 = (int)(time * (double)(k + 1));
                this.spawnJet(this.getX() + (double)Mth.cos((float)throwAngle) * 1.25 * d2, this.getZ() + (double)Mth.sin((float)throwAngle) * 1.25 * d2, this.getY() - 2.0, this.getY() + 2.0, throwAngle, d3);
            }
        }
    }

    protected void spawnJet(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (!blockstate.isFaceSturdy((BlockGetter)this.level(), blockpos1, Direction.UP)) continue;
            if (!this.level().isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = this.level().getBlockState(blockpos)).getCollisionShape((BlockGetter)this.level(), blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)minY) - 1);
        if (flag) {
            Entity entity;
            if (this.getOwner() != null && (entity = this.getOwner()) instanceof LivingEntity) {
                LivingEntity living = (LivingEntity)entity;
                this.level().addFreshEntity((Entity)new Flame_Jet_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, 7.0f, living));
            } else {
                this.level().addFreshEntity((Entity)new Flame_Jet_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, 7.0f, null));
            }
        }
    }

    public void tick() {
        super.tick();
        this.prevDeltaMovementX = this.getDeltaMovement().x;
        this.prevDeltaMovementY = this.getDeltaMovement().y;
        this.prevDeltaMovementZ = this.getDeltaMovement().z;
        this.setYRot(-((float)Mth.atan2((double)this.getDeltaMovement().x, (double)this.getDeltaMovement().z)) * 57.295776f);
        Vec3 trailAt = this.position().add(0.0, (double)(this.getBbHeight() / 2.0f), 0.0);
        if (this.trailPointer == -1) {
            Vec3 backAt = trailAt;
            for (int i = 0; i < this.trailPositions.length; ++i) {
                this.trailPositions[i] = backAt;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = trailAt;
    }

    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.isRemoved()) {
            partialTick = 1.0f;
        }
        int i = this.trailPointer - pointer & 0x3F;
        int j = this.trailPointer - pointer - 1 & 0x3F;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale((double)partialTick));
    }

    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), (SoundEvent)ModSounds.EXPLOSION.get(), SoundSource.BLOCKS, 4.0f, (1.0f + (this.level().random.nextFloat() - this.level().random.nextFloat()) * 0.2f) * 0.7f, false);
            this.level().addParticle((ParticleOptions)ModParticle.FLARE_EXPLODE.get(), this.getX(), this.getY(), this.getZ(), 0.1, 0.0, 0.0);
        }
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0f;
    }

    protected double getDefaultGravity() {
        return 0.025;
    }

    public boolean hasTrail() {
        return this.trailPointer != -1;
    }
}

