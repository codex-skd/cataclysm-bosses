/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.fml.event.config.ModConfigEvent$Loading
 *  net.neoforged.fml.event.config.ModConfigEvent$Reloading
 *  net.neoforged.neoforge.common.ModConfigSpec
 *  net.neoforged.neoforge.common.ModConfigSpec$Builder
 *  org.apache.commons.lang3.tuple.Pair
 */
package com.skd.sundering.config;

import com.skd.sundering.config.CMClientConfig;
import com.skd.sundering.config.CMCommonConfig;
import com.skd.sundering.config.ClientConfig;
import com.skd.sundering.config.CommonConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class ConfigHolder {
    public static final ModConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;
    public static final ModConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;

    public static void onModConfigLoadingEvent(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == CLIENT_SPEC) {
            CMClientConfig.Clientbake(CLIENT);
        }
        if (event.getConfig().getSpec() == COMMON_SPEC) {
            CMCommonConfig.Commonbake(COMMON);
        }
    }

    public static void onModConfigReloadEvent(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == CLIENT_SPEC) {
            CMClientConfig.Clientbake(CLIENT);
        }
        if (event.getConfig().getSpec() == COMMON_SPEC) {
            CMCommonConfig.Commonbake(COMMON);
        }
    }

    static {
        Pair specPair = new ModConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = (CommonConfig)specPair.getLeft();
        COMMON_SPEC = (ModConfigSpec)specPair.getRight();
        Pair clientSpecPair = new ModConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT = (ClientConfig)clientSpecPair.getLeft();
        CLIENT_SPEC = (ModConfigSpec)clientSpecPair.getRight();
    }
}

