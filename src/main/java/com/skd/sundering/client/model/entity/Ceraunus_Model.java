/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 */
package com.skd.sundering.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

@OnlyIn(value=Dist.CLIENT)
public class Ceraunus_Model<T extends Entity>
extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart chain;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Ceraunus_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.chain = this.everything.getChild("chain");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create().texOffs(21, 0).addBox(-9.0f, -40.3f, 0.0f, 18.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 62).addBox(-3.0f, -35.3f, -1.0f, 6.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(25, 60).addBox(0.0f, -38.3f, -3.0f, 0.0f, 9.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-3.0f, -25.3f, -2.0f, 6.0f, 32.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition cube_r1 = everything.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 47).addBox(-4.0f, -4.0f, -2.0f, 8.0f, 8.0f, 4.0f, new CubeDeformation(0.01f)), PartPose.offsetAndRotation((float)0.0f, (float)4.7f, (float)0.0f, (float)0.0f, (float)0.0f, (float)2.3562f));
        PartDefinition cube_r2 = everything.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 49).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)-28.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition cube_r3 = everything.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 38).addBox(-6.0f, -3.0f, -1.0f, 12.0f, 6.0f, 2.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)15.6944f, (float)-23.5732f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7418f));
        PartDefinition cube_r4 = everything.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(21, 12).addBox(-1.0f, -3.0f, -2.0f, 12.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-28.3f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition cube_r5 = everything.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 23).addBox(-6.0f, -3.0f, -1.0f, 12.0f, 6.0f, 2.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)-15.6944f, (float)-23.5732f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7418f));
        PartDefinition cube_r6 = everything.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 38).addBox(-11.0f, -3.0f, -2.0f, 12.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)-28.3f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition cube_r7 = everything.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(58, 54).addBox(-5.0f, -2.0f, -1.0f, 10.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0963f, (float)-24.7693f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition cube_r8 = everything.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(58, 47).addBox(-5.0f, -2.0f, -1.0f, 10.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0963f, (float)-24.7693f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition cube_r9 = everything.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(51, 61).addBox(-2.0f, -5.0f, -1.0f, 4.0f, 10.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(64, 61).addBox(-1.0f, 5.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(58, 0).addBox(-5.0f, 3.0f, 0.0f, 10.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)19.5093f, (float)-17.0353f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition cube_r10 = everything.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(62, 32).addBox(-1.0f, 5.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(38, 60).addBox(-2.0f, -5.0f, -1.0f, 4.0f, 10.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-19.5093f, (float)-17.0353f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition cube_r11 = everything.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(54, 12).addBox(-5.0f, -5.0f, 0.0f, 10.0f, 10.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-18.4651f, (float)-9.1037f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition chain = everything.addOrReplaceChild("chain", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)16.3f, (float)0.0f));
        PartDefinition cube_r12 = chain.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(21, 23).addBox(-4.0f, -10.0f, -1.0f, 14.0f, 14.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-8.6f, (float)1.0f, (float)0.0f, (float)0.0f, (float)2.3562f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public Vec3 getChainPosition(Vec3 offset, PoseStack transform) {
        this.root.translateAndRotate(transform);
        this.everything.translateAndRotate(transform);
        this.chain.translateAndRotate(transform);
        Vector4f vec = new Vector4f((float)offset.x, (float)offset.y, (float)offset.z, 1.0f);
        vec.mul((Matrix4fc)transform.last().pose());
        return new Vec3((double)vec.x(), (double)vec.y(), (double)vec.z());
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.children.entrySet()) {
            String partName = (String)entry.getKey();
            ModelPart childPart = (ModelPart)entry.getValue();
            this.partCache.putIfAbsent(partName, childPart);
            this.optionalPartCache.putIfAbsent(partName, Optional.of(childPart));
            if (childPart.children.isEmpty()) continue;
            this.buildPartCache(childPart);
        }
    }

    @NotNull
    public Optional<ModelPart> getAnyDescendantWithName(String name) {
        if ("root".equals(name)) {
            return Optional.of(this.root);
        }
        return this.optionalPartCache.getOrDefault(name, Optional.empty());
    }

    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }
}

