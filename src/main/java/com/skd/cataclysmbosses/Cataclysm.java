package com.skd.cataclysmbosses;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Compatibility class for legacy Cataclysm references.
 * This mod was originally based on Cataclysm, and many files still reference
 * the Cataclysm class. This class provides the same static fields.
 */
public class Cataclysm {
    public static final String MODID = "cataclysm_bosses";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerProxy PROXY;
    
    static {
        // Initialize proxy based on dist
        PROXY = FMLEnvironment.getDist().isClient() ? new ClientProxy() : new ServerProxy();
    }
    
    // Prevent instantiation
    private Cataclysm() {}
}
