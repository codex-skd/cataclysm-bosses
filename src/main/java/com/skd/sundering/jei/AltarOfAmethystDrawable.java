/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.gui.drawable.IDrawable
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.Identifier
 */
package com.skd.sundering.jei;

import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.Identifier;

public class AltarOfAmethystDrawable
implements IDrawable {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/altar_of_amethyst_jei.png");

    public int getWidth() {
        return 125;
    }

    public int getHeight() {
        return 59;
    }

    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        int i = xOffset;
        int j = yOffset;
        guiGraphics.blit(TEXTURE, i, j, 0.0f, 0.0f, 125, 59, 256, 256);
    }
}

