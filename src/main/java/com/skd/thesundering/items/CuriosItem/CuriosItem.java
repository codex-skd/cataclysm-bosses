/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMultimap
 *  com.google.common.collect.ImmutableMultimap$Builder
 *  com.google.common.collect.LinkedHashMultimap
 *  com.google.common.collect.Multimap
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.bus.api.Event
 *  net.neoforged.neoforge.common.NeoForge
 *  top.theillusivec4.curios.api.CuriosApi
 *  top.theillusivec4.curios.api.SlotContext
 *  top.theillusivec4.curios.api.event.CurioAttributeModifierEvent
 *  top.theillusivec4.curios.api.type.capability.ICurioItem
 */
package com.skd.thesundering.items.CuriosItem;

import com.skd.thesundering.items.CuriosItem.AttributeContainer;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.NeoForge;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CuriosItem
extends Item
implements ICurioItem {
    String attributeSlot = "";
    Function<Integer, Multimap<Holder<Attribute>, AttributeModifier>> attributes = null;
    Map<String, Integer> slotModifiers = new HashMap<String, Integer>();

    public CuriosItem(Item.Properties properties) {
        super(properties);
    }

    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, Identifier id, ItemStack stack) {
        LinkedHashMultimap modifiers = LinkedHashMultimap.create();
        if (slotContext.identifier().equals(this.attributeSlot) && this.attributes != null) {
            modifiers.putAll(this.attributes.apply(slotContext.index()));
        }
        if (!this.slotModifiers.isEmpty()) {
            this.slotModifiers.forEach((arg_0, arg_1) -> CuriosItem.lambda$getAttributeModifiers$0((Multimap)modifiers, id, arg_0, arg_1));
        }
        CurioAttributeModifierEvent evt = new CurioAttributeModifierEvent(stack, slotContext, id, (Multimap)modifiers);
        NeoForge.EVENT_BUS.post((Event)evt);
        return modifiers;
    }

    public CuriosItem withAttributes(String slot, AttributeContainer ... attributes) {
        this.attributeSlot = slot;
        this.attributes = index -> {
            ImmutableMultimap.Builder builder = ImmutableMultimap.builder();
            for (AttributeContainer holder : attributes) {
                String name = String.format("%s_%s", this.attributeSlot, index);
                builder.put(holder.attribute(), (Object)holder.createModifier(name));
            }
            return builder.build();
        };
        return this;
    }

    public CuriosItem withSlotModifier(String slotToModify, int amount) {
        this.slotModifiers.put(slotToModify, amount);
        return this;
    }

    private static /* synthetic */ void lambda$getAttributeModifiers$0(Multimap modifiers, Identifier id, String slotId, Integer amount) {
        CuriosApi.addSlotModifier((Multimap)modifiers, (String)slotId, (Identifier)id, (double)amount.intValue(), (AttributeModifier.Operation)AttributeModifier.Operation.ADD_VALUE);
    }
}

