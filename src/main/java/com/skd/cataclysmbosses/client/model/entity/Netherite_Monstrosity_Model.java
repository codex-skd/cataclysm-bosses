/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
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
package com.skd.cataclysmbosses.client.model.entity;

import com.skd.cataclysmbosses.client.animation.Netherite_Monstrosity_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import com.skd.cataclysmbosses.client.model.compat.CmHierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class Netherite_Monstrosity_Model
extends CmHierarchicalModel<net.minecraft.client.renderer.entity.state.EntityRenderState> {
    private final ModelPart root;
    private final ModelPart roots;
    private final ModelPart lowerbody;
    private final ModelPart upperbody;
    private final ModelPart head;
    private final ModelPart horns;
    private final ModelPart jaw;
    private final ModelPart leftarmjoint;
    private final ModelPart leftarm;
    private final ModelPart leftarm2;
    private final ModelPart lefthand;
    private final ModelPart l_hand_blast_4;
    private final ModelPart l_hand_blast_3;
    private final ModelPart leftfinger1;
    private final ModelPart l_hand_blast_2;
    private final ModelPart leftfinger2;
    private final ModelPart l_hand_blast_1;
    private final ModelPart leftfinger3;
    private final ModelPart l_cannon;
    private final ModelPart l_core;
    private final ModelPart l_flame_2;
    private final ModelPart l_flame_1;
    private final ModelPart rightarmjoint;
    private final ModelPart rightarm;
    private final ModelPart rightarm2;
    private final ModelPart righthand;
    private final ModelPart r_hand_blast_4;
    private final ModelPart r_hand_blast_3;
    private final ModelPart rightfinger1;
    private final ModelPart r_hand_blast_2;
    private final ModelPart rightfinger2;
    private final ModelPart r_hand_blast_1;
    private final ModelPart rightfinger3;
    private final ModelPart r_cannon;
    private final ModelPart r_core;
    private final ModelPart r_flame_1;
    private final ModelPart r_flame_2;
    private final ModelPart rightleg;
    private final ModelPart leftleg;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Netherite_Monstrosity_Model(ModelPart root) {
        super(root);
        this.root = root;
        this.buildPartCache(root);
        this.roots = this.root.getChild("roots");
        this.lowerbody = this.roots.getChild("lowerbody");
        this.upperbody = this.lowerbody.getChild("upperbody");
        this.head = this.upperbody.getChild("head");
        this.horns = this.head.getChild("horns");
        this.jaw = this.head.getChild("jaw");
        this.leftarmjoint = this.upperbody.getChild("leftarmjoint");
        this.leftarm = this.leftarmjoint.getChild("leftarm");
        this.leftarm2 = this.leftarm.getChild("leftarm2");
        this.lefthand = this.leftarm2.getChild("lefthand");
        this.l_hand_blast_4 = this.lefthand.getChild("l_hand_blast_4");
        this.l_hand_blast_3 = this.lefthand.getChild("l_hand_blast_3");
        this.leftfinger1 = this.l_hand_blast_3.getChild("leftfinger1");
        this.l_hand_blast_2 = this.lefthand.getChild("l_hand_blast_2");
        this.leftfinger2 = this.l_hand_blast_2.getChild("leftfinger2");
        this.l_hand_blast_1 = this.lefthand.getChild("l_hand_blast_1");
        this.leftfinger3 = this.l_hand_blast_1.getChild("leftfinger3");
        this.l_cannon = this.lefthand.getChild("l_cannon");
        this.l_core = this.lefthand.getChild("l_core");
        this.l_flame_2 = this.l_core.getChild("l_flame_2");
        this.l_flame_1 = this.l_core.getChild("l_flame_1");
        this.rightarmjoint = this.upperbody.getChild("rightarmjoint");
        this.rightarm = this.rightarmjoint.getChild("rightarm");
        this.rightarm2 = this.rightarm.getChild("rightarm2");
        this.righthand = this.rightarm2.getChild("righthand");
        this.r_hand_blast_4 = this.righthand.getChild("r_hand_blast_4");
        this.r_hand_blast_3 = this.righthand.getChild("r_hand_blast_3");
        this.rightfinger1 = this.r_hand_blast_3.getChild("rightfinger1");
        this.r_hand_blast_2 = this.righthand.getChild("r_hand_blast_2");
        this.rightfinger2 = this.r_hand_blast_2.getChild("rightfinger2");
        this.r_hand_blast_1 = this.righthand.getChild("r_hand_blast_1");
        this.rightfinger3 = this.r_hand_blast_1.getChild("rightfinger3");
        this.r_cannon = this.righthand.getChild("r_cannon");
        this.r_core = this.righthand.getChild("r_core");
        this.r_flame_1 = this.r_core.getChild("r_flame_1");
        this.r_flame_2 = this.r_core.getChild("r_flame_2");
        this.rightleg = this.roots.getChild("rightleg");
        this.leftleg = this.roots.getChild("leftleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition lowerbody = roots.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(175, 193).addBox(-14.0f, -11.0f, -10.5f, 28.0f, 11.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-24.0f, (float)2.0f));
        PartDefinition upperbody = lowerbody.addOrReplaceChild("upperbody", CubeListBuilder.create().texOffs(0, 0).addBox(-37.0f, -57.0f, -15.0f, 74.0f, 57.0f, 30.0f, new CubeDeformation(0.0f)).texOffs(209, 226).addBox(-14.0f, -50.0f, 15.0f, 28.0f, 16.0f, 11.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-11.0f, (float)0.0f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition head = upperbody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 139).addBox(-14.0f, -18.0f, -20.5f, 28.0f, 31.0f, 22.0f, new CubeDeformation(0.0f)).texOffs(246, 112).addBox(-34.0f, -12.5f, -16.0f, 20.0f, 13.0f, 13.0f, new CubeDeformation(0.0f)).texOffs(246, 112).mirror().addBox(14.0f, -12.5f, -16.0f, 20.0f, 13.0f, 13.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(253, 184).addBox(-34.0f, -27.5f, -16.0f, 8.0f, 15.0f, 13.0f, new CubeDeformation(0.0f)).texOffs(169, 171).addBox(26.0f, -15.5f, -16.0f, 8.0f, 3.0f, 13.0f, new CubeDeformation(0.0f)).texOffs(12, 0).addBox(-2.5f, -2.0f, -20.7f, 6.0f, 3.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(17, 5).addBox(-14.25f, 1.5f, -20.7f, 4.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)).texOffs(17, 5).addBox(10.25f, 1.5f, -20.7f, 4.0f, 4.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-33.0f, (float)-16.5f));
        PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offsetAndRotation((float)-4.5f, (float)47.0f, (float)-3.5f, (float)1.0472f, (float)0.0f, (float)0.0f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(209, 2).addBox(-13.5f, -10.0f, -21.9f, 27.0f, 16.0f, 21.0f, new CubeDeformation(0.0f)).texOffs(305, 8).addBox(-13.5f, 6.0f, -21.9f, 27.0f, 5.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(209, 40).addBox(-13.5f, 3.0f, -21.9f, 27.0f, 0.0f, 21.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)11.0f, (float)1.5f, (float)0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition leftarmjoint = upperbody.addOrReplaceChild("leftarmjoint", CubeListBuilder.create(), PartPose.offset((float)37.0f, (float)-38.5f, (float)-2.5f));
        PartDefinition leftarm = leftarmjoint.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(101, 163).addBox(0.0f, -33.5f, -13.5f, 20.0f, 23.0f, 27.0f, new CubeDeformation(0.0f)).texOffs(0, 88).addBox(0.0f, -10.5f, -13.5f, 37.0f, 23.0f, 27.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition leftarm2 = leftarm.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(132, 226).addBox(-11.0f, -4.5f, -8.0f, 22.0f, 20.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)18.0f, (float)12.0f, (float)0.0f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition lefthand = leftarm2.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(136, 264).mirror().addBox(-12.0f, -5.0f, -12.0f, 24.0f, 5.0f, 24.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)17.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition righthand_r1 = lefthand.addOrReplaceChild("righthand_r1", CubeListBuilder.create().texOffs(102, 260).mirror().addBox(-2.5f, -13.5f, 3.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(74, 260).mirror().addBox(-19.5f, -13.5f, 3.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)).mirror(false).texOffs(88, 260).mirror().addBox(-19.5f, -13.5f, 3.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(61, 314).mirror().addBox(-16.5f, -4.5f, -2.0f, 14.0f, 3.0f, 14.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(60, 270).mirror().addBox(-16.5f, -13.5f, -2.0f, 14.0f, 9.0f, 14.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)5.0f, (float)13.5f, (float)9.5f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition lefthand_r1 = lefthand.addOrReplaceChild("lefthand_r1", CubeListBuilder.create().texOffs(88, 260).addBox(-103.0f, -3.0f, -10.5f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-110.0f, (float)3.0f, (float)-8.5f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition righthand_r2 = lefthand.addOrReplaceChild("righthand_r2", CubeListBuilder.create().texOffs(88, 260).mirror().addBox(-10.0f, -3.0f, -10.5f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)3.0f, (float)-8.5f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition lefthand_r2 = lefthand.addOrReplaceChild("lefthand_r2", CubeListBuilder.create().texOffs(74, 260).addBox(-111.5f, -3.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)-118.5f, (float)3.0f, (float)0.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition righthand_r3 = lefthand.addOrReplaceChild("righthand_r3", CubeListBuilder.create().texOffs(74, 260).mirror().addBox(-10.0f, -3.0f, -2.5f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)3.0f, (float)-0.5f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition righthand_r4 = lefthand.addOrReplaceChild("righthand_r4", CubeListBuilder.create().texOffs(74, 260).mirror().addBox(-18.5f, -3.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)3.0f, (float)-8.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition l_hand_blast_4 = lefthand.addOrReplaceChild("l_hand_blast_4", CubeListBuilder.create(), PartPose.offset((float)-10.0f, (float)0.0f, (float)10.0f));
        PartDefinition lefthand_r3 = l_hand_blast_4.addOrReplaceChild("lefthand_r3", CubeListBuilder.create().texOffs(0, 304).addBox(-0.5f, -13.5f, -5.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(0, 329).addBox(2.5f, 1.5f, -2.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 269).addBox(-5.5f, -13.5f, -10.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)13.5f, (float)-0.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition l_hand_blast_3 = lefthand.addOrReplaceChild("l_hand_blast_3", CubeListBuilder.create(), PartPose.offset((float)10.0f, (float)0.0f, (float)10.0f));
        PartDefinition righthand_r5 = l_hand_blast_3.addOrReplaceChild("righthand_r5", CubeListBuilder.create().texOffs(0, 304).mirror().addBox(-9.5f, -13.5f, -5.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 329).mirror().addBox(-9.5f, 1.5f, -2.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 269).mirror().addBox(-9.5f, -13.5f, -10.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.0f, (float)13.5f, (float)-0.5f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition leftfinger1 = l_hand_blast_3.addOrReplaceChild("leftfinger1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5f, -2.5f, -1.5f, 3.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)20.0f, (float)-4.0f));
        PartDefinition l_hand_blast_2 = lefthand.addOrReplaceChild("l_hand_blast_2", CubeListBuilder.create().texOffs(0, 269).mirror().addBox(-10.0f, 0.0f, -5.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 329).mirror().addBox(-10.0f, 15.0f, 3.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 304).mirror().addBox(-10.0f, 0.0f, 0.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)10.0f, (float)0.0f, (float)-10.0f));
        PartDefinition leftfinger2 = l_hand_blast_2.addOrReplaceChild("leftfinger2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5f, -2.5f, -1.5f, 3.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)20.0f, (float)2.0f));
        PartDefinition l_hand_blast_1 = lefthand.addOrReplaceChild("l_hand_blast_1", CubeListBuilder.create().texOffs(0, 269).addBox(-5.0f, 0.0f, -5.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(0, 329).addBox(3.0f, 15.0f, 3.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 304).addBox(0.0f, 0.0f, 0.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-10.0f, (float)0.0f, (float)-10.0f));
        PartDefinition leftfinger3 = l_hand_blast_1.addOrReplaceChild("leftfinger3", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)20.0f, (float)8.5f));
        PartDefinition leftfinger3_r1 = leftfinger3.addOrReplaceChild("leftfinger3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5f, -7.5f, -2.5f, 3.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)5.0f, (float)1.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition l_cannon = lefthand.addOrReplaceChild("l_cannon", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)13.75f, (float)0.0f));
        PartDefinition righthand_r6 = l_cannon.addOrReplaceChild("righthand_r6", CubeListBuilder.create().texOffs(61, 294).mirror().addBox(-7.0f, 7.5f, -7.0f, 14.0f, 5.0f, 14.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(69, 331).mirror().addBox(-6.0f, 2.5f, -6.0f, 12.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-8.25f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition l_core = lefthand.addOrReplaceChild("l_core", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)13.0f, (float)0.0f));
        PartDefinition righthand_r7 = l_core.addOrReplaceChild("righthand_r7", CubeListBuilder.create().texOffs(0, 341).mirror().addBox(-4.0f, 6.5f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(-0.5f)).mirror(false).texOffs(0, 357).mirror().addBox(-4.0f, 6.5f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)-10.5f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition l_flame_2 = l_core.addOrReplaceChild("l_flame_2", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition righthand_r8 = l_flame_2.addOrReplaceChild("righthand_r8", CubeListBuilder.create().texOffs(-16, 373).mirror().addBox(-8.0f, 0.0f, -8.0f, 16.0f, 0.0f, 16.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-3.0663f, (float)-1.0163f, (float)-2.2196f));
        PartDefinition l_flame_1 = l_core.addOrReplaceChild("l_flame_1", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition righthand_r9 = l_flame_1.addOrReplaceChild("righthand_r9", CubeListBuilder.create().texOffs(-16, 373).mirror().addBox(-8.0f, 0.0f, -8.0f, 16.0f, 0.0f, 16.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-3.1416f, (float)-1.1781f, (float)2.7489f));
        PartDefinition rightarmjoint = upperbody.addOrReplaceChild("rightarmjoint", CubeListBuilder.create(), PartPose.offset((float)-37.0f, (float)-38.5f, (float)-2.5f));
        PartDefinition rightarm = rightarmjoint.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(101, 163).mirror().addBox(-20.0f, -33.5f, -13.5f, 20.0f, 23.0f, 27.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 88).mirror().addBox(-37.0f, -10.5f, -13.5f, 37.0f, 23.0f, 27.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition rightarm2 = rightarm.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(132, 226).addBox(-11.0f, -4.5f, -8.0f, 22.0f, 22.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-19.0f, (float)12.0f, (float)0.0f, (float)-0.1309f, (float)0.0f, (float)0.0f));
        PartDefinition righthand = rightarm2.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(136, 264).addBox(-12.0f, -5.0f, -12.0f, 24.0f, 5.0f, 24.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)17.0f, (float)0.0f, (float)-0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition lefthand_r4 = righthand.addOrReplaceChild("lefthand_r4", CubeListBuilder.create().texOffs(102, 260).addBox(-0.5f, -13.5f, 3.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(74, 260).addBox(16.5f, -13.5f, 3.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)).texOffs(88, 260).addBox(16.5f, -13.5f, 3.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(61, 314).addBox(2.5f, -4.5f, -2.0f, 14.0f, 3.0f, 14.0f, new CubeDeformation(0.0f)).texOffs(60, 270).addBox(2.5f, -13.5f, -2.0f, 14.0f, 9.0f, 14.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.0f, (float)13.5f, (float)9.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition righthand_r10 = righthand.addOrReplaceChild("righthand_r10", CubeListBuilder.create().texOffs(88, 260).mirror().addBox(100.0f, -3.0f, -10.5f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)110.0f, (float)3.0f, (float)-8.5f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition lefthand_r5 = righthand.addOrReplaceChild("lefthand_r5", CubeListBuilder.create().texOffs(88, 260).addBox(7.0f, -3.0f, -10.5f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)3.0f, (float)-8.5f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition righthand_r11 = righthand.addOrReplaceChild("righthand_r11", CubeListBuilder.create().texOffs(74, 260).mirror().addBox(108.5f, -3.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)).mirror(false), PartPose.offsetAndRotation((float)118.5f, (float)3.0f, (float)0.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
        PartDefinition lefthand_r6 = righthand.addOrReplaceChild("lefthand_r6", CubeListBuilder.create().texOffs(74, 260).addBox(7.0f, -3.0f, -2.5f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)0.0f, (float)3.0f, (float)-0.5f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition lefthand_r7 = righthand.addOrReplaceChild("lefthand_r7", CubeListBuilder.create().texOffs(74, 260).addBox(15.5f, -3.0f, -2.0f, 3.0f, 6.0f, 4.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)0.0f, (float)3.0f, (float)-8.5f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition r_hand_blast_4 = righthand.addOrReplaceChild("r_hand_blast_4", CubeListBuilder.create(), PartPose.offset((float)10.0f, (float)0.0f, (float)10.0f));
        PartDefinition righthand_r12 = r_hand_blast_4.addOrReplaceChild("righthand_r12", CubeListBuilder.create().texOffs(0, 304).mirror().addBox(-9.5f, -13.5f, -5.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 329).mirror().addBox(-9.5f, 1.5f, -2.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 269).mirror().addBox(-9.5f, -13.5f, -10.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)-5.0f, (float)13.5f, (float)-0.5f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        PartDefinition r_hand_blast_3 = righthand.addOrReplaceChild("r_hand_blast_3", CubeListBuilder.create(), PartPose.offset((float)-10.0f, (float)0.0f, (float)10.0f));
        PartDefinition lefthand_r8 = r_hand_blast_3.addOrReplaceChild("lefthand_r8", CubeListBuilder.create().texOffs(0, 304).addBox(-0.5f, -13.5f, -5.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)).texOffs(0, 329).addBox(2.5f, 1.5f, -2.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 269).addBox(-5.5f, -13.5f, -10.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)5.0f, (float)13.5f, (float)-0.5f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition rightfinger1 = r_hand_blast_3.addOrReplaceChild("rightfinger1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5f, -2.5f, -1.5f, 3.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)20.0f, (float)-4.0f));
        PartDefinition r_hand_blast_2 = righthand.addOrReplaceChild("r_hand_blast_2", CubeListBuilder.create().texOffs(0, 269).addBox(-5.0f, 0.0f, -5.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)).texOffs(0, 329).addBox(3.0f, 15.0f, 3.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(0, 304).addBox(0.0f, 0.0f, 0.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-10.0f, (float)0.0f, (float)-10.0f));
        PartDefinition rightfinger2 = r_hand_blast_2.addOrReplaceChild("rightfinger2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5f, -2.5f, -1.5f, 3.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)0.0f, (float)20.0f, (float)2.0f));
        PartDefinition r_hand_blast_1 = righthand.addOrReplaceChild("r_hand_blast_1", CubeListBuilder.create().texOffs(0, 269).mirror().addBox(-10.0f, 0.0f, -5.0f, 15.0f, 20.0f, 15.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 329).mirror().addBox(-10.0f, 15.0f, 3.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).mirror(false).texOffs(0, 304).mirror().addBox(-10.0f, 0.0f, 0.0f, 10.0f, 15.0f, 10.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offset((float)10.0f, (float)0.0f, (float)-10.0f));
        PartDefinition rightfinger3 = r_hand_blast_1.addOrReplaceChild("rightfinger3", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)20.0f, (float)8.5f));
        PartDefinition rightfinger3_r1 = rightfinger3.addOrReplaceChild("rightfinger3_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5f, -7.5f, -2.5f, 3.0f, 15.0f, 5.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)0.0f, (float)5.0f, (float)1.0f, (float)0.0f, (float)-3.1416f, (float)0.0f));
        PartDefinition r_cannon = righthand.addOrReplaceChild("r_cannon", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)13.75f, (float)0.0f));
        PartDefinition lefthand_r9 = r_cannon.addOrReplaceChild("lefthand_r9", CubeListBuilder.create().texOffs(61, 294).addBox(-7.0f, 7.5f, -7.0f, 14.0f, 5.0f, 14.0f, new CubeDeformation(0.0f)).texOffs(69, 331).addBox(-6.0f, 2.5f, -6.0f, 12.0f, 8.0f, 12.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-8.25f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition r_core = righthand.addOrReplaceChild("r_core", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)13.0f, (float)0.0f));
        PartDefinition lefthand_r10 = r_core.addOrReplaceChild("lefthand_r10", CubeListBuilder.create().texOffs(0, 341).addBox(-4.0f, 6.5f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)).texOffs(0, 357).addBox(-4.0f, 6.5f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.2f)), PartPose.offsetAndRotation((float)0.0f, (float)-10.5f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition r_flame_1 = r_core.addOrReplaceChild("r_flame_1", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition lefthand_r11 = r_flame_1.addOrReplaceChild("lefthand_r11", CubeListBuilder.create().texOffs(-16, 373).addBox(-8.0f, 0.0f, -8.0f, 16.0f, 0.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-3.0663f, (float)1.0163f, (float)2.2196f));
        PartDefinition r_flame_2 = r_core.addOrReplaceChild("r_flame_2", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition lefthand_r12 = r_flame_2.addOrReplaceChild("lefthand_r12", CubeListBuilder.create().texOffs(-16, 373).addBox(-8.0f, 0.0f, -8.0f, 16.0f, 0.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.0f, (float)-3.1416f, (float)1.1781f, (float)-2.7489f));
        PartDefinition rightleg = roots.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 193).addBox(-19.0f, -2.0f, -7.5f, 24.0f, 29.0f, 19.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-14.0f, (float)-27.0f, (float)0.0f, (float)0.0f, (float)0.0873f, (float)0.0f));
        PartDefinition leftleg = roots.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(0, 193).mirror().addBox(-5.0f, -2.0f, -7.5f, 24.0f, 29.0f, 19.0f, new CubeDeformation(0.0f)).mirror(false), PartPose.offsetAndRotation((float)14.0f, (float)-27.0f, (float)0.0f, (float)0.0f, (float)-0.0873f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)512, (int)512);
    }

        @Override
    public void setupAnim(EntityRenderState state) {
        super.setupAnim(state);
        // TODO (26.2): port animate/animateWalk calls from old setupAnim(entity, limbSwing, ...)
        // Original body stubbed for compile; see git history for original.
        // if (false) { // stubbed for compile
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        if (entity.getAttackState() != 8 || entity.attackTicks <= 19 || entity.attackTicks >= 49) {
            this.animateWalk(Netherite_Monstrosity_Animation.WALK, limbSwing, limbSwingAmount, 2.0f, 2.0f);
        }
        if (!entity.getIsAwaken()) {
            this.applyStatic(Netherite_Monstrosity_Animation.SLEEP);
        }
        this.animate(entity.getAnimationState("idle"), Netherite_Monstrosity_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("smash"), Netherite_Monstrosity_Animation.SMASH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("sleep"), Netherite_Monstrosity_Animation.SLEEP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("awake"), Netherite_Monstrosity_Animation.AWAKE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("phase_two"), Netherite_Monstrosity_Animation.PHASE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("death"), Netherite_Monstrosity_Animation.DEATH, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("fire"), Netherite_Monstrosity_Animation.FIRE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("drain"), Netherite_Monstrosity_Animation.DRAIN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("shoulder_check"), Netherite_Monstrosity_Animation.SHOULDER_CHECK, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("overpower"), Netherite_Monstrosity_Animation.OVERPOWER, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("flare_shot"), Netherite_Monstrosity_Animation.FLARE_SHOT, ageInTicks, 1.0f);
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot = xRot * ((float)Math.PI / 180);
        this.head.yRot = yRot * ((float)Math.PI / 180);
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.getAllParts().entrySet()) {
            String partName = (String)entry.getKey();
            ModelPart childPart = (ModelPart)entry.getValue();
            this.partCache.putIfAbsent(partName, childPart);
            this.optionalPartCache.putIfAbsent(partName, Optional.of(childPart));
            if (getChildrenMap(childPart).isEmpty()) continue;
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

    public ModelPart root() {
        return this.root;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, ModelPart> getChildrenMap(ModelPart part) {
        try {
            java.lang.reflect.Field f = ModelPart.class.getDeclaredField("children");
            f.setAccessible(true);
            return (Map<String, ModelPart>) f.get(part);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

