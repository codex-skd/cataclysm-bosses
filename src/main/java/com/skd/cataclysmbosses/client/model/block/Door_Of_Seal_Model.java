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

import com.skd.cataclysmbosses.blockentities.Door_Of_Seal_BlockEntity;
import com.skd.cataclysmbosses.client.animation.Door_Of_Seal_Animation;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Door_Of_Seal_Model
extends AdvancedEntityModel<Entity> {
    public final AdvancedModelBox roots;
    public final AdvancedModelBox left_door;
    public final AdvancedModelBox right_door;
    public final AdvancedModelBox lock;
    public final AdvancedModelBox cube_r1;

    public Door_Of_Seal_Model() {
        this.texWidth = 256;
        this.texHeight = 256;
        this.roots = new AdvancedModelBox((AdvancedEntityModel)this, "roots");
        this.roots.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.left_door = new AdvancedModelBox((AdvancedEntityModel)this, "left_door");
        this.left_door.setRotationPoint(40.0f, -64.0f, 0.0f);
        this.roots.addChild((BasicModelPart)this.left_door);
        this.left_door.setTextureOffset(0, 0).addBox(-40.0f, -64.0f, -8.0f, 40.0f, 128.0f, 16.0f, 0.0f, true);
        this.right_door = new AdvancedModelBox((AdvancedEntityModel)this, "right_door");
        this.right_door.setRotationPoint(-40.0f, -64.0f, 0.0f);
        this.roots.addChild((BasicModelPart)this.right_door);
        this.right_door.setTextureOffset(0, 0).addBox(0.0f, -64.0f, -8.0f, 40.0f, 128.0f, 16.0f, 0.0f, false);
        this.lock = new AdvancedModelBox((AdvancedEntityModel)this, "lock");
        this.lock.setRotationPoint(0.0f, -24.0f, -9.0f);
        this.roots.addChild((BasicModelPart)this.lock);
        this.cube_r1 = new AdvancedModelBox((AdvancedEntityModel)this, "cube_r1");
        this.cube_r1.setRotationPoint(0.0f, 7.9f, 0.0f);
        this.lock.addChild((BasicModelPart)this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, 0.7854f);
        this.cube_r1.setTextureOffset(0, 144).addBox(-21.6f, -21.6f, -1.0f, 32.0f, 32.0f, 2.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.roots;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.roots, this.left_door, this.right_door, this.lock, this.cube_r1);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void animate(Door_Of_Seal_BlockEntity entity, float partialTick) {
        this.resetToDefaultPose();
        float ageInTicks = (float)entity.tickCount + partialTick;
        this.animate(entity.getAnimationState("opening"), Door_Of_Seal_Animation.OPEN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("open"), Door_Of_Seal_Animation.OPEN_IDLE, ageInTicks, 1.0f);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

