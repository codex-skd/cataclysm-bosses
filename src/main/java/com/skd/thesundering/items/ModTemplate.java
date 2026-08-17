/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatFormatting
 *  net.minecraft.Util
 *  net.minecraft.network.chat.CommonComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Item$TooltipContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.TooltipFlag
 */
package com.skd.thesundering.items;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class ModTemplate
extends Item {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final String DESCRIPTION_ID = Util.makeDescriptionId((String)"item", (Identifier)Identifier.withDefaultNamespace((String)"smithing_template"));
    private static final Component INGREDIENTS_TITLE = Component.translatable((String)Util.makeDescriptionId((String)"item", (Identifier)Identifier.withDefaultNamespace((String)"smithing_template.ingredients"))).withStyle(TITLE_FORMAT);
    private static final Component APPLIES_TO_TITLE = Component.translatable((String)Util.makeDescriptionId((String)"item", (Identifier)Identifier.withDefaultNamespace((String)"smithing_template.applies_to"))).withStyle(TITLE_FORMAT);
    private static final Component IGNITIUM_UPGRADE = Component.translatable((String)"item.cataclysm.ignitium_upgrade.desc").withStyle(TITLE_FORMAT);
    private static final Component IGNITIUM_UPGRADE_APPLIES_TO = Component.translatable((String)"item.cataclysm.ignitium_upgrade.applies_to.desc").withStyle(DESCRIPTION_FORMAT);
    private static final Component IGNITIUM_UPGRADE_INGREDIENTS = Component.translatable((String)"item.cataclysm.ignitium_upgrade.ingredients.desc").withStyle(DESCRIPTION_FORMAT);
    private static final Component CURSIUM_UPGRADE = Component.translatable((String)"item.cataclysm.cursium_upgrade.desc").withStyle(TITLE_FORMAT);
    private static final Component CURSIUM_UPGRADE_APPLIES_TO = Component.translatable((String)"item.cataclysm.cursium_upgrade.applies_to.desc").withStyle(DESCRIPTION_FORMAT);
    private static final Component CURSIUM_UPGRADE_INGREDIENTS = Component.translatable((String)"item.cataclysm.cursium_upgrade.ingredients.desc").withStyle(DESCRIPTION_FORMAT);
    private static final Component IGNITIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable((String)"item.cataclysm.ignitium_upgrade.base_slot.desc");
    private static final Component IGNITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable((String)"item.cataclysm.ignitium_upgrade.additions_slot.desc");
    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace((String)"item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace((String)"item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace((String)"item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace((String)"item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace((String)"item/empty_slot_ingot");
    private final Component appliesTo;
    private final Component ingredients;
    private final Component upgradeDescription;
    private final Component baseSlotDescription;
    private final Component additionsSlotDescription;
    private final List<Identifier> baseSlotEmptyIcons;
    private final List<Identifier> additionalSlotEmptyIcons;

    public ModTemplate(Component p_266834_, Component p_267043_, Component p_267048_, Component p_267278_, Component p_267090_, List<Identifier> p_266755_, List<Identifier> p_267060_) {
        super(new Item.Properties().fireResistant());
        this.appliesTo = p_266834_;
        this.ingredients = p_267043_;
        this.upgradeDescription = p_267048_;
        this.baseSlotDescription = p_267278_;
        this.additionsSlotDescription = p_267090_;
        this.baseSlotEmptyIcons = p_266755_;
        this.additionalSlotEmptyIcons = p_267060_;
    }

    public static ModTemplate createignitiumUpgradeTemplate() {
        return new ModTemplate(IGNITIUM_UPGRADE_APPLIES_TO, IGNITIUM_UPGRADE_INGREDIENTS, IGNITIUM_UPGRADE, IGNITIUM_UPGRADE_BASE_SLOT_DESCRIPTION, IGNITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, ModTemplate.createignitiumUpgradeIconList(), ModTemplate.createignitiumUpgradeMaterialList());
    }

    public static ModTemplate createcursiumUpgradeTemplate() {
        return new ModTemplate(CURSIUM_UPGRADE_APPLIES_TO, CURSIUM_UPGRADE_INGREDIENTS, CURSIUM_UPGRADE, IGNITIUM_UPGRADE_BASE_SLOT_DESCRIPTION, IGNITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, ModTemplate.createignitiumUpgradeIconList(), ModTemplate.createignitiumUpgradeMaterialList());
    }

    private static List<Identifier> createignitiumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<Identifier> createignitiumUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    public void appendHoverText(ItemStack p_267313_, Item.TooltipContext p_339591_, List<Component> p_266820_, TooltipFlag p_266857_) {
        super.appendHoverText(p_267313_, p_339591_, p_266820_, p_266857_);
        p_266820_.add(this.upgradeDescription);
        p_266820_.add(CommonComponents.EMPTY);
        p_266820_.add(APPLIES_TO_TITLE);
        p_266820_.add((Component)CommonComponents.space().append(this.appliesTo));
        p_266820_.add(INGREDIENTS_TITLE);
        p_266820_.add((Component)CommonComponents.space().append(this.ingredients));
    }

    public Component getBaseSlotDescription() {
        return this.baseSlotDescription;
    }

    public Component getAdditionSlotDescription() {
        return this.additionsSlotDescription;
    }

    public List<Identifier> getBaseSlotEmptyIcons() {
        return this.baseSlotEmptyIcons;
    }

    public List<Identifier> getAdditionalSlotEmptyIcons() {
        return this.additionalSlotEmptyIcons;
    }

    public String getDescriptionId() {
        return DESCRIPTION_ID;
    }
}

