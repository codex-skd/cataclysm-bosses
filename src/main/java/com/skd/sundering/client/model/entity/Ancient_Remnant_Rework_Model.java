/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.skd.nautilusapi.server.animation.LegSolver
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.sundering.client.model.entity;

import com.skd.sundering.client.animation.Ancient_Remnant_Animation;
import com.skd.sundering.client.animation.Ancient_Remnant_Power_Animation;
import com.skd.sundering.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.skd.nautilusapi.server.animation.LegSolver;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class Ancient_Remnant_Rework_Model
extends HierarchicalModel<Ancient_Remnant_Entity> {
    private final ModelPart root;
    private final ModelPart roots;
    private final ModelPart mid_pivot;
    private final ModelPart pelvis;
    private final ModelPart left_long_bone;
    private final ModelPart right_long_bone;
    private final ModelPart spine_sail2;
    private final ModelPart left_bone;
    private final ModelPart right_bone;
    private final ModelPart left_big_bone;
    private final ModelPart right_big_bone;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart spine1;
    private final ModelPart spine2;
    private final ModelPart spine_sail1;
    private final ModelPart right_shoulder;
    private final ModelPart left_shoulder;
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart crown;
    private final ModelPart under_crown;
    private final ModelPart right_crown1;
    private final ModelPart right_crown2;
    private final ModelPart left_crown;
    private final ModelPart left_crown2;
    private final ModelPart snake;
    private final ModelPart upper_crown;
    private final ModelPart desert_necklace;
    private final ModelPart chain1;
    private final ModelPart chain2;
    private final ModelPart chain3;
    private final ModelPart chain4;
    private final ModelPart chain5;
    private final ModelPart desert_eye;
    private final ModelPart eye;
    private final ModelPart left_arm;
    private final ModelPart left_front_arm;
    private final ModelPart left_hand;
    private final ModelPart left_finger3;
    private final ModelPart left_finger1;
    private final ModelPart left_finger2;
    private final ModelPart right_arm;
    private final ModelPart right_front_arm;
    private final ModelPart right_hand;
    private final ModelPart right_finger1;
    private final ModelPart right_finger2;
    private final ModelPart right_finger3;
    private final ModelPart spine_deco;
    private final ModelPart legs;
    private final ModelPart left_leg;
    private final ModelPart left_deco1;
    private final ModelPart left_front_leg;
    private final ModelPart left_ankel_joint;
    private final ModelPart left_mini_bone;
    private final ModelPart left_deco2;
    private final ModelPart left_deco3;
    private final ModelPart left_ankel;
    private final ModelPart left_foot;
    private final ModelPart left_toe;
    private final ModelPart left_toe2;
    private final ModelPart left_toe3;
    private final ModelPart right_leg;
    private final ModelPart right_deco1;
    private final ModelPart right_front_leg;
    private final ModelPart right_ankel_joint;
    private final ModelPart right_mini_bone;
    private final ModelPart right_deco2;
    private final ModelPart right_deco3;
    private final ModelPart right_ankel;
    private final ModelPart right_foot;
    private final ModelPart right_toe;
    private final ModelPart right_toe2;
    private final ModelPart right_toe3;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Ancient_Remnant_Rework_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.roots = this.root.getChild("roots");
        this.mid_pivot = this.roots.getChild("mid_pivot");
        this.pelvis = this.mid_pivot.getChild("pelvis");
        this.left_long_bone = this.pelvis.getChild("left_long_bone");
        this.right_long_bone = this.pelvis.getChild("right_long_bone");
        this.spine_sail2 = this.pelvis.getChild("spine_sail2");
        this.left_bone = this.pelvis.getChild("left_bone");
        this.right_bone = this.pelvis.getChild("right_bone");
        this.left_big_bone = this.pelvis.getChild("left_big_bone");
        this.right_big_bone = this.pelvis.getChild("right_big_bone");
        this.tail1 = this.pelvis.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
        this.spine1 = this.pelvis.getChild("spine1");
        this.spine2 = this.spine1.getChild("spine2");
        this.spine_sail1 = this.spine2.getChild("spine_sail1");
        this.right_shoulder = this.spine2.getChild("right_shoulder");
        this.left_shoulder = this.spine2.getChild("left_shoulder");
        this.neck1 = this.spine2.getChild("neck1");
        this.neck2 = this.neck1.getChild("neck2");
        this.head = this.neck2.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.crown = this.head.getChild("crown");
        this.under_crown = this.crown.getChild("under_crown");
        this.right_crown1 = this.under_crown.getChild("right_crown1");
        this.right_crown2 = this.right_crown1.getChild("right_crown2");
        this.left_crown = this.under_crown.getChild("left_crown");
        this.left_crown2 = this.left_crown.getChild("left_crown2");
        this.snake = this.crown.getChild("snake");
        this.upper_crown = this.crown.getChild("upper_crown");
        this.desert_necklace = this.neck2.getChild("desert_necklace");
        this.chain1 = this.desert_necklace.getChild("chain1");
        this.chain2 = this.chain1.getChild("chain2");
        this.chain3 = this.chain2.getChild("chain3");
        this.chain4 = this.chain3.getChild("chain4");
        this.chain5 = this.chain4.getChild("chain5");
        this.desert_eye = this.chain5.getChild("desert_eye");
        this.eye = this.desert_eye.getChild("eye");
        this.left_arm = this.spine2.getChild("left_arm");
        this.left_front_arm = this.left_arm.getChild("left_front_arm");
        this.left_hand = this.left_front_arm.getChild("left_hand");
        this.left_finger3 = this.left_hand.getChild("left_finger3");
        this.left_finger1 = this.left_hand.getChild("left_finger1");
        this.left_finger2 = this.left_hand.getChild("left_finger2");
        this.right_arm = this.spine2.getChild("right_arm");
        this.right_front_arm = this.right_arm.getChild("right_front_arm");
        this.right_hand = this.right_front_arm.getChild("right_hand");
        this.right_finger1 = this.right_hand.getChild("right_finger1");
        this.right_finger2 = this.right_hand.getChild("right_finger2");
        this.right_finger3 = this.right_hand.getChild("right_finger3");
        this.spine_deco = this.spine2.getChild("spine_deco");
        this.legs = this.mid_pivot.getChild("legs");
        this.left_leg = this.legs.getChild("left_leg");
        this.left_deco1 = this.left_leg.getChild("left_deco1");
        this.left_front_leg = this.left_leg.getChild("left_front_leg");
        this.left_ankel_joint = this.left_front_leg.getChild("left_ankel_joint");
        this.left_mini_bone = this.left_ankel_joint.getChild("left_mini_bone");
        this.left_deco2 = this.left_ankel_joint.getChild("left_deco2");
        this.left_deco3 = this.left_ankel_joint.getChild("left_deco3");
        this.left_ankel = this.left_ankel_joint.getChild("left_ankel");
        this.left_foot = this.left_ankel_joint.getChild("left_foot");
        this.left_toe = this.left_foot.getChild("left_toe");
        this.left_toe2 = this.left_foot.getChild("left_toe2");
        this.left_toe3 = this.left_foot.getChild("left_toe3");
        this.right_leg = this.legs.getChild("right_leg");
        this.right_deco1 = this.right_leg.getChild("right_deco1");
        this.right_front_leg = this.right_leg.getChild("right_front_leg");
        this.right_ankel_joint = this.right_front_leg.getChild("right_ankel_joint");
        this.right_mini_bone = this.right_ankel_joint.getChild("right_mini_bone");
        this.right_deco2 = this.right_ankel_joint.getChild("right_deco2");
        this.right_deco3 = this.right_ankel_joint.getChild("right_deco3");
        this.right_ankel = this.right_ankel_joint.getChild("right_ankel");
        this.right_foot = this.right_ankel_joint.getChild("right_foot");
        this.right_toe = this.right_foot.getChild("right_toe");
        this.right_toe2 = this.right_foot.getChild("right_toe2");
        this.right_toe3 = this.right_foot.getChild("right_toe3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition mid_pivot = roots.addOrReplaceChild("mid_pivot", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-69.0f, (float)-10.0f));
        PartDefinition pelvis = mid_pivot.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(111, 42).addBox(-5.0f, -4.2211f, -9.2432f, 10.0f, 12.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)2.0f, (float)-0.2182f, (float)0.0f, (float)0.0f));
        PartDefinition left_long_bone = pelvis.addOrReplaceChild("left_long_bone", CubeListBuilder.create().texOffs(50, 0).addBox(0.0f, -4.0f, 6.0f, 5.0f, 28.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)6.5f, (float)-0.2211f, (float)-8.2432f, (float)-0.4185f, (float)0.1274f, (float)0.2783f));
        PartDefinition right_long_bone = pelvis.addOrReplaceChild("right_long_bone", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-5.0f, -4.0f, 6.0f, 5.0f, 28.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-6.5f, (float)-0.2211f, (float)-8.2432f, (float)-0.4185f, (float)-0.1274f, (float)-0.2783f));
        PartDefinition spine_sail2 = pelvis.addOrReplaceChild("spine_sail2", CubeListBuilder.create().texOffs(65, 50).addBox(0.0f, -28.916f, -25.98f, 0.0f, 30.0f, 32.0f, new CubeDeformation(0.01f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.2211f, (float)12.7568f, (float)0.1745f, (float)0.0f, (float)0.0f));
        PartDefinition left_bone = pelvis.addOrReplaceChild("left_bone", CubeListBuilder.create().texOffs(194, 215).addBox(1.0f, 3.0f, 0.0f, 7.0f, 33.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.5f, (float)-0.2211f, (float)-8.2432f, (float)0.7811f, (float)-0.0924f, (float)0.0928f));
        PartDefinition right_bone = pelvis.addOrReplaceChild("right_bone", CubeListBuilder.create().texOffs(194, 215).mirror().addBox(-8.0f, 3.0f, 0.0f, 7.0f, 33.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-3.5f, (float)-0.2211f, (float)-8.2432f, (float)0.7811f, (float)0.0924f, (float)-0.0928f));
        PartDefinition left_big_bone = pelvis.addOrReplaceChild("left_big_bone", CubeListBuilder.create().texOffs(112, 124).addBox(1.0f, -2.0f, -1.0f, 9.0f, 14.0f, 27.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.2211f, (float)-8.2432f, (float)0.3186f, (float)0.1451f, (float)-0.413f));
        PartDefinition right_big_bone = pelvis.addOrReplaceChild("right_big_bone", CubeListBuilder.create().texOffs(112, 124).mirror().addBox(-10.0f, -2.0f, -1.0f, 9.0f, 14.0f, 27.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-0.2211f, (float)-8.2432f, (float)0.3186f, (float)-0.1451f, (float)0.413f));
        PartDefinition tail1 = pelvis.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(98, 81).addBox(-4.0f, -5.916f, 1.02f, 8.0f, 10.0f, 32.0f, new CubeDeformation(0.0f)).texOffs(47, 117).addBox(0.0f, -24.916f, -0.98f, 0.0f, 19.0f, 32.0f, new CubeDeformation(0.0f)).texOffs(114, 197).addBox(0.0f, 4.084f, 6.02f, 0.0f, 6.0f, 25.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)6.7789f, (float)10.7568f, (float)0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 109).addBox(-3.5f, -3.7067f, -0.3098f, 7.0f, 7.0f, 32.0f, new CubeDeformation(0.0f)).texOffs(148, 47).addBox(0.0f, 3.2933f, -0.3098f, 0.0f, 4.0f, 32.0f, new CubeDeformation(0.0f)).texOffs(0, 149).addBox(0.0f, -6.7067f, -0.3098f, 0.0f, 3.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-2.8f, (float)32.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -2.7686f, -0.1825f, 6.0f, 6.0f, 37.0f, new CubeDeformation(0.0f)).texOffs(156, 13).addBox(0.0f, -6.7686f, -0.1825f, 0.0f, 4.0f, 29.0f, new CubeDeformation(0.0f)).texOffs(28, 198).addBox(0.0f, 3.2314f, -0.1825f, 0.0f, 4.0f, 25.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.5762f, (float)31.5254f, (float)-0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(50, 7).addBox(-3.0f, -2.8005f, 0.2055f, 5.0f, 5.0f, 37.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)1.3649f, (float)34.6065f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition spine1 = pelvis.addOrReplaceChild("spine1", CubeListBuilder.create().texOffs(162, 143).addBox(-4.5f, -5.0f, -19.0f, 9.0f, 8.0f, 23.0f, new CubeDeformation(0.0f)).texOffs(0, 185).addBox(3.0f, -3.0f, -19.0f, 11.0f, 18.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(145, 175).addBox(-14.0f, -3.0f, -19.0f, 11.0f, 18.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)5.0f, (float)-5.0f));
        PartDefinition spine2 = spine1.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(158, 101).addBox(-4.5f, -5.0f, -23.0f, 9.0f, 8.0f, 23.0f, new CubeDeformation(0.0f)).texOffs(200, 73).addBox(3.0f, -3.0f, -18.0f, 10.0f, 16.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(88, 190).addBox(-13.0f, -3.0f, -18.0f, 10.0f, 16.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(128, 229).addBox(1.8f, -7.1199f, -17.5887f, 4.0f, 5.0f, 13.0f, new CubeDeformation(0.0f)).texOffs(93, 229).addBox(-5.8f, -7.1199f, -17.5887f, 4.0f, 5.0f, 13.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)-19.0f, (float)0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition spine_sail1 = spine2.addOrReplaceChild("spine_sail1", CubeListBuilder.create().texOffs(0, 44).addBox(0.0f, -18.916f, -52.98f, 0.0f, 32.0f, 32.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-5.2211f, (float)36.7568f, (float)-0.0436f, (float)0.0f, (float)0.0f));
        PartDefinition right_shoulder = spine2.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(176, 187).mirror().addBox(-23.0f, -3.0f, -17.0f, 5.0f, 5.0f, 22.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.5314f, (float)-0.5844f, (float)-0.3136f));
        PartDefinition left_shoulder = spine2.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(176, 187).addBox(18.0f, -3.0f, -17.0f, 5.0f, 5.0f, 22.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)0.5314f, (float)0.5844f, (float)0.3136f));
        PartDefinition neck1 = spine2.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(204, 137).addBox(-3.5f, -4.0937f, -15.5774f, 8.0f, 9.0f, 16.0f, new CubeDeformation(0.0f)).texOffs(186, 0).addBox(-3.5f, -4.0937f, -17.5774f, 8.0f, 18.0f, 16.0f, new CubeDeformation(0.7f)).texOffs(235, 0).addBox(0.5f, -10.0937f, -15.5774f, 0.0f, 6.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.5f, (float)-1.0f, (float)-20.0f, (float)-0.4363f, (float)0.0f, (float)0.0f));
        PartDefinition neck2 = neck1.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(217, 35).addBox(-3.0f, -4.0038f, -10.0872f, 7.0f, 8.0f, 13.0f, new CubeDeformation(0.0f)).texOffs(33, 157).addBox(0.5f, -10.0038f, -10.0872f, 0.0f, 6.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.0937f, (float)-17.5774f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition head = neck2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 124).addBox(-6.0f, -10.0f, -14.0f, 13.0f, 10.0f, 14.0f, new CubeDeformation(0.0f)).texOffs(209, 175).addBox(-6.0f, -9.0f, -14.0f, 13.0f, 2.0f, 14.0f, new CubeDeformation(0.5f)).texOffs(44, 169).addBox(-3.5f, -7.0f, -35.0f, 8.0f, 7.0f, 21.0f, new CubeDeformation(0.0f)).texOffs(0, 222).addBox(-3.5f, -7.0f, -20.0f, 8.0f, 32.0f, 6.0f, new CubeDeformation(0.5f)).texOffs(33, 50).addBox(-3.5f, 0.0f, -35.0f, 8.0f, 4.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.0f, (float)-8.0f, (float)0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(29, 228).addBox(-4.0f, -2.0f, -6.0f, 9.0f, 7.0f, 11.0f, new CubeDeformation(0.0f)).texOffs(181, 47).addBox(-3.0f, 0.0f, -27.0f, 7.0f, 4.0f, 21.0f, new CubeDeformation(0.0f)).texOffs(216, 198).addBox(-3.0f, 4.0f, -27.0f, 7.0f, 2.0f, 17.0f, new CubeDeformation(0.0f)).texOffs(202, 112).addBox(-2.5f, -3.0f, -27.0f, 6.0f, 3.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)2.0f, (float)-7.0f));
        PartDefinition crown = head.addOrReplaceChild("crown", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition under_crown = crown.addOrReplaceChild("under_crown", CubeListBuilder.create().texOffs(223, 218).addBox(-7.5f, 0.0f, -4.0f, 15.0f, 17.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)-7.9063f, (float)1.5774f, (float)-0.3054f, (float)0.0f, (float)0.0f));
        PartDefinition right_crown1 = under_crown.addOrReplaceChild("right_crown1", CubeListBuilder.create().texOffs(13, 149).addBox(-5.0f, -2.0f, 0.0f, 6.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(23, 0).addBox(-5.0f, -4.0f, 1.5f, 4.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(29, 19).addBox(1.0f, 0.0f, 1.5f, 2.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(158, 133).addBox(-5.0f, 6.0f, 0.0f, 9.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(80, 113).addBox(-5.0f, 15.0f, 0.0f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).texOffs(0, 0).addBox(0.0f, 15.0f, 1.5f, 2.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)12.5f, (float)2.0f, (float)-7.0f));
        PartDefinition right_crown2 = right_crown1.addOrReplaceChild("right_crown2", CubeListBuilder.create().texOffs(84, 50).addBox(-1.5f, 0.0f, -3.0f, 3.0f, 7.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.5f, (float)19.0f, (float)3.0f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition left_crown = under_crown.addOrReplaceChild("left_crown", CubeListBuilder.create().texOffs(13, 149).mirror().addBox(-1.0f, -2.0f, 0.0f, 6.0f, 8.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(23, 0).mirror().addBox(1.0f, -4.0f, 1.5f, 4.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(29, 19).mirror().addBox(-3.0f, 0.0f, 1.5f, 2.0f, 6.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(158, 133).mirror().addBox(-4.0f, 6.0f, 0.0f, 9.0f, 9.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(80, 113).mirror().addBox(0.0f, 15.0f, 0.0f, 5.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 0).mirror().addBox(-2.0f, 15.0f, 1.5f, 2.0f, 3.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)-12.5f, (float)2.0f, (float)-7.0f));
        PartDefinition left_crown2 = left_crown.addOrReplaceChild("left_crown2", CubeListBuilder.create().texOffs(84, 50).mirror().addBox(-1.5f, 0.0f, -3.0f, 3.0f, 7.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)3.5f, (float)19.0f, (float)3.0f, (float)-0.2618f, (float)0.0f, (float)0.0f));
        PartDefinition snake = crown.addOrReplaceChild("snake", CubeListBuilder.create().texOffs(172, 84).addBox(0.0f, -83.0937f, -99.5774f, 0.0f, 7.0f, 9.0f, new CubeDeformation(0.0f)).texOffs(29, 10).mirror().addBox(-4.5f, -81.5937f, -93.5774f, 3.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(29, 10).addBox(1.5f, -81.5937f, -93.5774f, 3.0f, 8.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(26, 32).addBox(1.0f, -80.0937f, -96.5774f, 1.0f, 1.0f, 3.0f, new CubeDeformation(0.5f)).texOffs(71, 50).addBox(-1.0f, -81.0937f, -94.5774f, 2.0f, 8.0f, 2.0f, new CubeDeformation(0.5f)).texOffs(29, 26).addBox(-1.5f, -77.5937f, -100.0774f, 3.0f, 2.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(26, 32).addBox(-2.0f, -80.0937f, -96.5774f, 1.0f, 1.0f, 3.0f, new CubeDeformation(0.5f)).texOffs(98, 0).addBox(-1.0f, -81.0937f, -99.5774f, 2.0f, 3.0f, 4.0f, new CubeDeformation(0.5f)), PartPose.offset((float)0.5f, (float)66.0937f, (float)77.5774f));
        PartDefinition upper_crown = crown.addOrReplaceChild("upper_crown", CubeListBuilder.create().texOffs(95, 166).addBox(-7.0f, -6.0f, -17.0f, 15.0f, 6.0f, 17.0f, new CubeDeformation(0.01f)), PartPose.offsetAndRotation((float)0.0f, (float)-7.9063f, (float)1.5774f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition desert_necklace = neck2.addOrReplaceChild("desert_necklace", CubeListBuilder.create().texOffs(82, 169).addBox(-4.0f, 0.0f, -1.5f, 8.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.5f, (float)-4.9063f, (float)-0.9226f, (float)0.2182f, (float)0.0f, (float)0.0f));
        PartDefinition chain1 = desert_necklace.addOrReplaceChild("chain1", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0f, 0.0f, -1.5f, 8.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)4.0f, (float)0.0f));
        PartDefinition chain2 = chain1.addOrReplaceChild("chain2", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0f, 0.0f, -1.5f, 8.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition chain3 = chain2.addOrReplaceChild("chain3", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0f, 0.0f, -1.5f, 8.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition chain4 = chain3.addOrReplaceChild("chain4", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0f, 0.0f, -1.5f, 8.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition chain5 = chain4.addOrReplaceChild("chain5", CubeListBuilder.create().texOffs(147, 104).addBox(-4.0f, 0.0f, -1.5f, 8.0f, 5.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)5.0f, (float)0.0f));
        PartDefinition desert_eye = chain5.addOrReplaceChild("desert_eye", CubeListBuilder.create().texOffs(167, 0).mirror().addBox(-12.0f, -7.1811f, 0.2836f, 11.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(167, 0).addBox(1.0f, -7.1811f, 0.2836f, 11.0f, 11.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)8.7811f, (float)-0.2836f));
        PartDefinition eye = desert_eye.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(98, 50).addBox(-5.0f, -5.0f, -1.0f, 10.0f, 10.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-0.7811f, (float)0.2836f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition left_arm = spine2.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(47, 109).addBox(-6.0f, -4.0637f, -3.0436f, 6.0f, 20.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(0, 109).addBox(-6.0f, -4.0637f, -3.0436f, 6.0f, 20.0f, 5.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)13.2f, (float)10.0f, (float)-17.0f, (float)0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition left_front_arm = left_arm.addOrReplaceChild("left_front_arm", CubeListBuilder.create().texOffs(156, 47).addBox(-3.0f, -0.1465f, -2.2077f, 6.0f, 11.0f, 5.0f, new CubeDeformation(0.0f)).texOffs(0, 169).addBox(-3.0f, 2.8535f, -2.2077f, 6.0f, 5.0f, 5.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)-4.0f, (float)15.2977f, (float)-1.9036f, (float)-0.829f, (float)0.0f, (float)0.0f));
        PartDefinition left_hand = left_front_arm.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offsetAndRotation((float)1.0f, (float)10.1551f, (float)-0.5133f, (float)1.6144f, (float)0.0f, (float)0.0f));
        PartDefinition left_finger3 = left_hand.addOrReplaceChild("left_finger3", CubeListBuilder.create().texOffs(0, 149).addBox(-0.2215f, -3.2106f, -9.8849f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)1.0f, (float)0.0049f, (float)0.3079f, (float)-0.7216f, (float)-0.2324f, (float)0.2f));
        PartDefinition left_finger1 = left_hand.addOrReplaceChild("left_finger1", CubeListBuilder.create().texOffs(147, 84).addBox(0.2215f, -3.2106f, -9.8849f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)0.0049f, (float)0.3079f, (float)-0.7216f, (float)0.2324f, (float)-0.2f));
        PartDefinition left_finger2 = left_hand.addOrReplaceChild("left_finger2", CubeListBuilder.create().texOffs(0, 149).addBox(-0.2215f, -3.2106f, -9.8849f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)0.0049f, (float)0.3079f, (float)-0.7258f, (float)0.0f, (float)0.0f));
        PartDefinition right_arm = spine2.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(47, 109).mirror().addBox(0.0f, -4.0637f, -3.0436f, 6.0f, 20.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-13.2f, (float)10.0f, (float)-17.0f, (float)0.3491f, (float)0.0f, (float)0.0f));
        PartDefinition right_front_arm = right_arm.addOrReplaceChild("right_front_arm", CubeListBuilder.create().texOffs(156, 47).mirror().addBox(-3.0f, -0.1465f, -2.2077f, 6.0f, 11.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 169).mirror().addBox(-3.0f, 2.8535f, -2.2077f, 6.0f, 5.0f, 5.0f, new CubeDeformation(0.5f)).mirror(false), PartPose.offsetAndRotation((float)4.0f, (float)15.2977f, (float)-1.9036f, (float)-0.829f, (float)0.0f, (float)0.0f));
        PartDefinition right_hand = right_front_arm.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-1.0f, (float)10.1551f, (float)-0.5133f, (float)1.6144f, (float)0.0f, (float)0.0f));
        PartDefinition right_finger1 = right_hand.addOrReplaceChild("right_finger1", CubeListBuilder.create().texOffs(0, 149).mirror().addBox(0.2215f, -3.2106f, -9.8849f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-1.0f, (float)0.0049f, (float)0.3079f, (float)-0.7216f, (float)0.2324f, (float)-0.2f));
        PartDefinition right_finger2 = right_hand.addOrReplaceChild("right_finger2", CubeListBuilder.create().texOffs(0, 149).mirror().addBox(0.2215f, -3.2106f, -9.8849f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.0f, (float)0.0049f, (float)0.3079f, (float)-0.7258f, (float)0.0f, (float)0.0f));
        PartDefinition right_finger3 = right_hand.addOrReplaceChild("right_finger3", CubeListBuilder.create().texOffs(147, 84).mirror().addBox(-0.2215f, -3.2106f, -9.8849f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)3.0f, (float)0.0049f, (float)0.3079f, (float)-0.7216f, (float)-0.2324f, (float)0.2f));
        PartDefinition spine_deco = spine2.addOrReplaceChild("spine_deco", CubeListBuilder.create().texOffs(98, 0).addBox(-13.2f, 0.0f, -16.5f, 26.0f, 25.0f, 16.0f, new CubeDeformation(0.5f)), PartPose.offsetAndRotation((float)0.0f, (float)-7.3f, (float)-6.7f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition legs = mid_pivot.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)4.0f, (float)7.0f));
        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(165, 215).addBox(-6.0f, -2.0261f, -4.1809f, 8.0f, 34.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)15.0f, (float)0.0f, (float)6.0f, (float)-0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition left_deco1 = left_leg.addOrReplaceChild("left_deco1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0f, -8.0f, 1.0f, 8.0f, 28.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)10.9739f, (float)-8.1809f, (float)0.0959f, (float)-0.4349f, (float)-0.0329f));
        PartDefinition left_front_leg = left_leg.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 44).addBox(-5.0f, -2.5649f, -1.6913f, 8.0f, 24.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)32.9739f, (float)-2.1809f, (float)1.0908f, (float)0.0f, (float)0.0f));
        PartDefinition left_ankel_joint = left_front_leg.addOrReplaceChild("left_ankel_joint", CubeListBuilder.create(), PartPose.offset((float)-1.0f, (float)20.6148f, (float)1.661f));
        PartDefinition left_mini_bone = left_ankel_joint.addOrReplaceChild("left_mini_bone", CubeListBuilder.create().texOffs(29, 0).addBox(0.0209f, -3.1113f, 0.0913f, 0.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-1.0f, (float)11.0f, (float)-6.0f, (float)-0.3928f, (float)-0.0035f, (float)1.0E-4f));
        PartDefinition left_deco2 = left_ankel_joint.addOrReplaceChild("left_deco2", CubeListBuilder.create().texOffs(61, 210).addBox(-2.0f, -2.7487f, 0.1981f, 4.0f, 6.0f, 18.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)6.0f, (float)-4.9602f, (float)0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition left_deco3 = left_ankel_joint.addOrReplaceChild("left_deco3", CubeListBuilder.create().texOffs(33, 45).addBox(-0.2f, -11.7017f, -4.0722f, 4.0f, 13.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)9.0f, (float)-7.0f, (float)-0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition left_ankel = left_ankel_joint.addOrReplaceChild("left_ankel", CubeListBuilder.create().texOffs(54, 198).addBox(-3.0f, -0.2489f, -2.0393f, 6.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.0f, (float)0.0f, (float)-0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition left_foot = left_ankel_joint.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)12.0f, (float)-8.0f));
        PartDefinition left_toe = left_foot.addOrReplaceChild("left_toe", CubeListBuilder.create().texOffs(71, 50).addBox(0.0f, 0.2465f, -9.1823f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-1.8218f, (float)-0.2377f, (float)-0.6981f, (float)0.0f, (float)0.0f));
        PartDefinition left_toe2 = left_foot.addOrReplaceChild("left_toe2", CubeListBuilder.create().texOffs(71, 50).addBox(0.0f, 0.2465f, -9.1823f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-2.0f, (float)-1.8218f, (float)-0.2377f, (float)-0.7216f, (float)0.2324f, (float)-0.2f));
        PartDefinition left_toe3 = left_foot.addOrReplaceChild("left_toe3", CubeListBuilder.create().texOffs(71, 50).addBox(0.0f, 0.2465f, -9.1823f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)2.0f, (float)-1.8218f, (float)-0.2377f, (float)-0.7216f, (float)-0.2324f, (float)0.2f));
        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(165, 215).mirror().addBox(-2.0f, -2.0261f, -4.1809f, 8.0f, 34.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-15.0f, (float)0.0f, (float)6.0f, (float)-0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition right_deco1 = right_leg.addOrReplaceChild("right_deco1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0f, -8.0f, 1.0f, 8.0f, 28.0f, 6.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-2.0f, (float)10.9739f, (float)-8.1809f, (float)0.0959f, (float)0.4349f, (float)0.0329f));
        PartDefinition right_front_leg = right_leg.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 44).mirror().addBox(-3.0f, -2.5649f, -1.6913f, 8.0f, 24.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.0f, (float)32.9739f, (float)-2.1809f, (float)1.0908f, (float)0.0f, (float)0.0f));
        PartDefinition right_ankel_joint = right_front_leg.addOrReplaceChild("right_ankel_joint", CubeListBuilder.create(), PartPose.offset((float)1.0f, (float)20.6148f, (float)1.661f));
        PartDefinition right_mini_bone = right_ankel_joint.addOrReplaceChild("right_mini_bone", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(-0.0209f, -3.1113f, 0.0913f, 0.0f, 6.0f, 3.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)1.0f, (float)11.0f, (float)-6.0f, (float)-0.3928f, (float)0.0035f, (float)-1.0E-4f));
        PartDefinition right_deco2 = right_ankel_joint.addOrReplaceChild("right_deco2", CubeListBuilder.create().texOffs(61, 210).mirror().addBox(-2.0f, -2.7487f, 0.1981f, 4.0f, 6.0f, 18.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)6.0f, (float)-4.9602f, (float)0.5236f, (float)0.0f, (float)0.0f));
        PartDefinition right_deco3 = right_ankel_joint.addOrReplaceChild("right_deco3", CubeListBuilder.create().texOffs(33, 45).mirror().addBox(-3.8f, -11.7017f, -4.0722f, 4.0f, 13.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.0f, (float)9.0f, (float)-7.0f, (float)-0.3927f, (float)0.0f, (float)0.0f));
        PartDefinition right_ankel = right_ankel_joint.addOrReplaceChild("right_ankel", CubeListBuilder.create().texOffs(54, 198).mirror().addBox(-3.0f, -0.2489f, -2.0393f, 6.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-1.0f, (float)0.0f, (float)-0.5672f, (float)0.0f, (float)0.0f));
        PartDefinition right_foot = right_ankel_joint.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)12.0f, (float)-8.0f));
        PartDefinition right_toe = right_foot.addOrReplaceChild("right_toe", CubeListBuilder.create().texOffs(71, 50).mirror().addBox(0.0f, 0.2465f, -9.1823f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-1.8218f, (float)-0.2377f, (float)-0.6981f, (float)0.0f, (float)0.0f));
        PartDefinition right_toe2 = right_foot.addOrReplaceChild("right_toe2", CubeListBuilder.create().texOffs(71, 50).mirror().addBox(0.0f, 0.2465f, -9.1823f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)2.0f, (float)-1.8218f, (float)-0.2377f, (float)-0.7216f, (float)-0.2324f, (float)0.2f));
        PartDefinition right_toe3 = right_foot.addOrReplaceChild("right_toe3", CubeListBuilder.create().texOffs(71, 50).mirror().addBox(0.0f, 0.2465f, -9.1823f, 0.0f, 7.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-2.0f, (float)-1.8218f, (float)-0.2377f, (float)-0.7216f, (float)0.2324f, (float)-0.2f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

    public void setupAnim(Ancient_Remnant_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        if (entityIn.getAttackState() != 10 && entityIn.getAttackState() != 11 && entityIn.getAttackState() != 12 && !entityIn.isSleep()) {
            this.animateWalk(Ancient_Remnant_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 4.0f);
        }
        this.animate(entityIn.getAnimationState("idle"), Ancient_Remnant_Animation.IDLE, ageInTicks, entityIn.getNecklace() ? 1.0f : 0.15f);
        this.animate(entityIn.getAnimationState("death"), Ancient_Remnant_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("right_bite"), Ancient_Remnant_Animation.RIGHT_BITE, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("sandstorm_roar"), Ancient_Remnant_Animation.SAND_STORM_ROAR, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("phase_roar"), Ancient_Remnant_Animation.PHASE_ROAR, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("sleep"), Ancient_Remnant_Animation.SLEEP, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("awaken"), Ancient_Remnant_Animation.AWAKEN, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("left_double_stomp"), Ancient_Remnant_Power_Animation.DOUBLE_STOMP2, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("right_double_stomp"), Ancient_Remnant_Power_Animation.DOUBLE_STOMP1, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("ground_tail"), Ancient_Remnant_Power_Animation.GROUND_TAIL, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("tail_swing"), Ancient_Remnant_Power_Animation.TAIL_SWING, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("monolith"), Ancient_Remnant_Power_Animation.MONOLITH, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("right_stomp"), Ancient_Remnant_Animation.STOMP1, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("left_stomp"), Ancient_Remnant_Animation.STOMP2, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("charge"), Ancient_Remnant_Animation.CHARGE, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("charge_prepare"), Ancient_Remnant_Animation.CHARGE_PREPARE, ageInTicks, 1.0f);
        this.animate(entityIn.getAnimationState("charge_stun"), Ancient_Remnant_Animation.CHARGE_STUN, ageInTicks, 1.0f);
        float partialTick = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false);
        if (!entityIn.isSleep()) {
            this.articulateLegs(entityIn.legSolver, partialTick);
        }
        if (!entityIn.getNecklace()) {
            this.applyStatic(Ancient_Remnant_Animation.SLEEP);
        }
        this.desert_necklace.visible = entityIn.getNecklace();
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot += xRot * ((float)Math.PI / 180);
        this.head.yRot += yRot * ((float)Math.PI / 180);
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.children.entrySet()) {
            String partName = (String)entry.getKey();
            ModelPart childPart = (ModelPart)entry.getValue();
            this.partCache.putIfAbsent(partName, childPart);
            this.optionalPartCache.putIfAbsent(partName, Optional.of(childPart));
            if (childPart.children.isEmpty()) continue;
            this.buildPartCache(childPart);
        }
    }

    @NotNull
    public Optional<ModelPart> getAnyDescendantWithName(String name) {
        if ("root".equals(name)) {
            return Optional.of(this.root);
        }
        return this.optionalPartCache.getOrDefault(name, Optional.empty());
    }

    private void articulateLegs(LegSolver legs, float partialTick) {
        float heightBackLeft = legs.legs[0].getHeight(partialTick);
        float heightBackRight = legs.legs[1].getHeight(partialTick);
        float max = (1.0f - Ancient_Remnant_Rework_Model.smin(1.0f - heightBackLeft, 1.0f - heightBackRight, 0.1f)) * 0.8f;
        this.roots.y += max * 16.0f;
        this.right_leg.y += (heightBackRight - max) * 16.0f;
        this.left_leg.y += (heightBackLeft - max) * 16.0f;
    }

    private static float smin(float a, float b, float k) {
        float h = Math.max(k - Math.abs(a - b), 0.0f) / k;
        return Math.min(a, b) - h * h * k * 0.25f;
    }

    public ModelPart root() {
        return this.root;
    }
}

