/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.event.StandOnFluidEvent
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.SimpleParticleType
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.Identifier
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.tags.DamageTypeTags
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.Fluids
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent
 *  net.neoforged.neoforge.event.entity.living.LivingDamageEvent$Post
 *  net.neoforged.neoforge.event.entity.living.LivingDeathEvent
 *  net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent
 *  net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent$Start
 *  net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent$Stop
 *  net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent$Tick
 *  net.neoforged.neoforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.neoforged.neoforge.event.entity.living.LivingFallEvent
 *  net.neoforged.neoforge.event.entity.living.LivingHealEvent
 *  net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent
 *  net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent
 *  net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent
 *  net.neoforged.neoforge.event.entity.living.MobEffectEvent$Remove
 *  net.neoforged.neoforge.event.entity.player.AdvancementEvent$AdvancementEarnEvent
 *  net.neoforged.neoforge.event.entity.player.AttackEntityEvent
 *  net.neoforged.neoforge.event.entity.player.CriticalHitEvent
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$EntityInteract
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$LeftClickBlock
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$LeftClickEmpty
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$RightClickBlock
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$RightClickEmpty
 *  net.neoforged.neoforge.event.entity.player.PlayerInteractEvent$RightClickItem
 *  net.neoforged.neoforge.event.level.BlockEvent$BreakEvent
 *  net.neoforged.neoforge.event.level.BlockEvent$EntityPlaceEvent
 *  net.neoforged.neoforge.event.tick.PlayerTickEvent$Post
 *  net.neoforged.neoforge.network.PacketDistributor
 *  top.theillusivec4.curios.api.CuriosApi
 */
package com.skd.cataclysmbosses.event;

