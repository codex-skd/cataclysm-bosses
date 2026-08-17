/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResultHolder
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 *  net.minecraft.world.item.ItemUseAnimation
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.items;

import com.skd.thesundering.config.CMCommonConfig;
import com.skd.thesundering.entity.projectile.Wither_Howitzer_Entity;
import com.skd.thesundering.entity.projectile.Wither_Missile_Entity;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModSounds;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Wither_Assault_SHoulder_Weapon
extends Item {
    public Wither_Assault_SHoulder_Weapon(Item.Properties group) {
        super(group);
    }

    public ItemUseAnimation getUseAnimation(ItemStack p_77661_1_) {
        return ItemUseAnimation.BOW;
    }

    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player) {
            Player player = (Player)p_43396_;
            int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
            float f = Wither_Assault_SHoulder_Weapon.getPowerForTime(i);
            if (!((double)f < 0.5)) {
                p_43395_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), (SoundEvent)ModSounds.ROCKET_LAUNCH.get(), SoundSource.PLAYERS, 1.0f, 0.7f);
                if (p_43396_.isShiftKeyDown()) {
                    if (!p_43395_.isClientSide()) {
                        Wither_Howitzer_Entity rocket = new Wither_Howitzer_Entity((EntityType<Wither_Howitzer_Entity>)((EntityType)ModEntities.WITHER_HOWITZER.get()), p_43395_, (LivingEntity)player);
                        rocket.setRadius(3.5f);
                        rocket.shootFromRotation((Entity)player, player.getXRot(), player.getYRot(), 0.0f, f * 1.0f, 1.0f);
                        if (p_43395_.addFreshEntity((Entity)rocket)) {
                            player.getCooldowns().addCooldown((Item)this, CMCommonConfig.WASW.howitzerCooldown);
                        }
                    }
                } else if (!p_43395_.isClientSide()) {
                    float d7 = p_43396_.getYRot();
                    float d = p_43396_.getXRot();
                    float d1 = -Mth.sin((float)(d7 * ((float)Math.PI / 180))) * Mth.cos((float)(d * ((float)Math.PI / 180)));
                    float d2 = -Mth.sin((float)(d * ((float)Math.PI / 180)));
                    float d3 = Mth.cos((float)(d7 * ((float)Math.PI / 180))) * Mth.cos((float)(d * ((float)Math.PI / 180)));
                    double theta = (double)d7 * (Math.PI / 180);
                    double vecX = Math.cos(theta += 1.5707963267948966);
                    double vecZ = Math.sin(theta);
                    double x = p_43396_.getX() + vecX;
                    double Z = p_43396_.getZ() + vecZ;
                    Vec3 vec3 = new Vec3((double)d1, (double)d2, (double)d3);
                    float yRot = (float)(Mth.atan2((double)vec3.z, (double)vec3.x) * 57.29577951308232) + 90.0f;
                    float xRot = (float)(-(Mth.atan2((double)vec3.y, (double)Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * 57.29577951308232));
                    Wither_Missile_Entity witherskull = new Wither_Missile_Entity((LivingEntity)player, vec3.normalize(), p_43395_, (float)CMCommonConfig.WASW.missileDamage);
                    witherskull.setYRot(yRot);
                    witherskull.setXRot(xRot);
                    witherskull.setPosRaw(x, p_43396_.getEyeY(), Z);
                    if (p_43395_.addFreshEntity((Entity)witherskull)) {
                        player.getCooldowns().addCooldown((Item)this, CMCommonConfig.WASW.missileCooldown);
                    }
                }
            }
        }
    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0f;
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume((Object)itemstack);
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.wither_assault_shoulder_weapon.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add((Component)Component.translatable((String)"item.cataclysm.wither_assault_shoulder_weapon.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}

