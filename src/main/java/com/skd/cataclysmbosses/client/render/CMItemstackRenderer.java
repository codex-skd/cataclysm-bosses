package com.skd.cataclysmbosses.client.render;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.blocks.Cataclysm_Skull_Block;
import com.skd.cataclysmbosses.client.model.block.Abyssal_Egg_Model;
import com.skd.cataclysmbosses.client.model.block.Altar_of_Abyss_Model;
import com.skd.cataclysmbosses.client.model.block.Altar_of_Amethyst_Model;
import com.skd.cataclysmbosses.client.model.block.Altar_of_Fire_Model;
import com.skd.cataclysmbosses.client.model.block.Altar_of_Void_Model;
import com.skd.cataclysmbosses.client.model.block.Boss_Respawn_Spawner_Model;
import com.skd.cataclysmbosses.client.model.block.EMP_Model;
import com.skd.cataclysmbosses.client.model.block.Goddess_Statue_Model;
import com.skd.cataclysmbosses.client.model.block.Mechanical_Anvil_Model;
import com.skd.cataclysmbosses.client.model.entity.Coral_Bardiche_Model;
import com.skd.cataclysmbosses.client.model.entity.Coral_Spear_Model;
import com.skd.cataclysmbosses.client.model.item.Ancient_Spear_Model;
import com.skd.cataclysmbosses.client.model.item.Astrape_Model;
import com.skd.cataclysmbosses.client.model.item.Azure_Sea_Shield_Model;
import com.skd.cataclysmbosses.client.model.item.Black_Steel_Targe_Model;
import com.skd.cataclysmbosses.client.model.item.Brontes_Model;
import com.skd.cataclysmbosses.client.model.item.Bulwark_of_the_flame_Model;
import com.skd.cataclysmbosses.client.model.item.Ceraunus_Item_Model;
import com.skd.cataclysmbosses.client.model.item.Cursed_Bow_Model;
import com.skd.cataclysmbosses.client.model.item.Gauntlet_of_Bulwark_Model;
import com.skd.cataclysmbosses.client.model.item.Gauntlet_of_Guard_Model;
import com.skd.cataclysmbosses.client.model.item.Gauntlet_of_Maelstrom_Model;
import com.skd.cataclysmbosses.client.model.item.Incinerator_Model;
import com.skd.cataclysmbosses.client.model.item.Infernal_Forge_Model;
import com.skd.cataclysmbosses.client.model.item.Laser_Gatling_Model;
import com.skd.cataclysmbosses.client.model.item.Meat_Shredder_Model;
import com.skd.cataclysmbosses.client.model.item.Soul_render_Model;
import com.skd.cataclysmbosses.client.model.item.The_Annihilator_Model;
import com.skd.cataclysmbosses.client.model.item.The_Immolator_Model;
import com.skd.cataclysmbosses.client.model.item.Tidal_Claws_Model;
import com.skd.cataclysmbosses.client.model.item.Void_Forge_Model;
import com.skd.cataclysmbosses.client.model.item.Wither_Assault_SHoulder_Weapon_Model;
import com.skd.cataclysmbosses.client.model.item.Wrath_of_Desert_Model;
import com.skd.cataclysmbosses.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.skd.cataclysmbosses.init.ModItems;
import com.skd.cataclysmbosses.items.Cursed_bow;
import com.skd.cataclysmbosses.items.Laser_Gatling;
import com.skd.cataclysmbosses.items.Wrath_of_the_desert;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * PORT NOTE (26.2): replaces the old BlockEntityWithoutLevelRenderer-based item renderer.
 * Items are wired at runtime via item model JSONs referencing the "cataclysm:cm_item"
 * ItemModel.Unbaked codec (registered in ClientSetup through RegisterItemModelsEvent).
 */
