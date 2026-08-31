package com.skd.cataclysmbosses.client.render.compat;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;

/**
 * PORT NOTE (26.2): bridge state that keeps a reference to the live entity so legacy
 * renderer bodies can read entity fields directly during submit(), mimicking the
 * pre-RenderState EntityRenderer contract.
 */
public class CmEntityRenderState
extends EntityRenderState {
    public Entity entity;
    public float partialTick;
}
