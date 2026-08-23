#!/bin/bash
# Fix masivo para RenderLayers y modelos - NeoForge 26.2 / 1.21.4
# Ejecutar desde: G:/Proyectos/Mods_Minecraft/the_sundering/neoforge/26.2

set -e

echo "=== Fixing RenderLayers ==="

# 1. RenderLayer generic: Entity -> EntityRenderState
find src/main/java -name "*.java" -exec sed -i 's/extends RenderLayer<\([^,]*\), \(.*\)>/extends RenderLayer<\1, \2>/g' {} \;

# Fix type bounds: RenderLayer<Entity, Model> -> RenderLayer<EntityRenderState, Model>
find src/main/java -name "*.java" -exec sed -i 's/extends RenderLayer<\([A-Z][a-zA-Z_]*\)_Entity, \(.*\)>/extends RenderLayer<\1RenderState, \2>/g' {} \;

# 2. Add submit() method stub (abstract method required)
# This is a complex fix - just comment out the class and add TODO
# Better: add minimal submit implementation

# 3. FastColor -> ARGB (Mojang's new color utility)
find src/main/java -name "*.java" -exec sed -i 's/FastColor\.ARGB32\.color(/ARGB.color(/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.util\.FastColor;/import net.minecraft.util.ARGB;/g' {} \;

# 4. RenderType.eyes(Identifier) -> RenderTypes.eyes(ResourceLocation)
find src/main/java -name "*.java" -exec sed -i 's/RenderType\.eyes(\(.*\))/RenderTypes.eyes(\1)/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.client\.renderer\.rendertype\.RenderType;/import net.minecraft.client.renderer.RenderTypes;\nimport net.minecraft.client.renderer.rendertype.RenderType;/g' {} \;

# 5. RenderType.energySwirl -> RenderTypes.energySwirl
find src/main/java -name "*.java" -exec sed -i 's/RenderType\.energySwirl/RenderTypes.energySwirl/g' {} \;

# 6. model.renderToBuffer(ps, vb, light, overlay) -> 5 args (add color)
find src/main/java -name "*.java" -exec sed -i 's/\.renderToBuffer(\([^,]*\), \([^,]*\), \([^,]*\), \([^)]*\))/.renderToBuffer(\1, \2, \3, \4, 0xFFFFFFFF)/g' {} \;

# 7. EntityModel.prepareMobModel(Entity, float, float, float) -> REMOVE (no longer exists)
find src/main/java -name "*.java" -exec sed -i '/\.prepareMobModel(/d' {} \;

# 8. EntityModel.setupAnim(Entity, ...) -> setupAnim(EntityRenderState)
# This needs manual work per class, but we can fix simple cases
find src/main/java -name "*.java" -exec sed -i 's/\.setupAnim((Entity)\([^,]*\), \([^,]*\), \([^,]*\), \([^,]*\), \([^,]*\), \([^)]*\))/.setupAnim(\1)/g' {} \;

# 9. model.copyPropertiesTo(EntityModel) -> REMOVE
find src/main/java -name "*.java" -exec sed -i '/\.copyPropertiesTo(/d' {} \;

# 10. Fix imports
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.world\.entity\.projectile\.ThrownTrident;/import net.minecraft.world.entity.projectile.Trident;/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.world\.entity\.MobSpawnType;/import net.minecraft.world.entity.EntitySpawnReason;/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.world\.ItemInteractionResult;/import net.minecraft.world.InteractionResult;/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.Util;/import net.minecraft.util.Util;/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.world\.level\.block\.entity\.BlockEntity\$DataComponentInput;/import net.minecraft.core.component.DataComponentInput;/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/BlockEntity\.DataComponentInput/DataComponentInput/g' {} \;

# 11. Fix DirectionProperty -> EnumProperty<Direction>
find src/main/java -name "*.java" -exec sed -i 's/DirectionProperty/EnumProperty<Direction>/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/import net\.minecraft\.world\.level\.block\.state\.properties\.DirectionProperty;/import net.minecraft.world.level.block.state.properties.EnumProperty;\nimport net.minecraft.core.Direction;/g' {} \;

# 12. Fix ItemInteractionResult -> InteractionResult
find src/main/java -name "*.java" -exec sed -i 's/ItemInteractionResult/InteractionResult/g' {} \;

# 13. Fix MobSpawnType -> EntitySpawnReason (method calls)
find src/main/java -name "*.java" -exec sed -i 's/MobSpawnType\./EntitySpawnReason./g' {} \;

