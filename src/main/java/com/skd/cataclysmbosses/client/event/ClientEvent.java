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
import java.lang.reflect.Method;
import net.minecraft.util.Util;
// import net.minecraft.util.Util;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
// import net.minecraft.client.renderer.entity.ItemRenderer;
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
// import top.theillusivec4.curios.api.SlotTypePreset;
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
        Entity cameraEntity = event.getCamera().entity();
        float partialTick = event.getCamera().getCameraEntityPartialTicks(Minecraft.getInstance().getDeltaTracker());
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Maledictus_Entity && event.getCamera().isDetached()) {
            event.setDistance(6.0f);
        }
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Aptrgangr_Entity && event.getCamera().isDetached()) {
            event.setDistance(3.0f);
        }
        if (cameraEntity != null && cameraEntity.isPassenger() && cameraEntity.getVehicle() instanceof Clawdian_Entity && event.getCamera().isDetached()) {
            event.setDistance(6.0f);
        }
        if (false && CameraZoomManager.isActive() && event.getCamera().isDetached()) {
            float zoom = CameraZoomManager.getZoomOffset(partialTick);
            float floorzoom = getMaxZoom(event.getCamera(), zoom);
            if (floorzoom < zoom) {
                floorzoom = Math.max(0.0f, floorzoom - 0.2f);
            }
            float dy = 0.0f;
            float ny = zoom - floorzoom;
            if (ny > 0.0f) {
                dy = Math.min(ny * 0.5f, 1.5f);
            }
            moveCamera(event.getCamera(), -floorzoom, dy, 0.0f);
        }
    }

    public static boolean isKeyDown0(KeyMapping keybind) {
        if (keybind.isUnbound()) {
            return false;
        }
        return switch (keybind.getKey().getType()) {
            case InputConstants.Type.KEYSYM -> InputConstants.isKeyDown(Minecraft.getInstance().getWindow(), keybind.getKey().getValue());
            case InputConstants.Type.MOUSE -> {
                if (GLFW.glfwGetMouseButton((long)Minecraft.getInstance().getWindow().handle(), (int)keybind.getKey().getValue()) == 1) {
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
            // PORT TODO(26.2): ClientInput.moveVector is protected now; the "curse of desert"
            // control-reversal needs a MovementInputUpdateEvent accessor or a mixin.
        }
    }

    public static void onPreRenderHUD(RenderGuiLayerEvent.Pre event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            Minecraft mc = Minecraft.getInstance();
            if (player.isPassenger()) {
                if ((player.getVehicle() instanceof The_Leviathan_Tongue_Entity || player.getVehicle() instanceof IHoldEntity) && VanillaGuiLayers.VEHICLE_HEALTH == event.getName()) {
                    // PORT TODO(26.2): Gui.setOverlayMessage removed; re-route "you_cant_escape" action-bar message.
                }
                if (player.getVehicle() instanceof Accretion_Entity && VanillaGuiLayers.VEHICLE_HEALTH == event.getName()) {
                    // PORT TODO(26.2): Gui.setOverlayMessage removed; re-route "accretion_ride" action-bar message.
                }
            }
        }
    }

    public static void onPostRenderHUD(RenderGuiLayerEvent.Post event) {
        // PORT TODO(26.2): body was already empty; mc.options.hideGui field removed.
    }

    private static boolean shouldDrawSurvivalElements() {
        Minecraft mc = Minecraft.getInstance();
        return mc.gameMode.canHurtPlayer() && mc.getCameraEntity() instanceof Player;
    }

    public static void onPreRenderEntity(RenderLivingEvent.Pre event) {
        // PORT TODO(26.2): RenderLivingEvent.Pre lost getEntity()/getMultiBufferSource()/
        // getPackedLight(); this drew the incinerator/immolator flame-sigil quad and suppressed
        // "blocked" entity renders. Re-implement against the new event + SubmitNodeCollector.
    }

    public static void onPreRenderPlayer(RenderPlayerEvent.Pre event) {
    }

    public static void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float)p_229039_4_, (float)p_229039_5_, (float)p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float)p_229039_9_, (float)p_229039_11_, (float)p_229039_10_);
    }

    public static void clientTick(ClientTickEvent.Post event) {
        if (Minecraft.getInstance().hasSingleplayerServer() && Minecraft.getInstance().isPaused()) {
            return;
        }
        CMItemstackRenderer.incrementTick();
        CameraZoomManager.tick();
    }

    private static void updateAllChunks() {
        // PORT(26.2): viewArea/ViewArea.sections are private; use the public rebuild-everything hook.
        Minecraft.getInstance().levelExtractor.allChanged();
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
        // PORT TODO(26.2): first-person glove-accessory rendering. Used CuriosApi.getCuriosHelper()
        // + SlotTypePreset.HANDS (both replaced in regalia_slots_api: CuriosApi.getCuriosInventory,
        // CuriosSlotTypes.Preset.HANDS) and RenderArmEvent.getMultiBufferSource/getPackedLight/
        // getPlayer (removed). Re-wire with the regalia API + SubmitNodeCollector.
    }

    private void CustomHealth(RenderGuiLayerEvent.Pre event, int back) {
        // PORT TODO(26.2): custom heart-bar HUD. Not registered on any bus. Rebuild against
        // GuiGraphicsExtractor + RenderPipelines blit; RenderSystem.setShaderTexture/enableBlend
        // and Gui.getGuiTicks are gone.
    }

    public static void setupOverlayRenderState(boolean blend, boolean depthTest) {
        // PORT(26.2): RenderSystem enable/disableBlend/DepthTest, setShaderColor, setShader and
        // GameRenderer::getPositionTexShader are gone; GUI blit state is pipeline-managed now.
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

    // Helper methods for Camera reflection
    private static float getMaxZoom(Camera camera, float cameraDist) {
        try {
            Method method = Camera.class.getDeclaredMethod("getMaxZoom", float.class);
            method.setAccessible(true);
            return (float) method.invoke(camera, cameraDist);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    private static void moveCamera(Camera camera, float forwards, float up, float right) {
        try {
            Method method = Camera.class.getDeclaredMethod("move", float.class, float.class, float.class);
            method.setAccessible(true);
            method.invoke(camera, forwards, up, right);
        } catch (Exception e) {
            // Ignore
        }
    }
}
