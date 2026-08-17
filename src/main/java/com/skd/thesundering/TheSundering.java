/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.common.Mod
 *  net.neoforged.fml.config.IConfigSpec
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.neoforged.fml.loading.FMLLoader
 *  net.neoforged.neoforge.client.event.EntityRenderersEvent$RegisterLayerDefinitions
 *  net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
 *  net.neoforged.neoforge.network.registration.PayloadRegistrar
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package com.skd.thesundering;

import com.skd.thesundering.ClientProxy;
import com.skd.thesundering.ServerProxy;
import com.skd.thesundering.client.event.ClientEvent;
import com.skd.thesundering.client.event.ClientSetup;
import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.config.ConfigHolder;
import com.skd.thesundering.init.ModAttribute;
import com.skd.thesundering.init.ModBiomeModifiers;
import com.skd.thesundering.init.ModBlocks;
import com.skd.thesundering.init.ModDataAttachments;
import com.skd.thesundering.init.ModDataComponents;
import com.skd.thesundering.init.ModEffect;
import com.skd.thesundering.init.ModEntities;
import com.skd.thesundering.init.ModEntityDataSerializers;
import com.skd.thesundering.init.ModGroup;
import com.skd.thesundering.init.ModItems;
import com.skd.thesundering.init.ModJigsaw;
import com.skd.thesundering.init.ModMenu;
import com.skd.thesundering.init.ModParticle;
import com.skd.thesundering.init.ModRecipeSerializers;
import com.skd.thesundering.init.ModRecipeTypes;
import com.skd.thesundering.init.ModSounds;
import com.skd.thesundering.init.ModStructureModifiers;
import com.skd.thesundering.init.ModStructurePlacementType;
import com.skd.thesundering.init.ModStructureProcessor;
import com.skd.thesundering.init.ModStructures;
import com.skd.thesundering.init.ModTileentites;
import com.skd.thesundering.items.Armortier;
import com.skd.thesundering.message.MessageArmorKey;
import com.skd.thesundering.message.MessageBossBar;
import com.skd.thesundering.message.MessageCMMultipart;
import com.skd.thesundering.message.MessageCameraZoom;
import com.skd.thesundering.message.MessageCharge;
import com.skd.thesundering.message.MessageEntityCameraSwitch;
import com.skd.thesundering.message.MessageHookFalling;
import com.skd.thesundering.message.MessageMeatShredder;
import com.skd.thesundering.message.MessageMovePlayer;
import com.skd.thesundering.message.MessageMusic;
import com.skd.thesundering.message.MessageOpenInventory;
import com.skd.thesundering.message.MessageParticle;
import com.skd.thesundering.message.MessageRenderRush;
import com.skd.thesundering.message.MessageSwingArm;
import com.skd.thesundering.message.MessageTidalTentacle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value="the_sundering")
public class TheSundering {
    public static final String MODID = "the_sundering";
    public static final Logger LOGGER = LogManager.getLogger((String)"the_sundering");
    public static ServerProxy PROXY;

