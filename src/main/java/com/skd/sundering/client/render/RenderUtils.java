/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Vector4f
 */
package com.skd.sundering.client.render;

import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector4f;

public class RenderUtils {
    public static void matrixStackFromCitadelModel(PoseStack matrixStack, AdvancedModelBox AdvancedModelBox2) {
        AdvancedModelBox parent = AdvancedModelBox2.getParent();
        if (parent != null) {
            RenderUtils.matrixStackFromCitadelModel(matrixStack, parent);
        }
        AdvancedModelBox2.translateAndRotate(matrixStack);
    }

    public static Vec3 matrixStackFromCitadelModel(Entity entity, float entityYaw, AdvancedModelBox modelRenderer) {
        PoseStack matrixStack = new PoseStack();
        matrixStack.translate(entity.getX(), entity.getY(), entity.getZ());
        matrixStack.mulPose(new Quaternionf().rotationY((-entityYaw + 180.0f) * ((float)Math.PI / 180)));
        matrixStack.scale(-1.0f, -1.0f, 1.0f);
        matrixStack.translate(0.0f, -1.5f, 0.0f);
        RenderUtils.matrixStackFromCitadelModel(matrixStack, modelRenderer);
        PoseStack.Pose matrixEntry = matrixStack.last();
        Matrix4f matrix4f = matrixEntry.pose();
        Vector4f vec = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
        vec.mul((Matrix4fc)matrix4f);
        return new Vec3((double)vec.x(), (double)vec.y(), (double)vec.z());
    }
}

