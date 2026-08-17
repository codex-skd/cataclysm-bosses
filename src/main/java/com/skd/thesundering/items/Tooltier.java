/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resources.Identifier
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.crafting.Ingredient
 *  net.minecraft.world.level.ItemLike
 *  net.neoforged.neoforge.common.SimpleTier
 */
package com.skd.thesundering.items;

import com.skd.thesundering.init.ModItems;
import java.util.Locale;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.SimpleTier;

public class Tooltier {
    public static final Tier ANCIENT_METAL = new SimpleTier(BlockTags.create((Identifier)Tooltier.prefix("needs_ancient_metal_tool")), 750, 8.0f, 2.0f, 25, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.ANCIENT_METAL_INGOT.get()}));
    public static final Tier BLACK_STEEL = new SimpleTier(BlockTags.create((Identifier)Tooltier.prefix("needs_black_steel_tool")), 750, 8.0f, 2.0f, 25, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.BLACK_STEEL_INGOT.get()}));
    public static final Tier MONSTROSITY = new SimpleTier(BlockTags.create((Identifier)Tooltier.prefix("needs_monstrosity_tool")), 2800, 9.0f, 4.0f, 25, () -> Ingredient.of((ItemLike[])new ItemLike[]{(ItemLike)ModItems.MONSTROUS_HORN.get()}));

    private static Identifier prefix(String name) {
        return Identifier.fromNamespaceAndPath((String)"cataclysm", (String)name.toLowerCase(Locale.ROOT));
    }
}

