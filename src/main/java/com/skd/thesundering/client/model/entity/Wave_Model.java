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

import com.skd.thesundering.client.animation.Wave_Animation;
import com.skd.thesundering.entity.effect.Wave_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Wave_Model
extends HierarchicalModel<Wave_Entity> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart projectile;

    public Wave_Model(ModelPart root) {
        this.root = root;
        this.everything = this.root.getChild("everything");
        this.projectile = this.everything.getChild("projectile");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition projectile = root.addOrReplaceChild("projectile", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0f, -44.5f, -9.0f, 32.0f, 45.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(1, 61).addBox(-16.0f, -44.5f, 6.0f, 32.0f, 27.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)2.5f, (float)1.0f, (float)0.3927f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(Wave_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.getAnimationState("spawn"), Wave_Animation.SPAWN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("idle"), Wave_Animation.LOOP, ageInTicks, 0.75f);
        this.animate(entity.getAnimationState("despawn"), Wave_Animation.END, ageInTicks, 1.0f);
    }

    public ModelPart root() {
        return this.root;
    }
}

