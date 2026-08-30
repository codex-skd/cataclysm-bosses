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
package com.skd.cataclysmbosses.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Cursed_Bow_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox bow;
    private final AdvancedModelBox arm1;
    private final AdvancedModelBox arm2;
    private final AdvancedModelBox bow_string;
    private final AdvancedModelBox string;
    private final AdvancedModelBox string2;
    private final AdvancedModelBox arrow;
    private final AdvancedModelBox arrow_pivot1;
    private final AdvancedModelBox arrow2;
    private final AdvancedModelBox arrow_pivot2;
    private final AdvancedModelBox arrow3;
    private final AdvancedModelBox arrow_pivot3;

    public Cursed_Bow_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.bow = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bow.setRotationPoint(5.0E-4f, -17.0644f, -6.2737f);
        this.root.addChild((BasicModelPart)this.bow);
        this.bow.setTextureOffset(26, 49).addBox(-1.0f, -11.4356f, -1.2263f, 2.0f, 18.0f, 3.0f, 0.0f, false);
        this.bow.setTextureOffset(0, 0).addBox(0.0f, -8.4356f, -9.2263f, 0.0f, 12.0f, 8.0f, 0.0f, false);
        this.arm1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arm1.setRotationPoint(-5.0E-4f, -7.5162f, -0.7263f);
        this.bow.addChild((BasicModelPart)this.arm1);
        this.setRotationAngle(this.arm1, -0.5672f, 0.0f, 0.0f);
        this.arm1.setTextureOffset(43, 22).addBox(-2.4995f, -15.6119f, -3.9929f, 5.0f, 18.0f, 4.0f, 0.0f, false);
        this.arm1.setTextureOffset(38, 45).addBox(5.0E-4f, -22.846f, -2.9929f, 0.0f, 23.0f, 5.0f, 0.0f, false);
        this.arm2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arm2.setRotationPoint(-5.0E-4f, 2.6838f, -1.0263f);
        this.bow.addChild((BasicModelPart)this.arm2);
        this.setRotationAngle(this.arm2, 0.5672f, 0.0f, 0.0f);
        this.arm2.setTextureOffset(0, 49).addBox(5.0E-4f, -0.0933f, -2.6868f, 0.0f, 23.0f, 5.0f, 0.0f, false);
        this.arm2.setTextureOffset(11, 49).addBox(-1.4995f, -2.0933f, -3.6868f, 3.0f, 18.0f, 4.0f, 0.0f, false);
        this.bow_string = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bow_string.setRotationPoint(-5.0E-4f, -1.5f, 10.0f);
        this.bow.addChild((BasicModelPart)this.bow_string);
        this.string = new AdvancedModelBox((AdvancedEntityModel)this);
        this.string.setRotationPoint(0.5005f, 0.0f, 0.0f);
        this.bow_string.addChild((BasicModelPart)this.string);
        this.string.setTextureOffset(0, 22).addBox(-1.001f, 0.0859f, -0.2263f, 1.0f, 19.0f, 0.0f, 0.0f, false);
        this.string2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.string2.setRotationPoint(-0.4995f, 0.0f, -0.0485f);
        this.bow_string.addChild((BasicModelPart)this.string2);
        this.string2.setTextureOffset(17, 0).addBox(-0.001f, -18.9142f, -0.1778f, 1.0f, 19.0f, 0.0f, 0.0f, false);
        this.arrow = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow.setRotationPoint(0.3536f, -1.4356f, 0.2737f);
        this.bow_string.addChild((BasicModelPart)this.arrow);
        this.setRotationAngle(this.arrow, -0.0436f, 0.0f, 0.0f);
        this.arrow_pivot1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow_pivot1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.arrow.addChild((BasicModelPart)this.arrow_pivot1);
        this.setRotationAngle(this.arrow_pivot1, 0.0f, 0.0f, -0.7854f);
        this.arrow_pivot1.setTextureOffset(0, 0).addBox(-3.0f, 0.0f, -20.0f, 5.0f, 0.0f, 21.0f, 0.0f, false);
        this.arrow_pivot1.setTextureOffset(0, 22).addBox(-0.5f, -2.5f, -20.0f, 0.0f, 5.0f, 21.0f, 0.0f, false);
        this.arrow_pivot1.setTextureOffset(3, 22).addBox(-3.0f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, 0.0f, false);
        this.arrow2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow2.setRotationPoint(0.3536f, -1.4356f, 0.2737f);
        this.bow_string.addChild((BasicModelPart)this.arrow2);
        this.setRotationAngle(this.arrow2, 0.0873f, 0.0873f, 0.0f);
        this.arrow_pivot2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow_pivot2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.arrow2.addChild((BasicModelPart)this.arrow_pivot2);
        this.setRotationAngle(this.arrow_pivot2, 0.0f, 0.0f, -0.7854f);
        this.arrow_pivot2.setTextureOffset(0, 0).addBox(-3.0f, 0.0f, -20.0f, 5.0f, 0.0f, 21.0f, 0.0f, false);
        this.arrow_pivot2.setTextureOffset(0, 22).addBox(-0.5f, -2.5f, -20.0f, 0.0f, 5.0f, 21.0f, 0.0f, false);
        this.arrow_pivot2.setTextureOffset(3, 22).addBox(-3.0f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, 0.0f, false);
        this.arrow3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow3.setRotationPoint(0.3536f, -1.4356f, 0.2737f);
        this.bow_string.addChild((BasicModelPart)this.arrow3);
        this.setRotationAngle(this.arrow3, 0.0873f, -0.0873f, 0.0f);
        this.arrow_pivot3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow_pivot3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.arrow3.addChild((BasicModelPart)this.arrow_pivot3);
        this.setRotationAngle(this.arrow_pivot3, 0.0f, 0.0f, -0.7854f);
        this.arrow_pivot3.setTextureOffset(0, 0).addBox(-3.0f, 0.0f, -20.0f, 5.0f, 0.0f, 21.0f, 0.0f, false);
        this.arrow_pivot3.setTextureOffset(0, 22).addBox(-0.5f, -2.5f, -20.0f, 0.0f, 5.0f, 21.0f, 0.0f, false);
        this.arrow_pivot3.setTextureOffset(3, 22).addBox(-3.0f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }

    public void setupAnim(Entity entity, float pullAmount, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
        this.bow_string.rotationPointZ += pullAmount * 9.0f;
        float scale = pullAmount * 1.2f;
        this.arrow_pivot1.setScale(scale, scale, scale);
        this.arrow_pivot2.setScale(scale, scale, scale);
        this.arrow_pivot3.setScale(scale, scale, scale);
        this.string2.rotateAngleX += (float)Math.toRadians(pullAmount * 25.0f);
        this.string.rotateAngleX += (float)Math.toRadians(pullAmount * -25.0f);
        this.arm1.rotateAngleX += (float)Math.toRadians(pullAmount * -15.0f);
        this.arm2.rotateAngleX += (float)Math.toRadians(pullAmount * 15.0f);
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.root, this.bow_string, this.bow, this.arm1, this.arm2, this.string, this.string2, this.arrow, this.arrow2, this.arrow3, this.arrow_pivot1, this.arrow_pivot2, (Object[])new AdvancedModelBox[]{this.arrow_pivot3});
    }

    public BasicModelPart root() {
        return this.root;
    }
}

