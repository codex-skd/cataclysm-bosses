/*
 * Decompiled with CFR 0.152.
 */
package com.skd.thesundering.config;

import com.skd.thesundering.Cataclysm;
import com.skd.thesundering.config.ClientConfig;

public class CMClientConfig {
    public static boolean shadersCompat = false;
    public static boolean firstPerson = true;
    public static boolean thirdPerson = true;
    public static boolean ScreenShake = true;
    public static boolean BossMusic = true;
    public static int BossMusicVolume = 1;
    public static boolean customBossBars = true;
    public static boolean showLoginNotice = true;

    public static void Clientbake(ClientConfig config) {
        try {
            shadersCompat = (Boolean)config.shadersCompat.get();
            firstPerson = (Boolean)config.firstPerson.get();
            thirdPerson = (Boolean)config.thirdPerson.get();
            ScreenShake = (Boolean)config.ScreenShake.get();
            BossMusic = (Boolean)config.BossMusic.get();
            BossMusicVolume = (Integer)config.BossMusicVolume.get();
            customBossBars = (Boolean)config.custombossbar.get();
            showLoginNotice = (Boolean)config.showLoginNotice.get();
        }
        catch (Exception e) {
            Cataclysm.LOGGER.warn("An exception was caused trying to load the config for CM");
            e.printStackTrace();
        }
    }
}

