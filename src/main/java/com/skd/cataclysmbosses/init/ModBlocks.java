/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.SlabBlock
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.WallBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockBehaviour$OffsetType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.neoforged.neoforge.registries.DeferredBlock
 *  net.neoforged.neoforge.registries.DeferredRegister
 *  net.neoforged.neoforge.registries.DeferredRegister$Blocks
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.blocks.Abyssal_Egg_Block;
import com.skd.cataclysmbosses.blocks.Altar_Of_Abyss_Block;
import com.skd.cataclysmbosses.blocks.Altar_Of_Amethyst_Block;
import com.skd.cataclysmbosses.blocks.Altar_Of_Fire_Block;
import com.skd.cataclysmbosses.blocks.Altar_Of_Void_Block;
import com.skd.cataclysmbosses.blocks.Boss_Respawn_Spawner_Block;
import com.skd.cataclysmbosses.blocks.CMWoodTypes;
import com.skd.cataclysmbosses.blocks.Cataclysm_Skull_Block;
import com.skd.cataclysmbosses.blocks.Cataclysm_Wall_Skull_Block;
import com.skd.cataclysmbosses.blocks.Cursed_Tombstone_Block;
import com.skd.cataclysmbosses.blocks.Door_of_Seal_Block;
import com.skd.cataclysmbosses.blocks.EMP_Block;
import com.skd.cataclysmbosses.blocks.EndStoneTeleportTrapBricks;
import com.skd.cataclysmbosses.blocks.FacingBlock;
import com.skd.cataclysmbosses.blocks.FacingPillarBlock;
import com.skd.cataclysmbosses.blocks.Ink_Mural_Block;
import com.skd.cataclysmbosses.blocks.Mechanical_fusion_Anvil;
import com.skd.cataclysmbosses.blocks.Mural_Block;
import com.skd.cataclysmbosses.blocks.ObsidianExplosionTrapBricks;
import com.skd.cataclysmbosses.blocks.PointedIcicleBlock;
import com.skd.cataclysmbosses.blocks.Property.CustomNoteBlockInstrument;
import com.skd.cataclysmbosses.blocks.PurpurVoidRuneTrapBlock;
import com.skd.cataclysmbosses.blocks.Sandstone_Falling_Trap;
import com.skd.cataclysmbosses.blocks.Sandstone_Ignite_Trap;
import com.skd.cataclysmbosses.blocks.Sandstone_Poison_Dart_Trap;
import com.skd.cataclysmbosses.blocks.Statue_Block;
import java.util.function.ToIntFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks((String)"cataclysm");
    public static final DeferredBlock<Block> WITHERITE_BLOCK = BLOCKS.registerBlock("witherite_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(50.0f, 1200.0f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK));
    public static final DeferredBlock<Block> ENDERRITE_BLOCK = BLOCKS.registerBlock("enderite_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(50.0f, 1200.0f).sound(SoundType.NETHERITE_BLOCK));
    public static final DeferredBlock<Block> IGNITIUM_BLOCK = BLOCKS.registerBlock("ignitium_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(50.0f, 1200.0f).sound(SoundType.NETHERITE_BLOCK).lightLevel(state -> 15));
    public static final DeferredBlock<Block> ANCIENT_METAL_BLOCK = BLOCKS.registerBlock("ancient_metal_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(25.0f, 600.0f).sound(SoundType.METAL));
    public static final DeferredBlock<Block> CURSIUM_BLOCK = BLOCKS.registerBlock("cursium_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(50.0f, 1200.0f).sound(SoundType.METAL));
    public static final DeferredBlock<Block> POLISHED_END_STONE = BLOCKS.registerBlock("polished_end_stone", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.END_STONE));
    public static final DeferredBlock<Block> POLISHED_END_STONE_SLAB = BLOCKS.registerBlock("polished_end_stone_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_END_STONE.get())));
    public static final DeferredBlock<Block> POLISHED_END_STONE_STAIRS = BLOCKS.registerBlock("polished_end_stone_stairs", props -> new StairBlock(((Block)POLISHED_END_STONE.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_END_STONE.get())));
    public static final DeferredBlock<Block> CHISELED_END_STONE_BRICKS = BLOCKS.registerBlock("chiseled_end_stone_bricks", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.END_STONE_BRICKS));
    public static final DeferredBlock<Block> VOID_INFUSED_END_STONE_BRICKS = BLOCKS.registerBlock("void_infused_end_stone_bricks", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.END_STONE_BRICKS).lightLevel(state -> 7));
    public static final DeferredBlock<Block> VOID_STONE = BLOCKS.registerBlock("void_stone", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(50.0f, 1200.0f).lightLevel(state -> 7));
    public static final DeferredBlock<Block> VOID_CRYSTAL = BLOCKS.registerBlock("void_crystal", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.GLASS).requiresCorrectToolForDrops().strength(50.0f, 1200.0f).lightLevel(state -> 7));
    public static final DeferredBlock<Block> VOID_LANTERN_BLOCK = BLOCKS.registerBlock("void_lantern_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).sound(SoundType.GLASS).requiresCorrectToolForDrops().strength(50.0f, 1200.0f).lightLevel(state -> 15));
    public static final DeferredBlock<Block> END_STONE_PILLAR = BLOCKS.registerBlock("end_stone_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.SAND).requiresCorrectToolForDrops().strength(3.0f, 9.0f));
    public static final DeferredBlock<Block> PURPUR_TILES = BLOCKS.registerBlock("purpur_tiles", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PURPUR_BLOCK));
    public static final DeferredBlock<Block> PURPUR_TILE_SLAB = BLOCKS.registerBlock("purpur_tile_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)PURPUR_TILES.get())));
    public static final DeferredBlock<Block> PURPUR_TILE_STAIRS = BLOCKS.registerBlock("purpur_tile_stairs", props -> new StairBlock(((Block)PURPUR_TILES.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)PURPUR_TILES.get())));
    public static final DeferredBlock<Block> PURPUR_TILE_WALL = BLOCKS.registerBlock("purpur_tile_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)PURPUR_TILES.get())));
    public static final DeferredBlock<Block> VOID_PURPUR_TILES = BLOCKS.registerBlock("void_purpur_tiles", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PURPUR_BLOCK));
    public static final DeferredBlock<Block> PURPUR_TILE_PILLAR = BLOCKS.registerBlock("purpur_tile_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PURPUR_BLOCK));
    public static final DeferredBlock<Block> CHISELED_PURPUR_BLOCK = BLOCKS.registerBlock("chiseled_purpur_block", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PURPUR_BLOCK));
    public static final DeferredBlock<Block> OBSIDIAN_BRICKS = BLOCKS.registerBlock("obsidian_bricks", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.OBSIDIAN));
    public static final DeferredBlock<Block> OBSIDIAN_PILLAR = BLOCKS.registerBlock("obsidian_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.OBSIDIAN));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN = BLOCKS.registerBlock("polished_obsidian", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.OBSIDIAN));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN_SLAB = BLOCKS.registerBlock("polished_obsidian_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_OBSIDIAN.get())));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN_STAIRS = BLOCKS.registerBlock("polished_obsidian_stairs", props -> new StairBlock(((Block)POLISHED_OBSIDIAN.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_OBSIDIAN.get())));
    public static final DeferredBlock<Block> POLISHED_OBSIDIAN_WALL = BLOCKS.registerBlock("polished_obsidian_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_OBSIDIAN.get())));
    public static final DeferredBlock<Block> CHISELED_OBSIDIAN_BRICKS = BLOCKS.registerBlock("chiseled_obsidian_bricks", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)OBSIDIAN_BRICKS.get())));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_SLAB = BLOCKS.registerBlock("obsidian_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)OBSIDIAN_BRICKS.get())));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_STAIRS = BLOCKS.registerBlock("obsidian_brick_stairs", props -> new StairBlock(((Block)OBSIDIAN_BRICKS.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)OBSIDIAN_BRICKS.get())));
    public static final DeferredBlock<Block> OBSIDIAN_FENCE = BLOCKS.registerBlock("obsidian_fence", FenceBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)OBSIDIAN_BRICKS.get())));
    public static final DeferredBlock<Block> OBSIDIAN_BRICK_WALL = BLOCKS.registerBlock("obsidian_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)OBSIDIAN_BRICKS.get())));
    public static final DeferredBlock<Block> PURPUR_WALL = BLOCKS.registerBlock("purpur_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PURPUR_BLOCK));
    public static final DeferredBlock<Block> PURPUR_VOID_RUNE_TRAP_BLOCK = BLOCKS.registerBlock("purpur_void_rune_trap_block", PurpurVoidRuneTrapBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PURPUR_BLOCK).randomTicks().lightLevel(ModBlocks.getLightValueLit(7)));
    public static final DeferredBlock<Block> END_STONE_TELEPORT_TRAP_BRICKS = BLOCKS.registerBlock("end_stone_teleport_trap_bricks", EndStoneTeleportTrapBricks::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.END_STONE_BRICKS).randomTicks().lightLevel(ModBlocks.getLightValueLit(7)));
    public static final DeferredBlock<Block> OBSIDIAN_EXPLOSION_TRAP_BRICKS = BLOCKS.registerBlock("obsidian_explosion_trap_bricks", ObsidianExplosionTrapBricks::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)OBSIDIAN_BRICKS.get())).randomTicks().lightLevel(ModBlocks.getLightValueLit(7)));
    public static final DeferredBlock<Block> SANDSTONE_POISON_DART_TRAP = BLOCKS.registerBlock("sandstone_poison_dart_trap", Sandstone_Poison_Dart_Trap::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f));
    public static final DeferredBlock<Block> SANDSTONE_IGNITE_TRAP = BLOCKS.registerBlock("sandstone_ignite_trap", Sandstone_Ignite_Trap::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.SAND).randomTicks().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f));
    public static final DeferredBlock<Block> SANDSTONE_FALLING_TRAP = BLOCKS.registerBlock("sandstone_falling_trap", Sandstone_Falling_Trap::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.SAND).randomTicks().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f));
    public static final DeferredBlock<Block> ALTAR_OF_FIRE = BLOCKS.registerBlock("altar_of_fire", Altar_Of_Fire_Block::new, () -> BlockBehaviour.Properties.of().noOcclusion().lightLevel(block -> 7).strength(-1.0f, 3600000.0f).noLootTable().sound(SoundType.METAL));
    public static final DeferredBlock<Block> ALTAR_OF_VOID = BLOCKS.registerBlock("altar_of_void", Altar_Of_Void_Block::new, () -> BlockBehaviour.Properties.of().noOcclusion().lightLevel(block -> 7).strength(-1.0f, 3600000.0f).noLootTable().sound(SoundType.METAL));
    public static final DeferredBlock<Block> ALTAR_OF_AMETHYST = BLOCKS.registerBlock("altar_of_amethyst", Altar_Of_Amethyst_Block::new, () -> BlockBehaviour.Properties.of().noOcclusion().lightLevel(block -> 7).strength(-1.0f, 3600000.0f).noLootTable().sound(SoundType.STONE));
    public static final DeferredBlock<Block> ALTAR_OF_ABYSS = BLOCKS.registerBlock("altar_of_abyss", Altar_Of_Abyss_Block::new, () -> BlockBehaviour.Properties.of().noOcclusion().lightLevel(block -> 7).emissiveRendering(state -> true).strength(-1.0f, 3600000.0f).noLootTable().sound(SoundType.STONE));
    public static final DeferredBlock<Block> BOSS_RESPAWNER = BLOCKS.registerBlock("boss_respawner", Boss_Respawn_Spawner_Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion().strength(-1.0f, 3600000.0f).noLootTable().sound(SoundType.STONE));
    public static final DeferredBlock<Block> CURSED_TOMBSTONE = BLOCKS.registerBlock("cursed_tombstone", Cursed_Tombstone_Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion().strength(-1.0f, 3600000.0f).noLootTable().sound(SoundType.STONE));
    public static final DeferredBlock<Block> DUNGEON_BLOCK = BLOCKS.registerBlock("dungeon_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(-1.0f, 3600000.0f).noLootTable());
    public static final DeferredBlock<Block> EMP = BLOCKS.registerBlock("emp", EMP_Block::new, () -> BlockBehaviour.Properties.of().noOcclusion().lightLevel(block -> 7).noLootTable().strength(-1.0f, 3600000.0f).sound(SoundType.METAL));
    public static final DeferredBlock<Block> MECHANICAL_FUSION_ANVIL = BLOCKS.registerBlock("mechanical_fusion_anvil", Mechanical_fusion_Anvil::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(50.0f, 1200.0f).requiresCorrectToolForDrops().sound(SoundType.ANVIL));
    public static final DeferredBlock<Block> GODDESS_STATUE = BLOCKS.registerBlock("goddess_statue", Statue_Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).noOcclusion().strength(30.0f, 400.0f).sound(SoundType.STONE));
    public static final DeferredBlock<Block> DOOR_OF_SEAL = BLOCKS.registerBlock("door_of_seal", Door_of_Seal_Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion().dynamicShape().strength(-1.0f, 3600000.0f).noLootTable().requiresCorrectToolForDrops().sound(SoundType.METAL));
    public static final DeferredBlock<Block> KOBOLEDIATOR_SKULL = BLOCKS.registerBlock("kobolediator_skull", props -> new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, props), () -> BlockBehaviour.Properties.of().strength(1.0f).instrument(NoteBlockInstrument.CUSTOM_HEAD).pushReaction(PushReaction.DESTROY));
    // TODO 26.2: dropsLike(Block) removed from BlockBehaviour.Properties; wall skull drops need rework
    public static final DeferredBlock<Block> KOBOLEDIATOR_WALL_SKULL = BLOCKS.registerBlock("kobolediator_wall_skull", props -> new Cataclysm_Wall_Skull_Block(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, props), () -> BlockBehaviour.Properties.of().strength(1.0f).pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<Block> APTRGANGR_HEAD = BLOCKS.registerBlock("aptrgangr_head", props -> new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.APTRGANGR, props), () -> BlockBehaviour.Properties.of().strength(1.0f).instrument(NoteBlockInstrument.CUSTOM_HEAD).pushReaction(PushReaction.DESTROY));
    // TODO 26.2: dropsLike(Block) removed from BlockBehaviour.Properties; wall skull drops need rework
    public static final DeferredBlock<Block> APTRGANGR_WALL_HEAD = BLOCKS.registerBlock("aptrgangr_wall_head", props -> new Cataclysm_Wall_Skull_Block(Cataclysm_Skull_Block.Types.APTRGANGR, props), () -> BlockBehaviour.Properties.of().strength(1.0f).pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<Block> DRAUGR_HEAD = BLOCKS.registerBlock("draugr_head", props -> new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.DRAUGR, props), () -> BlockBehaviour.Properties.of().strength(1.0f).instrument(NoteBlockInstrument.CUSTOM_HEAD).pushReaction(PushReaction.DESTROY));
    // TODO 26.2: dropsLike(Block) removed from BlockBehaviour.Properties; wall skull drops need rework
    public static final DeferredBlock<Block> DRAUGR_WALL_HEAD = BLOCKS.registerBlock("draugr_wall_head", props -> new Cataclysm_Wall_Skull_Block(Cataclysm_Skull_Block.Types.DRAUGR, props), () -> BlockBehaviour.Properties.of().strength(1.0f).pushReaction(PushReaction.DESTROY));
    public static final DeferredBlock<Block> ABYSSAL_EGG = BLOCKS.registerBlock("abyssal_egg", Abyssal_Egg_Block::new, () -> BlockBehaviour.Properties.of().noOcclusion().lightLevel(block -> 1).pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_BLACK).emissiveRendering(state -> true).strength(3.0f, 9.0f).sound(SoundType.METAL));
    public static final DeferredBlock<Block> CHORUS_STEM = BLOCKS.registerBlock("chorus_stem", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> CHORUS_PLANKS = BLOCKS.registerBlock("chorus_planks", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(2.0f, 3.0f).instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> CHORUS_SLAB = BLOCKS.registerBlock("chorus_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)CHORUS_PLANKS.get())));
    public static final DeferredBlock<Block> CHORUS_STAIRS = BLOCKS.registerBlock("chorus_stairs", props -> new StairBlock(((Block)CHORUS_PLANKS.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)CHORUS_PLANKS.get())));
    public static final DeferredBlock<Block> CHORUS_FENCE = BLOCKS.registerBlock("chorus_fence", FenceBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)CHORUS_PLANKS.get())));
    public static final DeferredBlock<Block> CHORUS_TRAPDOOR = BLOCKS.registerBlock("chorus_trapdoor", props -> new TrapDoorBlock(CMWoodTypes.CHORUS, props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)CHORUS_PLANKS.get())).noOcclusion());
    public static final DeferredBlock<Block> PRISMARINE_BRICK_FENCE = BLOCKS.registerBlock("prismarine_brick_fence", FenceBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PRISMARINE_BRICKS));
    public static final DeferredBlock<Block> QUARTZ_BRICK_WALL = BLOCKS.registerBlock("quartz_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.QUARTZ_BRICKS));
    public static final DeferredBlock<Block> PRISMARINE_BRICK_WALL = BLOCKS.registerBlock("prismarine_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.PRISMARINE_BRICKS));
    public static final DeferredBlock<Block> STONE_PILLAR = BLOCKS.registerBlock("stone_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f));
    public static final DeferredBlock<Block> CHISELED_STONE_BRICK_PILLAR = BLOCKS.registerBlock("chiseled_stone_brick_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f));
    public static final DeferredBlock<Block> STONE_TILES = BLOCKS.registerBlock("stone_tiles", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f));
    public static final DeferredBlock<Block> FROSTED_STONE_BRICKS = BLOCKS.registerBlock("frosted_stone_bricks", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5f, 6.0f));
    public static final DeferredBlock<Block> FROSTED_STONE_BRICK_SLAB = BLOCKS.registerBlock("frosted_stone_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)FROSTED_STONE_BRICKS.get())));
    public static final DeferredBlock<Block> FROSTED_STONE_BRICK_STAIRS = BLOCKS.registerBlock("frosted_stone_brick_stairs", props -> new StairBlock(((Block)FROSTED_STONE_BRICKS.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)FROSTED_STONE_BRICKS.get())));
    public static final DeferredBlock<Block> FROSTED_STONE_BRICK_WALL = BLOCKS.registerBlock("frosted_stone_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)FROSTED_STONE_BRICKS.get())));
    public static final DeferredBlock<Block> BLACK_STEEL_BLOCK = BLOCKS.registerBlock("black_steel_block", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(25.0f, 600.0f).sound(SoundType.METAL));
    public static final DeferredBlock<Block> BLACK_STEEL_FENCE = BLOCKS.registerBlock("black_steel_fence", FenceBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)BLACK_STEEL_BLOCK.get())));
    public static final DeferredBlock<Block> BLACK_STEEL_WALL = BLOCKS.registerBlock("black_steel_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)BLACK_STEEL_BLOCK.get())));
    public static final DeferredBlock<Block> STONE_TILE_SLAB = BLOCKS.registerBlock("stone_tile_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)STONE_TILES.get())));
    public static final DeferredBlock<Block> STONE_TILE_STAIRS = BLOCKS.registerBlock("stone_tile_stairs", props -> new StairBlock(((Block)STONE_TILES.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)STONE_TILES.get())));
    public static final DeferredBlock<Block> STONE_TILE_WALL = BLOCKS.registerBlock("stone_tile_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)STONE_TILES.get())));
    public static final DeferredBlock<Block> POLISHED_SANDSTONE = BLOCKS.registerBlock("polished_sandstone", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)Blocks.SANDSTONE));
    public static final DeferredBlock<Block> BLACKSTONE_PILLAR = BLOCKS.registerBlock("blackstone_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 6.0f));
    public static final DeferredBlock<Block> AZURE_SEASTONE = BLOCKS.registerBlock("azure_seastone", Block::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0f, 6.0f));
    public static final DeferredBlock<Block> AZURE_SEASTONE_SLAB = BLOCKS.registerBlock("azure_seastone_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_STAIRS = BLOCKS.registerBlock("azure_seastone_stairs", props -> new StairBlock(((Block)AZURE_SEASTONE.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_WALL = BLOCKS.registerBlock("azure_seastone_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_FENCE = BLOCKS.registerBlock("azure_seastone_fence", FenceBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_TILES = BLOCKS.registerBlock("azure_seastone_tiles", FacingBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CHISELED_AZURE_SEASTONE = BLOCKS.registerBlock("chiseled_azure_seastone", FacingBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICKS = BLOCKS.registerBlock("azure_seastone_bricks", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICK_SLAB = BLOCKS.registerBlock("azure_seastone_brick_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE_BRICKS.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICK_STAIRS = BLOCKS.registerBlock("azure_seastone_brick_stairs", props -> new StairBlock(((Block)AZURE_SEASTONE_BRICKS.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE_BRICKS.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICK_WALL = BLOCKS.registerBlock("azure_seastone_brick_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE_BRICKS.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_EMPTY = BLOCKS.registerBlock("azure_seastone_mural_empty", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_CLAWDIAN = BLOCKS.registerBlock("azure_seastone_mural_clawdian", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_CINDARIA = BLOCKS.registerBlock("azure_seastone_mural_cindaria", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_HIPPOCAMTUS = BLOCKS.registerBlock("azure_seastone_mural_hippocamtus", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_URCHINKIN = BLOCKS.registerBlock("azure_seastone_mural_urchinkin", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_THUNDER = BLOCKS.registerBlock("azure_seastone_mural_thunder", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_SEA = BLOCKS.registerBlock("azure_seastone_mural_sea", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_UNDERWORLD = BLOCKS.registerBlock("azure_seastone_mural_underworld", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_HARVEST = BLOCKS.registerBlock("azure_seastone_mural_harvest", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_SMITHING = BLOCKS.registerBlock("azure_seastone_mural_smithing", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_WISDOM = BLOCKS.registerBlock("azure_seastone_mural_wisdom", Ink_Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_URCHINKIN = BLOCKS.registerBlock("curved_azure_seastone_urchinkin", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_1 = BLOCKS.registerBlock("curved_azure_seastone_cindaria_1", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_2 = BLOCKS.registerBlock("curved_azure_seastone_cindaria_2", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_3 = BLOCKS.registerBlock("curved_azure_seastone_cindaria_3", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_4 = BLOCKS.registerBlock("curved_azure_seastone_cindaria_4", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_1 = BLOCKS.registerBlock("curved_azure_seastone_hippocamtus_1", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_2 = BLOCKS.registerBlock("curved_azure_seastone_hippocamtus_2", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_3 = BLOCKS.registerBlock("curved_azure_seastone_hippocamtus_3", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_4 = BLOCKS.registerBlock("curved_azure_seastone_hippocamtus_4", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_1 = BLOCKS.registerBlock("curved_azure_seastone_clawdian_1", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_2 = BLOCKS.registerBlock("curved_azure_seastone_clawdian_2", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_3 = BLOCKS.registerBlock("curved_azure_seastone_clawdian_3", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_4 = BLOCKS.registerBlock("curved_azure_seastone_clawdian_4", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_1 = BLOCKS.registerBlock("curved_azure_seastone_scylla_1", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_2 = BLOCKS.registerBlock("curved_azure_seastone_scylla_2", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_3 = BLOCKS.registerBlock("curved_azure_seastone_scylla_3", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_4 = BLOCKS.registerBlock("curved_azure_seastone_scylla_4", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_5 = BLOCKS.registerBlock("curved_azure_seastone_scylla_5", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_6 = BLOCKS.registerBlock("curved_azure_seastone_scylla_6", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_7 = BLOCKS.registerBlock("curved_azure_seastone_scylla_7", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_8 = BLOCKS.registerBlock("curved_azure_seastone_scylla_8", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_9 = BLOCKS.registerBlock("curved_azure_seastone_scylla_9", Mural_Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE = BLOCKS.registerBlock("polished_azure_seastone", Block::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE_SLAB = BLOCKS.registerBlock("polished_azure_seastone_slab", SlabBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE_STAIRS = BLOCKS.registerBlock("polished_azure_seastone_stairs", props -> new StairBlock(((Block)POLISHED_AZURE_SEASTONE.get()).defaultBlockState(), props), () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)POLISHED_AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE_WALL = BLOCKS.registerBlock("polished_azure_seastone_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_PILLAR = BLOCKS.registerBlock("azure_seastone_pillar", RotatedPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> AZURE_SEASTONE_PILLAR_WALL = BLOCKS.registerBlock("azure_seastone_pillar_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CHISELED_AZURE_SEASTONE_PILLAR = BLOCKS.registerBlock("chiseled_azure_seastone_pillar", FacingPillarBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> CHISELED_AZURE_SEASTONE_PILLAR_WALL = BLOCKS.registerBlock("chiseled_azure_seastone_pillar_wall", WallBlock::new, () -> BlockBehaviour.Properties.ofFullCopy((BlockBehaviour)((BlockBehaviour)AZURE_SEASTONE.get())));
    public static final DeferredBlock<Block> POINTED_ICICLE = BLOCKS.registerBlock("pointed_icicle", PointedIcicleBlock::new, () -> BlockBehaviour.Properties.of().mapColor(MapColor.ICE).forceSolidOn().instrument(NoteBlockInstrument.CHIME).noOcclusion().randomTicks().sound(SoundType.GLASS).strength(0.5f).dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return state -> (Boolean)state.getValue((Property)BlockStateProperties.LIT) != false ? lightValue : 0;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
}

