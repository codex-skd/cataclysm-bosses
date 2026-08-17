/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.StructureType
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.sundering.init;

import com.skd.sundering.structures.Burning_Arena_Structure;
import com.skd.sundering.structures.Cursed_Pyramid_Structure;
import com.skd.sundering.structures.RuinedCitadelStructure;
import com.skd.sundering.structures.Sunken_City_Structure;
import com.skd.sundering.structures.jisaw.CataclysmJigsawStructure;
import java.util.Locale;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStructures {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_DEF_REG = DeferredRegister.create((ResourceKey)Registries.STRUCTURE_PIECE, (String)"cataclysm");
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE_DEF_REG = DeferredRegister.create((ResourceKey)Registries.STRUCTURE_TYPE, (String)"cataclysm");
    public static final DeferredHolder<StructureType<?>, StructureType<RuinedCitadelStructure>> RUINED_CITADEL = STRUCTURE_TYPE_DEF_REG.register("ruined_citadel", () -> () -> RuinedCitadelStructure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<Burning_Arena_Structure>> BURNING_ARENA = STRUCTURE_TYPE_DEF_REG.register("burning_arena", () -> () -> Burning_Arena_Structure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<Sunken_City_Structure>> SUNKEN_CITY = STRUCTURE_TYPE_DEF_REG.register("sunken_city", () -> () -> Sunken_City_Structure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<Cursed_Pyramid_Structure>> CURSED_PYRAMID = STRUCTURE_TYPE_DEF_REG.register("cursed_pyramid", () -> () -> Cursed_Pyramid_Structure.CODEC);
    public static final DeferredHolder<StructureType<?>, StructureType<CataclysmJigsawStructure>> CATACLYSM_JIGSAW = STRUCTURE_TYPE_DEF_REG.register("cataclysm_jigsaw", () -> () -> CataclysmJigsawStructure.CODEC);
    public static final DeferredHolder<StructurePieceType, StructurePieceType> RCP = ModStructures.registerPieceType("ruined_citadel", RuinedCitadelStructure.Piece::new);
    public static final DeferredHolder<StructurePieceType, StructurePieceType> BAP = ModStructures.registerPieceType("burning_arena", Burning_Arena_Structure.Piece::new);
    public static final DeferredHolder<StructurePieceType, StructurePieceType> SCP = ModStructures.registerPieceType("sunken_city", Sunken_City_Structure.Piece::new);
    public static final DeferredHolder<StructurePieceType, StructurePieceType> CPD = ModStructures.registerPieceType("cursed_pyramid", Cursed_Pyramid_Structure.Piece::new);
    public static final ResourceKey<Structure> SOUL_BLACK_SMITH_KEY = ResourceKey.create((ResourceKey)Registries.STRUCTURE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"soul_black_smith"));
    public static final ResourceKey<Structure> RUINED_CITADEL_KEY = ResourceKey.create((ResourceKey)Registries.STRUCTURE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ruined_citadel"));
    public static final ResourceKey<Structure> BURNING_ARENA_KEY = ResourceKey.create((ResourceKey)Registries.STRUCTURE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"burning_arena"));
    public static final ResourceKey<Structure> ANCIENT_FACTORY_KEY = ResourceKey.create((ResourceKey)Registries.STRUCTURE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"ancient_factory"));
    public static final ResourceKey<Structure> CURSED_PYRAMID_KEY = ResourceKey.create((ResourceKey)Registries.STRUCTURE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"cursed_pyramid"));

    private static DeferredHolder<StructurePieceType, StructurePieceType> registerPieceType(String name, StructurePieceType structurePieceType) {
        return STRUCTURE_PIECE_DEF_REG.register(name.toLowerCase(Locale.ROOT), () -> structurePieceType);
    }
}

