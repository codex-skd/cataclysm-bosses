/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
 *  net.minecraft.client.model.ArmedModel
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.world.entity.HumanoidArm
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Elite_Draugr_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.model.ArmedModel;
import com.skd.cataclysmbosses.client.model.compat.CmHierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.NotNull;

public class Elite_Draugr_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState>
implements ArmedModel {
    private final ModelPart everything;
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart front_cloth1;
    private final ModelPart front_cloth2;
    private final ModelPart back_cloth1;
    private final ModelPart back_cloth2;
    private final ModelPart waist;
    private final ModelPart chest;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart maw;
    private final ModelPart l_arm;
    private final ModelPart cube_r1;
    private final ModelPart l_arm2;
    private final ModelPart r_arm;
    private final ModelPart cube_r2;
    private final ModelPart r_arm2;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Elite_Draugr_Model(ModelPart root) {
        super(root);
        this.everything = root;
        this.buildPartCache(root);
        this.root = this.everything.getChild("root");
        this.body = this.root.getChild("body");
        this.front_cloth1 = this.body.getChild("front_cloth1");
        this.front_cloth2 = this.front_cloth1.getChild("front_cloth2");
        this.back_cloth1 = this.body.getChild("back_cloth1");
        this.back_cloth2 = this.back_cloth1.getChild("back_cloth2");
        this.waist = this.body.getChild("waist");
        this.chest = this.waist.getChild("chest");
        this.neck = this.chest.getChild("neck");
        this.head = this.neck.getChild("head");
        this.maw = this.head.getChild("maw");
        this.l_arm = this.chest.getChild("l_arm");
        this.cube_r1 = this.l_arm.getChild("cube_r1");
        this.l_arm2 = this.l_arm.getChild("l_arm2");
        this.r_arm = this.chest.getChild("r_arm");
        this.cube_r2 = this.r_arm.getChild("cube_r2");
        this.r_arm2 = this.r_arm.getChild("r_arm2");
        this.right_leg = this.root.getChild("right_leg");
        this.left_leg = this.root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(52, 0).addBox(-5.0f, -4.0f, -2.0f, 10.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-12.0f, (float)0.0f));
        PartDefinition front_cloth1 = body.addOrReplaceChild("front_cloth1", CubeListBuilder.create().texOffs(60, 8).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-2.0f, (float)-0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition front_cloth2 = front_cloth1.addOrReplaceChild("front_cloth2", CubeListBuilder.create().texOffs(56, 44).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)4.0f, (float)0.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition back_cloth1 = body.addOrReplaceChild("back_cloth1", CubeListBuilder.create().texOffs(38, 16).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)2.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition back_cloth2 = back_cloth1.addOrReplaceChild("back_cloth2", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0f, 0.0f, 0.0f, 8.0f, 4.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)4.0f, (float)0.0f));
        PartDefinition waist = body.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(80, 50).addBox(-1.5f, -8.0f, -1.0f, 3.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-4.0f, (float)1.0f));
        PartDefinition chest = waist.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(80, 60).addBox(-1.5f, -8.0f, -1.0f, 3.0f, 8.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(32, 50).addBox(-6.0f, -8.0f, -4.0f, 12.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(96, 0).addBox(-6.0f, -8.0f, -4.0f, 12.0f, 10.0f, 4.0f, new CubeDeformation(0.1f)), PartPose.offset((float)0.0f, (float)-8.0f, (float)0.0f));
        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(16, 18).addBox(-1.0f, -4.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-8.0f, (float)0.0f));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(96, 112).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.1f)).texOffs(0, 64).addBox(-11.0f, -15.0f, 0.0f, 9.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(80, 0).addBox(4.0f, -12.0f, 0.0f, 6.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(28, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.4f)), PartPose.offset((float)0.0f, (float)-2.0f, (float)-1.0f));
        PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create().texOffs(60, 60).addBox(-3.0f, -2.5f, -2.0f, 6.0f, 5.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)0.5f, (float)-3.0f, (float)0.2102f, (float)0.0504f, (float)-0.3014f));
        PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(72, 32).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(26, 76).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 5.0f, 4.0f, new CubeDeformation(0.3f)), PartPose.offset((float)7.0f, (float)-6.0f, (float)-1.0f));
        PartDefinition cube_r1 = l_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -2.0f, -2.5f, 6.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2618f));
        PartDefinition l_arm2 = l_arm.addOrReplaceChild("l_arm2", CubeListBuilder.create().texOffs(52, 69).addBox(-2.0f, 2.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.2f)).texOffs(68, 69).mirror().addBox(-2.0f, 0.0f, -2.0f, 4.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)6.0f, (float)0.0f));
        PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(72, 20).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(64, 50).addBox(-2.0f, -2.0f, -2.0f, 4.0f, 5.0f, 4.0f, new CubeDeformation(0.3f)), PartPose.offset((float)-7.0f, (float)-6.0f, (float)-1.0f));
        PartDefinition cube_r2 = r_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0f, 0.0f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(17, 11).addBox(-5.0f, -2.0f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(17, 9).addBox(0.0f, -3.0f, -0.5f, 1.0f, 1.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(0, 9).addBox(-2.0f, -4.0f, -0.5f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-4.0f, -5.0f, -0.5f, 1.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(0, 9).addBox(-3.0f, -2.0f, -2.5f, 6.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.2618f));
        PartDefinition r_arm2 = r_arm.addOrReplaceChild("r_arm2", CubeListBuilder.create().texOffs(68, 69).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 10.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(36, 64).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.2f)), PartPose.offset((float)0.0f, (float)6.0f, (float)0.0f));
        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 28).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-3.0f, (float)-12.0f, (float)0.0f));
        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 12).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)3.0f, (float)-12.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

        @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
        // TODO (26.2): port animate/animateWalk calls from old setupAnim(entity, limbSwing, ...)
        // Original body stubbed for compile; see git history for original.
        // if (false) { // stubbed for compile
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(Elite_Draugr_Animation.WALK, limbSwing, limbSwingAmount, 2.0f, 2.0f);
        this.animate(entity.getAnimationState("idle"), Elite_Draugr_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("re_load"), Elite_Draugr_Animation.RE_LOAD, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("shoot"), Elite_Draugr_Animation.SHOOT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("shoot2"), Elite_Draugr_Animation.SHOOT2, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("swing"), Elite_Draugr_Animation.SWING, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("attack"), Elite_Draugr_Animation.ATTACK, ageInTicks, 1.5f);
        this.animate(entity.getAnimationState("attack2"), Elite_Draugr_Animation.ATTACK2, ageInTicks, 1.5f);
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot = xRot * ((float)Math.PI / 180);
        this.head.yRot = yRot * ((float)Math.PI / 180);
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.getAllParts().entrySet()) {
            String partName = (String)entry.getKey();
            ModelPart childPart = (ModelPart)entry.getValue();
            this.partCache.putIfAbsent(partName, childPart);
            this.optionalPartCache.putIfAbsent(partName, Optional.of(childPart));
            if (getChildrenMap(childPart).isEmpty()) continue;
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

    public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
        this.root.translateAndRotate(poseStack);
        this.body.translateAndRotate(poseStack);
        this.waist.translateAndRotate(poseStack);
        this.chest.translateAndRotate(poseStack);
        if (arm == HumanoidArm.RIGHT) {
            this.r_arm.translateAndRotate(poseStack);
            this.r_arm2.translateAndRotate(poseStack);
            poseStack.translate(0.0f, 0.0f, 0.0f);
        } else {
            this.l_arm.translateAndRotate(poseStack);
            this.l_arm2.translateAndRotate(poseStack);
            poseStack.translate(0.0f, 0.0f, 0.0f);
        }
    }

    public ModelPart root() {
        return this.root;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, ModelPart> getChildrenMap(ModelPart part) {
        try {
            java.lang.reflect.Field f = ModelPart.class.getDeclaredField("children");
            f.setAccessible(true);
            return (Map<String, ModelPart>) f.get(part);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

