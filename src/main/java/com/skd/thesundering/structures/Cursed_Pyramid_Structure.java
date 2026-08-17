/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.entity.BlockEntityType
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$StructureSettings
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.StructureType
 *  net.minecraft.world.level.levelgen.structure.TemplateStructurePiece
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 */
package com.skd.thesundering.structures;

import com.skd.thesundering.entity.AnimationMonster.Koboleton_Entity;
import com.skd.thesundering.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.skd.thesundering.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.skd.thesundering.entity.InternalAnimationMonster.Wadjet_Entity;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModStructures;
import com.skd.thesundering.structures.CataclysmStructure;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class Cursed_Pyramid_Structure
extends CataclysmStructure {
    public static final MapCodec<Cursed_Pyramid_Structure> CODEC = Cursed_Pyramid_Structure.simpleCodec(Cursed_Pyramid_Structure::new);
    private static final Identifier LOWER1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_lower1");
    private static final Identifier LOWER2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_lower2");
    private static final Identifier LOWER3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_lower3");
    private static final Identifier LOWER4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_lower4");
    private static final Identifier UPPER1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_upper1");
    private static final Identifier UPPER2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_upper2");
    private static final Identifier UPPER3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_upper3");
    private static final Identifier UPPER4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_upper4");
    private static final Identifier OBELISK1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_obelisk1");
    private static final Identifier OBELISK2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid_obelisk2");
    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.builder().put((Object)LOWER1, (Object)new BlockPos(0, 1, 0)).put((Object)LOWER2, (Object)new BlockPos(0, 1, 0)).put((Object)LOWER3, (Object)new BlockPos(0, 1, 0)).put((Object)LOWER4, (Object)new BlockPos(0, 1, 0)).put((Object)UPPER1, (Object)new BlockPos(0, 1, 0)).put((Object)UPPER2, (Object)new BlockPos(0, 1, 0)).put((Object)UPPER3, (Object)new BlockPos(0, 1, 0)).put((Object)UPPER4, (Object)new BlockPos(0, 1, 0)).put((Object)OBELISK1, (Object)new BlockPos(0, 1, 0)).put((Object)OBELISK2, (Object)new BlockPos(0, 1, 0)).build();

    public Cursed_Pyramid_Structure(Structure.StructureSettings p_227593_) {
        super(p_227593_);
    }

    private static BlockPos posToSurface(ChunkGenerator generator, BlockPos pos, LevelHeightAccessor heightAccessor, RandomState state) {
        int surfaceY = generator.getBaseHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightAccessor, state);
        return new BlockPos(pos.getX(), surfaceY - 1, pos.getZ());
    }

    @Override
    public void generatePieces(StructurePiecesBuilder builder, Structure.GenerationContext context) {
        StructureTemplateManager templateManager = context.structureTemplateManager();
        Rotation rotation = Rotation.values()[context.random().nextInt(Rotation.values().length)];
        int x = (context.chunkPos().x << 4) + 7;
        int z = (context.chunkPos().z << 4) + 7;
        BlockPos centerPos = new BlockPos(x, 1, z);
        ChunkGenerator generator = context.chunkGenerator();
        LevelHeightAccessor heightLimitView = context.heightAccessor();
        int surfaceY = generator.getBaseHeight(centerPos.getX(), centerPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightLimitView, context.randomState());
        int oceanFloorY = generator.getBaseHeight(centerPos.getX(), centerPos.getZ(), Heightmap.Types.OCEAN_FLOOR_WG, heightLimitView, context.randomState());
        if (oceanFloorY < surfaceY) {
            return;
        }
        BlockPos spawncenterPos = Cursed_Pyramid_Structure.posToSurface(generator, centerPos, heightLimitView, context.randomState());
        BlockPos obelisk1Offset = spawncenterPos.offset((Vec3i)new BlockPos(20, -4, 94).rotate(rotation));
        BlockPos obelisk2Offset = spawncenterPos.offset((Vec3i)new BlockPos(45, -4, 94).rotate(rotation));
        BlockPos lower1Offset = spawncenterPos.offset(0, -39, 0);
        BlockPos lower2Offset = spawncenterPos.offset((Vec3i)new BlockPos(0, -39, 47).rotate(rotation));
        BlockPos lower3Offset = spawncenterPos.offset((Vec3i)new BlockPos(47, -39, 0).rotate(rotation));
        BlockPos lower4Offset = spawncenterPos.offset((Vec3i)new BlockPos(47, -39, 47).rotate(rotation));
        BlockPos upper1Offset = spawncenterPos.offset(0, 9, 0);
        BlockPos upper2Offset = spawncenterPos.offset((Vec3i)new BlockPos(0, 9, 47).rotate(rotation));
        BlockPos upper3Offset = spawncenterPos.offset((Vec3i)new BlockPos(47, 9, 0).rotate(rotation));
        BlockPos upper4Offset = spawncenterPos.offset((Vec3i)new BlockPos(47, 9, 47).rotate(rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, LOWER1, lower1Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, LOWER2, lower2Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, LOWER3, lower3Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, LOWER4, lower4Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, UPPER1, upper1Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, UPPER2, upper2Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, UPPER3, upper3Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, UPPER4, upper4Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, OBELISK1, obelisk1Offset, rotation));
        builder.addPiece((StructurePiece)new Piece(templateManager, OBELISK2, obelisk2Offset, rotation));
    }

    public StructureType<?> type() {
        return (StructureType)ModStructures.CURSED_PYRAMID.get();
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece
    extends TemplateStructurePiece {
        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, Rotation rotation) {
            super((StructurePieceType)ModStructures.CPD.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), Piece.makeSettings(rotation), Piece.makecenterPos(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound) {
            super((StructurePieceType)ModStructures.CPD.get(), tagCompound, templateManagerIn, p_162451_ -> Piece.makeSettings(Rotation.valueOf((String)tagCompound.getString("Rot"))));
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlaceSettings makeSettings(Rotation p_163156_) {
            BlockIgnoreProcessor blockignoreprocessor = BlockIgnoreProcessor.STRUCTURE_BLOCK;
            StructurePlaceSettings structureplacesettings = new StructurePlaceSettings().setRotation(p_163156_).setMirror(Mirror.NONE).addProcessor((StructureProcessor)blockignoreprocessor).setLiquidSettings(LiquidSettings.IGNORE_WATERLOGGING).addProcessor((StructureProcessor)new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE));
            return structureplacesettings;
        }

        private static BlockPos makecenterPos(Identifier p_162453_, BlockPos p_162454_) {
            return p_162454_.offset((Vec3i)OFFSET.get(p_162453_));
        }

        protected void addAdditionalSaveData(StructurePieceSerializationContext p_162444_, CompoundTag tagCompound) {
            super.addAdditionalSaveData(p_162444_, tagCompound);
            tagCompound.putString("Rot", this.placeSettings.getRotation().name());
        }

        protected void handleDataMarker(String function, BlockPos pos, ServerLevelAccessor worldIn, RandomSource rand, BoundingBox sbb) {
            switch (function) {
                case "necklace": {
                    worldIn.setBlock(pos, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 2);
                    worldIn.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent(blockEntity -> {
                        ResourceKey lootTableLocation = ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"archaeology/cursed_pyramid_necklace"));
                        blockEntity.setLootTable(lootTableLocation, pos.asLong());
                    });
                    break;
                }
                case "sus": {
                    worldIn.setBlock(pos, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 2);
                    worldIn.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent(blockEntity -> {
                        ResourceKey lootTableLocation = ResourceKey.create((ResourceKey)Registries.LOOT_TABLE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"archaeology/cursed_pyramid"));
                        blockEntity.setLootTable(lootTableLocation, pos.asLong());
                    });
                    break;
                }
                case "koboleton": {
                    Koboleton_Entity koboleton = (Koboleton_Entity)((EntityType)ModEntities.KOBOLETON.get()).create((Level)worldIn.getLevel());
                    if (koboleton == null) break;
                    koboleton.setPersistenceRequired();
                    koboleton.moveTo(pos, 0.0f, 0.0f);
                    koboleton.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(koboleton.blockPosition()), MobSpawnType.STRUCTURE, null);
                    worldIn.addFreshEntityWithPassengers((Entity)koboleton);
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    break;
                }
                case "wadjet": {
                    Wadjet_Entity wadjet = (Wadjet_Entity)((EntityType)ModEntities.WADJET.get()).create((Level)worldIn.getLevel());
                    if (wadjet == null) break;
                    wadjet.setPersistenceRequired();
                    wadjet.moveTo(pos, 0.0f, 0.0f);
                    wadjet.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(wadjet.blockPosition()), MobSpawnType.STRUCTURE, null);
                    worldIn.addFreshEntityWithPassengers((Entity)wadjet);
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    break;
                }
                case "kobolediator": {
                    Kobolediator_Entity kobolediator = (Kobolediator_Entity)((EntityType)ModEntities.KOBOLEDIATOR.get()).create((Level)worldIn.getLevel());
                    if (kobolediator == null) break;
                    kobolediator.setPersistenceRequired();
                    kobolediator.moveTo(pos, 0.0f, 0.0f);
                    kobolediator.setSleep(true);
                    kobolediator.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(kobolediator.blockPosition()), MobSpawnType.STRUCTURE, null);
                    worldIn.addFreshEntityWithPassengers((Entity)kobolediator);
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    break;
                }
                case "remnant": {
                    Ancient_Remnant_Entity remnant = (Ancient_Remnant_Entity)((EntityType)ModEntities.ANCIENT_REMNANT.get()).create((Level)worldIn.getLevel());
                    if (remnant == null) break;
                    remnant.setNecklace(false);
                    remnant.setPersistenceRequired();
                    remnant.moveTo(pos, 0.0f, 0.0f);
                    remnant.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(remnant.blockPosition()), MobSpawnType.STRUCTURE, null);
                    worldIn.addFreshEntityWithPassengers((Entity)remnant);
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                }
            }
        }
    }
}

