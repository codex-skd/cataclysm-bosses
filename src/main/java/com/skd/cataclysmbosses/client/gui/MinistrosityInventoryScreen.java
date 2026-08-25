/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGraphics
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
import net.minecraft.client.gui.GuiGraphics;
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

    protected void renderBg(GuiGraphics p_282553_, float p_282998_, int p_282929_, int p_283133_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_282553_.blit(HORSE_INVENTORY_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
        p_282553_.blit(HORSE_INVENTORY_LOCATION, i + 70, j + 17, 0, this.imageHeight, this.inventoryColumns * 18, 54);
        InventoryScreen.renderEntityInInventoryFollowsMouse((GuiGraphics)p_282553_, (int)(i - 10), (int)(j + 18), (int)(i + 78), (int)(j + 70), (int)34, (float)0.0f, (float)this.xMouse, (float)this.yMouse, (LivingEntity)this.mini);
    }
//             int i = (this.width - this.imageWidth) / 2;
//             int j = (this.height - this.imageHeight) / 2;
//             p_282553_.blit(HORSE_INVENTORY_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
//             p_282553_.blit(HORSE_INVENTORY_LOCATION, i + 70, j + 17, 0, this.imageHeight, this.inventoryColumns * 18, 54);
//             InventoryScreen.renderEntityInInventoryFollowsMouse((GuiGraphics)p_282553_, (int)(i - 10), (int)(j + 18), (int)(i + 78), (int)(j + 70), (int)34, (float)0.0f, (float)this.xMouse, (float)this.yMouse, (LivingEntity)this.mini);
//         }
//     
//         public void render(GuiGraphics p_281697_, int p_282103_, int p_283529_, float p_283079_) {
//             this.xMouse = p_282103_;
//             this.yMouse = p_283529_;
//             super.render(p_281697_, p_282103_, p_283529_, p_283079_);
//             this.renderTooltip(p_281697_, p_282103_, p_283529_);
//         }
}
