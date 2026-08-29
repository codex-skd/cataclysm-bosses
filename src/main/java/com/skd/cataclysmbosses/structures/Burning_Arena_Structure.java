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
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.levelgen.GenerationStep$Decoration
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
package com.skd.cataclysmbosses.structures;

import net.minecraft.world.entity.EntitySpawnReason;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.skd.cataclysmbosses.init.ModEntities;
import com.skd.cataclysmbosses.init.ModStructures;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
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

public class Burning_Arena_Structure
extends Structure {
    public static final MapCodec<Burning_Arena_Structure> CODEC = Burning_Arena_Structure.simpleCodec(Burning_Arena_Structure::new);
    private static final Identifier ARENA1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena1");
    private static final Identifier ARENA2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena2");
    private static final Identifier ARENA3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena3");
    private static final Identifier ARENA4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena4");
    private static final Identifier ARENA5 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena5");
    private static final Identifier ARENA6 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena6");
    private static final Identifier ARENA7 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena7");
    private static final Identifier ARENA8 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena8");
    private static final Map<Identifier, BlockPos> OFFSET = ImmutableMap.<Identifier, BlockPos>builder().put(ARENA1, new BlockPos(0, 1, 0)).put(ARENA2, new BlockPos(0, 1, 0)).put(ARENA3, new BlockPos(0, 1, 0)).put(ARENA4, new BlockPos(0, 1, 0)).put(ARENA5, new BlockPos(0, 1, 0)).put(ARENA6, new BlockPos(0, 1, 0)).put(ARENA7, new BlockPos(0, 1, 0)).put(ARENA8, new BlockPos(0, 1, 0)).build();

    public static void start(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation, StructurePieceAccessor pieceList, RandomSource random, RegistryAccess registryAccess) {
        int x = pos.getX();
        int z = pos.getZ();
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA1, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(0, 0, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA2, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA3, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(47, 0, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA4, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(0, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA5, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(0, 48, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA6, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(47, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA7, blockpos, rotation, registryAccess));
        rotationOffSet = new BlockPos(47, 48, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece((StructurePiece)new Piece(templateManager, ARENA8, blockpos, rotation, registryAccess));
    }

    public Burning_Arena_Structure(Structure.StructureSettings p_227593_) {
        super(p_227593_);
    }

    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext p_228964_) {
        int i = p_228964_.chunkPos().x() >> 16;
        int j = p_228964_.chunkPos().z() >> 16;
        BlockPos blockpos = new BlockPos(p_228964_.chunkPos().getMinBlockX(), 21, p_228964_.chunkPos().getMinBlockZ());
        WorldgenRandom worldgenrandom = new WorldgenRandom((RandomSource)new LegacyRandomSource(0L));
        worldgenrandom.setSeed((long)(i ^ j << 9) ^ p_228964_.seed());
        worldgenrandom.nextInt();
        return Optional.of(new Structure.GenerationStub(blockpos, p_228526_ -> Burning_Arena_Structure.generatePieces(p_228526_, p_228964_)));
    }

    private static void generatePieces(StructurePiecesBuilder p_197233_, Structure.GenerationContext p_197234_) {
        BlockPos blockpos = new BlockPos(p_197234_.chunkPos().getMinBlockX(), 21, p_197234_.chunkPos().getMinBlockZ());
        Rotation rotation = Rotation.getRandom((RandomSource)p_197234_.random());
        Burning_Arena_Structure.start(p_197234_.structureTemplateManager(), blockpos, rotation, (StructurePieceAccessor)p_197233_, (RandomSource)p_197234_.random(), p_197234_.registryAccess());
    }

    public StructureType<?> type() {
        return (StructureType)ModStructures.BURNING_ARENA.get();
    }

    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece
    extends TemplateStructurePiece {
        public Piece(StructureTemplateManager templateManagerIn, Identifier resourceLocationIn, BlockPos pos, Rotation rotation, RegistryAccess registryAccess) {
            super((StructurePieceType)ModStructures.BAP.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), Piece.makeSettings(rotation, registryAccess), Piece.makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound, RegistryAccess registryAccess) {
            super((StructurePieceType)ModStructures.BAP.get(), tagCompound, templateManagerIn, p_162451_ -> Piece.makeSettings(Rotation.valueOf(tagCompound.getStringOr("Rot", "NONE")), registryAccess));
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag tag) {
            this(context.structureTemplateManager(), tag, context.registryAccess());
        }

        private static StructurePlaceSettings makeSettings(Rotation p_163156_, RegistryAccess registryAccess) {
            BlockIgnoreProcessor blockignoreprocessor = BlockIgnoreProcessor.STRUCTURE_BLOCK;
            StructurePlaceSettings structureplacesettings = new StructurePlaceSettings().setRotation(p_163156_).setMirror(Mirror.NONE).addProcessor((StructureProcessor)blockignoreprocessor).addProcessor((StructureProcessor)new ProtectedBlockProcessor(registryAccess.getOrThrow(BlockTags.FEATURES_CANNOT_REPLACE)));
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
            if ("revenant".equals(function)) {
                worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                Ignited_Revenant_Entity revenant = (Ignited_Revenant_Entity)((EntityType)ModEntities.IGNITED_REVENANT.get()).create((Level)worldIn.getLevel(), EntitySpawnReason.STRUCTURE);
                revenant.setPos((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5);
                revenant.setYRot(180.0f);
                revenant.setXRot(180.0f);
                worldIn.addFreshEntity((Entity)revenant);
            }
        }
    }
}

