/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.neoforge.common.ModConfigSpec$BooleanValue
 *  net.neoforged.neoforge.common.ModConfigSpec$Builder
 *  net.neoforged.neoforge.common.ModConfigSpec$DoubleValue
 *  net.neoforged.neoforge.common.ModConfigSpec$IntValue
 */
package com.skd.thesundering.config;

import com.skd.thesundering.config.CMClientConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {
    private static final String LANG_PREFIX = "config.cataclysm.";
    public final ModConfigSpec.BooleanValue shadersCompat;
    public final ModConfigSpec.BooleanValue firstPerson;
    public final ModConfigSpec.BooleanValue thirdPerson;
    public final ModConfigSpec.BooleanValue ScreenShake;
    public final ModConfigSpec.BooleanValue custombossbar;
    public final ModConfigSpec.BooleanValue BossMusic;
    public final ModConfigSpec.IntValue BossMusicVolume;
    public final ModConfigSpec.BooleanValue showLoginNotice;

    public ClientConfig(ModConfigSpec.Builder builder) {
        builder.push("client");
        this.shadersCompat = ClientConfig.buildBoolean(builder, "shadersCompat", CMClientConfig.shadersCompat, "Off the Custom Rendering");
        this.ScreenShake = ClientConfig.buildBoolean(builder, "ScreenShake(on/off)", CMClientConfig.ScreenShake, "ScreenShake(on/off)");
        this.firstPerson = ClientConfig.buildBoolean(builder, "setThirdPerson(on/off)", CMClientConfig.thirdPerson, "Forced viewpoint change when hit by a grab attack");
        this.thirdPerson = ClientConfig.buildBoolean(builder, "setFirstPerson(on/off)", CMClientConfig.firstPerson, "Forced viewpoint change when hit by a grab attack");
        this.custombossbar = ClientConfig.buildBoolean(builder, "custombossbar(on/off)", CMClientConfig.customBossBars, "custombossbar(on/off)");
        this.BossMusic = ClientConfig.buildBoolean(builder, "BossMusic(on/off)", CMClientConfig.BossMusic, "custombossbar(on/off)");
        this.BossMusicVolume = ClientConfig.buildInt(builder, "BossMusicVolume", CMClientConfig.BossMusicVolume, 1, 100, "BossMusicVolume");
        this.showLoginNotice = ClientConfig.buildBoolean(builder, "showLoginNotice(on/off)", CMClientConfig.showLoginNotice, "showLoginNotice(on/off)");
        builder.pop();
    }

    private static ModConfigSpec.BooleanValue buildBoolean(ModConfigSpec.Builder builder, String trans, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).define(trans, defaultValue);
    }

    private static ModConfigSpec.IntValue buildInt(ModConfigSpec.Builder builder, String trans, int defaultValue, int min, int max, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).defineInRange(trans, defaultValue, min, max);
    }

    private static ModConfigSpec.DoubleValue buildDouble(ModConfigSpec.Builder builder, String trans, double defaultValue, double min, double max, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).defineInRange(trans, defaultValue, min, max);
    }
}

