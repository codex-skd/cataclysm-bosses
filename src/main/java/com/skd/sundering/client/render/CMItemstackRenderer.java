/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  com.google.common.collect.Maps
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.Util
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.SkullModelBase
 *  net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.server.packs.resources.ResourceManager
 *  net.minecraft.util.Mth
 *  net.minecraft.world.item.BlockItem
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SkullBlock$Type
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.neoforge.client.extensions.common.IClientItemExtensions
 */
package com.skd.sundering.client.render;

import com.skd.sundering.Cataclysm;
import com.skd.sundering.blocks.Cataclysm_Skull_Block;
import com.skd.sundering.client.model.block.Abyssal_Egg_Model;
import com.skd.sundering.client.model.block.Altar_of_Abyss_Model;
import com.skd.sundering.client.model.block.Altar_of_Amethyst_Model;
import com.skd.sundering.client.model.block.Altar_of_Fire_Model;
import com.skd.sundering.client.model.block.Altar_of_Void_Model;
import com.skd.sundering.client.model.block.Boss_Respawn_Spawner_Model;
import com.skd.sundering.client.model.block.EMP_Model;
import com.skd.sundering.client.model.block.Goddess_Statue_Model;
import com.skd.sundering.client.model.block.Mechanical_Anvil_Model;
import com.skd.sundering.client.model.entity.Coral_Bardiche_Model;
import com.skd.sundering.client.model.entity.Coral_Spear_Model;
import com.skd.sundering.client.model.item.Ancient_Spear_Model;
import com.skd.sundering.client.model.item.Astrape_Model;
import com.skd.sundering.client.model.item.Azure_Sea_Shield_Model;
import com.skd.sundering.client.model.item.Black_Steel_Targe_Model;
import com.skd.sundering.client.model.item.Brontes_Model;
import com.skd.sundering.client.model.item.Bulwark_of_the_flame_Model;
import com.skd.sundering.client.model.item.Ceraunus_Item_Model;
import com.skd.sundering.client.model.item.Cursed_Bow_Model;
import com.skd.sundering.client.model.item.Gauntlet_of_Bulwark_Model;
import com.skd.sundering.client.model.item.Gauntlet_of_Guard_Model;
import com.skd.sundering.client.model.item.Gauntlet_of_Maelstrom_Model;
import com.skd.sundering.client.model.item.Incinerator_Model;
import com.skd.sundering.client.model.item.Infernal_Forge_Model;
import com.skd.sundering.client.model.item.Laser_Gatling_Model;
import com.skd.sundering.client.model.item.Meat_Shredder_Model;
import com.skd.sundering.client.model.item.Soul_render_Model;
import com.skd.sundering.client.model.item.The_Annihilator_Model;
import com.skd.sundering.client.model.item.The_Immolator_Model;
import com.skd.sundering.client.model.item.Tidal_Claws_Model;
import com.skd.sundering.client.model.item.Void_Forge_Model;
import com.skd.sundering.client.model.item.Wither_Assault_SHoulder_Weapon_Model;
import com.skd.sundering.client.model.item.Wrath_of_Desert_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.skd.sundering.init.ModItems;
import com.skd.sundering.items.Cursed_bow;
import com.skd.sundering.items.Laser_Gatling;
import com.skd.sundering.items.Wrath_of_the_desert;
import com.google.common.base.Suppliers;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

