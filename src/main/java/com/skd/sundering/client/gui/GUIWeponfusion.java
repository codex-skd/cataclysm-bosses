/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.inventory.ItemCombinerScreen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.ItemCombinerMenu
 */
package com.skd.sundering.client.gui;

import com.skd.sundering.inventory.WeaponfusionMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ItemCombinerMenu;

public class GUIWeponfusion
extends ItemCombinerScreen<WeaponfusionMenu> {
    private static final Identifier SMITHING_LOCATION = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/fusion.png");

    public GUIWeponfusion(WeaponfusionMenu p_99290_, Inventory p_99291_, Component p_99292_) {
        super((ItemCombinerMenu)p_99290_, p_99291_, p_99292_, SMITHING_LOCATION);
        this.titleLabelX = 66;
        this.titleLabelY = 18;
    }

    protected void renderErrorIcon(GuiGraphics p_282905_, int p_283237_, int p_282237_) {
        if ((((WeaponfusionMenu)this.menu).getSlot(0).hasItem() || ((WeaponfusionMenu)this.menu).getSlot(1).hasItem()) && !((WeaponfusionMenu)this.menu).getSlot(((WeaponfusionMenu)this.menu).getResultSlot()).hasItem()) {
            p_282905_.blit(SMITHING_LOCATION, p_283237_ + 99, p_282237_ + 45, this.imageWidth, 0, 28, 21);
        }
    }
}

