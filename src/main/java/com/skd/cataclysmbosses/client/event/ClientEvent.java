/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.InputConstants
 *  com.mojang.blaze3d.platform.InputConstants$Type
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.Util
 *  net.minecraft.client.KeyMapping
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.client.renderer.GameRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.rendertype.RenderType
 *  net.minecraft.client.renderer.entity.ItemRenderer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.Identifier
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.neoforged.bus.api.Event
 *  net.neoforged.neoforge.client.event.CalculateDetachedCameraDistanceEvent
 *  net.neoforged.neoforge.client.event.ClientTickEvent$Post
 *  net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent$BossEventProgress
 *  net.neoforged.neoforge.client.event.MovementInputUpdateEvent
 *  net.neoforged.neoforge.client.event.RenderArmEvent
 *  net.neoforged.neoforge.client.event.RenderGuiLayerEvent$Post
 *  net.neoforged.neoforge.client.event.RenderGuiLayerEvent$Pre
 *  net.neoforged.neoforge.client.event.RenderLivingEvent$Post
 *  net.neoforged.neoforge.client.event.RenderLivingEvent$Pre
 *  net.neoforged.neoforge.client.event.RenderPlayerEvent$Pre
 *  net.neoforged.neoforge.client.event.ViewportEvent$ComputeCameraAngles
 *  net.neoforged.neoforge.client.event.ViewportEvent$ComputeFogColor
 *  net.neoforged.neoforge.client.event.ViewportEvent$RenderFog
 *  net.neoforged.neoforge.client.gui.VanillaGuiLayers
 *  net.neoforged.neoforge.common.NeoForge
 *  org.lwjgl.glfw.GLFW
 *  top.theillusivec4.curios.api.CuriosApi
 *  top.theillusivec4.curios.api.SlotTypePreset
 *  top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler
 *  top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler
 */
package com.skd.cataclysmbosses.client.event;

import com.skd.cataclysmbosses.Cataclysm;
import com.skd.cataclysmbosses.ClientProxy;
import com.skd.cataclysmbosses.client.event.CameraZoomManager;
import com.skd.cataclysmbosses.client.event.EventPosePlayerHand;
import com.skd.cataclysmbosses.client.gui.CustomBossBar;
import com.skd.cataclysmbosses.client.model.entity.PlayerSandstorm_Model;
import com.skd.cataclysmbosses.client.render.CMItemstackRenderer;
import com.skd.cataclysmbosses.client.render.item.CuriosRenderer.Blazing_Grips_Renderer;
import com.skd.cataclysmbosses.client.render.item.CuriosRenderer.Chitin_Claw_Renderer;
import com.skd.cataclysmbosses.client.render.item.CuriosRenderer.Sticky_Gloves_Renderer;
import com.skd.cataclysmbosses.config.CMClientConfig;
import com.skd.cataclysmbosses.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Tongue_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.AcropolisMonsters.Clawdian_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.skd.cataclysmbosses.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.skd.cataclysmbosses.entity.effect.ScreenShake_Entity;
import com.skd.cataclysmbosses.entity.effect.SkyColor_Entity;
import com.skd.cataclysmbosses.entity.etc.IHoldEntity;
import com.skd.cataclysmbosses.entity.projectile.Accretion_Entity;
import com.skd.cataclysmbosses.init.ModEffect;
import com.skd.cataclysmbosses.init.ModItems;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.Random;
import net.minecraft.Util;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.client.event.CalculateDetachedCameraDistanceEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;
import net.neoforged.neoforge.client.event.RenderArmEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.neoforge.common.NeoForge;
import org.lwjgl.glfw.GLFW;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

