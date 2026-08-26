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
package com.skd.cataclysmbosses.client.render.layer;

import com.skd.cataclysmbosses.client.model.entity.Ignis_Model;
import com.skd.cataclysmbosses.client.render.entity.Ignis_Renderer;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ignis_Shield_Layer
extends RenderLayer<Ignis_Entity, Ignis_Model> {
    private final Ignis_Model model = new Ignis_Model();
    private static final Identifier IGNIS_SHIELD = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_shield.png");
    private static final Identifier IGNIS_SOUL_SHIELD = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_soul_shield.png");
    private static final Identifier IGNIS_SHIELD_CRACK1 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_shield_crack1.png");
    private static final Identifier IGNIS_SHIELD_CRACK2 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_shield_crack2.png");
    private static final Identifier IGNIS_SHIELD_CRACK3 = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_shield_crack3.png");

    public Ignis_Shield_Layer(Ignis_Renderer renderIgnis) {
        super((RenderLayerParent)renderIgnis);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignis_Entity ignis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Identifier lvt_12_3_ = ignis.getBossPhase() < 1 ? IGNIS_SHIELD : IGNIS_SOUL_SHIELD;
        ((Ignis_Model)this.getParentModel()).copyPropertiesTo((EntityModel)this.model);
        this.model.setupAnim(ignis, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)lvt_12_3_));
        this.model.renderToBuffer(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        if (ignis.getShieldDurability() > 0) {
            VertexConsumer lvt_13_2_ = ignis.getShieldDurability() >= 3 ? bufferIn.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)IGNIS_SHIELD_CRACK3)) : (ignis.getShieldDurability() == 2 ? bufferIn.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)IGNIS_SHIELD_CRACK2)) : bufferIn.getBuffer(RenderTypes.entityCutoutNoCull((Identifier)IGNIS_SHIELD_CRACK1)));
            this.model.renderToBuffer(matrixStackIn, lvt_13_2_, packedLightIn, OverlayTexture.NO_OVERLAY, -1);
        }
    }
}

