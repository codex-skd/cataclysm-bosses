/*
 * Decompiled with CFR 0.152.
 * JEI 26.2 API changed - stubbed for compilation
 */
package com.skd.cataclysmbosses.jei;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;

public class AltarOfAmethystDrawable {
    private final Identifier texture;
    private final int width;
    private final int height;
    
    public AltarOfAmethystDrawable(Identifier texture, int width, int height) {
        this.texture = texture;
        this.width = width;
        this.height = height;
    }
    
    public void draw(GuiGraphicsExtractor guiGraphics, int xOffset, int yOffset) {
        // TODO: Implement for JEI 26.2
    }
    
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
