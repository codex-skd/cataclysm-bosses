package com.skd.sundering;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Sundering.MODID)
public class Sundering {

    public static final String MODID = "the_sundering";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public Sundering(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
    }
}
