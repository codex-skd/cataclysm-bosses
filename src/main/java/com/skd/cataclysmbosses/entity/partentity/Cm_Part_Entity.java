/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mth
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.phys.Vec3
 *  net.neoforged.neoforge.entity.PartEntity
 */
package com.skd.cataclysmbosses.entity.partentity;

import com.skd.cataclysmbosses.message.MessageCMMultipart;
import java.util.Objects;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.PartEntity;

public abstract class Cm_Part_Entity<T extends Entity>
extends PartEntity<T> {
    protected EntityDimensions realSize = EntityDimensions.fixed((float)1.0f, (float)1.0f);
    protected int newPosRotationIncrements;
    protected double interpTargetX;
    protected double interpTargetY;
    protected double interpTargetZ;
    protected double interpTargetYaw;
    protected double interpTargetPitch;
    public float renderYawOffset;
    public float prevRenderYawOffset;
    public int deathTime;
    public int hurtTime;
    private EntityDimensions dimensions;

    public Cm_Part_Entity(T parent) {
        super(parent);
    }

    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements) {
        this.interpTargetX = x;
        this.interpTargetY = y;
        this.interpTargetZ = z;
        this.interpTargetYaw = yaw;
        this.interpTargetPitch = pitch;
        this.newPosRotationIncrements = posRotationIncrements;
    }

    public void tick() {
        this.updateLastPos();
        super.tick();
        if (this.newPosRotationIncrements > 0) {
            double d0 = this.getX() + (this.interpTargetX - this.getX()) / (double)this.newPosRotationIncrements;
            double d2 = this.getY() + (this.interpTargetY - this.getY()) / (double)this.newPosRotationIncrements;
            double d4 = this.getZ() + (this.interpTargetZ - this.getZ()) / (double)this.newPosRotationIncrements;
            double d6 = Mth.wrapDegrees((double)(this.interpTargetYaw - (double)this.getYRot()));
            this.setYRot((float)((double)this.getYRot() + d6 / (double)this.newPosRotationIncrements));
            this.setXRot((float)((double)this.getXRot() + (this.interpTargetPitch - (double)this.getXRot()) / (double)this.newPosRotationIncrements));
            --this.newPosRotationIncrements;
            this.setPos(d0, d2, d4);
            this.setRot(this.getYRot(), this.getXRot());
        }
        while (this.getYRot() - this.yRotO < -180.0f) {
            this.yRotO -= 360.0f;
        }
        while (this.getYRot() - this.yRotO >= 180.0f) {
            this.yRotO += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.getXRot() - this.xRotO < -180.0f) {
            this.xRotO -= 360.0f;
        }
        while (this.getXRot() - this.xRotO >= 180.0f) {
            this.xRotO += 360.0f;
        }
    }

    public final void updateLastPos() {
        this.moveTo(this.getX(), this.getY(), this.getZ());
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
        ++this.tickCount;
    }

    protected void setSize(EntityDimensions size) {
        this.realSize = size;
        this.refreshDimensions();
    }

    public boolean isCurrentlyGlowing() {
        return this.getParent().isCurrentlyGlowing();
    }

    public boolean isInvisible() {
        return this.getParent().isInvisible();
    }

    public EntityDimensions getDimensions(Pose pose) {
        return this.realSize;
    }

    public boolean isPickable() {
        return true;
    }

    public void setId(int id) {
        super.setId(id + 1);
    }

    public MessageCMMultipart.PartDataHolder writeData() {
        return new MessageCMMultipart.PartDataHolder(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot(), this.dimensions.width(), this.dimensions.height(), this.dimensions.fixed(), this.getEntityData().packDirty());
    }

    public void readData(MessageCMMultipart.PartDataHolder data) {
        Vec3 vec = new Vec3(data.x(), data.y(), data.z());
        this.setPositionAndRotationDirect(vec.x(), vec.y(), vec.z(), data.yRot(), data.xRot(), 3);
        float w = data.width();
        float h = data.height();
        this.setSize(data.fixed() ? EntityDimensions.fixed((float)w, (float)h) : EntityDimensions.scalable((float)w, (float)h));
        if (data.data() != null) {
            this.getEntityData().assignValues(data.data());
        }
        this.refreshDimensions();
    }

    public static void assignPartIDs(Entity parent) {
        PartEntity[] parts = parent.getParts();
        int partsLength = Objects.requireNonNull(parts).length;
        for (int i = 0; i < partsLength; ++i) {
            PartEntity part = parts[i];
            part.setId(parent.getId() + i);
        }
    }
}

