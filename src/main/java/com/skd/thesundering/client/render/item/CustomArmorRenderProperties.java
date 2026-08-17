/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Suppliers
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.blaze3d.vertex.VertexMultiConsumer
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.Model
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.item.ArmorItem
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.neoforge.client.extensions.common.IClientItemExtensions
 */
package com.skd.thesundering.client.render.item;

import com.skd.thesundering.client.model.CMModelLayers;
import com.skd.thesundering.client.model.armor.Bloom_Stone_Pauldrons_Model;
import com.skd.thesundering.client.model.armor.Bone_Reptile_Armor_Model;
import com.skd.thesundering.client.model.armor.Cursium_Armor_Model;
import com.skd.thesundering.client.model.armor.Ignitium_Armor_Model;
import com.skd.thesundering.client.model.armor.Ignitium_Elytra_chestplate_Model;
import com.skd.thesundering.client.model.armor.MonstrousHelm_Model;
import com.skd.thesundering.client.render.CMRenderTypes;
import com.skd.thesundering.init.ModItems;
import com.skd.thesundering.items.Armortier;
import com.google.common.base.Suppliers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class CustomArmorRenderProperties
implements IClientItemExtensions {
    private static final Identifier CURSIUM_ARMOR_GHOST = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/armor/cursium_armor_ghost.png");
    private static boolean init;
    public static final Supplier<CustomArmorRenderProperties> INSTANCE;
    public static Ignitium_Elytra_chestplate_Model ELYTRA_ARMOR;
    public static MonstrousHelm_Model MONSTROUS_HELM_MODEL;
    public static Ignitium_Armor_Model IGNITIUM_ARMOR_MODEL;
    public static Ignitium_Armor_Model IGNITIUM_ARMOR_MODEL_LEGS;
    public static Bloom_Stone_Pauldrons_Model BLOOM_STONE_PAULDRONS_MODEL;
    public static Bone_Reptile_Armor_Model BONE_REPTILE_ARMOR_MODEL;
    public static Cursium_Armor_Model CURSIUM_ARMOR_MODEL;
    public static Cursium_Armor_Model CURSIUM_ARMOR_MODEL_LEGS;

    public static void initializeModels() {
        init = true;
        MONSTROUS_HELM_MODEL = new MonstrousHelm_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.MONSTROUS_HELM));
        IGNITIUM_ARMOR_MODEL = new Ignitium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.IGNITIUM_ARMOR_MODEL));
        ELYTRA_ARMOR = new Ignitium_Elytra_chestplate_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.ELYTRA_ARMOR));
        IGNITIUM_ARMOR_MODEL_LEGS = new Ignitium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.IGNITIUM_ARMOR_MODEL_LEGS));
        BLOOM_STONE_PAULDRONS_MODEL = new Bloom_Stone_Pauldrons_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BLOOM_STONE_PAULDRONS_MODEL));
        BONE_REPTILE_ARMOR_MODEL = new Bone_Reptile_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BONE_REPTILE_ARMOR_MODEL));
        CURSIUM_ARMOR_MODEL = new Cursium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CURSIUM_ARMOR_MODEL));
        CURSIUM_ARMOR_MODEL_LEGS = new Cursium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CURSIUM_ARMOR_MODEL_LEGS));
    }

    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
        if (!init) {
            CustomArmorRenderProperties.initializeModels();
        }
        if (itemStack.getItem() == ModItems.MONSTROUS_HELM.get()) {
            return MONSTROUS_HELM_MODEL;
        }
        if (itemStack.getItem() == ModItems.IGNITIUM_HELMET.get()) {
            return IGNITIUM_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.IGNITIUM_CHESTPLATE.get()) {
            return IGNITIUM_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.IGNITIUM_LEGGINGS.get()) {
            return IGNITIUM_ARMOR_MODEL_LEGS;
        }
        if (itemStack.getItem() == ModItems.IGNITIUM_BOOTS.get()) {
            return IGNITIUM_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.CURSIUM_HELMET.get()) {
            return CURSIUM_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.CURSIUM_CHESTPLATE.get()) {
            return CURSIUM_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.CURSIUM_LEGGINGS.get()) {
            return CURSIUM_ARMOR_MODEL_LEGS;
        }
        if (itemStack.getItem() == ModItems.CURSIUM_BOOTS.get()) {
            return CURSIUM_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.BLOOM_STONE_PAULDRONS.get()) {
            return BLOOM_STONE_PAULDRONS_MODEL;
        }
        if (itemStack.getItem() == ModItems.BONE_REPTILE_HELMET.get()) {
            return BONE_REPTILE_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.BONE_REPTILE_CHESTPLATE.get()) {
            return BONE_REPTILE_ARMOR_MODEL;
        }
        if (itemStack.getItem() == ModItems.IGNITIUM_ELYTRA_CHESTPLATE.get()) {
            return ELYTRA_ARMOR.withAnimations(entityLiving);
        }
        return _default;
    }

    public static void renderCustomArmor(PoseStack poseStack, MultiBufferSource multiBufferSource, int light, ItemStack itemStack, ArmorItem armorItem, Model armorModel, boolean legs, Identifier texture) {
        if (armorItem.getMaterial() == Armortier.CURSIUM) {
            VertexConsumer vertexconsumer1 = itemStack.hasFoil() ? VertexMultiConsumer.create((VertexConsumer)multiBufferSource.getBuffer(RenderType.entityGlintDirect()), (VertexConsumer)multiBufferSource.getBuffer(RenderType.entityTranslucent((Identifier)texture))) : multiBufferSource.getBuffer(RenderType.entityTranslucent((Identifier)texture));
            armorModel.renderToBuffer(poseStack, vertexconsumer1, light, OverlayTexture.NO_OVERLAY);
            VertexConsumer vertexconsumer2 = multiBufferSource.getBuffer(CMRenderTypes.getGhost(CURSIUM_ARMOR_GHOST));
            int i = FastColor.ARGB32.color((int)125, (int)255, (int)255, (int)255);
            armorModel.renderToBuffer(poseStack, vertexconsumer2, light, OverlayTexture.NO_OVERLAY, i);
        }
    }

    static {
        INSTANCE = Suppliers.memoize(CustomArmorRenderProperties::new);
    }
}