@OnlyIn(Dist.CLIENT)
public class CMItemstackRenderer
implements SpecialModelRenderer<ItemStack> {
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
    private static final Identifier CURSED_BOW_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/cursed_bow.png");
    private static final Identifier CURSED_BOW_GHOST_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/cursed_bow_ghost.png");
    private static final Identifier WRATH_OF_DESERT_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/wrath_of_desert.png");
    private static final Identifier WRATH_OF_DESERT_GHOST_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/wrath_of_desert_ghost.png");
    private static final Identifier SOUL_RENDER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/soul_render.png");
    private static final Identifier SOUL_RENDER_GHOST_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/soul_render_ghost.png");
    private static final Identifier THE_ANNIHILATOR_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/the_annihilator.png");
    private static final Identifier THE_ANNIHILATOR_GHOST_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/the_annihilator_ghost.png");
    private static final Identifier THE_IMMOLATOR_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/the_immolator.png");
    private static final Identifier THE_IMMOLATOR_GHOST_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/the_immolator_ghost.png");
    private static final Identifier BULWARK_OF_THE_FLAME_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/bulwark_of_the_flame.png");
    private static final Identifier BLACK_STEEL_TARGE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/black_steel_targe.png");
    private static final Identifier AZURE_SEA_SHIELD_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/azure_sea_shield.png");
    private static final Identifier ASTRAPE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/astrape.png");
    private static final Identifier CERAUNUS_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/ceraunus.png");
    private static final Identifier GAUNTLET_OF_GUARD_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/new_gauntlet_of_guard.png");
    private static final Identifier GAUNTLET_OF_MAELSTROM_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/gauntlet_of_maelstrom.png");
    private static final Identifier GAUNTLET_OF_BULWARK_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/new_gauntlet_of_bulwark.png");
    private static final Identifier GAUNTLET_OF_GUARD_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/new_gauntlet_of_guard_layer.png");
    private static final Identifier GAUNTLET_OF_BULWARK_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/new_gauntlet_of_bulwark_layer.png");
    private static final Identifier GAUNTLET_OF_MAELSTROM_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/gauntlet_of_maelstrom_layer.png");
    private static final Identifier THE_INCINERATOR_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/the_incinerator.png");
    private static final Identifier VOID_FORGE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/void_forge.png");
    private static final Identifier VOID_FORGE_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/void_forge_layer.png");
    private static final Identifier INFERNAL_FORGE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/infernal_forge.png");
    private static final Identifier INFERNAL_FORGE_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/infernal_forge_layer.png");
    private static final Identifier BRONTES_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/brontes.png");
    private static final Identifier BRONTES_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/brontes_layer.png");
    private static final Identifier TIDAL_CLAWS_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/tidal_claws.png");
    private static final Identifier MEAT_SHREDDER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/meat_shredder.png");
    private static final Identifier MEAT_SHREDDER_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/meat_shredder_layer.png");
    private static final Identifier LASER_GATLING_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/laser_gatling.png");
    private static final Identifier LASER_GATLING_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/laser_gatling_layer.png");
    private static final Identifier ALTAR_OF_FIRE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/altar_of_fire/altar_of_fire.png");
    private static final Identifier ALTAR_OF_VOID_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/altar_of_void.png");
    private static final Identifier ALTAR_OF_AMETHYST_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/altar_of_amethyst.png");
    private static final Identifier ALTAR_OF_ABYSS_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/altar_of_abyss.png");
    private static final Identifier ABYSSAL_EGG_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/abyssal_egg.png");
    private static final Identifier ABYSSAL_EGG_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/abyssal_egg_layer.png");
    private static final Identifier MIF_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/mechanical_fusion_anvil.png");
    private static final Identifier WASW_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/wither_assualt_shoulder_weapon.png");
    private static final Identifier WASW_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/wither_assualt_shoulder_weapon_layer.png");
    private static final Identifier VASW_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/void_assualt_shoulder_weapon.png");
    private static final Identifier VASW_LAYER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/void_assualt_shoulder_weapon_layer.png");
    private static final Identifier EMP_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/emp.png");
    private static final Identifier STATUE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/goddess_statue.png");
    private static final Identifier SPAWNER_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/boss_respawner.png");
    private static final Identifier[] TEXTURE_FIRE_PROGRESS = new Identifier[8];
    private static final Identifier[] TEXTURE_LIGHTNING_PROGRESS = new Identifier[6];
    private static final Identifier CORAL_SPEAR_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/coral_spear.png");
    private static final Identifier CORAL_BARDICHE_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/coral_bardiche.png");
    private static final Identifier ANCIENT_SPEAR_TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/item/ancient_spear.png");
    private Map<SkullBlock.Type, SkullModelBase> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());
    public static final Map<SkullBlock.Type, Identifier> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), p_261388_ -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/koboleton/kobolediator.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.APTRGANGR, Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/draugar/aptrgangr.png"));
        p_261388_.put(Cataclysm_Skull_Block.Types.DRAUGR, Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/draugar/draugr.png"));
    });

    public CMItemstackRenderer() {
        for (int i = 0; i < 8; ++i) {
            CMItemstackRenderer.TEXTURE_FIRE_PROGRESS[i] = Identifier.fromNamespaceAndPath("cataclysm", "textures/block/altar_of_fire/altarfire_" + i + ".png");
        }
    }

    public void onResourceManagerReload(ResourceManager manager) {
        this.skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());
        Cataclysm.LOGGER.debug("Reloaded ItemStackRenderer!");
    }

    public static void incrementTick() {
        ++ticksExisted;
    }

    @Override
    public ItemStack extractArgument(ItemStack stack) {
        return stack;
    }

    @Override
    public void submit(@Nullable ItemStack itemStackIn, PoseStack matrixStackIn, SubmitNodeCollector bufferIn, int combinedLightIn, int combinedOverlayIn, boolean hasFoil, int outlineColor) {
        if (itemStackIn == null) {
            return;
        }
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false);
        int tick = Minecraft.getInstance().player == null || Minecraft.getInstance().isPaused() ? ticksExisted : Minecraft.getInstance().player.tickCount;
        Item item = itemStackIn.getItem();
        int[] order = {0};
        if (item instanceof BlockItem && ((BlockItem)((Object)item)).getBlock() instanceof Cataclysm_Skull_Block) {
            SkullBlock.Type skullblock$type = ((Cataclysm_Skull_Block)((BlockItem)((Object)item)).getBlock()).getType();
            SkullModelBase skullmodelbase = this.skullModels.get(skullblock$type);
            Identifier resourcelocation = SKIN_BY_TYPE.get(skullblock$type);
            RenderType rendertype = RenderTypes.entityCutoutZOffset(resourcelocation);
            Cataclysm_Skull_Block_Renderer.renderItemSkull(matrixStackIn, bufferIn, order, combinedLightIn, skullmodelbase, rendertype);
        }
        if (itemStackIn.getItem() == ModItems.BULWARK_OF_THE_FLAME.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(BULWARK_OF_THE_FLAME_TEXTURE), hasFoil, (p, b) -> BULWARK_OF_THE_FLAME_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.BLACK_STEEL_TARGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(BLACK_STEEL_TARGE_TEXTURE), hasFoil, (p, b) -> BLACK_STEEL_TARGE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.AZURE_SEA_SHIELD.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(AZURE_SEA_SHIELD_TEXTURE), hasFoil, (p, b) -> AZURE_SEA_SHIELD_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ASTRAPE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(ASTRAPE_TEXTURE), hasFoil, (p, b) -> ASTRAPE_MODEL.renderToBuffer(p, b, combinedLightIn, OverlayTexture.NO_OVERLAY, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.CERAUNUS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(CERAUNUS_TEXTURE), hasFoil, (p, b) -> CERAUNUS_MODEL.renderToBuffer(p, b, combinedLightIn, OverlayTexture.NO_OVERLAY, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_GUARD.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(GAUNTLET_OF_GUARD_TEXTURE), hasFoil, (p, b) -> GAUNTLET_OF_GUARD_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(GAUNTLET_OF_GUARD_LAYER_TEXTURE), hasFoil, (p, b) -> GAUNTLET_OF_GUARD_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_BULWARK.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(GAUNTLET_OF_BULWARK_TEXTURE), hasFoil, (p, b) -> GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(GAUNTLET_OF_BULWARK_LAYER_TEXTURE), hasFoil, (p, b) -> GAUNTLET_OF_BULWARK_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GAUNTLET_OF_MAELSTROM.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(GAUNTLET_OF_MAELSTROM_TEXTURE), hasFoil, (p, b) -> GAUNTLET_OF_MAELSTROM_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(GAUNTLET_OF_MAELSTROM_LAYER_TEXTURE), hasFoil, (p, b) -> GAUNTLET_OF_MAELSTROM_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.THE_INCINERATOR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(THE_INCINERATOR_TEXTURE), hasFoil, (p, b) -> THE_INCINERATOR_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.WITHER_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(WASW_TEXTURE), hasFoil, (p, b) -> WASW_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(WASW_LAYER_TEXTURE), hasFoil, (p, b) -> WASW_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.VOID_ASSULT_SHOULDER_WEAPON.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(VASW_TEXTURE), hasFoil, (p, b) -> WASW_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(VASW_LAYER_TEXTURE), hasFoil, (p, b) -> WASW_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.CORAL_SPEAR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(CORAL_SPEAR_TEXTURE), hasFoil, (p, b) -> CORAL_SPEAR_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.CORAL_BARDICHE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(CORAL_BARDICHE_TEXTURE), hasFoil, (p, b) -> CORAL_BARDICHE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.VOID_FORGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(VOID_FORGE_TEXTURE), hasFoil, (p, b) -> VOID_FORGE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(VOID_FORGE_LAYER_TEXTURE), hasFoil, (p, b) -> VOID_FORGE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.BRONTES.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(BRONTES_TEXTURE), hasFoil, (p, b) -> BRONTES_MODEL.renderToBuffer(p, b, combinedLightIn, OverlayTexture.NO_OVERLAY, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(BRONTES_LAYER_TEXTURE), hasFoil, (p, b) -> BRONTES_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.INFERNAL_FORGE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(INFERNAL_FORGE_TEXTURE), hasFoil, (p, b) -> INFERNAL_FORGE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(INFERNAL_FORGE_LAYER_TEXTURE), hasFoil, (p, b) -> INFERNAL_FORGE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.TIDAL_CLAWS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(TIDAL_CLAWS_TEXTURE), hasFoil, (p, b) -> TIDAL_CLAWS_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.MEAT_SHREDDER.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(MEAT_SHREDDER_TEXTURE), hasFoil, (p, b) -> MEAT_SHREDDER_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.CMEyes(MEAT_SHREDDER_LAYER_TEXTURE), hasFoil, (p, b) -> MEAT_SHREDDER_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            MEAT_SHREDDER_MODEL.animateStack(itemStackIn);
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.LASER_GATLING.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            float ageInTicks = Minecraft.getInstance().player == null ? 0.0f : (float)Minecraft.getInstance().player.tickCount + partialTick;
            float openAmount = Minecraft.getInstance().player != null && Laser_Gatling.isCharged(itemStackIn) ? (float)Minecraft.getInstance().player.tickCount + partialTick : 0.0f;
            LASER_GATLING_MODEL.setupAnim(null, openAmount, 0.0f, ageInTicks, 0.0f, 0.0f);
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(LASER_GATLING_TEXTURE), hasFoil, (p, b) -> LASER_GATLING_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.eyes(LASER_GATLING_LAYER_TEXTURE), hasFoil, (p, b) -> LASER_GATLING_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ANCIENT_SPEAR.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(ANCIENT_SPEAR_TEXTURE), hasFoil, (p, b) -> ANCIENT_SPEAR_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.is(ModItems.CURSED_BOW.get())) {
            float ageInTicks = Minecraft.getInstance().player == null ? 0.0f : (float)Minecraft.getInstance().player.tickCount + partialTick;
            float pullAmount = Cursed_bow.getPullingAmount(itemStackIn, partialTick);
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            CURSED_BOW_MODEL.setupAnim(null, pullAmount, ageInTicks, 0.0f, 0.0f, 0.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(CURSED_BOW_TEXTURE), hasFoil, (p, b) -> CURSED_BOW_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGhost(CURSED_BOW_GHOST_TEXTURE), hasFoil, (p, b) -> CURSED_BOW_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.is(ModItems.WRATH_OF_THE_DESERT.get())) {
            float ageInTicks = Minecraft.getInstance().player == null ? 0.0f : (float)Minecraft.getInstance().player.tickCount + partialTick;
            float pullAmount = Wrath_of_the_desert.getPullingAmount(itemStackIn, partialTick);
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            WRATH_OF_DESERT_MODEL.setupAnim(null, pullAmount, ageInTicks, ageInTicks, 0.0f, 0.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(WRATH_OF_DESERT_TEXTURE), hasFoil, (p, b) -> WRATH_OF_DESERT_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGhost(WRATH_OF_DESERT_GHOST_TEXTURE), hasFoil, (p, b) -> WRATH_OF_DESERT_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.is(ModItems.SOUL_RENDER.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(SOUL_RENDER_TEXTURE), hasFoil, (p, b) -> SOUL_RENDER.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGhost(SOUL_RENDER_GHOST_TEXTURE), hasFoil, (p, b) -> SOUL_RENDER.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.is(ModItems.THE_ANNIHILATOR.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(THE_ANNIHILATOR_TEXTURE), hasFoil, (p, b) -> THE_ANNIHILATOR.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGhost(THE_ANNIHILATOR_GHOST_TEXTURE), hasFoil, (p, b) -> THE_ANNIHILATOR.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.is(ModItems.THE_IMMOLATOR.get())) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 0.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            this.drawModel(matrixStackIn, bufferIn, order, RenderTypes.armorCutoutNoCull(THE_IMMOLATOR_TEXTURE), hasFoil, (p, b) -> THE_IMMOLATOR_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGhost(THE_IMMOLATOR_GHOST_TEXTURE), hasFoil, (p, b) -> THE_IMMOLATOR_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_FIRE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_FIRE_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(ALTAR_OF_FIRE_TEXTURE), hasFoil, (p, b) -> ALTAR_OF_FIRE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGlowingEffect(this.getIdleTexture((int)((float)tick * 0.5f % 7.0f))), false, (p, b) -> ALTAR_OF_FIRE_MODEL.renderToBuffer(p, b, combinedLightIn, OverlayTexture.NO_OVERLAY, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_VOID.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_VOID_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(ALTAR_OF_VOID_TEXTURE), hasFoil, (p, b) -> ALTAR_OF_VOID_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_AMETHYST.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_AMETHYST_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(ALTAR_OF_AMETHYST_TEXTURE), hasFoil, (p, b) -> ALTAR_OF_AMETHYST_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ALTAR_OF_ABYSS.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ALTAR_OF_ABYSS_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(ALTAR_OF_ABYSS_TEXTURE), hasFoil, (p, b) -> ALTAR_OF_ABYSS_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.EMP.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            EMP_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(EMP_TEXTURE), hasFoil, (p, b) -> EMP_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.MECHANICAL_FUSION_ANVIL.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            MF_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(MIF_TEXTURE), hasFoil, (p, b) -> MF_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.ABYSSAL_EGG.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            ABYSSAL_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(ABYSSAL_EGG_TEXTURE), hasFoil, (p, b) -> ABYSSAL_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.getGhost(ABYSSAL_EGG_LAYER_TEXTURE), hasFoil, (p, b) -> ABYSSAL_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.GODDESS_STATUE.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            GODDESS_STATUE_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(STATUE_TEXTURE), hasFoil, (p, b) -> GODDESS_STATUE_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
        if (itemStackIn.getItem() == ModItems.BOSS_RESPAWNER.get()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5f, 1.5f, 0.5f);
            matrixStackIn.scale(1.0f, -1.0f, -1.0f);
            SPAWNER_MODEL.resetToDefaultPose();
            this.drawModel(matrixStackIn, bufferIn, order, CMRenderTypes.entityCutoutNoCull(SPAWNER_TEXTURE), hasFoil, (p, b) -> SPAWNER_MODEL.renderToBuffer(p, b, combinedLightIn, combinedOverlayIn, -1));
            matrixStackIn.popPose();
        }
    }

    @Override
    public void getExtents(java.util.function.Consumer<org.joml.Vector3fc> output) {
    }

    private interface Geom {
        void render(PoseStack pose, VertexConsumer buffer);
    }

    /*
     * Submits one model draw at the next layer order; replicates the old
     * ItemRenderer.getArmorFoilBuffer behavior by adding an extra glint pass when foil.
     */


    private void drawModel(PoseStack pose, SubmitNodeCollector collector, int[] order, RenderType renderType, boolean foil, Geom geom) {
        int o = order[0]++;
        collector.order(o).submitCustomGeometry(pose, renderType, (poseSnapshot, buffer) -> {
            PoseStack wrapped = new PoseStack();
            wrapped.mulPose(poseSnapshot.pose());
            geom.render(wrapped, buffer);
        });
        if (foil) {
            collector.order(order[0]++).submitCustomGeometry(pose, RenderTypes.entityGlint(), (poseSnapshot, buffer) -> {
                PoseStack wrapped = new PoseStack();
                wrapped.mulPose(poseSnapshot.pose());
                geom.render(wrapped, buffer);
            });
        }
    }

    private Identifier getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[Mth.clamp(age, 0, 7)];
    }

    public record Unbaked() implements SpecialModelRenderer.Unbaked<ItemStack> {
        public static final Unbaked INSTANCE = new Unbaked();
        public static final MapCodec<Unbaked> MAP_CODEC = MapCodec.unit(INSTANCE);

        @Override
        public MapCodec<Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public CMItemstackRenderer bake(SpecialModelRenderer.BakingContext context) {
            return new CMItemstackRenderer();
        }
    }
}
