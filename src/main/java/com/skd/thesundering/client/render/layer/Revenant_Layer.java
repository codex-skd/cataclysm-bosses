/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.thesundering.client.render.layer;

import com.skd.thesundering.client.model.entity.Ignited_Revenant_Model;
import com.skd.thesundering.client.render.entity.Ignited_Revenant_Renderer;
import com.skd.thesundering.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Revenant_Layer
extends RenderLayer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {
    private final Ignited_Revenant_Model model = new Ignited_Revenant_Model();
    private static final Identifier REVENANT_SHIELD = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/revenant_shield.png");

    public Revenant_Layer(Ignited_Revenant_Renderer renderIgnis) {
        super((RenderLayerParent)renderIgnis);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Revenant_Entity revenant, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ((Ignited_Revenant_Model)this.getParentModel()).copyPropertiesTo((EntityModel)this.model);
        this.model.setupAnim(revenant, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderType.entityCutoutNoCull((Identifier)REVENANT_SHIELD));
        this.model.renderToBuffer(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.NO_OVERLAY);
    }
}

