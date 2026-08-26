package com.skd.cataclysmbosses.entity.projectile;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

/*
 * PORT NOTE (26.2): placeholder — original class was missing from the decompiled port
 * (referenced by ModEntities but never ported). Minimal stub extending
 * ThrowableItemProjectile so ModEntities compiles; proper logic deferred.
 */
public class Lionfish_Spike_Entity extends ThrowableItemProjectile {
    public Lionfish_Spike_Entity(EntityType<? extends Lionfish_Spike_Entity> type, Level level) {
        super(type, level);
    }

    public Lionfish_Spike_Entity(EntityType<? extends Lionfish_Spike_Entity> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
    }

    public Lionfish_Spike_Entity(EntityType<? extends Lionfish_Spike_Entity> type, LivingEntity owner, Level level) {
        super(type, owner, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.COD;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            this.discard();
        }
    }

    @Override
    protected double getDefaultGravity() {
        return 0.05;
    }
}
