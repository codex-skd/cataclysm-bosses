/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.TextureAtlas
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.render.etc.LightningBoltData;
import com.skd.cataclysmbosses.client.render.etc.LightningRender;
import com.skd.cataclysmbosses.entity.effect.Bolt_strike_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

@OnlyIn(value=Dist.CLIENT)
public class Boltstrike_Renderer
extends EntityRenderer<Bolt_strike_Entity> {
    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<UUID, LightningRender>();
    private static final int MAX_HEIGHT = 15;
    private static final double START_MIN_RADIUS = 0.7;
    private static final double START_MAX_RADIUS = 1.2;
    private static final double END_MIN_RADIUS = 0.1;
    private static final double END_MAX_RADIUS = 0.5;

    public Boltstrike_Renderer(EntityRendererProvider.Context p_174286_) {
        super(p_174286_);
    }

    public void render(Bolt_strike_Entity entity, float p_115267_, float partialTicks, PoseStack poseStack, MultiBufferSource p_115270_, int p_115271_) {
        double x = Mth.lerp((double)partialTicks, (double)entity.xOld, (double)entity.getX());
        double y = Mth.lerp((double)partialTicks, (double)entity.yOld, (double)entity.getY());
        double z = Mth.lerp((double)partialTicks, (double)entity.zOld, (double)entity.getZ());
        int r = entity.getR();
        int g = entity.getG();
        int b = entity.getB();
        float f = entity.getAnimationProgress(partialTicks);
        float f1 = 0.0f;
        if (f != 0.0f) {
            f1 = f;
            poseStack.pushPose();
            poseStack.translate(-x, -y, -z);
            LightningBoltData.BoltRenderInfo boltData = new LightningBoltData.BoltRenderInfo(0.2f, 0.7f, 0.25f, 0.15f, new Vector4f((float)r / 255.0f, (float)g / 255.0f, (float)b / 255.0f, 0.7f), 0.92f);
            LightningBoltData bolt1 = new LightningBoltData(boltData, entity.getAnglePosition(partialTicks, 15.0, 1.2, 0.7), entity.getAnglePosition(partialTicks, 0.0, 0.5, 0.1), 4).size(f1).lifespan(1).spawn(LightningBoltData.SpawnFunction.NO_DELAY).fade(LightningBoltData.FadeFunction.NONE);
            LightningRender lightningRender = this.getLightingRender(entity.getUUID());
            if (!Minecraft.getInstance().isPaused()) {
                lightningRender.update((Object)entity, bolt1, partialTicks);
            }
            lightningRender.render(partialTicks, poseStack, p_115270_);
            poseStack.popPose();
        }
        if (entity.isRemoved() && this.lightningRenderMap.containsKey(entity.getUUID())) {
            this.lightningRenderMap.remove(entity.getUUID());
        }
    }

    private LightningRender getLightingRender(UUID uuid) {
        if (this.lightningRenderMap.get(uuid) == null) {
            this.lightningRenderMap.put(uuid, new LightningRender());
        }
        return this.lightningRenderMap.get(uuid);
    }

    public Identifier getTextureLocation(Bolt_strike_Entity p_115264_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

