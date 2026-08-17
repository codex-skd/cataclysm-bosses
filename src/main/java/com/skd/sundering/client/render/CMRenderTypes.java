/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.GlStateManager$DestFactor
 *  com.mojang.blaze3d.platform.GlStateManager$SourceFactor
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  net.minecraft.Util
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.RenderStateShard
 *  net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard
 *  net.minecraft.client.renderer.RenderStateShard$TextureStateShard
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.rendertype.RenderType$CompositeState
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.function.Function;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class CMRenderTypes
extends RenderType {
    public static final Function<Identifier, RenderType> BRIGHT = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER).setTransparencyState(NO_TRANSPARENCY).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(false);
        return CMRenderTypes.create((String)"bright", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)false, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> FLICKERING = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(false);
        return CMRenderTypes.create((String)"flickering", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)false, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> FULL_BRIGHT = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(false);
        return CMRenderTypes.create((String)"full_bright", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)false, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> GLOWING_EFFECT = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setShaderState(RENDERTYPE_BEACON_BEAM_SHADER).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setOverlayState(OVERLAY).setWriteMaskState(COLOR_WRITE).createCompositeState(false);
        return CMRenderTypes.create((String)"glow_effect", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)true, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> NEW_TRAIL_EFFECT = Util.memoize(p_286155_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ITEM_ENTITY_TRANSLUCENT_CULL_SHADER).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286155_, false, false)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setOutputState(ITEM_ENTITY_TARGET).setLightmapState(LIGHTMAP).setCullState(NO_CULL).setOverlayState(OVERLAY).setWriteMaskState(RenderStateShard.COLOR_DEPTH_WRITE).createCompositeState(true);
        return CMRenderTypes.create((String)"new_trail_effect", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)true, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> LIGHT_TRAIL_EFFECT = Util.memoize(p_286155_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_EYES_SHADER).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286155_, false, false)).setTransparencyState(ADDITIVE_TRANSPARENCY).setOutputState(ITEM_ENTITY_TARGET).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setWriteMaskState(COLOR_WRITE).setOverlayState(OVERLAY).createCompositeState(true);
        return CMRenderTypes.create((String)"light_trail_effect", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)true, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> CMEYE = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_EYES_SHADER).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setTransparencyState(ADDITIVE_TRANSPARENCY).setCullState(NO_CULL).setWriteMaskState(COLOR_WRITE).setOverlayState(OVERLAY).createCompositeState(false);
        return CMRenderTypes.create((String)"cm_eyes", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)false, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final RenderType CM_LIGHTNING = CMRenderTypes.create((String)"cm_lightning", (VertexFormat)DefaultVertexFormat.POSITION_COLOR, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)false, (boolean)true, (RenderType.CompositeState)RenderType.CompositeState.builder().setShaderState(RENDERTYPE_LIGHTNING_SHADER).setWriteMaskState(COLOR_WRITE).setTransparencyState(LIGHTNING_TRANSPARENCY).setCullState(NO_CULL).setOutputState(WEATHER_TARGET).createCompositeState(false));
    public static final Function<Identifier, RenderType> JELLY = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setWriteMaskState(COLOR_DEPTH_WRITE).setOverlayState(OVERLAY).createCompositeState(true);
        return CMRenderTypes.create((String)"jelly", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)true, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> GHOST = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER).setCullState(NO_CULL).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).setWriteMaskState(COLOR_DEPTH_WRITE).setDepthTestState(LEQUAL_DEPTH_TEST).setLayeringState(NO_LAYERING).createCompositeState(false);
        return CMRenderTypes.create((String)"ghost", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)true, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> DRAGON_DEATH = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(p_286169_, false, false)).setCullState(NO_CULL).createCompositeState(true);
        return CMRenderTypes.create((String)"dragon_death", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)1536, (boolean)false, (boolean)false, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static final Function<Identifier, RenderType> SHOCK_WAVE = Util.memoize(p_286169_ -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER).setCullState(NO_CULL).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/shock_wave.png"), true, true)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).setWriteMaskState(COLOR_WRITE).setDepthTestState(LEQUAL_DEPTH_TEST).setLayeringState(VIEW_OFFSET_Z_LAYERING).createCompositeState(false);
        return CMRenderTypes.create((String)"shock_wave", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)true, (boolean)true, (RenderType.CompositeState)rendertype$compositestate);
    });
    public static ParticleRenderType PARTICLE_SHEET_TRANSLUCENT_NO_DEPTH = new ParticleRenderType(){

        public BufferBuilder begin(Tesselator p_350576_, TextureManager p_107449_) {
            Minecraft.getInstance().gameRenderer.lightTexture().turnOnLightLayer();
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask((boolean)false);
            RenderSystem.disableCull();
            RenderSystem.setShaderTexture((int)0, (Identifier)TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            return p_350576_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
        }

        public String toString() {
            return "cataclysm:PARTICLE_SHEET_TRANSLUCENT_NO_DEPTH";
        }
    };

    public CMRenderTypes(String p_173178_, VertexFormat p_173179_, VertexFormat.Mode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
        super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
    }

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
        RenderType.CompositeState renderState = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER).setCullState(NO_CULL).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/shock_wave.png"), true, true)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).setWriteMaskState(COLOR_WRITE).setDepthTestState(LEQUAL_DEPTH_TEST).setLayeringState(VIEW_OFFSET_Z_LAYERING).createCompositeState(false);
        return CMRenderTypes.create((String)"shock_wave", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)true, (boolean)true, (RenderType.CompositeState)renderState);
    }

    public static RenderType getPulse() {
        RenderType.CompositeState renderState = RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER).setCullState(NO_CULL).setTextureState((RenderStateShard.EmptyTextureStateShard)new RenderStateShard.TextureStateShard(Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/particle/em_pulse.png"), true, true)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).setWriteMaskState(COLOR_WRITE).setDepthTestState(LEQUAL_DEPTH_TEST).setLayeringState(VIEW_OFFSET_Z_LAYERING).createCompositeState(false);
        return CMRenderTypes.create((String)"em_pulse", (VertexFormat)DefaultVertexFormat.NEW_ENTITY, (VertexFormat.Mode)VertexFormat.Mode.QUADS, (int)256, (boolean)true, (boolean)true, (RenderType.CompositeState)renderState);
    }
}

