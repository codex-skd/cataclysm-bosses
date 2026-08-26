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

import com.skd.cataclysmbosses.client.animation.Draugar_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Draugr_Entity;
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

public class Draugr_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState>
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
    private final ModelPart right_arm_r2;
    private final ModelPart head;
    private final ModelPart maw;
    private final ModelPart body_r1;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Draugr_Model(ModelPart root) {
        super(root);
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
        this.right_arm_r2 = this.right_arm.getChild("right_arm_r2");
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
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0f, -12.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(52, 0).addBox(-4.0f, -12.0f, -2.0f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.2f)).texOffs(32, 36).addBox(-4.0f, -3.0f, -2.0f, 8.0f, 11.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)0.0f, (float)-12.0f, (float)0.0f, (float)-0.0873f, (float)-0.2182f, (float)0.0f));
        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(76, 0).mirror().addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.2f)).mirror(false).texOffs(0, 48).mirror().addBox(-1.0f, 3.0f, -1.0f, 2.0f, 5.0f, 2.0f, new CubeDeformation(0.5f)).mirror(false).texOffs(40, 16).mirror().addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)5.0f, (float)-9.0f, (float)0.0f, (float)0.1309f, (float)0.0f, (float)-0.0436f));
        PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(58, 17).mirror().addBox(-1.0f, -2.0f, -3.5f, 0.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.9763f, (float)-0.7164f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition left_arm_r2 = left_arm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(48, 23).mirror().addBox(-1.0f, -2.0f, -1.5f, 2.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(84, 0).addBox(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, new CubeDeformation(0.2f)).texOffs(0, 48).addBox(-1.0f, 2.0f, -1.0f, 2.0f, 5.0f, 2.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)-5.0f, (float)-8.0f, (float)0.0f, (float)0.1309f, (float)0.0f, (float)0.0436f));
        PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(48, 18).addBox(-1.0f, -3.0f, -1.5f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.7526f, (float)-1.3329f, (float)1.5f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition right_arm_r2 = right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(58, 23).addBox(0.0f, -2.0f, -3.5f, 0.0f, 6.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(48, 23).addBox(-1.0f, -2.0f, -1.5f, 2.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(92, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.2f)).texOffs(0, 32).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.5f)).texOffs(58, 36).addBox(0.0f, -16.0f, 0.0f, 10.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(0, 55).mirror().addBox(-10.0f, -13.0f, 0.0f, 6.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-12.0f, (float)-1.0f, (float)0.5079f, (float)0.1287f, (float)-0.137f));
        PartDefinition maw = head.addOrReplaceChild("maw", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-2.5f, (float)-1.0f, (float)-0.0873f, (float)0.0f, (float)0.2182f));
        PartDefinition body_r1 = maw.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 6).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 5.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)64);
    }

        @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
    }
}
