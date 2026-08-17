/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.InputConstants$Type
 *  net.minecraft.client.KeyMapping
 */
package com.skd.sundering.init;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public class ModKeybind {
    public static final KeyMapping KEY_ABILITY = new KeyMapping("key.cataclysm.ability", InputConstants.Type.KEYSYM, 86, "key.categories.cataclysm");
    public static final KeyMapping HELMET_KEY_ABILITY = new KeyMapping("key.cataclysm.helmet_ability", InputConstants.Type.KEYSYM, 67, "key.categories.cataclysm");
    public static final KeyMapping CHESTPLATE_KEY_ABILITY = new KeyMapping("key.cataclysm.chestplate_ability", InputConstants.Type.KEYSYM, 89, "key.categories.cataclysm");
    public static final KeyMapping BOOTS_KEY_ABILITY = new KeyMapping("key.cataclysm.boots_ability", InputConstants.Type.KEYSYM, 86, "key.categories.cataclysm");
}

