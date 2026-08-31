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
        // TODO 26.2: CurioAttributeModifierEvent ctor changed in Curios API for NeoForge 26.2.
        // Old ctor: new CurioAttributeModifierEvent(stack, slotContext, id)
        // New ctor expects (ItemStack, CurioAttributeModifiers). Stubbed to return direct modifiers.
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slotContext.identifier().equals(this.attributeSlot) && this.attributes != null) {
            Multimap<Holder<Attribute>, AttributeModifier> attrMap = this.attributes.apply(slotContext.index());
            builder.putAll(attrMap);
        }
        return builder.build();
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
