package com.skd.cataclysmbosses.client.model.compat;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.AnimationState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * PORT NOTE (26.2): compat bridge for the removed HierarchicalModel.
 * Old models extended HierarchicalModel<Entity> with animate()/animateWalk() helpers
 * and direct ModelPart.children access. New models extend EntityModel<EntityRenderState>
 * and apply animation via setupAnim(state). This bridge keeps old bodies compiling
 * with no-op animation stubs; proper KeyframeAnimations port is tracked separately.
 */
@OnlyIn(Dist.CLIENT)
public abstract class CmHierarchicalModel<T extends EntityRenderState>
extends EntityModel<T> {
    protected final ModelPart root;

    protected CmHierarchicalModel(ModelPart root) {
        super(root);
        this.root = root;
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    // Stubs for old HierarchicalModel helpers — no-op for compile, animation deferred
    protected void animate(AnimationState state, AnimationDefinition def, float ageInTicks, float weight) {}
    protected void animateWalk(AnimationDefinition def, float limbSwing, float limbSwingAmount, float maxSpeed, float speed) {}
    protected void applyStatic(AnimationDefinition def) {}
}
