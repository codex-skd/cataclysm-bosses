/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemStack
 */
package com.skd.thesundering.client.model.item;

import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class Wrath_of_Desert_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox bow;
    private final AdvancedModelBox bow_r1;
    private final AdvancedModelBox arm1;
    private final AdvancedModelBox cube_r8_r1;
    private final AdvancedModelBox arm2;
    private final AdvancedModelBox bow_string;
    private final AdvancedModelBox string;
    private final AdvancedModelBox string2;
    private final AdvancedModelBox arrow3;
    private final AdvancedModelBox arrow_pivot3;
    private final AdvancedModelBox third_sand3;
    private final AdvancedModelBox third_sand2;
    private final AdvancedModelBox third_sand1;
    private final AdvancedModelBox arrow2;
    private final AdvancedModelBox arrow_pivot2;
    private final AdvancedModelBox second_sand3;
    private final AdvancedModelBox second_sand2;
    private final AdvancedModelBox second_sand1;
    private final AdvancedModelBox arrow1;
    private final AdvancedModelBox arrow_pivot1;
    private final AdvancedModelBox first_sand3;
    private final AdvancedModelBox first_sand2;
    private final AdvancedModelBox first_sand1;

    public Wrath_of_Desert_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.bow = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bow.setRotationPoint(5.0E-4f, -17.0644f, -6.2737f);
        this.root.addChild((BasicModelPart)this.bow);
        this.bow.setTextureOffset(26, 49).addBox(-1.0f, -11.4356f, -1.2263f, 2.0f, 18.0f, 3.0f, 0.0f, false);
        this.bow.setTextureOffset(36, 91).addBox(0.0f, -11.4356f, 1.7737f, 0.0f, 19.0f, 2.0f, 0.0f, false);
        this.bow.setTextureOffset(0, 0).addBox(0.0f, -8.4356f, -9.2263f, 0.0f, 12.0f, 8.0f, 0.0f, false);
        this.bow_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.bow_r1.setRotationPoint(-1.5f, -2.4356f, 0.2737f);
        this.bow.addChild((BasicModelPart)this.bow_r1);
        this.setRotationAngle(this.bow_r1, -0.7854f, 0.0f, 0.0f);
        this.bow_r1.setTextureOffset(36, 83).addBox(-0.5f, -2.5f, -2.5f, 1.0f, 5.0f, 5.0f, 0.0f, false);
        this.bow_r1.setTextureOffset(36, 73).addBox(2.5f, -2.5f, -2.5f, 1.0f, 5.0f, 5.0f, 0.0f, false);
        this.arm1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arm1.setRotationPoint(-5.0E-4f, -7.5162f, -0.7263f);
        this.bow.addChild((BasicModelPart)this.arm1);
        this.setRotationAngle(this.arm1, -0.5672f, 0.0f, 0.0f);
        this.arm1.setTextureOffset(43, 22).addBox(-2.4995f, -15.6119f, -3.9929f, 5.0f, 18.0f, 4.0f, 0.0f, false);
        this.arm1.setTextureOffset(47, 8).addBox(-2.4995f, -0.6119f, -11.9929f, 5.0f, 6.0f, 8.0f, 0.0f, false);
        this.arm1.setTextureOffset(61, 39).addBox(2.5005f, -15.6119f, -3.9929f, 5.0f, 3.0f, 2.0f, 0.0f, false);
        this.arm1.setTextureOffset(65, 44).addBox(2.5005f, -10.6119f, -3.9929f, 4.0f, 2.0f, 1.0f, 0.0f, false);
        this.arm1.setTextureOffset(65, 47).addBox(-6.4995f, -10.6119f, -3.9929f, 4.0f, 2.0f, 1.0f, 0.0f, false);
        this.arm1.setTextureOffset(61, 34).addBox(-7.4995f, -15.6119f, -3.9929f, 5.0f, 3.0f, 2.0f, 0.0f, false);
        this.arm1.setTextureOffset(38, 45).addBox(5.0E-4f, -22.846f, -2.9929f, 0.0f, 23.0f, 5.0f, 0.0f, false);
        this.cube_r8_r1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.cube_r8_r1.setRotationPoint(5.0E-4f, -11.1119f, -4.4929f);
        this.arm1.addChild((BasicModelPart)this.cube_r8_r1);
        this.setRotationAngle(this.cube_r8_r1, 0.0f, 0.0f, 0.7854f);
        this.cube_r8_r1.setTextureOffset(61, 28).addBox(-2.5f, -2.5f, -0.5f, 5.0f, 5.0f, 1.0f, 0.0f, false);
        this.arm2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arm2.setRotationPoint(-5.0E-4f, 2.6838f, -1.0263f);
        this.bow.addChild((BasicModelPart)this.arm2);
        this.setRotationAngle(this.arm2, 0.5672f, 0.0f, 0.0f);
        this.arm2.setTextureOffset(0, 49).addBox(5.0E-4f, -0.0933f, -2.6868f, 0.0f, 23.0f, 5.0f, 0.0f, false);
        this.arm2.setTextureOffset(11, 49).addBox(-1.4995f, -2.0933f, -3.6868f, 3.0f, 18.0f, 4.0f, 0.0f, false);
        this.arm2.setTextureOffset(73, 11).addBox(-1.4995f, -4.0933f, -10.6868f, 3.0f, 4.0f, 7.0f, 0.0f, false);
        this.arm2.setTextureOffset(11, 77).addBox(-1.4995f, 3.9067f, -3.6868f, 3.0f, 4.0f, 4.0f, 0.3f, false);
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
        this.arrow1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow1.setRotationPoint(0.3536f, -1.4356f, 0.2737f);
        this.bow_string.addChild((BasicModelPart)this.arrow1);
        this.setRotationAngle(this.arrow1, -0.0436f, 0.0f, 0.0f);
        this.arrow_pivot1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.arrow_pivot1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.arrow1.addChild((BasicModelPart)this.arrow_pivot1);
        this.setRotationAngle(this.arrow_pivot1, 0.0f, 0.0f, -0.7854f);
        this.arrow_pivot1.setTextureOffset(0, 0).addBox(-3.0f, 0.0f, -20.0f, 5.0f, 0.0f, 21.0f, 0.0f, false);
        this.arrow_pivot1.setTextureOffset(0, 22).addBox(-0.5f, -2.5f, -20.0f, 0.0f, 5.0f, 21.0f, 0.0f, false);
        this.arrow_pivot1.setTextureOffset(3, 22).addBox(-3.0f, -2.5f, 0.0f, 5.0f, 5.0f, 0.0f, 0.0f, false);
        this.first_sand3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.first_sand3.setRotationPoint(-0.5f, 0.0f, -12.0f);
        this.arrow_pivot1.addChild((BasicModelPart)this.first_sand3);
        this.setRotationAngle(this.first_sand3, 0.0f, 0.0f, -1.0036f);
        this.first_sand3.setTextureOffset(0, 107).addBox(-1.5f, -1.5f, -1.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.first_sand2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.first_sand2.setRotationPoint(0.0f, 0.0f, -3.0f);
        this.first_sand3.addChild((BasicModelPart)this.first_sand2);
        this.setRotationAngle(this.first_sand2, 0.0f, 0.0f, -0.48f);
        this.first_sand2.setTextureOffset(0, 112).addBox(-2.5f, -2.5f, -1.0f, 5.0f, 5.0f, 2.0f, 0.0f, false);
        this.first_sand1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.first_sand1.setRotationPoint(0.0f, 0.0f, -4.0f);
        this.first_sand2.addChild((BasicModelPart)this.first_sand1);
        this.first_sand1.setTextureOffset(0, 119).addBox(-3.5f, -3.5f, 0.0f, 7.0f, 7.0f, 2.0f, 0.0f, false);
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
        this.second_sand3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.second_sand3.setRotationPoint(-0.5f, 0.0f, -12.0f);
        this.arrow_pivot2.addChild((BasicModelPart)this.second_sand3);
        this.setRotationAngle(this.second_sand3, 0.0f, 0.0f, -1.0036f);
        this.second_sand3.setTextureOffset(0, 107).addBox(-1.5f, -1.5f, -1.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.second_sand2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.second_sand2.setRotationPoint(0.0f, 0.0f, -3.0f);
        this.second_sand3.addChild((BasicModelPart)this.second_sand2);
        this.setRotationAngle(this.second_sand2, 0.0f, 0.0f, -0.48f);
        this.second_sand2.setTextureOffset(0, 112).addBox(-2.5f, -2.5f, -1.0f, 5.0f, 5.0f, 2.0f, 0.0f, false);
        this.second_sand1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.second_sand1.setRotationPoint(0.0f, 0.0f, -4.0f);
        this.second_sand2.addChild((BasicModelPart)this.second_sand1);
        this.second_sand1.setTextureOffset(0, 119).addBox(-3.5f, -3.5f, 0.0f, 7.0f, 7.0f, 2.0f, 0.0f, false);
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
        this.third_sand3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.third_sand3.setRotationPoint(-0.5f, 0.0f, -12.0f);
        this.arrow_pivot3.addChild((BasicModelPart)this.third_sand3);
        this.setRotationAngle(this.third_sand3, 0.0f, 0.0f, -1.0036f);
        this.third_sand3.setTextureOffset(0, 107).addBox(-1.5f, -1.5f, -1.0f, 3.0f, 3.0f, 2.0f, 0.0f, false);
        this.third_sand2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.third_sand2.setRotationPoint(0.0f, 0.0f, -3.0f);
        this.third_sand3.addChild((BasicModelPart)this.third_sand2);
        this.setRotationAngle(this.third_sand2, 0.0f, 0.0f, -0.48f);
        this.third_sand2.setTextureOffset(0, 112).addBox(-2.5f, -2.5f, -1.0f, 5.0f, 5.0f, 2.0f, 0.0f, false);
        this.third_sand1 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.third_sand1.setRotationPoint(0.0f, 0.0f, -4.0f);
        this.third_sand2.addChild((BasicModelPart)this.third_sand1);
        this.third_sand1.setTextureOffset(0, 119).addBox(-3.5f, -3.5f, 0.0f, 7.0f, 7.0f, 2.0f, 0.0f, false);
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
        this.first_sand3.setScale(scale, scale, scale);
        this.second_sand3.setScale(scale, scale, scale);
        this.third_sand3.setScale(scale, scale, scale);
        this.first_sand2.setScale(scale, scale, scale);
        this.second_sand2.setScale(scale, scale, scale);
        this.third_sand2.setScale(scale, scale, scale);
        this.first_sand1.setScale(scale, scale, scale);
        this.second_sand1.setScale(scale, scale, scale);
        this.third_sand1.setScale(scale, scale, scale);
        this.string2.rotateAngleX += (float)Math.toRadians(pullAmount * 25.0f);
        this.string.rotateAngleX += (float)Math.toRadians(pullAmount * -25.0f);
        this.arm1.rotateAngleX += (float)Math.toRadians(pullAmount * -15.0f);
        this.arm2.rotateAngleX += (float)Math.toRadians(pullAmount * 15.0f);
        this.first_sand3.rotateAngleZ += ageInTicks * 0.7f;
        AdvancedModelBox advancedModelBox = this.first_sand2;
        advancedModelBox.rotateAngleZ = advancedModelBox.rotateAngleZ + (-this.first_sand3.rotateAngleZ + ageInTicks * 0.5f);
        advancedModelBox = this.first_sand1;
        advancedModelBox.rotateAngleZ = advancedModelBox.rotateAngleZ + (-this.first_sand3.rotateAngleZ - this.first_sand2.rotateAngleZ + ageInTicks * 0.3f);
        this.second_sand3.rotateAngleZ += ageInTicks * 0.7f;
        advancedModelBox = this.second_sand2;
        advancedModelBox.rotateAngleZ = advancedModelBox.rotateAngleZ + (-this.second_sand3.rotateAngleZ + ageInTicks * 0.5f);
        advancedModelBox = this.second_sand1;
        advancedModelBox.rotateAngleZ = advancedModelBox.rotateAngleZ + (-this.second_sand3.rotateAngleZ - this.second_sand2.rotateAngleZ + ageInTicks * 0.3f);
        this.third_sand3.rotateAngleZ += ageInTicks * 0.7f;
        advancedModelBox = this.third_sand2;
        advancedModelBox.rotateAngleZ = advancedModelBox.rotateAngleZ + (-this.third_sand3.rotateAngleZ + ageInTicks * 0.5f);
        advancedModelBox = this.third_sand1;
        advancedModelBox.rotateAngleZ = advancedModelBox.rotateAngleZ + (-this.third_sand3.rotateAngleZ - this.third_sand2.rotateAngleZ + ageInTicks * 0.3f);
    }

    public void animateStack(ItemStack itemStackIn) {
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.bow, (Object)this.bow_r1, (Object)this.arm1, (Object)this.cube_r8_r1, (Object)this.arm2, (Object)this.bow_string, (Object)this.string, (Object)this.string2, (Object)this.arrow3, (Object)this.arrow_pivot3, (Object)this.third_sand3, (Object[])new AdvancedModelBox[]{this.third_sand2, this.third_sand1, this.arrow2, this.arrow_pivot2, this.second_sand3, this.second_sand2, this.second_sand1, this.arrow1, this.arrow_pivot1, this.first_sand3, this.first_sand2, this.first_sand1});
    }

    public BasicModelPart root() {
        return this.root;
    }
}

