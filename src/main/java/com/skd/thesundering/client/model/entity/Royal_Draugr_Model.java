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
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.HumanoidArm
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.client.animation.Draugar_Animation;
import com.skd.thesundering.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import org.jetbrains.annotations.NotNull;

public class Royal_Draugr_Model
extends HierarchicalModel<Royal_Draugr_Entity>
implements ArmedModel {
    private final ModelPart everything;
    private final ModelPart root;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart left_arm_r1;
    private final ModelPart left_arm_r2;
    private final ModelPart right_arm;
    private final ModelPart right_arm_r1;
    private final ModelPart head;
    private final ModelPart maw;
    private final ModelPart body_r1;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Royal_Draugr_Model(ModelPart root) {
        this.everything = root;
        this.buildPartCache(root);
        this.root = this.everything.getChild("root");
        this.right_leg = this.root.getChild("right_leg");
        this.left_leg = this.root.getChild("left_leg");
        this.body = this.root.getChild("body");
        this.left_arm = this.body.getChild("left_arm");
        this.left_arm_r1 = this.left_arm.getChild("left_arm_r1");
        this.left_arm_r2 = this.left_arm.getChild("left_arm_r2");
        this.right_arm = this.body.getChild("right_arm");
        this.right_arm_r1 = this.right_arm.getChild("right_arm_r1");
        this.head = this.body.getChild("head");
        this.maw = this.head.getChild("maw");
        this.body_r1 = this.maw.getChild("body_r1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0f, 0.0f, -1.1f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(84, 0).addBox(-1.0f, 0.0f, -1.1f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.2f)), PartPose.offset((float)-2.0f, (float)-12.0f, (float)0.1f));
        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0f, 0.0f, -1.1f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(76, 0).mirror().addBox(-1.0f, 0.0f, -1.1f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offset((float)2.0f, (float)-12.0f, (float)0.1f));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0f, -12.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(52, 0).addBox(-4.0f, -12.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.2f)).texOffs(104, 26).addBox(-4.0f, -12.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.4f)).texOffs(32, 36).addBox(-4.0f, -3.0f, -2.0f, 8.0f, 11.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)0.0f, (float)-12.0f, (float)0.0f, (float)0.0873f, (float)0.0f, (float)0.0436f));
        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(76, 0).mirror().addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.2f)).mirror(false).texOffs(0, 48).mirror().addBox(-1.0f, 3.0f, -1.0f, 2.0f, 5.0f, 2.0f, new CubeDeformation(0.5f)).mirror(false).texOffs(118, 42).mirror().addBox(0.0f, 2.0f, -1.5f, 2.0f, 7.0f, 3.0f, new CubeDeformation(0.2f)).mirror(false).texOffs(40, 16).mirror().addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)5.0f, (float)-9.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)-0.0873f));
        PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(58, 17).mirror().addBox(-1.0f, -2.0f, -3.5f, 0.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.9763f, (float)-0.7164f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition left_arm_r2 = left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(48, 23).mirror().addBox(-1.0f, -2.0f, -1.5f, 2.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(84, 0).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.2f)).texOffs(0, 48).addBox(-1.0f, 2.0f, -1.0f, 2.0f, 5.0f, 2.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)-5.0f, (float)-8.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(104, 52).addBox(-3.0f, -4.0f, -2.5f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-0.5f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(92, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.2f)).texOffs(0, 32).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.5f)).texOffs(58, 36).addBox(0.0f, -16.0f, 0.0f, 10.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 55).mirror().addBox(-10.0f, -13.0f, 0.0f, 6.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-12.0f, (float)-1.0f, (float)0.1309f, (float)0.0f, (float)0.1745f));
        PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-2.5f, (float)-1.0f, (float)0.346f, (float)-0.0636f, (float)-0.1737f));
        PartDefinition body_r1 = maw.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 6).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 5.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)64);
    }

    public void setupAnim(Royal_Draugr_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean flag2;
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(Draugar_Animation.WALK, limbSwing, limbSwingAmount, 2.0f, 2.0f);
        this.animate(entity.getAnimationState("idle"), Draugar_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("attack"), Draugar_Animation.ATTACK, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("attack2"), Draugar_Animation.ATTACK2, ageInTicks, 1.0f);
        boolean bl = flag2 = entity.getMainArm() == HumanoidArm.RIGHT;
        if (entity.isUsingItem()) {
            boolean flag3;
            boolean bl2 = flag3 = entity.getUsedItemHand() == InteractionHand.MAIN_HAND;
            if (flag3 == flag2) {
                this.right_arm.xRot = this.right_arm.xRot * 0.5f - 0.9424779f;
                this.right_arm.yRot = -0.5235988f;
            } else {
                this.left_arm.xRot = this.left_arm.xRot * 0.5f - 0.9424779f;
                this.left_arm.yRot = 0.5235988f;
            }
        }
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot = xRot * ((float)Math.PI / 180);
        this.head.yRot = yRot * ((float)Math.PI / 180);
    }

    public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
        this.root.translateAndRotate(poseStack);
        this.body.translateAndRotate(poseStack);
        if (arm == HumanoidArm.RIGHT) {
            this.right_arm.translateAndRotate(poseStack);
            poseStack.translate(0.0f, 0.0f, 0.0f);
        } else {
            this.left_arm.translateAndRotate(poseStack);
            poseStack.translate(0.0f, 0.0f, 0.0f);
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

    public ModelPart root() {
        return this.root;
    }
}

