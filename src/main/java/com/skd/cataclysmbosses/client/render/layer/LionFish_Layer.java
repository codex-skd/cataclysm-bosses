package com.skd.cataclysmbosses.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/*
 * PORT NOTE (26.2): stubbed for compile — original RenderLayer used old
 * MultiBufferSource/Entity API. Proper port needs RenderLayer<LivingEntityRenderState, EntityModel>
 * with SubmitNodeCollector. Tracked separately.
 */
@OnlyIn(Dist.CLIENT)
public class LionFish_Layer {
    public LionFish_Layer(Object... args) {}
    public void render(PoseStack poseStack, Object buffer, int packedLight, Object entity, float a, float b, float c, float d, float e, float f) {}
}
