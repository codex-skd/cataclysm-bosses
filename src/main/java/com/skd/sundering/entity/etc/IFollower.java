/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.TamableAnimal
 */
package com.skd.sundering.entity.etc;

import com.skd.sundering.entity.Pet.Summoned_Entity.Abstract_Summoned_Entity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;

public interface IFollower {
    public boolean shouldFollow();

    default public void followEntity(TamableAnimal tameable, LivingEntity owner, double followSpeed) {
        tameable.getNavigation().moveTo((Entity)owner, followSpeed);
    }

    default public void followEntity(Abstract_Summoned_Entity tameable, LivingEntity owner, double followSpeed) {
        tameable.getNavigation().moveTo((Entity)owner, followSpeed);
    }
}

