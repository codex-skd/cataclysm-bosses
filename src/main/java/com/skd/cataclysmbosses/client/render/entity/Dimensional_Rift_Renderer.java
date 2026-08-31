/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4f
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Dimensional_Rift_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skd.cataclysmbosses.client.render.compat.CmEntityRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

@OnlyIn(value=Dist.CLIENT)
public class Dimensional_Rift_Renderer
extends CmEntityRenderer<Dimensional_Rift_Entity> {
    private static final Identifier TEXTURE_IDLE_1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle1.png");
    private static final Identifier TEXTURE_IDLE_2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle2.png");
    private static final Identifier TEXTURE_IDLE_3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle3.png");
    private static final Identifier TEXTURE_IDLE_4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle4.png");
    private static final Identifier TEXTURE_GROW_1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_0.png");
    private static final Identifier TEXTURE_GROW_2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_1.png");
    private static final Identifier TEXTURE_GROW_3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_2.png");
    private static final Identifier TEXTURE_GROW_4 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_3.png");

    public Dimensional_Rift_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    protected void render(Dimensional_Rift_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
        // TODO: port render body to 26.2 (old MobRenderer APIs removed)
    }

    private static void vertex(VertexConsumer p_114090_, Matrix4f p_114091_, PoseStack.Pose p_114092_, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.addVertex(p_114091_, p_114094_ - 0.5f, (float)p_114095_ - 0.25f, 0.0f).setColor(255, 255, 255, 255).setUv((float)p_114096_, (float)p_114097_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_114093_).setNormal(p_114092_, 0.0f, 1.0f, 0.0f);
    }

    public Identifier getTextureLocation(Dimensional_Rift_Entity entity) {
        return TEXTURE_IDLE_1;
    }

    public Identifier getIdleTexture(int age) {
        if (age < 3) {
            return TEXTURE_IDLE_1;
        }
        if (age < 6) {
            return TEXTURE_IDLE_2;
        }
        if (age < 10) {
            return TEXTURE_IDLE_3;
        }
        return TEXTURE_IDLE_4;
    }
}

