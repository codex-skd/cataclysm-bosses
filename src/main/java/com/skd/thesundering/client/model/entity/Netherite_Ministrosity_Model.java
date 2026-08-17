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
package com.skd.thesundering.client.model.entity;

import com.skd.thesundering.client.animation.Netherite_Ministrosity_Animation;
import com.skd.thesundering.entity.Pet.Netherite_Ministrosity_Entity;
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

public class Netherite_Ministrosity_Model
extends HierarchicalModel<Netherite_Ministrosity_Entity> {
    private final ModelPart root;
    private final ModelPart roots;
    private final ModelPart mid_root;
    private final ModelPart legs;
    private final ModelPart body;
    private final ModelPart jaw;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final Map<String, ModelPart> partCache = new Object2ObjectOpenHashMap();
    private final Map<String, Optional<ModelPart>> optionalPartCache = new Object2ObjectOpenHashMap();

    public Netherite_Ministrosity_Model(ModelPart root) {
        this.root = root;
        this.buildPartCache(root);
        this.roots = this.root.getChild("roots");
        this.mid_root = this.roots.getChild("mid_root");
        this.legs = this.mid_root.getChild("legs");
        this.body = this.legs.getChild("body");
        this.jaw = this.body.getChild("jaw");
        this.right_arm = this.body.getChild("right_arm");
        this.left_arm = this.body.getChild("left_arm");
        this.right_leg = this.legs.getChild("right_leg");
        this.left_leg = this.legs.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        PartDefinition mid_root = roots.addOrReplaceChild("mid_root", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition legs = mid_root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset((float)0.0f, (float)-4.0f, (float)0.0f));
        PartDefinition body = legs.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5f, -5.0f, -3.5f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(1, 28).addBox(-3.5f, -6.0f, -3.5f, 7.0f, 1.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)0.0f, (float)0.0f));
        PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 14).addBox(-3.5f, -6.0f, -7.0f, 7.0f, 5.0f, 7.0f, new CubeDeformation(0.0f)).texOffs(44, 16).addBox(-1.0f, -3.0f, -7.1f, 2.0f, 1.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(30, 10).addBox(-6.5f, -6.0f, -3.5f, 13.0f, 5.0f, 0.0f, new CubeDeformation(0.0f)).texOffs(29, 0).addBox(-3.5f, -1.0f, -7.0f, 7.0f, 1.0f, 7.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)-5.0f, (float)3.5f));
        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(29, 16).addBox(-4.5f, -1.0f, -2.0f, 5.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(30, 34).addBox(-5.5f, -1.0f, -2.0f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-4.0f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)-0.7418f));
        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(29, 25).addBox(-0.5f, -1.0f, -2.0f, 5.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)).texOffs(41, 34).addBox(4.5f, -1.0f, -2.0f, 1.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)4.0f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.0f, (float)0.7418f));
        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 36).addBox(-1.475f, 0.0f, -2.0f, 3.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)-2.0f, (float)0.0f, (float)0.0f));
        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(15, 37).addBox(-1.525f, 0.0f, -2.0f, 3.0f, 4.0f, 4.0f, new CubeDeformation(0.0f)), PartPose.offset((float)2.0f, (float)0.0f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(Netherite_Ministrosity_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animate(entity.getAnimationState("idle"), Netherite_Ministrosity_Animation.IDLE, ageInTicks, 1.0f);
        this.animateWalk(Netherite_Ministrosity_Animation.WALK, limbSwing, limbSwingAmount, 2.0f, 2.0f);
        if (!entity.getIsAwaken()) {
            this.applyStatic(Netherite_Ministrosity_Animation.SLEEP);
        }
        this.animate(entity.getAnimationState("operation"), Netherite_Ministrosity_Animation.OPERATION, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("chest_open"), Netherite_Ministrosity_Animation.CHEST_OPEN, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("chest_loop"), Netherite_Ministrosity_Animation.CHEST_LOOP, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("chest_close"), Netherite_Ministrosity_Animation.CHEST_CLOSE, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("sit_start"), Netherite_Ministrosity_Animation.SIT, ageInTicks, 1.0f);
        this.animate(entity.getAnimationState("sit_end"), Netherite_Ministrosity_Animation.SIT_END, ageInTicks, 1.0f);
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

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.roots.yRot = yRot * ((float)Math.PI / 180);
    }

    public ModelPart root() {
        return this.root;
    }
}

