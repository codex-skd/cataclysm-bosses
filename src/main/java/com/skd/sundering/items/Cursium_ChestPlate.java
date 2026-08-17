/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.world.item.ArmorItem$Type
 *  net.minecraft.world.item.equipment.ArmorMaterial
 *  net.minecraft.world.item.Item$Properties
 */
package com.skd.sundering.items;

import com.skd.sundering.items.Cursium_Armor;
import com.skd.sundering.items.LayerArmorPostRender;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;

public class Cursium_ChestPlate
extends Cursium_Armor
implements LayerArmorPostRender {
    public Cursium_ChestPlate(Holder<ArmorMaterial> pMaterial, ArmorItem.Type pType, Item.Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }
}

