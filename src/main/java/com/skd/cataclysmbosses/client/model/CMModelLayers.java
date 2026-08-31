/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.HumanoidArmorModel
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterLayerDefinitions
 */
package com.skd.cataclysmbosses.client.model;

import com.skd.cataclysmbosses.client.model.armor.Bloom_Stone_Pauldrons_Model;
import com.skd.cataclysmbosses.client.model.armor.Bone_Reptile_Armor_Model;
import com.skd.cataclysmbosses.client.model.armor.Cursium_Armor_Model;
import com.skd.cataclysmbosses.client.model.armor.Ignitium_Armor_Model;
import com.skd.cataclysmbosses.client.model.armor.Ignitium_Elytra_chestplate_Model;
import com.skd.cataclysmbosses.client.model.armor.MonstrousHelm_Model;
import com.skd.cataclysmbosses.client.model.block.AptrgangrHeadModel;
import com.skd.cataclysmbosses.client.model.block.DraugrHeadModel;
import com.skd.cataclysmbosses.client.model.block.KobolediatorHeadModel;
import com.skd.cataclysmbosses.client.model.entity.Ancient_Remnant_Rework_Model;
import com.skd.cataclysmbosses.client.model.entity.Aptrgangr_Model;
import com.skd.cataclysmbosses.client.model.entity.Ceraunus_Model;
import com.skd.cataclysmbosses.client.model.entity.Cindaria_Model;
import com.skd.cataclysmbosses.client.model.entity.Clawdian_Model;
import com.skd.cataclysmbosses.client.model.entity.Draugr_Model;
import com.skd.cataclysmbosses.client.model.entity.Drowned_Host_Model;
import com.skd.cataclysmbosses.client.model.entity.Elemental_Spear_Model;
import com.skd.cataclysmbosses.client.model.entity.Elite_Draugr_Model;
import com.skd.cataclysmbosses.client.model.entity.Flare_Bomb_Model;
import com.skd.cataclysmbosses.client.model.entity.Hippocamtus_Model;
import com.skd.cataclysmbosses.client.model.entity.Ignited_Berserker_Model;
import com.skd.cataclysmbosses.client.model.entity.Kobolediator_Model;
import com.skd.cataclysmbosses.client.model.entity.Laser_Beam_Model;
import com.skd.cataclysmbosses.client.model.entity.Maledictus_Model;
import com.skd.cataclysmbosses.client.model.entity.Netherite_Ministrosity_Model;
import com.skd.cataclysmbosses.client.model.entity.Netherite_Monstrosity_Model;
import com.skd.cataclysmbosses.client.model.entity.Royal_Draugr_Model;
import com.skd.cataclysmbosses.client.model.entity.Scylla_Model;
import com.skd.cataclysmbosses.client.model.entity.Storm_Serpent_Model;
import com.skd.cataclysmbosses.client.model.entity.Symbiocto_Model;
import com.skd.cataclysmbosses.client.model.entity.The_Prowler_Model;
import com.skd.cataclysmbosses.client.model.entity.Urchinkin_Model;
import com.skd.cataclysmbosses.client.model.entity.Wave_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Belt_Of_Beginner_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Belt_Of_Monstrosity_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Berserker_Soul_Amulet_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Blazing_Grips_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Chitin_Claw_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Sandstorm_In_A_BottleModel;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Sticky_Gloves_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Sturdy_Boots_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Unbreakable_Skull_Model;
import com.skd.cataclysmbosses.client.model.item.CuriosModel.Vitality_Ankh_Model;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(value=Dist.CLIENT)
public class CMModelLayers {
    public static final ModelLayerLocation ELYTRA_ARMOR = CMModelLayers.createLocation("elytra_armor", "main");
    public static final ModelLayerLocation MONSTROUS_HELM = CMModelLayers.createLocation("monstrous", "main");
    public static final ModelLayerLocation IGNITIUM_ARMOR_MODEL = CMModelLayers.createLocation("ignitium_armor_model", "main");
    public static final ModelLayerLocation IGNITIUM_ARMOR_MODEL_LEGS = CMModelLayers.createLocation("ignitium_armor_model_leg", "main");
    public static final ModelLayerLocation CURSIUM_ARMOR_MODEL = CMModelLayers.createLocation("cursium_armor_model", "main");
    public static final ModelLayerLocation CURSIUM_ARMOR_MODEL_LEGS = CMModelLayers.createLocation("cursium_armor_model_leg", "main");
    public static final ModelLayerLocation BLOOM_STONE_PAULDRONS_MODEL = CMModelLayers.createLocation("bloom_stone_pauldrons_model", "main");
    public static final ModelLayerLocation BONE_REPTILE_ARMOR_MODEL = CMModelLayers.createLocation("bone_reptile_armor_model", "main");
    public static final ModelLayerLocation SANDSTORM_IN_A_BOTTLE_MODEL = CMModelLayers.createLocation("sandstorm_in_a_bottle_model", "main");
    public static final ModelLayerLocation STICKY_GLOVES_MODEL = CMModelLayers.createLocation("sticky_gloves_model", "main");
    public static final ModelLayerLocation STICKY_GLOVES_SLIM_MODEL = CMModelLayers.createLocation("sticky_gloves_slim_model", "main");
    public static final ModelLayerLocation BLAZING_GRIPS_MODEL = CMModelLayers.createLocation("blazing_grips_model", "main");
    public static final ModelLayerLocation BLAZING_GRIPS_SLIM_MODEL = CMModelLayers.createLocation("blazing_grips_slim_model", "main");
    public static final ModelLayerLocation CHITIN_CLAW_MODEL = CMModelLayers.createLocation("chitin_claw_model", "main");
    public static final ModelLayerLocation CHITIN_CLAW_SLIM_MODEL = CMModelLayers.createLocation("chitin_claw_slim_model", "main");
    public static final ModelLayerLocation VITALITY_ANKH_MODEL = CMModelLayers.createLocation("vitality_ankh_model", "main");
    public static final ModelLayerLocation BELT_OF_BEGINNER_MODEL = CMModelLayers.createLocation("belt_of_beginner_model", "main");
    public static final ModelLayerLocation BELT_OF_MONSTROSITY_MODEL = CMModelLayers.createLocation("belt_of_monstrosity_model", "main");
    public static final ModelLayerLocation STURDY_BOOTS_MODEL = CMModelLayers.createLocation("sturdy_boots_model", "main");
    public static final ModelLayerLocation UNBREAKABLE_SKULL_MODEL = CMModelLayers.createLocation("unbreakable_skull_model", "main");
    public static final ModelLayerLocation BERSERKER_SOUL_AMULET_MODEL = CMModelLayers.createLocation("berserker_soul_amulet_model", "main");
    public static final ModelLayerLocation KOBOLEDIATOR_HEAD_MODEL = CMModelLayers.createLocation("kobolediator_head_model", "main");
    public static final ModelLayerLocation APTRGANGR_HEAD_MODEL = CMModelLayers.createLocation("aptrgangr_head_model", "main");
    public static final ModelLayerLocation DRAUGR_HEAD_MODEL = CMModelLayers.createLocation("draugr_head_model", "main");
    public static final ModelLayerLocation IGNITED_BERSERKER_MODEL = CMModelLayers.createLocation("ignited_berserker_model", "main");
    public static final ModelLayerLocation NETHERITE_MONSTROSITY_MODEL = CMModelLayers.createLocation("netherite_monstrosity_model", "main");
    public static final ModelLayerLocation NETHERITE_MINISTROSITY_MODEL = CMModelLayers.createLocation("netherite_ministrosity_model", "main");
    public static final ModelLayerLocation FLARE_BOMB_MODEL = CMModelLayers.createLocation("flare_bomb_model", "main");
    public static final ModelLayerLocation ROYAL_DRAUGR_MODEL = CMModelLayers.createLocation("royal_draugr_model", "main");
    public static final ModelLayerLocation DRAUGR_MODEL = CMModelLayers.createLocation("draugr_model", "main");
    public static final ModelLayerLocation ELITE_DRAUGR_MODEL = CMModelLayers.createLocation("elite_draugr_model", "main");
    public static final ModelLayerLocation ANCIENT_REMNANT_MODEL = CMModelLayers.createLocation("ancient_remnant_model", "main");
    public static final ModelLayerLocation MALEDICTUS_MODEL = CMModelLayers.createLocation("maledictus_model", "main");
    public static final ModelLayerLocation APTRGANGR_MODEL = CMModelLayers.createLocation("aptrgangr_model", "main");
    public static final ModelLayerLocation KOBOLEDIATOR_MODEL = CMModelLayers.createLocation("kobolediator_model", "main");
    public static final ModelLayerLocation PROWLER_MODEL = CMModelLayers.createLocation("prowler_model", "main");
    public static final ModelLayerLocation HIPPOCAMTUS_MODEL = CMModelLayers.createLocation("hippocamtus_model", "main");
    public static final ModelLayerLocation URCHINKIN_MODEL = CMModelLayers.createLocation("urchinkin_model", "main");
    public static final ModelLayerLocation OCTOSITE_MODEL = CMModelLayers.createLocation("octosite_model", "main");
    public static final ModelLayerLocation ELEMENTAL_SPEAR_MODEL = CMModelLayers.createLocation("elemental_spear_model", "main");
    public static final ModelLayerLocation CINDARIA_MODEL = CMModelLayers.createLocation("cindaria_model", "main");
    public static final ModelLayerLocation SCYLLA_MODEL = CMModelLayers.createLocation("scylla_model", "main");
    public static final ModelLayerLocation CERAUNUS_MODEL = CMModelLayers.createLocation("ceraunus_model", "main");
    public static final ModelLayerLocation CLAWDIAN_MODEL = CMModelLayers.createLocation("clawdian_model", "main");
    public static final ModelLayerLocation LASER_BEAM_MODEL = CMModelLayers.createLocation("laser_beam_model", "main");
    public static final ModelLayerLocation WAVE_MODEL = CMModelLayers.createLocation("wave_model", "main");
    public static final ModelLayerLocation DROWNED_HOST = CMModelLayers.createLocation("drowned_host", "main");
    public static final ModelLayerLocation DROWNED_HOST_INNER_ARMOR = CMModelLayers.createLocation("drowned_host", "inner_armor");
    public static final ModelLayerLocation DROWNED_HOST_OUTER_ARMOR = CMModelLayers.createLocation("drowned_host", "outer_armor");
    public static final ModelLayerLocation DROWNED_HOST_OUTER_LAYER = CMModelLayers.createLocation("drowned_host", "outer");
    public static final ModelLayerLocation STORM_SERPENT_MODEL = CMModelLayers.createLocation("storm_serpent_model", "main");

