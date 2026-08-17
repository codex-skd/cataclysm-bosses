/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.player.Player
 */
package com.skd.sundering.client.sound;

import com.skd.sundering.client.sound.BossMusicSound;
import com.skd.sundering.config.CMClientConfig;
import com.skd.sundering.entity.etc.Animation_Monsters;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public class BossMusicPlayer {
    public static BossMusicSound bossMusic;

    public static void playBossMusic(Animation_Monsters entity) {
        if (!CMClientConfig.BossMusic) {
            return;
        }
        SoundEvent soundEvent = entity.getBossMusic();
        if (soundEvent != null && entity.isAlive()) {
            LocalPlayer player = Minecraft.getInstance().player;
            if (bossMusic != null) {
                float f2 = Minecraft.getInstance().options.getSoundSourceVolume(SoundSource.RECORDS);
                if (f2 <= 0.0f) {
                    bossMusic = null;
                } else if (bossMusic.getBoss() == entity && !entity.canPlayerHearMusic((Player)player)) {
                    bossMusic.setBoss(null);
                } else if (bossMusic.getBoss() == null && bossMusic.getSoundEvent() == soundEvent) {
                    bossMusic.setBoss(entity);
                }
            } else if (entity.canPlayerHearMusic((Player)player)) {
                bossMusic = new BossMusicSound(entity.getBossMusic(), entity);
            }
            if (bossMusic != null && !Minecraft.getInstance().getSoundManager().isActive((SoundInstance)bossMusic)) {
                Minecraft.getInstance().getSoundManager().play((SoundInstance)bossMusic);
            }
        }
    }

    public static void stopBossMusic(Animation_Monsters entity) {
        if (!CMClientConfig.BossMusic) {
            return;
        }
        if (bossMusic != null && bossMusic.getBoss() == entity) {
            bossMusic.setBoss(null);
        }
    }
}

