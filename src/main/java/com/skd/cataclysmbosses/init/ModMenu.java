/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.flag.FeatureFlags
 *  net.minecraft.world.inventory.MenuType
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.cataclysmbosses.init;

import com.skd.cataclysmbosses.inventory.WeaponfusionMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenu {
    public static final DeferredRegister<MenuType<?>> DEF_REG = DeferredRegister.create((ResourceKey)Registries.MENU, (String)"cataclysm");
    public static final DeferredHolder<MenuType<?>, MenuType<WeaponfusionMenu>> WEAPON_FUSION = DEF_REG.register("weapon_fusion", () -> new MenuType(WeaponfusionMenu::new, FeatureFlags.DEFAULT_FLAGS));
}

