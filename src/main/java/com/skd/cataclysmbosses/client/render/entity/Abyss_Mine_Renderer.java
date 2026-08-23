/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Quaternionf
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.entity.Abyss_Mine_Model;
import com.skd.cataclysmbosses.client.render.CMRenderTypes;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Mine_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

@OnlyIn(value=Dist.CLIENT)
public class Abyss_Mine_Renderer
extends EntityRenderer<Abyss_Mine_Entity> {
    private static final Identifier ABYSS_MINE_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/leviathan/abyss_mine.png");
    private static final float SIN_45 = (float)Math.sin(0.7853981633974483);
    public Abyss_Mine_Model model = new Abyss_Mine_Model();

    public Abyss_Mine_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    protected int getBlockLightLevel(Abyss_Mine_Entity entity, BlockPos pos) {
        return 15;
    }

    public void render(Abyss_Mine_Entity p_114162_, float p_114163_, float p_114164_, PoseStack p_114165_, MultiBufferSource p_114166_, int p_114167_) {
        p_114165_.pushPose();
        float f1 = ((float)p_114162_.time + p_114164_) * 3.0f;
        float activateProgress = p_114162_.prevactivateProgress + (p_114162_.activateProgress - p_114162_.prevactivateProgress) * p_114164_;
        float d = activateProgress * 0.0875f;
        float e = activateProgress * 0.2f;
        VertexConsumer vertexconsumer = p_114166_.getBuffer(CMRenderTypes.getfullBright(ABYSS_MINE_TEXTURE));
        p_114165_.pushPose();
        p_114165_.scale(e, e, e);
        p_114165_.translate(0.0, -0.5, 0.0);
        int i = OverlayTexture.NO_OVERLAY;
        p_114165_.mulPose(Axis.YP.rotationDegrees(f1));
        p_114165_.translate(0.0, 0.75, 0.0);
        p_114165_.mulPose(new Quaternionf().setAngleAxis(1.0471976f, SIN_45, 0.0f, SIN_45));
        this.model.glass.render(p_114165_, vertexconsumer, p_114167_, i);
        float f2 = 0.875f;
        p_114165_.scale(d, d, d);
        p_114165_.mulPose(new Quaternionf().setAngleAxis(1.0471976f, SIN_45, 0.0f, SIN_45));
        p_114165_.mulPose(Axis.YP.rotationDegrees(f1));
        this.model.glass2.render(p_114165_, vertexconsumer, p_114167_, i);
        p_114165_.scale(d, d, d);
        p_114165_.mulPose(new Quaternionf().setAngleAxis(1.0471976f, SIN_45, 0.0f, SIN_45));
        p_114165_.mulPose(Axis.YP.rotationDegrees(f1));
        this.model.root.render(p_114165_, vertexconsumer, p_114167_, i);
        p_114165_.popPose();
        p_114165_.popPose();
        super.render((Entity)p_114162_, p_114163_, p_114164_, p_114165_, p_114166_, p_114167_);
    }

    public Identifier getTextureLocation(Abyss_Mine_Entity entity) {
        return ABYSS_MINE_TEXTURE;
    }
}

