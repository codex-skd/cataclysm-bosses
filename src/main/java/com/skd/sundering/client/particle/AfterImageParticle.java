/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.blaze3d.vertex.VertexFormatElement
 *  net.minecraft.client.Camera
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleProvider
 *  net.minecraft.client.particle.ParticleRenderType
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.MultiBufferSource$BufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 *  org.jetbrains.annotations.NotNull
 */
package com.skd.sundering.client.particle;

import com.skd.sundering.client.particle.Options.AfterImageParticleOptions;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.config.CMClientConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.util.function.Function;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class AfterImageParticle
extends Particle {
    private final int EntityId;
    private final boolean ghost;

    public AfterImageParticle(ClientLevel world, double x, double y, double z, int r, int g, int b, int entityId, boolean ghost, int lifetimes) {
        super(world, x, y, z);
        this.setSize(6.0f, 6.0f);
        this.x = x;
        this.y = y;
        this.z = z;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        this.EntityId = entityId;
        this.lifetime = lifetimes;
        this.ghost = ghost;
    }

    public AABB getRenderBoundingBox(float partialTicks) {
        return this.getBoundingBox().inflate(0.0);
    }

    public void tick() {
        Entity from;
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
        if ((from = this.getFromEntity()) == null) {
            this.remove();
        }
    }

    public Entity getFromEntity() {
        return this.EntityId == -1 ? null : this.level.getEntity(this.EntityId);
    }

    public void render(@NotNull VertexConsumer vertex, Camera camera, float tick) {
        LivingEntity living;
        EntityRenderer rendererRaw;
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        Vec3 vec3 = camera.getPosition();
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        double lerpX = Mth.lerp((double)tick, (double)this.xo, (double)this.x);
        double lerpY = Mth.lerp((double)tick, (double)this.yo, (double)this.y);
        double lerpZ = Mth.lerp((double)tick, (double)this.zo, (double)this.z);
        float colorR = this.rCol / 255.0f;
        float colorG = this.gCol / 255.0f;
        float colorB = this.bCol / 255.0f;
        float colorA = 0.5f / Math.abs((float)this.age + 1.0f);
        PoseStack stack = new PoseStack();
        Entity entity = this.getFromEntity();
        if (entity instanceof LivingEntity && (rendererRaw = entityRenderDispatcher.getRenderer((Entity)(living = (LivingEntity)entity))) instanceof LivingEntityRenderer) {
            LivingEntityRenderer renderer = (LivingEntityRenderer)rendererRaw;
            Function<VertexConsumer, VertexConsumer> createTintedBuffer = originalBuffer -> new VertexConsumer(){
                final /* synthetic */ VertexConsumer val$originalBuffer;
                final /* synthetic */ float val$colorR;
                final /* synthetic */ float val$colorG;
                final /* synthetic */ float val$colorB;
                final /* synthetic */ float val$colorA;
                {
                    this.val$originalBuffer = vertexConsumer;
                    this.val$colorR = f;
                    this.val$colorG = f2;
                    this.val$colorB = f3;
                    this.val$colorA = f4;
                }

                public VertexConsumer addVertex(float x, float y, float z) {
                    this.val$originalBuffer.addVertex(x, y, z);
                    return this;
                }

                public VertexConsumer setColor(int r, int g, int b, int a) {
                    this.val$originalBuffer.setColor((int)((float)r * this.val$colorR), (int)((float)g * this.val$colorG), (int)((float)b * this.val$colorB), (int)((float)a * this.val$colorA));
                    return this;
                }

                public VertexConsumer setUv(float u, float v) {
                    this.val$originalBuffer.setUv(u, v);
                    return this;
                }

                public VertexConsumer setUv1(int u, int v) {
                    this.val$originalBuffer.setUv1(u, v);
                    return this;
                }

                public VertexConsumer setUv2(int u, int v) {
                    this.val$originalBuffer.setUv2(u, v);
                    return this;
                }

                public VertexConsumer setNormal(float x, float y, float z) {
                    this.val$originalBuffer.setNormal(x, y, z);
                    return this;
                }
            };
            Minecraft minecraft = Minecraft.getInstance();
            boolean flag = !living.isInvisible();
            boolean flag1 = !flag && !living.isInvisibleTo((Player)minecraft.player);
            boolean flag2 = minecraft.shouldEntityAppearGlowing((Entity)living);
            MultiBufferSource tintedSource = requestedType -> {
                boolean hasTexture = requestedType.format().getElements().contains(VertexFormatElement.UV0);
                boolean hasNormal = requestedType.format().getElements().contains(VertexFormatElement.NORMAL);
                if (hasTexture && hasNormal) {
                    RenderType ghostType = this.getRenderType(living, renderer, flag, flag1, flag2);
                    VertexConsumer originalBuffer = multibuffersource$buffersource.getBuffer(ghostType);
                    return (VertexConsumer)createTintedBuffer.apply(originalBuffer);
                }
                VertexConsumer originalBuffer = multibuffersource$buffersource.getBuffer(requestedType);
                return (VertexConsumer)createTintedBuffer.apply(originalBuffer);
            };
            entityRenderDispatcher.render((Entity)living, lerpX - vec3.x(), lerpY - vec3.y(), lerpZ - vec3.z(), living.getYRot(), tick, stack, tintedSource, entityRenderDispatcher.getPackedLightCoords((Entity)living, tick));
        }
    }

    public RenderType getRenderType(LivingEntity p_230496_1_, LivingEntityRenderer<LivingEntity, ?> renderer, boolean p_230496_2_, boolean p_230496_3_, boolean p_230496_4_) {
        Identifier resourcelocation = renderer.getTextureLocation((Entity)p_230496_1_);
        if (p_230496_3_) {
            return RenderType.itemEntityTranslucentCull((Identifier)resourcelocation);
        }
        if (p_230496_2_) {
            return this.ghost && !CMClientConfig.shadersCompat ? CMRenderTypes.getGhost(resourcelocation) : RenderType.entityTranslucent((Identifier)resourcelocation);
        }
        return p_230496_4_ ? RenderType.outline((Identifier)resourcelocation) : null;
    }

    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static class Factory
    implements ParticleProvider<AfterImageParticleOptions> {
        public Particle createParticle(AfterImageParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            AfterImageParticle particle = new AfterImageParticle(level, x, y, z, data.r(), data.g(), data.b(), data.entityid(), data.ghost(), data.lifeticks());
            return particle;
        }
    }
}

