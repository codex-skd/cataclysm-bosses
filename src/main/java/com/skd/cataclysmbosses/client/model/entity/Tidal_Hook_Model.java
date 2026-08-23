/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.world.phys.Vec3
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.projectile.Tidal_Hook_Entity;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

public class Tidal_Hook_Model
extends AdvancedEntityModel<Tidal_Hook_Entity> {
    private final AdvancedModelBox body;
    private final AdvancedModelBox claw2;
    private final AdvancedModelBox claw4;
    private final AdvancedModelBox claw;
    private final AdvancedModelBox claw3;

    public Tidal_Hook_Model() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.body.setTextureOffset(0, 20).addBox(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.body.setTextureOffset(14, 0).addBox(-2.5f, 1.0f, -2.5f, 5.0f, 2.0f, 5.0f, 0.0f, false);
        this.body.setTextureOffset(0, 2).addBox(-2.75f, 1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 0.0f, false);
        this.body.setTextureOffset(0, 0).addBox(2.75f, 1.0f, -1.0f, 0.0f, 2.0f, 2.0f, 0.0f, false);
        this.body.setTextureOffset(4, 0).addBox(-1.0f, 1.0f, 2.75f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.body.setTextureOffset(0, 0).addBox(-1.0f, 1.0f, -2.75f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.claw2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw2.setRotationPoint(1.5f, 0.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.claw2);
        this.setRotationAngle(this.claw2, 0.0f, 0.0f, -0.7418f);
        this.claw2.setTextureOffset(19, 17).addBox(0.0f, -2.0f, -1.5f, 8.0f, 2.0f, 3.0f, 0.0f, false);
        this.claw4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw4.setRotationPoint(-1.5f, 0.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.claw4);
        this.setRotationAngle(this.claw4, 0.0f, 0.0f, 0.7418f);
        this.claw4.setTextureOffset(14, 10).addBox(-8.0f, -2.0f, -1.5f, 8.0f, 2.0f, 3.0f, 0.0f, false);
        this.claw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw.setRotationPoint(0.0f, 0.0f, 1.5f);
        this.body.addChild((BasicModelPart)this.claw);
        this.setRotationAngle(this.claw, 0.7418f, 0.0f, 0.0f);
        this.claw.setTextureOffset(0, 10).addBox(-1.5f, -2.0f, 0.0f, 3.0f, 2.0f, 8.0f, 0.0f, false);
        this.claw3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.claw3.setRotationPoint(0.0f, 0.0f, -1.5f);
        this.body.addChild((BasicModelPart)this.claw3);
        this.setRotationAngle(this.claw3, -0.7418f, 0.0f, 0.0f);
        this.claw3.setTextureOffset(0, 0).addBox(-1.5f, -2.0f, -8.0f, 3.0f, 2.0f, 8.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.body;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.body, (Object)this.claw, (Object)this.claw2, (Object)this.claw3, (Object)this.claw4);
    }

    public void setupAnim(Tidal_Hook_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public Vec3 getChainPosition(Vec3 offset, PoseStack transform) {
        this.body.translateAndRotate(transform);
        Vector4f vec = new Vector4f((float)offset.x, (float)offset.y, (float)offset.z, 1.0f);
        vec.mul((Matrix4fc)transform.last().pose());
        return new Vec3((double)vec.x(), (double)vec.y(), (double)vec.z());
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

