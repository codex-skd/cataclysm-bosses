package com.skd.sundering;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Sundering.MODID)
public class Sundering {

    public static final String MODID = "the_sundering";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public Sundering(IEventBus modEventBus, ModContainer modContainer) {
        // No @SubscribeEvent listeners exist yet (placeholder scaffolding). Registering an
        // instance with zero listener methods now throws IllegalArgumentException in this
        // NeoForge version (was a silent no-op before) -- do not call
        // NeoForge.EVENT_BUS.register(this) / modEventBus.register(this) until there's an
        // actual @SubscribeEvent method to register.
    }
}
