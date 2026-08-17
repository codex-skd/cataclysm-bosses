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
package com.skd.sundering;

import com.skd.sundering.ClientProxy;
import com.skd.sundering.ServerProxy;
import com.skd.sundering.client.event.ClientEvent;
import com.skd.sundering.client.event.ClientSetup;
import com.skd.sundering.client.model.CMModelLayers;
import com.skd.sundering.config.ConfigHolder;
import com.skd.sundering.init.ModAttribute;
import com.skd.sundering.init.ModBiomeModifiers;
import com.skd.sundering.init.ModBlocks;
import com.skd.sundering.init.ModDataAttachments;
import com.skd.sundering.init.ModDataComponents;
import com.skd.sundering.init.ModEffect;
import com.skd.sundering.init.ModEntities;
import com.skd.sundering.init.ModEntityDataSerializers;
import com.skd.sundering.init.ModGroup;
import com.skd.sundering.init.ModItems;
import com.skd.sundering.init.ModJigsaw;
import com.skd.sundering.init.ModMenu;
import com.skd.sundering.init.ModParticle;
import com.skd.sundering.init.ModRecipeSerializers;
import com.skd.sundering.init.ModRecipeTypes;
import com.skd.sundering.init.ModSounds;
import com.skd.sundering.init.ModStructureModifiers;
import com.skd.sundering.init.ModStructurePlacementType;
import com.skd.sundering.init.ModStructureProcessor;
import com.skd.sundering.init.ModStructures;
import com.skd.sundering.init.ModTileentites;
import com.skd.sundering.items.Armortier;
import com.skd.sundering.message.MessageArmorKey;
import com.skd.sundering.message.MessageBossBar;
import com.skd.sundering.message.MessageCMMultipart;
import com.skd.sundering.message.MessageCameraZoom;
import com.skd.sundering.message.MessageCharge;
import com.skd.sundering.message.MessageEntityCameraSwitch;
import com.skd.sundering.message.MessageHookFalling;
import com.skd.sundering.message.MessageMeatShredder;
import com.skd.sundering.message.MessageMovePlayer;
import com.skd.sundering.message.MessageMusic;
import com.skd.sundering.message.MessageOpenInventory;
import com.skd.sundering.message.MessageParticle;
import com.skd.sundering.message.MessageRenderRush;
import com.skd.sundering.message.MessageSwingArm;
import com.skd.sundering.message.MessageTidalTentacle;
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
public class Sundering {
    public static final String MODID = "the_sundering";
    public static final Logger LOGGER = LogManager.getLogger((String)"the_sundering");
    public static ServerProxy PROXY;

    public Sundering(IEventBus bus, Dist dist, ModContainer modContainer) {
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

