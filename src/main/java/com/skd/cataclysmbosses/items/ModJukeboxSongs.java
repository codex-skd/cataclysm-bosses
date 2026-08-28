/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Util
 *  net.minecraft.core.Holder
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.data.worldgen.BootstrapContext
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.item.JukeboxSong
 */
package com.skd.cataclysmbosses.items;

import com.skd.cataclysmbosses.init.ModSounds;
import net.minecraft.util.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

public interface ModJukeboxSongs {
    public static final ResourceKey<JukeboxSong> IGNIS_THEME = ModJukeboxSongs.registerKey("ignis_theme");
    public static final ResourceKey<JukeboxSong> ENDERGUARDIAN_THEME = ModJukeboxSongs.registerKey("enderguardian_theme");
    public static final ResourceKey<JukeboxSong> HARBINGER_THEME = ModJukeboxSongs.registerKey("harbinger_theme");
    public static final ResourceKey<JukeboxSong> MONSTROSITY_THEME = ModJukeboxSongs.registerKey("monstrosity_theme");
    public static final ResourceKey<JukeboxSong> REMNANT_THEME = ModJukeboxSongs.registerKey("remnant_theme");
    public static final ResourceKey<JukeboxSong> LEVIATHAN_THEME = ModJukeboxSongs.registerKey("leviathan_theme");
    public static final ResourceKey<JukeboxSong> MALEDICTUS_THEME = ModJukeboxSongs.registerKey("maledictus_theme");
    public static final ResourceKey<JukeboxSong> SCYLLA_THEME = ModJukeboxSongs.registerKey("scylla_theme");
    public static final ResourceKey<JukeboxSong> THE_CATACLYSM_FARER = ModJukeboxSongs.registerKey("the_cataclysmfarer");

    private static ResourceKey<JukeboxSong> registerKey(String p_350505_) {
        return ResourceKey.create((ResourceKey)Registries.JUKEBOX_SONG, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)p_350505_));
    }

    public static void bootstrap(BootstrapContext<JukeboxSong> p_350269_) {
        ModJukeboxSongs.register(p_350269_, IGNIS_THEME, ModSounds.IGNIS_MUSIC_DISC, 153.0f, 15);
        ModJukeboxSongs.register(p_350269_, ENDERGUARDIAN_THEME, ModSounds.ENDERGUARDIAN_MUSIC_DISC, 196.0f, 15);
        ModJukeboxSongs.register(p_350269_, HARBINGER_THEME, ModSounds.HARBINGER_MUSIC, 189.0f, 15);
        ModJukeboxSongs.register(p_350269_, MONSTROSITY_THEME, ModSounds.MONSTROSITY_MUSIC, 289.0f, 15);
        ModJukeboxSongs.register(p_350269_, REMNANT_THEME, ModSounds.REMNANT_MUSIC, 212.0f, 15);
        ModJukeboxSongs.register(p_350269_, LEVIATHAN_THEME, ModSounds.LEVIATHAN_MUSIC, 291.0f, 15);
        ModJukeboxSongs.register(p_350269_, MALEDICTUS_THEME, ModSounds.MALEDICTUS_MUSIC_DISC, 201.0f, 15);
    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Holder<SoundEvent> sound, float length, int output) {
        context.register(key, (Object)new JukeboxSong(sound, (Component)Component.translatable((String)Util.makeDescriptionId((String)"jukebox_song", (Identifier)key.location())), length, output));
    }
}

