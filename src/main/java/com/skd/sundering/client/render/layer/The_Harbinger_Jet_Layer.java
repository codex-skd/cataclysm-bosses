/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Vector4f
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.The_Harbinger_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.entity.The_Harbinger_Renderer;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector4f;

@OnlyIn(value=Dist.CLIENT)
public class The_Harbinger_Jet_Layer
extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[4];

    public The_Harbinger_Jet_Layer(The_Harbinger_Renderer renderIn, EntityRendererProvider.Context context) {
        super((RenderLayerParent)renderIn);
        this.entityRenderDispatcher = context.getEntityRenderDispatcher();
        for (int i = 0; i < 4; ++i) {
            The_Harbinger_Jet_Layer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/harbinger/harbinger_jet_" + i + ".png"));
        }
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getIsAct() && entity.getAnimation() != The_Harbinger_Entity.MISSILE_FIRE_ANIAMATION && entity.getAnimation() != The_Harbinger_Entity.MISSILE_FIRE_FAST_ANIAMATION) {
            this.rendercicle(matrixStackIn, bufferIn, packedLightIn, entity, partialTicks, true);
            this.rendercicle(matrixStackIn, bufferIn, packedLightIn, entity, partialTicks, false);
        }
    }

    private void rendercicle(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float partialTicks, boolean right) {
        matrixStackIn.pushPose();
        float bodyYaw = Mth.rotLerp((float)partialTicks, (float)entity.yBodyRotO, (float)entity.yBodyRot);
        Vec3 offset = this.getRiderPosition(Vec3.ZERO, right);
        matrixStackIn.translate(offset.x, offset.y, offset.z);
        matrixStackIn.mulPose(new Quaternionf().rotateY((float)Math.toRadians(-bodyYaw)));
        float camYaw = this.entityRenderDispatcher.camera.getYRot();
        matrixStackIn.mulPose(new Quaternionf().rotateY((float)Math.toRadians(camYaw)));
        matrixStackIn.scale(1.25f, 1.25f, 1.25f);
        PoseStack.Pose posestack$pose = matrixStackIn.last();
        VertexConsumer portalStatic = bufferIn.getBuffer(CMRenderTypes.entityCutoutNoCull((Identifier)this.getGrowingTexture(entity, (int)(((float)entity.tickCount + partialTicks) * 1.5f % 4.0f))));
        this.drawCircle(portalStatic, posestack$pose, packedLightIn, 1.0f, 1.0f, 1.0f);
        matrixStackIn.popPose();
    }

    private void drawCircle(VertexConsumer vertex, PoseStack.Pose normals, int packedLightIn, float r, float g, float b) {
        The_Harbinger_Jet_Layer.cirlceVertex(vertex, normals, packedLightIn, 0.0f, 0, 0, 0, 1.0f, r, g, b);
        The_Harbinger_Jet_Layer.cirlceVertex(vertex, normals, packedLightIn, 1.0f, 0, 1, 0, 1.0f, r, g, b);
        The_Harbinger_Jet_Layer.cirlceVertex(vertex, normals, packedLightIn, 1.0f, 1, 1, 1, 1.0f, r, g, b);
        The_Harbinger_Jet_Layer.cirlceVertex(vertex, normals, packedLightIn, 0.0f, 1, 0, 1, 1.0f, r, g, b);
    }

    private static void cirlceVertex(VertexConsumer vertex, PoseStack.Pose normals, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_, float alpha, float r, float g, float b) {
        vertex.addVertex(normals, p_114094_ - 0.5f, (float)p_114095_ - 0.25f, 0.0f).setColor(r, g, b, alpha).setUv((float)p_114096_, (float)p_114097_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(240).setNormal(normals, 0.0f, -1.0f, 0.0f);
    }

    public Identifier getGrowingTexture(The_Harbinger_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)3)];
    }

    public Vec3 getRiderPosition(Vec3 offsetIn, boolean right) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        ((The_Harbinger_Model)this.getParentModel()).translateToHand(translationStack, right);
        Vector4f armOffsetVec = new Vector4f((float)offsetIn.x, (float)offsetIn.y, (float)offsetIn.z, 1.0f);
        armOffsetVec.mul((Matrix4fc)translationStack.last().pose());
        Vec3 vec3 = new Vec3((double)armOffsetVec.x(), (double)armOffsetVec.y(), (double)armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }
}

