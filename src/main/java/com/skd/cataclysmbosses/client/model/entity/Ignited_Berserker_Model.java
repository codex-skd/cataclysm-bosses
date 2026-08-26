/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
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

import com.skd.cataclysmbosses.client.animation.Ignited_Berserker_Animation;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.jetbrains.annotations.NotNull;

public class Ignited_Berserker_Model<T extends Ignited_Berserker_Entity>
extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart everything;
    private final ModelPart mid_root;
    private final ModelPart rod;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart right_shoulder;
    private final ModelPart left_shoulder;
    private final ModelPart edges;
    private final ModelPart right_f_blade;
    private final ModelPart right_b_blade;
    private final ModelPart left_b_blade;
    private final ModelPart left_f_blade;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Ignited_Berserker_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.everything = root.getChild("everything");
        this.mid_root = this.everything.getChild("mid_root");
        this.rod = this.mid_root.getChild("rod");
        this.body = this.rod.getChild("body");
        this.head = this.body.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.right_shoulder = this.body.getChild("right_shoulder");
        this.left_shoulder = this.body.getChild("left_shoulder");
        this.edges = this.body.getChild("edges");
        this.right_f_blade = this.edges.getChild("right_f_blade");
        this.right_b_blade = this.edges.getChild("right_b_blade");
        this.left_b_blade = this.edges.getChild("left_b_blade");
        this.left_f_blade = this.edges.getChild("left_f_blade");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition everything = partdefinition.addOrReplaceChild("everything", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition mid_root = everything.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition rod = mid_root.addOrReplaceChild("rod", CubeListBuilder.create(), PartPose.offsetAndRotation((float)0.0f, (float)-16.0f, (float)-0.5f, (float)0.0873f, (float)0.0f, (float)0.0f));
        PartDefinition guard1 = rod.addOrReplaceChild("guard1", CubeListBuilder.create().texOffs(13, 40).addBox(-1.5f, -9.0f, -1.5f, 3.0f, 19.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)0.0f, (float)0.5f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition body = rod.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0f, -5.0f, -3.5f, 8.0f, 12.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-5.0f, (float)2.0f));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-8.0f, (float)-1.5f));
        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(46, 47).addBox(-3.0f, 0.0f, -4.0f, 6.0f, 2.0f, 5.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-1.0f, (float)0.0f));
        PartDefinition right_shoulder = body.addOrReplaceChild("right_shoulder", CubeListBuilder.create().texOffs(51, 31).addBox(-3.0f, -2.0f, -1.0f, 4.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-3.0f, (float)-4.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)-0.1309f));
        PartDefinition left_shoulder = body.addOrReplaceChild("left_shoulder", CubeListBuilder.create().texOffs(51, 24).addBox(-1.0f, -2.0f, -1.0f, 4.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)3.0f, (float)-4.0f, (float)-2.0f, (float)0.0f, (float)0.0f, (float)0.1309f));
        PartDefinition edges = body.addOrReplaceChild("edges", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)5.0f, (float)-1.5f));
        PartDefinition right_f_blade = edges.addOrReplaceChild("right_f_blade", CubeListBuilder.create().texOffs(26, 57).addBox(-0.9899f, -2.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(38, 26).addBox(-2.5f, -25.25f, -0.5f, 5.0f, 24.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-11.0f, (float)-2.0f, (float)-11.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition guard2 = right_f_blade.addOrReplaceChild("guard2", CubeListBuilder.create().texOffs(18, 64).addBox(-2.4f, 3.0f, -0.5f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 60).addBox(-3.4f, 4.0f, -0.5f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition guard3 = right_f_blade.addOrReplaceChild("guard3", CubeListBuilder.create().texOffs(60, 38).addBox(0.4f, 4.0f, -1.0f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(64, 22).addBox(0.4f, 3.0f, -1.0f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(64, 63).addBox(-1.6f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition guard4 = right_f_blade.addOrReplaceChild("guard4", CubeListBuilder.create().texOffs(50, 64).addBox(-0.4f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition guard5 = right_f_blade.addOrReplaceChild("guard5", CubeListBuilder.create().texOffs(51, 16).addBox(0.4f, -1.0f, -1.5f, 4.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition right_b_blade = edges.addOrReplaceChild("right_b_blade", CubeListBuilder.create().texOffs(48, 55).addBox(-0.9899f, -2.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(38, 0).addBox(-2.5f, -25.25f, -0.5f, 5.0f, 24.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-11.0f, (float)-2.0f, (float)11.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition guard6 = right_b_blade.addOrReplaceChild("guard6", CubeListBuilder.create().texOffs(64, 6).addBox(-2.4f, 3.0f, -1.5f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(57, 55).addBox(-3.4f, 4.0f, -1.5f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition guard7 = right_b_blade.addOrReplaceChild("guard7", CubeListBuilder.create().texOffs(57, 59).addBox(0.4f, 4.0f, -1.0f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(64, 14).addBox(0.4f, 3.0f, -1.0f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(64, 46).addBox(-1.6f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition guard8 = right_b_blade.addOrReplaceChild("guard8", CubeListBuilder.create().texOffs(45, 64).addBox(-0.4f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition guard9 = right_b_blade.addOrReplaceChild("guard9", CubeListBuilder.create().texOffs(51, 8).addBox(0.4f, -1.0f, -1.5f, 4.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition left_b_blade = edges.addOrReplaceChild("left_b_blade", CubeListBuilder.create().texOffs(39, 55).addBox(-1.0101f, -2.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 34).addBox(-2.5f, -25.25f, -0.5f, 5.0f, 24.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)11.0f, (float)-2.0f, (float)11.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
        PartDefinition guard10 = left_b_blade.addOrReplaceChild("guard10", CubeListBuilder.create().texOffs(55, 63).addBox(0.4f, 3.0f, -1.5f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(13, 34).addBox(0.4f, 4.0f, -1.5f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.5f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition guard11 = left_b_blade.addOrReplaceChild("guard11", CubeListBuilder.create().texOffs(26, 43).addBox(-3.4f, 4.0f, -1.0f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(0, 64).addBox(-2.4f, 3.0f, -1.0f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(40, 64).addBox(-0.4f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition guard12 = left_b_blade.addOrReplaceChild("guard12", CubeListBuilder.create().texOffs(35, 64).addBox(-1.6f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition guard13 = left_b_blade.addOrReplaceChild("guard13", CubeListBuilder.create().texOffs(51, 0).addBox(-4.4f, -1.0f, -1.5f, 4.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition left_f_blade = edges.addOrReplaceChild("left_f_blade", CubeListBuilder.create().texOffs(51, 38).addBox(-1.0101f, -2.0f, -1.0f, 2.0f, 6.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(25, 17).addBox(-2.5f, -25.25f, -0.5f, 5.0f, 24.0f, 1.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)11.0f, (float)-2.0f, (float)-11.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
        PartDefinition guard14 = left_f_blade.addOrReplaceChild("guard14", CubeListBuilder.create().texOffs(60, 42).addBox(0.4f, 3.0f, -0.5f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(25, 0).addBox(0.4f, 4.0f, -0.5f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)-0.5f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition guard15 = left_f_blade.addOrReplaceChild("guard15", CubeListBuilder.create().texOffs(25, 4).addBox(-3.4f, 4.0f, -1.0f, 3.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(9, 63).addBox(-2.4f, 3.0f, -1.0f, 2.0f, 1.0f, 2.0f, new CubeDeformation(0.0f)).texOffs(33, 8).addBox(-0.4f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        PartDefinition guard16 = left_f_blade.addOrReplaceChild("guard16", CubeListBuilder.create().texOffs(0, 0).addBox(-1.6f, -1.0f, 0.0f, 2.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7854f));
        PartDefinition guard17 = left_f_blade.addOrReplaceChild("guard17", CubeListBuilder.create().texOffs(26, 49).addBox(-4.4f, -1.0f, -1.5f, 4.0f, 4.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.9899f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7854f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)128, (int)128);
    }

    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        if (((Internal_Animation_Monster)((Object)entity)).getAttackState() == 0) {
            this.animateWalk(Ignited_Berserker_Animation.WALK, limbSwing, limbSwingAmount, 1.0f, 2.0f);
            this.edges.yRot -= ageInTicks * 0.1f;
        }
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("idle"), Ignited_Berserker_Animation.IDLE, ageInTicks, 1.0f);
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("x_slash"), Ignited_Berserker_Animation.X_SLASH, ageInTicks, 1.0f);
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("mixer_start"), Ignited_Berserker_Animation.MIXER_START, ageInTicks, 1.0f);
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("mixer_idle"), Ignited_Berserker_Animation.MIXER_IDLE, ageInTicks, 1.0f);
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("mixer_finish"), Ignited_Berserker_Animation.MIXER_FINISH, ageInTicks, 1.0f);
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("sword_dance_left"), Ignited_Berserker_Animation.SWORD_DANCE_LEFT, ageInTicks, 1.0f);
        this.animate(((Ignited_Berserker_Entity)((Object)entity)).getAnimationState("sword_dance_right"), Ignited_Berserker_Animation.SWORD_DANCE_RIGHT, ageInTicks, 1.0f);
    }

    private void buildPartCache(ModelPart part) {
        for (Map.Entry entry : part.children.entrySet()) {
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

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head.xRot = xRot * ((float)Math.PI / 180);
        this.head.yRot = yRot * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int alpha) {
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, alpha);
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

