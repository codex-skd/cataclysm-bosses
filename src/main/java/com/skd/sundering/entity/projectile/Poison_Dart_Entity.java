/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow
 *  net.minecraft.world.entity.projectile.arrow.AbstractArrow$Pickup
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 */
package com.skd.sundering.entity.projectile;

import com.skd.sundering.init.ModEntities;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class Poison_Dart_Entity
extends AbstractArrow {
    public Poison_Dart_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Poison_Dart_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Poison_Dart_Entity(Level worldIn, LivingEntity shooter) {
        this((EntityType)ModEntities.POISON_DART.get(), shooter.getX(), shooter.getEyeY() - (double)0.1f, shooter.getZ(), worldIn);
        this.setOwner((Entity)shooter);
        if (shooter instanceof Player) {
            this.pickup = AbstractArrow.Pickup.ALLOWED;
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }

    protected void doPostHurtEffects(LivingEntity p_36873_) {
        super.doPostHurtEffects(p_36873_);
        Entity entity = this.getEffectSource();
        p_36873_.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1), entity);
    }

    protected ItemStack getDefaultPickupItem() {
        return new ItemStack((ItemLike)Items.ARROW);
    }
}

