/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.CrashReport
 *  net.minecraft.CrashReportCategory
 *  net.minecraft.ReportedException
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.Cataclysm;
import com.skd.sundering.client.model.entity.Maledictus_Model;
import com.skd.sundering.client.render.entity.Maledictus_Renderer;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

public class MaledictusRiderLayer
extends RenderLayer<Maledictus_Entity, Maledictus_Model> {
    public MaledictusRiderLayer(Maledictus_Renderer render) {
        super((RenderLayerParent)render);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float bodyYaw = entity.yBodyRotO + (entity.yBodyRot - entity.yBodyRotO) * partialTicks;
        if (entity.isVehicle()) {
            Vec3 offset = new Vec3(0.0, 0.0, 0.0);
            Vec3 ridePos = this.getRiderPosition(offset);
            for (Entity passenger : entity.getPassengers()) {
                if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) continue;
                Cataclysm.PROXY.releaseRenderingEntity(passenger.getUUID());
                poseStack.pushPose();
                poseStack.translate(ridePos.x, ridePos.y - (double)0.65f + (double)passenger.getBbHeight(), ridePos.z);
                poseStack.mulPose(Axis.XN.rotationDegrees(180.0f));
                poseStack.mulPose(Axis.YN.rotationDegrees(360.0f - bodyYaw));
                MaledictusRiderLayer.renderPassenger(passenger, 0.0, 0.0, 0.0, 0.0f, partialTicks, poseStack, bufferIn, packedLightIn);
                poseStack.popPose();
                Cataclysm.PROXY.blockRenderingEntity(passenger.getUUID());
            }
        }
    }

    public Vec3 getRiderPosition(Vec3 offsetIn) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        ((Maledictus_Model)this.getParentModel()).translateToHand(translationStack, true);
        Vector4f armOffsetVec = new Vector4f((float)offsetIn.x, (float)offsetIn.y, (float)offsetIn.z, 1.0f);
        armOffsetVec.mul((Matrix4fc)translationStack.last().pose());
        Vec3 vec3 = new Vec3((double)armOffsetVec.x(), (double)armOffsetVec.y(), (double)armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }

    public static <E extends Entity> void renderPassenger(E entityIn, double x, double y, double z, float yaw, float partialTicks, PoseStack matrixStack, MultiBufferSource bufferIn, int packedLight) {
        block4: {
            EntityRenderer render = null;
            EntityRenderDispatcher manager = Minecraft.getInstance().getEntityRenderDispatcher();
            try {
                render = manager.getRenderer(entityIn);
                if (render == null) break block4;
                try {
                    render.render(entityIn, yaw, partialTicks, matrixStack, bufferIn, packedLight);
                }
                catch (Throwable throwable1) {
                    throw new ReportedException(CrashReport.forThrowable((Throwable)throwable1, (String)"Rendering entity in world"));
                }
            }
            catch (Throwable throwable3) {
                CrashReport crashreport = CrashReport.forThrowable((Throwable)throwable3, (String)"Rendering entity in world");
                CrashReportCategory crashreportcategory = crashreport.addCategory("Entity being rendered");
                entityIn.fillCrashReportCategory(crashreportcategory);
                CrashReportCategory crashreportcategory1 = crashreport.addCategory("Renderer details");
                crashreportcategory1.setDetail("Assigned renderer", (Object)render);
                crashreportcategory1.setDetail("Rotation", (Object)Float.valueOf(yaw));
                crashreportcategory1.setDetail("Delta", (Object)Float.valueOf(partialTicks));
                throw new ReportedException(crashreport);
            }
        }
    }
}

