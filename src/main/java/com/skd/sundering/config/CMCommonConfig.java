/*
 * Decompiled with CFR 0.152.
 */
package com.skd.sundering.config;

import com.skd.sundering.Cataclysm;
import com.skd.sundering.config.CommonConfig;

public class CMCommonConfig {
    public static void Commonbake(CommonConfig config) {
        try {
            EnderGuardian.healthMultiplier = (Double)config.MOBS.ENDERGUARDIAN.combatConfig.healthMultiplier.get();
            EnderGuardian.attackMultiplier = (Double)config.MOBS.ENDERGUARDIAN.combatConfig.attackMultiplier.get();
            EnderGuardian.damageCap = (Double)config.MOBS.ENDERGUARDIAN.capConfig.damageCap.get();
            EnderGuardian.dpsCap = (Double)config.MOBS.ENDERGUARDIAN.capConfig.dpsCap.get();
            EnderGuardian.dpsLimitTime = (Integer)config.MOBS.ENDERGUARDIAN.capConfig.dpslimittime.get();
            EnderGuardian.rangeCap = (Double)config.MOBS.ENDERGUARDIAN.capConfig.rangeCap.get();
            EnderGuardian.natureHeal = (Double)config.MOBS.ENDERGUARDIAN.healConfig.heal.get();
            EnderGuardian.respawner = (Boolean)config.MOBS.ENDERGUARDIAN.respawnerConfig.Respawner.get();
            EnderGuardian.ignoreMobGriefing = (Boolean)config.MOBS.ENDERGUARDIAN.mobGriefingConfig.Ignore.get();
            EnderGuardian.GravityPunchHpdamage = (Double)config.MOBS.ENDERGUARDIAN.GravityPunchHpdamage.get();
            EnderGuardian.TeleportAttackHpdamage = (Double)config.MOBS.ENDERGUARDIAN.TeleportAttackHpdamage.get();
            EnderGuardian.KnockbackHpdamage = (Double)config.MOBS.ENDERGUARDIAN.KnockbackHpdamage.get();
            EnderGuardian.UppercutHpdamage = (Double)config.MOBS.ENDERGUARDIAN.UppercutHpdamage.get();
            EnderGuardian.RocketPunchHpdamage = (Double)config.MOBS.ENDERGUARDIAN.RocketPunchHpdamage.get();
            EnderGuardian.AreaAttackHpdamage = (Double)config.MOBS.ENDERGUARDIAN.AreaAttackHpdamage.get();
            EnderGuardian.BlockBreakingX = (Integer)config.MOBS.ENDERGUARDIAN.BlockBreakingX.get();
            EnderGuardian.BlockBreakingY = (Integer)config.MOBS.ENDERGUARDIAN.BlockBreakingY.get();
            EnderGuardian.BlockBreakingZ = (Integer)config.MOBS.ENDERGUARDIAN.BlockBreakingZ.get();
            EnderGuardian.VoidRuneDamage = (Double)config.MOBS.ENDERGUARDIAN.VoidRuneDamage.get();
            EnderGuardian.SeparatePhaseMusic = (Boolean)config.MOBS.ENDERGUARDIAN.SeparatePhaseMusic.get();
            EnderGolem.healthMultiplier = (Double)config.MOBS.ENDERGOLEM.combatConfig.healthMultiplier.get();
            EnderGolem.attackMultiplier = (Double)config.MOBS.ENDERGOLEM.combatConfig.attackMultiplier.get();
            EnderGolem.damageCap = (Double)config.MOBS.ENDERGOLEM.capConfig.damageCap.get();
            EnderGolem.dpsCap = (Double)config.MOBS.ENDERGOLEM.capConfig.dpsCap.get();
            EnderGolem.dpsLimitTime = (Integer)config.MOBS.ENDERGOLEM.capConfig.dpslimittime.get();
            EnderGolem.rangeCap = (Double)config.MOBS.ENDERGOLEM.capConfig.rangeCap.get();
            EnderGolem.natureHeal = (Double)config.MOBS.ENDERGOLEM.healConfig.heal.get();
            EnderGolem.ignoreMobGriefing = (Boolean)config.MOBS.ENDERGOLEM.mobGriefingConfig.Ignore.get();
            EnderGolem.VoidRuneDamage = (Double)config.MOBS.ENDERGOLEM.VoidRuneDamage.get();
            NetheriteMonstrosity.healthMultiplier = (Double)config.MOBS.NETHERITE_MONSTROSITY.combatConfig.healthMultiplier.get();
            NetheriteMonstrosity.attackMultiplier = (Double)config.MOBS.NETHERITE_MONSTROSITY.combatConfig.attackMultiplier.get();
            NetheriteMonstrosity.damageCap = (Double)config.MOBS.NETHERITE_MONSTROSITY.capConfig.damageCap.get();
            NetheriteMonstrosity.dpsCap = (Double)config.MOBS.NETHERITE_MONSTROSITY.capConfig.dpsCap.get();
            NetheriteMonstrosity.dpsLimitTime = (Integer)config.MOBS.NETHERITE_MONSTROSITY.capConfig.dpslimittime.get();
            NetheriteMonstrosity.rangeCap = (Double)config.MOBS.NETHERITE_MONSTROSITY.capConfig.rangeCap.get();
            NetheriteMonstrosity.natureHeal = (Double)config.MOBS.NETHERITE_MONSTROSITY.healConfig.heal.get();
            NetheriteMonstrosity.respawner = (Boolean)config.MOBS.NETHERITE_MONSTROSITY.respawnerConfig.Respawner.get();
            NetheriteMonstrosity.ignoreMobGriefing = (Boolean)config.MOBS.NETHERITE_MONSTROSITY.mobGriefingConfig.Ignore.get();
            NetheriteMonstrosity.Lavabombmagazine = (Integer)config.MOBS.NETHERITE_MONSTROSITY.Lavabombmagazine.get();
            NetheriteMonstrosity.Lavabombamount = (Integer)config.MOBS.NETHERITE_MONSTROSITY.Lavabombamount.get();
            NetheriteMonstrosity.LavabombDuration = (Integer)config.MOBS.NETHERITE_MONSTROSITY.LavabombDuration.get();
            NetheriteMonstrosity.LavabombRandomDuration = (Integer)config.MOBS.NETHERITE_MONSTROSITY.LavabombRandomDuration.get();
            NetheriteMonstrosity.BodyCollided = (Boolean)config.MOBS.NETHERITE_MONSTROSITY.BodyCollided.get();
            NetheriteMonstrosity.SmashHpdamage = (Double)config.MOBS.NETHERITE_MONSTROSITY.SmashHpdamage.get();
            NetheriteMonstrosity.FlameJetDamage = (Double)config.MOBS.NETHERITE_MONSTROSITY.FlameJetDamage.get();
            NetheriteMonstrosity.FlareBombDamage = (Double)config.MOBS.NETHERITE_MONSTROSITY.FlareBombDamage.get();
            NetheriteMinistrosity.healthMultiplier = (Double)config.MOBS.NETHERITE_MINISTROSITY.combatConfig.healthMultiplier.get();
            NetheriteMinistrosity.attackMultiplier = (Double)config.MOBS.NETHERITE_MINISTROSITY.combatConfig.attackMultiplier.get();
            Ignis.healthMultiplier = (Double)config.MOBS.IGNIS.combatConfig.healthMultiplier.get();
            Ignis.attackMultiplier = (Double)config.MOBS.IGNIS.combatConfig.attackMultiplier.get();
            Ignis.damageCap = (Double)config.MOBS.IGNIS.capConfig.damageCap.get();
            Ignis.dpsCap = (Double)config.MOBS.IGNIS.capConfig.dpsCap.get();
            Ignis.dpsLimitTime = (Integer)config.MOBS.IGNIS.capConfig.dpslimittime.get();
            Ignis.rangeCap = (Double)config.MOBS.IGNIS.capConfig.rangeCap.get();
            Ignis.natureHeal = (Double)config.MOBS.IGNIS.healConfig.heal.get();
            Ignis.ignoreMobGriefing = (Boolean)config.MOBS.IGNIS.mobGriefingConfig.Ignore.get();
            Ignis.HealingMultiplier = (Double)config.MOBS.IGNIS.HealingMultiplier.get();
            Ignis.SeparatePhaseMusic = (Boolean)config.MOBS.IGNIS.SeparatePhaseMusic.get();
            IgnitedRevenant.healthMultiplier = (Double)config.MOBS.REVENANT.combatConfig.healthMultiplier.get();
            IgnitedRevenant.attackMultiplier = (Double)config.MOBS.REVENANT.combatConfig.attackMultiplier.get();
            IgnitedRevenant.AshenbreathDamage = (Double)config.MOBS.REVENANT.AshenbreathDamage.get();
            IgnitedRevenant.BlazingBoneDamage = (Double)config.MOBS.REVENANT.BlazingBoneDamage.get();
            Harbinger.healthMultiplier = (Double)config.MOBS.HARBINGER.combatConfig.healthMultiplier.get();
            Harbinger.attackMultiplier = (Double)config.MOBS.HARBINGER.combatConfig.attackMultiplier.get();
            Harbinger.damageCap = (Double)config.MOBS.HARBINGER.capConfig.damageCap.get();
            Harbinger.dpsCap = (Double)config.MOBS.HARBINGER.capConfig.dpsCap.get();
            Harbinger.dpsLimitTime = (Integer)config.MOBS.HARBINGER.capConfig.dpslimittime.get();
            Harbinger.rangeCap = (Double)config.MOBS.HARBINGER.capConfig.rangeCap.get();
            Harbinger.natureHeal = (Double)config.MOBS.HARBINGER.healConfig.heal.get();
            Harbinger.respawner = (Boolean)config.MOBS.HARBINGER.respawnerConfig.Respawner.get();
            Harbinger.ignoreMobGriefing = (Boolean)config.MOBS.HARBINGER.mobGriefingConfig.Ignore.get();
            Harbinger.AutoHeal = (Double)config.MOBS.HARBINGER.AutoHeal.get();
            Harbinger.LifeSteal = (Double)config.MOBS.HARBINGER.LifeSteal.get();
            Harbinger.WitherMissiledamage = (Double)config.MOBS.HARBINGER.WitherMissiledamage.get();
            Harbinger.Laserdamage = (Double)config.MOBS.HARBINGER.Laserdamage.get();
            Harbinger.DeathLaserdamage = (Double)config.MOBS.HARBINGER.DeathLaserdamage.get();
            Harbinger.DeathLaserHpdamage = (Double)config.MOBS.HARBINGER.DeathLaserHpdamage.get();
            Harbinger.ChargeHpDamage = (Double)config.MOBS.HARBINGER.ChargeHpDamage.get();
            Prowler.healthMultiplier = (Double)config.MOBS.PROWLER.combatConfig.healthMultiplier.get();
            Prowler.attackMultiplier = (Double)config.MOBS.PROWLER.combatConfig.attackMultiplier.get();
            Prowler.rangeCap = (Double)config.MOBS.PROWLER.rangeCap.get();
            Prowler.HomingMissiledamage = (Double)config.MOBS.PROWLER.HomingMissiledamage.get();
            Prowler.DeathLaserdamage = (Double)config.MOBS.PROWLER.DeathLaserdamage.get();
            Prowler.DeathLaserHpdamage = (Double)config.MOBS.PROWLER.DeathLaserHpdamage.get();
            Leviathan.healthMultiplier = (Double)config.MOBS.LEVIATHAN.combatConfig.healthMultiplier.get();
            Leviathan.attackMultiplier = (Double)config.MOBS.LEVIATHAN.combatConfig.attackMultiplier.get();
            Leviathan.damageCap = (Double)config.MOBS.LEVIATHAN.capConfig.damageCap.get();
            Leviathan.dpsCap = (Double)config.MOBS.LEVIATHAN.capConfig.dpsCap.get();
            Leviathan.dpsLimitTime = (Integer)config.MOBS.LEVIATHAN.capConfig.dpslimittime.get();
            Leviathan.rangeCap = (Double)config.MOBS.LEVIATHAN.capConfig.rangeCap.get();
            Leviathan.natureHeal = (Double)config.MOBS.LEVIATHAN.healConfig.heal.get();
            Leviathan.ignoreMobGriefing = (Boolean)config.MOBS.LEVIATHAN.mobGriefingConfig.Ignore.get();
            Leviathan.BiteHpDamage = (Double)config.MOBS.LEVIATHAN.BiteHpDamage.get();
            Leviathan.RushHpDamage = (Double)config.MOBS.LEVIATHAN.RushHpDamage.get();
            Leviathan.TailSwingHpDamage = (Double)config.MOBS.LEVIATHAN.TailSwingHpDamage.get();
            Leviathan.TentacleHpDamage = (Double)config.MOBS.LEVIATHAN.TentacleHpDamage.get();
            Leviathan.DimensionalRiftDamage = (Double)config.MOBS.LEVIATHAN.DimensionalRiftDamage.get();
            Leviathan.AbyssBlastDamage = (Double)config.MOBS.LEVIATHAN.AbyssBlastDamage.get();
            Leviathan.AbyssBlastHpDamage = (Double)config.MOBS.LEVIATHAN.AbyssBlastHpDamage.get();
            Leviathan.AbyssOrbdamage = (Double)config.MOBS.LEVIATHAN.AbyssOrbdamage.get();
            Leviathan.ImmuneOutofWater = (Boolean)config.MOBS.LEVIATHAN.ImmuneOutofWater.get();
            Leviathan.SeparatePhaseMusic = (Boolean)config.MOBS.LEVIATHAN.SeparatePhaseMusic.get();
            BabyLeviathan.healthMultiplier = (Double)config.MOBS.BABY_LEVIATHAN.combatConfig.healthMultiplier.get();
            BabyLeviathan.attackMultiplier = (Double)config.MOBS.BABY_LEVIATHAN.combatConfig.attackMultiplier.get();
            AmethystCrab.healthMultiplier = (Double)config.MOBS.CRAB.combatConfig.healthMultiplier.get();
            AmethystCrab.attackMultiplier = (Double)config.MOBS.CRAB.combatConfig.attackMultiplier.get();
            AmethystCrab.EarthQuakeDamage = (Double)config.MOBS.CRAB.EarthQuakeDamage.get();
            AmethystCrab.AmethystClusterDamage = (Double)config.MOBS.CRAB.AmethystClusterDamage.get();
            AncientRemnant.healthMultiplier = (Double)config.MOBS.ANCIENT_REMNANT.combatConfig.healthMultiplier.get();
            AncientRemnant.attackMultiplier = (Double)config.MOBS.ANCIENT_REMNANT.combatConfig.attackMultiplier.get();
            AncientRemnant.damageCap = (Double)config.MOBS.ANCIENT_REMNANT.capConfig.damageCap.get();
            AncientRemnant.dpsCap = (Double)config.MOBS.ANCIENT_REMNANT.capConfig.dpsCap.get();
            AncientRemnant.dpsLimitTime = (Integer)config.MOBS.ANCIENT_REMNANT.capConfig.dpslimittime.get();
            AncientRemnant.rangeCap = (Double)config.MOBS.ANCIENT_REMNANT.capConfig.rangeCap.get();
            AncientRemnant.natureHeal = (Double)config.MOBS.ANCIENT_REMNANT.healConfig.heal.get();
            AncientRemnant.respawner = (Boolean)config.MOBS.ANCIENT_REMNANT.respawnerConfig.Respawner.get();
            AncientRemnant.ignoreMobGriefing = (Boolean)config.MOBS.ANCIENT_REMNANT.mobGriefingConfig.Ignore.get();
            AncientRemnant.ChargeHpDamage = (Double)config.MOBS.ANCIENT_REMNANT.ChargeHpDamage.get();
            AncientRemnant.HpDamage = (Double)config.MOBS.ANCIENT_REMNANT.HpDamage.get();
            AncientRemnant.StompHpDamage = (Double)config.MOBS.ANCIENT_REMNANT.StompHpDamage.get();
            AncientRemnant.EarthQuakeDamage = (Double)config.MOBS.ANCIENT_REMNANT.EarthQuakeDamage.get();
            AncientRemnant.AncientDesertSteledamage = (Double)config.MOBS.ANCIENT_REMNANT.AncientDesertSteledamage.get();
            ModernRemnant.healthMultiplier = (Double)config.MOBS.MODERN_REMNANT.combatConfig.healthMultiplier.get();
            ModernRemnant.attackMultiplier = (Double)config.MOBS.MODERN_REMNANT.combatConfig.attackMultiplier.get();
            Koboleton.CauseKoboletontoDropItemInHandPercent = (Double)config.MOBS.KOBOLETON.CauseKoboletontoDropItemInHandPercent.get();
            Kobolediator.healthMultiplier = (Double)config.MOBS.KOBOLEDIATOR.combatConfig.healthMultiplier.get();
            Kobolediator.attackMultiplier = (Double)config.MOBS.KOBOLEDIATOR.combatConfig.attackMultiplier.get();
            Kobolediator.ignoreMobGriefing = (Boolean)config.MOBS.KOBOLEDIATOR.mobGriefingConfig.Ignore.get();
            Wadjet.healthMultiplier = (Double)config.MOBS.WADJET.combatConfig.healthMultiplier.get();
            Wadjet.attackMultiplier = (Double)config.MOBS.WADJET.combatConfig.attackMultiplier.get();
            Wadjet.Sandstorm_damage = (Double)config.MOBS.WADJET.Sandstorm_damage.get();
            Wadjet.AncientDesertSteledamage = (Double)config.MOBS.WADJET.AncientDesertSteledamage.get();
            Scylla.healthMultiplier = (Double)config.MOBS.SCYLLA.combatConfig.healthMultiplier.get();
            Scylla.attackMultiplier = (Double)config.MOBS.SCYLLA.combatConfig.attackMultiplier.get();
            Scylla.damageCap = (Double)config.MOBS.SCYLLA.capConfig.damageCap.get();
            Scylla.dpsCap = (Double)config.MOBS.SCYLLA.capConfig.dpsCap.get();
            Scylla.dpsLimitTime = (Integer)config.MOBS.SCYLLA.capConfig.dpslimittime.get();
            Scylla.rangeCap = (Double)config.MOBS.SCYLLA.capConfig.rangeCap.get();
            Scylla.natureHeal = (Double)config.MOBS.SCYLLA.healConfig.heal.get();
            Scylla.respawner = (Boolean)config.MOBS.SCYLLA.respawnerConfig.Respawner.get();
            Scylla.ignoreMobGriefing = (Boolean)config.MOBS.SCYLLA.mobGriefingConfig.Ignore.get();
            Scylla.SpearDamage = (Double)config.MOBS.SCYLLA.SpearDamage.get();
            Scylla.LightningStormDamage = (Double)config.MOBS.SCYLLA.LightningStormDamage.get();
            Scylla.LightningAreaDamage = (Double)config.MOBS.SCYLLA.LightningAreaDamage.get();
            Scylla.SnakeDamage = (Double)config.MOBS.SCYLLA.SnakeDamage.get();
            Scylla.AnchorDamage = (Double)config.MOBS.SCYLLA.AnchorDamage.get();
            Scylla.WeatherChange = (Boolean)config.MOBS.SCYLLA.WeatherChange.get();
            Scylla.HpDamage = (Double)config.MOBS.SCYLLA.HpDamage.get();
            Scylla.SpinHpDamage = (Double)config.MOBS.SCYLLA.SpinHpDamage.get();
            Scylla.StormHpDamage = (Double)config.MOBS.SCYLLA.StormHpDamage.get();
            Clawdian.healthMultiplier = (Double)config.MOBS.CLAWDIAN.combatConfig.healthMultiplier.get();
            Clawdian.attackMultiplier = (Double)config.MOBS.CLAWDIAN.combatConfig.attackMultiplier.get();
            Clawdian.damageCap = (Double)config.MOBS.CLAWDIAN.capConfig.damageCap.get();
            Clawdian.dpsCap = (Double)config.MOBS.CLAWDIAN.capConfig.dpsCap.get();
            Clawdian.dpsLimitTime = (Integer)config.MOBS.CLAWDIAN.capConfig.dpslimittime.get();
            Clawdian.rangeCap = (Double)config.MOBS.CLAWDIAN.capConfig.rangeCap.get();
            Clawdian.natureHeal = (Double)config.MOBS.CLAWDIAN.healConfig.heal.get();
            Clawdian.ignoreMobGriefing = (Boolean)config.MOBS.CLAWDIAN.mobGriefingConfig.Ignore.get();
            Maledictus.healthMultiplier = (Double)config.MOBS.MALEDICTUS.combatConfig.healthMultiplier.get();
            Maledictus.attackMultiplier = (Double)config.MOBS.MALEDICTUS.combatConfig.attackMultiplier.get();
            Maledictus.damageCap = (Double)config.MOBS.MALEDICTUS.capConfig.damageCap.get();
            Maledictus.dpsCap = (Double)config.MOBS.MALEDICTUS.capConfig.dpsCap.get();
            Maledictus.dpsLimitTime = (Integer)config.MOBS.MALEDICTUS.capConfig.dpslimittime.get();
            Maledictus.rangeCap = (Double)config.MOBS.MALEDICTUS.capConfig.rangeCap.get();
            Maledictus.natureHeal = (Double)config.MOBS.MALEDICTUS.healConfig.heal.get();
            Maledictus.ignoreMobGriefing = (Boolean)config.MOBS.MALEDICTUS.mobGriefingConfig.Ignore.get();
            Maledictus.PhantomHalberdDamage = (Double)config.MOBS.MALEDICTUS.PhantomHalberdDamage.get();
            Maledictus.HpDamage = (Double)config.MOBS.MALEDICTUS.HpDamage.get();
            Maledictus.ShockWaveHpDamage = (Double)config.MOBS.MALEDICTUS.ShockWaveHpDamage.get();
            Maledictus.AOEHpDamage = (Double)config.MOBS.MALEDICTUS.AOEHpDamage.get();
            Maledictus.FlyingSmashHpDamage = (Double)config.MOBS.MALEDICTUS.FlyingSmashHpDamage.get();
            Maledictus.SmashHpDamage = (Double)config.MOBS.MALEDICTUS.SmashHpDamage.get();
            Maledictus.PhantomArrowDamage = (Double)config.MOBS.MALEDICTUS.PhantomArrowDamage.get();
            Aptrgangr.healthMultiplier = (Double)config.MOBS.APTRGANGR.combatConfig.healthMultiplier.get();
            Aptrgangr.attackMultiplier = (Double)config.MOBS.APTRGANGR.combatConfig.attackMultiplier.get();
            Aptrgangr.natureHeal = (Double)config.MOBS.APTRGANGR.healConfig.heal.get();
            Aptrgangr.AxeBladeDamage = (Double)config.MOBS.APTRGANGR.AxeBladeDamage.get();
            ETC.ReturnHome = (Integer)config.MOBS.ETC.ReturnHome.get();
            Spawning.DeeplingSpawnWeight = (Integer)config.SPAWNING.DeeplingSpawnWeight.get();
            Spawning.DeeplingSpawnRolls = (Integer)config.SPAWNING.DeeplingSpawnRolls.get();
            Spawning.DeeplingBruteSpawnWeight = (Integer)config.SPAWNING.DeeplingBruteSpawnWeight.get();
            Spawning.DeeplingBruteSpawnRolls = (Integer)config.SPAWNING.DeeplingBruteSpawnRolls.get();
            Spawning.DeeplingAnglerSpawnWeight = (Integer)config.SPAWNING.DeeplingAnglerSpawnWeight.get();
            Spawning.DeeplingAnglerSpawnRolls = (Integer)config.SPAWNING.DeeplingAnglerSpawnRolls.get();
            Spawning.DeeplingPriestSpawnWeight = (Integer)config.SPAWNING.DeeplingPriestSpawnWeight.get();
            Spawning.DeeplingPriestSpawnRolls = (Integer)config.SPAWNING.DeeplingPriestSpawnRolls.get();
            Spawning.DeeplingWarlockSpawnWeight = (Integer)config.SPAWNING.DeeplingWarlockSpawnWeight.get();
            Spawning.DeeplingWarlockSpawnRolls = (Integer)config.SPAWNING.DeeplingWarlockSpawnRolls.get();
            Spawning.CoralgolemSpawnWeight = (Integer)config.SPAWNING.CoralgolemSpawnWeight.get();
            Spawning.CoralgolemSpawnRolls = (Integer)config.SPAWNING.CoralgolemSpawnRolls.get();
            Spawning.AmethystCrabSpawnWeight = (Integer)config.SPAWNING.AmethystCrabSpawnWeight.get();
            Spawning.AmethystCrabSpawnRolls = (Integer)config.SPAWNING.AmethystCrabSpawnRolls.get();
            Spawning.KoboletonSpawnWeight = (Integer)config.SPAWNING.KoboletonSpawnWeight.get();
            Spawning.KoboletonSpawnRolls = (Integer)config.SPAWNING.KoboletonSpawnRolls.get();
            Spawning.IgnitedBerserkerSpawnWeight = (Integer)config.SPAWNING.IgnitedBerserkerSpawnWeight.get();
            Spawning.IgnitedBerserkerSpawnRolls = (Integer)config.SPAWNING.IgnitedBerserkerSpawnRolls.get();
            IgnitiumArmor.armorMultiplier = (Double)config.TOOLS_AND_ABILITIES.IGNITIUM_ARMOR.armorConfig.armormultiplier.get();
            IgnitiumArmor.toughness = (Double)config.TOOLS_AND_ABILITIES.IGNITIUM_ARMOR.armorConfig.toughness.get();
            IgnitiumArmor.knockbackResistance = (Double)config.TOOLS_AND_ABILITIES.IGNITIUM_ARMOR.armorConfig.knockbackRes.get();
            CursiumArmor.armorMultiplier = (Double)config.TOOLS_AND_ABILITIES.CURSIUM_ARMOR.armorConfig.armormultiplier.get();
            CursiumArmor.toughness = (Double)config.TOOLS_AND_ABILITIES.CURSIUM_ARMOR.armorConfig.toughness.get();
            CursiumArmor.knockbackResistance = (Double)config.TOOLS_AND_ABILITIES.CURSIUM_ARMOR.armorConfig.knockbackRes.get();
            BoneReptileArmor.armorMultiplier = (Double)config.TOOLS_AND_ABILITIES.BONE_REPTILE_ARMOR.armorConfig.armormultiplier.get();
            BoneReptileArmor.toughness = (Double)config.TOOLS_AND_ABILITIES.BONE_REPTILE_ARMOR.armorConfig.toughness.get();
            BoneReptileArmor.knockbackResistance = (Double)config.TOOLS_AND_ABILITIES.BONE_REPTILE_ARMOR.armorConfig.knockbackRes.get();
            BloomStoneArmor.armorMultiplier = (Double)config.TOOLS_AND_ABILITIES.BLOOM_STONE_ARMOR.armorConfig.armormultiplier.get();
            BloomStoneArmor.toughness = (Double)config.TOOLS_AND_ABILITIES.BLOOM_STONE_ARMOR.armorConfig.toughness.get();
            BloomStoneArmor.knockbackResistance = (Double)config.TOOLS_AND_ABILITIES.BLOOM_STONE_ARMOR.armorConfig.knockbackRes.get();
            Incinerator.attackDamage = (Double)config.TOOLS_AND_ABILITIES.INCINERATOR.toolConfig.attackDamage.get();
            Incinerator.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.INCINERATOR.toolConfig.attackSpeed.get();
            Incinerator.cooldown = (Integer)config.TOOLS_AND_ABILITIES.INCINERATOR.IncineratorCooldown.get();
            BulwarkOfTheFlame.cooldown = (Integer)config.TOOLS_AND_ABILITIES.BULWARK_OF_THE_FLAME.BulwarkOfTheFlameCooldown.get();
            GauntletOfGuard.attackDamage = (Double)config.TOOLS_AND_ABILITIES.GAUNTLER_OF_GUARD.toolConfig.attackDamage.get();
            GauntletOfGuard.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.GAUNTLER_OF_GUARD.toolConfig.attackSpeed.get();
            GauntletOfBulwark.attackDamage = (Double)config.TOOLS_AND_ABILITIES.GAUNTLET_OF_BULWARK.toolConfig.attackDamage.get();
            GauntletOfBulwark.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.GAUNTLET_OF_BULWARK.toolConfig.attackSpeed.get();
            GauntletOfBulwark.cooldown = (Integer)config.TOOLS_AND_ABILITIES.GAUNTLET_OF_BULWARK.GauntletOfBulwarkCooldown.get();
            GauntletOfMaelstrom.attackDamage = (Double)config.TOOLS_AND_ABILITIES.GAUNTLER_OF_MAELSTROM.toolConfig.attackDamage.get();
            GauntletOfMaelstrom.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.GAUNTLER_OF_MAELSTROM.toolConfig.attackSpeed.get();
            GauntletOfMaelstrom.cooldown = (Integer)config.TOOLS_AND_ABILITIES.GAUNTLER_OF_MAELSTROM.GauntletOfMaelstromCooldown.get();
            InfernalForge.attackDamage = (Double)config.TOOLS_AND_ABILITIES.INFERNAL_FORGE.toolConfig.attackDamage.get();
            InfernalForge.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.INFERNAL_FORGE.toolConfig.attackSpeed.get();
            InfernalForge.cooldown = (Integer)config.TOOLS_AND_ABILITIES.INFERNAL_FORGE.InfernalForgeCooldown.get();
            VoidForge.attackDamage = (Double)config.TOOLS_AND_ABILITIES.VOID_FORGE.toolConfig.attackDamage.get();
            VoidForge.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.VOID_FORGE.toolConfig.attackSpeed.get();
            VoidForge.cooldown = (Integer)config.TOOLS_AND_ABILITIES.VOID_FORGE.VoidForgeCooldown.get();
            VoidForge.runeDamage = (Double)config.TOOLS_AND_ABILITIES.VOID_FORGE.VoidRuneDamage.get();
            Brontes.attackDamage = (Double)config.TOOLS_AND_ABILITIES.BRONTES.toolConfig.attackDamage.get();
            Brontes.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.BRONTES.toolConfig.attackSpeed.get();
            Brontes.stormareadamage = (Double)config.TOOLS_AND_ABILITIES.BRONTES.StormAreaDamage.get();
            Brontes.stormdamage = (Double)config.TOOLS_AND_ABILITIES.BRONTES.StormDamage.get();
            MeatShredder.attackDamage = (Double)config.TOOLS_AND_ABILITIES.MEATH_SHREDDER.toolConfig.attackDamage.get();
            MeatShredder.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.MEATH_SHREDDER.toolConfig.attackSpeed.get();
            Annihilator.attackDamage = (Double)config.TOOLS_AND_ABILITIES.ANNIHILATOR.toolConfig.attackDamage.get();
            Annihilator.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.ANNIHILATOR.toolConfig.attackSpeed.get();
            WASW.missileCooldown = (Integer)config.TOOLS_AND_ABILITIES.WASW.MissileCooldown.get();
            WASW.missileDamage = (Double)config.TOOLS_AND_ABILITIES.WASW.MissileDamage.get();
            WASW.howitzerCooldown = (Integer)config.TOOLS_AND_ABILITIES.WASW.HowitzerCooldown.get();
            VASW.howitzerCooldown = (Integer)config.TOOLS_AND_ABILITIES.VASW.HowitzerCooldown.get();
            VASW.runeDamage = (Double)config.TOOLS_AND_ABILITIES.VASW.VoidRuneDamage.get();
            VoidCore.cooldown = (Integer)config.TOOLS_AND_ABILITIES.VOID_CORE.VoidCoreCooldown.get();
            VoidCore.runeDamage = (Double)config.TOOLS_AND_ABILITIES.VOID_CORE.VoidRuneDamage.get();
            SandstormInABottle.cooldown = (Integer)config.TOOLS_AND_ABILITIES.SANDSTORM_IN_A_BOTTLE.SandStormCooldown.get();
            SoulRender.attackDamage = (Double)config.TOOLS_AND_ABILITIES.SOUL_RENDER.toolConfig.attackDamage.get();
            SoulRender.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.SOUL_RENDER.toolConfig.attackSpeed.get();
            SoulRender.cooldown = (Integer)config.TOOLS_AND_ABILITIES.SOUL_RENDER.SoulRenderCooldown.get();
            SoulRender.phantomHalberdDamage = (Double)config.TOOLS_AND_ABILITIES.SOUL_RENDER.PhantomHalberddamage.get();
            Immolator.attackDamage = (Double)config.TOOLS_AND_ABILITIES.IMMOLATOR.toolConfig.attackDamage.get();
            Immolator.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.IMMOLATOR.toolConfig.attackSpeed.get();
            Immolator.cooldown = (Integer)config.TOOLS_AND_ABILITIES.IMMOLATOR.ImmolatorCooldown.get();
            Ceraunus.attackDamage = (Double)config.TOOLS_AND_ABILITIES.CERAUNUS.toolConfig.attackDamage.get();
            Ceraunus.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.CERAUNUS.toolConfig.attackSpeed.get();
            Ceraunus.cooldown = (Integer)config.TOOLS_AND_ABILITIES.CERAUNUS.CeraunusCooldown.get();
            Ceraunus.waveDamage = (Double)config.TOOLS_AND_ABILITIES.CERAUNUS.CeraunusWaveDamage.get();
            TidalClaws.attackDamage = (Double)config.TOOLS_AND_ABILITIES.TIDAL_CLAW.toolConfig.attackDamage.get();
            TidalClaws.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.TIDAL_CLAW.toolConfig.attackSpeed.get();
            Astrape.attackDamage = (Double)config.TOOLS_AND_ABILITIES.ASTRAPE.toolConfig.attackDamage.get();
            Astrape.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.ASTRAPE.toolConfig.attackSpeed.get();
            Astrape.damage = (Double)config.TOOLS_AND_ABILITIES.ASTRAPE.AstrapeDamage.get();
            Astrape.areaDamage = (Double)config.TOOLS_AND_ABILITIES.ASTRAPE.AstrapeAreaDamage.get();
            Astrape.cooldown = (Integer)config.TOOLS_AND_ABILITIES.ASTRAPE.AstrapeCooldown.get();
            CursedBow.damage = (Double)config.TOOLS_AND_ABILITIES.CURSED_BOW.CursedBowDamage.get();
            WrathOfTheDesert.damage = (Double)config.TOOLS_AND_ABILITIES.WRATH_OF_THE_DESERT.WrathOfTheDesertDamage.get();
            LaserGatling.damage = (Double)config.TOOLS_AND_ABILITIES.LASER_GATLING.LaserDamage.get();
            AncientSpear.attackDamage = (Double)config.TOOLS_AND_ABILITIES.ANCIENTSPEAR.toolConfig.attackDamage.get();
            AncientSpear.attackSpeed = (Double)config.TOOLS_AND_ABILITIES.ANCIENTSPEAR.toolConfig.attackSpeed.get();
            AncientSpear.sandstormdamage = (Double)config.TOOLS_AND_ABILITIES.ANCIENTSPEAR.SandstormDamage.get();
            Blocks.CursedTombstoneCooldown = (Integer)config.BLOCKS.CURSEDTOMBSTONE.CursedTombstoneCooldown.get();
        }
        catch (Exception e) {
            Cataclysm.LOGGER.warn("An exception was caused trying to load the Common config for CM");
            e.printStackTrace();
        }
    }

