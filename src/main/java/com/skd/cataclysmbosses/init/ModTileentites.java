/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.block.entity.BlockEntityType$Builder
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.blockentities.Abyssal_Egg_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAbyss_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAmethyst_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfFire_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfVoid_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Statue_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Statue_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Abyssal_Egg_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAbyss_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAmethyst_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfFire_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfVoid_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Statue_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAbyss_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfFire_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfVoid_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAmethyst_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Statue_Block_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
import com.skd.cataclysmbosses.blockentities.Abyssal_Egg_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAbyss_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfAmethyst_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfFire_Block_Entity;
import com.skd.cataclysmbosses.blockentities.AltarOfVoid_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Statue_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Cataclysm_Skull_BlockEntity;
import com.skd.cataclysmbosses.blockentities.Cursed_tombstone_Entity;
import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.blockentities.EMP_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.skd.cataclysmbosses.blockentities.ObsidianExplosionTrapBricks_Block_Entity;
import com.skd.cataclysmbosses.blockentities.SandstoneIgniteTrap_Block_Entity;
import com.skd.cataclysmbosses.blockentities.Statue_Block_Entity;
import com.skd.cataclysmbosses.init.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.Set;

public class ModTileentites {
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create((ResourceKey)Registries.BLOCK_ENTITY_TYPE, (String)"cataclysm");
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ObsidianExplosionTrapBricks_Block_Entity>> OBSIDIAN_EXPLOSION_TRAP_BRICKS = TILE_ENTITY_TYPES.register("obsidian_explosion_trap_bricks", () -> new BlockEntityType<>(ObsidianExplosionTrapBricks_Block_Entity::new, Set.of(ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SandstoneIgniteTrap_Block_Entity>> SANDSTONE_IGNITE_TRAP = TILE_ENTITY_TYPES.register("sandstone_ignite_trap", () -> new BlockEntityType<>(SandstoneIgniteTrap_Block_Entity::new, Set.of(ModBlocks.SANDSTONE_IGNITE_TRAP.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfVoid_Block_Entity>> ALTAR_OF_VOID = TILE_ENTITY_TYPES.register("altar_of_void", () -> new BlockEntityType<>(AltarOfVoid_Block_Entity::new, Set.of(ModBlocks.ALTAR_OF_VOID.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfFire_Block_Entity>> ALTAR_OF_FIRE = TILE_ENTITY_TYPES.register("altar_of_fire", () -> new BlockEntityType<>(AltarOfFire_Block_Entity::new, Set.of(ModBlocks.ALTAR_OF_FIRE.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfAmethyst_Block_Entity>> ALTAR_OF_AMETHYST = TILE_ENTITY_TYPES.register("altar_of_amethyst", () -> new BlockEntityType<>(AltarOfAmethyst_Block_Entity::new, Set.of(ModBlocks.ALTAR_OF_AMETHYST.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfAbyss_Block_Entity>> ALTAR_OF_ABYSS = TILE_ENTITY_TYPES.register("altar_of_abyss", () -> new BlockEntityType<>(AltarOfAbyss_Block_Entity::new, Set.of(ModBlocks.ALTAR_OF_ABYSS.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Cursed_tombstone_Entity>> CURSED_TOMBSTONE = TILE_ENTITY_TYPES.register("cursed_tombstone", () -> new BlockEntityType<>(Cursed_tombstone_Entity::new, Set.of(ModBlocks.CURSED_TOMBSTONE.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Abyssal_Egg_Block_Entity>> ABYSSAL_EGG = TILE_ENTITY_TYPES.register("abyssal_egg", () -> new BlockEntityType<>(Abyssal_Egg_Block_Entity::new, Set.of(ModBlocks.ABYSSAL_EGG.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EMP_Block_Entity>> EMP = TILE_ENTITY_TYPES.register("emp", () -> new BlockEntityType<>(EMP_Block_Entity::new, Set.of(ModBlocks.EMP.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Cataclysm_Skull_BlockEntity>> CATACLYSM_SKULL = TILE_ENTITY_TYPES.register("cataclysm_skull", () -> new BlockEntityType<>(Cataclysm_Skull_BlockEntity::new, Set.of(ModBlocks.KOBOLEDIATOR_SKULL.get(), ModBlocks.KOBOLEDIATOR_WALL_SKULL.get(), ModBlocks.APTRGANGR_HEAD.get(), ModBlocks.APTRGANGR_WALL_HEAD.get(), ModBlocks.DRAUGR_HEAD.get(), ModBlocks.DRAUGR_WALL_HEAD.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Mechanical_fusion_Anvil_Block_Entity>> MECHANICAL_FUSION_ANVIL = TILE_ENTITY_TYPES.register("mechanical_fusion_anvil", () -> new BlockEntityType<>(Mechanical_fusion_Anvil_Block_Entity::new, Set.of(ModBlocks.MECHANICAL_FUSION_ANVIL.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Door_Of_Seal_BlockEntity>> DOOR_OF_SEAL = TILE_ENTITY_TYPES.register("door_of_seal", () -> new BlockEntityType<>(Door_Of_Seal_BlockEntity::new, Set.of(ModBlocks.DOOR_OF_SEAL.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Statue_Block_Entity>> GODDESS_STATUE = TILE_ENTITY_TYPES.register("goddess_statue", () -> new BlockEntityType<>(Statue_Block_Entity::new, Set.of(ModBlocks.GODDESS_STATUE.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Boss_Respawn_Spawner_Block_Entity>> BOSS_RESPAWNER = TILE_ENTITY_TYPES.register("boss_respawner", () -> new BlockEntityType<>(Boss_Respawn_Spawner_Block_Entity::new, Set.of(ModBlocks.BOSS_RESPAWNER.get())));
}