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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class Cataclysm_Armor
extends Item {
    protected final Holder<ArmorMaterial> material;
    protected final ArmorType type;
    private final Supplier<ItemAttributeModifiers> catdefaultModifiers = Suppliers.memoize(() -> {
        int i = this.material.value().defense().getOrDefault(this.type, 0);
        float f = this.material.value().toughness();
        ItemAttributeModifiers.Builder itemattributemodifiers$builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(this.type.getSlot());
        Identifier resourcelocation = Identifier.withDefaultNamespace("armor." + this.type.getName());
        itemattributemodifiers$builder.add(Attributes.ARMOR, new AttributeModifier(resourcelocation, i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup);
        itemattributemodifiers$builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourcelocation, f, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup);
        float f1 = this.material.value().knockbackResistance();
        if (f1 > 0.0f) {
            itemattributemodifiers$builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resourcelocation, f1, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup);
        }
        for (AttributeContainer holder : attributes) {
            itemattributemodifiers$builder.add(holder.attribute(), holder.createModifier(this.type.getSlot().getName()), equipmentslotgroup);
        }
        return itemattributemodifiers$builder.build();
    });
    private final AttributeContainer[] attributes;

    public Cataclysm_Armor(Holder<ArmorMaterial> pMaterial, ArmorType pType, Item.Properties pProperties, AttributeContainer ... pAttributes) {
        super(pProperties);
        this.material = pMaterial;
        this.type = pType;
        this.attributes = pAttributes;
    }

    public Holder<ArmorMaterial> getMaterial() {
        return this.material;
    }

    public ArmorType getType() {
        return this.type;
    }

    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.catdefaultModifiers.get();
    }

    public static ItemAttributeModifiers createArmorAttributes(Holder<ArmorMaterial> material, float configDefenseMultiplier, float configToughness, float configKnockback, ArmorType type, AttributeContainer ... attributes) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
        Identifier resLoc = Identifier.withDefaultNamespace("armor." + type.getName());
        int finalDefense = Math.round(configDefenseMultiplier * (float)material.value().defense().getOrDefault(type, 0));
        if (finalDefense > 0) {
            builder.add(Attributes.ARMOR, new AttributeModifier(resLoc, finalDefense, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if (configToughness > 0.0f) {
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resLoc, configToughness, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if (configKnockback > 0.0f) {
            builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resLoc, configKnockback, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        for (AttributeContainer holder : attributes) {
            AttributeModifier modifier = holder.createModifier(type.getSlot().getName());
            if (!(Math.abs(modifier.amount()) > 1.0E-5)) continue;
            builder.add(holder.attribute(), modifier, slotGroup);
        }
        return builder.build();
    }

    public static ItemAttributeModifiers createAttributes(Holder<ArmorMaterial> material, ArmorType type, AttributeContainer ... attributes) {
        float knockback;
        float toughness;
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
        Identifier id = Identifier.fromNamespaceAndPath("cataclysm", "armor." + type.getName());
        int defense = material.value().defense().getOrDefault(type, 0);
        if (defense > 0) {
            builder.add(Attributes.ARMOR, new AttributeModifier(id, defense, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if ((toughness = material.value().toughness()) > 0.0f) {
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(id, toughness, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        if ((knockback = material.value().knockbackResistance()) > 0.0f) {
            builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(id, knockback, AttributeModifier.Operation.ADD_VALUE), slotGroup);
        }
        for (AttributeContainer holder : attributes) {
            AttributeModifier modifier = holder.createModifier(type.getSlot().getName());
            if (!(Math.abs(modifier.amount()) > 1.0E-5)) continue;
            builder.add(holder.attribute(), modifier, slotGroup);
        }
        return builder.build();
    }
}
