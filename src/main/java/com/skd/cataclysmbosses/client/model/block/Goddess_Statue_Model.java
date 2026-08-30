/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.world.entity.Entity
 */
package com.skd.cataclysmbosses.client.model.block;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Goddess_Statue_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox body;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox cube_r3;
    private final AdvancedModelBox cube_r4;
    private final AdvancedModelBox cube_r5;
    private final AdvancedModelBox r_leg;
    private final AdvancedModelBox l_leg;
    private final AdvancedModelBox head;
    private final AdvancedModelBox helmet;
    private final AdvancedModelBox cube_r6;
    private final AdvancedModelBox cube_r7;
    private final AdvancedModelBox cube_r8;
    private final AdvancedModelBox hair;
    private final AdvancedModelBox cube_r9;
    private final AdvancedModelBox cube_r10;
    private final AdvancedModelBox cube_r11;
    private final AdvancedModelBox cube_r12;
    private final AdvancedModelBox cube_r13;

    public Goddess_Statue_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(-2.5f, -15.0f, 3.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.body.setTextureOffset(54, 66).addBox(-1.0f, -9.0f, -5.0f, 7.0f, 7.0f, 6.0f, 0.0f, false);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(2.5f, 1.229f, 3.2595f);
        this.body.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0611f, 0.0f, 0.0f);
        this.cube_r1.setTextureOffset(54, 79).addBox(-5.5f, 0.05f, 0.1f, 11.0f, 14.0f, 0.0f, 0.0f, false);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(3.0f, -1.8467f, -5.5308f);
        this.body.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.0873f, 0.0f, 0.0f);
        this.cube_r2.setTextureOffset(74, 0).addBox(-6.0f, 0.0f, 0.0f, 11.0f, 17.0f, 0.0f, 0.0f, false);
        this.cube_r3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.2182f, 0.0f, 0.0f);
        this.cube_r3.setTextureOffset(36, 0).addBox(-3.0f, -5.0f, -5.0f, 11.0f, 7.0f, 8.0f, 0.0f, false);
        this.cube_r4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r4.setRotationPoint(-1.0f, -12.1f, -4.0f);
        this.body.addChild((BasicModelPart)this.cube_r4);
        this.setRotationAngle(this.cube_r4, -0.8727f, 0.0f, 0.0f);
        this.cube_r4.setTextureOffset(74, 17).addBox(-1.0f, -3.0f, -3.0f, 9.0f, 6.0f, 4.0f, 0.0f, false);
        this.cube_r5 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r5.setRotationPoint(-2.0f, -13.0f, -2.0f);
        this.body.addChild((BasicModelPart)this.cube_r5);
        this.setRotationAngle(this.cube_r5, -0.1745f, 0.0f, 0.0f);
        this.cube_r5.setTextureOffset(26, 56).addBox(-3.0f, -4.0f, -1.0f, 15.0f, 5.0f, 5.0f, 0.0f, false);
        this.cube_r5.setTextureOffset(41, 16).addBox(0.0f, -4.0f, -3.0f, 9.0f, 9.0f, 7.0f, 0.005f, false);
        this.r_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.r_leg.setRotationPoint(-3.0f, -15.0f, 3.0f);
        this.root.addChild((BasicModelPart)this.r_leg);
        this.setRotationAngle(this.r_leg, 0.0037f, -0.089f, -0.0836f);
        this.r_leg.setTextureOffset(40, 32).addBox(-4.5f, -2.0f, -5.0f, 6.0f, 17.0f, 7.0f, 0.0f, false);
        this.l_leg = new AdvancedModelBox((AdvancedEntityModel)this);
        this.l_leg.setRotationPoint(3.0f, -15.0f, 3.0f);
        this.root.addChild((BasicModelPart)this.l_leg);
        this.setRotationAngle(this.l_leg, 0.0106f, 0.0375f, 0.0926f);
        this.l_leg.setTextureOffset(0, 54).addBox(-1.5f, -2.0f, -5.0f, 6.0f, 17.0f, 7.0f, 0.0f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -34.0f, 3.0f);
        this.root.addChild((BasicModelPart)this.head);
        this.head.setTextureOffset(76, 79).addBox(-2.0f, -3.0f, -2.5f, 4.0f, 6.0f, 4.0f, 0.0f, false);
        this.helmet = new AdvancedModelBox((AdvancedEntityModel)this);
        this.helmet.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.addChild((BasicModelPart)this.helmet);
        this.helmet.setTextureOffset(66, 32).addBox(-3.0f, -8.0f, -5.0f, 6.0f, 8.0f, 7.0f, 0.0f, false);
        this.cube_r6 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r6.setRotationPoint(3.5f, -5.0f, -3.9f);
        this.helmet.addChild((BasicModelPart)this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0504f, 0.523f, 0.0252f);
        this.cube_r6.setTextureOffset(38, 80).addBox(0.0f, -3.9706f, 0.0281f, 0.0f, 8.0f, 6.0f, 0.005f, false);
        this.cube_r7 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r7.setRotationPoint(-3.5f, -5.0f, -3.9f);
        this.helmet.addChild((BasicModelPart)this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0517f, -0.5666f, -0.0278f);
        this.cube_r7.setTextureOffset(26, 80).addBox(0.0f, -3.9706f, 0.0281f, 0.0f, 8.0f, 6.0f, 0.005f, false);
        this.cube_r8 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r8.setRotationPoint(0.0f, -8.0f, -3.0f);
        this.helmet.addChild((BasicModelPart)this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0436f, 0.0f, 0.0f);
        this.cube_r8.setTextureOffset(0, 78).addBox(-3.5f, 1.0f, -3.0f, 7.0f, 7.0f, 6.0f, 0.005f, false);
        this.hair = new AdvancedModelBox((AdvancedEntityModel)this);
        this.hair.setRotationPoint(-7.0f, 11.0f, 3.0f);
        this.head.addChild((BasicModelPart)this.hair);
        this.cube_r9 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r9.setRotationPoint(-2.0793f, -0.0236f, 5.4038f);
        this.hair.addChild((BasicModelPart)this.cube_r9);
        this.setRotationAngle(this.cube_r9, 0.0854f, -0.0189f, -0.0011f);
        this.cube_r9.setTextureOffset(106, 5).addBox(-4.9983f, -8.3334f, -0.0112f, 5.0f, 16.0f, 0.0f, 0.0f, false);
        this.cube_r10 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r10.setRotationPoint(5.0f, -6.0f, 1.0f);
        this.hair.addChild((BasicModelPart)this.cube_r10);
        this.setRotationAngle(this.cube_r10, 0.0854f, -0.0189f, -0.0011f);
        this.cube_r10.setTextureOffset(0, 0).addBox(-7.0f, -5.0f, -1.0f, 13.0f, 24.0f, 5.0f, 0.0f, false);
        this.cube_r11 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r11.setRotationPoint(7.25f, 5.0f, 2.0f);
        this.hair.addChild((BasicModelPart)this.cube_r11);
        this.setRotationAngle(this.cube_r11, -0.2606f, -0.028f, -0.7372f);
        this.cube_r11.setTextureOffset(92, 27).addBox(4.2194f, 3.0464f, -1.0664f, 4.0f, 15.0f, 0.0f, 0.0f, false);
        this.cube_r11.setTextureOffset(0, 29).addBox(-7.7806f, 1.0464f, -1.0664f, 12.0f, 17.0f, 8.0f, 0.0f, false);
        this.cube_r12 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r12.setRotationPoint(2.0f, -10.0f, -5.0f);
        this.hair.addChild((BasicModelPart)this.cube_r12);
        this.setRotationAngle(this.cube_r12, 0.1265f, 0.0338f, -0.2597f);
        this.cube_r12.setTextureOffset(26, 66).addBox(-3.0f, -1.0f, -4.0f, 5.0f, 5.0f, 9.0f, 0.0f, false);
        this.cube_r13 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r13.setRotationPoint(8.25f, -16.5f, -1.0f);
        this.hair.addChild((BasicModelPart)this.cube_r13);
        this.setRotationAngle(this.cube_r13, 0.3853f, -0.1193f, 0.0443f);
        this.cube_r13.setTextureOffset(66, 47).addBox(-5.5593f, -0.341f, -3.4177f, 8.0f, 10.0f, 5.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.body, this.cube_r1, this.cube_r2, this.cube_r3, this.cube_r4, this.cube_r5, this.r_leg, this.l_leg, this.head, this.helmet, this.cube_r6, (Object[])new AdvancedModelBox[]{this.cube_r7, this.cube_r8, this.hair, this.cube_r9, this.cube_r10, this.cube_r11, this.cube_r12, this.cube_r13});
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

