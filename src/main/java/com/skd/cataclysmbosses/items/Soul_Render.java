/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.network.chat.Component
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.neoforged.neoforge.common.ItemAbilities
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.Attachment.RenderRushAttachment;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.entity.projectile.Phantom_Halberd_Entity;
import com.skd.cataclysmbosses.init.ModDataAttachments;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;

public class Soul_Render
extends Cataclysm_Weapon {
    public Soul_Render(Item.Properties properties) {
        super(properties);
    }

    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        boolean hasSucceeded = false;
        if (livingEntity instanceof Player) {
            Player player = (Player)livingEntity;
            int i = this.getUseDuration(stack, livingEntity) - timeLeft;
            if (livingEntity.isShiftKeyDown()) {
                this.StrikeWindmillHalberd(level, (LivingEntity)player, 7, 5, 1.0, 1.0, 0.2, 1);
                if (!level.isClientSide()) {
                    player.getCooldowns().addCooldown(this.getDefaultInstance(), CMCommonConfig.SoulRender.cooldown);
                }
            } else {
                int t = Mth.clamp((int)i, (int)0, (int)60);
                if (t > 0) {
                    float f = 0.1f * (float)t;
                    Vec3 vec3 = player.getDeltaMovement().add(player.getViewVector(1.0f).normalize().multiply((double)f, (double)(f * 0.15f), (double)f));
                    livingEntity.setDeltaMovement(vec3.add(0.0, (double)(livingEntity.onGround() ? 0.2f : 0.0f), 0.0));
                    RenderRushAttachment charge = (RenderRushAttachment)livingEntity.getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT);
                    charge.setRush(true);
                    charge.setTimer(t / 2);
                    charge.setdamage((float)player.getAttributeValue(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE));
                    hasSucceeded = true;
                    if (!level.isClientSide() && hasSucceeded) {
                        player.getCooldowns().addCooldown(this.getDefaultInstance(), CMCommonConfig.SoulRender.cooldown);
                    }
                }
            }
        }
        return true;
    }

    private void StrikeWindmillHalberd(Level level, LivingEntity player, int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, int delay) {
        float angleIncrement = (float)(Math.PI * 2 / (double)numberOfBranches);
        for (int branch = 0; branch < numberOfBranches; ++branch) {
            float baseAngle = angleIncrement * (float)branch;
            for (int i = 0; i < particlesPerBranch; ++i) {
                double currentRadius = initialRadius + (double)i * radiusIncrement;
                float currentAngle = (float)((double)baseAngle + (double)((float)i * angleIncrement) / initialRadius + (double)((float)((double)i * curveFactor)));
                double xOffset = currentRadius * Math.cos(currentAngle);
                double zOffset = currentRadius * Math.sin(currentAngle);
                double spawnX = player.getX() + xOffset;
                double spawnY = player.getY() + 0.3;
                double spawnZ = player.getZ() + zOffset;
                int d3 = delay * (i + 1);
                double deltaX = level.getRandom().nextGaussian() * 0.007;
                double deltaY = level.getRandom().nextGaussian() * 0.007;
                double deltaZ = level.getRandom().nextGaussian() * 0.007;
                if (level.isClientSide()) {
                    level.addParticle((ParticleOptions)ModParticle.PHANTOM_WING_FLAME.get(), spawnX, spawnY, spawnZ, deltaX, deltaY, deltaZ);
                }
                this.spawnHalberd(spawnX, spawnZ, player.getY() - 5.0, player.getY() + 3.0, currentAngle, d3, level, player);
            }
        }
    }

    private void spawnHalberd(double x, double z, double minY, double maxY, float rotation, int delay, Level world, LivingEntity player) {
        BlockPos blockpos = BlockPos.containing((double)x, (double)maxY, (double)z);
        boolean flag = false;
        double d0 = 0.0;
        do {
            BlockState blockstate1;
            VoxelShape voxelshape;
            BlockPos blockpos1;
            BlockState blockstate;
            if (!(blockstate = world.getBlockState(blockpos1 = blockpos.below())).isFaceSturdy((BlockGetter)world, blockpos1, Direction.UP)) continue;
            if (!world.isEmptyBlock(blockpos) && !(voxelshape = (blockstate1 = world.getBlockState(blockpos)).getCollisionShape((BlockGetter)world, blockpos)).isEmpty()) {
                d0 = voxelshape.max(Direction.Axis.Y);
            }
            flag = true;
            break;
        } while ((blockpos = blockpos.below()).getY() >= Mth.floor((double)minY) - 1);
        if (flag) {
            world.addFreshEntity((Entity)new Phantom_Halberd_Entity(world, x, (double)blockpos.getY() + d0, z, rotation, delay, player, (float)CMCommonConfig.SoulRender.phantomHalberdDamage));
        }
    }

    public InteractionResult use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
        InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);
        if (otheritem.has(net.minecraft.core.component.DataComponents.BLOCKS_ATTACKS) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem)) {
            return InteractionResult.FAIL;
        }
        p_77659_2_.startUsingItem(p_77659_3_);
        return InteractionResult.CONSUME;
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

    public float getDestroySpeed(ItemStack p_41004_, BlockState p_41005_) {
        float speed = 15.0f;
        return p_41005_.is(BlockTags.MINEABLE_WITH_AXE) ? speed : 1.0f;
    }

    public static float getPowerForTime(int i) {
        float f = (float)i / (float)Soul_Render.getMaxLoadTime();
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    private static int getMaxLoadTime() {
        return 20;
    }

    public int getUseDuration(ItemStack p_43419_, LivingEntity p_345001_) {
        return 72000;
    }

    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BLOCK;
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, java.util.function.Consumer<Component> builder, TooltipFlag flags) {
        builder.accept((Component)Component.translatable((String)"item.cataclysm.soul_render.desc").withStyle(ChatFormatting.DARK_GREEN));
        builder.accept((Component)Component.translatable((String)"item.cataclysm.soul_render2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

