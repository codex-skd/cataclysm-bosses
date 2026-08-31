/*
 * Decompiled with CFR 0.152.
 */
package com.skd.cataclysmbosses.entity.etc;

import net.minecraft.core.GlobalPos;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public interface IHomeEntity {
    void setHomePos(GlobalPos vec3);

    GlobalPos getHomePos();

    void addAdditionalHomePoint(ValueOutput tag);

    void readAdditionalHomePoint(ValueInput tag);
}