/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.client.model.entity.Scylla_Model;
import com.skd.cataclysmbosses.client.render.entity.Scylla_Renderer;
import com.skd.cataclysmbosses.client.render.etc.LightningBoltData;
import com.skd.cataclysmbosses.client.render.etc.LightningRender;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

@OnlyIn(value=Dist.CLIENT)
public class Scylla_Eye_Spark_Layer
extends RenderLayer<Scylla_Entity, Scylla_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;
    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<UUID, LightningRender>();
    private final RandomSource rnd = RandomSource.create();

    public Scylla_Eye_Spark_Layer(Scylla_Renderer renderIn, EntityRendererProvider.Context context) {
        super((RenderLayerParent)renderIn);
        this.entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scylla_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.renderLightning(matrixStackIn, bufferIn, entity, partialTicks, true);
        this.renderLightning(matrixStackIn, bufferIn, entity, partialTicks, false);
    }

    private void renderLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Scylla_Entity entity, float partialtick, boolean right) {
        matrixStackIn.pushPose();
        Vec3 offset = new Vec3(0.0, 0.0, 0.0);
        Vec3 ridePos = this.getEyePosition(offset, right);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        if (entity.getEye()) {
            this.drawLightning(matrixStackIn, bufferIn, entity, 143, 241, 215, 4, 0.05f, partialtick);
        }
        matrixStackIn.popPose();
    }

    private void drawLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Scylla_Entity entity, int r, int g, int b, int seg, float size, float partialTicks) {
        matrixStackIn.pushPose();
        double x = this.rnd.nextFloat() - 0.5f;
        double y = this.rnd.nextFloat() - 0.5f;
        double z = this.rnd.nextFloat() - 0.5f;
        LightningBoltData.BoltRenderInfo blueBoltData = new LightningBoltData.BoltRenderInfo(0.5f, 0.1f, 0.5f, 0.85f, new Vector4f((float)r / 255.0f, (float)g / 255.0f, (float)b / 255.0f, 0.8f), 0.1f);
        LightningBoltData bolt1 = new LightningBoltData(blueBoltData, Vec3.ZERO, new Vec3(x, y, z), seg).size(size).lifespan(3).spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        LightningRender lightningRender = this.getLightingRender(entity.getUUID());
        lightningRender.update(entity, bolt1, partialTicks);
        lightningRender.render(partialTicks, matrixStackIn, bufferIn);
        matrixStackIn.popPose();
        if (!entity.isAlive() && this.lightningRenderMap.containsKey(entity.getUUID())) {
            this.lightningRenderMap.remove(entity.getUUID());
        }
    }

    private LightningRender getLightingRender(UUID uuid) {
        if (this.lightningRenderMap.get(uuid) == null) {
            this.lightningRenderMap.put(uuid, new LightningRender());
        }
        return this.lightningRenderMap.get(uuid);
    }

    public Vec3 getEyePosition(Vec3 offsetIn, boolean right) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        ((Scylla_Model)this.getParentModel()).translateToEye(translationStack, right);
        Vector4f armOffsetVec = new Vector4f((float)offsetIn.x, (float)offsetIn.y, (float)offsetIn.z, 1.0f);
        armOffsetVec.mul((Matrix4fc)translationStack.last().pose());
        Vec3 vec3 = new Vec3((double)armOffsetVec.x(), (double)armOffsetVec.y(), (double)armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }
}

