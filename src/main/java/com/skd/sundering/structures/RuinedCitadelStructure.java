/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.Identifier
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.monster.Shulker
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.LegacyRandomSource
 *  net.minecraft.world.level.levelgen.WorldgenRandom
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
 *  net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 */
package com.skd.sundering.structures;

import com.skd.sundering.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.skd.sundering.init.ModEntities;
import com.skd.sundering.init.ModStructures;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
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
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class RuinedCitadelStructure
extends Structure {
    public static final MapCodec<RuinedCitadelStructure> CODEC = RuinedCitadelStructure.simpleCodec(RuinedCitadelStructure::new);
    private static final Identifier CITADEL1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel1");
    private static final Identifier CITADEL2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel2");
    private static final Identifier CITADEL3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel3");
    private static final Identifier CITADEL4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel4");
    private static final Identifier CITADEL5 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel5");
    private static final Identifier CITADEL6 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel6");
    private static final Identifier CITADEL7 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel7");
    private static final Identifier CITADEL8 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel8");
    private static final Identifier CITADEL9 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel9");
    private static final Identifier CITADEL10 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel10");
    private static final Identifier CITADEL11 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel11");
    private static final Identifier CITADEL12 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel12");
    private static final Identifier CITADEL13 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel13");
    private static final Identifier CITADEL14 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel14");
    private static final Identifier CITADEL15 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel15");
    private static final Identifier CITADEL16 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel16");
    private static final Identifier CITADEL17 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel17");
    private static final Identifier CITADEL18 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel18");
    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.builder().put((Object)CITADEL1, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL2, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL3, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL4, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL5, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL6, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL7, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL8, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL9, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL10, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL11, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL12, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL13, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL14, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL15, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL16, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL17, (Object)new BlockPos(0, 1, 0)).put((Object)CITADEL18, (Object)new BlockPos(0, 1, 0)).build();

    public static void start(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation, StructurePieceAccessor pieceList, RandomSource random) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotationOffSet = new BlockPos(0, -45, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL5, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL14, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -45, 37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL6, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, 37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL15, blockpos, rotation));
        rotationOffSet = new BlockPos(0, -45, -37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL4, blockpos, rotation));
        rotationOffSet = new BlockPos(0, 0, -37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL13, blockpos, rotation));
        rotationOffSet = new BlockPos(-36, -45, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL2, blockpos, rotation));
        rotationOffSet = new BlockPos(-36, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL11, blockpos, rotation));
        rotationOffSet = new BlockPos(36, -45, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL8, blockpos, rotation));
        rotationOffSet = new BlockPos(36, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL17, blockpos, rotation));
        rotationOffSet = new BlockPos(-36, -45, -37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL1, blockpos, rotation));
        rotationOffSet = new BlockPos(-36, 0, -37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL10, blockpos, rotation));
        rotationOffSet = new BlockPos(-36, -45, 37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL3, blockpos, rotation));
        rotationOffSet = new BlockPos(-36, 0, 37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL12, blockpos, rotation));
        rotationOffSet = new BlockPos(36, -45, 37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL9, blockpos, rotation));
        rotationOffSet = new BlockPos(36, 0, 37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL18, blockpos, rotation));
        rotationOffSet = new BlockPos(36, -45, -37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL7, blockpos, rotation));
        rotationOffSet = new BlockPos(36, 0, -37).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, CITADEL16, blockpos, rotation));
    }

    public RuinedCitadelStructure(Structure.StructureSettings p_227593_) {
        super(p_227593_);
    }

    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext p_228964_) {
        int i = p_228964_.chunkPos().x >> 16;
        int j = p_228964_.chunkPos().z >> 16;
        WorldgenRandom worldgenrandom = new WorldgenRandom((RandomSource)new LegacyRandomSource(0L));
        worldgenrandom.setSeed((long)(i ^ j << 9) ^ p_228964_.seed());
        worldgenrandom.nextInt();
        return RuinedCitadelStructure.onTopOfChunkCenter((Structure.GenerationContext)p_228964_, (Heightmap.Types)Heightmap.Types.WORLD_SURFACE_WG, p_228967_ -> RuinedCitadelStructure.generatePieces(p_228967_, p_228964_));
    }

    private static void generatePieces(StructurePiecesBuilder p_197233_, Structure.GenerationContext p_197234_) {
        BlockPos blockpos = new BlockPos(p_197234_.chunkPos().getMinBlockX(), 53, p_197234_.chunkPos().getMinBlockZ());
        Rotation rotation = Rotation.getRandom((RandomSource)p_197234_.random());
        RuinedCitadelStructure.start(p_197234_.structureTemplateManager(), blockpos, rotation, (StructurePieceAccessor)p_197233_, (RandomSource)p_197234_.random());
    }

    public StructureType<?> type() {
        return (StructureType)ModStructures.RUINED_CITADEL.get();
    }

    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece
    extends TemplateStructurePiece {
        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, Rotation rotation) {
            super((StructurePieceType)ModStructures.RCP.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), Piece.makeSettings(rotation), Piece.makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound) {
            super((StructurePieceType)ModStructures.RCP.get(), tagCompound, templateManagerIn, p_162451_ -> Piece.makeSettings(Rotation.valueOf((String)tagCompound.getString("Rot"))));
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlaceSettings makeSettings(Rotation p_163156_) {
            BlockIgnoreProcessor blockignoreprocessor = BlockIgnoreProcessor.STRUCTURE_BLOCK;
            StructurePlaceSettings structureplacesettings = new StructurePlaceSettings().setRotation(p_163156_).setMirror(Mirror.NONE).addProcessor((StructureProcessor)blockignoreprocessor).addProcessor((StructureProcessor)new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE));
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
            if (sbb.isInside((Vec3i)pos) && Level.isInSpawnableBounds((BlockPos)pos)) {
                if (function.startsWith("sentry")) {
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    Shulker shulker = (Shulker)EntityType.SHULKER.create((Level)worldIn.getLevel());
                    shulker.setPos((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5);
                    worldIn.addFreshEntity((Entity)shulker);
                } else if (function.startsWith("mimic")) {
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    Shulker Silentshulkerentity = (Shulker)EntityType.SHULKER.create((Level)worldIn.getLevel());
                    Silentshulkerentity.setPos((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5);
                    Silentshulkerentity.setSilent(true);
                    worldIn.addFreshEntity((Entity)Silentshulkerentity);
                } else if ("golem".equals(function)) {
                    Ender_Golem_Entity golem = (Ender_Golem_Entity)((EntityType)ModEntities.ENDER_GOLEM.get()).create((Level)worldIn.getLevel());
                    worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    golem.moveTo(pos, 180.0f, 180.0f);
                    worldIn.addFreshEntity((Entity)golem);
                }
            }
        }
    }
}

