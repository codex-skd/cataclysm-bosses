/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.EquipmentSlotGroup
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.component.ItemAttributeModifiers
 *  net.minecraft.world.item.component.ItemAttributeModifiers$Builder
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.items.CuriosItem.AttributeContainer;
import com.google.common.base.Suppliers;
import java.util.function.Supplier;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class Cataclysm_Armor
extends ArmorItem {
    private final Supplier<ItemAttributeModifiers> catdefaultModifiers = Suppliers.memoize(() -> {
        int i = ((ArmorMaterial)this.material.value()).getDefense(this.type);
        float f = ((ArmorMaterial)this.material.value()).toughness();
        ItemAttributeModifiers.Builder itemattributemodifiers$builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot((EquipmentSlot)this.type.getSlot());
        Identifier resourcelocation = Identifier.withDefaultNamespace((String)("armor." + this.type.getName()));
        itemattributemodifiers$builder.add(Attributes.ARMOR, new AttributeModifier(resourcelocation, (double)i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup);
        itemattributemodifiers$builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourcelocation, (double)f, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup);
        float f1 = ((ArmorMaterial)this.material.value()).knockbackResistance();
        if (f1 > 0.0f) {
            itemattributemodifiers$builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resourcelocation, (double)f1, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup);
        }
        for (AttributeContainer holder : attributes) {
            itemattributemodifiers$builder.add(holder.attribute(), holder.createModifier(pType.getSlot().getName()), equipmentslotgroup);
        }
        return itemattributemodifiers$builder.build();
    });

    public Cataclysm_Armor(Holder<ArmorMaterial> pMaterial, ArmorItem.Type pType, Item.Properties pProperties, AttributeContainer ... attributes) {
        super(pMaterial, pType, pProperties);
    }

    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.catdefaultModifiers.get();
    }

    public static ItemAttributeModifiers createArmorAttributes(Holder<ArmorMaterial> material, float configDefenseMultiplier, float configToughness, float configKnockback, ArmorItem.Type type, AttributeContainer ... attributes) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot((EquipmentSlot)type.getSlot());
        Identifier resLoc = Identifier.withDefaultNamespace((String)("armor." + type.getName()));
        int finalDefense = Math.round(configDefenseMultiplier * (float)((ArmorMaterial)material.value()).getDefense(type));
        if (finalDefense > 0) {
            builder.add(Attributes.ARMOR, new AttributeModifier(resLoc, (double)finalDefense, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if (configToughness > 0.0f) {
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resLoc, (double)configToughness, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if (configKnockback > 0.0f) {
            builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resLoc, (double)configKnockback, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        for (AttributeContainer holder : attributes) {
            AttributeModifier modifier = holder.createModifier(type.getSlot().getName());
            if (!(Math.abs(modifier.amount()) > 1.0E-5)) continue;
            builder.add(holder.attribute(), modifier, slotGroup);
        }
        return builder.build();
    }

    public static ItemAttributeModifiers createAttributes(Holder<ArmorMaterial> material, ArmorItem.Type type, AttributeContainer ... attributes) {
        float knockback;
        float toughness;
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot((EquipmentSlot)type.getSlot());
        Identifier id = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("armor." + type.getName()));
        int defense = ((ArmorMaterial)material.value()).getDefense(type);
        if (defense > 0) {
            builder.add(Attributes.ARMOR, new AttributeModifier(id, (double)defense, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if ((toughness = ((ArmorMaterial)material.value()).toughness()) > 0.0f) {
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(id, (double)toughness, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if ((knockback = ((ArmorMaterial)material.value()).knockbackResistance()) > 0.0f) {
            builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(id, (double)knockback, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        for (AttributeContainer holder : attributes) {
            AttributeModifier modifier = holder.createModifier(type.getSlot().getName());
            if (!(Math.abs(modifier.amount()) > 1.0E-5)) continue;
            builder.add(holder.attribute(), modifier, slotGroup);
        }
        return builder.build();
    }
}

