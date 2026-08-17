/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance$Attenuation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 */
package com.skd.sundering.client.sound;

import com.skd.sundering.client.sound.BossMusicPlayer;
import com.skd.sundering.client.tool.ControlledAnimation;
import com.skd.sundering.config.CMClientConfig;
import com.skd.sundering.entity.etc.Animation_Monsters;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class BossMusicSound
extends AbstractTickableSoundInstance {
    private Animation_Monsters boss;
    private int ticksExisted = 0;
    private int timeUntilFade;
    private final SoundEvent soundEvent;
    ControlledAnimation volumeControl;

    public BossMusicSound(SoundEvent sound, Animation_Monsters boss) {
        super(sound, SoundSource.RECORDS, boss.getRandom());
        this.boss = boss;
        this.soundEvent = sound;
        this.attenuation = SoundInstance.Attenuation.NONE;
        this.looping = true;
        this.delay = 0;
        this.x = boss.getX();
        this.y = boss.getY();
        this.z = boss.getZ();
        this.volumeControl = new ControlledAnimation(40);
        this.volumeControl.setTimer(20);
        this.volume = this.volumeControl.getAnimationFraction();
        this.timeUntilFade = 80;
    }

    public boolean canPlaySound() {
        return BossMusicPlayer.bossMusic == this;
    }

    public void tick() {
        if (this.boss == null || !this.boss.isAlive() || this.boss.isSilent()) {
            if (this.boss != null && !this.boss.isAlive()) {
                this.timeUntilFade = 0;
            }
            this.boss = null;
            if (this.timeUntilFade > 0) {
                --this.timeUntilFade;
            } else {
                this.volumeControl.decreaseTimer();
            }
        } else {
            this.volumeControl.increaseTimer();
            this.timeUntilFade = 20;
        }
        if ((double)this.volumeControl.getAnimationFraction() < 0.025) {
            this.stop();
            BossMusicPlayer.bossMusic = null;
        }
        this.volume = this.volumeControl.getAnimationFraction() / (float)CMClientConfig.BossMusicVolume;
        if (this.ticksExisted % 100 == 0) {
            Minecraft.getInstance().getMusicManager().stopPlaying();
        }
        ++this.ticksExisted;
    }

    public void setBoss(Animation_Monsters boss) {
        this.boss = boss;
    }

    public Animation_Monsters getBoss() {
        return this.boss;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }
}

