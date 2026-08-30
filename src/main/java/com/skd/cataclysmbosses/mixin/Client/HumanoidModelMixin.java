/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.Model
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 *  net.neoforged.bus.api.Event
 *  net.neoforged.neoforge.common.NeoForge
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.skd.cataclysmbosses.mixin.Client;

import com.skd.cataclysmbosses.client.event.EventPosePlayerHand;
import java.util.function.Function;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.NeoForge;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HumanoidModel.class})
public abstract class HumanoidModelMixin
extends Model {
    public HumanoidModelMixin(ModelPart p_root, Function<Identifier, RenderType> p_103110_) {
        super(p_root, p_103110_);
    }

    @Inject(at={@At(value="HEAD")}, remap=true, method={"Lnet/minecraft/client/model/HumanoidModel;poseRightArm(Lnet/minecraft/world/entity/LivingEntity;)V"}, cancellable=true)
    private void custom_poseRightArm(LivingEntity entity, CallbackInfo ci) {
        EventPosePlayerHand event = new EventPosePlayerHand(entity, (HumanoidModel)(Object)this, false);
        NeoForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == EventPosePlayerHand.Result.ALLOW) {
            ci.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, remap=true, method={"Lnet/minecraft/client/model/HumanoidModel;poseLeftArm(Lnet/minecraft/world/entity/LivingEntity;)V"}, cancellable=true)
    private void custom_poseLeftArm(LivingEntity entity, CallbackInfo ci) {
        EventPosePlayerHand event = new EventPosePlayerHand(entity, (HumanoidModel)(Object)this, true);
        NeoForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == EventPosePlayerHand.Result.ALLOW) {
            ci.cancel();
        }
    }
}

