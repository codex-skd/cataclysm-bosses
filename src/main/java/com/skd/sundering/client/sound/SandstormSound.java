/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.resources.sounds.AbstractTickableSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance$Attenuation
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 */
package com.skd.sundering.client.sound;

import com.skd.sundering.entity.effect.Sandstorm_Entity;
import com.skd.sundering.init.ModSounds;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class SandstormSound
extends AbstractTickableSoundInstance {
    private final Sandstorm_Entity sandstom;

    public SandstormSound(Sandstorm_Entity sandstom) {
        super((SoundEvent)ModSounds.SANDSTORM.get(), SoundSource.HOSTILE, SoundInstance.createUnseededRandom());
        this.sandstom = sandstom;
        this.attenuation = SoundInstance.Attenuation.LINEAR;
        this.looping = true;
        this.x = (float)this.sandstom.getX();
        this.y = (float)this.sandstom.getY();
        this.z = (float)this.sandstom.getZ();
        this.delay = 0;
    }

    public boolean canPlaySound() {
        return this.sandstom.isAlive() && !this.sandstom.isSilent();
    }

    public void tick() {
        this.x = (float)this.sandstom.getX();
        this.y = (float)this.sandstom.getY();
        this.z = (float)this.sandstom.getZ();
        this.volume = 0.05f;
        this.pitch = 1.0f;
    }

    public boolean canStartSilent() {
        return true;
    }

    public boolean isSameEntity(Sandstorm_Entity entity) {
        return this.sandstom.isAlive() && this.sandstom.getId() == entity.getId();
    }
}

