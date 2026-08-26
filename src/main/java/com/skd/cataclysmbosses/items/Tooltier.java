package com.skd.cataclysmbosses.items;

import java.util.Locale;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;

public class Tooltier {
    public static final ToolMaterial ANCIENT_METAL = new ToolMaterial(
        BlockTags.create(Tooltier.prefix("needs_ancient_metal_tool")), 750, 8.0F, 2.0F, 25,
        TagKey.create(Registries.ITEM, Tooltier.prefix("repairs_ancient_metal_tools")));
    public static final ToolMaterial BLACK_STEEL = new ToolMaterial(
        BlockTags.create(Tooltier.prefix("needs_black_steel_tool")), 750, 8.0F, 2.0F, 25,
        TagKey.create(Registries.ITEM, Tooltier.prefix("repairs_black_steel_tools")));
    public static final ToolMaterial MONSTROSITY = new ToolMaterial(
        BlockTags.create(Tooltier.prefix("needs_monstrosity_tool")), 2800, 9.0F, 4.0F, 25,
        TagKey.create(Registries.ITEM, Tooltier.prefix("repairs_monstrosity_tools")));

    private static Identifier prefix(String name) {
        return Identifier.fromNamespaceAndPath("cataclysm", name.toLowerCase(Locale.ROOT));
    }
}
