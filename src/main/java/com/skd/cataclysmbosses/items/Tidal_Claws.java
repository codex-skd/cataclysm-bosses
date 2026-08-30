/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.chat.Component
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.EntityHitResult
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.items;

import net.minecraft.world.entity.EntitySpawnReason;
import com.skd.cataclysmbosses.Attachment.TidalTentacleAttachment;
import com.skd.cataclysmbosses.entity.projectile.Tidal_Hook_Entity;
import com.skd.cataclysmbosses.entity.projectile.Tidal_Tentacle_Entity;
import com.skd.cataclysmbosses.entity.util.TidalTentacleUtil;
import com.skd.cataclysmbosses.init.ModDataAttachments;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import com.skd.cataclysmbosses.items.ILeftClick;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Tidal_Claws
extends Cataclysm_Weapon
implements ILeftClick {
    public Tidal_Claws(Item.Properties group) {
        super(group);
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_77661_1_) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity player) {
        this.launchTendonsAt(stack, player, (Entity)entity);
        super.hurtEnemy(stack, entity, player);
    }

    private boolean isCharged(Player player, ItemStack stack) {
        return player.getAttackStrengthScale(0.5f) > 0.9f;
    }

    @Override
    public boolean onLeftClick(ItemStack stack, LivingEntity playerIn) {
        if (stack.is((Item)ModItems.TIDAL_CLAWS.get()) && (!(playerIn instanceof Player) || this.isCharged((Player)playerIn, stack))) {
            Level worldIn = playerIn.level();
            Entity closestValid = null;
            Vec3 playerEyes = playerIn.getEyePosition(1.0f);
            net.minecraft.world.phys.HitResult hitresult = worldIn.clip(new ClipContext(playerEyes, playerEyes.add(playerIn.getLookAngle().scale(16.0)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, (Entity)playerIn));
            if (hitresult instanceof EntityHitResult) {
                Entity entity = ((EntityHitResult)hitresult).getEntity();
                if (!entity.equals((Object)playerIn) && !playerIn.isAlliedTo(entity) && !entity.isAlliedTo((Entity)playerIn) && entity instanceof Mob && playerIn.hasLineOfSight(entity)) {
                    closestValid = entity;
                }
            } else {
                for (Entity entity : worldIn.getEntitiesOfClass(LivingEntity.class, playerIn.getBoundingBox().inflate(16.0))) {
                    if (entity.equals((Object)playerIn) || playerIn.isAlliedTo(entity) || entity.isAlliedTo((Entity)playerIn) || !(entity instanceof Mob) || !playerIn.hasLineOfSight(entity) || closestValid != null && !(playerIn.distanceTo(entity) < playerIn.distanceTo(closestValid))) continue;
                    closestValid = entity;
                }
            }
            return this.launchTendonsAt(stack, playerIn, closestValid);
        }
        return false;
    }

    public boolean launchTendonsAt(ItemStack stack, LivingEntity playerIn, Entity closestValid) {
        Level worldIn = playerIn.level();
        TidalTentacleAttachment charge = (TidalTentacleAttachment)playerIn.getData(ModDataAttachments.TIDAL_TENTACLE_ATTACHMENT);
        if (!charge.hasTentacle() && TidalTentacleUtil.canLaunchTentacles(worldIn, playerIn)) {
            TidalTentacleUtil.retractFarTentacles(worldIn, playerIn);
            if (!worldIn.isClientSide() && closestValid != null) {
                Tidal_Tentacle_Entity segment = (Tidal_Tentacle_Entity)((EntityType)ModEntities.TIDAL_TENTACLE.get()).create(worldIn, EntitySpawnReason.EVENT);
                segment.copyPosition((Entity)playerIn);
                worldIn.addFreshEntity((Entity)segment);
                segment.setCreatorEntityUUID(playerIn.getUUID());
                segment.setFromEntityID(playerIn.getId());
                segment.setToEntityID(closestValid.getId());
                segment.copyPosition((Entity)playerIn);
                segment.setProgress(0.0f);
                TidalTentacleUtil.setLastTentacle(playerIn, segment);
                return true;
            }
        }
        return false;
    }

    public InteractionResult use(Level level, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        boolean flag = (Boolean)user.getData(ModDataAttachments.HOOK_FALLING);
        if (!level.isClientSide() && !flag) {
            double maxRange = 30.0;
            double maxSpeed = 12.0;
            Tidal_Hook_Entity hookshot = new Tidal_Hook_Entity(level, (LivingEntity)user, stack);
            hookshot.setProperties(stack, maxRange, maxSpeed, user.getXRot(), user.getYRot(), 0.0f, 1.5f * (float)(maxSpeed / 10.0));
            level.addFreshEntity((Entity)hookshot);
        }
        user.startUsingItem(hand);
        user.setData(ModDataAttachments.HOOK_FALLING.get(), true);
        return super.use(level, user, hand);
    }

    public ItemStack finishUsingItem(ItemStack p_40712_, Level p_40713_, LivingEntity p_40714_) {
        boolean flag = (Boolean)p_40714_.getData(ModDataAttachments.HOOK_FALLING.get());
        if (flag) {
            p_40714_.setData(ModDataAttachments.HOOK_FALLING.get(), false);
        }
        return super.finishUsingItem(p_40712_, p_40713_, p_40714_);
    }

    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        boolean flag = (Boolean)user.getData(ModDataAttachments.HOOK_FALLING.get());
        if (flag) {
            user.setData(ModDataAttachments.HOOK_FALLING.get(), false);
        }
        return false;
    }

    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public int getEnchantmentValue() {
        return 16;
    }

    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.tidal_claws.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.tidal_claws.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}

