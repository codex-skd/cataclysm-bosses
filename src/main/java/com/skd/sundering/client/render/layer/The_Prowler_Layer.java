/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.WalkAnimationState
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.The_Prowler_Model;
import com.skd.sundering.client.render.CMRenderTypes;
import com.skd.sundering.client.render.entity.The_Prowler_Renderer;
import com.skd.sundering.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.WalkAnimationState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class The_Prowler_Layer
extends RenderLayer<The_Prowler_Entity, The_Prowler_Model> {
    private static final Identifier PROWLER_LAYER_TEXTURES = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/factory/the_prowler_layer.png");
    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[4];

    public The_Prowler_Layer(The_Prowler_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
        for (int i = 0; i < 4; ++i) {
            The_Prowler_Layer.TEXTURE_PROGRESS[i] = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)("textures/entity/factory/the_prowler_layer_" + i + ".png"));
        }
    }

    public Identifier getTextureLocation(The_Prowler_Entity entity) {
        WalkAnimationState walkanimationstate = entity.walkAnimation;
        int f3 = (int)walkanimationstate.position((float)entity.tickCount);
        return this.getGrowingTexture(entity, (int)((float)f3 * 0.5f % 4.0f));
    }

    public Identifier getGrowingTexture(The_Prowler_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp((int)age, (int)0, (int)4)];
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Prowler_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int f = 255 - entity.deathTime * 255 / entity.deathtimer();
        RenderType eyes = CMRenderTypes.CMEyes(this.getTextureLocation(entity));
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
        int i = FastColor.ARGB32.color((int)255, (int)f, (int)f, (int)f);
        ((The_Prowler_Model)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i);
    }
}

