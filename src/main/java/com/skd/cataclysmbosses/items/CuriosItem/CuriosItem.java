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
 *  top.theillusivec4.curios.api.common.slot.SlotTypePredicate
 */
package com.skd.cataclysmbosses.items.CuriosItem;

import com.skd.cataclysmbosses.items.CuriosItem.AttributeContainer;
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
import top.theillusivec4.curios.api.common.slot.SlotTypePredicate;

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
        CurioAttributeModifierEvent evt = new CurioAttributeModifierEvent(stack, slotContext, id);
        
        // Add attributes from withAttributes()
        if (slotContext.identifier().equals(this.attributeSlot) && this.attributes != null) {
            Multimap<Holder<Attribute>, AttributeModifier> attrMap = this.attributes.apply(slotContext.index());
            for (Map.Entry<Holder<Attribute>, AttributeModifier> entry : attrMap.entries()) {
                evt.addModifier(entry.getKey(), entry.getValue(), slotContext.identifier());
            }
        }
        
        // Add slot modifiers from withSlotModifier()
        if (!this.slotModifiers.isEmpty()) {
            for (Map.Entry<String, Integer> entry : this.slotModifiers.entrySet()) {
                String slotId = entry.getKey();
                int amount = entry.getValue();
                // Create a generic attribute modifier for slot modification
                // Note: In Curios 15.x, slot modifiers may use a different API
                // This adds a modifier with the item's ID as the modifier ID
                AttributeModifier modifier = new AttributeModifier(id.withSuffix("slot_" + slotId), amount, AttributeModifier.Operation.ADD_VALUE);
                // Use a placeholder attribute - in practice this should be a Curios-specific attribute
                // For now, we skip if we can't determine the correct attribute
                // evt.addModifier(attribute, modifier, slotId);
            }
        }
        
        NeoForge.EVENT_BUS.post((Event)evt);
        return evt.getModifiers();
    }

    public CuriosItem withAttributes(String slot, AttributeContainer ... attributes) {
        this.attributeSlot = slot;
        this.attributes = index -> {
            ImmutableMultimap.Builder builder = ImmutableMultimap.builder();
            for (AttributeContainer holder : attributes) {
                String name = String.format("%s_%s", this.attributeSlot, index);
                builder.put(holder.attribute(), holder.createModifier(name));
            }
            return builder.build();
        };
        return this;
    }

    public CuriosItem withSlotModifier(String slotToModify, int amount) {
        this.slotModifiers.put(slotToModify, amount);
        return this;
    }
}
