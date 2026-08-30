/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.blockentity.BlockEntityRenderer
 *  net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.EntityRenderDispatcher
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.ItemDisplayContext
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.saveddata.SavedData
 */
package com.skd.cataclysmbosses.blockentities;

import com.skd.cataclysmbosses.client.model.block.Boss_Respawn_Spawner_Model;
import com.skd.cataclysmbosses.init.ModTileentites;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jspecify.annotations.Nullable;

public class Boss_Respawn_Spawner_Block_Entity
extends BlockEntity {
    public int tickCount;
    public int Animaitonticks;
    public EntityType<?> spawnType;
    public ItemStack item;
    public boolean hasBeenRespawned;
    // PORT(26.2): client-side opening animation clock the spawner model drives (was lost in decompile).
    public final AnimationState openingAnimationState = new AnimationState();
    private Entity displayEntity;
    private boolean hasBeenRespawnedOnce;

    public Boss_Respawn_Spawner_Block_Entity(BlockPos pos, BlockState state) {
        super((BlockEntityType)ModTileentites.BOSS_RESPAWNER.get(), pos, state);
    }

    public void tick() {
        this.tickCount++;
        if (this.tickCount % 20 == 0) {
            this.setChanged();
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        if (input.getStringOr("EntityType", "").length() > 0) {
            String str = input.getStringOr("EntityType", "");
            this.spawnType = BuiltInRegistries.ENTITY_TYPE.get(Identifier.parse(str)).map(net.minecraft.core.Holder::value).orElse(null);
        }
        if (input.getStringOr("Item", "").length() > 0) {
            this.item = input.read("Item", ItemStack.CODEC).orElse(ItemStack.EMPTY);
        } else {
            this.item = ItemStack.EMPTY;
        }
        this.Animaitonticks = input.getIntOr("animationTicks", 0);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.getTheItem().isEmpty()) {
            output.store("Item", ItemStack.CODEC, this.getTheItem());
        }
        output.putInt("animationTicks", this.Animaitonticks);
        if (this.spawnType != null) {
            output.putString("EntityType", BuiltInRegistries.ENTITY_TYPE.getKey(this.spawnType).toString());
        }
    }

    public Entity getDisplayEntity(Level level) {
        if (this.displayEntity == null && this.spawnType != null || this.displayEntity != null && this.displayEntity.getType() != this.spawnType) {
            this.displayEntity = this.spawnType.create(level, EntitySpawnReason.EVENT);
        }
        return this.displayEntity;
    }
    
    public ItemStack getTheItem() {
        return this.item;
    }
}