    public TheSundering(IEventBus bus, Dist dist, ModContainer modContainer) {
        bus.addListener(this::setup);
        bus.addListener(this::setupPackets);
        PROXY = FMLLoader.getDist().isClient() ? new ClientProxy() : new ServerProxy();
        ModGroup.DEF_REG.register(bus);
        bus.addListener(this::setupEntityModelLayers);
        bus.addListener(ConfigHolder::onModConfigLoadingEvent);
        bus.addListener(ConfigHolder::onModConfigReloadEvent);
        if (dist.isClient()) {
            ClientSetup.ClientSetupevent(bus);
            ClientEvent.ClientEvent();
        }
        PROXY.init();
        bus.addListener(ModItems::modifyComponents);
        ModDataAttachments.ATTACHMENT_TYPES.register(bus);
        ModDataComponents.COMPONENTS.register(bus);
        ModEntityDataSerializers.DEF_REG.register(bus);
        ModItems.ITEMS.register(bus);
        Armortier.ARMOR_MATERIALS.register(bus);
        ModEffect.EFFECTS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModParticle.PARTICLE.register(bus);
        ModStructures.STRUCTURE_PIECE_DEF_REG.register(bus);
        ModStructures.STRUCTURE_TYPE_DEF_REG.register(bus);
        ModStructureProcessor.STRUCTURE_PROCESSOR.register(bus);
        ModTileentites.TILE_ENTITY_TYPES.register(bus);
        ModEntities.ENTITY_TYPE.register(bus);
        ModAttribute.ATTRIBUTES.register(bus);
        ModSounds.SOUNDS.register(bus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
        ModRecipeTypes.RECIPE_TYPES.register(bus);
        ModBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(bus);
        ModStructureModifiers.STRUCTURE_MODIFIER_SERIALIZERS.register(bus);
        ModMenu.DEF_REG.register(bus);
        ModStructurePlacementType.STRUCTURE_PLACEMENT_TYPES.register(bus);
        modContainer.registerConfig(ModConfig.Type.CLIENT, (IConfigSpec)ConfigHolder.CLIENT_SPEC, String.format("%s-client.toml", MODID));
        modContainer.registerConfig(ModConfig.Type.COMMON, (IConfigSpec)ConfigHolder.COMMON_SPEC, String.format("%s-common.toml", MODID));
    }

    private void setupEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        CMModelLayers.register(event);
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(ModItems::initDispenser);
        event.enqueueWork(ModJigsaw::new);
    }

    public void setupPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID).versioned("1.0.0").optional();
        registrar.playToServer(MessageSwingArm.TYPE, MessageSwingArm.STREAM_CODEC, MessageSwingArm::handle);
        registrar.playToServer(MessageArmorKey.TYPE, MessageArmorKey.STREAM_CODEC, MessageArmorKey::handle);
        registrar.playToClient(MessageHookFalling.TYPE, MessageHookFalling.STREAM_CODEC, MessageHookFalling::handle);
        registrar.playToClient(MessageCharge.TYPE, MessageCharge.STREAM_CODEC, MessageCharge::handle);
        registrar.playToClient(MessageRenderRush.TYPE, MessageRenderRush.STREAM_CODEC, MessageRenderRush::handle);
        registrar.playToClient(MessageParticle.TYPE, MessageParticle.STREAM_CODEC, MessageParticle::handle);
        registrar.playToClient(MessageTidalTentacle.TYPE, MessageTidalTentacle.STREAM_CODEC, MessageTidalTentacle::handle);
        registrar.playToClient(MessageBossBar.Display.TYPE, MessageBossBar.Display.STREAM_CODEC, MessageBossBar.Display::execute);
        registrar.playToClient(MessageBossBar.Remove.TYPE, MessageBossBar.Remove.STREAM_CODEC, MessageBossBar.Remove::execute);
        registrar.playToClient(MessageEntityCameraSwitch.FirstPerson.TYPE, MessageEntityCameraSwitch.FirstPerson.STREAM_CODEC, MessageEntityCameraSwitch.FirstPerson::execute);
        registrar.playToClient(MessageEntityCameraSwitch.ThridPerson.TYPE, MessageEntityCameraSwitch.ThridPerson.STREAM_CODEC, MessageEntityCameraSwitch.ThridPerson::execute);
        registrar.playToClient(MessageCMMultipart.TYPE, MessageCMMultipart.STREAM_CODEC, MessageCMMultipart::handle);
        registrar.playToClient(MessageOpenInventory.TYPE, MessageOpenInventory.STREAM_CODEC, MessageOpenInventory::handle);
        registrar.playToClient(MessageMusic.TYPE, MessageMusic.STREAM_CODEC, MessageMusic::handle);
        registrar.playToClient(MessageMeatShredder.TYPE, MessageMeatShredder.STREAM_CODEC, MessageMeatShredder::handle);
        registrar.playToClient(MessageMovePlayer.TYPE, MessageMovePlayer.STREAM_CODEC, MessageMovePlayer::handle);
        registrar.playToClient(MessageCameraZoom.TYPE, MessageCameraZoom.STREAM_CODEC, MessageCameraZoom::execute);
    }
}

