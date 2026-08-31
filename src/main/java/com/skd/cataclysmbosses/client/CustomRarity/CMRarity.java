/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.item.Rarity
 *  net.neoforged.fml.common.asm.enumextension.EnumProxy
 */
package com.skd.cataclysmbosses.client.CustomRarity;

import net.minecraft.ChatFormatting;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

public class CMRarity {
    // PORT TODO(26.2): Rarity's ctor is now (int id, String name, ChatFormatting color) — it no
    // longer takes a UnaryOperator<Style>, so the animated getPulsingColor() styling is gone.
    // Falls back to the nearest static ChatFormatting until a name/style hook exists again.
    public static final EnumProxy<Rarity> MALEDICTUS_PROXY = new EnumProxy<Rarity>(Rarity.class, -1, "cataclysm:maledictus", ChatFormatting.DARK_PURPLE);
    public static final EnumProxy<Rarity> IGNITIUM_PROXY = new EnumProxy<Rarity>(Rarity.class, -1, "cataclysm:ignitium", ChatFormatting.GOLD);
    public static final EnumProxy<Rarity> MALGNIS_PROXY = new EnumProxy<Rarity>(Rarity.class, -1, "cataclysm:malgis", ChatFormatting.LIGHT_PURPLE);

    @SuppressWarnings("unused")
    private static int getPulsingColor(long cycle, int color1, int color2) {
        float progress = (float)(Math.sin((double)(System.currentTimeMillis() % cycle) / (double)cycle * 2.0 * Math.PI) + 1.0) / 2.0f;
        int R1 = color1 >> 16 & 0xFF;
        int G1 = color1 >> 8 & 0xFF;
        int B1 = color1 & 0xFF;
        int R2 = color2 >> 16 & 0xFF;
        int G2 = color2 >> 8 & 0xFF;
        int B2 = color2 & 0xFF;
        int r = (int)Mth.lerp((float)progress, (float)R1, (float)R2);
        int g = (int)Mth.lerp((float)progress, (float)G1, (float)G2);
        int b = (int)Mth.lerp((float)progress, (float)B1, (float)B2);
        return r << 16 | g << 8 | b;
    }
}

