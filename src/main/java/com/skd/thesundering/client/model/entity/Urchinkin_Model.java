/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.client.animation.Urchinkin_Animation;
import com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters.Urchinkin_Entity;
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
import org.jetbrains.annotations.NotNull;

public class Urchinkin_Model
extends HierarchicalModel<Urchinkin_Entity> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart mid_root;
    private final ModelPart legs;
    private final ModelPart body;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Urchinkin_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.mid_root = this.everything.getChild("mid_root");
        this.legs = this.mid_root.getChild("legs");
        this.body = this.legs.getChild("body");
        this.right_arm = this.body.getChild("right_arm");
        this.left_arm = this.body.getChild("left_arm");
        this.right_leg = this.legs.getChild("right_leg");
        this.left_leg = this.legs.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-7.0f, (float)0.0f));
        PartDefinition legs = mid_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)3.0f, (float)0.0f));
        PartDefinition body = legs.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5f, -7.0f, -3.5f, 7.0f, 7.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(18, 20).addBox(-8.5f, -12.0f, 0.0f, 17.0f, 14.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 20).mirror().addBox(-8.5f, -7.0f, 0.0f, 17.0f, 14.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-5.0f, (float)0.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 20).addBox(-8.5f, -7.0f, 0.0f, 17.0f, 14.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-5.0f, (float)0.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 15).addBox(-4.2668f, -1.1426f, -1.0f, 5.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.4f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7418f));
        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(15, 15).addBox(-0.7332f, -1.1426f, -1.0f, 5.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.4f, (float)-3.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7418f));
        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 20).addBox(-0.975f, 0.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.0873f));
        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(9, 20).addBox(-1.025f, 0.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0873f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
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

    public void setupAnim(Urchinkin_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(Urchinkin_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 4.0f);
        this.animate(entity.getAnimationState("idle"), Urchinkin_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("roll"), Urchinkin_Animation.ROLL, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("attack"), Urchinkin_Animation.ATTACK, ageInTicks, 1.0f);
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.body.xRot = xRot * ((float)Math.PI / 180);
        this.everything.yRot = yRot * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }
}

