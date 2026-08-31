package com.skd.cataclysmbosses.client.render.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;

/**
 * PORT NOTE (26.2): minimal stand-in for the removed net.minecraft.client.renderer.MultiBufferSource.
 * getBuffer(RenderType) records a pending draw; after the legacy render body returns,
 * {@link #flush} replays each pending draw as an ordered submitCustomGeometry call.
 */
public class CmMultiBufferSource {
    private final List<PendingDraw> draws = new ArrayList<>();

    public VertexConsumer getBuffer(RenderType renderType) {
        CmRecordingVertexConsumer recorder = new CmRecordingVertexConsumer();
        this.draws.add(new PendingDraw(renderType, recorder));
        return recorder;
    }

    /**
     * Replicates old ItemRenderer.getFoilBufferDirect / getArmorFoilBuffer:
     * the returned consumer feeds the base draw and, when foil is set, the same
     * vertices are scheduled again under entityGlint().
     */
    public VertexConsumer getFoilBuffer(RenderType renderType, boolean foil) {
        CmRecordingVertexConsumer recorder = new CmRecordingVertexConsumer();
        this.draws.add(new PendingDraw(renderType, recorder));
        if (foil) {
            this.draws.add(new PendingDraw(RenderTypes.entityGlint(), recorder));
        }
        return recorder;
    }

    public void flush(PoseStack poseStack, SubmitNodeCollector collector) {
        int order = 0;
        for (PendingDraw draw : this.draws) {
            final CmRecordingVertexConsumer recorder = draw.recorder();
            collector.order(order++).submitCustomGeometry(poseStack, draw.renderType(), (pose, target) -> recorder.replayInto(target));
        }
        this.draws.clear();
    }

    private static final class PendingDraw {
        private final RenderType renderType;
        private final CmRecordingVertexConsumer recorder;

        private PendingDraw(RenderType renderType, CmRecordingVertexConsumer recorder) {
            this.renderType = renderType;
            this.recorder = recorder;
        }

        public RenderType renderType() {
            return this.renderType;
        }

        public CmRecordingVertexConsumer recorder() {
            return this.recorder;
        }
    }
}
