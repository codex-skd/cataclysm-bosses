/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.effect.MobEffect
 *  net.neoforged.neoforge.registries.DeferredHolder
 *  net.neoforged.neoforge.registries.DeferredRegister
 */
package com.skd.sundering.init;

import com.skd.sundering.effects.EffectAbyssal_Burn;
import com.skd.sundering.effects.EffectAbyssal_Curse;
import com.skd.sundering.effects.EffectAbyssal_Fear;
import com.skd.sundering.effects.EffectBlazing_Brand;
import com.skd.sundering.effects.EffectBlessing_Of_Amethyst;
import com.skd.sundering.effects.EffectBone_Fracture;
import com.skd.sundering.effects.EffectCurse_Of_Desert;
import com.skd.sundering.effects.EffectGhostForm;
import com.skd.sundering.effects.EffectGhost_Sickness;
import com.skd.sundering.effects.EffectMonstrous;
import com.skd.sundering.effects.EffectStun;
import com.skd.sundering.effects.EffectWetness;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffect {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create((Registry)BuiltInRegistries.MOB_EFFECT, (String)"cataclysm");
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTMONSTROUS = EFFECTS.register("monstrous", EffectMonstrous::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTBLAZING_BRAND = EFFECTS.register("blazing_brand", EffectBlazing_Brand::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTSTUN = EFFECTS.register("stun", EffectStun::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTABYSSAL_BURN = EFFECTS.register("abyssal_burn", EffectAbyssal_Burn::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTBONE_FRACTURE = EFFECTS.register("bone_fracture", EffectBone_Fracture::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTABYSSAL_FEAR = EFFECTS.register("abyssal_fear", EffectAbyssal_Fear::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTABYSSAL_CURSE = EFFECTS.register("abyssal_curse", EffectAbyssal_Curse::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTBLESSING_OF_AMETHYST = EFFECTS.register("blessing_of_amethyst", EffectBlessing_Of_Amethyst::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTCURSE_OF_DESERT = EFFECTS.register("curse_of_desert", EffectCurse_Of_Desert::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTGHOST_FORM = EFFECTS.register("ghost_form", EffectGhostForm::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTGHOST_SICKNESS = EFFECTS.register("ghost_sickness", EffectGhost_Sickness::new);
    public static final DeferredHolder<MobEffect, MobEffect> EFFECTWETNESS = EFFECTS.register("wetness", EffectWetness::new);
}

