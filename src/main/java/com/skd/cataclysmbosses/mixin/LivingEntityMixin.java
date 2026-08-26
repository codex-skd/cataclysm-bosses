/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.Holder
 *  net.minecraft.world.effect.MobEffect
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.level.Level
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.skd.cataclysmbosses.mixin;

import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.util.EntityUtil;
import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={LivingEntity.class})
public abstract class LivingEntityMixin
extends Entity {
    @Shadow
    public abstract boolean hasEffect(Holder<MobEffect> var1);

    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(method={"canAttack(Lnet/minecraft/world/entity/LivingEntity;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    public void onCanAttack(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity)this;
        if (self.hasEffect(ModEffect.EFFECTSTUN)) {
            cir.setReturnValue((Object)false);
        }
    }

    @Inject(method={"addEffect(Lnet/minecraft/world/effect/MobEffectInstance;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAddEffect(MobEffectInstance effectInstance, CallbackInfoReturnable<Boolean> cir) {
        this.dev1_21_1$handleStunEffectLogic(effectInstance, null, cir);
    }

    @Inject(method={"addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAddEffectWithSource(MobEffectInstance effectInstance, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        this.dev1_21_1$handleStunEffectLogic(effectInstance, source, cir);
    }

    @Unique
    private void dev1_21_1$handleStunEffectLogic(MobEffectInstance effectInstance, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        Player player;
        block5: {
            block4: {
                LivingEntity self = (LivingEntity)this;
                if (!(self instanceof Player)) break block4;
                player = (Player)self;
                if (effectInstance.getEffect().equals(ModEffect.EFFECTSTUN)) break block5;
            }
            return;
        }
        if (EntityUtil.isEquipped((Item)ModItems.UNBREAKABLE_SKULL.get(), (LivingEntity)player) && !player.getCooldowns().isOnCooldown(ModItems.UNBREAKABLE_SKULL.get().getDefaultInstance())) {
            int cooldownTicks = 900;
            player.getCooldowns().addCooldown(ModItems.UNBREAKABLE_SKULL.get().getDefaultInstance(), cooldownTicks);
            cir.setReturnValue((Object)false);
        }
    }
}