import com.skd.cataclysmbosses.Attachment.ChargeAttachment;
import com.skd.cataclysmbosses.Attachment.ParryAttachment;
import com.skd.cataclysmbosses.Attachment.RenderRushAttachment;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.skd.cataclysmbosses.init.ModAttribute;
import com.skd.cataclysmbosses.init.ModDataAttachments;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.init.ModParticle;
import com.skd.cataclysmbosses.init.ModSounds;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.items.ILeftClick;
import com.skd.cataclysmbosses.message.MessageSwingArm;
import com.skd.cataclysmbosses.util.CMDamageTypes;
import com.skd.nautilusapi.server.event.StandOnFluidEvent;
import java.util.List;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.AdvancementEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(modid="the_sundering")
public class ServerEventHandler {
    @SubscribeEvent
    public static void onLivingUpdateEvent(PlayerTickEvent.Post event) {
        ((ChargeAttachment)event.getEntity().getData(ModDataAttachments.CHARGE_ATTACHMENT)).tick((LivingEntity)event.getEntity());
        ((RenderRushAttachment)event.getEntity().getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT)).tick((LivingEntity)event.getEntity());
        if (((Boolean)event.getEntity().getData(ModDataAttachments.HOOK_FALLING)).booleanValue()) {
            // setIgnoreFallDamageFromCurrentImpulse now takes the impact position directly
            // (was a separate manual field assignment before) -- same net effect.
            event.getEntity().setIgnoreFallDamageFromCurrentImpulse(true, event.getEntity().position());
        }
    }

    @SubscribeEvent
    public static void StandOnFluidEventEvent(StandOnFluidEvent event) {
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.IGNITIUM_BOOTS.get() && !event.getEntity().isShiftKeyDown() && (event.getFluidState().is((Fluid)Fluids.LAVA) || event.getFluidState().is((Fluid)Fluids.FLOWING_LAVA))) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void BlockHeal(LivingHealEvent event) {
        float heal = event.getAmount();
        if (event.getEntity().hasEffect(ModEffect.EFFECTABYSSAL_FEAR)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getEffect(ModEffect.EFFECTSTUN) != null) {
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.0, entity.getDeltaMovement().z());
        }
    }

    @SubscribeEvent
    public static void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        if (player.hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
        LivingEntity living = event.getEntity();
        ItemStack itemStack = event.getItem();
        if (living.hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
        if (living.hasEffect(ModEffect.EFFECTGHOST_FORM)) {
            event.setCanceled(true);
        }
        if (itemStack.has(DataComponents.FOOD)) {
            int originalDuration = event.getDuration();
            float EatSpeed = (float)living.getAttributeValue(ModAttribute.EAT_SPEED) / 100.0f;
            int newDuration = (int)((double)originalDuration / (1.0 + (double)EatSpeed));
            event.setDuration(Math.max(1, newDuration));
        }
    }

    @SubscribeEvent
    public static void onUseItem(LivingEntityUseItemEvent event) {
        LivingEntity living = event.getEntity();
        if (living.hasEffect(ModEffect.EFFECTSTUN)) {
            event.setDuration(0);
        }
        if (living.hasEffect(ModEffect.EFFECTGHOST_FORM)) {
            event.setDuration(0);
        }
    }

    @SubscribeEvent
    public static void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
        LivingEntity living;
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity && (living = (LivingEntity)entity).hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void KnockbackEvent(LivingKnockBackEvent event) {
        Royal_Draugr_Entity royalDraugr;
        LivingEntity living = event.getEntity();
        if (living instanceof Royal_Draugr_Entity && (royalDraugr = (Royal_Draugr_Entity)living).isDraugrBlocking()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onBreakBlock(BreakBlockEvent event) {
        if (event.getPlayer().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract1(PlayerInteractEvent.RightClickEmpty event) {
    }

    @SubscribeEvent
    public static void onPlayerInteract2(PlayerInteractEvent.LeftClickEmpty event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            // empty if block
        }
        boolean flag = false;
        ItemStack leftItem = event.getEntity().getOffhandItem();
        ItemStack rightItem = event.getEntity().getMainHandItem();
        if (!event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            if (leftItem.getItem() instanceof ILeftClick) {
                ((ILeftClick)leftItem.getItem()).onLeftClick(leftItem, (LivingEntity)event.getEntity());
                flag = true;
            }
            if (rightItem.getItem() instanceof ILeftClick) {
                ((ILeftClick)rightItem.getItem()).onLeftClick(rightItem, (LivingEntity)event.getEntity());
                flag = true;
            }
            if (event.getLevel().isClientSide() && flag) {
                ClientPacketDistributor.sendToServer((CustomPacketPayload)new MessageSwingArm(InteractionHand.MAIN_HAND), new CustomPacketPayload[0]);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract3(PlayerInteractEvent.EntityInteract event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract4(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract5(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingSetTargetEvent(LivingChangeTargetEvent event) {
        Mob mob;
        LivingEntity livingEntity;
        if (event.getNewAboutToBeSetTarget() != null && (livingEntity = event.getEntity()) instanceof Mob && (mob = (Mob)livingEntity).getType().builtInRegistryHolder().is(ModTag.LAVA_MONSTER) && event.getEntity().getLastHurtByMob() != event.getNewAboutToBeSetTarget() && event.getNewAboutToBeSetTarget().getItemBySlot(EquipmentSlot.HEAD).is((Item)ModItems.IGNITIUM_HELMET.get())) {
            event.setCanceled(true);
            return;
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Post event) {
        Entity attacker;
        Entity entity;
        LivingEntity entity2 = event.getEntity();
        DamageSource source = event.getSource();
        if (entity2.getHealth() <= event.getHealthDamage() && entity2.hasEffect(ModEffect.EFFECTSTUN)) {
            entity2.removeEffect(ModEffect.EFFECTSTUN);
        }
        if (source.is(CMDamageTypes.DRACONIC_WOUND) && entity2.hasEffect(MobEffects.ABSORPTION)) {
            entity2.removeEffect(MobEffects.ABSORPTION);
        }
        // TODO(Curios): CuriosApi is not on the compile classpath yet -- deferred per
        // FASE1_PLAN_CATACLYSM.md until Curios is wired into build.gradle (batches 4-5 area).
        // Do not attempt to fix this block until then.
        if ((entity = event.getSource().getDirectEntity()) instanceof LivingEntity) {
            LivingEntity living = (LivingEntity)entity;
            List slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is((Item)ModItems.BLAZING_GRIPS.get()));
            if (!slot.isEmpty() && event.getEntity().getRandom().nextFloat() < 0.15f * (float)slot.size()) {
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 60, 0);
                entity2.addEffect(effectinstance);
            }
        }
        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getSource() != null && event.getSource().getEntity() != null && event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.IGNITIUM_LEGGINGS.get() && (attacker = event.getSource().getEntity()) instanceof LivingEntity && attacker != event.getEntity() && event.getEntity().getRandom().nextFloat() < 0.5f) {
            MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, 0, false, false, true);
            ((LivingEntity)attacker).addEffect(effectinstance);
            if (!attacker.isOnFire()) {
                attacker.igniteForSeconds(5.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onShieldDamage(LivingShieldBlockEvent event) {
        MobEffectInstance effectinstance;
        LivingEntity livingEntity;
        DamageSource source = event.getDamageSource();
        LivingEntity entity = event.getEntity();
        Item item = entity.getUseItem().getItem();
        Entity directEntity = source.getDirectEntity();
        if (source.is(CMDamageTypes.MALEDICTIO_SAGITTA)) {
            event.setShieldDamage(0);
        }
        ParryAttachment charge = (ParryAttachment)entity.getData(ModDataAttachments.PARRY_ATTACHMENT);
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getBlocked() && charge.getParryFrame() < 13 && directEntity instanceof LivingEntity) {
            livingEntity = (LivingEntity)directEntity;
            livingEntity.igniteForSeconds(3.0f);
            livingEntity.playSound(SoundEvents.ANVIL_LAND, 0.8f, 1.3f);
            effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, 0);
            // knockback now requires a DamageSource and a knockback-force float; this call has
            // no associated damage, so it reuses the shield's own damage source with 0 force.
            livingEntity.knockback(0.5, entity.getX() - livingEntity.getX(), entity.getZ() - livingEntity.getZ(), source, 0.0f);
            livingEntity.addEffect(effectinstance);
        }
        if (item == ModItems.AZURE_SEA_SHIELD.get() && event.getBlocked() && charge.getParryFrame() < 10) {
            event.setShieldDamage(0);
            if (directEntity instanceof LivingEntity) {
                livingEntity = (LivingEntity)directEntity;
                livingEntity.playSound((SoundEvent)ModSounds.PARRY.get(), 0.4f, 1.0f);
                entity.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 40, 1));
                effectinstance = new MobEffectInstance(MobEffects.SLOWNESS, 120, 1);
                livingEntity.knockback(0.5, entity.getX() - livingEntity.getX(), entity.getZ() - livingEntity.getZ(), source, 0.0f);
                livingEntity.addEffect(effectinstance);
            }
        }
    }

    @SubscribeEvent
    public static void DeathEvent(LivingDeathEvent event) {
        DamageSource source = event.getSource();
        if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && ServerEventHandler.tryCursiumPlateRebirth(event.getEntity())) {
            event.setCanceled(true);
        }
    }

    private static boolean tryCursiumPlateRebirth(LivingEntity living) {
        ItemStack chestplate = living.getItemBySlot(EquipmentSlot.CHEST);
        Level level = living.level();
        if (level instanceof ServerLevel) {
            ServerLevel serverLevel = (ServerLevel)level;
            if (chestplate.getItem() == ModItems.CURSIUM_CHESTPLATE.get() && !living.hasEffect(ModEffect.EFFECTGHOST_SICKNESS) && !living.hasEffect(ModEffect.EFFECTGHOST_FORM)) {
                living.setHealth(5.0f);
                serverLevel.playSound(null, living.getX(), living.getY(), living.getZ(), SoundEvents.TOTEM_USE, living.getSoundSource(), 1.25f, 1.0f);
                living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
                living.addEffect(new MobEffectInstance(ModEffect.EFFECTGHOST_FORM, 100, 0, false, true, true));
                double d0 = living.getX();
                double d1 = living.getY() + 3.0;
                double d2 = living.getZ();
                serverLevel.sendParticles((ParticleOptions)((SimpleParticleType)ModParticle.CURSED_ALGIZ.get()), d0, d1, d2, 1, 0.0, 0.0, 0.0, 0.0);
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void onLivingAttack(LivingIncomingDamageEvent event) {
        MobEffectInstance effectinstance1;
        DamageSource source = event.getSource();
        float damage = event.getAmount();
        if (source.is(DamageTypeTags.IS_LIGHTNING) && event.getEntity().hasEffect(ModEffect.EFFECTWETNESS) && (effectinstance1 = event.getEntity().getEffect(ModEffect.EFFECTWETNESS)) != null) {
            float i = (float)(effectinstance1.getAmplifier() + 1) * 0.2f;
            float f = damage + damage * i;
            damage = Math.min(Float.MAX_VALUE, f);
            event.setAmount(damage);
        }
        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM) && !event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            event.setCanceled(true);
        }
        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.CURSIUM_LEGGINGS.get()) {
            if (event.getSource().is(DamageTypeTags.IS_PROJECTILE)) {
                if (event.getEntity().getRandom().nextFloat() < 0.15f) {
                    event.setCanceled(true);
                }
            } else if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY) && event.getEntity().getRandom().nextFloat() < 0.08f) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onCriticalAttack(CriticalHitEvent event) {
        AttributeInstance attackDamageAttr;
        Entity entity;
        Player player = event.getEntity();
        ItemStack weapon = player.getMainHandItem();
        if (!weapon.isEmpty() && (entity = event.getTarget()) instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (weapon.getItem() == ModItems.THE_IMMOLATOR.get() && livingEntity.hasEffect(ModEffect.EFFECTBLAZING_BRAND)) {
                event.setCriticalHit(true);
            }
            if ((weapon.getItem() == ModItems.THE_ANNIHILATOR.get() || weapon.getItem() == ModItems.CERAUNUS.get() || weapon.getItem() == ModItems.THE_IMMOLATOR.get()) && event.isCriticalHit()) {
                livingEntity.playSound((SoundEvent)ModSounds.PARRY.get(), 0.5f, 1.1f);
            }
        }
        if ((attackDamageAttr = player.getAttribute(ModAttribute.ADDITIONAL_CRITICAL_DAMAGE)) != null) {
            double extraCritPercent = attackDamageAttr.getValue();
            float vanillaCrit = event.getDamageMultiplier();
            float finalMultiplier = (float)((double)vanillaCrit + extraCritPercent / 100.0);
            if (finalMultiplier < 1.0f) {
                finalMultiplier = 1.0f;
            }
            event.setDamageMultiplier(finalMultiplier);
        }
    }

    @SubscribeEvent
    public static void preventEffectRemoval(MobEffectEvent.Remove event) {
        MobEffectInstance effectInstance = event.getEffectInstance();
        if (effectInstance != null && effectInstance.getEffect() == ModEffect.EFFECTGHOST_SICKNESS.get()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        Player player;
        LivingEntity livingEntity;
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
            event.setDistance(event.getDistance() * 0.3f);
        }
        if ((livingEntity = event.getEntity()) instanceof Player && ((Boolean)(player = (Player)livingEntity).getData(ModDataAttachments.HOOK_FALLING)).booleanValue()) {
            event.setDistance(0.0f);
            event.setCanceled(false);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onStartUsing(LivingEntityUseItemEvent.Start event) {
        Player player;
        LivingEntity livingEntity;
        Item item = event.getItem().getItem();
        if ((item == ModItems.AZURE_SEA_SHIELD.get() || item == ModItems.BULWARK_OF_THE_FLAME.get()) && (livingEntity = event.getEntity()) instanceof Player && !(player = (Player)livingEntity).getCooldowns().isOnCooldown(event.getItem())) {
            ParryAttachment charge = (ParryAttachment)player.getData(ModDataAttachments.PARRY_ATTACHMENT);
            charge.setParryFrame(0);
        }
    }

    @SubscribeEvent
    public static void onUseTick(LivingEntityUseItemEvent.Tick event) {
        LivingEntity livingEntity;
        Item item = event.getItem().getItem();
        if ((item == ModItems.AZURE_SEA_SHIELD.get() || item == ModItems.BULWARK_OF_THE_FLAME.get()) && (livingEntity = event.getEntity()) instanceof Player) {
            Player player = (Player)livingEntity;
            ParryAttachment charge = (ParryAttachment)player.getData(ModDataAttachments.PARRY_ATTACHMENT);
            charge.setParryFrame(charge.getParryFrame() + 1);
        }
    }

    @SubscribeEvent
    public static void onStopUsing(LivingEntityUseItemEvent.Stop event) {
        LivingEntity livingEntity;
        Item item = event.getItem().getItem();
        if ((item == ModItems.AZURE_SEA_SHIELD.get() || item == ModItems.BULWARK_OF_THE_FLAME.get()) && (livingEntity = event.getEntity()) instanceof Player) {
            Player player = (Player)livingEntity;
            ParryAttachment charge = (ParryAttachment)player.getData(ModDataAttachments.PARRY_ATTACHMENT);
            charge.setParryFrame(0);
        }
    }

    @SubscribeEvent
    public static void onAdvancementEarned(AdvancementEvent.AdvancementEarnEvent event) {
        Player player = event.getEntity();
        Identifier advId = event.getAdvancement().id();
        if (advId.equals((Object)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"kill_all_bosses"))) {
            ItemStack reward = new ItemStack((ItemLike)ModItems.MUSIC_DISC_THE_CATACLYSM_FARER.get());
            if (!player.getInventory().add(reward)) {
                player.drop(reward, false);
            }
            // playNotifySound(SoundEvent, SoundSource, float, float) is gone; Entity only
            // exposes the 3-arg playSound(SoundEvent, float, float) overload now.
            player.playSound((SoundEvent)ModSounds.THE_CATACLYSM_FARER.get(), 1.0f, 1.0f);
        }
    }
}

