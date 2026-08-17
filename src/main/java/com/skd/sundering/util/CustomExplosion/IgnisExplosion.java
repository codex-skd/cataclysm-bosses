/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Sets
 *  com.mojang.datafixers.util.Pair
 *  it.unimi.dsi.fastutil.objects.ObjectArrayList
 *  javax.annotation.Nullable
 *  net.minecraft.Util
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.item.PrimedTnt
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.Projectile
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.EntityBasedExplosionDamageCalculator
 *  net.minecraft.world.level.Explosion
 *  net.minecraft.world.level.Explosion$BlockInteraction
 *  net.minecraft.world.level.ExplosionDamageCalculator
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseFireBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.event.EventHooks
 */
package com.skd.sundering.util.CustomExplosion;

import com.skd.sundering.init.ModParticle;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class IgnisExplosion
extends Explosion {
    private static final ExplosionDamageCalculator EXPLOSION_DAMAGE_CALCULATOR = new ExplosionDamageCalculator();
    private static final int MAX_DROPS_PER_COMBINED_STACK = 16;
    private final boolean fire;
    private final Explosion.BlockInteraction blockInteraction;
    private final RandomSource random = RandomSource.create();
    private final Level level;
    private final double x;
    private final double y;
    private final double z;
    @Nullable
    private final Entity source;
    private final float radius;
    private final DamageSource damageSource;
    private final ExplosionDamageCalculator damageCalculator;
    private final ObjectArrayList<BlockPos> toBlow = new ObjectArrayList();
    private final Map<Player, Vec3> hitPlayers = Maps.newHashMap();
    private final Vec3 position;

    public IgnisExplosion(Level level, @Nullable Entity source, @Nullable DamageSource damageSource, @Nullable ExplosionDamageCalculator damageCalculator, double x, double y, double z, float radius, boolean fire, Explosion.BlockInteraction blockInteraction) {
        super(level, source, IgnisExplosion.getDefaultDamageSource((Level)level, (Entity)source), (ExplosionDamageCalculator)null, x, y, z, radius, fire, blockInteraction, (ParticleOptions)ParticleTypes.EXPLOSION, (ParticleOptions)ParticleTypes.EXPLOSION_EMITTER, (Holder)SoundEvents.GENERIC_EXPLODE);
        this.level = level;
        this.source = source;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
        this.fire = fire;
        this.blockInteraction = blockInteraction;
        this.damageSource = damageSource == null ? level.damageSources().explosion((Explosion)this) : damageSource;
        this.damageCalculator = damageCalculator == null ? this.makeDamageCalculator(source) : damageCalculator;
        this.position = new Vec3(this.x, this.y, this.z);
    }

    private ExplosionDamageCalculator makeDamageCalculator(@Nullable Entity p_46063_) {
        return p_46063_ == null ? EXPLOSION_DAMAGE_CALCULATOR : new EntityBasedExplosionDamageCalculator(p_46063_);
    }

    public static float getSeenPercent(Vec3 p_46065_, Entity p_46066_) {
        AABB aabb = p_46066_.getBoundingBox();
        double d0 = 1.0 / ((aabb.maxX - aabb.minX) * 2.0 + 1.0);
        double d1 = 1.0 / ((aabb.maxY - aabb.minY) * 2.0 + 1.0);
        double d2 = 1.0 / ((aabb.maxZ - aabb.minZ) * 2.0 + 1.0);
        double d3 = (1.0 - Math.floor(1.0 / d0) * d0) / 2.0;
        double d4 = (1.0 - Math.floor(1.0 / d2) * d2) / 2.0;
        if (!(d0 < 0.0 || d1 < 0.0 || d2 < 0.0)) {
            int i = 0;
            int j = 0;
            for (double d5 = 0.0; d5 <= 1.0; d5 += d0) {
                for (double d6 = 0.0; d6 <= 1.0; d6 += d1) {
                    for (double d7 = 0.0; d7 <= 1.0; d7 += d2) {
                        double d8 = Mth.lerp((double)d5, (double)aabb.minX, (double)aabb.maxX);
                        double d9 = Mth.lerp((double)d6, (double)aabb.minY, (double)aabb.maxY);
                        double d10 = Mth.lerp((double)d7, (double)aabb.minZ, (double)aabb.maxZ);
                        Vec3 vec3 = new Vec3(d8 + d3, d9, d10 + d4);
                        if (p_46066_.level().clip(new ClipContext(vec3, p_46065_, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, p_46066_)).getType() == HitResult.Type.MISS) {
                            ++i;
                        }
                        ++j;
                    }
                }
            }
            return (float)i / (float)j;
        }
        return 0.0f;
    }

    public void explode() {
        this.level.gameEvent(this.source, (Holder)GameEvent.EXPLODE, new Vec3(this.x, this.y, this.z));
        HashSet set = Sets.newHashSet();
        int i = 16;
        for (int j = 0; j < 16; ++j) {
            for (int k = 0; k < 16; ++k) {
                block2: for (int l = 0; l < 16; ++l) {
                    if (j != 0 && j != 15 && k != 0 && k != 15 && l != 0 && l != 15) continue;
                    double d0 = (float)j / 15.0f * 2.0f - 1.0f;
                    double d1 = (float)k / 15.0f * 2.0f - 1.0f;
                    double d2 = (float)l / 15.0f * 2.0f - 1.0f;
                    double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                    d0 /= d3;
                    d1 /= d3;
                    d2 /= d3;
                    double d4 = this.x;
                    double d6 = this.y;
                    double d8 = this.z;
                    float f1 = 0.3f;
                    for (float f = this.radius * (0.7f + this.level.random.nextFloat() * 0.6f); f > 0.0f; f -= 0.22500001f) {
                        BlockPos blockpos = BlockPos.containing((double)d4, (double)d6, (double)d8);
                        BlockState blockstate = this.level.getBlockState(blockpos);
                        FluidState fluidstate = this.level.getFluidState(blockpos);
                        if (!this.level.isInWorldBounds(blockpos)) continue block2;
                        Optional optional = this.damageCalculator.getBlockExplosionResistance((Explosion)this, (BlockGetter)this.level, blockpos, blockstate, fluidstate);
                        if (optional.isPresent()) {
                            f -= (((Float)optional.get()).floatValue() + 0.3f) * 0.3f;
                        }
                        if (f > 0.0f && this.damageCalculator.shouldBlockExplode((Explosion)this, (BlockGetter)this.level, blockpos, blockstate, f)) {
                            set.add(blockpos);
                        }
                        d4 += d0 * (double)0.3f;
                        d6 += d1 * (double)0.3f;
                        d8 += d2 * (double)0.3f;
                    }
                }
            }
        }
        this.toBlow.addAll((Collection)set);
        float f2 = this.radius * 2.0f;
        int k1 = Mth.floor((double)(this.x - (double)f2 - 1.0));
        int l1 = Mth.floor((double)(this.x + (double)f2 + 1.0));
        int i2 = Mth.floor((double)(this.y - (double)f2 - 1.0));
        int i1 = Mth.floor((double)(this.y + (double)f2 + 1.0));
        int j2 = Mth.floor((double)(this.z - (double)f2 - 1.0));
        int j1 = Mth.floor((double)(this.z + (double)f2 + 1.0));
        List list = this.level.getEntities(this.source, new AABB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
        EventHooks.onExplosionDetonate((Level)this.level, (Explosion)this, (List)list, (double)f2);
        Vec3 vec3 = new Vec3(this.x, this.y, this.z);
        for (Entity entity : list) {
            Player player;
            double d10;
            double d9;
            double d7;
            double d5;
            double d12;
            double d11;
            if (entity.ignoreExplosion((Explosion)this) || !((d11 = Math.sqrt(entity.distanceToSqr(vec3)) / (double)f2) <= 1.0) || (d12 = Math.sqrt((d5 = entity.getX() - this.x) * d5 + (d7 = (entity instanceof PrimedTnt ? entity.getY() : entity.getEyeY()) - this.y) * d7 + (d9 = entity.getZ() - this.z) * d9)) == 0.0) continue;
            d5 /= d12;
            d7 /= d12;
            d9 /= d12;
            if (this.damageCalculator.shouldDamageEntity((Explosion)this, entity)) {
                entity.hurt(this.damageSource, this.damageCalculator.getEntityDamageAmount((Explosion)this, entity));
            }
            double d13 = (1.0 - d11) * (double)IgnisExplosion.getSeenPercent(vec3, entity) * (double)this.damageCalculator.getKnockbackMultiplier(entity);
            if (entity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity;
                d10 = d13 * (1.0 - livingentity.getAttributeValue(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE));
            } else {
                d10 = d13;
            }
            Vec3 vec31 = new Vec3(d5 *= d10, d7 *= d10, d9 *= d10);
            vec31 = EventHooks.getExplosionKnockback((Level)this.level, (Explosion)this, (Entity)entity, (Vec3)vec31);
            entity.setDeltaMovement(entity.getDeltaMovement().add(vec31));
            if (!(!(entity instanceof Player) || (player = (Player)entity).isSpectator() || player.isCreative() && player.getAbilities().flying)) {
                this.hitPlayers.put(player, vec31);
            }
            entity.onExplosionHit(this.source);
        }
    }

    public void finalizeExplosion(int color, double size) {
        Level level;
        this.level.playSound(null, this.x, this.y, this.z, (Holder)SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0f, (1.0f + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2f) * 0.7f);
        boolean flag = this.interactsWithBlocks();
        if (color != 0 && !this.level.isClientSide() && (level = this.level) instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            int i = 0;
            while ((float)i < 5.0f + this.radius * 5.0f) {
                float particleX = (this.random.nextFloat() - 0.5f) * this.radius * 1.5f;
                float particleY = (this.random.nextFloat() - 0.5f) * this.radius * 1.5f;
                float particleZ = (this.random.nextFloat() - 0.5f) * this.radius * 1.5f;
                serverLevel.sendParticles((ParticleOptions)(color == 1 ? (SimpleParticleType)ModParticle.IGNIS_EXPLODE.get() : (color == 2 ? (SimpleParticleType)ModParticle.IGNIS_SOUL_EXPLODE.get() : (color == 3 ? (SimpleParticleType)ModParticle.IGNIS_ABYSS_EXPLODE.get() : ParticleTypes.EXPLOSION))), this.x + (double)particleX, this.y + (double)particleY, this.z + (double)particleZ, 1, 1.0, 0.0, 0.0, size);
                ++i;
            }
        }
        if (flag) {
            this.level.getProfiler().push("explosion_blocks");
            ArrayList list = new ArrayList();
            Util.shuffle(this.toBlow, (RandomSource)this.level.random);
            for (BlockPos blockpos : this.toBlow) {
                this.level.getBlockState(blockpos).onExplosionHit(this.level, blockpos, (Explosion)this, (p_311741_, p_311742_) -> IgnisExplosion.addOrAppendStack(list, p_311741_, p_311742_));
            }
            for (Pair pair : list) {
                Block.popResource((Level)this.level, (BlockPos)((BlockPos)pair.getSecond()), (ItemStack)((ItemStack)pair.getFirst()));
            }
            this.level.getProfiler().pop();
        }
        if (this.fire) {
            for (BlockPos blockpos1 : this.toBlow) {
                if (this.random.nextInt(3) != 0 || !this.level.getBlockState(blockpos1).isAir() || !this.level.getBlockState(blockpos1.below()).isSolidRender((BlockGetter)this.level, blockpos1.below())) continue;
                this.level.setBlockAndUpdate(blockpos1, BaseFireBlock.getState((BlockGetter)this.level, (BlockPos)blockpos1));
            }
        }
    }

    private static void addOrAppendStack(List<Pair<ItemStack, BlockPos>> drops, ItemStack stack, BlockPos pos) {
        for (int i = 0; i < drops.size(); ++i) {
            Pair<ItemStack, BlockPos> pair = drops.get(i);
            ItemStack itemstack = (ItemStack)pair.getFirst();
            if (!ItemEntity.areMergable((ItemStack)itemstack, (ItemStack)stack)) continue;
            drops.set(i, (Pair<ItemStack, BlockPos>)Pair.of((Object)ItemEntity.merge((ItemStack)itemstack, (ItemStack)stack, (int)16), (Object)((BlockPos)pair.getSecond())));
            if (!stack.isEmpty()) continue;
            return;
        }
        drops.add((Pair<ItemStack, BlockPos>)Pair.of((Object)stack, (Object)pos));
    }

    public boolean interactsWithBlocks() {
        return this.blockInteraction != Explosion.BlockInteraction.KEEP;
    }

    public Map<Player, Vec3> getHitPlayers() {
        return this.hitPlayers;
    }

    @Nullable
    private static LivingEntity getIndirectSourceEntityInternal(@Nullable Entity source) {
        Projectile projectile;
        Entity entity;
        if (source == null) {
            return null;
        }
        if (source instanceof PrimedTnt) {
            PrimedTnt primedtnt = (PrimedTnt)source;
            return primedtnt.getOwner();
        }
        if (source instanceof LivingEntity) {
            return (LivingEntity)source;
        }
        if (source instanceof Projectile && (entity = (projectile = (Projectile)source).getOwner()) instanceof LivingEntity) {
            return (LivingEntity)entity;
        }
        return null;
    }

    @Nullable
    public LivingEntity getIndirectSourceEntity() {
        return IgnisExplosion.getIndirectSourceEntityInternal(this.source);
    }

    @Nullable
    public Entity getDirectSourceEntity() {
        return this.source;
    }

    public void clearToBlow() {
        this.toBlow.clear();
    }

    public List<BlockPos> getToBlow() {
        return this.toBlow;
    }

    public Explosion.BlockInteraction getBlockInteraction() {
        return this.blockInteraction;
    }

    public boolean canTriggerBlocks() {
        if (this.blockInteraction == Explosion.BlockInteraction.TRIGGER_BLOCK && !this.level.isClientSide()) {
            return this.source != null && this.source.getType() == EntityType.BREEZE_WIND_CHARGE ? this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) : true;
        }
        return false;
    }

    public Vec3 getPosition() {
        return this.position;
    }
}