    public static void register(EntityRenderersEvent.RegisterLayerDefinitions event) {
        MeshDefinition mesh3 = HumanoidModel.createMesh(new CubeDeformation(0.5f), 0.0F);
        LayerDefinition layerdefinition3 = LayerDefinition.create(mesh3, 64, 32);
        event.registerLayerDefinition(MONSTROUS_HELM, () -> MonstrousHelm_Model.createArmorLayer(new CubeDeformation(0.3f)));
        event.registerLayerDefinition(IGNITIUM_ARMOR_MODEL, () -> Ignitium_Armor_Model.createArmorLayer(new CubeDeformation(0.6f)));
        event.registerLayerDefinition(BLOOM_STONE_PAULDRONS_MODEL, () -> Bloom_Stone_Pauldrons_Model.createArmorLayer(new CubeDeformation(0.5f)));
        event.registerLayerDefinition(ELYTRA_ARMOR, () -> Ignitium_Elytra_chestplate_Model.createArmorLayer(new CubeDeformation(0.5f)));
        event.registerLayerDefinition(IGNITIUM_ARMOR_MODEL_LEGS, () -> Ignitium_Armor_Model.createArmorLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(SANDSTORM_IN_A_BOTTLE_MODEL, () -> Sandstorm_In_A_BottleModel.createLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(BONE_REPTILE_ARMOR_MODEL, () -> Bone_Reptile_Armor_Model.createArmorLayer(new CubeDeformation(1.0f)));
        event.registerLayerDefinition(STICKY_GLOVES_MODEL, () -> Sticky_Gloves_Model.createLayer(false, new CubeDeformation(0.2f)));
        event.registerLayerDefinition(STICKY_GLOVES_SLIM_MODEL, () -> Sticky_Gloves_Model.createLayer(true, new CubeDeformation(0.2f)));
        event.registerLayerDefinition(BLAZING_GRIPS_MODEL, () -> Blazing_Grips_Model.createLayer(false, new CubeDeformation(0.0f)));
        event.registerLayerDefinition(BLAZING_GRIPS_SLIM_MODEL, () -> Blazing_Grips_Model.createLayer(true, new CubeDeformation(0.0f)));
        event.registerLayerDefinition(CHITIN_CLAW_MODEL, () -> Chitin_Claw_Model.createLayer(false, new CubeDeformation(0.0f)));
        event.registerLayerDefinition(CHITIN_CLAW_SLIM_MODEL, () -> Chitin_Claw_Model.createLayer(true, new CubeDeformation(0.0f)));
        event.registerLayerDefinition(VITALITY_ANKH_MODEL, () -> Vitality_Ankh_Model.createLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(UNBREAKABLE_SKULL_MODEL, () -> Unbreakable_Skull_Model.createBodyLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(BELT_OF_BEGINNER_MODEL, () -> Belt_Of_Beginner_Model.createBodyLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(BELT_OF_MONSTROSITY_MODEL, () -> Belt_Of_Monstrosity_Model.createBodyLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(STURDY_BOOTS_MODEL, () -> Sturdy_Boots_Model.createBodyLayer(new CubeDeformation(0.3f)));
        event.registerLayerDefinition(BERSERKER_SOUL_AMULET_MODEL, () -> Berserker_Soul_Amulet_Model.createLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(KOBOLEDIATOR_HEAD_MODEL, KobolediatorHeadModel::createHeadLayer);
        event.registerLayerDefinition(APTRGANGR_HEAD_MODEL, AptrgangrHeadModel::createHeadLayer);
        event.registerLayerDefinition(DRAUGR_HEAD_MODEL, DraugrHeadModel::createHeadLayer);
        event.registerLayerDefinition(IGNITED_BERSERKER_MODEL, Ignited_Berserker_Model::createBodyLayer);
        event.registerLayerDefinition(NETHERITE_MONSTROSITY_MODEL, Netherite_Monstrosity_Model::createBodyLayer);
        event.registerLayerDefinition(NETHERITE_MINISTROSITY_MODEL, Netherite_Ministrosity_Model::createBodyLayer);
        event.registerLayerDefinition(FLARE_BOMB_MODEL, Flare_Bomb_Model::createBodyLayer);
        event.registerLayerDefinition(CURSIUM_ARMOR_MODEL, () -> Cursium_Armor_Model.createArmorLayer(new CubeDeformation(0.5f)));
        event.registerLayerDefinition(CURSIUM_ARMOR_MODEL_LEGS, () -> Cursium_Armor_Model.createArmorLayer(new CubeDeformation(0.2f)));
        event.registerLayerDefinition(ROYAL_DRAUGR_MODEL, Royal_Draugr_Model::createBodyLayer);
        event.registerLayerDefinition(DRAUGR_MODEL, Draugr_Model::createBodyLayer);
        event.registerLayerDefinition(ELITE_DRAUGR_MODEL, Elite_Draugr_Model::createBodyLayer);
        event.registerLayerDefinition(ANCIENT_REMNANT_MODEL, Ancient_Remnant_Rework_Model::createBodyLayer);
        event.registerLayerDefinition(MALEDICTUS_MODEL, Maledictus_Model::createBodyLayer);
        event.registerLayerDefinition(APTRGANGR_MODEL, Aptrgangr_Model::createBodyLayer);
        event.registerLayerDefinition(KOBOLEDIATOR_MODEL, Kobolediator_Model::createBodyLayer);
        event.registerLayerDefinition(PROWLER_MODEL, The_Prowler_Model::createBodyLayer);
        event.registerLayerDefinition(HIPPOCAMTUS_MODEL, Hippocamtus_Model::createBodyLayer);
        event.registerLayerDefinition(OCTOSITE_MODEL, Symbiocto_Model::createBodyLayer);
        event.registerLayerDefinition(URCHINKIN_MODEL, Urchinkin_Model::createBodyLayer);
        event.registerLayerDefinition(ELEMENTAL_SPEAR_MODEL, Elemental_Spear_Model::createBodyLayer);
        event.registerLayerDefinition(CINDARIA_MODEL, Cindaria_Model::createBodyLayer);
        event.registerLayerDefinition(SCYLLA_MODEL, Scylla_Model::createBodyLayer);
        event.registerLayerDefinition(CERAUNUS_MODEL, Ceraunus_Model::createBodyLayer);
        event.registerLayerDefinition(CLAWDIAN_MODEL, Clawdian_Model::createBodyLayer);
        event.registerLayerDefinition(LASER_BEAM_MODEL, Laser_Beam_Model::createBodyLayer);
        event.registerLayerDefinition(WAVE_MODEL, Wave_Model::createBodyLayer);
        event.registerLayerDefinition(STORM_SERPENT_MODEL, Storm_Serpent_Model::createBodyLayer);
        event.registerLayerDefinition(DROWNED_HOST, () -> Drowned_Host_Model.createBodyLayer(CubeDeformation.NONE));
        event.registerLayerDefinition(DROWNED_HOST_INNER_ARMOR, () -> layerdefinition3);
        event.registerLayerDefinition(DROWNED_HOST_OUTER_ARMOR, () -> layerdefinition3);
        event.registerLayerDefinition(DROWNED_HOST_OUTER_LAYER, () -> Drowned_Host_Model.createBodyLayer(new CubeDeformation(0.25f)));
    }

    private static ModelLayerLocation createLocation(String model, String layer) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)model), layer);
    }
}

