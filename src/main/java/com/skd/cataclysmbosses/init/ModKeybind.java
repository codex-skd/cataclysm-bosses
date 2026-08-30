/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.InputConstants$Type
 *  net.minecraft.client.KeyMapping
 */
package com.skd.cataclysmbosses.init;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class ModKeybind {
    private static final KeyMapping.Category CAT = KeyMapping.Category.register(Identifier.fromNamespaceAndPath("cataclysm", "main"));
    public static final KeyMapping KEY_ABILITY = new KeyMapping("key.cataclysm.ability", InputConstants.Type.KEYSYM, 86, CAT);
    public static final KeyMapping HELMET_KEY_ABILITY = new KeyMapping("key.cataclysm.helmet_ability", InputConstants.Type.KEYSYM, 67, CAT);
    public static final KeyMapping CHESTPLATE_KEY_ABILITY = new KeyMapping("key.cataclysm.chestplate_ability", InputConstants.Type.KEYSYM, 89, CAT);
    public static final KeyMapping BOOTS_KEY_ABILITY = new KeyMapping("key.cataclysm.boots_ability", InputConstants.Type.KEYSYM, 86, CAT);
}

