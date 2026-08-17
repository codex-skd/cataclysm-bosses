/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Property
 */
package com.skd.thesundering.blocks;

import com.skd.thesundering.blocks.TrapBlock;
import com.skd.thesundering.entity.projectile.Void_Rune_Entity;
import com.skd.thesundering.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class PurpurVoidRuneTrapBlock
extends TrapBlock {
    public PurpurVoidRuneTrapBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        PurpurVoidRuneTrapBlock.activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    private static void activate(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!((Boolean)state.getValue((Property)LIT)).booleanValue() && PurpurVoidRuneTrapBlock.shouldTrigger(entity)) {
            Void_Rune_Entity voidrune = (Void_Rune_Entity)((EntityType)ModEntities.VOID_RUNE.get()).create(world);
            if (voidrune != null) {
                voidrune.moveTo((double)pos.getX() + 0.5, pos.getY() + 1, (double)pos.getZ() + 0.5, 0.0f, 0.0f);
                voidrune.setDamage(7.0f);
                world.addFreshEntity((Entity)voidrune);
            }
            ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 3));
            world.setBlock(pos, (BlockState)state.setValue((Property)LIT, (Comparable)Boolean.valueOf(true)), 3);
        }
    }
}

