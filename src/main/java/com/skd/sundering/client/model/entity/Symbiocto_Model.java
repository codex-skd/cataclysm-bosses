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
package com.skd.sundering.client.model.entity;

import com.skd.sundering.client.animation.Symbiocto_Animation;
import com.skd.sundering.entity.InternalAnimationMonster.AcropolisMonsters.Symbiocto_Entity;
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

public class Symbiocto_Model
extends HierarchicalModel<Symbiocto_Entity> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart octo_head;
    private final ModelPart back_tentacle1;
    private final ModelPart face_tentacle2;
    private final ModelPart face_tentacle1;
    private final ModelPart face_tentacle3;
    private final ModelPart teeth2;
    private final ModelPart teeth;
    private final ModelPart teeth3;
    private final ModelPart teeth4;
    private final ModelPart left_tentacle1;
    private final ModelPart right_tentacle1;
    private final ModelPart left_tentacle2;
    private final ModelPart right_tentacle2;
    private final ModelPart left_tentacle3;
    private final ModelPart right_tentacle3;
    private final ModelPart back_tentacle2;
    private final ModelPart back_tentacle3;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Symbiocto_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.octo_head = this.everything.getChild("octo_head");
        this.back_tentacle1 = this.octo_head.getChild("back_tentacle1");
        this.face_tentacle2 = this.octo_head.getChild("face_tentacle2");
        this.face_tentacle1 = this.octo_head.getChild("face_tentacle1");
        this.face_tentacle3 = this.octo_head.getChild("face_tentacle3");
        this.teeth2 = this.octo_head.getChild("teeth2");
        this.teeth = this.octo_head.getChild("teeth");
        this.teeth3 = this.octo_head.getChild("teeth3");
        this.teeth4 = this.octo_head.getChild("teeth4");
        this.left_tentacle1 = this.octo_head.getChild("left_tentacle1");
        this.right_tentacle1 = this.octo_head.getChild("right_tentacle1");
        this.left_tentacle2 = this.octo_head.getChild("left_tentacle2");
        this.right_tentacle2 = this.octo_head.getChild("right_tentacle2");
        this.left_tentacle3 = this.octo_head.getChild("left_tentacle3");
        this.right_tentacle3 = this.octo_head.getChild("right_tentacle3");
        this.back_tentacle2 = this.octo_head.getChild("back_tentacle2");
        this.back_tentacle3 = this.octo_head.getChild("back_tentacle3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition octo_head = everything.addOrReplaceChild("octo_head", CubeListBuilder.create().texOffs(40, 58).addBox(4.5f, -3.0f, -2.5f, 2.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(41, 18).addBox(6.5f, -6.0f, -3.5f, 0.0f, 7.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-4.5f, -5.0f, -4.5f, 9.0f, 9.0f, 11.0f, new CubeDeformation(0.0f)).texOffs(100, 119).addBox(-3.5f, 2.0f, -3.5f, 7.0f, 2.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 21).addBox(-4.5f, -5.0f, -4.5f, 9.0f, 9.0f, 11.0f, new CubeDeformation(0.2f)).texOffs(0, 55).addBox(-2.5f, -9.0f, -4.5f, 0.0f, 4.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(41, 0).addBox(4.5f, -7.0f, 0.5f, 0.0f, 7.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(41, 0).mirror().addBox(-4.5f, -7.0f, 0.5f, 0.0f, 7.0f, 10.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(40, 58).mirror().addBox(-6.5f, -3.0f, -2.5f, 2.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(41, 18).mirror().addBox(-6.5f, -6.0f, -3.5f, 0.0f, 7.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)-4.0f, (float)-0.5f));
        PartDefinition back_tentacle1 = octo_head.addOrReplaceChild("back_tentacle1", CubeListBuilder.create().texOffs(19, 53).mirror().addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(60, 33).mirror().addBox(-1.0f, -4.0f, 6.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)3.5f, (float)3.0f, (float)4.5f));
        PartDefinition face_tentacle2 = octo_head.addOrReplaceChild("face_tentacle2", CubeListBuilder.create().texOffs(40, 47).addBox(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(58, 27).mirror().addBox(-1.0f, -4.0f, -8.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)3.0f, (float)-4.5f));
        PartDefinition face_tentacle1 = octo_head.addOrReplaceChild("face_tentacle1", CubeListBuilder.create().texOffs(19, 42).mirror().addBox(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(58, 27).mirror().addBox(-1.0f, -4.0f, -8.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)3.5f, (float)3.0f, (float)-4.5f));
        PartDefinition face_tentacle3 = octo_head.addOrReplaceChild("face_tentacle3", CubeListBuilder.create().texOffs(19, 42).addBox(-1.0f, -1.0f, -8.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(58, 27).addBox(-1.0f, -4.0f, -8.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-3.5f, (float)3.0f, (float)-4.5f));
        PartDefinition teeth2 = octo_head.addOrReplaceChild("teeth2", CubeListBuilder.create().texOffs(0, 42).addBox(0.0f, 0.0f, -4.5f, 0.0f, 3.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.5f, (float)4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.6981f));
        PartDefinition teeth = octo_head.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(41, 34).addBox(0.0f, 0.0f, -4.5f, 0.0f, 3.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.5f, (float)4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.6981f));
        PartDefinition teeth3 = octo_head.addOrReplaceChild("teeth3", CubeListBuilder.create().texOffs(58, 23).addBox(-4.5f, 0.0f, 0.0f, 9.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)4.0f, (float)-4.5f, (float)0.6981f, (float)0.0f, (float)0.0f));
        PartDefinition teeth4 = octo_head.addOrReplaceChild("teeth4", CubeListBuilder.create().texOffs(58, 23).addBox(-4.5f, 0.0f, 0.0f, 9.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)4.0f, (float)4.5f, (float)-0.6981f, (float)0.0f, (float)0.0f));
        PartDefinition left_tentacle1 = octo_head.addOrReplaceChild("left_tentacle1", CubeListBuilder.create().texOffs(58, 18).addBox(0.0f, -0.95f, -1.0f, 8.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(53, 58).addBox(6.0f, -3.95f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)4.5f, (float)2.95f, (float)-3.5f));
        PartDefinition right_tentacle1 = octo_head.addOrReplaceChild("right_tentacle1", CubeListBuilder.create().texOffs(58, 18).mirror().addBox(-8.0f, -0.95f, -1.0f, 8.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 58).mirror().addBox(-8.0f, -3.95f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-4.5f, (float)2.95f, (float)-3.5f));
        PartDefinition left_tentacle2 = octo_head.addOrReplaceChild("left_tentacle2", CubeListBuilder.create().texOffs(58, 18).addBox(0.0f, -0.95f, -1.0f, 8.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(53, 58).addBox(6.0f, -3.95f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)4.5f, (float)2.95f, (float)0.0f));
        PartDefinition right_tentacle2 = octo_head.addOrReplaceChild("right_tentacle2", CubeListBuilder.create().texOffs(58, 18).mirror().addBox(-8.0f, -0.95f, -1.0f, 8.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 58).mirror().addBox(-8.0f, -3.95f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-4.5f, (float)2.95f, (float)0.0f));
        PartDefinition left_tentacle3 = octo_head.addOrReplaceChild("left_tentacle3", CubeListBuilder.create().texOffs(58, 18).addBox(0.0f, -0.95f, -1.0f, 8.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(53, 58).addBox(6.0f, -3.95f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)4.5f, (float)2.95f, (float)3.5f));
        PartDefinition right_tentacle3 = octo_head.addOrReplaceChild("right_tentacle3", CubeListBuilder.create().texOffs(58, 18).mirror().addBox(-8.0f, -0.95f, -1.0f, 8.0f, 2.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 58).mirror().addBox(-8.0f, -3.95f, -1.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-4.5f, (float)2.95f, (float)3.5f));
        PartDefinition back_tentacle2 = octo_head.addOrReplaceChild("back_tentacle2", CubeListBuilder.create().texOffs(19, 53).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(60, 33).addBox(-1.0f, -4.0f, 6.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)3.0f, (float)4.5f));
        PartDefinition back_tentacle3 = octo_head.addOrReplaceChild("back_tentacle3", CubeListBuilder.create().texOffs(19, 53).addBox(-1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(60, 33).addBox(-1.0f, -4.0f, 6.0f, 2.0f, 3.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-3.5f, (float)3.0f, (float)4.5f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Symbiocto_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(Symbiocto_Animation.WALK, limbSwing, limbSwingAmount, 2.0f, 4.0f);
        this.animate(entity.getAnimationState("idle"), Symbiocto_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("attack"), Symbiocto_Animation.ATTACK, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spit"), Symbiocto_Animation.INK, ageInTicks, 1.0f);
        if (this.riding) {
            this.octo_head.z += 1.0f;
            this.octo_head.xRot -= (float)Math.toRadians(22.5);
            this.right_tentacle1.zRot -= (float)Math.toRadians(52.5);
            this.left_tentacle1.zRot += (float)Math.toRadians(52.5);
            this.right_tentacle2.zRot -= (float)Math.toRadians(20.0);
            this.left_tentacle2.zRot += (float)Math.toRadians(20.0);
            this.right_tentacle3.zRot -= (float)Math.toRadians(7.5);
            this.left_tentacle3.zRot += (float)Math.toRadians(7.5);
            this.face_tentacle1.xRot += (float)Math.toRadians(105.0);
            this.face_tentacle2.xRot += (float)Math.toRadians(105.0);
            this.face_tentacle3.xRot += (float)Math.toRadians(105.0);
            this.back_tentacle1.xRot -= (float)Math.toRadians(75.0);
            this.back_tentacle2.xRot -= (float)Math.toRadians(75.0);
            this.back_tentacle3.xRot -= (float)Math.toRadians(75.0);
        }
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

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.everything.yRot = yRot * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }
}