public class ClientEvent {
    public static final Identifier FLAME_STRIKE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/soul_flame_strike_sigil.png");
    private static final Identifier SANDSTORM_ICON = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/sandstorm_icons.png");
    private static final Identifier EFFECT_HEART = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/effect_heart.png");
    private static final Identifier FLASH_OUT = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/gui/flash_out.png");
    private static final Identifier SANDSTORM_TEXTURE = Identifier.fromNamespaceAndPath((String)"cataclysm", (String)"textures/entity/ancient_remnant/sandstorm.png");
    private static final PlayerSandstorm_Model SANDSTORM_MODEL = new PlayerSandstorm_Model();
    private final Random random = new Random();
    private int lastHealth;
    private int displayHealth;
    private long lastHealthTime;
    private long healthBlinkTime;
    private int leftHeight = 39;
    private int rightHeight = 39;
    private static boolean toolMenuKeyWasDown = false;

    public static void ClientEvent() {
        NeoForge.EVENT_BUS.addListener(ClientEvent::renderBossOverlay);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onCameraSetup);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onCameraZoom);
        NeoForge.EVENT_BUS.addListener(ClientEvent::MovementInput);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPreRenderHUD);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPostRenderHUD);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPreRenderEntity);
        NeoForge.EVENT_BUS.addListener(ClientEvent::clientTick);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPoseHand);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onRenderArm);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onPoseHand);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onRenderFog);
        NeoForge.EVENT_BUS.addListener(ClientEvent::onComputFog);
    }

    public static void onRenderFog(ViewportEvent.RenderFog event) {
    }

    public static void onComputFog(ViewportEvent.ComputeFogColor event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        float delta = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        if (player != null) {
            float ticksExistedDelta = delta;
            float totalIntensity = 0.0f;
            float r = event.getRed();
            float g = event.getGreen();
            float b = event.getBlue();
            for (SkyColor_Entity skyColorEntity : player.level().getEntitiesOfClass(SkyColor_Entity.class, player.getBoundingBox().inflate(64.0))) {
                float intensity = skyColorEntity.getColorIntensity((Player)player, ticksExistedDelta);
                if (!(intensity > 0.0f) || !(intensity > totalIntensity)) continue;
                totalIntensity = intensity;
                r = (float)skyColorEntity.getR() / 255.0f;
                g = (float)skyColorEntity.getG() / 255.0f;
                b = (float)skyColorEntity.getB() / 255.0f;
            }
            if (totalIntensity > 0.0f) {
                totalIntensity = Mth.clamp((float)totalIntensity, (float)0.0f, (float)1.0f);
                float baseR = event.getRed();
                float baseG = event.getGreen();
                float baseB = event.getBlue();
                event.setRed(Mth.lerp((float)totalIntensity, (float)baseR, (float)r));
                event.setGreen(Mth.lerp((float)totalIntensity, (float)baseG, (float)g));
                event.setBlue(Mth.lerp((float)totalIntensity, (float)baseB, (float)b));
            }
        }
    }

    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        LocalPlayer player = Minecraft.getInstance().player;
        float delta = (float)event.getPartialTick();
        float ticksExistedDelta = (float)player.tickCount + delta;
        if (CMClientConfig.ScreenShake && !Minecraft.getInstance().isPaused()) {
            if (player != null) {
                float shakeAmplitude = 0.0f;
                for (ScreenShake_Entity ScreenShake : player.level().getEntitiesOfClass(ScreenShake_Entity.class, player.getBoundingBox().inflate(48.0, 48.0, 48.0))) {
                    if (!(ScreenShake.distanceTo((Entity)player) < ScreenShake.getRadius())) continue;
                    shakeAmplitude += ScreenShake.getShakeAmount((Player)player, delta);
                }
                if (shakeAmplitude > 1.0f) {
                    shakeAmplitude = 1.0f;
                }
                event.setPitch((float)((double)event.getPitch() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 3.0f + 2.0f) * 25.0));
                event.setYaw((float)((double)event.getYaw() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 5.0f + 1.0f) * 25.0));
                event.setRoll((float)((double)event.getRoll() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 4.0f) * 25.0));
            }
            if (Minecraft.getInstance().player.getEffect(ModEffect.EFFECTSTUN) != null) {
                MobEffectInstance effectinstance1 = Minecraft.getInstance().player.getEffect(ModEffect.EFFECTSTUN);
                float shakeAmplitude = (float)((double)(1 + effectinstance1.getAmplifier()) * 0.01);
                event.setPitch((float)((double)event.getPitch() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 3.0f + 2.0f) * 25.0));
                event.setYaw((float)((double)event.getYaw() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 5.0f + 1.0f) * 25.0));
                event.setRoll((float)((double)event.getRoll() + (double)shakeAmplitude * Math.cos(ticksExistedDelta * 4.0f) * 25.0));
            }
        }
    }

    public static void onCameraZoom(CalculateDetachedCameraDistanceEvent event) {
        Entity cameraEntity = event.getCamera().getEntity();
        float partialTick = event.getCamera().getPartialTickTime();
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Maledictus_Entity && event.getCamera().isDetached()) {
            event.setDistance(6.0f);
        }
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Aptrgangr_Entity && event.getCamera().isDetached()) {
            event.setDistance(3.0f);
        }
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Clawdian_Entity && event.getCamera().isDetached()) {
            event.setDistance(6.0f);
        }
        if (CameraZoomManager.isActive() && event.getCamera().isDetached()) {
            float zoom = CameraZoomManager.getZoomOffset(partialTick);
            float floorzoom = event.getCamera().getMaxZoom(zoom);
            if (floorzoom < zoom) {
                floorzoom = Math.max(0.0f, floorzoom - 0.2f);
            }
            float dy = 0.0f;
            float ny = zoom - floorzoom;
            if (ny > 0.0f) {
                dy = Math.min(ny * 0.5f, 1.5f);
            }
            event.getCamera().move(-floorzoom, dy, 0.0f);
        }
    }

    public static boolean isKeyDown0(KeyMapping keybind) {
        if (keybind.isUnbound()) {
            return false;
        }
        return switch (keybind.getKey().getType()) {
            case InputConstants.Type.KEYSYM -> InputConstants.isKeyDown((long)Minecraft.getInstance().getWindow().getWindow(), (int)keybind.getKey().getValue());
            case InputConstants.Type.MOUSE -> {
                if (GLFW.glfwGetMouseButton((long)Minecraft.getInstance().getWindow().getWindow(), (int)keybind.getKey().getValue()) == 1) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }

    public static void MovementInput(MovementInputUpdateEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(ModEffect.EFFECTCURSE_OF_DESERT)) {
            if (Minecraft.getInstance().options.keyDown.isDown()) {
                event.getInput().forwardImpulse *= -1.0f;
            }
            if (Minecraft.getInstance().options.keyLeft.isDown()) {
                event.getInput().leftImpulse *= -1.0f;
            }
            if (Minecraft.getInstance().options.keyRight.isDown()) {
                event.getInput().leftImpulse *= -1.0f;
            }
            if (Minecraft.getInstance().options.keyUp.isDown()) {
                event.getInput().forwardImpulse *= -1.0f;
            }
        }
    }

    public static void onPreRenderHUD(RenderGuiLayerEvent.Pre event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            Minecraft mc = Minecraft.getInstance();
            if (player.isPassenger()) {
                if ((player.getVehicle() instanceof The_Leviathan_Tongue_Entity || player.getVehicle() instanceof IHoldEntity) && VanillaGuiLayers.VEHICLE_HEALTH == event.getName()) {
                    Minecraft.getInstance().gui.setOverlayMessage((Component)Component.translatable((String)"entity.cataclysm.you_cant_escape"), false);
                }
                if (player.getVehicle() instanceof Accretion_Entity && VanillaGuiLayers.VEHICLE_HEALTH == event.getName()) {
                    Minecraft.getInstance().gui.setOverlayMessage((Component)Component.translatable((String)"entity.cataclysm.accretion_ride"), false);
                }
            }
        }
    }

    public static void onPostRenderHUD(RenderGuiLayerEvent.Post event) {
        LocalPlayer player = Minecraft.getInstance().player;
        float delta = Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(true);
        float screenEffectIntensity = ((Double)Minecraft.getInstance().options.screenEffectScale().get()).floatValue();
        float ticksExistedDelta = (float)player.tickCount + delta;
        Minecraft mc = Minecraft.getInstance();
        if (player == null || VanillaGuiLayers.AIR_LEVEL != event.getName() || mc.options.hideGui || ClientEvent.shouldDrawSurvivalElements()) {
            // empty if block
        }
    }

    private static boolean shouldDrawSurvivalElements() {
        Minecraft mc = Minecraft.getInstance();
        return mc.gameMode.canHurtPlayer() && mc.getCameraEntity() instanceof Player;
    }

    public static void onPreRenderEntity(RenderLivingEvent.Pre event) {
        PoseStack.Pose lvt_19_1_;
        VertexConsumer ivertexbuilder;
        float f3;
        PoseStack matrixStackIn;
        float f2;
        int i;
        boolean usingImmolator;
        LivingEntity player = event.getEntity();
        boolean usingIncinerator = player.isUsingItem() && player.getUseItem().is((Item)ModItems.THE_INCINERATOR.get());
        boolean bl = usingImmolator = player.isUsingItem() && player.getUseItem().is((Item)ModItems.THE_IMMOLATOR.get());
        if (usingIncinerator) {
            i = player.getTicksUsingItem();
            f2 = (float)player.tickCount + event.getPartialTick();
            matrixStackIn = event.getPoseStack();
            f3 = Mth.clamp((int)i, (int)1, (int)60);
            matrixStackIn.pushPose();
            ivertexbuilder = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)event.getMultiBufferSource(), (RenderType)RenderType.entityTranslucentEmissive((Identifier)FLAME_STRIKE), (boolean)true);
            matrixStackIn.translate(0.0, 0.001, 0.0);
            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f + f2));
            lvt_19_1_ = matrixStackIn.last();
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }
        if (usingImmolator) {
            i = player.getTicksUsingItem();
            f2 = (float)player.tickCount + event.getPartialTick();
            matrixStackIn = event.getPoseStack();
            f3 = Mth.clamp((int)i, (int)1, (int)45);
            matrixStackIn.pushPose();
            ivertexbuilder = ItemRenderer.getArmorFoilBuffer((MultiBufferSource)event.getMultiBufferSource(), (RenderType)RenderType.entityTranslucentEmissive((Identifier)FLAME_STRIKE), (boolean)true);
            matrixStackIn.translate(0.0, 0.001, 0.0);
            matrixStackIn.scale(f3 * 0.05f, f3 * 0.05f, f3 * 0.05f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0f + f2));
            lvt_19_1_ = matrixStackIn.last();
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0.0f, 0.0f, 1, 0, 1, 240);
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0.0f, 1.0f, 1, 0, 1, 240);
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1.0f, 1.0f, 1, 0, 1, 240);
            ClientEvent.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1.0f, 0.0f, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }
        if (ClientProxy.blockedEntityRenders.contains(event.getEntity().getUUID())) {
            if (!Cataclysm.PROXY.isFirstPersonPlayer((Entity)event.getEntity())) {
                NeoForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
                event.setCanceled(true);
            }
            ClientProxy.blockedEntityRenders.remove(event.getEntity().getUUID());
        }
    }

    public static void onPreRenderPlayer(RenderPlayerEvent.Pre event) {
    }

    public static void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_);
    }

    public static void clientTick(ClientTickEvent.Post event) {
        if (Minecraft.getInstance().isSingleplayer() && Minecraft.getInstance().isPaused()) {
            return;
        }
        CMItemstackRenderer.incrementTick();
        CameraZoomManager.tick();
    }

    private static void updateAllChunks() {
        if (Minecraft.getInstance().levelRenderer.viewArea != null) {
            int length = Minecraft.getInstance().levelRenderer.viewArea.sections.length;
            for (int i = 0; i < length; ++i) {
                Minecraft.getInstance().levelRenderer.viewArea.sections[i].setDirty(true);
            }
        }
    }

    public static void onPoseHand(EventPosePlayerHand event) {
        LivingEntity player = (LivingEntity)event.getEntityIn();
        if (player.getItemInHand(InteractionHand.OFF_HAND).is((Item)ModItems.THE_ANNIHILATOR.get()) && player.getItemInHand(InteractionHand.MAIN_HAND).is((Item)ModItems.THE_ANNIHILATOR.get()) && player.isUsingItem()) {
            if (player.getMainArm() == HumanoidArm.LEFT) {
                event.getModel().rightArm.xRot = event.getModel().rightArm.xRot * 0.5f - (float)Math.PI;
                event.getModel().rightArm.yRot = 0.0f;
            } else {
                event.getModel().leftArm.xRot = event.getModel().leftArm.xRot * 0.5f - (float)Math.PI;
                event.getModel().leftArm.yRot = 0.0f;
            }
        }
        if (player.getItemInHand(InteractionHand.OFF_HAND).is((Item)ModItems.THE_IMMOLATOR.get()) && player.getItemInHand(InteractionHand.MAIN_HAND).is((Item)ModItems.THE_IMMOLATOR.get()) && player.isUsingItem()) {
            if (player.getMainArm() == HumanoidArm.LEFT) {
                event.getModel().rightArm.xRot = event.getModel().rightArm.xRot * 0.5f - (float)Math.PI;
                event.getModel().rightArm.yRot = 0.0f;
            } else {
                event.getModel().leftArm.xRot = event.getModel().leftArm.xRot * 0.5f - (float)Math.PI;
                event.getModel().leftArm.yRot = 0.0f;
            }
        }
    }

    public static void onRenderArm(RenderArmEvent event) {
        InteractionHand hand = event.getArm() == event.getPlayer().getMainArm() ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        CuriosApi.getCuriosHelper().getCuriosHandler((LivingEntity)event.getPlayer()).ifPresent(handler -> {
            ICurioStacksHandler stacksHandler = (ICurioStacksHandler)handler.getCurios().get(SlotTypePreset.HANDS.getIdentifier());
            if (stacksHandler != null) {
                int slot;
                IDynamicStackHandler stacks = stacksHandler.getStacks();
                IDynamicStackHandler cosmeticStacks = stacksHandler.getCosmeticStacks();
                int n = slot = hand == InteractionHand.MAIN_HAND ? 0 : 1;
                while (slot < stacks.getSlots()) {
                    Chitin_Claw_Renderer clawrenderer;
                    Sticky_Gloves_Renderer stickyrenderer;
                    Blazing_Grips_Renderer gripsrenderer;
                    ItemStack stack = cosmeticStacks.getStackInSlot(slot);
                    if (stack.isEmpty() && ((Boolean)stacksHandler.getRenders().get(slot)).booleanValue()) {
                        stack = stacks.getStackInSlot(slot);
                    }
                    if ((gripsrenderer = Blazing_Grips_Renderer.getGloveRenderer(stack)) != null) {
                        gripsrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
                    }
                    if ((stickyrenderer = Sticky_Gloves_Renderer.getGloveRenderer(stack)) != null) {
                        stickyrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
                    }
                    if ((clawrenderer = Chitin_Claw_Renderer.getGloveRenderer(stack)) != null) {
                        clawrenderer.renderFirstPersonArm(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPlayer(), event.getArm(), stack.hasFoil());
                    }
                    slot += 2;
                }
            }
        });
    }

    private void CustomHealth(RenderGuiLayerEvent.Pre event, int back) {
        boolean highlight;
        LocalPlayer player = Minecraft.getInstance().player;
        Minecraft mc = Minecraft.getInstance();
        Gui gui = mc.gui;
        GuiGraphics stack = event.getGuiGraphics();
        ClientEvent.setupOverlayRenderState(true, false);
        int width = stack.guiWidth();
        int height = stack.guiHeight();
        event.setCanceled(true);
        RenderSystem.setShaderTexture((int)0, (Identifier)EFFECT_HEART);
        RenderSystem.enableBlend();
        int health = Mth.ceil((float)player.getHealth());
        int tickCount = gui.getGuiTicks();
        boolean bl = highlight = this.healthBlinkTime > (long)tickCount && (this.healthBlinkTime - (long)tickCount) / 3L % 2L == 1L;
        if (health < this.lastHealth && player.invulnerableTime > 0) {
            this.lastHealthTime = Util.getMillis();
            this.healthBlinkTime = tickCount + 20;
        } else if (health > this.lastHealth && player.invulnerableTime > 0) {
            this.lastHealthTime = Util.getMillis();
            this.healthBlinkTime = tickCount + 10;
        }
        if (Util.getMillis() - this.lastHealthTime > 1000L) {
            this.lastHealth = health;
            this.displayHealth = health;
            this.lastHealthTime = Util.getMillis();
        }
        this.lastHealth = health;
        int healthLast = this.displayHealth;
        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = (float)maxHealth.getValue();
        int absorbtion = Mth.ceil((float)player.getAbsorptionAmount());
        int healthRows = Mth.ceil((float)((healthMax + (float)absorbtion) / 2.0f / 10.0f));
        int rowHeight = Math.max(10 - (healthRows - 2), 3);
        this.random.setSeed((long)tickCount * 312871L);
        int left = width / 2 - 91;
        int top = height - this.leftHeight;
        this.leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            this.leftHeight += 10 - rowHeight;
        }
        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION)) {
            regen = tickCount % Mth.ceil((float)(healthMax + 5.0f));
        }
        int TOP = player.level().getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? back : 16;
        int margin = 34;
        float absorbtionRemaining = absorbtion;
        for (int i = Mth.ceil((float)((healthMax + (float)absorbtion) / 2.0f)) - 1; i >= 0; --i) {
            int row = Mth.ceil((float)((float)(i + 1) / 10.0f)) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += this.random.nextInt(2);
            }
            if (i == regen) {
                y -= 2;
            }
            stack.blit(EFFECT_HEART, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    stack.blit(EFFECT_HEART, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    stack.blit(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
                }
            }
            if (absorbtionRemaining > 0.0f) {
                if (absorbtionRemaining == (float)absorbtion && (float)absorbtion % 2.0f == 1.0f) {
                    stack.blit(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
                    absorbtionRemaining -= 1.0f;
                    continue;
                }
                stack.blit(EFFECT_HEART, x, y, margin, TOP, 9, 9);
                absorbtionRemaining -= 2.0f;
                continue;
            }
            if (i * 2 + 1 < health) {
                stack.blit(EFFECT_HEART, x, y, margin, TOP, 9, 9);
                continue;
            }
            if (i * 2 + 1 != health) continue;
            stack.blit(EFFECT_HEART, x, y, margin + 9, TOP, 9, 9);
        }
        RenderSystem.disableBlend();
        RenderSystem.setShaderTexture((int)0, (Identifier)EFFECT_HEART);
    }

    public static void setupOverlayRenderState(boolean blend, boolean depthTest) {
        if (blend) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
        } else {
            RenderSystem.disableBlend();
        }
        if (depthTest) {
            RenderSystem.enableDepthTest();
        } else {
            RenderSystem.disableDepthTest();
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
    }

    private static void renderBossOverlay(CustomizeGuiOverlayEvent.BossEventProgress event) {
        ClientProxy.BossBarData data;
        if (CMClientConfig.customBossBars && (data = ClientProxy.bossBarRenderTypes.get(event.getBossEvent().getId())) != null) {
            CustomBossBar customBossBar = CustomBossBar.customBossBars.getOrDefault(data.renderType(), null);
            if (customBossBar == null) {
                return;
            }
            event.setCanceled(true);
            customBossBar.renderBossBar(event, data.remainLife());
        }
    }
}

