/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.client.model.Animations.ModelAnimator
 *  com.skd.nautilusapi.client.model.tools.AdvancedEntityModel
 *  com.skd.nautilusapi.client.model.tools.AdvancedModelBox
 *  com.skd.nautilusapi.client.model.tools.BasicModelPart
 *  com.skd.nautilusapi.server.animation.IAnimatedEntity
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Mth
 */
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.skd.nautilusapi.client.model.Animations.ModelAnimator;
import com.skd.nautilusapi.client.model.tools.AdvancedEntityModel;
import com.skd.nautilusapi.client.model.tools.AdvancedModelBox;
import com.skd.nautilusapi.client.model.tools.BasicModelPart;
import com.skd.nautilusapi.server.animation.IAnimatedEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

public class Ignited_Revenant_Model
extends AdvancedEntityModel<Ignited_Revenant_Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox body;
    private final AdvancedModelBox guardingring;
    private final AdvancedModelBox guardingring2;
    private final AdvancedModelBox shieldjoint;
    private final AdvancedModelBox shield;
    private final AdvancedModelBox right_parts;
    private final AdvancedModelBox left_parts;
    private final AdvancedModelBox spike_right;
    private final AdvancedModelBox spike_left;
    private final AdvancedModelBox shieldjoint2;
    private final AdvancedModelBox shield2;
    private final AdvancedModelBox right_parts2;
    private final AdvancedModelBox left_parts2;
    private final AdvancedModelBox spike_right2;
    private final AdvancedModelBox spike_left2;
    private final AdvancedModelBox shieldjoint3;
    private final AdvancedModelBox shield3;
    private final AdvancedModelBox right_parts3;
    private final AdvancedModelBox left_parts3;
    private final AdvancedModelBox spike_right3;
    private final AdvancedModelBox spike_left3;
    private final AdvancedModelBox shieldjoint4;
    private final AdvancedModelBox shield4;
    private final AdvancedModelBox right_parts4;
    private final AdvancedModelBox left_parts4;
    private final AdvancedModelBox spike_right4;
    private final AdvancedModelBox spike_left4;
    private final AdvancedModelBox center;
    private final AdvancedModelBox head;
    private final AdvancedModelBox jaw;
    private final AdvancedModelBox skull;
    private final AdvancedModelBox helmet;
    private final AdvancedModelBox right_horn;
    private final AdvancedModelBox left_horn;
    private ModelAnimator animator;

    public Ignited_Revenant_Model() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.root = new AdvancedModelBox((AdvancedEntityModel)this);
        this.root.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.body = new AdvancedModelBox((AdvancedEntityModel)this);
        this.body.setRotationPoint(0.0f, -6.0f, 0.0f);
        this.root.addChild((BasicModelPart)this.body);
        this.guardingring = new AdvancedModelBox((AdvancedEntityModel)this);
        this.guardingring.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.guardingring);
        this.guardingring2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.guardingring2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.guardingring.addChild((BasicModelPart)this.guardingring2);
        this.shieldjoint = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shieldjoint.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.guardingring2.addChild((BasicModelPart)this.shieldjoint);
        this.setRotationAngle(this.shieldjoint, 0.0f, -0.7854f, 0.0f);
        this.shield = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shield.setRotationPoint(0.0f, -4.8f, -12.3f);
        this.shieldjoint.addChild((BasicModelPart)this.shield);
        this.setRotationAngle(this.shield, -0.2182f, 0.0f, 0.0f);
        this.shield.setTextureOffset(33, 0).addBox(-3.5f, -3.0f, -1.0f, 7.0f, 21.0f, 1.0f, 0.0f, false);
        this.shield.setTextureOffset(69, 61).addBox(-4.0f, -5.0f, -1.5f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield.setTextureOffset(63, 15).addBox(-4.0f, 15.0f, -1.25f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield.setTextureOffset(34, 66).addBox(-3.0f, 2.0f, -1.5f, 6.0f, 12.0f, 0.0f, 0.0f, false);
        this.right_parts = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_parts.setRotationPoint(-3.5f, 4.0f, 0.5f);
        this.shield.addChild((BasicModelPart)this.right_parts);
        this.setRotationAngle(this.right_parts, 0.0436f, 0.0436f, -0.0873f);
        this.right_parts.setTextureOffset(60, 23).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.right_parts.setTextureOffset(50, 0).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.right_parts.setTextureOffset(72, 0).addBox(-4.25f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.right_parts.setTextureOffset(72, 0).addBox(-4.25f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_parts.setRotationPoint(3.5f, 4.0f, 0.5f);
        this.shield.addChild((BasicModelPart)this.left_parts);
        this.setRotationAngle(this.left_parts, 0.0436f, -0.0436f, 0.0873f);
        this.left_parts.setTextureOffset(47, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.left_parts.setTextureOffset(34, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.left_parts.setTextureOffset(70, 46).addBox(-2.75f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts.setTextureOffset(69, 69).addBox(-2.75f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.spike_right = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_right.setRotationPoint(4.0f, 6.5f, -1.0f);
        this.shield.addChild((BasicModelPart)this.spike_right);
        this.setRotationAngle(this.spike_right, 0.0f, -0.3491f, 0.0f);
        this.spike_right.setTextureOffset(63, 0).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_right.setTextureOffset(61, 46).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_left.setRotationPoint(-4.0f, 6.5f, -1.0f);
        this.shield.addChild((BasicModelPart)this.spike_left);
        this.setRotationAngle(this.spike_left, 0.0f, 0.3491f, 0.0f);
        this.spike_left.setTextureOffset(0, 61).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left.setTextureOffset(52, 58).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.shieldjoint2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shieldjoint2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.guardingring2.addChild((BasicModelPart)this.shieldjoint2);
        this.setRotationAngle(this.shieldjoint2, 0.0f, -2.3562f, 0.0f);
        this.shield2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shield2.setRotationPoint(0.0f, -4.8f, -12.3f);
        this.shieldjoint2.addChild((BasicModelPart)this.shield2);
        this.setRotationAngle(this.shield2, -0.2182f, 0.0f, 0.0f);
        this.shield2.setTextureOffset(33, 0).addBox(-3.5f, -3.0f, -1.0f, 7.0f, 21.0f, 1.0f, 0.0f, false);
        this.shield2.setTextureOffset(69, 61).addBox(-4.0f, -5.0f, -1.5f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield2.setTextureOffset(63, 15).addBox(-4.0f, 15.0f, -1.25f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield2.setTextureOffset(34, 66).addBox(-3.0f, 2.0f, -1.5f, 6.0f, 12.0f, 0.0f, 0.0f, false);
        this.right_parts2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_parts2.setRotationPoint(-3.5f, 4.0f, 0.5f);
        this.shield2.addChild((BasicModelPart)this.right_parts2);
        this.setRotationAngle(this.right_parts2, 0.0436f, 0.0436f, -0.0873f);
        this.right_parts2.setTextureOffset(60, 23).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.right_parts2.setTextureOffset(50, 0).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.right_parts2.setTextureOffset(72, 0).addBox(-4.25f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.right_parts2.setTextureOffset(72, 0).addBox(-4.25f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_parts2.setRotationPoint(3.5f, 4.0f, 0.5f);
        this.shield2.addChild((BasicModelPart)this.left_parts2);
        this.setRotationAngle(this.left_parts2, 0.0436f, -0.0436f, 0.0873f);
        this.left_parts2.setTextureOffset(47, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.left_parts2.setTextureOffset(34, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.left_parts2.setTextureOffset(70, 46).addBox(-2.75f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts2.setTextureOffset(69, 69).addBox(-2.75f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.spike_right2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_right2.setRotationPoint(4.0f, 6.5f, -1.0f);
        this.shield2.addChild((BasicModelPart)this.spike_right2);
        this.setRotationAngle(this.spike_right2, 0.0f, -0.3491f, 0.0f);
        this.spike_right2.setTextureOffset(63, 0).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_right2.setTextureOffset(61, 46).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left2 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_left2.setRotationPoint(-4.0f, 6.5f, -1.0f);
        this.shield2.addChild((BasicModelPart)this.spike_left2);
        this.setRotationAngle(this.spike_left2, 0.0f, 0.3491f, 0.0f);
        this.spike_left2.setTextureOffset(0, 61).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left2.setTextureOffset(52, 58).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.shieldjoint3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shieldjoint3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.guardingring2.addChild((BasicModelPart)this.shieldjoint3);
        this.setRotationAngle(this.shieldjoint3, 0.0f, 2.3562f, 0.0f);
        this.shield3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shield3.setRotationPoint(0.0f, -4.8f, -12.3f);
        this.shieldjoint3.addChild((BasicModelPart)this.shield3);
        this.setRotationAngle(this.shield3, -0.2182f, 0.0f, 0.0f);
        this.shield3.setTextureOffset(33, 0).addBox(-3.5f, -3.0f, -1.0f, 7.0f, 21.0f, 1.0f, 0.0f, false);
        this.shield3.setTextureOffset(69, 61).addBox(-4.0f, -5.0f, -1.5f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield3.setTextureOffset(63, 15).addBox(-4.0f, 15.0f, -1.25f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield3.setTextureOffset(34, 66).addBox(-3.0f, 2.0f, -1.5f, 6.0f, 12.0f, 0.0f, 0.0f, false);
        this.right_parts3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_parts3.setRotationPoint(-3.5f, 4.0f, 0.5f);
        this.shield3.addChild((BasicModelPart)this.right_parts3);
        this.setRotationAngle(this.right_parts3, 0.0436f, 0.0436f, -0.0873f);
        this.right_parts3.setTextureOffset(60, 23).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.right_parts3.setTextureOffset(50, 0).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.right_parts3.setTextureOffset(72, 0).addBox(-4.25f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.right_parts3.setTextureOffset(72, 0).addBox(-4.25f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_parts3.setRotationPoint(3.5f, 4.0f, 0.5f);
        this.shield3.addChild((BasicModelPart)this.left_parts3);
        this.setRotationAngle(this.left_parts3, 0.0436f, -0.0436f, 0.0873f);
        this.left_parts3.setTextureOffset(47, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.left_parts3.setTextureOffset(34, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.left_parts3.setTextureOffset(70, 46).addBox(-2.75f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts3.setTextureOffset(69, 69).addBox(-2.75f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.spike_right3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_right3.setRotationPoint(4.0f, 6.5f, -1.0f);
        this.shield3.addChild((BasicModelPart)this.spike_right3);
        this.setRotationAngle(this.spike_right3, 0.0f, -0.3491f, 0.0f);
        this.spike_right3.setTextureOffset(63, 0).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_right3.setTextureOffset(61, 46).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left3 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_left3.setRotationPoint(-4.0f, 6.5f, -1.0f);
        this.shield3.addChild((BasicModelPart)this.spike_left3);
        this.setRotationAngle(this.spike_left3, 0.0f, 0.3491f, 0.0f);
        this.spike_left3.setTextureOffset(0, 61).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left3.setTextureOffset(52, 58).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.shieldjoint4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shieldjoint4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.guardingring2.addChild((BasicModelPart)this.shieldjoint4);
        this.setRotationAngle(this.shieldjoint4, 0.0f, 0.7854f, 0.0f);
        this.shield4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.shield4.setRotationPoint(0.0f, -4.8f, -12.3f);
        this.shieldjoint4.addChild((BasicModelPart)this.shield4);
        this.setRotationAngle(this.shield4, -0.2182f, 0.0f, 0.0f);
        this.shield4.setTextureOffset(33, 0).addBox(-3.5f, -3.0f, -1.0f, 7.0f, 21.0f, 1.0f, 0.0f, false);
        this.shield4.setTextureOffset(69, 61).addBox(-4.0f, -5.0f, -1.5f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield4.setTextureOffset(63, 15).addBox(-4.0f, 15.0f, -1.25f, 8.0f, 5.0f, 2.0f, 0.0f, false);
        this.shield4.setTextureOffset(34, 66).addBox(-3.0f, 2.0f, -1.5f, 6.0f, 12.0f, 0.0f, 0.0f, false);
        this.right_parts4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_parts4.setRotationPoint(-3.5f, 4.0f, 0.5f);
        this.shield4.addChild((BasicModelPart)this.right_parts4);
        this.setRotationAngle(this.right_parts4, 0.0436f, 0.0436f, -0.0873f);
        this.right_parts4.setTextureOffset(60, 23).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.right_parts4.setTextureOffset(50, 0).addBox(-4.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.right_parts4.setTextureOffset(72, 0).addBox(-4.25f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.right_parts4.setTextureOffset(72, 0).addBox(-4.25f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_parts4.setRotationPoint(3.5f, 4.0f, 0.5f);
        this.shield4.addChild((BasicModelPart)this.left_parts4);
        this.setRotationAngle(this.left_parts4, 0.0436f, -0.0436f, 0.0873f);
        this.left_parts4.setTextureOffset(47, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.0f, false);
        this.left_parts4.setTextureOffset(34, 43).addBox(-1.0f, -7.0f, -1.0f, 5.0f, 21.0f, 1.0f, 0.3f, false);
        this.left_parts4.setTextureOffset(70, 46).addBox(-2.75f, -8.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.left_parts4.setTextureOffset(69, 69).addBox(-2.75f, 11.5f, -1.5f, 7.0f, 4.0f, 2.0f, 0.0f, false);
        this.spike_right4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_right4.setRotationPoint(4.0f, 6.5f, -1.0f);
        this.shield4.addChild((BasicModelPart)this.spike_right4);
        this.setRotationAngle(this.spike_right4, 0.0f, -0.3491f, 0.0f);
        this.spike_right4.setTextureOffset(63, 0).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_right4.setTextureOffset(61, 46).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left4 = new AdvancedModelBox((AdvancedEntityModel)this);
        this.spike_left4.setRotationPoint(-4.0f, 6.5f, -1.0f);
        this.shield4.addChild((BasicModelPart)this.spike_left4);
        this.setRotationAngle(this.spike_left4, 0.0f, 0.3491f, 0.0f);
        this.spike_left4.setTextureOffset(0, 61).addBox(0.0f, -12.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.spike_left4.setTextureOffset(52, 58).addBox(0.0f, 8.5f, -8.0f, 0.0f, 6.0f, 8.0f, 0.0f, false);
        this.center = new AdvancedModelBox((AdvancedEntityModel)this);
        this.center.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.addChild((BasicModelPart)this.center);
        this.center.setTextureOffset(17, 43).addBox(-2.0f, -22.0f, -2.0f, 4.0f, 22.0f, 4.0f, 0.0f, false);
        this.center.setTextureOffset(0, 34).addBox(-2.0f, -22.0f, -2.0f, 4.0f, 22.0f, 4.0f, 0.3f, false);
        this.head = new AdvancedModelBox((AdvancedEntityModel)this);
        this.head.setRotationPoint(0.0f, -26.0f, 0.0f);
        this.center.addChild((BasicModelPart)this.head);
        this.jaw = new AdvancedModelBox((AdvancedEntityModel)this);
        this.jaw.setRotationPoint(0.0f, 2.0f, 4.0f);
        this.head.addChild((BasicModelPart)this.jaw);
        this.jaw.setTextureOffset(0, 0).addBox(-4.0f, -6.0f, -8.0f, 8.0f, 8.0f, 8.0f, -0.1f, false);
        this.skull = new AdvancedModelBox((AdvancedEntityModel)this);
        this.skull.setRotationPoint(0.0f, 2.0f, 4.0f);
        this.head.addChild((BasicModelPart)this.skull);
        this.skull.setTextureOffset(25, 26).addBox(-4.0f, -5.999f, -8.0436f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.helmet = new AdvancedModelBox((AdvancedEntityModel)this);
        this.helmet.setRotationPoint(0.0f, -1.999f, -4.0436f);
        this.skull.addChild((BasicModelPart)this.helmet);
        this.helmet.setTextureOffset(0, 17).addBox(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.3f, false);
        this.right_horn = new AdvancedModelBox((AdvancedEntityModel)this);
        this.right_horn.setRotationPoint(-4.0f, -3.5f, -3.5f);
        this.helmet.addChild((BasicModelPart)this.right_horn);
        this.setRotationAngle(this.right_horn, 0.4363f, 0.0f, 0.0f);
        this.right_horn.setTextureOffset(0, 0).addBox(-1.3f, -5.5f, -0.5f, 1.0f, 6.0f, 1.0f, 0.0f, false);
        this.left_horn = new AdvancedModelBox((AdvancedEntityModel)this);
        this.left_horn.setRotationPoint(4.3f, -3.5f, -3.5f);
        this.helmet.addChild((BasicModelPart)this.left_horn);
        this.setRotationAngle(this.left_horn, 0.4363f, 0.0f, 0.0f);
        this.left_horn.setTextureOffset(0, 17).addBox(0.0f, -2.5f, -0.5f, 1.0f, 3.0f, 1.0f, 0.0f, false);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    public void animate(Ignited_Revenant_Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.resetToDefaultPose();
        this.animator.update((IAnimatedEntity)entity);
        this.animator.setAnimation(Ignited_Revenant_Entity.ASH_BREATH_ATTACK);
        if (!entity.getIsAnger()) {
            this.animator.startKeyframe(15);
            this.animator.rotate(this.guardingring, (float)Math.toRadians(-5.0), 0.0f, 0.0f);
            this.animator.rotate(this.center, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
            this.animator.rotate(this.head, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(8);
            this.animator.startKeyframe(5);
            this.animator.rotate(this.guardingring, (float)Math.toRadians(20.0), 0.0f, 0.0f);
            this.animator.rotate(this.center, (float)Math.toRadians(25.0), 0.0f, 0.0f);
            this.animator.rotate(this.head, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
            this.animator.move(this.skull, 0.0f, -3.0f, 0.0f);
            this.animator.rotate(this.skull, (float)Math.toRadians(-22.5), 0.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(15);
            this.animator.resetKeyframe(10);
        } else {
            this.animator.startKeyframe(15);
            this.animator.rotate(this.root, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
            this.animator.rotate(this.center, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
            this.animator.rotate(this.head, (float)Math.toRadians(-25.0), 0.0f, 0.0f);
            this.animator.rotate(this.shield, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield2, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield3, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield4, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.skull, (float)Math.toRadians(17.5), 0.0f, 0.0f);
            this.animator.rotate(this.jaw, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(8);
            this.animator.startKeyframe(5);
            this.animator.rotate(this.guardingring, (float)Math.toRadians(25.0), 0.0f, 0.0f);
            this.animator.rotate(this.center, (float)Math.toRadians(25.0), 0.0f, 0.0f);
            this.animator.rotate(this.head, (float)Math.toRadians(-15.0), 0.0f, 0.0f);
            this.animator.move(this.skull, 0.0f, -3.0f, 0.0f);
            this.animator.rotate(this.skull, (float)Math.toRadians(5.0), 0.0f, 0.0f);
            this.animator.rotate(this.shield, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield2, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield3, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield4, (float)Math.toRadians(47.5), 0.0f, 0.0f);
            this.animator.rotate(this.jaw, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(15);
            this.animator.resetKeyframe(10);
        }
        this.animator.setAnimation(Ignited_Revenant_Entity.BONE_STORM_ATTACK);
        if (!entity.getIsAnger()) {
            this.animator.startKeyframe(4);
            this.animator.rotate(this.shield, (float)Math.toRadians(-57.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield2, (float)Math.toRadians(-57.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield3, (float)Math.toRadians(-57.5), 0.0f, 0.0f);
            this.animator.rotate(this.shield4, (float)Math.toRadians(-57.5), 0.0f, 0.0f);
            this.animator.move(this.skull, 0.0f, -3.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(30);
            this.animator.resetKeyframe(15);
        } else {
            this.animator.startKeyframe(4);
            this.animator.rotate(this.root, (float)Math.toRadians(-12.5), 0.0f, 0.0f);
            this.animator.rotate(this.guardingring, (float)Math.toRadians(5.0), 0.0f, 0.0f);
            this.animator.rotate(this.shield, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.rotate(this.shield2, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.rotate(this.shield3, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.rotate(this.shield4, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.rotate(this.jaw, (float)Math.toRadians(-10.0), 0.0f, 0.0f);
            this.animator.move(this.skull, 0.0f, -3.0f, 0.0f);
            this.animator.endKeyframe();
            this.animator.setStaticKeyframe(30);
            this.animator.resetKeyframe(15);
        }
    }

    public void setupAnim(Ignited_Revenant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.animate(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float idleSpeed = 0.1f;
        float idleDegree = 1.0f;
        float walkSpeed = 0.5f;
        float walkDegree = 1.0f;
        this.faceTarget(netHeadYaw, headPitch, 1.0f, new AdvancedModelBox[]{this.head});
        this.bob(this.root, idleSpeed, idleDegree * 3.0f, false, ageInTicks, 1.0f);
        this.bob(this.shield, idleSpeed, idleDegree, false, ageInTicks, 1.0f);
        this.bob(this.shield2, idleSpeed, idleDegree, false, ageInTicks, 1.0f);
        this.bob(this.shield3, idleSpeed, idleDegree, false, ageInTicks, 1.0f);
        this.bob(this.shield4, idleSpeed, idleDegree, false, ageInTicks, 1.0f);
        float spin = 0.05f;
        if (entityIn.getIsAnger()) {
            if (entityIn.getAnimation() == Ignited_Revenant_Entity.NO_ANIMATION) {
                spin = 0.5f;
            }
        }
        this.guardingring2.rotateAngleY += ageInTicks * spin;
        this.shield.rotationPointY += Mth.cos((float)(ageInTicks * 0.1f));
        this.shield4.rotationPointY += Mth.cos((float)(ageInTicks * 0.1f));
        this.shield2.rotationPointY -= Mth.cos((float)(ageInTicks * 0.1f));
        this.shield3.rotationPointY -= Mth.cos((float)(ageInTicks * 0.1f));
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float angerProgress = entityIn.prevangerProgress + (entityIn.angerProgress - entityIn.prevangerProgress) * partialTick;
        this.progressRotationPrev(this.root, angerProgress, (float)Math.toRadians(12.5), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.guardingring, angerProgress, (float)Math.toRadians(-5.0), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.shield, angerProgress, (float)Math.toRadians(-47.5), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.shield2, angerProgress, (float)Math.toRadians(-47.5), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.shield3, angerProgress, (float)Math.toRadians(-47.5), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.shield4, angerProgress, (float)Math.toRadians(-47.5), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.skull, angerProgress, (float)Math.toRadians(-17.5), 0.0f, 0.0f, 5.0f);
        this.progressRotationPrev(this.jaw, angerProgress, (float)Math.toRadians(10.0), 0.0f, 0.0f, 5.0f);
        this.shield.showModel = entityIn.getShieldDurability() < 1;
        this.shield2.showModel = entityIn.getShieldDurability() < 2;
        this.shield3.showModel = entityIn.getShieldDurability() < 3;
        this.shield4.showModel = entityIn.getShieldDurability() < 4;
    }

    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of((Object)this.root, (Object)this.head, (Object)this.jaw, (Object)this.helmet, (Object)this.skull, (Object)this.body, (Object)this.guardingring, (Object)this.guardingring2, (Object)this.shield, (Object)this.shieldjoint, (Object)this.shield2, (Object)this.shieldjoint2, (Object[])new AdvancedModelBox[]{this.shield3, this.shieldjoint3, this.shield4, this.shieldjoint4, this.center});
    }

    public BasicModelPart root() {
        return this.root;
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox2, float x, float y, float z) {
        AdvancedModelBox2.rotateAngleX = x;
        AdvancedModelBox2.rotateAngleY = y;
        AdvancedModelBox2.rotateAngleZ = z;
    }
}

