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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Kobolediator_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Kobolediator_Entity;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import com.skd.cataclysmbosses.client.model.compat.CmHierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class Kobolediator_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart mid_root;
    private final ModelPart pelvis;
    private final ModelPart lower_body;
    private final ModelPart body;
    private final ModelPart right_shoulder;
    private final ModelPart right_arm;
    private final ModelPart right_front_arm;
    private final ModelPart golden_greatsword;
    private final ModelPart left_shoulder;
    private final ModelPart left_arm;
    private final ModelPart left_front_arm;
    private final ModelPart head;
    private final ModelPart head_cube1;
    private final ModelPart head_cube2;
    private final ModelPart head_cube3;
    private final ModelPart head_cube4;
    private final ModelPart right_horn;
    private final ModelPart left_horn;
    private final ModelPart jaw;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart legs;
    private final ModelPart right_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_leg;
    private final ModelPart left_front_leg;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Kobolediator_Model(ModelPart root) {
        super(root);
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.mid_root = this.everything.getChild("mid_root");
        this.pelvis = this.mid_root.getChild("pelvis");
        this.lower_body = this.pelvis.getChild("lower_body");
        this.body = this.lower_body.getChild("body");
        this.right_shoulder = this.body.getChild("right_shoulder");
        this.right_arm = this.right_shoulder.getChild("right_arm");
        this.right_front_arm = this.right_arm.getChild("right_front_arm");
        this.golden_greatsword = this.right_front_arm.getChild("golden_greatsword");
        this.left_shoulder = this.body.getChild("left_shoulder");
        this.left_arm = this.left_shoulder.getChild("left_arm");
        this.left_front_arm = this.left_arm.getChild("left_front_arm");
        this.head = this.body.getChild("head");
        this.head_cube1 = this.head.getChild("head_cube1");
        this.head_cube2 = this.head.getChild("head_cube2");
        this.head_cube3 = this.head.getChild("head_cube3");
        this.head_cube4 = this.head.getChild("head_cube4");
        this.right_horn = this.head.getChild("right_horn");
        this.left_horn = this.head.getChild("left_horn");
        this.jaw = this.head.getChild("jaw");
        this.tail1 = this.pelvis.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.legs = this.mid_root.getChild("legs");
        this.right_leg = this.legs.getChild("right_leg");
        this.right_front_leg = this.right_leg.getChild("right_front_leg");
        this.left_leg = this.legs.getChild("left_leg");
        this.left_front_leg = this.left_leg.getChild("left_front_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)25.0f, (float)-1.0f));
        PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition pelvis = mid_root.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(94, 72).addBox(-9.0f, -3.0f, -6.0513f, 18.0f, 6.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-22.0f, (float)0.0f, (float)0.1745f, (float)0.1309f, (float)0.0f));
        PartDefinition lower_body = pelvis.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(86, 0).addBox(-6.2168f, -14.0f, -15.0f, 14.0f, 14.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(56, 146).addBox(-2.2168f, -14.0f, -3.0f, 6.0f, 14.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-0.7832f, (float)0.0f, (float)8.9487f));
        PartDefinition body = lower_body.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.2168f, -21.0f, -19.0f, 24.0f, 21.0f, 19.0f, new CubeDeformation(0.0f)).texOffs(126, 130).addBox(-3.2168f, -21.0f, -3.0f, 6.0f, 21.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(0, 40).addBox(-10.2168f, -21.0f, -21.0f, 4.0f, 16.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(5.7832f, -21.0f, -21.0f, 4.0f, 16.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 40).addBox(-13.2168f, -21.0f, -19.0f, 26.0f, 7.0f, 19.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)1.0f, (float)-14.0f, (float)0.0f, (float)0.1372f, (float)-0.3027f, (float)-0.0411f));
        PartDefinition right_shoulder = body.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(0, 66).addBox(-16.0f, -4.0f, -9.0f, 17.0f, 15.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-13.0f, (float)-20.0f, (float)-8.0f, (float)-0.6109f, (float)0.2618f, (float)0.2182f));
        PartDefinition right_arm = right_shoulder.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(94, 124).addBox(-5.0f, -1.0f, -4.0f, 8.0f, 14.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.0f, (float)9.0f, (float)2.0f, (float)-0.4904f, (float)0.0334f, (float)0.0769f));
        PartDefinition right_front_arm = right_arm.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(0, 100).addBox(-6.025f, 0.0f, -6.5f, 9.0f, 22.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(94, 93).addBox(-8.025f, 2.0f, -8.5f, 8.0f, 18.0f, 13.0f, new CubeDeformation(0.0f)).texOffs(67, 0).addBox(1.0f, 16.0f, -1.5f, 4.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(53, 69).addBox(1.0f, 17.0f, 1.5f, 4.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(53, 69).addBox(1.0f, 17.0f, -4.5f, 4.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)13.0f, (float)2.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition golden_greatsword = right_front_arm.addOrReplaceChild("golden_greatsword", CubeListBuilder.create().texOffs(80, 146).addBox(-2.2168f, -12.0f, -2.1f, 4.0f, 21.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(72, 72).addBox(-1.7168f, -78.0f, -4.1f, 3.0f, 66.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(71, 40).addBox(-2.2168f, -12.0f, 1.9f, 4.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(0, 66).addBox(-2.2168f, -12.0f, -7.1f, 4.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)18.9f, (float)1.0f, (float)1.3963f, (float)0.0f, (float)0.0f));
        PartDefinition left_shoulder = body.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-1.0f, -4.0f, -9.0f, 17.0f, 15.0f, 19.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)12.5663f, (float)-20.0f, (float)-8.0f, (float)0.0436f, (float)-0.0873f, (float)-0.1309f));
        PartDefinition left_arm = left_shoulder.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(94, 124).mirror().addBox(-3.0f, -1.0f, -4.0f, 8.0f, 14.0f, 8.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)5.0f, (float)9.0f, (float)2.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition left_front_arm = left_arm.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(0, 100).mirror().addBox(-2.975f, 0.0f, -6.5f, 9.0f, 22.0f, 9.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(94, 93).mirror().addBox(0.025f, 2.0f, -8.5f, 8.0f, 18.0f, 13.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 69).mirror().addBox(-5.0f, 17.0f, -4.5f, 4.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(67, 0).mirror().addBox(-5.0f, 16.0f, -1.5f, 4.0f, 7.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 69).mirror().addBox(-5.0f, 17.0f, 1.5f, 4.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)13.0f, (float)2.0f, (float)-0.829f, (float)0.0f, (float)0.0f));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 119).addBox(-4.2168f, -3.0f, -10.0f, 10.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)-30.0f, (float)-9.0f, (float)0.0f, (float)0.1309f, (float)0.0f));
        PartDefinition head_cube1 = head.addOrReplaceChild("head_cube1", CubeListBuilder.create().texOffs(36, 100).addBox(0.8f, -5.0f, -8.0f, 6.0f, 6.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.5663f, (float)-2.0f, (float)-2.0f, (float)0.1616f, (float)0.1866f, (float)-0.0568f));
        PartDefinition head_cube2 = head.addOrReplaceChild("head_cube2", CubeListBuilder.create().texOffs(62, 38).addBox(1.0f, -6.0f, -12.0f, 6.0f, 6.0f, 28.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.2168f, (float)-3.0f, (float)-2.0f, (float)0.48f, (float)0.0f, (float)0.0f));
        PartDefinition head_cube3 = head.addOrReplaceChild("head_cube3", CubeListBuilder.create().texOffs(125, 113).addBox(-6.8f, -5.0f, -8.0f, 6.0f, 6.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)-2.0f, (float)0.1616f, (float)-0.1866f, (float)0.0568f));
        PartDefinition head_cube4 = head.addOrReplaceChild("head_cube4", CubeListBuilder.create().texOffs(102, 49).addBox(-3.0f, -34.0f, -23.0f, 9.0f, 7.0f, 10.0f, new CubeDeformation(-0.01f)), PartPose.offsetAndRotation((float)-0.7168f, (float)30.0f, (float)5.0f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(148, 105).addBox(-9.2168f, -9.0f, 4.0513f, 5.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(148, 40).addBox(-9.2168f, -9.0f, -1.9487f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(129, 0).addBox(-9.2168f, -3.0f, -1.9487f, 12.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-2.0f, (float)-5.0f, (float)-3.0f));
        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(148, 52).addBox(4.2168f, -9.0f, 4.0513f, 5.0f, 5.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(96, 146).addBox(3.2168f, -9.0f, -1.9487f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(123, 93).addBox(-2.7832f, -3.0f, -1.9487f, 12.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)3.5663f, (float)-5.0f, (float)-3.0f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(102, 29).addBox(-2.7168f, -4.0f, -12.0f, 7.0f, 4.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)6.0f, (float)-6.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition tail1 = pelvis.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(130, 54).addBox(-1.5f, -2.0f, -1.0f, 3.0f, 4.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.1231f, (float)11.3724f, (float)-0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(67, 0).addBox(-2.0f, -1.1888f, -1.1585f, 2.0f, 3.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)-0.5f, (float)10.0f, (float)0.4799f, (float)0.0f, (float)0.0f));
        PartDefinition legs = mid_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-22.0f, (float)0.0f));
        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(145, 70).addBox(-3.2168f, -2.0f, -3.0f, 7.0f, 10.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-6.7832f, (float)4.0f, (float)0.9487f, (float)-0.1295f, (float)0.5275f, (float)0.3306f));
        PartDefinition right_front_leg = right_leg.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(137, 22).addBox(-2.2168f, 0.0f, -1.0f, 7.0f, 11.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(53, 62).addBox(-1.2168f, 8.0f, -5.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(53, 62).addBox(3.7832f, 8.0f, -5.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(53, 62).addBox(1.2832f, 8.0f, -5.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.975f, (float)8.0f, (float)-2.0f, (float)0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 138).addBox(-3.7832f, -2.0f, -3.0f, 7.0f, 10.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)6.7832f, (float)3.0f, (float)0.9487f, (float)-0.1295f, (float)-0.5275f, (float)-0.3306f));
        PartDefinition left_front_leg = left_leg.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 131).addBox(-4.7832f, 0.0f, -1.0f, 7.0f, 11.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(53, 62).mirror().addBox(1.2168f, 8.0f, -5.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 62).mirror().addBox(-1.2832f, 8.0f, -5.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(53, 62).mirror().addBox(-3.7832f, 8.0f, -5.0f, 0.0f, 3.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.975f, (float)8.0f, (float)-2.0f, (float)0.3927f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

        @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
    }
}