    public static class EnderGuardian {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 22.0;
        public static double dpsCap = 13.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 12.0;
        public static double natureHeal = 25.0;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;
        public static double GravityPunchHpdamage = 0.05;
        public static double TeleportAttackHpdamage = 0.05;
        public static double KnockbackHpdamage = 0.06;
        public static double UppercutHpdamage = 0.1;
        public static double RocketPunchHpdamage = 0.1;
        public static double AreaAttackHpdamage = 0.08;
        public static int BlockBreakingX = 15;
        public static int BlockBreakingY = 2;
        public static int BlockBreakingZ = 15;
        public static double VoidRuneDamage = 9.0;
        public static boolean SeparatePhaseMusic = true;
    }

    public static class EnderGolem {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 999999.0;
        public static double dpsCap = 999999.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 8.0;
        public static double natureHeal = 25.0;
        public static boolean ignoreMobGriefing = false;
        public static double VoidRuneDamage = 7.0;
    }

    public static class NetheriteMonstrosity {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 25.0;
        public static double dpsCap = 20.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 18.0;
        public static double natureHeal = 25.0;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;
        public static int Lavabombmagazine = 3;
        public static int Lavabombamount = 3;
        public static int LavabombDuration = 350;
        public static int LavabombRandomDuration = 150;
        public static boolean BodyCollided = true;
        public static double SmashHpdamage = 0.08;
        public static double FlameJetDamage = 7.0;
        public static double FlareBombDamage = 10.0;
    }

