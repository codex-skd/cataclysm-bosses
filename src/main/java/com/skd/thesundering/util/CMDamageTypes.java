/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.Nullable
 */
package com.skd.thesundering.util;

import com.skd.thesundering.util.EntityExcludedDamageSource;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CMDamageTypes {
    public static final ResourceKey<DamageType> LASER = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"laser"));
    public static final ResourceKey<DamageType> DEATHLASER = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"deathlaser"));
    public static final ResourceKey<DamageType> EMP = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"emp"));
    public static final ResourceKey<DamageType> ABYSSAL_BURN = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"abyssal_burn"));
    public static final ResourceKey<DamageType> SHREDDER = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"shredder"));
    public static final ResourceKey<DamageType> SWORD_DANCE = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"sword_dance"));
    public static final ResourceKey<DamageType> MALEDICTIO = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"maledictio"));
    public static final ResourceKey<DamageType> MALEDICTIO_SAGITTA = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"maledictio_sagitta"));
    public static final ResourceKey<DamageType> MALEDICTIO_MAGICAE = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"maledictio_magicae"));
    public static final ResourceKey<DamageType> PENETRATE = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"penetrate"));
    public static final ResourceKey<DamageType> MALEDICTIO_ANIMA = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"maledictio_anima"));
    public static final ResourceKey<DamageType> LIGHTNING = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"lightning"));
    public static final ResourceKey<DamageType> STORM_BRINGER = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"storm_bringer"));
    public static final ResourceKey<DamageType> PLAYER_CERAUNUS = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"player_ceraunus"));
    public static final ResourceKey<DamageType> FLAME_STRIKE = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"flame_strike"));
    public static final ResourceKey<DamageType> STAR_LANCE = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"star_lance"));
    public static final ResourceKey<DamageType> DRACONIC_WOUND = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"draconic_wound"));
    public static final ResourceKey<DamageType> DRACONIC_SLASH = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"draconic_slash"));
    public static final ResourceKey<DamageType> DRACONIC_WOUND_ERUPTION = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"draconic_wound_eruption"));
    public static final ResourceKey<DamageType> DAGGER = ResourceKey.create((ResourceKey)Registries.DAMAGE_TYPE, (Identifier)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"dagger"));

    public static DamageSource causeLaserDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(LASER), attacker, caster);
    }

    public static DamageSource getDamageSource(Level level, ResourceKey<DamageType> type, EntityType<?> ... toIgnore) {
        return CMDamageTypes.getEntityDamageSource(level, type, null, toIgnore);
    }

    public static DamageSource getEntityDamageSource(Level level, ResourceKey<DamageType> type, @Nullable Entity attacker, EntityType<?> ... toIgnore) {
        return CMDamageTypes.getIndirectEntityDamageSource(level, type, attacker, attacker, toIgnore);
    }

    public static DamageSource getIndirectEntityDamageSource(Level level, ResourceKey<DamageType> type, @Nullable Entity attacker, @Nullable Entity indirectAttacker, EntityType<?> ... toIgnore) {
        return toIgnore.length > 0 ? new EntityExcludedDamageSource((Holder<DamageType>)level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), toIgnore) : new DamageSource((Holder)level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), attacker, indirectAttacker);
    }

    public static DamageSource causeDeathLaserDamage(Entity attacker, LivingEntity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(DEATHLASER), attacker, (Entity)caster);
    }

    public static DamageSource causeShredderDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(SHREDDER), (Entity)attacker);
    }

    public static DamageSource causeSwordDanceDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(SWORD_DANCE), (Entity)attacker);
    }

    public static DamageSource causeMaledictioDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(MALEDICTIO), (Entity)attacker);
    }

    public static DamageSource causeMaledictioSoulDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(MALEDICTIO_ANIMA), (Entity)attacker);
    }

    public static DamageSource causeMaledictioSagittaDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(MALEDICTIO_SAGITTA), attacker, caster);
    }

    public static DamageSource causeStarLanceDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(STAR_LANCE), attacker, caster);
    }

    public static DamageSource causeMaledictioMagicaeDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(MALEDICTIO_MAGICAE), attacker, caster);
    }

    public static DamageSource causePenetrateDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(PENETRATE), (Entity)attacker);
    }

    public static DamageSource causeDraconicSlashMobDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(DRACONIC_SLASH), (Entity)attacker);
    }

    public static DamageSource causeDraconicWoundEruptionDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(DRACONIC_WOUND_ERUPTION), attacker, caster);
    }

    public static DamageSource causeLightningDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(LIGHTNING), attacker, caster);
    }

    public static DamageSource causeLightningMobDamage(LivingEntity attacker) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(LIGHTNING), (Entity)attacker);
    }

    public static DamageSource causeStormBringerDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(STORM_BRINGER), attacker, caster);
    }

    public static DamageSource causeDaggerDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(DAGGER), attacker, caster);
    }

    public static DamageSource causePlayerCeraunusDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(PLAYER_CERAUNUS), attacker, caster);
    }

    public static DamageSource causeFlameStrikeDamage(Entity attacker, Entity caster) {
        return new DamageSource((Holder)((Registry)attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get()).getHolderOrThrow(FLAME_STRIKE), attacker, caster);
    }
}

