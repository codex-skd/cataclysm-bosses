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
package com.skd.thesundering.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Ceraunus_Item_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox anchor;
    private final AdvancedModelBox cube_r1;
    private final AdvancedModelBox cube_r2;
    private final AdvancedModelBox cube_r3;
    private final AdvancedModelBox cube_r4;
    private final AdvancedModelBox cube_r5;
    private final AdvancedModelBox cube_r6;
    private final AdvancedModelBox cube_r7;
    private final AdvancedModelBox cube_r8;
    private final AdvancedModelBox cube_r9;
    private final AdvancedModelBox cube_r10;
    private final AdvancedModelBox cube_r11;
    private final AdvancedModelBox cube_r12;
    private final AdvancedModelBox chain;
    private final AdvancedModelBox cube_r13;

    public Ceraunus_Item_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.anchor = new AdvancedModelBox((AdvancedEntityModel)this);
        this.anchor.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.anchor.setTextureOffset(0, 0).addBox(0.0f, -50.3f, -9.0f, 0.0f, 11.0f, 18.0f, 0.0f, false);
        this.anchor.setTextureOffset(79, 51).addBox(-1.0f, -45.3f, -3.0f, 2.0f, 6.0f, 6.0f, 0.0f, false);
        this.anchor.setTextureOffset(37, 19).addBox(-3.0f, -48.3f, 0.0f, 6.0f, 9.0f, 0.0f, 0.0f, false);
        this.anchor.setTextureOffset(0, 30).addBox(-2.0f, -35.3f, -3.0f, 4.0f, 32.0f, 6.0f, -0.01f, false);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r1.setRotationPoint(0.0f, -5.3f, 0.0f);
        this.anchor.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, -2.3562f, 0.0f, 0.0f);
        this.cube_r1.setTextureOffset(70, 0).addBox(-2.0f, -4.0f, -4.0f, 4.0f, 8.0f, 8.0f, 0.0f, false);
        this.cube_r2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r2.setRotationPoint(0.0f, -38.5f, 0.0f);
        this.anchor.addChild((BasicModelPart)this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.7854f, 0.0f, 0.0f);
        this.cube_r2.setTextureOffset(79, 38).addBox(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, 0.1f, false);
        this.cube_r3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r3.setRotationPoint(0.0f, -33.5732f, 15.6944f);
        this.anchor.addChild((BasicModelPart)this.cube_r3);
        this.setRotationAngle(this.cube_r3, -0.7418f, 0.0f, 0.0f);
        this.cube_r3.setTextureOffset(50, 38).addBox(-1.0f, -3.0f, -6.0f, 2.0f, 6.0f, 12.0f, 0.001f, false);
        this.cube_r4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r4.setRotationPoint(0.0f, -38.3f, 2.0f);
        this.anchor.addChild((BasicModelPart)this.cube_r4);
        this.setRotationAngle(this.cube_r4, -0.1309f, 0.0f, 0.0f);
        this.cube_r4.setTextureOffset(37, 0).addBox(-2.0f, -3.0f, -1.0f, 4.0f, 6.0f, 12.0f, 0.0f, false);
        this.cube_r5 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r5.setRotationPoint(0.0f, -33.5732f, -15.6944f);
        this.anchor.addChild((BasicModelPart)this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.7418f, 0.0f, 0.0f);
        this.cube_r5.setTextureOffset(50, 57).addBox(-1.0f, -3.0f, -6.0f, 2.0f, 6.0f, 12.0f, 0.001f, false);
        this.cube_r6 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r6.setRotationPoint(0.0f, -38.3f, -2.0f);
        this.anchor.addChild((BasicModelPart)this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.1309f, 0.0f, 0.0f);
        this.cube_r6.setTextureOffset(50, 19).addBox(-2.0f, -3.0f, -11.0f, 4.0f, 6.0f, 12.0f, 0.0f, false);
        this.cube_r7 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r7.setRotationPoint(0.0f, -34.7693f, 3.0963f);
        this.anchor.addChild((BasicModelPart)this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.3491f, 0.0f, 0.0f);
        this.cube_r7.setTextureOffset(67, 76).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, 0.0f, false);
        this.cube_r8 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r8.setRotationPoint(0.0f, -34.7693f, -3.0963f);
        this.anchor.addChild((BasicModelPart)this.cube_r8);
        this.setRotationAngle(this.cube_r8, -0.3491f, 0.0f, 0.0f);
        this.cube_r8.setTextureOffset(42, 76).addBox(-1.0f, -2.0f, -5.0f, 2.0f, 4.0f, 10.0f, 0.0f, false);
        this.cube_r9 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r9.setRotationPoint(0.0f, -27.0353f, 19.5093f);
        this.anchor.addChild((BasicModelPart)this.cube_r9);
        this.setRotationAngle(this.cube_r9, -0.1309f, 0.0f, 0.0f);
        this.cube_r9.setTextureOffset(83, 17).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, 0.0f, false);
        this.cube_r9.setTextureOffset(88, 64).addBox(-1.0f, 5.0f, -1.0f, 2.0f, 6.0f, 2.0f, 0.0f, false);
        this.cube_r9.setTextureOffset(0, 69).addBox(0.0f, 3.0f, -5.0f, 0.0f, 10.0f, 10.0f, 0.0f, false);
        this.cube_r10 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r10.setRotationPoint(0.0f, -27.0353f, -19.5093f);
        this.anchor.addChild((BasicModelPart)this.cube_r10);
        this.setRotationAngle(this.cube_r10, 0.1309f, 0.0f, 0.0f);
        this.cube_r10.setTextureOffset(79, 64).addBox(-1.0f, 5.0f, -1.0f, 2.0f, 6.0f, 2.0f, 0.0f, false);
        this.cube_r11 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r11.setRotationPoint(0.0f, -19.1037f, -18.4651f);
        this.anchor.addChild((BasicModelPart)this.cube_r11);
        this.setRotationAngle(this.cube_r11, 0.1309f, 0.0f, 0.0f);
        this.cube_r11.setTextureOffset(21, 59).addBox(0.0f, -5.0f, -5.0f, 0.0f, 10.0f, 10.0f, 0.0f, false);
        this.cube_r12 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r12.setRotationPoint(0.0f, -27.0353f, -19.5093f);
        this.anchor.addChild((BasicModelPart)this.cube_r12);
        this.setRotationAngle(this.cube_r12, 0.1309f, 0.0f, 0.0f);
        this.cube_r12.setTextureOffset(21, 80).addBox(-1.0f, -5.0f, -2.0f, 2.0f, 10.0f, 4.0f, 0.0f, false);
        this.chain = new AdvancedModelBox((AdvancedEntityModel)this);
        this.chain.setRotationPoint(0.0f, 8.3f, 0.0f);
        this.anchor.addChild((BasicModelPart)this.chain);
        this.cube_r13 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r13.setRotationPoint(-1.0f, -10.6f, 0.0f);
        this.chain.addChild((BasicModelPart)this.cube_r13);
        this.setRotationAngle(this.cube_r13, -2.3562f, 0.0f, 0.0f);
        this.cube_r13.setTextureOffset(21, 30).addBox(1.0f, -10.0f, -4.0f, 0.0f, 14.0f, 14.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.anchor, (Object)this.cube_r1, (Object)this.cube_r2, (Object)this.cube_r3, (Object)this.cube_r4, (Object)this.cube_r5, (Object)this.cube_r6, (Object)this.cube_r7, (Object)this.cube_r8, (Object)this.cube_r9, (Object)this.cube_r10, (Object)this.cube_r11, (Object[])new AdvancedModelBox[]{this.cube_r12, this.chain, this.cube_r13});
    }

    public BasicModelPart root() {
        return this.anchor;
    }
}