    public static class NetheriteMinistrosity {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
    }

    public static class Ignis {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 20.0;
        public static double dpsCap = 14.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 15.0;
        public static double natureHeal = 25.0;
        public static boolean ignoreMobGriefing = true;
        public static double HealingMultiplier = 1.0;
        public static boolean SeparatePhaseMusic = true;
    }

    public static class IgnitedRevenant {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double AshenbreathDamage = 4.0;
        public static double BlazingBoneDamage = 5.0;
    }

    public static class Harbinger {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 22.0;
        public static double dpsCap = 14.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 35.0;
        public static double natureHeal = 25.0;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;
        public static double AutoHeal = 2.0;
        public static double LifeSteal = 5.0;
        public static double WitherMissiledamage = 8.0;
        public static double Laserdamage = 5.0;
        public static double DeathLaserdamage = 5.0;
        public static double DeathLaserHpdamage = 0.05;
        public static double ChargeHpDamage = 0.06;
    }

    public static class Prowler {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double rangeCap = 15.0;
        public static double HomingMissiledamage = 5.0;
        public static double DeathLaserdamage = 5.0;
        public static double DeathLaserHpdamage = 0.05;
    }

    public static class Leviathan {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 20.0;
        public static double dpsCap = 15.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 38.0;
        public static double natureHeal = 25.0;
        public static boolean ignoreMobGriefing = true;
        public static double BiteHpDamage = 0.1;
        public static double RushHpDamage = 0.05;
        public static double TailSwingHpDamage = 0.06;
        public static double TentacleHpDamage = 0.06;
        public static double DimensionalRiftDamage = 10.0;
        public static double AbyssBlastDamage = 10.0;
        public static double AbyssBlastHpDamage = 0.1;
        public static double AbyssOrbdamage = 4.0;
        public static boolean ImmuneOutofWater = true;
        public static boolean SeparatePhaseMusic = true;
    }

