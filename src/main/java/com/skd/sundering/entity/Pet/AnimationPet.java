/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.Identifier
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.AgeableMob
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.TamableAnimal
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier
 *  net.minecraft.world.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.Vec3
 */
package com.skd.sundering.entity.Pet;

import com.skd.sundering.entity.etc.IFollower;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AnimationPet
extends TamableAnimal
implements IFollower {
    private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(AnimationPet.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> COMMAND = SynchedEntityData.defineId(AnimationPet.class, (EntityDataSerializer)EntityDataSerializers.INT);
    private static final Identifier MOB_HEALTH_MODIFIER_ID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"pet_health");
    private static final Identifier MOB_DAMAGE_MODIFIER_ID = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"pet_damage");

    public AnimationPet(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(COMMAND, (Object)0);
        p_326229_.define(SITTING, (Object)false);
    }

    public int getCommand() {
        return (Integer)this.entityData.get(COMMAND);
    }

    public void setCommand(int command) {
        this.entityData.set(COMMAND, (Object)command);
    }

    public boolean isSitting() {
        return (Boolean)this.entityData.get(SITTING);
    }

    public void setOrderedToSit(boolean sit) {
        this.entityData.set(SITTING, (Object)sit);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("CmPetSitting", this.isSitting());
        compound.putInt("Command", this.getCommand());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setOrderedToSit(compound.getBoolean("CmPetSitting"));
        this.setCommand(compound.getInt("Command"));
    }

    public void setConfigattribute(LivingEntity entity, double hpconfig, double dmgconfig) {
        AttributeInstance attackDamageAttr;
        AttributeInstance maxHealthAttr = entity.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            double difference = maxHealthAttr.getBaseValue() * hpconfig - maxHealthAttr.getBaseValue();
            maxHealthAttr.addTransientModifier(new AttributeModifier(MOB_HEALTH_MODIFIER_ID, difference, AttributeModifier.Operation.ADD_VALUE));
            entity.setHealth(entity.getMaxHealth());
        }
        if ((attackDamageAttr = entity.getAttribute(Attributes.ATTACK_DAMAGE)) != null) {
            double difference = attackDamageAttr.getBaseValue() * dmgconfig - attackDamageAttr.getBaseValue();
            attackDamageAttr.addTransientModifier(new AttributeModifier(MOB_DAMAGE_MODIFIER_ID, difference, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    public boolean removeWhenFarAway(double p_21542_) {
        return false;
    }

    public boolean isFood(ItemStack p_27600_) {
        return false;
    }

    public void circleEntity(LivingEntity target, float radius, float speed, boolean direction, int circleFrame, float offset, float moveSpeedMultiplier) {
        int directionInt = direction ? 1 : -1;
        double t = (double)(directionInt * circleFrame) * 0.5 * (double)speed / (double)radius + (double)offset;
        Vec3 movePos = target.position().add((double)radius * Math.cos(t), 0.0, (double)radius * Math.sin(t));
        this.getNavigation().moveTo(movePos.x, movePos.y, movePos.z, (double)(speed * moveSpeedMultiplier));
    }

    @Override
    public boolean shouldFollow() {
        return false;
    }

    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }
}

