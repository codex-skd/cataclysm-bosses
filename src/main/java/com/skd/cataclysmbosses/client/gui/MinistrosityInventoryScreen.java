/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGraphicsExtractor
 *  net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
 *  net.minecraft.client.gui.screens.inventory.InventoryScreen
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Inventory
 *  net.minecraft.world.inventory.AbstractContainerMenu
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.gui;

import com.skd.cataclysmbosses.entity.Pet.Netherite_Ministrosity_Entity;
import com.skd.cataclysmbosses.inventory.MinistrostiyMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class MinistrosityInventoryScreen
extends AbstractContainerScreen<MinistrostiyMenu> {
    private static final Identifier HORSE_INVENTORY_LOCATION = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/ministrosity2.png");
    private final Netherite_Ministrosity_Entity mini;
    private final int inventoryColumns;
    private float xMouse;
    private float yMouse;

    public MinistrosityInventoryScreen(MinistrostiyMenu p_98817_, Inventory p_98818_, Netherite_Ministrosity_Entity p_98819_, int p_352203_) {
        super((AbstractContainerMenu)p_98817_, p_98818_, p_98819_.getDisplayName());
        this.mini = p_98819_;
        this.inventoryColumns = p_352203_;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor p_282553_, float p_282998_, int p_282929_, int p_283133_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_282553_.blit(HORSE_INVENTORY_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
        p_282553_.blit(HORSE_INVENTORY_LOCATION, i + 70, j + 17, 0, this.imageHeight, this.inventoryColumns * 18, 54);
        InventoryScreen.extractEntityInInventoryFollowsMouse(p_282553_, i - 10, j + 18, i + 78, j + 70, 34, 0.0f, this.xMouse, this.yMouse, (LivingEntity)this.mini);
    }
    
    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        this.xMouse = mouseX;
        this.yMouse = mouseY;
        super.extractRenderState(graphics, mouseX, mouseY, partialTick);
    }
}