    public static class BabyLeviathan {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
    }

    public static class AmethystCrab {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double EarthQuakeDamage = 5.0;
        public static double AmethystClusterDamage = 12.0;
    }

    public static class AncientRemnant {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 21.0;
        public static double dpsCap = 14.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 14.0;
        public static double natureHeal = 25.0;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;
        public static double ChargeHpDamage = 0.1;
        public static double HpDamage = 0.05;
        public static double StompHpDamage = 0.03;
        public static double EarthQuakeDamage = 11.0;
        public static double AncientDesertSteledamage = 11.0;
    }

    public static class ModernRemnant {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
    }

    public static class Koboleton {
        public static double CauseKoboletontoDropItemInHandPercent = 5.0;
    }

    public static class Kobolediator {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static boolean ignoreMobGriefing = false;
    }

    public static class Wadjet {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double Sandstorm_damage = 6.0;
        public static double AncientDesertSteledamage = 11.0;
    }

    public static class Scylla {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 21.0;
        public static double dpsCap = 13.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 12.0;
        public static double natureHeal = 25.0;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;
        public static double SpearDamage = 14.0;
        public static double LightningStormDamage = 10.0;
        public static double LightningAreaDamage = 4.0;
        public static double SnakeDamage = 16.0;
        public static double AnchorDamage = 16.0;
        public static boolean WeatherChange = true;
        public static double HpDamage = 0.05;
        public static double SpinHpDamage = 0.07;
        public static double StormHpDamage = 0.04;
    }

