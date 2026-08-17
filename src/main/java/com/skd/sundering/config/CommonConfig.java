/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.neoforged.neoforge.common.ModConfigSpec$BooleanValue
 *  net.neoforged.neoforge.common.ModConfigSpec$Builder
 *  net.neoforged.neoforge.common.ModConfigSpec$DoubleValue
 *  net.neoforged.neoforge.common.ModConfigSpec$IntValue
 */
package com.skd.sundering.config;

import com.skd.sundering.config.CMCommonConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig {
    private static final String LANG_PREFIX = "config.cataclysm.";
    public final ToolsAndAbilities TOOLS_AND_ABILITIES;
    public final Mobs MOBS;
    public final Blocks BLOCKS;
    public final Spawning SPAWNING;

    public CommonConfig(ModConfigSpec.Builder builder) {
        this.TOOLS_AND_ABILITIES = new ToolsAndAbilities(builder);
        this.MOBS = new Mobs(builder);
        this.BLOCKS = new Blocks(builder);
        this.SPAWNING = new Spawning(builder);
    }

    public static class ToolsAndAbilities {
        public final IgnitiumArmor IGNITIUM_ARMOR;
        public final CursiumArmor CURSIUM_ARMOR;
        public final BoneReptileArmor BONE_REPTILE_ARMOR;
        public final BloomStoneArmor BLOOM_STONE_ARMOR;
        public final Incinerator INCINERATOR;
        public final BulwarkOfTheFlame BULWARK_OF_THE_FLAME;
        public final GauntletOfGuard GAUNTLER_OF_GUARD;
        public final GauntletOfBulwark GAUNTLET_OF_BULWARK;
        public final GauntletOfMaelstrom GAUNTLER_OF_MAELSTROM;
        public final InfernalForge INFERNAL_FORGE;
        public final VoidForge VOID_FORGE;
        public final Brontes BRONTES;
        public final TidalClaws TIDAL_CLAW;
        public final MeatShredder MEATH_SHREDDER;
        public final WitherAssaultShoulderWeapon WASW;
        public final VoidAssaultShoulderWeapon VASW;
        public final VoidCore VOID_CORE;
        public final SandstormInABottle SANDSTORM_IN_A_BOTTLE;
        public final Annihilator ANNIHILATOR;
        public final SoulRender SOUL_RENDER;
        public final Immolator IMMOLATOR;
        public final Ceraunus CERAUNUS;
        public final Astrape ASTRAPE;
        public final CursedBow CURSED_BOW;
        public final WrathOfTheDesert WRATH_OF_THE_DESERT;
        public final LaserGatling LASER_GATLING;
        public final AncientSpear ANCIENTSPEAR;

        ToolsAndAbilities(ModConfigSpec.Builder builder) {
            builder.push("tools_and_abilities");
            this.IGNITIUM_ARMOR = new IgnitiumArmor(builder);
            this.CURSIUM_ARMOR = new CursiumArmor(builder);
            this.BONE_REPTILE_ARMOR = new BoneReptileArmor(builder);
            this.BLOOM_STONE_ARMOR = new BloomStoneArmor(builder);
            this.INCINERATOR = new Incinerator(builder);
            this.BULWARK_OF_THE_FLAME = new BulwarkOfTheFlame(builder);
            this.GAUNTLER_OF_GUARD = new GauntletOfGuard(builder);
            this.GAUNTLET_OF_BULWARK = new GauntletOfBulwark(builder);
            this.GAUNTLER_OF_MAELSTROM = new GauntletOfMaelstrom(builder);
            this.INFERNAL_FORGE = new InfernalForge(builder);
            this.VOID_FORGE = new VoidForge(builder);
            this.BRONTES = new Brontes(builder);
            this.WASW = new WitherAssaultShoulderWeapon(builder);
            this.VASW = new VoidAssaultShoulderWeapon(builder);
            this.VOID_CORE = new VoidCore(builder);
            this.SANDSTORM_IN_A_BOTTLE = new SandstormInABottle(builder);
            this.SOUL_RENDER = new SoulRender(builder);
            this.IMMOLATOR = new Immolator(builder);
            this.TIDAL_CLAW = new TidalClaws(builder);
            this.CERAUNUS = new Ceraunus(builder);
            this.ASTRAPE = new Astrape(builder);
            this.MEATH_SHREDDER = new MeatShredder(builder);
            this.ANNIHILATOR = new Annihilator(builder);
            this.CURSED_BOW = new CursedBow(builder);
            this.WRATH_OF_THE_DESERT = new WrathOfTheDesert(builder);
            this.LASER_GATLING = new LaserGatling(builder);
            this.ANCIENTSPEAR = new AncientSpear(builder);
            builder.pop();
        }
    }

    public static class Mobs {
        public final ETC ETC;
        public final EnderGuardian ENDERGUARDIAN;
        public final Netherite_Monstrosity NETHERITE_MONSTROSITY;
        public final Netherite_Ministrosity NETHERITE_MINISTROSITY;
        public final EnderGolem ENDERGOLEM;
        public final Amethyst_Crab CRAB;
        public final Ignis IGNIS;
        public final Ignited_Revenant REVENANT;
        public final Harbinger HARBINGER;
        public final Prowler PROWLER;
        public final Leviathan LEVIATHAN;
        public final BabyLeviathan BABY_LEVIATHAN;
        public final Ancient_Remnant ANCIENT_REMNANT;
        public final ModernRemnant MODERN_REMNANT;
        public final Koboleton KOBOLETON;
        public final Kobolediator KOBOLEDIATOR;
        public final Wadjet WADJET;
        public final Maledictus MALEDICTUS;
        public final Aptrgangr APTRGANGR;
        public final Scylla SCYLLA;
        public final Clawdian CLAWDIAN;

        Mobs(ModConfigSpec.Builder builder) {
            builder.push("mobs");
            this.ETC = new ETC(builder);
            this.ENDERGUARDIAN = new EnderGuardian(builder);
            this.ENDERGOLEM = new EnderGolem(builder);
            this.NETHERITE_MONSTROSITY = new Netherite_Monstrosity(builder);
            this.NETHERITE_MINISTROSITY = new Netherite_Ministrosity(builder);
            this.IGNIS = new Ignis(builder);
            this.REVENANT = new Ignited_Revenant(builder);
            this.HARBINGER = new Harbinger(builder);
            this.PROWLER = new Prowler(builder);
            this.CRAB = new Amethyst_Crab(builder);
            this.LEVIATHAN = new Leviathan(builder);
            this.BABY_LEVIATHAN = new BabyLeviathan(builder);
            this.ANCIENT_REMNANT = new Ancient_Remnant(builder);
            this.MODERN_REMNANT = new ModernRemnant(builder);
            this.KOBOLETON = new Koboleton(builder);
            this.KOBOLEDIATOR = new Kobolediator(builder);
            this.WADJET = new Wadjet(builder);
            this.MALEDICTUS = new Maledictus(builder);
            this.APTRGANGR = new Aptrgangr(builder);
            this.SCYLLA = new Scylla(builder);
            this.CLAWDIAN = new Clawdian(builder);
            builder.pop();
        }
    }

    public static class Blocks {
        public final CursedTombstone CURSEDTOMBSTONE;

        Blocks(ModConfigSpec.Builder builder) {
            builder.push("blocks");
            this.CURSEDTOMBSTONE = new CursedTombstone(builder);
            builder.pop();
        }
    }

    public static class Spawning {
        public final ModConfigSpec.IntValue DeeplingSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingBruteSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingBruteSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingAnglerSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingAnglerSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingPriestSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingPriestSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingWarlockSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingWarlockSpawnRolls;
        public final ModConfigSpec.IntValue CoralgolemSpawnWeight;
        public final ModConfigSpec.IntValue CoralgolemSpawnRolls;
        public final ModConfigSpec.IntValue AmethystCrabSpawnWeight;
        public final ModConfigSpec.IntValue AmethystCrabSpawnRolls;
        public final ModConfigSpec.IntValue KoboletonSpawnWeight;
        public final ModConfigSpec.IntValue KoboletonSpawnRolls;
        public final ModConfigSpec.IntValue IgnitedBerserkerSpawnWeight;
        public final ModConfigSpec.IntValue IgnitedBerserkerSpawnRolls;

        Spawning(ModConfigSpec.Builder builder) {
            builder.push("spawning");
            this.DeeplingSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.deepling_spawn_weight").defineInRange("deepling_spawn_weight", CMCommonConfig.Spawning.DeeplingSpawnWeight, 0, 1000);
            this.DeeplingSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.deepling_spawn_rolls").defineInRange("deepling_spawn_rolls", CMCommonConfig.Spawning.DeeplingSpawnRolls, 0, Integer.MAX_VALUE);
            this.DeeplingBruteSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.deepling_brute_spawn_weight").defineInRange("deepling_brute_spawn_weight", CMCommonConfig.Spawning.DeeplingBruteSpawnWeight, 0, 1000);
            this.DeeplingBruteSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.deepling_brute_spawn_rolls").defineInRange("deepling_brute_spawn_rolls", CMCommonConfig.Spawning.DeeplingBruteSpawnRolls, 0, Integer.MAX_VALUE);
            this.DeeplingAnglerSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.deepling_angler_spawn_weight").defineInRange("deepling_angler_spawn_weight", CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight, 0, 1000);
            this.DeeplingAnglerSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.deepling_angler_spawn_rolls").defineInRange("deepling_angler_spawn_rolls", CMCommonConfig.Spawning.DeeplingAnglerSpawnRolls, 0, Integer.MAX_VALUE);
            this.DeeplingPriestSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.deepling_priest_spawn_weight").defineInRange("deepling_priest_spawn_weight", CMCommonConfig.Spawning.DeeplingPriestSpawnWeight, 0, 1000);
            this.DeeplingPriestSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.deepling_priest_spawn_rolls").defineInRange("deepling_priest_spawn_rolls", CMCommonConfig.Spawning.DeeplingPriestSpawnRolls, 0, Integer.MAX_VALUE);
            this.DeeplingWarlockSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.deepling_warlock_spawn_weight").defineInRange("deepling_warlock_spawn_weight", CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight, 0, 1000);
            this.DeeplingWarlockSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.deepling_warlock_spawn_rolls").defineInRange("deepling_warlock_spawn_rolls", CMCommonConfig.Spawning.DeeplingWarlockSpawnRolls, 0, Integer.MAX_VALUE);
            this.CoralgolemSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.coral_golem_spawn_weight").defineInRange("coral_golem_spawn_weight", CMCommonConfig.Spawning.CoralgolemSpawnWeight, 0, 1000);
            this.CoralgolemSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.coral_golem_spawn_rolls").defineInRange("coral_golem_spawn_rolls", CMCommonConfig.Spawning.CoralgolemSpawnRolls, 0, Integer.MAX_VALUE);
            this.AmethystCrabSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.amethyst_crab_spawn_weight").defineInRange("amethyst_crab_spawn_weight", CMCommonConfig.Spawning.AmethystCrabSpawnWeight, 0, 1000);
            this.AmethystCrabSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.amethyst_crab_spawn_rolls").defineInRange("amethyst_crab_spawn_rolls", CMCommonConfig.Spawning.AmethystCrabSpawnRolls, 0, Integer.MAX_VALUE);
            this.KoboletonSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.koboleton_spawn_weight").defineInRange("koboleton_spawn_weight", CMCommonConfig.Spawning.KoboletonSpawnWeight, 0, 1000);
            this.KoboletonSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.koboleton_spawn_rolls").defineInRange("koboleton_spawn_rolls", CMCommonConfig.Spawning.KoboletonSpawnRolls, 0, Integer.MAX_VALUE);
            this.IgnitedBerserkerSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn").translation("config.cataclysm.ignited_berserker_spawn_weight").defineInRange("ignited_berserker_spawn_weight", CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight, 0, 1000);
            this.IgnitedBerserkerSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning").translation("config.cataclysm.ignited_berserker_spawn_rolls").defineInRange("ignited_berserker_spawn_rolls", CMCommonConfig.Spawning.IgnitedBerserkerSpawnRolls, 0, Integer.MAX_VALUE);
            builder.pop();
        }
    }

    public static class AncientSpear {
        public final ModConfigSpec.DoubleValue SandstormDamage;
        public final ToolConfig toolConfig;

        AncientSpear(ModConfigSpec.Builder builder) {
            builder.push("ancient_spear");
            this.SandstormDamage = builder.comment("SandStorm").translation("config.cataclysm.sand_storm_damage").defineInRange("sand_storm_damage", CMCommonConfig.AncientSpear.sandstormdamage, 0.0, 1000000.0);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.AncientSpear.attackDamage, CMCommonConfig.AncientSpear.attackSpeed);
            builder.pop();
        }
    }

    public static class LaserGatling {
        public final ModConfigSpec.DoubleValue LaserDamage;

        LaserGatling(ModConfigSpec.Builder builder) {
            builder.push("laser_gatling");
            this.LaserDamage = builder.comment("Laser Damage").translation("config.cataclysm.laser_damage").defineInRange("laser_damage", CMCommonConfig.LaserGatling.damage, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class WrathOfTheDesert {
        public final ModConfigSpec.DoubleValue WrathOfTheDesertDamage;

        WrathOfTheDesert(ModConfigSpec.Builder builder) {
            builder.push("wrath_of_the_desert");
            this.WrathOfTheDesertDamage = builder.comment("Wrath Of The Desert Damage").translation("config.cataclysm.wrath_of_the_desert_damage").defineInRange("wrath_of_the_desert_damage", CMCommonConfig.WrathOfTheDesert.damage, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class CursedBow {
        public final ModConfigSpec.DoubleValue CursedBowDamage;

        CursedBow(ModConfigSpec.Builder builder) {
            builder.push("cursed_bow");
            this.CursedBowDamage = builder.comment("Cursed Bow Damage").translation("config.cataclysm.cursed_bow_damage").defineInRange("cursed_bow_damage", CMCommonConfig.CursedBow.damage, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class Astrape {
        public final ToolConfig toolConfig;
        public final ModConfigSpec.DoubleValue AstrapeDamage;
        public final ModConfigSpec.DoubleValue AstrapeAreaDamage;
        public final ModConfigSpec.IntValue AstrapeCooldown;

        Astrape(ModConfigSpec.Builder builder) {
            builder.push("astrape");
            this.AstrapeDamage = builder.comment("Astrape Damage").translation("config.cataclysm.astrape_damage").defineInRange("astrape_damage", CMCommonConfig.Astrape.damage, 0.0, 1000000.0);
            this.AstrapeAreaDamage = builder.comment("Astrape Area Damage").translation("config.cataclysm.astrape_area_damage").defineInRange("astrape_area_damage", CMCommonConfig.Astrape.areaDamage, 0.0, 1000000.0);
            this.AstrapeCooldown = builder.comment("Astrape Cooldown").translation("config.cataclysm.astrape_cooldown").defineInRange("astrape_cooldown", CMCommonConfig.Astrape.cooldown, 0, 1000000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.Astrape.attackDamage, CMCommonConfig.Astrape.attackSpeed);
            builder.pop();
        }
    }

    public static class TidalClaws {
        public final ToolConfig toolConfig;

        TidalClaws(ModConfigSpec.Builder builder) {
            builder.push("tidal_claws");
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.TidalClaws.attackDamage, CMCommonConfig.TidalClaws.attackSpeed);
            builder.pop();
        }
    }

    public static class Ceraunus {
        public final ToolConfig toolConfig;
        public final ModConfigSpec.IntValue CeraunusCooldown;
        public final ModConfigSpec.DoubleValue CeraunusWaveDamage;

        Ceraunus(ModConfigSpec.Builder builder) {
            builder.push("ceraunus");
            this.CeraunusWaveDamage = builder.comment("Ceraunus Wave Damage").translation("config.cataclysm.ceraunus_wave_damage").defineInRange("ceraunus_wave_damage", CMCommonConfig.Ceraunus.waveDamage, 0.0, 1000000.0);
            this.CeraunusCooldown = builder.comment("Ceraunus Cooldown").translation("config.cataclysm.ceraunus_cooldown").defineInRange("ceraunus_cooldown", CMCommonConfig.Ceraunus.cooldown, 0, 1000000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.Ceraunus.attackDamage, CMCommonConfig.Ceraunus.attackSpeed);
            builder.pop();
        }
    }

    public static class Immolator {
        public final ToolConfig toolConfig;
        public final ModConfigSpec.IntValue ImmolatorCooldown;

        Immolator(ModConfigSpec.Builder builder) {
            builder.push("immolator");
            this.ImmolatorCooldown = builder.comment("Immolator Cooldown").translation("config.cataclysm.immolator_cooldown").defineInRange("immolator_cooldown", CMCommonConfig.Immolator.cooldown, 0, 1000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.Immolator.attackDamage, CMCommonConfig.Immolator.attackSpeed);
            builder.pop();
        }
    }

    public static class SoulRender {
        public final ToolConfig toolConfig;
        public final ModConfigSpec.IntValue SoulRenderCooldown;
        public final ModConfigSpec.DoubleValue PhantomHalberddamage;

        SoulRender(ModConfigSpec.Builder builder) {
            builder.push("soul_render");
            this.SoulRenderCooldown = builder.comment("Soul Render Cooldown").translation("config.cataclysm.soul_render_cooldown").defineInRange("soul_render_cooldown", CMCommonConfig.SoulRender.cooldown, 0, 1000);
            this.PhantomHalberddamage = builder.comment("Phantom Halberd Damage").translation("config.cataclysm.phantom_halberd_damage").defineInRange("phantom_halberd_damage", CMCommonConfig.SoulRender.phantomHalberdDamage, 0.0, 1000000.0);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.SoulRender.attackDamage, CMCommonConfig.SoulRender.attackSpeed);
            builder.pop();
        }
    }

    public static class SandstormInABottle {
        public final ModConfigSpec.IntValue SandStormCooldown;

        SandstormInABottle(ModConfigSpec.Builder builder) {
            builder.push("sandstorm");
            this.SandStormCooldown = builder.comment("Cooldown").translation("config.cataclysm.sandstorm_cooldown").defineInRange("sandstorm_cooldown", CMCommonConfig.SandstormInABottle.cooldown, 0, 1000);
            builder.pop();
        }
    }

    public static class VoidCore {
        public final ModConfigSpec.IntValue VoidCoreCooldown;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;

        VoidCore(ModConfigSpec.Builder builder) {
            builder.push("void_core");
            this.VoidCoreCooldown = builder.comment("Cooldown").translation("config.cataclysm.void_core_cooldown").defineInRange("void_core_cooldown", CMCommonConfig.VoidCore.cooldown, 0, 1000);
            this.VoidRuneDamage = builder.comment("Void Core Rune Damage").translation("config.cataclysm.void_core_rune_damage").defineInRange("void_core_rune_damage", CMCommonConfig.VoidCore.runeDamage, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class VoidAssaultShoulderWeapon {
        public final ModConfigSpec.IntValue HowitzerCooldown;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;

        VoidAssaultShoulderWeapon(ModConfigSpec.Builder builder) {
            builder.push("void_assault_shoulder_weapon");
            this.HowitzerCooldown = builder.comment("Howitzer Cooldown").translation("config.cataclysm.howitzer_cooldown").defineInRange("howitzer_cooldown", CMCommonConfig.VASW.howitzerCooldown, 0, 1000);
            this.VoidRuneDamage = builder.comment("VASW Rune Damage").translation("config.cataclysm.vasw_rune_damage").defineInRange("vasw_rune_damage", CMCommonConfig.VASW.runeDamage, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class WitherAssaultShoulderWeapon {
        public final ModConfigSpec.IntValue MissileCooldown;
        public final ModConfigSpec.DoubleValue MissileDamage;
        public final ModConfigSpec.IntValue HowitzerCooldown;

        WitherAssaultShoulderWeapon(ModConfigSpec.Builder builder) {
            builder.push("wither_assault_shoulder_weapon");
            this.MissileCooldown = builder.comment("Missile Cooldown").translation("config.cataclysm.missile_cooldown").defineInRange("missile_cooldown", CMCommonConfig.WASW.missileCooldown, 0, 1000);
            this.MissileDamage = builder.comment("Missile Damage").translation("config.cataclysm.missile_damage").defineInRange("missile_damage", CMCommonConfig.WASW.missileDamage, 0.0, 100000.0);
            this.HowitzerCooldown = builder.comment("Howitzer Cooldown").translation("config.cataclysm.howitzer_cooldown").defineInRange("howitzer_cooldown", CMCommonConfig.WASW.howitzerCooldown, 0, 1000);
            builder.pop();
        }
    }

    public static class Annihilator {
        public final ToolConfig toolConfig;

        Annihilator(ModConfigSpec.Builder builder) {
            builder.push("annihilator");
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.Annihilator.attackDamage, CMCommonConfig.Annihilator.attackSpeed);
            builder.pop();
        }
    }

    public static class MeatShredder {
        public final ToolConfig toolConfig;

        MeatShredder(ModConfigSpec.Builder builder) {
            builder.push("meat_shredder");
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.MeatShredder.attackDamage, CMCommonConfig.MeatShredder.attackSpeed);
            builder.pop();
        }
    }

    public static class Brontes {
        public final ModConfigSpec.DoubleValue StormAreaDamage;
        public final ModConfigSpec.DoubleValue StormDamage;
        public final ToolConfig toolConfig;

        Brontes(ModConfigSpec.Builder builder) {
            builder.push("brontes");
            this.StormDamage = builder.comment("Brontes Storm Damage").translation("config.cataclysm.brontes_storm_damage").defineInRange("brontes_storm_damage", CMCommonConfig.Brontes.stormdamage, 0.0, 1000000.0);
            this.StormAreaDamage = builder.comment("Brontes Storm Area Damage").translation("config.cataclysm.brontes_storm_area_damage").defineInRange("brontes_storm_area_damage", CMCommonConfig.Brontes.stormareadamage, 0.0, 1000000.0);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.Brontes.attackDamage, CMCommonConfig.Brontes.attackSpeed);
            builder.pop();
        }
    }

    public static class VoidForge {
        public final ModConfigSpec.IntValue VoidForgeCooldown;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
        public final ToolConfig toolConfig;

        VoidForge(ModConfigSpec.Builder builder) {
            builder.push("void_forge");
            this.VoidForgeCooldown = builder.comment("Void Forge Cooldown").translation("config.cataclysm.void_forge_cooldown").defineInRange("void_forge_cooldown", CMCommonConfig.VoidForge.cooldown, 0, 1000);
            this.VoidRuneDamage = builder.comment("Void Forge Rune Damage").translation("config.cataclysm.void_forge_rune_damage").defineInRange("void_forge_rune_damage", CMCommonConfig.VoidForge.runeDamage, 0.0, 1000000.0);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.VoidForge.attackDamage, CMCommonConfig.VoidForge.attackSpeed);
            builder.pop();
        }
    }

    public static class InfernalForge {
        public final ModConfigSpec.IntValue InfernalForgeCooldown;
        public final ToolConfig toolConfig;

        InfernalForge(ModConfigSpec.Builder builder) {
            builder.push("infernal_forge");
            this.InfernalForgeCooldown = builder.comment("Infernal Forge Cooldown").translation("config.cataclysm.infernal_forge_cooldown").defineInRange("infernal_forge_cooldown", CMCommonConfig.InfernalForge.cooldown, 0, 1000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.InfernalForge.attackDamage, CMCommonConfig.InfernalForge.attackSpeed);
            builder.pop();
        }
    }

    public static class GauntletOfMaelstrom {
        public final ModConfigSpec.IntValue GauntletOfMaelstromCooldown;
        public final ToolConfig toolConfig;

        GauntletOfMaelstrom(ModConfigSpec.Builder builder) {
            builder.push("gauntlet_of_maelstrom");
            this.GauntletOfMaelstromCooldown = builder.comment("Maelstrom Cooldown").translation("config.cataclysm.maelstrom_cooldown").defineInRange("maelstrom_cooldown", CMCommonConfig.GauntletOfMaelstrom.cooldown, 0, 1000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.GauntletOfMaelstrom.attackDamage, CMCommonConfig.GauntletOfMaelstrom.attackSpeed);
            builder.pop();
        }
    }

    public static class GauntletOfBulwark {
        public final ModConfigSpec.IntValue GauntletOfBulwarkCooldown;
        public final ToolConfig toolConfig;

        GauntletOfBulwark(ModConfigSpec.Builder builder) {
            builder.push("gauntlet_of_bulwark");
            this.GauntletOfBulwarkCooldown = builder.comment("Gauntlet Of Bulwark Cooldown").translation("config.cataclysm.gauntlet_of_bulwark_cooldown").defineInRange("gauntlet_of_bulwark_cooldown", CMCommonConfig.GauntletOfBulwark.cooldown, 0, 1000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.GauntletOfBulwark.attackDamage, CMCommonConfig.GauntletOfBulwark.attackSpeed);
            builder.pop();
        }
    }

    public static class GauntletOfGuard {
        public final ToolConfig toolConfig;

        GauntletOfGuard(ModConfigSpec.Builder builder) {
            builder.push("gauntlet_of_guard");
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.GauntletOfGuard.attackDamage, CMCommonConfig.GauntletOfGuard.attackSpeed);
            builder.pop();
        }
    }

    public static class BulwarkOfTheFlame {
        public final ModConfigSpec.IntValue BulwarkOfTheFlameCooldown;

        BulwarkOfTheFlame(ModConfigSpec.Builder builder) {
            builder.push("bulwark_of_the_flame");
            this.BulwarkOfTheFlameCooldown = builder.comment("Bulwark Of The Flame Cooldown").translation("config.cataclysm.bulwark_of_the_flame_cooldown").defineInRange("bulwark_of_the_flame_cooldown", CMCommonConfig.BulwarkOfTheFlame.cooldown, 0, 1000);
            builder.pop();
        }
    }

    public static class Incinerator {
        public final ModConfigSpec.IntValue IncineratorCooldown;
        public final ToolConfig toolConfig;

        Incinerator(ModConfigSpec.Builder builder) {
            builder.push("incinerator");
            this.IncineratorCooldown = builder.comment("Incinerator Cooldown").translation("config.cataclysm.incinerator_cooldown").defineInRange("incinerator_cooldown", CMCommonConfig.Incinerator.cooldown, 0, 1000);
            this.toolConfig = new ToolConfig(builder, CMCommonConfig.Incinerator.attackDamage, CMCommonConfig.Incinerator.attackSpeed);
            builder.pop();
        }
    }

    public static class BloomStoneArmor {
        public final ArmorConfig armorConfig;

        BloomStoneArmor(ModConfigSpec.Builder builder) {
            builder.push("bloom_stone_armor");
            this.armorConfig = new ArmorConfig(builder, CMCommonConfig.BloomStoneArmor.armorMultiplier, CMCommonConfig.BloomStoneArmor.toughness, CMCommonConfig.BloomStoneArmor.knockbackResistance);
            builder.pop();
        }
    }

    public static class BoneReptileArmor {
        public final ArmorConfig armorConfig;

        BoneReptileArmor(ModConfigSpec.Builder builder) {
            builder.push("bone_reptile_armor");
            this.armorConfig = new ArmorConfig(builder, CMCommonConfig.BoneReptileArmor.armorMultiplier, CMCommonConfig.BoneReptileArmor.toughness, CMCommonConfig.BoneReptileArmor.knockbackResistance);
            builder.pop();
        }
    }

    public static class CursiumArmor {
        public final ArmorConfig armorConfig;

        CursiumArmor(ModConfigSpec.Builder builder) {
            builder.push("cursium_armor");
            this.armorConfig = new ArmorConfig(builder, CMCommonConfig.CursiumArmor.armorMultiplier, CMCommonConfig.CursiumArmor.toughness, CMCommonConfig.CursiumArmor.knockbackResistance);
            builder.pop();
        }
    }

    public static class IgnitiumArmor {
        public final ArmorConfig armorConfig;

        IgnitiumArmor(ModConfigSpec.Builder builder) {
            builder.push("ignitium_armor");
            this.armorConfig = new ArmorConfig(builder, CMCommonConfig.IgnitiumArmor.armorMultiplier, CMCommonConfig.IgnitiumArmor.toughness, CMCommonConfig.IgnitiumArmor.knockbackResistance);
            builder.pop();
        }
    }

    public static class Aptrgangr {
        public final CombatConfig combatConfig;
        public final NatureHealConfig healConfig;
        public final ModConfigSpec.DoubleValue AxeBladeDamage;

        Aptrgangr(ModConfigSpec.Builder builder) {
            builder.push("aptrgangr");
            this.AxeBladeDamage = builder.comment("Axe Blade Damage").translation("config.cataclysm.axe_blade_damage").defineInRange("axe_blade_damage", CMCommonConfig.Aptrgangr.AxeBladeDamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Aptrgangr.healthMultiplier, CMCommonConfig.Aptrgangr.attackMultiplier);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Aptrgangr.natureHeal);
            builder.pop();
        }
    }

    public static class Maledictus {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue PhantomHalberdDamage;
        public final ModConfigSpec.DoubleValue HpDamage;
        public final ModConfigSpec.DoubleValue ShockWaveHpDamage;
        public final ModConfigSpec.DoubleValue AOEHpDamage;
        public final ModConfigSpec.DoubleValue FlyingSmashHpDamage;
        public final ModConfigSpec.DoubleValue SmashHpDamage;
        public final ModConfigSpec.DoubleValue PhantomArrowDamage;

        Maledictus(ModConfigSpec.Builder builder) {
            builder.push("maledictus");
            this.PhantomHalberdDamage = builder.comment("Phantom Halberd Damage").translation("config.cataclysm.phantom_halberd_damage").defineInRange("phantom_halberd_damage", CMCommonConfig.Maledictus.PhantomHalberdDamage, 0.0, 1000000.0);
            this.HpDamage = builder.comment("Hp Damage").translation("config.cataclysm.hp_damage").defineInRange("hp_damage", CMCommonConfig.Maledictus.HpDamage, 0.0, 1.0);
            this.ShockWaveHpDamage = builder.comment("Shock Wave Hp Damage").translation("config.cataclysm.shock_wave_hp_damage").defineInRange("shock_wave_hp_damage", CMCommonConfig.Maledictus.ShockWaveHpDamage, 0.0, 1.0);
            this.AOEHpDamage = builder.comment("AOE Hp Damage").translation("config.cataclysm.aoe_hp_damage").defineInRange("aoe_hp_damage", CMCommonConfig.Maledictus.AOEHpDamage, 0.0, 1.0);
            this.FlyingSmashHpDamage = builder.comment("Flying Smash Hp Damage").translation("config.cataclysm.flying_smash_hp_damage").defineInRange("flying_smash_hp_damage", CMCommonConfig.Maledictus.FlyingSmashHpDamage, 0.0, 1.0);
            this.SmashHpDamage = builder.comment("Smash Hp Damage").translation("config.cataclysm.smash_hp_damage").defineInRange("smash_hp_damage", CMCommonConfig.Maledictus.SmashHpDamage, 0.0, 1.0);
            this.PhantomArrowDamage = builder.comment("Phantom Arrow Damage").translation("config.cataclysm.phantom_arrow_damage").defineInRange("phantom_arrow_damage", CMCommonConfig.Maledictus.PhantomArrowDamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Maledictus.healthMultiplier, CMCommonConfig.Maledictus.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.Maledictus.damageCap, CMCommonConfig.Maledictus.dpsCap, CMCommonConfig.Maledictus.dpsLimitTime, CMCommonConfig.Maledictus.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Maledictus.natureHeal);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Maledictus.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class Clawdian {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;

        Clawdian(ModConfigSpec.Builder builder) {
            builder.push("clawdian");
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Clawdian.healthMultiplier, CMCommonConfig.Clawdian.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.Clawdian.damageCap, CMCommonConfig.Clawdian.dpsCap, CMCommonConfig.Clawdian.dpsLimitTime, CMCommonConfig.Clawdian.rangeCap);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Clawdian.ignoreMobGriefing);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Clawdian.natureHeal);
            builder.pop();
        }
    }

    public static class Scylla {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue SpearDamage;
        public final ModConfigSpec.DoubleValue LightningStormDamage;
        public final ModConfigSpec.DoubleValue HpDamage;
        public final ModConfigSpec.DoubleValue LightningAreaDamage;
        public final ModConfigSpec.DoubleValue SnakeDamage;
        public final ModConfigSpec.DoubleValue AnchorDamage;
        public final ModConfigSpec.BooleanValue WeatherChange;
        public final ModConfigSpec.DoubleValue SpinHpDamage;
        public final ModConfigSpec.DoubleValue StormHpDamage;

        Scylla(ModConfigSpec.Builder builder) {
            builder.push("scylla");
            this.SpearDamage = builder.comment("Spear Damage").translation("config.cataclysm.spear_damage").defineInRange("spear_damage", CMCommonConfig.Scylla.SpearDamage, 0.0, 1000000.0);
            this.LightningStormDamage = builder.comment("Lightning Storm Damage").translation("config.cataclysm.lightning_storm_damage").defineInRange("lightning_storm_damage", CMCommonConfig.Scylla.LightningStormDamage, 0.0, 1000000.0);
            this.LightningAreaDamage = builder.comment("Lightning Area Damage").translation("config.cataclysm.lightning_area_damage").defineInRange("lightning_area_damage", CMCommonConfig.Scylla.LightningAreaDamage, 0.0, 1000000.0);
            this.SnakeDamage = builder.comment("Snake Damage").translation("config.cataclysm.snake_damage").defineInRange("snake_damage", CMCommonConfig.Scylla.SnakeDamage, 0.0, 1000000.0);
            this.AnchorDamage = builder.comment("Anchor Damage").translation("config.cataclysm.anchor_damage").defineInRange("anchor_damage", CMCommonConfig.Scylla.AnchorDamage, 0.0, 1000000.0);
            this.WeatherChange = builder.comment("Weather Change").translation("config.cataclysm.weather_change").define("weather_change", CMCommonConfig.Scylla.WeatherChange);
            this.HpDamage = builder.comment("Hp Damage").translation("config.cataclysm.hp_damage").defineInRange("hp_damage", CMCommonConfig.Scylla.HpDamage, 0.0, 1.0);
            this.SpinHpDamage = builder.comment("Spin Hp Damage").translation("config.cataclysm.spin_hp_damage").defineInRange("spin_hp_damage", CMCommonConfig.Scylla.SpinHpDamage, 0.0, 1.0);
            this.StormHpDamage = builder.comment("Lightning Storm Hp Damage").translation("config.cataclysm.lightning_storm_hp_damage").defineInRange("lightning_storm_hp_damage", CMCommonConfig.Scylla.StormHpDamage, 0.0, 1.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Scylla.healthMultiplier, CMCommonConfig.Scylla.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.Scylla.damageCap, CMCommonConfig.Scylla.dpsCap, CMCommonConfig.Scylla.dpsLimitTime, CMCommonConfig.Scylla.rangeCap);
            this.respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.Scylla.respawner);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Scylla.natureHeal);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Scylla.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class Wadjet {
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue Sandstorm_damage;
        public final ModConfigSpec.DoubleValue AncientDesertSteledamage;

        Wadjet(ModConfigSpec.Builder builder) {
            builder.push("wadjet");
            this.Sandstorm_damage = builder.comment("Sandstorm Damage").translation("config.cataclysm.sandstorm_damage").defineInRange("sandstorm_damage", CMCommonConfig.Wadjet.Sandstorm_damage, 0.0, 1000000.0);
            this.AncientDesertSteledamage = builder.comment("Ancient Desert Stele Damage").translation("config.cataclysm.ancient_desert_stele_damage").defineInRange("ancient_desert_stele_damage", CMCommonConfig.Wadjet.AncientDesertSteledamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Wadjet.healthMultiplier, CMCommonConfig.Wadjet.attackMultiplier);
            builder.pop();
        }
    }

    public static class Kobolediator {
        public final CombatConfig combatConfig;
        public final IgnoreMobGriefing mobGriefingConfig;

        Kobolediator(ModConfigSpec.Builder builder) {
            builder.push("kobolediator");
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Kobolediator.healthMultiplier, CMCommonConfig.Kobolediator.attackMultiplier);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Kobolediator.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class Koboleton {
        public final ModConfigSpec.DoubleValue CauseKoboletontoDropItemInHandPercent;

        Koboleton(ModConfigSpec.Builder builder) {
            builder.push("koboleton");
            this.CauseKoboletontoDropItemInHandPercent = builder.comment("CauseKoboletontoDropItemInHandPercent").translation("config.cataclysm.drop_hand").defineInRange("drop_hand", CMCommonConfig.Koboleton.CauseKoboletontoDropItemInHandPercent, 0.0, 100.0);
            builder.pop();
        }
    }

    public static class ModernRemnant {
        public final CombatConfig combatConfig;

        ModernRemnant(ModConfigSpec.Builder builder) {
            builder.push("modern_remnant");
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.ModernRemnant.healthMultiplier, CMCommonConfig.ModernRemnant.attackMultiplier);
            builder.pop();
        }
    }

    public static class Ancient_Remnant {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue ChargeHpDamage;
        public final ModConfigSpec.DoubleValue HpDamage;
        public final ModConfigSpec.DoubleValue StompHpDamage;
        public final ModConfigSpec.DoubleValue EarthQuakeDamage;
        public final ModConfigSpec.DoubleValue AncientDesertSteledamage;

        Ancient_Remnant(ModConfigSpec.Builder builder) {
            builder.push("ancient_remnant");
            this.ChargeHpDamage = builder.comment("Charge Hp Damage").translation("config.cataclysm.charge_hp_damage").defineInRange("charge_hp_damage", CMCommonConfig.AncientRemnant.ChargeHpDamage, 0.0, 1.0);
            this.HpDamage = builder.comment("Hp Damage").translation("config.cataclysm.hp_damage").defineInRange("hp_damage", CMCommonConfig.AncientRemnant.HpDamage, 0.0, 1.0);
            this.StompHpDamage = builder.comment("Stomp Hp Damage").translation("config.cataclysm.stomp_hp_damage").defineInRange("stomp_hp_damage", CMCommonConfig.AncientRemnant.StompHpDamage, 0.0, 1.0);
            this.EarthQuakeDamage = builder.comment("EarthQuake Damage").translation("config.cataclysm.earthquake_damage").defineInRange("earthquake_damage", CMCommonConfig.AncientRemnant.EarthQuakeDamage, 0.0, 1000000.0);
            this.AncientDesertSteledamage = builder.comment("Ancient Desert Stele Damage").translation("config.cataclysm.ancient_desert_stele_damage").defineInRange("ancient_desert_stele_damage", CMCommonConfig.AncientRemnant.AncientDesertSteledamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.AncientRemnant.healthMultiplier, CMCommonConfig.AncientRemnant.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.AncientRemnant.damageCap, CMCommonConfig.AncientRemnant.dpsCap, CMCommonConfig.AncientRemnant.dpsLimitTime, CMCommonConfig.AncientRemnant.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.AncientRemnant.natureHeal);
            this.respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.AncientRemnant.respawner);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.AncientRemnant.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class Amethyst_Crab {
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue EarthQuakeDamage;
        public final ModConfigSpec.DoubleValue AmethystClusterDamage;

        Amethyst_Crab(ModConfigSpec.Builder builder) {
            builder.push("amethyst_crab");
            this.EarthQuakeDamage = builder.comment("Earth Quake Damage").translation("config.cataclysm.earth_quake_damage").defineInRange("earth_quake_damage", CMCommonConfig.AmethystCrab.EarthQuakeDamage, 0.0, 1000000.0);
            this.AmethystClusterDamage = builder.comment("Amethyst Cluster Damage").translation("config.cataclysm.amethyst_cluster_damage").defineInRange("amethyst_cluster_damage", CMCommonConfig.AmethystCrab.AmethystClusterDamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.AmethystCrab.healthMultiplier, CMCommonConfig.AmethystCrab.attackMultiplier);
            builder.pop();
        }
    }

    public static class BabyLeviathan {
        public final CombatConfig combatConfig;

        BabyLeviathan(ModConfigSpec.Builder builder) {
            builder.push("baby_leviathan");
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.BabyLeviathan.healthMultiplier, CMCommonConfig.BabyLeviathan.attackMultiplier);
            builder.pop();
        }
    }

    public static class Leviathan {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue BiteHpDamage;
        public final ModConfigSpec.DoubleValue RushHpDamage;
        public final ModConfigSpec.DoubleValue TailSwingHpDamage;
        public final ModConfigSpec.DoubleValue TentacleHpDamage;
        public final ModConfigSpec.DoubleValue DimensionalRiftDamage;
        public final ModConfigSpec.DoubleValue AbyssBlastDamage;
        public final ModConfigSpec.DoubleValue AbyssBlastHpDamage;
        public final ModConfigSpec.DoubleValue AbyssOrbdamage;
        public final ModConfigSpec.BooleanValue ImmuneOutofWater;
        public final ModConfigSpec.BooleanValue SeparatePhaseMusic;

        Leviathan(ModConfigSpec.Builder builder) {
            builder.push("leviathan");
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Leviathan.ignoreMobGriefing);
            this.BiteHpDamage = builder.comment("Bite Hp Damage").translation("config.cataclysm.bite_hp_damage").defineInRange("bite_hp_damage", CMCommonConfig.Leviathan.BiteHpDamage, 0.0, 1.0);
            this.RushHpDamage = builder.comment("Rush Hp Damge").translation("config.cataclysm.rush_hp_damage").defineInRange("rush_hp_damage", CMCommonConfig.Leviathan.RushHpDamage, 0.0, 1.0);
            this.TailSwingHpDamage = builder.comment("Tail Swing Hp Damage").translation("config.cataclysm.tail_swing_hp_damage").defineInRange("tail_swing_hp_damage", CMCommonConfig.Leviathan.TailSwingHpDamage, 0.0, 1.0);
            this.TentacleHpDamage = builder.comment("Tentacle Hp Damage").translation("config.cataclysm.tentacle_hp_damage").defineInRange("tentacle_hp_damage", CMCommonConfig.Leviathan.TentacleHpDamage, 0.0, 1.0);
            this.DimensionalRiftDamage = builder.comment("Dimensional Rift Damage").translation("config.cataclysm.dimensional_rift_damage").defineInRange("dimensional_rift_damage", CMCommonConfig.Leviathan.DimensionalRiftDamage, 0.0, 1000000.0);
            this.AbyssBlastDamage = builder.comment("Abyss Blast Damage").translation("config.cataclysm.abyss_blast_damage").defineInRange("abyss_blast_damage", CMCommonConfig.Leviathan.AbyssBlastDamage, 0.0, 1000000.0);
            this.AbyssBlastHpDamage = builder.comment("Abyss Blast HP Damage").translation("config.cataclysm.abyss_blast_hp_damage").defineInRange("abyss_blast_hp_damage", CMCommonConfig.Leviathan.AbyssBlastHpDamage, 0.0, 1.0);
            this.AbyssOrbdamage = builder.comment("Abyss Orb Damage").translation("config.cataclysm.abyss_orb_damage").defineInRange("abyss_orb_damage", CMCommonConfig.Leviathan.AbyssOrbdamage, 0.0, 1000000.0);
            this.ImmuneOutofWater = builder.comment("Leviathan Immune Out of Water.").translation("config.cataclysm.immune_out_of_water").define("immune_out_of_water", CMCommonConfig.Leviathan.ImmuneOutofWater);
            this.SeparatePhaseMusic = builder.comment("Enable separate music per boss phase").translation("config.cataclysm.separate_phase_music").define("separate_phase_music", CMCommonConfig.Leviathan.SeparatePhaseMusic);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Leviathan.healthMultiplier, CMCommonConfig.Leviathan.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.Leviathan.damageCap, CMCommonConfig.Leviathan.dpsCap, CMCommonConfig.Leviathan.dpsLimitTime, CMCommonConfig.Leviathan.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Leviathan.natureHeal);
            builder.pop();
        }
    }

    public static class Prowler {
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue rangeCap;
        public final ModConfigSpec.DoubleValue HomingMissiledamage;
        public final ModConfigSpec.DoubleValue DeathLaserdamage;
        public final ModConfigSpec.DoubleValue DeathLaserHpdamage;

        Prowler(ModConfigSpec.Builder builder) {
            builder.push("prowler");
            this.rangeCap = builder.comment("Range Cap").translation("config.cataclysm.range_cap").defineInRange("range_cap", CMCommonConfig.Prowler.rangeCap, 1.0, 1000000.0);
            this.HomingMissiledamage = builder.comment("Wither Homing Missile").translation("config.cataclysm.homing_missile").defineInRange("homing_missile", CMCommonConfig.Prowler.HomingMissiledamage, 0.0, 1000000.0);
            this.DeathLaserdamage = builder.comment("Death Laser Damage").translation("config.cataclysm.death_laser_damage").defineInRange("death_laser_damage", CMCommonConfig.Prowler.DeathLaserdamage, 0.0, 1000000.0);
            this.DeathLaserHpdamage = builder.comment("Death Laser HP Damage").translation("config.cataclysm.death_laser_hp_damage").defineInRange("death_laser_hp_damage", CMCommonConfig.Prowler.DeathLaserHpdamage, 0.0, 1.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Prowler.healthMultiplier, CMCommonConfig.Prowler.attackMultiplier);
            builder.pop();
        }
    }

    public static class Harbinger {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue AutoHeal;
        public final ModConfigSpec.DoubleValue LifeSteal;
        public final ModConfigSpec.DoubleValue WitherMissiledamage;
        public final ModConfigSpec.DoubleValue Laserdamage;
        public final ModConfigSpec.DoubleValue DeathLaserdamage;
        public final ModConfigSpec.DoubleValue DeathLaserHpdamage;
        public final ModConfigSpec.DoubleValue ChargeHpDamage;

        Harbinger(ModConfigSpec.Builder builder) {
            builder.push("harbinger");
            this.AutoHeal = builder.comment("Harbinger Auto Heal").translation("config.cataclysm.harbinger_auto_heal").defineInRange("harbinger_auto_heal", CMCommonConfig.Harbinger.AutoHeal, 0.0, 1000000.0);
            this.LifeSteal = builder.comment("Harbinger Life Steal").translation("config.cataclysm.harbinger_life_steal").defineInRange("harbinger_life_steal", CMCommonConfig.Harbinger.LifeSteal, 0.0, 1000000.0);
            this.WitherMissiledamage = builder.comment("Wither Missile Damage").translation("config.cataclysm.wither_missile_damage").defineInRange("wither_missile_damage", CMCommonConfig.Harbinger.WitherMissiledamage, 0.0, 1000000.0);
            this.Laserdamage = builder.comment("Laser Damage").translation("config.cataclysm.laser_damage").defineInRange("laser_damage", CMCommonConfig.Harbinger.Laserdamage, 0.0, 1000000.0);
            this.DeathLaserdamage = builder.comment("Death Laser Damage").translation("config.cataclysm.death_laser_damage").defineInRange("death_laser_damage", CMCommonConfig.Harbinger.DeathLaserdamage, 0.0, 1000000.0);
            this.DeathLaserHpdamage = builder.comment("Death Laser HP Damage").translation("config.cataclysm.death_laser_hp_damage").defineInRange("death_laser_hp_damage", CMCommonConfig.Harbinger.DeathLaserHpdamage, 0.0, 1.0);
            this.ChargeHpDamage = builder.comment("Charge Attack Hp Damage").translation("config.cataclysm.charge_hp_damage").defineInRange("charge_hp_damage", CMCommonConfig.Harbinger.ChargeHpDamage, 0.0, 1.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Harbinger.healthMultiplier, CMCommonConfig.Harbinger.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.Harbinger.damageCap, CMCommonConfig.Harbinger.dpsCap, CMCommonConfig.Harbinger.dpsLimitTime, CMCommonConfig.Harbinger.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Harbinger.natureHeal);
            this.respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.Harbinger.respawner);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Harbinger.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class Ignited_Revenant {
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue AshenbreathDamage;
        public final ModConfigSpec.DoubleValue BlazingBoneDamage;

        Ignited_Revenant(ModConfigSpec.Builder builder) {
            builder.push("ignited_revenant");
            this.AshenbreathDamage = builder.comment("Ashen Breath Damage").translation("config.cataclysm.ashen_breath_damage").defineInRange("ashen_breath_damage", CMCommonConfig.IgnitedRevenant.AshenbreathDamage, 0.0, 1000000.0);
            this.BlazingBoneDamage = builder.comment("Blazing Bone Damage").translation("config.cataclysm.blazing_bone_damage").defineInRange("blazing_bone_damage", CMCommonConfig.IgnitedRevenant.BlazingBoneDamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.IgnitedRevenant.healthMultiplier, CMCommonConfig.IgnitedRevenant.attackMultiplier);
            builder.pop();
        }
    }

    public static class Ignis {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue HealingMultiplier;
        public final ModConfigSpec.BooleanValue SeparatePhaseMusic;

        Ignis(ModConfigSpec.Builder builder) {
            builder.push("ignis");
            this.HealingMultiplier = builder.comment("Ignis's Life steal Multiplier").translation("config.cataclysm.healing_multiplier").defineInRange("healing_multiplier", CMCommonConfig.Ignis.HealingMultiplier, 0.0, 1000000.0);
            this.SeparatePhaseMusic = builder.comment("Enable separate music per boss phase").translation("config.cataclysm.separate_phase_music").define("separate_phase_music", CMCommonConfig.Ignis.SeparatePhaseMusic);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.Ignis.healthMultiplier, CMCommonConfig.Ignis.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.Ignis.damageCap, CMCommonConfig.Ignis.dpsCap, CMCommonConfig.Ignis.dpsLimitTime, CMCommonConfig.Ignis.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.Ignis.natureHeal);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Ignis.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class Netherite_Ministrosity {
        public final CombatConfig combatConfig;

        Netherite_Ministrosity(ModConfigSpec.Builder builder) {
            builder.push("netherite_ministrosity");
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.NetheriteMinistrosity.healthMultiplier, CMCommonConfig.NetheriteMinistrosity.attackMultiplier);
            builder.pop();
        }
    }

    public static class Netherite_Monstrosity {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.IntValue Lavabombmagazine;
        public final ModConfigSpec.IntValue Lavabombamount;
        public final ModConfigSpec.IntValue LavabombDuration;
        public final ModConfigSpec.IntValue LavabombRandomDuration;
        public final ModConfigSpec.BooleanValue BodyCollided;
        public final ModConfigSpec.DoubleValue SmashHpdamage;
        public final ModConfigSpec.DoubleValue FlameJetDamage;
        public final ModConfigSpec.DoubleValue FlareBombDamage;

        Netherite_Monstrosity(ModConfigSpec.Builder builder) {
            builder.push("netherite_monstrosity");
            this.Lavabombmagazine = builder.comment("Lava bomb Magazine").translation("config.cataclysm.lava_bomb_magazine").defineInRange("lava_bomb_magazine", CMCommonConfig.NetheriteMonstrosity.Lavabombmagazine, 0, 20);
            this.Lavabombamount = builder.comment("Lava bomb Amount").translation("config.cataclysm.lava_bomb_amount").defineInRange("lava_bomb_amount", CMCommonConfig.NetheriteMonstrosity.Lavabombamount, 1, 1000);
            this.LavabombDuration = builder.comment("Lava bomb Duration").translation("config.cataclysm.lava_bomb_duration").defineInRange("lava_bomb_duration", CMCommonConfig.NetheriteMonstrosity.LavabombDuration, 1, 10000);
            this.LavabombRandomDuration = builder.comment("Lava bomb Random Duration").translation("config.cataclysm.lava_bomb_random_duration").defineInRange("lava_bomb_random_duration", CMCommonConfig.NetheriteMonstrosity.LavabombRandomDuration, 1, 10000);
            this.BodyCollided = builder.comment("Body collide like shulker").translation("config.cataclysm.body_collided").define("body_collided", CMCommonConfig.NetheriteMonstrosity.BodyCollided);
            this.SmashHpdamage = builder.comment("Smash Hp Damage").translation("config.cataclysm.smash_hp_damage").defineInRange("smash_hp_damage", CMCommonConfig.NetheriteMonstrosity.SmashHpdamage, 0.0, 1.0);
            this.FlameJetDamage = builder.comment("Flame Jet Damage").translation("config.cataclysm.flame_jet_damage").defineInRange("flame_jet_damage", CMCommonConfig.NetheriteMonstrosity.FlameJetDamage, 0.0, 1000000.0);
            this.FlareBombDamage = builder.comment("Flare Bomb Damage").translation("config.cataclysm.flare_bomb_damage").defineInRange("flare_bomb_damage", CMCommonConfig.NetheriteMonstrosity.FlareBombDamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.NetheriteMonstrosity.healthMultiplier, CMCommonConfig.NetheriteMonstrosity.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.NetheriteMonstrosity.damageCap, CMCommonConfig.NetheriteMonstrosity.dpsCap, CMCommonConfig.NetheriteMonstrosity.dpsLimitTime, CMCommonConfig.NetheriteMonstrosity.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.NetheriteMonstrosity.natureHeal);
            this.respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.NetheriteMonstrosity.respawner);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.NetheriteMonstrosity.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class EnderGolem {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;

        EnderGolem(ModConfigSpec.Builder builder) {
            builder.push("ender_golem");
            this.VoidRuneDamage = builder.comment("Void Rune Damage").translation("config.cataclysm.void_rune_damage").defineInRange("void_rune_damage", CMCommonConfig.EnderGolem.VoidRuneDamage, 0.0, 1000000.0);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.EnderGolem.healthMultiplier, CMCommonConfig.EnderGolem.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.EnderGolem.damageCap, CMCommonConfig.EnderGolem.dpsCap, CMCommonConfig.EnderGolem.dpsLimitTime, CMCommonConfig.EnderGolem.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.EnderGolem.natureHeal);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.EnderGolem.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class EnderGuardian {
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue GravityPunchHpdamage;
        public final ModConfigSpec.DoubleValue TeleportAttackHpdamage;
        public final ModConfigSpec.DoubleValue KnockbackHpdamage;
        public final ModConfigSpec.DoubleValue UppercutHpdamage;
        public final ModConfigSpec.DoubleValue RocketPunchHpdamage;
        public final ModConfigSpec.DoubleValue AreaAttackHpdamage;
        public final ModConfigSpec.IntValue BlockBreakingX;
        public final ModConfigSpec.IntValue BlockBreakingY;
        public final ModConfigSpec.IntValue BlockBreakingZ;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
        public final ModConfigSpec.BooleanValue SeparatePhaseMusic;

        EnderGuardian(ModConfigSpec.Builder builder) {
            builder.push("ender_guardian");
            this.GravityPunchHpdamage = builder.comment("Gravity Punch Hp Damage").translation("config.cataclysm.gravity_punch_hp_damage").defineInRange("gravity_punch_hp_damage", CMCommonConfig.EnderGuardian.GravityPunchHpdamage, 0.0, 1.0);
            this.TeleportAttackHpdamage = builder.comment("Teleport Attack Hp Damage").translation("config.cataclysm.teleport_attack_hp_damage").defineInRange("teleport_attack_hp_damage", CMCommonConfig.EnderGuardian.TeleportAttackHpdamage, 0.0, 1.0);
            this.KnockbackHpdamage = builder.comment("Knockback Hp Damage").translation("config.cataclysm.knockback_hp_damage").defineInRange("knockback_hp_damage", CMCommonConfig.EnderGuardian.KnockbackHpdamage, 0.0, 1.0);
            this.UppercutHpdamage = builder.comment("Uppercut Hp Damage").translation("config.cataclysm.uppercut_hp_damage").defineInRange("uppercut_hp_damage", CMCommonConfig.EnderGuardian.UppercutHpdamage, 0.0, 1.0);
            this.RocketPunchHpdamage = builder.comment("Rocket Punch Hp Damage").translation("config.cataclysm.rocket_punch_hp_damage").defineInRange("rocket_punch_hp_damage", CMCommonConfig.EnderGuardian.RocketPunchHpdamage, 0.0, 1.0);
            this.AreaAttackHpdamage = builder.comment("Area Attack Hp Damage").translation("config.cataclysm.area_attack_hp_damage").defineInRange("area_attack_hp_damage", CMCommonConfig.EnderGuardian.AreaAttackHpdamage, 0.0, 1.0);
            this.BlockBreakingX = builder.comment("Block Breaking X").translation("config.cataclysm.block_break_x").defineInRange("block_break_x", CMCommonConfig.EnderGuardian.BlockBreakingX, 0, 20);
            this.BlockBreakingY = builder.comment("Block Breaking Y").translation("config.cataclysm.block_break_y").defineInRange("block_break_y", CMCommonConfig.EnderGuardian.BlockBreakingY, 0, 10);
            this.BlockBreakingZ = builder.comment("Block Breaking Z").translation("config.cataclysm.block_break_z").defineInRange("block_break_z", CMCommonConfig.EnderGuardian.BlockBreakingZ, 0, 20);
            this.VoidRuneDamage = builder.comment("Void Rune Damage").translation("config.cataclysm.void_rune_damage").defineInRange("void_rune_damage", CMCommonConfig.EnderGuardian.VoidRuneDamage, 0.0, 1000000.0);
            this.SeparatePhaseMusic = builder.comment("Enable separate music per boss phase").translation("config.cataclysm.separate_phase_music").define("separate_phase_music", CMCommonConfig.EnderGuardian.SeparatePhaseMusic);
            this.combatConfig = new CombatConfig(builder, CMCommonConfig.EnderGuardian.healthMultiplier, CMCommonConfig.EnderGuardian.attackMultiplier);
            this.capConfig = new CapConfig(builder, CMCommonConfig.EnderGuardian.damageCap, CMCommonConfig.EnderGuardian.dpsCap, CMCommonConfig.EnderGuardian.dpsLimitTime, CMCommonConfig.EnderGuardian.rangeCap);
            this.healConfig = new NatureHealConfig(builder, CMCommonConfig.EnderGuardian.natureHeal);
            this.respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.EnderGuardian.respawner);
            this.mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.EnderGuardian.ignoreMobGriefing);
            builder.pop();
        }
    }

    public static class ETC {
        public final ModConfigSpec.IntValue ReturnHome;

        ETC(ModConfigSpec.Builder builder) {
            builder.push("etc");
            this.ReturnHome = builder.comment("Return Home").translation("config.cataclysm.return_home").defineInRange("return_home", 20, 0, 200);
            builder.pop();
        }
    }

    public static class CursedTombstone {
        public final ModConfigSpec.IntValue CursedTombstoneCooldown;

        CursedTombstone(ModConfigSpec.Builder builder) {
            builder.push("cursed_tombstone");
            this.CursedTombstoneCooldown = builder.comment("Cursed Tombstone Cooldown").translation("config.cataclysm.cursed_tombstone_cooldown").defineInRange("cursed_tombstone_cooldown", 1, 0, 30);
            builder.pop();
        }
    }

    public static class RespawnerConfig {
        public final ModConfigSpec.BooleanValue Respawner;

        RespawnerConfig(ModConfigSpec.Builder builder, boolean spawner) {
            builder.push("respawner_config");
            this.Respawner = builder.comment("Respawner").translation("config.cataclysm.respawner").define("respawner", spawner);
            builder.pop();
        }
    }

    public static class ArmorConfig {
        public final ModConfigSpec.DoubleValue armormultiplier;
        public final ModConfigSpec.DoubleValue toughness;
        public final ModConfigSpec.DoubleValue knockbackRes;
        public float ArmorMultiplierValue = 1.0f;
        public float toughnessValue = 1.0f;
        public float KnockbackResistanceValue = 0.01f;

        ArmorConfig(ModConfigSpec.Builder builder, double armorMulti, double toughness, double knockbackResistanceValue) {
            builder.push("armor_config");
            this.armormultiplier = builder.comment("Armor_Multiplier").translation("config.cataclysm.armor_multiplier").defineInRange("armor_multiplier", armorMulti, 0.0, 1000000.0);
            this.toughness = builder.comment("Toughness").translation("config.cataclysm.toughness").defineInRange("toughness", toughness, 0.0, 1000000.0);
            this.knockbackRes = builder.comment("Knockback Resistance").translation("config.cataclysm.knockback_resistance").defineInRange("knockback_resistance", knockbackResistanceValue, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class ToolConfig {
        public final ModConfigSpec.DoubleValue attackDamage;
        public final ModConfigSpec.DoubleValue attackSpeed;
        public float attackDamageValue = 9.0f;
        public float attackSpeedValue = 0.9f;

        ToolConfig(ModConfigSpec.Builder builder, double attackDamage, double attackSpeed) {
            builder.push("tool_config");
            this.attackDamage = builder.comment("Tool attack damage").translation("config.cataclysm.attack_damage").defineInRange("attack_damage", attackDamage, 0.0, 1000000.0);
            this.attackSpeed = builder.comment("Tool attack speed").translation("config.cataclysm.attack_speed").defineInRange("attack_speed", attackSpeed, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class NatureHealConfig {
        public final ModConfigSpec.DoubleValue heal;

        NatureHealConfig(ModConfigSpec.Builder builder, double Heal) {
            builder.push("nature_heal_config");
            this.heal = builder.comment("Nature Heal").translation("config.cataclysm.nature_heal").defineInRange("nature_heal", Heal, 0.0, 1000000.0);
            builder.pop();
        }
    }

    public static class CapConfig {
        public final ModConfigSpec.DoubleValue damageCap;
        public final ModConfigSpec.DoubleValue dpsCap;
        public final ModConfigSpec.IntValue dpslimittime;
        public final ModConfigSpec.DoubleValue rangeCap;

        CapConfig(ModConfigSpec.Builder builder, double DamageCap, double DpsCap, int dpslimittime, double RangeCap) {
            builder.push("cap_config");
            this.damageCap = builder.comment("Damage Cap").translation("config.cataclysm.damage_cap").defineInRange("damage_cap", DamageCap, 0.0, 1000000.0);
            this.dpsCap = builder.comment("Dps Cap").translation("config.cataclysm.dps_cap").defineInRange("dps_cap", DpsCap, 1.0, 1000000.0);
            this.dpslimittime = builder.comment("DPS Limit Time").translation("config.cataclysm.dps_limit_time").defineInRange("dps_limit_time", dpslimittime, 1, 100);
            this.rangeCap = builder.comment("Range Cap").translation("config.cataclysm.range_cap").defineInRange("range_cap", RangeCap, 1.0, 1000000.0);
            builder.pop();
        }
    }

    public static class IgnoreMobGriefing {
        public final ModConfigSpec.BooleanValue Ignore;

        IgnoreMobGriefing(ModConfigSpec.Builder builder, boolean ignore) {
            builder.push("ignore_mobgriefing_config");
            this.Ignore = builder.comment("Ignore MobGriefing").translation("config.cataclysm.ignore_mobgriefing").define("ignore_mobgriefing", ignore);
            builder.pop();
        }
    }

    public static class CombatConfig {
        public final ModConfigSpec.DoubleValue healthMultiplier;
        public final ModConfigSpec.DoubleValue attackMultiplier;

        CombatConfig(ModConfigSpec.Builder builder, double healthMultiplier, double attackMultiplier) {
            builder.push("combat_config");
            this.healthMultiplier = builder.comment("Scale mob health by this value").translation("config.cataclysm.health_multiplier").defineInRange("health_multiplier", healthMultiplier, 0.1, 1000000.0);
            this.attackMultiplier = builder.comment("Scale mob attack damage by this value").translation("config.cataclysm.attack_multiplier").defineInRange("attack_multiplier", attackMultiplier, 0.1, 1000000.0);
            builder.pop();
        }
    }
}

