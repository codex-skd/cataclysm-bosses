/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Ceraunus_Model;
import com.skd.cataclysmbosses.entity.projectile.Player_Ceraunus_Entity;
import com.skd.cataclysmbosses.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Player_Ceraunus_Renderer extends EntityRenderer<Player_Ceraunus_Entity> {
    private final Ceraunus_Model model;
    private static final Identifier TEXTURE = new ResourceLocation("cataclysm_bosses", "textures/entity/player_ceraunus.png");
    private static final Identifier CHAIN_TEXTURE = new ResourceLocation("cataclysm_bosses", "textures/entity/player_ceraunus_chain.png");

    public Player_Ceraunus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        this.model = new Ceraunus_Model(renderManagerIn.bakeLayer(CMModelLayers.CERAUNUS_MODEL));
    }

    @Override
    public void render(Player_Ceraunus_Entity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource provider, int light) {
        matrices.pushPose();
        float yRot = Mth.lerp((float)tickDelta, (float)entity.yRotO, (float)entity.getYRot());
        float xRot = Mth.lerp((float)tickDelta, (float)entity.xRotO, (float)entity.getXRot());
        matrices.mulPose(Axis.YP.rotationDegrees(yRot - 90.0f));
        matrices.mulPose(Axis.ZP.rotationDegrees(xRot + 90.0f));
        this.model.renderToBuffer(matrices, provider.getBuffer(this.model.renderType(TEXTURE)), light, OverlayTexture.NO_OVERLAY);
        matrices.popPose();
    }

    @Override
    public Identifier getTextureLocation(Player_Ceraunus_Entity entity) {
        return TEXTURE;
    }
}

