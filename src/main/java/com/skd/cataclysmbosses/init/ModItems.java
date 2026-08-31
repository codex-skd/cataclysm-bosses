/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.component.DataComponents
 *  net.minecraft.core.dispenser.BlockSource
 *  net.minecraft.core.dispenser.DefaultDispenseItemBehavior
 *  net.minecraft.core.dispenser.DispenseItemBehavior
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.food.FoodProperties$Builder
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.ArmorMaterials
 *  net.minecraft.world.item.AxeItem
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.DispensibleContainerItem
 *  net.minecraft.world.item.HoeItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.PickaxeItem
 *  net.minecraft.world.item.Rarity
 *  net.minecraft.world.item.ShovelItem
 *  net.minecraft.world.item.SpawnEggItem
 *  net.minecraft.world.item.SwordItem
 *  net.minecraft.world.item.Tier
 *  net.minecraft.world.item.component.Unbreakable
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.DispenserBlock
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.Fluids
 *  net.neoforged.neoforge.event.ModifyDefaultComponentsEvent
 *  net.neoforged.neoforge.registries.DeferredItem
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.DeferredRegister$Items
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.items.Khopesh;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.client.CustomRarity.CMRarity;
import com.skd.cataclysmbosses.config.CMCommonConfig;
import com.skd.cataclysmbosses.config.ConfigHolder;
import com.skd.cataclysmbosses.init.ModAttribute;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModTag;
import com.skd.cataclysmbosses.items.Ancient_Spear;
import com.skd.cataclysmbosses.items.Armortier;
import com.skd.cataclysmbosses.items.Astrape;
import com.skd.cataclysmbosses.items.Athame;
import com.skd.cataclysmbosses.items.Azure_sea_Shield;
import com.skd.cataclysmbosses.items.Black_Steel_Targe;
import com.skd.cataclysmbosses.items.Blessed_Amethyst_Crab_Meat;
import com.skd.cataclysmbosses.items.Bloom_Stone_Pauldrons;
import com.skd.cataclysmbosses.items.Bone_Reptile_Armor;
import com.skd.cataclysmbosses.items.Brontes;
import com.skd.cataclysmbosses.items.Bulwark_of_the_flame;
import com.skd.cataclysmbosses.items.CataclysmSkullItem;
import com.skd.cataclysmbosses.items.Cataclysm_Armor;
import com.skd.cataclysmbosses.items.Cataclysm_Weapon;
import com.skd.cataclysmbosses.items.Ceraunus;
import com.skd.cataclysmbosses.items.Coral_Bardiche;
import com.skd.cataclysmbosses.items.Coral_Spear;
import com.skd.cataclysmbosses.items.CuriosItem.AttributeContainer;
import com.skd.cataclysmbosses.items.CuriosItem.Blazing_Grips;
import com.skd.cataclysmbosses.items.CuriosItem.Chitin_Claw;
import com.skd.cataclysmbosses.items.CuriosItem.CuriosItem;
import com.skd.cataclysmbosses.items.CuriosItem.Sticky_Gloves;
import com.skd.cataclysmbosses.items.CuriosItem.Sturdy_Boots;
import com.skd.cataclysmbosses.items.CuriosItem.Unbreakable_Skull;
import com.skd.cataclysmbosses.items.Cursed_bow;
import com.skd.cataclysmbosses.items.Cursium_Armor;
import com.skd.cataclysmbosses.items.Cursium_ChestPlate;
import com.skd.cataclysmbosses.items.DungeonEyeItem;
import com.skd.cataclysmbosses.items.Gauntlet_of_Bulwark;
import com.skd.cataclysmbosses.items.Gauntlet_of_Guard;
import com.skd.cataclysmbosses.items.Gauntlet_of_Maelstrom;
import com.skd.cataclysmbosses.items.Ignitium_Armor;
import com.skd.cataclysmbosses.items.Ignitium_Elytra_ChestPlate;
import com.skd.cataclysmbosses.items.Infernal_forge;
import com.skd.cataclysmbosses.items.ItemInventoryOnly;
import com.skd.cataclysmbosses.items.Laser_Gatling;
import com.skd.cataclysmbosses.items.Meat_Shredder;
import com.skd.cataclysmbosses.items.ModFishBucket;
import com.skd.cataclysmbosses.items.ModJukeboxSongs;
import com.skd.cataclysmbosses.items.ModTemplate;
import com.skd.cataclysmbosses.items.ModernRemantBucket;
import com.skd.cataclysmbosses.items.Monstrous_Helm;
import com.skd.cataclysmbosses.items.Necklace_Of_The_Desert;
import com.skd.cataclysmbosses.items.Netherite_Effigy;
import com.skd.cataclysmbosses.items.Remnant_Skull;
import com.skd.cataclysmbosses.items.Sandstorm_In_A_Bottle;
import com.skd.cataclysmbosses.items.Soul_Render;
import com.skd.cataclysmbosses.items.Strange_Key;
import com.skd.cataclysmbosses.items.The_Annihilator;
import com.skd.cataclysmbosses.items.The_Immolator;
import com.skd.cataclysmbosses.items.The_Incinerator;
import com.skd.cataclysmbosses.items.Tidal_Claws;
import com.skd.cataclysmbosses.items.Tooltier;
import com.skd.cataclysmbosses.items.Void_Assault_SHoulder_Weapon;
import com.skd.cataclysmbosses.items.Void_Scatter_Arrow_Item;
import com.skd.cataclysmbosses.items.Void_core;
import com.skd.cataclysmbosses.items.Void_forge;
import com.skd.cataclysmbosses.items.Wither_Assault_SHoulder_Weapon;
import com.skd.cataclysmbosses.items.Wrath_of_the_desert;
import com.skd.cataclysmbosses.util.AttributeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems((String)"cataclysm");
    public static final DeferredItem<BlockItem> ENDERITE_BLOCK = ITEMS.registerItem("enderite_block", props -> new BlockItem((Block)ModBlocks.ENDERRITE_BLOCK.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> WITHERITE_BLCOK = ITEMS.registerItem("witherite_block", props -> new BlockItem((Block)ModBlocks.WITHERITE_BLOCK.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> IGNITIUM_BLOCK = ITEMS.registerItem("ignitium_block", props -> new BlockItem((Block)ModBlocks.IGNITIUM_BLOCK.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> ANCIENT_METAL_BLOCK = ITEMS.registerItem("ancient_metal_block", props -> new BlockItem((Block)ModBlocks.ANCIENT_METAL_BLOCK.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<BlockItem> CURSIUM_BLOCK = ITEMS.registerItem("cursium_block", props -> new BlockItem((Block)ModBlocks.CURSIUM_BLOCK.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> DUNGEON_BLOCK = ITEMS.registerItem("dungeon_block", props -> new BlockItem((Block)ModBlocks.DUNGEON_BLOCK.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_SANDSTONE = ITEMS.registerItem("polished_sandstone", props -> new BlockItem((Block)ModBlocks.POLISHED_SANDSTONE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_END_STONE = ITEMS.registerItem("polished_end_stone", props -> new BlockItem((Block)ModBlocks.POLISHED_END_STONE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_END_STONE_SLAB = ITEMS.registerItem("polished_end_stone_slab", props -> new BlockItem((Block)ModBlocks.POLISHED_END_STONE_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_END_STONE_STAIRS = ITEMS.registerItem("polished_end_stone_stairs", props -> new BlockItem((Block)ModBlocks.POLISHED_END_STONE_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_END_STONE_BRICKS = ITEMS.registerItem("chiseled_end_stone_bricks", props -> new BlockItem((Block)ModBlocks.CHISELED_END_STONE_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> END_STONE_PILLAR = ITEMS.registerItem("end_stone_pillar", props -> new BlockItem((Block)ModBlocks.END_STONE_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_TILES = ITEMS.registerItem("purpur_tiles", props -> new BlockItem((Block)ModBlocks.PURPUR_TILES.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> VOID_PURPUR_TILES = ITEMS.registerItem("void_purpur_tiles", props -> new BlockItem((Block)ModBlocks.VOID_PURPUR_TILES.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_TILE_PILLAR = ITEMS.registerItem("purpur_tile_pillar", props -> new BlockItem((Block)ModBlocks.PURPUR_TILE_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_TILE_SLAB = ITEMS.registerItem("purpur_tile_slab", props -> new BlockItem((Block)ModBlocks.PURPUR_TILE_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_TILE_STAIRS = ITEMS.registerItem("purpur_tile_stairs", props -> new BlockItem((Block)ModBlocks.PURPUR_TILE_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_TILE_WALL = ITEMS.registerItem("purpur_tile_wall", props -> new BlockItem((Block)ModBlocks.PURPUR_TILE_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> VOID_INFUSED_END_STONE_BRICKS = ITEMS.registerItem("void_infused_end_stone_bricks", props -> new BlockItem((Block)ModBlocks.VOID_INFUSED_END_STONE_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> VOID_STONE = ITEMS.registerItem("void_stone", props -> new BlockItem((Block)ModBlocks.VOID_STONE.get(), props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<BlockItem> VOID_CRYSTAL = ITEMS.registerItem("void_crystal", props -> new BlockItem((Block)ModBlocks.VOID_CRYSTAL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> VOID_LANTERN_BLOCK = ITEMS.registerItem("void_lantern_block", props -> new BlockItem((Block)ModBlocks.VOID_LANTERN_BLOCK.get(), props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICKS = ITEMS.registerItem("obsidian_bricks", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_OBSIDIAN = ITEMS.registerItem("polished_obsidian", props -> new BlockItem((Block)ModBlocks.POLISHED_OBSIDIAN.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_OBSIDIAN_SLAB = ITEMS.registerItem("polished_obsidian_slab", props -> new BlockItem((Block)ModBlocks.POLISHED_OBSIDIAN_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_OBSIDIAN_STAIRS = ITEMS.registerItem("polished_obsidian_stairs", props -> new BlockItem((Block)ModBlocks.POLISHED_OBSIDIAN_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_OBSIDIAN_WALL = ITEMS.registerItem("polished_obsidian_wall", props -> new BlockItem((Block)ModBlocks.POLISHED_OBSIDIAN_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> OBSIDIAN_PILLAR = ITEMS.registerItem("obsidian_pillar", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_OBSIDIAN_BRICKS = ITEMS.registerItem("chiseled_obsidian_bricks", props -> new BlockItem((Block)ModBlocks.CHISELED_OBSIDIAN_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_SLAB = ITEMS.registerItem("obsidian_brick_slab", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_BRICK_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_STAIRS = ITEMS.registerItem("obsidian_brick_stairs", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_BRICK_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> OBSIDIAN_FENCE = ITEMS.registerItem("obsidian_fence", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_FENCE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_WALL = ITEMS.registerItem("obsidian_brick_wall", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_BRICK_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_PURPUR_BLOCK = ITEMS.registerItem("chiseled_purpur_block", props -> new BlockItem((Block)ModBlocks.CHISELED_PURPUR_BLOCK.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_WALL = ITEMS.registerItem("purpur_wall", props -> new BlockItem((Block)ModBlocks.PURPUR_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PURPUR_VOID_RUNE_TRAP_BLOCK = ITEMS.registerItem("purpur_void_rune_trap_block", props -> new BlockItem((Block)ModBlocks.PURPUR_VOID_RUNE_TRAP_BLOCK.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> END_STONE_TELEPORT_TRAP_BRICKS = ITEMS.registerItem("end_stone_teleport_trap_bricks", props -> new BlockItem((Block)ModBlocks.END_STONE_TELEPORT_TRAP_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> OBSIDIAN_EXPLOSION_TRAP_BRICKS = ITEMS.registerItem("obsidian_explosion_trap_bricks", props -> new BlockItem((Block)ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> SANDSTONE_POISON_DART_TRAP = ITEMS.registerItem("sandstone_poison_dart_trap", props -> new BlockItem((Block)ModBlocks.SANDSTONE_POISON_DART_TRAP.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> SANDSTONE_IGNITE_TRAP = ITEMS.registerItem("sandstone_ignite_trap", props -> new BlockItem((Block)ModBlocks.SANDSTONE_IGNITE_TRAP.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> SANDSTONE_FALLING_TRAP = ITEMS.registerItem("sandstone_falling_trap", props -> new BlockItem((Block)ModBlocks.SANDSTONE_FALLING_TRAP.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_STEM = ITEMS.registerItem("chorus_stem", props -> new BlockItem((Block)ModBlocks.CHORUS_STEM.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_PLANKS = ITEMS.registerItem("chorus_planks", props -> new BlockItem((Block)ModBlocks.CHORUS_PLANKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_SLAB = ITEMS.registerItem("chorus_slab", props -> new BlockItem((Block)ModBlocks.CHORUS_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_STAIRS = ITEMS.registerItem("chorus_stairs", props -> new BlockItem((Block)ModBlocks.CHORUS_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_FENCE = ITEMS.registerItem("chorus_fence", props -> new BlockItem((Block)ModBlocks.CHORUS_FENCE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHORUS_TRAPDOOR = ITEMS.registerItem("chorus_trapdoor", props -> new BlockItem((Block)ModBlocks.CHORUS_TRAPDOOR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PRISMARINE_BRICK_FENCE = ITEMS.registerItem("prismarine_brick_fence", props -> new BlockItem((Block)ModBlocks.PRISMARINE_BRICK_FENCE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> QUARTZ_BRICK_WALL = ITEMS.registerItem("quartz_brick_wall", props -> new BlockItem((Block)ModBlocks.QUARTZ_BRICK_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> PRISMARINE_BRICK_WALL = ITEMS.registerItem("prismarine_brick_wall", props -> new BlockItem((Block)ModBlocks.PRISMARINE_BRICK_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> STONE_PILLAR = ITEMS.registerItem("stone_pillar", props -> new BlockItem((Block)ModBlocks.STONE_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_STONE_BRICK_PILLAR = ITEMS.registerItem("chiseled_stone_brick_pillar", props -> new BlockItem((Block)ModBlocks.CHISELED_STONE_BRICK_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> STONE_TILES = ITEMS.registerItem("stone_tiles", props -> new BlockItem((Block)ModBlocks.STONE_TILES.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> STONE_TILE_SLAB = ITEMS.registerItem("stone_tile_slab", props -> new BlockItem((Block)ModBlocks.STONE_TILE_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> STONE_TILE_STAIRS = ITEMS.registerItem("stone_tile_stairs", props -> new BlockItem((Block)ModBlocks.STONE_TILE_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> STONE_TILE_WALL = ITEMS.registerItem("stone_tile_wall", props -> new BlockItem((Block)ModBlocks.STONE_TILE_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> BLACKSTONE_PILLAR = ITEMS.registerItem("blackstone_pillar", props -> new BlockItem((Block)ModBlocks.BLACKSTONE_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE = ITEMS.registerItem("azure_seastone", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_SLAB = ITEMS.registerItem("azure_seastone_slab", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_STAIRS = ITEMS.registerItem("azure_seastone_stairs", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_WALL = ITEMS.registerItem("azure_seastone_wall", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_FENCE = ITEMS.registerItem("azure_seastone_fence", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_FENCE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_TILES = ITEMS.registerItem("azure_seastone_tiles", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_TILES.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_AZURE_SEASTONE = ITEMS.registerItem("chiseled_azure_seastone", props -> new BlockItem((Block)ModBlocks.CHISELED_AZURE_SEASTONE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICKS = ITEMS.registerItem("azure_seastone_bricks", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICK_SLAB = ITEMS.registerItem("azure_seastone_brick_slab", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_BRICK_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICK_STAIRS = ITEMS.registerItem("azure_seastone_brick_stairs", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_BRICK_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICK_WALL = ITEMS.registerItem("azure_seastone_brick_wall", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_BRICK_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_EMPTY = ITEMS.registerItem("azure_seastone_mural_empty", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_EMPTY.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_URCHINKIN = ITEMS.registerItem("azure_seastone_mural_urchinkin", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_URCHINKIN.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_CINDARIA = ITEMS.registerItem("azure_seastone_mural_cindaria", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_CINDARIA.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_HIPPOCAMTUS = ITEMS.registerItem("azure_seastone_mural_hippocamtus", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_HIPPOCAMTUS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_CLAWDIAN = ITEMS.registerItem("azure_seastone_mural_clawdian", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_CLAWDIAN.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_THUNDER = ITEMS.registerItem("azure_seastone_mural_thunder", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_THUNDER.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_SEA = ITEMS.registerItem("azure_seastone_mural_sea", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_SEA.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_UNDERWORLD = ITEMS.registerItem("azure_seastone_mural_underworld", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_UNDERWORLD.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_HARVEST = ITEMS.registerItem("azure_seastone_mural_harvest", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_HARVEST.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_SMITHING = ITEMS.registerItem("azure_seastone_mural_smithing", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_SMITHING.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_WISDOM = ITEMS.registerItem("azure_seastone_mural_wisdom", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_MURAL_WISDOM.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_URCHINKIN = ITEMS.registerItem("curved_azure_seastone_urchinkin", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_URCHINKIN.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_1 = ITEMS.registerItem("curved_azure_seastone_cindaria_1", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CINDARIA_1.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_2 = ITEMS.registerItem("curved_azure_seastone_cindaria_2", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CINDARIA_2.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_3 = ITEMS.registerItem("curved_azure_seastone_cindaria_3", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CINDARIA_3.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_4 = ITEMS.registerItem("curved_azure_seastone_cindaria_4", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CINDARIA_4.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_1 = ITEMS.registerItem("curved_azure_seastone_hippocamtus_1", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_1.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_2 = ITEMS.registerItem("curved_azure_seastone_hippocamtus_2", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_2.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_3 = ITEMS.registerItem("curved_azure_seastone_hippocamtus_3", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_3.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_4 = ITEMS.registerItem("curved_azure_seastone_hippocamtus_4", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_4.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_1 = ITEMS.registerItem("curved_azure_seastone_clawdian_1", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CLAWDIAN_1.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_2 = ITEMS.registerItem("curved_azure_seastone_clawdian_2", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CLAWDIAN_2.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_3 = ITEMS.registerItem("curved_azure_seastone_clawdian_3", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CLAWDIAN_3.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_4 = ITEMS.registerItem("curved_azure_seastone_clawdian_4", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_CLAWDIAN_4.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_1 = ITEMS.registerItem("curved_azure_seastone_scylla_1", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_1.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_2 = ITEMS.registerItem("curved_azure_seastone_scylla_2", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_2.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_3 = ITEMS.registerItem("curved_azure_seastone_scylla_3", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_3.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_4 = ITEMS.registerItem("curved_azure_seastone_scylla_4", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_4.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_5 = ITEMS.registerItem("curved_azure_seastone_scylla_5", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_5.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_6 = ITEMS.registerItem("curved_azure_seastone_scylla_6", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_6.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_7 = ITEMS.registerItem("curved_azure_seastone_scylla_7", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_7.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_8 = ITEMS.registerItem("curved_azure_seastone_scylla_8", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_8.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_9 = ITEMS.registerItem("curved_azure_seastone_scylla_9", props -> new BlockItem((Block)ModBlocks.CURVED_SEASTONE_SCYLLA_9.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE = ITEMS.registerItem("polished_azure_seastone", props -> new BlockItem((Block)ModBlocks.POLISHED_AZURE_SEASTONE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE_SLAB = ITEMS.registerItem("polished_azure_seastone_slab", props -> new BlockItem((Block)ModBlocks.POLISHED_AZURE_SEASTONE_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE_STAIRS = ITEMS.registerItem("polished_azure_seastone_stairs", props -> new BlockItem((Block)ModBlocks.POLISHED_AZURE_SEASTONE_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE_WALL = ITEMS.registerItem("polished_azure_seastone_wall", props -> new BlockItem((Block)ModBlocks.POLISHED_AZURE_SEASTONE_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_PILLAR = ITEMS.registerItem("azure_seastone_pillar", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> AZURE_SEASTONE_PILLAR_WALL = ITEMS.registerItem("azure_seastone_pillar_wall", props -> new BlockItem((Block)ModBlocks.AZURE_SEASTONE_PILLAR_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_AZURE_SEASTONE_PILLAR = ITEMS.registerItem("chiseled_azure_seastone_pillar", props -> new BlockItem((Block)ModBlocks.CHISELED_AZURE_SEASTONE_PILLAR.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> CHISELED_AZURE_SEASTONE_PILLAR_WALL = ITEMS.registerItem("chiseled_azure_seastone_pillar_wall", props -> new BlockItem((Block)ModBlocks.CHISELED_AZURE_SEASTONE_PILLAR_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICKS = ITEMS.registerItem("frosted_stone_bricks", props -> new BlockItem((Block)ModBlocks.FROSTED_STONE_BRICKS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICK_SLAB = ITEMS.registerItem("frosted_stone_brick_slab", props -> new BlockItem((Block)ModBlocks.FROSTED_STONE_BRICK_SLAB.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICK_STAIRS = ITEMS.registerItem("frosted_stone_brick_stairs", props -> new BlockItem((Block)ModBlocks.FROSTED_STONE_BRICK_STAIRS.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICK_WALL = ITEMS.registerItem("frosted_stone_brick_wall", props -> new BlockItem((Block)ModBlocks.FROSTED_STONE_BRICK_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> BLACK_STEEL_BLOCK = ITEMS.registerItem("black_steel_block", props -> new BlockItem((Block)ModBlocks.BLACK_STEEL_BLOCK.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> BLACK_STEEL_FENCE = ITEMS.registerItem("black_steel_fence", props -> new BlockItem((Block)ModBlocks.BLACK_STEEL_FENCE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> BLACK_STEEL_WALL = ITEMS.registerItem("black_steel_wall", props -> new BlockItem((Block)ModBlocks.BLACK_STEEL_WALL.get(), props), () -> new Item.Properties());
    public static final DeferredItem<BlockItem> POINTED_ICICLE = ITEMS.registerItem("pointed_icicle", props -> new BlockItem((Block)ModBlocks.POINTED_ICICLE.get(), props), () -> new Item.Properties());
    public static final DeferredItem<Item> WITHERITE_INGOT = ITEMS.registerItem("witherite_ingot", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> ENDERITE_INGOT = ITEMS.registerItem("enderite_ingot", props -> new ItemInventoryOnly(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> ANCIENT_METAL_INGOT = ITEMS.registerItem("ancient_metal_ingot", props -> new Item(props), () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> ANCIENT_METAL_NUGGET = ITEMS.registerItem("ancient_metal_nugget", props -> new Item(props), () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> BLACK_STEEL_INGOT = ITEMS.registerItem("black_steel_ingot", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> BLACK_STEEL_NUGGET = ITEMS.registerItem("black_steel_nugget", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> LACRIMA = ITEMS.registerItem("lacrima", props -> new Item(props), () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> ESSENCE_OF_THE_STORM = ITEMS.registerItem("essence_of_the_storm", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> IGNITIUM_INGOT = ITEMS.registerItem("ignitium_ingot", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity((Rarity)CMRarity.IGNITIUM_PROXY.getValue()));
    public static final DeferredItem<Item> CURSIUM_INGOT = ITEMS.registerItem("cursium_ingot", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity((Rarity)CMRarity.MALEDICTUS_PROXY.getValue()));
    public static final DeferredItem<Item> IGNITIUM_UPGARDE_SMITHING_TEMPLATE = ITEMS.registerItem("ignitium_upgrade_smithing_template", ModTemplate::createignitiumUpgradeTemplate, () -> new net.minecraft.world.item.Item.Properties().fireResistant());
    public static final DeferredItem<Item> CURSIUM_UPGARDE_SMITHING_TEMPLATE = ITEMS.registerItem("cursium_upgrade_smithing_template", ModTemplate::createcursiumUpgradeTemplate, () -> new net.minecraft.world.item.Item.Properties().fireResistant());
    public static final DeferredItem<Item> CHAIN_OF_SOUL_BINDING = ITEMS.registerItem("chain_of_soul_binding", props -> new ItemInventoryOnly(props), () -> new Item.Properties());
    public static final DeferredItem<Item> CORAL_SPEAR = ITEMS.registerItem("coral_spear", props -> new Coral_Spear(props), () -> new Item.Properties().durability(110).attributes(Coral_Spear.createAttributes()));
    public static final DeferredItem<Item> CORAL_BARDICHE = ITEMS.registerItem("coral_bardiche", props -> new Coral_Bardiche(props), () -> new Item.Properties().durability(160).attributes(Coral_Bardiche.createAttributes()));
    public static final DeferredItem<Item> ATHAME = ITEMS.registerItem("athame", props -> new Athame(props), () -> new Item.Properties().durability(250).attributes(Athame.createAttributes()));
    public static final DeferredItem<Item> KHOPESH = ITEMS.registerItem("khopesh", props -> new Khopesh(props), () -> new Item.Properties().sword(Tooltier.ANCIENT_METAL, 3.0F, -2.4F));
    public static final DeferredItem<Item> BLACK_STEEL_SWORD = ITEMS.registerItem("black_steel_sword", props -> new Item(props), () -> new Item.Properties().sword(Tooltier.BLACK_STEEL, 3.0F, -2.4F));
    public static final DeferredItem<Item> BLACK_STEEL_SHOVEL = ITEMS.registerItem("black_steel_shovel", props -> new ShovelItem(Tooltier.BLACK_STEEL, 1.5F, -3.0F, props), () -> new Item.Properties());
    public static final DeferredItem<Item> BLACK_STEEL_PICKAXE = ITEMS.registerItem("black_steel_pickaxe", props -> new Item(props), () -> new Item.Properties().pickaxe(Tooltier.BLACK_STEEL, 1.0F, -2.8F));
    public static final DeferredItem<Item> BLACK_STEEL_AXE = ITEMS.registerItem("black_steel_axe", props -> new AxeItem(Tooltier.BLACK_STEEL, 6.0F, -3.1F, props), () -> new Item.Properties());
    public static final DeferredItem<Item> BLACK_STEEL_HOE = ITEMS.registerItem("black_steel_hoe", props -> new HoeItem(Tooltier.BLACK_STEEL, -2.0F, -1.0F, props), () -> new Item.Properties());
    public static final DeferredItem<Item> BLACK_STEEL_TARGE = ITEMS.registerItem("black_steel_targe", props -> new Black_Steel_Targe(props), () -> new Item.Properties().durability(840));
    public static final DeferredItem<Item> AZURE_SEA_SHIELD = ITEMS.registerItem("azure_sea_shield", props -> new Azure_sea_Shield(props), () -> new Item.Properties().durability(514));
    public static final DeferredItem<Item> BULWARK_OF_THE_FLAME = ITEMS.registerItem("bulwark_of_the_flame", props -> new Bulwark_of_the_flame(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> GAUNTLET_OF_GUARD = ITEMS.registerItem("gauntlet_of_guard", props -> new Gauntlet_of_Guard(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(10.0f, -2.4f, new AttributeContainer((Holder<Attribute>)Attributes.ARMOR, 3.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.ARMOR_TOUGHNESS, 3.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.KNOCKBACK_RESISTANCE, 0.15f, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> GAUNTLET_OF_BULWARK = ITEMS.registerItem("gauntlet_of_bulwark", props -> new Gauntlet_of_Bulwark(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(10.0f, -2.4f, new AttributeContainer((Holder<Attribute>)Attributes.ARMOR, 3.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.ARMOR_TOUGHNESS, 3.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.KNOCKBACK_RESISTANCE, 0.15f, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> GAUNTLET_OF_MAELSTROM = ITEMS.registerItem("gauntlet_of_maelstrom", props -> new Gauntlet_of_Maelstrom(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(10.0f, -2.4f, new AttributeContainer((Holder<Attribute>)Attributes.ARMOR, 3.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.ARMOR_TOUGHNESS, 3.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.KNOCKBACK_RESISTANCE, 0.15f, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> THE_INCINERATOR = ITEMS.registerItem("the_incinerator", props -> new The_Incinerator(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(13.0f, -2.7f, new AttributeContainer((Holder<Attribute>)Attributes.ENTITY_INTERACTION_RANGE, 2.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> BELT_OF_BEGINNER = ITEMS.registerItem("belt_of_beginner", props -> new CuriosItem(props), () -> new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> BELT_OF_MONSTROSITY = ITEMS.registerItem("belt_of_monstrosity", props -> new CuriosItem(props), () -> new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> BLAZING_GRIPS = ITEMS.registerItem("blazing_grips", props -> new Blazing_Grips(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> CHITIN_CLAW = ITEMS.registerItem("chitin_claw", props -> new Chitin_Claw(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> RING_OF_GRUDGED = ITEMS.registerItem("ring_of_grudged", props -> new CuriosItem(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> BERSERKER_SOUL_AMULET = ITEMS.registerItem("berserker_soul_amulet", props -> new CuriosItem(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> VITALITY_ANKH = ITEMS.registerItem("vitality_ankh", props -> new CuriosItem(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> UNBREAKABLE_SKULL = ITEMS.registerItem("unbreakable_skull", props -> new Unbreakable_Skull(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> STURDY_BOOTS = ITEMS.registerItem("sturdy_boots", props -> new Sturdy_Boots(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> CURSED_BOW = ITEMS.registerItem("cursed_bow", props -> new Cursed_bow(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> WRATH_OF_THE_DESERT = ITEMS.registerItem("wrath_of_the_desert", props -> new Wrath_of_the_desert(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> SOUL_RENDER = ITEMS.registerItem("soul_render", props -> new Soul_Render(props), () -> new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(Cataclysm_Weapon.createAttributes(14.0f, -2.9f, new AttributeContainer((Holder<Attribute>)Attributes.ENTITY_INTERACTION_RANGE, 2.0, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer((Holder<Attribute>)Attributes.BLOCK_INTERACTION_RANGE, 2.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> THE_ANNIHILATOR = ITEMS.registerItem("the_annihilator", props -> new The_Annihilator(props), () -> new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(Cataclysm_Weapon.createAttributes(6.5f, -2.4f, new AttributeContainer((Holder<Attribute>)ModAttribute.ADDITIONAL_CRITICAL_DAMAGE, 75.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> ASTRAPE = ITEMS.registerItem("astrape", props -> new Astrape(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(9.5f, -2.6f, new AttributeContainer((Holder<Attribute>)Attributes.ENTITY_INTERACTION_RANGE, 2.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> CERAUNUS = ITEMS.registerItem("ceraunus", props -> new Ceraunus(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(15.0f, -3.3f, new AttributeContainer((Holder<Attribute>)Attributes.ENTITY_INTERACTION_RANGE, 1.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> BRONTES = ITEMS.registerItem("brontes", props -> new Brontes(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).pickaxe(Tooltier.MONSTROSITY, 8.0F, -3.0F));
    public static final DeferredItem<Item> THE_IMMOLATOR = ITEMS.registerItem("the_immolator", props -> new The_Immolator(props), () -> new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(Cataclysm_Weapon.createAttributes(7.5f, -2.4f, new AttributeContainer((Holder<Attribute>)ModAttribute.ADDITIONAL_CRITICAL_DAMAGE, 60.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> MEAT_SHREDDER = ITEMS.registerItem("meat_shredder", props -> new Meat_Shredder(props), () -> new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(Cataclysm_Weapon.createAttributes(7.5f, -2.6f, new AttributeContainer[0])));
    public static final DeferredItem<Item> LASER_GATLING = ITEMS.registerItem("laser_gatling", props -> new Laser_Gatling(props), () -> new Item.Properties().stacksTo(1).fireResistant().durability(50).rarity(Rarity.EPIC));
    public static final DeferredItem<Item> WITHER_ASSULT_SHOULDER_WEAPON = ITEMS.registerItem("wither_assault_shoulder_weapon", props -> new Wither_Assault_SHoulder_Weapon(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> VOID_ASSULT_SHOULDER_WEAPON = ITEMS.registerItem("void_assault_shoulder_weapon", props -> new Void_Assault_SHoulder_Weapon(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> VOID_FORGE = ITEMS.registerItem("void_forge", props -> new Void_forge(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).pickaxe(Tooltier.MONSTROSITY, 8.0F, -3.0F));
    public static final DeferredItem<Item> TIDAL_CLAWS = ITEMS.registerItem("tidal_claws", props -> new Tidal_Claws(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Cataclysm_Weapon.createAttributes(7.0f, -2.4f, new AttributeContainer[0])));
    public static final DeferredItem<Item> INFERNAL_FORGE = ITEMS.registerItem("infernal_forge", props -> new Infernal_forge(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).pickaxe(Tooltier.MONSTROSITY, 8.0F, -3.0F));
    public static final DeferredItem<Item> SANDSTORM_IN_A_BOTTLE = ITEMS.registerItem("sandstorm_in_a_bottle", props -> new Sandstorm_In_A_Bottle(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> ANCIENT_SPEAR = ITEMS.registerItem("ancient_spear", props -> new Ancient_Spear(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().durability(1800).attributes(Cataclysm_Weapon.createAttributes(8.5f, -2.6f, new AttributeContainer((Holder<Attribute>)Attributes.ENTITY_INTERACTION_RANGE, 2.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> STICKY_GLOVES = ITEMS.registerItem("sticky_gloves", props -> new Sticky_Gloves(props), () -> new Item.Properties().stacksTo(1));
    public static final DeferredItem<Item> REMNANT_SKULL = ITEMS.registerItem("remnant_skull", props -> new Remnant_Skull(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> NETHERITE_EFFIGY = ITEMS.registerItem("netherite_effigy", props -> new Netherite_Effigy(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    public static final DeferredItem<Item> VOID_SCATTER_ARROW = ITEMS.registerItem("void_scatter_arrow", props -> new Void_Scatter_Arrow_Item(props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> VOID_SHARD = ITEMS.registerItem("void_shard", props -> new ItemInventoryOnly(props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> BLAZING_BONE = ITEMS.registerItem("blazing_bone", props -> new ItemInventoryOnly(props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> KOBOLETON_BONE = ITEMS.registerItem("koboleton_bone", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> VOID_JAW = ITEMS.registerItem("void_jaw", props -> new Item(props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> VOID_CORE = ITEMS.registerItem("void_core", props -> new Void_core(props), () -> new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> CRYSTALLIZED_CORAL_FRAGMENTS = ITEMS.registerItem("crystallized_coral_fragments", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> CRYSTALLIZED_CORAL = ITEMS.registerItem("crystallized_coral", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> CORAL_CHUNK = ITEMS.registerItem("coral_chunk", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> ABYSSAL_SACRIFICE = ITEMS.registerItem("abyssal_sacrifice", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final DeferredItem<Item> NECKLACE_OF_THE_DESERT = ITEMS.registerItem("necklace_of_the_desert", props -> new Necklace_Of_The_Desert(props), () -> new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final DeferredItem<Item> STRANGE_KEY = ITEMS.registerItem("strange_key", props -> new Strange_Key(props), () -> new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final DeferredItem<Item> APTRGANGR_HEAD = ITEMS.registerItem("aptrgangr_head", props -> new CataclysmSkullItem((Block)ModBlocks.APTRGANGR_HEAD.get(), (Block)ModBlocks.APTRGANGR_WALL_HEAD.get(), props), () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> DRAUGR_HEAD = ITEMS.registerItem("draugr_head", props -> new CataclysmSkullItem((Block)ModBlocks.DRAUGR_HEAD.get(), (Block)ModBlocks.DRAUGR_WALL_HEAD.get(), props), () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> KOBOLEDIATOR_SKULL = ITEMS.registerItem("kobolediator_skull", props -> new CataclysmSkullItem((Block)ModBlocks.KOBOLEDIATOR_SKULL.get(), (Block)ModBlocks.KOBOLEDIATOR_WALL_SKULL.get(), props), () -> new Item.Properties().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> BONE_REPTILE_HELMET = ITEMS.registerItem("bone_reptile_helmet", props -> new Bone_Reptile_Armor(Armortier.BONE_REPTILE, ArmorType.HELMET, props), () -> new Item.Properties().humanoidArmor(Armortier.BONE_REPTILE.value(), ArmorType.HELMET).attributes(Cataclysm_Armor.createAttributes(Armortier.BONE_REPTILE, ArmorType.HELMET)));
    public static final DeferredItem<Item> BONE_REPTILE_CHESTPLATE = ITEMS.registerItem("bone_reptile_chestplate", props -> new Bone_Reptile_Armor(Armortier.BONE_REPTILE, ArmorType.CHESTPLATE, props), () -> new Item.Properties().humanoidArmor(Armortier.BONE_REPTILE.value(), ArmorType.CHESTPLATE).attributes(Cataclysm_Armor.createAttributes(Armortier.BONE_REPTILE, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> IGNITIUM_HELMET = ITEMS.registerItem("ignitium_helmet", props -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorType.HELMET, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.IGNITIUM.value(), ArmorType.HELMET).attributes(Cataclysm_Armor.createAttributes(Armortier.IGNITIUM, ArmorType.HELMET)));
    public static final DeferredItem<Item> IGNITIUM_CHESTPLATE = ITEMS.registerItem("ignitium_chestplate", props -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorType.CHESTPLATE, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.IGNITIUM.value(), ArmorType.CHESTPLATE).attributes(Cataclysm_Armor.createAttributes(Armortier.IGNITIUM, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> IGNITIUM_ELYTRA_CHESTPLATE = ITEMS.registerItem("ignitium_elytra_chestplate", props -> new Ignitium_Elytra_ChestPlate(props, Armortier.IGNITIUM), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.IGNITIUM.value(), ArmorType.CHESTPLATE).attributes(Cataclysm_Armor.createAttributes(Armortier.IGNITIUM, ArmorType.CHESTPLATE)).component(DataComponents.GLIDER, Unit.INSTANCE));
    public static final DeferredItem<Item> IGNITIUM_LEGGINGS = ITEMS.registerItem("ignitium_leggings", props -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorType.LEGGINGS, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.IGNITIUM.value(), ArmorType.LEGGINGS).attributes(Cataclysm_Armor.createAttributes(Armortier.IGNITIUM, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> IGNITIUM_BOOTS = ITEMS.registerItem("ignitium_boots", props -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorType.BOOTS, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.IGNITIUM.value(), ArmorType.BOOTS).attributes(Cataclysm_Armor.createAttributes(Armortier.IGNITIUM, ArmorType.BOOTS)));
    public static final DeferredItem<Item> CURSIUM_HELMET = ITEMS.registerItem("cursium_helmet", props -> new Cursium_Armor(Armortier.CURSIUM, ArmorType.HELMET, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.CURSIUM.value(), ArmorType.HELMET).attributes(Cataclysm_Armor.createAttributes(Armortier.CURSIUM, ArmorType.HELMET)));
    public static final DeferredItem<Item> CURSIUM_CHESTPLATE = ITEMS.registerItem("cursium_chestplate", props -> new Cursium_ChestPlate(Armortier.CURSIUM, ArmorType.CHESTPLATE, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.CURSIUM.value(), ArmorType.CHESTPLATE).attributes(Cataclysm_Armor.createAttributes(Armortier.CURSIUM, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> CURSIUM_LEGGINGS = ITEMS.registerItem("cursium_leggings", props -> new Cursium_Armor(Armortier.CURSIUM, ArmorType.LEGGINGS, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.CURSIUM.value(), ArmorType.LEGGINGS).attributes(Cataclysm_Armor.createAttributes(Armortier.CURSIUM, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> CURSIUM_BOOTS = ITEMS.registerItem("cursium_boots", props -> new Cursium_Armor(Armortier.CURSIUM, ArmorType.BOOTS, props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC).humanoidArmor(Armortier.CURSIUM.value(), ArmorType.BOOTS).attributes(Cataclysm_Armor.createAttributes(Armortier.CURSIUM, ArmorType.BOOTS)));
    public static final DeferredItem<Item> MONSTROUS_HORN = ITEMS.registerItem("monstrous_horn", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> LAVA_POWER_CELL = ITEMS.registerItem("lava_power_cell", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> MONSTROUS_HELM = ITEMS.registerItem("monstrous_helm", props -> new Monstrous_Helm(net.minecraft.core.Holder.direct(ArmorMaterials.NETHERITE), ArmorType.HELMET, props), () -> new Item.Properties().fireResistant().humanoidArmor(ArmorMaterials.NETHERITE, ArmorType.HELMET).rarity(Rarity.EPIC));
    public static final DeferredItem<Item> BLOOM_STONE_PAULDRONS = ITEMS.registerItem("bloom_stone_pauldrons", props -> new Bloom_Stone_Pauldrons(Armortier.CRAB, ArmorType.CHESTPLATE, props, new AttributeContainer[0]), () -> new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).humanoidArmor(Armortier.CRAB.value(), ArmorType.CHESTPLATE).attributes(Cataclysm_Armor.createAttributes(Armortier.CRAB, ArmorType.CHESTPLATE, new AttributeContainer(ModAttribute.NATURE_HEAL, 15.0, AttributeModifier.Operation.ADD_VALUE))));
    public static final DeferredItem<Item> BURNING_ASHES = ITEMS.registerItem("burning_ashes", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.RARE));
    public static final DeferredItem<Item> DYING_EMBER = ITEMS.registerItem("dying_ember", props -> new Item(props), () -> new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON));
    public static final DeferredItem<Item> MUSIC_DISC_NETHERITE_MONSTROSITY = ITEMS.registerItem("music_disc_netherite_monstrosity", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.MONSTROSITY_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_ENDER_GUARDIAN = ITEMS.registerItem("music_disc_ender_guardian", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.ENDERGUARDIAN_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_IGNIS = ITEMS.registerItem("music_disc_ignis", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.IGNIS_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_THE_HARBINGER = ITEMS.registerItem("music_disc_the_harbinger", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.HARBINGER_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_THE_LEVIATHAN = ITEMS.registerItem("music_disc_the_leviathan", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.LEVIATHAN_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_ANCIENT_REMNANT = ITEMS.registerItem("music_disc_ancient_remnant", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.REMNANT_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_MALEDICTUS = ITEMS.registerItem("music_disc_maledictus", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.MALEDICTUS_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_SCYLLA = ITEMS.registerItem("music_disc_scylla", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.SCYLLA_THEME));
    public static final DeferredItem<Item> MUSIC_DISC_THE_CATACLYSM_FARER = ITEMS.registerItem("music_disc_the_cataclysmfarer", props -> new Item(props), () -> new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.THE_CATACLYSM_FARER));
    public static final DeferredItem<Item> MECH_EYE = ITEMS.registerItem("mech_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_MECH_LOCATED, 255, 51, 0), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> FLAME_EYE = ITEMS.registerItem("flame_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_FLAME_LOCATED, 252, 149, 0), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> VOID_EYE = ITEMS.registerItem("void_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_RUINED_LOCATED, 186, 149, 186), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> MONSTROUS_EYE = ITEMS.registerItem("monstrous_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_MONSTROUS_LOCATED, 90, 87, 90), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> ABYSS_EYE = ITEMS.registerItem("abyss_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_ABYSS_LOCATED, 33, 22, 43), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> DESERT_EYE = ITEMS.registerItem("desert_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_DESERT_LOCATED, 247, 168, 64), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> CURSED_EYE = ITEMS.registerItem("cursed_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_CURSE_LOCATED, 26, 107, 89), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> STORM_EYE = ITEMS.registerItem("storm_eye", props -> new DungeonEyeItem(props, ModTag.EYE_OF_STORM_LOCATED, 99, 194, 224), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> LIONFISH = ITEMS.registerItem("lionfish", props -> new Item(props), () -> new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build()));
    public static final DeferredItem<Item> AMETHYST_CRAB_MEAT = ITEMS.registerItem("amethyst_crab_meat", props -> new Item(props), () -> new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.2f).build()));
    public static final DeferredItem<Item> BLESSED_AMETHYST_CRAB_MEAT = ITEMS.registerItem("blessed_amethyst_crab_meat", props -> new Blessed_Amethyst_Crab_Meat(props), () -> new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.2f).alwaysEdible().build()));
    public static final DeferredItem<Item> AMETHYST_CRAB_SHELL = ITEMS.registerItem("amethyst_crab_shell", props -> new Item(props), () -> new Item.Properties());
    public static final DeferredItem<Item> LIONFISH_SPIKE = ITEMS.registerItem("lionfish_spike", props -> new ItemInventoryOnly(props), () -> new Item.Properties());
    public static final DeferredItem<Item> URCHIN_SPIKE = ITEMS.registerItem("urchin_spike", props -> new ItemInventoryOnly(props), () -> new Item.Properties());
    public static final DeferredItem<Item> BLOOD_CLOT = ITEMS.registerItem("blood_clot", props -> new ItemInventoryOnly(props), () -> new Item.Properties());
    public static final DeferredItem<Item> THE_BABY_LEVIATHAN_BUCKET = ITEMS.registerItem("the_baby_leviathan_bucket", props -> new ModFishBucket((EntityType)ModEntities.THE_BABY_LEVIATHAN.get(), (Fluid)Fluids.WATER, props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> MODERN_REMNANT_BUCKET = ITEMS.registerItem("modern_remnant_bucket", props -> new ModernRemantBucket((EntityType)ModEntities.MODERN_REMNANT.get(), Fluids.EMPTY, props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<Item> NETHERITE_MINISTROSITY_BUCKET = ITEMS.registerItem("netherite_ministrosity_bucket", props -> new ModernRemantBucket((EntityType)ModEntities.NETHERITE_MINISTROSITY.get(), Fluids.EMPTY, props), () -> new Item.Properties().fireResistant());
    public static final DeferredItem<SpawnEggItem> ENDER_GOLEM_SPAWN_EGG = ITEMS.registerItem("ender_golem_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.ENDER_GOLEM.get()));
    public static final DeferredItem<SpawnEggItem> NETHERITE_MONSTROSITY_SPAWN_EGG = ITEMS.registerItem("netherite_monstrosity_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.NETHERITE_MONSTROSITY.get()));
    public static final DeferredItem<SpawnEggItem> NETHERITE_MINISTROSITY_SPAWN_EGG = ITEMS.registerItem("netherite_ministrosity_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.NETHERITE_MINISTROSITY.get()));
    public static final DeferredItem<SpawnEggItem> ENDER_GUARDIAN_SPAWN_EGG = ITEMS.registerItem("ender_guardian_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.ENDER_GUARDIAN.get()));
    public static final DeferredItem<SpawnEggItem> ENDERMAPTERA_SPAWN_EGG = ITEMS.registerItem("endermaptera_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.ENDERMAPTERA.get()));
    public static final DeferredItem<SpawnEggItem> IGNIS_SPAWN_EGG = ITEMS.registerItem("ignis_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.IGNIS.get()));
    public static final DeferredItem<SpawnEggItem> IGNITED_REVENANT_SPAWN_EGG = ITEMS.registerItem("ignited_revenant_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.IGNITED_REVENANT.get()));
    public static final DeferredItem<SpawnEggItem> IGNITED_BERSERKER_SPAWN_EGG = ITEMS.registerItem("ignited_berserker_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.IGNITED_BERSERKER.get()));
    public static final DeferredItem<SpawnEggItem> THE_WATCHER_SPAWN_EGG = ITEMS.registerItem("the_watcher_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.THE_WATCHER.get()));
    public static final DeferredItem<SpawnEggItem> THE_PROWLER_SPAWN_EGG = ITEMS.registerItem("the_prowler_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.THE_PROWLER.get()));
    public static final DeferredItem<SpawnEggItem> THE_HARBINGER_SPAWN_EGG = ITEMS.registerItem("the_harbinger_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.THE_HARBINGER.get()));
    public static final DeferredItem<SpawnEggItem> THE_LEVIATHAN_SPAWN_EGG = ITEMS.registerItem("the_leviathan_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.THE_LEVIATHAN.get()));
    public static final DeferredItem<SpawnEggItem> THE_BABY_LEVIATHAN_SPAWN_EGG = ITEMS.registerItem("the_baby_leviathan_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.THE_BABY_LEVIATHAN.get()));
    public static final DeferredItem<SpawnEggItem> DEEPLING_SPAWN_EGG = ITEMS.registerItem("deepling_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DEEPLING.get()));
    public static final DeferredItem<SpawnEggItem> DEEPLING_BRUTE_SPAWN_EGG = ITEMS.registerItem("deepling_brute_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DEEPLING_BRUTE.get()));
    public static final DeferredItem<SpawnEggItem> DEEPLING_ANGLER_SPAWN_EGG = ITEMS.registerItem("deepling_angler_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DEEPLING_ANGLER.get()));
    public static final DeferredItem<SpawnEggItem> DEEPLING_PRIEST_SPAWN_EGG = ITEMS.registerItem("deepling_priest_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DEEPLING_PRIEST.get()));
    public static final DeferredItem<SpawnEggItem> DEEPLING_WARLOCK_SPAWN_EGG = ITEMS.registerItem("deepling_warlock_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DEEPLING_WARLOCK.get()));
    public static final DeferredItem<SpawnEggItem> LIONFISH_SPAWN_EGG = ITEMS.registerItem("lionfish_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.LIONFISH.get()));
    public static final DeferredItem<SpawnEggItem> CORAL_GOLEM_SPAWN_EGG = ITEMS.registerItem("coral_golem_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.CORAL_GOLEM.get()));
    public static final DeferredItem<SpawnEggItem> CORALSSUS_SPAWN_EGG = ITEMS.registerItem("coralssus_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.CORALSSUS.get()));
    public static final DeferredItem<SpawnEggItem> AMETHYST_CRAB_SPAWN_EGG = ITEMS.registerItem("amethyst_crab_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.AMETHYST_CRAB.get()));
    public static final DeferredItem<SpawnEggItem> KOBOLETON_SPAWN_EGG = ITEMS.registerItem("koboleton_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.KOBOLETON.get()));
    public static final DeferredItem<SpawnEggItem> KOBOLEDIATOR_SPAWN_EGG = ITEMS.registerItem("kobolediator_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.KOBOLEDIATOR.get()));
    public static final DeferredItem<SpawnEggItem> WADJET_SPAWN_EGG = ITEMS.registerItem("wadjet_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.WADJET.get()));
    public static final DeferredItem<SpawnEggItem> ANCIENT_REMNANT_SPAWN_EGG = ITEMS.registerItem("ancient_remnant_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.ANCIENT_REMNANT.get()));
    public static final DeferredItem<SpawnEggItem> MODERN_REMNANT_SPAWN_EGG = ITEMS.registerItem("modern_remnant_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.MODERN_REMNANT.get()));
    public static final DeferredItem<SpawnEggItem> MALEDICTUS_SPAWN_EGG = ITEMS.registerItem("maledictus_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.MALEDICTUS.get()));
    public static final DeferredItem<SpawnEggItem> APTRGANGR_SPAWN_EGG = ITEMS.registerItem("aptrgangr_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.APTRGANGR.get()));
    public static final DeferredItem<SpawnEggItem> ELITE_DRAUGR_SPAWN_EGG = ITEMS.registerItem("elite_draugr_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.ELITE_DRAUGR.get()));
    public static final DeferredItem<SpawnEggItem> ROYAL_DRAUGR_SPAWN_EGG = ITEMS.registerItem("royal_draugr_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.ROYAL_DRAUGR.get()));
    public static final DeferredItem<SpawnEggItem> DRAUGR_SPAWN_EGG = ITEMS.registerItem("draugr_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DRAUGR.get()));
    public static final DeferredItem<SpawnEggItem> SCYLLA_SPAWN_EGG = ITEMS.registerItem("scylla_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.SCYLLA.get()));
    public static final DeferredItem<SpawnEggItem> CLAWDIAN_SPAWN_EGG = ITEMS.registerItem("clawdian_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.CLAWDIAN.get()));
    public static final DeferredItem<SpawnEggItem> HIPPOCAMTUS_SPAWN_EGG = ITEMS.registerItem("hippocamtus_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.HIPPOCAMTUS.get()));
    public static final DeferredItem<SpawnEggItem> CINDARIA_SPAWN_EGG = ITEMS.registerItem("cindaria_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.CINDARIA.get()));
    public static final DeferredItem<SpawnEggItem> OCTOHOST_SPAWN_EGG = ITEMS.registerItem("octohost_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.DROWNED_HOST.get()));
    public static final DeferredItem<SpawnEggItem> SYMBIOCTO_SPAWN_EGG = ITEMS.registerItem("symbiocto_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.SYMBIOCTO.get()));
    public static final DeferredItem<SpawnEggItem> URCHINKIN_SPAWN_EGG = ITEMS.registerItem("urchinkin_spawn_egg", props -> new SpawnEggItem(props), () -> new Item.Properties().spawnEgg(ModEntities.URCHINKIN.get()));
    public static final DeferredItem<BlockItem> ALTAR_OF_VOID = ITEMS.registerItem("altar_of_void", props -> new BlockItem((Block)ModBlocks.ALTAR_OF_VOID.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> ALTAR_OF_FIRE = ITEMS.registerItem("altar_of_fire", props -> new BlockItem((Block)ModBlocks.ALTAR_OF_FIRE.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> ALTAR_OF_AMETHYST = ITEMS.registerItem("altar_of_amethyst", props -> new BlockItem((Block)ModBlocks.ALTAR_OF_AMETHYST.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> ALTAR_OF_ABYSS = ITEMS.registerItem("altar_of_abyss", props -> new BlockItem((Block)ModBlocks.ALTAR_OF_ABYSS.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> CURSED_TOMBSTONE = ITEMS.registerItem("cursed_tombstone", props -> new BlockItem((Block)ModBlocks.CURSED_TOMBSTONE.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> EMP = ITEMS.registerItem("emp", props -> new BlockItem((Block)ModBlocks.EMP.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> ABYSSAL_EGG = ITEMS.registerItem("abyssal_egg", props -> new BlockItem((Block)ModBlocks.ABYSSAL_EGG.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> MECHANICAL_FUSION_ANVIL = ITEMS.registerItem("mechanical_fusion_anvil", props -> new BlockItem((Block)ModBlocks.MECHANICAL_FUSION_ANVIL.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> DOOR_OF_SEAL = ITEMS.registerItem("door_of_seal", props -> new BlockItem((Block)ModBlocks.DOOR_OF_SEAL.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> GODDESS_STATUE = ITEMS.registerItem("goddess_statue", props -> new BlockItem((Block)ModBlocks.GODDESS_STATUE.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));
    public static final DeferredItem<BlockItem> BOSS_RESPAWNER = ITEMS.registerItem("boss_respawner", props -> new BlockItem((Block)ModBlocks.BOSS_RESPAWNER.get(), props), () -> new Item.Properties().fireResistant().rarity(Rarity.EPIC));

    private static ItemAttributeModifiers toolAttributes(ToolMaterial material, float attackDamageBaseline, float attackSpeedBaseline) {
        return ItemAttributeModifiers.builder()
            .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
                new net.minecraft.world.entity.ai.attributes.AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamageBaseline + material.attackDamageBonus(), net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE),
                net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND)
            .add(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED,
                new net.minecraft.world.entity.ai.attributes.AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeedBaseline, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE),
                net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND)
            .build();
    }

    public static void initDispenser() {
        DispenserBlock.registerProjectileBehavior((ItemLike)((ItemLike)VOID_SCATTER_ARROW.get()));
        DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior(){
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem)itemStack.getItem();
                BlockPos blockPos = blockSource.pos().relative((Direction)blockSource.state().getValue((Property)DispenserBlock.FACING));
                ServerLevel level = blockSource.level().getLevel();
                if (dispensibleContainerItem.emptyContents(null, (Level)level, blockPos, null)) {
                    dispensibleContainerItem.checkExtraContent(null, (Level)level, itemStack, blockPos);
                    return new ItemStack((ItemLike)Items.BUCKET);
                }
                return this.defaultDispenseItemBehavior.dispense(blockSource, itemStack);
            }
        };
        DispenserBlock.registerBehavior((ItemLike)((ItemLike)THE_BABY_LEVIATHAN_BUCKET.get()), (DispenseItemBehavior)dispenseItemBehavior);
        DispenserBlock.registerBehavior((ItemLike)((ItemLike)MODERN_REMNANT_BUCKET.get()), (DispenseItemBehavior)dispenseItemBehavior);
    }

    public static void modifyComponents(ModifyDefaultComponentsEvent event) {
        if (!ConfigHolder.COMMON_SPEC.isLoaded()) {
            Cataclysm.LOGGER.error("Could not modify default components due to config not being loaded yet");
        } else {
            event.modify((ItemLike)MONSTROUS_HELM.get(), (components, context, item) -> components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE));
            event.modify((ItemLike)IGNITIUM_HELMET.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)IGNITIUM_HELMET.get(), Cataclysm_Armor.createArmorAttributes(Armortier.IGNITIUM, (float)CMCommonConfig.IgnitiumArmor.armorMultiplier, (float)CMCommonConfig.IgnitiumArmor.toughness, (float)CMCommonConfig.IgnitiumArmor.knockbackResistance, ArmorType.HELMET, new AttributeContainer[0]));
            });
            event.modify((ItemLike)IGNITIUM_CHESTPLATE.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)IGNITIUM_CHESTPLATE.get(), Cataclysm_Armor.createArmorAttributes(Armortier.IGNITIUM, (float)CMCommonConfig.IgnitiumArmor.armorMultiplier, (float)CMCommonConfig.IgnitiumArmor.toughness, (float)CMCommonConfig.IgnitiumArmor.knockbackResistance, ArmorType.CHESTPLATE, new AttributeContainer[0]));
            });
            event.modify((ItemLike)IGNITIUM_ELYTRA_CHESTPLATE.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)IGNITIUM_ELYTRA_CHESTPLATE.get(), Cataclysm_Armor.createArmorAttributes(Armortier.IGNITIUM, (float)CMCommonConfig.IgnitiumArmor.armorMultiplier, (float)CMCommonConfig.IgnitiumArmor.toughness, (float)CMCommonConfig.IgnitiumArmor.knockbackResistance, ArmorType.CHESTPLATE, new AttributeContainer[0]));
            });
            event.modify((ItemLike)IGNITIUM_LEGGINGS.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)IGNITIUM_LEGGINGS.get(), Cataclysm_Armor.createArmorAttributes(Armortier.IGNITIUM, (float)CMCommonConfig.IgnitiumArmor.armorMultiplier, (float)CMCommonConfig.IgnitiumArmor.toughness, (float)CMCommonConfig.IgnitiumArmor.knockbackResistance, ArmorType.LEGGINGS, new AttributeContainer[0]));
            });
            event.modify((ItemLike)IGNITIUM_BOOTS.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)IGNITIUM_BOOTS.get(), Cataclysm_Armor.createArmorAttributes(Armortier.IGNITIUM, (float)CMCommonConfig.IgnitiumArmor.armorMultiplier, (float)CMCommonConfig.IgnitiumArmor.toughness, (float)CMCommonConfig.IgnitiumArmor.knockbackResistance, ArmorType.BOOTS, new AttributeContainer[0]));
            });
            event.modify((ItemLike)CURSIUM_HELMET.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)CURSIUM_HELMET.get(), Cataclysm_Armor.createArmorAttributes(Armortier.CURSIUM, (float)CMCommonConfig.CursiumArmor.armorMultiplier, (float)CMCommonConfig.CursiumArmor.toughness, (float)CMCommonConfig.CursiumArmor.knockbackResistance, ArmorType.HELMET, new AttributeContainer[0]));
            });
            event.modify((ItemLike)CURSIUM_CHESTPLATE.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)CURSIUM_CHESTPLATE.get(), Cataclysm_Armor.createArmorAttributes(Armortier.CURSIUM, (float)CMCommonConfig.CursiumArmor.armorMultiplier, (float)CMCommonConfig.CursiumArmor.toughness, (float)CMCommonConfig.CursiumArmor.knockbackResistance, ArmorType.CHESTPLATE, new AttributeContainer[0]));
            });
            event.modify((ItemLike)CURSIUM_LEGGINGS.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)CURSIUM_LEGGINGS.get(), Cataclysm_Armor.createArmorAttributes(Armortier.CURSIUM, (float)CMCommonConfig.CursiumArmor.armorMultiplier, (float)CMCommonConfig.CursiumArmor.toughness, (float)CMCommonConfig.CursiumArmor.knockbackResistance, ArmorType.LEGGINGS, new AttributeContainer[0]));
            });
            event.modify((ItemLike)CURSIUM_BOOTS.get(), (components, context, item) -> {
                components.set(DataComponents.UNBREAKABLE, Unit.INSTANCE);
                AttributeUtils.mergeAttributes(components, (Item)CURSIUM_BOOTS.get(), Cataclysm_Armor.createArmorAttributes(Armortier.CURSIUM, (float)CMCommonConfig.CursiumArmor.armorMultiplier, (float)CMCommonConfig.CursiumArmor.toughness, (float)CMCommonConfig.CursiumArmor.knockbackResistance, ArmorType.BOOTS, new AttributeContainer[0]));
            });
            event.modify((ItemLike)BONE_REPTILE_HELMET.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)BONE_REPTILE_HELMET.get(), Cataclysm_Armor.createArmorAttributes(Armortier.BONE_REPTILE, (float)CMCommonConfig.BoneReptileArmor.armorMultiplier, (float)CMCommonConfig.BoneReptileArmor.toughness, (float)CMCommonConfig.BoneReptileArmor.knockbackResistance, ArmorType.HELMET, new AttributeContainer[0])));
            event.modify((ItemLike)BONE_REPTILE_CHESTPLATE.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)BONE_REPTILE_CHESTPLATE.get(), Cataclysm_Armor.createArmorAttributes(Armortier.BONE_REPTILE, (float)CMCommonConfig.BoneReptileArmor.armorMultiplier, (float)CMCommonConfig.BoneReptileArmor.toughness, (float)CMCommonConfig.BoneReptileArmor.knockbackResistance, ArmorType.CHESTPLATE, new AttributeContainer[0])));
            event.modify((ItemLike)BLOOM_STONE_PAULDRONS.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)BLOOM_STONE_PAULDRONS.get(), Cataclysm_Armor.createArmorAttributes(Armortier.CRAB, (float)CMCommonConfig.BloomStoneArmor.armorMultiplier, (float)CMCommonConfig.BloomStoneArmor.toughness, (float)CMCommonConfig.BloomStoneArmor.knockbackResistance, ArmorType.CHESTPLATE, new AttributeContainer[0])));
            event.modify((ItemLike)GAUNTLET_OF_BULWARK.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)GAUNTLET_OF_BULWARK.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.GauntletOfBulwark.attackDamage, -4.0f + (float)CMCommonConfig.GauntletOfBulwark.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)GAUNTLET_OF_GUARD.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)GAUNTLET_OF_GUARD.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.GauntletOfGuard.attackDamage, -4.0f + (float)CMCommonConfig.GauntletOfGuard.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)GAUNTLET_OF_MAELSTROM.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)GAUNTLET_OF_MAELSTROM.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.GauntletOfMaelstrom.attackDamage, -4.0f + (float)CMCommonConfig.GauntletOfMaelstrom.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)MEAT_SHREDDER.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)MEAT_SHREDDER.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.MeatShredder.attackDamage, -4.0f + (float)CMCommonConfig.MeatShredder.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)SOUL_RENDER.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)SOUL_RENDER.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.SoulRender.attackDamage, -4.0f + (float)CMCommonConfig.SoulRender.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)CERAUNUS.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)CERAUNUS.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.Ceraunus.attackDamage, -4.0f + (float)CMCommonConfig.Ceraunus.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)THE_ANNIHILATOR.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)THE_ANNIHILATOR.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.Annihilator.attackDamage, -4.0f + (float)CMCommonConfig.Annihilator.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)THE_IMMOLATOR.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)THE_IMMOLATOR.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.Immolator.attackDamage, -4.0f + (float)CMCommonConfig.Immolator.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)ASTRAPE.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)ASTRAPE.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.Astrape.attackDamage, -4.0f + (float)CMCommonConfig.Astrape.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)THE_INCINERATOR.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)THE_INCINERATOR.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.Incinerator.attackDamage, -4.0f + (float)CMCommonConfig.Incinerator.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)INFERNAL_FORGE.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)INFERNAL_FORGE.get(), toolAttributes(Tooltier.MONSTROSITY, -4.0F + (float)CMCommonConfig.InfernalForge.attackDamage, -4.0F + (float)CMCommonConfig.InfernalForge.attackSpeed)));
            event.modify((ItemLike)TIDAL_CLAWS.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)TIDAL_CLAWS.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.TidalClaws.attackDamage, -4.0f + (float)CMCommonConfig.TidalClaws.attackSpeed, new AttributeContainer[0])));
            event.modify((ItemLike)BRONTES.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)BRONTES.get(), toolAttributes(Tooltier.MONSTROSITY, -4.0F + (float)CMCommonConfig.Brontes.attackDamage, -4.0F + (float)CMCommonConfig.Brontes.attackSpeed)));
            event.modify((ItemLike)VOID_FORGE.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)VOID_FORGE.get(), toolAttributes(Tooltier.MONSTROSITY, -4.0F + (float)CMCommonConfig.VoidForge.attackDamage, -4.0F + (float)CMCommonConfig.VoidForge.attackSpeed)));
            event.modify((ItemLike)ANCIENT_SPEAR.get(), (components, context, item) -> AttributeUtils.mergeAttributes(components, (Item)ANCIENT_SPEAR.get(), Cataclysm_Weapon.createAttributes(-1.0f + (float)CMCommonConfig.AncientSpear.attackDamage, -4.0f + (float)CMCommonConfig.AncientSpear.attackSpeed, new AttributeContainer[0])));
        }
    }
}

