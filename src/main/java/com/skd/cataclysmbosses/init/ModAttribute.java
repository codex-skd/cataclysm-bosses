/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.RangedAttribute
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.fml.common.EventBusSubscriber$Bus
 *  net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.cataclysmbosses.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid="the_sundering", bus=EventBusSubscriber.Bus.MOD)
public class ModAttribute {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create((ResourceKey)Registries.ATTRIBUTE, (String)"cataclysm");
    public static final DeferredHolder<Attribute, Attribute> ADDITIONAL_CRITICAL_DAMAGE = ATTRIBUTES.register("additional_critical_damage", () -> new RangedAttribute("attribute.cataclysm.additional_critical_damage", 0.0, -512.0, 512.0).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> NATURE_HEAL = ATTRIBUTES.register("nature_heal", () -> new RangedAttribute("attribute.cataclysm.nature_heal", 0.0, -256.0, 1024.0).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> EAT_SPEED = ATTRIBUTES.register("eat_speed", () -> new RangedAttribute("attribute.cataclysm.eat_speed", 0.0, -100.0, 100.0).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> CHARGE_TIME = ATTRIBUTES.register("charge_time", () -> new RangedAttribute("attribute.cataclysm.charge_time", 0.0, -100.0, 512.0).setSyncable(true));

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> e.add(entity, (Holder)attribute)));
    }
}