    public static class Clawdian {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 21.0;
        public static double dpsCap = 12.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 12.0;
        public static double natureHeal = 25.0;
        public static boolean ignoreMobGriefing = false;
    }

    public static class Maledictus {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double damageCap = 20.0;
        public static double dpsCap = 13.0;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 14.0;
        public static double natureHeal = 25.0;
        public static boolean ignoreMobGriefing = true;
        public static double PhantomHalberdDamage = 11.0;
        public static double HpDamage = 0.05;
        public static double ShockWaveHpDamage = 0.03;
        public static double AOEHpDamage = 0.15;
        public static double FlyingSmashHpDamage = 0.1;
        public static double SmashHpDamage = 0.08;
        public static double PhantomArrowDamage = 5.0;
    }

    public static class Aptrgangr {
        public static double healthMultiplier = 1.0;
        public static double attackMultiplier = 1.0;
        public static double natureHeal = 25.0;
        public static double AxeBladeDamage = 8.0;
    }

    public static class ETC {
        public static int ReturnHome = 20;
    }

    public static class Spawning {
        public static int DeeplingSpawnWeight = 2;
        public static int DeeplingSpawnRolls = 30;
        public static int DeeplingBruteSpawnWeight = 1;
        public static int DeeplingBruteSpawnRolls = 50;
        public static int DeeplingAnglerSpawnWeight = 2;
        public static int DeeplingAnglerSpawnRolls = 30;
        public static int DeeplingPriestSpawnWeight = 1;
        public static int DeeplingPriestSpawnRolls = 70;
        public static int DeeplingWarlockSpawnWeight = 1;
        public static int DeeplingWarlockSpawnRolls = 70;
        public static int CoralgolemSpawnWeight = 1;
        public static int CoralgolemSpawnRolls = 70;
        public static int AmethystCrabSpawnWeight = 1;
        public static int AmethystCrabSpawnRolls = 20;
        public static int KoboletonSpawnWeight = 15;
        public static int KoboletonSpawnRolls = 1;
        public static int IgnitedBerserkerSpawnWeight = 7;
        public static int IgnitedBerserkerSpawnRolls = 2;
    }

