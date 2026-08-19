/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationStub
 *  net.minecraft.world.level.levelgen.structure.Structure$StructureSettings
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.StructurePieceAccessor
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

import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModStructures;
import com.skd.thesundering.init.ModTag;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
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

public class Sunken_City_Structure
extends Structure {
    public static final MapCodec<Sunken_City_Structure> CODEC = Sunken_City_Structure.simpleCodec(Sunken_City_Structure::new);
    private static final Identifier CITY_MID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid");
    private static final Identifier CITY_LOWER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower");
    private static final Identifier CITY_UPPER = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_upper");
    private static final Identifier CITY_MID_EAST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_east");
    private static final Identifier CITY_MID_NORTH = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_north");
    private static final Identifier CITY_MID_SOUTH = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_south");
    private static final Identifier CITY_MID_WEST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_west");
    private static final Identifier CITY_MID_NORTHEAST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_northeast");
    private static final Identifier CITY_MID_NORTHWEST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_northwest");
    private static final Identifier CITY_MID_SOUTHEAST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_southeast");
    private static final Identifier CITY_MID_SOUTHWEST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_southwest");
    private static final Identifier CITY_LOWER_EAST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_east");
    private static final Identifier CITY_LOWER_NORTH = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_north");
    private static final Identifier CITY_LOWER_SOUTH = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_south");
    private static final Identifier CITY_LOWER_WEST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_west");
    private static final Identifier CITY_LOWER_NORTHEAST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_northeast");
    private static final Identifier CITY_LOWER_NORTHWEST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_northwest");
    private static final Identifier CITY_LOWER_SOUTHEAST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_southeast");
    private static final Identifier CITY_LOWER_SOUTHWEST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_southwest");
    private static final Identifier CITY_UPPER_TREASURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_upper_treasureroom");
    private static final Identifier CITY_LOWER_TREASURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_treasureroom");
    private static final Identifier CITY_ENTRANCE1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_entrance1");
    private static final Identifier CITY_ENTRANCE2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_entrance2");
    private static final Identifier CITY_ENTRANCE3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_entrance3");
    private static final Identifier CITY_ENTRANCE4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_entrance4");
    private static final Identifier CITY_TEMPLE1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_temple1");
    private static final Identifier CITY_TEMPLE2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_temple2");
    private static final Identifier CITY_UPPER_PRISON = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_upper_prison");
    private static final Identifier CITY_UPPERSIDE_PRISON = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_upperside_prison");
    private static final Identifier CITY_LOWER_PRISON = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lower_prison");
    private static final Identifier CITY_LOWERSIDE_PRISON = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_lowerside_prison");
    private static final Identifier CITY_MID_NORTH_SIDE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sunken_city_mid_north_side");
    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.builder().put((Object)CITY_MID, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_UPPER, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_EAST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_NORTH, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_SOUTH, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_WEST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_NORTHEAST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_NORTHWEST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_SOUTHEAST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_SOUTHWEST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_EAST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_NORTH, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_SOUTH, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_WEST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_NORTHEAST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_NORTHWEST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_SOUTHEAST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_SOUTHWEST, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_UPPER_TREASURE, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_TREASURE, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_ENTRANCE1, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_ENTRANCE2, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_ENTRANCE3, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_ENTRANCE4, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_TEMPLE1, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_TEMPLE2, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_UPPER_PRISON, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_UPPERSIDE_PRISON, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWER_PRISON, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_LOWERSIDE_PRISON, (Object)new BlockPos(0, 1, 0)).put((Object)CITY_MID_NORTH_SIDE, (Object)new BlockPos(0, 1, 0)).build();

    public static void start(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation, StructurePieceAccessor pieceList, RandomSource random) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_UPPER, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER, blockpos, rotation));
        rotationOffSet = new BlockPos(47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_EAST, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, -47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_NORTH, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_SOUTH, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_WEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, 0, -12).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_NORTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, 0, -47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_NORTHWEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_SOUTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_SOUTHWEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_EAST, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -38, -47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_NORTH, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_SOUTH, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_WEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, -38, -9).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_NORTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, -38, -47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_NORTHWEST, blockpos, rotation));
        rotationOffSet = new BlockPos(47, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_SOUTHEAST, blockpos, rotation));
        rotationOffSet = new BlockPos(-47, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_SOUTHWEST, blockpos, rotation));
        rotationOffSet = new BlockPos(-105, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_ENTRANCE1, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_ENTRANCE2, blockpos, rotation));
        rotationOffSet = new BlockPos(-105, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_ENTRANCE3, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_ENTRANCE4, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, 0, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_UPPER_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, -38, 47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-52, 0, 94).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_UPPERSIDE_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-52, -38, 94).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWERSIDE_PRISON, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, 0, -47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_UPPER_TREASURE, blockpos, rotation));
        rotationOffSet = new BlockPos(-94, -38, -47).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_LOWER_TREASURE, blockpos, rotation));
        rotationOffSet = new BlockPos(94, -38, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_TEMPLE1, blockpos, rotation));
        rotationOffSet = new BlockPos(94, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_TEMPLE2, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, -50).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITY_MID_NORTH_SIDE, blockpos, rotation));
    }

    public Sunken_City_Structure(Structure.StructureSettings p_227593_) {
        super(p_227593_);
    }

    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext p_228964_) {
        int i = p_228964_.chunkPos().getBlockX(9);
        int j = p_228964_.chunkPos().getBlockZ(9);
        for (Holder holder : p_228964_.biomeSource().getBiomesWithin(i, p_228964_.chunkGenerator().getSeaLevel(), j, 29, p_228964_.randomState().sampler())) {
            if (holder.is(ModTag.REQUIRED_SUNKEN_CITY_SURROUNDING)) continue;
            return Optional.empty();
        }
        return Sunken_City_Structure.onTopOfChunkCenter((Structure.GenerationContext)p_228964_, (Heightmap.Types)Heightmap.Types.OCEAN_FLOOR_WG, p_228967_ -> Sunken_City_Structure.generatePieces(p_228967_, p_228964_));
    }

    private static void generatePieces(StructurePiecesBuilder p_197233_, Structure.GenerationContext p_197234_) {
        int i = p_197234_.chunkPos().getMinBlockX();
        int j = p_197234_.chunkPos().getMinBlockZ();
        BlockPos blockpos = new BlockPos(i, 19, j);
        Rotation rotation = Rotation.getRandom((RandomSource)p_197234_.random());
        Sunken_City_Structure.start(p_197234_.structureTemplateManager(), blockpos, rotation, (StructurePieceAccessor)p_197233_, (RandomSource)p_197234_.random());
    }

    public StructureType<?> type() {
        return (StructureType)ModStructures.SUNKEN_CITY.get();
    }

    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece
    extends TemplateStructurePiece {
        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, Rotation rotation) {
            super((StructurePieceType)ModStructures.SCP.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), Piece.makeSettings(rotation), Piece.makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound) {
            super((StructurePieceType)ModStructures.SCP.get(), tagCompound, templateManagerIn, p_162451_ -> Piece.makeSettings(Rotation.valueOf((String)tagCompound.getString("Rot"))));
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlaceSettings makeSettings(Rotation p_163156_) {
            BlockIgnoreProcessor blockignoreprocessor = BlockIgnoreProcessor.STRUCTURE_BLOCK;
            StructurePlaceSettings structureplacesettings = new StructurePlaceSettings().setRotation(p_163156_).setMirror(Mirror.NONE).addProcessor((StructureProcessor)blockignoreprocessor).setLiquidSettings(LiquidSettings.IGNORE_WATERLOGGING).addProcessor((StructureProcessor)new ProtectedBlockProcessor(ModTag.SUNKEN_CITY_MATERIAL));
            return structureplacesettings;
        }

        private static BlockPos makePosition(Identifier p_162453_, BlockPos p_162454_) {
            return p_162454_.offset((Vec3i)OFFSET.get(p_162453_));
        }

        protected void addAdditionalSaveData(StructurePieceSerializationContext p_162444_, CompoundTag tagCompound) {
            super.addAdditionalSaveData(p_162444_, tagCompound);
            tagCompound.putString("Rot", this.placeSettings.getRotation().name());
        }

        protected void handleDataMarker(String function, BlockPos pos, ServerLevelAccessor worldIn, RandomSource rand, BoundingBox sbb) {
            ArrayList<Mob> list = new ArrayList<Mob>();
            switch (function) {
                case "deepling_brute": {
                    list.add((Mob)((EntityType)ModEntities.DEEPLING_BRUTE.get()).create((Level)worldIn.getLevel()));
                    break;
                }
                case "deepling_angler": {
                    list.add((Mob)((EntityType)ModEntities.DEEPLING_ANGLER.get()).create((Level)worldIn.getLevel()));
                    break;
                }
                case "deepling": {
                    list.add((Mob)((EntityType)ModEntities.DEEPLING.get()).create((Level)worldIn.getLevel()));
                    break;
                }
                case "sus": {
                    list.add((Mob)((EntityType)ModEntities.CORALSSUS.get()).create((Level)worldIn.getLevel()));
                    break;
                }
                case "deepling_priest": {
                    if (rand.nextBoolean()) {
                        list.add((Mob)((EntityType)ModEntities.DEEPLING_PRIEST.get()).create((Level)worldIn.getLevel()));
                        break;
                    }
                    list.add((Mob)((EntityType)ModEntities.DEEPLING_WARLOCK.get()).create((Level)worldIn.getLevel()));
                    break;
                }
                default: {
                    return;
                }
            }
            for (Mob mob : list) {
                mob.setPersistenceRequired();
                mob.moveTo(pos, 0.0f, 0.0f);
                mob.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(mob.blockPosition()), EntitySpawnReason.STRUCTURE, null);
                worldIn.addFreshEntityWithPassengers((Entity)mob);
                worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
            }
        }
    }
}

