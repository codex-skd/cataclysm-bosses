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

import com.skd.cataclysmbosses.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.skd.cataclysmbosses.client.animation.Boss_Respawn_Spawner_Animation;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.Entity;

public class Boss_Respawn_Spawner_Model
extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox bone;
    private final AdvancedModelBox one;
    private final AdvancedModelBox two;
    private final AdvancedModelBox three;
    private final AdvancedModelBox four;
    private final AdvancedModelBox bone2;
    private final AdvancedModelBox bone3;

    public Boss_Respawn_Spawner_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this, "root");
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.root.setTextureOffset(33, 0).addBox(-4.0f, -18.0f, -4.0f, 8.0f, 14.0f, 8.0f, 0.0f, false);
        this.bone = new AdvancedModelBox((AdvancedEntityModel)this, "bone");
        this.bone.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.bone);
        this.one = new AdvancedModelBox((AdvancedEntityModel)this, "one");
        this.one.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bone.addChild((BasicModelPart)this.one);
        this.one.setTextureOffset(0, 0).addBox(-8.0f, -18.0f, 0.0f, 8.0f, 18.0f, 8.0f, 0.0f, false);
        this.two = new AdvancedModelBox((AdvancedEntityModel)this, "two");
        this.two.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bone.addChild((BasicModelPart)this.two);
        this.two.setTextureOffset(0, 0).addBox(0.0f, -18.0f, 0.0f, 8.0f, 18.0f, 8.0f, 0.0f, true);
        this.three = new AdvancedModelBox((AdvancedEntityModel)this, "three");
        this.three.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bone.addChild((BasicModelPart)this.three);
        this.three.setTextureOffset(0, 27).addBox(0.0f, -18.0f, -8.0f, 8.0f, 18.0f, 8.0f, 0.0f, true);
        this.four = new AdvancedModelBox((AdvancedEntityModel)this, "four");
        this.four.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bone.addChild((BasicModelPart)this.four);
        this.four.setTextureOffset(0, 27).addBox(-8.0f, -18.0f, -8.0f, 8.0f, 18.0f, 8.0f, 0.0f, false);
        this.bone2 = new AdvancedModelBox((AdvancedEntityModel)this, "bone2");
        this.bone2.setRotationPoint(0.0f, -18.0f, 7.0f);
        this.root.addChild((BasicModelPart)this.bone2);
        this.bone2.setTextureOffset(33, 23).addBox(-4.0f, -4.0f, -6.0f, 8.0f, 4.0f, 6.0f, 0.0f, false);
        this.bone2.setTextureOffset(33, 41).addBox(-3.0f, -4.0f, -7.0f, 6.0f, 0.0f, 1.0f, 0.0f, false);
        this.bone3 = new AdvancedModelBox((AdvancedEntityModel)this, "bone3");
        this.bone3.setRotationPoint(0.0f, -18.0f, -7.0f);
        this.root.addChild((BasicModelPart)this.bone3);
        this.bone3.setTextureOffset(33, 34).addBox(-4.0f, -4.0f, 1.0f, 8.0f, 4.0f, 2.0f, 0.0f, false);
        this.updateDefaultPose();
    }

    public BasicModelPart root() {
        return this.root;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.bone, (Object)this.one, (Object)this.two, (Object)this.three, (Object)this.four, (Object)this.bone2, (Object)this.bone3);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.resetToDefaultPose();
    }

    public void animate(Boss_Respawn_Spawner_Block_Entity entity, float partialTick) {
        this.resetToDefaultPose();
        float ageInTicks = (float)entity.tickCount + partialTick;
        this.animate(entity.getAnimationState("opening"), Boss_Respawn_Spawner_Animation.SPAWNING, ageInTicks, 1.0f);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