    public static class IgnitiumArmor {
        public static double armorMultiplier = 1.0;
        public static double toughness = 4.0;
        public static double knockbackResistance = 0.15;
    }

    public static class CursiumArmor {
        public static double armorMultiplier = 1.0;
        public static double toughness = 4.0;
        public static double knockbackResistance = 0.05;
    }

    public static class BoneReptileArmor {
        public static double armorMultiplier = 1.0;
        public static double toughness = 2.5;
        public static double knockbackResistance = 0.15;
    }

    public static class BloomStoneArmor {
        public static double armorMultiplier = 1.0;
        public static double toughness = 2.0;
        public static double knockbackResistance = 0.1;
    }

    public static class Incinerator {
        public static double attackDamage = 14.0;
        public static double attackSpeed = 1.4;
        public static int cooldown = 400;
    }

    public static class BulwarkOfTheFlame {
        public static int cooldown = 80;
    }

    public static class GauntletOfGuard {
        public static double attackDamage = 11.0;
        public static double attackSpeed = 1.6;
    }

    public static class GauntletOfBulwark {
        public static double attackDamage = 11.0;
        public static double attackSpeed = 1.6;
        public static int cooldown = 80;
    }

    public static class GauntletOfMaelstrom {
        public static double attackDamage = 11.0;
        public static double attackSpeed = 1.6;
        public static int cooldown = 180;
    }

