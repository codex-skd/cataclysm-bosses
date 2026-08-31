/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  net.neoforged.bus.api.Event
 *  net.neoforged.neoforge.client.event.RenderLivingEvent$Post
 *  net.neoforged.neoforge.client.event.RenderLivingEvent$Pre
 *  net.neoforged.neoforge.client.event.RenderNameTagEvent
 *  net.neoforged.neoforge.common.NeoForge
 */
package com.skd.cataclysmbosses.client.render.entity;

import com.skd.cataclysmbosses.client.model.CMModelLayers;
import com.skd.cataclysmbosses.client.model.entity.Scylla_Model;
import com.skd.cataclysmbosses.client.render.layer.LayerGenericGlowing;
import com.skd.cataclysmbosses.client.render.layer.Scylla_Eye_Spark_Layer;
import com.skd.cataclysmbosses.client.render.layer.Scylla_Snake_Layer;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import com.skd.cataclysmbosses.client.render.compat.CmMobRenderer;
import com.skd.cataclysmbosses.client.render.compat.CmMultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.NeoForge;

@OnlyIn(value=Dist.CLIENT)
public class Scylla_Renderer
extends CmMobRenderer<Scylla_Entity> {
    private static final Identifier SCYLLA_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/scylla_no_snake.png");
    private static final Identifier SCYLLA_EYE_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/scylla/scylla_eye.png");

    public Scylla_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Scylla_Model(renderManagerIn.bakeLayer(CMModelLayers.SCYLLA_MODEL)), 0.75f);
        this.addLayer(new Scylla_Snake_Layer(this));
        this.addLayer(new Scylla_Eye_Spark_Layer(this, renderManagerIn));
        this.addLayer(new LayerGenericGlowing(this, SCYLLA_EYE_TEXTURES));
    }

    public Identifier getTextureLocation(Scylla_Entity entity) {
        return SCYLLA_TEXTURES;
    }

    // PORT TODO(26.2): the full render body (model attackTime/riding/young setup, setupRotations,
    // prepareMobModel/setupAnim, renderToBuffer with the ARGB death-fade alpha, the Scylla_Snake /
    // Eye_Spark / glow layers, and the RenderLivingEvent.Pre/Post + RenderNameTagEvent firing) needs
    // a real port to the 26.2 SubmitNodeCollector pipeline: NeoForge.EVENT_BUS.post now returns
    // boolean, RenderLivingEvent/RenderNameTagEvent ctors take a LivingEntityRenderer +
    // SubmitNodeCollector which the CmMultiBufferSource bridge does not expose. Stubbed to match the
    // other boss renderers until the bridge grows a SubmitNodeCollector accessor.
    protected void render(Scylla_Entity entityIn, float partialTicks, PoseStack matrixStackIn, CmMultiBufferSource bufferIn, int packedLightIn) {
    }

    public boolean shouldRender(Scylla_Entity livingentity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingentity, camera, camX, camY, camZ)) {
            return true;
        }
        Entity weapon = livingentity.getAnchor();
        if (weapon != null) {
            Vec3 vec3 = livingentity.position();
            Vec3 vec31 = weapon.position();
            return camera.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
        }
        return false;
    }

    protected float getFlipDegrees(Scylla_Entity entity) {
        return 0.0f;
    }

    protected void scale(Scylla_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.15f, 1.15f, 1.15f);
    }
}

