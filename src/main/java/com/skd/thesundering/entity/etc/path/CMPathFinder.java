/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.core.BlockPos
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.level.PathNavigationRegion
 *  net.minecraft.world.level.pathfinder.Node
 *  net.minecraft.world.level.pathfinder.NodeEvaluator
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.level.pathfinder.PathFinder
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.thesundering.entity.etc.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;

public class CMPathFinder
extends PathFinder {
    public CMPathFinder(NodeEvaluator processor, int maxVisitedNodes) {
        super(processor, maxVisitedNodes);
    }

    @Nullable
    public Path findPath(PathNavigationRegion regionIn, Mob mob, Set<BlockPos> targetPositions, float maxRange, int accuracy, float searchDepthMultiplier) {
        Path path = super.findPath(regionIn, mob, targetPositions, maxRange, accuracy, searchDepthMultiplier);
        return path == null ? null : new PatchedPath(path);
    }

    static class PatchedPath
    extends Path {
        public PatchedPath(Path original) {
            super(PatchedPath.copyPathPoints(original), original.getTarget(), original.canReach());
        }

        public Vec3 getEntityPosAtNode(Entity entity, int index) {
            Node point = this.getNode(index);
            double d0 = (double)point.x + (double)Mth.floor((float)(entity.getBbWidth() + 1.0f)) * 0.5;
            double d1 = point.y;
            double d2 = (double)point.z + (double)Mth.floor((float)(entity.getBbWidth() + 1.0f)) * 0.5;
            return new Vec3(d0, d1, d2);
        }

        private static List<Node> copyPathPoints(Path original) {
            ArrayList<Node> points = new ArrayList<Node>();
            for (int i = 0; i < original.getNodeCount(); ++i) {
                points.add(original.getNode(i));
            }
            return points;
        }
    }
}

