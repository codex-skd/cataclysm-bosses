/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument
 *  net.minecraft.world.level.block.state.properties.NoteBlockInstrument$Type
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.skd.sundering.mixin;

import com.skd.sundering.blocks.Property.CustomNoteBlockInstrument;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NoteBlockInstrument.class})
public class NoteBlockInstrumentMixin {
    @Shadow
    @Mutable
    @Final
    private static NoteBlockInstrument[] $VALUES;

    @Invoker(value="<init>")
    public static NoteBlockInstrument newInstrument(String name, int id, String enumName, Holder sound, NoteBlockInstrument.Type type) {
        throw new AssertionError();
    }

    @Inject(method={"<clinit>"}, at={@At(value="FIELD", target="Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;$VALUES:[Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;", shift=At.Shift.AFTER)})
    private static void US$addCustomInstruments(CallbackInfo ci) {
        ArrayList<NoteBlockInstrument> instruments = new ArrayList<NoteBlockInstrument>(Arrays.asList($VALUES));
        NoteBlockInstrument last = (NoteBlockInstrument)instruments.get(instruments.size() - 1);
        int i = 1;
        for (CustomNoteBlockInstrument instrument : CustomNoteBlockInstrument.values()) {
            instruments.add(NoteBlockInstrumentMixin.newInstrument(instrument.name(), last.ordinal() + i, instrument.getString(), instrument.getSoundEvent(), instrument.getType()));
            ++i;
        }
        $VALUES = instruments.toArray(new NoteBlockInstrument[0]);
    }
}

