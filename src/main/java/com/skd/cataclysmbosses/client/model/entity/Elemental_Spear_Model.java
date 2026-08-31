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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Elemental_Spear_Animation;
import com.skd.cataclysmbosses.entity.projectile.Elemental_Spear_Entity;
import com.skd.cataclysmbosses.client.model.compat.CmHierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Elemental_Spear_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState> {
    private final ModelPart root;
    private final ModelPart rot;

    public Elemental_Spear_Model(ModelPart root) {
        super(root);
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

            @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
    }
}
