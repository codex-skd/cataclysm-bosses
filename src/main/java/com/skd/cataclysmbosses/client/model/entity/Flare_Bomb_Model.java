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
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.projectile.Flare_Bomb_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.phys.Vec3;

public class Flare_Bomb_Model
extends HierarchicalModel<Flare_Bomb_Entity> {
    private final ModelPart root;
    private final ModelPart outer;
    private final ModelPart inner;

    public Flare_Bomb_Model(ModelPart root) {
        this.root = root.getChild("root");
        this.outer = this.root.getChild("outer");
        this.inner = this.root.getChild("inner");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)4.0f, (float)0.0f));
        PartDefinition outer = root.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition inner = root.addOrReplaceChild("inner", CubeListBuilder.create().texOffs(0, 33).addBox(-4.5f, -4.5f, -4.5f, 9.0f, 9.0f, 9.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Flare_Bomb_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float delta = ageInTicks - (float)entity.tickCount;
        this.root().getAllParts().forEach(ModelPart::resetPose);
        Vec3 prevV = new Vec3(entity.prevDeltaMovementX, entity.prevDeltaMovementY, entity.prevDeltaMovementZ);
        Vec3 dv = prevV.add(entity.getDeltaMovement().subtract(prevV).scale((double)delta));
        double d = Math.sqrt(dv.x * dv.x + dv.y * dv.y + dv.z * dv.z);
        if (d != 0.0) {
            double a = dv.y / d;
            a = Math.max(-10.0, Math.min(1.0, a));
            float pitch = -((float)Math.asin(a));
            this.root.xRot = pitch + 1.5707964f;
        }
        this.inner.yRot = ageInTicks * 20.0f * ((float)Math.PI / 180);
        this.inner.xRot = ageInTicks * 20.0f * ((float)Math.PI / 180);
        this.inner.zRot = ageInTicks * 20.0f * ((float)Math.PI / 180);
        this.outer.yRot = ageInTicks * -10.0f * ((float)Math.PI / 180);
        this.outer.xRot = ageInTicks * -10.0f * ((float)Math.PI / 180);
        this.outer.zRot = ageInTicks * -10.0f * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }
}

