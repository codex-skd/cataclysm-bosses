/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.LivingEntity
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.api.distmarker.OnlyIn
 */
package com.skd.sundering.client.render.layer;

import com.skd.sundering.client.model.entity.Ignis_Model;
import com.skd.sundering.client.render.entity.Ignis_Renderer;
import com.skd.sundering.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class Ignis_Armor_Crack_Layer
extends RenderLayer<Ignis_Entity, Ignis_Model> {
    private static final Map<Ignis_Entity.Crackiness, Identifier> resourceLocations = ImmutableMap.of((Object)((Object)Ignis_Entity.Crackiness.LOW), (Object)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_armor_crack1.png"), (Object)((Object)Ignis_Entity.Crackiness.MEDIUM), (Object)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_armor_crack2.png"), (Object)((Object)Ignis_Entity.Crackiness.HIGH), (Object)Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ignis/ignis_armor_crack3.png"));

    public Ignis_Armor_Crack_Layer(Ignis_Renderer renderIn) {
        super((RenderLayerParent)renderIn);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignis_Entity ignis, float p_117152_, float p_117153_, float p_117154_, float p_117155_, float p_117156_, float p_117157_) {
        Ignis_Entity.Crackiness ignis$crackiness;
        if (!ignis.isInvisible() && ignis.getBossPhase() > 0 && (ignis$crackiness = ignis.getCrackiness()) != Ignis_Entity.Crackiness.NONE) {
            Identifier resourcelocation = resourceLocations.get((Object)ignis$crackiness);
            Ignis_Armor_Crack_Layer.renderColoredCutoutModel((EntityModel)this.getParentModel(), (Identifier)resourcelocation, (PoseStack)matrixStackIn, (MultiBufferSource)bufferIn, (int)packedLightIn, (LivingEntity)ignis, (int)-1);
        }
    }
}

