/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument$Type
 */
package com.skd.cataclysmbosses.blocks.Property;

import com.skd.cataclysmbosses.init.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public enum CustomNoteBlockInstrument {
    KOBOLEDIATOR("kobolediator", (Holder)ModSounds.NOTE_BLOCK_IMITATE_KOBOLEDIATOR),
    APTRGANGR("aptrgangr", (Holder)ModSounds.NOTE_BLOCK_IMITATE_APTRGANGR),
    DRAUGR("draugr", (Holder)ModSounds.NOTE_BLOCK_IMITATE_DRAUGR);

    private final String string;
    private final Holder<SoundEvent> soundEvent;

    private CustomNoteBlockInstrument(String string2, Holder sound) {
        this.string = string2;
        this.soundEvent = sound;
    }

    public Object getType() {
        try {
            Class<?> typeClass = Class.forName("net.minecraft.world.level.block.state.properties.NoteBlockInstrument$Type");
            @SuppressWarnings("unchecked")
            Object mobHead = Enum.valueOf((Class<Enum>) typeClass, "MOB_HEAD");
            return mobHead;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Holder<SoundEvent> getSoundEvent() {
        return this.soundEvent;
    }

    public String getString() {
        return this.string;
    }

    public NoteBlockInstrument get() {
        return NoteBlockInstrument.valueOf((String)this.name());
    }
}