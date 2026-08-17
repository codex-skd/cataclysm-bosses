/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 */
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.client.animation.Elemental_Spear_Animation;
import com.skd.thesundering.entity.projectile.Elemental_Spear_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Elemental_Spear_Model
extends HierarchicalModel<Elemental_Spear_Entity> {
    private final ModelPart root;
    private final ModelPart rot;

    public Elemental_Spear_Model(ModelPart root) {
        this.root = root.getChild("root");
        this.rot = this.root.getChild("rot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-4.0f, (float)0.0f));
        PartDefinition rot = root.addOrReplaceChild("rot", CubeListBuilder.create().texOffs(0, -64).addBox(0.0f, -7.5f, -23.0f, 0.0f, 15.0f, 64.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition root_r1 = rot.addOrReplaceChild("root_r1", CubeListBuilder.create().texOffs(0, -64).addBox(0.0f, -7.5f, -23.0f, 0.0f, 15.0f, 64.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.5708f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Elemental_Spear_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.root.yRot = netHeadYaw * ((float)Math.PI / 180);
        this.root.xRot = headPitch * ((float)Math.PI / 180);
        this.animate(entity.getAnimationState("idle"), Elemental_Spear_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("spawn"), Elemental_Spear_Animation.SPAWN, ageInTicks, 1.0f);
    }

    public void setupAnim(float yRot, float xRot) {
    }

    public ModelPart root() {
        return this.root;
    }
}