@OnlyIn(value=Dist.CLIENT)
public class CMItemstackRenderer
extends BlockEntityWithoutLevelRenderer {
    public static int ticksExisted = 0;
    private static final Bulwark_of_the_flame_Model BULWARK_OF_THE_FLAME_MODEL = new Bulwark_of_the_flame_Model();
    private static final Black_Steel_Targe_Model BLACK_STEEL_TARGE_MODEL = new Black_Steel_Targe_Model();
    private static final Azure_Sea_Shield_Model AZURE_SEA_SHIELD_MODEL = new Azure_Sea_Shield_Model();
    private static final EMP_Model EMP_MODEL = new EMP_Model();
    private static final Mechanical_Anvil_Model MF_MODEL = new Mechanical_Anvil_Model();
    private static final Gauntlet_of_Guard_Model GAUNTLET_OF_GUARD_MODEL = new Gauntlet_of_Guard_Model();
    private static final Gauntlet_of_Bulwark_Model GAUNTLET_OF_BULWARK_MODEL = new Gauntlet_of_Bulwark_Model();
    private static final Gauntlet_of_Maelstrom_Model GAUNTLET_OF_MAELSTROM_MODEL = new Gauntlet_of_Maelstrom_Model();
    private static final Astrape_Model ASTRAPE_MODEL = new Astrape_Model();
    private static final Ceraunus_Item_Model CERAUNUS_MODEL = new Ceraunus_Item_Model();
    private static final Brontes_Model BRONTES_MODEL = new Brontes_Model();
    private static final Incinerator_Model THE_INCINERATOR_MODEL = new Incinerator_Model();
    private static final Coral_Spear_Model CORAL_SPEAR_MODEL = new Coral_Spear_Model();
    private static final Coral_Bardiche_Model CORAL_BARDICHE_MODEL = new Coral_Bardiche_Model();
    private static final Altar_of_Fire_Model ALTAR_OF_FIRE_MODEL = new Altar_of_Fire_Model();
    private static final Altar_of_Void_Model ALTAR_OF_VOID_MODEL = new Altar_of_Void_Model();
    private static final Altar_of_Amethyst_Model ALTAR_OF_AMETHYST_MODEL = new Altar_of_Amethyst_Model();
    private static final Altar_of_Abyss_Model ALTAR_OF_ABYSS_MODEL = new Altar_of_Abyss_Model();
    private static final Abyssal_Egg_Model ABYSSAL_MODEL = new Abyssal_Egg_Model();
    private static final Goddess_Statue_Model GODDESS_STATUE_MODEL = new Goddess_Statue_Model();
    private static final Boss_Respawn_Spawner_Model SPAWNER_MODEL = new Boss_Respawn_Spawner_Model();
    private static final Wither_Assault_SHoulder_Weapon_Model WASW_MODEL = new Wither_Assault_SHoulder_Weapon_Model();
    private static final Void_Forge_Model VOID_FORGE_MODEL = new Void_Forge_Model();
    private static final Infernal_Forge_Model INFERNAL_FORGE_MODEL = new Infernal_Forge_Model();
    private static final Tidal_Claws_Model TIDAL_CLAWS_MODEL = new Tidal_Claws_Model();
    private static final Meat_Shredder_Model MEAT_SHREDDER_MODEL = new Meat_Shredder_Model();
    private static final Laser_Gatling_Model LASER_GATLING_MODEL = new Laser_Gatling_Model();
    private static final Ancient_Spear_Model ANCIENT_SPEAR_MODEL = new Ancient_Spear_Model();
    private static final Cursed_Bow_Model CURSED_BOW_MODEL = new Cursed_Bow_Model();
    private static final Wrath_of_Desert_Model WRATH_OF_DESERT_MODEL = new Wrath_of_Desert_Model();
    private static final The_Annihilator_Model THE_ANNIHILATOR = new The_Annihilator_Model();
    private static final The_Immolator_Model THE_IMMOLATOR_MODEL = new The_Immolator_Model();
    private static final Soul_render_Model SOUL_RENDER = new Soul_render_Model();
    private static final Identifier CURSED_BOW_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/cursed_bow.png");
    private static final Identifier CURSED_BOW_GHOST_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/cursed_bow_ghost.png");
    private static final Identifier WRATH_OF_DESERT_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/wrath_of_desert.png");
    private static final Identifier WRATH_OF_DESERT_GHOST_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/wrath_of_desert_ghost.png");
    private static final Identifier SOUL_RENDER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/soul_render.png");
    private static final Identifier SOUL_RENDER_GHOST_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/soul_render_ghost.png");
    private static final Identifier THE_ANNIHILATOR_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/the_annihilator.png");
    private static final Identifier THE_ANNIHILATOR_GHOST_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/the_annihilator_ghost.png");
    private static final Identifier THE_IMMOLATOR_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/the_immolator.png");
    private static final Identifier THE_IMMOLATOR_GHOST_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/the_immolator_ghost.png");
    private static final Identifier BULWARK_OF_THE_FLAME_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/bulwark_of_the_flame.png");
    private static final Identifier BLACK_STEEL_TARGE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/black_steel_targe.png");
    private static final Identifier AZURE_SEA_SHIELD_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/azure_sea_shield.png");
    private static final Identifier ASTRAPE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/astrape.png");
    private static final Identifier CERAUNUS_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/ceraunus.png");
    private static final Identifier GAUNTLET_OF_GUARD_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/new_gauntlet_of_guard.png");
    private static final Identifier GAUNTLET_OF_MAELSTROM_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/gauntlet_of_maelstrom.png");
    private static final Identifier GAUNTLET_OF_BULWARK_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/new_gauntlet_of_bulwark.png");
    private static final Identifier GAUNTLET_OF_GUARD_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/new_gauntlet_of_guard_layer.png");
    private static final Identifier GAUNTLET_OF_BULWARK_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/new_gauntlet_of_bulwark_layer.png");
    private static final Identifier GAUNTLET_OF_MAELSTROM_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/gauntlet_of_maelstrom_layer.png");
    private static final Identifier THE_INCINERATOR_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/the_incinerator.png");
    private static final Identifier VOID_FORGE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/void_forge.png");
    private static final Identifier VOID_FORGE_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/void_forge_layer.png");
    private static final Identifier INFERNAL_FORGE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/infernal_forge.png");
    private static final Identifier INFERNAL_FORGE_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/infernal_forge_layer.png");
    private static final Identifier BRONTES_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/brontes.png");
    private static final Identifier BRONTES_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/brontes_layer.png");
    private static final Identifier TIDAL_CLAWS_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/tidal_claws.png");
    private static final Identifier MEAT_SHREDDER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/meat_shredder.png");
    private static final Identifier MEAT_SHREDDER_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/meat_shredder_layer.png");
    private static final Identifier LASER_GATLING_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/laser_gatling.png");
    private static final Identifier LASER_GATLING_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/laser_gatling_layer.png");
    private static final Identifier ALTAR_OF_FIRE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_fire/altar_of_fire.png");
    private static final Identifier ALTAR_OF_VOID_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_void.png");
    private static final Identifier ALTAR_OF_AMETHYST_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_amethyst.png");
    private static final Identifier ALTAR_OF_ABYSS_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/altar_of_abyss.png");
    private static final Identifier ABYSSAL_EGG_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/abyssal_egg.png");
    private static final Identifier ABYSSAL_EGG_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/abyssal_egg_layer.png");
    private static final Identifier MIF_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/mechanical_fusion_anvil.png");
    private static final Identifier WASW_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/wither_assualt_shoulder_weapon.png");
    private static final Identifier WASW_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/wither_assualt_shoulder_weapon_layer.png");
    private static final Identifier VASW_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/void_assualt_shoulder_weapon.png");
    private static final Identifier VASW_LAYER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/void_assualt_shoulder_weapon_layer.png");
    private static final Identifier EMP_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/emp.png");
    private static final Identifier STATUE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/goddess_statue.png");
    private static final Identifier SPAWNER_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/block/boss_respawner.png");
    private static final Identifier[] TEXTURE_FIRE_PROGRESS = new Identifier[8];
    private static final Identifier[] TEXTURE_LIGHTNING_PROGRESS = new Identifier[6];
    private static final Identifier CORAL_SPEAR_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/coral_spear.png");
    private static final Identifier CORAL_BARDICHE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/coral_bardiche.png");
    private static final Identifier ANCIENT_SPEAR_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/item/ancient_spear.png");
    private Map<SkullBlock.Type, SkullModelBase> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());
    public static final Map<SkullBlock.Type, Identifier> SKIN_BY_TYPE = (Map)Util.make((Object)Maps.newHashMap(), p_261388_ -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/draugar/draugr.png"));
    });
    public static final Supplier<CMItemstackRenderer> INSTANCE = Suppliers.memoize(CMItemstackRenderer::new);
    public static final IClientItemExtensions CLIENT_ITEM_EXTENSION = (IClientItemExtensions)Util.make(() -> new IClientItemExtensions(){

        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return INSTANCE.get();
        }
    });

    public CMItemstackRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        for (int i = 0; i < 8; ++i) {
            CMItemstackRenderer.TEXTURE_FIRE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/block/altar_of_fire/altarfire_" + i + ".png"));
        }
    }

    public void onResourceManagerReload(ResourceManager manager) {
        this.skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());
        Cataclysm.LOGGER.debug("Reloaded ItemStackRenderer!");
    }

    public static void incrementTick() {
        ++ticksExisted;
    }

    public void renderByItem(ItemStack itemStackIn, ItemDisplayContext transformType, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        VertexConsumer vertexconsumer;
        VertexConsumer vertexconsumer2;
        VertexConsumer vertexconsumer22;
        VertexConsumer vertexconsumer3;
        BlockItem blockItem;
        Block block;
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false);
        boolean left = transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND;
        int tick = Minecraft.getInstance().player == null || Minecraft.getInstance().isPaused() ? ticksExisted : Minecraft.getInstance().player.tickCount;
        Item item = itemStackIn.getItem();
        if (item instanceof BlockItem && (block = (blockItem = (BlockItem)item).getBlock()) instanceof Cataclysm_Skull_Block) {
            SkullBlock.Type skullblock$type = ((Cataclysm_Skull_Block)block).getType();
            SkullModelBase skullmodelbase = this.skullModels.get(skullblock$type);
            Identifier resourcelocation = SKIN_BY_TYPE.get(skullblock$type);
            RenderType rendertype = RenderType.entityCutoutNoCullZOffset((Identifier)resourcelocation);
            Cataclysm_Skull_Block_Renderer.renderSkull(null, 180.0f, 0.0f, matrixStackIn, bufferIn, combinedLightIn, skullmodelbase, rendertype, skullblock$type, false);
        }
        if (itemStackIn.getItem() == ModItems.BULWARK_OF_THE_FLAME.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)BULWARK_OF_THE_FLAME_TEXTURE), (boolean)itemStackIn.hasFoil());
            BULWARK_OF_THE_FLAME_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.BLACK_STEEL_TARGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)BLACK_STEEL_TARGE_TEXTURE), (boolean)itemStackIn.hasFoil());
            BLACK_STEEL_TARGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.AZURE_SEA_SHIELD.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)AZURE_SEA_SHIELD_TEXTURE), (boolean)itemStackIn.hasFoil());
            AZURE_SEA_SHIELD_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ASTRAPE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)ASTRAPE_TEXTURE), (boolean)itemStackIn.hasFoil());
            ASTRAPE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.CERAUNUS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.entityCutoutNoCull((Identifier)CERAUNUS_TEXTURE), (boolean)itemStackIn.hasFoil());
            CERAUNUS_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_GUARD.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)GAUNTLET_OF_GUARD_TEXTURE), (boolean)itemStackIn.hasFoil());
            GAUNTLET_OF_GUARD_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)GAUNTLET_OF_GUARD_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            GAUNTLET_OF_GUARD_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_BULWARK.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)GAUNTLET_OF_BULWARK_TEXTURE), (boolean)itemStackIn.hasFoil());
            GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)GAUNTLET_OF_BULWARK_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_MAELSTROM.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)GAUNTLET_OF_MAELSTROM_TEXTURE), (boolean)itemStackIn.hasFoil());
            GAUNTLET_OF_MAELSTROM_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)GAUNTLET_OF_MAELSTROM_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            GAUNTLET_OF_MAELSTROM_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.THE_INCINERATOR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)THE_INCINERATOR_TEXTURE), (boolean)itemStackIn.hasFoil());
            THE_INCINERATOR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.WITHER_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)WASW_TEXTURE), (boolean)itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)WASW_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.VOID_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)VASW_TEXTURE), (boolean)itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)VASW_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            WASW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.CORAL_SPEAR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)CORAL_SPEAR_TEXTURE), (boolean)itemStackIn.hasFoil());
            CORAL_SPEAR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.CORAL_BARDICHE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)CORAL_BARDICHE_TEXTURE), (boolean)itemStackIn.hasFoil());
            CORAL_BARDICHE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.VOID_FORGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)VOID_FORGE_TEXTURE), (boolean)itemStackIn.hasFoil());
            VOID_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)VOID_FORGE_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            VOID_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.BRONTES.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)BRONTES_TEXTURE), (boolean)itemStackIn.hasFoil());
            BRONTES_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, OverlayTexture.NO_OVERLAY);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)BRONTES_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            BRONTES_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.INFERNAL_FORGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)INFERNAL_FORGE_TEXTURE), (boolean)itemStackIn.hasFoil());
            INFERNAL_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)INFERNAL_FORGE_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            INFERNAL_FORGE_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.TIDAL_CLAWS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)TIDAL_CLAWS_TEXTURE), (boolean)itemStackIn.hasFoil());
            TIDAL_CLAWS_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.MEAT_SHREDDER.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)MEAT_SHREDDER_TEXTURE), (boolean)itemStackIn.hasFoil());
            MEAT_SHREDDER_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer22 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.CMEyes(MEAT_SHREDDER_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            MEAT_SHREDDER_MODEL.renderToBuffer(matrixStackIn, vertexconsumer22, combinedLightIn, combinedOverlayIn);
            MEAT_SHREDDER_MODEL.animateStack(itemStackIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.LASER_GATLING.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.entityCutoutNoCull((Identifier)LASER_GATLING_TEXTURE), (boolean)itemStackIn.hasFoil());
            float ageInTicks = Minecraft.getInstance().player == null ? 0.0f : (float)Minecraft.getInstance().player.tickCount + partialTick;
            float openAmount = Minecraft.getInstance().player != null && Laser_Gatling.isCharged(itemStackIn) ? (float)Minecraft.getInstance().player.tickCount + partialTick : 0.0f;
            LASER_GATLING_MODEL.setupAnim(null, openAmount, 0.0f, ageInTicks, 0.0f, 0.0f);
            LASER_GATLING_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            vertexconsumer2 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.eyes((Identifier)LASER_GATLING_LAYER_TEXTURE), (boolean)itemStackIn.hasFoil());
            LASER_GATLING_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ANCIENT_SPEAR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            vertexconsumer3 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)ANCIENT_SPEAR_TEXTURE), (boolean)itemStackIn.hasFoil());
            ANCIENT_SPEAR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer3, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.is((Item)ModItems.CURSED_BOW.get())) {
            float ageInTicks = Minecraft.getInstance().player == null ? 0.0f : (float)Minecraft.getInstance().player.tickCount + partialTick;
            float pullAmount = Cursed_bow.getPullingAmount(itemStackIn, partialTick);
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            CURSED_BOW_MODEL.setupAnim(null, pullAmount, ageInTicks, 0.0f, 0.0f, 0.0f);
            vertexconsumer = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)CURSED_BOW_TEXTURE), (boolean)itemStackIn.hasFoil());
            CURSED_BOW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn);
            vertexconsumer2 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.getGhost(CURSED_BOW_GHOST_TEXTURE), (boolean)itemStackIn.hasFoil());
            CURSED_BOW_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.is((Item)ModItems.WRATH_OF_THE_DESERT.get())) {
            float ageInTicks = Minecraft.getInstance().player == null ? 0.0f : (float)Minecraft.getInstance().player.tickCount + partialTick;
            float pullAmount = Wrath_of_the_desert.getPullingAmount(itemStackIn, partialTick);
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            WRATH_OF_DESERT_MODEL.setupAnim(null, pullAmount, ageInTicks, ageInTicks, 0.0f, 0.0f);
            vertexconsumer = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)WRATH_OF_DESERT_TEXTURE), (boolean)itemStackIn.hasFoil());
            WRATH_OF_DESERT_MODEL.renderToBuffer(matrixStackIn, vertexconsumer, combinedLightIn, combinedOverlayIn);
            vertexconsumer2 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.getGhost(WRATH_OF_DESERT_GHOST_TEXTURE), (boolean)itemStackIn.hasFoil());
            WRATH_OF_DESERT_MODEL.renderToBuffer(matrixStackIn, vertexconsumer2, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.is((Item)ModItems.SOUL_RENDER.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            VertexConsumer vertexconsumer4 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)SOUL_RENDER_TEXTURE), (boolean)itemStackIn.hasFoil());
            SOUL_RENDER.renderToBuffer(matrixStackIn, vertexconsumer4, combinedLightIn, combinedOverlayIn);
            VertexConsumer vertexconsumer23 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.getGhost(SOUL_RENDER_GHOST_TEXTURE), (boolean)itemStackIn.hasFoil());
            SOUL_RENDER.renderToBuffer(matrixStackIn, vertexconsumer23, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.is((Item)ModItems.THE_ANNIHILATOR.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            VertexConsumer vertexconsumer5 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)THE_ANNIHILATOR_TEXTURE), (boolean)itemStackIn.hasFoil());
            THE_ANNIHILATOR.renderToBuffer(matrixStackIn, vertexconsumer5, combinedLightIn, combinedOverlayIn);
            VertexConsumer vertexconsumer24 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.getGhost(THE_ANNIHILATOR_GHOST_TEXTURE), (boolean)itemStackIn.hasFoil());
            THE_ANNIHILATOR.renderToBuffer(matrixStackIn, vertexconsumer24, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.is((Item)ModItems.THE_IMMOLATOR.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            VertexConsumer vertexconsumer6 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)RenderType.armorCutoutNoCull((Identifier)THE_IMMOLATOR_TEXTURE), (boolean)itemStackIn.hasFoil());
            THE_IMMOLATOR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer6, combinedLightIn, combinedOverlayIn);
            VertexConsumer vertexconsumer25 = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)bufferIn, (RenderType)CMRenderTypes.getGhost(THE_IMMOLATOR_GHOST_TEXTURE), (boolean)itemStackIn.hasFoil());
            THE_IMMOLATOR_MODEL.renderToBuffer(matrixStackIn, vertexconsumer25, combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_FIRE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_FIRE_MODEL.resetToDefaultPose();
            ALTAR_OF_FIRE_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)ALTAR_OF_FIRE_TEXTURE)), combinedLightIn, combinedOverlayIn);
            ALTAR_OF_FIRE_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(this.getIdleTexture((int)((float)tick * 0.5f % 7.0f)))), combinedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_VOID.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_VOID_MODEL.resetToDefaultPose();
            ALTAR_OF_VOID_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)ALTAR_OF_VOID_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_AMETHYST.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_AMETHYST_MODEL.resetToDefaultPose();
            ALTAR_OF_AMETHYST_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)ALTAR_OF_AMETHYST_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_ABYSS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_ABYSS_MODEL.resetToDefaultPose();
            ALTAR_OF_ABYSS_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)ALTAR_OF_ABYSS_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.EMP.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            EMP_MODEL.resetToDefaultPose();
            EMP_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)EMP_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.MECHANICAL_FUSION_ANVIL.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            MF_MODEL.resetToDefaultPose();
            MF_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)MIF_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ABYSSAL_EGG.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ABYSSAL_MODEL.resetToDefaultPose();
            ABYSSAL_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)ABYSSAL_EGG_TEXTURE)), combinedLightIn, combinedOverlayIn);
            ABYSSAL_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getGhost(ABYSSAL_EGG_LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GODDESS_STATUE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            GODDESS_STATUE_MODEL.resetToDefaultPose();
            GODDESS_STATUE_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)STATUE_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.BOSS_RESPAWNER.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            SPAWNER_MODEL.resetToDefaultPose();
            SPAWNER_MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)SPAWNER_TEXTURE)), combinedLightIn, combinedOverlayIn);
            matrixStackIn.popPose();
        }
    }

    private Identifier getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[Mth.clamp((int)age, (int)0, (int)7)];
    }
}

