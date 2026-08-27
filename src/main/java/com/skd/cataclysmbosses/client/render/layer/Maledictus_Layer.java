package com.skd.cataclysmbosses.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Layer extends RenderLayer<LivingEntityRenderState, EntityModel<LivingEntityRenderState>> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath("cataclysm", "textures/entity/maledictus/maledictus.png");

    public Maledictus_Layer(RenderLayerParent<LivingEntityRenderState, EntityModel<LivingEntityRenderState>> renderer) {
        super(renderer);
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, LivingEntityRenderState state, float yRot, float xRot) {
        if (!state.isInvisible) {
            EntityModel<LivingEntityRenderState> model = this.getParentModel();
            RenderLayer.coloredCutoutModelCopyLayerRender(
                this.getParentModel(),
                TEXTURE,
                poseStack,
                submitNodeCollector,
                packedLight,
                state,
                0xFFFFFFFF,
                0
            );
        }
    }
}