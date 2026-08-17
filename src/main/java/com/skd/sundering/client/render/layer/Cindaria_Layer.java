/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.world.entity.LivingEntity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.Cindaria_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.entity.Cindaria_Renderer;
import com.skd.sundering.config.CMClientConfig;
import com.skd.sundering.entity.InternalAnimationMonster.AcropolisMonsters.Cindaria_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Cindaria_Layer
extends RenderLayer<Cindaria_Entity, Cindaria_Model> {
    private static final Identifier LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/sea/cindaria_body.png");

    public Cindaria_Layer(Cindaria_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public Identifier getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Cindaria_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isInvisible()) {
            RenderType ghost = CMClientConfig.shadersCompat ? RenderType.entityTranslucent((Identifier)this.getLayerTextureLocation()) : CMRenderTypes.jelly(this.getLayerTextureLocation());
            VertexConsumer VertexConsumer2 = bufferIn.getBuffer(ghost);
            float alpha = 0.65f;
            boolean hurt = Math.max(entity.hurtTime, entity.deathTime) > 0;
            int i1 = FastColor.ARGB32.colorFromFloat((float)alpha, (float)1.0f, (float)(hurt ? 0.49803922f : 1.0f), (float)(hurt ? 0.49803922f : 1.0f));
            ((Cindaria_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, LivingEntityRenderer.getOverlayCoords((LivingEntity)entity, (float)0.0f), i1);
        }
    }
}

