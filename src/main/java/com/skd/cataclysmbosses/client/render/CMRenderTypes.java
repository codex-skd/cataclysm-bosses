package com.skd.cataclysmbosses.client.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import java.util.function.Function;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.OutputTarget;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CMRenderTypes {
    public static final Function<Identifier, RenderType> BRIGHT = Util.memoize(texture -> RenderType.create(
        "bright",
        RenderSetup.builder(RenderPipelines.ENTITY_TRANSLUCENT_CULL)
            .withTexture("Sampler0", texture)
            .useLightmap()
            .useOverlay()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> FLICKERING = Util.memoize(texture -> RenderType.create(
        "flickering",
        RenderSetup.builder(RenderPipelines.ENTITY_TRANSLUCENT_CULL)
            .withTexture("Sampler0", texture)
            .useLightmap()
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> FULL_BRIGHT = Util.memoize(texture -> RenderType.create(
        "full_bright",
        RenderSetup.builder(RenderPipelines.ENTITY_TRANSLUCENT_CULL)
            .withTexture("Sampler0", texture)
            .useLightmap()
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> GLOWING_EFFECT = Util.memoize(texture -> RenderType.create(
        "glow_effect",
        RenderSetup.builder(RenderPipelines.BEACON_BEAM_TRANSLUCENT)
            .withTexture("Sampler0", texture)
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> NEW_TRAIL_EFFECT = Util.memoize(texture -> RenderType.create(
        "new_trail_effect",
        RenderSetup.builder(RenderPipelines.ENTITY_TRANSLUCENT_CULL)
            .withTexture("Sampler0", texture)
            .setOutputTarget(OutputTarget.ITEM_ENTITY_TARGET)
            .useLightmap()
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> LIGHT_TRAIL_EFFECT = Util.memoize(texture -> RenderType.create(
        "light_trail_effect",
        RenderSetup.builder(RenderPipelines.ENERGY_SWIRL)
            .withTexture("Sampler0", texture)
            .setOutputTarget(OutputTarget.ITEM_ENTITY_TARGET)
            .useLightmap()
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> CMEYE = Util.memoize(texture -> RenderType.create(
        "cm_eyes",
        RenderSetup.builder(RenderPipelines.EYES)
            .withTexture("Sampler0", texture)
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final RenderType CM_LIGHTNING = RenderType.create(
        "cm_lightning",
        RenderSetup.builder(RenderPipelines.LIGHTNING)
            .setOutputTarget(OutputTarget.WEATHER_TARGET)
            .sortOnUpload()
            .createRenderSetup()
    );
    public static final Function<Identifier, RenderType> JELLY = Util.memoize(texture -> RenderType.create(
        "jelly",
        RenderSetup.builder(RenderPipelines.ENERGY_SWIRL)
            .withTexture("Sampler0", texture)
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> GHOST = Util.memoize(texture -> RenderType.create(
        "ghost",
        RenderSetup.builder(RenderPipelines.ENERGY_SWIRL)
            .withTexture("Sampler0", texture)
            .useLightmap()
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> DRAGON_DEATH = Util.memoize(texture -> RenderType.create(
        "dragon_death",
        RenderSetup.builder(RenderPipelines.ENERGY_SWIRL)
            .withTexture("Sampler0", texture)
            .createRenderSetup()
    ));
    public static final Function<Identifier, RenderType> SHOCK_WAVE = Util.memoize(texture -> RenderType.create(
        "shock_wave",
        RenderSetup.builder(RenderPipelines.ENERGY_SWIRL)
            .withTexture("Sampler0", texture)
            .useLightmap()
            .useOverlay()
            .sortOnUpload()
            .createRenderSetup()
    ));
    public static ParticleRenderType PARTICLE_SHEET_TRANSLUCENT_NO_DEPTH = ParticleRenderType.SINGLE_QUADS;

    public static RenderType getBright(Identifier location) {
        return BRIGHT.apply(location);
    }

    public static RenderType getFlickering(Identifier location) {
        return FLICKERING.apply(location);
    }

    public static RenderType getfullBright(Identifier location) {
        return FULL_BRIGHT.apply(location);
    }

    public static RenderType getGlowingEffect(Identifier location) {
        return GLOWING_EFFECT.apply(location);
    }

    public static RenderType getGhost(Identifier location) {
        return GHOST.apply(location);
    }

    public static RenderType CMEyes(Identifier location) {
        return CMEYE.apply(location);
    }

    public static RenderType eyes(Identifier location) {
        return RenderTypes.eyes(location);
    }

    public static RenderType entityCutoutNoCull(Identifier location) {
        return RenderTypes.entityCutout(location);
    }

    public static RenderType jelly(Identifier location) {
        return JELLY.apply(location);
    }

    public static RenderType getTrailEffect(Identifier location) {
        return NEW_TRAIL_EFFECT.apply(location);
    }

    public static RenderType getLightTrailEffect(Identifier location) {
        return LIGHT_TRAIL_EFFECT.apply(location);
    }

    public static RenderType DragonDeath(Identifier location) {
        return DRAGON_DEATH.apply(location);
    }

    public static RenderType CMLightning() {
        return CM_LIGHTNING;
    }

    public static RenderType getShockWave() {
        return SHOCK_WAVE.apply(Identifier.fromNamespaceAndPath("cataclysm", "textures/particle/shock_wave.png"));
    }

    public static RenderType getPulse() {
        return SHOCK_WAVE.apply(Identifier.fromNamespaceAndPath("cataclysm", "textures/particle/em_pulse.png"));
    }
}
