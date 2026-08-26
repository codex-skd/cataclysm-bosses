package com.skd.cataclysmbosses.client.model.entity;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Drowned_Host_Model extends ZombieModel<ZombieRenderState> {
    public Drowned_Host_Model(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation cubeDeformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(cubeDeformation, 0.0f);
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation), PartPose.offset(5.0f, 2.0f, 0.0f));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation), PartPose.offset(1.9f, 12.0f, 0.0f));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(ZombieRenderState state) {
        super.setupAnim(state);
        // PORT NOTE (26.2): custom trident arm pose and symbiocto passenger logic are
        // deferred to the animation/model cluster (needs state.isPassenger etc.).
        // Original code:
        //   if (leftArmPose == THROW_SPEAR) { leftArm.xRot = ... }
        //   if (isVehicle && passenger is Symbiocto_Entity) { head.xRot -= ... }
        //   if (rightArmPose == THROW_SPEAR) { ... }
        //   if (swimAmount > 0) { ... swim interpolations ... }
    }
}
