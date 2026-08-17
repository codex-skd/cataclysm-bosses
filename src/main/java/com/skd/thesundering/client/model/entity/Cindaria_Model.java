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

import com.skd.thesundering.client.animation.Cindaria_Animation;
import com.skd.thesundering.entity.InternalAnimationMonster.AcropolisMonsters.Cindaria_Entity;
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

public class Cindaria_Model
extends HierarchicalModel<Cindaria_Entity> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart lowerBody;
    private final ModelPart upperBody;
    private final ModelPart head;
    private final ModelPart head2;
    private final ModelPart rightHeadArm;
    private final ModelPart rightHeadArm2;
    private final ModelPart rightHeadArm3;
    private final ModelPart leftHeadArm;
    private final ModelPart leftHeadArm2;
    private final ModelPart leftHeadArm3;
    private final ModelPart rightArm;
    private final ModelPart rightArm2;
    private final ModelPart staff;
    private final ModelPart bone;
    private final ModelPart leftArm;
    private final ModelPart leftArm2;
    private final ModelPart skirt;
    private final ModelPart skirt2;
    private final ModelPart rightLeg;
    private final ModelPart rightLeg2;
    private final ModelPart leftLeg;
    private final ModelPart leftLeg2;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Cindaria_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.everything = this.root.getChild("everything");
        this.lowerBody = this.everything.getChild("lowerBody");
        this.upperBody = this.lowerBody.getChild("upperBody");
        this.head = this.upperBody.getChild("head");
        this.head2 = this.head.getChild("head2");
        this.rightHeadArm = this.head2.getChild("rightHeadArm");
        this.rightHeadArm2 = this.rightHeadArm.getChild("rightHeadArm2");
        this.rightHeadArm3 = this.rightHeadArm2.getChild("rightHeadArm3");
        this.leftHeadArm = this.head2.getChild("leftHeadArm");
        this.leftHeadArm2 = this.leftHeadArm.getChild("leftHeadArm2");
        this.leftHeadArm3 = this.leftHeadArm2.getChild("leftHeadArm3");
        this.rightArm = this.upperBody.getChild("rightArm");
        this.rightArm2 = this.rightArm.getChild("rightArm2");
        this.staff = this.rightArm2.getChild("staff");
        this.bone = this.staff.getChild("bone");
        this.leftArm = this.upperBody.getChild("leftArm");
        this.leftArm2 = this.leftArm.getChild("leftArm2");
        this.skirt = this.lowerBody.getChild("skirt");
        this.skirt2 = this.lowerBody.getChild("skirt2");
        this.rightLeg = this.everything.getChild("rightLeg");
        this.rightLeg2 = this.rightLeg.getChild("rightLeg2");
        this.leftLeg = this.everything.getChild("leftLeg");
        this.leftLeg2 = this.leftLeg.getChild("leftLeg2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition lowerBody = everything.addOrReplaceChild("lowerBody", CubeListBuilder.create().texOffs(64, 44).addBox(-4.0f, -4.0f, -2.0f, 8.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-20.0f, (float)0.0f));
        PartDefinition cube_r1 = lowerBody.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(64, 80).addBox(0.0f, 0.0f, -2.0f, 0.0f, 10.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition cube_r2 = lowerBody.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 80).addBox(0.0f, 0.0f, -2.0f, 0.0f, 10.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition cube_r3 = lowerBody.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(72, 0).addBox(-6.0f, 0.0f, 0.0f, 12.0f, 12.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)2.0f, (float)0.2182f, (float)0.0f, (float)0.0f));
        PartDefinition upperBody = lowerBody.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(72, 12).addBox(-3.5f, -10.0f, -2.0f, 7.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(16, 74).addBox(-3.0f, -4.0f, -2.0f, 6.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-4.0f, (float)0.0f));
        PartDefinition cube_r4 = upperBody.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(114, 123).addBox(-3.5f, 0.0f, 0.0f, 7.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-5.0f, (float)-2.0f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition cube_r5 = upperBody.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(114, 123).addBox(-3.5f, 0.0f, 0.0f, 7.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-7.0f, (float)-2.0f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition head = upperBody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(56, 52).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(64, 28).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.4f)), PartPose.offset((float)0.0f, (float)-10.0f, (float)0.0f));
        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(56, 68).addBox(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 4.0f, new CubeDeformation(0.1f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.0f, (float)4.0f, (float)0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0f, -9.0f, -9.0f, 18.0f, 10.0f, 18.0f, new CubeDeformation(0.0f)).texOffs(0, 28).addBox(-8.0f, -8.0f, -8.0f, 16.0f, 8.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(0, 52).addBox(-7.0f, 0.0f, -7.0f, 14.0f, 8.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-6.0f, (float)0.0f));
        PartDefinition rightHeadArm = head2.addOrReplaceChild("rightHeadArm", CubeListBuilder.create().texOffs(22, 94).addBox(-0.5f, 0.0f, -1.5f, 1.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-7.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.2182f));
        PartDefinition rightHeadArm2 = rightHeadArm.addOrReplaceChild("rightHeadArm2", CubeListBuilder.create().texOffs(42, 86).addBox(-0.5f, 0.0f, -2.0f, 1.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)8.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3927f));
        PartDefinition rightHeadArm3 = rightHeadArm2.addOrReplaceChild("rightHeadArm3", CubeListBuilder.create().texOffs(0, 86).addBox(-0.5f, 0.0f, -2.5f, 1.0f, 8.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)8.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.3491f));
        PartDefinition leftHeadArm = head2.addOrReplaceChild("leftHeadArm", CubeListBuilder.create().texOffs(94, 75).addBox(-0.5f, 0.0f, -1.5f, 1.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)7.5f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.2182f));
        PartDefinition leftHeadArm2 = leftHeadArm.addOrReplaceChild("leftHeadArm2", CubeListBuilder.create().texOffs(88, 44).addBox(-0.5f, 0.0f, -2.0f, 1.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)8.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3927f));
        PartDefinition leftHeadArm3 = leftHeadArm2.addOrReplaceChild("leftHeadArm3", CubeListBuilder.create().texOffs(30, 86).addBox(-0.5f, 0.0f, -2.5f, 1.0f, 8.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)8.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition rightArm = upperBody.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(88, 56).addBox(-1.0f, -1.0f, -1.5f, 2.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.5f, (float)-9.0f, (float)0.0f, (float)-0.3054f, (float)0.0f, (float)0.1745f));
        PartDefinition rightArm2 = rightArm.addOrReplaceChild("rightArm2", CubeListBuilder.create().texOffs(90, 87).addBox(-1.0f, 0.0f, -1.5f, 2.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)7.0f, (float)0.0f, (float)-2.3551f, (float)-0.0262f, (float)-0.0832f));
        PartDefinition staff = rightArm2.addOrReplaceChild("staff", CubeListBuilder.create().texOffs(180, 41).addBox(-1.0f, 4.0f, -1.0f, 2.0f, 4.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(152, 48).addBox(0.0f, -24.0f, -4.0f, 0.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(180, 33).addBox(-4.0f, -24.0f, 0.0f, 8.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(128, 33).addBox(0.0f, 6.0f, -6.0f, 0.0f, 15.0f, 12.0f, new CubeDeformation(0.0f)).texOffs(152, 33).addBox(-6.0f, 6.0f, 0.0f, 12.0f, 15.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(168, 48).addBox(-1.0f, -26.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(176, 33).addBox(-0.5f, -20.0f, -0.5f, 1.0f, 24.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(180, 47).addBox(-0.5f, -28.0f, -0.5f, 1.0f, 2.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)7.0f, (float)0.0f, (float)1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition bone = staff.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(128, 0).addBox(-9.5f, 0.0f, -9.5f, 19.0f, 14.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)0.0f));
        PartDefinition leftArm = upperBody.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(94, 12).addBox(-1.0f, -1.0f, -1.5f, 2.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.5f, (float)-9.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition leftArm2 = leftArm.addOrReplaceChild("leftArm2", CubeListBuilder.create().texOffs(12, 94).addBox(-1.0f, 0.0f, -1.5f, 2.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)7.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.3491f));
        PartDefinition skirt = lowerBody.addOrReplaceChild("skirt", CubeListBuilder.create().texOffs(0, 110).addBox(-7.0f, 0.0f, -5.0f, 14.0f, 8.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-2.5f, (float)0.0f));
        PartDefinition skirt2 = lowerBody.addOrReplaceChild("skirt2", CubeListBuilder.create().texOffs(55, 115).addBox(-4.5f, 0.0f, -2.5f, 9.0f, 8.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-2.0f, (float)0.0f));
        PartDefinition rightLeg = everything.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)-20.0f, (float)0.0f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition rightLeg2 = rightLeg.addOrReplaceChild("rightLeg2", CubeListBuilder.create().texOffs(16, 82).addBox(-1.5f, 0.0f, -2.0f, 3.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)8.0f, (float)0.0f, (float)1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition leftLeg = everything.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(36, 74).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-20.0f, (float)0.0f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition leftLeg2 = leftLeg.addOrReplaceChild("leftLeg2", CubeListBuilder.create().texOffs(80, 75).addBox(-1.5f, 0.0f, -2.0f, 3.0f, 8.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)8.0f, (float)0.0f, (float)0.2182f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)256, (int)256);
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

    public void setupAnim(Cindaria_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(Cindaria_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 1.5f);
        this.animate(entity.getAnimationState("idle"), Cindaria_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("magic1"), Cindaria_Animation.MAGIC, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("melee"), Cindaria_Animation.MELEE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Cindaria_Animation.DEATH, ageInTicks, 1.0f);
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot = xRot * ((float)Math.PI / 180);
        this.head.yRot = yRot * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }
}