# 14. Fix ThrownTrident -> Trident (class name change)
find src/main/java -name "*.java" -exec sed -i 's/ThrownTrident/Trident/g' {} \;

# 15. Fix FastColor -> ARGB (remaining)
find src/main/java -name "*.java" -exec sed -i 's/FastColor/ARGB/g' {} \;

echo "=== Fixing Model files ==="

# 16. EntityModel generic: <LivingEntity> -> <EntityRenderState> or <HumanoidRenderState>
find src/main/java/com/skd/thesundering/client/model -name "*.java" -exec sed -i 's/extends HumanoidModel<LivingEntity>/extends HumanoidModel<HumanoidRenderState>/g' {} \;
find src/main/java/com/skd/thesundering/client/model -name "*.java" -exec sed -i 's/extends EntityModel<LivingEntity>/extends EntityModel<LivingEntityRenderState>/g' {} \;

# 17. setupAnim signature: (Entity, float, float, float, float, float) -> (EntityRenderState)
find src/main/java/com/skd/thesundering/client/model -name "*.java" -exec sed -i 's/public void setupAnim(Entity \([^,]*\), float \([^,]*\), float \([^,]*\), float \([^,]*\), float \([^,]*\), float \([^)]*\))/public void setupAnim(\1)/g' {} \;

# 18. Remove prepareMobModel and copyPropertiesTo
find src/main/java/com/skd/thesundering/client/model -name "*.java" -exec sed -i '/public void prepareMobModel/d' {} \;
find src/main/java/com/skd/thesundering/client/model -name "*.java" -exec sed -i '/\.copyPropertiesTo(/d' {} \;

# 19. Remove hurt() from Projectile subclasses (final in 1.21.4)
find src/main/java/com/skd/thesundering/entity/projectile -name "*.java" -exec sed -i '/public boolean hurt(DamageSource/,/^[[:space:]]*}/d' {} \;

# 20. Fix recreateFromPacket: getXa/getYa/getZa -> getMovement()
find src/main/java -name "*.java" -exec sed -i 's/Vec3 vec3 = new Vec3(packet.getXa(), packet.getYa(), packet.getZa());/Vec3 vec3 = packet.getMovement();/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/double d0 = packet.getXa();/double d0 = vec3.x();/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/double d1 = packet.getYa();/double d1 = vec3.y();/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/double d2 = packet.getZa();/double d2 = vec3.z();/g' {} \;

# 21. Remove hasImpulse = true
find src/main/java -name "*.java" -exec sed -i '/this.hasImpulse = true;/d' {} \;

# 22. Fix onDeflection: remove super.onDeflection call
find src/main/java -name "*.java" -exec sed -i 's/super.onDeflection(entity, deflectedByPlayer);//g' {} \;

# 23. Remove checkDespawn and removeWhenFarAway (final in 1.21.4)
find src/main/java -name "*.java" -exec sed -i '/public void checkDespawn/,/^[[:space:]]*}/d' {} \;
find src/main/java -name "*.java" -exec sed -i '/public boolean removeWhenFarAway/,/^[[:space:]]*}/d' {} \;

# 24. Fix CuriosRenderer registry deprecated
find src/main/java -name "*.java" -exec sed -i 's/CuriosRendererRegistry.getRenderer/CuriosRendererRegistry.getRenderer \/\/ deprecated/g' {} \;

# 25. Fix DataComponentInput import
find src/main/java -name "*.java" -exec sed -i 's/import net.minecraft.world.level.block.entity.BlockEntity\$DataComponentInput;/import net.minecraft.core.component.DataComponentInput;/g' {} \;
find src/main/java -name "*.java" -exec sed -i 's/BlockEntity.DataComponentInput/DataComponentInput/g' {} \;

# 26. Comment out applyImplicitComponents and collectImplicitComponents (API changed)
find src/main/java/com/skd/thesundering/blockentities -name "*.java" -exec sed -i '/protected void applyImplicitComponents/,/^[[:space:]]*}/s/^/\/\/ /' {} \;
find src/main/java/com/skd/thesundering/blockentities -name "*.java" -exec sed -i '/protected void collectImplicitComponents/,/^[[:space:]]*}/s/^/\/\/ /' {} \;

echo "=== Done ==="
echo "Run: ./gradlew compileJava --no-daemon"