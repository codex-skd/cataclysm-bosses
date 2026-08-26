/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.Holder
 *  net.minecraft.network.chat.Component
 *  net.minecraft.stats.Stats
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntitySelector
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.gameevent.GameEvent
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.items;

import net.minecraft.world.entity.EntitySpawnReason;
import com.skd.cataclysmbosses.entity.Pet.Netherite_Ministrosity_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Netherite_Effigy
extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

    public Netherite_Effigy(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level p_40622_, Player p_40623_, InteractionHand p_40624_) {
        ItemStack itemstack = p_40623_.getItemInHand(p_40624_);
        BlockHitResult hitresult = Netherite_Effigy.getPlayerPOVHitResult((Level)p_40622_, (Player)p_40623_, (ClipContext.Fluid)ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResult.PASS;
        }
        Vec3 vec3 = p_40623_.getViewVector(1.0f);
        Vec3 vec31 = hitresult.getLocation();
        double d0 = 5.0;
        List list = p_40622_.getEntities((Entity)p_40623_, p_40623_.getBoundingBox().expandTowards(vec3.scale(5.0)).inflate(1.0), ENTITY_PREDICATE);
        if (!list.isEmpty()) {
            for (Entity entity : list) {
                AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                if (!aabb.contains(vec31)) continue;
                return InteractionResult.PASS;
            }
        }
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            Netherite_Ministrosity_Entity remnantEntity = (Netherite_Ministrosity_Entity)((EntityType)ModEntities.NETHERITE_MINISTROSITY.get()).create(p_40622_, EntitySpawnReason.EVENT);
            remnantEntity.setPos(vec31.x, vec31.y, vec31.z);
            remnantEntity.setIsAwaken(false);
            if (!p_40622_.noCollision((Entity)remnantEntity, remnantEntity.getBoundingBox())) {
                return InteractionResult.FAIL;
            }
            if (!p_40622_.isClientSide()) {
                p_40622_.addFreshEntity((Entity)remnantEntity);
                p_40622_.gameEvent((Entity)p_40623_, (Holder)GameEvent.ENTITY_PLACE, vec31);
                if (!p_40623_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
            }
            p_40623_.awardStat(Stats.ITEM_USED.get((Object)this));
            return p_40622_.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.PASS;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add((Component)Component.translatable((String)"item.cataclysm.netherite_effigy.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

