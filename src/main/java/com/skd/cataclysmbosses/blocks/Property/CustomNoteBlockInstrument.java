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
    KOBOLEDIATOR("kobolediator", (Holder)ModSounds.NOTE_BLOCK_IMITATE_KOBOLEDIATOR, NoteBlockInstrument.Type.MOB_HEAD),
    APTRGANGR("aptrgangr", (Holder)ModSounds.NOTE_BLOCK_IMITATE_APTRGANGR, NoteBlockInstrument.Type.MOB_HEAD),
    DRAUGR("draugr", (Holder)ModSounds.NOTE_BLOCK_IMITATE_DRAUGR, NoteBlockInstrument.Type.MOB_HEAD);

    private final String string;
    private final Holder<SoundEvent> soundEvent;
    private final NoteBlockInstrument.Type type;

    private CustomNoteBlockInstrument(String string2, Holder sound, NoteBlockInstrument.Type type) {
        this.string = string2;
        this.soundEvent = sound;
        this.type = type;
    }

    public NoteBlockInstrument.Type getType() {
        return this.type;
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