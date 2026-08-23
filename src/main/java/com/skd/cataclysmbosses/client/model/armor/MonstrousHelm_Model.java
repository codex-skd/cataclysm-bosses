/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class MonstrousHelm_Model
extends HumanoidModel {
    public ModelPart helmet;

    public MonstrousHelm_Model(ModelPart p_170677_) {
        super(p_170677_);
        this.helmet = p_170677_.getChild("head").getChild("helmet");
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh((CubeDeformation)deformation, (float)0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -9.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.6f)), PartPose.offset((float)0.0f, (float)1.0f, (float)0.0f));
        helmet.addOrReplaceChild("lefthorn", CubeListBuilder.create().texOffs(0, 28).addBox(4.0f, -6.0f, -3.0f, 2.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).texOffs(0, 16).addBox(6.0f, -9.0f, -3.0f, 3.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        helmet.addOrReplaceChild("righthorn", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-6.0f, -6.0f, -3.0f, 2.0f, 3.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 16).mirror().addBox(-9.0f, -9.0f, -3.0f, 3.0f, 6.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
    }
}