    public static class InfernalForge {
        public static double attackDamage = 13.0;
        public static double attackSpeed = 1.0;
        public static int cooldown = 80;
    }

    public static class VoidForge {
        public static double attackDamage = 13.0;
        public static double attackSpeed = 1.0;
        public static int cooldown = 100;
        public static double runeDamage = 7.0;
    }

    public static class Brontes {
        public static double attackDamage = 13.0;
        public static double attackSpeed = 1.0;
        public static double stormareadamage = 1.0;
        public static double stormdamage = 10.0;
    }

    public static class MeatShredder {
        public static double attackDamage = 8.5;
        public static double attackSpeed = 1.4;
    }

    public static class Annihilator {
        public static double attackDamage = 8.5;
        public static double attackSpeed = 1.6;
    }

    public static class WASW {
        public static int missileCooldown = 40;
        public static double missileDamage = 16.0;
        public static int howitzerCooldown = 100;
    }

    public static class VASW {
        public static int howitzerCooldown = 160;
        public static double runeDamage = 7.0;
    }

    public static class VoidCore {
        public static int cooldown = 160;
        public static double runeDamage = 7.0;
    }

    public static class SandstormInABottle {
        public static int cooldown = 300;
    }

    public static class SoulRender {
        public static double attackDamage = 15.0;
        public static double attackSpeed = 1.05;
        public static int cooldown = 100;
        public static double phantomHalberdDamage = 12.0;
    }

    public static class Immolator {
        public static double attackDamage = 8.5;
        public static double attackSpeed = 1.6;
        public static int cooldown = 250;
    }

    public static class Ceraunus {
        public static double attackDamage = 16.0;
        public static double attackSpeed = 0.7;
        public static int cooldown = 150;
        public static double waveDamage = 6.0;
    }

    public static class TidalClaws {
        public static double attackDamage = 8.0;
        public static double attackSpeed = 1.6;
    }

    public static class Astrape {
        public static double attackDamage = 10.5;
        public static double attackSpeed = 1.4;
        public static double damage = 11.0;
        public static double areaDamage = 2.0;
        public static int cooldown = 60;
    }

    public static class CursedBow {
        public static double damage = 8.0;
    }

    public static class WrathOfTheDesert {
        public static double damage = 7.5;
    }

    public static class LaserGatling {
        public static double damage = 7.0;
    }

    public static class AncientSpear {
        public static double attackDamage = 9.5;
        public static double attackSpeed = 1.4;
        public static double sandstormdamage = 6.0;
    }

    public static class Blocks {
        public static int CursedTombstoneCooldown = 1;
    }
}

