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

import com.skd.cataclysmbosses.client.animation.Hippocamtus_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Hippocamtus_Entity;
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

public class Hippocamtus_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart tail;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tail5;
    private final ModelPart body;
    private final ModelPart chest;
    private final ModelPart l_arm;
    private final ModelPart l_arm2;
    private final ModelPart r_arm;
    private final ModelPart r_arm2;
    private final ModelPart spear;
    private final ModelPart head;
    private final java.util.function.Function<String, ModelPart> partLookup;

    public Hippocamtus_Model(ModelPart root) {
        super(root);
        this.root = root;
        this.partLookup = root.createPartLookup();
        this.everything = this.root.getChild("everything");
        this.tail = this.everything.getChild("tail");
        this.tail2 = this.tail.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
        this.tail5 = this.tail4.getChild("tail5");
        this.body = this.everything.getChild("body");
        this.chest = this.body.getChild("chest");
        this.l_arm = this.chest.getChild("l_arm");
        this.l_arm2 = this.l_arm.getChild("l_arm2");
        this.r_arm = this.chest.getChild("r_arm");
        this.r_arm2 = this.r_arm.getChild("r_arm2");
        this.spear = this.r_arm2.getChild("spear");
        this.head = this.chest.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition tail = everything.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0f, 0.0f, -3.0f, 10.0f, 8.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(137, 105).addBox(-10.0f, -4.0f, 0.0f, 5.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(15, 137).addBox(5.0f, -4.0f, 0.0f, 5.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(74, 130).addBox(3.0f, -3.0f, -3.0f, 2.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(132, 56).addBox(-5.0f, -3.0f, -3.0f, 2.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-19.0f, (float)0.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 90).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.0f, (float)-2.0f, (float)-3.0f, (float)0.0f, (float)-0.7418f, (float)0.0f));
        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 96).addBox(-1.0f, -1.0f, 0.0f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.0f, (float)-2.0f, (float)3.0f, (float)0.0f, (float)0.7418f, (float)0.0f));
        PartDefinition cube_r3 = tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(38, 93).addBox(0.0f, -1.0f, 0.0f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)-2.0f, (float)3.0f, (float)0.0f, (float)-0.7418f, (float)0.0f));
        PartDefinition cube_r4 = tail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(38, 87).addBox(0.0f, -1.0f, 0.0f, 1.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)-2.0f, (float)-3.0f, (float)0.0f, (float)0.7418f, (float)0.0f));
        PartDefinition cube_r5 = tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(124, 23).addBox(-5.0f, 0.0f, 0.0f, 10.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)4.0f, (float)-3.0f, (float)-1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(93, 33).addBox(-4.5f, -1.5f, -2.5f, 9.0f, 7.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)7.5f, (float)0.0f, (float)0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 102).addBox(-4.0f, -0.5f, -2.0f, 8.0f, 7.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(92, 113).addBox(0.0f, 0.5f, 2.0f, 0.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)5.0f, (float)0.0f, (float)0.6109f, (float)0.0f, (float)0.0f));
        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(113, 64).addBox(-2.5f, 0.0f, -2.0f, 5.0f, 7.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(15, 127).addBox(-2.5f, 0.0f, -2.0f, 5.0f, 5.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(25, 102).addBox(0.0f, 1.0f, 2.0f, 0.0f, 5.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)6.5f, (float)0.0f, (float)0.7854f, (float)0.0f, (float)0.0f));
        PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(128, 43).addBox(-2.0f, 0.0f, -1.5f, 4.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(93, 0).addBox(-2.0f, 9.0f, -1.5f, 4.0f, 9.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(33, 87).addBox(0.0f, 9.0f, 7.5f, 0.0f, 9.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(122, 93).addBox(0.0f, 18.0f, -1.5f, 0.0f, 2.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(64, 135).addBox(0.0f, 3.0f, -3.5f, 0.0f, 15.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)7.0f, (float)0.0f, (float)1.0036f, (float)0.0f, (float)0.0f));
        PartDefinition body = everything.addOrReplaceChild("body", CubeListBuilder.create().texOffs(101, 93).addBox(-3.0f, -9.5f, -2.0f, 6.0f, 11.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-18.5f, (float)0.0f, (float)0.2182f, (float)0.0f, (float)0.0f));
        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(124, 14).addBox(-3.0f, -1.0f, -2.0f, 6.0f, 4.0f, 4.0f, new CubeDeformation(0.3f)).texOffs(132, 66).addBox(-2.0f, -10.0f, -2.5f, 4.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(122, 33).addBox(-2.5f, -10.0f, -3.0f, 5.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-8.5f, (float)0.0f));
        PartDefinition cube_r6 = chest.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(120, 109).addBox(6.0f, -3.0f, -6.0f, 0.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(120, 0).addBox(17.0f, -3.0f, -6.0f, 0.0f, 5.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-11.5f, (float)-7.0f, (float)3.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r7 = chest.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(113, 46).addBox(0.0f, -4.5f, 3.0f, 0.0f, 10.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(41, 84).addBox(-6.0f, -3.5f, -4.0f, 12.0f, 7.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-3.5f, (float)1.0f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition l_arm = chest.addOrReplaceChild("l_arm", CubeListBuilder.create().texOffs(69, 140).addBox(3.0f, -5.0f, -2.5f, 0.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(123, 76).addBox(-1.0f, -3.0f, -2.5f, 4.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(139, 117).addBox(3.0f, -7.0f, 0.0f, 6.0f, 9.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(121, 134).addBox(1.0f, 2.0f, -2.5f, 2.0f, 3.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(0, 114).addBox(-1.5f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)-5.0f, (float)0.0f, (float)-0.1745f, (float)0.0f, (float)-0.2618f));
        PartDefinition l_arm2 = l_arm.addOrReplaceChild("l_arm2", CubeListBuilder.create().texOffs(77, 113).addBox(-1.5f, 0.0f, -2.0f, 3.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(41, 47).addBox(1.5f, -4.0f, -9.0f, 2.0f, 18.0f, 18.0f, new CubeDeformation(0.0f)).texOffs(0, 131).addBox(2.5f, -8.0f, -1.0f, 0.0f, 4.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(91, 132).addBox(2.5f, 14.0f, -1.0f, 0.0f, 4.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(25, 112).addBox(-2.0f, -2.0f, -2.5f, 4.0f, 9.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(106, 134).addBox(0.0f, 9.0f, -2.5f, 2.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)10.0f, (float)0.0f, (float)-0.48f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r8 = l_arm2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(141, 96).addBox(0.0f, -2.0f, -2.5f, 0.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)9.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition r_arm = chest.addOrReplaceChild("r_arm", CubeListBuilder.create().texOffs(141, 87).addBox(-3.0f, -5.0f, -2.5f, 0.0f, 2.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(120, 123).addBox(-3.0f, -3.0f, -2.5f, 4.0f, 5.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(34, 135).addBox(-3.0f, 2.0f, -2.5f, 2.0f, 3.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(44, 118).addBox(-1.5f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)-5.0f, (float)0.0f, (float)-0.1745f, (float)0.0f, (float)0.2618f));
        PartDefinition r_arm2 = r_arm.addOrReplaceChild("r_arm2", CubeListBuilder.create().texOffs(101, 109).addBox(-2.0f, -2.0f, -2.5f, 4.0f, 9.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(142, 75).addBox(-6.9f, -2.0f, 0.0f, 5.0f, 9.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(59, 118).addBox(-1.5f, 0.0f, -2.0f, 3.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(106, 134).mirror().addBox(-2.0f, 9.0f, -2.5f, 2.0f, 4.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)10.0f, (float)0.0f, (float)-0.48f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r9 = r_arm2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(141, 96).mirror().addBox(0.0f, -2.0f, -2.5f, 0.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-2.0f, (float)9.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition spear = r_arm2.addOrReplaceChild("spear", CubeListBuilder.create().texOffs(44, 112).addBox(-1.5f, -1.5143f, -23.0f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(49, 135).addBox(-1.0f, -1.0143f, -22.2f, 2.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(44, 112).addBox(-1.5f, -1.5143f, -17.2f, 3.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(136, 134).addBox(0.0f, 0.9857f, -22.2f, 0.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(137, 0).addBox(0.0f, -6.9143f, -22.2f, 0.0f, 6.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(-0.5f, -0.5143f, -17.2f, 1.0f, 1.0f, 45.0f, new CubeDeformation(0.0f)).texOffs(0, 47).addBox(0.0f, -9.5143f, -43.0f, 0.0f, 19.0f, 20.0f, new CubeDeformation(0.0f)).texOffs(33, 99).addBox(-0.5f, -0.5143f, -34.0f, 1.0f, 1.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)10.5143f, (float)0.2f, (float)0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(82, 47).addBox(-0.5f, -10.9086f, -4.2305f, 0.0f, 13.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(58, 99).addBox(0.0f, -12.9086f, -13.1305f, 3.0f, 12.0f, 6.0f, new CubeDeformation(0.2f)).texOffs(82, 76).addBox(-3.0f, -2.9086f, -12.1305f, 6.0f, 2.0f, 14.0f, new CubeDeformation(0.001f)).texOffs(93, 19).addBox(-3.0f, -6.9086f, -7.1305f, 6.0f, 4.0f, 9.0f, new CubeDeformation(0.001f)).texOffs(80, 93).addBox(-3.0f, -15.9086f, -8.1305f, 0.0f, 9.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(92, 124).addBox(-2.0f, -1.9086f, -18.1305f, 4.0f, 1.0f, 6.0f, new CubeDeformation(0.001f)), PartPose.offsetAndRotation((float)0.0f, (float)-9.0f, (float)0.5f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
    }

    @NotNull
    public Optional<ModelPart> getAnyDescendantWithName(String name) {
        if ("root".equals(name)) {
            return Optional.of(this.root);
        }
        return Optional.ofNullable(this.partLookup.apply(name));
    }

        @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
    }
}
