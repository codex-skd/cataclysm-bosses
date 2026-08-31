package com.skd.cataclysmbosses.client.render.compat;

import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * PORT NOTE (26.2): records VertexConsumer calls issued by legacy immediate-mode renderer
 * bodies so they can be replayed later into the real VertexConsumer handed out by
 * SubmitNodeCollector.submitCustomGeometry at draw time.
 */
public class CmRecordingVertexConsumer
implements VertexConsumer {
    private final List<Consumer<VertexConsumer>> ops = new ArrayList<>();

    public void replayInto(VertexConsumer target) {
        for (Consumer<VertexConsumer> op : this.ops) {
            op.accept(target);
        }
    }

    @Override
    public VertexConsumer addVertex(float x, float y, float z) {
        this.ops.add(vc -> vc.addVertex(x, y, z));
        return this;
    }

    @Override
    public VertexConsumer setColor(int r, int g, int b, int a) {
        this.ops.add(vc -> vc.setColor(r, g, b, a));
        return this;
    }

    @Override
    public VertexConsumer setColor(int color) {
        this.ops.add(vc -> vc.setColor(color));
        return this;
    }

    @Override
    public VertexConsumer setUv(float u, float v) {
        this.ops.add(vc -> vc.setUv(u, v));
        return this;
    }

    @Override
    public VertexConsumer setUv1(int u, int v) {
        this.ops.add(vc -> vc.setUv1(u, v));
        return this;
    }

    @Override
    public VertexConsumer setUv2(int u, int v) {
        this.ops.add(vc -> vc.setUv2(u, v));
        return this;
    }

    @Override
    public VertexConsumer setNormal(float x, float y, float z) {
        this.ops.add(vc -> vc.setNormal(x, y, z));
        return this;
    }

    @Override
    public VertexConsumer setLineWidth(float width) {
        this.ops.add(vc -> vc.setLineWidth(width));
        return this;
    }
}
